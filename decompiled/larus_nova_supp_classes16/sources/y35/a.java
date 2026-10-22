package y35;

import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.doc.syncblock.SyncBlockViewModel;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.domain.BearUrl;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import k25.e0;
import k25.m0;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {

    /* JADX INFO: renamed from: y35.a$a, reason: collision with other inner class name */
    public static final class C0325a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ NetService c;

        public b(a r1, String r2, NetService r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r7) {
            BearUrl r8 = (BearUrl) r7;
            Intrinsics.checkNotNullParameter(r8, "url");
            if (j.a.a.getNetworkState().a() == true) goto L26;
            tt5.a.h("SyncBlockResolver", "netweork is not connected");
            a r0 = this.a;
            String r2 = this.b;
            r0.getClass();
            String r1 = r8.b;
            boolean r3 = true;
            if (r1 != null) goto L7;
        L10:
            boolean r4 = true;
        L12:
            if (r4 == false) goto L14;
            tt5.a.k("SyncBlockResolver", "token is empty");
            return Flowable.just("");
        L14:
            m0 r9 = e0.m().A(r2, r8.b, 0);
            if (r9 == null) goto L17;
            String r10 = r9.c;
        L18:
            if (r10 != null) goto L20;
        L23:
            if (r3 == true) goto L25;
            tt5.a.h("SyncBlockResolver", "get source token from cache");
            Flowable r11 = Flowable.just(r10);
            Intrinsics.checkNotNull(r11);
            return r11;
        L25:
            tt5.a.h("SyncBlockResolver", "get source token from cache, but cache is null");
            Flowable r12 = Flowable.just("");
            Intrinsics.checkNotNull(r12);
            return r12;
        L20:
            if (r10.length() == 0) goto L23;
            r3 = false;
            goto L23
        L17:
            r10 = null;
            goto L18
        L7:
            if (r1.length() == 0) goto L10;
            r4 = false;
            goto L12
        L26:
            tt5.a.h("SyncBlockResolver", "fetch source token from network");
            a r5 = this.a;
            NetService r6 = this.c;
            String r13 = this.b;
            r5.getClass();
            NetService.f r14 = new NetService.f(SyncBlockViewModel.API);
            r14.b("token", r8.b);
            r14.b("obj_type", String.valueOf(e.y.b));
            r14.c = 2;
            return r6.Vc(new ax4.a()).a(r14).map(y35.b.a).map(new d(r8, r13));
        }
    }

    static {
    }

    public a() {
    }

    public final Flowable<String> a(h0 r3, NetService r4, BearUrl r5) {
        Intrinsics.checkNotNullParameter(r3, "localAccountService");
        Intrinsics.checkNotNullParameter(r4, "netService");
        Intrinsics.checkNotNullParameter(r5, "bearUrl");
        tt5.a.h("SyncBlockResolver", "fetchSourceToken");
        AccountService$Account r6 = r3.G2();
        return Flowable.just(r5).observeOn(fo5.d.c()).flatMap(new b(this, r6.tenantId + '_' + r6.uid + "_sync_to_source", r4)).observeOn(fo5.d.d()).timeout(DocOpenConfig.d(), TimeUnit.MILLISECONDS);
    }
}
