package uu5;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements FlowableOnSubscribe<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f551757a;

    public e(h r100) {
        this.f551757a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.FlowableOnSubscribe
    public final void subscribe(FlowableEmitter<Object> r100) throws Exception {
        this.f551757a.f551759a = r100;
    }
}
