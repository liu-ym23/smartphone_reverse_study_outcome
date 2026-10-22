package com.bytedance.ee.bear.doc.structure;

import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.t;

/* JADX INFO: loaded from: classes16.dex */
public interface IFloatingStructurePlugin<H extends PluginHost> extends f<H> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.doc.structure.IFloatingStructurePlugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static /* bridge */ /* synthetic */ void $default$onPause(IFloatingStructurePlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onResume(IFloatingStructurePlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStart(IFloatingStructurePlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStop(IFloatingStructurePlugin r100, PluginHost r101) {
        }
    }

    public interface a {
    }

    a getFloatingStructureDelegate();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ H getHost();

    boolean isFloatingStructureShowing();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ boolean isViewImmersive();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToHost(H r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToUIContainer(H r100, t r101);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onConfigurationChanged(Configuration r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromHost(H r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromUIContainer(H r100, t r101);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onPause(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onResume(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStart(PluginHost r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStop(PluginHost r100);

    void setFloatingStructureDelegate(a r100);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void setUserVisibleHint(boolean r100);
}
