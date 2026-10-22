package com.bytedance.locallife.groupon.struct.refresh;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/refresh/RefreshScene;", "", "NOW", "DIAMOND_VISIBLE", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum RefreshScene extends Enum<RefreshScene> {
    public static final RefreshScene DIAMOND_VISIBLE = null;
    public static final RefreshScene NOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RefreshScene[] f258849a = null;

    public static RefreshScene valueOf(String r100) {
        return (RefreshScene) a.a(RefreshScene.class, r100);
    }

    public static RefreshScene[] values() {
        return (RefreshScene[]) f258849a.clone();
    }

    static {
        RefreshScene r100 = new RefreshScene("NOW", 0);
        NOW = r100;
        RefreshScene r101 = new RefreshScene("DIAMOND_VISIBLE", 1);
        DIAMOND_VISIBLE = r101;
        f258849a = new RefreshScene[]{r100, r101};
    }

    public RefreshScene(String r100, int r101) {
        super(r100, r101);
    }
}
