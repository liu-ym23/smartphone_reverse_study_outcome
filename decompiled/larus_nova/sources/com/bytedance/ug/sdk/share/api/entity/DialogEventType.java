package com.bytedance.ug.sdk.share.api.entity;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum DialogEventType extends Enum<DialogEventType> {
    public static final DialogEventType CLICK = null;
    public static final DialogEventType DISMISS = null;
    public static final DialogEventType SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DialogEventType[] f272303a = null;

    static {
        DialogEventType r100 = new DialogEventType("SHOW", 0);
        SHOW = r100;
        DialogEventType r101 = new DialogEventType("CLICK", 1);
        CLICK = r101;
        DialogEventType r102 = new DialogEventType("DISMISS", 2);
        DISMISS = r102;
        f272303a = new DialogEventType[]{r100, r101, r102};
    }

    public static DialogEventType[] values() {
        return (DialogEventType[]) f272303a.clone();
    }

    public static DialogEventType valueOf(String r100) {
        return (DialogEventType) a.a(DialogEventType.class, r100);
    }

    public DialogEventType(String r100, int r101) {
        super(r100, r101);
    }
}
