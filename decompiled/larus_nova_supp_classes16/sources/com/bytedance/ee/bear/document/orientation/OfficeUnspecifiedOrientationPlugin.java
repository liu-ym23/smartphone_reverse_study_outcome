package com.bytedance.ee.bear.document.orientation;

import android.content.res.Configuration;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.contract.doc.DocsOpenSource;
import com.bytedance.ee.bear.document.toolbar.editpanels.EditPanelsManager;
import com.bytedance.ee.util.observer.IgnoreInitialObserver;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Stack;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeUnspecifiedOrientationPlugin extends OfficeCommonOrientationPlugin implements BaseUnspecifiedOrientationPlugin<ChameleonPluginHost> {
    private static final String TAG = "UnspecifiedOrientationPlugin";
    private IgnoreInitialObserver<ru5.d> mAfterForceSwicthOrientationObserver;
    private pcb.a mKeyboardHeightProvider;
    protected OrientationViewModel mOrientationViewModel;
    protected BaseSensorOrientationDetectorPlugin<?> mSensorDetectorPlugin;
    protected k orientationController;

    public class a extends IgnoreInitialObserver<ru5.d> {
        public final /* synthetic */ MutableLiveData b;
        public final /* synthetic */ OfficeUnspecifiedOrientationPlugin c;

        public final void a(Object r2) {
            ru5.d r3 = (ru5.d) r2;
            this.c.orientationController.b(-1);
            this.c.mOrientationViewModel.setRequestOrientation(-1);
            this.b.removeObserver(this);
        }

        public a(OfficeUnspecifiedOrientationPlugin r1, MutableLiveData r2) {
            this.c = r1;
            this.b = r2;
        }
    }

    public static /* synthetic */ void a(OfficeUnspecifiedOrientationPlugin r0, Stack r1) {
        r0.lambda$onAttachToHost$1(r1);
    }

    public static /* synthetic */ void c(OfficeUnspecifiedOrientationPlugin r0, EditPanelsManager r1) {
        r0.lambda$onConfigurationChanged$2(r1);
    }

    public static /* synthetic */ void d(OfficeUnspecifiedOrientationPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public /* synthetic */ void disableTips() {
        BaseUnspecifiedOrientationPlugin.CC.$default$disableTips(this);
    }

    public /* synthetic */ void enableTips() {
        BaseUnspecifiedOrientationPlugin.CC.$default$enableTips(this);
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public final /* synthetic */ void forcePortraitAndLock() {
        BaseUnspecifiedOrientationPlugin.CC.$default$forcePortraitAndLock(this);
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public final /* synthetic */ boolean isLandscapeDisabled() {
        return BaseUnspecifiedOrientationPlugin.CC.$default$isLandscapeDisabled(this);
    }

    @Override // com.bytedance.ee.bear.document.orientation.OfficeCommonOrientationPlugin, com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public boolean shouldOverrideOrientationPerforming() {
        return false;
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public final /* synthetic */ void toggleDeviceOrientation() {
        BaseUnspecifiedOrientationPlugin.CC.$default$toggleDeviceOrientation(this);
    }

    private void initObserver() {
        BaseSensorOrientationDetectorPlugin<?> r0 = this.mSensorDetectorPlugin;
        if (r0 == null) goto L6;
        this.mAfterForceSwicthOrientationObserver = new a(this, r0.getOrientation());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setOrientation() {
        if (Boolean.TRUE.equals(this.mOrientationViewModel.getEnable().getValue()) == true) goto L20;
        if (ForsetiHelper.s(getHost().fragment) == false) goto L10;
        if (ku5.c.k(getContext()) == true) goto L20;
    L10:
        if (ku5.c.k(getContext()) == true) goto L12;
    L13:
        tt5.a.h(TAG, "force portrait");
        if (ForsetiHelper.s(getHost().fragment) == false) goto L18;
        int r0 = this.orientationController.a();
        tt5.a.h(TAG, "currentOrientation: " + r0);
        if (r0 == 1) goto L26;
        this.mOrientationViewModel.setRequestOrientation(r0);
        this.orientationController.b(1);
        return;
    L26:
        return;
    L18:
        this.mOrientationViewModel.setRequestOrientation(getActivity().getRequestedOrientation());
        this.orientationController.b(1);
        return;
    L12:
        if (ku5.c.l() == false) goto L13;
        return;
    L20:
        if (getDocViewModel().getOpenSource() != DocsOpenSource.vc) goto L22;
        return;
    L22:
        if (((Boolean) this.mOrientationViewModel.getLocked().getValue()).booleanValue() == true) goto L30;
        tt5.a.h(TAG, "restore orientation, current orientation is " + this.mOrientationViewModel.getRequestOrientation());
        this.orientationController.b(this.mOrientationViewModel.getRequestOrientation());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.orientation.OfficeCommonOrientationPlugin, com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public void forceLandscape() {
        this.orientationController.b(0);
        this.mOrientationViewModel.setRequestOrientation(0);
        if (this.mOrientationViewModel.isLock() == false) goto L5;
        return;
    L5:
        if (this.mAfterForceSwicthOrientationObserver == null) goto L9;
        MutableLiveData<ru5.d> r0 = this.mSensorDetectorPlugin.getOrientation();
        r0.removeObserver(this.mAfterForceSwicthOrientationObserver);
        this.mAfterForceSwicthOrientationObserver.a = null;
        r0.observe(getLifecycleOwner(), this.mAfterForceSwicthOrientationObserver);
        return;
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public void forceLandscapeAndLock() {
        this.orientationController.b(0);
        this.mOrientationViewModel.setRequestOrientation(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.orientation.OfficeCommonOrientationPlugin, com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public void forcePortrait() {
        this.orientationController.b(1);
        this.mOrientationViewModel.setRequestOrientation(1);
        if (this.mOrientationViewModel.isLock() == false) goto L5;
    L9:
        setSupportLandscape(true);
        return;
    L5:
        if (this.mAfterForceSwicthOrientationObserver == null) goto L9;
        if (getSupportLandscape() == false) goto L9;
        MutableLiveData<ru5.d> r0 = this.mSensorDetectorPlugin.getOrientation();
        r0.removeObserver(this.mAfterForceSwicthOrientationObserver);
        this.mAfterForceSwicthOrientationObserver.a = null;
        r0.observe(getLifecycleOwner(), this.mAfterForceSwicthOrientationObserver);
        goto L9
    }

    public OfficeUnspecifiedOrientationPlugin() {
        this.mAfterForceSwicthOrientationObserver = null;
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public OrientationViewModel getOrientationViewModel() {
        return this.mOrientationViewModel;
    }

    private /* synthetic */ void lambda$onAttachToHost$0(Boolean r1) {
        setOrientation();
    }

    private /* synthetic */ void lambda$onAttachToHost$1(Stack r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.empty() == false) goto L7;
    L9:
        this.mOrientationViewModel.enable();
        return;
    L7:
        if (((p) r2.peek()).shouldDisableLandscape() == false) goto L9;
        this.mOrientationViewModel.disable();
    }

    private /* synthetic */ void lambda$onConfigurationChanged$2(EditPanelsManager r2) {
        r2.onConfigurationChanged(this.mKeyboardHeightProvider);
        r2.requestUpdateWebContentHeight();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r4);
        this.orientationController = new k(r4);
        OrientationViewModel r0 = (OrientationViewModel) viewModel(OrientationViewModel.class);
        this.mOrientationViewModel = r0;
        r0.setRequestOrientation(getActivity().getRequestedOrientation());
        this.mKeyboardHeightProvider = pcb.a.a.b(getActivity());
        this.mSensorDetectorPlugin = (BaseSensorOrientationDetectorPlugin) findPlugin(BaseSensorOrientationDetectorPlugin.class);
        initObserver();
        this.mOrientationViewModel.registerLockObserver(getContext());
        this.mOrientationViewModel.getEnable().observe(getLifecycleOwner(), new n(this));
        this.mOrientationViewModel.getPanels().observe(getLifecycleOwner(), new o(this));
        if (ForsetiHelper.s(r4.fragment) == false) goto L6;
        this.orientationController.b(getActivity().getRequestedOrientation());
        return;
    }

    public void onConfigurationChanged(Configuration r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onConfigurationChanged(r4);
        int r5 = h35.a.a;
        final EditPanelsManager r6 = h35.a.a(getHost());
        com.bytedance.ee.util.ui.j.d(new m(this, r6), 500);
        if (ForsetiHelper.s(getHost().getFragment()) == true) goto L5;
        return;
    L5:
        if (ForsetiHelper.e() == false) goto L9;
        boolean r7 = getHost().getFragment().isResumed();
        tt5.a.h(TAG, "onConfigurationChanged: isResume:" + r7);
        if (r7 == false) goto L12;
        setOrientation();
        return;
    L12:
        return;
    L9:
        setOrientation();
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public void onOrientationSupportPanelDismiss(p r3) {
        tt5.a.h(TAG, "dismiss panel: " + r3);
        this.mOrientationViewModel.onOrientationSupportPanelDismiss(r3);
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public void onOrientationSupportPanelShowing(p r3) {
        tt5.a.h(TAG, "showing panel: " + r3);
        this.mOrientationViewModel.onOrientationSupportPanelShowing(r3);
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public void setAnalyticSource(String r2) {
        this.mOrientationViewModel.setSource(r2);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.document.orientation.OfficeCommonOrientationPlugin
    public void onAttachToUIContainer(ChameleonPluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        super.onAttachToUIContainer(r1, r2);
        if (shouldOverrideOrientationPerforming() == false) goto L5;
        return;
    L5:
        if (((Boolean) this.mOrientationViewModel.getLocked().getValue()).booleanValue() == true) goto L9;
        this.mOrientationViewModel.setRequestOrientation(-1);
        this.orientationController.b(-1);
        return;
    }

    @Override // com.bytedance.ee.bear.document.orientation.OfficeCommonOrientationPlugin, com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, com.bytedance.ee.bear.browser.plugin.t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }
}
