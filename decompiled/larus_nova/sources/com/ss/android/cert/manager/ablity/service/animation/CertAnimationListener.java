package com.ss.android.cert.manager.ablity.service.animation;

/* JADX INFO: loaded from: classes34.dex */
public interface CertAnimationListener {
    public static final CertAnimationListener EMPTY = null;

    void onAnimationCancel();

    void onAnimationEnd();

    void onAnimationPause();

    void onAnimationRepeat();

    void onAnimationResume();

    void onAnimationStart();

    static {
        EMPTY = new AnonymousClass1();
    }
}
