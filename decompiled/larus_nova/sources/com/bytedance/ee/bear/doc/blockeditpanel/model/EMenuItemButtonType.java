package com.bytedance.ee.bear.doc.blockeditpanel.model;

import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum EMenuItemButtonType extends Enum<EMenuItemButtonType> {
    public static final EMenuItemButtonType COLORED_ICON_WITH_TEXT = null;
    public static final EMenuItemButtonType COLOR_CLEAR_BACKGROUND = null;
    public static final EMenuItemButtonType GROUP = null;
    public static final EMenuItemButtonType HEADING_BUTTON_GROUP = null;
    public static final EMenuItemButtonType ICON_ALONE = null;
    public static final EMenuItemButtonType ICON_IN_GROUP = null;
    public static final EMenuItemButtonType ICON_WITH_DOWN_ARROW = null;
    public static final EMenuItemButtonType ICON_WITH_RIGHT_ARROW = null;
    public static final EMenuItemButtonType ICON_WITH_TEXT = null;
    public static final EMenuItemButtonType SCROLLABLE_GROUP = null;
    public static final EMenuItemButtonType SEPARATOR = null;
    public static final EMenuItemButtonType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, EMenuItemButtonType> f217614a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArray<EMenuItemButtonType> f217615b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EMenuItemButtonType[] f217616c = null;
    public String name;

    static {
        int r100 = 0;
        EMenuItemButtonType r101 = new EMenuItemButtonType("ICON_WITH_TEXT", 0, "iconWithText");
        ICON_WITH_TEXT = r101;
        EMenuItemButtonType r102 = new EMenuItemButtonType("COLORED_ICON_WITH_TEXT", 1, "coloredIconWithText");
        COLORED_ICON_WITH_TEXT = r102;
        EMenuItemButtonType r103 = new EMenuItemButtonType("ICON_ALONE", 2, "iconAlone");
        ICON_ALONE = r103;
        EMenuItemButtonType r104 = new EMenuItemButtonType("ICON_IN_GROUP", 3, "iconInGroup");
        ICON_IN_GROUP = r104;
        EMenuItemButtonType r105 = new EMenuItemButtonType("ICON_WITH_RIGHT_ARROW", 4, "iconWithRightArrow");
        ICON_WITH_RIGHT_ARROW = r105;
        EMenuItemButtonType r106 = new EMenuItemButtonType("ICON_WITH_DOWN_ARROW", 5, "iconWithDownArrow");
        ICON_WITH_DOWN_ARROW = r106;
        EMenuItemButtonType r110 = new EMenuItemButtonType("GROUP", 6, "group");
        GROUP = r110;
        EMenuItemButtonType r111 = new EMenuItemButtonType("SEPARATOR", 7, "separator");
        SEPARATOR = r111;
        EMenuItemButtonType r112 = new EMenuItemButtonType("SCROLLABLE_GROUP", 8, "scrollableGroup");
        SCROLLABLE_GROUP = r112;
        EMenuItemButtonType r113 = new EMenuItemButtonType("UNKNOWN", 9, "unknown");
        UNKNOWN = r113;
        EMenuItemButtonType r114 = new EMenuItemButtonType("HEADING_BUTTON_GROUP", 10, "headingButtonGroup");
        HEADING_BUTTON_GROUP = r114;
        EMenuItemButtonType r107 = new EMenuItemButtonType("COLOR_CLEAR_BACKGROUND", 11, "colorClearBackground");
        COLOR_CLEAR_BACKGROUND = r107;
        f217616c = new EMenuItemButtonType[]{r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r107};
        f217614a = new HashMap();
        f217615b = new SparseArray();
        EMenuItemButtonType[] r108 = values();
        int r109 = r108.length;
    L3:
        if (r100 >= r109) goto L5;
        EMenuItemButtonType r115 = r108[r100];
        f217614a.put(r115.name, r115);
        f217615b.append(r115.ordinal(), r115);
        r100 = r100 + 1;
        goto L3
    }

    public static EMenuItemButtonType[] values() {
        return (EMenuItemButtonType[]) f217616c.clone();
    }

    public static EMenuItemButtonType getEMenuItemButtonTypeByName(String r100) {
        EMenuItemButtonType r101 = (EMenuItemButtonType) ((HashMap) f217614a).get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return UNKNOWN;
    }

    public static EMenuItemButtonType getEMenuItemButtonTypeByOrdinal(int r100) {
        EMenuItemButtonType r101 = f217615b.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return UNKNOWN;
    }

    public static EMenuItemButtonType valueOf(String r100) {
        return (EMenuItemButtonType) a.a(EMenuItemButtonType.class, r100);
    }

    public EMenuItemButtonType(String r100, int r101, String r102) {
        super(r100, r101);
        this.name = r102;
    }
}
