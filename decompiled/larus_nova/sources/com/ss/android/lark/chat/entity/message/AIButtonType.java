package com.ss.android.lark.chat.entity.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/AIButtonType;", "", "<init>", "(Ljava/lang/String;I)V", "LIKE", "DISLIKE", "REGENERATE", "SHARE", "COPY", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AIButtonType extends Enum<AIButtonType> {
    public static final AIButtonType COPY = null;
    public static final AIButtonType DISLIKE = null;
    public static final AIButtonType LIKE = null;
    public static final AIButtonType REGENERATE = null;
    public static final AIButtonType SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AIButtonType[] f415208a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f415209b = null;

    public static EnumEntries<AIButtonType> getEntries() {
        return f415209b;
    }

    static {
        AIButtonType r100 = new AIButtonType("LIKE", 0);
        LIKE = r100;
        AIButtonType r101 = new AIButtonType("DISLIKE", 1);
        DISLIKE = r101;
        AIButtonType r102 = new AIButtonType("REGENERATE", 2);
        REGENERATE = r102;
        AIButtonType r103 = new AIButtonType("SHARE", 3);
        SHARE = r103;
        AIButtonType r104 = new AIButtonType("COPY", 4);
        COPY = r104;
        AIButtonType[] r105 = {r100, r101, r102, r103, r104};
        f415208a = r105;
        f415209b = EnumEntriesKt.enumEntries(r105);
    }

    public static AIButtonType[] values() {
        return (AIButtonType[]) f415208a.clone();
    }

    public static AIButtonType valueOf(String r100) {
        return (AIButtonType) r27.a.a(AIButtonType.class, r100);
    }

    public AIButtonType(String r100, int r101) {
        super(r100, r101);
    }
}
