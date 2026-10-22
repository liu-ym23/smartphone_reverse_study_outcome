package com.ss.android.lark.officesdk.minutes.api.hardware.aiknowledge;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/hardware/aiknowledge/MmAIKnowledgeEntryType;", "", "<init>", "(Ljava/lang/String;I)V", "KNOWLEDGE_AI", "DOUBAO", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAIKnowledgeEntryType extends Enum<MmAIKnowledgeEntryType> {
    public static final MmAIKnowledgeEntryType DOUBAO = null;
    public static final MmAIKnowledgeEntryType KNOWLEDGE_AI = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAIKnowledgeEntryType[] f433500a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433501b = null;

    public static EnumEntries<MmAIKnowledgeEntryType> getEntries() {
        return f433501b;
    }

    static {
        MmAIKnowledgeEntryType r100 = new MmAIKnowledgeEntryType("KNOWLEDGE_AI", 0);
        KNOWLEDGE_AI = r100;
        MmAIKnowledgeEntryType r101 = new MmAIKnowledgeEntryType("DOUBAO", 1);
        DOUBAO = r101;
        MmAIKnowledgeEntryType[] r102 = {r100, r101};
        f433500a = r102;
        f433501b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmAIKnowledgeEntryType[] values() {
        return (MmAIKnowledgeEntryType[]) f433500a.clone();
    }

    public static MmAIKnowledgeEntryType valueOf(String r100) {
        return (MmAIKnowledgeEntryType) a.a(MmAIKnowledgeEntryType.class, r100);
    }

    public MmAIKnowledgeEntryType(String r100, int r101) {
        super(r100, r101);
    }
}
