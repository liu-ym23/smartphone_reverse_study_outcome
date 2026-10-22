package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.live;

import com.bytedance.android.livesdk.ec.adapter.api.FloatWindowState;
import com.bytedance.android.livesdk.ec.adapter.api.LiveVolume;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[FloatWindowState.values().length];
        a = r0;
        r0[FloatWindowState.OPEN.ordinal()] = 1;
        r0[FloatWindowState.STOP.ordinal()] = 2;
        int[] r1 = new int[LiveVolume.values().length];
        r1[LiveVolume.MUTE.ordinal()] = 1;
        r1[LiveVolume.UNMUTE.ordinal()] = 2;
    }
}
