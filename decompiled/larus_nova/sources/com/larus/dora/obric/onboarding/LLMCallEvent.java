package com.larus.dora.obric.onboarding;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/obric/onboarding/LLMCallEvent;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", GXAnimation.STATE_START, "QUERY_END", "REPLY", "NEXT", "FINISH", "WEAR", "LINK", "NET", "INVALID", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LLMCallEvent extends Enum<LLMCallEvent> {
    public static final LLMCallEvent FINISH = null;
    public static final LLMCallEvent INVALID = null;
    public static final LLMCallEvent LINK = null;
    public static final LLMCallEvent NET = null;
    public static final LLMCallEvent NEXT = null;
    public static final LLMCallEvent QUERY_END = null;
    public static final LLMCallEvent REPLY = null;
    public static final LLMCallEvent START = null;
    public static final LLMCallEvent UNKNOWN = null;
    public static final LLMCallEvent WEAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LLMCallEvent[] f340713a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f340714b = null;

    public static EnumEntries<LLMCallEvent> getEntries() {
        return f340714b;
    }

    static {
        LLMCallEvent r100 = new LLMCallEvent("UNKNOWN", 0);
        UNKNOWN = r100;
        LLMCallEvent r101 = new LLMCallEvent(GXAnimation.STATE_START, 1);
        START = r101;
        LLMCallEvent r102 = new LLMCallEvent("QUERY_END", 2);
        QUERY_END = r102;
        LLMCallEvent r103 = new LLMCallEvent("REPLY", 3);
        REPLY = r103;
        LLMCallEvent r104 = new LLMCallEvent("NEXT", 4);
        NEXT = r104;
        LLMCallEvent r105 = new LLMCallEvent("FINISH", 5);
        FINISH = r105;
        LLMCallEvent r110 = new LLMCallEvent("WEAR", 6);
        WEAR = r110;
        LLMCallEvent r111 = new LLMCallEvent("LINK", 7);
        LINK = r111;
        LLMCallEvent r112 = new LLMCallEvent("NET", 8);
        NET = r112;
        LLMCallEvent r113 = new LLMCallEvent("INVALID", 9);
        INVALID = r113;
        LLMCallEvent[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f340713a = r114;
        f340714b = EnumEntriesKt.enumEntries(r114);
    }

    public static LLMCallEvent[] values() {
        return (LLMCallEvent[]) f340713a.clone();
    }

    public static LLMCallEvent valueOf(String r100) {
        return (LLMCallEvent) r27.a.a(LLMCallEvent.class, r100);
    }

    public LLMCallEvent(String r100, int r101) {
        super(r100, r101);
    }
}
