package com.bytedance.android.window.shop.repository.vo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/repository/vo/WindowLabelType;", "", "PureText", "Hybrid", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowLabelType extends Enum<WindowLabelType> {
    public static final WindowLabelType Hybrid = null;
    public static final WindowLabelType PureText = null;
    public static final /* synthetic */ WindowLabelType[] a = null;

    static {
        WindowLabelType r1 = new WindowLabelType("PureText", 0);
        PureText = r1;
        WindowLabelType r2 = new WindowLabelType("Hybrid", 1);
        Hybrid = r2;
        a = new WindowLabelType[]{r1, r2};
    }

    public static WindowLabelType valueOf(String r1) {
        return (WindowLabelType) a.a(WindowLabelType.class, r1);
    }

    public static WindowLabelType[] values() {
        return (WindowLabelType[]) a.clone();
    }

    public WindowLabelType(String r1, int r2) {
        super(r1, r2);
    }
}
