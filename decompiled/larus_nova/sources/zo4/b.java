package zo4;

import com.bytedance.ee.bear.bitable.card.BitableRecordSetting;
import com.bytedance.ee.bear.bitable.common.BTJson;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableRecordSetting f573107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KVRepo f573108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Calendar f573109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Calendar f573110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Long> f573111e;

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f573112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Calendar f573113b;

        public a(b r100, Calendar r101) {
            this.f573112a = r100;
            this.f573113b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            b r102 = this.f573112a;
            Calendar r103 = this.f573113b;
            ArrayList r104 = new ArrayList();
            Iterator<T> r105 = r101.iterator();
        L4:
            if (r105.hasNext() == false) goto L8;
            T r106 = r105.next();
            long r107 = ((Number) r106).longValue();
            r102.f573110d.setTimeInMillis(r107);
            if (r102.f573110d.after(r103) == false) goto L4;
            r104.add(r106);
            goto L4
        L8:
            return r104;
        }
    }

    /* JADX INFO: renamed from: zo4.b$b, reason: collision with other inner class name */
    public static final class C8482b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f573114a;

        public C8482b(b r100) {
            this.f573114a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            ((ArrayList) this.f573114a.f573111e).clear();
            List<Long> r102 = this.f573114a.f573111e;
            Intrinsics.checkNotNull(r101);
            ArrayList r103 = (ArrayList) r102;
            r103.addAll(r101);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f573115a = null;

        static {
            f573115a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.e("RecordSwitchPagerActionTrace", "get times error ", (Throwable) r100, false);
        }
    }

    public static final class d {
    }

    static {
    }

    public final boolean a() {
        tt5.a.h("RecordSwitchPagerActionTrace", "saveTimes : " + ((ArrayList) this.f573111e).size());
        if (((ArrayList) this.f573111e).size() <= this.f573107a.f().a()) goto L5;
        return true;
    L5:
        return false;
    }

    public b(BitableRecordSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "recordSetting");
        this.f573107a = r100;
        KVRepo r101 = com.bytedance.ee.bear.bitable.core.usercomponent.b.a().xd();
        this.f573108b = r101;
        Calendar r102 = Calendar.getInstance();
        this.f573109c = r102;
        this.f573110d = Calendar.getInstance();
        this.f573111e = new ArrayList();
        r102.setTimeInMillis(System.currentTimeMillis());
        r102.add(5, -r100.f().c());
        Object r103 = null;
        String r104 = r101.getString("BASE_RECORD_SWITCH_PAGER_TIME", null);
        if (r104 == null) goto L11;
        BTJson r105 = BTJson.f209798c;
        Type r106 = new zo4.c().getType();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r104, "valueJson");
        Intrinsics.checkNotNullParameter(r106, "type");
        r103 = r105.f209799a.fromJson(r104, r106);     // Catch: Exception -> L7
    L9:
        List r107 = (List) r103;
        if (r107 == null) goto L11;
    L12:
        Observable.just(r107).subscribeOn(fo5.d.c()).map(new a(this, r102)).subscribe(new C8482b(this), c.f573115a);
        return;
    L7:
        e = move-exception;
        tt5.a.e("BTJson", "json parse error : ", e, false);
    L11:
        r107 = CollectionsKt.emptyList();
        goto L12
    }
}
