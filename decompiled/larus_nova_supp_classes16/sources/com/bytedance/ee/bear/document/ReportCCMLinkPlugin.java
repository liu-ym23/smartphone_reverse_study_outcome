package com.bytedance.ee.bear.document;

import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.AnalyticConstant$LinkLocation;
import com.bytedance.ee.bear.contract.AnalyticConstant$LinkScene;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ReportCCMLinkPlugin extends DocumentPlugin {
    private WebViewClient mWebViewClient;

    public class a extends WebViewClient {
        public final /* synthetic */ ReportCCMLinkPlugin a;

        public a(ReportCCMLinkPlugin r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r8, String r9) {
            DocViewModel r0 = this.a.getDocViewModel();
            com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
            if (r0.isAnnounceDoc() == false) goto L6;
            String r2 = AnalyticConstant$LinkScene.MESSENGER.getScene();
            String r3 = AnalyticConstant$LinkLocation.MESSENGER_GROUP_ANNOUNCEMENT.getLocation();
        L24:
            int r4 = av5.b.a;
            Intrinsics.checkNotNullParameter(r2, "scene");
            Intrinsics.checkNotNullParameter(r3, "location");
            HashMap r5 = new HashMap();
            if (TextUtils.isEmpty(r2) == false) goto L27;
        L30:
            tt5.a.h("RouteReport", "empty scene or location");
        L32:
            if (r5.isEmpty() == true) goto L43;
            JSONObject r6 = new JSONObject();
            Iterator r7 = r5.entrySet().iterator();
        L35:
            if (r7.hasNext() == false) goto L41;
            Map.Entry r10 = (Map.Entry) r7.next();
            r6.put((String) r10.getKey(), r10.getValue());     // Catch: JSONException -> L39
        L39:
            e = move-exception;
            e.printStackTrace();
            goto L35
        L41:
            r1.i("link_clicked", r6);
        L43:
            return super.shouldOverrideUrlLoading(r8, r9);
        L27:
            if (TextUtils.isEmpty(r3) == true) goto L30;
            r5.put("scene", r2);
            r5.put("location", r3);
            goto L32
        L6:
            if (r0.isType(sbb.e.n) == false) goto L9;
            r2 = AnalyticConstant$LinkScene.CCM.getScene();
            r3 = AnalyticConstant$LinkLocation.CCM_WIKI.getLocation();
            goto L24
        L9:
            if (r0.isOpenFromLarkFeed() == false) goto L12;
            r2 = AnalyticConstant$LinkScene.MESSENGER.getScene();
            r3 = AnalyticConstant$LinkLocation.MESSENGER_LARK_FEED.getLocation();
            goto L24
        L12:
            if (r0.isConferenceRecords() == false) goto L15;
            r2 = AnalyticConstant$LinkScene.CCM.getScene();
            r3 = AnalyticConstant$LinkLocation.OPENDOC_CONFERENCE_RECORDS.getLocation();
            goto L24
        L15:
            if (TextUtils.equals(r0.getDocumentType(), sbb.e.h.getType()) == false) goto L18;
            r2 = AnalyticConstant$LinkScene.CCM.getScene();
            r3 = AnalyticConstant$LinkLocation.CCM_SHEET.getLocation();
            goto L24
        L18:
            if (TextUtils.equals(r0.getDocumentType(), sbb.e.m.getType()) == false) goto L21;
            r2 = AnalyticConstant$LinkScene.CCM.getScene();
            r3 = AnalyticConstant$LinkLocation.CCM_SLIDE.getLocation();
            goto L24
        L21:
            if (TextUtils.equals(r0.getDocumentType(), sbb.e.k.getType()) == false) goto L23;
            r2 = AnalyticConstant$LinkScene.CCM.getScene();
            r3 = AnalyticConstant$LinkLocation.CCM_MINDNOTE.getLocation();
            goto L24
        L23:
            r2 = AnalyticConstant$LinkScene.CCM.getScene();
            r3 = AnalyticConstant$LinkLocation.CCM_DOCS.getLocation();
            goto L24
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView r1, WebResourceRequest r2) {
            return shouldOverrideUrlLoading(r1, r2.getUrl().toString());
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public ReportCCMLinkPlugin() {
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        super.onAttachToHost(r2);
        if (this.mWebViewClient != null) goto L5;
        this.mWebViewClient = new a(this);
    L5:
        getWeb().addWebViewClientDelegate(this.mWebViewClient);
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        super.onDetachFromHost(r2);
        if (this.mWebViewClient == null) goto L6;
        getWeb().removeWebViewClientDelegate(this.mWebViewClient);
        this.mWebViewClient = null;
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }
}
