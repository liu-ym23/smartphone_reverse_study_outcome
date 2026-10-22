package com.bytedance.ug.sdk.luckydog.api.window;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum DialogProperty$Type extends Enum<DialogProperty$Type> {
    public static final DialogProperty$Type DIALOG_FLEXIBLE = null;
    public static final DialogProperty$Type UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DialogProperty$Type[] f271718a = null;

    static {
        DialogProperty$Type r100 = new DialogProperty$Type("UNKNOWN", 0);
        UNKNOWN = r100;
        DialogProperty$Type r101 = new DialogProperty$Type("DIALOG_FLEXIBLE", 1);
        DIALOG_FLEXIBLE = r101;
        f271718a = new DialogProperty$Type[]{r100, r101};
    }

    public static DialogProperty$Type[] values() {
        return (DialogProperty$Type[]) f271718a.clone();
    }

    public static DialogProperty$Type valueOf(String r100) {
        return (DialogProperty$Type) a.a(DialogProperty$Type.class, r100);
    }

    public DialogProperty$Type(String r100, int r101) {
        super(r100, r101);
    }
}
