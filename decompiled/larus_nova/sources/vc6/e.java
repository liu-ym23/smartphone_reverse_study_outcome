package vc6;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes19.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f554121a = null;

    static {
        f554121a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        jy0.b.c("RedPacketPlugin", "sendDialog error: " + ((Throwable) r100).getMessage(), null, 4);
    }
}
