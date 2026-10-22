package com.ss.android.lark.inline.ai.logic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/inline/ai/logic/FeedBackChoice;", "", "<init>", "(Ljava/lang/String;I)V", "Unselected", "Like", "Unlike", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedBackChoice extends Enum<FeedBackChoice> {
    public static final FeedBackChoice Like = null;
    public static final FeedBackChoice Unlike = null;
    public static final FeedBackChoice Unselected = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedBackChoice[] f427242a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f427243b = null;

    public static EnumEntries<FeedBackChoice> getEntries() {
        return f427243b;
    }

    static {
        FeedBackChoice r100 = new FeedBackChoice("Unselected", 0);
        Unselected = r100;
        FeedBackChoice r101 = new FeedBackChoice("Like", 1);
        Like = r101;
        FeedBackChoice r102 = new FeedBackChoice("Unlike", 2);
        Unlike = r102;
        FeedBackChoice[] r103 = {r100, r101, r102};
        f427242a = r103;
        f427243b = EnumEntriesKt.enumEntries(r103);
    }

    public static FeedBackChoice[] values() {
        return (FeedBackChoice[]) f427242a.clone();
    }

    public static FeedBackChoice valueOf(String r100) {
        return (FeedBackChoice) r27.a.a(FeedBackChoice.class, r100);
    }

    public FeedBackChoice(String r100, int r101) {
        super(r100, r101);
    }
}
