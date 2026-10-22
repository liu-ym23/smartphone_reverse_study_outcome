package com.bytedance.ee.bear.bitable.common.model.condition;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/model/condition/EFilterSortFieldInvalidType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", AccountType.OTHERS, "FIELD_UNREADABLE", "FIELD_PARTIAL_DENIED", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EFilterSortFieldInvalidType extends Enum<EFilterSortFieldInvalidType> {
    public static final EFilterSortFieldInvalidType FIELD_PARTIAL_DENIED = null;
    public static final EFilterSortFieldInvalidType FIELD_UNREADABLE = null;
    public static final EFilterSortFieldInvalidType OTHERS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EFilterSortFieldInvalidType[] f209852a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209853b = null;
    private final int value;

    public static EnumEntries<EFilterSortFieldInvalidType> getEntries() {
        return f209853b;
    }

    static {
        EFilterSortFieldInvalidType r100 = new EFilterSortFieldInvalidType(AccountType.OTHERS, 0, 0);
        OTHERS = r100;
        EFilterSortFieldInvalidType r101 = new EFilterSortFieldInvalidType("FIELD_UNREADABLE", 1, 1);
        FIELD_UNREADABLE = r101;
        EFilterSortFieldInvalidType r102 = new EFilterSortFieldInvalidType("FIELD_PARTIAL_DENIED", 2, 2);
        FIELD_PARTIAL_DENIED = r102;
        EFilterSortFieldInvalidType[] r103 = {r100, r101, r102};
        f209852a = r103;
        f209853b = EnumEntriesKt.enumEntries(r103);
    }

    public static EFilterSortFieldInvalidType[] values() {
        return (EFilterSortFieldInvalidType[]) f209852a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static EFilterSortFieldInvalidType valueOf(String r100) {
        return (EFilterSortFieldInvalidType) a.a(EFilterSortFieldInvalidType.class, r100);
    }

    public EFilterSortFieldInvalidType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
