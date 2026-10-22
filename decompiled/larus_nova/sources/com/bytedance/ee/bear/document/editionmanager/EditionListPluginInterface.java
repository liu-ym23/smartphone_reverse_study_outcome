package com.bytedance.ee.bear.document.editionmanager;

import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.t;

/* JADX INFO: loaded from: classes16.dex */
public interface EditionListPluginInterface extends f<PluginHost> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.editionmanager.EditionListPluginInterface$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ void $default$onPause(EditionListPluginInterface r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onResume(EditionListPluginInterface r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStart(EditionListPluginInterface r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStop(EditionListPluginInterface r100, PluginHost r101) {
        }
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ PluginHost getHost();

    void handleEventDelete();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ boolean isViewImmersive();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToHost(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onConfigurationChanged(Configuration r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromHost(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onPause(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onResume(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStart(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStop(PluginHost r100);

    void recoverEdition();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void setUserVisibleHint(boolean r100);
}
