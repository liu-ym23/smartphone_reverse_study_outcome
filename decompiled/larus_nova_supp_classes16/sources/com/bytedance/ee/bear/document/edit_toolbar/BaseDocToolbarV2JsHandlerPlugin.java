package com.bytedance.ee.bear.document.edit_toolbar;

import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.model.toolbar.ToolbarV2;
import com.bytedance.ee.bear.edit.component.toolbar2.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface BaseDocToolbarV2JsHandlerPlugin<H extends PluginHost> extends com.bytedance.ee.bear.browser.plugin.f<H> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.edit_toolbar.BaseDocToolbarV2JsHandlerPlugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static /* bridge */ /* synthetic */ void $default$onPause(BaseDocToolbarV2JsHandlerPlugin r0, PluginHost r1) {
        }

        public static /* bridge */ /* synthetic */ void $default$onResume(BaseDocToolbarV2JsHandlerPlugin r0, PluginHost r1) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStart(BaseDocToolbarV2JsHandlerPlugin r0, PluginHost r1) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStop(BaseDocToolbarV2JsHandlerPlugin r0, PluginHost r1) {
        }
    }

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ H getHost();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ boolean isViewImmersive();

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToHost(H r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onAttachToUIContainer(H r1, t r2);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onConfigurationChanged(Configuration r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromHost(H r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void onDetachFromUIContainer(H r1, t r2);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onPause(PluginHost r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onResume(PluginHost r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStart(PluginHost r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* bridge */ /* synthetic */ void onStop(PluginHost r1);

    void registerHandler(c0<? extends ToolbarV2> r1);

    @Override // com.bytedance.ee.bear.browser.plugin.f
    /* synthetic */ void setUserVisibleHint(boolean r1);

    void unRegisterHandler(c0<? extends ToolbarV2> r1);
}
