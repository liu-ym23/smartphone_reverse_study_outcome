package com.bytedance.live.bizlink.impl.platform.dynamic.base;

import ch6.c;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\"\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006%"}, d2 = {"Lcom/bytedance/live/bizlink/impl/platform/dynamic/base/MultiLinkHybMainLinkCBEvent;", "", "Lch6/c;", "", "eventType", "Ljava/lang/String;", "getEventType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "AudienceReceiveInviteMsg", "AudienceReplyMsg", "ReplySuccCB", "ReplyFailCB", "PermitResultCB", "PermitMsgCB", "ApplySuccCB", "ApplyFailCB", "JoinChannelSuccCB", "JoinChannelFailCB", "RtcAdvanceStartSuccCB", "LinkSuccessPreCB", "LinkSuccessCB", "LinkFailCB", "LinkPermissionCheckSuccCB", "LinkPermissionCheckFailCB", "RtcClientInitSuccCB", "RtcClientInitFailCB", "LiveClientInitSuccCB", "LiveClientInitFailCB", "KickOutMsgCB", "SysKickOutMsgCB", "LinkEndSuccessCB", "LeaveChannelSuccCB", "LeaveChannelFailCB", "FinishChannelSuccCB", "FinishChannelFailCB", "multi-biz-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkHybMainLinkCBEvent extends Enum<MultiLinkHybMainLinkCBEvent> implements c {
    public static final MultiLinkHybMainLinkCBEvent ApplyFailCB = null;
    public static final MultiLinkHybMainLinkCBEvent ApplySuccCB = null;
    public static final MultiLinkHybMainLinkCBEvent AudienceReceiveInviteMsg = null;
    public static final MultiLinkHybMainLinkCBEvent AudienceReplyMsg = null;
    public static final a Companion = null;
    public static final MultiLinkHybMainLinkCBEvent FinishChannelFailCB = null;
    public static final MultiLinkHybMainLinkCBEvent FinishChannelSuccCB = null;
    public static final MultiLinkHybMainLinkCBEvent JoinChannelFailCB = null;
    public static final MultiLinkHybMainLinkCBEvent JoinChannelSuccCB = null;
    public static final MultiLinkHybMainLinkCBEvent KickOutMsgCB = null;
    public static final MultiLinkHybMainLinkCBEvent LeaveChannelFailCB = null;
    public static final MultiLinkHybMainLinkCBEvent LeaveChannelSuccCB = null;
    public static final MultiLinkHybMainLinkCBEvent LinkEndSuccessCB = null;
    public static final MultiLinkHybMainLinkCBEvent LinkFailCB = null;
    public static final MultiLinkHybMainLinkCBEvent LinkPermissionCheckFailCB = null;
    public static final MultiLinkHybMainLinkCBEvent LinkPermissionCheckSuccCB = null;
    public static final MultiLinkHybMainLinkCBEvent LinkSuccessCB = null;
    public static final MultiLinkHybMainLinkCBEvent LinkSuccessPreCB = null;
    public static final MultiLinkHybMainLinkCBEvent LiveClientInitFailCB = null;
    public static final MultiLinkHybMainLinkCBEvent LiveClientInitSuccCB = null;
    public static final MultiLinkHybMainLinkCBEvent PermitMsgCB = null;
    public static final MultiLinkHybMainLinkCBEvent PermitResultCB = null;
    public static final MultiLinkHybMainLinkCBEvent ReplyFailCB = null;
    public static final MultiLinkHybMainLinkCBEvent ReplySuccCB = null;
    public static final MultiLinkHybMainLinkCBEvent RtcAdvanceStartSuccCB = null;
    public static final MultiLinkHybMainLinkCBEvent RtcClientInitFailCB = null;
    public static final MultiLinkHybMainLinkCBEvent RtcClientInitSuccCB = null;
    public static final MultiLinkHybMainLinkCBEvent SysKickOutMsgCB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiLinkHybMainLinkCBEvent[] f254889a = null;
    private final String eventType;

    public static MultiLinkHybMainLinkCBEvent valueOf(String r100) {
        return (MultiLinkHybMainLinkCBEvent) r27.a.a(MultiLinkHybMainLinkCBEvent.class, r100);
    }

    public static MultiLinkHybMainLinkCBEvent[] values() {
        return (MultiLinkHybMainLinkCBEvent[]) f254889a.clone();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybMainLinkCBEvent$a] */
    static {
        MultiLinkHybMainLinkCBEvent r100 = new MultiLinkHybMainLinkCBEvent("AudienceReceiveInviteMsg", 0, "cb_event_receive_invite_msg");
        AudienceReceiveInviteMsg = r100;
        MultiLinkHybMainLinkCBEvent r101 = new MultiLinkHybMainLinkCBEvent("AudienceReplyMsg", 1, "cb_event_receive_reply_msg");
        AudienceReplyMsg = r101;
        MultiLinkHybMainLinkCBEvent r102 = new MultiLinkHybMainLinkCBEvent("ReplySuccCB", 2, "cb_event_reply_success");
        ReplySuccCB = r102;
        MultiLinkHybMainLinkCBEvent r103 = new MultiLinkHybMainLinkCBEvent("ReplyFailCB", 3, "cb_event_reply_fail");
        ReplyFailCB = r103;
        MultiLinkHybMainLinkCBEvent r104 = new MultiLinkHybMainLinkCBEvent("PermitResultCB", 4, "cb_event_permit_result");
        PermitResultCB = r104;
        MultiLinkHybMainLinkCBEvent r105 = new MultiLinkHybMainLinkCBEvent("PermitMsgCB", 5, "cb_event_receive_permit_msg");
        PermitMsgCB = r105;
        MultiLinkHybMainLinkCBEvent r106 = new MultiLinkHybMainLinkCBEvent("ApplySuccCB", 6, "cb_event_apply_success");
        ApplySuccCB = r106;
        MultiLinkHybMainLinkCBEvent r107 = new MultiLinkHybMainLinkCBEvent("ApplyFailCB", 7, "cb_event_apply_fail");
        ApplyFailCB = r107;
        MultiLinkHybMainLinkCBEvent r108 = new MultiLinkHybMainLinkCBEvent("JoinChannelSuccCB", 8, "cb_event_join_channel_success");
        JoinChannelSuccCB = r108;
        MultiLinkHybMainLinkCBEvent r109 = new MultiLinkHybMainLinkCBEvent("JoinChannelFailCB", 9, "cb_event_join_channel_fail");
        JoinChannelFailCB = r109;
        MultiLinkHybMainLinkCBEvent r110 = new MultiLinkHybMainLinkCBEvent("RtcAdvanceStartSuccCB", 10, "cb_event_rtc_advance_start_success");
        RtcAdvanceStartSuccCB = r110;
        MultiLinkHybMainLinkCBEvent r111 = new MultiLinkHybMainLinkCBEvent("LinkSuccessPreCB", 11, "cb_event_link_success_pre");
        LinkSuccessPreCB = r111;
        MultiLinkHybMainLinkCBEvent r112 = new MultiLinkHybMainLinkCBEvent("LinkSuccessCB", 12, "cb_event_link_succss");
        LinkSuccessCB = r112;
        MultiLinkHybMainLinkCBEvent r113 = new MultiLinkHybMainLinkCBEvent("LinkFailCB", 13, "cb_event_link_fail");
        LinkFailCB = r113;
        MultiLinkHybMainLinkCBEvent r114 = new MultiLinkHybMainLinkCBEvent("LinkPermissionCheckSuccCB", 14, "cb_event_link_permission_check_success");
        LinkPermissionCheckSuccCB = r114;
        MultiLinkHybMainLinkCBEvent r115 = new MultiLinkHybMainLinkCBEvent("LinkPermissionCheckFailCB", 15, "cb_event_link_permission_check_fail");
        LinkPermissionCheckFailCB = r115;
        MultiLinkHybMainLinkCBEvent r116 = new MultiLinkHybMainLinkCBEvent("RtcClientInitSuccCB", 16, "cb_event_rtc_client_init_success");
        RtcClientInitSuccCB = r116;
        MultiLinkHybMainLinkCBEvent r117 = new MultiLinkHybMainLinkCBEvent("RtcClientInitFailCB", 17, "cb_event_rtc_client_init_fail");
        RtcClientInitFailCB = r117;
        MultiLinkHybMainLinkCBEvent r118 = new MultiLinkHybMainLinkCBEvent("LiveClientInitSuccCB", 18, "cb_event_live_client_init_success");
        LiveClientInitSuccCB = r118;
        MultiLinkHybMainLinkCBEvent r119 = new MultiLinkHybMainLinkCBEvent("LiveClientInitFailCB", 19, "cb_event_live_client_init_fail");
        LiveClientInitFailCB = r119;
        MultiLinkHybMainLinkCBEvent r120 = new MultiLinkHybMainLinkCBEvent("KickOutMsgCB", 20, "cb_event_receive_kick_out_msg");
        KickOutMsgCB = r120;
        MultiLinkHybMainLinkCBEvent r121 = new MultiLinkHybMainLinkCBEvent("SysKickOutMsgCB", 21, "cb_event_receive_sys_kick_out_msg");
        SysKickOutMsgCB = r121;
        MultiLinkHybMainLinkCBEvent r122 = new MultiLinkHybMainLinkCBEvent("LinkEndSuccessCB", 22, "cb_event_link_end_success");
        LinkEndSuccessCB = r122;
        MultiLinkHybMainLinkCBEvent r123 = new MultiLinkHybMainLinkCBEvent("LeaveChannelSuccCB", 23, "cb_event_leave_channel_success");
        LeaveChannelSuccCB = r123;
        MultiLinkHybMainLinkCBEvent r124 = new MultiLinkHybMainLinkCBEvent("LeaveChannelFailCB", 24, "cb_event_leave_channel_fail");
        LeaveChannelFailCB = r124;
        MultiLinkHybMainLinkCBEvent r125 = new MultiLinkHybMainLinkCBEvent("FinishChannelSuccCB", 25, "cb_event_finish_channel_success");
        FinishChannelSuccCB = r125;
        MultiLinkHybMainLinkCBEvent r126 = new MultiLinkHybMainLinkCBEvent("FinishChannelFailCB", 26, "cb_event_finish_channel_fail");
        FinishChannelFailCB = r126;
        f254889a = new MultiLinkHybMainLinkCBEvent[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126};
        Companion = new a();
    }

    public final String getEventType() {
        return this.eventType;
    }

    public MultiLinkHybMainLinkCBEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.eventType = r102;
    }
}
