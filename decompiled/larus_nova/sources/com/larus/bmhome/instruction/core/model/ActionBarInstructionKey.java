package com.larus.bmhome.instruction.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b!\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006&"}, d2 = {"Lcom/larus/bmhome/instruction/core/model/ActionBarInstructionKey;", "", "key", "", "code", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getCode", "()I", "COCO_CALL", "COCO_NEWS_ACTIONBAR_NAME", "COCO_HEALTH_CONSULTATION", "COCO_MUSIC_RANDOM_PLAY", "COCO_RECORD", "COCO_CALL_ENGLISH_LEARNING", "COCO_CALL_IDIOM", "COCO_CALL_INTERVIEW", "COCO_CALL_TREE_HOLE", "COCO_COMMAND", "COCO_DAILY_NEWS", "COCO_OLYMPIC_DAILY_CARD", "COCO_SPEAKER", "COMPLEX_SEARCH", "COCO_LISTEN_PODCAST", "COCO_CALL_VIDEO", "CREATION_TEMPLATE_AIGENING", "CREATION_TEMPLATE_AIREPLICA", "COCO_DEEP_THINKING", "COCO_SINGER", "COCO_INMATE", "COCO_ENGLISH_LEARNING", "COCO_PODCAST_GENERATION", "COCO_ECOM_ASSISTANT", "COCO_TRAVEL_ASK_DOUBAO", "COCO_AI_SIMUL_INTERPRET", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActionBarInstructionKey extends Enum<ActionBarInstructionKey> {
    public static final ActionBarInstructionKey COCO_AI_SIMUL_INTERPRET = null;
    public static final ActionBarInstructionKey COCO_CALL = null;
    public static final ActionBarInstructionKey COCO_CALL_ENGLISH_LEARNING = null;
    public static final ActionBarInstructionKey COCO_CALL_IDIOM = null;
    public static final ActionBarInstructionKey COCO_CALL_INTERVIEW = null;
    public static final ActionBarInstructionKey COCO_CALL_TREE_HOLE = null;
    public static final ActionBarInstructionKey COCO_CALL_VIDEO = null;
    public static final ActionBarInstructionKey COCO_COMMAND = null;
    public static final ActionBarInstructionKey COCO_DAILY_NEWS = null;
    public static final ActionBarInstructionKey COCO_DEEP_THINKING = null;
    public static final ActionBarInstructionKey COCO_ECOM_ASSISTANT = null;
    public static final ActionBarInstructionKey COCO_ENGLISH_LEARNING = null;
    public static final ActionBarInstructionKey COCO_HEALTH_CONSULTATION = null;
    public static final ActionBarInstructionKey COCO_INMATE = null;
    public static final ActionBarInstructionKey COCO_LISTEN_PODCAST = null;
    public static final ActionBarInstructionKey COCO_MUSIC_RANDOM_PLAY = null;
    public static final ActionBarInstructionKey COCO_NEWS_ACTIONBAR_NAME = null;
    public static final ActionBarInstructionKey COCO_OLYMPIC_DAILY_CARD = null;
    public static final ActionBarInstructionKey COCO_PODCAST_GENERATION = null;
    public static final ActionBarInstructionKey COCO_RECORD = null;
    public static final ActionBarInstructionKey COCO_SINGER = null;
    public static final ActionBarInstructionKey COCO_SPEAKER = null;
    public static final ActionBarInstructionKey COCO_TRAVEL_ASK_DOUBAO = null;
    public static final ActionBarInstructionKey COMPLEX_SEARCH = null;
    public static final ActionBarInstructionKey CREATION_TEMPLATE_AIGENING = null;
    public static final ActionBarInstructionKey CREATION_TEMPLATE_AIREPLICA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionBarInstructionKey[] f312051a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f312052b = null;
    private final int code;
    private final String key;

    public static EnumEntries<ActionBarInstructionKey> getEntries() {
        return f312052b;
    }

    static {
        ActionBarInstructionKey r100 = new ActionBarInstructionKey("COCO_CALL", 0, "coco_call", 1001);
        COCO_CALL = r100;
        ActionBarInstructionKey r101 = new ActionBarInstructionKey("COCO_NEWS_ACTIONBAR_NAME", 1, "coco_news_actionbar_name", 1002);
        COCO_NEWS_ACTIONBAR_NAME = r101;
        ActionBarInstructionKey r102 = new ActionBarInstructionKey("COCO_HEALTH_CONSULTATION", 2, "coco_health_consultation", 1003);
        COCO_HEALTH_CONSULTATION = r102;
        ActionBarInstructionKey r103 = new ActionBarInstructionKey("COCO_MUSIC_RANDOM_PLAY", 3, "coco_music_random_play", 1004);
        COCO_MUSIC_RANDOM_PLAY = r103;
        ActionBarInstructionKey r104 = new ActionBarInstructionKey("COCO_RECORD", 4, "coco_record", 1005);
        COCO_RECORD = r104;
        ActionBarInstructionKey r105 = new ActionBarInstructionKey("COCO_CALL_ENGLISH_LEARNING", 5, "coco_call_english_learning", 1006);
        COCO_CALL_ENGLISH_LEARNING = r105;
        ActionBarInstructionKey r106 = new ActionBarInstructionKey("COCO_CALL_IDIOM", 6, "coco_call_idiom", 1007);
        COCO_CALL_IDIOM = r106;
        ActionBarInstructionKey r110 = new ActionBarInstructionKey("COCO_CALL_INTERVIEW", 7, "coco_call_interview", 1008);
        COCO_CALL_INTERVIEW = r110;
        ActionBarInstructionKey r111 = new ActionBarInstructionKey("COCO_CALL_TREE_HOLE", 8, "coco_call_tree_hole", 1009);
        COCO_CALL_TREE_HOLE = r111;
        ActionBarInstructionKey r112 = new ActionBarInstructionKey("COCO_COMMAND", 9, "coco_command", 1010);
        COCO_COMMAND = r112;
        ActionBarInstructionKey r113 = new ActionBarInstructionKey("COCO_DAILY_NEWS", 10, "coco_daily_news", 1011);
        COCO_DAILY_NEWS = r113;
        ActionBarInstructionKey r107 = new ActionBarInstructionKey("COCO_OLYMPIC_DAILY_CARD", 11, "coco_olympic_daily_card", 1012);
        COCO_OLYMPIC_DAILY_CARD = r107;
        ActionBarInstructionKey r108 = new ActionBarInstructionKey("COCO_SPEAKER", 12, "coco_speaker", 1013);
        COCO_SPEAKER = r108;
        ActionBarInstructionKey r109 = new ActionBarInstructionKey("COMPLEX_SEARCH", 13, "complex_search", 1014);
        COMPLEX_SEARCH = r109;
        ActionBarInstructionKey r114 = new ActionBarInstructionKey("COCO_LISTEN_PODCAST", 14, "coco_listen_podcast", 1015);
        COCO_LISTEN_PODCAST = r114;
        ActionBarInstructionKey r115 = new ActionBarInstructionKey("COCO_CALL_VIDEO", 15, "coco_call_video", 1016);
        COCO_CALL_VIDEO = r115;
        ActionBarInstructionKey r116 = new ActionBarInstructionKey("CREATION_TEMPLATE_AIGENING", 16, "creation_template_AiGenImg", 1017);
        CREATION_TEMPLATE_AIGENING = r116;
        ActionBarInstructionKey r117 = new ActionBarInstructionKey("CREATION_TEMPLATE_AIREPLICA", 17, "creation_template_AiReplica", 1018);
        CREATION_TEMPLATE_AIREPLICA = r117;
        ActionBarInstructionKey r118 = new ActionBarInstructionKey("COCO_DEEP_THINKING", 18, "coco_deep_thinking", 1019);
        COCO_DEEP_THINKING = r118;
        ActionBarInstructionKey r119 = new ActionBarInstructionKey("COCO_SINGER", 19, "coco_singer", 1020);
        COCO_SINGER = r119;
        ActionBarInstructionKey r120 = new ActionBarInstructionKey("COCO_INMATE", 20, "coco_inmate", 1021);
        COCO_INMATE = r120;
        ActionBarInstructionKey r121 = new ActionBarInstructionKey("COCO_ENGLISH_LEARNING", 21, "coco_english_learning", 1022);
        COCO_ENGLISH_LEARNING = r121;
        ActionBarInstructionKey r122 = new ActionBarInstructionKey("COCO_PODCAST_GENERATION", 22, "coco_podcast_generation", 1023);
        COCO_PODCAST_GENERATION = r122;
        ActionBarInstructionKey r123 = new ActionBarInstructionKey("COCO_ECOM_ASSISTANT", 23, "coco_ecom_assistant", 1024);
        COCO_ECOM_ASSISTANT = r123;
        ActionBarInstructionKey r124 = new ActionBarInstructionKey("COCO_TRAVEL_ASK_DOUBAO", 24, "coco_travel_ask_doubao", 1025);
        COCO_TRAVEL_ASK_DOUBAO = r124;
        ActionBarInstructionKey r125 = new ActionBarInstructionKey("COCO_AI_SIMUL_INTERPRET", 25, "coco_ai_simul_interpret", 1026);
        COCO_AI_SIMUL_INTERPRET = r125;
        ActionBarInstructionKey[] r126 = {r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125};
        f312051a = r126;
        f312052b = EnumEntriesKt.enumEntries(r126);
    }

    public static ActionBarInstructionKey[] values() {
        return (ActionBarInstructionKey[]) f312051a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final String getKey() {
        return this.key;
    }

    public static ActionBarInstructionKey valueOf(String r100) {
        return (ActionBarInstructionKey) a.a(ActionBarInstructionKey.class, r100);
    }

    public ActionBarInstructionKey(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.key = r102;
        this.code = r103;
    }
}
