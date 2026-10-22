package com.ss.android.lark.inline.ai.logic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/inline/ai/logic/InlineAIStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Init", "Waiting", "PrepareWaiting", "Writing", "Finished", "Closed", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InlineAIStatus extends Enum<InlineAIStatus> {
    public static final InlineAIStatus Closed = null;
    public static final InlineAIStatus Finished = null;
    public static final InlineAIStatus Init = null;
    public static final InlineAIStatus PrepareWaiting = null;
    public static final InlineAIStatus Waiting = null;
    public static final InlineAIStatus Writing = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InlineAIStatus[] f427279a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f427280b = null;

    public static EnumEntries<InlineAIStatus> getEntries() {
        return f427280b;
    }

    static {
        InlineAIStatus r100 = new InlineAIStatus("Init", 0);
        Init = r100;
        InlineAIStatus r101 = new InlineAIStatus("Waiting", 1);
        Waiting = r101;
        InlineAIStatus r102 = new InlineAIStatus("PrepareWaiting", 2);
        PrepareWaiting = r102;
        InlineAIStatus r103 = new InlineAIStatus("Writing", 3);
        Writing = r103;
        InlineAIStatus r104 = new InlineAIStatus("Finished", 4);
        Finished = r104;
        InlineAIStatus r105 = new InlineAIStatus("Closed", 5);
        Closed = r105;
        InlineAIStatus[] r110 = {r100, r101, r102, r103, r104, r105};
        f427279a = r110;
        f427280b = EnumEntriesKt.enumEntries(r110);
    }

    public static InlineAIStatus[] values() {
        return (InlineAIStatus[]) f427279a.clone();
    }

    public static InlineAIStatus valueOf(String r100) {
        return (InlineAIStatus) r27.a.a(InlineAIStatus.class, r100);
    }

    public InlineAIStatus(String r100, int r101) {
        super(r100, r101);
    }
}
