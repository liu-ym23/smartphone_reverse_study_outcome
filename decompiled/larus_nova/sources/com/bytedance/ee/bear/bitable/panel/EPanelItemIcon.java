package com.bytedance.ee.bear.bitable.panel;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final enum EPanelItemIcon extends Enum<EPanelItemIcon> {
    public static final EPanelItemIcon BITABLE_TABLE = null;
    public static final EPanelItemIcon CALENDAR = null;
    public static final EPanelItemIcon COPY = null;
    public static final EPanelItemIcon CREATE = null;
    public static final EPanelItemIcon DASHBOARD = null;
    public static final EPanelItemIcon DELETE = null;
    public static final EPanelItemIcon FORM = null;
    public static final EPanelItemIcon GALLEERY = null;
    public static final EPanelItemIcon GANTT = null;
    public static final EPanelItemIcon GRID = null;
    public static final EPanelItemIcon KANBAN = null;
    public static final EPanelItemIcon LINKED_DOC = null;
    public static final EPanelItemIcon RENAME = null;
    public static final EPanelItemIcon SELECT = null;
    public static final EPanelItemIcon SYNC = null;
    public static final EPanelItemIcon TASK = null;
    public static final EPanelItemIcon UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, EPanelItemIcon> f214826a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f214827b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EPanelItemIcon[] f214828c = null;
    public int activeImageRes;
    public int activeImageTintRes;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f214829id;
    public int inactiveImageRes;
    public int inactiveImageTintRes;

    public static int getActiveImageTintRes() {
        return R.color.primary_fill_default;
    }

    public static int getInactiveImageTintRes() {
        return R.color.icon_n1;
    }

    static {
        EPanelItemIcon r100 = new EPanelItemIcon("SELECT", 0, "select", R.drawable.icon_panel_checkbox_selected, R.color.primary_fill_default, R.drawable.icon_panel_checkbox_noselected, 0);
        SELECT = r100;
        EPanelItemIcon r101 = new EPanelItemIcon("GRID", 1, GXViewKey.VIEW_TYPE_CONTAINER_GRID, R.drawable.ud_icon_bitablegrid_outlined, R.color.primary_fill_default, R.drawable.ud_icon_bitablegrid_outlined, R.color.icon_n1);
        GRID = r101;
        EPanelItemIcon r102 = new EPanelItemIcon("KANBAN", 2, "kanban", R.drawable.ud_icon_bitablekanban_outlined, R.color.primary_fill_default, R.drawable.ud_icon_bitablekanban_outlined, R.color.icon_n1);
        KANBAN = r102;
        EPanelItemIcon r103 = new EPanelItemIcon("GALLEERY", 3, "gallery", R.drawable.ud_icon_bitablegallery_outlined, R.color.primary_fill_default, R.drawable.ud_icon_bitablegallery_outlined, R.color.icon_n1);
        GALLEERY = r103;
        EPanelItemIcon r104 = new EPanelItemIcon("GANTT", 4, "gantt", R.drawable.ud_icon_bitablegantt_outlined, R.color.primary_fill_default, R.drawable.ud_icon_bitablegantt_outlined, R.color.icon_n1);
        GANTT = r104;
        EPanelItemIcon r105 = new EPanelItemIcon("FORM", 5, "form", R.drawable.ud_icon_bitableform_outlined, R.color.primary_fill_default, R.drawable.ud_icon_bitableform_outlined, R.color.icon_n1);
        FORM = r105;
        EPanelItemIcon r106 = new EPanelItemIcon("TASK", 6, "task", R.drawable.ud_icon_bitable_taskview_outlined, R.color.primary_fill_default, R.drawable.ud_icon_bitable_taskview_outlined, R.color.icon_n1);
        TASK = r106;
        EPanelItemIcon r107 = new EPanelItemIcon("CALENDAR", 7, "calendar", R.drawable.ud_icon_calendar_line_outlined, R.color.primary_fill_default, R.drawable.ud_icon_calendar_line_outlined, R.color.icon_n1);
        CALENDAR = r107;
        EPanelItemIcon r108 = new EPanelItemIcon("COPY", 8, "copy", R.drawable.ud_icon_copy_outlined);
        COPY = r108;
        EPanelItemIcon r109 = new EPanelItemIcon("RENAME", 9, "rename", R.drawable.ud_icon_rename_outlined);
        RENAME = r109;
        EPanelItemIcon r110 = new EPanelItemIcon("DELETE", 10, "delete", R.drawable.ud_icon_delete_trash_outlined);
        DELETE = r110;
        EPanelItemIcon r111 = new EPanelItemIcon("CREATE", 11, "create", R.drawable.ud_icon_add_outlined, R.color.icon_n1, R.drawable.ud_icon_add_outlined, R.color.icon_n1);
        CREATE = r111;
        EPanelItemIcon r112 = new EPanelItemIcon(BridgeSyncType.SYNC, 12, DocumentType.DOCX_SYNC_BLOCK_NAME, R.drawable.ud_icon_buzz_outlined, R.color.icon_n1, R.drawable.ud_icon_buzz_outlined, R.color.icon_n1);
        SYNC = r112;
        EPanelItemIcon r113 = new EPanelItemIcon("LINKED_DOC", 13, "linked_doc", R.drawable.ud_icon_bitablegrid_outlined, R.color.primary_pri_500, R.drawable.ud_icon_bitablegrid_outlined, R.color.icon_disable);
        LINKED_DOC = r113;
        EPanelItemIcon r114 = new EPanelItemIcon("BITABLE_TABLE", 14, "BITABLE_TABLE", R.drawable.ud_icon_sheet_bitable_outlined, R.color.icon_n1, R.drawable.ud_icon_sheet_bitable_outlined, R.color.icon_n1);
        BITABLE_TABLE = r114;
        EPanelItemIcon r115 = new EPanelItemIcon("DASHBOARD", 15, "DASHBOARD", R.drawable.ud_icon_burnlife_notime_outlined, R.color.icon_n1, R.drawable.ud_icon_burnlife_notime_outlined, R.color.icon_n1);
        DASHBOARD = r115;
        EPanelItemIcon r116 = new EPanelItemIcon("UNKNOWN", 16, "unknown", R.drawable.ud_icon_bitableunknow_outlined, R.color.primary_fill_default, R.drawable.ud_icon_bitableunknow_outlined, R.color.icon_n1);
        UNKNOWN = r116;
        f214828c = new EPanelItemIcon[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116};
        f214826a = new HashMap();
        f214827b = new HashMap();
        EPanelItemIcon[] r117 = values();
        int r118 = r117.length;
        int r119 = 0;
    L3:
        if (r119 >= r118) goto L5;
        EPanelItemIcon r120 = r117[r119];
        ((HashMap) f214826a).put(r120.f214829id, r120);
        r119 = r119 + 1;
        goto L3
    }

    public static EPanelItemIcon[] values() {
        return (EPanelItemIcon[]) f214828c.clone();
    }

    public static EPanelItemIcon getEPanelItemIconById(String r100) {
        EPanelItemIcon r101 = (EPanelItemIcon) ((HashMap) f214826a).get(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return UNKNOWN;
    }

    public static String getUDResourceName(String r100) {
        return "ud_" + r100.replace('-', '_');
    }

    public static EPanelItemIcon valueOf(String r100) {
        return (EPanelItemIcon) r27.a.a(EPanelItemIcon.class, r100);
    }

    public static int getDrawableId(Context r100, String r101) {
        Map<String, Integer> r102 = f214827b;
        if (((HashMap) r102).containsKey(r101) == true) goto L5;
        int r103 = r100.getResources().getIdentifier(getUDResourceName(r101), "drawable", r100.getPackageName());
        if (r103 != 0) goto L9;
        return R.drawable.ud_icon_bitableunknow_outlined;
    L9:
        HashMap r104 = (HashMap) r102;
        r104.put(r101, Integer.valueOf(r103));
        return r103;
    L5:
        return ((Integer) ((HashMap) r102).get(r101)).intValue();
    }

    public static int getEPanelItemIconById(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(r102) == true) goto L7;
        return getDrawableId(r100, r102);
    L7:
        return getEPanelItemIconById(r101).activeImageRes;
    }

    public EPanelItemIcon(String r100, int r110, String r111, int r112) {
        this(r100, r110, r111, r112, R.color.icon_n1, r112, R.color.icon_n1);
    }

    public EPanelItemIcon(String r100, int r101, String r102, int r103, int r104, int r105, int r106) {
        super(r100, r101);
        this.f214829id = r102;
        this.activeImageRes = r103;
        this.activeImageTintRes = r104;
        this.inactiveImageRes = r105;
        this.inactiveImageTintRes = r106;
    }
}
