package com.bytedance.live.bizlink.impl.platform.dynamic.base;

import ch6.c;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/live/bizlink/impl/platform/dynamic/base/MultiLinkHybMediaCBEvent;", "", "Lch6/c;", "", "eventType", "Ljava/lang/String;", "getEventType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "LiveClientStreamInfoCB", "LiveClientStreamErrorCB", "LinkRtcInfoCB", "LinkRtcRtsRoomMessageCB", "LinkRtcRtsUserMessageCB", "LinkRtcErrorCB", "multi-biz-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkHybMediaCBEvent extends Enum<MultiLinkHybMediaCBEvent> implements c {
    public static final a Companion = null;
    public static final MultiLinkHybMediaCBEvent LinkRtcErrorCB = null;
    public static final MultiLinkHybMediaCBEvent LinkRtcInfoCB = null;
    public static final MultiLinkHybMediaCBEvent LinkRtcRtsRoomMessageCB = null;
    public static final MultiLinkHybMediaCBEvent LinkRtcRtsUserMessageCB = null;
    public static final MultiLinkHybMediaCBEvent LiveClientStreamErrorCB = null;
    public static final MultiLinkHybMediaCBEvent LiveClientStreamInfoCB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiLinkHybMediaCBEvent[] f254892a = null;
    private final String eventType;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.live.bizlink.impl.platform.dynamic.base.MultiLinkHybMediaCBEvent$a] */
    static {
        MultiLinkHybMediaCBEvent r100 = new MultiLinkHybMediaCBEvent("LiveClientStreamInfoCB", 0, "cb_event_live_client_stream_info");
        LiveClientStreamInfoCB = r100;
        MultiLinkHybMediaCBEvent r101 = new MultiLinkHybMediaCBEvent("LiveClientStreamErrorCB", 1, "cb_event_live_client_stream_error");
        LiveClientStreamErrorCB = r101;
        MultiLinkHybMediaCBEvent r102 = new MultiLinkHybMediaCBEvent("LinkRtcInfoCB", 2, "cb_event_link_rtc_info");
        LinkRtcInfoCB = r102;
        MultiLinkHybMediaCBEvent r103 = new MultiLinkHybMediaCBEvent("LinkRtcRtsRoomMessageCB", 3, "cb_event_rts_room_message");
        LinkRtcRtsRoomMessageCB = r103;
        MultiLinkHybMediaCBEvent r104 = new MultiLinkHybMediaCBEvent("LinkRtcRtsUserMessageCB", 4, "cb_event_rts_user_message");
        LinkRtcRtsUserMessageCB = r104;
        MultiLinkHybMediaCBEvent r105 = new MultiLinkHybMediaCBEvent("LinkRtcErrorCB", 5, "cb_event_link_rtc_error");
        LinkRtcErrorCB = r105;
        f254892a = new MultiLinkHybMediaCBEvent[]{r100, r101, r102, r103, r104, r105};
        Companion = new a();
    }

    public static MultiLinkHybMediaCBEvent valueOf(String r100) {
        return (MultiLinkHybMediaCBEvent) r27.a.a(MultiLinkHybMediaCBEvent.class, r100);
    }

    public static MultiLinkHybMediaCBEvent[] values() {
        return (MultiLinkHybMediaCBEvent[]) f254892a.clone();
    }

    public final String getEventType() {
        return this.eventType;
    }

    public MultiLinkHybMediaCBEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.eventType = r102;
    }
}
