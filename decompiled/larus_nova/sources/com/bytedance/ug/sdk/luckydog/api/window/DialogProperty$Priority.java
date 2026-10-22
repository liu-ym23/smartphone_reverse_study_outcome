package com.bytedance.ug.sdk.luckydog.api.window;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum DialogProperty$Priority extends Enum<DialogProperty$Priority> {
    public static final DialogProperty$Priority Default = null;
    public static final DialogProperty$Priority High = null;
    public static final DialogProperty$Priority Highest = null;
    public static final DialogProperty$Priority Low = null;
    public static final DialogProperty$Priority Medium = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DialogProperty$Priority[] f271717a = null;
    public final int value;

    static {
        DialogProperty$Priority r100 = new DialogProperty$Priority("Highest", 0, 4);
        Highest = r100;
        DialogProperty$Priority r101 = new DialogProperty$Priority("High", 1, 3);
        High = r101;
        DialogProperty$Priority r102 = new DialogProperty$Priority("Medium", 2, 2);
        Medium = r102;
        DialogProperty$Priority r103 = new DialogProperty$Priority("Default", 3, 1);
        Default = r103;
        DialogProperty$Priority r104 = new DialogProperty$Priority("Low", 4, 0);
        Low = r104;
        f271717a = new DialogProperty$Priority[]{r100, r101, r102, r103, r104};
    }

    public static DialogProperty$Priority[] values() {
        return (DialogProperty$Priority[]) f271717a.clone();
    }

    public static DialogProperty$Priority valueOf(String r100) {
        return (DialogProperty$Priority) a.a(DialogProperty$Priority.class, r100);
    }

    public DialogProperty$Priority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
