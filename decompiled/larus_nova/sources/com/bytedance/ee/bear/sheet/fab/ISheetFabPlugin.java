package com.bytedance.ee.bear.sheet.fab;

import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: classes18.dex */
public interface ISheetFabPlugin<H extends PluginHost> extends com.bytedance.ee.bear.browser.plugin.f<H> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.sheet.fab.ISheetFabPlugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static /* bridge */ /* synthetic */ void $default$onPause(ISheetFabPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onResume(ISheetFabPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStart(ISheetFabPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStop(ISheetFabPlugin r100, PluginHost r101) {
        }
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ H getHost();

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

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onPause(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onResume(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStart(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStop(PluginHost r100);

    void setEditButtonVisibilityFromNative(boolean r100);

    void setSheetFabMargin(int r100, int r101, int r102, int r103);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void setUserVisibleHint(boolean r100);
}
