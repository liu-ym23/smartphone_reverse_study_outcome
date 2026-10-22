package com.haibin.calendarview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.nova.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public final class l {
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int f276155J;
    public final String K;
    public Class<?> L;
    public final String M;
    public Class<?> N;
    public final String O;
    public Class<?> P;
    public final String Q;
    public Class<?> R;
    public final String S;
    public int T;
    public int U;
    public int V;
    public int W;
    public final int X;
    public int Y;
    public final int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f276156a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final int f276157a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f276158b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f276159b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f276160c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final boolean f276161c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f276162d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final int f276163d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f276164e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public Calendar f276165e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f276166f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f276167f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f276168g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f276169g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f276170h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f276171h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f276172i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f276173i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f276174j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public Map<String, Calendar> f276175j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f276176k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public CalendarView.e f276177k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f276178l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public h f276179l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f276180m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public CalendarView.f f276181m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f276182n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public Calendar f276183n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f276184o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public Calendar f276185o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f276186p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final Map<String, Calendar> f276187p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f276188q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f276189q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f276190r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public Calendar f276191r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f276192s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public Calendar f276193s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f276194t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f276195t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f276196u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public int f276197u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f276198v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f276199w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f276200x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f276201y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f276202z;

    public final Calendar c() {
        Calendar r100 = new Calendar();
        r100.setYear(this.f276165e0.getYear());
        r100.setWeek(this.f276165e0.getWeek());
        r100.setMonth(this.f276165e0.getMonth());
        r100.setDay(this.f276165e0.getDay());
        r100.setCurrentDay(true);
        p.c(r100);
        return r100;
    }

    public final Calendar d() {
        Calendar r100 = new Calendar();
        r100.setYear(this.U);
        r100.setMonth(this.W);
        r100.setDay(this.Y);
        r100.setCurrentDay(r100.equals(this.f276165e0));
        p.c(r100);
        return r100;
    }

    public final Calendar e() {
        Calendar r100 = new Calendar();
        r100.setYear(this.T);
        r100.setMonth(this.V);
        r100.setDay(this.X);
        r100.setCurrentDay(r100.equals(this.f276165e0));
        p.c(r100);
        return r100;
    }

    public final void f() {
        Map<String, Calendar> r100 = this.f276175j0;
        if (r100 != null) goto L5;
    L9:
        this.f276183n0.clearScheme();
        return;
    L5:
        if (r100.size() <= 0) goto L9;
        String r101 = this.f276183n0.toString();
        if (this.f276175j0.containsKey(r101) == false) goto L11;
        Calendar r102 = this.f276175j0.get(r101);
        this.f276183n0.mergeScheme(r102, this.S);
        return;
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

    public final void b(List<Calendar> r100) {
        Map<String, Calendar> r101 = this.f276175j0;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.size() == 0) goto L25;
        Iterator r102 = ((ArrayList) r100).iterator();
    L9:
        if (r102.hasNext() == false) goto L26;
        Calendar r103 = (Calendar) r102.next();
        if (this.f276175j0.containsKey(r103.toString()) == true) goto L12;
        r103.setScheme("");
        r103.setSchemeColor(0);
        r103.setSchemes(null);
        goto L9
    L12:
        Calendar r104 = this.f276175j0.get(r103.toString());
        if (TextUtils.isEmpty(r104.getScheme()) == false) goto L15;
        String r105 = this.S;
    L16:
        r103.setScheme(r105);
        r103.setSchemeColor(r104.getSchemeColor());
        r103.setSchemes(r104.getSchemes());
        goto L9
    L15:
        r105 = r104.getScheme();
        goto L16
    L26:
        return;
    }

    public l(Context r110, AttributeSet r111) {
        this.f276187p0 = new HashMap();
        TypedArray r112 = r110.obtainStyledAttributes(r111, new int[]{R.attr.calendar_height, R.attr.calendar_match_parent, R.attr.calendar_padding, R.attr.current_day_lunar_text_color, R.attr.current_day_text_color, R.attr.current_month_lunar_text_color, R.attr.current_month_text_color, R.attr.day_text_size, R.attr.lunar_text_size, R.attr.max_multi_select_size, R.attr.max_select_range, R.attr.max_year, R.attr.max_year_day, R.attr.max_year_month, R.attr.min_select_range, R.attr.min_year, R.attr.min_year_day, R.attr.min_year_month, R.attr.month_view, R.attr.month_view_scrollable, R.attr.month_view_show_mode, R.attr.other_month_lunar_text_color, R.attr.other_month_text_color, R.attr.scheme_lunar_text_color, R.attr.scheme_month_text_color, R.attr.scheme_text, R.attr.scheme_text_color, R.attr.scheme_theme_color, R.attr.select_mode, R.attr.selected_lunar_text_color, R.attr.selected_text_color, R.attr.selected_theme_color, R.attr.week_background, R.attr.week_bar_height, R.attr.week_bar_view, R.attr.week_line_background, R.attr.week_line_margin, R.attr.week_start_with, R.attr.week_text_color, R.attr.week_text_size, R.attr.week_view, R.attr.week_view_scrollable, R.attr.year_view, R.attr.year_view_background, R.attr.year_view_current_day_text_color, R.attr.year_view_day_text_color, R.attr.year_view_day_text_size, R.attr.year_view_month_height, R.attr.year_view_month_margin_bottom, R.attr.year_view_month_margin_top, R.attr.year_view_month_text_color, R.attr.year_view_month_text_size, R.attr.year_view_padding, R.attr.year_view_scheme_color, R.attr.year_view_scrollable, R.attr.year_view_select_text_color, R.attr.year_view_week_height, R.attr.year_view_week_text_color, R.attr.year_view_week_text_size});
        if (p.f276214a == null) goto L6;
    L10:
        this.f276184o = (int) r112.getDimension(2, 0.0f);
        this.f276168g = r112.getColor(26, -1);
        this.f276170h = r112.getColor(23, -1973791);
        int r100 = r112.getColor(27, 1355796431);
        this.I = r100;
        this.K = r112.getString(18);
        this.O = r112.getString(42);
        this.M = r112.getString(40);
        String r101 = r112.getString(34);
        this.Q = r101;
        this.H = r112.getDimensionPixelSize(39, f.a(r110, 12.0f));
        this.f276163d0 = (int) r112.getDimension(33, f.a(r110, 40.0f));
        this.G = (int) r112.getDimension(36, f.a(r110, 0.0f));
        String r102 = r112.getString(25);
        this.S = r102;
        if (TextUtils.isEmpty(r102) == false) goto L13;
        this.S = "记";
    L13:
        this.f276167f0 = r112.getBoolean(19, true);
        this.f276169g0 = r112.getBoolean(41, true);
        this.f276171h0 = r112.getBoolean(54, true);
        this.f276158b = r112.getInt(20, 0);
        this.f276156a = r112.getInt(37, 1);
        this.f276160c = r112.getInt(28, 0);
        this.f276189q0 = r112.getInt(9, Integer.MAX_VALUE);
        this.f276195t0 = r112.getInt(14, -1);
        int r103 = r112.getInt(10, -1);
        this.f276197u0 = r103;
        int r104 = this.f276195t0;
        if (r104 <= r103) goto L17;
        if (r103 <= 0) goto L17;
        this.f276197u0 = r104;
        this.f276195t0 = r104;
    L23:
        this.F = r112.getColor(32, -1);
        this.D = r112.getColor(35, 0);
        this.E = r112.getColor(43, -1);
        this.f276166f = r112.getColor(38, -13421773);
        int r105 = r112.getColor(4, -65536);
        this.f276162d = r105;
        this.f276164e = r112.getColor(3, -65536);
        this.f276155J = r112.getColor(31, 1355796431);
        this.f276176k = r112.getColor(30, -15658735);
        this.f276178l = r112.getColor(29, -15658735);
        this.f276174j = r112.getColor(6, -15658735);
        this.f276172i = r112.getColor(22, -1973791);
        this.f276180m = r112.getColor(5, -1973791);
        this.f276182n = r112.getColor(21, -1973791);
        this.T = r112.getInt(15, 1971);
        this.U = r112.getInt(11, GLMapStaticValue.MAP_PARAMETERNAME_POLYGON_FILL_CONTROL);
        this.V = r112.getInt(17, 1);
        this.W = r112.getInt(13, 12);
        this.X = r112.getInt(16, 1);
        this.Y = r112.getInt(12, -1);
        this.Z = r112.getDimensionPixelSize(7, f.a(r110, 16.0f));
        this.f276157a0 = r112.getDimensionPixelSize(8, f.a(r110, 10.0f));
        this.f276159b0 = (int) r112.getDimension(0, f.a(r110, 56.0f));
        this.f276161c0 = r112.getBoolean(1, false);
        this.f276186p = r112.getDimensionPixelSize(51, f.a(r110, 18.0f));
        this.f276188q = r112.getDimensionPixelSize(46, f.a(r110, 7.0f));
        this.f276200x = r112.getColor(50, -15658735);
        this.f276201y = r112.getColor(45, -15658735);
        this.f276202z = r112.getColor(53, r100);
        this.C = r112.getColor(57, -13421773);
        this.B = r112.getColor(44, r105);
        this.A = r112.getColor(55, -13421773);
        this.f276190r = r112.getDimensionPixelSize(58, f.a(r110, 8.0f));
        this.f276192s = r112.getDimensionPixelSize(47, f.a(r110, 32.0f));
        this.f276194t = r112.getDimensionPixelSize(56, f.a(r110, 0.0f));
        this.f276196u = (int) r112.getDimension(52, f.a(r110, 6.0f));
        this.f276198v = (int) r112.getDimension(49, f.a(r110, 4.0f));
        this.f276199w = (int) r112.getDimension(48, f.a(r110, 4.0f));
        if (this.T > 1900) goto L27;
        this.T = 1900;
    L27:
        if (this.U < 2099) goto L29;
        this.U = 2099;
    L29:
        r112.recycle();
        this.f276165e0 = new Calendar();
        Date r113 = new Date();
        this.f276165e0.setYear(CastIntegerProtector.parseInt(new SimpleDateFormat("yyyy").format(r113)));
        this.f276165e0.setMonth(CastIntegerProtector.parseInt(new SimpleDateFormat("MM").format(r113)));
        this.f276165e0.setDay(CastIntegerProtector.parseInt(new SimpleDateFormat("dd").format(r113)));
        this.f276165e0.setCurrentDay(true);
        p.c(this.f276165e0);
        int r114 = this.T;
        int r115 = this.V;
        int r106 = this.U;
        int r107 = this.W;
        this.T = r114;
        this.V = r115;
        this.U = r106;
        this.W = r107;
        if (r106 >= this.f276165e0.getYear()) goto L33;
        this.U = this.f276165e0.getYear();
    L33:
        if (this.Y != (-1)) goto L35;
        this.Y = f.c(this.U, this.W);
    L35:
        this.f276173i0 = (((this.f276165e0.getYear() - this.T) * 12) + this.f276165e0.getMonth()) - this.V;
    L42:
        e = move-exception;
        e.printStackTrace();
    L73:
    L50:
        e = move-exception;
        e.printStackTrace();
    L75:
    L58:
        e = move-exception;
        e.printStackTrace();
    L71:
    L66:
        e = move-exception;
        e.printStackTrace();
        return;
    L61:
        if (TextUtils.isEmpty(this.M) == false) goto L63;
        Class<n> r116 = n.class;
    L64:
        this.N = r116;     // Catch: Exception -> L66
        return;
    L63:
        r116 = a(this.M);     // Catch: Exception -> L66
        goto L64
    L53:
        if (TextUtils.isEmpty(this.K) == false) goto L55;
        Class<m> r117 = m.class;
    L56:
        this.L = r117;     // Catch: Exception -> L58
        goto L71
    L55:
        r117 = a(this.K);     // Catch: Exception -> L58
        goto L56
    L45:
        if (TextUtils.isEmpty(this.O) == false) goto L47;
        Class<o> r118 = o.class;
        this.P = r118;     // Catch: Exception -> L50
    L48:
        this.P = r118;     // Catch: Exception -> L50
        goto L75
    L47:
        r118 = a(this.O);     // Catch: Exception -> L50
        goto L48
    L37:
        if (TextUtils.isEmpty(r101) == false) goto L39;
        Class<w> r119 = w.class;
        this.R = r119;     // Catch: Exception -> L42
    L40:
        this.R = r119;     // Catch: Exception -> L42
        goto L73
    L39:
        r119 = a(this.Q);     // Catch: Exception -> L42
    L17:
        if (r104 > 0) goto L19;
        this.f276195t0 = -1;
    L20:
        if (r103 > 0) goto L22;
        this.f276197u0 = -1;
        goto L23
    L22:
        this.f276197u0 = r103;
        goto L23
    L19:
        this.f276195t0 = r104;
        goto L20
    L6:
        if (v.f276247a != null) goto L9;
        v.f276247a = r110.getResources().getStringArray(R.array.trunk_string_array);
        r110.getResources().getStringArray(R.array.branch_string_array);
    L9:
        u.f276225a = r110.getResources().getStringArray(R.array.solar_term);
        p.f276214a = r110.getResources().getStringArray(R.array.lunar_first_of_month);
        p.f276215b = r110.getResources().getStringArray(R.array.tradition_festival);
        p.f276216c = r110.getResources().getStringArray(R.array.lunar_str);
        p.f276217d = r110.getResources().getStringArray(R.array.special_festivals);
        p.f276219f = r110.getResources().getStringArray(R.array.solar_festival);
        goto L10
    }
}
