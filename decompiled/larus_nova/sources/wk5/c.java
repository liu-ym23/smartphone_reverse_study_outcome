package wk5;

import com.bytedance.ee.bear.onboarding.e;
import io.reactivex.FlowableEmitter;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements e.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowableEmitter f560114a;

    @Override // com.bytedance.ee.bear.onboarding.e.b
    public final void onInit() {
        e.f236145l.remove(this);
        if (this.f560114a.isCancelled() == true) goto L6;
        this.f560114a.onNext(d.a.f560115a);
        this.f560114a.onComplete();
        return;
    }

    public c(FlowableEmitter r100) {
        this.f560114a = r100;
    }
}
