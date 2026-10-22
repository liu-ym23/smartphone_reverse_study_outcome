package com.bytedance.ee.bear.document.knowledgeai;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/document/knowledgeai/DocsKnowledgeAIType;", "", "wireValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireValue", "()Ljava/lang/String;", "NONE", "KNOWLEDGE_AI", "FLOW_AI", "contentmanager-lark-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocsKnowledgeAIType extends Enum<DocsKnowledgeAIType> {
    public static final DocsKnowledgeAIType FLOW_AI = null;
    public static final DocsKnowledgeAIType KNOWLEDGE_AI = null;
    public static final DocsKnowledgeAIType NONE = null;
    public static final /* synthetic */ DocsKnowledgeAIType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String wireValue;

    public static EnumEntries<DocsKnowledgeAIType> getEntries() {
        return b;
    }

    static {
        DocsKnowledgeAIType r0 = new DocsKnowledgeAIType("NONE", 0, "none");
        NONE = r0;
        DocsKnowledgeAIType r1 = new DocsKnowledgeAIType("KNOWLEDGE_AI", 1, "knowledgeAI");
        KNOWLEDGE_AI = r1;
        DocsKnowledgeAIType r2 = new DocsKnowledgeAIType("FLOW_AI", 2, "flowAI");
        FLOW_AI = r2;
        DocsKnowledgeAIType[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static DocsKnowledgeAIType[] values() {
        return (DocsKnowledgeAIType[]) a.clone();
    }

    public final String getWireValue() {
        return this.wireValue;
    }

    public static DocsKnowledgeAIType valueOf(String r1) {
        return (DocsKnowledgeAIType) r27.a.a(DocsKnowledgeAIType.class, r1);
    }

    public DocsKnowledgeAIType(String r1, int r2, String r3) {
        super(r1, r2);
        this.wireValue = r3;
    }
}
