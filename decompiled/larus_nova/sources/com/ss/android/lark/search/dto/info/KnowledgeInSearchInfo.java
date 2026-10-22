package com.ss.android.lark.search.dto.info;

import com.larksuite.framework.utils.f0;
import com.ss.android.lark.pb.ai_topic_stream_search.QueryIntentionType;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 o2\u00020\u0001:\u0002opB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010c\u001a\u00020\u0018H\u0016J\b\u0010d\u001a\u00020\u0018H\u0016J\u0014\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020g0fH\u0016J$\u0010h\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020g0ij\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020g`jH\u0016J$\u0010k\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020g0ij\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020g`jH\u0016J\b\u0010l\u001a\u00020\u0018H\u0016J\u0013\u0010m\u001a\u00020\u00052\b\u0010n\u001a\u0004\u0018\u00010gH\u0096\u0002R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\u001a\u0010,\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR\u001a\u0010/\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR\u001a\u00102\u001a\u000203X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001cR\u001a\u0010;\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\b\"\u0004\b=\u0010\nR\u001a\u0010>\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\b\"\u0004\b@\u0010\nR\u001a\u0010A\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\b\"\u0004\bB\u0010\nR\u001a\u0010C\u001a\u00020DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\b\"\u0004\bJ\u0010\nR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010Q\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\b\"\u0004\bS\u0010\nR\u001a\u0010T\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\b\"\u0004\bV\u0010\nR\u001a\u0010W\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u001a\"\u0004\bY\u0010\u001cR\u001a\u0010Z\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\b\"\u0004\b\\\u0010\nR\u001c\u0010]\u001a\u0004\u0018\u00010^X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010b¨\u0006q"}, d2 = {"Lcom/ss/android/lark/search/dto/info/KnowledgeInSearchInfo;", "Lcom/ss/android/lark/search/dto/info/SearchAiInfo;", "<init>", "()V", "value", "", "normalStyle", "getNormalStyle", "()Z", "setNormalStyle", "(Z)V", "searchPosition", "Lcom/ss/android/lark/search/dto/info/KnowledgeSearchPosition;", "getSearchPosition", "()Lcom/ss/android/lark/search/dto/info/KnowledgeSearchPosition;", "setSearchPosition", "(Lcom/ss/android/lark/search/dto/info/KnowledgeSearchPosition;)V", "preferredAnchor", "Lcom/ss/android/lark/search/dto/info/KnowledgeInSearchInfo$KnowledgePreferredAnchor;", "getPreferredAnchor", "()Lcom/ss/android/lark/search/dto/info/KnowledgeInSearchInfo$KnowledgePreferredAnchor;", "setPreferredAnchor", "(Lcom/ss/android/lark/search/dto/info/KnowledgeInSearchInfo$KnowledgePreferredAnchor;)V", "rewriteContent", "", "getRewriteContent", "()Ljava/lang/String;", "setRewriteContent", "(Ljava/lang/String;)V", "aiTopicId", "", "getAiTopicId", "()J", "setAiTopicId", "(J)V", "aiRoundId", "getAiRoundId", "setAiRoundId", "aiAnswerId", "getAiAnswerId", "setAiAnswerId", "actionButtonText", "getActionButtonText", "setActionButtonText", "actionButtonDesc", "getActionButtonDesc", "setActionButtonDesc", "actionButtonApplink", "getActionButtonApplink", "setActionButtonApplink", "userClickType", "Lcom/ss/android/lark/search/dto/info/KnowledgeUserClickType;", "getUserClickType", "()Lcom/ss/android/lark/search/dto/info/KnowledgeUserClickType;", "setUserClickType", "(Lcom/ss/android/lark/search/dto/info/KnowledgeUserClickType;)V", "clickReferenceID", "getClickReferenceID", "setClickReferenceID", "userClickEnterprise", "getUserClickEnterprise", "setUserClickEnterprise", "userClickInternet", "getUserClickInternet", "setUserClickInternet", "isWaitingJumpForRequest", "setWaitingJumpForRequest", "roundStatus", "", "getRoundStatus", "()I", "setRoundStatus", "(I)V", "isDefaultType", "setDefaultType", "queryIntentionTypeForReportHistory", "Lcom/ss/android/lark/pb/ai_topic_stream_search/QueryIntentionType;", "getQueryIntentionTypeForReportHistory", "()Lcom/ss/android/lark/pb/ai_topic_stream_search/QueryIntentionType;", "setQueryIntentionTypeForReportHistory", "(Lcom/ss/android/lark/pb/ai_topic_stream_search/QueryIntentionType;)V", "shouldAnswerForReportHistory", "getShouldAnswerForReportHistory", "setShouldAnswerForReportHistory", "reportedHistory", "getReportedHistory", "setReportedHistory", "searchTypeForEvent", "getSearchTypeForEvent", "setSearchTypeForEvent", "canJumpToDoubao", "getCanJumpToDoubao", "setCanJumpToDoubao", "doubaoLocalMsg", "Lcom/ss/android/lark/search/dto/info/KnowledgeLocalMessage;", "getDoubaoLocalMsg", "()Lcom/ss/android/lark/search/dto/info/KnowledgeLocalMessage;", "setDoubaoLocalMsg", "(Lcom/ss/android/lark/search/dto/info/KnowledgeLocalMessage;)V", "getTagForReport", "getResultTypeForReport", "getExtraParams", "", "", "getClickEventExtraParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getShowEventExtraParams", "getSubResultTypeForReport", "equals", "other", "Companion", "KnowledgePreferredAnchor", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KnowledgeInSearchInfo extends SearchAiInfo {
    public static final a Companion = null;
    public static final String HAS_RESULT_ID = "enterprise_qa_result";
    public static final String TAG = "KnowledgeInSearchInfo";
    private String actionButtonApplink;
    private String actionButtonDesc;
    private String actionButtonText;
    private long aiAnswerId;
    private long aiRoundId;
    private long aiTopicId;
    private boolean canJumpToDoubao;
    private String clickReferenceID;
    private com.ss.android.lark.search.dto.info.b doubaoLocalMsg;
    private boolean isDefaultType;
    private boolean isWaitingJumpForRequest;
    private boolean normalStyle;
    private KnowledgePreferredAnchor preferredAnchor;
    private QueryIntentionType queryIntentionTypeForReportHistory;
    private boolean reportedHistory;
    private String rewriteContent;
    private int roundStatus;
    private KnowledgeSearchPosition searchPosition;
    private String searchTypeForEvent;
    private boolean shouldAnswerForReportHistory;
    private boolean userClickEnterprise;
    private boolean userClickInternet;
    private KnowledgeUserClickType userClickType;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/search/dto/info/KnowledgeInSearchInfo$KnowledgePreferredAnchor;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", "AFTER_SPOTLIGHT", "AFTER_SECTION", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum KnowledgePreferredAnchor extends Enum<KnowledgePreferredAnchor> {
        public static final KnowledgePreferredAnchor AFTER_SECTION = null;
        public static final KnowledgePreferredAnchor AFTER_SPOTLIGHT = null;
        public static final KnowledgePreferredAnchor TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KnowledgePreferredAnchor[] f440153a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f440154b = null;

        public static EnumEntries<KnowledgePreferredAnchor> getEntries() {
            return f440154b;
        }

        static {
            KnowledgePreferredAnchor r100 = new KnowledgePreferredAnchor("TOP", 0);
            TOP = r100;
            KnowledgePreferredAnchor r101 = new KnowledgePreferredAnchor("AFTER_SPOTLIGHT", 1);
            AFTER_SPOTLIGHT = r101;
            KnowledgePreferredAnchor r102 = new KnowledgePreferredAnchor("AFTER_SECTION", 2);
            AFTER_SECTION = r102;
            KnowledgePreferredAnchor[] r103 = {r100, r101, r102};
            f440153a = r103;
            f440154b = EnumEntriesKt.enumEntries(r103);
        }

        public static KnowledgePreferredAnchor[] values() {
            return (KnowledgePreferredAnchor[]) f440153a.clone();
        }

        public static KnowledgePreferredAnchor valueOf(String r100) {
            return (KnowledgePreferredAnchor) r27.a.a(KnowledgePreferredAnchor.class, r100);
        }

        public KnowledgePreferredAnchor(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f440155a = null;

        static {
            int[] r100 = new int[KnowledgeUserClickType.values().length];
            r100[KnowledgeUserClickType.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r100[KnowledgeUserClickType.DEFAULT_BACK_UP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r100[KnowledgeUserClickType.SECTION_TITLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[KnowledgeUserClickType.GO_TO_MAIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[KnowledgeUserClickType.UNFOLD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r100[KnowledgeUserClickType.FOLD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[KnowledgeUserClickType.REFRENCE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r100[KnowledgeUserClickType.LOADING_STATE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r100[KnowledgeUserClickType.ANSWER_CONTENT.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[KnowledgeUserClickType.CHAT_JUMP.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f440155a = r100;
        }
    }

    static {
        Companion = new a();
    }

    public final com.ss.android.lark.search.dto.info.b getDoubaoLocalMsg() {
        return null;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        return SearchAiInfo.DEFAULT_ID;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getTagForReport() {
        return "enterprise_qa_section";
    }

    public final void setDoubaoLocalMsg(com.ss.android.lark.search.dto.info.b r100) {
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public HashMap<String, Object> getClickEventExtraParams() {
        HashMap<String, Object> r100 = new HashMap();
        JSONObject r101 = new JSONObject();
        KnowledgeUserClickType r102 = this.userClickType;
        if (r102 != KnowledgeUserClickType.GO_TO_MAIN) goto L5;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        r101.put("is_display_redpacket", isShowingHongBao());
        r101.put("is_new", isNewUserForHongBao());
    L13:
        r100.put("sub_click_detail", r101);
        return r100;
    L5:
        if (r102 == KnowledgeUserClickType.UNFOLD) goto L10;
        if (r102 == KnowledgeUserClickType.DEFAULT_BACK_UP) goto L10;
        r103 = false;
        goto L11
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public Map<String, Object> getExtraParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("search_type", this.searchTypeForEvent);
        long r101 = this.aiRoundId;
        if (r101 == 0) goto L6;
        r100.put("ai_round_id", String.valueOf(r101));
    L6:
        if (this.userClickType != KnowledgeUserClickType.REFRENCE) goto L8;
        r100.put("sub_entity_id", this.clickReferenceID);
    L8:
        return r100;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public HashMap<String, Object> getShowEventExtraParams() {
        HashMap<String, Object> r100 = new HashMap();
        if (this.isDefaultType == false) goto L5;
        r100.put("is_display_redpacket", Boolean.valueOf(isShowingHongBao()));
    L5:
        return r100;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getSubResultTypeForReport() {
        KnowledgeUserClickType r100 = this.userClickType;
        switch(b.f440155a[r100.ordinal()]) {
            case 1: goto L15;
            case 2: goto L25;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            case 8: goto L7;
            case 9: goto L6;
            case 10: goto L5;
            default: goto L16;
        };
    L5:
        return "jump_main_chat";
    L6:
        return "click_blank_area";
    L7:
        return "loading_card";
    L8:
        return "reference";
    L9:
        return "fold";
    L10:
        return "unfold";
    L11:
        return "go_to_main_chat";
    L12:
        return "title";
    L16:
        return super.getSubResultTypeForReport();
    L25:
        return super.getSubResultTypeForReport();
    L15:
        return super.getSubResultTypeForReport();
    }

    public KnowledgeInSearchInfo() {
        this.searchPosition = KnowledgeSearchPosition.UNKNOWN;
        this.rewriteContent = "";
        this.actionButtonText = "";
        this.actionButtonDesc = "";
        this.actionButtonApplink = "";
        this.userClickType = KnowledgeUserClickType.UNKNOWN;
        this.clickReferenceID = "";
        this.searchTypeForEvent = "";
        this.canJumpToDoubao = true;
    }

    public final String getActionButtonApplink() {
        return this.actionButtonApplink;
    }

    public final String getActionButtonDesc() {
        return this.actionButtonDesc;
    }

    public final String getActionButtonText() {
        return this.actionButtonText;
    }

    public final long getAiAnswerId() {
        return this.aiAnswerId;
    }

    public final long getAiRoundId() {
        return this.aiRoundId;
    }

    public final long getAiTopicId() {
        return this.aiTopicId;
    }

    public final boolean getCanJumpToDoubao() {
        return this.canJumpToDoubao;
    }

    public final String getClickReferenceID() {
        return this.clickReferenceID;
    }

    public final boolean getNormalStyle() {
        return this.normalStyle;
    }

    public final KnowledgePreferredAnchor getPreferredAnchor() {
        return this.preferredAnchor;
    }

    public final QueryIntentionType getQueryIntentionTypeForReportHistory() {
        return this.queryIntentionTypeForReportHistory;
    }

    public final boolean getReportedHistory() {
        return this.reportedHistory;
    }

    public final String getRewriteContent() {
        return this.rewriteContent;
    }

    public final int getRoundStatus() {
        return this.roundStatus;
    }

    public final KnowledgeSearchPosition getSearchPosition() {
        return this.searchPosition;
    }

    public final String getSearchTypeForEvent() {
        return this.searchTypeForEvent;
    }

    public final boolean getShouldAnswerForReportHistory() {
        return this.shouldAnswerForReportHistory;
    }

    public final boolean getUserClickEnterprise() {
        return this.userClickEnterprise;
    }

    public final boolean getUserClickInternet() {
        return this.userClickInternet;
    }

    public final KnowledgeUserClickType getUserClickType() {
        return this.userClickType;
    }

    public final boolean isDefaultType() {
        return this.isDefaultType;
    }

    public final boolean isWaitingJumpForRequest() {
        return this.isWaitingJumpForRequest;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public boolean equals(Object r100) {
        if (this.normalStyle == false) goto L18;
        if (super.equals(r100) == false) goto L15;
        String r101 = null;
        if ((r100 instanceof KnowledgeInSearchInfo) == false) goto L9;
        KnowledgeInSearchInfo r102 = (KnowledgeInSearchInfo) r100;
    L10:
        if (r102 == null) goto L13;
        r101 = r102.getRequestId();
    L13:
        if (f0.c(r101, getRequestId()) == false) goto L15;
        return true;
    L9:
        r102 = null;
    L15:
        return false;
    L18:
        return super.equals(r100);
    }

    public final void setActionButtonApplink(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.actionButtonApplink = r100;
    }

    public final void setActionButtonDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.actionButtonDesc = r100;
    }

    public final void setActionButtonText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.actionButtonText = r100;
    }

    public final void setAiAnswerId(long r100) {
        this.aiAnswerId = r100;
    }

    public final void setAiRoundId(long r100) {
        this.aiRoundId = r100;
    }

    public final void setAiTopicId(long r100) {
        this.aiTopicId = r100;
    }

    public final void setCanJumpToDoubao(boolean r100) {
        this.canJumpToDoubao = r100;
    }

    public final void setClickReferenceID(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.clickReferenceID = r100;
    }

    public final void setDefaultType(boolean r100) {
        this.isDefaultType = r100;
    }

    public final void setNormalStyle(boolean r100) {
        if (r100 == false) goto L4;
        String r101 = "enterprise_qa_result";
    L5:
        setId(r101);
        this.normalStyle = r100;
        return;
    L4:
        r101 = getId();
        goto L5
    }

    public final void setPreferredAnchor(KnowledgePreferredAnchor r100) {
        this.preferredAnchor = r100;
    }

    public final void setQueryIntentionTypeForReportHistory(QueryIntentionType r100) {
        this.queryIntentionTypeForReportHistory = r100;
    }

    public final void setReportedHistory(boolean r100) {
        this.reportedHistory = r100;
    }

    public final void setRewriteContent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.rewriteContent = r100;
    }

    public final void setRoundStatus(int r100) {
        this.roundStatus = r100;
    }

    public final void setSearchPosition(KnowledgeSearchPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.searchPosition = r100;
    }

    public final void setSearchTypeForEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.searchTypeForEvent = r100;
    }

    public final void setShouldAnswerForReportHistory(boolean r100) {
        this.shouldAnswerForReportHistory = r100;
    }

    public final void setUserClickEnterprise(boolean r100) {
        this.userClickEnterprise = r100;
    }

    public final void setUserClickInternet(boolean r100) {
        this.userClickInternet = r100;
    }

    public final void setUserClickType(KnowledgeUserClickType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.userClickType = r100;
    }

    public final void setWaitingJumpForRequest(boolean r100) {
        this.isWaitingJumpForRequest = r100;
    }
}
