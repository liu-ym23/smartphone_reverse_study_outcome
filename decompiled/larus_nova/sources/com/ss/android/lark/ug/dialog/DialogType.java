package com.ss.android.lark.ug.dialog;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/ug/dialog/DialogType;", "", "<init>", "(Ljava/lang/String;I)V", "FULL_SCREEN_DIALOG", "HALF_SCREEN_DIALOG", "ug-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DialogType extends Enum<DialogType> {
    public static final DialogType FULL_SCREEN_DIALOG = null;
    public static final DialogType HALF_SCREEN_DIALOG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DialogType[] f444433a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444434b = null;

    public static EnumEntries<DialogType> getEntries() {
        return f444434b;
    }

    static {
        DialogType r100 = new DialogType("FULL_SCREEN_DIALOG", 0);
        FULL_SCREEN_DIALOG = r100;
        DialogType r101 = new DialogType("HALF_SCREEN_DIALOG", 1);
        HALF_SCREEN_DIALOG = r101;
        DialogType[] r102 = {r100, r101};
        f444433a = r102;
        f444434b = EnumEntriesKt.enumEntries(r102);
    }

    public static DialogType[] values() {
        return (DialogType[]) f444433a.clone();
    }

    public static DialogType valueOf(String r100) {
        return (DialogType) r27.a.a(DialogType.class, r100);
    }

    public DialogType(String r100, int r101) {
        super(r100, r101);
    }
}
