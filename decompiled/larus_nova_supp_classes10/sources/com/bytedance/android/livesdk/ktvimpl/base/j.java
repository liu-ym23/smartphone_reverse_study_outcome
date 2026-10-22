package com.bytedance.android.livesdk.ktvimpl.base;

import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final /* synthetic */ class j {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[MusicPanel.Track.values().length];
        a = r0;
        r0[MusicPanel.Track.ALL_SUPPORT.ordinal()] = 1;
        r0[MusicPanel.Track.ORIGIN_ONLY.ordinal()] = 2;
        r0[MusicPanel.Track.ACCOMPANIMENT_ONLY.ordinal()] = 3;
        r0[MusicPanel.Track.NONE.ordinal()] = 4;
    }
}
