package com.bytedance.ee.bear.bitable.statistic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$BW\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012(\b\u0002\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\f¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0001J\u001e\u0010 \u001a\u00020\u001d2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R.\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\fX\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\f8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014¨\u0006%"}, d2 = {"Lcom/bytedance/ee/bear/bitable/statistic/BitableStatisticEventModel$NormalPointModel;", "Ljava/io/Serializable;", "name", "", "timestamp", "", "unique", "", "pointType", "Lcom/bytedance/ee/bear/bitable/statistic/BitableStatisticEventModel$NormalPointType;", "extras", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;JZLcom/bytedance/ee/bear/bitable/statistic/BitableStatisticEventModel$NormalPointType;Ljava/util/HashMap;)V", "getName", "()Ljava/lang/String;", "getTimestamp", "()J", "getUnique", "()Z", "type", "getType", "()Lcom/bytedance/ee/bear/bitable/statistic/BitableStatisticEventModel$NormalPointType;", "mExtras", "getExtras", "()Ljava/util/HashMap;", "isTempPoint", "addExtra", "", "key", "value", "addExtras", "extra", "", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableStatisticEventModel$NormalPointModel implements Serializable {
    public static final a Companion = null;
    private HashMap<String, Serializable> mExtras;
    private final String name;
    private final long timestamp;
    private final BitableStatisticEventModel$NormalPointType type;
    private final boolean unique;

    public static final class a {
        public a() {
        }

        public static BitableStatisticEventModel$NormalPointModel a(long r10, String r12) {
            Intrinsics.checkNotNullParameter(r12, "name");
            return new BitableStatisticEventModel$NormalPointModel(r12, r10, true, BitableStatisticEventModel$NormalPointType.INIT_POINT, null, 16, null);
        }

        public static BitableStatisticEventModel$NormalPointModel b(String r10, long r11, boolean r13, HashMap r14) {
            Intrinsics.checkNotNullParameter(r10, "name");
            return new BitableStatisticEventModel$NormalPointModel(r10, r11, r13, null, r14, 8, null);
        }

        public static BitableStatisticEventModel$NormalPointModel d(String r10, long r11, boolean r13, boolean r14) {
            Intrinsics.checkNotNullParameter(r10, "name");
            if (r14 == false) goto L5;
            BitableStatisticEventModel$NormalPointType r16 = BitableStatisticEventModel$NormalPointType.TEMP_POINT_TRIGGER;
        L7:
            return new BitableStatisticEventModel$NormalPointModel(r10, r11, r13, r16, null, 16, null);
        L5:
            r16 = BitableStatisticEventModel$NormalPointType.TEMP_POINT;
            goto L7
        }

        public static /* synthetic */ BitableStatisticEventModel$NormalPointModel c(a r0, String r1, long r2, boolean r4, int r5) {
            if ((r5 & 4) == 0) goto L5;
            r4 = true;
        L5:
            r0.getClass();
            return b(r1, r2, r4, null);
        }

        public static /* synthetic */ BitableStatisticEventModel$NormalPointModel e(a r1, String r2, long r3, boolean r5, int r6) {
            if ((r6 & 8) == 0) goto L5;
            r5 = false;
        L5:
            r1.getClass();
            return d(r2, r3, false, r5);
        }
    }

    static {
        Companion = new a();
    }

    public BitableStatisticEventModel$NormalPointModel() {
        throw null;
    }

    public final boolean isTempPoint() {
        BitableStatisticEventModel$NormalPointType r0 = this.type;
        if (r0 != BitableStatisticEventModel$NormalPointType.TEMP_POINT) goto L5;
    L8:
        return true;
    L5:
        if (r0 == BitableStatisticEventModel$NormalPointType.TEMP_POINT_TRIGGER) goto L8;
        return false;
    }

    public final HashMap<String, Serializable> getExtras() {
        return this.mExtras;
    }

    public final String getName() {
        return this.name;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final BitableStatisticEventModel$NormalPointType getType() {
        return this.type;
    }

    public final boolean getUnique() {
        return this.unique;
    }

    public final void addExtras(Map<String, ? extends Object> r4) {
        if (r4 == null) goto L9;
        Iterator<Map.Entry<String, ? extends Object>> r5 = r4.entrySet().iterator();
    L5:
        if (r5.hasNext() == false) goto L15;
        Map.Entry<String, ? extends Object> r0 = r5.next();
        Object r1 = r0.getValue();
        if ((r1 instanceof Serializable) == false) goto L5;
        addExtra(r0.getKey(), (Serializable) r1);
        goto L5
    L15:
        return;
    }

    public final void addExtra(String r2, Serializable r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        if (this.mExtras != null) goto L5;
        this.mExtras = new HashMap();
    L5:
        HashMap<String, Serializable> r0 = this.mExtras;
        if (r0 == null) goto L9;
        r0.put(r2, r3);
        return;
    }

    public BitableStatisticEventModel$NormalPointModel(String r1, long r2, boolean r4, BitableStatisticEventModel$NormalPointType r5, HashMap r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 4) == 0) goto L6;
        r4 = true;
    L6:
        if ((r7 & 8) == 0) goto L9;
        r5 = BitableStatisticEventModel$NormalPointType.POINT;
    L9:
        if ((r7 & 16) == 0) goto L11;
        r6 = null;
    L11:
        this.name = r1;
        this.timestamp = r2;
        this.unique = r4;
        this.type = r5;
        this.mExtras = r6;
    }
}
