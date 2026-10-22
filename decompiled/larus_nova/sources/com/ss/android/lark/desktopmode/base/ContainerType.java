package com.ss.android.lark.desktopmode.base;

import com.obric.miniapp.alarm.AccountType;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum ContainerType extends Enum<ContainerType> {
    public static final ContainerType ALL = null;
    public static final ContainerType Drawer = null;
    public static final ContainerType Float = null;
    public static final ContainerType Left = null;
    public static final ContainerType Right = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerType[] f420390a = null;

    static {
        ContainerType r100 = new ContainerType("Float", 0);
        Float = r100;
        ContainerType r101 = new ContainerType("Left", 1);
        Left = r101;
        ContainerType r102 = new ContainerType("Right", 2);
        Right = r102;
        ContainerType r103 = new ContainerType(AccountType.ALL, 3);
        ALL = r103;
        ContainerType r104 = new ContainerType("Drawer", 4);
        Drawer = r104;
        f420390a = new ContainerType[]{r100, r101, r102, r103, r104};
    }

    public static ContainerType[] values() {
        return (ContainerType[]) f420390a.clone();
    }

    public static ContainerType valueOf(String r100) {
        return (ContainerType) a.a(ContainerType.class, r100);
    }

    public ContainerType(String r100, int r101) {
        super(r100, r101);
    }
}
