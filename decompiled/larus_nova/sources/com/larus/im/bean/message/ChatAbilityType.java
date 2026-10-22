package com.larus.im.bean.message;

import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.ITTVideoEngineInternal;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\bC\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bE¨\u0006F"}, d2 = {"Lcom/larus/im/bean/message/ChatAbilityType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ChatAbilityType_Unknown", "SKILL_WRITING", "DesExtSkillMultiWebsites", "SKILL_CALL", "SKILL_NEWS_ACTIONBAR_NAME", "SKILL_HEALTH_CONSULTATION", "SKILL_MUSIC_RANDOM_PLAY", "SKILL_RECORD", "SKILL_CALL_ENGLISH_LEARNING", "SKILL_CALL_IDIOM", "SKILL_CALL_INTERVIEW", "SKILL_CALL_TREE_HOLE", "SKILL_COMMAND", "SKILL_DAILY_NEWS", "SKILL_OLYMPIC_DAILY_CARD", "SKILL_SPEAKER", "SKILL_COMPLEX_SEARCH", "SKILL_LISTEN_PODCAST", "SKILL_CALL_VIDEO", "SKILL_CREATION_TEMPLATE_AIGENIMG", "SKILL_CREATION_TEMPLATE_AIREPLICA", "SKILL_DEEP_THINKING", "SKILL_SINGER", "SKILL_INMATE", "SKILL_ENGLISH_LEARNING", "SKILL_PODCAST_GENERATION", "SKILL_ECOM_ASSISTANT", "SKILL_COCO_TRAVEL_ASK_DOUBAO", "SKILL_SIMULTANEOUS_INTERPRETATION", "SKILL_PROBLEM_SOLVING", "SKILL_IMAGE_GENERATION", "SKILL_VIDEO_GENERATION", "SKILL_AI_PHOTO", "SKILL_WRITING_ASSISTANCE", "SKILL_MUSIC_GENERATION", "SKILL_TRANSLATION", "SKILL_REMINDER_FIRST", "SKILL_DOCUMENT_READING", "SKILL_WEB_PAGE_READING", "SKILL_REPLY_ASSISTANCE", "SKILL_HEALTH_CONSULTATION_OLD", "SKILL_REMINDER_SECOND", "SKILL_SEARCH", "SKILL_COMPOSITION_CORRECTION", "SKILL_ORAL_CALCULATION_CORRECTION", "SKILL_AI_IMAGE_EDITING", "SKILL_AI_NOTE", "SKILL_CONTINUOUS_VOICE", "SKILL_HEALTH_CONSULTATION_NEW", "SKILL_IN_DEPTH_RESEARCH", "SKILL_VIDEO_UNDERSTANDING", "SKILL_COLLEGE_ENTRANCE_EXAM", "SKILL_PHOTO_ANIMATION", "SKILL_AI_PODCAST_NEW", "SKILL_CREATION_MERGE", "SKILL_HOMEWORK_CORRECTION", "SKILL_PPT_GENERATION", "SKILL_SHEET_GENERATION", "SKILL_ECOMMERCE_ASSISTANT", "SKILL_SHARE_FOLDER", "SKILL_COMPUTER_MENU", "SKILL_USE_SKILL", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChatAbilityType extends Enum<ChatAbilityType> {
    public static final ChatAbilityType ChatAbilityType_Unknown = null;
    public static final ChatAbilityType DesExtSkillMultiWebsites = null;
    public static final ChatAbilityType SKILL_AI_IMAGE_EDITING = null;
    public static final ChatAbilityType SKILL_AI_NOTE = null;
    public static final ChatAbilityType SKILL_AI_PHOTO = null;
    public static final ChatAbilityType SKILL_AI_PODCAST_NEW = null;
    public static final ChatAbilityType SKILL_CALL = null;
    public static final ChatAbilityType SKILL_CALL_ENGLISH_LEARNING = null;
    public static final ChatAbilityType SKILL_CALL_IDIOM = null;
    public static final ChatAbilityType SKILL_CALL_INTERVIEW = null;
    public static final ChatAbilityType SKILL_CALL_TREE_HOLE = null;
    public static final ChatAbilityType SKILL_CALL_VIDEO = null;
    public static final ChatAbilityType SKILL_COCO_TRAVEL_ASK_DOUBAO = null;
    public static final ChatAbilityType SKILL_COLLEGE_ENTRANCE_EXAM = null;
    public static final ChatAbilityType SKILL_COMMAND = null;
    public static final ChatAbilityType SKILL_COMPLEX_SEARCH = null;
    public static final ChatAbilityType SKILL_COMPOSITION_CORRECTION = null;
    public static final ChatAbilityType SKILL_COMPUTER_MENU = null;
    public static final ChatAbilityType SKILL_CONTINUOUS_VOICE = null;
    public static final ChatAbilityType SKILL_CREATION_MERGE = null;
    public static final ChatAbilityType SKILL_CREATION_TEMPLATE_AIGENIMG = null;
    public static final ChatAbilityType SKILL_CREATION_TEMPLATE_AIREPLICA = null;
    public static final ChatAbilityType SKILL_DAILY_NEWS = null;
    public static final ChatAbilityType SKILL_DEEP_THINKING = null;
    public static final ChatAbilityType SKILL_DOCUMENT_READING = null;
    public static final ChatAbilityType SKILL_ECOMMERCE_ASSISTANT = null;
    public static final ChatAbilityType SKILL_ECOM_ASSISTANT = null;
    public static final ChatAbilityType SKILL_ENGLISH_LEARNING = null;
    public static final ChatAbilityType SKILL_HEALTH_CONSULTATION = null;
    public static final ChatAbilityType SKILL_HEALTH_CONSULTATION_NEW = null;
    public static final ChatAbilityType SKILL_HEALTH_CONSULTATION_OLD = null;
    public static final ChatAbilityType SKILL_HOMEWORK_CORRECTION = null;
    public static final ChatAbilityType SKILL_IMAGE_GENERATION = null;
    public static final ChatAbilityType SKILL_INMATE = null;
    public static final ChatAbilityType SKILL_IN_DEPTH_RESEARCH = null;
    public static final ChatAbilityType SKILL_LISTEN_PODCAST = null;
    public static final ChatAbilityType SKILL_MUSIC_GENERATION = null;
    public static final ChatAbilityType SKILL_MUSIC_RANDOM_PLAY = null;
    public static final ChatAbilityType SKILL_NEWS_ACTIONBAR_NAME = null;
    public static final ChatAbilityType SKILL_OLYMPIC_DAILY_CARD = null;
    public static final ChatAbilityType SKILL_ORAL_CALCULATION_CORRECTION = null;
    public static final ChatAbilityType SKILL_PHOTO_ANIMATION = null;
    public static final ChatAbilityType SKILL_PODCAST_GENERATION = null;
    public static final ChatAbilityType SKILL_PPT_GENERATION = null;
    public static final ChatAbilityType SKILL_PROBLEM_SOLVING = null;
    public static final ChatAbilityType SKILL_RECORD = null;
    public static final ChatAbilityType SKILL_REMINDER_FIRST = null;
    public static final ChatAbilityType SKILL_REMINDER_SECOND = null;
    public static final ChatAbilityType SKILL_REPLY_ASSISTANCE = null;
    public static final ChatAbilityType SKILL_SEARCH = null;
    public static final ChatAbilityType SKILL_SHARE_FOLDER = null;
    public static final ChatAbilityType SKILL_SHEET_GENERATION = null;
    public static final ChatAbilityType SKILL_SIMULTANEOUS_INTERPRETATION = null;
    public static final ChatAbilityType SKILL_SINGER = null;
    public static final ChatAbilityType SKILL_SPEAKER = null;
    public static final ChatAbilityType SKILL_TRANSLATION = null;
    public static final ChatAbilityType SKILL_USE_SKILL = null;
    public static final ChatAbilityType SKILL_VIDEO_GENERATION = null;
    public static final ChatAbilityType SKILL_VIDEO_UNDERSTANDING = null;
    public static final ChatAbilityType SKILL_WEB_PAGE_READING = null;
    public static final ChatAbilityType SKILL_WRITING = null;
    public static final ChatAbilityType SKILL_WRITING_ASSISTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatAbilityType[] f346587a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346588b = null;
    private final int value;

    public static EnumEntries<ChatAbilityType> getEntries() {
        return f346588b;
    }

    static {
        ChatAbilityType r100 = new ChatAbilityType("ChatAbilityType_Unknown", 0, 0);
        ChatAbilityType_Unknown = r100;
        ChatAbilityType r101 = new ChatAbilityType("SKILL_WRITING", 1, 2);
        SKILL_WRITING = r101;
        ChatAbilityType r102 = new ChatAbilityType("DesExtSkillMultiWebsites", 2, 102);
        DesExtSkillMultiWebsites = r102;
        ChatAbilityType r103 = new ChatAbilityType("SKILL_CALL", 3, 1001);
        SKILL_CALL = r103;
        ChatAbilityType r104 = new ChatAbilityType("SKILL_NEWS_ACTIONBAR_NAME", 4, 1002);
        SKILL_NEWS_ACTIONBAR_NAME = r104;
        ChatAbilityType r105 = new ChatAbilityType("SKILL_HEALTH_CONSULTATION", 5, 1003);
        SKILL_HEALTH_CONSULTATION = r105;
        ChatAbilityType r110 = new ChatAbilityType("SKILL_MUSIC_RANDOM_PLAY", 6, 1004);
        SKILL_MUSIC_RANDOM_PLAY = r110;
        ChatAbilityType r111 = new ChatAbilityType("SKILL_RECORD", 7, 1005);
        SKILL_RECORD = r111;
        ChatAbilityType r112 = new ChatAbilityType("SKILL_CALL_ENGLISH_LEARNING", 8, 1006);
        SKILL_CALL_ENGLISH_LEARNING = r112;
        ChatAbilityType r113 = new ChatAbilityType("SKILL_CALL_IDIOM", 9, 1007);
        SKILL_CALL_IDIOM = r113;
        ChatAbilityType r114 = new ChatAbilityType("SKILL_CALL_INTERVIEW", 10, 1008);
        SKILL_CALL_INTERVIEW = r114;
        ChatAbilityType r106 = new ChatAbilityType("SKILL_CALL_TREE_HOLE", 11, 1009);
        SKILL_CALL_TREE_HOLE = r106;
        ChatAbilityType r107 = new ChatAbilityType("SKILL_COMMAND", 12, 1010);
        SKILL_COMMAND = r107;
        ChatAbilityType r108 = new ChatAbilityType("SKILL_DAILY_NEWS", 13, 1011);
        SKILL_DAILY_NEWS = r108;
        ChatAbilityType r109 = new ChatAbilityType("SKILL_OLYMPIC_DAILY_CARD", 14, 1012);
        SKILL_OLYMPIC_DAILY_CARD = r109;
        ChatAbilityType r115 = new ChatAbilityType("SKILL_SPEAKER", 15, 1013);
        SKILL_SPEAKER = r115;
        ChatAbilityType r116 = new ChatAbilityType("SKILL_COMPLEX_SEARCH", 16, 1014);
        SKILL_COMPLEX_SEARCH = r116;
        ChatAbilityType r117 = new ChatAbilityType("SKILL_LISTEN_PODCAST", 17, 1015);
        SKILL_LISTEN_PODCAST = r117;
        ChatAbilityType r118 = new ChatAbilityType("SKILL_CALL_VIDEO", 18, 1016);
        SKILL_CALL_VIDEO = r118;
        ChatAbilityType r119 = new ChatAbilityType("SKILL_CREATION_TEMPLATE_AIGENIMG", 19, 1017);
        SKILL_CREATION_TEMPLATE_AIGENIMG = r119;
        ChatAbilityType r120 = new ChatAbilityType("SKILL_CREATION_TEMPLATE_AIREPLICA", 20, 1018);
        SKILL_CREATION_TEMPLATE_AIREPLICA = r120;
        ChatAbilityType r121 = new ChatAbilityType("SKILL_DEEP_THINKING", 21, 1019);
        SKILL_DEEP_THINKING = r121;
        ChatAbilityType r122 = new ChatAbilityType("SKILL_SINGER", 22, 1020);
        SKILL_SINGER = r122;
        ChatAbilityType r123 = new ChatAbilityType("SKILL_INMATE", 23, 1021);
        SKILL_INMATE = r123;
        ChatAbilityType r124 = new ChatAbilityType("SKILL_ENGLISH_LEARNING", 24, 1022);
        SKILL_ENGLISH_LEARNING = r124;
        ChatAbilityType r125 = new ChatAbilityType("SKILL_PODCAST_GENERATION", 25, 1023);
        SKILL_PODCAST_GENERATION = r125;
        ChatAbilityType r126 = new ChatAbilityType("SKILL_ECOM_ASSISTANT", 26, 1024);
        SKILL_ECOM_ASSISTANT = r126;
        ChatAbilityType r127 = new ChatAbilityType("SKILL_COCO_TRAVEL_ASK_DOUBAO", 27, 1025);
        SKILL_COCO_TRAVEL_ASK_DOUBAO = r127;
        ChatAbilityType r128 = new ChatAbilityType("SKILL_SIMULTANEOUS_INTERPRETATION", 28, 1026);
        SKILL_SIMULTANEOUS_INTERPRETATION = r128;
        ChatAbilityType r129 = new ChatAbilityType("SKILL_PROBLEM_SOLVING", 29, 2000);
        SKILL_PROBLEM_SOLVING = r129;
        ChatAbilityType r130 = new ChatAbilityType("SKILL_IMAGE_GENERATION", 30, 2001);
        SKILL_IMAGE_GENERATION = r130;
        ChatAbilityType r131 = new ChatAbilityType("SKILL_VIDEO_GENERATION", 31, 2002);
        SKILL_VIDEO_GENERATION = r131;
        ChatAbilityType r132 = new ChatAbilityType("SKILL_AI_PHOTO", 32, 2003);
        SKILL_AI_PHOTO = r132;
        ChatAbilityType r133 = new ChatAbilityType("SKILL_WRITING_ASSISTANCE", 33, 2004);
        SKILL_WRITING_ASSISTANCE = r133;
        ChatAbilityType r134 = new ChatAbilityType("SKILL_MUSIC_GENERATION", 34, 2005);
        SKILL_MUSIC_GENERATION = r134;
        ChatAbilityType r135 = new ChatAbilityType("SKILL_TRANSLATION", 35, 2006);
        SKILL_TRANSLATION = r135;
        ChatAbilityType r136 = new ChatAbilityType("SKILL_REMINDER_FIRST", 36, 2007);
        SKILL_REMINDER_FIRST = r136;
        ChatAbilityType r137 = new ChatAbilityType("SKILL_DOCUMENT_READING", 37, 2008);
        SKILL_DOCUMENT_READING = r137;
        ChatAbilityType r138 = new ChatAbilityType("SKILL_WEB_PAGE_READING", 38, 2009);
        SKILL_WEB_PAGE_READING = r138;
        ChatAbilityType r139 = new ChatAbilityType("SKILL_REPLY_ASSISTANCE", 39, 2010);
        SKILL_REPLY_ASSISTANCE = r139;
        ChatAbilityType r140 = new ChatAbilityType("SKILL_HEALTH_CONSULTATION_OLD", 40, 2011);
        SKILL_HEALTH_CONSULTATION_OLD = r140;
        ChatAbilityType r141 = new ChatAbilityType("SKILL_REMINDER_SECOND", 41, 2012);
        SKILL_REMINDER_SECOND = r141;
        ChatAbilityType r142 = new ChatAbilityType("SKILL_SEARCH", 42, 2013);
        SKILL_SEARCH = r142;
        ChatAbilityType r143 = new ChatAbilityType("SKILL_COMPOSITION_CORRECTION", 43, 2014);
        SKILL_COMPOSITION_CORRECTION = r143;
        ChatAbilityType r144 = new ChatAbilityType("SKILL_ORAL_CALCULATION_CORRECTION", 44, 2015);
        SKILL_ORAL_CALCULATION_CORRECTION = r144;
        ChatAbilityType r145 = new ChatAbilityType("SKILL_AI_IMAGE_EDITING", 45, 2016);
        SKILL_AI_IMAGE_EDITING = r145;
        ChatAbilityType r146 = new ChatAbilityType("SKILL_AI_NOTE", 46, 2017);
        SKILL_AI_NOTE = r146;
        ChatAbilityType r147 = new ChatAbilityType("SKILL_CONTINUOUS_VOICE", 47, 2018);
        SKILL_CONTINUOUS_VOICE = r147;
        ChatAbilityType r148 = new ChatAbilityType("SKILL_HEALTH_CONSULTATION_NEW", 48, 2019);
        SKILL_HEALTH_CONSULTATION_NEW = r148;
        ChatAbilityType r149 = new ChatAbilityType("SKILL_IN_DEPTH_RESEARCH", 49, 2020);
        SKILL_IN_DEPTH_RESEARCH = r149;
        ChatAbilityType r150 = new ChatAbilityType("SKILL_VIDEO_UNDERSTANDING", 50, 2021);
        SKILL_VIDEO_UNDERSTANDING = r150;
        ChatAbilityType r151 = new ChatAbilityType("SKILL_COLLEGE_ENTRANCE_EXAM", 51, 2022);
        SKILL_COLLEGE_ENTRANCE_EXAM = r151;
        ChatAbilityType r152 = new ChatAbilityType("SKILL_PHOTO_ANIMATION", 52, DataLoaderHelper.DATALOADER_KEY_INT_OPTIMIZE_RANGE);
        SKILL_PHOTO_ANIMATION = r152;
        ChatAbilityType r153 = new ChatAbilityType("SKILL_AI_PODCAST_NEW", 53, DataLoaderHelper.DATALOADER_KEY_INT_NET_LOG_MAX_SIZE);
        SKILL_AI_PODCAST_NEW = r153;
        ChatAbilityType r154 = new ChatAbilityType("SKILL_CREATION_MERGE", 54, DataLoaderHelper.DATALOADER_KEY_INT_CHECK_CACHE_DIR);
        SKILL_CREATION_MERGE = r154;
        ChatAbilityType r155 = new ChatAbilityType("SKILL_HOMEWORK_CORRECTION", 55, 2026);
        SKILL_HOMEWORK_CORRECTION = r155;
        ChatAbilityType r156 = new ChatAbilityType("SKILL_PPT_GENERATION", 56, 5000);
        SKILL_PPT_GENERATION = r156;
        ChatAbilityType r157 = new ChatAbilityType("SKILL_SHEET_GENERATION", 57, 5003);
        SKILL_SHEET_GENERATION = r157;
        ChatAbilityType r158 = new ChatAbilityType("SKILL_ECOMMERCE_ASSISTANT", 58, ITTVideoEngineInternal.PLAYER_OPTION_EXO_CODEC_ASYNC_INIT_ENABLE);
        SKILL_ECOMMERCE_ASSISTANT = r158;
        ChatAbilityType r159 = new ChatAbilityType("SKILL_SHARE_FOLDER", 59, ITTVideoEngineInternal.PLAYER_OPTION_EXO_ALLOW_MEDIACODECHELPER);
        SKILL_SHARE_FOLDER = r159;
        ChatAbilityType r160 = new ChatAbilityType("SKILL_COMPUTER_MENU", 60, 5006);
        SKILL_COMPUTER_MENU = r160;
        ChatAbilityType r161 = new ChatAbilityType("SKILL_USE_SKILL", 61, 5007);
        SKILL_USE_SKILL = r161;
        ChatAbilityType[] r162 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152, r153, r154, r155, r156, r157, r158, r159, r160, r161};
        f346587a = r162;
        f346588b = EnumEntriesKt.enumEntries(r162);
    }

    public static ChatAbilityType[] values() {
        return (ChatAbilityType[]) f346587a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatAbilityType valueOf(String r100) {
        return (ChatAbilityType) r27.a.a(ChatAbilityType.class, r100);
    }

    public ChatAbilityType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
