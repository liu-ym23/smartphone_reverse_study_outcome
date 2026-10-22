package com.bytedance.android.shopping.mall.homepage.opt;

import androidx.core.util.Supplier;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.shopping.mall.homepage.ECMallFragment$firstScreenHelp$2;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static final a.C0106a e = null;
    public static final a f = null;
    public final Object a;
    public final Supplier<DataEngineWrapper> b;
    public final Function0<Unit> c;
    public final Function1<String, Unit> d;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.opt.e$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/opt/e$a$a;", "", "", "optPage", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "clearMemoryTime", "a", "homepageDataFromInterceptor", "b", "ignoreStraightOut", "getIgnoreStraightOut", "prefetchImagesFromInterceptor", "getPrefetchImagesFromInterceptor", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0106a {

            @SerializedName("clear_memory_time")
            private final Integer clearMemoryTime;

            @SerializedName("homepage_data_from_interceptor")
            private final Integer homepageDataFromInterceptor;

            @SerializedName("homepage_ignore_straight_out")
            private final Integer ignoreStraightOut;

            @SerializedName("opt_page")
            private final Integer optPage;

            @SerializedName("prefetch_image_from_interceptor")
            private final Integer prefetchImagesFromInterceptor;

            public C0106a() {
                this(0);
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof C0106a) == false) goto L16;
                C0106a r4 = (C0106a) r3;
                if (Intrinsics.areEqual(this.optPage, r4.optPage) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.clearMemoryTime, r4.clearMemoryTime) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.homepageDataFromInterceptor, r4.homepageDataFromInterceptor) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.ignoreStraightOut, r4.ignoreStraightOut) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.prefetchImagesFromInterceptor, r4.prefetchImagesFromInterceptor) == true) goto L25;
                return false;
            L25:
                return true;
            L16:
                return false;
            }

            public final int hashCode() {
                Integer r0 = this.optPage;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                Integer r4 = this.clearMemoryTime;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                Integer r7 = this.homepageDataFromInterceptor;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                Integer r10 = this.ignoreStraightOut;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                Integer r13 = this.prefetchImagesFromInterceptor;
                if (r13 == null) goto L22;
                r1 = r13.hashCode();
            L22:
                return r12 + r1;
            L17:
                r11 = 0;
                goto L18
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "FirstScreenOptData(optPage=" + this.optPage + ", clearMemoryTime=" + this.clearMemoryTime + ", homepageDataFromInterceptor=" + this.homepageDataFromInterceptor + ", ignoreStraightOut=" + this.ignoreStraightOut + ", prefetchImagesFromInterceptor=" + this.prefetchImagesFromInterceptor + ")";
            }

            public final Integer a() {
                return this.clearMemoryTime;
            }

            public final Integer b() {
                return this.homepageDataFromInterceptor;
            }

            public final Integer c() {
                return this.optPage;
            }

            public C0106a(int r5) {
                this.optPage = null;
                this.clearMemoryTime = 0;
                this.homepageDataFromInterceptor = 0;
                this.ignoreStraightOut = 0;
                this.prefetchImagesFromInterceptor = 0;
            }
        }

        public a() {
        }
    }

    public e() {
        throw null;
    }

    static {
        f = new a();
        int r0 = s93.c.a;
        Object r1 = new a.C0106a(0);
        IHybridHostService r2 = com.bytedance.android.ec.hybrid.a.h();
        if (r2 == null) goto L10;
        yj.g r3 = r2.getHostAB();
        if (r3 == null) goto L10;
        Object r4 = r3.a("mall_first_screen_image_and_net_opt", r1);
        if (r4 == null) goto L10;
        r1 = r4;
    L10:
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.c.a.b, "Key : mall_first_screen_image_and_net_opt, Value: " + r1);
        e = (a.C0106a) r1;
    }

    public static boolean a() {
        Integer r0 = e.b();
        if (r0 != null) goto L6;
    L8:
        return false;
    L6:
        if (r0.intValue() != 1) goto L8;
        return true;
    }

    public e(ECMallFragment$firstScreenHelp$2.a r1, Function0 r2, Function1 r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.a = new Object();
    }
}
