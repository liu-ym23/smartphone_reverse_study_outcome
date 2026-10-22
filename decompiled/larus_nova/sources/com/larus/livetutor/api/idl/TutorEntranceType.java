package com.larus.livetutor.api.idl;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0087\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/larus/livetutor/api/idl/TutorEntranceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "LiveTutorTabNewQuery", "LiveTutorTabNotConsumeHistory", "History", "Banner", "ResultPageActionbar", "ResultPageQaEntrance", "WrongBook", "DoubaoSuggest", "DoubaoActionbarPage", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TutorEntranceType extends Enum<TutorEntranceType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TutorEntranceType[] $VALUES = null;

    @SerializedName("4")
    public static final TutorEntranceType Banner = null;
    public static final a Companion = null;

    @SerializedName(BDLocationException.ERROR_UID_IS_EMPTY)
    public static final TutorEntranceType DoubaoActionbarPage = null;

    @SerializedName("101")
    public static final TutorEntranceType DoubaoSuggest = null;

    @SerializedName("3")
    public static final TutorEntranceType History = null;

    @SerializedName("1")
    public static final TutorEntranceType LiveTutorTabNewQuery = null;

    @SerializedName("2")
    public static final TutorEntranceType LiveTutorTabNotConsumeHistory = null;

    @SerializedName("11")
    public static final TutorEntranceType ResultPageActionbar = null;

    @SerializedName("12")
    public static final TutorEntranceType ResultPageQaEntrance = null;

    @SerializedName("0")
    public static final TutorEntranceType Unknown = null;

    @SerializedName("13")
    public static final TutorEntranceType WrongBook = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ TutorEntranceType[] $values() {
        return new TutorEntranceType[]{Unknown, LiveTutorTabNewQuery, LiveTutorTabNotConsumeHistory, History, Banner, ResultPageActionbar, ResultPageQaEntrance, WrongBook, DoubaoSuggest, DoubaoActionbarPage};
    }

    public static EnumEntries<TutorEntranceType> getEntries() {
        return $ENTRIES;
    }

    static {
        Unknown = new TutorEntranceType("Unknown", 0, 0);
        LiveTutorTabNewQuery = new TutorEntranceType("LiveTutorTabNewQuery", 1, 1);
        LiveTutorTabNotConsumeHistory = new TutorEntranceType("LiveTutorTabNotConsumeHistory", 2, 2);
        History = new TutorEntranceType("History", 3, 3);
        Banner = new TutorEntranceType("Banner", 4, 4);
        ResultPageActionbar = new TutorEntranceType("ResultPageActionbar", 5, 11);
        ResultPageQaEntrance = new TutorEntranceType("ResultPageQaEntrance", 6, 12);
        WrongBook = new TutorEntranceType("WrongBook", 7, 13);
        DoubaoSuggest = new TutorEntranceType("DoubaoSuggest", 8, 101);
        DoubaoActionbarPage = new TutorEntranceType("DoubaoActionbarPage", 9, 102);
        TutorEntranceType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static TutorEntranceType[] values() {
        return (TutorEntranceType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final TutorEntranceType findByValue(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L28;
        if (r100 == 1) goto L38;
        if (r100 == 2) goto L37;
        if (r100 == 3) goto L36;
        if (r100 == 4) goto L35;
        if (r100 == 101) goto L34;
        if (r100 == 102) goto L33;
        switch(r100) {
            case 11: goto L32;
            case 12: goto L31;
            case 13: goto L30;
            default: goto L17;
        };
    L17:
        return null;
    L30:
        return WrongBook;
    L31:
        return ResultPageQaEntrance;
    L32:
        return ResultPageActionbar;
    L33:
        return DoubaoActionbarPage;
    L34:
        return DoubaoSuggest;
    L35:
        return Banner;
    L36:
        return History;
    L37:
        return LiveTutorTabNotConsumeHistory;
    L38:
        return LiveTutorTabNewQuery;
    L28:
        return Unknown;
    }

    public static TutorEntranceType valueOf(String r100) {
        return (TutorEntranceType) r27.a.a(TutorEntranceType.class, r100);
    }

    private TutorEntranceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
