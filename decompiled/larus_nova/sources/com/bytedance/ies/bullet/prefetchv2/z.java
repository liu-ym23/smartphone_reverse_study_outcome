package com.bytedance.ies.bullet.prefetchv2;

import bolts.Task;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.lynx.tasm.LynxError;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.ByteArrayOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d0 f247614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f247615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f247616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f247617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f247618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f247619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f247620g;

    public interface a {
        void b(p r100, Throwable r101);

        void d(p r100, v r101);
    }

    public interface b extends a {
        void a(p r100, v r101);

        void c(p r100, v r101);
    }

    public static final class c implements com.bytedance.ies.bullet.prefetchv2.d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f247621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f247622b;

        @Override // com.bytedance.ies.bullet.prefetchv2.d.c
        public final void a(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            if (this.f247621a.f247619f == false) goto L5;
            return;
        L5:
            HybridLogger r101 = HybridLogger.f246343a;
            HybridLogger.i("XPrefetch", "Prefetch请求失败: " + r100.getMessage(), null, 12);
            z r102 = this.f247621a;
            a r103 = r102.f247618e;
            if (r103 == null) goto L8;
            r103.b(r102.f247616c, r100);
        L8:
            this.f247621a.a();
        }

        @Override // com.bytedance.ies.bullet.prefetchv2.d.c
        public final void b(com.bytedance.ies.bullet.prefetchv2.d.b r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            if (this.f247621a.f247619f == false) goto L32;
            return;
        L32:
            System.currentTimeMillis();     // Catch: Throwable -> L21 Exception -> L23
            v r101 = this.f247621a.c();     // Catch: Throwable -> L21 Exception -> L23
            if (r101 == null) goto L8;
            r101.f247601a = Integer.valueOf(r100.f247523d);     // Catch: Throwable -> L21 Exception -> L23
            r101.f247602b = r100.f247522c;     // Catch: Throwable -> L21 Exception -> L23
            r101.f247610j = true;     // Catch: Throwable -> L21 Exception -> L23
        L9:
            HybridLogger r102 = HybridLogger.f246343a;     // Catch: Throwable -> L21 Exception -> L23
            HybridLogger.m("XPrefetch", "接受流式 Prefetch 数据结束: " + this.f247621a.f247616c.f247575l, null, null, 12);     // Catch: Throwable -> L21 Exception -> L23
            if (r101 == null) goto L27;
            z r103 = this.f247621a;     // Catch: Throwable -> L21 Exception -> L23
            a r104 = r103.f247618e;     // Catch: Throwable -> L21 Exception -> L23
            if (r104 == null) goto L27;
            Object r105 = r103.f247620g;     // Catch: Throwable -> L21 Exception -> L23
            monitor-enter(r105);     // Catch: Throwable -> L21 Exception -> L23
            r104.d(r103.f247616c, r101);     // Catch: Throwable -> L18
            Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L18
            monitor-exit(r105);     // Catch: Throwable -> L21 Exception -> L23
        L18:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21 Exception -> L23
        L27:
            this.f247621a.a();
            return;
        L8:
            r101 = null;
        L23:
            e = move-exception;
            z r107 = this.f247621a;     // Catch: Throwable -> L21
            a r108 = r107.f247618e;     // Catch: Throwable -> L21
            if (r108 == null) goto L27;
            r108.b(r107.f247616c, new PrefetchException("请求结果处理异常 in onRequestSucceed: " + e.getMessage()));     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            this.f247621a.a();
            throw th;
        }

        @Override // com.bytedance.ies.bullet.prefetchv2.d.c
        public final void c(com.bytedance.ies.bullet.prefetchv2.d.b r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            z r101 = this.f247621a;
            if (r101.f247619f == false) goto L38;
            return;
        L38:
        L31:
            e = move-exception;
            HybridLogger r102 = HybridLogger.f246343a;
            HybridLogger.i("XPrefetch", "接受流式 Prefetch 数据异常: " + e.getMessage(), null, 12);
            z r103 = this.f247621a;
            a r104 = r103.f247618e;
            if (r104 == null) goto L42;
            r104.b(r103.f247616c, new PrefetchException("请求结果处理异常 in onReceiveResponse: " + e.getMessage()));
            return;
        L42:
            return;
        L7:
            if (r101.c() != null) goto L11;
            v r105 = new v();     // Catch: Exception -> L31
            long r106 = this.f247622b;     // Catch: Exception -> L31
            z r107 = this.f247621a;     // Catch: Exception -> L31
            r105.f247601a = Integer.valueOf(r100.f247523d);     // Catch: Exception -> L31
            r105.f247602b = r100.f247522c;     // Catch: Exception -> L31
            r105.f247604d = Long.valueOf(r106);     // Catch: Exception -> L31
            t r108 = r107.f247615b;     // Catch: Exception -> L31
            r105.f247605e = r108.f247590g;     // Catch: Exception -> L31
            r105.f247606f = r108.f247591h;     // Catch: Exception -> L31
            r105.f247607g = r108.f247592i;     // Catch: Exception -> L31
            String r109 = r107.f247617d.f247545b;     // Catch: Exception -> L31
            Intrinsics.checkNotNullParameter(r109, "<set-?>");     // Catch: Exception -> L31
            r105.f247608h = r109;     // Catch: Exception -> L31
            r105.f247610j = false;     // Catch: Exception -> L31
            ByteArrayOutputStream r110 = new ByteArrayOutputStream();     // Catch: Exception -> L31
            r110.write(r100.f247520a);     // Catch: Exception -> L31
            r105.f247609i = r110;     // Catch: Exception -> L31
            f r111 = a0.f247516d;     // Catch: Exception -> L31
            if (r111 == null) goto L17;
            r111.b(this.f247621a.f247616c, r105);     // Catch: Exception -> L31
        L17:
            if (r105 == null) goto L39;
            z r112 = this.f247621a;     // Catch: Exception -> L31
            a r113 = r112.f247618e;     // Catch: Exception -> L31
            if ((r113 instanceof b) == false) goto L21;
            b r114 = (b) r113;     // Catch: Exception -> L31
        L22:
            if (r114 == null) goto L40;
            Object r115 = r112.f247620g;     // Catch: Exception -> L31
            monitor-enter(r115);     // Catch: Exception -> L31
            r114.c(r112.f247616c, r105);     // Catch: Throwable -> L28
            Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L28
            monitor-exit(r115);     // Catch: Exception -> L31
            return;
        L28:
            th = move-exception;
            throw th;     // Catch: Exception -> L31
        L40:
            return;
        L21:
            r114 = null;
            goto L22
        L39:
            return;
        L11:
            r105 = this.f247621a.c();     // Catch: Exception -> L31
            if (r105 == null) goto L16;
            ByteArrayOutputStream r117 = r105.f247609i;     // Catch: Exception -> L31
            if (r117 == null) goto L17;
            r117.write(r100.f247520a);     // Catch: Exception -> L31
            goto L17
        L16:
            r105 = null;
            goto L17
        }

        public c(z r100, long r101) {
            this.f247621a = r100;
            this.f247622b = r101;
        }
    }

    public static final class d implements com.bytedance.ies.bullet.prefetchv2.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z f247623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f247624b;

        public static final class a<V> implements Callable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ z f247625a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.ies.bullet.prefetchv2.d.b f247626b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f247627c;

            public a(z r100, com.bytedance.ies.bullet.prefetchv2.d.b r101, long r102) {
                this.f247625a = r100;
                this.f247626b = r101;
                this.f247627c = r102;
            }

            @Override // java.util.concurrent.Callable
            public final Unit call() {
                System.currentTimeMillis();     // Catch: Throwable -> L10 Exception -> L19
                v r100 = new v();     // Catch: Throwable -> L10 Exception -> L19
                com.bytedance.ies.bullet.prefetchv2.d.b r101 = this.f247626b;     // Catch: Throwable -> L10 Exception -> L19
                z r102 = this.f247625a;     // Catch: Throwable -> L10 Exception -> L19
                long r103 = this.f247627c;     // Catch: Throwable -> L10 Exception -> L19
                r100.f247601a = Integer.valueOf(r101.f247523d);     // Catch: Throwable -> L10 Exception -> L19
                r100.f247602b = r101.f247522c;     // Catch: Throwable -> L10 Exception -> L19
                r102.getClass();     // Catch: Throwable -> L10 Exception -> L29
                String r104 = z.b(r101);     // Catch: Throwable -> L10 Exception -> L29
                if (r104 == null) goto L7;
                JSONObject r105 = new JSONObject(r104);     // Catch: Throwable -> L10 Exception -> L29
            L8:
                r100.f247603c = r105;     // Catch: Throwable -> L10 Exception -> L29
                goto L12
            L7:
                r105 = new JSONObject();     // Catch: Throwable -> L10 Exception -> L29
            L12:
                r100.f247604d = Long.valueOf(r103);     // Catch: Throwable -> L10 Exception -> L19
                t r106 = r102.f247615b;     // Catch: Throwable -> L10 Exception -> L19
                r100.f247605e = r106.f247590g;     // Catch: Throwable -> L10 Exception -> L19
                r100.f247606f = r106.f247591h;     // Catch: Throwable -> L10 Exception -> L19
                r100.f247607g = r106.f247592i;     // Catch: Throwable -> L10 Exception -> L19
                String r107 = r102.f247617d.f247545b;     // Catch: Throwable -> L10 Exception -> L19
                Intrinsics.checkNotNullParameter(r107, "<set-?>");     // Catch: Throwable -> L10 Exception -> L19
                r100.f247608h = r107;     // Catch: Throwable -> L10 Exception -> L19
                int r108 = j.f247548a;     // Catch: Throwable -> L10 Exception -> L19
                j.a("Prefetch成功: " + this.f247625a.f247616c.f247575l);     // Catch: Throwable -> L10 Exception -> L19
                f r109 = a0.f247516d;     // Catch: Throwable -> L10 Exception -> L19
                if (r109 == null) goto L15;
                r109.b(this.f247625a.f247616c, r100);     // Catch: Throwable -> L10 Exception -> L19
            L15:
                z r110 = this.f247625a;     // Catch: Throwable -> L10 Exception -> L19
                a r111 = r110.f247618e;     // Catch: Throwable -> L10 Exception -> L19
                if (r111 == null) goto L24;
                r111.d(r110.f247616c, r100);     // Catch: Throwable -> L10 Exception -> L19
                Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L10 Exception -> L19
            L25:
                this.f247625a.a();
                return r112;
            L24:
                r112 = null;
            L10:
                th = move-exception;
                this.f247625a.a();
                throw th;
            L19:
                e = move-exception;
                z r113 = this.f247625a;     // Catch: Throwable -> L10
                a r114 = r113.f247618e;     // Catch: Throwable -> L10
                if (r114 == null) goto L24;
                r114.b(r113.f247616c, new PrefetchException("请求结果处理异常: " + e.getMessage()));     // Catch: Throwable -> L10
                r112 = Unit.INSTANCE;     // Catch: Throwable -> L10
                goto L25
            }

            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                return call();
            }
        }

        @Override // com.bytedance.ies.bullet.prefetchv2.d.a
        public final void a(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            int r101 = j.f247548a;
            j.b("Prefetch请求失败: " + r100.getMessage());
            z r102 = this.f247623a;
            a r103 = r102.f247618e;
            if (r103 == null) goto L5;
            r103.b(r102.f247616c, r100);
        L5:
            this.f247623a.a();
        }

        @Override // com.bytedance.ies.bullet.prefetchv2.d.a
        public final void b(com.bytedance.ies.bullet.prefetchv2.d.b r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            Task.callInBackground(new a(this.f247623a, r100, this.f247624b));
        }

        public d(z r100, long r101) {
            this.f247623a = r100;
            this.f247624b = r101;
        }
    }

    public final synchronized void a() {
        monitor-enter(this);
        ConcurrentHashMap<String, z> r100 = e0.f247529a;     // Catch: Throwable -> L6
        e0.a(this.f247616c);     // Catch: Throwable -> L6
        this.f247619f = true;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized v c() {
        monitor-enter(this);
        f r100 = a0.f247516d;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        v r101 = r100.a(this.f247616c);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r101;
    L7:
        r101 = null;
    L10:
        th = move-exception;
        throw th;
    }

    public final void e() {
        String r100 = this.f247614a.f247525b;
        ConcurrentHashMap<String, m> r101 = c0.f247518a;
        boolean r102 = true;
        com.bytedance.ies.bullet.prefetchv2.d r103 = null;
        if (r100 != null) goto L5;
    L21:
        m r104 = c0.f247519b;
        if (r104 == null) goto L24;
        r103 = r104.b();
    L24:
        com.bytedance.ies.bullet.prefetchv2.d r105 = r103;
        if (r105 != null) goto L28;
        a();
        int r106 = j.f247548a;
        j.b("NetworkExecutor为空, 请查看是否注入网络实现，prefetch_business: " + r100);
        return;
    L28:
        long r107 = System.currentTimeMillis();
        if (this.f247615b.f247599p == false) goto L50;
        p r108 = this.f247616c;
        c r109 = new c(this, r107);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "callback");
        List<String> r110 = r108.f247574k;
        if (r110 != null) goto L33;
        String r111 = p.a(r108.f247564a, r108.f247567d, r108.f247571h);
    L34:
        LinkedHashMap r112 = new LinkedHashMap();
        Map<String, String> r113 = r108.f247566c;
        if (r113 == null) goto L37;
        r112.putAll(r113);
    L37:
        Map<String, String> r114 = r108.f247570g;
        if (r114 == null) goto L40;
        r112.putAll(r114);
    L40:
        Map<String, Map<Class<?>, Object>> r115 = x26.a.f562251a;
        w26.g r116 = (w26.g) x26.a.a(w26.g.class);
        if (r116 == null) goto L47;
        w26.e r117 = (w26.e) r116.n0(w26.e.class);
        if (r117 == null) goto L47;
        Boolean r118 = r117.F1();
        if (r118 == null) goto L47;
        r102 = r118.booleanValue();
    L47:
        if (r102 == false) goto L49;
        r112.put("Anniex-Prefetch", "1");
    L49:
        List<String> r119 = com.bytedance.ies.argus.strategy.provider.client.o.f246230a;
        com.bytedance.ies.argus.strategy.provider.client.o.a.a(r112);
        Task.callInBackground(new q(r108, r111, r112, r109));
        return;
    L33:
        String r120 = r108.f247564a;
        Map<String, String> r121 = r108.f247567d;
        Map<String, String> r122 = r108.f247571h;
        ConcurrentHashMap<String, Object> r123 = com.bytedance.android.anniex.ability.f.f40204a;
        r111 = p.b(r120, r121, r122, com.bytedance.android.anniex.ability.f.m(r108.f247577n, r110, UriProtector.parse(r120)));
        goto L34
    L50:
        p r124 = this.f247616c;
        d r125 = new d(this, r107);
        r124.getClass();
        Intrinsics.checkNotNullParameter(r105, "executor");
        Intrinsics.checkNotNullParameter(r125, "callback");
        List<String> r126 = r124.f247574k;
        if (r126 != null) goto L53;
        String r127 = p.a(r124.f247564a, r124.f247567d, r124.f247571h);
    L54:
        String r128 = r127;
        LinkedHashMap r129 = new LinkedHashMap();
        Map<String, String> r130 = r124.f247566c;
        if (r130 == null) goto L57;
        r129.putAll(r130);
    L57:
        Map<String, String> r131 = r124.f247570g;
        if (r131 == null) goto L60;
        r129.putAll(r131);
    L60:
        Map<String, Map<Class<?>, Object>> r132 = x26.a.f562251a;
        w26.g r133 = (w26.g) x26.a.a(w26.g.class);
        if (r133 == null) goto L67;
        w26.e r134 = (w26.e) r133.n0(w26.e.class);
        if (r134 == null) goto L67;
        Boolean r135 = r134.F1();
        if (r135 == null) goto L67;
        r102 = r135.booleanValue();
    L67:
        if (r102 == false) goto L69;
        r129.put("Anniex-Prefetch", "1");
    L69:
        List<String> r136 = com.bytedance.ies.argus.strategy.provider.client.o.f246230a;
        com.bytedance.ies.argus.strategy.provider.client.o.a.a(r129);
        if (r124.f247572i == false) goto L99;
        boolean r137 = r124.f247569f;
        if (com.bytedance.sdk.xbridge.cn.utils.g.e() == null) goto L75;
        IHostNetworkDepend r138 = com.bytedance.sdk.xbridge.cn.utils.g.e();
        Intrinsics.checkNotNull(r138);
    L74:
        IHostNetworkDepend r139 = r138;
        s r140 = new s(r125);
        String r141 = r124.f247565b;
        Locale r142 = Locale.ROOT;
        if (r141 == null) goto L98;
        if (Intrinsics.areEqual(r141.toLowerCase(r142), MonitorConstants.CONNECT_TYPE_GET) == false) goto L83;
        te7.e.f545589a.getClass();
        te7.e.i(r128, r129, r140, r139, r137, true, -1);
        return;
    L83:
        String r143 = r124.f247565b;
        if (r143 == null) goto L96;
        if (Intrinsics.areEqual(r143.toLowerCase(r142), UGCMonitor.TYPE_POST) == false) goto L126;
        String r144 = (String) r129.get("Content-Type");
        if (r144 != null) goto L90;
        String r145 = "application/x-www-form-urlencoded";
    L91:
        r129.put("Content-Type", r145);
        te7.e r146 = te7.e.f545589a;
        JSONObject r147 = r124.f247568e;
        if (r147 != null) goto L94;
        r147 = new JSONObject();
    L94:
        r146.getClass();
        te7.e.n(r128, r129, r145, r147, r140, r139, r137, true, -1);
        return;
    L90:
        r145 = r144;
        goto L91
    L126:
        return;
    L96:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L98:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L75:
        if (r137 == false) goto L77;
        r138 = com.bytedance.sdk.xbridge.cn.utils.g.d();
        goto L74
    L77:
        r138 = com.bytedance.sdk.xbridge.cn.utils.g.g();
        goto L74
    L99:
        String r148 = r124.f247565b;
        Locale r149 = Locale.ROOT;
        if (r148 == null) goto L123;
        if (Intrinsics.areEqual(r148.toLowerCase(r149), MonitorConstants.CONNECT_TYPE_GET) == false) goto L104;
        r105.a(r128, r129, r124.f247569f, r125);
        return;
    L104:
        String r150 = r124.f247565b;
        if (r150 == null) goto L121;
        if (Intrinsics.areEqual(r150.toLowerCase(r149), UGCMonitor.TYPE_POST) == false) goto L129;
        Map<String, String> r151 = r124.f247566c;
        if (r151 == null) goto L114;
        String r152 = r151.get("Content-Type");
        if (r152 == null) goto L114;
        String r153 = r152;
    L115:
        JSONObject r154 = r124.f247568e;
        if (r154 != null) goto L118;
        r154 = new JSONObject();
    L118:
        r105.b(r128, r129, r153, r154, r124.f247569f, r125);
        return;
    L114:
        r153 = "application/x-www-form-urlencoded";
        goto L115
    L129:
        return;
    L121:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L123:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L53:
        String r155 = r124.f247564a;
        Map<String, String> r156 = r124.f247567d;
        Map<String, String> r157 = r124.f247571h;
        ConcurrentHashMap<String, Object> r158 = com.bytedance.android.anniex.ability.f.f40204a;
        r127 = p.b(r155, r156, r157, com.bytedance.android.anniex.ability.f.m(r124.f247577n, r126, UriProtector.parse(r155)));
        goto L54
    L5:
        if (r100.length() != 0) goto L7;
        boolean r159 = true;
    L8:
        if (r159 == false) goto L10;
        m r160 = null;
    L11:
        if (r160 == null) goto L14;
        com.bytedance.ies.bullet.prefetchv2.d r161 = r160.b();
        if (r161 == null) goto L14;
    L18:
        if (r161 == null) goto L21;
        r103 = r161;
    L14:
        m r162 = c0.f247519b;
        if (r162 == null) goto L17;
        r161 = r162.b();
        goto L18
    L17:
        r161 = null;
        goto L18
    L10:
        r160 = c0.f247518a.get(r100);
        goto L11
    L7:
        r159 = false;
        goto L8
    }

    public static String b(com.bytedance.ies.bullet.prefetchv2.d.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = r100.f247521b;
        if (r101 == null) goto L5;
        return r101;
    L5:
        byte[] r102 = r100.f247520a;
        if (r102 == null) goto L9;
        r100.f247521b = new String(r102, Charsets.UTF_8);
    L9:
        return r100.f247521b;
    }

    public final void d(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (this.f247619f == false) goto L15;
        f r101 = a0.f247516d;
        Boolean r102 = null;
        if (r101 == null) goto L7;
        v r103 = r101.a(this.f247616c);
    L8:
        if (r103 != null) goto L10;
    L12:
        if (r103 == null) goto L14;
        r102 = Boolean.valueOf(r103.a());
    L14:
        r100.b(this.f247616c, new PrefetchException("边界错误，cache: " + r103 + ", cache expire: " + r102));
        return;
    L10:
        if (r103.a() == true) goto L12;
        r100.d(this.f247616c, r103);
        return;
    L7:
        r103 = null;
        goto L8
    L15:
        this.f247618e = r100;
        if ((r100 instanceof b) == false) goto L31;
        Object r104 = this.f247620g;
        monitor-enter(r104);
        v r105 = c();     // Catch: Throwable -> L24
        if (r105 == null) goto L22;
        ((b) r100).a(this.f247616c, r105);     // Catch: Throwable -> L24
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L22:
        monitor-exit(r104);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public z(d0 r100, t r101, p r102, h r103) {
        Intrinsics.checkNotNullParameter(r100, "schemaModel");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "request");
        Intrinsics.checkNotNullParameter(r103, "prefetchConfig");
        this.f247614a = r100;
        this.f247615b = r101;
        this.f247616c = r102;
        this.f247617d = r103;
        this.f247620g = new Object();
    }
}
