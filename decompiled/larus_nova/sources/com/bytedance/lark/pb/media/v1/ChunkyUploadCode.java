package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ChunkyUploadCode extends Enum<ChunkyUploadCode> implements WireEnum {
    private static final /* synthetic */ ChunkyUploadCode[] $VALUES = null;
    public static final ProtoAdapter<ChunkyUploadCode> ADAPTER = null;
    public static final ChunkyUploadCode BAD = null;
    public static final ChunkyUploadCode ERROR = null;
    public static final ChunkyUploadCode NORMAL = null;
    private final int value;

    static {
        ChunkyUploadCode r100 = new ChunkyUploadCode("ERROR", 0, 0);
        ERROR = r100;
        ChunkyUploadCode r101 = new ChunkyUploadCode(EffectConstants.NORMAL, 1, 1);
        NORMAL = r101;
        ChunkyUploadCode r102 = new ChunkyUploadCode("BAD", 2, 2);
        BAD = r102;
        $VALUES = new ChunkyUploadCode[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChunkyUploadCode.class);
    }

    public static ChunkyUploadCode[] values() {
        return (ChunkyUploadCode[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ChunkyUploadCode fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return BAD;
    L12:
        return NORMAL;
    L14:
        return ERROR;
    }

    public static ChunkyUploadCode valueOf(String r100) {
        return (ChunkyUploadCode) a.a(ChunkyUploadCode.class, r100);
    }

    private ChunkyUploadCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
