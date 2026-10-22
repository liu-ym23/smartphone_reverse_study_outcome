package com.bytedance.android.window.shop.widget.topbar;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/widget/topbar/MinMode;", "", "ICON", "TEXT", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MinMode extends Enum<MinMode> {
    public static final MinMode ICON = null;
    public static final MinMode TEXT = null;
    public static final /* synthetic */ MinMode[] a = null;

    static {
        MinMode r1 = new MinMode("ICON", 0);
        ICON = r1;
        MinMode r2 = new MinMode("TEXT", 1);
        TEXT = r2;
        a = new MinMode[]{r1, r2};
    }

    public static MinMode valueOf(String r1) {
        return (MinMode) a.a(MinMode.class, r1);
    }

    public static MinMode[] values() {
        return (MinMode[]) a.clone();
    }

    public MinMode(String r1, int r2) {
        super(r1, r2);
    }
}
