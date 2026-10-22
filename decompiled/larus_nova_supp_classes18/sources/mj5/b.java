package mj5;

import ax4.f;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a {

        /* JADX INFO: renamed from: mj5.b$a$a, reason: collision with other inner class name */
        public static final class C0267a<T, R> implements Function {
            public static final C0267a<T, R> a = null;

            static {
                a = new C0267a();
            }

            public C0267a() {
            }

            public final Object apply(Object r2) {
                Intrinsics.checkNotNullParameter((SimpleRequestResult) r2, "it");
                return Boolean.TRUE;
            }
        }

        @JvmStatic
        public static Flowable a(String r3, int r4, int r5, long r6) {
            Intrinsics.checkNotNullParameter(r3, "objToken");
            NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
            NetService.f r1 = new NetService.f("space/api/platform/fresh_status/update");
            ((NetService.e) r1).c = 1;
            r1.b(ResourceData.KEY_OBJ_TOKEN, r3);
            r1.b("obj_type", String.valueOf(r4));
            r1.b("fresh_status", String.valueOf(r5));
            if (r6 == (-1)) goto L6;
            r1.b("deadline_time", String.valueOf(r6 / ((long) CCMLynxCardView.ViewType.BANNER)));
        L6:
            return r0.Vc(new f()).a(r1).map(C0267a.a);
        }
    }

    static {
    }
}
