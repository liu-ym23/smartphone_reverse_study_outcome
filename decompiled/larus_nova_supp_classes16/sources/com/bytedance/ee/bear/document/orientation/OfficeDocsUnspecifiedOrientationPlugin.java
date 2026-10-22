package com.bytedance.ee.bear.document.orientation;

import android.content.res.Configuration;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin;
import com.bytedance.ee.bear.document.x2;
import com.bytedance.ee.bear.sheet.orientation.OfficeSheetUnspecifiedOrientationPlugin;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import ew4.b0;
import java.util.Stack;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeDocsUnspecifiedOrientationPlugin extends OfficeUnspecifiedOrientationPlugin implements x2.b {
    private static final String TAG = "DocsUnspecifiedOrientat";
    private boolean enableOrientationTipsFromJs;
    private boolean isLoading;
    private d mIOrientationEvent;
    private b0 mOrientationConfig;
    private e mOrientationTipPresenter;
    private LiveData<ru5.d> mSensorOrientationState;

    public class a implements e.c {
        public final /* synthetic */ OfficeDocsUnspecifiedOrientationPlugin a;

        @Override // com.bytedance.ee.bear.document.orientation.e.c
        public final int a() {
            int r0 = this.a.orientationController.a();
            tt5.a.h(OfficeDocsUnspecifiedOrientationPlugin.TAG, "getRequestedOrientation() called orientation:" + r0);
            return r0;
        }

        @Override // com.bytedance.ee.bear.document.orientation.e.c
        public final void c() {
            if (this.a.getWeb() == null) goto L8;
            ChameleonWebView r0 = this.a.getWeb().getWebView();
            if ((r0 instanceof ChameleonWebView) == false) goto L9;
            r0.c();
            return;
        L9:
            return;
        }

        @Override // com.bytedance.ee.bear.document.orientation.e.c
        public final void d() {
            tt5.a.h(OfficeDocsUnspecifiedOrientationPlugin.TAG, "switchPortrait() called");
            if (OfficeDocsUnspecifiedOrientationPlugin.access$000(this.a) == null) goto L5;
            OfficeSheetUnspecifiedOrientationPlugin.access$100(OfficeDocsUnspecifiedOrientationPlugin.access$000(this.a).a).setSource("sheet_m_portrait_button");
        L5:
            this.a.orientationController.b(1);
            this.a.mOrientationViewModel.setRequestOrientation(1);
        }

        @Override // com.bytedance.ee.bear.document.orientation.e.c
        public final void f() {
            tt5.a.h(OfficeDocsUnspecifiedOrientationPlugin.TAG, "clearRequestedOrientation() called");
            k r0 = this.a.orientationController;
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

        @Override // com.bytedance.ee.bear.document.orientation.e.c
        public final Fragment getHostFragment() {
            return this.a.getHost().fragment;
        }

        public a(OfficeDocsUnspecifiedOrientationPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.orientation.e.c
        public final void b(int r3) {
            tt5.a.h(OfficeDocsUnspecifiedOrientationPlugin.TAG, "setRequestedOrientation() called：" + r3);
            this.a.orientationController.b(r3);
        }

        @Override // com.bytedance.ee.bear.document.orientation.e.c
        public final void e(boolean r3) {
            tt5.a.h(OfficeDocsUnspecifiedOrientationPlugin.TAG, "switchLandscape() called with: reverse = [" + r3 + "]");
            if (OfficeDocsUnspecifiedOrientationPlugin.access$000(this.a) == null) goto L5;
            OfficeSheetUnspecifiedOrientationPlugin.access$200(OfficeDocsUnspecifiedOrientationPlugin.access$000(this.a).a).setSource("sheet_m_landscape_button");
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
        public final /* synthetic */ OfficeDocsUnspecifiedOrientationPlugin b;

        public b(OfficeDocsUnspecifiedOrientationPlugin r1) {
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
            OfficeDocsUnspecifiedOrientationPlugin.access$100(this.b).e();
            if (Boolean.TRUE.equals(this.b.mOrientationViewModel.getEnable().getValue()) == false) goto L9;
            this.b.orientationController.b(-1);
            this.b.mOrientationViewModel.setRequestOrientation(-1);
            goto L9
        }
    }

    public class c implements x2.b {
        public final /* synthetic */ OfficeDocsUnspecifiedOrientationPlugin a;

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onLoadCancel() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final /* synthetic */ void onSSRLoadSuccess() {
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadStart() {
            OfficeDocsUnspecifiedOrientationPlugin.access$202(this.a, true);
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadSuccess() {
            OfficeDocsUnspecifiedOrientationPlugin.access$202(this.a, false);
        }

        public c(OfficeDocsUnspecifiedOrientationPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.document.x2.b
        public final void onLoadFail(int r1, Throwable r2) {
            OfficeDocsUnspecifiedOrientationPlugin.access$202(this.a, false);
        }
    }

    public interface d {
    }

    public static /* synthetic */ void e(OfficeDocsUnspecifiedOrientationPlugin r0, Stack r1) {
        r0.lambda$onAttachToHost$1(r1);
    }

    public static /* synthetic */ void f(OfficeDocsUnspecifiedOrientationPlugin r0, ru5.d r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public /* bridge */ /* synthetic */ void onLoadCancel() {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadFail(int r1, Throwable r2) {
    }

    @Override // com.bytedance.ee.bear.document.orientation.OfficeUnspecifiedOrientationPlugin, com.bytedance.ee.bear.document.orientation.OfficeCommonOrientationPlugin, com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public /* bridge */ /* synthetic */ void onSSRLoadSuccess() {
    }

    public boolean canShowTips() {
        b0 r0 = this.mOrientationConfig;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.l0() == true) goto L8;
        return false;
    }

    @Override // com.bytedance.ee.bear.document.orientation.OfficeUnspecifiedOrientationPlugin, com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public void disableTips() {
        this.mOrientationTipPresenter.c();
    }

    @Override // com.bytedance.ee.bear.document.orientation.OfficeUnspecifiedOrientationPlugin, com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public void enableTips() {
        this.mOrientationTipPresenter.d();
    }

    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadStart() {
        this.mOrientationTipPresenter.c();
    }

    public OfficeDocsUnspecifiedOrientationPlugin() {
        this.enableOrientationTipsFromJs = true;
    }

    @Override // com.bytedance.ee.bear.document.orientation.OfficeUnspecifiedOrientationPlugin, com.bytedance.ee.bear.document.orientation.OfficeCommonOrientationPlugin, com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.x2.b
    public void onLoadSuccess() {
        if (com.bytedance.ee.util.ui.n.D(getActivity()) == true) goto L6;
        this.mOrientationTipPresenter.d();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.orientation.OfficeUnspecifiedOrientationPlugin
    public boolean shouldOverrideOrientationPerforming() {
        int r0 = getActivity().getRequestedOrientation();
        if (r0 == 8) goto L8;
        if (r0 == 0) goto L8;
        return super.shouldOverrideOrientationPerforming();
    L8:
        this.mOrientationViewModel.setRequestOrientation(r0);
        return true;
    }

    public static /* synthetic */ d access$000(OfficeDocsUnspecifiedOrientationPlugin r0) {
        return r0.mIOrientationEvent;
    }

    public static /* synthetic */ e access$100(OfficeDocsUnspecifiedOrientationPlugin r0) {
        return r0.mOrientationTipPresenter;
    }

    private void lambda$onAttachToHost$0(ru5.d r3) {
        if (r3 != null) goto L6;
        if (this.isLoading == false) goto L6;
        return;
    L6:
        if (canShowTips() == false) goto L16;
        OfficeSheetUnspecifiedOrientationPlugin.a r0 = this.mIOrientationEvent;
        if (r0 == null) goto L12;
        OfficeSheetUnspecifiedOrientationPlugin.access$300(r0.a).setSource("mobile_rotation");
    L12:
        if (r3.isLandscape() == false) goto L14;
        onOrientationChangedToLandscape(r3.a());
        return;
    L14:
        onOrientationChangedToPortrait(r3.a());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
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

    /* JADX WARN: Multi-variable type inference failed */
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
        OfficeSheetUnspecifiedOrientationPlugin.a r4 = this.mIOrientationEvent;
        if (r4 == null) goto L18;
        OfficeSheetUnspecifiedOrientationPlugin.access$000(r4.a).b("show_landscape_btn");
        return;
    L18:
        return;
    L13:
        this.mOrientationTipPresenter.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
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
        e r4 = this.mOrientationTipPresenter;
        if (getActivity().getRequestedOrientation() != 8) goto L14;
        boolean r0 = true;
    L15:
        r4.j(r0);
        OfficeSheetUnspecifiedOrientationPlugin.a r5 = this.mIOrientationEvent;
        if (r5 == null) goto L23;
        OfficeSheetUnspecifiedOrientationPlugin.access$000(r5.a).b("show_portrait_btn");
        return;
    L23:
        return;
    L14:
        r0 = false;
    L18:
        this.mOrientationTipPresenter.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.orientation.OfficeUnspecifiedOrientationPlugin
    public void onAttachToHost(ChameleonPluginHost r3) {
        super.onAttachToHost(r3);
        this.mOrientationConfig = (b0) r3.getUserComponent().a(b0.class);
        this.mOrientationTipPresenter = new e(new a(this));
        BaseSensorOrientationDetectorPlugin<?> r4 = this.mSensorDetectorPlugin;
        if (r4 == null) goto L5;
        MutableLiveData<ru5.d> r5 = r4.getOrientation();
        this.mSensorOrientationState = r5;
        r5.observe(getLifecycleOwner(), new i(this));
    L5:
        this.mOrientationViewModel.getLocked().observe(getLifecycleOwner(), new b(this));
        this.mOrientationViewModel.getPanels().observe(getLifecycleOwner(), new j(this));
        BaseSelectionPlugin r6 = (BaseSelectionPlugin) findPlugin(BaseSelectionPlugin.class);
        if (r6 == null) goto L8;
        r6.registerActionModeObserver(this.mOrientationTipPresenter);
    L8:
        x2 r7 = getDocumentLoader();
        if (r7 == null) goto L12;
        r7.S3(new c(this));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.orientation.OfficeUnspecifiedOrientationPlugin, com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
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

    public void onResume(ChameleonPluginHost r1) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onResume(r1);
        e r2 = this.mOrientationTipPresenter;
        if (r2 == null) goto L6;
        r2.g();
        return;
    }

    public void setIOrientationEvent(d r1) {
        this.mIOrientationEvent = r1;
    }

    @Override // com.bytedance.ee.bear.document.orientation.OfficeUnspecifiedOrientationPlugin, com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onResume(PluginHost r1) {
        onResume((ChameleonPluginHost) r1);
    }

    public static /* synthetic */ boolean access$202(OfficeDocsUnspecifiedOrientationPlugin r0, boolean r1) {
        r0.isLoading = r1;
        return r1;
    }

    @Override // com.bytedance.ee.bear.document.orientation.OfficeCommonOrientationPlugin
    public void handleOrientationFromJs(OfficeCommonOrientationPlugin.LandscapeControlMeta r1, tb5.m r2) {
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
    @Override // com.bytedance.ee.bear.document.orientation.OfficeUnspecifiedOrientationPlugin, com.bytedance.ee.bear.document.orientation.OfficeCommonOrientationPlugin
    public void onAttachToUIContainer(ChameleonPluginHost r2, com.bytedance.ee.bear.browser.plugin.t r3) {
        super.onAttachToUIContainer(r2, r3);
        x2 r4 = getDocumentLoader();
        if (r4 == null) goto L5;
        r4.S3(this);
    L5:
        View r5 = getUIContainer().b(this, 2131564575);
        e r6 = this.mOrientationTipPresenter;
        r6.getClass();
        r6.d = new e.d(r5);
        if (ForsetiHelper.s(getHost().fragment) == true) goto L8;
        return;
    L8:
        if (ForsetiHelper.e() == false) goto L12;
        this.mOrientationTipPresenter.f();
        return;
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        x2 r3 = getDocumentLoader();
        if (r3 == null) goto L6;
        r3.S(this);
        return;
    }

    @Override // com.bytedance.ee.bear.document.orientation.OfficeUnspecifiedOrientationPlugin, com.bytedance.ee.bear.document.orientation.OfficeCommonOrientationPlugin, com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
