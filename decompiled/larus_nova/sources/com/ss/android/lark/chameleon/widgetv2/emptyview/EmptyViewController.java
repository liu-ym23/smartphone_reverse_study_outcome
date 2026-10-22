package com.ss.android.lark.chameleon.widgetv2.emptyview;

/* JADX INFO: loaded from: classes35.dex */
public interface EmptyViewController {
    void hide();

    void show();

    void showCustomError(int r100, CharSequence r101);

    void showLoadError(Throwable r100);

    void showLoading();

    void showNoContent();

    void showNoFound();

    void showNoNetworkError();

    void showNoPermission();

    void showNoSupport();

    void showTimeout();

    void showWikiDeleted();
}
