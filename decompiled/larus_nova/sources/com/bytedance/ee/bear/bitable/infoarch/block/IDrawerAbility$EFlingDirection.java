package com.bytedance.ee.bear.bitable.infoarch.block;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/block/IDrawerAbility$EFlingDirection;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "TOP", "DOWN", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IDrawerAbility$EFlingDirection extends Enum<IDrawerAbility$EFlingDirection> {
    public static final IDrawerAbility$EFlingDirection DOWN = null;
    public static final IDrawerAbility$EFlingDirection LEFT = null;
    public static final IDrawerAbility$EFlingDirection RIGHT = null;
    public static final IDrawerAbility$EFlingDirection TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IDrawerAbility$EFlingDirection[] f213193a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f213194b = null;

    public static EnumEntries<IDrawerAbility$EFlingDirection> getEntries() {
        return f213194b;
    }

    static {
        IDrawerAbility$EFlingDirection r100 = new IDrawerAbility$EFlingDirection("LEFT", 0);
        LEFT = r100;
        IDrawerAbility$EFlingDirection r101 = new IDrawerAbility$EFlingDirection("RIGHT", 1);
        RIGHT = r101;
        IDrawerAbility$EFlingDirection r102 = new IDrawerAbility$EFlingDirection("TOP", 2);
        TOP = r102;
        IDrawerAbility$EFlingDirection r103 = new IDrawerAbility$EFlingDirection("DOWN", 3);
        DOWN = r103;
        IDrawerAbility$EFlingDirection[] r104 = {r100, r101, r102, r103};
        f213193a = r104;
        f213194b = EnumEntriesKt.enumEntries(r104);
    }

    public static IDrawerAbility$EFlingDirection[] values() {
        return (IDrawerAbility$EFlingDirection[]) f213193a.clone();
    }

    public static IDrawerAbility$EFlingDirection valueOf(String r100) {
        return (IDrawerAbility$EFlingDirection) r27.a.a(IDrawerAbility$EFlingDirection.class, r100);
    }

    public IDrawerAbility$EFlingDirection(String r100, int r101) {
        super(r100, r101);
    }
}
