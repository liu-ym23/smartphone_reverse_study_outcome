package ue0;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f549788a;

    public f(d r100) {
        this.f549788a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        d r101 = this.f549788a;
        r101.f549786h.printALogger("LivePreviewMultiLinkOnlineUserListHandler", r101.hashCode(), ((Throwable) r100).toString(), true);
    }
}
