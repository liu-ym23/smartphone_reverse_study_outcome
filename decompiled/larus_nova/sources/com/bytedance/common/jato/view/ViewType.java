package com.bytedance.common.jato.view;

import androidx.core.app.NotificationCompat;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum ViewType extends Enum<ViewType> {
    private static final /* synthetic */ ViewType[] $VALUES = null;
    public static final ViewType create = null;
    public static final ViewType set = null;
    public static final ViewType stub = null;
    public static final ViewType sys = null;

    /* JADX INFO: renamed from: x2c, reason: collision with root package name */
    public static final ViewType f202963x2c = null;

    static {
        ViewType r100 = new ViewType("x2c", 0);
        f202963x2c = r100;
        ViewType r101 = new ViewType(NotificationCompat.CATEGORY_SYSTEM, 1);
        sys = r101;
        ViewType r102 = new ViewType("stub", 2);
        stub = r102;
        ViewType r103 = new ViewType("set", 3);
        set = r103;
        ViewType r104 = new ViewType("create", 4);
        create = r104;
        $VALUES = new ViewType[]{r100, r101, r102, r103, r104};
    }

    public static ViewType[] values() {
        return (ViewType[]) $VALUES.clone();
    }

    public static ViewType valueOf(String r100) {
        return (ViewType) a.a(ViewType.class, r100);
    }

    private ViewType(String r100, int r101) {
        super(r100, r101);
    }
}
