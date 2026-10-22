package com.bytedance.live.bizlink.api.platformapi.host;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/live/bizlink/api/platformapi/host/PostEventType;", "", "LinkInRoomCloseEvent", "VoiceTalkRtcLinkSuccessEvent", "VoiceTalkRtcAdvanceLinkSuccessEvent", "VoiceTalkRtcLinkEndEvent", "VoiceTalkLiveClientInitSuccessEvent", "GiftMessageBoardInviteResultEventFalse", "multi-biz-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PostEventType extends Enum<PostEventType> {
    public static final PostEventType GiftMessageBoardInviteResultEventFalse = null;
    public static final PostEventType LinkInRoomCloseEvent = null;
    public static final PostEventType VoiceTalkLiveClientInitSuccessEvent = null;
    public static final PostEventType VoiceTalkRtcAdvanceLinkSuccessEvent = null;
    public static final PostEventType VoiceTalkRtcLinkEndEvent = null;
    public static final PostEventType VoiceTalkRtcLinkSuccessEvent = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PostEventType[] f254866a = null;

    static {
        PostEventType r100 = new PostEventType("LinkInRoomCloseEvent", 0);
        LinkInRoomCloseEvent = r100;
        PostEventType r101 = new PostEventType("VoiceTalkRtcLinkSuccessEvent", 1);
        VoiceTalkRtcLinkSuccessEvent = r101;
        PostEventType r102 = new PostEventType("VoiceTalkRtcAdvanceLinkSuccessEvent", 2);
        VoiceTalkRtcAdvanceLinkSuccessEvent = r102;
        PostEventType r103 = new PostEventType("VoiceTalkRtcLinkEndEvent", 3);
        VoiceTalkRtcLinkEndEvent = r103;
        PostEventType r104 = new PostEventType("VoiceTalkLiveClientInitSuccessEvent", 4);
        VoiceTalkLiveClientInitSuccessEvent = r104;
        PostEventType r105 = new PostEventType("GiftMessageBoardInviteResultEventFalse", 5);
        GiftMessageBoardInviteResultEventFalse = r105;
        f254866a = new PostEventType[]{r100, r101, r102, r103, r104, r105};
    }

    public static PostEventType valueOf(String r100) {
        return (PostEventType) a.a(PostEventType.class, r100);
    }

    public static PostEventType[] values() {
        return (PostEventType[]) f254866a.clone();
    }

    public PostEventType(String r100, int r101) {
        super(r100, r101);
    }
}
