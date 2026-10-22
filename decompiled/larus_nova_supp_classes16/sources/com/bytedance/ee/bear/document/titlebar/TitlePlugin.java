package com.bytedance.ee.bear.document.titlebar;

import android.animation.ObjectAnimator;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.WebViewContainer;
import com.bytedance.ee.bear.document.a5;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TitlePlugin extends DocumentPluginV2 implements BaseTitlePlugin<PluginHost>, x2.b, a5 {
    private static final String TAG = "TitlePlugin";
    protected View contentOuterContainer;
    private boolean customEnableNestScroll;
    private boolean customHeaderNestScrollEnable;
    private tb5.m deviceInfoCallback;
    private boolean hideTitleWhenLandscape;
    private ImmersiveWebContainerBehavior immersiveWebContainerBehavior;
    private final MutableLiveData<Boolean> isCardShowing;
    private boolean isHostSupportNestScroll;
    private boolean isInCustomHeader;
    protected boolean isPad;
    private boolean isSheet;
    private boolean isTemplatePreview;
    private boolean loading;
    private int mCustomContentHeight;
    private boolean mCustomPreviewMode;
    private s1 mDocReport;
    private boolean mHasReportViewEvent;
    private boolean mIsDocx;
    private com.bytedance.ee.bear.browser.plugin.d mLastDeviceInfo;
    private WebViewContainer mWebViewContainer;
    private Runnable notifyTitleBarHideRunnable;
    protected AppBarLayout titleBar;
    private Set<a5.a> titleBarBackPressedInterceptors;
    private ImmersiveTitleBarBehavior titleBarBehavior;
    private final ComponentCallbacks titleBarDarkModeConfigurationChangedCallbacks;
    private ViewTreeObserver.OnGlobalLayoutListener titleBarLayoutListener;
    private final TitleBar.a titleBarStateChangedListener;
    private ViewTreeObserver titleBarViewTreeObserver;
    private final View.OnLayoutChangeListener updateWebPaddingTask;

    public class a implements ComponentCallbacks {
        public final /* synthetic */ TitlePlugin a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public a(TitlePlugin r1) {
            this.a = r1;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r1) {
            TitleBar r2 = TitlePlugin.access$1500(this.a);
            if (r2 == null) goto L6;
            r2.invalidate();
            return;
        }
    }

    public class b implements tb5.i<String> {
        public final /* synthetic */ TitlePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(TitlePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            if (((TitleBarFixedInfo) JSON.parseObject((String) r2, TitleBarFixedInfo.class)).isFixed() == false) goto L5;
            this.a.updateEnableNestScroll(false);
            this.a.titleBar.setAlpha(1.0f);
            this.a.titleBar.setVisibility(0);
            return;
        L5:
            this.a.updateEnableNestScroll(true);
        }
    }

    public class c implements tb5.i<String> {
        public final /* synthetic */ TitlePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(TitlePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r5, tb5.m r6) {
            String r7 = (String) r5;
            JSONObject r8 = new JSONObject();
            if (TitlePlugin.access$700(this.a) == null) goto L10;
            AppBarLayout r0 = this.a.titleBar;
            if (r0 == null) goto L10;
            if (r0.getVisibility() != 0) goto L10;
            int[] r1 = new int[2];
            int[] r2 = new int[2];
            this.a.titleBar.getLocationInWindow(r1);
            TitlePlugin.access$700(this.a).getLocationInWindow(r2);
            int r3 = (r1[1] + this.a.titleBar.getHeight()) - r2[1];
            if (r3 < 0) goto L10;
        L11:
            r8.put("height", Integer.valueOf(com.bytedance.ee.util.ui.n.E(r3)));
            tt5.a.h(TitlePlugin.TAG, r8.toJSONString());
            r6.b(r8);
            return;
        L10:
            r3 = 0;
            goto L11
        }
    }

    public class d implements tb5.i<NameData> {
        public final /* synthetic */ TitlePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(TitlePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            NameData r4 = (NameData) r2;
            this.a.getDocumentMetadata().setDocName(r4.getName());
            this.a.getDocumentMetadata().getShowingIconInfo().setValue(r4.getIcon_info());
        }
    }

    public class e implements tb5.i<NavigationTitle> {
        public final /* synthetic */ TitlePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public e(TitlePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            NavigationTitle r4 = (NavigationTitle) r2;
            if (this.a.getDocumentMetadata().isAnnounceDoc() == true) goto L5;
        L9:
            this.a.getDocumentMetadata().updateTitle(r4);
            return;
        L5:
            if ("".equals(r4.getTitle()) == false) goto L7;
        L8:
            r4.setTitle(TitlePlugin.access$900(this.a, 2131887861));
            r4.setDisplayTitleType(1);
            r4.setSubTitle(null);
            goto L9
        L7:
            if (TitlePlugin.access$800(this.a, 2131887843).equals(r4.getTitle()) == false) goto L9;
            goto L8
        }
    }

    public class f implements tb5.i<ToggleTitlebarData> {
        public final /* synthetic */ TitlePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f(TitlePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            ToggleTitlebarData r5 = (ToggleTitlebarData) r3;
            tt5.a.h(TitlePlugin.TAG, "ToggleTitleHandler handle: isPad:" + this.a.isPad + ", data:" + r5);
            if (this.a.isPad == true) goto L5;
        L7:
            boolean r6 = true;
            if (r5.getStates() == 1) goto L11;
            r6 = false;
        L11:
            tt5.a.h(TitlePlugin.TAG, "Toggle title show:" + r6);
            this.a.toggleTitle(r6);
            return;
        L5:
            if (r5.isIsLarkAndroidSupportPad() == true) goto L7;
            tt5.a.h(TitlePlugin.TAG, "ToggleTitleHandler handle: isPad and not support pad, return");
        }
    }

    public class g implements tb5.i<String> {
        public final /* synthetic */ TitlePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public g(TitlePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            String r3 = (String) r1;
            tt5.a.h(TitlePlugin.TAG, "Toggle titleBar visible");
            BearUrl r4 = this.a.getDocumentMetadata().getBearUrl();
            if (TextUtils.equals(sbb.e.g.getType(), r4.a) == true) goto L5;
        L7:
            TitlePlugin r5 = this.a;
            if (r5.isPad == false) goto L10;
            return;
        L10:
            if (r5.titleBar.getVisibility() != 0) goto L12;
            this.a.titleBar.setVisibility(4);
            return;
        L12:
            this.a.titleBar.setVisibility(0);
            return;
        L5:
            if (DocOpenConfig.k == false) goto L7;
        }
    }

    public class h implements tb5.i<Void> {
        public final /* synthetic */ TitlePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public h(TitlePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, tb5.m r3) {
            Void r4 = (Void) r2;
            tt5.a.b(TitlePlugin.TAG, "front end notify get device info");
            TitlePlugin.access$1002(this.a, r3);
            TitlePlugin.access$1200(this.a).g(TitlePlugin.access$1100(this.a));
            TitlePlugin r5 = this.a;
            TitlePlugin.access$1400(r5, TitlePlugin.access$1300(r5).getDeviceInfo());
        }
    }

    public TitlePlugin() {
        this(false);
    }

    public static /* synthetic */ void a(TitlePlugin r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r0.lambda$new$0(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void c(TitlePlugin r0, Boolean r1) {
        r0.lambda$handleCardShowingStatus$3(r1);
    }

    public static /* synthetic */ void d(TitlePlugin r0) {
        r0.lambda$onAttachToUIContainer$1();
    }

    public static /* synthetic */ void e(TitlePlugin r0) {
        r0.lambda$onLoadSuccess$4();
    }

    public static /* synthetic */ void f(TitlePlugin r0, com.bytedance.ee.bear.browser.plugin.d r1) {
        r0.notifyDeviceInfo(r1);
    }

    public static /* synthetic */ void g(TitlePlugin r0, View r1) {
        r0.lambda$onAttachToUIContainer$2(r1);
    }

    public boolean isPadEnableNestScroll() {
        return true;
    }

    public /* bridge */ /* synthetic */ void onLoadCancel() {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadStart() {
        this.loading = true;
        updateNestScroll();
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadSuccess() {
        this.loading = false;
        updateNestScroll();
        com.bytedance.ee.util.ui.j.c(new p0(this));
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public /* bridge */ /* synthetic */ void onSSRLoadSuccess() {
    }

    private void handleCardShowingStatus() {
        if (this.isPad == true) goto L6;
        this.isCardShowing.observe(getLifecycleOwner(), new o0(this));
        return;
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$1() {
        if (this.notifyTitleBarHideRunnable != null) goto L5;
        return;
    L5:
        if (this.titleBar.getVisibility() != 4) goto L9;
        this.notifyTitleBarHideRunnable.run();
        return;
    }

    private void lockDefaultNavigationModeIfNeed() {
        ((com.bytedance.ee.bear.document.titlebar.a) org.koin.java.a.a(com.bytedance.ee.bear.document.titlebar.a.class)).a();
        tt5.a.h(TAG, "enableLockDefaultNavigationMode = false");
    }

    private boolean shouldEnableNestScroll() {
        if (this.isHostSupportNestScroll == true) goto L5;
    L15:
        return false;
    L5:
        if (this.loading == true) goto L15;
        if (this.customEnableNestScroll == false) goto L15;
        if (this.isPad == false) goto L13;
        if (isPadEnableNestScroll() == false) goto L15;
    L13:
        if (specialSceneForbiddenNestedScroll() == true) goto L15;
        return true;
    }

    @Override // com.bytedance.ee.bear.document.a5
    public Set<a5.a> getBackPressedInterceptors() {
        return Collections.unmodifiableSet(this.titleBarBackPressedInterceptors);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public BaseTitlePlugin.a getImmersiveDelegate() {
        return this.titleBarBehavior.h;
    }

    public int getPaddingBottom() {
        if (this.isTemplatePreview == true) goto L5;
        return 0;
    L5:
        if (getDocumentMetadata().isCommonTemplatePreview() == false) goto L13;
        if (this.mCustomPreviewMode == false) goto L11;
        return this.mCustomContentHeight;
    L11:
        return y9c.d.a(160);
    L13:
        return y9c.d.a(250);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public int[] getTitleBarHeightLocation() {
        AppBarLayout r0 = this.titleBar;
        if (r0 == null) goto L7;
        int[] r1 = new int[2];
        r0.getLocationOnScreen(r1);
        return r1;
    L7:
        return new int[2];
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public void removeNotifyTitleBarHideRunnable() {
        if (this.notifyTitleBarHideRunnable == null) goto L6;
        this.notifyTitleBarHideRunnable = null;
        return;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public void setAppBarLayoutInvisible() {
        this.titleBar.setVisibility(4);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public void setAppBarLayoutVisible() {
        this.titleBar.setVisibility(0);
        this.titleBar.setAlpha(1.0f);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public void setTitleBarVisible() {
        AppBarLayout r0 = this.titleBar;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 4) goto L9;
        updateEnableNestScroll(false);
        this.titleBar.setAlpha(1.0f);
        this.titleBar.setVisibility(0);
        updateEnableNestScroll(true);
        return;
    }

    public void updateContentContainerPaddingTop() {
        if (this.contentOuterContainer != null) goto L5;
        return;
    L5:
        if (shouldEnableNestScroll() == false) goto L7;
        int r0 = 0;
    L9:
        if (this.contentOuterContainer.getPaddingTop() == r0) goto L11;
    L12:
        this.contentOuterContainer.setPadding(0, r0, 0, getPaddingBottom());
        return;
    L11:
        if (this.mCustomPreviewMode == true) goto L12;
        return;
    L7:
        r0 = this.titleBar.getHeight();
        goto L9
    }

    private void hideLeftActions() {
        TitleBar r0 = getTitleBar();
        if (getDocumentMetadata().isEditionDoc() == true) goto L5;
        return;
    L5:
        if (getDocumentMetadata().isType(sbb.e.n) == false) goto L10;
        if (r0 == null) goto L11;
        ((LinearLayout) r0.getTitleBarLayout().getLeftLayout().findViewById(2131388818)).setVisibility(8);
        return;
    L11:
        return;
    }

    private void lambda$onLoadSuccess$4() {
        if (isUIContainerAttached() == true) goto L5;
        return;
    L5:
        if (this.mHasReportViewEvent == true) goto L9;
        s1 r0 = this.mDocReport;
        HashMap<String, Object> r1 = r0.b.m("docCommonParams");
        r0.b.n("ccm_space_docs_topbar_view", r1);
        tt5.a.b("DocReport", "reportTopBarViewEvent, params = " + r1);
        this.mHasReportViewEvent = true;
        return;
    }

    private boolean specialSceneForbiddenNestedScroll() {
        if (getDocViewModel() != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(getDocViewModel().getOpenSource().name(), DocsOpenSource.base_instruction_docx.name()) == false) goto L7;
        return true;
    }

    private void updateNestScroll() {
        if (isUIContainerAttached() == true) goto L6;
        return;
    L6:
        if (specialSceneForbiddenNestedScroll() == false) goto L8;
        return;
    L8:
        boolean r0 = shouldEnableNestScroll();
        vv4.k r1 = getWebOrNull();
        if (r1 == null) goto L14;
        WebView r2 = r1.getWebView();
        if (r2 == null) goto L14;
        r2.setNestedScrollingEnabled(r0);
    L14:
        if (this.contentOuterContainer != null) goto L16;
        return;
    L16:
        if (this.titleBar == null) goto L45;
        updateContentContainerPaddingTop();
        ImmersiveWebContainerBehavior r3 = null;
        if ((this.titleBar.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) == false) goto L37;
        CoordinatorLayout.LayoutParams r4 = this.titleBar.getLayoutParams();
        ImmersiveTitleBarBehavior r5 = this.titleBarBehavior;
        ObjectAnimator r6 = r5.d;
        if (r6 == null) goto L26;
        r6.removeAllListeners();
        if (r5.d.isRunning() == false) goto L25;
        r5.d.cancel();
    L25:
        r5.d = null;
    L26:
        ObjectAnimator r7 = r5.e;
        if (r7 == null) goto L32;
        r7.removeAllListeners();
        if (r5.e.isRunning() == false) goto L31;
        r5.e.cancel();
    L31:
        r5.e = null;
    L32:
        if (r0 == false) goto L34;
        ImmersiveTitleBarBehavior r8 = this.titleBarBehavior;
    L35:
        r4.setBehavior(r8);
        goto L37
    L34:
        r8 = null;
    L37:
        if ((this.contentOuterContainer.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) == false) goto L42;
        CoordinatorLayout.LayoutParams r9 = this.contentOuterContainer.getLayoutParams();
        ImmersiveWebContainerBehavior r10 = new ImmersiveWebContainerBehavior();
        this.immersiveWebContainerBehavior = r10;
        if (r0 == false) goto L41;
        r3 = r10;
    L41:
        r9.setBehavior(r3);
    L42:
        this.contentOuterContainer.requestLayout();
        return;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public boolean isHostSupportNestScroll() {
        return this.isHostSupportNestScroll;
    }

    public TitlePlugin(boolean r2) {
        this(r2, false);
    }

    public static /* synthetic */ TitleBar.a access$1100(TitlePlugin r0) {
        return r0.titleBarStateChangedListener;
    }

    public static /* synthetic */ TitleBar access$1200(TitlePlugin r0) {
        return r0.getTitleBar();
    }

    public static /* synthetic */ TitleBar access$1300(TitlePlugin r0) {
        return r0.getTitleBar();
    }

    public static /* synthetic */ TitleBar access$1500(TitlePlugin r0) {
        return r0.getTitleBar();
    }

    public static /* synthetic */ WebViewContainer access$700(TitlePlugin r0) {
        return r0.mWebViewContainer;
    }

    private /* synthetic */ void lambda$handleCardShowingStatus$3(Boolean r3) {
        tt5.a.h(TAG, "handleCardShowingStatus, isShowing = " + r3);
        if (r3 == null) goto L6;
        getTitleBar().setTransparent(r3.booleanValue());
        return;
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$2(View r2) {
        this.mDocReport.m("back");
    }

    private void notifyDeviceInfo(com.bytedance.ee.bear.browser.plugin.d r4) {
        if (r4.c <= 0.0f) goto L5;
        r4.c = 1.0f;
    L6:
        r4.d = 0.0f;
        if (r4.equals(this.mLastDeviceInfo) == false) goto L10;
        return;
    L10:
        if (this.deviceInfoCallback == null) goto L13;
        JSONObject r0 = new JSONObject();
        r0.put("statusBarHeight", Integer.valueOf(r4.a));
        r0.put("titleBarHeight", Integer.valueOf(r4.b));
        r0.put("titleBarVisiblePercent", Float.valueOf(r4.c));
        tt5.a.b(TAG, "notify js device info: " + r0.toJSONString());
        this.mLastDeviceInfo = new com.bytedance.ee.bear.browser.plugin.d(r4);
        this.deviceInfoCallback.b(r0);
        return;
    L13:
        return;
    L5:
        r4.c = 0.0f;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.a5
    public void addBackPressedInterceptor(a5.a r2) {
        this.titleBarBackPressedInterceptors.add(r2);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public int getAiRightIconPosition(int r3) {
        if (getTitleBar() != null) goto L5;
        return 0;
    L5:
        if (getTitleBar().getTitleBarLayout() != null) goto L7;
        return 0;
    L7:
        if (getTitleBar().getTitleBarLayout().getRightLayout() != null) goto L9;
        return 0;
    L9:
        if (getTitleBar().getTitleBarLayout().getRightLayout().getChildCount() <= r3) goto L17;
        View r0 = getTitleBar().getTitleBarLayout().getRightLayout().getChildAt(r3);
        return (r0.getWidth() * r3) - (r0.getWidth() / 2);
    L17:
        return 0;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        if (this.isTemplatePreview == false) goto L5;
        return;
    L5:
        r3.put("biz.navigation.setTitle", new e(this));
        r3.put("biz.util.toggleTitlebar", new f(this));
        r3.put("biz.navigation.setName", new d(this));
        r3.put("biz.util.getDeviceInfo", new h(this));
        r3.put("biz.edit.togglgEditMode", new g(this));
        r3.put("biz.util.fixedTitleBar", new b(this));
        r3.put("biz.util.getWebViewCoverHeight", new c(this));
    }

    public void handleOrientation(Configuration r3) {
        if (this.isPad == false) goto L6;
        return;
    L6:
        if (r3.orientation != 2) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L13;
        getUIContainer().hideStatusBar();
        if (this.hideTitleWhenLandscape == false) goto L15;
        getTitleBar().hide(false);
        return;
    L15:
        return;
    L13:
        getUIContainer().a();
        getTitleBar().show(false);
        return;
    L8:
        r4 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r8) {
        super.onAttachToHost(r8);
        this.isPad = ku5.c.k(getContext());
        tt5.a.h(TAG, "isPad = " + this.isPad);
        getEditorAbility().getDocumentLoader().S3(this);
        this.mDocReport = new s1(com.bytedance.ee.bear.contract.j.a.a, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), (com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class), (com.bytedance.ee.bear.contract.f) org.koin.java.a.a(com.bytedance.ee.bear.contract.f.class), ((com.bytedance.ee.bear.contract.b0) org.koin.java.a.a(com.bytedance.ee.bear.contract.b0.class)).e());
        r8.registerHostAbility(this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        handleOrientation(r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r2) {
        super.onDetachFromHost(r2);
        getEditorAbility().getDocumentLoader().S(this);
        r2.unregisterHostAbility(this);
        if (this.titleBarViewTreeObserver != null) goto L5;
        return;
    L5:
        if (this.titleBarLayoutListener == null) goto L12;
        tt5.a.h(TAG, "onDetachFromUIContainer,  titleBarViewTreeObserver.isAlive() = " + this.titleBarViewTreeObserver.isAlive());
        if (this.titleBarViewTreeObserver.isAlive() == false) goto L9;
        this.titleBarViewTreeObserver.removeOnGlobalLayoutListener(this.titleBarLayoutListener);
    L9:
        this.titleBarLayoutListener = null;
        return;
    }

    @Override // com.bytedance.ee.bear.document.a5
    public void removeBackPressedInterceptor(a5.a r2) {
        this.titleBarBackPressedInterceptors.remove(r2);
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public void setImmersiveDelegate(BaseTitlePlugin.a r2) {
        this.titleBarBehavior.h = r2;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public void setNotifyTitleBarHideRunnable(Runnable r1) {
        this.notifyTitleBarHideRunnable = r1;
    }

    public void toggleTitle(boolean r5) {
        com.bytedance.ee.bear.browser.plugin.t r0 = getUIContainer();
        TitleBar r1 = r0.getTitleBar();
        if (r5 == true) goto L5;
        r0.hideStatusBar();
        r1.hide(false);
        return;
    L5:
        if (getResources() != null) goto L7;
    L10:
        r0.a();
    L11:
        r1.show(false);
        return;
    L7:
        if (getResources().getConfiguration().orientation != 2) goto L10;
        if (this.isPad == false) goto L11;
        goto L10
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public void updateAntiShakePreDrawEnable(boolean r2) {
        ImmersiveWebContainerBehavior r0 = this.immersiveWebContainerBehavior;
        if (r0 == null) goto L6;
        r0.h = r2;
        return;
    }

    public void updateCardShowingStatus(boolean r2) {
        this.isCardShowing.postValue(Boolean.valueOf(r2));
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public void updateEnableNestScroll(boolean r4) {
        if (this.isInCustomHeader == false) goto L6;
        tt5.a.h(TAG, "updateEnableNestScroll, isInCustomHeader = " + this.isInCustomHeader);
        r4 = this.customHeaderNestScrollEnable;
    L6:
        if (this.customEnableNestScroll == r4) goto L9;
        tt5.a.h(TAG, "updateEnableNestScroll, enable = " + r4);
        this.customEnableNestScroll = r4;
        updateNestScroll();
        return;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public void updateIsHostSupportNestScroll(boolean r1) {
        this.isHostSupportNestScroll = r1;
        updateNestScroll();
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public void updateIsInCustomHeader(boolean r2) {
        if (this.isInCustomHeader == r2) goto L6;
        this.isInCustomHeader = r2;
        return;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public void updateIsInCustomHeaderNestScroll(boolean r2) {
        if (this.customHeaderNestScrollEnable == r2) goto L6;
        this.customHeaderNestScrollEnable = r2;
        return;
    }

    public TitlePlugin(boolean r2, boolean r3) {
        this(r2, r3, true);
    }

    public static /* synthetic */ tb5.m access$1002(TitlePlugin r0, tb5.m r1) {
        r0.deviceInfoCallback = r1;
        return r1;
    }

    public static /* synthetic */ void access$1400(TitlePlugin r0, com.bytedance.ee.bear.browser.plugin.d r1) {
        r0.notifyDeviceInfo(r1);
    }

    public static /* synthetic */ String access$800(TitlePlugin r0, int r1) {
        return r0.getString(r1);
    }

    public static /* synthetic */ String access$900(TitlePlugin r0, int r1) {
        return r0.getString(r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(PluginHost r6, com.bytedance.ee.bear.browser.plugin.t r7) {
        super.onAttachToUIContainer(r6, r7);
        BearUrl r0 = getDocumentMetadata().getBearUrl();
        boolean r1 = sbb.e.g.getType().equals(r0.a);
        this.mIsDocx = sbb.e.o.getType().equals(r0.a);
        this.isSheet = sbb.e.h.getType().equals(r0.a);
        boolean r2 = sbb.e.i.getType().equals(r0.a);
        boolean r3 = sbb.e.k.getType().equals(r0.a);
        boolean r4 = sbb.e.m.getType().equals(r0.a);
        TitleBar r5 = getTitleBar();
        if (r1 == true) goto L12;
        if (this.mIsDocx == true) goto L12;
        if (this.isSheet == true) goto L12;
        if (r2 == true) goto L12;
        if (r3 == true) goto L12;
        if (r4 == true) goto L12;
    L14:
        TitleBar.TitleGravity r8 = TitleBar.TitleGravity.Center;
    L15:
        r5.b(r8);
        this.contentOuterContainer = r6.getContainer(ContainerType.Content.getValue());
        this.titleBar = r7.findView(2131369266);
        this.mWebViewContainer = (WebViewContainer) r7.findView(2131393115);
        AppBarLayout r9 = this.titleBar;
        if (r9 == null) goto L18;
        this.titleBarLayoutListener = new m0(this);
        ViewTreeObserver r10 = r9.getViewTreeObserver();
        this.titleBarViewTreeObserver = r10;
        r10.addOnGlobalLayoutListener(this.titleBarLayoutListener);
        this.titleBar.addOnLayoutChangeListener(this.updateWebPaddingTask);
    L18:
        handleOrientation(getResources().getConfiguration());
        handleCardShowingStatus();
        lockDefaultNavigationModeIfNeed();
        BaseTitleBar r11 = getTitleBar().getTitleBarLayout();
        r11.setLeftExtraClickListener(new n0(this));
        r11.setTag(2131388826, Boolean.TRUE);
        getActivity().getApplicationContext().registerComponentCallbacks(this.titleBarDarkModeConfigurationChangedCallbacks);
        hideLeftActions();
        return;
    L12:
        if (this.isTemplatePreview == true) goto L14;
        r8 = TitleBar.TitleGravity.Left;
        goto L15
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onDetachFromUIContainer(r2, r3);
        if (this.titleBarLayoutListener != null) goto L5;
    L10:
        getDocumentMetadata().updateTitle(new NavigationTitle());
        AppBarLayout r4 = this.titleBar;
        if (r4 == null) goto L13;
        r4.removeOnLayoutChangeListener(this.updateWebPaddingTask);
    L13:
        getTitleBar().c(this.titleBarStateChangedListener);
        getActivity().getApplicationContext().unregisterComponentCallbacks(this.titleBarDarkModeConfigurationChangedCallbacks);
        if (ForsetiHelper.s(r2.getHostFragment()) == false) goto L17;
        getUIContainer().a();
        return;
    L17:
        return;
    L5:
        if (this.titleBarViewTreeObserver == null) goto L10;
        tt5.a.h(TAG, "onDetachFromUIContainer, titleBarViewTreeObserver.isAlive() = " + this.titleBarViewTreeObserver.isAlive());
        if (this.titleBarViewTreeObserver.isAlive() == false) goto L9;
        this.titleBarViewTreeObserver.removeOnGlobalLayoutListener(this.titleBarLayoutListener);
    L9:
        this.titleBarLayoutListener = null;
        goto L10
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadFail(int r1, Throwable r2) {
        this.loading = false;
        updateNestScroll();
    }

    @Override // com.bytedance.ee.bear.document.titlebar.BaseTitlePlugin
    public void updateCustomPreviewStatus(boolean r1, int r2) {
        this.mCustomContentHeight = r2;
        this.mCustomPreviewMode = r1;
        updateContentContainerPaddingTop();
    }

    public TitlePlugin(boolean r4, boolean r5, boolean r6) {
        this.isPad = false;
        this.customEnableNestScroll = true;
        this.hideTitleWhenLandscape = true;
        this.isInCustomHeader = false;
        this.customHeaderNestScrollEnable = false;
        this.immersiveWebContainerBehavior = null;
        this.isCardShowing = new MutableLiveData();
        this.updateWebPaddingTask = new q0(this);
        this.titleBarStateChangedListener = new r0(this);
        this.mCustomPreviewMode = false;
        this.mCustomContentHeight = 0;
        this.titleBarBackPressedInterceptors = new HashSet();
        this.notifyTitleBarHideRunnable = null;
        this.titleBarDarkModeConfigurationChangedCallbacks = new a(this);
        this.isHostSupportNestScroll = r4;
        this.isTemplatePreview = r5;
        this.titleBarBehavior = new ImmersiveTitleBarBehavior();
        this.hideTitleWhenLandscape = r6;
    }

    private /* synthetic */ void lambda$new$0(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        com.bytedance.ee.util.ui.j.c(new s0(this));
    }
}
