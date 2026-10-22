package com.bytedance.ee.bear.middleground.comment.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/widget/BotAtHintActionType;", "", "<init>", "(Ljava/lang/String;I)V", "CONFIGURE_NOW", "LEARN_MORE", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BotAtHintActionType extends Enum<BotAtHintActionType> {
    public static final BotAtHintActionType CONFIGURE_NOW = null;
    public static final BotAtHintActionType LEARN_MORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BotAtHintActionType[] f232257a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f232258b = null;

    public static EnumEntries<BotAtHintActionType> getEntries() {
        return f232258b;
    }

    static {
        BotAtHintActionType r100 = new BotAtHintActionType("CONFIGURE_NOW", 0);
        CONFIGURE_NOW = r100;
        BotAtHintActionType r101 = new BotAtHintActionType("LEARN_MORE", 1);
        LEARN_MORE = r101;
        BotAtHintActionType[] r102 = {r100, r101};
        f232257a = r102;
        f232258b = EnumEntriesKt.enumEntries(r102);
    }

    public static BotAtHintActionType[] values() {
        return (BotAtHintActionType[]) f232257a.clone();
    }

    public static BotAtHintActionType valueOf(String r100) {
        return (BotAtHintActionType) r27.a.a(BotAtHintActionType.class, r100);
    }

    public BotAtHintActionType(String r100, int r101) {
        super(r100, r101);
    }
}
