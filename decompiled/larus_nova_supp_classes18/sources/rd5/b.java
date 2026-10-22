package rd5;

import ax4.f;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements rd5.a {

    public static final class a {
    }

    /* JADX INFO: renamed from: rd5.b$b, reason: collision with other inner class name */
    public static final class C0299b<T> implements Consumer {
        public static final C0299b<T> a = null;

        static {
            a = new C0299b();
        }

        public C0299b() {
        }

        public final void accept(Object r2) {
            SimpleRequestResult r3 = (SimpleRequestResult) r2;
            tt5.a.h("RecentReporter", "reportRecentClick success");
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            tt5.a.l("RecentReporter", "reportRecentClick error", (Throwable) r3);
        }
    }

    static {
    }

    public b() {
    }

    @Override // rd5.a
    public final void a(String r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "objToken");
        tt5.a.h("RecentReporter", "reportRecentClick, objToken: " + du5.b.k(r6) + ", type: " + r7);
        Flowable r2 = null;
        NetService r1 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        Intrinsics.checkNotNullParameter(r6, "objToken");
        NetService.f r0 = new NetService.f("/space/api/explorer/recent/report/");
        ((NetService.e) r0).c = 1;
        ((HashMap) ((NetService.e) r0).d).put(ResourceData.KEY_OBJ_TOKEN, r6);
        ((HashMap) ((NetService.e) r0).d).put("obj_type", String.valueOf(r7));
        if (r1 == null) goto L7;
        NetService.d r8 = r1.Vc(new f());
        if (r8 == null) goto L7;
        r2 = r8.a(r0);
    L7:
        if (r2 == null) goto L10;
        r2.subscribe(C0299b.a, c.a);
        return;
    }
}
