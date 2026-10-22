package com.ss.android.lark.chat.entity.message.content;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeDetailSourceType;", "", "<init>", "(Ljava/lang/String;I)V", "AIRecommendQuestions", "UserInsertInput", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AtKnowledgeDetailSourceType extends Enum<AtKnowledgeDetailSourceType> {
    public static final AtKnowledgeDetailSourceType AIRecommendQuestions = null;
    public static final AtKnowledgeDetailSourceType UserInsertInput = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtKnowledgeDetailSourceType[] f415317a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415318b = null;

    public static EnumEntries<AtKnowledgeDetailSourceType> getEntries() {
        return f415318b;
    }

    static {
        AtKnowledgeDetailSourceType r100 = new AtKnowledgeDetailSourceType("AIRecommendQuestions", 0);
        AIRecommendQuestions = r100;
        AtKnowledgeDetailSourceType r101 = new AtKnowledgeDetailSourceType("UserInsertInput", 1);
        UserInsertInput = r101;
        AtKnowledgeDetailSourceType[] r102 = {r100, r101};
        f415317a = r102;
        f415318b = EnumEntriesKt.enumEntries(r102);
    }

    public static AtKnowledgeDetailSourceType[] values() {
        return (AtKnowledgeDetailSourceType[]) f415317a.clone();
    }

    public static AtKnowledgeDetailSourceType valueOf(String r100) {
        return (AtKnowledgeDetailSourceType) r27.a.a(AtKnowledgeDetailSourceType.class, r100);
    }

    public AtKnowledgeDetailSourceType(String r100, int r101) {
        super(r100, r101);
    }
}
