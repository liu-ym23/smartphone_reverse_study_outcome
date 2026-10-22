package com.bytedance.ee.bear.drive.module.nativepreview;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SharedDriveBlockViewManagerPlugin extends AbsDrivePlugin {
    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SharedDriveBlockViewManagerPlugin() {
    }

    private ViewGroup findParent(View r4) {
    L3:
        if (r4 == null) goto L13;
        if ("block_place_holder".equals(r4.getTag()) == true) goto L7;
        Object r5 = r4.getParent();
        if (r5 == null) goto L13;
        if ((r5 instanceof View) == false) goto L13;
        r4 = (View) r5;
        goto L3
    L7:
        return (ViewGroup) r4;
    L13:
        return null;
    }

    private void removeFragmentView(ViewGroup r5) {
        int r0 = 0;
    L4:
        if (r0 >= r5.getChildCount()) goto L9;
        View r1 = r5.getChildAt(r0);
        if ("loadingRoot".equals(r1.getTag()) == true) goto L8;
        r5.removeView(r1);
    L8:
        r0 = r0 + 1;
        goto L4
    }

    public void onDetachFromUIContainer(DrivePluginHost r2, t r3) {
        ViewGroup r0 = findParent(r3.getContentView());
        if (r0 == null) goto L5;
        removeFragmentView(r0);
    L5:
        super.onDetachFromUIContainer(r2, r3);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DrivePluginHost) r1, r2);
    }
}
