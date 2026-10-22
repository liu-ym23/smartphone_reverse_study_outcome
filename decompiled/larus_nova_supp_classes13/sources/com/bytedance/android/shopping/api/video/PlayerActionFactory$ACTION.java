package com.bytedance.android.shopping.api.video;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"com/bytedance/android/shopping/api/video/PlayerActionFactory$ACTION", "", "Lcom/bytedance/android/shopping/api/video/PlayerActionFactory$ACTION;", "", "actionName", "Ljava/lang/String;", "getActionName", "()Ljava/lang/String;", "CREATE", "BIND_DATA", "PLAY_NEW_SESSION", "PAUSE", "RESUME", "STOP", "FINISH", "RELEASE", "MUTE", "ON_RENDER_FIRST_FRAME", "ON_FAILED", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PlayerActionFactory$ACTION extends Enum<PlayerActionFactory$ACTION> {
    public static final PlayerActionFactory$ACTION BIND_DATA = null;
    public static final PlayerActionFactory$ACTION CREATE = null;
    public static final PlayerActionFactory$ACTION FINISH = null;
    public static final PlayerActionFactory$ACTION MUTE = null;
    public static final PlayerActionFactory$ACTION ON_FAILED = null;
    public static final PlayerActionFactory$ACTION ON_RENDER_FIRST_FRAME = null;
    public static final PlayerActionFactory$ACTION PAUSE = null;
    public static final PlayerActionFactory$ACTION PLAY_NEW_SESSION = null;
    public static final PlayerActionFactory$ACTION RELEASE = null;
    public static final PlayerActionFactory$ACTION RESUME = null;
    public static final PlayerActionFactory$ACTION STOP = null;
    public static final /* synthetic */ PlayerActionFactory$ACTION[] a = null;
    private final String actionName;

    public static PlayerActionFactory$ACTION valueOf(String r1) {
        return (PlayerActionFactory$ACTION) r27.a.a(PlayerActionFactory$ACTION.class, r1);
    }

    public static PlayerActionFactory$ACTION[] values() {
        return (PlayerActionFactory$ACTION[]) a.clone();
    }

    static {
        PlayerActionFactory$ACTION r1 = new PlayerActionFactory$ACTION("CREATE", 0, "create");
        CREATE = r1;
        PlayerActionFactory$ACTION r2 = new PlayerActionFactory$ACTION("BIND_DATA", 1, "bindData");
        BIND_DATA = r2;
        PlayerActionFactory$ACTION r3 = new PlayerActionFactory$ACTION("PLAY_NEW_SESSION", 2, "playNewSession");
        PLAY_NEW_SESSION = r3;
        PlayerActionFactory$ACTION r4 = new PlayerActionFactory$ACTION("PAUSE", 3, "pause");
        PAUSE = r4;
        PlayerActionFactory$ACTION r5 = new PlayerActionFactory$ACTION("RESUME", 4, "resume");
        RESUME = r5;
        PlayerActionFactory$ACTION r6 = new PlayerActionFactory$ACTION("STOP", 5, "stop");
        STOP = r6;
        PlayerActionFactory$ACTION r7 = new PlayerActionFactory$ACTION("FINISH", 6, "finish");
        FINISH = r7;
        PlayerActionFactory$ACTION r8 = new PlayerActionFactory$ACTION("RELEASE", 7, "release");
        RELEASE = r8;
        PlayerActionFactory$ACTION r9 = new PlayerActionFactory$ACTION("MUTE", 8, "mute");
        MUTE = r9;
        PlayerActionFactory$ACTION r10 = new PlayerActionFactory$ACTION("ON_RENDER_FIRST_FRAME", 9, "onRenderFirstFrame");
        ON_RENDER_FIRST_FRAME = r10;
        PlayerActionFactory$ACTION r11 = new PlayerActionFactory$ACTION("ON_FAILED", 10, "on_failed");
        ON_FAILED = r11;
        a = new PlayerActionFactory$ACTION[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
    }

    public final String getActionName() {
        return this.actionName;
    }

    public PlayerActionFactory$ACTION(String r1, int r2, String r3) {
        super(r1, r2);
        this.actionName = r3;
    }
}
