package com.bytedance.ee.bear.document.orientation;

import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: classes16.dex */
public interface BaseUnspecifiedOrientationPlugin<H extends PluginHost> extends com.bytedance.ee.bear.browser.plugin.f<H> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static void $default$disableTips(BaseUnspecifiedOrientationPlugin r100) {
        }

        public static void $default$enableTips(BaseUnspecifiedOrientationPlugin r100) {
        }

        public static void $default$forceLandscape(BaseUnspecifiedOrientationPlugin r100) {
        }

        public static void $default$forceLandscapeAndLock(BaseUnspecifiedOrientationPlugin r100) {
        }

        public static void $default$forcePortrait(BaseUnspecifiedOrientationPlugin r100) {
        }

        public static void $default$forcePortraitAndLock(BaseUnspecifiedOrientationPlugin r100) {
        }

        public static OrientationViewModel $default$getOrientationViewModel(BaseUnspecifiedOrientationPlugin r100) {
            return null;
        }

        public static boolean $default$isLandscapeDisabled(BaseUnspecifiedOrientationPlugin r100) {
            return false;
        }

        public static void $default$onOrientationSupportPanelDismiss(BaseUnspecifiedOrientationPlugin r100, p r101) {
        }

        public static void $default$onOrientationSupportPanelShowing(BaseUnspecifiedOrientationPlugin r100, p r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onPause(BaseUnspecifiedOrientationPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onResume(BaseUnspecifiedOrientationPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStart(BaseUnspecifiedOrientationPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStop(BaseUnspecifiedOrientationPlugin r100, PluginHost r101) {
        }

        public static void $default$setAnalyticSource(BaseUnspecifiedOrientationPlugin r100, String r101) {
        }

        public static void $default$toggleDeviceOrientation(BaseUnspecifiedOrientationPlugin r100) {
        }
    }

    void disableTips();

    void enableTips();

    void forceLandscape();

    void forceLandscapeAndLock();

    void forcePortrait();

    void forcePortraitAndLock();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ H getHost();

    OrientationViewModel getOrientationViewModel();

    boolean isLandscapeDisabled();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ boolean isViewImmersive();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToHost(H r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToUIContainer(H r100, com.bytedance.ee.bear.browser.plugin.t r101);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onConfigurationChanged(Configuration r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromHost(H r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromUIContainer(H r100, com.bytedance.ee.bear.browser.plugin.t r101);

    void onOrientationSupportPanelDismiss(p r100);

    void onOrientationSupportPanelShowing(p r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onPause(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onResume(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStart(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStop(PluginHost r100);

    void setAnalyticSource(String r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void setUserVisibleHint(boolean r100);

    void toggleDeviceOrientation();
}
