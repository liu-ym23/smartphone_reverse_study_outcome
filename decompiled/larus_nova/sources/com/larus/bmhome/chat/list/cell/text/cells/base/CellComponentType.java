package com.larus.bmhome.chat.list.cell.text.cells.base;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/cells/base/CellComponentType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "DEEP_THINK_TOP_COMPONENT", "DEEP_THINK_REFERENCE_COMPONENT", "DEEP_THINK_CONTENT_COMPONENT", "TOP_CELL_COMPONENT", "MIDDLE_CELL_COMPONENT", "BOTTOM_CELL_COMPONENT", "COMPOSITE_CELL_COMPONENT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CellComponentType extends Enum<CellComponentType> {
    public static final CellComponentType BOTTOM_CELL_COMPONENT = null;
    public static final CellComponentType COMPOSITE_CELL_COMPONENT = null;
    public static final CellComponentType DEEP_THINK_CONTENT_COMPONENT = null;
    public static final CellComponentType DEEP_THINK_REFERENCE_COMPONENT = null;
    public static final CellComponentType DEEP_THINK_TOP_COMPONENT = null;
    public static final CellComponentType MIDDLE_CELL_COMPONENT = null;
    public static final CellComponentType TOP_CELL_COMPONENT = null;
    public static final CellComponentType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CellComponentType[] f306007a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f306008b = null;

    public static EnumEntries<CellComponentType> getEntries() {
        return f306008b;
    }

    static {
        CellComponentType r100 = new CellComponentType("UNKNOWN", 0);
        UNKNOWN = r100;
        CellComponentType r101 = new CellComponentType("DEEP_THINK_TOP_COMPONENT", 1);
        DEEP_THINK_TOP_COMPONENT = r101;
        CellComponentType r102 = new CellComponentType("DEEP_THINK_REFERENCE_COMPONENT", 2);
        DEEP_THINK_REFERENCE_COMPONENT = r102;
        CellComponentType r103 = new CellComponentType("DEEP_THINK_CONTENT_COMPONENT", 3);
        DEEP_THINK_CONTENT_COMPONENT = r103;
        CellComponentType r104 = new CellComponentType("TOP_CELL_COMPONENT", 4);
        TOP_CELL_COMPONENT = r104;
        CellComponentType r105 = new CellComponentType("MIDDLE_CELL_COMPONENT", 5);
        MIDDLE_CELL_COMPONENT = r105;
        CellComponentType r110 = new CellComponentType("BOTTOM_CELL_COMPONENT", 6);
        BOTTOM_CELL_COMPONENT = r110;
        CellComponentType r111 = new CellComponentType("COMPOSITE_CELL_COMPONENT", 7);
        COMPOSITE_CELL_COMPONENT = r111;
        CellComponentType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f306007a = r112;
        f306008b = EnumEntriesKt.enumEntries(r112);
    }

    public static CellComponentType[] values() {
        return (CellComponentType[]) f306007a.clone();
    }

    public static CellComponentType valueOf(String r100) {
        return (CellComponentType) r27.a.a(CellComponentType.class, r100);
    }

    public CellComponentType(String r100, int r101) {
        super(r100, r101);
    }
}
