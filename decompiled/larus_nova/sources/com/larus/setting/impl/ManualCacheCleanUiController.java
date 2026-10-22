package com.larus.setting.impl;

import android.content.Context;
import android.os.SystemClock;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.disk.api.IAppDiskService;
import com.larus.disk.api.ManualCacheCleanError;
import com.larus.disk.api.ManualCacheCleanStatus;
import com.larus.nova.R;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import tx9.r;

/* JADX INFO: loaded from: classes31.dex */
public final class ManualCacheCleanUiController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ManualCacheCleanUiController f367966a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f367967b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.disk.api.j f367968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f367969b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f367968a, r101.f367968a) == true) goto L12;
            return false;
        L12:
            if (this.f367969b == r101.f367969b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            com.larus.disk.api.j r100 = this.f367968a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            long r102 = this.f367969b;
            return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ManualCleanOutcome(result=" + this.f367968a + ", failedRemainingBytes=" + this.f367969b + ')';
        }

        public a(com.larus.disk.api.j r100, long r101) {
            this.f367968a = r100;
            this.f367969b = r101;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f367970a = null;

        static {
            int[] r100 = new int[ManualCacheCleanStatus.values().length];
            r100[ManualCacheCleanStatus.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[ManualCacheCleanStatus.PARTIAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[ManualCacheCleanStatus.TASK_RUNNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[ManualCacheCleanStatus.DISABLED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[ManualCacheCleanStatus.FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f367970a = r100;
        }
    }

    public ManualCacheCleanUiController() {
    }

    static {
        f367966a = new ManualCacheCleanUiController();
        f367967b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static long d() {
        e10 r100 = e10.f368561a;
        Long r101 = Long.valueOf(e10.u().C());
        if (r101.longValue() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = null;
    L9:
        if (r101 == null) goto L11;
        long r103 = r101.longValue();
    L12:
        long r104 = r103;
        return TimeUnit.SECONDS.toMillis(RangesKt.coerceIn(r104, 1, 600));
    L11:
        r103 = 120;
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    public final Object e(Continuation<? super Long> r110) {
        if ((r110 instanceof ManualCacheCleanUiController$queryCacheSize$1) == false) goto L7;
        ManualCacheCleanUiController$queryCacheSize$1 r100 = (ManualCacheCleanUiController$queryCacheSize$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 != 1) goto L15;
        long r104 = r100.J$0;
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L26 CancellationException -> L29
    L22:
        if (((Long) r111) != null) goto L24;
        FLogger.f375446a.w("ManualCacheCleanUi", "manual cache size query timeout timeoutMs=" + r104);     // Catch: Exception -> L26 CancellationException -> L29
    L24:
    L33:
        return (Long) r111;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r111);
        long r105 = d();     // Catch: Exception -> L26 CancellationException -> L29
        ManualCacheCleanUiController$queryCacheSize$2 r112 = new ManualCacheCleanUiController$queryCacheSize$2(null);     // Catch: Exception -> L26 CancellationException -> L29
        r100.J$0 = r105;     // Catch: Exception -> L26 CancellationException -> L29
        r100.label = 1;     // Catch: Exception -> L26 CancellationException -> L29
        r111 = TimeoutKt.c(r105, r112, r100);     // Catch: Exception -> L26 CancellationException -> L29
        if (r111 != r102) goto L20;
        return r102;
    L20:
        r104 = r105;
    L29:
        e = move-exception;
        throw e;
    L26:
        e = move-exception;
        FLogger.f375446a.e("ManualCacheCleanUi", "query manual cache size failed", e);
        return null;
    L7:
        r100 = new ManualCacheCleanUiController$queryCacheSize$1(this, r110);
        goto L8
    }

    public static void f(ItemTextArrow r100, long r101, Function1 r102) {
        if (r101 <= 0) goto L5;
        boolean r103 = true;
    L6:
        r100.setEnabled(true);
        r100.setClickable(true);
        r100.setStyle(1);
        if (r103 == false) goto L9;
        String r104 = (String) r102.invoke(Long.valueOf(r101));
    L10:
        r100.Z5(r104, null);
        return;
    L9:
        r104 = "";
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    public static final Object b(ManualCacheCleanUiController r210, long r211, String r212, String r213, long r310, Continuation r311) {
        String r100 = r212;
        r210.getClass();
        if ((r311 instanceof ManualCacheCleanUiController$executeAndReportClean$1) == false) goto L7;
        ManualCacheCleanUiController$executeAndReportClean$1 r101 = (ManualCacheCleanUiController$executeAndReportClean$1) r311;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        Long r107 = null;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        long r108 = r101.J$1;
        long r109 = r101.J$0;
        com.larus.disk.api.j r110 = (com.larus.disk.api.j) r101.L$2;
        String r111 = (String) r101.L$1;
        String r112 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L46:
        Long r113 = (Long) r103;
        if (r113 == null) goto L49;
        String r114 = r111;
        long r115 = r113.longValue();
    L126:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L116
        if (r110 == null) goto L62;
        Long r117 = Boxing.boxLong(r110.f330540b);     // Catch: Throwable -> L116
        if (r117.longValue() < 0) goto L56;
        boolean r118 = true;
    L57:
        if (r118 == true) goto L60;
        r117 = null;
    L60:
        if (r117 == null) goto L62;
        r109 = r117.longValue();     // Catch: Throwable -> L116
        goto L62
    L56:
        r118 = false;
    L62:
        if (r110 == null) goto L71;
        Long r119 = Boxing.boxLong(r110.f330541c);     // Catch: Throwable -> L116
        if (r119.longValue() < 0) goto L66;
        boolean r120 = true;
    L67:
        if (r120 == true) goto L70;
        r119 = null;
    L70:
        if (r119 == null) goto L71;
    L76:
        Long r214 = r119;
    L78:
        if (r110 == null) goto L81;
        ManualCacheCleanError r121 = r110.f330543e;     // Catch: Throwable -> L116
        if (r121 == null) goto L81;
    L82:
        if (r110 == null) goto L89;
        ManualCacheCleanStatus r122 = r110.f330539a;     // Catch: Throwable -> L116
        if (r122 == null) goto L89;
        String r123 = r122.name();     // Catch: Throwable -> L116
        if (r123 == null) goto L89;
        String r124 = r123.toLowerCase(Locale.US);     // Catch: Throwable -> L116
        if (r124 == null) goto L89;
    L91:
        if (r109 < 0) goto L94;
        if (r214 == null) goto L94;
        r107 = Boxing.boxLong(RangesKt.coerceAtLeast(r109 - r214.longValue(), 0));     // Catch: Throwable -> L116
    L94:
        Long r215 = r107;
        long r125 = SystemClock.elapsedRealtime() - r108;     // Catch: Throwable -> L116
        if (r110 == null) goto L104;
        String r126 = r110.f330542d;     // Catch: Throwable -> L116
        if (r126 == null) goto L104;
        if (StringsKt.isBlank(r126) == false) goto L101;
        r126 = r112;
    L101:
        if (r126 == null) goto L104;
        String r127 = r126;
    L105:
        String r128 = r121.getCode();     // Catch: Throwable -> L116
        String r129 = r121.getReason();     // Catch: Throwable -> L116
        String r130 = r121.getStage();     // Catch: Throwable -> L116
        if (r110 == null) goto L109;
        String r131 = r110.f330544f;     // Catch: Throwable -> L116
        if (r131 == null) goto L109;
    L110:
        long r132 = r115;
        r.a(r124, r125, r127, r128, r129, r130, r131, r114, Boxing.boxLong(r109), r214, r215);     // Catch: Throwable -> L114
        Object r133 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L114
    L119:
        Throwable r134 = Result.m9452exceptionOrNullimpl(r133);
        if (r134 == null) goto L123;
        FLogger.f375446a.e("ManualCacheCleanUi", "report manual cache clean result failed", r134);
    L123:
        return new a(r110, r132);
    L114:
        th = th;
    L118:
        Result.Companion r135 = Result.Companion;
        r133 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L109:
        r131 = "execution";
    L104:
        r127 = r112;
    L89:
        r124 = "failed";
    L81:
        r121 = ManualCacheCleanError.EXECUTION_FAILED;     // Catch: Throwable -> L116
        goto L82
    L66:
        r120 = false;
    L71:
        r119 = Boxing.boxLong(r115);     // Catch: Throwable -> L116
        if (r119.longValue() >= 0) goto L75;
        r106 = false;
    L75:
        if (r106 == true) goto L76;
        r214 = null;
    L116:
        th = th;
        r132 = r115;
        goto L118
    L49:
        long r136 = r108;
        r100 = r112;
        com.larus.disk.api.j r137 = r110;
        String r138 = r111;
        long r139 = r109;
    L50:
        r110 = r137;
        r115 = -1;
        r114 = r138;
        r109 = r139;
        r112 = r100;
        r108 = r136;
        goto L126
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r140 = r101.J$1;
        long r141 = r101.J$0;
        String r142 = (String) r101.L$1;
        String r143 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L18
        r138 = r142;
        r100 = r143;
        r139 = r141;
        r136 = r140;
    L30:
        r137 = (com.larus.disk.api.j) r103;     // Catch: Exception -> L32
    L41:
        if (r137 != null) goto L50;
        r101.L$0 = r100;
        r101.L$1 = r138;
        r101.L$2 = r137;
        r101.J$0 = r139;
        r101.J$1 = r136;
        r101.label = 2;
        Object r144 = r210.e(r101);
        if (r144 == r104) goto L139;
        r110 = r137;
        r103 = r144;
        r112 = r100;
        r108 = r136;
        long r216 = r139;
        r111 = r138;
        r109 = r216;
        goto L46
    L139:
        return r104;
    L32:
        e = e;
    L40:
        FLogger.f375446a.e("ManualCacheCleanUi", "manual cache clean failed", e);
        r137 = null;
    L18:
        e = e;
        r138 = r142;
        r100 = r143;
        r139 = r141;
        r136 = r140;
        goto L40
    L20:
        ResultKt.throwOnFailure(r103);
        IAppDiskService.Companion r145 = IAppDiskService.f330510a;     // Catch: Exception -> L38
        r101.L$0 = r100;     // Catch: Exception -> L38
        r138 = r213;
        r101.L$1 = r138;     // Catch: Exception -> L36
        r139 = r211;
        r101.J$0 = r139;     // Catch: Exception -> L34
        r136 = r310;
        r101.J$1 = r136;     // Catch: Exception -> L32
        r101.label = 1;     // Catch: Exception -> L32
        r103 = r145.b(r100, r101);     // Catch: Exception -> L32
        if (r103 != r104) goto L30;
        return r104;
    L34:
        e = e;
    L35:
        r136 = r310;
    L36:
        e = e;
        r139 = r211;
    L38:
        e = e;
        r139 = r211;
        r138 = r213;
    L7:
        r101 = new ManualCacheCleanUiController$executeAndReportClean$1(r210, r311);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, kotlinx.coroutines.Job] */
    public static final void c(Ref.ObjectRef<Job> r110, Fragment r111, ItemTextArrow r112, Function1<? super Long, String> r113, String r114, by7.e r115, boolean r116) {
        r110.element = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r111.getViewLifecycleOwner()), null, null, new ManualCacheCleanUiController$bind$launchCacheSizeQuery$1(r112, r116, r111, r113, r110, r114, r115, null), 3, null);
    }

    public static final Object a(ManualCacheCleanUiController r210, Fragment r211, ItemTextArrow r212, long r213, String r214, String r215, Function1 r216, Continuation r217) {
        r210.getClass();
        if ((r217 instanceof ManualCacheCleanUiController$clean$1) == false) goto L7;
        ManualCacheCleanUiController$clean$1 r100 = (ManualCacheCleanUiController$clean$1) r217;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        long r105 = r100.J$0;
        Function1 r106 = (Function1) r100.L$3;
        String r107 = (String) r100.L$2;
        ItemTextArrow r108 = (ItemTextArrow) r100.L$1;
        Fragment r109 = (Fragment) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14
        Function1 r110 = r106;
        Object r111 = r102;
        String r112 = r107;
        long r113 = r105;
        ItemTextArrow r114 = r108;
        Fragment r115 = r109;
    L26:
        a r116 = (a) r111;     // Catch: Throwable -> L93
        if (JobKt.isActive(r100.getContext()) == false) goto L33;
        if (r115.isAdded() == false) goto L33;
        r114.V5();
    L33:
        if (r116 != null) goto L41;
        FLogger.f375446a.w("ManualCacheCleanUi", "manual cache clean UI wait timeout operationId=" + r112 + " timeoutMs=" + r113);
        if (JobKt.isActive(r100.getContext()) == false) goto L114;
        if (r115.isAdded() == false) goto L114;
        t19.s r117 = t19.s.f544207a;
        Context r118 = r115.getContext();
        r117.getClass();
        t19.s.b(r118, R.string.larus_infra_clearCache_toast_clearFail, false);
    L114:
        return Unit.INSTANCE;
    L41:
        if (JobKt.isActive(r100.getContext()) == false) goto L92;
        if (r115.isAdded() == false) goto L92;
        com.larus.disk.api.j r119 = r116.f367968a;
        if (r119 != null) goto L51;
        long r120 = r116.f367969b;
        if (r120 < 0) goto L50;
        f(r114, r120, r110);
    L50:
        t19.s r121 = t19.s.f544207a;
        Context r122 = r115.getContext();
        r121.getClass();
        t19.s.b(r122, R.string.larus_infra_clearCache_toast_clearFail, false);
        return Unit.INSTANCE;
    L51:
        long r123 = r119.f330540b;
        if (r123 < 0) goto L58;
        long r124 = r119.f330541c;
        if (r124 < 0) goto L58;
        if (r124 >= r123) goto L58;
        boolean r125 = true;
    L60:
        if (r119.f330539a != ManualCacheCleanStatus.PARTIAL) goto L63;
        if (r125 == false) goto L63;
        long r126 = 0;
    L65:
        if (r126 < 0) goto L67;
        f(r114, r126, r110);
    L67:
        int r127 = b.f367970a[r119.f330539a.ordinal()];
        if (r127 == 1) goto L85;
        if (r127 != 2) goto L72;
        if (r125 == false) goto L83;
        t19.s r128 = t19.s.f544207a;
        Context r129 = r115.getContext();
        r128.getClass();
        t19.s.o(r129, R.string.larus_infra_clearCache_toast_cleared, false);
    L116:
        return Unit.INSTANCE;
    L83:
        t19.s r130 = t19.s.f544207a;
        Context r131 = r115.getContext();
        r130.getClass();
        t19.s.b(r131, R.string.larus_infra_clearCache_toast_clearFail, false);
        goto L116
    L72:
        if (r127 != 3) goto L74;
    L80:
        t19.s r132 = t19.s.f544207a;
        Context r133 = r115.getContext();
        r132.getClass();
        t19.s.b(r133, R.string.larus_infra_clearCache_toast_clearFail, false);
        goto L116
    L74:
        if (r127 == 4) goto L80;
        if (r127 == 5) goto L80;
        throw new NoWhenBranchMatchedException();
    L85:
        if (r119.f330540b <= 0) goto L87;
    L89:
        t19.s r134 = t19.s.f544207a;
        Context r135 = r115.getContext();
        r134.getClass();
        t19.s.o(r135, R.string.larus_infra_clearCache_toast_cleared, false);
        goto L116
    L87:
        if (r119.f330541c > 0) goto L89;
        t19.s.f544207a.g(r115.getContext(), R.string.larus_infra_clearCache_toast_noCache, false);
    L63:
        r126 = r119.f330541c;
    L58:
        r125 = false;
    L92:
        return Unit.INSTANCE;
    L93:
        th = th;
    L100:
        if (JobKt.isActive(r100.getContext()) == true) goto L102;
    L104:
        throw th;
    L102:
        if (r115.isAdded() == false) goto L104;
        r114.V5();
    L14:
        th = th;
        r114 = r108;
        r115 = r109;
        goto L100
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        long r136 = SystemClock.elapsedRealtime();
        r212.c6();
        Deferred r137 = BuildersKt.async$default(f367967b, null, null, new ManualCacheCleanUiController$clean$terminalTask$1(r213, r214, r215, r136, null), 3, null);
        r113 = d();
        ManualCacheCleanUiController$clean$outcome$1 r138 = new ManualCacheCleanUiController$clean$outcome$1(r137, null);     // Catch: Throwable -> L97
        r115 = r211;
        r100.L$0 = r115;     // Catch: Throwable -> L95
        r114 = r212;
        r100.L$1 = r114;     // Catch: Throwable -> L93
        r112 = r214;
        r100.L$2 = r112;     // Catch: Throwable -> L93
        r110 = r216;
        r100.L$3 = r110;     // Catch: Throwable -> L93
        r100.J$0 = r113;     // Catch: Throwable -> L93
        r100.label = 1;     // Catch: Throwable -> L93
        r111 = TimeoutKt.c(r113, r138, r100);     // Catch: Throwable -> L93
        if (r111 != r103) goto L26;
        return r103;
    L95:
        th = th;
    L96:
        r114 = r212;
    L97:
        th = th;
        r115 = r211;
    L7:
        r100 = new ManualCacheCleanUiController$clean$1(r210, r217);
        goto L8
    }
}
