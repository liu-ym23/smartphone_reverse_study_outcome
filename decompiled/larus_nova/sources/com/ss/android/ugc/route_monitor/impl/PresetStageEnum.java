package com.ss.android.ugc.route_monitor.impl;

import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006\""}, d2 = {"Lcom/ss/android/ugc/route_monitor/impl/PresetStageEnum;", "", "", "stageName", "Ljava/lang/String;", "getStageName", "()Ljava/lang/String;", "", "stageCode", "I", "getStageCode", "()I", "APPLICATION_ATTACH_BASE_CONTEXT_START", "APPLICATION_ON_CREATE_START", "APPLICATION_ON_CREATE_END", "PUSH_ACTIVITY_ON_CREATE_START", "PUSH_ACTIVITY_ON_CREATE_END", "DEEPLINK_ACTIVITY_ON_CREATE_START", "DEEPLINK_ACTIVITY_ON_CREATE_END", "DEEPLINK_ACTIVITY_ON_START_START", "DEEPLINK_ACTIVITY_ON_START_END", "DEEPLINK_END", "TRANSITION_PAGE_ON_CREATE_START", "TRANSITION_PAGE_ON_CREATE_END", "TRANSITION_PAGE_ON_RESUME_START", "TRANSITION_PAGE_ON_RESUME_END", "TRANSITION_PAGE_ON_VIEW_SHOW", "DEFAULT_TIMEOUT_END", "SESSION_INTERRUPTION", "UNDERTAKE_PAGE_ON_CREATE_START", "UNDERTAKE_PAGE_ON_CREATE_END", "UNDERTAKE_PAGE_ON_RESUME_START", "UNDERTAKE_PAGE_ON_RESUME_END", "UNDERTAKE_PAGE_ON_VIEW_SHOW", "route-monitor_release"}, k = 1, mv = {1, 4, 0})
public final enum PresetStageEnum extends Enum<PresetStageEnum> {
    public static final PresetStageEnum APPLICATION_ATTACH_BASE_CONTEXT_START = null;
    public static final PresetStageEnum APPLICATION_ON_CREATE_END = null;
    public static final PresetStageEnum APPLICATION_ON_CREATE_START = null;
    public static final PresetStageEnum DEEPLINK_ACTIVITY_ON_CREATE_END = null;
    public static final PresetStageEnum DEEPLINK_ACTIVITY_ON_CREATE_START = null;
    public static final PresetStageEnum DEEPLINK_ACTIVITY_ON_START_END = null;
    public static final PresetStageEnum DEEPLINK_ACTIVITY_ON_START_START = null;
    public static final PresetStageEnum DEEPLINK_END = null;
    public static final PresetStageEnum DEFAULT_TIMEOUT_END = null;
    public static final PresetStageEnum PUSH_ACTIVITY_ON_CREATE_END = null;
    public static final PresetStageEnum PUSH_ACTIVITY_ON_CREATE_START = null;
    public static final PresetStageEnum SESSION_INTERRUPTION = null;
    public static final PresetStageEnum TRANSITION_PAGE_ON_CREATE_END = null;
    public static final PresetStageEnum TRANSITION_PAGE_ON_CREATE_START = null;
    public static final PresetStageEnum TRANSITION_PAGE_ON_RESUME_END = null;
    public static final PresetStageEnum TRANSITION_PAGE_ON_RESUME_START = null;
    public static final PresetStageEnum TRANSITION_PAGE_ON_VIEW_SHOW = null;
    public static final PresetStageEnum UNDERTAKE_PAGE_ON_CREATE_END = null;
    public static final PresetStageEnum UNDERTAKE_PAGE_ON_CREATE_START = null;
    public static final PresetStageEnum UNDERTAKE_PAGE_ON_RESUME_END = null;
    public static final PresetStageEnum UNDERTAKE_PAGE_ON_RESUME_START = null;
    public static final PresetStageEnum UNDERTAKE_PAGE_ON_VIEW_SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PresetStageEnum[] f454391a = null;
    private final int stageCode;
    private final String stageName;

    public static PresetStageEnum valueOf(String r100) {
        return (PresetStageEnum) r27.a.a(PresetStageEnum.class, r100);
    }

    public static PresetStageEnum[] values() {
        return (PresetStageEnum[]) f454391a.clone();
    }

