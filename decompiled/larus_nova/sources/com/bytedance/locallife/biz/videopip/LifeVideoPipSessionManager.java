package com.bytedance.locallife.biz.videopip;

import android.content.res.Resources;
import android.util.TypedValue;
import com.bytedance.keva.Keva;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.biz.common.utils.e;
import com.bytedance.locallife.dito.event.BusMutableLiveData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes21.dex */
public final class LifeVideoPipSessionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f256999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayDeque<a> f257000b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f257001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f257002d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Function0<Unit> f257003e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Function0<Unit> f257004f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Function0<Unit> f257005g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Function2<Integer, Integer, Unit> f257006h = null;

    public LifeVideoPipSessionManager() {
    }

    static {
        f257000b = new ArrayDeque();
        f257002d = LazyKt.lazy(LifeVideoPipSessionManager$repo$2.INSTANCE);
        f257003e = LifeVideoPipSessionManager$onPipShow$1.INSTANCE;
        f257004f = LifeVideoPipSessionManager$onPipCancel$1.INSTANCE;
        f257005g = LifeVideoPipSessionManager$onPipClick$1.INSTANCE;
        f257006h = LifeVideoPipSessionManager$onPipDragEnd$1.INSTANCE;
    }

    public static void f() {
        if (f256999a == null) goto L6;
        HostServiceUtilsKt.r0().e();
        return;
    }

    public static boolean g() {
        HostServiceUtilsKt.r0().e();
        return false;
    }

    public static /* synthetic */ boolean b(boolean r100) {
        return a(r100, "");
    }

    public static boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceSessionId");
        yn6.c r101 = yn6.a.f568561a;
        return Intrinsics.areEqual(yn6.a.e(r100, 0, "life_video_pip_session_state"), 1);
    }

    public static void e(String r100) {
        if (f256999a == null) goto L31;
        ArrayDeque<a> r101 = f257000b;
        ListIterator<a> r102 = r101.listIterator(r101.size());
    L6:
        if (r102.hasPrevious() == false) goto L10;
        a r103 = r102.previous();
        if (Intrinsics.areEqual(r103.f257009b, r100) == false) goto L6;
    L11:
        a r104 = r103;
        if (r104 == null) goto L14;
        f257000b.remove(r104);
    L14:
        ArrayDeque<a> r105 = f257000b;
        if (r105.isEmpty() == false) goto L32;
        b r106 = f256999a;
        if (r106 == null) goto L33;
        VIDEO_PIP_SESSION_STATE r107 = r106.f257014b;
        if (r107 != VIDEO_PIP_SESSION_STATE.EXIT) goto L24;
        int r108 = f257001c + 1;
        f257001c = r108;
        if (r108 < c.a().getDislikeActionCount()) goto L26;
        f257001c = 0;
        Lazy r109 = f257002d;
        ((Keva) r109.getValue()).storeBoolean("video_pip_dislike_switch", true);
        ((Keva) r109.getValue()).storeLong("video_pip_dislike_time", System.currentTimeMillis());
    L26:
        f256999a = null;
        r105.clear();
        HostServiceUtilsKt.r0().f();
        return;
    L24:
        if (r107 == VIDEO_PIP_SESSION_STATE.NOT_INITIAL) goto L26;
        f257001c = 0;
        goto L26
    L33:
        return;
    L32:
        return;
    L10:
        r103 = null;
        goto L11
    }

    public static void i(String r110) {
        b r100 = f256999a;
        if (r100 == null) goto L50;
        ArrayDeque<a> r101 = f257000b;
        ListIterator<a> r102 = r101.listIterator(r101.size());
    L6:
        if (r102.hasPrevious() == false) goto L10;
        a r103 = r102.previous();
        if (Intrinsics.areEqual(r103.f257009b, r110) == false) goto L6;
    L11:
        a r104 = r103;
        if (r104 == null) goto L51;
        VIDEO_PIP_SESSION_STATE r111 = r100.f257014b;
        if (r111 != VIDEO_PIP_SESSION_STATE.NOT_INITIAL) goto L44;
        c.a().getVideoPipSize();
        boolean r105 = false;
        if (c.a().getSmallWindowRecord() != 1) goto L27;
        Keva r112 = Keva.getRepo("life_video_small_window_pos");
        if (r112 == null) goto L20;
        int r113 = r112.getInt("pos_x", 0);
    L21:
        if (r113 != 1) goto L23;
        Resources r114 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 12.0f, WindowDisplayMetricsOverride.apply(r114, r114.getDisplayMetrics())));
    L30:
        if (c.a().getSmallWindowRecord() != 1) goto L37;
        Keva r115 = Keva.getRepo("life_video_small_window_pos");
        if (r115 == null) goto L34;
        int r116 = r115.getInt("pos_y", 0);
    L35:
        if (r116 == 0) goto L37;
    L42:
        c.a().getEnablePipWindowOpt();
        HostServiceUtilsKt.r0().a(r104.f257008a, r100.f257013a, r100.f257015c, r104.f257011d, f257003e, f257004f, f257005g, f257006h);
        r104.f257012e = true;
        return;
    L34:
        r116 = 0;
    L37:
        float r117 = c.a().getDefaultPositionYRatio();
        if (r117 != 0.0f) goto L40;
        r105 = true;
    L40:
        if (r105 == true) goto L42;
        Math.ceil(r117 * e.a());
        goto L42
    L23:
        if (r113 == 2) goto L30;
    L20:
        r113 = 0;
    L27:
        if (c.a().getDefaultPositionX() != 1) goto L30;
        Resources r118 = Resources.getSystem();
        MathKt.roundToInt(TypedValue.applyDimension(1, 12.0f, WindowDisplayMetricsOverride.apply(r118, r118.getDisplayMetrics())));
        goto L30
    L44:
        if (r111 != VIDEO_PIP_SESSION_STATE.HIDE) goto L53;
        HostServiceUtilsKt.r0().b();
        r104.f257012e = true;
        return;
    L53:
        return;
    L51:
        return;
    L10:
        r103 = null;
        goto L11
    }

    public static boolean a(boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "awemeId");
        b r100 = f256999a;
        if (r100 == null) goto L6;
        VIDEO_PIP_SESSION_STATE r101 = r100.f257014b;
        if (r101 == null) goto L6;
    L8:
        if (r101 == VIDEO_PIP_SESSION_STATE.EXIT) goto L10;
        boolean r102 = true;
    L11:
        ju6.a r103 = HostServiceUtilsKt.r0();
        if (f256999a != null) goto L14;
        r103.d(r111);
        boolean r112 = false;
    L16:
        if (f256999a != null) goto L18;
        r103.c();
    L18:
        if (r110 == false) goto L32;
        if (r102 == false) goto L32;
        Lazy r113 = f257002d;
        if (((Keva) r113.getValue()).getBoolean("video_pip_dislike_switch", false) == false) goto L28;
        long r104 = ((Keva) r113.getValue()).getLong("video_pip_dislike_time", 0);
        long r105 = System.currentTimeMillis();
        int r106 = c.a().getDislikeDuration();
        long r107 = r105 - r104;
        if (r107 > 0) goto L25;
    L27:
        ((Keva) r113.getValue()).storeBoolean("video_pip_dislike_switch", false);
        goto L28
    L25:
        if (r107 >= ((((r106 * 24) * 60) * 60) * 1000)) goto L27;
        boolean r114 = true;
    L29:
        if (r114 == true) goto L32;
        if (r112 == false) goto L32;
        return true;
    L28:
        r114 = false;
    L32:
        return false;
    L14:
        r112 = true;
        goto L16
    L10:
        r102 = false;
    L6:
        r101 = VIDEO_PIP_SESSION_STATE.NOT_INITIAL;
        goto L8
    }

    public static void h(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "status");
        yn6.c r102 = yn6.a.f568561a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        yn6.a.f(r100, r101, "life_poi_75_flag_now");
    }

    public static void d(String r100, String r101, String r102, BusMutableLiveData r103, HashMap r104) {
        Intrinsics.checkNotNullParameter(r100, "awemeId");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "traceSessionId");
        Intrinsics.checkNotNullParameter(r103, "backClickLiveData");
        Intrinsics.checkNotNullParameter(r104, "trackParams");
        if (f256999a != null) goto L8;
        String r105 = (String) r104.get("enter_from");
        if (r105 != null) goto L7;
        r105 = "";
    L7:
        f256999a = new b(r100, r105);
        f257000b.addLast(new a(r101, r102, new WeakReference(r103), r104));
        return;
    L8:
        f257000b.addLast(new a(r101, r102, new WeakReference(r103), r104));
    }
}
