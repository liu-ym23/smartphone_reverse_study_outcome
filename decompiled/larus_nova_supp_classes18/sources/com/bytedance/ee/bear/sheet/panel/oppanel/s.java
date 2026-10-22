package com.bytedance.ee.bear.sheet.panel.oppanel;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements ew4.i0 {
    public final /* synthetic */ OfficeFabPanelFragment.a a;

    public final PluginHost a() {
        return PluginHost.fromFragment(this.a.a);
    L4:
        e = move-exception;
        tt5.a.e("OfficeFabPanelFragment", "get plugin host error", e, false);
        return null;
    }

    public FragmentActivity getActivity() {
        return this.a.a.requireActivity();
    }

    public s(OfficeFabPanelFragment.a r1) {
        this.a = r1;
    }
}
