package com.bytedance.ee.bear.document.knowledgeai;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/document/knowledgeai/DocsKnowledgeAIType;", "", "wireValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireValue", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "KNOWLEDGE_AI", "FLOW_AI", "contentmanager-lark-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocsKnowledgeAIType extends Enum<DocsKnowledgeAIType> {
    public static final DocsKnowledgeAIType FLOW_AI = null;
    public static final DocsKnowledgeAIType KNOWLEDGE_AI = null;
    public static final DocsKnowledgeAIType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocsKnowledgeAIType[] f220144a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f220145b = null;
    private final String wireValue;

    public static EnumEntries<DocsKnowledgeAIType> getEntries() {
        return f220145b;
    }

    static {
        DocsKnowledgeAIType r100 = new DocsKnowledgeAIType(UserProfileEvent.POSITION_NONE, 0, "none");
        NONE = r100;
        DocsKnowledgeAIType r101 = new DocsKnowledgeAIType("KNOWLEDGE_AI", 1, IOfflineExtraParser.ParserType.KNOWLEDGE_AI);
        KNOWLEDGE_AI = r101;
        DocsKnowledgeAIType r102 = new DocsKnowledgeAIType("FLOW_AI", 2, "flowAI");
        FLOW_AI = r102;
        DocsKnowledgeAIType[] r103 = {r100, r101, r102};
        f220144a = r103;
        f220145b = EnumEntriesKt.enumEntries(r103);
    }

    public static DocsKnowledgeAIType[] values() {
        return (DocsKnowledgeAIType[]) f220144a.clone();
    }

    public final String getWireValue() {
        return this.wireValue;
    }

    public static DocsKnowledgeAIType valueOf(String r100) {
        return (DocsKnowledgeAIType) r27.a.a(DocsKnowledgeAIType.class, r100);
    }

    public DocsKnowledgeAIType(String r100, int r101, String r102) {
        super(r100, r101);
        this.wireValue = r102;
    }
}
