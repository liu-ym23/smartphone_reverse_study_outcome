package com.ss.android.lark.chat.entity.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/AIRecommendQuestionViewSpace;", "", "<init>", "(Ljava/lang/String;I)V", "Normal", "System", "Bubble", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AIRecommendQuestionViewSpace extends Enum<AIRecommendQuestionViewSpace> {
    public static final AIRecommendQuestionViewSpace Bubble = null;
    public static final AIRecommendQuestionViewSpace Normal = null;
    public static final AIRecommendQuestionViewSpace System = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AIRecommendQuestionViewSpace[] f415210a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415211b = null;

    public static EnumEntries<AIRecommendQuestionViewSpace> getEntries() {
        return f415211b;
    }

    static {
        AIRecommendQuestionViewSpace r100 = new AIRecommendQuestionViewSpace("Normal", 0);
        Normal = r100;
        AIRecommendQuestionViewSpace r101 = new AIRecommendQuestionViewSpace("System", 1);
        System = r101;
        AIRecommendQuestionViewSpace r102 = new AIRecommendQuestionViewSpace("Bubble", 2);
        Bubble = r102;
        AIRecommendQuestionViewSpace[] r103 = {r100, r101, r102};
        f415210a = r103;
        f415211b = EnumEntriesKt.enumEntries(r103);
    }

    public static AIRecommendQuestionViewSpace[] values() {
        return (AIRecommendQuestionViewSpace[]) f415210a.clone();
    }

    public static AIRecommendQuestionViewSpace valueOf(String r100) {
        return (AIRecommendQuestionViewSpace) r27.a.a(AIRecommendQuestionViewSpace.class, r100);
    }

    public AIRecommendQuestionViewSpace(String r100, int r101) {
        super(r100, r101);
    }
}
