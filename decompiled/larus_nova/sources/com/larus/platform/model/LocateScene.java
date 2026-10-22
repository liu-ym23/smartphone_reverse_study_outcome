package com.larus.platform.model;

import com.byted.cast.common.TeaEventTrack;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003J\u000e\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0000J\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006$"}, d2 = {"Lcom/larus/platform/model/LocateScene;", "", "triggerPoll", "", "hasLimit", "enableBackgroundTriggerPoll", "pollLevel", "Lcom/larus/platform/model/Level;", "<init>", "(Ljava/lang/String;IZZZLcom/larus/platform/model/Level;)V", "getHasLimit", "()Z", "UNKNOWN", "POLL", "APPLET", "MSG_NEED_LOC", "AGENT_TOOL", "SERVER_CMD", "COLD_LAUNCH", "HOT_LAUNCH", "VUI_AWAKE", "VUI_CMD", "OFFICE_SDK", "REALTIME_CALL_VIDEO_CMD", "ECOMMERCE_ADD_ADDRESS", "DORA_G_CONNECT", "DORA_G_WEAR", "DORA_G_ASR", "DORA_G_QUIT", "canTriggerPoll", "isInBackground", "isHigherThan", TeaEventTrack.ACTION_DRAMA_PRE, "isDoraGRadicalStrategy", "isDoraGStrategy", "isDoraGQuitStrategy", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LocateScene extends Enum<LocateScene> {
    public static final LocateScene AGENT_TOOL = null;
    public static final LocateScene APPLET = null;
    public static final LocateScene COLD_LAUNCH = null;
    public static final LocateScene DORA_G_ASR = null;
    public static final LocateScene DORA_G_CONNECT = null;
    public static final LocateScene DORA_G_QUIT = null;
    public static final LocateScene DORA_G_WEAR = null;
    public static final LocateScene ECOMMERCE_ADD_ADDRESS = null;
    public static final LocateScene HOT_LAUNCH = null;
    public static final LocateScene MSG_NEED_LOC = null;
    public static final LocateScene OFFICE_SDK = null;
    public static final LocateScene POLL = null;
    public static final LocateScene REALTIME_CALL_VIDEO_CMD = null;
    public static final LocateScene SERVER_CMD = null;
    public static final LocateScene UNKNOWN = null;
    public static final LocateScene VUI_AWAKE = null;
    public static final LocateScene VUI_CMD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocateScene[] f365465a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365466b = null;
    private final boolean enableBackgroundTriggerPoll;
    private final boolean hasLimit;
    private final Level pollLevel;
    private final boolean triggerPoll;

    public static EnumEntries<LocateScene> getEntries() {
        return f365466b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        LocateScene r100 = new LocateScene("UNKNOWN", 0, false, false, false, null, 12, null);
        UNKNOWN = r100;
        boolean r110 = false;
        boolean r111 = false;
        Level r112 = null;
        int r113 = 12;
        DefaultConstructorMarker r114 = null;
        LocateScene r101 = new LocateScene("POLL", 1, false, r110, r111, r112, r113, r114);
        POLL = r101;
        boolean r210 = false;
        boolean r211 = false;
        Level r212 = null;
        int r213 = 12;
        LocateScene r102 = new LocateScene("APPLET", 2, false, r210, r211, r212, r213, null);
        APPLET = r102;
        boolean r115 = true;
        LocateScene r103 = new LocateScene("MSG_NEED_LOC", 3, r115, r110, r111, r112, r113, r114);
        MSG_NEED_LOC = r103;
        boolean r214 = true;
        LocateScene r104 = new LocateScene("AGENT_TOOL", 4, r214, r210, r211, r212, r213, 0 == true ? 1 : 0);
        AGENT_TOOL = r104;
        LocateScene r105 = new LocateScene("SERVER_CMD", 5, r115, r110, r111, r112, r113, r114);
        SERVER_CMD = r105;
        LocateScene r106 = new LocateScene("COLD_LAUNCH", 6, r214, true, r211, r212, r213, 0 == true ? 1 : 0);
        COLD_LAUNCH = r106;
        LocateScene r107 = new LocateScene("HOT_LAUNCH", 7, r115, true, r111, r112, r113, r114);
        HOT_LAUNCH = r107;
        boolean r215 = false;
        boolean r216 = false;
        int r217 = 8;
        LocateScene r108 = new LocateScene("VUI_AWAKE", 8, r215, r216, true, r212, r217, 0 == true ? 1 : 0);
        VUI_AWAKE = r108;
        LocateScene r109 = new LocateScene("VUI_CMD", 9, r115, false, r111, r112, 8, r114);
        VUI_CMD = r109;
        boolean r218 = false;
        LocateScene r116 = new LocateScene("OFFICE_SDK", 10, r215, r216, r218, r212, r217, 0 == true ? 1 : 0);
        OFFICE_SDK = r116;
        LocateScene r219 = new LocateScene("REALTIME_CALL_VIDEO_CMD", 11, true, r111, false, null, 12, null);
        REALTIME_CALL_VIDEO_CMD = r219;
        LocateScene r117 = new LocateScene("ECOMMERCE_ADD_ADDRESS", 12, r218, false, false, 0 == true ? 1 : 0, 8, null);
        ECOMMERCE_ADD_ADDRESS = r117;
        Level r220 = Level.HIGH;
        LocateScene r118 = new LocateScene("DORA_G_CONNECT", 13, true, false, true, r220);
        DORA_G_CONNECT = r118;
        LocateScene r119 = new LocateScene("DORA_G_WEAR", 14, true, false, true, r220);
        DORA_G_WEAR = r119;
        LocateScene r120 = new LocateScene("DORA_G_ASR", 15, true, false, true, r220);
        DORA_G_ASR = r120;
        LocateScene r121 = new LocateScene("DORA_G_QUIT", 16, false, false, false, r220);
        DORA_G_QUIT = r121;
        LocateScene[] r122 = {r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r116, r219, r117, r118, r119, r120, r121};
        f365465a = r122;
        f365466b = EnumEntriesKt.enumEntries(r122);
    }

    public static LocateScene[] values() {
        return (LocateScene[]) f365465a.clone();
    }

    public final boolean isDoraGQuitStrategy() {
        if (this != DORA_G_QUIT) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isDoraGRadicalStrategy() {
        if (this != DORA_G_CONNECT) goto L5;
    L10:
        return true;
    L5:
        if (this == DORA_G_ASR) goto L10;
        if (this == DORA_G_WEAR) goto L10;
        return false;
    }

    public final boolean isDoraGStrategy() {
        if (isDoraGQuitStrategy() == false) goto L5;
    L8:
        return true;
    L5:
        if (isDoraGRadicalStrategy() == true) goto L8;
        return false;
    }

    public final boolean getHasLimit() {
        return this.hasLimit;
    }

    public static LocateScene valueOf(String r100) {
        return (LocateScene) a.a(LocateScene.class, r100);
    }

    public final boolean canTriggerPoll(boolean r100) {
        if (this.triggerPoll == true) goto L6;
        return false;
    L6:
        if (r100 == true) goto L8;
        return true;
    L8:
        return this.enableBackgroundTriggerPoll;
    }

    public final boolean isHigherThan(LocateScene r100) {
        Intrinsics.checkNotNullParameter(r100, TeaEventTrack.ACTION_DRAMA_PRE);
        if (this.pollLevel == Level.HIGH) goto L5;
    L7:
        return false;
    L5:
        if (r100.pollLevel != Level.Normal) goto L7;
        return true;
    }

    public LocateScene(String r100, int r101, boolean r102, boolean r103, boolean r104, Level r105) {
        super(r100, r101);
        this.triggerPoll = r102;
        this.hasLimit = r103;
        this.enableBackgroundTriggerPoll = r104;
        this.pollLevel = r105;
    }

    public /* synthetic */ LocateScene(String r100, int r101, boolean r110, boolean r111, boolean r112, Level r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 4) == 0) goto L5;
        boolean r102 = false;
    L7:
        if ((r114 & 8) == 0) goto L9;
        r113 = Level.Normal;
    L9:
        this(r100, r101, r110, r111, r102, r113);
        return;
    L5:
        r102 = r112;
        goto L7
    }
}
