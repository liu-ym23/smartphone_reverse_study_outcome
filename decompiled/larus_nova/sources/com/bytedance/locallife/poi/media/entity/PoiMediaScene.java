package com.bytedance.locallife.poi.media.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/poi/media/entity/PoiMediaScene;", "", "", "scene", "I", "getScene", "()I", "SCENE_REC_FOOD", "SCENIC_SPOT_FOOD", "SCENIC_BIG_PHOTO_LIST", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiMediaScene extends Enum<PoiMediaScene> {
    public static final PoiMediaScene SCENE_REC_FOOD = null;
    public static final PoiMediaScene SCENIC_BIG_PHOTO_LIST = null;
    public static final PoiMediaScene SCENIC_SPOT_FOOD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiMediaScene[] f262666a = null;
    private final int scene;

    public static PoiMediaScene valueOf(String r100) {
        return (PoiMediaScene) a.a(PoiMediaScene.class, r100);
    }

    public static PoiMediaScene[] values() {
        return (PoiMediaScene[]) f262666a.clone();
    }

    static {
        PoiMediaScene r100 = new PoiMediaScene("SCENE_REC_FOOD", 0, 1);
        SCENE_REC_FOOD = r100;
        PoiMediaScene r101 = new PoiMediaScene("SCENIC_SPOT_FOOD", 1, 2);
        SCENIC_SPOT_FOOD = r101;
        PoiMediaScene r102 = new PoiMediaScene("SCENIC_BIG_PHOTO_LIST", 2, 99999);
        SCENIC_BIG_PHOTO_LIST = r102;
        f262666a = new PoiMediaScene[]{r100, r101, r102};
    }

    public final int getScene() {
        return this.scene;
    }

    public PoiMediaScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
