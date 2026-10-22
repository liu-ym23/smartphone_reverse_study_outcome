package com.ss.android.lark.pb.authorization;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum FeatureGateType extends Enum<FeatureGateType> implements WireEnum {
    private static final /* synthetic */ FeatureGateType[] $VALUES = null;
    public static final ProtoAdapter<FeatureGateType> ADAPTER = null;
    public static final FeatureGateType FEATURE_GATE_FILE = null;
    public static final FeatureGateType FEATURE_GATE_PASTE_PROTECTION = null;
    public static final FeatureGateType FEATURE_GATE_PRIVACY = null;
    public static final FeatureGateType FEATURE_GATE_SCREEN_PROTECTION = null;
    public static final FeatureGateType FEATURE_GATE_UNKNOWN = null;
    private final int value;

    static {
        FeatureGateType r100 = new FeatureGateType("FEATURE_GATE_UNKNOWN", 0, 0);
        FEATURE_GATE_UNKNOWN = r100;
        FeatureGateType r101 = new FeatureGateType("FEATURE_GATE_FILE", 1, 1);
        FEATURE_GATE_FILE = r101;
        FeatureGateType r102 = new FeatureGateType("FEATURE_GATE_PRIVACY", 2, 2);
        FEATURE_GATE_PRIVACY = r102;
        FeatureGateType r103 = new FeatureGateType("FEATURE_GATE_PASTE_PROTECTION", 3, 3);
        FEATURE_GATE_PASTE_PROTECTION = r103;
        FeatureGateType r104 = new FeatureGateType("FEATURE_GATE_SCREEN_PROTECTION", 4, 4);
        FEATURE_GATE_SCREEN_PROTECTION = r104;
        $VALUES = new FeatureGateType[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(FeatureGateType.class);
    }

    public static FeatureGateType[] values() {
        return (FeatureGateType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FeatureGateType fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return FEATURE_GATE_SCREEN_PROTECTION;
    L16:
        return FEATURE_GATE_PASTE_PROTECTION;
    L18:
        return FEATURE_GATE_PRIVACY;
    L20:
        return FEATURE_GATE_FILE;
    L22:
        return FEATURE_GATE_UNKNOWN;
    }

    public static FeatureGateType valueOf(String r100) {
        return (FeatureGateType) a.a(FeatureGateType.class, r100);
    }

    private FeatureGateType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
