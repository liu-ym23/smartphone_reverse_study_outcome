package com.bytedance.android.window.shop.home.tab.common;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.google.gson.Gson;
import hq7.d;
import java.util.Map;
import jj4.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import zq3.c;
import zq3.d0;
import zq3.h0;
import zq3.i0;
import zq3.k0;
import zq3.l;
import zq3.n;
import zq3.q;
import zq3.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowConstDef {
    public static final fo.a<WindowLayoutType> a = null;
    public static final boolean b = false;
    public static final Lazy c = null;
    public static final long d = 0;
    public static final boolean e = false;
    public static final boolean f = false;
    public static final Lazy g = null;
    public static final Lazy h = null;
    public static final Lazy i = null;
    public static final Lazy j = null;
    public static final Lazy k = null;
    public static final Lazy l = null;
    public static final Lazy m = null;
    public static final Lazy n = null;
    public static final Lazy o = null;
    public static final Lazy p = null;
    public static final Lazy q = null;
    public static final Lazy r = null;
    public static final boolean s = false;
    public static final boolean t = false;
    public static final boolean u = false;
    public static final Lazy v = null;
    public static final Map<String, Integer> w = null;
    public static final Lazy x = null;
    public static final int y = 0;

    public WindowConstDef() {
    }

    public static boolean a() {
        return ((Boolean) n.getValue()).booleanValue();
    }

    static {
        Object r2 = 0;
        a = new fo.a("product_tab_layout", new WindowLayoutType[0]);
        int r0 = l.a;
        Object r3 = null;
        if (c.b == false) goto L13;
        int r1 = p.a;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L9
        b r5 = b.b;     // Catch: Throwable -> L9
        Object r6 = jj4.a.a("window_feed_use_list_kit", Integer.class, r2, false);     // Catch: Throwable -> L9
        if (r6 != null) goto L40;
        Intrinsics.throwNpe();     // Catch: Throwable -> L9
    L40:
        if (((Number) r6).intValue() != 1) goto L42;
        boolean r7 = true;
    L43:
        b = r7;
        c = LazyKt.lazy(WindowConstDef$WINDOW_HYBRID_LIST_USE_ASYNC_TRANSFORM$2.INSTANCE);
        Gson r8 = c.a;
        Object r9 = 0L;
        if (c.b == false) goto L55;
        int r10 = p.a;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L50
        b r12 = b.b;     // Catch: Throwable -> L50
        Object r13 = jj4.a.a("window_header_transition_duration", Long.class, r9, false);     // Catch: Throwable -> L50
        if (r13 != null) goto L81;
        Intrinsics.throwNpe();     // Catch: Throwable -> L50
    L81:
        d = ((Number) r13).longValue();
        Lazy r14 = ECSettingKeys.a;
        int r15 = p.a;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L86
        b r17 = b.b;     // Catch: Throwable -> L86
        Object r18 = jj4.a.a("ec_window_feed_scale_enable", Integer.class, r2, false);     // Catch: Throwable -> L86
        if (r18 != null) goto L91;
        Intrinsics.throwNpe();     // Catch: Throwable -> L86
    L91:
        if (((Number) r18).intValue() != 1) goto L93;
        boolean r19 = true;
    L94:
        e = r19;
        int r20 = l.a;
        if (c.b == false) goto L105;
        int r21 = p.a;
        b r22 = b.b;     // Catch: Throwable -> L101
        Object r23 = jj4.a.a("window_header_use_list_kit", Integer.class, r2, false);     // Catch: Throwable -> L101
        if (r23 != null) goto L132;
        Intrinsics.throwNpe();     // Catch: Throwable -> L101
    L132:
        if (((Number) r23).intValue() != 1) goto L134;
        boolean r24 = true;
    L135:
        f = r24;
        g = LazyKt.lazy(WindowConstDef$WINDOW_LAUNCH_VIEW_PRECREATE$2.INSTANCE);
        h = LazyKt.lazy(WindowConstDef$WINDOW_TAB_REQUEST_PAGE_SIZE$2.INSTANCE);
        i = LazyKt.lazy(WindowConstDef$WINDOW_TAB_LAYOUT_SMILE_INDICATOR$2.INSTANCE);
        j = LazyKt.lazy(WindowConstDef$WINDOW_LAUNCH_TASK_OPT$2.INSTANCE);
        k = LazyKt.lazy(WindowConstDef$WINDOW_ROOT_XML_USE_SYNC_INFLATER$2.INSTANCE);
        l = LazyKt.lazy(WindowConstDef$WINDOW_LAUNCH_VIEW_PRECREATE_CNT$2.INSTANCE);
        m = LazyKt.lazy(WindowConstDef$WINDOW_DYNAMIC_RENDER_PERF_OPT$2.INSTANCE);
        n = LazyKt.lazy(WindowConstDef$WINDOW_PRICE_USE_DOUYIN_NUM_ABC$2.INSTANCE);
        o = LazyKt.lazy(WindowConstDef$WINDOW_LAUNCH_TAB_PRECREATE$2.INSTANCE);
        p = LazyKt.lazy(WindowConstDef$WINDOW_LIVE_DATA_OPT$2.INSTANCE);
        q = LazyKt.lazy(WindowConstDef$COMMON_HORIZONTAL_EDGE_MARGIN$2.INSTANCE);
        r = LazyKt.lazy(WindowConstDef$WINDOW_HEADER_NICK_NAME_EMOJI_SUPPORT$2.INSTANCE);
        int r25 = l.a;
        Gson r26 = c.a;
        Object r27 = Boolean.TRUE;
        if (c.b == false) goto L147;
        int r28 = p.a;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L142
        b r30 = b.b;     // Catch: Throwable -> L142
        Object r31 = jj4.a.a("window_dynamic_view_enable_cache", Boolean.class, r27, false);     // Catch: Throwable -> L142
        if (r31 != null) goto L173;
        Intrinsics.throwNpe();     // Catch: Throwable -> L142
    L173:
        s = ((Boolean) r31).booleanValue();
        int r32 = l.a;
        Gson r33 = c.a;
        Object r34 = Boolean.TRUE;
        if (c.b == false) goto L185;
        int r35 = p.a;
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L180
        b r37 = b.b;     // Catch: Throwable -> L180
        Object r38 = jj4.a.a("window_tags_enable_cache", Boolean.class, r34, false);     // Catch: Throwable -> L180
        if (r38 != null) goto L211;
        Intrinsics.throwNpe();     // Catch: Throwable -> L180
    L211:
        t = ((Boolean) r38).booleanValue();
        int r39 = l.a;
        Gson r40 = c.a;
        Object r41 = Boolean.TRUE;
        if (c.b == false) goto L223;
        int r42 = p.a;
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L218
        b r44 = b.b;     // Catch: Throwable -> L218
        Object r45 = jj4.a.a("window_search_use_new_path", Boolean.class, r41, false);     // Catch: Throwable -> L218
        if (r45 != null) goto L249;
        Intrinsics.throwNpe();     // Catch: Throwable -> L218
    L249:
        u = ((Boolean) r45).booleanValue();
        v = LazyKt.lazy(WindowConstDef$WINDOW_TITLE_PREFIX_ICON_BIND_OPT$2.INSTANCE);
        if (c.b == false) goto L261;
        int r46 = p.a;
        Result.Companion r47 = Result.Companion;     // Catch: Throwable -> L256
        b r48 = b.b;     // Catch: Throwable -> L256
        Object r49 = jj4.a.a("window_tab_use_dynamic_product", Integer.class, r2, false);     // Catch: Throwable -> L256
        if (r49 != null) goto L288;
        Intrinsics.throwNpe();     // Catch: Throwable -> L256
    L288:
        if (((Number) r49).intValue() != 1) goto L290;
        int r50 = 1;
    L291:
        w = MapsKt.mapOf(new Pair[]{TuplesKt.to("window_header_use_list_kit", Integer.valueOf(f ? 1 : 0)), TuplesKt.to("window_tab_use_dynamic_product", Integer.valueOf(r50))});
        x = LazyKt.lazy(WindowConstDef$WINDOW_FIX_LAYOUT_SWITCH$2.INSTANCE);
        int r51 = p.a;
        Object r52 = 10;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L296
        b r54 = b.b;     // Catch: Throwable -> L296
        Object r55 = jj4.a.a("window_hybrid_feed_request_preload_threshold", Integer.class, r52, false);     // Catch: Throwable -> L296
        if (r55 != null) goto L302;
        Intrinsics.throwNpe();     // Catch: Throwable -> L296
    L302:
        y = RangesKt.coerceIn(((Number) r55).intValue(), 1, 100);
        return;
    L296:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        Object r57 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r57) == true) goto L301;
        r52 = r57;
    L301:
        r55 = r52;
        goto L302
    L290:
        r50 = 0;
    L256:
        th = move-exception;
        Result.Companion r58 = Result.Companion;
        Object r59 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r59) == true) goto L285;
    L260:
        r2 = r59;
    L285:
        r49 = r2;
        goto L288
    L261:
        String r60 = d.b("debug.shopping.mock.window_tab_use_dynamic_product");
        if (r60 != null) goto L264;
    L267:
        boolean r61 = true;
    L268:
        if (r61 == false) goto L338;
    L276:
        if (r3 != null) goto L286;
        int r62 = p.a;
        Result.Companion r63 = Result.Companion;     // Catch: Throwable -> L282
        b r64 = b.b;     // Catch: Throwable -> L282
        r49 = jj4.a.a("window_tab_use_dynamic_product", Integer.class, r2, false);     // Catch: Throwable -> L282
        if (r49 != null) goto L288;
        Intrinsics.throwNpe();     // Catch: Throwable -> L282
    L282:
        th = move-exception;
        Result.Companion r65 = Result.Companion;
        r59 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r59) == false) goto L260;
    L286:
        r49 = r3;
        goto L288
    L338:
        Object r66 = c.a.fromJson(r60, new h0().getType());     // Catch: Exception -> L274
        if (r66 == null) goto L276;
        r3 = r66;
    L274:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L276
    L264:
        if (StringsKt.isBlank(r60) == true) goto L267;
        r61 = false;
    L218:
        th = move-exception;
        Result.Companion r67 = Result.Companion;
        Object r68 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r68) == true) goto L248;
    L222:
        r41 = r68;
    L248:
        r45 = r41;
        goto L249
    L223:
        String r69 = d.b("debug.shopping.mock.window_search_use_new_path");
        if (r69 != null) goto L226;
    L229:
        boolean r70 = true;
    L230:
        if (r70 == false) goto L320;
    L238:
        r45 = null;
    L239:
        if (r45 != null) goto L249;
        int r71 = p.a;
        Result.Companion r72 = Result.Companion;     // Catch: Throwable -> L245
        b r73 = b.b;     // Catch: Throwable -> L245
        r45 = jj4.a.a("window_search_use_new_path", Boolean.class, r41, false);     // Catch: Throwable -> L245
        if (r45 != null) goto L249;
        Intrinsics.throwNpe();     // Catch: Throwable -> L245
    L245:
        th = move-exception;
        Result.Companion r74 = Result.Companion;
        r68 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r68) == false) goto L222;
    L320:
        r45 = c.a.fromJson(r69, new d0().getType());     // Catch: Exception -> L236
        if (r45 == null) goto L238;
    L236:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L238
    L226:
        if (StringsKt.isBlank(r69) == true) goto L229;
        r70 = false;
    L180:
        th = move-exception;
        Result.Companion r75 = Result.Companion;
        Object r76 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r76) == true) goto L210;
    L184:
        r34 = r76;
    L210:
        r38 = r34;
        goto L211
    L185:
        String r77 = d.b("debug.shopping.mock.window_tags_enable_cache");
        if (r77 != null) goto L188;
    L191:
        boolean r78 = true;
    L192:
        if (r78 == false) goto L340;
    L200:
        r38 = null;
    L201:
        if (r38 != null) goto L211;
        int r79 = p.a;
        Result.Companion r80 = Result.Companion;     // Catch: Throwable -> L207
        b r81 = b.b;     // Catch: Throwable -> L207
        r38 = jj4.a.a("window_tags_enable_cache", Boolean.class, r34, false);     // Catch: Throwable -> L207
        if (r38 != null) goto L211;
        Intrinsics.throwNpe();     // Catch: Throwable -> L207
    L207:
        th = move-exception;
        Result.Companion r82 = Result.Companion;
        r76 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r76) == false) goto L184;
    L340:
        r38 = c.a.fromJson(r77, new i0().getType());     // Catch: Exception -> L198
        if (r38 == null) goto L200;
    L198:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L200
    L188:
        if (StringsKt.isBlank(r77) == true) goto L191;
        r78 = false;
    L142:
        th = move-exception;
        Result.Companion r83 = Result.Companion;
        Object r84 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r84) == true) goto L172;
    L146:
        r27 = r84;
    L172:
        r31 = r27;
        goto L173
    L147:
        String r85 = d.b("debug.shopping.mock.window_dynamic_view_enable_cache");
        if (r85 != null) goto L150;
    L153:
        boolean r86 = true;
    L154:
        if (r86 == false) goto L316;
    L162:
        r31 = null;
    L163:
        if (r31 != null) goto L173;
        int r87 = p.a;
        Result.Companion r88 = Result.Companion;     // Catch: Throwable -> L169
        b r89 = b.b;     // Catch: Throwable -> L169
        r31 = jj4.a.a("window_dynamic_view_enable_cache", Boolean.class, r27, false);     // Catch: Throwable -> L169
        if (r31 != null) goto L173;
        Intrinsics.throwNpe();     // Catch: Throwable -> L169
    L169:
        th = move-exception;
        Result.Companion r90 = Result.Companion;
        r84 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r84) == false) goto L146;
    L316:
        r31 = c.a.fromJson(r85, new n().getType());     // Catch: Exception -> L160
        if (r31 == null) goto L162;
    L160:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L162
    L150:
        if (StringsKt.isBlank(r85) == true) goto L153;
        r86 = false;
        goto L154
    L134:
        r24 = false;
    L101:
        th = move-exception;
        Result.Companion r91 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r23) == false) goto L132;
    L130:
        r23 = r2;
        goto L132
    L105:
        String r92 = d.b("debug.shopping.mock.window_header_use_list_kit");
        if (r92 != null) goto L108;
    L111:
        boolean r93 = true;
    L112:
        if (r93 == false) goto L346;
    L120:
        r23 = null;
    L121:
        if (r23 != null) goto L132;
        int r94 = p.a;
        Result.Companion r95 = Result.Companion;     // Catch: Throwable -> L127
        b r96 = b.b;     // Catch: Throwable -> L127
        r23 = jj4.a.a("window_header_use_list_kit", Integer.class, r2, false);     // Catch: Throwable -> L127
        if (r23 != null) goto L132;
        Intrinsics.throwNpe();     // Catch: Throwable -> L127
    L127:
        th = move-exception;
        Result.Companion r97 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r23) == false) goto L132;
    L346:
        r23 = c.a.fromJson(r92, new r().getType());     // Catch: Exception -> L118
        if (r23 == null) goto L120;
    L118:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L120
    L108:
        if (StringsKt.isBlank(r92) == true) goto L111;
        r93 = false;
        goto L112
    L93:
        r19 = false;
    L86:
        th = move-exception;
        Result.Companion r98 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r18) == false) goto L91;
        r18 = r2;
    L50:
        th = move-exception;
        Result.Companion r99 = Result.Companion;
        Object r100 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r100) == true) goto L80;
    L54:
        r9 = r100;
    L80:
        r13 = r9;
        goto L81
    L55:
        String r101 = d.b("debug.shopping.mock.window_header_transition_duration");
        if (r101 != null) goto L58;
    L61:
        boolean r102 = true;
    L62:
        if (r102 == false) goto L336;
    L70:
        r13 = null;
    L71:
        if (r13 != null) goto L81;
        int r103 = p.a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L77
        b r105 = b.b;     // Catch: Throwable -> L77
        r13 = jj4.a.a("window_header_transition_duration", Long.class, r9, false);     // Catch: Throwable -> L77
        if (r13 != null) goto L81;
        Intrinsics.throwNpe();     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r100 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r100) == false) goto L54;
    L336:
        r13 = c.a.fromJson(r101, new q().getType());     // Catch: Exception -> L68
        if (r13 == null) goto L70;
    L68:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L70
    L58:
        if (StringsKt.isBlank(r101) == true) goto L61;
        r102 = false;
        goto L62
    L42:
        r7 = false;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == false) goto L40;
    L38:
        r6 = r2;
        goto L40
    L13:
        String r108 = d.b("debug.shopping.mock.window_feed_use_list_kit");
        if (r108 != null) goto L16;
    L19:
        boolean r109 = true;
    L20:
        if (r109 == false) goto L314;
    L28:
        r6 = null;
    L29:
        if (r6 != null) goto L40;
        int r110 = p.a;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L35
        b r112 = b.b;     // Catch: Throwable -> L35
        r6 = jj4.a.a("window_feed_use_list_kit", Integer.class, r2, false);     // Catch: Throwable -> L35
        if (r6 != null) goto L40;
        Intrinsics.throwNpe();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r6) == false) goto L40;
    L314:
        r6 = c.a.fromJson(r108, new k0().getType());     // Catch: Exception -> L26
        if (r6 == null) goto L28;
    L26:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L28
    L16:
        if (StringsKt.isBlank(r108) == true) goto L19;
        r109 = false;
        goto L20
    }

    public static boolean b(Integer r0, int r1) {
        if ((r1 & 1) == 0) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L10;
        if (r0.intValue() <= 100) goto L10;
        return false;
    L10:
        return b;
    }
}
