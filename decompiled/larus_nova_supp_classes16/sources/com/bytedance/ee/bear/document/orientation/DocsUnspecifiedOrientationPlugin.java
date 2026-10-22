package com.bytedance.ee.bear.document.orientation;

import android.content.res.Configuration;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.WebFragment;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin;
import com.bytedance.ee.bear.document.x2;
import com.ss.android.lark.insets.WindowInsetsUtils;
import java.util.Stack;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocsUnspecifiedOrientationPlugin extends UnspecifiedOrientationPlugin implements x2.b {
    private static final String TAG = "DocsUnspecifiedOrientat";
    private com.ss.android.lark.insets.f displayCutoutInsetsHandler;
    private boolean enableOrientationTipsFromJs;
    private boolean isLoading;
    private e mIOrientationEvent;
    private com.bytedance.ee.bear.document.orientation.e mOrientationTipPresenter;
    private LiveData<ru5.d> mSensorOrientationState;
    private Boolean originConsumeDisplayCutout;

    public class a implements com.bytedance.ee.bear.document.orientation.e.c {
        public final /* synthetic */ DocsUnspecifiedOrientationPlugin a;

        @Override // com.bytedance.ee.bear.document.orientation.e.c
        public final int a() {
            int r0 = this.a.orientationController.a();
            tt5.a.h(DocsUnspecifiedOrientationPlugin.TAG, "getRequestedOrientation() called orientation:" + r0);
            return r0;
        }

        @Override // com.bytedance.ee.bear.document.orientation.e.c
        public final void c() {
            if ((DocsUnspecifiedOrientationPlugin.access$100(this.a).getWebView() instanceof zv4.b) == false) goto L6;
            ((zv4.b) DocsUnspecifiedOrientationPlugin.access$200(this.a).getWebView()).c();
            return;
        }

        @Override // com.bytedance.ee.bear.document.orientation.e.c
        public final void d() {
            tt5.a.h(DocsUnspecifiedOrientationPlugin.TAG, "switchPortrait() called");
            if (DocsUnspecifiedOrientationPlugin.access$000(this.a) == null) goto L5;
            DocsUnspecifiedOrientationPlugin.access$000(this.a).c();
        L5:
            this.a.orientationController.b(1);
            this.a.mOrientationViewModel.setRequestOrientation(1);
        }

        @Override // com.bytedance.ee.bear.document.orientation.e.c
        public final void f() {
            tt5.a.h(DocsUnspecifiedOrientationPlugin.TAG, "clearRequestedOrientation() called");
            h r0 = this.a.orientationController;
            r0.getClass();
            tt5.a.h("ForsetiOrientationController", "clearRequestedOrientation() called");
            Fragment r1 = r0.a.getHostFragment();
            if (r1 != null) goto L5;
            return;
        L5:
            if (ForsetiHelper.s(r1) == false) goto L16;
            gib.a r2 = r1.getActivity();
            if ((r2 instanceof gib.a) == false) goto L10;
            gib.a r3 = r2;
        L11:
            if (r3 == null) goto L15;
            r3.clearExternalRequestedOrientation(r1);
            return;
        L15:
            return;
        L10:
            r3 = null;
            goto L11
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.bytedance.ee.bear.document.orientation.e.c
        public final Fragment getHostFragment() {
            return ((DocumentPluginHost) this.a.getHost()).c();
        }

        public a(DocsUnspecifiedOrientationPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.orientation.e.c
        public final void b(int r3) {
            tt5.a.h(DocsUnspecifiedOrientationPlugin.TAG, "setRequestedOrientation() called：" + r3);
            this.a.orientationController.b(r3);
        }

        @Override // com.bytedance.ee.bear.document.orientation.e.c
        public final void e(boolean r3) {
            tt5.a.h(DocsUnspecifiedOrientationPlugin.TAG, "switchLandscape() called with: reverse = [" + r3 + "]");
            if (DocsUnspecifiedOrientationPlugin.access$000(this.a) == null) goto L5;
            DocsUnspecifiedOrientationPlugin.access$000(this.a).b();
        L5:
            if (r3 == false) goto L7;
            int r4 = 8;
        L8:
            this.a.orientationController.b(r4);
            this.a.mOrientationViewModel.setRequestOrientation(r4);
            return;
        L7:
            r4 = 0;
            goto L8
        }
    }

    public class b implements Observer<Boolean> {
        public boolean a;
        public final /* synthetic */ DocsUnspecifiedOrientationPlugin b;

        public b(DocsUnspecifiedOrientationPlugin r1) {
            this.b = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            if (this.a == true) goto L5;
        L9:
            this.a = Boolean.TRUE.equals(r4);
            return;
        L5:
            if (Boolean.FALSE.equals(r4) == false) goto L9;
            DocsUnspecifiedOrientationPlugin.access$300(this.b).e();
            if (Boolean.TRUE.equals(this.b.mOrientationViewModel.getEnable().getValue()) == false) goto L9;
            this.b.orientationController.b(-1);
            this.b.mOrientationViewModel.setRequestOrientation(-1);
            goto L9
        }
    }

    public class c implements x2.b {
        public final /* synthetic */ DocsUnspecifiedOrientationPlugin a;

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onLoadCancel() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onSSRLoadSuccess() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadStart() {
            DocsUnspecifiedOrientationPlugin.access$402(this.a, true);
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            DocsUnspecifiedOrientationPlugin.access$402(this.a, false);
        }

        public c(DocsUnspecifiedOrientationPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r1, Throwable r2) {
            DocsUnspecifiedOrientationPlugin.access$402(this.a, false);
        }
    }

    public class d implements e {
        @Override // com.bytedance.ee.bear.document.orientation.DocsUnspecifiedOrientationPlugin.e
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.document.orientation.DocsUnspecifiedOrientationPlugin.e
        public final void d() {
        }

        @Override // com.bytedance.ee.bear.document.orientation.DocsUnspecifiedOrientationPlugin.e
        public final void e() {
        }

        public d() {
        }
    }

    public interface e {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public static /* synthetic */ void f(DocsUnspecifiedOrientationPlugin r0, ru5.d r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public static /* synthetic */ void g(DocsUnspecifiedOrientationPlugin r0, Stack r1) {
        r0.lambda$onAttachToHost$1(r1);
    }

    public boolean canShowTips() {
        return true;
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public /* bridge */ /* synthetic */ void onLoadCancel() {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadFail(int r1, Throwable r2) {
    }

    @Override // com.bytedance.ee.bear.document.orientation.UnspecifiedOrientationPlugin, com.bytedance.ee.bear.document.orientation.CommonOrientationPlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public /* bridge */ /* synthetic */ void onSSRLoadSuccess() {
    }

    private void restoreDisplayCutoutAvoidance() {
        com.ss.android.lark.insets.f r0 = this.displayCutoutInsetsHandler;
        if (r0 == null) goto L17;
        Boolean r1 = this.originConsumeDisplayCutout;
        if (r1 != null) goto L18;
        return;
    L18:
        r0.h(r1.booleanValue());     // Catch: Exception -> L10 Throwable -> L14
    L9:
        this.displayCutoutInsetsHandler = null;
        this.originConsumeDisplayCutout = null;
        return;
    L14:
        th = move-exception;
        this.displayCutoutInsetsHandler = null;
        this.originConsumeDisplayCutout = null;
        throw th;
    L10:
        e = move-exception;
        tt5.a.l(TAG, "restoreDisplayCutoutAvoidance failed", e);     // Catch: Throwable -> L14
        goto L9
    }

    @Override // com.bytedance.ee.bear.document.orientation.UnspecifiedOrientationPlugin, com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public void disableTips() {
        this.mOrientationTipPresenter.c();
    }

    @Override // com.bytedance.ee.bear.document.orientation.UnspecifiedOrientationPlugin, com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public void enableTips() {
        this.mOrientationTipPresenter.d();
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadStart() {
        this.mOrientationTipPresenter.c();
    }

    public DocsUnspecifiedOrientationPlugin() {
        this.enableOrientationTipsFromJs = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isSlides() {
        if (getHost() != 0) goto L5;
    L7:
        return false;
    L5:
        if (((DocumentPluginHost) getHost()).getDocumentMetadata().isDocumentType(sbb.e.m) == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.ss.android.lark.insets.f obtainDisplayCutoutInsetsHandler() {
        if (getHost() == 0) goto L5;
        WebFragment r0 = ((DocumentPluginHost) getHost()).c();
    L6:
        if (r0 == null) goto L12;
        if (ForsetiHelper.s(r0) == false) goto L12;
        return WindowInsetsUtils.b(r0);
    L12:
        if (getActivity() != null) goto L14;
        return null;
    L14:
        return WindowInsetsUtils.c(getActivity());
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.document.orientation.UnspecifiedOrientationPlugin, com.bytedance.ee.bear.document.orientation.CommonOrientationPlugin, com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public void forcePortrait() {
        super.forcePortrait();
        ru5.d r0 = (ru5.d) this.mSensorOrientationState.getValue();
        if (this.mOrientationViewModel.isLock() == false) goto L8;
        if (r0 == null) goto L9;
        this.mOrientationTipPresenter.e();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadSuccess() {
        if (com.bytedance.ee.util.ui.n.D(getActivity()) == true) goto L6;
        this.mOrientationTipPresenter.d();
        return;
    }

    @Override // com.bytedance.ee.bear.document.orientation.UnspecifiedOrientationPlugin
    public boolean shouldOverrideOrientationPerforming() {
        int r0 = getActivity().getRequestedOrientation();
        if (r0 == 8) goto L8;
        if (r0 == 0) goto L8;
        return super.shouldOverrideOrientationPerforming();
    L8:
        this.mOrientationViewModel.setRequestOrientation(r0);
        return true;
    }

    public static /* synthetic */ e access$000(DocsUnspecifiedOrientationPlugin r0) {
        return r0.mIOrientationEvent;
    }

    public static /* synthetic */ vv4.k access$100(DocsUnspecifiedOrientationPlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ vv4.k access$200(DocsUnspecifiedOrientationPlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ com.bytedance.ee.bear.document.orientation.e access$300(DocsUnspecifiedOrientationPlugin r0) {
        return r0.mOrientationTipPresenter;
    }

    private boolean isLandscape(Configuration r2) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (r2.orientation != 2) goto L6;
        return true;
    }

    private /* synthetic */ void lambda$onAttachToHost$0(ru5.d r2) {
        if (r2 != null) goto L6;
        if (this.isLoading == false) goto L6;
        return;
    L6:
        if (canShowTips() == false) goto L16;
        e r0 = this.mIOrientationEvent;
        if (r0 == null) goto L12;
        r0.d();
    L12:
        if (r2.isLandscape() == false) goto L14;
        onOrientationChangedToLandscape(r2.a());
        return;
    L14:
        onOrientationChangedToPortrait(r2.a());
        return;
    }

    private /* synthetic */ void lambda$onAttachToHost$1(Stack r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        tt5.a.h(TAG, "orientationSupportPanels size: " + r3.size());
        if (r3.empty() == true) goto L7;
    L13:
        this.mOrientationTipPresenter.c();
        tt5.a.h(TAG, "mOrientationTipPresenter disable");
        return;
    L7:
        if (com.bytedance.ee.util.ui.n.D(getActivity()) == true) goto L13;
        if (isVCFollow() == true) goto L13;
        if (this.enableOrientationTipsFromJs == false) goto L13;
        this.mOrientationTipPresenter.d();
        tt5.a.h(TAG, "mOrientationTipPresenter enable");
    }

    private void onOrientationChangedToLandscape(boolean r3) {
        if (this.mOrientationViewModel.isLock() == true) goto L5;
        return;
    L5:
        if (isVCFollow() == false) goto L7;
        return;
    L7:
        if (this.enableOrientationTipsFromJs == true) goto L9;
        return;
    L9:
        if (getResources().getConfiguration().orientation != 1) goto L13;
        this.mOrientationTipPresenter.i(r3);
        e r4 = this.mIOrientationEvent;
        if (r4 == null) goto L18;
        r4.a();
        return;
    L18:
        return;
    L13:
        this.mOrientationTipPresenter.e();
    }

    private void onOrientationChangedToPortrait(boolean r3) {
        if (this.mOrientationViewModel.isLock() == true) goto L5;
        return;
    L5:
        if (isVCFollow() == false) goto L7;
        return;
    L7:
        if (this.enableOrientationTipsFromJs == true) goto L9;
        return;
    L9:
        if (getResources().getConfiguration().orientation != 2) goto L18;
        if (r3 == true) goto L18;
        com.bytedance.ee.bear.document.orientation.e r4 = this.mOrientationTipPresenter;
        if (getActivity().getRequestedOrientation() != 8) goto L14;
        boolean r0 = true;
    L15:
        r4.j(r0);
        e r5 = this.mIOrientationEvent;
        if (r5 == null) goto L23;
        r5.e();
        return;
    L23:
        return;
    L14:
        r0 = false;
    L18:
        this.mOrientationTipPresenter.e();
    }

    private void updateDisplayCutoutAvoidance(boolean r3) {
        if (ku5.c.k(getContext()) == false) goto L6;
        return;
    L6:
        if (isSlides() == false) goto L9;
        restoreDisplayCutoutAvoidance();
        return;
    L9:
        if (r3 == true) goto L31;
        restoreDisplayCutoutAvoidance();
        return;
    L31:
        com.ss.android.lark.insets.f r4 = obtainDisplayCutoutInsetsHandler();     // Catch: Exception -> L28
        if (r4 != null) goto L15;
        return;
    L15:
        com.ss.android.lark.insets.f r0 = this.displayCutoutInsetsHandler;     // Catch: Exception -> L28
        if (r0 == null) goto L20;
        if (r0 == r4) goto L20;
        restoreDisplayCutoutAvoidance();     // Catch: Exception -> L28
    L20:
        if (this.originConsumeDisplayCutout != null) goto L22;
    L23:
        this.displayCutoutInsetsHandler = r4;     // Catch: Exception -> L28
        this.originConsumeDisplayCutout = Boolean.valueOf(r4.g());     // Catch: Exception -> L28
    L25:
        if (r4.g() == true) goto L33;
        r4.h(true);     // Catch: Exception -> L28
        return;
    L33:
        return;
    L22:
        if (this.displayCutoutInsetsHandler == r4) goto L25;
    L28:
        e = move-exception;
        tt5.a.l(TAG, "updateDisplayCutoutAvoidance failed", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.orientation.UnspecifiedOrientationPlugin
    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        this.mOrientationTipPresenter = new com.bytedance.ee.bear.document.orientation.e(new a(this));
        BaseSensorOrientationDetectorPlugin<?> r4 = this.mSensorDetectorPlugin;
        if (r4 == null) goto L5;
        MutableLiveData<ru5.d> r5 = r4.getOrientation();
        this.mSensorOrientationState = r5;
        r5.observe(getLifecycleOwner(), new f(this));
    L5:
        this.mOrientationViewModel.getLocked().observe(getLifecycleOwner(), new b(this));
        this.mOrientationViewModel.getPanels().observe(getLifecycleOwner(), new g(this));
        BaseSelectionPlugin r6 = (BaseSelectionPlugin) findPlugin(BaseSelectionPlugin.class);
        if (r6 == null) goto L8;
        r6.registerActionModeObserver(this.mOrientationTipPresenter);
    L8:
        ((DocumentPluginHost) getHost()).getDocumentLoader().S3(new c(this));
    }

    @Override // com.bytedance.ee.bear.document.orientation.UnspecifiedOrientationPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        updateDisplayCutoutAvoidance(isLandscape(r3));
        this.mOrientationTipPresenter.e();
        if (this.mOrientationViewModel.isLock() == true) goto L5;
        return;
    L5:
        if (isVCFollow() == false) goto L7;
        return;
    L7:
        if (this.enableOrientationTipsFromJs == true) goto L9;
        return;
    L9:
        if (canShowTips() == false) goto L26;
        ru5.d r4 = (ru5.d) this.mSensorDetectorPlugin.getOrientation().getValue();
        if (r4 != null) goto L13;
        return;
    L13:
        if (r4.isLandscape() == false) goto L18;
        if (getResources().getConfiguration().orientation != 1) goto L18;
        this.mOrientationTipPresenter.i(r4.a());
        return;
    L18:
        if (r4.isLandscape() == false) goto L20;
        return;
    L20:
        if (getResources().getConfiguration().orientation != 2) goto L30;
        this.mOrientationTipPresenter.j(r4.a());
        return;
    L30:
        return;
    }

    public void onResume(DocumentPluginHost r1) {
        super.onResume(r1);
        com.bytedance.ee.bear.document.orientation.e r2 = this.mOrientationTipPresenter;
        if (r2 == null) goto L6;
        r2.g();
        return;
    }

    public void setIOrientationEvent(e r1) {
        this.mIOrientationEvent = r1;
    }

    @Override // com.bytedance.ee.bear.document.orientation.UnspecifiedOrientationPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onResume(PluginHost r1) {
        onResume((DocumentPluginHost) r1);
    }

    public static /* synthetic */ boolean access$402(DocsUnspecifiedOrientationPlugin r0, boolean r1) {
        r0.isLoading = r1;
        return r1;
    }

    @Override // com.bytedance.ee.bear.document.orientation.CommonOrientationPlugin
    public void handleOrientationFromJs(CommonOrientationPlugin.LandscapeControlMeta r1, tb5.m r2) {
        super.handleOrientationFromJs(r1, r2);
        if (r1 == null) goto L9;
        boolean r3 = r1.getEnableOrientationTip();
        this.enableOrientationTipsFromJs = r3;
        if (r3 == false) goto L7;
        this.mOrientationTipPresenter.d();
        return;
    L7:
        this.mOrientationTipPresenter.c();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.orientation.UnspecifiedOrientationPlugin, com.bytedance.ee.bear.document.orientation.CommonOrientationPlugin
    public void onAttachToUIContainer(DocumentPluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onAttachToUIContainer(r2, r3);
        r2.getDocumentLoader().S3(this);
        View r4 = getUIContainer().b(this, 2131564575);
        com.bytedance.ee.bear.document.orientation.e r5 = this.mOrientationTipPresenter;
        r5.getClass();
        r5.d = new com.bytedance.ee.bear.document.orientation.e.d(r4);
        if (ForsetiHelper.s(((DocumentPluginHost) getHost()).c()) == true) goto L5;
    L7:
        updateDisplayCutoutAvoidance(isLandscape(getResources().getConfiguration()));
        return;
    L5:
        if (ForsetiHelper.e() == false) goto L7;
        this.mOrientationTipPresenter.f();
        goto L7
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onDetachFromUIContainer(r1, r2);
        restoreDisplayCutoutAvoidance();
        r1.getDocumentLoader().S(this);
    }

    @Override // com.bytedance.ee.bear.document.orientation.UnspecifiedOrientationPlugin, com.bytedance.ee.bear.document.orientation.CommonOrientationPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
