package com.obric.oui.indicator;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/indicator/IndicatorDotVisualState;", "", "ACTIVE", EffectConstants.NORMAL, "EDGE", "HIDDEN", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum IndicatorDotVisualState extends Enum<IndicatorDotVisualState> {
    public static final IndicatorDotVisualState ACTIVE = null;
    public static final IndicatorDotVisualState EDGE = null;
    public static final IndicatorDotVisualState HIDDEN = null;
    public static final IndicatorDotVisualState NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IndicatorDotVisualState[] f401165a = null;

    public static IndicatorDotVisualState valueOf(String r100) {
        return (IndicatorDotVisualState) r27.a.a(IndicatorDotVisualState.class, r100);
    }

    public static IndicatorDotVisualState[] values() {
        return (IndicatorDotVisualState[]) f401165a.clone();
    }

    static {
        IndicatorDotVisualState r100 = new IndicatorDotVisualState("ACTIVE", 0);
        ACTIVE = r100;
        IndicatorDotVisualState r101 = new IndicatorDotVisualState(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        IndicatorDotVisualState r102 = new IndicatorDotVisualState("EDGE", 2);
        EDGE = r102;
        IndicatorDotVisualState r103 = new IndicatorDotVisualState("HIDDEN", 3);
        HIDDEN = r103;
        f401165a = new IndicatorDotVisualState[]{r100, r101, r102, r103};
    }

    public IndicatorDotVisualState(String r100, int r101) {
        super(r100, r101);
    }
}
