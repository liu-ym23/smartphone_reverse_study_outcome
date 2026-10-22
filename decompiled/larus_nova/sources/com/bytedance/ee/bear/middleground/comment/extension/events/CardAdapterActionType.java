package com.bytedance.ee.bear.middleground.comment.extension.events;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/extension/events/CardAdapterActionType;", "", "<init>", "(Ljava/lang/String;I)V", "SetAnim", "SetReaction", "SetContentReaction", "SetTranslateIcon", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CardAdapterActionType extends Enum<CardAdapterActionType> {
    public static final CardAdapterActionType SetAnim = null;
    public static final CardAdapterActionType SetContentReaction = null;
    public static final CardAdapterActionType SetReaction = null;
    public static final CardAdapterActionType SetTranslateIcon = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardAdapterActionType[] f231579a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f231580b = null;

    public static EnumEntries<CardAdapterActionType> getEntries() {
        return f231580b;
    }

    static {
        CardAdapterActionType r100 = new CardAdapterActionType("SetAnim", 0);
        SetAnim = r100;
        CardAdapterActionType r101 = new CardAdapterActionType("SetReaction", 1);
        SetReaction = r101;
        CardAdapterActionType r102 = new CardAdapterActionType("SetContentReaction", 2);
        SetContentReaction = r102;
        CardAdapterActionType r103 = new CardAdapterActionType("SetTranslateIcon", 3);
        SetTranslateIcon = r103;
        CardAdapterActionType[] r104 = {r100, r101, r102, r103};
        f231579a = r104;
        f231580b = EnumEntriesKt.enumEntries(r104);
    }

    public static CardAdapterActionType[] values() {
        return (CardAdapterActionType[]) f231579a.clone();
    }

    public static CardAdapterActionType valueOf(String r100) {
        return (CardAdapterActionType) a.a(CardAdapterActionType.class, r100);
    }

    public CardAdapterActionType(String r100, int r101) {
        super(r100, r101);
    }
}
