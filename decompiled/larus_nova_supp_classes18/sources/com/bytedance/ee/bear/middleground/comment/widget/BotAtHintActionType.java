package com.bytedance.ee.bear.middleground.comment.widget;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/widget/BotAtHintActionType;", "", "<init>", "(Ljava/lang/String;I)V", "CONFIGURE_NOW", "LEARN_MORE", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BotAtHintActionType extends Enum<BotAtHintActionType> {
    public static final BotAtHintActionType CONFIGURE_NOW = null;
    public static final BotAtHintActionType LEARN_MORE = null;
    public static final /* synthetic */ BotAtHintActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<BotAtHintActionType> getEntries() {
        return b;
    }

    static {
        BotAtHintActionType r0 = new BotAtHintActionType("CONFIGURE_NOW", 0);
        CONFIGURE_NOW = r0;
        BotAtHintActionType r1 = new BotAtHintActionType("LEARN_MORE", 1);
        LEARN_MORE = r1;
        BotAtHintActionType[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static BotAtHintActionType[] values() {
        return (BotAtHintActionType[]) a.clone();
    }

    public static BotAtHintActionType valueOf(String r1) {
        return (BotAtHintActionType) r27.a.a(BotAtHintActionType.class, r1);
    }

    public BotAtHintActionType(String r1, int r2) {
        super(r1, r2);
    }
}
