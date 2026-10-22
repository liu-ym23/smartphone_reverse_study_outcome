package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/CloseChallengeType;", "", "", "value", "I", "getValue", "()I", "UNKNOWN", "MULTI_CHORUS_CONFLICT_CHALLENGE", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CloseChallengeType extends Enum<CloseChallengeType> {
    public static final CloseChallengeType MULTI_CHORUS_CONFLICT_CHALLENGE = null;
    public static final CloseChallengeType UNKNOWN = null;
    public static final /* synthetic */ CloseChallengeType[] a = null;
    private final int value;

    static {
        CloseChallengeType r1 = new CloseChallengeType("UNKNOWN", 0, 0);
        UNKNOWN = r1;
        CloseChallengeType r2 = new CloseChallengeType("MULTI_CHORUS_CONFLICT_CHALLENGE", 1, 1);
        MULTI_CHORUS_CONFLICT_CHALLENGE = r2;
        a = new CloseChallengeType[]{r1, r2};
    }

    public static CloseChallengeType valueOf(String r1) {
        return (CloseChallengeType) r27.a.a(CloseChallengeType.class, r1);
    }

    public static CloseChallengeType[] values() {
        return (CloseChallengeType[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CloseChallengeType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
