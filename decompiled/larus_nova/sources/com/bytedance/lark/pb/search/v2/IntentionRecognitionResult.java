package com.bytedance.lark.pb.search.v2;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum IntentionRecognitionResult extends Enum<IntentionRecognitionResult> implements WireEnum {
    private static final /* synthetic */ IntentionRecognitionResult[] $VALUES = null;
    public static final ProtoAdapter<IntentionRecognitionResult> ADAPTER = null;
    public static final IntentionRecognitionResult Error = null;
    public static final IntentionRecognitionResult False = null;
    public static final IntentionRecognitionResult None = null;
    public static final IntentionRecognitionResult True = null;
    private final int value;

    static {
        IntentionRecognitionResult r100 = new IntentionRecognitionResult("None", 0, 0);
        None = r100;
        IntentionRecognitionResult r101 = new IntentionRecognitionResult(BdpAppEventConstant.TRUE, 1, 1);
        True = r101;
        IntentionRecognitionResult r102 = new IntentionRecognitionResult(BdpAppEventConstant.FALSE, 2, 2);
        False = r102;
        IntentionRecognitionResult r103 = new IntentionRecognitionResult("Error", 3, 3);
        Error = r103;
        $VALUES = new IntentionRecognitionResult[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(IntentionRecognitionResult.class);
    }

    public static IntentionRecognitionResult[] values() {
        return (IntentionRecognitionResult[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static IntentionRecognitionResult fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return Error;
    L14:
        return False;
    L16:
        return True;
    L18:
        return None;
    }

    public static IntentionRecognitionResult valueOf(String r100) {
        return (IntentionRecognitionResult) a.a(IntentionRecognitionResult.class, r100);
    }

    private IntentionRecognitionResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
