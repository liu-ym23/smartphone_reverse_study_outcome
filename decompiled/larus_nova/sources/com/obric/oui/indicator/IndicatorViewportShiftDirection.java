package com.obric.oui.indicator;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/oui/indicator/IndicatorViewportShiftDirection;", "", "", "stepDistance", "resolveExitTranslation", "exitTranslationSign", FaceService.girlLabel, "FORWARD", "BACKWARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum IndicatorViewportShiftDirection extends Enum<IndicatorViewportShiftDirection> {
    public static final IndicatorViewportShiftDirection BACKWARD = null;
    public static final IndicatorViewportShiftDirection FORWARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IndicatorViewportShiftDirection[] f401176a = null;
    private final float exitTranslationSign;

    public static IndicatorViewportShiftDirection valueOf(String r100) {
        return (IndicatorViewportShiftDirection) r27.a.a(IndicatorViewportShiftDirection.class, r100);
    }

    public static IndicatorViewportShiftDirection[] values() {
        return (IndicatorViewportShiftDirection[]) f401176a.clone();
    }

    static {
        IndicatorViewportShiftDirection r100 = new IndicatorViewportShiftDirection("FORWARD", 0, -1.0f);
        FORWARD = r100;
        IndicatorViewportShiftDirection r101 = new IndicatorViewportShiftDirection("BACKWARD", 1, 1.0f);
        BACKWARD = r101;
        f401176a = new IndicatorViewportShiftDirection[]{r100, r101};
    }

    public final float resolveExitTranslation(float r100) {
        return this.exitTranslationSign * r100;
    }

    public IndicatorViewportShiftDirection(String r100, int r101, float r102) {
        super(r100, r101);
        this.exitTranslationSign = r102;
    }
}
