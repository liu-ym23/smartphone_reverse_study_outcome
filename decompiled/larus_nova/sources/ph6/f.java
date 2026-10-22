package ph6;

import com.bytedance.live.bizlink.api.business.anchor2guest.base.BizLinkServiceType;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f529284a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f529285b = null;

    static {
        int[] r100 = new int[BizLinkServiceType.values().length];
        f529284a = r100;
        r100[BizLinkServiceType.VideoGuest.ordinal()] = 1;
        r100[BizLinkServiceType.VoiceGuest.ordinal()] = 2;
        r100[BizLinkServiceType.KtvGuest.ordinal()] = 3;
        r100[BizLinkServiceType.ChorusGuest.ordinal()] = 4;
        int[] r101 = new int[BizLinkServiceType.values().length];
        f529285b = r101;
        r101[BizLinkServiceType.VoiceAnchor.ordinal()] = 1;
        r101[BizLinkServiceType.VideoAnchor.ordinal()] = 2;
        r101[BizLinkServiceType.KtvAnchor.ordinal()] = 3;
        r101[BizLinkServiceType.ChorusAnchor.ordinal()] = 4;
    }
}
