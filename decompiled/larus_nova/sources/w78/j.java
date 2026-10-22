package w78;

import android.os.Handler;
import androidx.lifecycle.Observer;
import com.larus.network.http.HttpLiveData;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f558584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f558585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HttpLiveData<T> f558586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f558587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f558588e;

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f558589a;

        public a(g r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f558589a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f558589a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f558589a.invoke(r100);
        }
    }

    public final void b() {
        FLogger.f375446a.i("UserDynamic", "scheduleCheck " + CollectionsKt.joinToString$default(this.f558584a, null, null, null, 0, null, new h(), 31, null) + ' ' + this.f558585b);
        Handler r100 = t0.f375468a;
        r100.removeCallbacks(this.f558588e);
        r100.postDelayed(this.f558588e, this.f558585b);
    }

    public final void a(boolean r100) {
        if (r100 == false) goto L4;
    L7:
        JSONObject r101 = new JSONObject();
        JSONArray r102 = new JSONArray();
        Iterator<T> r103 = this.f558584a.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        r102.put((String) r103.next());
        goto L9
    L11:
        Unit r104 = Unit.INSTANCE;
        r101.put("key_list", r102);
        HttpLiveData.c(this.f558586c, ServiceType.BASIC_TEC, "/alice/user/dynamic", r101, false, null, 248);
        return;
    L4:
        if (this.f558587d < 0) goto L7;
        if ((System.currentTimeMillis() - this.f558587d) >= this.f558585b) goto L7;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [w78.g] */
    public j(Class r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "keyList");
        this.f558584a = r101;
        this.f558585b = 21600000;
        HttpLiveData<T> r102 = new HttpLiveData(r100);
        this.f558586c = r102;
        this.f558587d = -1;
        this.f558588e = new i(this);
        r102.f360128c.observeForever(new a(new g(this)));
    }
}
