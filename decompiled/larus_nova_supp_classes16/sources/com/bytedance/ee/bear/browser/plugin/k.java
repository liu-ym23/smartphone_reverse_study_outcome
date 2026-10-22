package com.bytedance.ee.bear.browser.plugin;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k implements PluginHost.a {
    public k() {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final /* synthetic */ ViewGroup getContainer(int r1) {
        return null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final /* synthetic */ Fragment getHostFragment() {
        return null;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final vo5.a ej() {
        return new h(this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public FragmentActivity getActivity() {
        throw new IllegalStateException("not support");
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final LifecycleOwner getLifecycleOwner() {
        throw new IllegalStateException("not support");
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final o getPluginListProvider() {
        throw new IllegalStateException("not support");
    }
}
