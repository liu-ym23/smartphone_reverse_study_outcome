package wl5;

import io.reactivex.FlowableEmitter;
import onb.j;
import vl5.i;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements j<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowableEmitter f560198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f560199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f560200c;

    @Override // onb.j
    public final void a(onb.b r100) {
        i r101 = (i) r100;
        if (this.f560200c.f560201a == false) goto L6;
        tt5.a.b("JSModelService-Docs", "sendDocRequest - onSuccess, message:\n" + this.f560199b + "\nresponse:\n" + r101.f555679a);
    L6:
        if (this.f560198a.isCancelled() == true) goto L10;
        this.f560198a.onNext(r101.f555679a);
        return;
    }

    @Override // onb.j
    public final void onError(String r100, String r101) {
        tt5.a.h("JSModelService-Docs", "sendDocRequest()... commands-> + onError  ->code: " + r100 + " message: " + r101);
        if (this.f560198a.isCancelled() == false) goto L5;
        return;
    L5:
        this.f560198a.onNext("{ \"errorMsg\": \"rn timeout\"}");
    }

    public e(f r100, FlowableEmitter r101, String r102) {
        this.f560200c = r100;
        this.f560198a = r101;
        this.f560199b = r102;
    }
}
