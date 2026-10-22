package com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/live/extension/plugin/api/rtc/engine/type/LiveWrappedRoomProfile;", "", "", "value", "I", "Companion", "a", "COMMUNICATION", "GAME", "CLOUD_GAME", "LOW_LATENCY", "CHAT_ROOM", "INTERACTIVE_PODCAST", "CHORUS", "GAME_STREAMING", "MEETING", "MEETING_ROOM", "CLASSROOM", "CALL", "LIVE", "live_extension_plugin_api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveWrappedRoomProfile extends Enum<LiveWrappedRoomProfile> {
    public static final LiveWrappedRoomProfile CALL = null;
    public static final LiveWrappedRoomProfile CHAT_ROOM = null;
    public static final LiveWrappedRoomProfile CHORUS = null;
    public static final LiveWrappedRoomProfile CLASSROOM = null;
    public static final LiveWrappedRoomProfile CLOUD_GAME = null;
    public static final LiveWrappedRoomProfile COMMUNICATION = null;
    public static final a Companion = null;
    public static final LiveWrappedRoomProfile GAME = null;
    public static final LiveWrappedRoomProfile GAME_STREAMING = null;
    public static final LiveWrappedRoomProfile INTERACTIVE_PODCAST = null;
    public static final LiveWrappedRoomProfile LIVE = null;
    public static final LiveWrappedRoomProfile LOW_LATENCY = null;
    public static final LiveWrappedRoomProfile MEETING = null;
    public static final LiveWrappedRoomProfile MEETING_ROOM = null;
    public static final /* synthetic */ LiveWrappedRoomProfile[] a = null;
    private final int value;

    public static LiveWrappedRoomProfile valueOf(String r1) {
        return (LiveWrappedRoomProfile) r27.a.a(LiveWrappedRoomProfile.class, r1);
    }

    public static LiveWrappedRoomProfile[] values() {
        return (LiveWrappedRoomProfile[]) a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomProfile$a] */
    static {
        LiveWrappedRoomProfile r1 = new LiveWrappedRoomProfile("COMMUNICATION", 0, 0);
        COMMUNICATION = r1;
        LiveWrappedRoomProfile r2 = new LiveWrappedRoomProfile("GAME", 1, 2);
        GAME = r2;
        LiveWrappedRoomProfile r3 = new LiveWrappedRoomProfile("CLOUD_GAME", 2, 3);
        CLOUD_GAME = r3;
        LiveWrappedRoomProfile r4 = new LiveWrappedRoomProfile("LOW_LATENCY", 3, 4);
        LOW_LATENCY = r4;
        LiveWrappedRoomProfile r5 = new LiveWrappedRoomProfile("CHAT_ROOM", 4, 6);
        CHAT_ROOM = r5;
        LiveWrappedRoomProfile r6 = new LiveWrappedRoomProfile("INTERACTIVE_PODCAST", 5, 10);
        INTERACTIVE_PODCAST = r6;
        LiveWrappedRoomProfile r7 = new LiveWrappedRoomProfile("CHORUS", 6, 12);
        CHORUS = r7;
        LiveWrappedRoomProfile r8 = new LiveWrappedRoomProfile("GAME_STREAMING", 7, 14);
        GAME_STREAMING = r8;
        LiveWrappedRoomProfile r9 = new LiveWrappedRoomProfile("MEETING", 8, 16);
        MEETING = r9;
        LiveWrappedRoomProfile r10 = new LiveWrappedRoomProfile("MEETING_ROOM", 9, 17);
        MEETING_ROOM = r10;
        LiveWrappedRoomProfile r11 = new LiveWrappedRoomProfile("CLASSROOM", 10, 18);
        CLASSROOM = r11;
        LiveWrappedRoomProfile r12 = new LiveWrappedRoomProfile("CALL", 11, 19);
        CALL = r12;
        LiveWrappedRoomProfile r13 = new LiveWrappedRoomProfile("LIVE", 12, 20);
        LIVE = r13;
        a = new LiveWrappedRoomProfile[]{r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13};
        Companion = new a();
    }

    public final int value() {
        return this.value;
    }

    public LiveWrappedRoomProfile(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
