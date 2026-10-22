package com.larus.canvas.feature.component.logic.provider;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/canvas/feature/component/logic/provider/CanvasGallerySidebarItemType;", "", "<init>", "(Ljava/lang/String;I)V", "SHARE", "TO_VIDEO", "EDIT", "SHAREPNESS", "EXPAND", "ERASE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CanvasGallerySidebarItemType extends Enum<CanvasGallerySidebarItemType> {
    public static final CanvasGallerySidebarItemType EDIT = null;
    public static final CanvasGallerySidebarItemType ERASE = null;
    public static final CanvasGallerySidebarItemType EXPAND = null;
    public static final CanvasGallerySidebarItemType SHARE = null;
    public static final CanvasGallerySidebarItemType SHAREPNESS = null;
    public static final CanvasGallerySidebarItemType TO_VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CanvasGallerySidebarItemType[] f323422a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f323423b = null;

    public static EnumEntries<CanvasGallerySidebarItemType> getEntries() {
        return f323423b;
    }

    static {
        CanvasGallerySidebarItemType r100 = new CanvasGallerySidebarItemType("SHARE", 0);
        SHARE = r100;
        CanvasGallerySidebarItemType r101 = new CanvasGallerySidebarItemType("TO_VIDEO", 1);
        TO_VIDEO = r101;
        CanvasGallerySidebarItemType r102 = new CanvasGallerySidebarItemType("EDIT", 2);
        EDIT = r102;
        CanvasGallerySidebarItemType r103 = new CanvasGallerySidebarItemType("SHAREPNESS", 3);
        SHAREPNESS = r103;
        CanvasGallerySidebarItemType r104 = new CanvasGallerySidebarItemType("EXPAND", 4);
        EXPAND = r104;
        CanvasGallerySidebarItemType r105 = new CanvasGallerySidebarItemType("ERASE", 5);
        ERASE = r105;
        CanvasGallerySidebarItemType[] r110 = {r100, r101, r102, r103, r104, r105};
        f323422a = r110;
        f323423b = EnumEntriesKt.enumEntries(r110);
    }

    public static CanvasGallerySidebarItemType[] values() {
        return (CanvasGallerySidebarItemType[]) f323422a.clone();
    }

    public static CanvasGallerySidebarItemType valueOf(String r100) {
        return (CanvasGallerySidebarItemType) r27.a.a(CanvasGallerySidebarItemType.class, r100);
    }

    public CanvasGallerySidebarItemType(String r100, int r101) {
        super(r100, r101);
    }
}
