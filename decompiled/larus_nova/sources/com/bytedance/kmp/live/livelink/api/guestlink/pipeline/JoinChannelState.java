package com.bytedance.kmp.live.livelink.api.guestlink.pipeline;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/kmp/live/livelink/api/guestlink/pipeline/JoinChannelState;", "", UserProfileEvent.POSITION_NONE, "STATE_INIT", "STATE_SELF_JOIN_RTC_ROOM_SUCCESS", "STATE_WAITING", "STATE_ONLINE", "STATE_FAILED", "multi-link-service-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum JoinChannelState extends Enum<JoinChannelState> {
    public static final JoinChannelState NONE = null;
    public static final JoinChannelState STATE_FAILED = null;
    public static final JoinChannelState STATE_INIT = null;
    public static final JoinChannelState STATE_ONLINE = null;
    public static final JoinChannelState STATE_SELF_JOIN_RTC_ROOM_SUCCESS = null;
    public static final JoinChannelState STATE_WAITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ JoinChannelState[] f252201a = null;

    static {
        JoinChannelState r100 = new JoinChannelState(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        JoinChannelState r101 = new JoinChannelState("STATE_INIT", 1);
        STATE_INIT = r101;
        JoinChannelState r102 = new JoinChannelState("STATE_SELF_JOIN_RTC_ROOM_SUCCESS", 2);
        STATE_SELF_JOIN_RTC_ROOM_SUCCESS = r102;
        JoinChannelState r103 = new JoinChannelState("STATE_WAITING", 3);
        STATE_WAITING = r103;
        JoinChannelState r104 = new JoinChannelState("STATE_ONLINE", 4);
        STATE_ONLINE = r104;
        JoinChannelState r105 = new JoinChannelState("STATE_FAILED", 5);
        STATE_FAILED = r105;
        f252201a = new JoinChannelState[]{r100, r101, r102, r103, r104, r105};
    }

    public static JoinChannelState valueOf(String r100) {
        return (JoinChannelState) a.a(JoinChannelState.class, r100);
    }

    public static JoinChannelState[] values() {
        return (JoinChannelState[]) f252201a.clone();
    }

    public JoinChannelState(String r100, int r101) {
        super(r100, r101);
    }
}
