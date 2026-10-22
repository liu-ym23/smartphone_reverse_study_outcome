package com.bytedance.ee.bear.document.orientation;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/document/orientation/OfficePortraitOrientationPlugin;", "Lcom/bytedance/ee/bear/document/orientation/OfficeCommonOrientationPlugin;", "Lcom/bytedance/ee/bear/document/orientation/BaseUnspecifiedOrientationPlugin;", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "<init>", "()V", "onAttachToHost", "", "host", "forcePortrait", "forceLandscape", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficePortraitOrientationPlugin extends OfficeCommonOrientationPlugin implements BaseUnspecifiedOrientationPlugin<ChameleonPluginHost> {
    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public final /* synthetic */ void disableTips() {
        BaseUnspecifiedOrientationPlugin.CC.$default$disableTips(this);
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public final /* synthetic */ void enableTips() {
        BaseUnspecifiedOrientationPlugin.CC.$default$enableTips(this);
    }

    @Override // com.bytedance.ee.bear.document.orientation.OfficeCommonOrientationPlugin, com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public void forceLandscape() {
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public final /* synthetic */ void forceLandscapeAndLock() {
        BaseUnspecifiedOrientationPlugin.CC.$default$forceLandscapeAndLock(this);
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public final /* synthetic */ void forcePortraitAndLock() {
        BaseUnspecifiedOrientationPlugin.CC.$default$forcePortraitAndLock(this);
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public final /* synthetic */ OrientationViewModel getOrientationViewModel() {
        return BaseUnspecifiedOrientationPlugin.CC.$default$getOrientationViewModel(this);
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public final /* synthetic */ boolean isLandscapeDisabled() {
        return BaseUnspecifiedOrientationPlugin.CC.$default$isLandscapeDisabled(this);
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public final /* synthetic */ void onOrientationSupportPanelDismiss(p r1) {
        BaseUnspecifiedOrientationPlugin.CC.$default$onOrientationSupportPanelDismiss(this, r1);
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public final /* synthetic */ void onOrientationSupportPanelShowing(p r1) {
        BaseUnspecifiedOrientationPlugin.CC.$default$onOrientationSupportPanelShowing(this, r1);
    }

    @Override // com.bytedance.ee.bear.document.orientation.OfficeCommonOrientationPlugin, com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public final /* synthetic */ void setAnalyticSource(String r1) {
        BaseUnspecifiedOrientationPlugin.CC.$default$setAnalyticSource(this, r1);
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public final /* synthetic */ void toggleDeviceOrientation() {
        BaseUnspecifiedOrientationPlugin.CC.$default$toggleDeviceOrientation(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.document.orientation.OfficeCommonOrientationPlugin, com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin
    public void forcePortrait() {
        getActivity().setRequestedOrientation(1);
    }

    public OfficePortraitOrientationPlugin() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        if (yo5.a.a(getActivity()) == false) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        forcePortrait();
        return;
    L12:
        return;
    L5:
        if (com.ss.android.lark.base.embedded.b.g() == true) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }
}
