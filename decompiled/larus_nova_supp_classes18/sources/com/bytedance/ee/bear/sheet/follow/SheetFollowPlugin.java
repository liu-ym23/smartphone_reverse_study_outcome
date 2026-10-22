package com.bytedance.ee.bear.sheet.follow;

import android.os.Bundle;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.follow.FollowPlugin;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetFollowPlugin extends FollowPlugin {
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void handleOrientation() {
        BaseUnspecifiedOrientationPlugin r0 = findPlugin(BaseUnspecifiedOrientationPlugin.class);
        if (r0 != null) goto L5;
        return;
    L5:
        Bundle r1 = getHost().c().getArguments();
        if (r1 != null) goto L8;
    L12:
        r0.forceLandscape();
        return;
    L8:
        if (r1.getBoolean("vc_refresh", false) == false) goto L12;
        if (getContext().getResources().getConfiguration().orientation == 1) goto L14;
        r0.forceLandscape();
        return;
    }

    public SheetFollowPlugin() {
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        handleOrientation();
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }
}
