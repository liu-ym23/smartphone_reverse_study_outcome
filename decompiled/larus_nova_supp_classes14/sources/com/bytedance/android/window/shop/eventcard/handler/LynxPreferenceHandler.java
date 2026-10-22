package com.bytedance.android.window.shop.eventcard.handler;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LynxPreferenceHandler implements a {
    public static final LynxPreferenceHandler a = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/window/shop/eventcard/handler/LynxPreferenceHandler$LynxPreferenceOperation;", "", "", "operation", "Ljava/lang/String;", "getOperation", "()Ljava/lang/String;", "Companion", "a", "GET", "SET", "REMOVE", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LynxPreferenceOperation extends Enum<LynxPreferenceOperation> {
        public static final a Companion = null;
        public static final LynxPreferenceOperation GET = null;
        public static final LynxPreferenceOperation REMOVE = null;
        public static final LynxPreferenceOperation SET = null;
        public static final /* synthetic */ LynxPreferenceOperation[] a = null;
        public static final Map<String, LynxPreferenceOperation> b = null;
        private final String operation;

        public static final class a {
            public a() {
            }
        }

        static {
            int r3 = 0;
            LynxPreferenceOperation r1 = new LynxPreferenceOperation("GET", 0, "get");
            GET = r1;
            LynxPreferenceOperation r2 = new LynxPreferenceOperation("SET", 1, "set");
            SET = r2;
            LynxPreferenceOperation r4 = new LynxPreferenceOperation("REMOVE", 2, "remove");
            REMOVE = r4;
            a = new LynxPreferenceOperation[]{r1, r2, r4};
            Companion = new a();
            LynxPreferenceOperation[] r0 = values();
            LinkedHashMap r5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(r0.length), 16));
            int r6 = r0.length;
        L3:
            if (r3 >= r6) goto L5;
            LynxPreferenceOperation r7 = r0[r3];
            r5.put(r7.operation, r7);
            r3 = r3 + 1;
            goto L3
        L5:
            b = r5;
        }

        public static LynxPreferenceOperation valueOf(String r1) {
            return (LynxPreferenceOperation) r27.a.a(LynxPreferenceOperation.class, r1);
        }

        public static LynxPreferenceOperation[] values() {
            return (LynxPreferenceOperation[]) a.clone();
        }

        public static final /* synthetic */ Map access$getMapping$cp() {
            return b;
        }

        public final String getOperation() {
            return this.operation;
        }

        public LynxPreferenceOperation(String r1, int r2, String r3) {
            super(r1, r2);
            this.operation = r3;
        }
    }

    public LynxPreferenceHandler() {
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final void release() {
    }

    static {
        a = new LynxPreferenceHandler();
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final Map<String, Object> a(int r5, Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Object r7 = r6.get("preference_key");
        LynxPreferenceOperation r1 = null;
        if ((r7 instanceof String) == true) goto L5;
        r7 = null;
    L5:
        String r8 = (String) r7;
        if (r8 == null) goto L8;
        LynxPreferenceOperation.a r0 = LynxPreferenceOperation.Companion;
        Object r2 = r6.get("preference_action");
        if ((r2 instanceof String) == true) goto L12;
        r2 = null;
    L12:
        String r3 = (String) r2;
        r0.getClass();
        if (r3 == null) goto L16;
        r1 = (LynxPreferenceOperation) LynxPreferenceOperation.access$getMapping$cp().get(r3);
    L16:
        if (r1 == null) goto L18;
        int r4 = e.a[r1.ordinal()];
        if (r4 != 1) goto L22;
        ConcurrentHashMap<String, Object> r9 = fp3.a.a;
        Intrinsics.checkNotNullParameter(r8, "key");
        return MapsKt.mapOf(TuplesKt.to(r8, fp3.a.a.get(r8)));
    L22:
        if (r4 != 2) goto L24;
        Object r10 = r6.get("preference_value");
        if (r10 == null) goto L32;
        ConcurrentHashMap<String, Object> r11 = fp3.a.a;
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r10, "value");
        return MapsKt.mapOf(TuplesKt.to(r8, fp3.a.a.put(r8, r10)));
    L32:
        return MapsKt.emptyMap();
    L24:
        if (r4 != 3) goto L28;
        ConcurrentHashMap<String, Object> r12 = fp3.a.a;
        Intrinsics.checkNotNullParameter(r8, "key");
        return MapsKt.mapOf(TuplesKt.to(r8, fp3.a.a.remove(r8)));
    L28:
        throw new NoWhenBranchMatchedException();
    L18:
        return MapsKt.emptyMap();
    L8:
        return MapsKt.emptyMap();
    }
}
