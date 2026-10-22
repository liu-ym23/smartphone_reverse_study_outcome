package com.bytedance.ee.bear.middleground.permission.external;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/external/AdjustExternalResult;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SUCCESS", "FAIL", "AUDIT", "CANCEL", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AdjustExternalResult extends Enum<AdjustExternalResult> {
    public static final AdjustExternalResult AUDIT = null;
    public static final AdjustExternalResult CANCEL = null;
    public static final AdjustExternalResult FAIL = null;
    public static final AdjustExternalResult SUCCESS = null;
    public static final /* synthetic */ AdjustExternalResult[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<AdjustExternalResult> getEntries() {
        return b;
    }

    static {
        AdjustExternalResult r0 = new AdjustExternalResult("SUCCESS", 0, 1);
        SUCCESS = r0;
        AdjustExternalResult r1 = new AdjustExternalResult("FAIL", 1, 2);
        FAIL = r1;
        AdjustExternalResult r4 = new AdjustExternalResult("AUDIT", 2, 3);
        AUDIT = r4;
        AdjustExternalResult r6 = new AdjustExternalResult("CANCEL", 3, 4);
        CANCEL = r6;
        AdjustExternalResult[] r8 = {r0, r1, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static AdjustExternalResult[] values() {
        return (AdjustExternalResult[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AdjustExternalResult valueOf(String r1) {
        return (AdjustExternalResult) a.a(AdjustExternalResult.class, r1);
    }

    public AdjustExternalResult(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
