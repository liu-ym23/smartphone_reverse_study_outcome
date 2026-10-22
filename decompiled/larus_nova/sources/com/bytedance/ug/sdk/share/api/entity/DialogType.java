package com.bytedance.ug.sdk.share.api.entity;

import r27.a;

/* JADX INFO: loaded from: classes22.dex */
public final enum DialogType extends Enum<DialogType> {
    public static final DialogType TOKEN_GUIDE = null;
    public static final DialogType TOKEN_NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DialogType[] f272304a = null;

    static {
        DialogType r100 = new DialogType("TOKEN_NORMAL", 0);
        TOKEN_NORMAL = r100;
        DialogType r101 = new DialogType("TOKEN_GUIDE", 1);
        TOKEN_GUIDE = r101;
        f272304a = new DialogType[]{r100, r101};
    }

    public static DialogType[] values() {
        return (DialogType[]) f272304a.clone();
    }

    public static DialogType valueOf(String r100) {
        return (DialogType) a.a(DialogType.class, r100);
    }

    public DialogType(String r100, int r101) {
        super(r100, r101);
    }
}
