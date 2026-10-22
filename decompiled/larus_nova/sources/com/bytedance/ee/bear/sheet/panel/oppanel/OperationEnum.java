package com.bytedance.ee.bear.sheet.panel.oppanel;

import com.bytedance.ee.bear.document.share.ShareItem;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final enum OperationEnum extends Enum<OperationEnum> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OperationEnum[] f238197a = null;
    public static final OperationEnum addReminder = null;
    public static final OperationEnum backColor = null;
    public static final OperationEnum borderLine = null;
    public static final OperationEnum checkbox = null;
    public static final OperationEnum deleteCol = null;
    public static final OperationEnum deleteRow = null;
    public static final OperationEnum filter = null;
    public static final OperationEnum fontSize = null;
    public static final OperationEnum foreColor = null;
    public static final OperationEnum freezeSheet = null;
    public static final OperationEnum hideCol = null;
    public static final OperationEnum insertComment = null;
    public static final OperationEnum merge = null;
    public static final OperationEnum myAiDataInsight = null;
    public static final OperationEnum shareImage = null;
    public static final OperationEnum sort = null;
    public static final OperationEnum uploadImage = null;
    boolean hasNext;
    int iconResId;

    public OperationEnum() {
        throw null;
    }

    static {
        OperationEnum r100 = new OperationEnum("deleteRow", 0, R.drawable.sheet_icon_delete_trash_outlined, false);
        deleteRow = r100;
        OperationEnum r101 = new OperationEnum("deleteCol", 1, R.drawable.sheet_icon_delete_trash_outlined, false);
        deleteCol = r101;
        OperationEnum r102 = new OperationEnum("merge", 2, R.drawable.sheet_icon_mergecells_outlined, false);
        merge = r102;
        OperationEnum r103 = new OperationEnum("insertComment", 3, R.drawable.ud_icon_add_comment_outlined, false);
        insertComment = r103;
        OperationEnum r104 = new OperationEnum("filter", 4, R.drawable.ud_icon_list_filter_outlined, true);
        filter = r104;
        OperationEnum r105 = new OperationEnum("sort", 5, R.drawable.sheet_icon_sor_a_to_z_outlined, true);
        sort = r105;
        OperationEnum r110 = new OperationEnum("freezeSheet", 6, R.drawable.sheet_icon_freeze_column_and_row_outlined, true);
        freezeSheet = r110;
        OperationEnum r111 = new OperationEnum("uploadImage", 7, R.drawable.ud_icon_image_outlined, false);
        uploadImage = r111;
        OperationEnum r112 = new OperationEnum("addReminder", 8, R.drawable.ud_icon_alarm_clock_outlined, false);
        addReminder = r112;
        OperationEnum r113 = new OperationEnum(ShareItem.SHARE_IMAGE, 9, R.drawable.ud_icon_long_figure_outlined, false);
        shareImage = r113;
        OperationEnum r106 = new OperationEnum("checkbox", 10, R.drawable.ud_icon_todo_outlined, false);
        checkbox = r106;
        OperationEnum r107 = new OperationEnum("borderLine", 11, -1, true);
        borderLine = r107;
        OperationEnum r114 = new OperationEnum("foreColor", 12, -1, true);
        foreColor = r114;
        OperationEnum r115 = new OperationEnum("backColor", 13, -1, true);
        backColor = r115;
        OperationEnum r108 = new OperationEnum("fontSize", 14, -1, false);
        fontSize = r108;
        OperationEnum r109 = new OperationEnum("myAiDataInsight", 15, R.drawable.ud_icon_myai_colorful, false);
        myAiDataInsight = r109;
        OperationEnum r116 = new OperationEnum("hideCol", 16, R.drawable.sheet_icon_visible_lock_outlined, false);
        hideCol = r116;
        f238197a = new OperationEnum[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r114, r115, r108, r109, r116};
    }

    public static OperationEnum[] values() {
        return (OperationEnum[]) f238197a.clone();
    }

    public static OperationEnum valueOf(String r100) {
        return (OperationEnum) r27.a.a(OperationEnum.class, r100);
    }

    public OperationEnum(String r100, int r101, int r102, boolean r103) {
        super(r100, r101);
        this.iconResId = r102;
        this.hasNext = r103;
    }
}
