package com.bytedance.locallife.groupon;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"com/bytedance/locallife/groupon/NearbyConstants$SnackBar$TriggerScene", "", "Lcom/bytedance/locallife/groupon/NearbyConstants$SnackBar$TriggerScene;", "", "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "", "priority", "I", "getPriority", "()I", "MAKE_DEAL", "COLLECT_ITEM", "COLLECT_POI", "CLICK_POI", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum NearbyConstants$SnackBar$TriggerScene extends Enum<NearbyConstants$SnackBar$TriggerScene> {
    public static final NearbyConstants$SnackBar$TriggerScene CLICK_POI = null;
    public static final NearbyConstants$SnackBar$TriggerScene COLLECT_ITEM = null;
    public static final NearbyConstants$SnackBar$TriggerScene COLLECT_POI = null;
    public static final NearbyConstants$SnackBar$TriggerScene MAKE_DEAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NearbyConstants$SnackBar$TriggerScene[] f258782a = null;
    private final int priority;
    private final String scene;

    public static NearbyConstants$SnackBar$TriggerScene valueOf(String r100) {
        return (NearbyConstants$SnackBar$TriggerScene) a.a(NearbyConstants$SnackBar$TriggerScene.class, r100);
    }

    public static NearbyConstants$SnackBar$TriggerScene[] values() {
        return (NearbyConstants$SnackBar$TriggerScene[]) f258782a.clone();
    }

    static {
        NearbyConstants$SnackBar$TriggerScene r100 = new NearbyConstants$SnackBar$TriggerScene("MAKE_DEAL", 0, "order", 4);
        MAKE_DEAL = r100;
        NearbyConstants$SnackBar$TriggerScene r101 = new NearbyConstants$SnackBar$TriggerScene("COLLECT_ITEM", 1, "collect_product", 3);
        COLLECT_ITEM = r101;
        NearbyConstants$SnackBar$TriggerScene r102 = new NearbyConstants$SnackBar$TriggerScene("COLLECT_POI", 2, "collect_poi", 2);
        COLLECT_POI = r102;
        NearbyConstants$SnackBar$TriggerScene r103 = new NearbyConstants$SnackBar$TriggerScene("CLICK_POI", 3, "click_poi", 1);
        CLICK_POI = r103;
        f258782a = new NearbyConstants$SnackBar$TriggerScene[]{r100, r101, r102, r103};
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getScene() {
        return this.scene;
    }

    public NearbyConstants$SnackBar$TriggerScene(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.scene = r102;
        this.priority = r103;
    }
}
