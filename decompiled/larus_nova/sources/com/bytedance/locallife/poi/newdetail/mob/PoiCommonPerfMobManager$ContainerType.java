package com.bytedance.locallife.poi.newdetail.mob;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"com/bytedance/locallife/poi/newdetail/mob/PoiCommonPerfMobManager$ContainerType", "", "Lcom/bytedance/locallife/poi/newdetail/mob/PoiCommonPerfMobManager$ContainerType;", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "LYNX", "NATIVE", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiCommonPerfMobManager$ContainerType extends Enum<PoiCommonPerfMobManager$ContainerType> {
    public static final PoiCommonPerfMobManager$ContainerType LYNX = null;
    public static final PoiCommonPerfMobManager$ContainerType NATIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiCommonPerfMobManager$ContainerType[] f263283a = null;
    private final String value;

    public static PoiCommonPerfMobManager$ContainerType valueOf(String r100) {
        return (PoiCommonPerfMobManager$ContainerType) r27.a.a(PoiCommonPerfMobManager$ContainerType.class, r100);
    }

    public static PoiCommonPerfMobManager$ContainerType[] values() {
        return (PoiCommonPerfMobManager$ContainerType[]) f263283a.clone();
    }

    static {
        PoiCommonPerfMobManager$ContainerType r100 = new PoiCommonPerfMobManager$ContainerType("LYNX", 0, "lynx");
        LYNX = r100;
        PoiCommonPerfMobManager$ContainerType r101 = new PoiCommonPerfMobManager$ContainerType("NATIVE", 1, "native");
        NATIVE = r101;
        f263283a = new PoiCommonPerfMobManager$ContainerType[]{r100, r101};
    }

    public final String getValue() {
        return this.value;
    }

    public PoiCommonPerfMobManager$ContainerType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
