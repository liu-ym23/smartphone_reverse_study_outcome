package com.bytedance.ee.bear.sheet.borderline;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum BorderStyleEnum extends Enum<BorderStyleEnum> {
    public static final /* synthetic */ BorderStyleEnum[] a = null;
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
        BorderStyleEnum r0 = new BorderStyleEnum("noborder", 0, 2131247795);
        noborder = r0;
        BorderStyleEnum r1 = new BorderStyleEnum("fullborder", 1, 2131247783);
        fullborder = r1;
        BorderStyleEnum r2 = new BorderStyleEnum("outerborder", 2, 2131247796);
        outerborder = r2;
        BorderStyleEnum r4 = new BorderStyleEnum("innerborder", 3, 2131247792);
        innerborder = r4;
        BorderStyleEnum r6 = new BorderStyleEnum("leftborder", 4, 2131247793);
        leftborder = r6;
        BorderStyleEnum r8 = new BorderStyleEnum("rightborder", 5, 2131247798);
        rightborder = r8;
        BorderStyleEnum r10 = new BorderStyleEnum("topborder", 6, 2131247803);
        topborder = r10;
        BorderStyleEnum r12 = new BorderStyleEnum("bottomborder", 7, 2131247787);
        bottomborder = r12;
        a = new BorderStyleEnum[]{r0, r1, r2, r4, r6, r8, r10, r12};
    }

    public static BorderStyleEnum[] values() {
        return (BorderStyleEnum[]) a.clone();
    }

    public static BorderStyleEnum valueOf(String r1) {
        return (BorderStyleEnum) r27.a.a(BorderStyleEnum.class, r1);
    }

    public BorderStyleEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.iconRes = r3;
    }
}
