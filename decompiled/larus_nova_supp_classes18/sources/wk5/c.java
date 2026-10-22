package wk5;

import com.bytedance.ee.bear.onboarding.e;
import io.reactivex.FlowableEmitter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements e.b {
    public final /* synthetic */ FlowableEmitter a;

    @Override // com.bytedance.ee.bear.onboarding.e.b
    public final void onInit() {
        e.l.remove(this);
        if (this.a.isCancelled() == true) goto L6;
        this.a.onNext(d.a.a);
        this.a.onComplete();
        return;
    }

    public c(FlowableEmitter r1) {
        this.a = r1;
    }
}
