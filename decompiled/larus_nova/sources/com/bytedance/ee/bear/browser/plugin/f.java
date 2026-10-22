package com.bytedance.ee.bear.browser.plugin;

import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: classes16.dex */
public interface f<H extends PluginHost> {
    H getHost();

    boolean isViewImmersive();

    void onAttachToHost(H r100);

    void onAttachToUIContainer(H r100, t r101);

    void onConfigurationChanged(Configuration r100);

    void onDetachFromHost(H r100);

    void onDetachFromUIContainer(H r100, t r101);

    void onPause(H r100);

    void onResume(H r100);

    void onStart(H r100);

    void onStop(H r100);

    void setUserVisibleHint(boolean r100);
}
