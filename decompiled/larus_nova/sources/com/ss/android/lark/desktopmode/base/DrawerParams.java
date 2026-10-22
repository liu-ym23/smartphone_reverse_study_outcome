package com.ss.android.lark.desktopmode.base;

/* JADX INFO: loaded from: classes35.dex */
public class DrawerParams extends FragmentParams {
    private final boolean dimBehind;
    private final int drawerWidth;

    public static final class a extends FragmentParams.a<a, DrawerParams> {
    }

    public int getDrawerWidth() {
        return this.drawerWidth;
    }

    public boolean isDimBehind() {
        return this.dimBehind;
    }

    public DrawerParams(boolean r100) {
        super(ContainerType.Drawer, false);
        this.dimBehind = r100;
        this.drawerWidth = 320;
    }

    public DrawerParams(a r100) {
        ContainerType r101 = ContainerType.Float;
        throw null;
    }

    public DrawerParams(boolean r100, int r101) {
        super(ContainerType.Drawer, false);
        this.dimBehind = r100;
        this.drawerWidth = r101;
    }
}
