package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.content.res.Configuration;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginHost;

/* JADX INFO: loaded from: classes35.dex */
public interface Plugin<H extends PluginHost> {

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.pluginsystem.plugin.Plugin$-CC, reason: invalid class name */
    public final /* synthetic */ class CC<H extends PluginHost> {
        public static void $default$onPause(Plugin r100, PluginHost r101) {
        }

        public static void $default$onResume(Plugin r100, PluginHost r101) {
        }

        public static void $default$onStart(Plugin r100, PluginHost r101) {
        }

        public static void $default$onStop(Plugin r100, PluginHost r101) {
        }
    }

    H getHost();

    boolean isViewImmersive();

    void onAttachToHost(H r100);

    void onAttachToUIContainer(H r100, UIContainer r101);

    void onConfigurationChanged(Configuration r100);

    void onDetachFromHost(H r100);

    void onDetachFromUIContainer(H r100, UIContainer r101);

    void onPause(H r100);

    void onResume(H r100);

    void onStart(H r100);

    void onStop(H r100);

    void setUserVisibleHint(boolean r100);
}
