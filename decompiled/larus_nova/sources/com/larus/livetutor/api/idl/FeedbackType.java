package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0087\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/livetutor/api/idl/FeedbackType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "QaSession", "MsgErr", "GuideFinish", "GuideExit", "GuidePermanent", "RealTimeCallFinish", "LiveTutorExit", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FeedbackType extends Enum<FeedbackType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FeedbackType[] $VALUES = null;
    public static final a Companion = null;

    @SerializedName("3")
    public static final FeedbackType GuideExit = null;

    @SerializedName("2")
    public static final FeedbackType GuideFinish = null;

    @SerializedName("4")
    public static final FeedbackType GuidePermanent = null;

    @SerializedName("6")
    public static final FeedbackType LiveTutorExit = null;

    @SerializedName("1")
    public static final FeedbackType MsgErr = null;

    @SerializedName("0")
    public static final FeedbackType QaSession = null;

    @SerializedName("5")
    public static final FeedbackType RealTimeCallFinish = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ FeedbackType[] $values() {
        return new FeedbackType[]{QaSession, MsgErr, GuideFinish, GuideExit, GuidePermanent, RealTimeCallFinish, LiveTutorExit};
    }

    public static EnumEntries<FeedbackType> getEntries() {
        return $ENTRIES;
    }

    static {
        QaSession = new FeedbackType("QaSession", 0, 0);
        MsgErr = new FeedbackType("MsgErr", 1, 1);
        GuideFinish = new FeedbackType("GuideFinish", 2, 2);
        GuideExit = new FeedbackType("GuideExit", 3, 3);
        GuidePermanent = new FeedbackType("GuidePermanent", 4, 4);
        RealTimeCallFinish = new FeedbackType("RealTimeCallFinish", 5, 5);
        LiveTutorExit = new FeedbackType("LiveTutorExit", 6, 6);
        FeedbackType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static FeedbackType[] values() {
        return (FeedbackType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final FeedbackType findByValue(int r100) {
        Companion.getClass();
        switch(r100) {
            case 0: goto L12;
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            default: goto L4;
        };
    L4:
        return null;
    L14:
        return LiveTutorExit;
    L15:
        return RealTimeCallFinish;
    L16:
        return GuidePermanent;
    L17:
        return GuideExit;
    L18:
        return GuideFinish;
    L19:
        return MsgErr;
    L12:
        return QaSession;
    }

    public static FeedbackType valueOf(String r100) {
        return (FeedbackType) r27.a.a(FeedbackType.class, r100);
    }

    private FeedbackType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
