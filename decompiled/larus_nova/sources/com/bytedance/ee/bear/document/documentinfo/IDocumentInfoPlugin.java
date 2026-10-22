package com.bytedance.ee.bear.document.documentinfo;

import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.t;

/* JADX INFO: loaded from: classes16.dex */
public interface IDocumentInfoPlugin<H extends PluginHost> extends f<H> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.documentinfo.IDocumentInfoPlugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static /* bridge */ /* synthetic */ void $default$onPause(IDocumentInfoPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onResume(IDocumentInfoPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStart(IDocumentInfoPlugin r100, PluginHost r101) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStop(IDocumentInfoPlugin r100, PluginHost r101) {
        }
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ H getHost();

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

    void requestDocumentInfo();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void setUserVisibleHint(boolean r100);
}
