package com.bytedance.awemeopen.bizmodels.ad;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/ad/CsjAdScene;", "", "FIT_CONTAINER_FEED", "FIT_CONTAINER_FOLLOW", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final enum CsjAdScene extends Enum<CsjAdScene> {
    public static final CsjAdScene FIT_CONTAINER_FEED = null;
    public static final CsjAdScene FIT_CONTAINER_FOLLOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CsjAdScene[] f198168a = null;

    public static CsjAdScene valueOf(String r100) {
        return (CsjAdScene) a.a(CsjAdScene.class, r100);
    }

    public static CsjAdScene[] values() {
        return (CsjAdScene[]) f198168a.clone();
    }

    static {
        CsjAdScene r100 = new CsjAdScene("FIT_CONTAINER_FEED", 0);
        FIT_CONTAINER_FEED = r100;
        CsjAdScene r101 = new CsjAdScene("FIT_CONTAINER_FOLLOW", 1);
        FIT_CONTAINER_FOLLOW = r101;
        f198168a = new CsjAdScene[]{r100, r101};
    }

    public CsjAdScene(String r100, int r101) {
        super(r100, r101);
    }
}
