package com.bytedance.ee.bear.list.loadstateview;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final enum EmptyCategory extends Enum<EmptyCategory> {
    public static final EmptyCategory AI_MEETING_NOTE = null;
    public static final EmptyCategory AI_MONTHLY = null;
    public static final EmptyCategory AI_RECORD_NOTE = null;
    public static final EmptyCategory AI_WEEKLY = null;
    public static final EmptyCategory BITABLE_RECENT_NORMAL = null;
    public static final EmptyCategory BITABLE_RECENT_NORMAL_HAS_NO_BENEFIT = null;
    public static final EmptyCategory BUSINESS_TEMPLATE = null;
    public static final EmptyCategory CUSTOM_TEMPLATE = null;
    public static final EmptyCategory CUSTOM_TEMPLATE_V2 = null;
    public static final int DEFAULT_VALUE = -1;
    public static final EmptyCategory FAVORITE_FILTER = null;
    public static final EmptyCategory FAVORITE_NORMAL = null;
    public static final EmptyCategory FOLDER_NORMAL = null;
    public static final EmptyCategory FOLDER_READONLY = null;
    public static final EmptyCategory FOLDER_SELECT = null;
    public static final EmptyCategory MY_SPACE_FILTER = null;
    public static final EmptyCategory MY_SPACE_NORMAL = null;
    public static final EmptyCategory OFFLINE = null;
    public static final EmptyCategory PIN = null;
    public static final EmptyCategory RECENT_FILTER = null;
    public static final EmptyCategory RECENT_NORMAL = null;
    public static final EmptyCategory SEARCH_TEMPLATE = null;
    public static final EmptyCategory SEARCH_TEMPLATE_FOR_SYSTEM = null;
    public static final EmptyCategory SHARE = null;
    public static final EmptyCategory SHARE_FOLDER = null;
    public static final EmptyCategory SINGLE_CATEGORY_TEMPLATE = null;
    public static final EmptyCategory SUBORDINATE_RECENT = null;
    public static final EmptyCategory SYSTEM_TEMPLATE = null;
    public static final EmptyCategory TEMPLATE = null;
    public static final EmptyCategory UNKNOWN = null;
    public static final EmptyCategory WIKI = null;
    public static final EmptyCategory WIKI_SPACE = null;
    public static final EmptyCategory WIKI_SPACE_MGMT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EmptyCategory[] f228618a = null;
    private final int descTextRes;
    private final int imageRes;
    private final int lintBtnTextRes;
    private final int primaryBtnTextRes;
    private final int secondaryBtnTextRes;
    private final int titleTextRes;

    static {
        EmptyCategory r100 = new EmptyCategory("PIN", 0, R.drawable.ccm_empty_neutral_no_content, -1, R.string.Doc_List_Pin_Empty_Tips, -1, -1);
        PIN = r100;
        EmptyCategory r101 = new EmptyCategory("RECENT_NORMAL", 1, R.drawable.ccm_empty_positive_document_default, -1, R.string.Doc_Facade_EmptyDocumentTips, R.string.Doc_Facade_CreateDocument, -1);
        RECENT_NORMAL = r101;
        EmptyCategory r102 = new EmptyCategory("SUBORDINATE_RECENT", 2, R.drawable.ccm_empty_positive_document_default, -1, R.string.LarkCCM_CM_LeaderAccess_NoRecents_Empty, -1, -1);
        SUBORDINATE_RECENT = r102;
        EmptyCategory r103 = new EmptyCategory("BITABLE_RECENT_NORMAL", 3, R.drawable.ccm_empty_positive_document_default, -1, R.string.Bitable_Base_ExploreBitable_Description, R.string.CreationMobile_Template_Bitable_Blanklabel, -1);
        BITABLE_RECENT_NORMAL = r103;
        EmptyCategory r104 = new EmptyCategory("BITABLE_RECENT_NORMAL_HAS_NO_BENEFIT", 4, R.drawable.ccm_empty_positive_document_default, -1, R.string.Bitable_Unbundle_NoContent_Desc, -1, -1);
        BITABLE_RECENT_NORMAL_HAS_NO_BENEFIT = r104;
        EmptyCategory r310 = new EmptyCategory("RECENT_FILTER", 5, R.drawable.ccm_empty_positive_document_default, -1, R.string.Doc_Facade_FilterEmptyDocTips, R.string.Doc_Facade_CreateDocument, -1);
        RECENT_FILTER = r310;
        EmptyCategory r210 = new EmptyCategory("MY_SPACE_NORMAL", 6, R.drawable.ccm_empty_positive_document_default, -1, R.string.Doc_Facade_EmptyDocumentTips, R.string.Doc_Facade_CreateDocument, -1);
        MY_SPACE_NORMAL = r210;
        EmptyCategory r105 = new EmptyCategory("MY_SPACE_FILTER", 7, R.drawable.ccm_empty_positive_document_default, -1, R.string.Doc_Facade_FilterEmptyDocTips, R.string.Doc_Facade_CreateDocument, -1);
        MY_SPACE_FILTER = r105;
        EmptyCategory r106 = new EmptyCategory("SHARE", 8, R.drawable.ccm_empty_neutral_no_content, -1, R.string.Doc_Facade_EmptyShareVisit, -1, -1);
        SHARE = r106;
        EmptyCategory r211 = new EmptyCategory("SHARE_FOLDER", 9, R.drawable.ccm_empty_neutral_no_content, -1, R.string.Doc_List_NoSharedFolder, -1, -1);
        SHARE_FOLDER = r211;
        EmptyCategory r107 = new EmptyCategory("FAVORITE_NORMAL", 10, R.drawable.ccm_empty_neutral_no_content, -1, R.string.Doc_Facade_NoStar, -1, -1);
        FAVORITE_NORMAL = r107;
        EmptyCategory r108 = new EmptyCategory("FAVORITE_FILTER", 11, R.drawable.ccm_empty_neutral_no_content, -1, R.string.Doc_Facade_FilterEmptyDocTips, -1, -1);
        FAVORITE_FILTER = r108;
        EmptyCategory r109 = new EmptyCategory("OFFLINE", 12, R.drawable.ccm_empty_neutral_no_content, R.string.Doc_Facade_OfflineEmptyAvailableFile, R.string.Doc_Facade_OfflineBannerTitle, -1, -1);
        OFFLINE = r109;
        EmptyCategory r110 = new EmptyCategory("FOLDER_NORMAL", 13, R.drawable.ccm_empty_positive_document_default, -1, R.string.Doc_Facade_EmptyDocumentTips, R.string.Doc_Facade_CreateDocument, -1);
        FOLDER_NORMAL = r110;
        EmptyCategory r111 = new EmptyCategory("FOLDER_READONLY", 14, R.drawable.ccm_empty_positive_document_default, -1, R.string.Doc_List_EmptyFolderInArchive, -1, -1);
        FOLDER_READONLY = r111;
        EmptyCategory r212 = new EmptyCategory("WIKI", 15, R.drawable.ccm_empty_neutral_search_failed, -1, R.string.Doc_Wiki_Home_RecentsEmptyText, -1, -1);
        WIKI = r212;
        EmptyCategory r213 = new EmptyCategory("WIKI_SPACE", 16, R.drawable.ccm_empty_neutral_search_failed, -1, R.string.LarkCCM_Wiki_Category_NoWorkspace_Empty, -1, -1);
        WIKI_SPACE = r213;
        EmptyCategory r214 = new EmptyCategory("WIKI_SPACE_MGMT", 17, R.drawable.ccm_empty_neutral_search_failed, -1, R.string.LarkCCM_Wiki_CategoryMgmt_NoSpaceHere_Empty, -1, -1);
        WIKI_SPACE_MGMT = r214;
        EmptyCategory r215 = new EmptyCategory("FOLDER_SELECT", 18, R.drawable.ccm_empty_neutral_no_content, -1, R.string.Doc_List_EmptySubFolder, -1, -1);
        FOLDER_SELECT = r215;
        EmptyCategory r311 = new EmptyCategory("UNKNOWN", 19, R.drawable.ccm_empty_neutral_no_content, -1, R.string.Doc_Facade_EmptyDocumentTips, R.string.Doc_Facade_CreateDocument, -1);
        UNKNOWN = r311;
        EmptyCategory r216 = new EmptyCategory("TEMPLATE", 20, R.drawable.ccm_empty_neutral_no_content, -1, -1, -1, -1);
        TEMPLATE = r216;
        EmptyCategory r217 = new EmptyCategory("SYSTEM_TEMPLATE", 21, R.drawable.ccm_empty_neutral_no_content, R.string.Doc_List_EmptyTemplateCategory, -1, -1, -1);
        SYSTEM_TEMPLATE = r217;
        EmptyCategory r312 = new EmptyCategory("SEARCH_TEMPLATE", 22, R.drawable.ccm_empty_neutral_search_failed, -1, R.string.CreationMobile_Template_Feedback_NoTemplateSearch, -1, -1);
        SEARCH_TEMPLATE = r312;
        EmptyCategory r112 = new EmptyCategory("SEARCH_TEMPLATE_FOR_SYSTEM", 23, R.drawable.ccm_empty_neutral_search_failed, -1, R.string.CreationMobile_Template_Feedback_NoTemplateSearch, -1, -1);
        SEARCH_TEMPLATE_FOR_SYSTEM = r112;
        EmptyCategory r113 = new EmptyCategory("SINGLE_CATEGORY_TEMPLATE", 24, R.drawable.ccm_empty_neutral_no_cloud_document, -1, R.string.Doc_List_EmptyTemplateCategory, -1, -1);
        SINGLE_CATEGORY_TEMPLATE = r113;
        EmptyCategory r114 = new EmptyCategory("CUSTOM_TEMPLATE", 25, R.drawable.ccm_empty_neutral_no_cloud_document, R.string.Doc_List_CustomTemplateGuideTitle, R.string.Doc_List_CustomTemplateGuideDescription, -1, R.string.CreationMobile_Operation_ClicktoKnowMore);
        CUSTOM_TEMPLATE = r114;
        EmptyCategory r115 = new EmptyCategory("CUSTOM_TEMPLATE_V2", 26, R.drawable.ccm_empty_neutral_no_content, R.string.Doc_List_CustomTemplateGuideTitle, R.string.Doc_List_CustomTemplateGuideDescription, -1, R.string.CreationMobile_Operation_ClicktoKnowMore);
        CUSTOM_TEMPLATE_V2 = r115;
        EmptyCategory r116 = new EmptyCategory("BUSINESS_TEMPLATE", 27, R.drawable.ccm_empty_neutral_no_content, R.string.Doc_List_EnterpriseTemplateGuideTitle, R.string.Doc_List_EnterpriseTemplateGuideDescription, -1, -1);
        BUSINESS_TEMPLATE = r116;
        EmptyCategory r510 = new EmptyCategory("AI_MONTHLY", 28, R.drawable.ccm_empty_neutral_no_content, -1, R.string.LarkCCM_AINotes_NoMonthlySummary_EmptyState, -1, -1);
        AI_MONTHLY = r510;
        EmptyCategory r218 = new EmptyCategory("AI_WEEKLY", 29, R.drawable.ccm_empty_neutral_no_content, -1, R.string.LarkCCM_AINotes_NoWeeklyRecap_EmptyState, -1, -1);
        AI_WEEKLY = r218;
        EmptyCategory r313 = new EmptyCategory("AI_MEETING_NOTE", 30, R.drawable.ccm_empty_neutral_no_content, -1, R.string.LarkCCM_AINotes_NoMeetingNotesYet_EmptyState, R.string.LarkCCM_AINotes_NewMeeting_Button, -1);
        AI_MEETING_NOTE = r313;
        EmptyCategory r117 = new EmptyCategory("AI_RECORD_NOTE", 31, R.drawable.ccm_empty_neutral_no_content, -1, R.string.LarkCCM_RecordNotes_NoRecordingNotes_EmptyState, R.string.LarkCCM_RecordNotes_StartRecording_Button, -1);
        AI_RECORD_NOTE = r117;
        f228618a = new EmptyCategory[]{r100, r101, r102, r103, r104, r310, r210, r105, r106, r211, r107, r108, r109, r110, r111, r212, r213, r214, r215, r311, r216, r217, r312, r112, r113, r114, r115, r116, r510, r218, r313, r117};
    }

    public static EmptyCategory[] values() {
        return (EmptyCategory[]) f228618a.clone();
    }

    public int getDescTextRes() {
        return this.descTextRes;
    }

    public int getImageRes() {
        return this.imageRes;
    }

    public int getLintBtnTextRes() {
        return this.lintBtnTextRes;
    }

    public int getPrimaryBtnTextRes() {
        return this.primaryBtnTextRes;
    }

    public int getSecondaryBtnTextRes() {
        return this.secondaryBtnTextRes;
    }

    public int getTitleTextRes() {
        return this.titleTextRes;
    }

    public static EmptyCategory valueOf(String r100) {
        return (EmptyCategory) r27.a.a(EmptyCategory.class, r100);
    }

    public EmptyCategory(String r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        super(r100, r101);
        this.imageRes = r102;
        this.titleTextRes = r103;
        this.descTextRes = r104;
        this.primaryBtnTextRes = r105;
        this.secondaryBtnTextRes = -1;
        this.lintBtnTextRes = r106;
    }
}
