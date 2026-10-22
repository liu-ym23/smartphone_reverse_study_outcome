package com.bytedance.livesdk.ktvcommon.midi.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0087\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/livesdk/ktvcommon/midi/model/HitType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, UserProfileEvent.POSITION_NONE, "MISS", "GOOD", "GREAT", "PERFECT", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum HitType extends Enum<HitType> {
    public static final a Companion = null;
    public static final HitType GOOD = null;
    public static final HitType GREAT = null;
    public static final HitType MISS = null;
    public static final HitType NONE = null;
    public static final HitType PERFECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HitType[] f256036a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.livesdk.ktvcommon.midi.model.HitType$a] */
    static {
        HitType r100 = new HitType(UserProfileEvent.POSITION_NONE, 0, -1);
        NONE = r100;
        HitType r101 = new HitType("MISS", 1, 0);
        MISS = r101;
        HitType r102 = new HitType("GOOD", 2, 1);
        GOOD = r102;
        HitType r103 = new HitType("GREAT", 3, 2);
        GREAT = r103;
        HitType r104 = new HitType("PERFECT", 4, 3);
        PERFECT = r104;
        f256036a = new HitType[]{r100, r101, r102, r103, r104};
        Companion = new a();
    }

    public static HitType valueOf(String r100) {
        return (HitType) r27.a.a(HitType.class, r100);
    }

    public static HitType[] values() {
        return (HitType[]) f256036a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public HitType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
