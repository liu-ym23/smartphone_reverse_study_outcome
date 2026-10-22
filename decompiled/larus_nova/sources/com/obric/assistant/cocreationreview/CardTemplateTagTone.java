package com.obric.assistant.cocreationreview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/cocreationreview/CardTemplateTagTone;", "", "<init>", "(Ljava/lang/String;I)V", "NEUTRAL", "ACCENT", "SUCCESS", "WARNING", "DANGER", "METRIC", "FEEDBACK_UP", "FEEDBACK_DOWN", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CardTemplateTagTone extends Enum<CardTemplateTagTone> {
    public static final CardTemplateTagTone ACCENT = null;
    public static final CardTemplateTagTone DANGER = null;
    public static final CardTemplateTagTone FEEDBACK_DOWN = null;
    public static final CardTemplateTagTone FEEDBACK_UP = null;
    public static final CardTemplateTagTone METRIC = null;
    public static final CardTemplateTagTone NEUTRAL = null;
    public static final CardTemplateTagTone SUCCESS = null;
    public static final CardTemplateTagTone WARNING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardTemplateTagTone[] f386999a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387000b = null;

    public static EnumEntries<CardTemplateTagTone> getEntries() {
        return f387000b;
    }

    static {
        CardTemplateTagTone r100 = new CardTemplateTagTone("NEUTRAL", 0);
        NEUTRAL = r100;
        CardTemplateTagTone r101 = new CardTemplateTagTone("ACCENT", 1);
        ACCENT = r101;
        CardTemplateTagTone r102 = new CardTemplateTagTone("SUCCESS", 2);
        SUCCESS = r102;
        CardTemplateTagTone r103 = new CardTemplateTagTone("WARNING", 3);
        WARNING = r103;
        CardTemplateTagTone r104 = new CardTemplateTagTone("DANGER", 4);
        DANGER = r104;
        CardTemplateTagTone r105 = new CardTemplateTagTone("METRIC", 5);
        METRIC = r105;
        CardTemplateTagTone r110 = new CardTemplateTagTone("FEEDBACK_UP", 6);
        FEEDBACK_UP = r110;
        CardTemplateTagTone r111 = new CardTemplateTagTone("FEEDBACK_DOWN", 7);
        FEEDBACK_DOWN = r111;
        CardTemplateTagTone[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f386999a = r112;
        f387000b = EnumEntriesKt.enumEntries(r112);
    }

    public static CardTemplateTagTone[] values() {
        return (CardTemplateTagTone[]) f386999a.clone();
    }

    public static CardTemplateTagTone valueOf(String r100) {
        return (CardTemplateTagTone) r27.a.a(CardTemplateTagTone.class, r100);
    }

    public CardTemplateTagTone(String r100, int r101) {
        super(r100, r101);
    }
}
