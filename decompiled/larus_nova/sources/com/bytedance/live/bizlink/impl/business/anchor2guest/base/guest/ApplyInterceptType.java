package com.bytedance.live.bizlink.impl.business.anchor2guest.base.guest;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/live/bizlink/impl/business/anchor2guest/base/guest/ApplyInterceptType;", "", "Follow", "TeamFight", "PaidLink", "ShowBeauty", "multi-biz-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ApplyInterceptType extends Enum<ApplyInterceptType> {
    public static final ApplyInterceptType Follow = null;
    public static final ApplyInterceptType PaidLink = null;
    public static final ApplyInterceptType ShowBeauty = null;
    public static final ApplyInterceptType TeamFight = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ApplyInterceptType[] f254867a = null;

    static {
        ApplyInterceptType r100 = new ApplyInterceptType("Follow", 0);
        Follow = r100;
        ApplyInterceptType r101 = new ApplyInterceptType("TeamFight", 1);
        TeamFight = r101;
        ApplyInterceptType r102 = new ApplyInterceptType("PaidLink", 2);
        PaidLink = r102;
        ApplyInterceptType r103 = new ApplyInterceptType("ShowBeauty", 3);
        ShowBeauty = r103;
        f254867a = new ApplyInterceptType[]{r100, r101, r102, r103};
    }

    public static ApplyInterceptType valueOf(String r100) {
        return (ApplyInterceptType) a.a(ApplyInterceptType.class, r100);
    }

    public static ApplyInterceptType[] values() {
        return (ApplyInterceptType[]) f254867a.clone();
    }

    public ApplyInterceptType(String r100, int r101) {
        super(r100, r101);
    }
}
