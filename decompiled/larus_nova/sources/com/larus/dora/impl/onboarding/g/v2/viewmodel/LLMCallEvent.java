package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/onboarding/g/v2/viewmodel/LLMCallEvent;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", GXAnimation.STATE_START, "REPLY", "NEXT", "FINISH", "WEAR", "LINK", "NET", "INVALID", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LLMCallEvent extends Enum<LLMCallEvent> {
    public static final LLMCallEvent FINISH = null;
    public static final LLMCallEvent INVALID = null;
    public static final LLMCallEvent LINK = null;
    public static final LLMCallEvent NET = null;
    public static final LLMCallEvent NEXT = null;
    public static final LLMCallEvent REPLY = null;
    public static final LLMCallEvent START = null;
    public static final LLMCallEvent UNKNOWN = null;
    public static final LLMCallEvent WEAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LLMCallEvent[] f336788a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f336789b = null;

    public static EnumEntries<LLMCallEvent> getEntries() {
        return f336789b;
    }

    static {
        LLMCallEvent r100 = new LLMCallEvent("UNKNOWN", 0);
        UNKNOWN = r100;
        LLMCallEvent r101 = new LLMCallEvent(GXAnimation.STATE_START, 1);
        START = r101;
        LLMCallEvent r102 = new LLMCallEvent("REPLY", 2);
        REPLY = r102;
        LLMCallEvent r103 = new LLMCallEvent("NEXT", 3);
        NEXT = r103;
        LLMCallEvent r104 = new LLMCallEvent("FINISH", 4);
        FINISH = r104;
        LLMCallEvent r105 = new LLMCallEvent("WEAR", 5);
        WEAR = r105;
        LLMCallEvent r110 = new LLMCallEvent("LINK", 6);
        LINK = r110;
        LLMCallEvent r111 = new LLMCallEvent("NET", 7);
        NET = r111;
        LLMCallEvent r112 = new LLMCallEvent("INVALID", 8);
        INVALID = r112;
        LLMCallEvent[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f336788a = r113;
        f336789b = EnumEntriesKt.enumEntries(r113);
    }

    public static LLMCallEvent[] values() {
        return (LLMCallEvent[]) f336788a.clone();
    }

    public static LLMCallEvent valueOf(String r100) {
        return (LLMCallEvent) r27.a.a(LLMCallEvent.class, r100);
    }

    public LLMCallEvent(String r100, int r101) {
        super(r100, r101);
    }
}
