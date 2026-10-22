package com.bytedance.ee.bear.sheet_core.inputbar.toolbar;

import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.sheet.inputbar.subpanel.OfficeSheetDateKeyboardFragment;
import com.bytedance.ee.bear.sheet.inputbar.subpanel.OfficeSheetNumKeyboardFragment;
import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum ToolbarItemEnum extends Enum<ToolbarItemEnum> {
    public static final Map<String, ToolbarItemEnum> a = null;
    public static final ToolbarItemEnum addReminder = null;
    public static final /* synthetic */ ToolbarItemEnum[] b = null;
    public static final ToolbarItemEnum checkbox = null;
    public static final ToolbarItemEnum date = null;
    public static final ToolbarItemEnum editRowInCard = null;
    public static final ToolbarItemEnum insertImage = null;
    public static final ToolbarItemEnum mention = null;
    public static final ToolbarItemEnum myAiDataInsight = null;
    public static final ToolbarItemEnum number = null;
    public static final ToolbarItemEnum text = null;
    public boolean adminLimit;
    public boolean alpha;
    public String fragment;
    public int iconRes;
    public boolean selectable;

    static {
        ToolbarItemEnum r6 = new ToolbarItemEnum("text", 0, 2131238068, true, null);
        text = r6;
        ToolbarItemEnum r0 = new ToolbarItemEnum(SheetInputData.InputData.FormatType.NUMBER, 1, 2131238067, true, OfficeSheetNumKeyboardFragment.class.getName());
        number = r0;
        ToolbarItemEnum r1 = new ToolbarItemEnum("editRowInCard", 2, 2131255668, false, null);
        editRowInCard = r1;
        ToolbarItemEnum r2 = new ToolbarItemEnum("date", 3, 2131253990, true, OfficeSheetDateKeyboardFragment.class.getName());
        date = r2;
        ToolbarItemEnum r3 = new ToolbarItemEnum("insertImage", 4, 2131254899, true, "insertImage");
        insertImage = r3;
        ToolbarItemEnum r4 = new ToolbarItemEnum("checkbox", 5, 2131256017, false, null);
        checkbox = r4;
        ToolbarItemEnum r5 = new ToolbarItemEnum("mention", 6, 2131253681, false, null);
        mention = r5;
        ToolbarItemEnum r13 = new ToolbarItemEnum("addReminder", 7, 2131253615, false, null);
        addReminder = r13;
        ToolbarItemEnum r7 = new ToolbarItemEnum("myAiDataInsight", 8, 2131255192, false, null);
        myAiDataInsight = r7;
        int r9 = 0;
        b = new ToolbarItemEnum[]{r6, r0, r1, r2, r3, r4, r5, r13, r7};
        a = new HashMap();
        ToolbarItemEnum[] r8 = values();
        int r10 = r8.length;
    L3:
        if (r9 >= r10) goto L5;
        ToolbarItemEnum r11 = r8[r9];
        a.put(r11.name(), r11);
        r9 = r9 + 1;
        goto L3
    }

    public static ToolbarItemEnum[] values() {
        return (ToolbarItemEnum[]) b.clone();
    }

    public static ToolbarItemEnum getToolbarItemEnumByName(String r1) {
        ToolbarItemEnum r2 = (ToolbarItemEnum) ((HashMap) a).get(r1);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return text;
    }

    public static ToolbarItemEnum valueOf(String r1) {
        return (ToolbarItemEnum) a.a(ToolbarItemEnum.class, r1);
    }

    public ToolbarItemEnum(String r1, int r2, int r3, boolean r4, String r5) {
        super(r1, r2);
        this.iconRes = r3;
        this.selectable = r4;
        this.fragment = r5;
    }
}
