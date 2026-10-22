package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/model/MusicOperateType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "ADJUST", "PAUSE_RESTART", "CHALLENGE", "SILENCE", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MusicOperateType extends Enum<MusicOperateType> {
    public static final MusicOperateType ADJUST = null;
    public static final MusicOperateType CHALLENGE = null;
    public static final MusicOperateType PAUSE_RESTART = null;
    public static final MusicOperateType SILENCE = null;
    public static final MusicOperateType UNKNOWN = null;
    public static final /* synthetic */ MusicOperateType[] a = null;
    private final int value;

    static {
        MusicOperateType r1 = new MusicOperateType("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        MusicOperateType r2 = new MusicOperateType("ADJUST", 1, 1);
        ADJUST = r2;
        MusicOperateType r3 = new MusicOperateType("PAUSE_RESTART", 2, 2);
        PAUSE_RESTART = r3;
        MusicOperateType r4 = new MusicOperateType("CHALLENGE", 3, 3);
        CHALLENGE = r4;
        MusicOperateType r5 = new MusicOperateType("SILENCE", 4, 4);
        SILENCE = r5;
        a = new MusicOperateType[]{r1, r2, r3, r4, r5};
    }

    public static MusicOperateType valueOf(String r1) {
        return (MusicOperateType) a.a(MusicOperateType.class, r1);
    }

    public static MusicOperateType[] values() {
        return (MusicOperateType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public MusicOperateType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
