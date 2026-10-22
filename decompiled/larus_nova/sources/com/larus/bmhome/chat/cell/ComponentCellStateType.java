package com.larus.bmhome.chat.cell;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/cell/ComponentCellStateType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "NEW_TEXT_CELL", "TOP_TEXT_CELL", "MIDDLE_TEXT_CELL", "BOTTOM_TEXT_CELL", "DEEP_THINK_HEADER_TITLE_CELL", "DEEP_THINK_CONTENT_CELL", "DEEP_THINK_REFERENCE_CELL", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ComponentCellStateType extends Enum<ComponentCellStateType> {
    public static final ComponentCellStateType BOTTOM_TEXT_CELL = null;
    public static final ComponentCellStateType DEEP_THINK_CONTENT_CELL = null;
    public static final ComponentCellStateType DEEP_THINK_HEADER_TITLE_CELL = null;
    public static final ComponentCellStateType DEEP_THINK_REFERENCE_CELL = null;
    public static final ComponentCellStateType DEFAULT = null;
    public static final ComponentCellStateType MIDDLE_TEXT_CELL = null;
    public static final ComponentCellStateType NEW_TEXT_CELL = null;
    public static final ComponentCellStateType TOP_TEXT_CELL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComponentCellStateType[] f297619a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297620b = null;

    public static EnumEntries<ComponentCellStateType> getEntries() {
        return f297620b;
    }

    static {
        ComponentCellStateType r100 = new ComponentCellStateType("DEFAULT", 0);
        DEFAULT = r100;
        ComponentCellStateType r101 = new ComponentCellStateType("NEW_TEXT_CELL", 1);
        NEW_TEXT_CELL = r101;
        ComponentCellStateType r102 = new ComponentCellStateType("TOP_TEXT_CELL", 2);
        TOP_TEXT_CELL = r102;
        ComponentCellStateType r103 = new ComponentCellStateType("MIDDLE_TEXT_CELL", 3);
        MIDDLE_TEXT_CELL = r103;
        ComponentCellStateType r104 = new ComponentCellStateType("BOTTOM_TEXT_CELL", 4);
        BOTTOM_TEXT_CELL = r104;
        ComponentCellStateType r105 = new ComponentCellStateType("DEEP_THINK_HEADER_TITLE_CELL", 5);
        DEEP_THINK_HEADER_TITLE_CELL = r105;
        ComponentCellStateType r110 = new ComponentCellStateType("DEEP_THINK_CONTENT_CELL", 6);
        DEEP_THINK_CONTENT_CELL = r110;
        ComponentCellStateType r111 = new ComponentCellStateType("DEEP_THINK_REFERENCE_CELL", 7);
        DEEP_THINK_REFERENCE_CELL = r111;
        ComponentCellStateType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f297619a = r112;
        f297620b = EnumEntriesKt.enumEntries(r112);
    }

    public static ComponentCellStateType[] values() {
        return (ComponentCellStateType[]) f297619a.clone();
    }

    public static ComponentCellStateType valueOf(String r100) {
        return (ComponentCellStateType) a.a(ComponentCellStateType.class, r100);
    }

    public ComponentCellStateType(String r100, int r101) {
        super(r100, r101);
    }
}
