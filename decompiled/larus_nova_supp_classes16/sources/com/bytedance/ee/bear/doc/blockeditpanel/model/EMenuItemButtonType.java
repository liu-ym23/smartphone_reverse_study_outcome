package com.bytedance.ee.bear.doc.blockeditpanel.model;

import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public static final Map<String, EMenuItemButtonType> a = null;
    public static final SparseArray<EMenuItemButtonType> b = null;
    public static final /* synthetic */ EMenuItemButtonType[] c = null;
    public String name;

    static {
        int r3 = 0;
        EMenuItemButtonType r0 = new EMenuItemButtonType("ICON_WITH_TEXT", 0, "iconWithText");
        ICON_WITH_TEXT = r0;
        EMenuItemButtonType r1 = new EMenuItemButtonType("COLORED_ICON_WITH_TEXT", 1, "coloredIconWithText");
        COLORED_ICON_WITH_TEXT = r1;
        EMenuItemButtonType r2 = new EMenuItemButtonType("ICON_ALONE", 2, "iconAlone");
        ICON_ALONE = r2;
        EMenuItemButtonType r4 = new EMenuItemButtonType("ICON_IN_GROUP", 3, "iconInGroup");
        ICON_IN_GROUP = r4;
        EMenuItemButtonType r6 = new EMenuItemButtonType("ICON_WITH_RIGHT_ARROW", 4, "iconWithRightArrow");
        ICON_WITH_RIGHT_ARROW = r6;
        EMenuItemButtonType r8 = new EMenuItemButtonType("ICON_WITH_DOWN_ARROW", 5, "iconWithDownArrow");
        ICON_WITH_DOWN_ARROW = r8;
        EMenuItemButtonType r10 = new EMenuItemButtonType("GROUP", 6, "group");
        GROUP = r10;
        EMenuItemButtonType r12 = new EMenuItemButtonType("SEPARATOR", 7, "separator");
        SEPARATOR = r12;
        EMenuItemButtonType r14 = new EMenuItemButtonType("SCROLLABLE_GROUP", 8, "scrollableGroup");
        SCROLLABLE_GROUP = r14;
        EMenuItemButtonType r13 = new EMenuItemButtonType("UNKNOWN", 9, "unknown");
        UNKNOWN = r13;
        EMenuItemButtonType r11 = new EMenuItemButtonType("HEADING_BUTTON_GROUP", 10, "headingButtonGroup");
        HEADING_BUTTON_GROUP = r11;
        EMenuItemButtonType r9 = new EMenuItemButtonType("COLOR_CLEAR_BACKGROUND", 11, "colorClearBackground");
        COLOR_CLEAR_BACKGROUND = r9;
        c = new EMenuItemButtonType[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9};
        a = new HashMap();
        b = new SparseArray();
        EMenuItemButtonType[] r5 = values();
        int r7 = r5.length;
    L3:
        if (r3 >= r7) goto L5;
        EMenuItemButtonType r16 = r5[r3];
        a.put(r16.name, r16);
        b.append(r16.ordinal(), r16);
        r3 = r3 + 1;
        goto L3
    }

    public static EMenuItemButtonType[] values() {
        return (EMenuItemButtonType[]) c.clone();
    }

    public static EMenuItemButtonType getEMenuItemButtonTypeByName(String r1) {
        EMenuItemButtonType r2 = (EMenuItemButtonType) ((HashMap) a).get(r1);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return UNKNOWN;
    }

    public static EMenuItemButtonType getEMenuItemButtonTypeByOrdinal(int r1) {
        EMenuItemButtonType r2 = b.get(r1);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return UNKNOWN;
    }

    public static EMenuItemButtonType valueOf(String r1) {
        return (EMenuItemButtonType) a.a(EMenuItemButtonType.class, r1);
    }

    public EMenuItemButtonType(String r1, int r2, String r3) {
        super(r1, r2);
        this.name = r3;
    }
}
