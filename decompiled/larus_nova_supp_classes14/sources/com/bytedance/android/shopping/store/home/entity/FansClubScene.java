package com.bytedance.android.shopping.store.home.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/FansClubScene;", "", "DEFAULT", "LIVE", "Shop", "Window", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FansClubScene extends Enum<FansClubScene> {
    public static final FansClubScene DEFAULT = null;
    public static final FansClubScene LIVE = null;
    public static final FansClubScene Shop = null;
    public static final FansClubScene Window = null;
    public static final /* synthetic */ FansClubScene[] a = null;

    static {
        FansClubScene r1 = new FansClubScene("DEFAULT", 0);
        DEFAULT = r1;
        FansClubScene r2 = new FansClubScene("LIVE", 1);
        LIVE = r2;
        FansClubScene r3 = new FansClubScene("Shop", 2);
        Shop = r3;
        FansClubScene r4 = new FansClubScene("Window", 3);
        Window = r4;
        a = new FansClubScene[]{r1, r2, r3, r4};
    }

    public static FansClubScene valueOf(String r1) {
        return (FansClubScene) r27.a.a(FansClubScene.class, r1);
    }

    public static FansClubScene[] values() {
        return (FansClubScene[]) a.clone();
    }

    public FansClubScene(String r1, int r2) {
        super(r1, r2);
    }
}
