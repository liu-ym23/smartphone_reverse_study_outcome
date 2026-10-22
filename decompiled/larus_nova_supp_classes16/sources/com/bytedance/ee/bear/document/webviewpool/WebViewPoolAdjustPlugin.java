package com.bytedance.ee.bear.document.webviewpool;

import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.util.ui.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.Chameleon;
import com.ss.android.lark.utils.LarkContext;
import q45.d;
import q45.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WebViewPoolAdjustPlugin extends DocumentPluginV3 {
    private static final String TAG = "WebViewPoolAdjustPlugin";
    private final Runnable addIdleRunnable;
    private final MessageQueue.IdleHandler preloadWebviewIdleHandler;
    private final Runnable preloadWebviewRunnable;
    private final x2.c renderCallback;

    public class a extends x2.c {
        public final /* synthetic */ WebViewPoolAdjustPlugin a;

        @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            WebViewPoolAdjustPlugin.access$000(this.a);
            WebViewPoolAdjustPlugin.access$100(this.a);
        }

        public a(WebViewPoolAdjustPlugin r1) {
            this.a = r1;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ WebViewPoolAdjustPlugin a;

        @Override // java.lang.Runnable
        public final void run() {
            Chameleon.c(Chameleon.a, this.a.getChameleonConfig());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(WebViewPoolAdjustPlugin r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ void a(WebViewPoolAdjustPlugin r0) {
        r0.lambda$new$1();
    }

    public static /* synthetic */ boolean c(WebViewPoolAdjustPlugin r0) {
        return r0.lambda$new$0();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void cancelPreloadWebviewTask() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Looper.getMainLooper().getQueue().removeIdleHandler(this.preloadWebviewIdleHandler);
    L6:
        j.e(this.addIdleRunnable);
        return;
    L5:
        j.e(this.preloadWebviewRunnable);
        goto L6
    }

    private void doPreloadWebviewTask() {
        tt5.a.h(TAG, "doPreloadWebviewTask()...");
        etb.b r0 = (etb.b) LarkContext.spiByDwarf(etb.b.class);
        if (r0 == null) goto L5;
        boolean r1 = ((PreloadNextWebGapABTest) r0.r("use_new_webView_pool_config", PreloadNextWebGapABTest.class, new PreloadNextWebGapABTest())).getUseNewWebViewPoolConfig();
    L6:
        WebViewPoolConfig r2 = ((WebViewPoolConfig) c.a.a.c(WebViewPoolConfig.KEY, WebViewPoolConfig.class, new WebViewPoolConfig(1, 2, 5, 3))).changeToOfficeWebViewPoolConfig();
        if (r1 == false) goto L13;
        if (r2.preloadNextWebView == true) goto L13;
        tt5.a.h(TAG, "doPreloadWebviewTask() preloadNextWebView is false");
        return;
    L13:
        if (Build.VERSION.SDK_INT < 23) goto L18;
        int r3 = r2.preloadNextGapTime;
        if (r3 <= 0) goto L17;
        j.d(this.addIdleRunnable, r3);
        return;
    L17:
        Looper.getMainLooper().getQueue().addIdleHandler(this.preloadWebviewIdleHandler);
        return;
    L18:
        j.d(this.preloadWebviewRunnable, 1000);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private boolean lambda$new$0() {
        Chameleon.c(Chameleon.a, getChameleonConfig());
        return false;
    }

    private /* synthetic */ void lambda$new$1() {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Looper.getMainLooper().getQueue().addIdleHandler(this.preloadWebviewIdleHandler);
        return;
    }

    public WebViewPoolAdjustPlugin() {
        this.renderCallback = new a(this);
        this.preloadWebviewIdleHandler = new d(this);
        this.addIdleRunnable = new e(this);
        this.preloadWebviewRunnable = new b(this);
    }

    public static /* synthetic */ void access$000(WebViewPoolAdjustPlugin r0) {
        r0.cancelPreloadWebviewTask();
    }

    public static /* synthetic */ void access$100(WebViewPoolAdjustPlugin r0) {
        r0.doPreloadWebviewTask();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r3) {
        tt5.a.h(TAG, "onAttachToHost()...");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        getDocumentLoader().S3(this.renderCallback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromHost(ChameleonPluginHost r3) {
        tt5.a.h(TAG, "onDetachFromHost()...");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromHost(r3);
        getDocumentLoader().S(this.renderCallback);
        cancelPreloadWebviewTask();
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((ChameleonPluginHost) r1);
    }
}
