package com.larus.bmhome.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/ability/FloatChatWindowEventType;", "", "from", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "Init", "SendSuccess", "ManualDragUp", "ManualDragDown", "AnswerIntent", "RefreshPageIntent", "MaskClick", "BackPress", "Rebound", "ExternalRequest", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FloatChatWindowEventType extends Enum<FloatChatWindowEventType> {
    public static final FloatChatWindowEventType AnswerIntent = null;
    public static final FloatChatWindowEventType BackPress = null;
    public static final FloatChatWindowEventType ExternalRequest = null;
    public static final FloatChatWindowEventType Init = null;
    public static final FloatChatWindowEventType ManualDragDown = null;
    public static final FloatChatWindowEventType ManualDragUp = null;
    public static final FloatChatWindowEventType MaskClick = null;
    public static final FloatChatWindowEventType Rebound = null;
    public static final FloatChatWindowEventType RefreshPageIntent = null;
    public static final FloatChatWindowEventType SendSuccess = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FloatChatWindowEventType[] f294924a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294925b = null;
    private final String from;

    public static EnumEntries<FloatChatWindowEventType> getEntries() {
        return f294925b;
    }

    static {
        FloatChatWindowEventType r100 = new FloatChatWindowEventType("Init", 0, "init");
        Init = r100;
        FloatChatWindowEventType r101 = new FloatChatWindowEventType("SendSuccess", 1, "send_success");
        SendSuccess = r101;
        FloatChatWindowEventType r102 = new FloatChatWindowEventType("ManualDragUp", 2, "manual_drag_up");
        ManualDragUp = r102;
        FloatChatWindowEventType r103 = new FloatChatWindowEventType("ManualDragDown", 3, "manual_drag_down");
        ManualDragDown = r103;
        FloatChatWindowEventType r104 = new FloatChatWindowEventType("AnswerIntent", 4, "answer_intent");
        AnswerIntent = r104;
        FloatChatWindowEventType r105 = new FloatChatWindowEventType("RefreshPageIntent", 5, "refresh_page_intent");
        RefreshPageIntent = r105;
        FloatChatWindowEventType r110 = new FloatChatWindowEventType("MaskClick", 6, "mask_click");
        MaskClick = r110;
        FloatChatWindowEventType r111 = new FloatChatWindowEventType("BackPress", 7, "back_press");
        BackPress = r111;
        FloatChatWindowEventType r112 = new FloatChatWindowEventType("Rebound", 8, "rebound");
        Rebound = r112;
        FloatChatWindowEventType r113 = new FloatChatWindowEventType("ExternalRequest", 9, "external_request");
        ExternalRequest = r113;
        FloatChatWindowEventType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f294924a = r114;
        f294925b = EnumEntriesKt.enumEntries(r114);
    }

    public static FloatChatWindowEventType[] values() {
        return (FloatChatWindowEventType[]) f294924a.clone();
    }

    public final String getFrom() {
        return this.from;
    }

    public static FloatChatWindowEventType valueOf(String r100) {
        return (FloatChatWindowEventType) a.a(FloatChatWindowEventType.class, r100);
    }

    public FloatChatWindowEventType(String r100, int r101, String r102) {
        super(r100, r101);
        this.from = r102;
    }
}
