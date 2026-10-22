package com.bytedance.awemeopen.apps.framework.base.view.refresh;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final enum ButtonStyle extends Enum<ButtonStyle> {
    public static final ButtonStyle BORDER = null;
    public static final ButtonStyle SOLID = null;
    public static final /* synthetic */ ButtonStyle[] a = null;

    static {
        ButtonStyle r0 = new ButtonStyle("SOLID", 0);
        SOLID = r0;
        ButtonStyle r1 = new ButtonStyle("BORDER", 1);
        BORDER = r1;
        a = new ButtonStyle[]{r0, r1};
    }

    public static ButtonStyle[] values() {
        return (ButtonStyle[]) a.clone();
    }

    public static ButtonStyle valueOf(String r1) {
        return (ButtonStyle) r27.a.a(ButtonStyle.class, r1);
    }

    public ButtonStyle(String r1, int r2) {
        super(r1, r2);
    }
}
