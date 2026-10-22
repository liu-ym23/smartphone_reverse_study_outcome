package com.bytedance.live.bizlink.api.business.anchor2guest.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/live/bizlink/api/business/anchor2guest/base/BizLinkServiceType;", "", "VideoGuest", "VoiceGuest", "ChorusGuest", "KtvGuest", "VideoAnchor", "VoiceAnchor", "ChorusAnchor", "KtvAnchor", "multi-biz-link-kmp-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum BizLinkServiceType extends Enum<BizLinkServiceType> {
    public static final BizLinkServiceType ChorusAnchor = null;
    public static final BizLinkServiceType ChorusGuest = null;
    public static final BizLinkServiceType KtvAnchor = null;
    public static final BizLinkServiceType KtvGuest = null;
    public static final BizLinkServiceType VideoAnchor = null;
    public static final BizLinkServiceType VideoGuest = null;
    public static final BizLinkServiceType VoiceAnchor = null;
    public static final BizLinkServiceType VoiceGuest = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BizLinkServiceType[] f254858a = null;

    static {
        BizLinkServiceType r100 = new BizLinkServiceType("VideoGuest", 0);
        VideoGuest = r100;
        BizLinkServiceType r101 = new BizLinkServiceType("VoiceGuest", 1);
        VoiceGuest = r101;
        BizLinkServiceType r102 = new BizLinkServiceType("ChorusGuest", 2);
        ChorusGuest = r102;
        BizLinkServiceType r103 = new BizLinkServiceType("KtvGuest", 3);
        KtvGuest = r103;
        BizLinkServiceType r104 = new BizLinkServiceType("VideoAnchor", 4);
        VideoAnchor = r104;
        BizLinkServiceType r105 = new BizLinkServiceType("VoiceAnchor", 5);
        VoiceAnchor = r105;
        BizLinkServiceType r106 = new BizLinkServiceType("ChorusAnchor", 6);
        ChorusAnchor = r106;
        BizLinkServiceType r107 = new BizLinkServiceType("KtvAnchor", 7);
        KtvAnchor = r107;
        f254858a = new BizLinkServiceType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public static BizLinkServiceType valueOf(String r100) {
        return (BizLinkServiceType) a.a(BizLinkServiceType.class, r100);
    }

    public static BizLinkServiceType[] values() {
        return (BizLinkServiceType[]) f254858a.clone();
    }

    public BizLinkServiceType(String r100, int r101) {
        super(r100, r101);
    }
}
