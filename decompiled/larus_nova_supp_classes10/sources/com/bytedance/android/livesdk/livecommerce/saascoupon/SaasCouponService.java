package com.bytedance.android.livesdk.livecommerce.saascoupon;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import bl2.g;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.h;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.sdk.helper.i;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.livesdk.livecommerce.ECLiveCommerceModel_ProvideLiveServiceFactory;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import el2.k;
import el2.l;
import el2.n;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class SaasCouponService implements n {
    public static final /* synthetic */ int B = 0;
    public final Lazy A;
    public k a;
    public final dl2.e b;
    public final g c;
    public final Handler d;
    public final Lazy e;
    public final int f;
    public boolean g;
    public bl2.e h;
    public boolean i;
    public WeakReference<Context> j;
    public Function1<? super JSONObject, Unit> k;
    public com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.a l;
    public final Lazy m;
    public final Lazy n;
    public Function0<LiveRoomParams> o;
    public boolean p;
    public final Lazy q;
    public Runnable r;
    public Runnable s;
    public Runnable t;
    public Disposable u;
    public final CompositeDisposable v;
    public final int w;
    public String x;
    public int y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SaasCouponService a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public b(SaasCouponService r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r11) {
            bl2.b r12 = (bl2.b) r11;
            if (r12 != null) goto L5;
        L100:
            this.a.b(Boolean.FALSE, 2);
            return;
        L5:
            if (r12.a() != 0) goto L100;
            bl2.e r1 = r12.e();
            el.a r2 = null;
            if (r1 == null) goto L10;
            bl2.d r3 = r1.d();
        L11:
            long r4 = 0;
            if (r3 == null) goto L62;
            bl2.e r5 = r12.e();
            if (r5 == null) goto L16;
            List<bl2.c> r6 = r5.a();
        L17:
            if (r6 == null) goto L62;
            if (this.a.i == true) goto L110;
            bl2.e r7 = r12.e();
            if (r7 == null) goto L25;
            long r8 = r7.b();
        L27:
            if (r8 >= 0) goto L29;
            this.a.b(Boolean.FALSE, 2);
        L29:
            this.a.b(Boolean.TRUE, null);
            this.a.h = r12.e();
            bl2.e r0 = r12.e();
            if (r0 == null) goto L53;
            List<bl2.c> r9 = r0.a();
            if (r9 == null) goto L53;
            Iterator<bl2.c> r10 = r9.iterator();
        L35:
            if (r10.hasNext() == false) goto L53;
            bl2.c r13 = r10.next();
            String r14 = r13.k();
            if (r14 == null) goto L39;
            g r15 = this.a.c;
            r15.getClass();
            Intrinsics.checkNotNullParameter(r14, "<set-?>");
            r15.m = r14;
        L39:
            String r16 = r13.j();
            if (r16 == null) goto L42;
            g r17 = this.a.c;
            r17.getClass();
            Intrinsics.checkNotNullParameter(r16, "<set-?>");
            r17.l = r16;
        L42:
            String r18 = r13.d();
            if (r18 == null) goto L45;
            g r19 = this.a.c;
            r19.getClass();
            Intrinsics.checkNotNullParameter(r18, "<set-?>");
            r19.c = r18;
        L45:
            String r20 = r13.c();
            if (r20 == null) goto L48;
            g r21 = this.a.c;
            r21.getClass();
            Intrinsics.checkNotNullParameter(r20, "<set-?>");
            r21.n = r20;
        L48:
            String r22 = r13.e();
            if (r22 == null) goto L51;
            g r23 = this.a.c;
            r23.getClass();
            Intrinsics.checkNotNullParameter(r22, "<set-?>");
            r23.o = r22;
        L51:
            this.a.c.k = r13.h();
        L53:
            if (this.b == false) goto L55;
        L57:
            bl2.e r110 = r12.e();
            if (r110 == null) goto L60;
            r4 = r110.b();
        L60:
            r4 = r4 * 1000;
        L61:
            SaasCouponService r111 = this.a;
            r111.d.postDelayed((Runnable) r111.q.getValue(), r4);
            return;
        L55:
            if (this.c == false) goto L57;
        L25:
            r8 = 0;
            goto L27
        L110:
            return;
        L16:
            r6 = null;
        L62:
            el.b r24 = r12.d();
            boolean r25 = true;
            if (r24 != null) goto L65;
        L75:
            el.a r26 = r12.c();
            if (r26 == null) goto L92;
            if (EComABUtils.enableLiveExpansionCoupon() == true) goto L80;
        L86:
            r25 = false;
        L87:
            if (r25 == false) goto L89;
            r2 = r26;
        L89:
            if (r2 == null) goto L92;
            SaasCouponService r112 = this.a;
            d r27 = new d(r2, this);
            r112.s = r27;
            r112.d.postDelayed(r27, r2.c());
            return;
        L80:
            if (r26.a() == null) goto L86;
            if (r26.b() == null) goto L86;
            if (r26.c() <= 0) goto L86;
        L92:
            if (this.b == false) goto L94;
        L96:
            this.a.b(Boolean.FALSE, 2);
        L97:
            String r113 = r12.f();
            if (r113 == null) goto L108;
            SaasCouponService.c(this.a, r113);
            return;
        L108:
            return;
        L94:
            if (this.c == true) goto L96;
            this.a.b(Boolean.FALSE, 3);
            goto L97
        L65:
            if (r24.a() != null) goto L67;
        L69:
            boolean r28 = false;
        L70:
            if (r28 == true) goto L73;
            r24 = null;
        L73:
            if (r24 == null) goto L75;
            SaasCouponService r29 = this.a;
            com.bytedance.android.livesdk.livecommerce.saascoupon.c r30 = new com.bytedance.android.livesdk.livecommerce.saascoupon.c(r24, this, r12);
            r29.r = r30;
            r29.d.postDelayed(r30, ((Number) r29.m.getValue()).longValue());
            return;
        L67:
            if (r24.b() == null) goto L69;
            r28 = true;
            goto L70
        L10:
            r3 = null;
            goto L11
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ SaasCouponService a;

        public c(SaasCouponService r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            this.a.b(Boolean.FALSE, 2);
        }
    }

    static {
    }

    public final boolean g() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    public final int d() {
        if (this.y != (-1)) goto L6;
        this.y = q.a.getInt("saascoupon_show_toast_count_daily", 0);
    L6:
        return this.y;
    }

    @Override // el2.n
    public final void destroy() {
        ECLiveHybridUtil.p("LIVEROOM_SHOW_SHOT_REDPACK", (j) this.z.getValue());
        ECLiveHybridUtil.p("LIVEROOM_OPEN_PRODUCT_LIST", (j) this.A.getValue());
        this.v.clear();
        Disposable r0 = this.u;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.u = null;
        this.d.removeCallbacks((Runnable) this.q.getValue());
        Runnable r1 = this.r;
        if (r1 == null) goto L8;
        this.d.removeCallbacks(r1);
    L8:
        Runnable r2 = this.s;
        if (r2 == null) goto L11;
        this.d.removeCallbacks(r2);
    L11:
        Runnable r3 = this.t;
        if (r3 == null) goto L14;
        this.d.removeCallbacks(r3);
    L14:
        com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.a r4 = this.l;
        if (r4 == null) goto L17;
        r4.a(false);
    L17:
        this.h = null;
        WeakReference<Context> r5 = this.j;
        if (r5 == null) goto L20;
        r5.clear();
    L20:
        this.k = null;
        this.o = null;
        al2.a.a = "";
        al2.a.b = "";
        al2.a.c = "";
        al2.a.d = 0;
    }

    public final boolean f() {
        WeakReference<Context> r0 = this.j;
        Lifecycle.State r1 = null;
        if (r0 == null) goto L5;
        Context r2 = r0.get();
    L7:
        if ((r2 instanceof FragmentActivity) == true) goto L9;
        r2 = null;
    L9:
        FragmentActivity r3 = (FragmentActivity) r2;
        if (r3 == null) goto L15;
        Lifecycle r4 = r3.getLifecycle();
        if (r4 == null) goto L15;
        r1 = r4.getCurrentState();
    L15:
        if (r1 != Lifecycle.State.RESUMED) goto L17;
        return true;
    L17:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    public SaasCouponService() {
        this.b = new dl2.e();
        this.c = new g();
        this.d = new Handler(Looper.getMainLooper());
        this.e = LazyKt.lazy(SaasCouponService$isStartLogin$2.INSTANCE);
        int r0 = com.bytedance.android.ec.core.abtest.j.a;
        Object r1 = 0;
        int r2 = com.bytedance.android.ec.base.settings.b.a;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L165
        h.a();     // Catch: Throwable -> L165
        SDKSettingsCacheManager r4 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L165
        Object r5 = null;
        r4.getClass();     // Catch: Throwable -> L56
        Object r6 = SDKSettingsCacheManager.b.get("pre_init_is_start_login");     // Catch: Throwable -> L56
        if (r6 != null) goto L11;
    L53:
        Object r7 = null;
    L54:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L56
    L58:
        Throwable r9 = Result.exceptionOrNull-impl(r8);     // Catch: Throwable -> L165
        if (r9 == null) goto L62;
        EnsureManager.ensureNotReachHere(r9);     // Catch: Throwable -> L165
    L62:
        if (Result.isFailure-impl(r8) == false) goto L65;
        r8 = null;
    L65:
        if ((r8 instanceof Integer) == true) goto L67;
        r8 = null;
    L67:
        Object r10 = (Integer) r8;     // Catch: Throwable -> L165
        if (r10 != null) goto L74;
        r4.getClass();     // Catch: Throwable -> L165
        Object r11 = SDKSettingsCacheManager.a.get("pre_init_is_start_login");     // Catch: Throwable -> L165
        if ((r11 instanceof Integer) == true) goto L73;
        r11 = null;
    L73:
        r10 = (Integer) r11;     // Catch: Throwable -> L165
    L74:
        if (r10 != null) goto L174;
        int r12 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L165
    L153:
        th = move-exception;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L165
        Object r14 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L156:
        if (Result.exceptionOrNull-impl(r14) != null) goto L186;
    L157:
        r10 = r14;
    L163:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L165
        SDKSettingsCacheManager.e("pre_init_is_start_login", r10);     // Catch: Throwable -> L165
        goto L174
    L186:
        r14 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("pre_init_is_start_login", Integer.class, r1);     // Catch: Throwable -> L160
    L161:
        if (r14 != null) goto L157;
        r10 = r1;
    L160:
        r14 = r1;
        goto L161
    L176:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L127
        Object r15 = SDKSettingsCacheManager.b.get("pre_init_is_start_login");     // Catch: Throwable -> L127
        if (r15 != null) goto L82;
    L124:
        Object r16 = null;
    L125:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L127
    L129:
        Throwable r18 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L153
        if (r18 == null) goto L133;
        EnsureManager.ensureNotReachHere(r18);     // Catch: Throwable -> L153
    L133:
        if (Result.isFailure-impl(r17) == false) goto L136;
        r17 = null;
    L136:
        if ((r17 instanceof Integer) == true) goto L138;
        r17 = null;
    L138:
        Integer r19 = (Integer) r17;     // Catch: Throwable -> L153
        if (r19 == null) goto L141;
        r10 = r19;
        goto L163
    L141:
        jj4.b r20 = jj4.b.b;     // Catch: Throwable -> L153
        Object r21 = jj4.a.a("pre_init_is_start_login", Integer.class, r1, false);     // Catch: Throwable -> L153
        if (r21 != null) goto L145;
        Intrinsics.throwNpe();     // Catch: Throwable -> L153
    L145:
        if ((r21 instanceof Integer) == false) goto L148;
        r5 = r21;
    L148:
        Object r22 = (Integer) r5;     // Catch: Throwable -> L153
        if (r22 != null) goto L151;
        r22 = r1;
    L151:
        r14 = Result.constructor-impl(r22);     // Catch: Throwable -> L153
    L82:
        if ((r15 instanceof Integer) == true) goto L84;
        Object r23 = null;
    L85:
        r16 = (Integer) r23;     // Catch: Throwable -> L127
        if (r16 != null) goto L125;
        if ((r15 instanceof Number) == false) goto L112;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r24 = Float.valueOf(((Number) r15).floatValue());     // Catch: Throwable -> L127
        if ((r24 instanceof Integer) == true) goto L95;
        r24 = null;
    L95:
        r16 = (Integer) r24;     // Catch: Throwable -> L127
        goto L125
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r25 = Double.valueOf(((Number) r15).doubleValue());     // Catch: Throwable -> L127
        if ((r25 instanceof Integer) == true) goto L101;
        r25 = null;
    L101:
        r16 = (Integer) r25;     // Catch: Throwable -> L127
        goto L125
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L106;
        r16 = Integer.valueOf(((Number) r15).intValue());     // Catch: Throwable -> L127
        goto L125
    L106:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L112;
        Long r26 = Long.valueOf(((Number) r15).longValue());     // Catch: Throwable -> L127
        if ((r26 instanceof Integer) == true) goto L110;
        r26 = null;
    L110:
        r16 = (Integer) r26;     // Catch: Throwable -> L127
    L112:
        if ((r15 instanceof JSONObject) == false) goto L114;
    L184:
        Object r27 = SDKSettingsCacheManager.a().fromJson(r15.toString(), Integer.class);     // Catch: Throwable -> L120
        if ((r27 instanceof Integer) == true) goto L118;
        r27 = null;
    L118:
        Object r28 = Result.constructor-impl((Integer) r27);     // Catch: Throwable -> L120
    L122:
        r16 = r28;
        if (Result.isFailure-impl(r16) == false) goto L125;
    L120:
        th = move-exception;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L127
        r28 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L127
        goto L122
    L114:
        if ((r15 instanceof JSONArray) == false) goto L124;
    L84:
        r23 = r15;
    L127:
        th = move-exception;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L153
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L153
    L174:
        this.f = ((Number) r10).intValue();
        this.g = true;
        this.m = LazyKt.lazy(SaasCouponService$lynxCouponShowDelay$2.INSTANCE);
        this.n = LazyKt.lazy(SaasCouponService$isShowDurationEventNAReport$2.INSTANCE);
        this.q = LazyKt.lazy(new SaasCouponService$showToastRun$2(this));
        this.v = new CompositeDisposable();
        this.w = EComABUtils.saasCouponToastMaxShowCountDaily();
        this.y = -1;
        this.z = LazyKt.lazy(new SaasCouponService$fullPageEventCloseBlockSubscriber$2(this));
        this.A = LazyKt.lazy(new SaasCouponService$fullPageEventOpenProductListSubscriber$2(this));
        this.a = ECLiveCommerceModel_ProvideLiveServiceFactory.proxyProvideLiveService(hh2.a.a().f);
        return;
    L11:
        if ((r6 instanceof Integer) == true) goto L13;
        Object r31 = null;
    L14:
        r7 = (Integer) r31;     // Catch: Throwable -> L56
        if (r7 != null) goto L54;
        if ((r6 instanceof Number) == false) goto L41;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L26;
        Float r32 = Float.valueOf(((Number) r6).floatValue());     // Catch: Throwable -> L56
        if ((r32 instanceof Integer) == true) goto L24;
        r32 = null;
    L24:
        r7 = (Integer) r32;     // Catch: Throwable -> L56
        goto L54
    L26:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L32;
        Double r33 = Double.valueOf(((Number) r6).doubleValue());     // Catch: Throwable -> L56
        if ((r33 instanceof Integer) == true) goto L30;
        r33 = null;
    L30:
        r7 = (Integer) r33;     // Catch: Throwable -> L56
        goto L54
    L32:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
        r7 = Integer.valueOf(((Number) r6).intValue());     // Catch: Throwable -> L56
        goto L54
    L35:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
        Long r34 = Long.valueOf(((Number) r6).longValue());     // Catch: Throwable -> L56
        if ((r34 instanceof Integer) == true) goto L39;
        r34 = null;
    L39:
        r7 = (Integer) r34;     // Catch: Throwable -> L56
    L41:
        if ((r6 instanceof JSONObject) == false) goto L43;
    L180:
        Object r35 = SDKSettingsCacheManager.a().fromJson(r6.toString(), Integer.class);     // Catch: Throwable -> L49
        if ((r35 instanceof Integer) == true) goto L47;
        r35 = null;
    L47:
        Object r36 = Result.constructor-impl((Integer) r35);     // Catch: Throwable -> L49
    L51:
        r7 = r36;
        if (Result.isFailure-impl(r7) == false) goto L54;
    L49:
        th = move-exception;
        Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L56
        r36 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
        goto L51
    L43:
        if ((r6 instanceof JSONArray) == false) goto L53;
    L13:
        r31 = r6;
    L56:
        th = move-exception;
        Result.Companion r38 = Result.Companion;     // Catch: Throwable -> L165
        r8 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
    L165:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        Object r40 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r41 = Result.exceptionOrNull-impl(r40);
        if (r41 == null) goto L170;
        EnsureManager.ensureNotReachHere(r41);
    L170:
        if (Result.isFailure-impl(r40) == true) goto L173;
        r1 = r40;
    L173:
        r10 = r1;
        goto L174
    }

    public static final void c(SaasCouponService r7, String r8) {
        WeakReference<Context> r0 = r7.j;
        if (r0 == null) goto L32;
        Context r1 = r0.get();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r.a.isLogin() == true) goto L11;
        return;
    L11:
        if (Intrinsics.areEqual(r7.c.b, "preview_benefit_coupon_popup") == false) goto L30;
        String r2 = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        if (r7.x != null) goto L16;
        r7.x = q.a.getString("saascoupon_last_show_toast_date", "");
    L16:
        if (Intrinsics.areEqual(r7.x, r2) == false) goto L21;
        if (r7.d() < r7.w) goto L21;
        boolean r4 = false;
    L28:
        if (r4 == true) goto L30;
        return;
    L21:
        if (r7.x != null) goto L23;
        r7.x = q.a.getString("saascoupon_last_show_toast_date", "");
    L23:
        r4 = true;
        if (Intrinsics.areEqual(r7.x, r2) == false) goto L26;
        r7.y = r7.d() + 1;
    L27:
        q.a.d("saascoupon_show_toast_count_daily", r7.d());
        goto L28
    L26:
        r7.x = r2;
        q.a.putString("saascoupon_last_show_toast_date", r2);
        r7.y = 1;
    L30:
        i.a.e(r1, r8, false, false);
        return;
    }

    @Override // el2.n
    public final void b(Boolean r4, Integer r5) {
        Function1<? super JSONObject, Unit> r0 = this.k;
        if (r0 == null) goto L11;
        JSONObject r1 = new JSONObject();
        if (r4 == null) goto L7;
        r4.booleanValue();
        r1.put("is_coupon_need_show", r4.booleanValue());
    L7:
        if (r5 == null) goto L9;
        r5.intValue();
        r1.put("action_type", r5.intValue());
    L9:
        Unit r6 = Unit.INSTANCE;
        Unit r7 = (Unit) r0.invoke(r1);
        return;
    }

    public final void e(boolean r8, boolean r9) {
        g r0 = this.c;
        r0.s = r8;
        CompositeDisposable r1 = this.v;
        dl2.e r2 = this.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r0, "requestParams");
        FilterNullArrayList<si2.k> r3 = new FilterNullArrayList();
        r3.add(new si2.k("enter_from", r0.a));
        r3.add(new si2.k("popup_key", r0.b));
        r3.add(new si2.k("room_id", r0.d));
        r3.add(new si2.k("anchor_open_id", r0.e));
        r3.add(new si2.k("reqid", r0.f));
        r3.add(new si2.k("token", r0.g));
        r3.add(new si2.k("cid", String.valueOf(r0.h)));
        r3.add(new si2.k("ad_id", String.valueOf(r0.i)));
        r3.add(new si2.k("biz_tag", r0.j));
        r3.add(new si2.k("skip_frequency", String.valueOf(r0.p)));
        r3.add(new si2.k("is_inner", String.valueOf(r0.q)));
        r3.add(si2.k.a.a("ecom_live_params", r0.r));
        r3.add(new si2.k("is_first_request", String.valueOf(r0.s)));
        l r4 = r2.a;
        if (r4 == null) goto L6;
        Observable r5 = r4.b(si2.g.R, r3, bl2.b.class, new dl2.c());
        if (r5 == null) goto L6;
    L7:
        r1.add(r5.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r8, r9), new c(this)));
        return;
    L6:
        r5 = Observable.create(dl2.b.a);
        goto L7
    }

    @Override // el2.n
    public final void a(Context r9, Bundle r10, Function1 r11, sg2.n r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "args");
        Intrinsics.checkNotNullParameter(r11, "callBack");
        Intrinsics.checkNotNullParameter(r12, "getLiveRoomParams");
        Disposable r1 = null;
        if ((r9 instanceof FragmentActivity) == true) goto L5;
        Context r0 = null;
    L6:
        FragmentActivity r2 = (FragmentActivity) r0;
        if (r2 == null) goto L11;
        Lifecycle r3 = r2.getLifecycle();
        if (r3 == null) goto L11;
        r3.addObserver(new SaasCouponService$tryShowSaasCouponDialog$1(this));
    L11:
        this.j = new WeakReference(r9);
        this.k = r11;
        this.o = r12;
        g r13 = this.c;
        String r14 = r10.getString("room_id", "");
        r13.getClass();
        Intrinsics.checkNotNullParameter(r14, "<set-?>");
        r13.d = r14;
        g r15 = this.c;
        r10.getBoolean("is_portrait", true);
        r15.getClass();
        g r16 = this.c;
        String r17 = r10.getString("anchor_open_id", "");
        r16.getClass();
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r16.e = r17;
        g r18 = this.c;
        String r19 = r10.getString("enter_from", "live");
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "<set-?>");
        r18.a = r19;
        this.c.p = r10.getBoolean("first_coupon_popup_skip_frequency", false);
        this.c.q = r10.getBoolean("is_inner", false);
        JSONObject r20 = z1.g(r10.getString("enter_request", ""));
        if (r20 == null) goto L16;
        JSONObject r21 = r20.optJSONObject("params");
        if (r21 == null) goto L16;
        g r110 = this.c;
        String r6 = r21.optString("reqid", "");
        r110.getClass();
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r110.f = r6;
        g r111 = this.c;
        String r7 = r21.optString("token", "");
        r111.getClass();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r111.g = r7;
        this.c.h = r21.optLong("cid", 0);
        this.c.i = r21.optLong("ad_id", 0);
        g r112 = this.c;
        String r22 = r21.optString("biz_tag", "");
        r112.getClass();
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r112.j = r22;
    L16:
        String r23 = r10.getString("saas_coupon_popup_key");
        if (r23 != null) goto L19;
    L24:
        String r24 = r10.getString("ecom_live_params");
        if (r24 == null) goto L33;
        if ((!StringsKt.isBlank(r24)) == true) goto L30;
        r24 = null;
    L30:
        if (r24 == null) goto L33;
        this.c.r = r24;
    L33:
        if (al2.a.a.length() != 0) goto L35;
        boolean r25 = true;
    L36:
        if (r25 == false) goto L39;
        String r26 = r10.getString("card_type", "");
        Intrinsics.checkNotNullParameter(r26, "<set-?>");
        al2.a.a = r26;
    L39:
        if (al2.a.b.length() != 0) goto L41;
        boolean r27 = true;
    L42:
        if (r27 == false) goto L45;
        String r28 = r10.getString("enter_from_event", "");
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        al2.a.b = r28;
    L45:
        if (al2.a.c.length() != 0) goto L47;
        boolean r29 = true;
    L48:
        if (r29 == false) goto L51;
        String r30 = r10.getString("previous_page", "");
        Intrinsics.checkNotNullParameter(r30, "<set-?>");
        al2.a.c = r30;
    L51:
        if (al2.a.d != 0) goto L53;
        al2.a.d = r10.getLong("is_from_ug", 0);
    L53:
        int r31 = r10.getInt("saas_coupon_popup_has_applied", 0);
        al2.a.e = r31;
        if (r31 != 0) goto L56;
        boolean r32 = true;
    L57:
        this.p = r32;
        if (this.f == 0) goto L60;
        dm.a.a("SaasCouponService").i("tryShowSaasCouponDialog, room_id: " + this.c.d + ", isStartLogin:" + g());
    L60:
        Observable r33 = r.a.b();
        if (r33 == null) goto L63;
        r1 = r33.subscribe(new com.bytedance.android.livesdk.livecommerce.saascoupon.b(this));
    L63:
        this.u = r1;
        e(true, false);
        return;
    L56:
        r32 = false;
        goto L57
    L47:
        r29 = false;
        goto L48
    L41:
        r27 = false;
        goto L42
    L35:
        r25 = false;
        goto L36
    L19:
        if (r23.length() <= 0) goto L21;
        boolean r113 = true;
    L22:
        if (r113 == false) goto L24;
        g r114 = this.c;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r23, "<set-?>");
        r114.b = r23;
        goto L24
    L21:
        r113 = false;
        goto L22
    L5:
        r0 = r9;
        goto L6
    }
}
