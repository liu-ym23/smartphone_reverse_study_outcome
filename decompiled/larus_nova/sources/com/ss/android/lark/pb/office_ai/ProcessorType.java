package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum ProcessorType extends Enum<ProcessorType> implements WireEnum {
    private static final /* synthetic */ ProcessorType[] $VALUES = null;
    public static final ProtoAdapter<ProcessorType> ADAPTER = null;
    public static final ProcessorType ProcessorType_AI_ENGINE = null;
    public static final ProcessorType ProcessorType_APAAS = null;
    public static final ProcessorType ProcessorType_INNER = null;
    public static final ProcessorType ProcessorType_OPENAPI = null;
    private final int value;

    static {
        ProcessorType r100 = new ProcessorType("ProcessorType_AI_ENGINE", 0, 1);
        ProcessorType_AI_ENGINE = r100;
        ProcessorType r101 = new ProcessorType("ProcessorType_APAAS", 1, 2);
        ProcessorType_APAAS = r101;
        ProcessorType r102 = new ProcessorType("ProcessorType_OPENAPI", 2, 3);
        ProcessorType_OPENAPI = r102;
        ProcessorType r103 = new ProcessorType("ProcessorType_INNER", 3, 4);
        ProcessorType_INNER = r103;
        $VALUES = new ProcessorType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(ProcessorType.class);
    }

    public static ProcessorType[] values() {
        return (ProcessorType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ProcessorType fromValue(int r100) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        return null;
    L13:
        return ProcessorType_INNER;
    L15:
        return ProcessorType_OPENAPI;
    L17:
        return ProcessorType_APAAS;
    L19:
        return ProcessorType_AI_ENGINE;
    }

    public static ProcessorType valueOf(String r100) {
        return (ProcessorType) a.a(ProcessorType.class, r100);
    }

    private ProcessorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
