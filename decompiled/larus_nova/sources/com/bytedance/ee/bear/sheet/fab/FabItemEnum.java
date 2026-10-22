package com.bytedance.ee.bear.sheet.fab;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final enum FabItemEnum extends Enum<FabItemEnum> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FabItemEnum[] f237612a = null;
    public static final FabItemEnum bitableGrid = null;
    public static final FabItemEnum bitableKanban = null;
    public static final FabItemEnum cardMode = null;
    public static final FabItemEnum createRecord = null;
    public static final FabItemEnum input = null;
    public static final FabItemEnum kanbanZoomIn = null;
    public static final FabItemEnum kanbanZoomOut = null;
    public static final FabItemEnum operation = null;
    public static final FabItemEnum search = null;
    public static final FabItemEnum shareDashboard = null;
    public static final FabItemEnum shareForm = null;
    public int colorRes;
    public int imageRes;
    public int imageTintColorRes;
    public int type;

    public FabItemEnum() {
        throw null;
    }

    static {
        FabItemEnum r100 = new FabItemEnum("input", 0, 0, R.drawable.ud_icon_keyboard_outlined, R.color.bg_float, R.color.fab_item_keyboard_primary);
        input = r100;
        FabItemEnum r101 = new FabItemEnum("cardMode", 1, 0, R.drawable.ud_icon_sheet_cardmodel_outlined, R.color.bg_float, R.color.primary_fill_default);
        cardMode = r101;
        FabItemEnum r102 = new FabItemEnum(WikiFolderPushPlugin.OPT, 2, 2, R.drawable.ud_icon_toolbar_more_outlined, R.color.fab_item_operate_primary, R.color.static_white);
        operation = r102;
        FabItemEnum r103 = new FabItemEnum("search", 3, 0, R.drawable.ud_icon_find_and_replace_outlined, R.color.bg_float, R.color.primary_fill_default);
        search = r103;
        FabItemEnum r104 = new FabItemEnum("bitableGrid", 4, 0, R.drawable.ud_icon_bitablegrid_outlined, R.color.bg_float, R.color.primary_fill_default);
        bitableGrid = r104;
        FabItemEnum r105 = new FabItemEnum("bitableKanban", 5, 0, R.drawable.ud_icon_bitablekanban_outlined, R.color.bg_float, R.color.primary_fill_default);
        bitableKanban = r105;
        FabItemEnum r110 = new FabItemEnum("kanbanZoomIn", 6, 0, R.drawable.ud_icon_zoom_in_outlined, R.color.bg_float, R.color.primary_fill_default);
        kanbanZoomIn = r110;
        FabItemEnum r111 = new FabItemEnum("kanbanZoomOut", 7, 0, R.drawable.ud_icon_zoom_out_outlined, R.color.bg_float, R.color.primary_fill_default);
        kanbanZoomOut = r111;
        FabItemEnum r106 = new FabItemEnum("createRecord", 8, 0, R.drawable.ud_icon_add_outlined, R.color.lkui_B500, R.color.static_white);
        createRecord = r106;
        FabItemEnum r107 = new FabItemEnum("shareForm", 9);
        shareForm = r107;
        FabItemEnum r108 = new FabItemEnum("shareDashboard", 10);
        shareDashboard = r108;
        f237612a = new FabItemEnum[]{r100, r101, r102, r103, r104, r105, r110, r111, r106, r107, r108};
    }

    public static FabItemEnum[] values() {
        return (FabItemEnum[]) f237612a.clone();
    }

    public static FabItemEnum valueOf(String r100) {
        return (FabItemEnum) r27.a.a(FabItemEnum.class, r100);
    }

    public FabItemEnum(String r100, int r101) {
        this(r100, r101, 1, 0, 0, 0);
    }

    public FabItemEnum(String r100, int r101, int r102, int r103, int r104, int r105) {
        super(r100, r101);
        this.type = r102;
        this.imageRes = r103;
        this.colorRes = r104;
        this.imageTintColorRes = r105;
    }
}
