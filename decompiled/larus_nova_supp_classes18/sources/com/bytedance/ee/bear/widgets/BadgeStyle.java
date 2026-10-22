package com.bytedance.ee.bear.widgets;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final enum BadgeStyle extends Enum<BadgeStyle> {
    public static final /* synthetic */ BadgeStyle[] a = null;
    public static final BadgeStyle mute = null;
    public static final BadgeStyle num = null;
    public static final BadgeStyle point = null;
    public static final BadgeStyle text = null;

    static {
        BadgeStyle r0 = new BadgeStyle("point", 0);
        point = r0;
        BadgeStyle r1 = new BadgeStyle("num", 1);
        num = r1;
        BadgeStyle r3 = new BadgeStyle("mute", 2);
        mute = r3;
        BadgeStyle r5 = new BadgeStyle("text", 3);
        text = r5;
        a = new BadgeStyle[]{r0, r1, r3, r5};
    }

    public static BadgeStyle[] values() {
        return (BadgeStyle[]) a.clone();
    }

    public static BadgeStyle valueOf(String r1) {
        return (BadgeStyle) r27.a.a(BadgeStyle.class, r1);
    }

    public BadgeStyle(String r1, int r2) {
        super(r1, r2);
    }
}
