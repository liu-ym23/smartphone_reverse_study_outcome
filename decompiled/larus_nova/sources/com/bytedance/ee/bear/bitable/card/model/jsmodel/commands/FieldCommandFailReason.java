package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandFailReason;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "TableError", "ActionError", "NotSupport", "NameRepeat", "LastOne", "FieldTypeNotMatch", "RecordCountExceeded", "FieldCountExceeded", "WrongOptions", "FieldError", "RecordError", "GroupRepeat", "PrivateViewForbidden", "ActionNoPermission", "ActionOversize", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FieldCommandFailReason extends Enum<FieldCommandFailReason> {
    public static final FieldCommandFailReason ActionError = null;
    public static final FieldCommandFailReason ActionNoPermission = null;
    public static final FieldCommandFailReason ActionOversize = null;
    public static final FieldCommandFailReason FieldCountExceeded = null;
    public static final FieldCommandFailReason FieldError = null;
    public static final FieldCommandFailReason FieldTypeNotMatch = null;
    public static final FieldCommandFailReason GroupRepeat = null;
    public static final FieldCommandFailReason LastOne = null;
    public static final FieldCommandFailReason NameRepeat = null;
    public static final FieldCommandFailReason NotSupport = null;
    public static final FieldCommandFailReason PrivateViewForbidden = null;
    public static final FieldCommandFailReason RecordCountExceeded = null;
    public static final FieldCommandFailReason RecordError = null;
    public static final FieldCommandFailReason TableError = null;
    public static final FieldCommandFailReason UNKNOWN = null;
    public static final FieldCommandFailReason WrongOptions = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FieldCommandFailReason[] f207106a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207107b = null;
    private final int value;

    public static EnumEntries<FieldCommandFailReason> getEntries() {
        return f207107b;
    }

    static {
        FieldCommandFailReason r100 = new FieldCommandFailReason("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        FieldCommandFailReason r101 = new FieldCommandFailReason("TableError", 1, 1);
        TableError = r101;
        FieldCommandFailReason r102 = new FieldCommandFailReason("ActionError", 2, 2);
        ActionError = r102;
        FieldCommandFailReason r103 = new FieldCommandFailReason("NotSupport", 3, 3);
        NotSupport = r103;
        FieldCommandFailReason r104 = new FieldCommandFailReason("NameRepeat", 4, 4);
        NameRepeat = r104;
        FieldCommandFailReason r105 = new FieldCommandFailReason("LastOne", 5, 5);
        LastOne = r105;
        FieldCommandFailReason r110 = new FieldCommandFailReason("FieldTypeNotMatch", 6, 6);
        FieldTypeNotMatch = r110;
        FieldCommandFailReason r111 = new FieldCommandFailReason("RecordCountExceeded", 7, 8);
        RecordCountExceeded = r111;
        FieldCommandFailReason r112 = new FieldCommandFailReason("FieldCountExceeded", 8, 9);
        FieldCountExceeded = r112;
        FieldCommandFailReason r113 = new FieldCommandFailReason("WrongOptions", 9, 10);
        WrongOptions = r113;
        FieldCommandFailReason r114 = new FieldCommandFailReason("FieldError", 10, 11);
        FieldError = r114;
        FieldCommandFailReason r115 = new FieldCommandFailReason("RecordError", 11, 12);
        RecordError = r115;
        FieldCommandFailReason r106 = new FieldCommandFailReason("GroupRepeat", 12, 13);
        GroupRepeat = r106;
        FieldCommandFailReason r107 = new FieldCommandFailReason("PrivateViewForbidden", 13, 14);
        PrivateViewForbidden = r107;
        FieldCommandFailReason r108 = new FieldCommandFailReason("ActionNoPermission", 14, 15);
        ActionNoPermission = r108;
        FieldCommandFailReason r109 = new FieldCommandFailReason("ActionOversize", 15, 16);
        ActionOversize = r109;
        FieldCommandFailReason[] r116 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109};
        f207106a = r116;
        f207107b = EnumEntriesKt.enumEntries(r116);
    }

    public static FieldCommandFailReason[] values() {
        return (FieldCommandFailReason[]) f207106a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FieldCommandFailReason valueOf(String r100) {
        return (FieldCommandFailReason) a.a(FieldCommandFailReason.class, r100);
    }

    public FieldCommandFailReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
