package com.ss.android.lark.desktopmode.base;

/* JADX INFO: loaded from: classes35.dex */
public class LeftWindowParams extends MainWindowParams {
    public static final int TAB_LEFT_WIDTH_IN_DP = 300;
    private final int tabWidth;

    public static final class a extends MainWindowParams.a {
    }

    public int getTabWidth() {
        return this.tabWidth;
    }

    public LeftWindowParams(a r100) {
        super(r100);
        throw null;
    }

    public LeftWindowParams(ContainerType r100, String r101, int r102) {
        super(r100, r101);
        this.tabWidth = r102;
    }
}
