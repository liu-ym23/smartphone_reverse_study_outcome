package com.bytedance.ee.bear.bitable.card.model.jsmodel.permission;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/permission/OperationType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ADDABLE", "DELETABLE", "EDITABLE", "OPTION_EDITABLE", "MOVABLE", "VISIBLE", "COPYABLE", "PASTABLE", "CUTTABLE", "LOCKABLE", "LOCAL_EDITABLE", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OperationType extends Enum<OperationType> {
    public static final OperationType ADDABLE = null;
    public static final OperationType COPYABLE = null;
    public static final OperationType CUTTABLE = null;
    public static final OperationType DELETABLE = null;
    public static final OperationType EDITABLE = null;
    public static final OperationType LOCAL_EDITABLE = null;
    public static final OperationType LOCKABLE = null;
    public static final OperationType MOVABLE = null;
    public static final OperationType OPTION_EDITABLE = null;
    public static final OperationType PASTABLE = null;
    public static final OperationType VISIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OperationType[] f207122a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207123b = null;
    private final String value;

    public static EnumEntries<OperationType> getEntries() {
        return f207123b;
    }

    static {
        OperationType r100 = new OperationType("ADDABLE", 0, "addable");
        ADDABLE = r100;
        OperationType r101 = new OperationType("DELETABLE", 1, "deletable");
        DELETABLE = r101;
        OperationType r102 = new OperationType("EDITABLE", 2, "editable");
        EDITABLE = r102;
        OperationType r103 = new OperationType("OPTION_EDITABLE", 3, "optionEditable");
        OPTION_EDITABLE = r103;
        OperationType r104 = new OperationType("MOVABLE", 4, "movable");
        MOVABLE = r104;
        OperationType r105 = new OperationType("VISIBLE", 5, "visible");
        VISIBLE = r105;
        OperationType r110 = new OperationType("COPYABLE", 6, "copyable");
        COPYABLE = r110;
        OperationType r111 = new OperationType("PASTABLE", 7, "pastable");
        PASTABLE = r111;
        OperationType r112 = new OperationType("CUTTABLE", 8, "cuttable");
        CUTTABLE = r112;
        OperationType r113 = new OperationType("LOCKABLE", 9, "lockable");
        LOCKABLE = r113;
        OperationType r114 = new OperationType("LOCAL_EDITABLE", 10, "localEditable");
        LOCAL_EDITABLE = r114;
        OperationType[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        f207122a = r106;
        f207123b = EnumEntriesKt.enumEntries(r106);
    }

    public static OperationType[] values() {
        return (OperationType[]) f207122a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static OperationType valueOf(String r100) {
        return (OperationType) a.a(OperationType.class, r100);
    }

    public OperationType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
