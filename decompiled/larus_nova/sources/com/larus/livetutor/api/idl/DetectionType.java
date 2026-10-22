package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/larus/livetutor/api/idl/DetectionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "SingleQuestion", "MultiQuestion", "Correct", "MetalCalc", "WrongQuestion", "PicTranslate", "SimilarQuestion", "SimilarQuestionV2", "LiveTutorTab", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DetectionType extends Enum<DetectionType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DetectionType[] $VALUES = null;
    public static final a Companion = null;

    @SerializedName("3")
    public static final DetectionType Correct = null;

    @SerializedName(Constants.VIA_SHARE_TYPE_MINI_PROGRAM)
    public static final DetectionType LiveTutorTab = null;

    @SerializedName("4")
    public static final DetectionType MetalCalc = null;

    @SerializedName("2")
    public static final DetectionType MultiQuestion = null;

    @SerializedName("6")
    public static final DetectionType PicTranslate = null;

    @SerializedName("7")
    public static final DetectionType SimilarQuestion = null;

    @SerializedName("8")
    public static final DetectionType SimilarQuestionV2 = null;

    @SerializedName("1")
    public static final DetectionType SingleQuestion = null;

    @SerializedName("0")
    public static final DetectionType Unknown = null;

    @SerializedName("5")
    public static final DetectionType WrongQuestion = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ DetectionType[] $values() {
        return new DetectionType[]{Unknown, SingleQuestion, MultiQuestion, Correct, MetalCalc, WrongQuestion, PicTranslate, SimilarQuestion, SimilarQuestionV2, LiveTutorTab};
    }

    public static EnumEntries<DetectionType> getEntries() {
        return $ENTRIES;
    }

    static {
        Unknown = new DetectionType("Unknown", 0, 0);
        SingleQuestion = new DetectionType("SingleQuestion", 1, 1);
        MultiQuestion = new DetectionType("MultiQuestion", 2, 2);
        Correct = new DetectionType("Correct", 3, 3);
        MetalCalc = new DetectionType("MetalCalc", 4, 4);
        WrongQuestion = new DetectionType("WrongQuestion", 5, 5);
        PicTranslate = new DetectionType("PicTranslate", 6, 6);
        SimilarQuestion = new DetectionType("SimilarQuestion", 7, 7);
        SimilarQuestionV2 = new DetectionType("SimilarQuestionV2", 8, 8);
        LiveTutorTab = new DetectionType("LiveTutorTab", 9, 9);
        DetectionType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static DetectionType[] values() {
        return (DetectionType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final DetectionType findByValue(int r100) {
        Companion.getClass();
        switch(r100) {
            case 0: goto L15;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            default: goto L4;
        };
    L4:
        return null;
    L17:
        return LiveTutorTab;
    L18:
        return SimilarQuestionV2;
    L19:
        return SimilarQuestion;
    L20:
        return PicTranslate;
    L21:
        return WrongQuestion;
    L22:
        return MetalCalc;
    L23:
        return Correct;
    L24:
        return MultiQuestion;
    L25:
        return SingleQuestion;
    L15:
        return Unknown;
    }

    public static DetectionType valueOf(String r100) {
        return (DetectionType) r27.a.a(DetectionType.class, r100);
    }

    private DetectionType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
