package sg6;

import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f541836a = null;

    static {
        int[] r100 = new int[BizLinkServiceType.values().length];
        f541836a = r100;
        r100[BizLinkServiceType.VideoGuest.ordinal()] = 1;
        r100[BizLinkServiceType.VoiceGuest.ordinal()] = 2;
        r100[BizLinkServiceType.ChorusGuest.ordinal()] = 3;
        r100[BizLinkServiceType.KtvGuest.ordinal()] = 4;
        r100[BizLinkServiceType.VideoAnchor.ordinal()] = 5;
        r100[BizLinkServiceType.VoiceAnchor.ordinal()] = 6;
        r100[BizLinkServiceType.ChorusAnchor.ordinal()] = 7;
        r100[BizLinkServiceType.KtvAnchor.ordinal()] = 8;
    }
}
