package com.bytedance.ee.bear.contract;

import android.webkit.WebView;
import com.bytedance.ee.bear.browser.WebFragment;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface m {

    public interface a {
        void onRequestExport();
    }

    public interface b {
    }

    public interface c {
        void onRequestSnapshot(String r1, String r2);

        void onRequestSnapshot(String r1, String r2, b r3);
    }

    void a(WebFragment r1);

    Flowable b();

    Flowable<Boolean> c(boolean r1);

    Flowable d(WebView r1);

    void e(m0 r1);

    void f(WebFragment r1);

    void g(a r1);

    void h(String r1, String r2, b r3);

    void i();

    Flowable<Boolean> j(WebView r1, boolean r2);

    void k(c r1);

    void l(a r1);

    void m(String r1);

    void n(c r1);
}
