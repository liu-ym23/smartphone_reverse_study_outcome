package oq0;

import android.content.Context;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPrefHelper f524839a;

    /* JADX INFO: renamed from: oq0.a$a, reason: collision with other inner class name */
    public static final class C7089a {
    }

    static {
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f524839a = SharedPrefHelper.c(r100, "openplatform_audience_high_intention_sp");
    }

    public final b a(String r100) {
        b r101 = (b) GsonHelper.get().fromJson(this.f524839a.j(r100, ""), b.class);     // Catch: Exception -> L7
        if (r101 != null) goto L11;
        return new b(null);
    L11:
        return r101;
    L8:
        return new b(null);
    }

    public final c b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "recordKey");
        Intrinsics.checkNotNullParameter(r101, "recordId");
        return a(r100).a().get(r101);
    }

    public final void c(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "recordKey");
        Intrinsics.checkNotNullParameter(r102, "recordId");
        c r103 = b(r100, r102);
        if (r103 == null) goto L5;
        long r104 = r103.a();
    L6:
        d(r100, r102, r101 + r104);
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public final void d(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "recordKey");
        Intrinsics.checkNotNullParameter(r101, "recordId");
        b r103 = a(r100);
        c r104 = r103.a().get(r101);
        if (r104 != null) goto L5;
        r104 = new c(0);
    L5:
        r104.c(r102);
        r104.d(System.currentTimeMillis());
        r103.a().put(r101, r104);
        String r105 = GsonHelper.get().toJson(r103);     // Catch: Exception -> L8
    L9:
        this.f524839a.m(r100, r105);
        return;
    L8:
        r105 = "";
        goto L9
    }
}
