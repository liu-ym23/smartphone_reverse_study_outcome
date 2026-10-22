package com.bytedance.ee.bear.middleground.comment.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/CardCommentHeight;", "", "<init>", "(Ljava/lang/String;I)V", "MAX", "DEFAULT", "SHRINK", "MIN", "SHRINK_ONE_LEVEL", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CardCommentHeight extends Enum<CardCommentHeight> {
    public static final CardCommentHeight DEFAULT = null;
    public static final CardCommentHeight MAX = null;
    public static final CardCommentHeight MIN = null;
    public static final CardCommentHeight SHRINK = null;
    public static final CardCommentHeight SHRINK_ONE_LEVEL = null;
    public static final /* synthetic */ CardCommentHeight[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CardCommentHeight> getEntries() {
        return b;
    }

    static {
        CardCommentHeight r0 = new CardCommentHeight("MAX", 0);
        MAX = r0;
        CardCommentHeight r1 = new CardCommentHeight("DEFAULT", 1);
        DEFAULT = r1;
        CardCommentHeight r3 = new CardCommentHeight("SHRINK", 2);
        SHRINK = r3;
        CardCommentHeight r5 = new CardCommentHeight("MIN", 3);
        MIN = r5;
        CardCommentHeight r7 = new CardCommentHeight("SHRINK_ONE_LEVEL", 4);
        SHRINK_ONE_LEVEL = r7;
        CardCommentHeight[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static CardCommentHeight[] values() {
        return (CardCommentHeight[]) a.clone();
    }

    public static CardCommentHeight valueOf(String r1) {
        return (CardCommentHeight) r27.a.a(CardCommentHeight.class, r1);
    }

    public CardCommentHeight(String r1, int r2) {
        super(r1, r2);
    }
}
