package com.bytedance.ee.bear.bitable.statistic;

import com.bytedance.ee.bear.document.loading.SmallLoadingPlugin;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/BitableStatisticConstant$FpsDropState;", "", "title", "", "max", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getMax", "()I", "NONE", "LITTLE", "NORMAL", "MIDDLE", "SERIOUS", "BAD", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BitableStatisticConstant$FpsDropState extends Enum<BitableStatisticConstant$FpsDropState> {
    public static final BitableStatisticConstant$FpsDropState BAD = null;
    public static final a Companion = null;
    public static final BitableStatisticConstant$FpsDropState LITTLE = null;
    public static final BitableStatisticConstant$FpsDropState MIDDLE = null;
    public static final BitableStatisticConstant$FpsDropState NONE = null;
    public static final BitableStatisticConstant$FpsDropState NORMAL = null;
    public static final BitableStatisticConstant$FpsDropState SERIOUS = null;
    public static final /* synthetic */ BitableStatisticConstant$FpsDropState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int max;
    private final String title;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static BitableStatisticConstant$FpsDropState a(int r2) {
            BitableStatisticConstant$FpsDropState r0 = BitableStatisticConstant$FpsDropState.NONE;
            if (r2 > r0.getMax()) goto L5;
            return r0;
        L5:
            BitableStatisticConstant$FpsDropState r1 = BitableStatisticConstant$FpsDropState.LITTLE;
            if (r2 > r1.getMax()) goto L8;
            return r1;
        L8:
            BitableStatisticConstant$FpsDropState r3 = BitableStatisticConstant$FpsDropState.NORMAL;
            if (r2 > r3.getMax()) goto L11;
            return r3;
        L11:
            BitableStatisticConstant$FpsDropState r4 = BitableStatisticConstant$FpsDropState.MIDDLE;
            if (r2 > r4.getMax()) goto L14;
            return r4;
        L14:
            BitableStatisticConstant$FpsDropState r5 = BitableStatisticConstant$FpsDropState.SERIOUS;
            if (r2 > r5.getMax()) goto L18;
            return r5;
        L18:
            return BitableStatisticConstant$FpsDropState.BAD;
        }
    }

    @JvmStatic
    public static final BitableStatisticConstant$FpsDropState cal(int r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public static EnumEntries<BitableStatisticConstant$FpsDropState> getEntries() {
        return b;
    }

    static {
        BitableStatisticConstant$FpsDropState r0 = new BitableStatisticConstant$FpsDropState("NONE", 0, "none", 0);
        NONE = r0;
        BitableStatisticConstant$FpsDropState r1 = new BitableStatisticConstant$FpsDropState("LITTLE", 1, "little", 2);
        LITTLE = r1;
        BitableStatisticConstant$FpsDropState r3 = new BitableStatisticConstant$FpsDropState("NORMAL", 2, "normal", 6);
        NORMAL = r3;
        BitableStatisticConstant$FpsDropState r5 = new BitableStatisticConstant$FpsDropState("MIDDLE", 3, "middle", 13);
        MIDDLE = r5;
        BitableStatisticConstant$FpsDropState r7 = new BitableStatisticConstant$FpsDropState("SERIOUS", 4, "serious", 25);
        SERIOUS = r7;
        BitableStatisticConstant$FpsDropState r10 = new BitableStatisticConstant$FpsDropState("BAD", 5, "bad", SmallLoadingPlugin.DURATION_MAX);
        BAD = r10;
        BitableStatisticConstant$FpsDropState[] r8 = {r0, r1, r3, r5, r7, r10};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
        Companion = new a();
    }

    public static BitableStatisticConstant$FpsDropState[] values() {
        return (BitableStatisticConstant$FpsDropState[]) a.clone();
    }

    public final int getMax() {
        return this.max;
    }

    public final String getTitle() {
        return this.title;
    }

    public static BitableStatisticConstant$FpsDropState valueOf(String r1) {
        return (BitableStatisticConstant$FpsDropState) r27.a.a(BitableStatisticConstant$FpsDropState.class, r1);
    }

    public BitableStatisticConstant$FpsDropState(String r1, int r2, String r3, int r4) {
        super(r1, r2);
        this.title = r3;
        this.max = r4;
    }
}
