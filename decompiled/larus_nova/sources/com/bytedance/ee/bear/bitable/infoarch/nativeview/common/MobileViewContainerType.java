package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/MobileViewContainerType;", "", "<init>", "(Ljava/lang/String;I)V", "Modal", "Fullscreen", "Main", "LinkedCellTable", "LinkedFullTable", "LinkedSearchTable", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MobileViewContainerType extends Enum<MobileViewContainerType> {
    public static final MobileViewContainerType Fullscreen = null;
    public static final MobileViewContainerType LinkedCellTable = null;
    public static final MobileViewContainerType LinkedFullTable = null;
    public static final MobileViewContainerType LinkedSearchTable = null;
    public static final MobileViewContainerType Main = null;
    public static final MobileViewContainerType Modal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MobileViewContainerType[] f213297a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f213298b = null;

    public static EnumEntries<MobileViewContainerType> getEntries() {
        return f213298b;
    }

    static {
        MobileViewContainerType r100 = new MobileViewContainerType("Modal", 0);
        Modal = r100;
        MobileViewContainerType r101 = new MobileViewContainerType("Fullscreen", 1);
        Fullscreen = r101;
        MobileViewContainerType r102 = new MobileViewContainerType("Main", 2);
        Main = r102;
        MobileViewContainerType r103 = new MobileViewContainerType("LinkedCellTable", 3);
        LinkedCellTable = r103;
        MobileViewContainerType r104 = new MobileViewContainerType("LinkedFullTable", 4);
        LinkedFullTable = r104;
        MobileViewContainerType r105 = new MobileViewContainerType("LinkedSearchTable", 5);
        LinkedSearchTable = r105;
        MobileViewContainerType[] r110 = {r100, r101, r102, r103, r104, r105};
        f213297a = r110;
        f213298b = EnumEntriesKt.enumEntries(r110);
    }

    public static MobileViewContainerType[] values() {
        return (MobileViewContainerType[]) f213297a.clone();
    }

    public static MobileViewContainerType valueOf(String r100) {
        return (MobileViewContainerType) a.a(MobileViewContainerType.class, r100);
    }

    public MobileViewContainerType(String r100, int r101) {
        super(r100, r101);
    }
}
