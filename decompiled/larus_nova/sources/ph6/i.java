package ph6;

import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;
import com.bytedance.live.bizlink.api.platformapi.host.PostEventType;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f529287a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f529288b = null;

    static {
        int[] r100 = new int[PostEventType.values().length];
        f529287a = r100;
        r100[PostEventType.LinkInRoomCloseEvent.ordinal()] = 1;
        r100[PostEventType.VoiceTalkRtcLinkSuccessEvent.ordinal()] = 2;
        r100[PostEventType.VoiceTalkRtcAdvanceLinkSuccessEvent.ordinal()] = 3;
        r100[PostEventType.VoiceTalkRtcLinkEndEvent.ordinal()] = 4;
        r100[PostEventType.VoiceTalkLiveClientInitSuccessEvent.ordinal()] = 5;
        r100[PostEventType.GiftMessageBoardInviteResultEventFalse.ordinal()] = 6;
        int[] r101 = new int[BizLinkServiceType.values().length];
        f529288b = r101;
        r101[BizLinkServiceType.VideoGuest.ordinal()] = 1;
        r101[BizLinkServiceType.VoiceGuest.ordinal()] = 2;
        r101[BizLinkServiceType.VideoAnchor.ordinal()] = 3;
        r101[BizLinkServiceType.VoiceAnchor.ordinal()] = 4;
    }
}
