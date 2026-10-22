package com.bytedance.ee.bear.sheet.borderline;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final enum BorderStyleEnum extends Enum<BorderStyleEnum> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BorderStyleEnum[] f237382a = null;
    public static final BorderStyleEnum bottomborder = null;
    public static final BorderStyleEnum fullborder = null;
    public static final BorderStyleEnum innerborder = null;
    public static final BorderStyleEnum leftborder = null;
    public static final BorderStyleEnum noborder = null;
    public static final BorderStyleEnum outerborder = null;
    public static final BorderStyleEnum rightborder = null;
    public static final BorderStyleEnum topborder = null;
    public int iconRes;

    static {
        BorderStyleEnum r100 = new BorderStyleEnum("noborder", 0, R.drawable.sheet_icon_no_borders_outlined);
        noborder = r100;
        BorderStyleEnum r101 = new BorderStyleEnum("fullborder", 1, R.drawable.sheet_icon_borders_outlined);
        fullborder = r101;
        BorderStyleEnum r102 = new BorderStyleEnum("outerborder", 2, R.drawable.sheet_icon_outer_borders_outlined);
        outerborder = r102;
        BorderStyleEnum r103 = new BorderStyleEnum("innerborder", 3, R.drawable.sheet_icon_inner_borders_outlined);
        innerborder = r103;
        BorderStyleEnum r104 = new BorderStyleEnum("leftborder", 4, R.drawable.sheet_icon_left_borders_outlined);
        leftborder = r104;
        BorderStyleEnum r105 = new BorderStyleEnum("rightborder", 5, R.drawable.sheet_icon_right_borders_outlined);
        rightborder = r105;
        BorderStyleEnum r110 = new BorderStyleEnum("topborder", 6, R.drawable.sheet_icon_up_borders_outlined);
        topborder = r110;
        BorderStyleEnum r111 = new BorderStyleEnum("bottomborder", 7, R.drawable.sheet_icon_down_borders_outlined);
        bottomborder = r111;
        f237382a = new BorderStyleEnum[]{r100, r101, r102, r103, r104, r105, r110, r111};
    }

    public static BorderStyleEnum[] values() {
        return (BorderStyleEnum[]) f237382a.clone();
    }

    public static BorderStyleEnum valueOf(String r100) {
        return (BorderStyleEnum) r27.a.a(BorderStyleEnum.class, r100);
    }

    public BorderStyleEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.iconRes = r102;
    }
}
