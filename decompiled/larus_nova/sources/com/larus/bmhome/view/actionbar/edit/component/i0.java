package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f316349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f316350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Integer, Long> f316351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, Integer> f316352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<com.larus.bmhome.actionbar.model.h, List<com.larus.bmhome.actionbar.model.w>> f316353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<com.larus.bmhome.actionbar.model.h, Boolean> f316354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function4<com.larus.bmhome.actionbar.model.h, com.larus.bmhome.actionbar.model.w, Integer, Set<String>, Unit> f316355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function4<com.larus.bmhome.actionbar.model.h, com.larus.bmhome.actionbar.model.w, Integer, String, Unit> f316356h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function3<com.larus.bmhome.actionbar.model.j, Integer, Set<String>, Unit> f316357i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function3<com.larus.bmhome.actionbar.model.j, Integer, String, Unit> f316358j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<k0, Unit> f316359k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function1<k0, Unit> f316360l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final View f316361m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinearLayout f316362n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f316363o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Set<String> f316364p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Set<String> f316365q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<Integer, Long> f316366r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<Integer, Integer> f316367s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.a0 f316368t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f316369u;

    public final k0 d() {
        ArrayList r100 = new ArrayList();
        com.larus.bmhome.actionbar.model.a0 r101 = this.f316368t;
        if (r101 == null) goto L5;
        List<com.larus.bmhome.actionbar.model.f0> r102 = r101.f294961c;
    L6:
        if (r102 != null) goto L8;
        r102 = CollectionsKt.emptyList();
    L8:
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L55;
        com.larus.bmhome.actionbar.model.f0 r104 = (com.larus.bmhome.actionbar.model.f0) r103.next();
        Integer r105 = r104.f();
        if (r105 == null) goto L10;
        int r106 = r105.intValue();
        com.larus.bmhome.actionbar.model.h r107 = r104.d();
        if (r107 == null) goto L29;
        Long r108 = this.f316351c.get(Integer.valueOf(r106));
        List<com.larus.bmhome.actionbar.model.w> r109 = r107.f295167e;
        if (r109 == null) goto L29;
        Iterator<T> r110 = r109.iterator();
    L19:
        if (r110.hasNext() == false) goto L23;
        Object r111 = r110.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r111).f295510a, r108) == false) goto L19;
    L24:
        com.larus.bmhome.actionbar.model.w r112 = (com.larus.bmhome.actionbar.model.w) r111;
        if (r112 == null) goto L29;
        k0 r113 = j0.a(r112, r106, this.f316350b);
        if (r113 == null) goto L29;
        r100.add(r113);
        goto L29
    L23:
        r111 = null;
    L29:
        com.larus.bmhome.actionbar.model.j r114 = r104.e();
        if (r114 == null) goto L10;
        Integer r115 = this.f316352d.get(Integer.valueOf(r106));
        String r116 = this.f316350b;
        Intrinsics.checkNotNullParameter(r114, "<this>");
        Intrinsics.checkNotNullParameter(r116, "enterMethod");
        if (j0.f(r114, r115) == true) goto L34;
        k0 r117 = null;
    L53:
        if (r117 == null) goto L10;
        r100.add(r117);
        goto L10
    L34:
        com.larus.bmhome.actionbar.model.z1 r118 = r114.f295219o;
        if (r118 == null) goto L37;
        Map<String, String> r119 = r118.f295637d;
    L38:
        int r120 = uz8.b.C7949b.f552206c;
        if (r119 == null) goto L41;
        String r121 = r119.get("feature_detail_key");
    L42:
        if (r119 == null) goto L44;
        String r122 = r119.get("feature_detail_value");
    L45:
        List r123 = CollectionsKt.listOfNotNull(uz8.b.C7949b.a.a(r121, r122, r115));
        List r124 = CollectionsKt.listOf(new l0(r106, null, r115, 2));
        com.larus.bmhome.actionbar.model.z1 r125 = r114.f295219o;
        int r126 = uz8.b.f552201e;
        if (r119 == null) goto L48;
        String r127 = r119.get("trigger_scene");
    L49:
        if (r119 == null) goto L51;
        String r128 = r119.get("feature_key");
    L52:
        Intrinsics.checkNotNullParameter(r116, "enterMethod");
        Intrinsics.checkNotNullParameter(r123, "featureDetails");
        r117 = new k0(r124, r125, new uz8.b(r116, r127, r128, uz8.b.a.a(r123)), r123);
        goto L53
    L51:
        r128 = null;
        goto L52
    L48:
        r127 = null;
        goto L49
    L44:
        r122 = null;
        goto L45
    L41:
        r121 = null;
        goto L42
    L37:
        r119 = null;
        goto L38
    L55:
        k0 r129 = (k0) CollectionsKt.firstOrNull(r100);
        if (r129 != null) goto L58;
        return null;
    L58:
        ArrayList r130 = new ArrayList();
        Iterator r131 = r100.iterator();
    L60:
        if (r131.hasNext() == false) goto L62;
        CollectionsKt.addAll(r130, ((k0) r131.next()).f316392a);
        goto L60
    L62:
        ArrayList r132 = new ArrayList();
        Iterator r133 = r100.iterator();
    L64:
        if (r133.hasNext() == false) goto L66;
        CollectionsKt.addAll(r132, ((k0) r133.next()).f316395d);
        goto L64
    L66:
        uz8.b r134 = r129.f316394c;
        int r135 = uz8.b.f552201e;
        uz8.b r136 = new uz8.b(r134.f552202a, r134.f552203b, r134.f552204c, uz8.b.a.a(r132));
        com.larus.bmhome.actionbar.model.z1 r137 = r129.f316393b;
        Intrinsics.checkNotNullParameter(r130, "selections");
        Intrinsics.checkNotNullParameter(r136, "trackingExtra");
        Intrinsics.checkNotNullParameter(r132, "featureDetails");
        return new k0(r130, r137, r136, r132);
    L5:
        r102 = null;
        goto L6
    }

    public final int f() {
        return i(R.attr.larus_primary_50, R.color.larus_primary_50);
    }

    public final LinearLayout c(String r100) {
        LinearLayout r101 = new LinearLayout(this.f316349a);
        r101.setOrientation(1);
        r101.setPadding(0, e(4), 0, e(12));
        if (r100 != null) goto L5;
    L10:
        return r101;
    L5:
        if ((true ^ StringsKt.isBlank(r100)) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        TextView r102 = new TextView(r101.getContext());
        r102.setText(r100);
        r102.setTextSize(14.0f);
        r102.setTypeface(Typeface.create("sans-serif-medium", 0));
        r102.setTextColor(i(R.attr.larus_neutral_50, R.color.larus_neutral_50));
        r102.setPadding(e(16), 0, e(16), 0);
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-1, -2);
        r103.bottomMargin = e(8);
        Unit r104 = Unit.INSTANCE;
        r101.addView(r102, r103);
        goto L10
    }

    public final int e(int r100) {
        Resources r101 = this.f316349a.getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v62, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r0v92 */
    /* JADX WARN: Type inference failed for: r0v93, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r0v94 */
    /* JADX WARN: Type inference failed for: r0v95 */
    /* JADX WARN: Type inference failed for: r0v98 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r15v1, types: [android.view.View, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r1v38, types: [com.larus.bmhome.view.actionbar.edit.component.e0] */
    /* JADX WARN: Type inference failed for: r1v80, types: [com.larus.bmhome.view.actionbar.edit.component.c0] */
    /* JADX WARN: Type inference failed for: r2v28, types: [com.larus.bmhome.view.actionbar.edit.component.g0] */
    /* JADX WARN: Type inference failed for: r39v0 */
    /* JADX WARN: Type inference failed for: r39v1 */
    /* JADX WARN: Type inference failed for: r39v2 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v18, types: [com.larus.bmhome.view.actionbar.edit.component.d0] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v53, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v55 */
    /* JADX WARN: Type inference failed for: r4v56 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r9v2, types: [android.widget.LinearLayout] */
    public final void g(com.larus.bmhome.actionbar.model.a0 r410) {
        Intrinsics.checkNotNullParameter(r410, "config");
        this.f316368t = r410;
        TextView r100 = (TextView) this.f316361m.findViewById(R.id.tv_collaborated_param_panel_title);
        Intrinsics.checkNotNullParameter(r410, "<this>");
        String r101 = r410.f294960b;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.setText(r101);
        this.f316362n.removeAllViews();
        List<com.larus.bmhome.actionbar.model.f0> r103 = r410.f294961c;
        if (r103 != null) goto L8;
        r103 = CollectionsKt.emptyList();
    L8:
        Iterator r110 = r103.iterator();
    L10:
        if (r110.hasNext() == false) goto L249;
        com.larus.bmhome.actionbar.model.f0 r104 = (com.larus.bmhome.actionbar.model.f0) r110.next();
        if (r104.d() == null) goto L174;
        LinearLayout r105 = this.f316362n;
        final com.larus.bmhome.actionbar.model.h r106 = r104.d();
        if (r106 != null) goto L16;
        ?? r107 = new View(this.f316349a);
    L47:
        ?? r108 = r107;
        ?? r109 = r105;
        String r210 = r102;
        Iterator r310 = r110;
    L173:
        r109.addView(r108);
    L248:
        r102 = r210;
        r110 = r310;
        goto L10
    L16:
        Integer r111 = r104.f();
        if (r111 == null) goto L171;
        final int r112 = r111.intValue();
        if (r112 == 2) goto L23;
        if (r112 == 1) goto L23;
        boolean r113 = false;
    L24:
        ?? r114 = c(r106.f295165c);
        Long r115 = this.f316351c.get(Integer.valueOf(r112));
        Integer r116 = r106.f295172j;
        if (r116 != null) goto L28;
    L48:
        Function0 r117 = new d0(this, r112);
        final ?? r118 = new e0(this, r106, r112);
        List<com.larus.bmhome.actionbar.model.w> r119 = this.f316353e.invoke(r106);
        Integer r120 = r106.f295173k;
        if (r120 != null) goto L51;
    L59:
        int r121 = 3;
    L60:
        if (r113 == false) goto L62;
        int r122 = 76;
    L63:
        int r123 = e(r122);
        final ArrayList r124 = new ArrayList();
        ?? r125 = new LinearLayout(this.f316349a);
        r125.setOrientation(1);
        r125.setPadding(e(12), 0, e(12), 0);
        Iterator r126 = CollectionsKt.chunked(r119, r121).iterator();
        int r211 = 0;
        ?? r127 = r114;
    L65:
        if (r126.hasNext() == false) goto L170;
        Object r128 = r126.next();
        int r212 = r211 + 1;
        if (r211 >= 0) goto L69;
        CollectionsKt.throwIndexOverflow();
    L69:
        List r213 = (List) r128;
        LinearLayout r129 = new LinearLayout(r125.getContext());
        r129.setOrientation(0);
        Iterator r214 = r213.iterator();
        int r215 = 0;
        ?? r130 = r127;
    L70:
        String r216 = r102;
        if (r214.hasNext() == false) goto L157;
        Object r131 = r214.next();
        int r217 = r215 + 1;
        if (r215 >= 0) goto L75;
        CollectionsKt.throwIndexOverflow();
    L75:
        final com.larus.bmhome.actionbar.model.w r132 = (com.larus.bmhome.actionbar.model.w) r131;
        final int r218 = (r211 * r121) + r215;
        int r311 = r121;
        this.f316355g.invoke(r106, r132, Integer.valueOf(r218), this.f316364p);
        boolean r133 = Intrinsics.areEqual(r132.f295510a, r115);
        Iterator r312 = r110;
        Long r313 = r115;
        Iterator r219 = r126;
        ?? r134 = r130;
        final ?? r135 = r117;
        com.larus.bmhome.actionbar.model.h r314 = r106;
        Function0 r315 = r117;
        LinearLayout r136 = r105;
        LinearLayout r316 = r129;
        final boolean r137 = r113;
        final ?? r138 = new g0(r118, r132, r218, r135, r124, this, r137);
        if (r113 == false) goto L134;
        String r317 = j0.d(r132);
        if (r317 != null) goto L80;
        String r139 = r216;
    L81:
        LinearLayout r140 = new LinearLayout(this.f316349a);
        r140.setOrientation(1);
        r140.setGravity(17);
        r140.setPadding(0, e(4), 0, 0);
        r140.setContentDescription(r139);
        r140.setClickable(true);
        r140.setFocusable(true);
        if (r133 == false) goto L84;
        int r141 = i(R.attr.larus_primary_transparent_1, R.color.larus_primary_transparent_1);
    L85:
        float r142 = e(16);
        if (r133 == false) goto L88;
        Integer r143 = Integer.valueOf(f());
    L89:
        r140.setBackground(j(r141, r142, r143));
        boolean r144 = v19.h.f552477a;
        if (v19.h.a(null) == false) goto L107;
        com.larus.bmhome.actionbar.model.w r145 = r132;
        com.larus.bmhome.actionbar.model.g1 r146 = r145.f295516g;
        if (r146 == null) goto L100;
        String r147 = r146.f295156b;
        if (r147 == null) goto L100;
        if ((!StringsKt.isBlank(r147)) == true) goto L99;
        r147 = null;
    L99:
        if (r147 == null) goto L100;
    L115:
        SimpleDraweeView r148 = new SimpleDraweeView(this.f316349a);
        GenericDraweeHierarchy r149 = r148.getHierarchy();
        if (r133 == false) goto L118;
        int r318 = f();
    L119:
        r149.setActualImageColorFilter(new PorterDuffColorFilter(r318, PorterDuff.Mode.SRC_IN));
        if (r147 != null) goto L122;
    L125:
        boolean r150 = true;
    L126:
        if (r150 == false) goto L128;
        com.larus.utils.e1.o(r148);
    L129:
        r140.addView(r148, new LinearLayout.LayoutParams(e(20), e(20)));
        TextView r151 = new TextView(r140.getContext());
        r151.setText(r139);
        r151.setTextSize(15.0f);
        r151.setIncludeFontPadding(false);
        r151.setTypeface(Typeface.create("sans-serif-medium", 0));
        r151.setGravity(17);
        if (r133 == false) goto L132;
        int r152 = f();
    L133:
        r151.setTextColor(r152);
        LinearLayout.LayoutParams r153 = new LinearLayout.LayoutParams(-2, -2);
        r153.topMargin = e(4);
        Unit r154 = Unit.INSTANCE;
        r140.addView(r151, r153);
        com.larus.utils.e1.d(r140, new x(r138));
        ?? r319 = r134;
    L153:
        r124.add(TuplesKt.to(r145, r140));
        LinearLayout.LayoutParams r155 = new LinearLayout.LayoutParams(0, r123, 1.0f);
        if (r215 <= 0) goto L156;
        r155.setMarginStart(e(8));
    L156:
        Unit r156 = Unit.INSTANCE;
        r316.addView(r140, r155);
        r129 = r316;
        r102 = r216;
        r215 = r217;
        r126 = r219;
        r121 = r311;
        r110 = r312;
        r115 = r313;
        r106 = r314;
        r117 = r315;
        r105 = r136;
        r130 = r319;
        goto L70
    L132:
        r152 = i(R.attr.larus_neutral_100, R.color.larus_neutral_100);
        goto L133
    L128:
        ImageLoaderKt.u(r148, r147, "template_item_photo");
        goto L129
    L122:
        if (StringsKt.isBlank(r147) == true) goto L125;
        r150 = false;
        goto L126
    L118:
        r318 = i(R.attr.larus_neutral_100, R.color.larus_neutral_100);
    L100:
        com.larus.bmhome.actionbar.model.g1 r157 = r145.f295515f;
        if (r157 == null) goto L114;
        r147 = r157.f295156b;
        if (r147 == null) goto L114;
        if ((!StringsKt.isBlank(r147)) == true) goto L115;
    L114:
        r147 = null;
        goto L115
    L107:
        r145 = r132;
        com.larus.bmhome.actionbar.model.g1 r158 = r145.f295515f;
        if (r158 == null) goto L114;
        r147 = r158.f295156b;
        if (r147 == null) goto L114;
        if ((!StringsKt.isBlank(r147)) == false) goto L114;
    L88:
        r143 = null;
        goto L89
    L84:
        r141 = i(R.attr.larus_base_2_overlay, R.color.larus_base_2_overlay);
        goto L85
    L80:
        r139 = r317;
        goto L81
    L134:
        r319 = r134;
        r145 = r132;
        r140 = new LinearLayout(this.f316349a);
        r140.setOrientation(0);
        r140.setGravity(17);
        if (r133 == false) goto L137;
        int r159 = i(R.attr.larus_primary_transparent_1, R.color.larus_primary_transparent_1);
    L138:
        float r160 = e(16);
        if (r133 == false) goto L141;
        Integer r161 = Integer.valueOf(f());
    L142:
        r140.setBackground(j(r159, r160, r161));
        TextView r162 = new TextView(r140.getContext());
        String r163 = j0.d(r145);
        if (r163 != null) goto L145;
        r163 = r216;
    L145:
        r162.setText(r163);
        r162.setTextSize(15.0f);
        r162.setIncludeFontPadding(false);
        r162.setMaxLines(1);
        r162.setEllipsize(TextUtils.TruncateAt.END);
        r162.setTypeface(Typeface.create("sans-serif-medium", 0));
        r162.setGravity(17);
        if (r133 == false) goto L148;
        int r164 = f();
    L149:
        r162.setTextColor(r164);
        r140.addView(r162, new LinearLayout.LayoutParams(-2, -2));
        a r165 = b.d(r145);
        if (r165 == null) goto L152;
        View r166 = b.a(r140.getContext(), r165);
        LinearLayout.LayoutParams r167 = new LinearLayout.LayoutParams(-2, -2);
        r167.setMarginStart(e(4));
        Unit r168 = Unit.INSTANCE;
        r140.addView(r166, r167);
    L152:
        com.larus.utils.e1.d(r140, new t(r138));
        goto L153
    L148:
        r164 = i(R.attr.larus_neutral_100, R.color.larus_neutral_100);
        goto L149
    L141:
        r161 = null;
        goto L142
    L137:
        r159 = i(R.attr.larus_base_2_overlay, R.color.larus_base_2_overlay);
        goto L138
    L157:
        int r320 = r121;
        Long r321 = r115;
        ?? r322 = r130;
        com.larus.bmhome.actionbar.model.h r323 = r106;
        LinearLayout r324 = r105;
        LinearLayout r169 = r129;
        Iterator r325 = r110;
        Iterator r220 = r126;
        Function0 r326 = r117;
        int r170 = r320 - r213.size();
        int r171 = 0;
    L158:
        if (r171 >= r170) goto L166;
        View r172 = new View(r125.getContext());
        LinearLayout.LayoutParams r173 = new LinearLayout.LayoutParams(0, r123, 1.0f);
        if ((!r213.isEmpty()) == true) goto L164;
        if (r171 > 0) goto L164;
        int r174 = 0;
    L165:
        r173.setMarginStart(r174);
        Unit r175 = Unit.INSTANCE;
        r169.addView(r172, r173);
        r171 = r171 + 1;
    L164:
        r174 = e(8);
        goto L165
    L166:
        LinearLayout.LayoutParams r176 = new LinearLayout.LayoutParams(-1, r123);
        if (r211 <= 0) goto L169;
        r176.topMargin = e(8);
    L169:
        Unit r177 = Unit.INSTANCE;
        r125.addView(r169, r176);
        r211 = r212;
        r102 = r216;
        r126 = r220;
        r121 = r320;
        r110 = r325;
        r115 = r321;
        r106 = r323;
        r117 = r326;
        r105 = r324;
        r127 = r322;
        goto L65
    L170:
        LinearLayout r327 = r105;
        r210 = r102;
        r310 = r110;
        r127.addView(r125);
        ?? r178 = r127;
    L172:
        r109 = r327;
        r108 = r178;
        goto L173
    L62:
        r122 = 48;
        goto L63
    L51:
        if (r120.intValue() <= 0) goto L53;
        boolean r179 = true;
    L54:
        if (r179 == true) goto L57;
        r120 = null;
    L57:
        if (r120 == null) goto L59;
        r121 = r120.intValue();
        goto L60
    L53:
        r179 = false;
        goto L54
    L28:
        if (r116.intValue() != 3) goto L48;
        ?? r180 = new c0(this, r112, r106);
        LinearLayout r181 = new LinearLayout(this.f316349a);
        r181.setOrientation(1);
        List<com.larus.bmhome.actionbar.model.w> r182 = r106.f295167e;
        if (r182 != null) goto L32;
        r182 = CollectionsKt.emptyList();
    L32:
        TextView r183 = new TextView(this.f316349a);
        r183.setTextSize(14.0f);
        r183.setTextColor(f());
        r183.setGravity(GravityCompat.END);
        Iterator<com.larus.bmhome.actionbar.model.w> r184 = r182.iterator();
        int r185 = 0;
    L34:
        if (r184.hasNext() == false) goto L39;
        if (Intrinsics.areEqual(r184.next().f295510a, r115) == true) goto L37;
        r185 = r185 + 1;
        goto L34
    L37:
        int r186 = r185;
    L40:
        int r187 = RangesKt.coerceAtLeast(r186, 0);
        SeekBar r188 = new SeekBar(this.f316349a);
        r188.setMax(RangesKt.coerceAtLeast(r182.size() - 1, 0));
        r188.setProgress(RangesKt.coerceIn(r187, 0, r188.getMax()));
        r188.setOnSeekBarChangeListener(new h0(r182, r183, r180));
        com.larus.bmhome.actionbar.model.w r189 = (com.larus.bmhome.actionbar.model.w) CollectionsKt.getOrNull(r182, r188.getProgress());
        if (r189 == null) goto L43;
        String r190 = j0.d(r189);
    L44:
        if (r190 != null) goto L46;
        r190 = r102;
    L46:
        r183.setText(r190);
        r181.addView(r183);
        r181.addView(r188);
        r114.addView(r181);
        r107 = r114;
        goto L47
    L43:
        r190 = null;
        goto L44
    L39:
        r186 = -1;
    L23:
        r113 = true;
        goto L24
    L171:
        r327 = r105;
        r210 = r102;
        r310 = r110;
        r178 = new View(this.f316349a);
        goto L172
    L174:
        r210 = r102;
        r310 = r110;
        if (r104.e() == null) goto L248;
        ?? r191 = this.f316362n;
        final com.larus.bmhome.actionbar.model.j r192 = r104.e();
        if (r192 != null) goto L179;
        View r193 = new View(this.f316349a);
    L247:
        r191.addView(r193);
        goto L248
    L179:
        Integer r194 = r104.f();
        if (r194 == null) goto L245;
        final int r195 = r194.intValue();
        LinearLayout r196 = c(r192.f295206b);
        Integer r197 = r192.f295208d;
        if (r197 == null) goto L184;
        int r198 = r197.intValue();
    L185:
        Integer r199 = r192.f295209e;
        if (r199 == null) goto L188;
        int r200 = r199.intValue();
    L189:
        Integer r201 = r192.f295210f;
        if (r201 == null) goto L192;
        int r202 = r201.intValue();
    L193:
        Integer r203 = Integer.valueOf(r202);
        if (r203.intValue() <= 0) goto L196;
        boolean r204 = true;
    L197:
        if (r204 == true) goto L200;
        r203 = null;
    L200:
        if (r203 == null) goto L202;
        int r205 = r203.intValue();
    L203:
        boolean r1100 = this.f316352d.containsKey(Integer.valueOf(r195));
        if (r1100 == false) goto L207;
        Integer r206 = this.f316352d.get(Integer.valueOf(r195));
    L206:
        Integer r1101 = r206;
        if (r1101 == null) goto L214;
        int r207 = r1101.intValue();
    L218:
        int r1102 = RangesKt.coerceIn(r207, r198, r200);
        if (j0.f(r192, this.f316352d.get(Integer.valueOf(r195))) == true) goto L221;
        this.f316367s.put(Integer.valueOf(r195), this.f316352d.get(Integer.valueOf(r195)));
    L221:
        final CollaboratedDurationSliderView r208 = new CollaboratedDurationSliderView(this.f316349a, null, 6, 0);
        boolean r209 = !Intrinsics.areEqual(r192.f295211g, Boolean.FALSE);
        Function1<? super Integer, String> r221 = new r(r192);
        Function1<? super Integer, Integer> r222 = new y(r192, this);
        Intrinsics.checkNotNullParameter(r221, "valueFormatter");
        Intrinsics.checkNotNullParameter(r222, "upgradeBadgeWidthProvider");
        r208.f316048d = r198;
        r208.f316049e = RangesKt.coerceAtLeast(r200, r198);
        Integer r223 = Integer.valueOf(r205);
        if (r223.intValue() <= 0) goto L224;
        boolean r224 = true;
    L225:
        if (r224 == true) goto L228;
        r223 = null;
    L228:
        if (r223 == null) goto L230;
        int r225 = r223.intValue();
    L231:
        r208.f316050f = r225;
        r208.f316052h = r209;
        r208.f316053i = r221;
        r208.f316054j = r222;
        r208.f316051g = RangesKt.coerceIn(r1102, r208.f316048d, r208.f316049e);
        r208.f();
        r208.invalidate();
        final FrameLayout r226 = new FrameLayout(this.f316349a);
        r226.setVisibility(8);
        r226.setImportantForAccessibility(2);
        final Ref.ObjectRef r1103 = new Ref.ObjectRef();
        final FrameLayout r227 = new FrameLayout(this.f316349a);
        r227.addView(r208, new FrameLayout.LayoutParams(-1, e(80)));
        r227.addView(r226, new FrameLayout.LayoutParams(-2, -2));
        r208.setOnDurationTrackingStarted(new z(r192, this, r195));
        boolean r1104 = false;
        r208.setOnDurationChanged(new a0(this, r195, r192, r1103, r226, r208, r227));
        r208.setOnDurationTrackingFinished(new b0(this, r195, r192));
        if (r1100 == false) goto L241;
        if (r1101 != null) goto L235;
    L240:
        if (r1104 == true) goto L241;
    L244:
        this.f316357i.invoke(r192, this.f316352d.get(Integer.valueOf(r195)), this.f316364p);
        r196.addView(r227, new LinearLayout.LayoutParams(-1, e(80)));
        b(r192, r1103, r226, this, r208, r227, this.f316352d.get(Integer.valueOf(r195)));
        r193 = r196;
        goto L247
    L235:
        if (r1101.intValue() == r1102) goto L237;
        boolean r228 = true;
        boolean r229 = true;
    L238:
        if (r229 != r228) goto L240;
        r1104 = true;
        goto L240
    L237:
        r228 = true;
        r229 = false;
    L241:
        this.f316352d.put(Integer.valueOf(r195), Integer.valueOf(r1102));
        if (j0.f(r192, Integer.valueOf(r1102)) == true) goto L244;
        this.f316367s.put(Integer.valueOf(r195), Integer.valueOf(r1102));
        goto L244
    L230:
        r225 = 1;
        goto L231
    L224:
        r224 = false;
        goto L225
    L214:
        Integer r230 = r192.f295212h;
        if (r230 == null) goto L217;
        r207 = r230.intValue();
        goto L218
    L217:
        r207 = r198;
        goto L218
    L207:
        Integer r231 = r192.f295212h;
        if (r231 == null) goto L210;
        int r232 = r231.intValue();
    L211:
        r206 = Integer.valueOf(r232);
        goto L206
    L210:
        r232 = r198;
        goto L211
    L202:
        r205 = 1;
        goto L203
    L196:
        r204 = false;
        goto L197
    L192:
        r202 = 1;
        goto L193
    L188:
        r200 = r198;
        goto L189
    L184:
        r198 = 0;
        goto L185
    L245:
        r193 = new View(this.f316349a);
        goto L247
    L249:
        k(true);
    }

    public final void h(k0 r110) {
        if (this.f316369u == false) goto L9;
        Set<String> r100 = this.f316365q;
        uz8.b r101 = r110.f316394c;
        if (r100.add(CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{r110.a(), r101.f552202a, r101.f552203b, r101.f552204c, r101.f552205d}), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null)) == false) goto L10;
        this.f316359k.invoke(r110);
        return;
    L10:
        return;
    }

    public final void k(boolean r100) {
        k0 r101 = d();
        TextView r102 = (TextView) this.f316363o.getValue();
        if (r101 == null) goto L13;
        Context r103 = this.f316349a;
        com.larus.bmhome.actionbar.model.z1 r104 = r101.f316393b;
        if (r104 == null) goto L11;
        String r105 = r104.f295636c;
        if (r105 == null) goto L11;
        if ((!StringsKt.isBlank(r105)) == false) goto L11;
    L12:
        String r106 = j0.c(r103, r105);
    L14:
        r102.setText(r106);
        if (r100 == false) goto L19;
        if (r101 == null) goto L20;
        h(r101);
        return;
    L20:
        return;
    L19:
        return;
    L11:
        r105 = null;
        goto L12
    L13:
        r106 = this.f316349a.getString(R.string.larus_aiCreation_paraBottomSheet_btn_confirm);
        Intrinsics.checkNotNull(r106);
        goto L14
    }

    public final int i(int r100, int r101) {
        Context r102 = this.f316349a;
        return ContextCompat.getColor(r102, v19.c.b(r100, r102, r101));
    }

    public final GradientDrawable j(int r100, float r101, Integer r102) {
        GradientDrawable r103 = new GradientDrawable();
        r103.setShape(0);
        r103.setColor(r100);
        r103.setCornerRadius(r101);
        if (r102 == null) goto L5;
        int r104 = r102.intValue();
        r103.setStroke(e(1), r104);
    L5:
        return r103;
    }

    public static final void a(com.larus.bmhome.actionbar.model.j r100, FrameLayout r101, CollaboratedDurationSliderView r102, i0 r103, int r104, int r105) {
        String r106 = r100.a(Integer.valueOf(r104));
        if (r106 != null) goto L5;
        r106 = "";
    L5:
        int r107 = r103.e(2);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r106, "label");
        float r108 = r102.e();
        float r109 = r102.d();
        int r110 = RangesKt.coerceIn(r104, r102.f316048d, r102.f316049e);
        int r111 = r102.f316049e;
        int r112 = r102.f316048d;
        if (r111 <= r112) goto L9;
        r108 = r108 + (((r109 - r108) * (r110 - r112)) / (r111 - r112));
    L9:
        float r113 = r102.f316063s.measureText(r106);
        float r114 = r107;
        float r115 = ((r113 + r114) + r105) / 2.0f;
        float r116 = r102.c();
        float r117 = r115 + r116;
        float r118 = (r102.getWidth() - r115) - r116;
        if (r118 < r117) goto L12;
        float r119 = RangesKt.coerceIn(r108, r117, r118);
    L13:
        r101.setX(((r119 - r115) + r113) + r114);
        r101.setY(r102.a(3));
        return;
    L12:
        r119 = r102.getWidth() / 2.0f;
        goto L13
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Object, java.lang.String] */
    public static final void b(final com.larus.bmhome.actionbar.model.j r100, Ref.ObjectRef<String> r110, final FrameLayout r111, final i0 r112, final CollaboratedDurationSliderView r113, FrameLayout r114, final Integer r115) {
        m0 r101 = j0.b(r100, r115);
        if (r101 == null) goto L19;
        if (r115 == null) goto L19;
        final int r102 = r112.e(r101.f316406b);
        int r103 = r112.e(r101.f316407c);
        ViewGroup.LayoutParams r104 = r111.getLayoutParams();
        r104.width = r102;
        r104.height = r103;
        r111.setLayoutParams(r104);
        r111.requestLayout();
        ?? r105 = r101.f316405a + '|' + r101.f316406b + '|' + r101.f316407c + '|' + r101.f316408d;
        if (Intrinsics.areEqual(r110.element, r105) == true) goto L9;
    L10:
        r110.element = r105;
        r111.removeAllViews();
        SimpleDraweeView r116 = new SimpleDraweeView(r112.f316349a);
        Integer r106 = r101.f316408d;
        if (r106 == null) goto L13;
        r116.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(r112.e(r106.intValue())));
    L13:
        ImageLoaderKt.u(r116, r101.f316405a, "template_item_photo");
        r111.addView(r116, new FrameLayout.LayoutParams(r102, r103));
    L15:
        if (r113.getWidth() <= 0) goto L17;
        a(r100, r111, r113, r112, r115.intValue(), r102);
        r111.setVisibility(0);
        return;
    L17:
        r111.setVisibility(4);
        r114.post(new f0(r115, r102, r111, r100, r113, r112));
        return;
    L9:
        if (r111.getChildCount() != 0) goto L15;
    L19:
        r110.element = null;
        r111.removeAllViews();
        r111.setVisibility(8);
    }

    public i0(Context r100, String r101, Map r102, Map r103, k r104, l r105, Function4 r106, Function4 r107, Function3 r110, Function3 r111, Function1 r112, m r113, final n r114, final o r115) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "creationEnterMethod");
        Intrinsics.checkNotNullParameter(r102, "draftDropdownSelections");
        Intrinsics.checkNotNullParameter(r103, "draftDurations");
        Intrinsics.checkNotNullParameter(r104, "visibleOptionProvider");
        Intrinsics.checkNotNullParameter(r105, "shouldInterceptRatioClick");
        Intrinsics.checkNotNullParameter(r106, "onDropdownOptionShow");
        Intrinsics.checkNotNullParameter(r107, "onDropdownOptionClick");
        Intrinsics.checkNotNullParameter(r110, "onDurationOptionShow");
        Intrinsics.checkNotNullParameter(r111, "onDurationOptionClick");
        Intrinsics.checkNotNullParameter(r112, "onSubscribeGuidanceShow");
        Intrinsics.checkNotNullParameter(r113, "onSubscribeRequired");
        Intrinsics.checkNotNullParameter(r114, "onClose");
        Intrinsics.checkNotNullParameter(r115, "onConfirm");
        this.f316349a = r100;
        this.f316350b = r101;
        this.f316351c = r102;
        this.f316352d = r103;
        this.f316353e = r104;
        this.f316354f = r105;
        this.f316355g = r106;
        this.f316356h = r107;
        this.f316357i = r110;
        this.f316358j = r111;
        this.f316359k = r112;
        this.f316360l = r113;
        View r108 = LayoutInflater.from(r100).inflate(R.layout.larus_dialog_collaborated_param_selector, null);
        r108.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        com.larus.utils.e1.d(r108.findViewById(R.id.tv_collaborated_param_panel_close), new u(r114));
        com.larus.utils.e1.d(r108.findViewById(R.id.tv_collaborated_param_confirm), new v(this, r115));
        this.f316361m = r108;
        LinearLayout r109 = new LinearLayout(r100);
        r109.setOrientation(1);
        this.f316362n = r109;
        this.f316363o = LazyKt.lazy(new w(this));
        this.f316364p = new LinkedHashSet();
        this.f316365q = new LinkedHashSet();
        this.f316366r = MapsKt.toMutableMap(r102);
        this.f316367s = MapsKt.toMutableMap(r103);
        ((NestedScrollView) r108.findViewById(R.id.collaborated_param_selector_scroll)).addView(r109, new ViewGroup.LayoutParams(-1, -2));
    }
}
