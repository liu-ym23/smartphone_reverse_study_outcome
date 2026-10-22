package com.bytedance.ee.bear.bitable.filter.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/model/EFilterCommandType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AddCondition", "DeleteCondition", "UpdateCondition", "SetConjunction", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EFilterCommandType extends Enum<EFilterCommandType> {
    public static final EFilterCommandType AddCondition = null;
    public static final EFilterCommandType DeleteCondition = null;
    public static final EFilterCommandType SetConjunction = null;
    public static final EFilterCommandType UpdateCondition = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EFilterCommandType[] f211871a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f211872b = null;
    private final String value;

    public static EnumEntries<EFilterCommandType> getEntries() {
        return f211872b;
    }

    static {
        EFilterCommandType r100 = new EFilterCommandType("AddCondition", 0, "AddCondition");
        AddCondition = r100;
        EFilterCommandType r101 = new EFilterCommandType("DeleteCondition", 1, "DeleteCondition");
        DeleteCondition = r101;
        EFilterCommandType r102 = new EFilterCommandType("UpdateCondition", 2, "UpdateCondition");
        UpdateCondition = r102;
        EFilterCommandType r103 = new EFilterCommandType("SetConjunction", 3, "SetConjunction");
        SetConjunction = r103;
        EFilterCommandType[] r104 = {r100, r101, r102, r103};
        f211871a = r104;
        f211872b = EnumEntriesKt.enumEntries(r104);
    }

    public static EFilterCommandType[] values() {
        return (EFilterCommandType[]) f211871a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static EFilterCommandType valueOf(String r100) {
        return (EFilterCommandType) r27.a.a(EFilterCommandType.class, r100);
    }

    public EFilterCommandType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
