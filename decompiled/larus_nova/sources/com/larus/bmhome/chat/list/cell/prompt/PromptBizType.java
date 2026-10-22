package com.larus.bmhome.chat.list.cell.prompt;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/prompt/PromptBizType;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST_MET", "WELCOME_BACK", "SUGGEST", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PromptBizType extends Enum<PromptBizType> {
    public static final PromptBizType FIRST_MET = null;
    public static final PromptBizType SUGGEST = null;
    public static final PromptBizType WELCOME_BACK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PromptBizType[] f305491a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f305492b = null;

    public static EnumEntries<PromptBizType> getEntries() {
        return f305492b;
    }

    static {
        PromptBizType r100 = new PromptBizType("FIRST_MET", 0);
        FIRST_MET = r100;
        PromptBizType r101 = new PromptBizType("WELCOME_BACK", 1);
        WELCOME_BACK = r101;
        PromptBizType r102 = new PromptBizType("SUGGEST", 2);
        SUGGEST = r102;
        PromptBizType[] r103 = {r100, r101, r102};
        f305491a = r103;
        f305492b = EnumEntriesKt.enumEntries(r103);
    }

    public static PromptBizType[] values() {
        return (PromptBizType[]) f305491a.clone();
    }

    public static PromptBizType valueOf(String r100) {
        return (PromptBizType) r27.a.a(PromptBizType.class, r100);
    }

    public PromptBizType(String r100, int r101) {
        super(r100, r101);
    }
}
