package com.dtf.face.ui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.dtf.face.config.IConstValues;
import com.dtf.face.log.RecordService;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.ttm.player.MediaPlayer;
import hs7.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public class ToygerWebView extends WebView {
    private Handler mHandler;

    public static class DTFJSBridge {
        @JavascriptInterface
        public String getStyleOptions() {
            return String.valueOf(a.h().f487012x);
        }

        public DTFJSBridge() {
        }
    }

    public class ToygerWebChromeClient extends WebChromeClient {
        public final /* synthetic */ ToygerWebView this$0;

        public ToygerWebChromeClient(ToygerWebView r100) {
            this.this$0 = r100;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView r100, int r101) {
            if (ToygerWebView.access$000(this.this$0) == null) goto L5;
            Message r102 = ToygerWebView.access$000(this.this$0).obtainMessage(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER);
            r102.arg1 = r101;
            ToygerWebView.access$000(this.this$0).sendMessage(r102);
        L5:
            super.onProgressChanged(r100, r101);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView r100, String r101) {
            super.onReceivedTitle(r100, r101);
            if (ToygerWebView.access$000(this.this$0) == null) goto L13;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.contains("404") == false) goto L8;
        L11:
            Message r102 = ToygerWebView.access$000(this.this$0).obtainMessage(908);
            r102.obj = r101;
            ToygerWebView.access$000(this.this$0).sendMessage(r102);
            return;
        L8:
            if (r101.contains("500") == true) goto L11;
            if (r101.contains("502") == true) goto L11;
            return;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView r110, String r111, String r112, String r113, JsPromptResult r114) {
            if (ToygerWebView.access$000(this.this$0) == null) goto L45;
            if (r112 == null) goto L45;
            Uri r100 = UriProtector.parse(r112);
            Uri r101 = UriProtector.parse(r111);
            if (r101 != null) goto L9;
        L17:
            if (r100 != null) goto L19;
        L21:
            String r102 = r112;
        L23:
            if (r102.equalsIgnoreCase("face_auth_elderly") == false) goto L27;
            super.onJsPrompt(r110, r111, r112, r113, r114);
            r114.cancel();
            ToygerWebView.access$000(this.this$0).sendMessage(ToygerWebView.access$000(this.this$0).obtainMessage(915));
            return true;
        L27:
            if (r102.equalsIgnoreCase("face_auth") == false) goto L31;
            super.onJsPrompt(r110, r111, r112, r113, r114);
            r114.cancel();
            ToygerWebView.access$000(this.this$0).sendMessage(ToygerWebView.access$000(this.this$0).obtainMessage(LynxErrorCode.LYNX_ERROR_CODE_MODULE_BUSINESS_ERROR));
            return true;
        L31:
            if (r102.equalsIgnoreCase("navi_close") == false) goto L35;
            super.onJsPrompt(r110, r111, r112, r113, r114);
            r114.cancel();
            ToygerWebView.access$000(this.this$0).sendMessage(ToygerWebView.access$000(this.this$0).obtainMessage(906));
            return true;
        L35:
            if (r102.equalsIgnoreCase("guide_log") == false) goto L39;
            super.onJsPrompt(r110, r111, r112, r113, r114);
            r114.cancel();
            Message r103 = ToygerWebView.access$000(this.this$0).obtainMessage(907);
            r103.obj = r113;
            ToygerWebView.access$000(this.this$0).sendMessage(r103);
            return true;
        L39:
            if (r102.equalsIgnoreCase("get_ocr_info") == false) goto L43;
            super.onJsPrompt(r110, r111, r112, r113, r114);
            r114.cancel();
            Message r104 = ToygerWebView.access$000(this.this$0).obtainMessage(918);
            ToygerWebView.access$000(this.this$0).sendMessage(r104);
            return true;
        L43:
            return super.onJsPrompt(r110, r111, r112, r113, r114);
        L19:
            if (TextUtils.isEmpty(r100.getPath()) == true) goto L21;
            r102 = r100.getPath();
            goto L23
        L9:
            if ("YES".equals(UriProtector.getQueryParameter(r101, IConstValues.RARECHARACTER)) == false) goto L17;
            if (r112.contains("face_auth") == false) goto L17;
            if (r100 == null) goto L17;
            String r105 = UriProtector.getQueryParameter(r100, "name");
            String r106 = UriProtector.getQueryParameter(r100, "idNumber");
            String r107 = UriProtector.getQueryParameter(r100, "rareLoadStatus");
            RecordService r108 = RecordService.getInstance();
            String[] r115 = new String[2];
            r115[0] = "rareLoadStatus";
            if (r107 != null) goto L16;
            r107 = "null";
        L16:
            r115[1] = r107;
            r108.recordEvent(2, "rare", r115);
            a.h().B = r105;
            a.h().C = r106;
        L45:
            return super.onJsPrompt(r110, r111, r112, r113, r114);
        }
    }

    public class ToygerWebViewClient extends WebViewClient {
        public final /* synthetic */ ToygerWebView this$0;
        private Map<String, Long> urlsLoadCost;

        public ToygerWebViewClient(ToygerWebView r100) {
            this.this$0 = r100;
            this.urlsLoadCost = new HashMap();
        }

        public void markUrlStart(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L6;
            return;
        L6:
            if (this.urlsLoadCost.containsKey(r100) == true) goto L9;
            this.urlsLoadCost.put(r100, Long.valueOf(System.currentTimeMillis()));
            return;
        }

        public void markUrlEnd(String r110, boolean r111) {
            if (TextUtils.isEmpty(r110) == false) goto L6;
            return;
        L6:
            if (this.urlsLoadCost.containsKey(r110) == false) goto L19;
            long r100 = this.urlsLoadCost.get(r110).longValue();
            long r101 = 0;
            if (r100 <= 0) goto L20;
            RecordService r102 = RecordService.getInstance();
            String[] r103 = new String[6];
            r103[0] = "url";
            r103[1] = r110;
            r103[2] = ChameleonOpenTracker.ParamKey.COST;
            r103[3] = String.valueOf(System.currentTimeMillis() - r100);
            r103[4] = "status";
            if (r111 == false) goto L12;
            String r104 = "true";
        L13:
            r103[5] = r104;
            r102.recordEvent(2, "webViewLoad", r103);
            Map<String, Long> r105 = this.urlsLoadCost;
            if (r111 == true) goto L17;
            r101 = -1;
        L17:
            r105.put(r110, Long.valueOf(r101));
            return;
        L12:
            r104 = "false";
            goto L13
        L20:
            return;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r100, String r101) {
            super.onPageFinished(r100, r101);
            if (ToygerWebView.access$000(this.this$0) == null) goto L5;
            Message r102 = ToygerWebView.access$000(this.this$0).obtainMessage(919);
            ToygerWebView.access$000(this.this$0).sendMessage(r102);
        L5:
            markUrlEnd(r101, true);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r100, String r101, Bitmap r102) {
            super.onPageStarted(r100, r101, r102);
            if (ToygerWebView.access$000(this.this$0) == null) goto L5;
            Message r103 = ToygerWebView.access$000(this.this$0).obtainMessage(920);
            r103.obj = r101;
            ToygerWebView.access$000(this.this$0).sendMessage(r103);
        L5:
            markUrlStart(r101);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
            super.onReceivedError(r100, r101, r102);
            if (ToygerWebView.access$000(this.this$0) == null) goto L13;
            Message r103 = ToygerWebView.access$000(this.this$0).obtainMessage(908);
            if (r102 != null) goto L15;
        L12:
            ToygerWebView.access$000(this.this$0).sendMessage(r103);
            goto L13
        L15:
        L10:
            th = move-exception;
            RecordService.getInstance().recordException(th);
            goto L12
        L7:
            if (Build.VERSION.SDK_INT < 23) goto L12;
            r103.obj = r102.getErrorCode() + r102.getDescription().toString();     // Catch: Throwable -> L10
        L13:
            markUrlEnd(r100.getUrl(), false);
        }
    }

    public void init() {
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        WebSettings r100 = getSettings();
        r100.setJavaScriptEnabled(true);
        r100.setCacheMode(-1);
        r100.setDomStorageEnabled(true);
        r100.setDatabaseEnabled(true);
        r100.setAllowFileAccess(false);
        r100.setSavePassword(false);
        r100.setSupportZoom(false);
        r100.setBuiltInZoomControls(false);
        setWebChromeClient(new ToygerWebChromeClient(this));
        setWebViewClient(new ToygerWebViewClient(this));
        addJavascriptInterface(new DTFJSBridge(), "AndroidInterface");
    }

    public static /* synthetic */ Handler access$000(ToygerWebView r100) {
        return r100.mHandler;
    }

    private static Context getFixedContext(Context r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        Context r101 = r100.createConfigurationContext(new Configuration());
        NewMiraResourcesManager.getInstance().install(r101);
        return r101;
    L6:
        return r100;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String r100) {
        super.loadUrl(r100);
        String r101 = getSettings().getUserAgentString();     // Catch: Throwable -> L5
    L7:
        RecordService r102 = RecordService.getInstance();
        String[] r103 = new String[4];
        r103[0] = "url";
        r103[1] = r100;
        r103[2] = BaseHttpRequestInfo.KEY_USER_AGENT;
        if (TextUtils.isEmpty(r101) == false) goto L10;
        r101 = "NULL";
    L10:
        r103[3] = r101;
        r102.recordEvent(2, "webViewInfo", r103);
        return;
    L5:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        r101 = "";
        goto L7
    }

    public void setHandler(Handler r100) {
        this.mHandler = r100;
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof ToygerWebChromeClient) == false) goto L8;
        super.setWebChromeClient(r100);
        return;
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof ToygerWebViewClient) == false) goto L8;
        super.setWebViewClient(r100);
        return;
    }

    public ToygerWebView(Context r100, AttributeSet r101) {
        super(getFixedContext(r100), r101);
        init();
    }
}
