package qs;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f534637a = null;

    static {
        f534637a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        yr.c.b("AnchorFloatBallTask", String.valueOf(((Throwable) r100).getMessage()));
    }
}
