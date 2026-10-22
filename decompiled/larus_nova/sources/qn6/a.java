package qn6;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.core.BaseDitoView;
import com.bytedance.locallife.dito.core.e0;
import com.bytedance.locallife.dito.core.y;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Field f534076r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Field f534077s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Class<?> f534078t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Field f534079u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Field f534080v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Field f534081w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Field f534082x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Class<?> f534083y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f534084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Rect> f534085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f534086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Float f534087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, String> f534088e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public y f534089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f534090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f534091h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f534092i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f534093j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Boolean> f534094k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function1<? super String, Unit> f534095l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.locallife.biz.mob.a f534096m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f534097n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f534098o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f534099p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f534100q;

    /* JADX INFO: renamed from: qn6.a$a, reason: collision with other inner class name */
    public static final class C7366a {
    }

    static {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(ViewGroup.class.getDeclaredField("mFirstTouchTarget"));     // Catch: Throwable -> L5
    L7:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        Object r103 = null;
        if (r102 == null) goto L11;
        HostServiceUtilsKt.c().a(r102);
        r101 = null;
    L11:
        f534076r = (Field) r101;
        Object r104 = Result.m9449constructorimpl(View.class.getDeclaredField("mListenerInfo"));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L20;
        HostServiceUtilsKt.c().a(r105);
        r104 = null;
    L20:
        f534077s = (Field) r104;
        Object r106 = Result.m9449constructorimpl(a("android.view.View$ListenerInfo"));     // Catch: Throwable -> L23
    L25:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L29;
        HostServiceUtilsKt.c().a(r107);
        r106 = null;
    L29:
        Class<?> r108 = (Class) r106;
        f534078t = r108;
        if (r108 != null) goto L100;
        Field r109 = null;
    L35:
        Object r110 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L32
    L38:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L42;
        HostServiceUtilsKt.c().a(r111);
        r110 = null;
    L42:
        f534079u = (Field) r110;
        Class<?> r112 = f534078t;     // Catch: Throwable -> L49
        if (r112 == null) goto L46;
        Field r113 = r112.getDeclaredField("mOnClickListener");     // Catch: Throwable -> L49
    L47:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L49
    L51:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L55;
        HostServiceUtilsKt.c().a(r115);
        r114 = null;
    L55:
        f534080v = (Field) r114;
        Class<?> r116 = f534078t;     // Catch: Throwable -> L62
        if (r116 == null) goto L59;
        Field r117 = r116.getDeclaredField("mOnLongClickListener");     // Catch: Throwable -> L62
    L60:
        Object r118 = Result.m9449constructorimpl(r117);     // Catch: Throwable -> L62
    L64:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L68;
        HostServiceUtilsKt.c().a(r119);
        r118 = null;
    L68:
        f534081w = (Field) r118;
        Object r120 = Result.m9449constructorimpl(a("android.view.ViewGroup$TouchTarget").getDeclaredField(MapBundleKey.OfflineMapKey.OFFLINE_CHILD));     // Catch: Throwable -> L71
    L73:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);
        if (r121 == null) goto L77;
        HostServiceUtilsKt.c().a(r121);
        r120 = null;
    L77:
        f534082x = (Field) r120;
        Object r122 = Result.m9449constructorimpl(a("com.lynx.tasm.LynxView"));     // Catch: Throwable -> L80
    L82:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 != null) goto L85;
        r103 = r122;
    L86:
        f534083y = (Class) r103;
        return;
    L85:
        HostServiceUtilsKt.c().a(r123);
    L80:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L71:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L73
    L59:
        r117 = null;
    L62:
        th = move-exception;
        Result.Companion r126 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L64
    L46:
        r113 = null;
    L49:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L32:
        th = move-exception;
        Result.Companion r128 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    L100:
        r109 = r108.getDeclaredField("mOnTouchListener");     // Catch: Throwable -> L32
    L23:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L14:
        th = move-exception;
        Result.Companion r130 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void g() {
        if (this.f534100q == true) goto L6;
        return;
    L6:
        if (this.f534098o == false) goto L9;
        return;
    L9:
        if (this.f534088e.isEmpty() == false) goto L11;
        return;
    L11:
        this.f534098o = true;
        y r100 = this.f534089f;
        Unit r101 = null;
        if (r100 == null) goto L16;
        e0 r102 = r100.f258164f;
        if (r102 == null) goto L16;
        Long r103 = Long.valueOf(r102.f257909b);
    L17:
        if (r103 == null) goto L25;
        long r104 = SystemClock.elapsedRealtime();
        y r105 = this.f534089f;
        if (r105 == null) goto L23;
        e0 r106 = r105.f258164f;
        if (r106 == null) goto L23;
        long r107 = r104 - r106.f257909b;
    L24:
        this.f534088e.put("operation_interval", String.valueOf(r107));
    L23:
        r107 = 0;
    L25:
        com.bytedance.locallife.biz.mob.a r108 = this.f534096m;
        if (r108 == null) goto L28;
        r108.a(this.f534099p, this.f534088e);
        r101 = Unit.INSTANCE;
    L28:
        if (r101 != null) goto L31;
        int r109 = com.bytedance.locallife.biz.mob.a.f256703c;
        com.bytedance.locallife.biz.mob.a.C3646a.c(this.f534099p, this.f534088e);
        return;
    L31:
        return;
    L16:
        r103 = null;
        goto L17
    }

    public final void i() {
        Function0<Boolean> r100 = this.f534094k;     // Catch: Throwable -> L39
        if (r100 == null) goto L8;
        if (r100.invoke().booleanValue() == true) goto L8;
        return;
    L8:
        if (this.f534084a == false) goto L11;
        return;
    L11:
        if (this.f534091h.length() != 0) goto L13;
        boolean r101 = true;
    L14:
        if (r101 == false) goto L17;
        return;
    L17:
        if (this.f534088e.isEmpty() == false) goto L19;
        return;
    L19:
        this.f534084a = true;     // Catch: Throwable -> L39
        this.f534088e.put(ILiveRoomPlayFragmentConstant.EXTRA_OPERATION_TYPE, this.f534091h);     // Catch: Throwable -> L39
        this.f534088e.put("click_node_tag", this.f534092i);     // Catch: Throwable -> L39
        y r102 = this.f534089f;     // Catch: Throwable -> L39
        Unit r103 = null;
        if (r102 == null) goto L24;
        e0 r104 = r102.f258164f;     // Catch: Throwable -> L39
        if (r104 == null) goto L24;
        Long r105 = Long.valueOf(r104.f257909b);     // Catch: Throwable -> L39
    L25:
        if (r105 == null) goto L33;
        long r106 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L39
        y r107 = this.f534089f;     // Catch: Throwable -> L39
        if (r107 == null) goto L31;
        e0 r108 = r107.f258164f;     // Catch: Throwable -> L39
        if (r108 == null) goto L31;
        long r109 = r106 - r108.f257909b;     // Catch: Throwable -> L39
    L32:
        this.f534088e.put("operation_interval", String.valueOf(r109));     // Catch: Throwable -> L39
    L31:
        r109 = 0;
    L33:
        com.bytedance.locallife.biz.mob.a r110 = this.f534096m;     // Catch: Throwable -> L39
        if (r110 == null) goto L36;
        r110.a(this.f534093j, this.f534088e);     // Catch: Throwable -> L39
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L39
    L36:
        if (r103 != null) goto L44;
        int r111 = com.bytedance.locallife.biz.mob.a.f256703c;     // Catch: Throwable -> L39
        com.bytedance.locallife.biz.mob.a.C3646a.c(this.f534093j, this.f534088e);     // Catch: Throwable -> L39
        return;
    L44:
        return;
    L24:
        r105 = null;
        goto L25
    L13:
        r101 = false;
    L39:
        th = move-exception;
        HostServiceUtilsKt.c().a(th);
    }

    public a() {
        this.f534085b = CollectionsKt.emptyList();
        this.f534088e = new HashMap();
        this.f534090g = 3;
        this.f534091h = "";
        this.f534092i = "";
        this.f534093j = "operation_on_poi_detail";
        this.f534097n = "other";
        this.f534099p = "click_on_poi_detail";
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static View b(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static Object e(Object r100) {
        Field r101 = f534082x;     // Catch: Throwable -> L25
        if (r101 == null) goto L7;
        r101.setAccessible(true);     // Catch: Throwable -> L25
    L7:
        if (r101 == null) goto L9;
        Object r102 = r101.get(r100);     // Catch: Throwable -> L25
    L11:
        if ((r102 instanceof ViewGroup) == false) goto L32;
        Field r103 = f534076r;     // Catch: Throwable -> L20
        if (r103 == null) goto L16;
        r103.setAccessible(true);     // Catch: Throwable -> L20
    L16:
        if (r103 == null) goto L19;
        Object r104 = r103.get(r102);     // Catch: Throwable -> L20
    L22:
        if (r104 == null) goto L33;
        return e(r104);
    L33:
        return r102;
    L19:
        r104 = null;
    L20:
        th = move-exception;
        HostServiceUtilsKt.c().a(th);     // Catch: Throwable -> L25
        goto L19
    L32:
        return r102;
    L9:
        r102 = null;
    L25:
        th = move-exception;
        HostServiceUtilsKt.c().a(th);
        return null;
    }

    public final void h(String r100) {
        if (this.f534091h.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        this.f534091h = r100;
    L8:
        i();
        Function1<? super String, Unit> r102 = this.f534095l;
        if (r102 == null) goto L12;
        r102.invoke(r100);
        return;
    L12:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void c(Window r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNullParameter(r101, "ev");
        int r102 = r101.getAction();     // Catch: Throwable -> L132
        if (r102 == 0) goto L130;
        boolean r103 = true;
        if (r102 == 1) goto L29;
        if (r102 != 2) goto L145;
        Float r104 = this.f534087d;     // Catch: Throwable -> L132
        if (r104 == null) goto L146;
        float r105 = r104.floatValue();     // Catch: Throwable -> L132
        Integer r106 = this.f534086c;     // Catch: Throwable -> L132
        if (r106 == null) goto L147;
        int r107 = r106.intValue();     // Catch: Throwable -> L132
        int r108 = this.f534090g;     // Catch: Throwable -> L132
        if (r108 == 1) goto L27;
        if (r108 == 2) goto L24;
        if (r108 == 3) goto L21;
        return;
    L21:
        if (Math.abs(r101.getRawY() - r105) < r107) goto L148;
        h(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);     // Catch: Throwable -> L132
        return;
    L148:
        return;
    L24:
        if ((r101.getRawY() - r105) < r107) goto L150;
        h(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);     // Catch: Throwable -> L132
        return;
    L150:
        return;
    L27:
        if ((r101.getRawY() - r105) > (-r107)) goto L152;
        h(GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);     // Catch: Throwable -> L132
        return;
    L152:
        return;
    L147:
        return;
    L146:
        return;
    L145:
        return;
    L29:
        Iterator<T> r109 = this.f534085b.iterator();     // Catch: Throwable -> L132
    L31:
        if (r109.hasNext() == false) goto L35;
        if (((Rect) r109.next()).contains((int) r101.getRawX(), (int) r101.getRawY()) == false) goto L31;
        return;
    L35:
        Float r110 = this.f534087d;     // Catch: Throwable -> L132
        if (r110 != null) goto L38;
        return;
    L38:
        float r111 = r110.floatValue();     // Catch: Throwable -> L132
        Integer r112 = this.f534086c;     // Catch: Throwable -> L132
        Object r113 = null;
        if (r112 != null) goto L41;
    L44:
        View r114 = b(r100);     // Catch: Throwable -> L132
        Field r115 = f534076r;     // Catch: Throwable -> L53
        if (r115 == null) goto L49;
        r115.setAccessible(true);     // Catch: Throwable -> L53
    L49:
        if (r115 == null) goto L52;
        Object r116 = r115.get(r114);     // Catch: Throwable -> L53
    L55:
        if (r116 == null) goto L154;
        g();     // Catch: Throwable -> L132
        Object r117 = e(r116);     // Catch: Throwable -> L132
        if (r117 == null) goto L110;
        if ((r117 instanceof ViewGroup) == false) goto L110;
        Class<?> r118 = f534083y;     // Catch: Throwable -> L132
        if (r118 == null) goto L110;
        if (r118.isInstance(r117) == true) goto L110;
        Field r119 = f534077s;     // Catch: Throwable -> L100
        if (r119 == null) goto L68;
        r119.setAccessible(true);     // Catch: Throwable -> L100
    L68:
        if (r119 == null) goto L70;
        Object r120 = r119.get(r117);     // Catch: Throwable -> L100
    L71:
        if (r120 == null) goto L102;
        Field r121 = f534079u;     // Catch: Throwable -> L100
        if (r121 == null) goto L76;
        r121.setAccessible(true);     // Catch: Throwable -> L100
    L76:
        if (r121 == null) goto L78;
        Object r122 = r121.get(r120);     // Catch: Throwable -> L100
    L79:
        if (r122 != null) goto L103;
        Field r123 = f534080v;     // Catch: Throwable -> L100
        if (r123 == null) goto L85;
        r123.setAccessible(true);     // Catch: Throwable -> L100
    L85:
        if (r123 == null) goto L87;
        Object r124 = r123.get(r120);     // Catch: Throwable -> L100
    L88:
        if (r124 != null) goto L103;
        Field r125 = f534081w;     // Catch: Throwable -> L100
        if (r125 == null) goto L94;
        r125.setAccessible(true);     // Catch: Throwable -> L100
    L94:
        if (r125 == null) goto L97;
        Object r126 = r125.get(r120);     // Catch: Throwable -> L100
    L98:
        if (r126 == null) goto L102;
    L97:
        r126 = null;
        goto L98
    L87:
        r124 = null;
    L103:
        if (r103 == true) goto L110;
        String r127 = this.f534097n;     // Catch: Throwable -> L132
        if (r127 != null) goto L107;
        r127 = "other";
    L107:
        h(r127);     // Catch: Throwable -> L132
        return;
    L78:
        r122 = null;
    L102:
        r103 = false;
        goto L103
    L70:
        r120 = null;
    L100:
        th = move-exception;
        HostServiceUtilsKt.c().a(th);     // Catch: Throwable -> L132
    L110:
        if (this.f534084a == false) goto L140;
    L129:
        h("click");     // Catch: Throwable -> L132
        return;
    L140:
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L119
        float r129 = r101.getRawX();     // Catch: Throwable -> L119
        float r130 = r101.getRawY();     // Catch: Throwable -> L119
        Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L119
        BaseDitoView r131 = d(b(r100), r129, r130, new int[2]);     // Catch: Throwable -> L119
        if (r131 == null) goto L116;
        BaseDitoModel r132 = r131.getModel();     // Catch: Throwable -> L119
        if (r132 == null) goto L116;
        String r133 = r132.f258493b.f258222b;     // Catch: Throwable -> L119
    L117:
        Object r134 = Result.m9449constructorimpl(String.valueOf(r133));     // Catch: Throwable -> L119
    L122:
        if (Result.m9455isFailureimpl(r134) == true) goto L125;
        r113 = r134;
    L125:
        String r135 = (String) r113;     // Catch: Throwable -> L132
        if (r135 != null) goto L128;
        r135 = "";
    L128:
        this.f534092i = r135;     // Catch: Throwable -> L132
    L116:
        r133 = null;
    L119:
        th = move-exception;
        Result.Companion r136 = Result.Companion;     // Catch: Throwable -> L132
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L132
        goto L122
    L154:
        return;
    L52:
        r116 = null;
    L53:
        th = move-exception;
        HostServiceUtilsKt.c().a(th);     // Catch: Throwable -> L132
        goto L52
    L41:
        if (Math.abs(r101.getRawY() - r111) < r112.intValue()) goto L44;
        this.f534087d = null;     // Catch: Throwable -> L132
        return;
    L130:
        this.f534087d = Float.valueOf(r101.getRawY());     // Catch: Throwable -> L132
        return;
    L132:
        th = move-exception;
        HostServiceUtilsKt.c().a(th);
    }

    public static BaseDitoView d(View r100, float r101, float r102, int[] r103) {
        if (r100.getVisibility() == 0) goto L5;
        return null;
    L5:
        r100.getLocationOnScreen(r103);
        int r104 = r103[0];
        int r105 = r103[1];
        int r106 = r100.getWidth() + r104;
        int r107 = r100.getHeight() + r105;
        if (r101 >= r104) goto L8;
    L28:
        return null;
    L8:
        if (r101 > r106) goto L28;
        if (r102 < r105) goto L28;
        if (r102 > r107) goto L28;
        boolean r108 = r100 instanceof BaseDitoView;
        if (r108 == false) goto L20;
        if (r108 == true) goto L18;
        return null;
    L18:
        return (BaseDitoView) r100;
    L20:
        if ((r100 instanceof ViewGroup) == false) goto L28;
        ViewGroup r109 = (ViewGroup) r100;
        int r110 = r109.getChildCount() - 1;
    L23:
        if ((-1) >= r110) goto L28;
        BaseDitoView r111 = d(r109.getChildAt(r110), r101, r102, r103);
        if (r111 != null) goto L26;
        r110 = r110 - 1;
        goto L23
    L26:
        return r111;
    }

    public static void f(a r100, Context r101, List r102, int r103, String r104, Function0 r105, Function1 r106, com.bytedance.locallife.biz.mob.a r107, String r110, boolean r111, y r112, int r113) {
        if ((r113 & 4) == 0) goto L6;
        r103 = 3;
    L6:
        if ((r113 & 8) == 0) goto L9;
        r104 = "operation_on_poi_detail";
    L9:
        if ((r113 & 32) == 0) goto L12;
        r105 = null;
    L12:
        if ((r113 & 64) == 0) goto L15;
        r106 = null;
    L15:
        if ((r113 & 128) == 0) goto L18;
        r107 = null;
    L18:
        if ((r113 & 256) == 0) goto L21;
        r110 = "other";
    L21:
        if ((r113 & 512) == 0) goto L24;
        r111 = false;
    L24:
        if ((r113 & 1024) == 0) goto L26;
        r112 = null;
    L26:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "rects");
        Intrinsics.checkNotNullParameter(r104, "eventName");
        r100.f534085b = r102;
        r100.f534086c = Integer.valueOf(ViewConfiguration.get(r101).getScaledTouchSlop());
        r100.f534090g = r103;
        r100.f534093j = r104;
        r100.f534094k = r105;
        r100.f534095l = r106;
        r100.f534096m = r107;
        r100.f534097n = r110;
        r100.f534100q = r111;
        r100.f534089f = r112;
    }
}
