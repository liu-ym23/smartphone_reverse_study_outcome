package com.larus.voicecall.impl.component.vlm;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/voicecall/impl/component/vlm/ExitVideoModalReason;", "", "str", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStr", "()Ljava/lang/String;", "OPEN_SHARE_SCREEN", "EXIT_FOR_RTC_ERROR", "REJECT_CAMERA_PERMISSION", "ON_REACH_VIDEO_CALL_DURATION_LIMIT", "REJECT_CAMERA_PERMISSION_ON_CLICK", "EXIT_FOR_DISCONNECT", "EXIT_FOR_ENTER_SCENE", "O_EXIT_VIDEO_MODAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExitVideoModalReason extends Enum<ExitVideoModalReason> {
    public static final ExitVideoModalReason EXIT_FOR_DISCONNECT = null;
    public static final ExitVideoModalReason EXIT_FOR_ENTER_SCENE = null;
    public static final ExitVideoModalReason EXIT_FOR_RTC_ERROR = null;
    public static final ExitVideoModalReason ON_REACH_VIDEO_CALL_DURATION_LIMIT = null;
    public static final ExitVideoModalReason OPEN_SHARE_SCREEN = null;
    public static final ExitVideoModalReason O_EXIT_VIDEO_MODAL = null;
    public static final ExitVideoModalReason REJECT_CAMERA_PERMISSION = null;
    public static final ExitVideoModalReason REJECT_CAMERA_PERMISSION_ON_CLICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExitVideoModalReason[] f377787a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f377788b = null;
    private final String str;

    public static EnumEntries<ExitVideoModalReason> getEntries() {
        return f377788b;
    }

    static {
        ExitVideoModalReason r100 = new ExitVideoModalReason("OPEN_SHARE_SCREEN", 0, "open_screen_share");
        OPEN_SHARE_SCREEN = r100;
        ExitVideoModalReason r101 = new ExitVideoModalReason("EXIT_FOR_RTC_ERROR", 1, "on_error_from_rtc");
        EXIT_FOR_RTC_ERROR = r101;
        ExitVideoModalReason r102 = new ExitVideoModalReason("REJECT_CAMERA_PERMISSION", 2, "reject_camera_permission");
        REJECT_CAMERA_PERMISSION = r102;
        ExitVideoModalReason r103 = new ExitVideoModalReason("ON_REACH_VIDEO_CALL_DURATION_LIMIT", 3, "on_reach_video_call_duration_limit");
        ON_REACH_VIDEO_CALL_DURATION_LIMIT = r103;
        ExitVideoModalReason r104 = new ExitVideoModalReason("REJECT_CAMERA_PERMISSION_ON_CLICK", 4, "reject_camera_permission_on_click");
        REJECT_CAMERA_PERMISSION_ON_CLICK = r104;
        ExitVideoModalReason r105 = new ExitVideoModalReason("EXIT_FOR_DISCONNECT", 5, "exit_for_disconnect");
        EXIT_FOR_DISCONNECT = r105;
        ExitVideoModalReason r110 = new ExitVideoModalReason("EXIT_FOR_ENTER_SCENE", 6, "exit_for_enter_scene");
        EXIT_FOR_ENTER_SCENE = r110;
        ExitVideoModalReason r111 = new ExitVideoModalReason("O_EXIT_VIDEO_MODAL", 7, "o_exit_video_modal");
        O_EXIT_VIDEO_MODAL = r111;
        ExitVideoModalReason[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f377787a = r112;
        f377788b = EnumEntriesKt.enumEntries(r112);
    }

    public static ExitVideoModalReason[] values() {
        return (ExitVideoModalReason[]) f377787a.clone();
    }

    public final String getStr() {
        return this.str;
    }

    public static ExitVideoModalReason valueOf(String r100) {
        return (ExitVideoModalReason) r27.a.a(ExitVideoModalReason.class, r100);
    }

    public ExitVideoModalReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.str = r102;
    }
}
