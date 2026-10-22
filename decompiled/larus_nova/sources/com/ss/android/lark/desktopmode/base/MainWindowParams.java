package com.ss.android.lark.desktopmode.base;

/* JADX INFO: loaded from: classes35.dex */
public class MainWindowParams extends FragmentParams {
    private final String tabName;

    public static class a extends FragmentParams.a<a, MainWindowParams> {
    }

    public String getTabName() {
        return this.tabName;
    }

    public MainWindowParams(a r100) {
        throw null;
    }

    public MainWindowParams(ContainerType r100, String r101) {
        super(r100, false);
        this.tabName = r101;
    }
}
