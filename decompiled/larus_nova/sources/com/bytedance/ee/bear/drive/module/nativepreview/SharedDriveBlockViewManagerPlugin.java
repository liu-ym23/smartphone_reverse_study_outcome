package com.bytedance.ee.bear.drive.module.nativepreview;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.drive.core.AbsDrivePlugin;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;

/* JADX INFO: loaded from: classes16.dex */
public class SharedDriveBlockViewManagerPlugin extends AbsDrivePlugin {
    @Override // com.bytedance.ee.bear.drive.core.AbsDrivePlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public SharedDriveBlockViewManagerPlugin() {
    }

    private ViewGroup findParent(View r100) {
    L3:
        if (r100 == null) goto L13;
        if ("block_place_holder".equals(r100.getTag()) == true) goto L7;
        Object r101 = r100.getParent();
        if (r101 == null) goto L13;
        if ((r101 instanceof View) == false) goto L13;
        r100 = (View) r101;
        goto L3
    L7:
        return (ViewGroup) r100;
    L13:
        return null;
    }

    private void removeFragmentView(ViewGroup r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.getChildCount()) goto L9;
        View r102 = r100.getChildAt(r101);
        if ("loadingRoot".equals(r102.getTag()) == true) goto L8;
        r100.removeView(r102);
    L8:
        r101 = r101 + 1;
        goto L4
    }

    public void onDetachFromUIContainer(DrivePluginHost r100, t r101) {
        ViewGroup r102 = findParent(r101.getContentView());
        if (r102 == null) goto L5;
        removeFragmentView(r102);
    L5:
        super.onDetachFromUIContainer(r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((DrivePluginHost) r100, r101);
    }
}
