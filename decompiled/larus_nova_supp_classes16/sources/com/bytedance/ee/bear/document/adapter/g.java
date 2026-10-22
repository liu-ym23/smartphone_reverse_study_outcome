package com.bytedance.ee.bear.document.adapter;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.n;
import com.bytedance.ee.bear.browser.plugin.o;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements PluginHost.a {
    public final ChameleonPluginHost a;

    public static final class a implements o {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.browser.plugin.o
        public final n a(PluginHost r2) {
            return new n(new n.a[0]);
        }
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
        return new com.bytedance.ee.bear.browser.plugin.h(this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public FragmentActivity getActivity() {
        return this.a.getActivity();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final LifecycleOwner getLifecycleOwner() {
        return this.a.getLifecycleOwner();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final o getPluginListProvider() {
        return a.a;
    }

    public g(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "chameleonHost");
        this.a = r2;
    }
}
