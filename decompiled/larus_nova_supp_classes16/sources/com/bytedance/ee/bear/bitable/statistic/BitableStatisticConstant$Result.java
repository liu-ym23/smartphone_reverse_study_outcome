package com.bytedance.ee.bear.bitable.statistic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/BitableStatisticConstant$Result;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SUCCESS", "FAIL", "CANCEL", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableStatisticConstant$Result extends Enum<BitableStatisticConstant$Result> {
    public static final BitableStatisticConstant$Result CANCEL = null;
    public static final a Companion = null;
    public static final BitableStatisticConstant$Result FAIL = null;
    public static final BitableStatisticConstant$Result SUCCESS = null;
    public static final /* synthetic */ BitableStatisticConstant$Result[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<BitableStatisticConstant$Result> getEntries() {
        return b;
    }

    static {
        BitableStatisticConstant$Result r0 = new BitableStatisticConstant$Result("SUCCESS", 0, "success");
        SUCCESS = r0;
        BitableStatisticConstant$Result r1 = new BitableStatisticConstant$Result("FAIL", 1, "fail");
        FAIL = r1;
        BitableStatisticConstant$Result r3 = new BitableStatisticConstant$Result("CANCEL", 2, "cancel");
        CANCEL = r3;
        BitableStatisticConstant$Result[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
        Companion = new a();
    }

    public static BitableStatisticConstant$Result[] values() {
        return (BitableStatisticConstant$Result[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final BitableStatisticConstant$Result lookup(String r5) {
        Companion.getClass();
        BitableStatisticConstant$Result[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        BitableStatisticConstant$Result r3 = r0[r2];
        if (Intrinsics.areEqual(r3.getValue(), r5) == true) goto L12;
        r2 = r2 + 1;
        goto L3
    L12:
        return r3;
    L8:
        return null;
    }

    public static BitableStatisticConstant$Result valueOf(String r1) {
        return (BitableStatisticConstant$Result) r27.a.a(BitableStatisticConstant$Result.class, r1);
    }

    public BitableStatisticConstant$Result(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
