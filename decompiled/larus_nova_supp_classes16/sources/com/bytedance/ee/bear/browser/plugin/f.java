package com.bytedance.ee.bear.browser.plugin;

import android.content.res.Configuration;
import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface f<H extends PluginHost> {
    H getHost();

    boolean isViewImmersive();

    void onAttachToHost(H r1);

    void onAttachToUIContainer(H r1, t r2);

    void onConfigurationChanged(Configuration r1);

    void onDetachFromHost(H r1);

    void onDetachFromUIContainer(H r1, t r2);

    void onPause(H r1);

    void onResume(H r1);

    void onStart(H r1);

    void onStop(H r1);

    void setUserVisibleHint(boolean r1);
}
