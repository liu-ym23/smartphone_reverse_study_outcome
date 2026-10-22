package pd;

import android.view.View;

/* JADX INFO: loaded from: classes43.dex */
public interface h {
    void b();

    void onFirstScreen(View r100);

    void onLoadFailed(View r100, String r101);

    void onLoadSuccess(View r100);

    void onPageStart(View r100, String r101);

    void onReceivedError(View r100, String r101);

    void onRuntimeReady(View r100);
}
