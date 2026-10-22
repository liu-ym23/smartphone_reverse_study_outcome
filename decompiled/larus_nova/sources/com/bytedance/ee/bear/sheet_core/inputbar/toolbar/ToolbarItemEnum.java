package com.bytedance.ee.bear.sheet_core.inputbar.toolbar;

import com.bytedance.ee.bear.sheet.inputbar.subpanel.OfficeSheetDateKeyboardFragment;
import com.bytedance.ee.bear.sheet.inputbar.subpanel.OfficeSheetNumKeyboardFragment;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
public final enum ToolbarItemEnum extends Enum<ToolbarItemEnum> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, ToolbarItemEnum> f238507a = null;
    public static final ToolbarItemEnum addReminder = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ToolbarItemEnum[] f238508b = null;
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
        ToolbarItemEnum r100 = new ToolbarItemEnum("text", 0, R.drawable.icon_sheettoolbar_text_nor, true, null);
        text = r100;
        ToolbarItemEnum r101 = new ToolbarItemEnum("number", 1, R.drawable.icon_sheettoolbar_number_nor, true, OfficeSheetNumKeyboardFragment.class.getName());
        number = r101;
        ToolbarItemEnum r102 = new ToolbarItemEnum("editRowInCard", 2, R.drawable.ud_icon_sheet_cardmodel_outlined, false, null);
        editRowInCard = r102;
        ToolbarItemEnum r103 = new ToolbarItemEnum("date", 3, R.drawable.ud_icon_calendar_outlined, true, OfficeSheetDateKeyboardFragment.class.getName());
        date = r103;
        ToolbarItemEnum r104 = new ToolbarItemEnum("insertImage", 4, R.drawable.ud_icon_image_outlined, true, "insertImage");
        insertImage = r104;
        ToolbarItemEnum r105 = new ToolbarItemEnum("checkbox", 5, R.drawable.ud_icon_todo_outlined, false, null);
        checkbox = r105;
        ToolbarItemEnum r106 = new ToolbarItemEnum("mention", 6, R.drawable.ud_icon_at_outlined, false, null);
        mention = r106;
        ToolbarItemEnum r110 = new ToolbarItemEnum("addReminder", 7, R.drawable.ud_icon_alarm_clock_outlined, false, null);
        addReminder = r110;
        ToolbarItemEnum r107 = new ToolbarItemEnum("myAiDataInsight", 8, R.drawable.ud_icon_myai_colorful, false, null);
        myAiDataInsight = r107;
        int r108 = 0;
        f238508b = new ToolbarItemEnum[]{r100, r101, r102, r103, r104, r105, r106, r110, r107};
        f238507a = new HashMap();
        ToolbarItemEnum[] r109 = values();
        int r111 = r109.length;
    L3:
        if (r108 >= r111) goto L5;
        ToolbarItemEnum r112 = r109[r108];
        f238507a.put(r112.name(), r112);
        r108 = r108 + 1;
        goto L3
    }

    public static ToolbarItemEnum[] values() {
        return (ToolbarItemEnum[]) f238508b.clone();
    }

    public static ToolbarItemEnum getToolbarItemEnumByName(String r100) {
        ToolbarItemEnum r101 = (ToolbarItemEnum) ((HashMap) f238507a).get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return text;
    }

    public static ToolbarItemEnum valueOf(String r100) {
        return (ToolbarItemEnum) a.a(ToolbarItemEnum.class, r100);
    }

    public ToolbarItemEnum(String r100, int r101, int r102, boolean r103, String r104) {
        super(r100, r101);
        this.iconRes = r102;
        this.selectable = r103;
        this.fragment = r104;
    }
}
