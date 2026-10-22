package gn0;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f481799a = null;

    static {
        f481799a = new e();
    }

    public e() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        jy0.b.c("MultiControlService", "WebcastLinkMicMethod subscribe error " + ((Throwable) r100), null, 4);
    }
}