    static {
        PresetStageEnum r100 = new PresetStageEnum("APPLICATION_ATTACH_BASE_CONTEXT_START", 0, "Application_attachBaseContext_start", -1);
        APPLICATION_ATTACH_BASE_CONTEXT_START = r100;
        PresetStageEnum r101 = new PresetStageEnum("APPLICATION_ON_CREATE_START", 1, "Application_onCreate_start", 0);
        APPLICATION_ON_CREATE_START = r101;
        PresetStageEnum r102 = new PresetStageEnum("APPLICATION_ON_CREATE_END", 2, "Application_onCreate_end", 49);
        APPLICATION_ON_CREATE_END = r102;
        PresetStageEnum r103 = new PresetStageEnum("PUSH_ACTIVITY_ON_CREATE_START", 3, "PushActivity_onCreate_start", 50);
        PUSH_ACTIVITY_ON_CREATE_START = r103;
        PresetStageEnum r104 = new PresetStageEnum("PUSH_ACTIVITY_ON_CREATE_END", 4, "PushActivity_onCreate_end", 99);
        PUSH_ACTIVITY_ON_CREATE_END = r104;
        PresetStageEnum r105 = new PresetStageEnum("DEEPLINK_ACTIVITY_ON_CREATE_START", 5, "DeepLinkActivity_onCreate_start", 100);
        DEEPLINK_ACTIVITY_ON_CREATE_START = r105;
        PresetStageEnum r106 = new PresetStageEnum("DEEPLINK_ACTIVITY_ON_CREATE_END", 6, "DeepLinkActivity_onCreate_end", 149);
        DEEPLINK_ACTIVITY_ON_CREATE_END = r106;
        PresetStageEnum r107 = new PresetStageEnum("DEEPLINK_ACTIVITY_ON_START_START", 7, "DeepLinkActivity_onCreate_start", 150);
        DEEPLINK_ACTIVITY_ON_START_START = r107;
        PresetStageEnum r108 = new PresetStageEnum("DEEPLINK_ACTIVITY_ON_START_END", 8, "DeepLinkActivity_onCreate_end", 199);
        DEEPLINK_ACTIVITY_ON_START_END = r108;
        PresetStageEnum r109 = new PresetStageEnum("DEEPLINK_END", 9, "DeepLink_end", 299);
        DEEPLINK_END = r109;
        PresetStageEnum r110 = new PresetStageEnum("TRANSITION_PAGE_ON_CREATE_START", 10, "TransitionPage_onCreate_start", 300);
        TRANSITION_PAGE_ON_CREATE_START = r110;
        PresetStageEnum r111 = new PresetStageEnum("TRANSITION_PAGE_ON_CREATE_END", 11, "TransitionPage_onCreate_end", MediaPlayer.MEDIA_PLAYER_OPTION_BYTEVC1_SW_FORBIDDEN);
        TRANSITION_PAGE_ON_CREATE_END = r111;
        PresetStageEnum r112 = new PresetStageEnum("TRANSITION_PAGE_ON_RESUME_START", 12, "TransitionPage_onResume_start", 400);
        TRANSITION_PAGE_ON_RESUME_START = r112;
        PresetStageEnum r113 = new PresetStageEnum("TRANSITION_PAGE_ON_RESUME_END", 13, "TransitionPage_onResume_end", TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_BARRAGE_MASK);
        TRANSITION_PAGE_ON_RESUME_END = r113;
        PresetStageEnum r114 = new PresetStageEnum("TRANSITION_PAGE_ON_VIEW_SHOW", 14, "TransitionPage_onView_show", 500);
        TRANSITION_PAGE_ON_VIEW_SHOW = r114;
        PresetStageEnum r115 = new PresetStageEnum("DEFAULT_TIMEOUT_END", 15, "Default_timeout_end", 600);
        DEFAULT_TIMEOUT_END = r115;
        PresetStageEnum r116 = new PresetStageEnum("SESSION_INTERRUPTION", 16, "Session_interruption", 601);
        SESSION_INTERRUPTION = r116;
        PresetStageEnum r117 = new PresetStageEnum("UNDERTAKE_PAGE_ON_CREATE_START", 17, "UndertakePage_onCreate_start", 1000);
        UNDERTAKE_PAGE_ON_CREATE_START = r117;
        PresetStageEnum r118 = new PresetStageEnum("UNDERTAKE_PAGE_ON_CREATE_END", 18, "UndertakePage_onCreate_end", 1099);
        UNDERTAKE_PAGE_ON_CREATE_END = r118;
        PresetStageEnum r119 = new PresetStageEnum("UNDERTAKE_PAGE_ON_RESUME_START", 19, "UndertakePage_onResume_start", 1100);
        UNDERTAKE_PAGE_ON_RESUME_START = r119;
        PresetStageEnum r120 = new PresetStageEnum("UNDERTAKE_PAGE_ON_RESUME_END", 20, "UndertakePage_onResume_end", 1199);
        UNDERTAKE_PAGE_ON_RESUME_END = r120;
        PresetStageEnum r121 = new PresetStageEnum("UNDERTAKE_PAGE_ON_VIEW_SHOW", 21, "UndertakePage_onViewShow", 1200);
        UNDERTAKE_PAGE_ON_VIEW_SHOW = r121;
        f454391a = new PresetStageEnum[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121};
    }

    public final int getStageCode() {
        return this.stageCode;
    }

    public final String getStageName() {
        return this.stageName;
    }

    public PresetStageEnum(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.stageName = r102;
        this.stageCode = r103;
    }
}
