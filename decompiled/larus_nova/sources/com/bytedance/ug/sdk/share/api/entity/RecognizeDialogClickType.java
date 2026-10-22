package com.bytedance.ug.sdk.share.api.entity;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum RecognizeDialogClickType extends Enum<RecognizeDialogClickType> {
    public static final RecognizeDialogClickType CLICK_TYPE_CLOSE = null;
    public static final RecognizeDialogClickType CLICK_TYPE_DETAIL = null;
    public static final RecognizeDialogClickType CLICK_TYPE_USER_DETAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecognizeDialogClickType[] f272307a = null;

    static {
        RecognizeDialogClickType r100 = new RecognizeDialogClickType("CLICK_TYPE_CLOSE", 0);
        CLICK_TYPE_CLOSE = r100;
        RecognizeDialogClickType r101 = new RecognizeDialogClickType("CLICK_TYPE_DETAIL", 1);
        CLICK_TYPE_DETAIL = r101;
        RecognizeDialogClickType r102 = new RecognizeDialogClickType("CLICK_TYPE_USER_DETAIL", 2);
        CLICK_TYPE_USER_DETAIL = r102;
        f272307a = new RecognizeDialogClickType[]{r100, r101, r102};
    }

    public static RecognizeDialogClickType[] values() {
        return (RecognizeDialogClickType[]) f272307a.clone();
    }

    public static RecognizeDialogClickType valueOf(String r100) {
        return (RecognizeDialogClickType) a.a(RecognizeDialogClickType.class, r100);
    }

    public RecognizeDialogClickType(String r100, int r101) {
        super(r100, r101);
    }
}
