package com.bytedance.ies.dmt.ui.widget;

/* JADX INFO: loaded from: classes19.dex */
public final enum ButtonStyle extends Enum<ButtonStyle> {
    public static final ButtonStyle BORDER = null;
    public static final ButtonStyle SOLID = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ButtonStyle[] f248388a = null;

    static {
        ButtonStyle r100 = new ButtonStyle("SOLID", 0);
        SOLID = r100;
        ButtonStyle r101 = new ButtonStyle("BORDER", 1);
        BORDER = r101;
        f248388a = new ButtonStyle[]{r100, r101};
    }

    public static ButtonStyle[] values() {
        return (ButtonStyle[]) f248388a.clone();
    }

    public static ButtonStyle valueOf(String r100) {
        return (ButtonStyle) r27.a.a(ButtonStyle.class, r100);
    }

    public ButtonStyle(String r100, int r101) {
        super(r100, r101);
    }
}
