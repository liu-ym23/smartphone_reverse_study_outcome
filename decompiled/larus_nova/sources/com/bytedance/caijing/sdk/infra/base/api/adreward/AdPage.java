package com.bytedance.caijing.sdk.infra.base.api.adreward;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/adreward/AdPage;", "", "ONE_MORE_PAGE", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final enum AdPage extends Enum<AdPage> {
    public static final AdPage ONE_MORE_PAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AdPage[] f202205a = null;

    public static AdPage valueOf(String r100) {
        return (AdPage) a.a(AdPage.class, r100);
    }

    public static AdPage[] values() {
        return (AdPage[]) f202205a.clone();
    }

    static {
        AdPage r100 = new AdPage();
        ONE_MORE_PAGE = r100;
        f202205a = new AdPage[]{r100};
    }

    public AdPage() {
        super("ONE_MORE_PAGE", 0);
    }
}
