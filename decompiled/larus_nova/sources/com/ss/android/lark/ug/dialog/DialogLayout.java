package com.ss.android.lark.ug.dialog;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/ug/dialog/DialogLayout;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OPERATION_DIALOG", "ug-dialog_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DialogLayout extends Enum<DialogLayout> {
    public static final DialogLayout OPERATION_DIALOG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DialogLayout[] f444431a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444432b = null;
    private final String value;

    public static EnumEntries<DialogLayout> getEntries() {
        return f444432b;
    }

    static {
        DialogLayout r100 = new DialogLayout();
        OPERATION_DIALOG = r100;
        DialogLayout[] r101 = {r100};
        f444431a = r101;
        f444432b = EnumEntriesKt.enumEntries(r101);
    }

    public DialogLayout() {
        super("OPERATION_DIALOG", 0);
        this.value = "ug_operation_dialog";
    }

    public static DialogLayout[] values() {
        return (DialogLayout[]) f444431a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static DialogLayout valueOf(String r100) {
        return (DialogLayout) r27.a.a(DialogLayout.class, r100);
    }
}
