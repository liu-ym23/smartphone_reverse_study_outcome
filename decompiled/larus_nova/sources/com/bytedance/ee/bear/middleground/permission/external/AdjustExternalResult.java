package com.bytedance.ee.bear.middleground.permission.external;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/external/AdjustExternalResult;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SUCCESS", "FAIL", "AUDIT", "CANCEL", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AdjustExternalResult extends Enum<AdjustExternalResult> {
    public static final AdjustExternalResult AUDIT = null;
    public static final AdjustExternalResult CANCEL = null;
    public static final AdjustExternalResult FAIL = null;
    public static final AdjustExternalResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AdjustExternalResult[] f233877a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f233878b = null;
    private final int value;

    public static EnumEntries<AdjustExternalResult> getEntries() {
        return f233878b;
    }

    static {
        AdjustExternalResult r100 = new AdjustExternalResult("SUCCESS", 0, 1);
        SUCCESS = r100;
        AdjustExternalResult r101 = new AdjustExternalResult("FAIL", 1, 2);
        FAIL = r101;
        AdjustExternalResult r102 = new AdjustExternalResult("AUDIT", 2, 3);
        AUDIT = r102;
        AdjustExternalResult r103 = new AdjustExternalResult("CANCEL", 3, 4);
        CANCEL = r103;
        AdjustExternalResult[] r104 = {r100, r101, r102, r103};
        f233877a = r104;
        f233878b = EnumEntriesKt.enumEntries(r104);
    }

    public static AdjustExternalResult[] values() {
        return (AdjustExternalResult[]) f233877a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AdjustExternalResult valueOf(String r100) {
        return (AdjustExternalResult) a.a(AdjustExternalResult.class, r100);
    }

    public AdjustExternalResult(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
