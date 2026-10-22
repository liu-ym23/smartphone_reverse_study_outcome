package com.bytedance.locallife.groupon.struct.innerpush;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/innerpush/TopBannerType;", "", "", "type", "I", "getType", "()I", "LIVE", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum TopBannerType extends Enum<TopBannerType> {
    public static final TopBannerType LIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TopBannerType[] f258843a = null;
    private final int type;

    public static TopBannerType valueOf(String r100) {
        return (TopBannerType) a.a(TopBannerType.class, r100);
    }

    public static TopBannerType[] values() {
        return (TopBannerType[]) f258843a.clone();
    }

    static {
        TopBannerType r100 = new TopBannerType();
        LIVE = r100;
        f258843a = new TopBannerType[]{r100};
    }

    public TopBannerType() {
        super("LIVE", 0);
        this.type = 1;
    }

    public final int getType() {
        return this.type;
    }
}
