package com.ss.android.ugc.aweme.search.ecommerce.api.srp;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/ecommerce/api/srp/ECSearchBizScene;", "", "HYBRID_SEARCH", "EC_SEARCH", "EC_AI_SEARCH", "EC_PHOTO_SEARCH", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ECSearchBizScene extends Enum<ECSearchBizScene> {
    public static final ECSearchBizScene EC_AI_SEARCH = null;
    public static final ECSearchBizScene EC_PHOTO_SEARCH = null;
    public static final ECSearchBizScene EC_SEARCH = null;
    public static final ECSearchBizScene HYBRID_SEARCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ECSearchBizScene[] f452772a = null;

    static {
        ECSearchBizScene r100 = new ECSearchBizScene("HYBRID_SEARCH", 0);
        HYBRID_SEARCH = r100;
        ECSearchBizScene r101 = new ECSearchBizScene("EC_SEARCH", 1);
        EC_SEARCH = r101;
        ECSearchBizScene r102 = new ECSearchBizScene("EC_AI_SEARCH", 2);
        EC_AI_SEARCH = r102;
        ECSearchBizScene r103 = new ECSearchBizScene("EC_PHOTO_SEARCH", 3);
        EC_PHOTO_SEARCH = r103;
        f452772a = new ECSearchBizScene[]{r100, r101, r102, r103};
    }

    public static ECSearchBizScene valueOf(String r100) {
        return (ECSearchBizScene) a.a(ECSearchBizScene.class, r100);
    }

    public static ECSearchBizScene[] values() {
        return (ECSearchBizScene[]) f452772a.clone();
    }

    public ECSearchBizScene(String r100, int r101) {
        super(r100, r101);
    }
}
