package com.bytedance.locallife.biz.prefetch.newsdk;

import com.bytedance.retrofit2.Invocation;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
public abstract class AbsPrefetchInterceptor implements Interceptor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile Function0<? extends List<String>> f256933c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f256934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f256935b;

    public static final class a {
    }

    public abstract boolean b();

    public abstract SsResponse<?> f(Interceptor.Chain r100, String r101, long r102);

    static {
        f256933c = AbsPrefetchInterceptor$Companion$cacheKeyWhiteListProvider$1.INSTANCE;
    }

    public AbsPrefetchInterceptor(c r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f256934a = r100;
        this.f256935b = true;
    }

    public final boolean a(f r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Long r101 = r100.f256949f;
        if (r100.f256947d == null) goto L5;
    L24:
        return false;
    L5:
        if (r100.f256946c == null) goto L24;
        if (r101 == null) goto L24;
        if (r100.f256950g < 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L18;
        if ((System.currentTimeMillis() - r101.longValue()) >= r100.f256950g) goto L25;
        return true;
    L25:
        return false;
    L18:
        if (this.f256934a.l() == false) goto L23;
        long r103 = System.currentTimeMillis() - r101.longValue();
        this.f256934a.h();
        if (r103 >= Long.MAX_VALUE) goto L26;
        return true;
    L26:
        return false;
    L23:
        return true;
    L11:
        r102 = false;
        goto L12
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r110) {
        Intrinsics.checkNotNullParameter(r110, "chain");
        long r100 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r110, "chain");
        TreeMap r101 = new TreeMap();
        Invocation r102 = (Invocation) r110.request().tag(Invocation.class);
        Object r103 = null;
        if (r102 == null) goto L43;
        List<?> r104 = r102.arguments();
        if (r104 == null) goto L43;
        Iterator<T> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L43;
        Object r106 = r105.next();
        if ((r106 instanceof Map) == false) goto L12;
        Map r107 = (Map) r106;
    L13:
        if (r107 == null) goto L21;
        Iterator r108 = r107.entrySet().iterator();
    L16:
        if (r108.hasNext() == false) goto L21;
        Map.Entry r109 = (Map.Entry) r108.next();
        Object r111 = r109.getKey();
        Object r112 = r109.getValue();
        if ((r111 instanceof String) == false) goto L16;
        if (r112 == null) goto L16;
        r101.put(r111, r112);
    L21:
        if (r106 != null) goto L77;
        Map r113 = null;
    L35:
        if (r113 == null) goto L8;
        Iterator r114 = r113.entrySet().iterator();
    L38:
        if (r114.hasNext() == false) goto L8;
        Map.Entry r115 = (Map.Entry) r114.next();
        Object r116 = r115.getKey();
        Object r117 = r115.getValue();
        if ((r116 instanceof String) == false) goto L38;
        if (r117 == null) goto L38;
        r101.put(r116, r117);
        goto L38
    L77:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L29
        Field r119 = r106.getClass().getDeclaredField("params");     // Catch: Throwable -> L29
        r119.setAccessible(true);     // Catch: Throwable -> L29
        Object r120 = r119.get(r106);     // Catch: Throwable -> L29
        if ((r120 instanceof Map) == false) goto L26;
        Map r121 = (Map) r120;     // Catch: Throwable -> L29
    L27:
        Object r122 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L29
    L32:
        if (Result.m9455isFailureimpl(r122) == false) goto L34;
        r122 = null;
    L34:
        r113 = (Map) r122;
        goto L35
    L26:
        r121 = null;
    L29:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    L12:
        r107 = null;
    L43:
        List<String> r124 = f256933c.invoke();
        if (r124 == null) goto L46;
        r101.keySet().removeAll(r124);
    L46:
        Map<String, f> r125 = PrefetchManager.f256936a.snapshot();
        Iterator<T> r126 = r125.keySet().iterator();
    L48:
        if (r126.hasNext() == false) goto L55;
        Object r127 = r126.next();
        String r128 = (String) r127;
        f r129 = r125.get(r128);
        if (r129 != null) goto L52;
        boolean r130 = false;
    L53:
        if (r130 == false) goto L48;
        r103 = r127;
        goto L55
    L52:
        int r131 = d.f256941a;
        r130 = Intrinsics.areEqual(d.a.a(r101, r129.f256945b.k().f256942a, r129.f256945b.k().f256943b), r128);
    L55:
        String r132 = (String) r103;
        if (r132 != null) goto L58;
        r132 = "";
    L58:
        f r133 = PrefetchManager.f256936a.get(r132);
        if (r133 == null) goto L62;
        String r134 = r133.f256944a;
        if (r134 == null) goto L62;
    L63:
        Map<String, String> r135 = PrefetchManager.f256937b;
        String r136 = (String) ((LinkedHashMap) r135).get(r134);
        if (r136 != null) goto L68;
        r136 = r135.put(r134, r134);
        if (r136 != null) goto L68;
        r136 = r134;
    L68:
        monitor-enter(r136);
        SsResponse<?> r137 = f(r110, r134, r100);     // Catch: Throwable -> L72
        monitor-exit(r136);
        return r137;
    L72:
        th = move-exception;
        throw th;
    L62:
        int r138 = d.f256941a;
        r134 = d.a.a(r101, this.f256934a.k().f256942a, this.f256934a.k().f256943b);
        goto L63
    }

    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (this.f256935b == true) goto L5;
        return;
    L5:
        int r102 = com.bytedance.locallife.biz.mob.a.f256703c;
        Map r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("type", r100), TuplesKt.to("scene", this.f256934a.getScene()), TuplesKt.to("preScene", this.f256934a.i()), TuplesKt.to("message", r101), TuplesKt.to("isPrefetch", String.valueOf(b()))});
        Iterator<T> r104 = this.f256934a.a().keySet().iterator();
    L7:
        if (r104.hasNext() == false) goto L14;
        String r105 = (String) r104.next();
        if (r103.containsKey(r105) == true) goto L7;
        String r106 = this.f256934a.a().get(r105);
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        r103.put(r105, r106);
        goto L7
    L14:
        Unit r107 = Unit.INSTANCE;
        com.bytedance.locallife.biz.mob.a.C3646a.c("PRE_REQUEST_EXCEPTION", r103);
    }

    public static /* synthetic */ void e(AbsPrefetchInterceptor r110, boolean r111, boolean r112, long r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r114 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r114 & 4) == 0) goto L14;
        r113 = -1;
    L14:
        if ((r114 & 8) == 0) goto L16;
        long r102 = -1;
    L17:
        r110.d(r100, r101, r113, r102, null, null, null);
        return;
    L16:
        r102 = 0;
        goto L17
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final void d(boolean r100, boolean r101, long r102, long r103, Long r110, String r111, String r112) {
        if (this.f256935b == true) goto L5;
        return;
    L5:
        b();
        this.f256934a.getScene();
        b();
        int r104 = com.bytedance.locallife.biz.mob.a.f256703c;
        Pair[] r105 = new Pair[5];
        r105[0] = TuplesKt.to("scene", this.f256934a.getScene());
        if (r111 != null) goto L8;
        r111 = this.f256934a.i();
    L8:
        r105[1] = TuplesKt.to("preScene", r111);
        if (r112 != null) goto L11;
        this.f256934a.f();
        r112 = "default";
    L11:
        r105[2] = TuplesKt.to("preMethod", r112);
        r105[3] = TuplesKt.to("isSuccess", String.valueOf(r100));
        r105[4] = TuplesKt.to("isPrefetch", String.valueOf(b()));
        Map r113 = MapsKt.mutableMapOf(r105);
        if (b() == true) goto L22;
        r113.put("hasFocus", String.valueOf(r101));
        if (r101 == false) goto L18;
        if (r100 == false) goto L18;
        r113.put("intervalTime", String.valueOf(r103));
    L18:
        if (r110 == null) goto L20;
        long r106 = r110.longValue();
    L21:
        r113.put("freeTime", String.valueOf(RangesKt.coerceAtLeast(0, r106)));
        goto L22
    L20:
        r106 = 0;
    L22:
        if (r100 == false) goto L24;
        r113.put("requestTime", String.valueOf(r102));
    L24:
        Unit r107 = Unit.INSTANCE;
        com.bytedance.locallife.biz.mob.a.C3646a.c("PRE_REQUEST_MOB", r113);
        b();
    }
}
