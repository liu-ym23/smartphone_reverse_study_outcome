package com.bytedance.ee.bear.bitable.statistic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/BitableStatisticConstant$Result;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SUCCESS", "FAIL", "CANCEL", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableStatisticConstant$Result extends Enum<BitableStatisticConstant$Result> {
    public static final BitableStatisticConstant$Result CANCEL = null;
    public static final a Companion = null;
    public static final BitableStatisticConstant$Result FAIL = null;
    public static final BitableStatisticConstant$Result SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BitableStatisticConstant$Result[] f215594a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215595b = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<BitableStatisticConstant$Result> getEntries() {
        return f215595b;
    }

    static {
        BitableStatisticConstant$Result r100 = new BitableStatisticConstant$Result("SUCCESS", 0, "success");
        SUCCESS = r100;
        BitableStatisticConstant$Result r101 = new BitableStatisticConstant$Result("FAIL", 1, "fail");
        FAIL = r101;
        BitableStatisticConstant$Result r102 = new BitableStatisticConstant$Result("CANCEL", 2, "cancel");
        CANCEL = r102;
        BitableStatisticConstant$Result[] r103 = {r100, r101, r102};
        f215594a = r103;
        f215595b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static BitableStatisticConstant$Result[] values() {
        return (BitableStatisticConstant$Result[]) f215594a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final BitableStatisticConstant$Result lookup(String r100) {
        Companion.getClass();
        BitableStatisticConstant$Result[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        BitableStatisticConstant$Result r104 = r101[r103];
        if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L12;
        r103 = r103 + 1;
        goto L3
    L12:
        return r104;
    L8:
        return null;
    }

    public static BitableStatisticConstant$Result valueOf(String r100) {
        return (BitableStatisticConstant$Result) r27.a.a(BitableStatisticConstant$Result.class, r100);
    }

    public BitableStatisticConstant$Result(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
