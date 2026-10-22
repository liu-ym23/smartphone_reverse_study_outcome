package com.bytedance.locallife.poi.newdetail.mob;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/bytedance/locallife/poi/newdetail/mob/PoiCommonPerfMobManager$Type", "", "Lcom/bytedance/locallife/poi/newdetail/mob/PoiCommonPerfMobManager$Type;", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "MODEL", "DELEGATE", "RENDER", "ERROR", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiCommonPerfMobManager$Type extends Enum<PoiCommonPerfMobManager$Type> {
    public static final PoiCommonPerfMobManager$Type DELEGATE = null;
    public static final PoiCommonPerfMobManager$Type ERROR = null;
    public static final PoiCommonPerfMobManager$Type MODEL = null;
    public static final PoiCommonPerfMobManager$Type RENDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiCommonPerfMobManager$Type[] f263284a = null;
    private final String value;

    public static PoiCommonPerfMobManager$Type valueOf(String r100) {
        return (PoiCommonPerfMobManager$Type) r27.a.a(PoiCommonPerfMobManager$Type.class, r100);
    }

    public static PoiCommonPerfMobManager$Type[] values() {
        return (PoiCommonPerfMobManager$Type[]) f263284a.clone();
    }

    static {
        PoiCommonPerfMobManager$Type r100 = new PoiCommonPerfMobManager$Type("MODEL", 0, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        MODEL = r100;
        PoiCommonPerfMobManager$Type r101 = new PoiCommonPerfMobManager$Type("DELEGATE", 1, "delegate");
        DELEGATE = r101;
        PoiCommonPerfMobManager$Type r102 = new PoiCommonPerfMobManager$Type("RENDER", 2, ChameleonOpenTracker.Stage.RENDER);
        RENDER = r102;
        PoiCommonPerfMobManager$Type r103 = new PoiCommonPerfMobManager$Type("ERROR", 3, "error");
        ERROR = r103;
        f263284a = new PoiCommonPerfMobManager$Type[]{r100, r101, r102, r103};
    }

    public final String getValue() {
        return this.value;
    }

    public PoiCommonPerfMobManager$Type(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
