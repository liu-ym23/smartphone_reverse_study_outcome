package com.bytedance.ee.bear.document.plugin.selection;

import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: classes16.dex */
public interface BaseSelectionPlugin<H extends PluginHost> extends com.bytedance.ee.bear.browser.plugin.f<H> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.plugin.selection.BaseSelectionPlugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static void $default$jsClearDocxSelection(BaseSelectionPlugin r100) {
        }

        public static /* bridge */ /* synthetic */ void $default$onPause(BaseSelectionPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onResume(BaseSelectionPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStart(BaseSelectionPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStop(BaseSelectionPlugin r100, PluginHost r101) {
        }
    }

    void addMenuItemClickListener(d r100);

    void clearSelection();

    void closeActionMode();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ H getHost();

    boolean isShowingActionMode();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ boolean isViewImmersive();

    void jsClearDocxSelection();

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

    void registerActionModeObserver(a r100);

    void removeMenuItemClickListener(d r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void setUserVisibleHint(boolean r100);

    void unregisterActionModeObserver(a r100);
}
