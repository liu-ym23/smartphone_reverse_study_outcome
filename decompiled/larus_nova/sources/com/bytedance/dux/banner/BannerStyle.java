package com.bytedance.dux.banner;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/dux/banner/BannerStyle;", "", "", "style", "I", "getStyle", "()I", "FILL", "INDENT", "TRIPTYCH", "dux_release"}, k = 1, mv = {1, 7, 1})
public final enum BannerStyle extends Enum<BannerStyle> {
    public static final BannerStyle FILL = null;
    public static final BannerStyle INDENT = null;
    public static final BannerStyle TRIPTYCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BannerStyle[] f204850a = null;
    private final int style;

    public static BannerStyle valueOf(String r100) {
        return (BannerStyle) r27.a.a(BannerStyle.class, r100);
    }

    public static BannerStyle[] values() {
        return (BannerStyle[]) f204850a.clone();
    }

    static {
        BannerStyle r100 = new BannerStyle("FILL", 0, 0);
        FILL = r100;
        BannerStyle r101 = new BannerStyle("INDENT", 1, 1);
        INDENT = r101;
        BannerStyle r102 = new BannerStyle("TRIPTYCH", 2, 2);
        TRIPTYCH = r102;
        f204850a = new BannerStyle[]{r100, r101, r102};
    }

    public final int getStyle() {
        return this.style;
    }

    public BannerStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.style = r102;
    }
}
