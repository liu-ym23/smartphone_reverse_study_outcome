package com.bytedance.android.shopping.api.mall.opt;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.api.mall.common.tools.h;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;
import yj.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECDeepFeedDomainPreConnectUtil {
    public static final Set<ECDeepFeedDomainPreConnectUtil> f = null;
    public static final a g = null;
    public volatile boolean a;
    public volatile Long b;
    public volatile long c;
    public volatile Disposable d;
    public volatile Long e;

    public static final class a {
        public a() {
        }

        public static com.bytedance.android.shopping.api.mall.opt.a b() {
            int r0 = com.bytedance.android.ec.base.settings.a.a;
            Object r2 = null;
            Object r1 = new com.bytedance.android.shopping.api.mall.opt.a(null);
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L165
            Object r4 = com.bytedance.android.ec.base.settings.d.c.get("ec_deep_feed_domain_preconnect_config");     // Catch: Throwable -> L56
            if (r4 != null) goto L8;
        L53:
            Object r5 = null;
        L54:
            Object r6 = Result.constructor-impl(r5);     // Catch: Throwable -> L56
        L58:
            Throwable r7 = Result.exceptionOrNull-impl(r6);     // Catch: Throwable -> L165
            if (r7 == null) goto L62;
            EnsureManager.ensureNotReachHere(r7);     // Catch: Throwable -> L165
        L62:
            if (Result.isFailure-impl(r6) == false) goto L65;
            r6 = null;
        L65:
            if ((r6 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L67;
            r6 = null;
        L67:
            Object r8 = (com.bytedance.android.shopping.api.mall.opt.a) r6;     // Catch: Throwable -> L165
            if (r8 != null) goto L74;
            Object r9 = com.bytedance.android.ec.base.settings.d.a.get("ec_deep_feed_domain_preconnect_config");     // Catch: Throwable -> L165
            if ((r9 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L73;
            r9 = null;
        L73:
            r8 = (com.bytedance.android.shopping.api.mall.opt.a) r9;     // Catch: Throwable -> L165
        L74:
            if (r8 != null) goto L175;
            int r10 = com.bytedance.android.ec.base.settings.c.a;     // Catch: Throwable -> L165
            Object r11 = com.bytedance.android.ec.base.settings.d.c.get("ec_deep_feed_domain_preconnect_config");     // Catch: Throwable -> L129
            if (r11 != null) goto L81;
        L126:
            Object r12 = null;
        L127:
            Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L129
        L131:
            Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L155
            if (r14 == null) goto L135;
            EnsureManager.ensureNotReachHere(r14);     // Catch: Throwable -> L155
        L135:
            if (Result.isFailure-impl(r13) == false) goto L138;
            r13 = null;
        L138:
            if ((r13 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L140;
            r13 = null;
        L140:
            r8 = (com.bytedance.android.shopping.api.mall.opt.a) r13;     // Catch: Throwable -> L155
            if (r8 != null) goto L163;
            IHybridHostService r15 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L155
            if (r15 == null) goto L146;
            Object r16 = r15.getHostABValue("ec_deep_feed_domain_preconnect_config", r1);     // Catch: Throwable -> L155
        L147:
            if (r16 != null) goto L149;
        L154:
            r8 = r1;
            goto L163
        L149:
            if ((r16 instanceof com.bytedance.android.shopping.api.mall.opt.a) == false) goto L152;
            r2 = r16;
        L152:
            Object r17 = (com.bytedance.android.shopping.api.mall.opt.a) r2;     // Catch: Throwable -> L155
            if (r17 == null) goto L154;
        L162:
            r8 = r17;
            goto L163
        L146:
            r16 = null;
        L163:
            com.bytedance.android.ec.base.settings.d.d("ec_deep_feed_domain_preconnect_config", r8);     // Catch: Throwable -> L165
            goto L175
        L81:
            if ((r11 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L83;
            Object r18 = null;
        L84:
            r12 = (com.bytedance.android.shopping.api.mall.opt.a) r18;     // Catch: Throwable -> L129
            if (r12 != null) goto L127;
            if ((r11 instanceof Number) == false) goto L114;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.api.mall.opt.a.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L96;
            Float r19 = Float.valueOf(((Number) r11).floatValue());     // Catch: Throwable -> L129
            if ((r19 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L94;
            r19 = null;
        L94:
            r12 = (com.bytedance.android.shopping.api.mall.opt.a) r19;     // Catch: Throwable -> L129
            goto L127
        L96:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.api.mall.opt.a.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L102;
            Double r20 = Double.valueOf(((Number) r11).doubleValue());     // Catch: Throwable -> L129
            if ((r20 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L100;
            r20 = null;
        L100:
            r12 = (com.bytedance.android.shopping.api.mall.opt.a) r20;     // Catch: Throwable -> L129
            goto L127
        L102:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.api.mall.opt.a.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L108;
            Integer r21 = Integer.valueOf(((Number) r11).intValue());     // Catch: Throwable -> L129
            if ((r21 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L106;
            r21 = null;
        L106:
            r12 = (com.bytedance.android.shopping.api.mall.opt.a) r21;     // Catch: Throwable -> L129
            goto L127
        L108:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.api.mall.opt.a.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L114;
            Long r22 = Long.valueOf(((Number) r11).longValue());     // Catch: Throwable -> L129
            if ((r22 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L112;
            r22 = null;
        L112:
            r12 = (com.bytedance.android.shopping.api.mall.opt.a) r22;     // Catch: Throwable -> L129
        L114:
            if ((r11 instanceof JSONObject) == false) goto L116;
        L183:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L122
            Object r23 = SDKSettingsCacheManager.a().fromJson(r11.toString(), com.bytedance.android.shopping.api.mall.opt.a.class);     // Catch: Throwable -> L122
            if ((r23 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L120;
            r23 = null;
        L120:
            Object r24 = Result.constructor-impl((com.bytedance.android.shopping.api.mall.opt.a) r23);     // Catch: Throwable -> L122
        L124:
            r12 = r24;
            if (Result.isFailure-impl(r12) == false) goto L127;
        L122:
            th = move-exception;
            Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L129
            r24 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L129
            goto L124
        L116:
            if ((r11 instanceof JSONArray) == false) goto L126;
        L83:
            r18 = r11;
        L155:
            th = move-exception;
            Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L165
            r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
            Throwable r27 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L165
            if (r27 == null) goto L160;
            EnsureManager.ensureNotReachHere(r27);     // Catch: Throwable -> L165
        L160:
            if (Result.isFailure-impl(r17) == false) goto L162;
            r17 = r1;
        L129:
            th = move-exception;
            Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L155
            r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L155
        L175:
            return (com.bytedance.android.shopping.api.mall.opt.a) r8;
        L8:
            if ((r4 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L10;
            Object r29 = null;
        L11:
            r5 = (com.bytedance.android.shopping.api.mall.opt.a) r29;     // Catch: Throwable -> L56
            if (r5 != null) goto L54;
            if ((r4 instanceof Number) == false) goto L41;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.api.mall.opt.a.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L23;
            Float r30 = Float.valueOf(((Number) r4).floatValue());     // Catch: Throwable -> L56
            if ((r30 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L21;
            r30 = null;
        L21:
            r5 = (com.bytedance.android.shopping.api.mall.opt.a) r30;     // Catch: Throwable -> L56
            goto L54
        L23:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.api.mall.opt.a.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L29;
            Double r31 = Double.valueOf(((Number) r4).doubleValue());     // Catch: Throwable -> L56
            if ((r31 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L27;
            r31 = null;
        L27:
            r5 = (com.bytedance.android.shopping.api.mall.opt.a) r31;     // Catch: Throwable -> L56
            goto L54
        L29:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.api.mall.opt.a.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L35;
            Integer r32 = Integer.valueOf(((Number) r4).intValue());     // Catch: Throwable -> L56
            if ((r32 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L33;
            r32 = null;
        L33:
            r5 = (com.bytedance.android.shopping.api.mall.opt.a) r32;     // Catch: Throwable -> L56
            goto L54
        L35:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.api.mall.opt.a.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L41;
            Long r33 = Long.valueOf(((Number) r4).longValue());     // Catch: Throwable -> L56
            if ((r33 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L39;
            r33 = null;
        L39:
            r5 = (com.bytedance.android.shopping.api.mall.opt.a) r33;     // Catch: Throwable -> L56
        L41:
            if ((r4 instanceof JSONObject) == false) goto L43;
        L180:
            SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L49
            Object r34 = SDKSettingsCacheManager.a().fromJson(r4.toString(), com.bytedance.android.shopping.api.mall.opt.a.class);     // Catch: Throwable -> L49
            if ((r34 instanceof com.bytedance.android.shopping.api.mall.opt.a) == true) goto L47;
            r34 = null;
        L47:
            Object r35 = Result.constructor-impl((com.bytedance.android.shopping.api.mall.opt.a) r34);     // Catch: Throwable -> L49
        L51:
            r5 = r35;
            if (Result.isFailure-impl(r5) == false) goto L54;
        L49:
            th = move-exception;
            Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L56
            r35 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L56
            goto L51
        L43:
            if ((r4 instanceof JSONArray) == false) goto L53;
        L10:
            r29 = r4;
        L56:
            th = move-exception;
            Result.Companion r37 = Result.Companion;     // Catch: Throwable -> L165
            r6 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L165
        L165:
            th = move-exception;
            Result.Companion r38 = Result.Companion;
            Object r39 = Result.constructor-impl(ResultKt.createFailure(th));
            Throwable r40 = Result.exceptionOrNull-impl(r39);
            if (r40 == null) goto L170;
            EnsureManager.ensureNotReachHere(r40);
        L170:
            if (Result.isFailure-impl(r39) == true) goto L173;
            r1 = r39;
        L173:
            r8 = r1;
            goto L175
        }

        public static final void a(a r1, ECDeepFeedDomainPreConnectUtil r2) {
            monitor-enter(r1);
            ECDeepFeedDomainPreConnectUtil.f.remove(r2);     // Catch: Throwable -> L6
            monitor-exit(r1);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ECDeepFeedDomainPreConnectUtil a;
        public final /* synthetic */ long b;

        public b(ECDeepFeedDomainPreConnectUtil r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            ECDeepFeedDomainPreConnectUtil r0 = this.a;
            long r1 = this.b;
            boolean r4 = true;
            if (r0.a == true) goto L5;
        L7:
            boolean r3 = false;
        L8:
            if (r3 == false) goto L52;
            ECDeepFeedDomainPreConnectUtil.g.getClass();
            com.bytedance.android.shopping.api.mall.opt.a r5 = a.b();
            if (r5.b() == true) goto L13;
            r0.f(r1);
            return;
        L13:
            Set r6 = ECDeepFeedDomainPreConnectUtil.h(r5.a());
            if (r6.isEmpty() == false) goto L16;
            r0.f(r1);
            return;
        L16:
            Long r7 = r5.c();
            if (r7 != null) goto L19;
        L44:
            r0.f(r1);
            return;
        L19:
            if (r7.longValue() <= 0) goto L44;
            r0.e = Long.valueOf(System.currentTimeMillis());
            ECDeepFeedDomainPreConnectUtil.a(r6);     // Catch: Throwable -> L41
            long r8 = r7.longValue();
            monitor-enter(r0);
        L38:
            th = move-exception;
            throw th;
        L26:
            if (r0.a == true) goto L29;
        L31:
            r4 = false;
        L32:
            if (r4 == true) goto L35;
            monitor-exit(r0);
            return;
        L35:
            r0.c(r8, r1);     // Catch: Throwable -> L38
            monitor-exit(r0);
            return;
        L29:
            if (r0.c != r1) goto L31;
        L41:
            th = move-exception;
            r0.b(r7.longValue(), r1);
            throw th;
        L52:
            return;
        L5:
            if (r0.c != r1) goto L7;
            r3 = true;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ECDeepFeedDomainPreConnectUtil a;
        public final /* synthetic */ Set b;

        public c(ECDeepFeedDomainPreConnectUtil r1, Set r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECDeepFeedDomainPreConnectUtil r0 = this.a;     // Catch: Throwable -> L4
            Set r1 = this.b;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            ECDeepFeedDomainPreConnectUtil.a(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECDeepFeedDomainPreConnectUtil() {
    }

    public final synchronized void e() {
        monitor-enter(this);
        g();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        g = new a();
        f = new LinkedHashSet();
    }

    public final void g() {
        Disposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.d = null;
        this.a = false;
        this.b = null;
        this.c++;
    }

    public static void a(Set r2) {
        n r0 = h.b.getIHybridHostNetService();
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        r0.connect((String) r3.next());     // Catch: Exception -> L8
        goto L4
    }

    public static Set h(List r1) {
        if (r1 == null) goto L10;
        Sequence r2 = CollectionsKt.asSequence(r1);
        if (r2 == null) goto L10;
        Sequence r3 = SequencesKt.map(r2, ECDeepFeedDomainPreConnectUtil$toNormalizedDomainSet$1.INSTANCE);
        if (r3 == null) goto L10;
        Sequence r4 = SequencesKt.filter(r3, ECDeepFeedDomainPreConnectUtil$toNormalizedDomainSet$2.INSTANCE);
        if (r4 == null) goto L10;
        Set r5 = SequencesKt.toSet(r4);
    L11:
        if (r5 == null) goto L13;
        return r5;
    L13:
        return SetsKt.emptySet();
    L10:
        r5 = null;
        goto L11
    }

    public final void d(long r4) {
        if (this.a == false) goto L10;
        Long r0 = this.b;
        if (r0 == null) goto L10;
        if (r0.longValue() != r4) goto L10;
        return;
    L10:
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L12:
        if (this.a == false) goto L21;
        Long r1 = this.b;     // Catch: Throwable -> L24
        if (r1 == null) goto L21;
        if (r1.longValue() != r4) goto L21;
        monitor-exit(this);
        return;
    L21:
        g();     // Catch: Throwable -> L24
        this.a = true;     // Catch: Throwable -> L24
        this.b = Long.valueOf(r4);     // Catch: Throwable -> L24
        c(r4, this.c);     // Catch: Throwable -> L24
        monitor-exit(this);
    }

    public final synchronized void f(long r4) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.a == true) goto L7;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        g();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L7:
        if (this.c != r4) goto L9;
        r5 = true;
        goto L10
    }

    public final void i(Set<String> r3) {
        this.e = Long.valueOf(System.currentTimeMillis());
        com.bytedance.android.ec.hybrid.a.d().execute(new c(this, r3));
    }

    public final synchronized void b(long r4, long r6) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.a == true) goto L7;
    L9:
        boolean r0 = false;
    L10:
        if (r0 == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        c(r4, r6);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L7:
        if (this.c != r6) goto L9;
        r0 = true;
        goto L10
    }

    public final void c(long r3, long r5) {
        this.b = Long.valueOf(r3);
        Disposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.d = Schedulers.from(com.bytedance.android.ec.hybrid.a.d()).scheduleDirect(new b(this, r5), r3, TimeUnit.MILLISECONDS);
    }
}
