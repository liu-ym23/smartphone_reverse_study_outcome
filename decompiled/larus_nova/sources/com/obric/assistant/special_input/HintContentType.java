package com.obric.assistant.special_input;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/special_input/HintContentType;", "", "<init>", "(Ljava/lang/String;I)V", "OAUTO_CLARIFY_NO_BOLD", "OAUTO_CLARIFY_BOLD", "COMPLEX_TASK_NO_BOLD", "COMPLEX_TASK_CLARIFY_BOLD", "ADDITION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HintContentType extends Enum<HintContentType> {
    public static final HintContentType ADDITION = null;
    public static final HintContentType COMPLEX_TASK_CLARIFY_BOLD = null;
    public static final HintContentType COMPLEX_TASK_NO_BOLD = null;
    public static final HintContentType OAUTO_CLARIFY_BOLD = null;
    public static final HintContentType OAUTO_CLARIFY_NO_BOLD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HintContentType[] f392525a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392526b = null;

    public static EnumEntries<HintContentType> getEntries() {
        return f392526b;
    }

    static {
        HintContentType r100 = new HintContentType("OAUTO_CLARIFY_NO_BOLD", 0);
        OAUTO_CLARIFY_NO_BOLD = r100;
        HintContentType r101 = new HintContentType("OAUTO_CLARIFY_BOLD", 1);
        OAUTO_CLARIFY_BOLD = r101;
        HintContentType r102 = new HintContentType("COMPLEX_TASK_NO_BOLD", 2);
        COMPLEX_TASK_NO_BOLD = r102;
        HintContentType r103 = new HintContentType("COMPLEX_TASK_CLARIFY_BOLD", 3);
        COMPLEX_TASK_CLARIFY_BOLD = r103;
        HintContentType r104 = new HintContentType("ADDITION", 4);
        ADDITION = r104;
        HintContentType[] r105 = {r100, r101, r102, r103, r104};
        f392525a = r105;
        f392526b = EnumEntriesKt.enumEntries(r105);
    }

    public static HintContentType[] values() {
        return (HintContentType[]) f392525a.clone();
    }

    public static HintContentType valueOf(String r100) {
        return (HintContentType) r27.a.a(HintContentType.class, r100);
    }

    public HintContentType(String r100, int r101) {
        super(r100, r101);
    }
}
