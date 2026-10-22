package im2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.e f490473a;

    public f(lmc.a.f r100) {
        this.f490473a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.ss.ugc.live.sdk.msg.network.e r101 = this.f490473a;
        r101.a((com.ss.ugc.live.sdk.msg.utils.g) r100);
    }
}
