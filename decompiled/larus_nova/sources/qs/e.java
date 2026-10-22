package qs;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f534639a = null;

    static {
        f534639a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        yr.c.b("AnchorFloatBallTask", "fetchAnchorFloatBallData error: " + ((Throwable) r100).getMessage());
    }
}
