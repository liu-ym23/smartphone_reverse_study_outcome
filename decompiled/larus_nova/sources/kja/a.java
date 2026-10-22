package kja;

import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f503728a = null;

    static {
        int[] r100 = new int[SmoothCornerHelper.Companion.CurveType.values().length];
        f503728a = r100;
        r100[SmoothCornerHelper.Companion.CurveType.BASIC.ordinal()] = 1;
        r100[SmoothCornerHelper.Companion.CurveType.QUADRATIC.ordinal()] = 2;
        r100[SmoothCornerHelper.Companion.CurveType.SKETCH.ordinal()] = 3;
        r100[SmoothCornerHelper.Companion.CurveType.FIGMA.ordinal()] = 4;
        r100[SmoothCornerHelper.Companion.CurveType.QUADRATIC_CAPSULE.ordinal()] = 5;
    }
}
