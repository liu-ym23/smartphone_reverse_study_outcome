package com.bytedance.ee.bear.bitable.celleditor.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/bean/EditCellOperation;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EnterEditMode", "SetValue", "ExitEditMode", "OpenPanel", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EditCellOperation extends Enum<EditCellOperation> {
    public static final EditCellOperation EnterEditMode = null;
    public static final EditCellOperation ExitEditMode = null;
    public static final EditCellOperation OpenPanel = null;
    public static final EditCellOperation SetValue = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EditCellOperation[] f209314a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209315b = null;
    private final int value;

    public static EnumEntries<EditCellOperation> getEntries() {
        return f209315b;
    }

    static {
        EditCellOperation r100 = new EditCellOperation("EnterEditMode", 0, 1);
        EnterEditMode = r100;
        EditCellOperation r101 = new EditCellOperation("SetValue", 1, 2);
        SetValue = r101;
        EditCellOperation r102 = new EditCellOperation("ExitEditMode", 2, 3);
        ExitEditMode = r102;
        EditCellOperation r103 = new EditCellOperation("OpenPanel", 3, 4);
        OpenPanel = r103;
        EditCellOperation[] r104 = {r100, r101, r102, r103};
        f209314a = r104;
        f209315b = EnumEntriesKt.enumEntries(r104);
    }

    public static EditCellOperation[] values() {
        return (EditCellOperation[]) f209314a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EditCellOperation valueOf(String r100) {
        return (EditCellOperation) a.a(EditCellOperation.class, r100);
    }

    public EditCellOperation(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
