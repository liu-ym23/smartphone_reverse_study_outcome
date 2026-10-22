package com.bytedance.ee.bear.document.orientation;

import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface BaseUnspecifiedOrientationPlugin<H extends PluginHost> extends com.bytedance.ee.bear.browser.plugin.f<H> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static void $default$disableTips(BaseUnspecifiedOrientationPlugin r0) {
        }

        public static void $default$enableTips(BaseUnspecifiedOrientationPlugin r0) {
        }

        public static void $default$forceLandscape(BaseUnspecifiedOrientationPlugin r0) {
        }

        public static void $default$forceLandscapeAndLock(BaseUnspecifiedOrientationPlugin r0) {
        }

        public static void $default$forcePortrait(BaseUnspecifiedOrientationPlugin r0) {
        }

        public static void $default$forcePortraitAndLock(BaseUnspecifiedOrientationPlugin r0) {
        }

        public static OrientationViewModel $default$getOrientationViewModel(BaseUnspecifiedOrientationPlugin r0) {
            return null;
        }

        public static boolean $default$isLandscapeDisabled(BaseUnspecifiedOrientationPlugin r0) {
            return false;
        }

        public static void $default$onOrientationSupportPanelDismiss(BaseUnspecifiedOrientationPlugin r0, p r1) {
        }

        public static void $default$onOrientationSupportPanelShowing(BaseUnspecifiedOrientationPlugin r0, p r1) {
        }

        public static /* bridge */ /* synthetic */ void $default$onPause(BaseUnspecifiedOrientationPlugin r0, PluginHost r1) {
        }

        public static /* bridge */ /* synthetic */ void $default$onResume(BaseUnspecifiedOrientationPlugin r0, PluginHost r1) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStart(BaseUnspecifiedOrientationPlugin r0, PluginHost r1) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStop(BaseUnspecifiedOrientationPlugin r0, PluginHost r1) {
        }

        public static void $default$setAnalyticSource(BaseUnspecifiedOrientationPlugin r0, String r1) {
        }

        public static void $default$toggleDeviceOrientation(BaseUnspecifiedOrientationPlugin r0) {
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
    /* synthetic */ void onAttachToHost(H r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToUIContainer(H r1, com.bytedance.ee.bear.browser.plugin.t r2);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onConfigurationChanged(Configuration r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromHost(H r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromUIContainer(H r1, com.bytedance.ee.bear.browser.plugin.t r2);

    void onOrientationSupportPanelDismiss(p r1);

    void onOrientationSupportPanelShowing(p r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onPause(PluginHost r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onResume(PluginHost r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStart(PluginHost r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStop(PluginHost r1);

    void setAnalyticSource(String r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void setUserVisibleHint(boolean r1);

    void toggleDeviceOrientation();
}
