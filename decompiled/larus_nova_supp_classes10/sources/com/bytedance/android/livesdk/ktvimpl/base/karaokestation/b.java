package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import com.bytedance.android.live.ktv.common.music.control.IMusicControlNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;

    static {
        int[] r0 = new int[IMusicControlNode.OperationType.values().length];
        a = r0;
        IMusicControlNode.OperationType r1 = IMusicControlNode.OperationType.ADD_MUSIC;
        r0[r1.ordinal()] = 1;
        int[] r2 = new int[IMusicControlNode.OperationType.values().length];
        b = r2;
        r2[r1.ordinal()] = 1;
    }
}
