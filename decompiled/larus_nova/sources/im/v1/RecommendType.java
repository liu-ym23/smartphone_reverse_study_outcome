package im.v1;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum RecommendType extends Enum<RecommendType> implements WireEnum {
    private static final /* synthetic */ RecommendType[] $VALUES = null;
    public static final RecommendType ACTIVITY = null;
    public static final ProtoAdapter<RecommendType> ADAPTER = null;
    public static final RecommendType AIReplyQuery = null;
    public static final RecommendType ClientFollowUp = null;
    public static final RecommendType ContentBasedReco = null;
    public static final RecommendType DEFAULT = null;
    public static final RecommendType DEFAULT_QUESTIONS = null;
    public static final RecommendType DocCommentsBasedReco = null;
    public static final RecommendType DocContentRetrieveReco = null;
    public static final RecommendType DocItemCF = null;
    public static final RecommendType DocLatestComment = null;
    public static final RecommendType EnterpriseProfile = null;
    public static final RecommendType FastDocItemCF = null;
    public static final RecommendType FastDocItemCFV2 = null;
    public static final RecommendType File = null;
    public static final RecommendType HELP_DESK = null;
    public static final RecommendType HistoricalFollowUp = null;
    public static final RecommendType HotDoc = null;
    public static final RecommendType HotNews = null;
    public static final RecommendType InquisitDoc = null;
    public static final RecommendType ItemCF = null;
    public static final RecommendType LLMAsRS = null;
    public static final RecommendType MIND_READER = null;
    public static final RecommendType Minutes = null;
    public static final RecommendType ONBOARDING = null;
    public static final RecommendType Operational = null;
    public static final RecommendType PROJECT = null;
    public static final RecommendType RECENT_EDITED_DOCS = null;
    public static final RecommendType RECENT_MSGS = null;
    public static final RecommendType RecentSharedDoc = null;
    public static final RecommendType RecentViewedDoc = null;
    public static final RecommendType RecentViewedDocV2 = null;
    public static final RecommendType RelatedDocTitle = null;
    public static final RecommendType SPECIFIED_DOCS = null;
    public static final RecommendType SafeTy = null;
    public static final RecommendType SugCommand = null;
    public static final RecommendType SugLLMGene = null;
    public static final RecommendType SugLLMGeneRefKnow = null;
    public static final RecommendType SugLLMGeneRefSug = null;
    public static final RecommendType SummaryMindReader = null;
    public static final RecommendType UserCF = null;
    public static final RecommendType UserProfile = null;
    public static final RecommendType UserQuestionCF = null;
    public static final RecommendType ViewedDocsBasedReco = null;
    private final int value;

    static {
        RecommendType r100 = new RecommendType("PROJECT", 0, 1);
        PROJECT = r100;
        RecommendType r101 = new RecommendType("MIND_READER", 1, 2);
        MIND_READER = r101;
        RecommendType r102 = new RecommendType(BannerBizName.ACTIVITY, 2, 3);
        ACTIVITY = r102;
        RecommendType r103 = new RecommendType("HotDoc", 3, 4);
        HotDoc = r103;
        RecommendType r104 = new RecommendType("UserProfile", 4, 5);
        UserProfile = r104;
        RecommendType r105 = new RecommendType("RecentViewedDoc", 5, 6);
        RecentViewedDoc = r105;
        RecommendType r110 = new RecommendType("RecentSharedDoc", 6, 7);
        RecentSharedDoc = r110;
        RecommendType r111 = new RecommendType("SafeTy", 7, 8);
        SafeTy = r111;
        RecommendType r112 = new RecommendType("UserCF", 8, 9);
        UserCF = r112;
        RecommendType r113 = new RecommendType("ItemCF", 9, 10);
        ItemCF = r113;
        RecommendType r114 = new RecommendType("ClientFollowUp", 10, 11);
        ClientFollowUp = r114;
        RecommendType r115 = new RecommendType("SugLLMGene", 11, 12);
        SugLLMGene = r115;
        RecommendType r106 = new RecommendType("DocItemCF", 12, 13);
        DocItemCF = r106;
        RecommendType r107 = new RecommendType("EnterpriseProfile", 13, 14);
        EnterpriseProfile = r107;
        RecommendType r108 = new RecommendType("RelatedDocTitle", 14, 15);
        RelatedDocTitle = r108;
        RecommendType r109 = new RecommendType("ONBOARDING", 15, 16);
        ONBOARDING = r109;
        RecommendType r116 = new RecommendType("FastDocItemCF", 16, 17);
        FastDocItemCF = r116;
        RecommendType r117 = new RecommendType("SugLLMGeneRefSug", 17, 18);
        SugLLMGeneRefSug = r117;
        RecommendType r118 = new RecommendType("SummaryMindReader", 18, 19);
        SummaryMindReader = r118;
        RecommendType r119 = new RecommendType("ContentBasedReco", 19, 20);
        ContentBasedReco = r119;
        RecommendType r120 = new RecommendType("AIReplyQuery", 20, 21);
        AIReplyQuery = r120;
        RecommendType r121 = new RecommendType("FastDocItemCFV2", 21, 22);
        FastDocItemCFV2 = r121;
        RecommendType r122 = new RecommendType("SugCommand", 22, 23);
        SugCommand = r122;
        RecommendType r123 = new RecommendType("RecentViewedDocV2", 23, 24);
        RecentViewedDocV2 = r123;
        RecommendType r124 = new RecommendType("UserQuestionCF", 24, 25);
        UserQuestionCF = r124;
        RecommendType r125 = new RecommendType("HistoricalFollowUp", 25, 26);
        HistoricalFollowUp = r125;
        RecommendType r126 = new RecommendType("Operational", 26, 27);
        Operational = r126;
        RecommendType r127 = new RecommendType("SugLLMGeneRefKnow", 27, 28);
        SugLLMGeneRefKnow = r127;
        RecommendType r128 = new RecommendType("DocCommentsBasedReco", 28, 29);
        DocCommentsBasedReco = r128;
        RecommendType r129 = new RecommendType("DocLatestComment", 29, 30);
        DocLatestComment = r129;
        RecommendType r130 = new RecommendType("HotNews", 30, 31);
        HotNews = r130;
        RecommendType r131 = new RecommendType("LLMAsRS", 31, 32);
        LLMAsRS = r131;
        RecommendType r132 = new RecommendType("DocContentRetrieveReco", 32, 33);
        DocContentRetrieveReco = r132;
        RecommendType r133 = new RecommendType("InquisitDoc", 33, 34);
        InquisitDoc = r133;
        RecommendType r134 = new RecommendType("ViewedDocsBasedReco", 34, 35);
        ViewedDocsBasedReco = r134;
        RecommendType r135 = new RecommendType("Minutes", 35, 36);
        Minutes = r135;
        RecommendType r136 = new RecommendType(SpeechEngineDefines.RECORDER_TYPE_FILE, 36, 37);
        File = r136;
        RecommendType r137 = new RecommendType("DEFAULT_QUESTIONS", 37, 250);
        DEFAULT_QUESTIONS = r137;
        RecommendType r138 = new RecommendType("RECENT_EDITED_DOCS", 38, 251);
        RECENT_EDITED_DOCS = r138;
        RecommendType r139 = new RecommendType("SPECIFIED_DOCS", 39, 252);
        SPECIFIED_DOCS = r139;
        RecommendType r140 = new RecommendType("RECENT_MSGS", 40, 253);
        RECENT_MSGS = r140;
        RecommendType r141 = new RecommendType("HELP_DESK", 41, 254);
        HELP_DESK = r141;
        RecommendType r142 = new RecommendType("DEFAULT", 42, 255);
        DEFAULT = r142;
        $VALUES = new RecommendType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142};
        ADAPTER = ProtoAdapter.newEnumAdapter(RecommendType.class);
    }

    public static RecommendType[] values() {
        return (RecommendType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static RecommendType fromValue(int r100) {
        switch(r100) {
            case 1: goto L91;
            case 2: goto L89;
            case 3: goto L87;
            case 4: goto L85;
            case 5: goto L83;
            case 6: goto L81;
            case 7: goto L79;
            case 8: goto L77;
            case 9: goto L75;
            case 10: goto L73;
            case 11: goto L71;
            case 12: goto L69;
            case 13: goto L67;
            case 14: goto L65;
            case 15: goto L63;
            case 16: goto L61;
            case 17: goto L59;
            case 18: goto L57;
            case 19: goto L55;
            case 20: goto L53;
            case 21: goto L51;
            case 22: goto L49;
            case 23: goto L47;
            case 24: goto L45;
            case 25: goto L43;
            case 26: goto L41;
            case 27: goto L39;
            case 28: goto L37;
            case 29: goto L35;
            case 30: goto L33;
            case 31: goto L31;
            case 32: goto L29;
            case 33: goto L27;
            case 34: goto L25;
            case 35: goto L23;
            case 36: goto L21;
            case 37: goto L19;
            default: goto L3;
        };
    L3:
        switch(r100) {
            case 250: goto L17;
            case 251: goto L15;
            case 252: goto L13;
            case 253: goto L11;
            case 254: goto L9;
            case 255: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return DEFAULT;
    L9:
        return HELP_DESK;
    L11:
        return RECENT_MSGS;
    L13:
        return SPECIFIED_DOCS;
    L15:
        return RECENT_EDITED_DOCS;
    L17:
        return DEFAULT_QUESTIONS;
    L19:
        return File;
    L21:
        return Minutes;
    L23:
        return ViewedDocsBasedReco;
    L25:
        return InquisitDoc;
    L27:
        return DocContentRetrieveReco;
    L29:
        return LLMAsRS;
    L31:
        return HotNews;
    L33:
        return DocLatestComment;
    L35:
        return DocCommentsBasedReco;
    L37:
        return SugLLMGeneRefKnow;
    L39:
        return Operational;
    L41:
        return HistoricalFollowUp;
    L43:
        return UserQuestionCF;
    L45:
        return RecentViewedDocV2;
    L47:
        return SugCommand;
    L49:
        return FastDocItemCFV2;
    L51:
        return AIReplyQuery;
    L53:
        return ContentBasedReco;
    L55:
        return SummaryMindReader;
    L57:
        return SugLLMGeneRefSug;
    L59:
        return FastDocItemCF;
    L61:
        return ONBOARDING;
    L63:
        return RelatedDocTitle;
    L65:
        return EnterpriseProfile;
    L67:
        return DocItemCF;
    L69:
        return SugLLMGene;
    L71:
        return ClientFollowUp;
    L73:
        return ItemCF;
    L75:
        return UserCF;
    L77:
        return SafeTy;
    L79:
        return RecentSharedDoc;
    L81:
        return RecentViewedDoc;
    L83:
        return UserProfile;
    L85:
        return HotDoc;
    L87:
        return ACTIVITY;
    L89:
        return MIND_READER;
    L91:
        return PROJECT;
    }

    public static RecommendType valueOf(String r100) {
        return (RecommendType) a.a(RecommendType.class, r100);
    }

    private RecommendType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
