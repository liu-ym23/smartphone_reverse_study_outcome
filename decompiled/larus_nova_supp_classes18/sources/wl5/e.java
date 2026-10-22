package wl5;

import io.reactivex.FlowableEmitter;
import onb.j;
import vl5.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements j<i> {
    public final /* synthetic */ FlowableEmitter a;
    public final /* synthetic */ String b;
    public final /* synthetic */ f c;

    public final void a(onb.b r3) {
        i r4 = (i) r3;
        if (this.c.a == false) goto L6;
        tt5.a.b("JSModelService-Docs", "sendDocRequest - onSuccess, message:\n" + this.b + "\nresponse:\n" + r4.a);
    L6:
        if (this.a.isCancelled() == true) goto L10;
        this.a.onNext(r4.a);
        return;
    }

    public final void onError(String r3, String r4) {
        tt5.a.h("JSModelService-Docs", "sendDocRequest()... commands-> + onError  ->code: " + r3 + " message: " + r4);
        if (this.a.isCancelled() == false) goto L5;
        return;
    L5:
        this.a.onNext("{ \"errorMsg\": \"rn timeout\"}");
    }

    public e(f r1, FlowableEmitter r2, String r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
