package com.bytedance.ee.bear.bitable.card.model.jsmodel.commands;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/commands/TableCommonType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SET_EX_TYPE", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TableCommonType extends Enum<TableCommonType> {
    public static final TableCommonType SET_EX_TYPE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TableCommonType[] f207114a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207115b = null;
    private final String value;

    public static EnumEntries<TableCommonType> getEntries() {
        return f207115b;
    }

    static {
        TableCommonType r100 = new TableCommonType();
        SET_EX_TYPE = r100;
        TableCommonType[] r101 = {r100};
        f207114a = r101;
        f207115b = EnumEntriesKt.enumEntries(r101);
    }

    public TableCommonType() {
        super("SET_EX_TYPE", 0);
        this.value = "SetExType";
    }

    public static TableCommonType[] values() {
        return (TableCommonType[]) f207114a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static TableCommonType valueOf(String r100) {
        return (TableCommonType) a.a(TableCommonType.class, r100);
    }
}
