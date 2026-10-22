package com.bytedance.ee.bear.middleground.comment.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/CardCommentHeight;", "", "<init>", "(Ljava/lang/String;I)V", "MAX", "DEFAULT", "SHRINK", "MIN", "SHRINK_ONE_LEVEL", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CardCommentHeight extends Enum<CardCommentHeight> {
    public static final CardCommentHeight DEFAULT = null;
    public static final CardCommentHeight MAX = null;
    public static final CardCommentHeight MIN = null;
    public static final CardCommentHeight SHRINK = null;
    public static final CardCommentHeight SHRINK_ONE_LEVEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardCommentHeight[] f231302a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f231303b = null;

    public static EnumEntries<CardCommentHeight> getEntries() {
        return f231303b;
    }

    static {
        CardCommentHeight r100 = new CardCommentHeight("MAX", 0);
        MAX = r100;
        CardCommentHeight r101 = new CardCommentHeight("DEFAULT", 1);
        DEFAULT = r101;
        CardCommentHeight r102 = new CardCommentHeight("SHRINK", 2);
        SHRINK = r102;
        CardCommentHeight r103 = new CardCommentHeight("MIN", 3);
        MIN = r103;
        CardCommentHeight r104 = new CardCommentHeight("SHRINK_ONE_LEVEL", 4);
        SHRINK_ONE_LEVEL = r104;
        CardCommentHeight[] r105 = {r100, r101, r102, r103, r104};
        f231302a = r105;
        f231303b = EnumEntriesKt.enumEntries(r105);
    }

    public static CardCommentHeight[] values() {
        return (CardCommentHeight[]) f231302a.clone();
    }

    public static CardCommentHeight valueOf(String r100) {
        return (CardCommentHeight) r27.a.a(CardCommentHeight.class, r100);
    }

    public CardCommentHeight(String r100, int r101) {
        super(r100, r101);
    }
}
