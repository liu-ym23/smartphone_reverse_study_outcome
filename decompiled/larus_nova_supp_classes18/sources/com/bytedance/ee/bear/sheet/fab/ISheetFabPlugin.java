package com.bytedance.ee.bear.sheet.fab;

import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface ISheetFabPlugin<H extends PluginHost> extends com.bytedance.ee.bear.browser.plugin.f<H> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.sheet.fab.ISheetFabPlugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static /* bridge */ /* synthetic */ void $default$onPause(ISheetFabPlugin r0, PluginHost r1) {
        }

        public static /* bridge */ /* synthetic */ void $default$onResume(ISheetFabPlugin r0, PluginHost r1) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStart(ISheetFabPlugin r0, PluginHost r1) {
        }

        public static /* bridge */ /* synthetic */ void $default$onStop(ISheetFabPlugin r0, PluginHost r1) {
        }
    }

    /* synthetic */ H getHost();

    /* synthetic */ boolean isViewImmersive();

    /* synthetic */ void onAttachToHost(H r1);

    /* synthetic */ void onAttachToUIContainer(H r1, com.bytedance.ee.bear.browser.plugin.t r2);

    /* synthetic */ void onConfigurationChanged(Configuration r1);

    /* synthetic */ void onDetachFromHost(H r1);

    /* synthetic */ void onDetachFromUIContainer(H r1, com.bytedance.ee.bear.browser.plugin.t r2);

    /* bridge */ /* synthetic */ void onPause(PluginHost r1);

    /* bridge */ /* synthetic */ void onResume(PluginHost r1);

    /* bridge */ /* synthetic */ void onStart(PluginHost r1);

    /* bridge */ /* synthetic */ void onStop(PluginHost r1);

    void setEditButtonVisibilityFromNative(boolean r1);

    void setSheetFabMargin(int r1, int r2, int r3, int r4);

    /* synthetic */ void setUserVisibleHint(boolean r1);
}
