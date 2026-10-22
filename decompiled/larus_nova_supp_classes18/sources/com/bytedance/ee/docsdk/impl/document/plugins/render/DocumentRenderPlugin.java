package com.bytedance.ee.docsdk.impl.document.plugins.render;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.docsdk.impl.document.service.ContainerThemeWebService;
import com.bytedance.ee.docsdk.impl.document.service.NotifyReadyService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chameleon.api.AbsChameleonPlugin;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.OpenConfig;
import com.ss.android.lark.chameleon.api.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.pluginsystem.Web;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginsystem.plugin.UIContainer;
import com.ss.android.lark.chameleon.util.MainLooper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u0004¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/render/DocumentRenderPlugin;", "Lcom/ss/android/lark/chameleon/api/AbsChameleonPlugin;", "()V", "onAttachToUIContainer", "", "host", "Lcom/ss/android/lark/chameleon/api/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/ss/android/lark/chameleon/pluginsystem/plugin/UIContainer;", "onDetachFromUIContainer", "onStart", "parseRendUri", "", ResourceData.KEY_URL, "render", "Companion", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DocumentRenderPlugin extends AbsChameleonPlugin {
    public static final Companion Companion = null;
    public static final String TAG = "DocumentRenderPlugin";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/document/plugins/render/DocumentRenderPlugin$Companion;", "", "()V", "TAG", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(String r0) {
        render$lambda$4$lambda$3(r0);
    }

    public static /* synthetic */ void b(DocumentRenderPlugin r0, String r1) {
        render$lambda$4(r0, r1);
    }

    public static /* synthetic */ void c(String r0) {
        onDetachFromUIContainer$lambda$2$lambda$1(r0);
    }

    public static /* synthetic */ void d(ChameleonPluginHost r0) {
        onDetachFromUIContainer$lambda$2(r0);
    }

    public final void render() {
        Log.i("[DocTracer]", "Begin render");
        Log.i(TAG, "Begin render");
        String r1 = getHost().getChameleonConfig().getLoadUrl();
        if (TextUtils.isEmpty(r1) == false) goto L6;
        Log.e(TAG, "Abort render, url is empty");
        return;
    L6:
        JSONObject r2 = new JSONObject();
        r2.put("userId", Env.getUserId());
        String r4 = "1";
        r2.put("tenantId", "1");
        r2.put("departmentId", "0");
        boolean r6 = true;
        r2.put("isPreloadFinished", 1);
        if (Env.isDarkMode() == false) goto L9;
        String r3 = ContainerThemeWebService.THEME_CONFIG_VALUE_DARK;
    L10:
        r2.put(ContainerThemeWebService.THEME_CONFIG_KEY, r3);
        r2.put("x", 0);
        r2.put("y", 0);
        JSONObject r5 = new JSONObject();
        ChameleonConfig r8 = getHost().getChameleonConfig();
        if (r8 == null) goto L15;
        OpenConfig r9 = r8.getOpenConfig();
        if (r9 == null) goto L15;
        long r10 = r9.getOpenTimestamp();
    L16:
        r5.put("tap", r10);
        r5.put("invokeRender", System.currentTimeMillis());
        r5.put("preloadStart", System.currentTimeMillis());
        r5.put("webviewLoadUrl", System.currentTimeMillis());
        r2.put("timestamp", r5);
        r2.put("prefetchData", "");
        r2.put("title", "");
        r2.put("nativeWebviewId", System.currentTimeMillis());
        r2.put("isDebug", false);
        r2.put("preFetchClientvarEnable", false);
        r2.put("srcHost", "");
        r2.put("shouldRenderCacheHtml", false);
        r2.put("renderSSRWebviewType", 0);
        r2.put("clientvars", "");
        OpenConfig r11 = getHost().getChameleonConfig().getOpenConfig();
        if (r11 != null) goto L19;
    L21:
        r6 = false;
    L22:
        if (r6 == false) goto L24;
        r4 = "0";
    L24:
        r2.put("isColdLaunch", r4);
        JSONObject r7 = new JSONObject();
        if (r1 != null) goto L27;
        String r12 = "";
    L28:
        r7.put(ResourceData.KEY_URL, parseRendUri(r12));
        r7.put("infos", r2);
        StringBuilder r13 = new StringBuilder("url=");
        if (r1 != null) goto L31;
        String r14 = "";
    L32:
        r13.append(parseRendUri(r14));
        Log.i(TAG, r13.toString());
        Log.i(TAG, "infos=" + r2);
        r7.put("docsApiPrefix", "https://internal-api-space.larkoffice.com/space");
        r7.put("frontierDomain", new String[]{"ccm-frontier.larkoffice.com", "ccm-frontier.larkoffice.com"});
        r7.put("unit", "");
        r7.put("brand", "");
        r7.put("srcHost", UriProtector.parse(r1).getHost());
        r7.put("srcUrl", r1);
        final String r15 = "javascript:render(" + r7 + ')';
        Log.i(TAG, "script=" + r15);
        new Handler(Looper.getMainLooper()).post(new d(this, r15));
        return;
    L31:
        r14 = r1;
        goto L32
    L27:
        r12 = r1;
        goto L28
    L19:
        if (r11.isColdLaunch() == true) goto L21;
    L15:
        r10 = System.currentTimeMillis();
        goto L16
    L9:
        r3 = ContainerThemeWebService.THEME_CONFIG_VALUE_LIGHT;
        goto L10
    }

    public DocumentRenderPlugin() {
    }

    private static final void onDetachFromUIContainer$lambda$2(ChameleonPluginHost r2) {
        if (r2 == null) goto L9;
        Web r3 = r2.getWeb();
        if (r3 == null) goto L10;
        WebView r4 = r3.getWebView();
        if (r4 == null) goto L11;
        r4.evaluateJavascript("javascript:clear()", new a());
        return;
    L11:
        return;
    L10:
        return;
    }

    private static final void onDetachFromUIContainer$lambda$2$lambda$1(String r2) {
        Log.i(TAG, "***reportOpenDoc*** ValueCallback value: " + r2);
    }

    private static final void render$lambda$4$lambda$3(String r2) {
        Log.i(TAG, "***reportOpenDoc*** ValueCallback value: " + r2);
        Log.i("[DocTracer]", "After render");
    }

    public /* bridge */ /* synthetic */ void onStart(PluginHost r1) {
        onStart((ChameleonPluginHost) r1);
    }

    public final String parseRendUri(String r9) {
        Intrinsics.checkNotNullParameter(r9, ResourceData.KEY_URL);
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return "";
    L5:
        String r3 = UriProtector.parse(r9).getPath();
        if (TextUtils.isEmpty(r3) == true) goto L15;
        Intrinsics.checkNotNull(r3);
        int r0 = StringsKt.indexOf$default(r9, r3, 0, false, 6, null);
        if (r0 != (-1)) goto L10;
    L14:
        return "";
    L10:
        if (r0 > r9.length()) goto L14;
        return r9.substring(r0);
    L15:
        return null;
    }

    public void onStart(ChameleonPluginHost r1) {
        super/*com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin*/.onStart(r1);
    }

    private static final void render$lambda$4(DocumentRenderPlugin r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$script");
        r1.getHost().getWeb().getWebView().evaluateJavascript(r2, new b());
    }

    public void onAttachToUIContainer(ChameleonPluginHost r3, UIContainer r4) {
        super/*com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin*/.onAttachToUIContainer(r3, r4);
        Boolean r5 = null;
        if (r3 == null) goto L5;
        final NotifyReadyService r6 = (NotifyReadyService) r3.getWebService(NotifyReadyService.class);
    L6:
        StringBuilder r0 = new StringBuilder("isWebReady=");
        if (r6 == null) goto L9;
        r5 = Boolean.valueOf(r6.isReady());
    L9:
        r0.append(r5);
        Log.i(TAG, r0.toString());
        if (r6 != null) goto L12;
        return;
    L12:
        if (r6.isReady() == false) goto L14;
        render();
        return;
    L14:
        Log.i(TAG, "Web is not ready, register listener");
        r6.registerWebReadyListener(new DocumentRenderPlugin$onAttachToUIContainer$1$1(this, r6));
        return;
    L5:
        r6 = null;
        goto L6
    }

    public void onDetachFromUIContainer(final ChameleonPluginHost r1, UIContainer r2) {
        super/*com.ss.android.lark.chameleon.pluginsystem.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        MainLooper.runOnMainThread(new c(r1));
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, UIContainer r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, UIContainer r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
