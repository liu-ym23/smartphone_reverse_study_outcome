package uu5;

import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

/* JADX INFO: loaded from: classes19.dex */
public final class l implements FlowableOnSubscribe<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f551763a;

    public l(m r100) {
        this.f551763a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.FlowableOnSubscribe
    public final void subscribe(FlowableEmitter<Object> r100) throws Exception {
        this.f551763a.f551764a = r100;
    }
}
