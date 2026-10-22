package com.larus.bmhome.chat.layout.item;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import androidx.core.view.GravityCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.larus.bmhome.chat.list.cell.prompt.WcbItemLinearLayout;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
public final class l3 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final PathInterpolator f304466p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f304467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f304468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Integer> f304469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<View, String> f304470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<View, String> f304471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Animator f304472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AnimatorSet f304473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ValueAnimator f304474h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f304475i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<? extends Pair<? extends View, Integer>> f304476j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f304477k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Rect f304478l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f304479m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f304480n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f304481o;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f304482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f304483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f304484c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f304482a == r101.f304482a) goto L12;
            return false;
        L12:
            if (this.f304483b == r101.f304483b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f304482a * 31) + this.f304483b;
        }

        public final String toString() {
            return "DirectChildWidth(measuredWidth=" + this.f304482a + ", marginWidth=" + this.f304483b + ')';
        }

        public b(int r100, int r101) {
            this.f304482a = r100;
            this.f304483b = r101;
            this.f304484c = r100 + r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f304485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f304486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f304487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f304488d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f304485a, r101.f304485a) == true) goto L12;
            return false;
        L12:
            if (this.f304486b == r101.f304486b) goto L15;
            return false;
        L15:
            if (this.f304487c == r101.f304487c) goto L18;
            return false;
        L18:
            if (this.f304488d == r101.f304488d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f304485a.hashCode() * 31) + this.f304486b) * 31) + this.f304487c) * 31) + this.f304488d;
        }

        public final String toString() {
            return "RefreshChildWidth(child=" + this.f304485a + ", originalWidth=" + this.f304486b + ", startWidth=" + this.f304487c + ", targetWidth=" + this.f304488d + ')';
        }

        public c(View r100, int r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
            this.f304485a = r100;
            this.f304486b = r101;
            this.f304487c = r102;
            this.f304488d = r103;
        }
    }

    static {
        f304466p = new PathInterpolator(0.0f, 0.0f, 0.58f, 1.0f);
    }

    public final void b() {
        AnimatorSet r100 = this.f304473g;
        ValueAnimator r101 = this.f304474h;
        Animator r102 = this.f304472f;
        if (r102 == null) goto L9;
        if (r100 != null) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
    L10:
        this.f304481o++;
        this.f304472f = null;
        this.f304473g = null;
        this.f304474h = null;
        if (r102 == null) goto L13;
        r102.cancel();
    L13:
        if (r100 == null) goto L15;
        r100.cancel();
    L15:
        if (r100 != null) goto L18;
        if (r101 == null) goto L18;
        r101.cancel();
    L18:
        this.f304467a.animate().cancel();
        this.f304467a.setAlpha(1.0f);
        f(this.f304475i);
        return;
    L6:
        r103 = false;
    L9:
        r102 = null;
        goto L10
    }

    public final Integer c() {
        if (this.f304480n == false) goto L5;
        Integer r100 = this.f304477k;
    L9:
        boolean r101 = true;
        if (r100 != null) goto L12;
    L20:
        int r102 = this.f304469c.invoke().intValue();
    L21:
        Integer r103 = Integer.valueOf(r102);
        if (r103.intValue() <= 0) goto L24;
        boolean r104 = true;
    L25:
        if (r104 == true) goto L28;
        r103 = null;
    L28:
        if (r103 == null) goto L56;
        int r105 = r103.intValue();
        int r106 = RangesKt.coerceAtLeast((r105 - this.f304467a.getPaddingLeft()) - this.f304467a.getPaddingRight(), 0);
        Iterator<Integer> r107 = RangesKt.until(0, this.f304467a.getChildCount()).iterator();
        if (r107.hasNext() == true) goto L32;
        Integer r108 = null;
    L38:
        if (r108 == null) goto L40;
        int r109 = r108.intValue();
    L41:
        Integer r110 = Integer.valueOf((this.f304467a.getPaddingLeft() + this.f304467a.getPaddingRight()) + r109);
        if (r110.intValue() > 0) goto L45;
        r101 = false;
    L45:
        if (r101 == true) goto L48;
        r110 = null;
    L48:
        if (r110 != null) goto L50;
        return null;
    L50:
        return Integer.valueOf(RangesKt.coerceAtMost(r110.intValue(), r105));
    L40:
        r109 = 0;
        goto L41
    L32:
        IntIterator r111 = (IntIterator) r107;
        r108 = Integer.valueOf(e(this.f304467a.getChildAt(r111.nextInt()), r106).f304484c);
    L34:
        if (r107.hasNext() == false) goto L38;
        Integer r112 = Integer.valueOf(e(this.f304467a.getChildAt(r111.nextInt()), r106).f304484c);
        if (r108.compareTo(r112) >= 0) goto L34;
        r108 = r112;
        goto L34
    L56:
        return null;
    L24:
        r104 = false;
        goto L25
    L12:
        if (r100.intValue() <= 0) goto L14;
        boolean r113 = true;
    L15:
        if (r113 == true) goto L18;
        r100 = null;
    L18:
        if (r100 == null) goto L20;
        r102 = r100.intValue();
        goto L21
    L14:
        r113 = false;
        goto L15
    L5:
        ViewGroup.LayoutParams r114 = this.f304467a.getLayoutParams();
        if (r114 == null) goto L8;
        r100 = Integer.valueOf(r114.width);
        goto L9
    L8:
        r100 = null;
        goto L9
    }

    public final Map<String, Integer> d(int r110) {
        int r111 = RangesKt.coerceAtLeast((r110 - this.f304467a.getPaddingLeft()) - this.f304467a.getPaddingRight(), 0);
        LinkedHashMap r100 = new LinkedHashMap();
        LinkedHashSet r101 = new LinkedHashSet();
        int r102 = this.f304467a.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L29;
        View r104 = this.f304467a.getChildAt(r103);
        Intrinsics.checkNotNull(r104);
        boolean r105 = true;
        if (r104.getVisibility() != 8) goto L7;
        boolean r106 = true;
    L8:
        String r107 = null;
        if (r106 == false) goto L12;
        r104 = null;
    L12:
        if (r104 == null) goto L28;
        String r108 = this.f304470d.invoke(r104);
        if (r108 == null) goto L28;
        if (r108.length() > 0) goto L20;
        r105 = false;
    L20:
        if (r105 == false) goto L22;
        r107 = r108;
    L22:
        if (r107 == null) goto L28;
        if (r100.containsKey(r107) == false) goto L27;
        r101.add(r107);
        goto L28
    L27:
        r100.put(r107, Integer.valueOf(e(r104, r111).f304482a));
    L28:
        r103 = r103 + 1;
        goto L3
    L7:
        r106 = false;
        goto L8
    L29:
        Iterator r112 = r101.iterator();
    L31:
        if (r112.hasNext() == false) goto L33;
        r100.remove((String) r112.next());
        goto L31
    L33:
        return r100;
    }

    public final void f(Integer r100) {
        if (this.f304480n == true) goto L10;
        if (r100 != null) goto L10;
        if (this.f304479m == true) goto L10;
        if (this.f304476j.isEmpty() == false) goto L10;
        return;
    L10:
        ViewGroup.LayoutParams r101 = this.f304467a.getLayoutParams();
        boolean r102 = this.f304480n;
        this.f304480n = false;
        this.f304475i = null;
        if (this.f304479m == false) goto L13;
        this.f304467a.setClipBounds(this.f304478l);
        this.f304478l = null;
        this.f304479m = false;
    L13:
        Iterator<T> r103 = this.f304476j.iterator();
    L15:
        if (r103.hasNext() == false) goto L19;
        Pair r104 = (Pair) r103.next();
        View r105 = (View) r104.component1();
        int r106 = ((Number) r104.component2()).intValue();
        ViewGroup.LayoutParams r107 = r105.getLayoutParams();
        if (r107 == null) goto L15;
        r107.width = r106;
        r105.setLayoutParams(r107);
        goto L15
    L19:
        this.f304476j = CollectionsKt.emptyList();
        if (r102 == true) goto L23;
        this.f304477k = null;
        return;
    L23:
        if (r101 != null) goto L25;
        return;
    L25:
        Integer r108 = this.f304477k;
        if (r108 == null) goto L28;
        int r109 = r108.intValue();
    L29:
        r101.width = r109;
        this.f304477k = null;
        this.f304467a.setLayoutParams(r101);
        return;
    L28:
        r109 = r101.width;
        goto L29
    }

    public final void h(int r100) {
        ViewGroup.LayoutParams r101 = this.f304467a.getLayoutParams();
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f304480n == true) goto L8;
        this.f304477k = Integer.valueOf(r101.width);
    L8:
        r101.width = r100;
        this.f304467a.setLayoutParams(r101);
        this.f304480n = true;
    }

    public static b e(View r100, int r101) {
        int r102 = 0;
        if (r100.getVisibility() != 8) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        r100.measure(View.MeasureSpec.makeMeasureSpec(r101, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
    L13:
        if (r105 == null) goto L16;
        r102 = r105.leftMargin + r105.rightMargin;
    L16:
        return new b(r100.getMeasuredWidth(), r102);
    L12:
        r105 = null;
        goto L13
    L8:
        return new b(0, 0);
    L5:
        r103 = false;
        goto L6
    }

    public static void g(View r100, int r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L6;
        r102.width = r101;
        r100.setLayoutParams(r102);
        return;
    }

    public l3(ViewGroup r100, s2 r101, t2 r102, u2 r103) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        Intrinsics.checkNotNullParameter("WcbSugPromptSpan", "tag");
        Intrinsics.checkNotNullParameter(r101, "maxWidthProvider");
        Intrinsics.checkNotNullParameter(r102, "childKeyProvider");
        Intrinsics.checkNotNullParameter(r103, "childChangeKeyProvider");
        this.f304467a = r100;
        this.f304468b = "WcbSugPromptSpan";
        this.f304469c = r101;
        this.f304470d = r102;
        this.f304471e = r103;
        this.f304476j = CollectionsKt.emptyList();
    }

    public final void a(String r310, Set r311, Map r312, n2 r313) {
        final l3 r110 = this;
        Set r111 = r311;
        Map r112 = r312;
        Intrinsics.checkNotNullParameter(r112, "changedWcbItemStartKeys");
        Intrinsics.checkNotNullParameter(r313, "updateContent");
        b();
        Integer r113 = null;
        String r100 = "alpha";
        if (r111 != null) goto L5;
        Integer r101 = c();
        if (r101 != null) goto L200;
        r101 = Integer.valueOf(r110.f304467a.getWidth());
        if (r101.intValue() <= 0) goto L186;
        boolean r102 = true;
    L187:
        if (r102 == true) goto L190;
        r101 = null;
    L190:
        if (r101 != null) goto L200;
        r101 = Integer.valueOf(r110.f304467a.getMeasuredWidth());
        if (r101.intValue() <= 0) goto L195;
        boolean r103 = true;
    L196:
        if (r103 == true) goto L199;
        r101 = null;
    L199:
        if (r101 != null) goto L200;
        ViewGroup.LayoutParams r104 = r110.f304467a.getLayoutParams();
        if (r104 == null) goto L209;
        r101 = Integer.valueOf(r104.width);
        if (r101.intValue() <= 0) goto L206;
        boolean r105 = true;
    L207:
        if (r105 == false) goto L209;
    L210:
        if (r101 != null) goto L200;
        int r106 = 0;
    L213:
        Map<String, Integer> r107 = r110.d(r106);
        if (r106 <= 0) goto L216;
        r110.h(r106);
    L216:
        final int r114 = r110.f304481o + 1;
        r110.f304481o = r114;
        Integer r108 = Integer.valueOf(r110.f304467a.getHeight());
        if (r108.intValue() <= 0) goto L219;
        boolean r109 = true;
    L220:
        if (r109 == true) goto L223;
        r108 = null;
    L223:
        if (r108 != null) goto L233;
        r108 = Integer.valueOf(r110.f304467a.getMeasuredHeight());
        if (r108.intValue() <= 0) goto L228;
        boolean r115 = true;
    L229:
        if (r115 == true) goto L232;
        r108 = null;
    L232:
        if (r108 != null) goto L233;
        int r116 = 0;
    L235:
        ViewParent r117 = r110.f304467a.getParent();
        if ((r117 instanceof ViewGroup) == false) goto L238;
        final ViewGroup r118 = (ViewGroup) r117;
    L239:
        if (r118 == null) goto L250;
        if (r106 <= 0) goto L250;
        if (r116 <= 0) goto L250;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L244
        Bitmap r120 = Bitmap.createBitmap(r106, r116, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L244
        r110.f304467a.draw(new Canvas(r120));     // Catch: Throwable -> L244
        ClipDrawable r121 = new ClipDrawable(new BitmapDrawable(r110.f304467a.getResources(), r120), GravityCompat.START, 1);     // Catch: Throwable -> L244
        r121.setBounds(r110.f304467a.getLeft(), r110.f304467a.getTop(), r110.f304467a.getLeft() + r106, r110.f304467a.getTop() + r116);     // Catch: Throwable -> L244
        r121.setLevel(10000);     // Catch: Throwable -> L244
        Object r122 = Result.m9449constructorimpl(r121);     // Catch: Throwable -> L244
    L247:
        if (Result.m9455isFailureimpl(r122) == false) goto L249;
        r122 = null;
    L249:
        final ClipDrawable r123 = (ClipDrawable) r122;
    L251:
        if (r123 == null) goto L256;
        if (r118 == null) goto L256;
        ViewGroupOverlay r124 = r118.getOverlay();
        if (r124 == null) goto L256;
        r124.add(r123);
        Unit r125 = Unit.INSTANCE;
    L256:
        if (r123 == null) goto L258;
        ValueAnimator r126 = ValueAnimator.ofInt(new int[]{255, 0});
        r126.setDuration(100);
        r126.setInterpolator(f304466p);
        r126.addUpdateListener(new j3(r123, r118));
        r126.addListener(new o3(r110, r118, r123));
    L259:
        r110.f304472f = r126;
        r313.invoke();
        Integer r127 = c();
        if (r110.f304480n == false) goto L262;
        Integer r128 = r110.f304477k;
    L266:
        if (r127 != null) goto L286;
        if (r128 != null) goto L270;
    L275:
        r128 = null;
    L276:
        if (r128 == null) goto L278;
        int r129 = r128.intValue();
    L287:
        final int r130 = r129;
        FLogger.f375446a.i(r110.f304468b, "refreshStartCombined contentKey=" + r310 + ", startWidth=" + r106 + ", targetWidth=" + r130);
        Map<String, Integer> r131 = r110.d(r130);
        if ((!r107.isEmpty()) == true) goto L292;
    L294:
        boolean r132 = false;
    L296:
        if (r131.isEmpty() == true) goto L311;
        Iterator r133 = ((LinkedHashMap) r131).entrySet().iterator();
    L300:
        if (r133.hasNext() == false) goto L311;
        Map.Entry r134 = (Map.Entry) r133.next();
        String r135 = (String) r134.getKey();
        int r136 = ((Number) r134.getValue()).intValue();
        Integer r137 = (Integer) ((LinkedHashMap) r107).get(r135);
        if (r137 == null) goto L308;
        int r138 = r137.intValue();
        if (r132 == false) goto L308;
        if (r138 <= r136) goto L308;
        if (r136 <= 0) goto L308;
        boolean r139 = true;
    L309:
        if (r139 == false) goto L300;
        boolean r140 = true;
    L312:
        if (r106 <= r130) goto L315;
        if (r130 <= 0) goto L315;
        boolean r141 = true;
    L316:
        r110.f304467a.setAlpha(0.0f);
        if (r141 == true) goto L321;
        if (r140 == true) goto L321;
        boolean r142 = false;
    L322:
        ArrayList r143 = new ArrayList();
        if (r126 == null) goto L325;
        r143.add(r126);
    L325:
        if (r130 > 0) goto L327;
        r110.f(Integer.valueOf(r130));
        ArrayList r314 = r143;
    L470:
        ArrayList r315 = r314;
        int r144 = r114;
        final l3 r145 = r110;
        ValueAnimator r146 = null;
        float r147 = 0.0f;
        char r148 = 0;
    L516:
        ArrayList r149 = r315;
        if (r146 == null) goto L519;
        r149.add(r146);
    L519:
        ViewGroup r150 = r145.f304467a;
        float[] r151 = new float[2];
        r151[r148] = r147;
        r151[1] = 1.0f;
        ObjectAnimator r152 = ObjectAnimator.ofFloat(r150, "alpha", r151);
        r152.setDuration(240);
        r152.setInterpolator(f304466p);
        r149.add(r152);
        if (r149.isEmpty() == false) goto L522;
        r145.f304467a.setAlpha(1.0f);
        return;
    L522:
        AnimatorSet r153 = new AnimatorSet();
        r153.playTogether(r149);
        r153.addListener(new q3(r145, r144, r310));
        r153.start();
        r145.f304473g = r153;
        return;
    L327:
        Integer r154 = Integer.valueOf(r106);
        if (r154.intValue() <= 0) goto L330;
        boolean r155 = true;
    L331:
        if (r155 == true) goto L334;
        r154 = null;
    L334:
        if (r154 == null) goto L336;
        final int r156 = r154.intValue();
    L337:
        if (r156 >= r130) goto L339;
        final boolean r157 = true;
    L340:
        if (r156 == r130) goto L342;
        boolean r158 = true;
    L343:
        if (r158 == true) goto L345;
    L351:
        if (r132 == false) goto L355;
        if (r157 == true) goto L355;
        if (r158 == true) goto L355;
        boolean r159 = true;
    L356:
        if (r142 == false) goto L359;
        if (r158 == true) goto L359;
        boolean r160 = true;
    L360:
        int r161 = RangesKt.coerceAtLeast((r130 - r110.f304467a.getPaddingLeft()) - r110.f304467a.getPaddingRight(), 0);
        LinkedHashSet r162 = new LinkedHashSet();
        LinkedHashSet r163 = new LinkedHashSet();
        int r164 = r110.f304467a.getChildCount();
        r314 = r143;
        int r165 = 0;
    L361:
        if (r165 >= r164) goto L386;
        View r166 = r110.f304467a.getChildAt(r165);
        Intrinsics.checkNotNull(r166);
        int r316 = r164;
        if (r166.getVisibility() != 8) goto L365;
        boolean r167 = true;
    L366:
        if (r167 == true) goto L368;
        View r168 = r166;
    L369:
        if (r168 == null) goto L385;
        String r169 = r110.f304470d.invoke(r168);
        if (r169 == null) goto L385;
        if (r169.length() <= 0) goto L376;
        boolean r170 = true;
    L377:
        if (r170 == true) goto L380;
        r169 = null;
    L380:
        if (r169 == null) goto L385;
        if (r162.add(r169) == true) goto L385;
        r163.add(r169);
        goto L385
    L376:
        r170 = false;
    L385:
        r165 = r165 + 1;
        r164 = r316;
        goto L361
    L368:
        r168 = null;
        goto L369
    L365:
        r167 = false;
        goto L366
    L386:
        r162.removeAll(r163);
        IntRange r171 = RangesKt.until(0, r110.f304467a.getChildCount());
        final ArrayList r172 = new ArrayList();
        Iterator<Integer> r173 = r171.iterator();
    L388:
        if (r173.hasNext() == false) goto L446;
        View r174 = r110.f304467a.getChildAt(((IntIterator) r173).nextInt());
        Intrinsics.checkNotNull(r174);
        Iterator<Integer> r317 = r173;
        if (r174.getVisibility() != 8) goto L392;
        boolean r175 = true;
    L393:
        if (r175 == false) goto L396;
        r174 = null;
    L396:
        if (r174 != null) goto L398;
    L397:
        LinkedHashSet r176 = r162;
        c r177 = null;
    L443:
        if (r177 == null) goto L445;
        r172.add(r177);
    L445:
        r173 = r317;
        r123 = r123;
        r162 = r176;
        goto L388
    L398:
        ViewGroup.LayoutParams r178 = r174.getLayoutParams();
        if (r178 == null) goto L397;
        int r179 = r178.width;
        Integer r180 = Integer.valueOf(e(r174, r161).f304482a);
        if (r180.intValue() <= 0) goto L404;
        boolean r181 = true;
    L405:
        if (r181 == true) goto L408;
        r180 = null;
    L408:
        if (r180 == null) goto L397;
        int r182 = RangesKt.coerceAtMost(r180.intValue(), r161);
        String r183 = r110.f304470d.invoke(r174);
        if (r183 != null) goto L412;
    L417:
        r183 = null;
    L418:
        if (r183 != null) goto L420;
    L432:
        r176 = r162;
    L433:
        Integer r184 = null;
    L434:
        if (r160 == false) goto L437;
        if (r184 == null) goto L440;
        int r185 = RangesKt.coerceAtLeast(r184.intValue(), r182);
    L441:
        r177 = new c(r174, r179, r185, r182);
    L440:
        r185 = r182;
        goto L441
    L437:
        if (r159 == false) goto L440;
        if (r184 == null) goto L440;
        r185 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r184.intValue(), r161), r182);
        goto L441
    L420:
        if (r162.contains(r183) == true) goto L423;
        r183 = null;
    L423:
        if (r183 == null) goto L432;
        r176 = r162;
        r184 = (Integer) ((LinkedHashMap) r107).get(r183);
        if (r184 == null) goto L433;
        if (r184.intValue() <= 0) goto L429;
        boolean r186 = true;
    L430:
        if (r186 == false) goto L433;
    L429:
        r186 = false;
        goto L430
    L412:
        if (r183.length() <= 0) goto L414;
        boolean r187 = true;
    L415:
        if (r187 == false) goto L417;
    L414:
        r187 = false;
        goto L415
    L404:
        r181 = false;
        goto L405
    L392:
        r175 = false;
        goto L393
    L446:
        final ClipDrawable r188 = r123;
        ArrayList r189 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r172, 10));
        Iterator r190 = r172.iterator();
    L448:
        if (r190.hasNext() == false) goto L450;
        c r191 = (c) r190.next();
        r189.add(TuplesKt.to(r191.f304485a, Integer.valueOf(r191.f304486b)));
        goto L448
    L450:
        r110.f304476j = r189;
        Iterator r192 = r172.iterator();
    L452:
        if (r192.hasNext() == false) goto L455;
        c r193 = (c) r192.next();
        g(r193.f304485a, r193.f304487c);
        goto L452
    L455:
        if (r172.isEmpty() == true) goto L466;
        Iterator r194 = r172.iterator();
    L459:
        if (r194.hasNext() == false) goto L466;
        c r195 = (c) r194.next();
        if (r195.f304487c == r195.f304488d) goto L463;
        boolean r196 = true;
    L464:
        if (r196 == false) goto L459;
        boolean r197 = true;
    L467:
        if (r156 != r130) goto L471;
        if (r197 == true) goto L471;
        r110.f(Integer.valueOf(r130));
    L471:
        r110.f304475i = Integer.valueOf(r130);
        if (r157 == false) goto L474;
        int r198 = r130;
    L475:
        r110.h(r198);
        final LinkedHashMap r199 = new LinkedHashMap();
        final ArrayList r200 = new ArrayList();
        Resources r201 = r110.f304467a.getResources();
        final int r1100 = RangesKt.coerceAtLeast(MathKt.roundToInt(WindowDisplayMetricsOverride.apply(r201, r201.getDisplayMetrics()).density), 1);
        if (r157 == false) goto L493;
        if (r158 == false) goto L493;
        int r202 = r110.f304467a.getChildCount();
        int r203 = 0;
    L479:
        if (r203 >= r202) goto L493;
        View r204 = r110.f304467a.getChildAt(r203);
        Intrinsics.checkNotNull(r204);
        if (r204.getVisibility() != 8) goto L483;
        boolean r205 = true;
    L484:
        if (r205 == false) goto L487;
        r204 = null;
    L487:
        if (r204 == null) goto L492;
        if (r204.getBackground() == null) goto L492;
        r200.add(r204);
    L492:
        r203 = r203 + 1;
        goto L479
    L483:
        r205 = false;
    L493:
        if (r158 == false) goto L515;
        Integer r206 = Integer.valueOf(r110.f304467a.getHeight());
        if (r206.intValue() <= 0) goto L497;
        boolean r207 = true;
    L498:
        if (r207 == true) goto L501;
        r206 = null;
    L501:
        if (r206 != null) goto L511;
        Integer r208 = Integer.valueOf(r110.f304467a.getMeasuredHeight());
        if (r208.intValue() <= 0) goto L506;
        boolean r209 = true;
    L507:
        if (r209 == false) goto L509;
        r113 = r208;
    L509:
        if (r113 == null) goto L512;
        r206 = r113;
        goto L511
    L512:
        int r210 = Integer.MAX_VALUE;
    L513:
        r110.f304467a.setClipBounds(new Rect(0, 0, r156, r210));
        goto L515
    L506:
        r209 = false;
    L511:
        r210 = r206.intValue();
        goto L513
    L497:
        r207 = false;
    L515:
        ValueAnimator r211 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r211.setDuration(240);
        r211.setInterpolator(f304466p);
        r145 = this;
        r315 = r314;
        final boolean r212 = r158;
        r147 = 0.0f;
        r148 = 0;
        r144 = r114;
        r146 = r211;
        r146.addUpdateListener(new k3(r114, r145, r156, r130, r212, r157, r200, r188, r172, r199, r1100));
        r146.addListener(new p3(r199, r144, r145, r130));
        r145.f304474h = r146;
        goto L516
    L474:
        r198 = r156;
        goto L475
    L463:
        r196 = false;
    L466:
        r197 = false;
    L359:
        r160 = false;
    L355:
        r159 = false;
        goto L356
    L345:
        if (r110.f304479m == true) goto L351;
        Rect r213 = r110.f304467a.getClipBounds();
        if (r213 == null) goto L349;
        Rect r214 = new Rect(r213);
    L350:
        r110.f304478l = r214;
        r110.f304479m = true;
        goto L351
    L349:
        r214 = null;
        goto L350
    L342:
        r158 = false;
        goto L343
    L339:
        r157 = false;
        goto L340
    L336:
        r156 = r130;
        goto L337
    L330:
        r155 = false;
    L321:
        r142 = true;
    L315:
        r141 = false;
    L308:
        r139 = false;
    L311:
        r140 = false;
        goto L312
    L292:
        if ((!r131.isEmpty()) == false) goto L294;
        r132 = true;
        goto L296
    L278:
        r127 = Integer.valueOf(r110.f304467a.getMeasuredWidth());
        if (r127.intValue() <= 0) goto L281;
        boolean r215 = true;
    L282:
        if (r215 == true) goto L285;
        r127 = null;
    L285:
        if (r127 != null) goto L286;
        r129 = r110.f304469c.invoke().intValue();
        goto L287
    L281:
        r215 = false;
        goto L282
    L270:
        if (r128.intValue() <= 0) goto L272;
        boolean r216 = true;
    L273:
        if (r216 == false) goto L275;
    L272:
        r216 = false;
    L286:
        r129 = r127.intValue();
        goto L287
    L262:
        ViewGroup.LayoutParams r217 = r110.f304467a.getLayoutParams();
        if (r217 == null) goto L265;
        r128 = Integer.valueOf(r217.width);
        goto L266
    L265:
        r128 = null;
        goto L266
    L258:
        r126 = null;
    L244:
        th = move-exception;
        Result.Companion r218 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L250:
        r123 = null;
        goto L251
    L238:
        r118 = null;
        goto L239
    L228:
        r115 = false;
    L233:
        r116 = r108.intValue();
        goto L235
    L219:
        r109 = false;
        goto L220
    L206:
        r105 = false;
    L209:
        r101 = null;
        goto L210
    L195:
        r103 = false;
        goto L196
    L186:
        r102 = false;
    L200:
        r106 = r101.intValue();
        goto L213
    L5:
        if (r311.isEmpty() == false) goto L8;
        r313.invoke();
        return;
    L8:
        int r1101 = r110.f304481o + 1;
        r110.f304481o = r1101;
        LinkedHashMap r219 = new LinkedHashMap();
        LinkedHashMap r1102 = new LinkedHashMap();
        int r220 = r110.f304467a.getChildCount();
        int r1103 = 0;
    L9:
        if (r1103 >= r220) goto L72;
        View r221 = r110.f304467a.getChildAt(r1103);
        if ((r221 instanceof WcbItemLinearLayout) == false) goto L13;
        WcbItemLinearLayout r222 = (WcbItemLinearLayout) r221;
    L14:
        if (r222 != null) goto L16;
    L15:
        int r318 = r220;
    L71:
        r1103 = r1103 + 1;
        r220 = r318;
        goto L9
    L16:
        String r223 = r110.f304471e.invoke(r222);
        if (r223 == null) goto L15;
        if (r111.contains(r223) == false) goto L15;
        Integer r224 = Integer.valueOf(r222.getWidth());
        if (r224.intValue() <= 0) goto L24;
        boolean r225 = true;
    L25:
        if (r225 == true) goto L28;
        r224 = null;
    L28:
        if (r224 != null) goto L38;
        r224 = Integer.valueOf(r222.getMeasuredWidth());
        if (r224.intValue() <= 0) goto L33;
        boolean r226 = true;
    L34:
        if (r226 == true) goto L37;
        r224 = null;
    L37:
        if (r224 == null) goto L15;
    L33:
        r226 = false;
    L38:
        int r227 = r224.intValue();
        Integer r228 = Integer.valueOf(r222.getHeight());
        if (r228.intValue() <= 0) goto L41;
        boolean r229 = true;
    L42:
        if (r229 == true) goto L45;
        r228 = null;
    L45:
        if (r228 != null) goto L55;
        r228 = Integer.valueOf(r222.getMeasuredHeight());
        if (r228.intValue() <= 0) goto L50;
        boolean r230 = true;
    L51:
        if (r230 == true) goto L54;
        r228 = null;
    L54:
        if (r228 == null) goto L15;
    L50:
        r230 = false;
    L55:
        int r231 = r228.intValue();
        Result.Companion r232 = Result.Companion;     // Catch: Throwable -> L62
        Bitmap r233 = Bitmap.createBitmap(r227, r231, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L62
        r222.draw(new Canvas(r233));     // Catch: Throwable -> L62
        r318 = r220;
        ClipDrawable r234 = new ClipDrawable(new BitmapDrawable(r110.f304467a.getResources(), r233), GravityCompat.START, 1);     // Catch: Throwable -> L60
        r234.setBounds(r222.getLeft(), r222.getTop(), r222.getLeft() + r227, r222.getTop() + r231);     // Catch: Throwable -> L60
        r234.setLevel(10000);     // Catch: Throwable -> L60
        Object r235 = Result.m9449constructorimpl(r234);     // Catch: Throwable -> L60
    L66:
        if (Result.m9455isFailureimpl(r235) == false) goto L68;
        r235 = null;
    L68:
        ClipDrawable r236 = (ClipDrawable) r235;
        if (r236 == null) goto L71;
        r219.put(r223, r236);
        r1102.put(r223, Integer.valueOf(r227));
        r110.f304467a.getOverlay().add(r236);
        Unit r237 = Unit.INSTANCE;
    L60:
        th = th;
    L64:
        Result.Companion r238 = Result.Companion;
        r235 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L62:
        th = th;
        r318 = r220;
        goto L64
    L41:
        r229 = false;
        goto L42
    L24:
        r225 = false;
        goto L25
    L13:
        r222 = null;
        goto L14
    L72:
        r313.invoke();
        int r239 = RangesKt.coerceAtLeast((r110.f304469c.invoke().intValue() - r110.f304467a.getPaddingLeft()) - r110.f304467a.getPaddingRight(), 0);
        ArrayList r1104 = new ArrayList();
        Iterator r240 = r219.entrySet().iterator();
    L74:
        if (r240.hasNext() == false) goto L76;
        final ClipDrawable r241 = (ClipDrawable) ((Map.Entry) r240.next()).getValue();
        ValueAnimator r242 = ValueAnimator.ofInt(new int[]{255, 0});
        r242.setDuration(240);
        r242.setInterpolator(f304466p);
        r242.addUpdateListener(new h3(r241, r110));
        r242.addListener(new m3(r110, r241));
        r1104.add(r242);
        goto L74
    L76:
        ArrayList r243 = new ArrayList();
        ArrayList r244 = new ArrayList();
        final LinkedHashMap r245 = new LinkedHashMap();
        Resources r246 = r110.f304467a.getResources();
        int r247 = RangesKt.coerceAtLeast(MathKt.roundToInt(WindowDisplayMetricsOverride.apply(r246, r246.getDisplayMetrics()).density), 1);
        int r248 = r110.f304467a.getChildCount();
        int r249 = 0;
    L77:
        if (r249 >= r248) goto L174;
        View r250 = r110.f304467a.getChildAt(r249);
        int r251 = r249;
        if ((r250 instanceof WcbItemLinearLayout) == false) goto L81;
        WcbItemLinearLayout r252 = (WcbItemLinearLayout) r250;
    L82:
        if (r252 != null) goto L84;
    L83:
        r239 = r239;
        final LinkedHashMap r253 = r219;
        r100 = r100;
        final int r254 = r247;
        r245 = r245;
        ArrayList r255 = r244;
        ArrayList r319 = r243;
        r1102 = r1102;
        r251 = r251;
        int r256 = r248;
    L172:
        ArrayList r1105 = r1104;
    L173:
        r249 = r251 + 1;
        r110 = this;
        r111 = r311;
        r112 = r312;
        r247 = r254;
        r1104 = r1105;
        r1102 = r1102;
        r100 = r100;
        r248 = r256;
        r245 = r245;
        r244 = r255;
        r219 = r253;
        r243 = r319;
        r1101 = r1101;
        r239 = r239;
        goto L77
    L84:
        String r257 = r110.f304471e.invoke(r252);
        if (r257 == null) goto L83;
        if (r111.contains(r257) == false) goto L83;
        int r320 = r248;
        ViewGroup.LayoutParams r258 = r252.getLayoutParams();
        if (r258 != null) goto L92;
        r253 = r219;
    L170:
        r254 = r247;
        r255 = r244;
        r319 = r243;
    L171:
        r256 = r320;
        goto L172
    L92:
        int r259 = r258.width;
        r253 = r219;
        Integer r260 = Integer.valueOf(e(r252, r239).f304482a);
        if (r260.intValue() <= 0) goto L95;
        boolean r261 = true;
    L96:
        if (r261 == true) goto L99;
        r260 = null;
    L99:
        if (r260 == null) goto L170;
        final int r262 = RangesKt.coerceAtMost(r260.intValue(), r239);
        Integer r263 = (Integer) r1102.get(r257);
        if (r263 != null) goto L103;
    L111:
        r239 = r239;
        String r264 = (String) r112.get(r257);
        if (r264 == null) goto L121;
        Integer r265 = (Integer) r1102.get(r264);
        if (r265 == null) goto L121;
        if (r265.intValue() <= 0) goto L118;
        boolean r266 = true;
    L119:
        if (r266 == false) goto L121;
    L122:
        if (r265 == null) goto L124;
        int r267 = r265.intValue();
    L125:
        r243.add(TuplesKt.to(r252, Integer.valueOf(r259)));
        r252.setAlpha(0.0f);
        if (r267 >= r262) goto L128;
        boolean r268 = true;
    L129:
        Integer r269 = Integer.valueOf(r252.getHeight());
        if (r269.intValue() <= 0) goto L132;
        boolean r270 = true;
    L133:
        if (r270 == true) goto L136;
        r269 = null;
    L136:
        if (r269 != null) goto L144;
        r269 = Integer.valueOf(r252.getMeasuredHeight());
        if (r269.intValue() <= 0) goto L140;
        boolean r271 = true;
    L141:
        if (r271 == true) goto L144;
        Integer r272 = null;
    L145:
        if (r268 == false) goto L164;
        g(r252, r262);
        if (r272 == null) goto L162;
        int r273 = r272.intValue();
        String r274 = r257;
        Rect r275 = r252.getClipBounds();
        ArrayList r276 = r243;
        if (r275 == null) goto L151;
        Rect r277 = new Rect(r275);
    L152:
        r244.add(TuplesKt.to(r252, r277));
        r252.setClipBounds(new Rect(0, 0, r267, r273));
        Drawable r278 = r252.getBackground();
        if (r278 == null) goto L165;
        Drawable.ConstantState r279 = r278.getConstantState();
        if (r279 == null) goto L165;
        Drawable r280 = r279.newDrawable();
        if (r280 == null) goto L165;
        Drawable r281 = r280.mutate();
        if (r281 == null) goto L165;
        r247 = r247;
        int r282 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r247, r262), 1);
        Bitmap r283 = Bitmap.createBitmap(r282, r273, Bitmap.Config.ARGB_8888);
        r244 = r244;
        Canvas r284 = new Canvas(r283);
        r284.translate(-(r262 - r282), 0.0f);
        r281.setBounds(0, 0, r262, r273);
        r281.draw(r284);
        BitmapDrawable r285 = new BitmapDrawable(r110.f304467a.getResources(), r283);
        r285.setBounds(RangesKt.coerceAtLeast(r267 - r282, 0), 0, r267, r273);
        r285.setAlpha(0);
        r252.getOverlay().add(r285);
        r245.put(r252, r285);
    L165:
        ObjectAnimator r286 = ObjectAnimator.ofFloat(r252, r100, new float[]{0.0f, 1.0f});
        r286.setDuration(240);
        PathInterpolator r287 = f304466p;
        r286.setInterpolator(r287);
        r1104.add(r286);
        if (r267 == r262) goto L168;
        ValueAnimator r288 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r288.setDuration(240);
        r288.setInterpolator(r287);
        final String r1106 = r274;
        final WcbItemLinearLayout r289 = r252;
        r251 = r251;
        final int r290 = r1101;
        r256 = r320;
        String r1107 = r100;
        final int r291 = r267;
        r100 = r1107;
        r254 = r247;
        r245 = r245;
        final boolean r292 = r268;
        r255 = r244;
        final Integer r293 = r272;
        r1101 = r1101;
        r1105 = r1104;
        r1102 = r1102;
        r319 = r276;
        r288.addUpdateListener(new i3(r290, this, r289, r291, r262, r292, r293, r245, r253, r1106, r254));
        r1105.add(r288);
        goto L173
    L168:
        r319 = r276;
        r254 = r247;
        r255 = r244;
        goto L171
    L151:
        r277 = null;
        goto L152
    L162:
        r274 = r257;
        r276 = r243;
        goto L165
    L164:
        r274 = r257;
        r247 = r247;
        r244 = r244;
        r276 = r243;
        g(r252, r267);
        Unit r294 = Unit.INSTANCE;
        goto L165
    L140:
        r271 = false;
    L144:
        r272 = r269;
        goto L145
    L132:
        r270 = false;
        goto L133
    L128:
        r268 = false;
        goto L129
    L124:
        r267 = r262;
        goto L125
    L118:
        r266 = false;
    L121:
        r265 = null;
        goto L122
    L103:
        if (r263.intValue() <= 0) goto L105;
        boolean r295 = true;
    L106:
        if (r295 == true) goto L109;
        r263 = null;
    L109:
        if (r263 == null) goto L111;
        r239 = r239;
        r267 = r263.intValue();
        goto L125
    L105:
        r295 = false;
        goto L106
    L95:
        r261 = false;
        goto L96
    L81:
        r252 = null;
        goto L82
    L174:
        LinkedHashMap r296 = r245;
        ArrayList r297 = r244;
        ArrayList r298 = r243;
        int r321 = r1101;
        ArrayList r1108 = r1104;
        r110.f304476j = r298;
        if (r1108.isEmpty() == false) goto L178;
        r110.f(r110.f304475i);
        return;
    L178:
        AnimatorSet r299 = new AnimatorSet();
        r299.playTogether(r1108);
        r299.addListener(new n3(this, r296, r297, r298, r321));
        r299.start();
        r110.f304473g = r299;
    }
}
