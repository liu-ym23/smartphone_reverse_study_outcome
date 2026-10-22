package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/FieldCommandType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SET_FIELD_ATTR", "ADD_FIELD", "DELETE_FIELD", "MOVE_FIELD", "CONVERT_FIELD", "ADD_OPTION", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FieldCommandType extends Enum<FieldCommandType> {
    public static final FieldCommandType ADD_FIELD = null;
    public static final FieldCommandType ADD_OPTION = null;
    public static final FieldCommandType CONVERT_FIELD = null;
    public static final FieldCommandType DELETE_FIELD = null;
    public static final FieldCommandType MOVE_FIELD = null;
    public static final FieldCommandType SET_FIELD_ATTR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FieldCommandType[] f207110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207111b = null;
    private final String value;

    public static EnumEntries<FieldCommandType> getEntries() {
        return f207111b;
    }

    static {
        FieldCommandType r100 = new FieldCommandType("SET_FIELD_ATTR", 0, "SetFieldAttr");
        SET_FIELD_ATTR = r100;
        FieldCommandType r101 = new FieldCommandType("ADD_FIELD", 1, "AddField");
        ADD_FIELD = r101;
        FieldCommandType r102 = new FieldCommandType("DELETE_FIELD", 2, "DeleteField");
        DELETE_FIELD = r102;
        FieldCommandType r103 = new FieldCommandType("MOVE_FIELD", 3, "MoveField");
        MOVE_FIELD = r103;
        FieldCommandType r104 = new FieldCommandType("CONVERT_FIELD", 4, "ConvertField");
        CONVERT_FIELD = r104;
        FieldCommandType r105 = new FieldCommandType("ADD_OPTION", 5, "AddOptions");
        ADD_OPTION = r105;
        FieldCommandType[] r110 = {r100, r101, r102, r103, r104, r105};
        f207110a = r110;
        f207111b = EnumEntriesKt.enumEntries(r110);
    }

    public static FieldCommandType[] values() {
        return (FieldCommandType[]) f207110a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static FieldCommandType valueOf(String r100) {
        return (FieldCommandType) a.a(FieldCommandType.class, r100);
    }

    public FieldCommandType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
