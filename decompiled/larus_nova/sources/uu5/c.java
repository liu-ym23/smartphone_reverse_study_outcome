package uu5;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements FlowableOnSubscribe<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f551754a;

    public c(d r100) {
        this.f551754a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.FlowableOnSubscribe
    public final void subscribe(FlowableEmitter<Object> r100) throws Exception {
        this.f551754a.f551755a = r100;
    }
}
