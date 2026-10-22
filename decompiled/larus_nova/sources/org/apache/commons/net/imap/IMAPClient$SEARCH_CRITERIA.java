package org.apache.commons.net.imap;

import com.bytedance.android.ec.model.response.anchorv3.PromotionCrossBorderStruct;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum IMAPClient$SEARCH_CRITERIA extends Enum<IMAPClient$SEARCH_CRITERIA> {
    private static final /* synthetic */ IMAPClient$SEARCH_CRITERIA[] $VALUES = null;
    public static final IMAPClient$SEARCH_CRITERIA ALL = null;
    public static final IMAPClient$SEARCH_CRITERIA ANSWERED = null;
    public static final IMAPClient$SEARCH_CRITERIA BCC = null;
    public static final IMAPClient$SEARCH_CRITERIA BEFORE = null;
    public static final IMAPClient$SEARCH_CRITERIA BODY = null;
    public static final IMAPClient$SEARCH_CRITERIA CC = null;
    public static final IMAPClient$SEARCH_CRITERIA DELETED = null;
    public static final IMAPClient$SEARCH_CRITERIA DRAFT = null;
    public static final IMAPClient$SEARCH_CRITERIA FLAGGED = null;
    public static final IMAPClient$SEARCH_CRITERIA FROM = null;
    public static final IMAPClient$SEARCH_CRITERIA HEADER = null;
    public static final IMAPClient$SEARCH_CRITERIA KEYWORD = null;
    public static final IMAPClient$SEARCH_CRITERIA LARGER = null;
    public static final IMAPClient$SEARCH_CRITERIA NEW = null;
    public static final IMAPClient$SEARCH_CRITERIA NOT = null;
    public static final IMAPClient$SEARCH_CRITERIA OLD = null;
    public static final IMAPClient$SEARCH_CRITERIA ON = null;
    public static final IMAPClient$SEARCH_CRITERIA OR = null;
    public static final IMAPClient$SEARCH_CRITERIA RECENT = null;
    public static final IMAPClient$SEARCH_CRITERIA SEEN = null;
    public static final IMAPClient$SEARCH_CRITERIA SENTBEFORE = null;
    public static final IMAPClient$SEARCH_CRITERIA SENTON = null;
    public static final IMAPClient$SEARCH_CRITERIA SENTSINCE = null;
    public static final IMAPClient$SEARCH_CRITERIA SINCE = null;
    public static final IMAPClient$SEARCH_CRITERIA SMALLER = null;
    public static final IMAPClient$SEARCH_CRITERIA SUBJECT = null;
    public static final IMAPClient$SEARCH_CRITERIA TEXT = null;
    public static final IMAPClient$SEARCH_CRITERIA TO = null;
    public static final IMAPClient$SEARCH_CRITERIA UID = null;
    public static final IMAPClient$SEARCH_CRITERIA UNANSWERED = null;
    public static final IMAPClient$SEARCH_CRITERIA UNDELETED = null;
    public static final IMAPClient$SEARCH_CRITERIA UNDRAFT = null;
    public static final IMAPClient$SEARCH_CRITERIA UNFLAGGED = null;
    public static final IMAPClient$SEARCH_CRITERIA UNKEYWORD = null;
    public static final IMAPClient$SEARCH_CRITERIA UNSEEN = null;

    static {
        IMAPClient$SEARCH_CRITERIA r100 = new IMAPClient$SEARCH_CRITERIA(AccountType.ALL, 0);
        ALL = r100;
        IMAPClient$SEARCH_CRITERIA r101 = new IMAPClient$SEARCH_CRITERIA("ANSWERED", 1);
        ANSWERED = r101;
        IMAPClient$SEARCH_CRITERIA r102 = new IMAPClient$SEARCH_CRITERIA("BCC", 2);
        BCC = r102;
        IMAPClient$SEARCH_CRITERIA r103 = new IMAPClient$SEARCH_CRITERIA("BEFORE", 3);
        BEFORE = r103;
        IMAPClient$SEARCH_CRITERIA r104 = new IMAPClient$SEARCH_CRITERIA("BODY", 4);
        BODY = r104;
        IMAPClient$SEARCH_CRITERIA r105 = new IMAPClient$SEARCH_CRITERIA(PromotionCrossBorderStruct.CLEAR_CC_TYPE, 5);
        CC = r105;
        IMAPClient$SEARCH_CRITERIA r110 = new IMAPClient$SEARCH_CRITERIA("DELETED", 6);
        DELETED = r110;
        IMAPClient$SEARCH_CRITERIA r111 = new IMAPClient$SEARCH_CRITERIA("DRAFT", 7);
        DRAFT = r111;
        IMAPClient$SEARCH_CRITERIA r112 = new IMAPClient$SEARCH_CRITERIA("FLAGGED", 8);
        FLAGGED = r112;
        IMAPClient$SEARCH_CRITERIA r113 = new IMAPClient$SEARCH_CRITERIA("FROM", 9);
        FROM = r113;
        IMAPClient$SEARCH_CRITERIA r114 = new IMAPClient$SEARCH_CRITERIA("HEADER", 10);
        HEADER = r114;
        IMAPClient$SEARCH_CRITERIA r115 = new IMAPClient$SEARCH_CRITERIA("KEYWORD", 11);
        KEYWORD = r115;
        IMAPClient$SEARCH_CRITERIA r106 = new IMAPClient$SEARCH_CRITERIA("LARGER", 12);
        LARGER = r106;
        IMAPClient$SEARCH_CRITERIA r107 = new IMAPClient$SEARCH_CRITERIA("NEW", 13);
        NEW = r107;
        IMAPClient$SEARCH_CRITERIA r108 = new IMAPClient$SEARCH_CRITERIA("NOT", 14);
        NOT = r108;
        IMAPClient$SEARCH_CRITERIA r109 = new IMAPClient$SEARCH_CRITERIA("OLD", 15);
        OLD = r109;
        IMAPClient$SEARCH_CRITERIA r116 = new IMAPClient$SEARCH_CRITERIA("ON", 16);
        ON = r116;
        IMAPClient$SEARCH_CRITERIA r117 = new IMAPClient$SEARCH_CRITERIA("OR", 17);
        OR = r117;
        IMAPClient$SEARCH_CRITERIA r118 = new IMAPClient$SEARCH_CRITERIA("RECENT", 18);
        RECENT = r118;
        IMAPClient$SEARCH_CRITERIA r119 = new IMAPClient$SEARCH_CRITERIA("SEEN", 19);
        SEEN = r119;
        IMAPClient$SEARCH_CRITERIA r120 = new IMAPClient$SEARCH_CRITERIA("SENTBEFORE", 20);
        SENTBEFORE = r120;
        IMAPClient$SEARCH_CRITERIA r121 = new IMAPClient$SEARCH_CRITERIA("SENTON", 21);
        SENTON = r121;
        IMAPClient$SEARCH_CRITERIA r122 = new IMAPClient$SEARCH_CRITERIA("SENTSINCE", 22);
        SENTSINCE = r122;
        IMAPClient$SEARCH_CRITERIA r123 = new IMAPClient$SEARCH_CRITERIA("SINCE", 23);
        SINCE = r123;
        IMAPClient$SEARCH_CRITERIA r124 = new IMAPClient$SEARCH_CRITERIA("SMALLER", 24);
        SMALLER = r124;
        IMAPClient$SEARCH_CRITERIA r125 = new IMAPClient$SEARCH_CRITERIA("SUBJECT", 25);
        SUBJECT = r125;
        IMAPClient$SEARCH_CRITERIA r126 = new IMAPClient$SEARCH_CRITERIA(CardAdapter.TEXT, 26);
        TEXT = r126;
        IMAPClient$SEARCH_CRITERIA r127 = new IMAPClient$SEARCH_CRITERIA("TO", 27);
        TO = r127;
        IMAPClient$SEARCH_CRITERIA r128 = new IMAPClient$SEARCH_CRITERIA("UID", 28);
        UID = r128;
        IMAPClient$SEARCH_CRITERIA r129 = new IMAPClient$SEARCH_CRITERIA("UNANSWERED", 29);
        UNANSWERED = r129;
        IMAPClient$SEARCH_CRITERIA r130 = new IMAPClient$SEARCH_CRITERIA("UNDELETED", 30);
        UNDELETED = r130;
        IMAPClient$SEARCH_CRITERIA r131 = new IMAPClient$SEARCH_CRITERIA("UNDRAFT", 31);
        UNDRAFT = r131;
        IMAPClient$SEARCH_CRITERIA r132 = new IMAPClient$SEARCH_CRITERIA("UNFLAGGED", 32);
        UNFLAGGED = r132;
        IMAPClient$SEARCH_CRITERIA r133 = new IMAPClient$SEARCH_CRITERIA("UNKEYWORD", 33);
        UNKEYWORD = r133;
        IMAPClient$SEARCH_CRITERIA r134 = new IMAPClient$SEARCH_CRITERIA("UNSEEN", 34);
        UNSEEN = r134;
        $VALUES = new IMAPClient$SEARCH_CRITERIA[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134};
    }

    public static IMAPClient$SEARCH_CRITERIA[] values() {
        return (IMAPClient$SEARCH_CRITERIA[]) $VALUES.clone();
    }

    public static IMAPClient$SEARCH_CRITERIA valueOf(String r100) {
        return (IMAPClient$SEARCH_CRITERIA) a.a(IMAPClient$SEARCH_CRITERIA.class, r100);
    }

    private IMAPClient$SEARCH_CRITERIA(String r100, int r101) {
        super(r100, r101);
    }
}
