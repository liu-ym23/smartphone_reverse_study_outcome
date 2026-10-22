package com.ss.android.cert.manager.ablity.service.animation;

/* JADX INFO: loaded from: classes34.dex */
public interface CertAnimationErrorListener {
    public static final CertAnimationErrorListener EMPTY = null;

    void onError(Throwable r100);

    static {
        EMPTY = new AnonymousClass1();
    }
}
