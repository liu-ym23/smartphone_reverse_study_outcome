package com.bytedance.locallife.poi.media.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/poi/media/entity/PoiPlayActionType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "AUTO_PLAY", "MANUAL_PLAY", "SLIDE", "UNKNOWN", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiPlayActionType extends Enum<PoiPlayActionType> {
    public static final PoiPlayActionType AUTO_PLAY = null;
    public static final PoiPlayActionType MANUAL_PLAY = null;
    public static final PoiPlayActionType SLIDE = null;
    public static final PoiPlayActionType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiPlayActionType[] f262668a = null;
    private final String type;

    public static PoiPlayActionType valueOf(String r100) {
        return (PoiPlayActionType) a.a(PoiPlayActionType.class, r100);
    }

    public static PoiPlayActionType[] values() {
        return (PoiPlayActionType[]) f262668a.clone();
    }

    static {
        PoiPlayActionType r100 = new PoiPlayActionType("AUTO_PLAY", 0, "auto_play");
        AUTO_PLAY = r100;
        PoiPlayActionType r101 = new PoiPlayActionType("MANUAL_PLAY", 1, "manual_play");
        MANUAL_PLAY = r101;
        PoiPlayActionType r102 = new PoiPlayActionType("SLIDE", 2, "slide");
        SLIDE = r102;
        PoiPlayActionType r103 = new PoiPlayActionType("UNKNOWN", 3, "unknown");
        UNKNOWN = r103;
        f262668a = new PoiPlayActionType[]{r100, r101, r102, r103};
    }

    public final String getType() {
        return this.type;
    }

    public PoiPlayActionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
