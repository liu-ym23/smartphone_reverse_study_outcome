package com.bytedance.android.livesdk.ktvimpl.base.sei;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/PlayFlag;", "", "NORMAL", "PREVIEW_SONG", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PlayFlag extends Enum<PlayFlag> {
    public static final PlayFlag NORMAL = null;
    public static final PlayFlag PREVIEW_SONG = null;
    public static final /* synthetic */ PlayFlag[] a = null;

    static {
        PlayFlag r1 = new PlayFlag("NORMAL", 0);
        NORMAL = r1;
        PlayFlag r2 = new PlayFlag("PREVIEW_SONG", 1);
        PREVIEW_SONG = r2;
        a = new PlayFlag[]{r1, r2};
    }

    public static PlayFlag valueOf(String r1) {
        return (PlayFlag) r27.a.a(PlayFlag.class, r1);
    }

    public static PlayFlag[] values() {
        return (PlayFlag[]) a.clone();
    }

    public PlayFlag(String r1, int r2) {
        super(r1, r2);
    }
}
