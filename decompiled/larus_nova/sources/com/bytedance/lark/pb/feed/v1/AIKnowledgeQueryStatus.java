package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum AIKnowledgeQueryStatus extends Enum<AIKnowledgeQueryStatus> implements WireEnum {
    private static final /* synthetic */ AIKnowledgeQueryStatus[] $VALUES = null;
    public static final ProtoAdapter<AIKnowledgeQueryStatus> ADAPTER = null;
    public static final AIKnowledgeQueryStatus QUERY_CLOSE = null;
    public static final AIKnowledgeQueryStatus QUERY_DONE = null;
    public static final AIKnowledgeQueryStatus QUERY_PROCESSING = null;
    public static final AIKnowledgeQueryStatus QUERY_START = null;
    public static final AIKnowledgeQueryStatus UNKNOWN_QUERY_STATUS = null;
    private final int value;

    static {
        AIKnowledgeQueryStatus r100 = new AIKnowledgeQueryStatus("UNKNOWN_QUERY_STATUS", 0, 0);
        UNKNOWN_QUERY_STATUS = r100;
        AIKnowledgeQueryStatus r101 = new AIKnowledgeQueryStatus("QUERY_START", 1, 1);
        QUERY_START = r101;
        AIKnowledgeQueryStatus r102 = new AIKnowledgeQueryStatus("QUERY_PROCESSING", 2, 2);
        QUERY_PROCESSING = r102;
        AIKnowledgeQueryStatus r103 = new AIKnowledgeQueryStatus("QUERY_DONE", 3, 3);
        QUERY_DONE = r103;
        AIKnowledgeQueryStatus r104 = new AIKnowledgeQueryStatus("QUERY_CLOSE", 4, 4);
        QUERY_CLOSE = r104;
        $VALUES = new AIKnowledgeQueryStatus[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(AIKnowledgeQueryStatus.class);
    }

    public static AIKnowledgeQueryStatus[] values() {
        return (AIKnowledgeQueryStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static AIKnowledgeQueryStatus fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return QUERY_CLOSE;
    L16:
        return QUERY_DONE;
    L18:
        return QUERY_PROCESSING;
    L20:
        return QUERY_START;
    L22:
        return UNKNOWN_QUERY_STATUS;
    }

    public static AIKnowledgeQueryStatus valueOf(String r100) {
        return (AIKnowledgeQueryStatus) a.a(AIKnowledgeQueryStatus.class, r100);
    }

    private AIKnowledgeQueryStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
