package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0087\u0081\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c"}, d2 = {"Lcom/larus/livetutor/api/idl/BizScenes;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "IntelligentLesson", "AssistantAnswer", "WritingGuidance", "IntegratedChat", "MiddleSchoolQA", "PrimarySchoolQA", "InterestReading", "StoryPedia", "KnowledgeQa", "EnglishPractice", "GuideQa", "SpokenEnglish", "PicTranslate", "GeneralVision", "RtcDefault", "RtcMia", "RtcLiveTutor", "RtcLiveTutorProd", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BizScenes extends Enum<BizScenes> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ BizScenes[] $VALUES = null;

    @SerializedName("2")
    public static final BizScenes AssistantAnswer = null;
    public static final a Companion = null;

    @SerializedName(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)
    public static final BizScenes EnglishPractice = null;

    @SerializedName(Constants.VIA_REPORT_TYPE_MAKE_FRIEND)
    public static final BizScenes GeneralVision = null;

    @SerializedName("11")
    public static final BizScenes GuideQa = null;

    @SerializedName("4")
    public static final BizScenes IntegratedChat = null;

    @SerializedName("1")
    public static final BizScenes IntelligentLesson = null;

    @SerializedName("7")
    public static final BizScenes InterestReading = null;

    @SerializedName(Constants.VIA_SHARE_TYPE_MINI_PROGRAM)
    public static final BizScenes KnowledgeQa = null;

    @SerializedName("5")
    public static final BizScenes MiddleSchoolQA = null;

    @SerializedName("13")
    public static final BizScenes PicTranslate = null;

    @SerializedName("6")
    public static final BizScenes PrimarySchoolQA = null;

    @SerializedName(Constants.VIA_REPORT_TYPE_WPA_STATE)
    public static final BizScenes RtcDefault = null;

    @SerializedName(Constants.VIA_REPORT_TYPE_START_GROUP)
    public static final BizScenes RtcLiveTutor = null;

    @SerializedName("18")
    public static final BizScenes RtcLiveTutorProd = null;

    @SerializedName(Constants.VIA_REPORT_TYPE_START_WAP)
    public static final BizScenes RtcMia = null;

    @SerializedName("12")
    public static final BizScenes SpokenEnglish = null;

    @SerializedName("8")
    public static final BizScenes StoryPedia = null;

    @SerializedName("0")
    public static final BizScenes Unknown = null;

    @SerializedName("3")
    public static final BizScenes WritingGuidance = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ BizScenes[] $values() {
        return new BizScenes[]{Unknown, IntelligentLesson, AssistantAnswer, WritingGuidance, IntegratedChat, MiddleSchoolQA, PrimarySchoolQA, InterestReading, StoryPedia, KnowledgeQa, EnglishPractice, GuideQa, SpokenEnglish, PicTranslate, GeneralVision, RtcDefault, RtcMia, RtcLiveTutor, RtcLiveTutorProd};
    }

    public static EnumEntries<BizScenes> getEntries() {
        return $ENTRIES;
    }

    static {
        Unknown = new BizScenes("Unknown", 0, 0);
        IntelligentLesson = new BizScenes("IntelligentLesson", 1, 1);
        AssistantAnswer = new BizScenes("AssistantAnswer", 2, 2);
        WritingGuidance = new BizScenes("WritingGuidance", 3, 3);
        IntegratedChat = new BizScenes("IntegratedChat", 4, 4);
        MiddleSchoolQA = new BizScenes("MiddleSchoolQA", 5, 5);
        PrimarySchoolQA = new BizScenes("PrimarySchoolQA", 6, 6);
        InterestReading = new BizScenes("InterestReading", 7, 7);
        StoryPedia = new BizScenes("StoryPedia", 8, 8);
        KnowledgeQa = new BizScenes("KnowledgeQa", 9, 9);
        EnglishPractice = new BizScenes("EnglishPractice", 10, 10);
        GuideQa = new BizScenes("GuideQa", 11, 11);
        SpokenEnglish = new BizScenes("SpokenEnglish", 12, 12);
        PicTranslate = new BizScenes("PicTranslate", 13, 13);
        GeneralVision = new BizScenes("GeneralVision", 14, 14);
        RtcDefault = new BizScenes("RtcDefault", 15, 15);
        RtcMia = new BizScenes("RtcMia", 16, 16);
        RtcLiveTutor = new BizScenes("RtcLiveTutor", 17, 17);
        RtcLiveTutorProd = new BizScenes("RtcLiveTutorProd", 18, 18);
        BizScenes[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static BizScenes[] values() {
        return (BizScenes[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final BizScenes findByValue(int r100) {
        Companion.getClass();
        switch(r100) {
            case 0: goto L24;
            case 1: goto L43;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L40;
            case 5: goto L39;
            case 6: goto L38;
            case 7: goto L37;
            case 8: goto L36;
            case 9: goto L35;
            case 10: goto L34;
            case 11: goto L33;
            case 12: goto L32;
            case 13: goto L31;
            case 14: goto L30;
            case 15: goto L29;
            case 16: goto L28;
            case 17: goto L27;
            case 18: goto L26;
            default: goto L4;
        };
    L4:
        return null;
    L26:
        return RtcLiveTutorProd;
    L27:
        return RtcLiveTutor;
    L28:
        return RtcMia;
    L29:
        return RtcDefault;
    L30:
        return GeneralVision;
    L31:
        return PicTranslate;
    L32:
        return SpokenEnglish;
    L33:
        return GuideQa;
    L34:
        return EnglishPractice;
    L35:
        return KnowledgeQa;
    L36:
        return StoryPedia;
    L37:
        return InterestReading;
    L38:
        return PrimarySchoolQA;
    L39:
        return MiddleSchoolQA;
    L40:
        return IntegratedChat;
    L41:
        return WritingGuidance;
    L42:
        return AssistantAnswer;
    L43:
        return IntelligentLesson;
    L24:
        return Unknown;
    }

    public static BizScenes valueOf(String r100) {
        return (BizScenes) r27.a.a(BizScenes.class, r100);
    }

    private BizScenes(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
