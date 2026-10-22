package com.bytedance.android.window.shop.utils;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/android/window/shop/utils/LazySpecifiedScaleType$ScaleType", "", "Lcom/bytedance/android/window/shop/utils/LazySpecifiedScaleType$ScaleType;", "FIT_XY", "CENTER_CROP", "FIT_TOP", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LazySpecifiedScaleType$ScaleType extends Enum<LazySpecifiedScaleType$ScaleType> {
    public static final LazySpecifiedScaleType$ScaleType CENTER_CROP = null;
    public static final LazySpecifiedScaleType$ScaleType FIT_TOP = null;
    public static final LazySpecifiedScaleType$ScaleType FIT_XY = null;
    public static final /* synthetic */ LazySpecifiedScaleType$ScaleType[] a = null;

    static {
        LazySpecifiedScaleType$ScaleType r1 = new LazySpecifiedScaleType$ScaleType("FIT_XY", 0);
        FIT_XY = r1;
        LazySpecifiedScaleType$ScaleType r2 = new LazySpecifiedScaleType$ScaleType("CENTER_CROP", 1);
        CENTER_CROP = r2;
        LazySpecifiedScaleType$ScaleType r3 = new LazySpecifiedScaleType$ScaleType("FIT_TOP", 2);
        FIT_TOP = r3;
        a = new LazySpecifiedScaleType$ScaleType[]{r1, r2, r3};
    }

    public static LazySpecifiedScaleType$ScaleType valueOf(String r1) {
        return (LazySpecifiedScaleType$ScaleType) a.a(LazySpecifiedScaleType$ScaleType.class, r1);
    }

    public static LazySpecifiedScaleType$ScaleType[] values() {
        return (LazySpecifiedScaleType$ScaleType[]) a.clone();
    }

    public LazySpecifiedScaleType$ScaleType(String r1, int r2) {
        super(r1, r2);
    }
}
