package com.bytedance.ee.bear.drive.biz.preview.navigation;

import android.net.Uri;
import android.util.Base64;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;
import com.bytedance.ee.bear.drive.view.preview.wps.WpsViewModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import i75.h;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0011H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/preview/navigation/DriveWpsNavigationPlugin;", "Lcom/bytedance/ee/bear/drive/core/AbsDrivePlugin;", "<init>", "()V", "webView", "Landroid/webkit/WebView;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/drive/core/DrivePluginHost;", "navigationToWordLocation", "page", "", "navigationToPPTLocation", "navigationToSheetLocation", "tabIndex", "range", "", "evaluateJavaScript", "javaScriptCode", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveWpsNavigationPlugin extends AbsDrivePlugin {
    public static final a Companion = null;
    private static final String TAG = "DriveWpsNavigationPlugin";
    private WebView webView;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements ValueCallback {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r3) {
            tt5.a.h(DriveWpsNavigationPlugin.TAG, "evaluateJavaScript: result:" + ((String) r3) + ' ');
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ DrivePluginHost a;
        public final /* synthetic */ DriveWpsNavigationPlugin b;

        public c(DrivePluginHost r1, DriveWpsNavigationPlugin r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r9) {
            Boolean r10 = (Boolean) r9;
            tt5.a.h(DriveWpsNavigationPlugin.TAG, "successLiveData " + r10);
        L50:
            e = move-exception;
            tt5.a.d(DriveWpsNavigationPlugin.TAG, " error:" + e.getMessage());
            return;
        L4:
            if (r10.booleanValue() == false) goto L56;
            BaseOpenEntity r11 = this.a.c.getOpenEntity();     // Catch: Exception -> L50
            if ((r11 instanceof SpaceFileOpenEntity) == false) goto L8;
            SpaceFileOpenEntity r12 = (SpaceFileOpenEntity) r11;     // Catch: Exception -> L50
        L9:
            if (r12 == null) goto L57;
            String r13 = r12.getOriginUrl();     // Catch: Exception -> L50
            if (r13 == null) goto L58;
            DrivePluginHost r1 = this.a;     // Catch: Exception -> L50
            DriveWpsNavigationPlugin r3 = this.b;     // Catch: Exception -> L50
            Uri r14 = UriProtector.parse(r13);     // Catch: Exception -> L50
            if (r14 == null) goto L59;
            String r16 = r14.getFragment();     // Catch: Exception -> L50
            if (r16 == null) goto L60;
            Map<String, String> r17 = h.o(r16);     // Catch: Exception -> L50
            String r2 = r1.c.getFileName();     // Catch: Exception -> L50
            String r4 = "";
            if (r2 != null) goto L20;
            r2 = "";
        L20:
            String r5 = com.bytedance.ee.util.io.a.c(r2);     // Catch: Exception -> L50
            DriveWpsNavigationPlugin.access$setWebView$p(r3, (WebView) r3.findViewById(2131370258));     // Catch: Exception -> L50
            HashMap r18 = (HashMap) r17;     // Catch: Exception -> L50
            String r6 = (String) r18.get("page_number");     // Catch: Exception -> L50
            if (r6 == null) goto L23;
            int r7 = CastIntegerProtector.parseInt(r6);     // Catch: Exception -> L50
        L24:
            if (r7 == (-1)) goto L61;
            int r8 = r7 + 1;     // Catch: Exception -> L50
            if (h.g(r5) == false) goto L28;
        L48:
            DriveWpsNavigationPlugin.access$navigationToWordLocation(r3, r8);     // Catch: Exception -> L50
            return;
        L28:
            if ("wps".equalsIgnoreCase(r5) == true) goto L48;
            if (h.j(r5) == false) goto L34;
            DriveWpsNavigationPlugin.access$navigationToPPTLocation(r3, r8);     // Catch: Exception -> L50
            return;
        L34:
            if (h.h(r5) == true) goto L53;
            if (h.f(r5) == true) goto L53;
            if ("et".equalsIgnoreCase(r5) == true) goto L53;
            return;
        L53:
            String r19 = (String) r18.get("range");     // Catch: IllegalArgumentException -> L45 Exception -> L50
            if (r19 != null) goto L43;
            r19 = "";
        L43:
            Charset r20 = Charsets.UTF_8;     // Catch: IllegalArgumentException -> L45 Exception -> L50
            r4 = new String(Base64.decode(r19.getBytes(r20), 0), r20);     // Catch: IllegalArgumentException -> L45 Exception -> L50
        L47:
            DriveWpsNavigationPlugin.access$navigationToSheetLocation(r3, r8, r4);     // Catch: Exception -> L50
            return;
        L45:
            e = move-exception;
            tt5.a.e(DriveWpsNavigationPlugin.TAG, "decode Base64 error: " + e.getMessage(), e, false);     // Catch: Exception -> L50
            goto L47
        L61:
            return;
        L23:
            r7 = -1;
            goto L24
        L60:
            return;
        L59:
            return;
        L58:
            return;
        L57:
            return;
        L8:
            r12 = null;
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DriveWpsNavigationPlugin() {
    }

    private final void evaluateJavaScript(String r3) {
        WebView r0 = this.webView;
        if (r0 == null) goto L6;
        r0.evaluateJavascript(r3, b.a);
        return;
    }

    private final void navigationToPPTLocation(int r4) {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.enterprise_drive_ppt_anchor_link");
        tt5.a.h(TAG, "navigationToPPTLocation() called with: page = " + r4 + " isFgOn = " + r0);
        if (r0 == true) goto L5;
        return;
    L5:
        evaluateJavaScript(StringsKt.trimIndent("\n            (async () => {\n                await currentApplication.ActivePresentation.SlideShowWindow.View.GotoSlide(" + r4 + ");\n            })();\n        "));
    }

    private final void navigationToWordLocation(int r4) {
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.enterprise_drive_word_anchor_link");
        tt5.a.h(TAG, "navigationToWordLocation() called with: page = " + r4 + " isFgOn = " + r0);
        if (r0 == true) goto L5;
        return;
    L5:
        evaluateJavaScript(StringsKt.trimIndent("\n            (async () => {\n                await this.currentApplication.ActiveDocument.ActiveWindow.Selection.GoTo(\n                    this.currentApplication.Enum.WdGoToItem.wdGoToPage,\n                    this.currentApplication.Enum.WdGoToDirection.wdGoToAbsolute,\n                    " + r4 + "\n                );\n            })();\n        "));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin
    public void onAttachToHost(DrivePluginHost r4) {
        Intrinsics.checkNotNullParameter(r4, "host");
        super.onAttachPreview();
        ((WpsViewModel) viewModel(WpsViewModel.class)).getWpsApplicationReadyLiveData().observe(getLifecycleOwner(), new c(r4, this));
    }

    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DrivePluginHost) r1);
    }

    public static final /* synthetic */ void access$navigationToPPTLocation(DriveWpsNavigationPlugin r0, int r1) {
        r0.navigationToPPTLocation(r1);
    }

    public static final /* synthetic */ void access$navigationToWordLocation(DriveWpsNavigationPlugin r0, int r1) {
        r0.navigationToWordLocation(r1);
    }

    public static final /* synthetic */ void access$setWebView$p(DriveWpsNavigationPlugin r0, WebView r1) {
        r0.webView = r1;
    }

    private final void navigationToSheetLocation(int r3, String r4) {
        tt5.a.h(TAG, "goToSheet() called with: tabIndex = " + r3 + ", range = " + r4);
        if ((!StringsKt.isBlank(r4)) == false) goto L5;
        String r5 = "await this.currentApplication.Range('" + r4 + "').Select();";
    L6:
        evaluateJavaScript(StringsKt.trimIndent("\n            (async () => {\n                await this.currentApplication.ActiveWorkbook.Sheets.Item(" + r3 + ").Activate();\n                " + r5 + "\n            })();\n        "));
        return;
    L5:
        r5 = "";
        goto L6
    }

    public static final /* synthetic */ void access$navigationToSheetLocation(DriveWpsNavigationPlugin r0, int r1, String r2) {
        r0.navigationToSheetLocation(r1, r2);
    }
}
