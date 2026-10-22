package com.huawei.secure.android.common.webview;

import android.webkit.WebView;
import com.huawei.secure.android.common.util.b;
import com.huawei.secure.android.common.util.c;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CountDownLatch;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class SafeGetUrl {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f278244c = "SafeGetUrl";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f278245d = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f278246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WebView f278247b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f278248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SafeGetUrl f278249b;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_secure_android_common_webview_SafeGetUrl$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_secure_android_common_webview_SafeGetUrl$a__run$___twin___() {
            SafeGetUrl r100 = this.f278249b;
            r100.setUrl(SafeGetUrl.a(r100).getUrl());
            this.f278248a.countDown();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_secure_android_common_webview_SafeGetUrl$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_huawei_secure_android_common_webview_SafeGetUrl$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(SafeGetUrl r100, CountDownLatch r101) {
            this.f278249b = r100;
            this.f278248a = r101;
        }
    }

    public String getUrlMethod() {
        if (this.f278247b != null) goto L7;
        return "";
    L7:
        if (b.a() == true) goto L9;
        CountDownLatch r100 = new CountDownLatch(1);
        c.a(new a(this, r100));
        r100.await();     // Catch: InterruptedException -> L13
    L16:
        return this.f278246a;
    L13:
        e = move-exception;
        e.getMessage();
        goto L16
    L9:
        return this.f278247b.getUrl();
    }

    public SafeGetUrl() {
    }

    public WebView getWebView() {
        return this.f278247b;
    }

    public SafeGetUrl(WebView r100) {
        this.f278247b = r100;
    }

    public static /* synthetic */ WebView a(SafeGetUrl r100) {
        return r100.f278247b;
    }

    public void setUrl(String r100) {
        this.f278246a = r100;
    }

    public void setWebView(WebView r100) {
        this.f278247b = r100;
    }
}
