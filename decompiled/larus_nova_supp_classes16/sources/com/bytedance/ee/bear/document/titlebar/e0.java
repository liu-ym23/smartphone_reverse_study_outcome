package com.bytedance.ee.bear.document.titlebar;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.google.android.material.appbar.AppBarLayout;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e0 implements d0.c {
    public final ChameleonPluginHost a;
    public final AppBarLayout b;

    @Override // com.bytedance.ee.bear.document.titlebar.d0.c
    public final d0.b getActionProvider() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.d0.c
    public final ViewGroup a() {
        return this.a.getContainer(ContainerType.Content.getValue());
    }

    @Override // com.bytedance.ee.bear.document.titlebar.d0.c
    public FragmentActivity getActivity() {
        return this.a.getActivity();
    }

    @Override // com.bytedance.ee.bear.document.titlebar.d0.c
    public final View getRootView() {
        Fragment r0 = this.a.getHostFragment();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getView();
    }

    @Override // com.bytedance.ee.bear.document.titlebar.d0.c
    public final LifecycleOwner getTitleBarLifecycleOwner() {
        return this.a.getLifecycleOwner();
    }

    @Override // com.bytedance.ee.bear.document.titlebar.d0.c
    public final WebView getWebView() {
        WebPluginHost r0 = this.a;
        if ((r0 instanceof WebPluginHost) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L11;
        vv4.k r1 = r0.getWeb();
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getWebView();
    L11:
        return null;
    }

    @Override // com.bytedance.ee.bear.document.titlebar.d0.c
    public final AppBarLayout getTitleBarLayout() {
        return this.b;
    }

    public e0(ChameleonPluginHost r2, AppBarLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        Intrinsics.checkNotNullParameter(r3, "appBarLayout");
        this.a = r2;
        this.b = r3;
    }
}
