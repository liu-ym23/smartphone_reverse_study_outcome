package com.bytedance.live.bizlink.impl.platform.dynamic.base;

import ch6.c;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/live/bizlink/impl/platform/dynamic/base/MultiLinkHybGuestLinkCBEvent;", "", "Lch6/c;", "", "eventType", "Ljava/lang/String;", "getEventType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OwnerJoinChannelSuccCB", "OwnerJoinChannelFailCB", "OnlookerEnterChannelSuccCB", "OnlookerEnterChannelFailCB", "OwnerFinishChannelSuccCB", "OwnerFinishChannelFailCB", "OnlookerLeaveChannelSuccCB", "OnlookerLeaveChannelFailCB", "RtcRoomInitSuccCB", "RtcRoomInitFailCB", "RtcRoomSelfJoinSuccCB", "RtcRoomSelfJoinFailCB", "RtcRoomSelfLeaveSuccCB", "RtcRoomSelfLeaveFailCB", "RtcRoomSelfConnLostOrFailCB", "RtcRoomSelfRtcErrCB", "RtcRoomRemoteUserJoinedCB", "RtcRoomRemoteUserLeavedCB", "RtcRoomBothJoinSuccCB", "RtcCallCountDownUpdateCB", "RtcCallCountDownEndCB", "multi-biz-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkHybGuestLinkCBEvent extends Enum<MultiLinkHybGuestLinkCBEvent> implements c {
    public static final a Companion = null;
    public static final MultiLinkHybGuestLinkCBEvent OnlookerEnterChannelFailCB = null;
    public static final MultiLinkHybGuestLinkCBEvent OnlookerEnterChannelSuccCB = null;
    public static final MultiLinkHybGuestLinkCBEvent OnlookerLeaveChannelFailCB = null;
    public static final MultiLinkHybGuestLinkCBEvent OnlookerLeaveChannelSuccCB = null;
    public static final MultiLinkHybGuestLinkCBEvent OwnerFinishChannelFailCB = null;
    public static final MultiLinkHybGuestLinkCBEvent OwnerFinishChannelSuccCB = null;
    public static final MultiLinkHybGuestLinkCBEvent OwnerJoinChannelFailCB = null;
    public static final MultiLinkHybGuestLinkCBEvent OwnerJoinChannelSuccCB = null;
    public static final MultiLinkHybGuestLinkCBEvent RtcCallCountDownEndCB = null;
    public static final MultiLinkHybGuestLinkCBEvent RtcCallCountDownUpdateCB = null;
    public static final MultiLinkHybGuestLinkCBEvent RtcRoomBothJoinSuccCB = null;
    public static final MultiLinkHybGuestLinkCBEvent RtcRoomInitFailCB = null;
    public static final MultiLinkHybGuestLinkCBEvent RtcRoomInitSuccCB = null;
    public static final MultiLinkHybGuestLinkCBEvent RtcRoomRemoteUserJoinedCB = null;
    public static final MultiLinkHybGuestLinkCBEvent RtcRoomRemoteUserLeavedCB = null;
    public static final MultiLinkHybGuestLinkCBEvent RtcRoomSelfConnLostOrFailCB = null;
    public static final MultiLinkHybGuestLinkCBEvent RtcRoomSelfJoinFailCB = null;
    public static final MultiLinkHybGuestLinkCBEvent RtcRoomSelfJoinSuccCB = null;
    public static final MultiLinkHybGuestLinkCBEvent RtcRoomSelfLeaveFailCB = null;
    public static final MultiLinkHybGuestLinkCBEvent RtcRoomSelfLeaveSuccCB = null;
    public static final MultiLinkHybGuestLinkCBEvent RtcRoomSelfRtcErrCB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiLinkHybGuestLinkCBEvent[] f254885a = null;
    private final String eventType;

    public static MultiLinkHybGuestLinkCBEvent valueOf(String r100) {
        return (MultiLinkHybGuestLinkCBEvent) r27.a.a(MultiLinkHybGuestLinkCBEvent.class, r100);
    }

    public static MultiLinkHybGuestLinkCBEvent[] values() {
        return (MultiLinkHybGuestLinkCBEvent[]) f254885a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybGuestLinkCBEvent$a] */
    static {
        MultiLinkHybGuestLinkCBEvent r100 = new MultiLinkHybGuestLinkCBEvent("OwnerJoinChannelSuccCB", 0, "owner_join_channel_success");
        OwnerJoinChannelSuccCB = r100;
        MultiLinkHybGuestLinkCBEvent r101 = new MultiLinkHybGuestLinkCBEvent("OwnerJoinChannelFailCB", 1, "owner_join_channel_fail");
        OwnerJoinChannelFailCB = r101;
        MultiLinkHybGuestLinkCBEvent r102 = new MultiLinkHybGuestLinkCBEvent("OnlookerEnterChannelSuccCB", 2, "onlooker_enter_channel_success");
        OnlookerEnterChannelSuccCB = r102;
        MultiLinkHybGuestLinkCBEvent r103 = new MultiLinkHybGuestLinkCBEvent("OnlookerEnterChannelFailCB", 3, "onlooker_enter_channel_fail");
        OnlookerEnterChannelFailCB = r103;
        MultiLinkHybGuestLinkCBEvent r104 = new MultiLinkHybGuestLinkCBEvent("OwnerFinishChannelSuccCB", 4, "cb_event_owner_finish_channel_success");
        OwnerFinishChannelSuccCB = r104;
        MultiLinkHybGuestLinkCBEvent r105 = new MultiLinkHybGuestLinkCBEvent("OwnerFinishChannelFailCB", 5, "cb_event_owner_finish_channel_fail");
        OwnerFinishChannelFailCB = r105;
        MultiLinkHybGuestLinkCBEvent r106 = new MultiLinkHybGuestLinkCBEvent("OnlookerLeaveChannelSuccCB", 6, "cb_event_onlooker_leave_channel_success");
        OnlookerLeaveChannelSuccCB = r106;
        MultiLinkHybGuestLinkCBEvent r107 = new MultiLinkHybGuestLinkCBEvent("OnlookerLeaveChannelFailCB", 7, "cb_event_onlooker_leave_channel_fail");
        OnlookerLeaveChannelFailCB = r107;
        MultiLinkHybGuestLinkCBEvent r108 = new MultiLinkHybGuestLinkCBEvent("RtcRoomInitSuccCB", 8, "cb_event_rtc_room_init_success");
        RtcRoomInitSuccCB = r108;
        MultiLinkHybGuestLinkCBEvent r109 = new MultiLinkHybGuestLinkCBEvent("RtcRoomInitFailCB", 9, "cb_event_rtc_room_init_fail");
        RtcRoomInitFailCB = r109;
        MultiLinkHybGuestLinkCBEvent r110 = new MultiLinkHybGuestLinkCBEvent("RtcRoomSelfJoinSuccCB", 10, "cb_event_rtc_room_self_join_success");
        RtcRoomSelfJoinSuccCB = r110;
        MultiLinkHybGuestLinkCBEvent r111 = new MultiLinkHybGuestLinkCBEvent("RtcRoomSelfJoinFailCB", 11, "cb_event_rtc_room_self_join_fail");
        RtcRoomSelfJoinFailCB = r111;
        MultiLinkHybGuestLinkCBEvent r112 = new MultiLinkHybGuestLinkCBEvent("RtcRoomSelfLeaveSuccCB", 12, "cb_event_rtc_room_self_leave_success");
        RtcRoomSelfLeaveSuccCB = r112;
        MultiLinkHybGuestLinkCBEvent r113 = new MultiLinkHybGuestLinkCBEvent("RtcRoomSelfLeaveFailCB", 13, "cb_event_rtc_room_self_leave_fail");
        RtcRoomSelfLeaveFailCB = r113;
        MultiLinkHybGuestLinkCBEvent r114 = new MultiLinkHybGuestLinkCBEvent("RtcRoomSelfConnLostOrFailCB", 14, "cb_event_rtc_room_self_conn_lost_or_fail");
        RtcRoomSelfConnLostOrFailCB = r114;
        MultiLinkHybGuestLinkCBEvent r115 = new MultiLinkHybGuestLinkCBEvent("RtcRoomSelfRtcErrCB", 15, "cb_event_rtc_room_self_rtc_error");
        RtcRoomSelfRtcErrCB = r115;
        MultiLinkHybGuestLinkCBEvent r116 = new MultiLinkHybGuestLinkCBEvent("RtcRoomRemoteUserJoinedCB", 16, "cb_event_rtc_room_remote_user_joined");
        RtcRoomRemoteUserJoinedCB = r116;
        MultiLinkHybGuestLinkCBEvent r117 = new MultiLinkHybGuestLinkCBEvent("RtcRoomRemoteUserLeavedCB", 17, "cb_event_rtc_room_remote_user_leaved");
        RtcRoomRemoteUserLeavedCB = r117;
        MultiLinkHybGuestLinkCBEvent r118 = new MultiLinkHybGuestLinkCBEvent("RtcRoomBothJoinSuccCB", 18, "cb_event_rtc_room_both_join_success");
        RtcRoomBothJoinSuccCB = r118;
        MultiLinkHybGuestLinkCBEvent r119 = new MultiLinkHybGuestLinkCBEvent("RtcCallCountDownUpdateCB", 19, "cb_event_rtc_call_count_down_update");
        RtcCallCountDownUpdateCB = r119;
        MultiLinkHybGuestLinkCBEvent r120 = new MultiLinkHybGuestLinkCBEvent("RtcCallCountDownEndCB", 20, "cb_event_rtc_call_count_down_end");
        RtcCallCountDownEndCB = r120;
        f254885a = new MultiLinkHybGuestLinkCBEvent[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120};
        Companion = new a();
    }

    public final String getEventType() {
        return this.eventType;
    }

    public MultiLinkHybGuestLinkCBEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.eventType = r102;
    }
}
