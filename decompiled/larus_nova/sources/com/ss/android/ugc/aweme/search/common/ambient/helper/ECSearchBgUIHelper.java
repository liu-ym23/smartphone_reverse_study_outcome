package com.ss.android.ugc.aweme.search.common.ambient.helper;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.lighten.core.ScaleType;
import com.ss.android.ugc.aweme.search.common.ab.ECSearchExperiment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ambient/helper/ECSearchBgUIHelper;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchBgUIHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchBgUIHelper f451445a = null;

    private ECSearchBgUIHelper() {
    }

    static {
        f451445a = new ECSearchBgUIHelper();
    }

    public static ScaleType b(Integer r100) {
        if (ECSearchExperiment.a() != 1) goto L5;
        ScaleType r101 = ScaleType.FIT_XY;
    L6:
        if (r100 != null) goto L9;
    L11:
        if (r100 != null) goto L14;
    L16:
        if (r100 != null) goto L19;
        return r101;
    L19:
        if (r100.intValue() == 2) goto L21;
        return r101;
    L21:
        return ScaleType.FIT_CENTER;
    L14:
        if (r100.intValue() != 1) goto L16;
        return ScaleType.FIT_END;
    L9:
        if (r100.intValue() != 0) goto L11;
        return r101;
    L5:
        r101 = ScaleType.FIT_START;
        goto L6
    }

    public static int c(String r100) {
        return Color.parseColor(r100);
    L4:
        return 0;
    }

    public static GradientDrawable a(Integer r100, int[] r101) {
        if (r100 != null) goto L6;
    L8:
        if (r100 != null) goto L11;
    L13:
        if (r100 != null) goto L16;
    L18:
        if (r100 != null) goto L21;
    L23:
        GradientDrawable.Orientation r102 = GradientDrawable.Orientation.TOP_BOTTOM;
    L25:
        return new GradientDrawable(r102, r101);
    L21:
        if (r100.intValue() != 3) goto L23;
        r102 = GradientDrawable.Orientation.TR_BL;
        goto L25
    L16:
        if (r100.intValue() != 2) goto L18;
        r102 = GradientDrawable.Orientation.TL_BR;
        goto L25
    L11:
        if (r100.intValue() != 1) goto L13;
    L12:
        r102 = GradientDrawable.Orientation.TOP_BOTTOM;
        goto L25
    L6:
        if (r100.intValue() != 0) goto L8;
        goto L8
    }
}
