package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum FeatureStatus extends Enum<FeatureStatus> implements WireEnum {
    private static final /* synthetic */ FeatureStatus[] $VALUES = null;
    public static final ProtoAdapter<FeatureStatus> ADAPTER = null;
    public static final FeatureStatus FEATURE_STATUS_DISABLED = null;
    public static final FeatureStatus FEATURE_STATUS_OFF = null;
    public static final FeatureStatus FEATURE_STATUS_ON = null;
    public static final FeatureStatus FEATURE_STATUS_UNKNOWN = null;
    private final int value;

    static {
        FeatureStatus r100 = new FeatureStatus("FEATURE_STATUS_UNKNOWN", 0, 0);
        FEATURE_STATUS_UNKNOWN = r100;
        FeatureStatus r101 = new FeatureStatus("FEATURE_STATUS_DISABLED", 1, 1);
        FEATURE_STATUS_DISABLED = r101;
        FeatureStatus r102 = new FeatureStatus("FEATURE_STATUS_ON", 2, 2);
        FEATURE_STATUS_ON = r102;
        FeatureStatus r103 = new FeatureStatus("FEATURE_STATUS_OFF", 3, 3);
        FEATURE_STATUS_OFF = r103;
        $VALUES = new FeatureStatus[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(FeatureStatus.class);
    }

    public static FeatureStatus[] values() {
        return (FeatureStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FeatureStatus fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return FEATURE_STATUS_OFF;
    L14:
        return FEATURE_STATUS_ON;
    L16:
        return FEATURE_STATUS_DISABLED;
    L18:
        return FEATURE_STATUS_UNKNOWN;
    }

    public static FeatureStatus valueOf(String r100) {
        return (FeatureStatus) a.a(FeatureStatus.class, r100);
    }

    private FeatureStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
