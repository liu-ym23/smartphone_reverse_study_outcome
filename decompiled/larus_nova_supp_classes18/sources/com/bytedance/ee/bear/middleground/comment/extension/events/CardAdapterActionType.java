package com.bytedance.ee.bear.middleground.comment.extension.events;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/extension/events/CardAdapterActionType;", "", "<init>", "(Ljava/lang/String;I)V", "SetAnim", "SetReaction", "SetContentReaction", "SetTranslateIcon", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CardAdapterActionType extends Enum<CardAdapterActionType> {
    public static final CardAdapterActionType SetAnim = null;
    public static final CardAdapterActionType SetContentReaction = null;
    public static final CardAdapterActionType SetReaction = null;
    public static final CardAdapterActionType SetTranslateIcon = null;
    public static final /* synthetic */ CardAdapterActionType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CardAdapterActionType> getEntries() {
        return b;
    }

    static {
        CardAdapterActionType r0 = new CardAdapterActionType("SetAnim", 0);
        SetAnim = r0;
        CardAdapterActionType r1 = new CardAdapterActionType("SetReaction", 1);
        SetReaction = r1;
        CardAdapterActionType r3 = new CardAdapterActionType("SetContentReaction", 2);
        SetContentReaction = r3;
        CardAdapterActionType r5 = new CardAdapterActionType("SetTranslateIcon", 3);
        SetTranslateIcon = r5;
        CardAdapterActionType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static CardAdapterActionType[] values() {
        return (CardAdapterActionType[]) a.clone();
    }

    public static CardAdapterActionType valueOf(String r1) {
        return (CardAdapterActionType) a.a(CardAdapterActionType.class, r1);
    }

    public CardAdapterActionType(String r1, int r2) {
        super(r1, r2);
    }
}
