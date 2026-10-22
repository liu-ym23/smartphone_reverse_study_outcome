package com.ss.android.lark.pb.meeting_object;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum FeatureUpgradeType extends Enum<FeatureUpgradeType> implements WireEnum {
    private static final /* synthetic */ FeatureUpgradeType[] $VALUES = null;
    public static final ProtoAdapter<FeatureUpgradeType> ADAPTER = null;
    public static final FeatureUpgradeType FeatureUpgradeType_AI = null;
    public static final FeatureUpgradeType FeatureUpgradeType_ASR = null;
    public static final FeatureUpgradeType FeatureUpgradeType_Unknown = null;
    private final int value;

    static {
        FeatureUpgradeType r100 = new FeatureUpgradeType("FeatureUpgradeType_Unknown", 0, 0);
        FeatureUpgradeType_Unknown = r100;
        FeatureUpgradeType r101 = new FeatureUpgradeType("FeatureUpgradeType_ASR", 1, 1);
        FeatureUpgradeType_ASR = r101;
        FeatureUpgradeType r102 = new FeatureUpgradeType("FeatureUpgradeType_AI", 2, 2);
        FeatureUpgradeType_AI = r102;
        $VALUES = new FeatureUpgradeType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(FeatureUpgradeType.class);
    }

    public static FeatureUpgradeType[] values() {
        return (FeatureUpgradeType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FeatureUpgradeType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return FeatureUpgradeType_AI;
    L12:
        return FeatureUpgradeType_ASR;
    L14:
        return FeatureUpgradeType_Unknown;
    }

    public static FeatureUpgradeType valueOf(String r100) {
        return (FeatureUpgradeType) a.a(FeatureUpgradeType.class, r100);
    }

    private FeatureUpgradeType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
