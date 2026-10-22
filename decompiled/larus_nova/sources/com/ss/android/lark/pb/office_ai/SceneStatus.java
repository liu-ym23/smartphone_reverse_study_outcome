package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum SceneStatus extends Enum<SceneStatus> implements WireEnum {
    private static final /* synthetic */ SceneStatus[] $VALUES = null;
    public static final ProtoAdapter<SceneStatus> ADAPTER = null;
    public static final SceneStatus SceneStatus_DELETE = null;
    public static final SceneStatus SceneStatus_STOP = null;
    public static final SceneStatus SceneStatus_VALID = null;
    private final int value;

    static {
        SceneStatus r100 = new SceneStatus("SceneStatus_VALID", 0, 0);
        SceneStatus_VALID = r100;
        SceneStatus r101 = new SceneStatus("SceneStatus_STOP", 1, 1);
        SceneStatus_STOP = r101;
        SceneStatus r102 = new SceneStatus("SceneStatus_DELETE", 2, 2);
        SceneStatus_DELETE = r102;
        $VALUES = new SceneStatus[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(SceneStatus.class);
    }

    public static SceneStatus[] values() {
        return (SceneStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SceneStatus fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return SceneStatus_DELETE;
    L12:
        return SceneStatus_STOP;
    L14:
        return SceneStatus_VALID;
    }

    public static SceneStatus valueOf(String r100) {
        return (SceneStatus) a.a(SceneStatus.class, r100);
    }

    private SceneStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
