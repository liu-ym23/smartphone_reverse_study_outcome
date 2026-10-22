package com.bytedance.android.shopping.mall.homepage.opt;

import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.ability.e0;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class MallDrainageOpt {
    public static final Lazy f = null;
    public static String g;
    public static final a h = null;
    public final String a;
    public boolean b;
    public final Lazy c;
    public final Lazy d;
    public final Map<String, Object> e;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.opt.MallDrainageOpt$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/opt/MallDrainageOpt$a$a;", "", "", "delayTime", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "", "delayHeader", "Ljava/lang/Integer;", "getDelayHeader", "()Ljava/lang/Integer;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0104a {

            @SerializedName("delay_draw_header")
            private final Integer delayHeader;

            @SerializedName("delay_to_top_time")
            private final Long delayTime;

            public C0104a() {
                this(0);
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof C0104a) == false) goto L10;
                C0104a r4 = (C0104a) r3;
                if (Intrinsics.areEqual(this.delayTime, r4.delayTime) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.delayHeader, r4.delayHeader) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public final int hashCode() {
                Long r0 = this.delayTime;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                Integer r4 = this.delayHeader;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "GylPinToTopParams(delayTime=" + this.delayTime + ", delayHeader=" + this.delayHeader + ")";
            }

            public final Long a() {
                return this.delayTime;
            }

            public C0104a(int r3) {
                this.delayTime = 500L;
                this.delayHeader = null;
            }
        }

        public a() {
        }
    }

    public MallDrainageOpt() {
        throw null;
    }

    static {
        h = new a();
        f = LazyKt.lazy(MallDrainageOpt$Companion$isNeedGulPinToTop$2.INSTANCE);
    }

    public MallDrainageOpt(Map r3) {
        this.e = r3;
        this.c = LazyKt.lazy(MallDrainageOpt$service$2.INSTANCE);
        this.d = LazyKt.lazy(MallDrainageOpt$nativeGylTop$2.INSTANCE);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        Object r4 = r3.get("mall_lynx_config");     // Catch: Throwable -> L16
        Object r1 = null;
        if ((r4 instanceof Map) == true) goto L6;
        r4 = null;
    L6:
        Map r5 = (Map) r4;     // Catch: Throwable -> L16
        if (r5 == null) goto L9;
        Object r6 = r5.get("gyl_pin_to_top_native");     // Catch: Throwable -> L16
    L11:
        if ((r6 instanceof String) == false) goto L14;
        r1 = r6;
    L14:
        this.a = (String) r1;     // Catch: Throwable -> L16
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
        return;
    L9:
        r6 = null;
    L16:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final void a(ECHybridListEngine r9) {
        if (this.b == false) goto L5;
        return;
    L5:
        this.b = true;
        long r1 = System.currentTimeMillis();
        e0 r10 = (e0) r9.getAbility(e0.class);
        Object r3 = null;
        if (r10 == null) goto L8;
        r10.a("favorite_section", 0, true, null);
    L8:
        long r5 = System.currentTimeMillis();
        Object r11 = this.e.get("delivery_session_id");
        if ((r11 instanceof String) == false) goto L12;
        r3 = r11;
    L12:
        String r4 = (String) r3;
        if (r4 != null) goto L15;
    L18:
        boolean r12 = true;
    L19:
        if (r12 == true) goto L26;
        Map<String, ? extends Object> r13 = MapsKt.mapOf(new Pair[]{TuplesKt.to("request_show_start_time", Long.valueOf(r1)), TuplesKt.to("request_show_end_time", Long.valueOf(r5))});
        y93.b r2 = (y93.b) this.c.getValue();
        if (r2 == null) goto L25;
        r2.g(r4, true, r13);
        return;
    L25:
        return;
    L26:
        return;
    L15:
        if (r4.length() == 0) goto L18;
        r12 = false;
        goto L19
    }
}
