package xi5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public NetService.f<SimpleRequestResult> a;

    public class a implements Consumer<SimpleRequestResult> {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void accept(Object r3) throws Exception {
            tt5.a.b("SetPrivacyExecutor", "GetPrivacyExecutor doAction accept  result=" + ((SimpleRequestResult) r3));
            c r4 = this.a;
            if (r4 == null) goto L6;
            r4.a();
            return;
        }
    }

    public class b implements Consumer<Throwable> {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void accept(Object r4) throws Exception {
            Throwable r5 = (Throwable) r4;
            tt5.a.e("SetPrivacyExecutor", " doAction failed", r5, false);
            c r0 = this.a;
            if (r0 == null) goto L6;
            r0.onError(r5);
            return;
        }
    }

    public interface c {
        void a();

        void onError(Throwable r1) throws Exception;
    }

    public i() {
    }

    public final Disposable a(boolean r4, c r5, String r6) {
        NetService.f<SimpleRequestResult> r0 = new NetService.f("/space/api/user_properties/set/");
        this.a = r0;
        ((NetService.e) r0).c = 1;
        if (r4 == false) goto L5;
        String r7 = "true";
    L6:
        ((NetService.e) this.a).j = "{\"permission_type\":1,\"properties\":{" + ("\"" + r6 + "\"") + ":" + r7 + "}}";
        return ((NetService) org.koin.java.a.a(NetService.class)).Vc(new ax4.f()).a(this.a).subscribe(new a(r5), new b(r5));
    L5:
        r7 = "false";
        goto L6
    }
}
