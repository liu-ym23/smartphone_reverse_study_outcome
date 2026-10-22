package com.bytedance.ee.bear.contract;

import android.webkit.WebView;
import com.bytedance.ee.bear.browser.WebFragment;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes16.dex */
public interface m {

    public interface a {
        void onRequestExport();
    }

    public interface b {
    }

    public interface c {
        void onRequestSnapshot(String r100, String r101);

        void onRequestSnapshot(String r100, String r101, b r102);
    }

    void a(WebFragment r100);

    Flowable b();

    Flowable<Boolean> c(boolean r100);

    Flowable d(WebView r100);

    void e(m0 r100);

    void f(WebFragment r100);

    void g(a r100);

    void h(String r100, String r101, b r102);

    void i();

    Flowable<Boolean> j(WebView r100, boolean r101);

    void k(c r100);

    void l(a r100);

    void m(String r100);

    void n(c r100);
}
