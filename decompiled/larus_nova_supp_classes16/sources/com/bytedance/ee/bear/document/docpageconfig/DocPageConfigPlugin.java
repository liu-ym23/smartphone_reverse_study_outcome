package com.bytedance.ee.bear.document.docpageconfig;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewParent;
import bp5.c;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.document.orientation.p;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vv4.k;
import zv4.d;
import zv4.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/ee/bear/document/docpageconfig/DocPageConfigPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/widget/statusbar/StatusBarCompat$IInterceptor;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "<init>", "()V", "mDocPageConfig", "Landroid/os/Bundle;", "mDecorateLayer", "Lcom/bytedance/ee/bear/browser/view/DecorateLayer;", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onDetachFromHost", "handleTitleBarState", "handleOrientationState", "handleScrollConflicts", "shouldDisableLandscape", "", "interceptSetStatusBarColor", "activity", "Landroid/app/Activity;", "i", "", "b", "interceptSetSystemUiVisibility", "getConfigValue", "key", "", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocPageConfigPlugin extends DocumentPlugin implements c.a, p {
    public static final a Companion = null;
    private static final String TAG = "DocPageConfigPlugin";
    private d mDecorateLayer;
    private Bundle mDocPageConfig;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends g {
        public final /* synthetic */ DocPageConfigPlugin a;

        public b(DocPageConfigPlugin r1) {
            this.a = r1;
        }

        @Override // zv4.d
        public final boolean onTouchEvent(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            if (r2.getAction() != 0) goto L7;
            DocPageConfigPlugin.access$getWeb(this.a).getWebView().requestDisallowInterceptTouchEvent(true);
            return false;
        L7:
            return false;
        }

        @Override // zv4.g, zv4.d
        public final void a(int r1, int r2, boolean r3, boolean r4) {
            if (r3 == false) goto L5;
            DocPageConfigPlugin.access$getWeb(this.a).getWebView().requestDisallowInterceptTouchEvent(false);
            return;
        }
    }

    static {
        Companion = new a();
    }

    public boolean interceptSetStatusBarColor(Activity r1, int r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        return true;
    }

    public boolean interceptSetSystemUiVisibility(Activity r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        return true;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return true;
    }

    private final void handleOrientationState() {
        if (getConfigValue("disableLandscape") == false) goto L8;
        BaseUnspecifiedOrientationPlugin r1 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r1 == null) goto L9;
        r1.onOrientationSupportPanelShowing(this);
        tt5.a.b(TAG, "disableLandscape");
        return;
    L9:
        return;
    }

    private final void handleScrollConflicts() {
        if (this.mDecorateLayer != null) goto L6;
        this.mDecorateLayer = new b(this);
    L6:
        if ((getWeb().getWebView() instanceof zv4.c) == false) goto L9;
        ViewParent r0 = getWeb().getWebView();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.browser.view.DecorateHost<*>");
        ((zv4.c) r0).b(this.mDecorateLayer);
        return;
    }

    private final void handleTitleBarState() {
        TitleBar r0 = getTitleBar();
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = getConfigValue("hideTitleBar");
        if (r1 == false) goto L8;
        r0.getTitleBarLayout().setVisibility(8);
    L8:
        boolean r2 = getConfigValue("hideTitle");
        if (r2 == false) goto L11;
        getTitleBar().setTitleVisibility(false);
        getTitleBar().h();
    L11:
        boolean r4 = getConfigValue("hideBackIcon");
        if (r4 == false) goto L14;
        r0.setLeftIconVisibility(false);
    L14:
        ArrayList r3 = new ArrayList();
        boolean r5 = getConfigValue("hideMessageIcon");
        boolean r6 = getConfigValue("hideShareIcon");
        boolean r7 = getConfigValue("hideMoreIcon");
        if (r5 == false) goto L17;
        r3.add(new MenuItem("MESSAGE", null));
    L17:
        if (r6 == false) goto L19;
        r3.add(new MenuItem("SHARE", null));
    L19:
        if (r7 == false) goto L21;
        r3.add(new MenuItem("MORE_OPERATE", null));
    L21:
        r0.setHiddenMenus(r3);
        tt5.a.b(TAG, "hideTitleBar=" + r1 + ", hideTitle=" + r2 + ", hideBackIcon=" + r4 + ", hiddenMenuItems=" + r3);
    }

    public DocPageConfigPlugin() {
    }

    public static final /* synthetic */ k access$getWeb(DocPageConfigPlugin r0) {
        return r0.getWeb();
    }

    private final boolean getConfigValue(String r3) {
        Bundle r0 = this.mDocPageConfig;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getBoolean(r3, false);
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        c.b(getActivity(), this);
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
        c.c(getActivity(), this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public void onAttachToUIContainer(DocumentPluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onAttachToUIContainer(r2, r3);
        Bundle r4 = r2.c().getArguments();
        if (r4 == null) goto L5;
        Bundle r5 = r4.getBundle("doc_page_config");
    L6:
        this.mDocPageConfig = r5;
        if (r5 == null) goto L9;
        handleTitleBarState();
        handleOrientationState();
    L9:
        handleScrollConflicts();
        return;
    L5:
        r5 = null;
        goto L6
    }

    public void onDetachFromUIContainer(DocumentPluginHost r2, t r3) {
        Intrinsics.checkNotNullParameter(r2, "host");
        Intrinsics.checkNotNullParameter(r3, "uiContainer");
        super.onDetachFromUIContainer(r2, r3);
        if ((getWeb().getWebView() instanceof zv4.c) == true) goto L5;
    L7:
        BaseUnspecifiedOrientationPlugin r4 = (BaseUnspecifiedOrientationPlugin) findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r4 == null) goto L11;
        r4.onOrientationSupportPanelDismiss(this);
        return;
    L11:
        return;
    L5:
        if (this.mDecorateLayer == null) goto L7;
        ViewParent r5 = getWeb().getWebView();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.browser.view.DecorateHost<*>");
        ((zv4.c) r5).d(this.mDecorateLayer);
        goto L7
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
