package com.bytedance.android.shopping.api.mall.common.feed.help;

import android.os.Handler;
import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.shopping.api.mall.model.ImpressionItem;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallCommonImpressionReportHelper {
    public static final Lazy k = null;
    public static final a l = null;
    public final Handler a;
    public final Set<ImpressionItem> b;
    public List<ImpressionItem> c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public final ECMallCommonImpressionReportHelper$pollingRunnable$1 h;
    public final b i;
    public final Function0<ECHybridDataEngine> j;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final boolean a;
        public final long b;
        public final int c;
        public final boolean d;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L14;
            b r7 = (b) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L10;
            return false;
        L10:
            if (this.c == r7.c) goto L12;
            return false;
        L12:
            if (this.d == r7.d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public final int hashCode() {
            boolean r0 = this.a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            long r3 = this.b;
            int r4 = ((((r2 * 31) + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.c) * 31;
            boolean r5 = this.d;
            if (r5 == true) goto L10;
            r1 = r5;
        L10:
            return r4 + r1;
        }

        public final String toString() {
            return "ECMallCommonImpressionReportConfig(enable=" + this.a + ", intervalMs=" + this.b + ", threshold=" + this.c + ", flushOnInvisible=" + this.d + ")";
        }

        public b(long r2, int r4, boolean r5) {
            this.a = true;
            this.b = r2;
            this.c = r4;
            this.d = r5;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/feed/help/ECMallCommonImpressionReportHelper$c;", "", "", "", "pageNames", "Ljava/util/List;", "getPageNames", "()Ljava/util/List;", "", "intervalMs", "J", "b", "()J", "", "threshold", "I", "c", "()I", "", "flushOnInvisible", "Z", "a", "()Z", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("flush_on_invisible")
        private final boolean flushOnInvisible;

        @SerializedName("interval_ms")
        private final long intervalMs;

        @SerializedName("page_names")
        private final List<String> pageNames;

        @SerializedName("threshold")
        private final int threshold;

        public c() {
            this(null);
        }

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof c) == false) goto L14;
            c r7 = (c) r6;
            if (Intrinsics.areEqual(this.pageNames, r7.pageNames) == true) goto L8;
            return false;
        L8:
            if (this.intervalMs == r7.intervalMs) goto L10;
            return false;
        L10:
            if (this.threshold == r7.threshold) goto L12;
            return false;
        L12:
            if (this.flushOnInvisible == r7.flushOnInvisible) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            List<String> r0 = this.pageNames;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L6:
            long r2 = this.intervalMs;
            int r3 = ((((r1 * 31) + ((int) (r2 ^ (r2 >>> 32)))) * 31) + this.threshold) * 31;
            boolean r4 = this.flushOnInvisible;
            ?? r5 = r4;
            if (r4 == false) goto L10;
            r5 = 1;
        L10:
            return r3 + r5;
        L5:
            r1 = 0;
            goto L6
        }

        public final String toString() {
            return "ECMallCommonImpressionReportSetting(pageNames=" + this.pageNames + ", intervalMs=" + this.intervalMs + ", threshold=" + this.threshold + ", flushOnInvisible=" + this.flushOnInvisible + ")";
        }

        public final boolean a() {
            return this.flushOnInvisible;
        }

        public final long b() {
            return this.intervalMs;
        }

        public final int c() {
            return this.threshold;
        }

        public c(Object r3) {
            this.pageNames = null;
            this.intervalMs = 5000;
            this.threshold = 0;
            this.flushOnInvisible = false;
        }

        public final boolean d(String r3) {
            Intrinsics.checkNotNullParameter(r3, "pageName");
            List<String> r0 = this.pageNames;
            if (r0 != null) goto L5;
        L6:
            List<String> r4 = this.pageNames;
            if (r4 != null) goto L9;
        L11:
            return false;
        L9:
            if (r4.contains("all_page") != true) goto L11;
            return true;
        L5:
            if (r0.contains(r3) != true) goto L6;
            return true;
        }
    }

    static {
        l = new a();
        k = LazyKt.lazy(ECMallCommonImpressionReportHelper$Companion$commonImpressionSetting$2.INSTANCE);
    }

    public ECMallCommonImpressionReportHelper(b r2, Function0<ECHybridDataEngine> r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "dataEngineProvider");
        this.i = r2;
        this.j = r3;
        this.a = t93.a.b();
        this.b = new LinkedHashSet();
        this.c = CollectionsKt.emptyList();
        this.h = new ECMallCommonImpressionReportHelper$pollingRunnable$1(this);
    }

    public static void a(final ECMallCommonImpressionReportHelper r3, boolean r4, boolean r5, final Function0 r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r5 = false;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r6 = null;
    L9:
        if (r3.g == false) goto L13;
        if (r6 == null) goto L38;
        Unit r8 = (Unit) r6.invoke();
        return;
    L38:
        return;
    L13:
        if (r3.b.isEmpty() == false) goto L17;
        if (r6 == null) goto L40;
        Unit r9 = (Unit) r6.invoke();
        return;
    L40:
        return;
    L17:
        if (r3.e == false) goto L23;
        if (r4 == true) goto L20;
        if (r5 == true) goto L20;
    L21:
        if (r6 == null) goto L42;
        Unit r10 = (Unit) r6.invoke();
        return;
    L42:
        return;
    L20:
        r3.f = true;
        goto L21
    L23:
        r3.e = true;
        Set<ImpressionItem> r11 = r3.b;
        final ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r13 = r11.iterator();
    L25:
        if (r13.hasNext() == false) goto L27;
        ImpressionItem r14 = (ImpressionItem) r13.next();
        r12.add(new ImpressionItem(r14.getType(), r14.getId()));
        goto L25
    L27:
        r3.c = r12;
        if (r12.isEmpty() == false) goto L32;
        r3.e = false;
        if (r6 == null) goto L44;
        Unit r15 = (Unit) r6.invoke();
        return;
    L44:
        return;
    L32:
        Function1<Boolean, Unit> r16 = new ECMallCommonImpressionReportHelper$flushCommonImpression$1(r3, r12, r6);
        ECHybridDataEngine r17 = (ECHybridDataEngine) r3.j.invoke();
        if (r17 != null) goto L35;
        r16.invoke(Boolean.FALSE);
        return;
    L35:
        r17.a(CollectionsKt.listOf("common_impression"), new com.bytedance.android.shopping.api.mall.common.feed.help.c(r3, r16));
    }
}
