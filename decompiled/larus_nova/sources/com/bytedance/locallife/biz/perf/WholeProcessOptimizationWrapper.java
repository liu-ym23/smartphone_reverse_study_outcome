package com.bytedance.locallife.biz.perf;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.ss.android.ugc.aweme.poi.bean.PoiBizCode;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class WholeProcessOptimizationWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WholeProcessOptimizationWrapper f256838a = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/biz/perf/WholeProcessOptimizationWrapper$Code;", "", "", "value", "I", "getValue", "()I", "FAILURE", "SUCCESS", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> {
        public static final Code FAILURE = null;
        public static final Code SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f256839a = null;
        private final int value;

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f256839a.clone();
        }

        static {
            Code r100 = new Code("FAILURE", 0, 0);
            FAILURE = r100;
            Code r101 = new Code("SUCCESS", 1, 1);
            SUCCESS = r101;
            f256839a = new Code[]{r100, r101};
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public interface a {
        void a(Code r100, String r101);
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f256840a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f256841b = null;

        static {
            int[] r100 = new int[PoiBizCode.values().length];
            r100[PoiBizCode.TRIP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L33:
            r100[PoiBizCode.GENERAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L43:
            r100[PoiBizCode.DELIVER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L35:
            r100[PoiBizCode.FOOD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L10:
            f256840a = r100;
            int[] r101 = new int[PageEnum.values().length];
            r101[PageEnum.MALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L39:
            r101[PageEnum.POI.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L27:
            r101[PageEnum.GOODS_DETAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L37:
            r101[PageEnum.CONFIRM_ORDER_PAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L31:
            r101[PageEnum.TRADE_ORDER_DETAIL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L16:
            f256841b = r101;
        }
    }

    static {
        f256838a = new WholeProcessOptimizationWrapper();
    }

    public WholeProcessOptimizationWrapper() {
    }

    public static yv6.a b() {
        int r100 = e.f256846a;
        yv6.b r101 = (yv6.b) HostServiceUtilsKt.g0().a("local_service_opt_settings", yv6.b.class, null);
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.a();
    }

    public static PoiBizCode a(String r100) {
        if (r100 != null) goto L4;
        r100 = "default";
    L4:
        PoiBizCode[] r101 = PoiBizCode.values();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        int r103 = r101.length;     // Catch: Throwable -> L13
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L12;
        PoiBizCode r105 = r101[r104];     // Catch: Throwable -> L13
        if (Intrinsics.areEqual(r105.bizCode, r100) == true) goto L9;
        r104 = r104 + 1;     // Catch: Throwable -> L13
        goto L6
    L9:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r106) == false) goto L18;
        r106 = null;
    L18:
        PoiBizCode r107 = (PoiBizCode) r106;
        if (r107 == null) goto L21;
        return r107;
    L21:
        return PoiBizCode.DEFAULT;
    L12:
        throw new NoSuchElementException("Array contains no element matching the predicate.");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    public final void e(String r100) {
        PoiBizCode r101 = a(r100);
        PageEnum r102 = PageEnum.POI;
        yv6.a r103 = b();
        if (r103 == null) goto L7;
        Boolean r104 = r103.c();
        if (r104 == null) goto L7;
        boolean r105 = r104.booleanValue();
    L8:
        f(this, r101, r102, false, false, Boolean.valueOf(r105), null, 108);
        return;
    L7:
        r105 = false;
        goto L8
    }

    public static List c(String r100, PageEnum r101, String r102, a r103) {
        Intrinsics.checkNotNullParameter(r101, "pageEnum");
        PoiBizCode r104 = a(r100);
        if (r102 != null) goto L5;
        r102 = "default";
    L5:
        yv6.d r105 = d(r104, r101, r102, r103);
        if (r105 == null) goto L11;
        List<String> r106 = r105.b();
        if (r106 == null) goto L11;
        return r106;
    L11:
        return CollectionsKt.emptyList();
    }

    public static yv6.d d(PoiBizCode r100, PageEnum r101, String r102, a r110) {
        int r103 = e.f256846a;
        if (com.bytedance.locallife.biz.experiment.f.b() == false) goto L8;
        yv6.b r104 = (yv6.b) HostServiceUtilsKt.g0().a("local_service_opt_settings", yv6.b.class, null);
        if (r104 == null) goto L8;
        yv6.e r105 = r104.c();
    L9:
        if (r105 != null) goto L13;
        if (r110 == null) goto L12;
        r110.a(Code.FAILURE, "获取不到Settings/Libra配置，请配置。");
    L12:
        return null;
    L13:
        int r106 = b.f256840a[r100.ordinal()];
        if (r106 == 1) goto L22;
        if (r106 == 2) goto L21;
        if (r106 == 3) goto L20;
        if (r106 == 4) goto L19;
        yv6.c r107 = r105.a();
    L23:
        if (r107 != null) goto L27;
        if (r110 == null) goto L26;
        r110.a(Code.FAILURE, "行业字段找不到，default字段也找不到，请检查下配置。");
    L26:
        return null;
    L27:
        int r108 = b.f256841b[r101.ordinal()];
        if (r108 == 1) goto L40;
        if (r108 == 2) goto L39;
        if (r108 == 3) goto L38;
        if (r108 != 4) goto L33;
        List<yv6.d> r109 = r107.a();
    L41:
        if (r109 == null) goto L72;
        Iterator<T> r111 = r109.iterator();
        yv6.d r112 = null;
    L44:
        if (r111.hasNext() == false) goto L66;
        yv6.d r113 = (yv6.d) r111.next();
        if (r113 == null) goto L44;
        List<String> r114 = r113.a();
        if (r114 == null) goto L44;
        Iterator<T> r115 = r114.iterator();
    L51:
        if (r115.hasNext() == false) goto L44;
        String r116 = (String) r115.next();
        List<String> r117 = r113.b();
        if (r117 != null) goto L55;
    L57:
        boolean r118 = false;
    L59:
        if (Intrinsics.areEqual(r102, r116) == false) goto L63;
        if (r118 == false) goto L63;
        return r113;
    L63:
        if (Intrinsics.areEqual("default", r116) == false) goto L51;
        if (r118 == false) goto L51;
        r112 = r113;
        goto L51
    L55:
        if ((!r117.isEmpty()) != true) goto L57;
        r118 = true;
        goto L59
    L66:
        if (r112 == null) goto L70;
        if (r110 == null) goto L69;
        r110.a(Code.SUCCESS, "name找不到，默认使用default配置。");
    L69:
        return r112;
    L70:
        if (r110 == null) goto L72;
        r110.a(Code.FAILURE, "name找不到，default也找不到，请检查下配置。");
    L72:
        return null;
    L33:
        if (r108 != 5) goto L36;
        r109 = r107.e();
        goto L41
    L36:
        throw new NoWhenBranchMatchedException();
    L38:
        r109 = r107.b();
        goto L41
    L39:
        r109 = r107.d();
        goto L41
    L40:
        r109 = r107.c();
        goto L41
    L19:
        r107 = r105.c();
        goto L23
    L20:
        r107 = r105.b();
        goto L23
    L21:
        r107 = r105.d();
        goto L23
    L22:
        r107 = r105.e();
    L8:
        r105 = null;
        goto L9
    }

    public static void f(WholeProcessOptimizationWrapper r100, PoiBizCode r101, PageEnum r102, boolean r103, boolean r104, Boolean r105, a r106, int r110) {
        boolean r107 = false;
        if ((r110 & 4) == 0) goto L6;
        r103 = false;
    L6:
        if ((r110 & 8) == 0) goto L9;
        r104 = false;
    L9:
        if ((r110 & 16) == 0) goto L12;
        r105 = null;
    L12:
        if ((r110 & 64) == 0) goto L14;
        r106 = null;
    L14:
        r100.getClass();
        yv6.d r108 = d(r101, r102, "default", r106);
        if (r108 == null) goto L24;
        j r109 = j.f256854a;
        List<String> r111 = r108.b();
        if (r111 != null) goto L19;
        r111 = CollectionsKt.emptyList();
    L19:
        r109.getClass();
        j.c(PrefetchTiming.ROUTER, r111);
        if (r105 == null) goto L22;
        r107 = r105.booleanValue();
    L22:
        j.a(r103, r104, r107, 200);
        return;
    }
}
