package com.ss.ugc.live.barrage.controller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes36.dex */
public class ScrollBarrageController extends AbsBarrageController {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f458106J = null;
    public AbsBarrage A;
    public final HashMap<AbsBarrage, RectF> B;
    public final HashSet<Animator> C;
    public final RectF D;
    public boolean E;
    public final RectF F;
    public boolean G;
    public final View H;
    public final h I;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f458107n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f458108o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f458109p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Deque<AbsBarrage> f458110q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Deque<com.ss.ugc.live.barrage.barrage.d> f458111r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final com.ss.ugc.live.barrage.barrage.b f458112s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.ss.ugc.live.barrage.controller.f f458113t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Random f458114u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashMap<Integer, AbsBarrage> f458115v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList<Integer> f458116w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final HashMap<AbsBarrage, b> f458117x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.ss.ugc.live.barrage.controller.e f458118y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final RectF f458119z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f458120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f458121b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f458122c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f458123d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f458124e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
        L28:
            return true;
        L5:
            if ((r100 instanceof b) == false) goto L27;
            b r101 = (b) r100;
            if (this.f458121b != r101.f458121b) goto L9;
            boolean r102 = true;
        L10:
            if (r102 == false) goto L27;
            if (this.f458122c != r101.f458122c) goto L14;
            boolean r103 = true;
        L15:
            if (r103 == false) goto L27;
            if (this.f458123d != r101.f458123d) goto L19;
            boolean r104 = true;
        L20:
            if (r104 == false) goto L27;
            if (this.f458124e != r101.f458124e) goto L24;
            boolean r105 = true;
        L25:
            if (r105 == false) goto L27;
        L24:
            r105 = false;
            goto L25
        L19:
            r104 = false;
            goto L20
        L14:
            r103 = false;
            goto L15
        L9:
            r102 = false;
        L27:
            return false;
        }

        public final int hashCode() {
            return (((((this.f458121b * 31) + this.f458122c) * 31) + this.f458123d) * 31) + this.f458124e;
        }

        public final String toString() {
            return "DanmakuConfig(lineHeight=" + this.f458121b + ", lineSpacing=" + this.f458122c + ", displayHeight=" + this.f458123d + ", duration=" + this.f458124e + ")";
        }

        public b(int r100, int r101, int r102) {
            this.f458121b = r100;
            this.f458122c = 0;
            this.f458123d = r101;
            this.f458124e = r102;
            this.f458120a = (r101 - 0) / (r100 + 0);
        }
    }

    public interface c {
        boolean a();
    }

    public interface d {
        boolean a();
    }

    public interface e {
        int[] b();

        void e();
    }

    public interface f {
        boolean c(int r100);

        void f(float r100);
    }

    public interface g {
        int[] d();
    }

    public interface h {
    }

    public static final class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsBarrage f458125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RectF f458126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ScrollBarrageController f458127c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            if (r100 == null) goto L4;
            this.f458127c.C.remove(r100);
        L4:
            this.f458127c.B.remove(this.f458125a);
            this.f458126b.setEmpty();
            this.f458127c.H.invalidate();
        }

        public i(AbsBarrage r100, RectF r101, ScrollBarrageController r102) {
            this.f458125a = r100;
            this.f458126b = r101;
            this.f458127c = r102;
        }
    }

    public static final class j implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RectF f458128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f458129b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ScrollBarrageController f458130c;

        public j(RectF r100, float r101, ScrollBarrageController r102) {
            this.f458128a = r100;
            this.f458129b = r101;
            this.f458130c = r102;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L7;
            float r102 = ((Float) r101).floatValue();
            this.f458128a.offsetTo(r102, this.f458129b);
            this.f458130c.H.invalidate();
            return;
        L7:
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
        f458106J = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ScrollBarrageController.class), "danmakuLinePaint", "getDanmakuLinePaint()Landroid/graphics/Paint;"))};
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public void b() {
        Iterator<Animator> r100 = this.C.iterator();     // Catch: Throwable -> L8
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().cancel();     // Catch: Throwable -> L8
        goto L4
    L6:
        this.C.clear();     // Catch: Throwable -> L8
        super.b();     // Catch: Throwable -> L8
        return;
    }

    public final Context getContext() {
        return this.H.getContext();
    }

    public final void r() {
        AbsBarrage r100 = this.A;
        if (r100 == null) goto L15;
        r100.i().setAlpha(r100.f458065m.f458067a);
        if (this.E == true) goto L15;
        RectF r101 = new RectF(this.f458119z);
        this.B.put(r100, r101);
        float r102 = r101.left;
        float r103 = r101.top;
        b r104 = this.f458117x.get(r100);
        if (r104 != null) goto L11;
        r104 = this.f458109p;
    L11:
        if ((r100 instanceof f) == false) goto L13;
        float r105 = 0.0f;
    L14:
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{r102, r100.f458058f.left - r105}).setDuration(300);
        r106.addListener(new i(r100, r101, this));
        r106.addUpdateListener(new j(r101, r103, this));
        r106.start();
        this.C.add(r106);
        goto L15
    L13:
        r105 = ((p) this.I).a(r100) * (300 * (this.H.getWidth() / r104.f458124e));
    L15:
        this.A = null;
        this.f458119z.setEmpty();
        this.H.invalidate();
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public void m() {
        p();     // Catch: Throwable -> L8
        Iterator<Animator> r100 = this.C.iterator();     // Catch: Throwable -> L8
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().cancel();     // Catch: Throwable -> L8
        goto L4
    L6:
        this.C.clear();     // Catch: Throwable -> L8
        super.m();     // Catch: Throwable -> L8
        return;
    }

    public final int t() {
        Resources r100 = getContext().getResources();
        return (int) ((6.0f * WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).density) + 0.5f);
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public void c(Canvas r100) {
        int r101 = this.f458094a.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        AbsBarrage r103 = (AbsBarrage) ListProtector.get(this.f458094a, r102);
        if ((!Intrinsics.areEqual(r103, this.A)) == false) goto L9;
        if (this.B.containsKey(r103) == true) goto L9;
        r103.g(r100);
    L9:
        r102 = r102 + 1;
        goto L3
    L10:
        Iterator<Map.Entry<AbsBarrage, RectF>> r104 = this.B.entrySet().iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        Map.Entry<AbsBarrage, RectF> r105 = r104.next();
        AbsBarrage r106 = r105.getKey();
        r106.f458058f.set(r105.getValue());
        r106.g(r100);
        goto L12
    L14:
        AbsBarrage r107 = this.A;
        if (r107 == null) goto L23;
        this.D.set(r107.f458058f);
        r107.f458058f.set(this.f458119z);
        r107.g(r100);
        r107.f458058f.set(this.D);
        return;
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void d(Canvas r110) {
        if (this.f458107n == false) goto L7;
        float r100 = this.H.getWidth();
        b r101 = this.f458109p;
        float r102 = r101.f458121b;
        float r103 = r101.f458122c;
        int r111 = r101.f458120a;
        float r112 = r103;
        int r113 = 0;
    L5:
        if (r113 >= r111) goto L9;
        Lazy r104 = this.f458108o;
        KProperty[] r114 = f458106J;
        KProperty r105 = r114[0];
        r110.drawLine(0.0f, r112, r100, r112, (Paint) r104.getValue());
        float r115 = r112 + r102;
        Lazy r106 = this.f458108o;
        KProperty r107 = r114[0];
        r110.drawLine(0.0f, r115, r100, r115, (Paint) r106.getValue());
        r112 = r115 + r103;
        r113 = r113 + 1;
        goto L5
    L9:
        return;
    }

    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public boolean k(MotionEvent r100) {
        Function1<AbsBarrage, Unit> r101 = new ScrollBarrageController$onTouchEvent$1(this);
        int r102 = r100.getAction();
        if (r102 == 0) goto L31;
        if (r102 == 1) goto L22;
        if (r102 == 2) goto L10;
        if (r102 == 3) goto L10;
    L40:
        return false;
    L10:
        if (this.G == true) goto L12;
        AbsBarrage r103 = this.f458097d;
        if (r103 == null) goto L40;
        r101.invoke2(r103);
        if (this.F.contains(r100.getX(), r100.getY()) == false) goto L40;
        return r103.l(r100, this.f458104k);
    L12:
        if (r100.getAction() != 3) goto L14;
        this.G = false;
    L14:
        return false;
    L22:
        if (this.G == false) goto L25;
        this.G = false;
        return false;
    L25:
        AbsBarrage r104 = this.f458097d;
        if (r104 == null) goto L40;
        r101.invoke2(r104);
        if (this.F.contains(r100.getX(), r100.getY()) == false) goto L40;
        return r104.l(r100, this.f458104k);
    L31:
        ((ArrayList) this.f458112s.f458084a).isEmpty();
        this.G = false;
        Iterator<AbsBarrage> r105 = this.f458094a.iterator();
    L32:
        com.ss.ugc.live.barrage.util.a.C5473a r106 = (com.ss.ugc.live.barrage.util.a.C5473a) r105;
        if (r106.hasNext() == false) goto L40;
        AbsBarrage r107 = (AbsBarrage) r106.next();
        r101.invoke2(r107);
        if (this.F.contains(r100.getX(), r100.getY()) == false) goto L32;
        if (r107.l(r100, this.f458104k) == false) goto L32;
        this.f458097d = r107;
        return true;
    }

    public final float s(int r100) {
        AbsBarrage r101 = this.f458115v.get(Integer.valueOf(r100));
        if (r101 == null) goto L7;
        RectF r102 = r101.f458058f;
        if (r102 == null) goto L7;
        return r102.right;
    L7:
        return 0.0f;
    }

    public final void u(b r100) {
        if (this.H.getHeight() != r100.f458123d) goto L5;
        int[] r101 = {Math.max((r100.f458120a / 2) - 1, 0), r100.f458120a / 2};
    L6:
        Iterator<T> r102 = this.f458111r.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((com.ss.ugc.live.barrage.barrage.d) r102.next()).f458086v = r101;
        goto L8
    L10:
        return;
    L5:
        r101 = new int[]{Math.max(r100.f458120a - 2, 0), Math.max(r100.f458120a - 1, 0)};
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v38, types: [com.ss.ugc.live.barrage.barrage.AbsBarrage, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10, types: [com.ss.ugc.live.barrage.barrage.AbsBarrage] */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [com.ss.ugc.live.barrage.barrage.AbsBarrage, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.ss.ugc.live.barrage.util.a] */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v66, types: [com.ss.ugc.live.barrage.barrage.AbsBarrage, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v14, types: [com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.p] */
    /* JADX WARN: Type inference failed for: r9v23, types: [com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.p] */
    /* JADX WARN: Type inference failed for: r9v30, types: [com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.p] */
    @Override // com.ss.ugc.live.barrage.controller.AbsBarrageController
    public void j(com.ss.ugc.live.barrage.util.a r110, float r210) {
        if (this.E == false) goto L5;
        return;
    L5:
        this.f458115v.clear();
        this.f458116w.clear();
        int r100 = this.H.getWidth();
        Iterator<AbsBarrage> r101 = r110.iterator();
    L6:
        com.ss.ugc.live.barrage.util.a.C5473a r102 = (com.ss.ugc.live.barrage.util.a.C5473a) r101;
        boolean r103 = true;
        if (r102.hasNext() == false) goto L37;
        ?? r104 = (AbsBarrage) r102.next();
        if (r104.f458058f.right >= 0) goto L15;
        if ((!Intrinsics.areEqual(r104, this.A)) == false) goto L15;
        if (this.B.containsKey(r104) == true) goto L15;
        this.f458117x.remove(r104);
        r102.remove();
    L15:
        int r105 = r104.f458055c;
        if ((r104 instanceof f) == false) goto L22;
        f r106 = (f) r104;
        if (r106.c(r100) == false) goto L22;
        r106.f(r210);
        if (r104.f458058f.right < s(r105)) goto L6;
        this.f458115v.put(Integer.valueOf(r105), (AbsBarrage) r104);
    L22:
        b r107 = this.f458117x.get(r104);
        if (r107 != null) goto L26;
        r107 = this.f458109p;
    L26:
        float r108 = ((r210 / r107.f458124e) * r100) * ((p) this.I).a(r104);
        if ((r104 instanceof e) == false) goto L29;
        ((e) r104).e();
        ((p) this.I).a(r104);
    L29:
        int r109 = r107.f458120a;
        if (r105 < 0) goto L6;
        if (r109 <= r105) goto L6;
        if (r104.f458058f.right <= s(r105)) goto L36;
        this.f458115v.put(Integer.valueOf(r105), (AbsBarrage) r104);
    L36:
        r104.f458058f.offset(-r108, 0.0f);
        goto L6
    L37:
        b r111 = this.f458109p;
        int r112 = r111.f458121b;
        int r113 = r111.f458122c;
        int r114 = r111.f458120a;
        int r115 = 0;
    L38:
        if (r115 >= r114) goto L68;
        AbsBarrage r116 = this.f458115v.get(Integer.valueOf(r115));
        if ((r116 instanceof c) == false) goto L44;
        if (((c) r116).a() == false) goto L44;
        r115 = r115 + 1;
    L44:
        boolean r117 = r116 instanceof d;
        if (r117 == true) goto L47;
    L59:
        if (r117 == false) goto L64;
        if ((r116 instanceof e) == false) goto L64;
        ((e) r116).e();
    L64:
        if (s(r115) >= r100) goto L66;
        this.f458116w.add(Integer.valueOf(r115));
    L66:
        r115 = r115 + 1;
        goto L38
    L47:
        if ((r116 instanceof e) == false) goto L59;
        e r118 = (e) r116;
        r118.e();
        if (((d) r116).a() == false) goto L59;
        int[] r119 = r118.b();
        int r120 = r119.length;
        int r121 = 0;
    L51:
        if (r121 >= r120) goto L58;
        int r122 = r119[r121];
        AbsBarrage r123 = this.f458115v.get(Integer.valueOf(r122));
        if (r123 != null) goto L55;
    L56:
        this.f458115v.put(Integer.valueOf(r122), r116);
    L57:
        r121 = r121 + 1;
        goto L51
    L55:
        if (r123.f458058f.right >= r116.f458058f.right) goto L57;
    L58:
        r115 = r115 + r118.b().length;
        goto L38
    L68:
        ArrayList<Integer> r124 = this.f458116w;
        com.ss.ugc.live.barrage.controller.e r125 = this.f458118y;
        r125.f458138a = r100;
        r125.f458139b = r114;
        Unit r126 = Unit.INSTANCE;
        Collections.sort(r124, r125);
        int r127 = this.f458116w.size();
        int r128 = 0;
        float r129 = 0.0f;
    L69:
        if (r128 >= r127) goto L177;
        int r130 = ((Number) ListProtector.get(this.f458116w, r128)).intValue();
        Iterator<AbsBarrage> r131 = this.f458110q.iterator();
    L72:
        if (r131.hasNext() == false) goto L81;
        AbsBarrage r132 = r131.next();
        if ((r132 instanceof g) == false) goto L72;
        int r133 = this.f458109p.f458120a;
        if (ArraysKt.contains(((g) r132).d(), r130) == false) goto L72;
        if (r132.f458054b == false) goto L72;
        r131.remove();
        int r211 = r127;
        ?? r134 = r132;
    L125:
        if (r134 == 0) goto L168;
        float r135 = r134.f458058f.width();
        boolean r136 = r134 instanceof e;
        if (r136 == false) goto L129;
        ((e) r134).e();
        float r137 = r134.f458058f.height();
    L130:
        if (r136 == false) goto L132;
        ((e) r134).e();
        float r138 = 0.0f;
    L133:
        AbsBarrage r139 = this.f458115v.get(Integer.valueOf(r130));
        if (r139 != null) goto L136;
        float r140 = t();
    L137:
        r129 = r129 + (r140 + this.f458114u.nextInt(t()));
        if (r136 == false) goto L152;
        e r141 = (e) r134;
        r141.e();
        if (r141.b().length != 0) goto L142;
        boolean r142 = true;
    L144:
        if ((!r142) == false) goto L148;
        RectF r143 = r134.f458058f;
        float r144 = r100;
        r143.left = r144;
        r143.right = r144 + r135;
        float r145 = (r138 + r113) + (r141.b()[0] * (r113 + r112));
        r143.top = r145;
        r143.bottom = r145 + r137;
        Unit r146 = Unit.INSTANCE;
        int[] r147 = r141.b();
        int r148 = r147.length;
        int r149 = 0;
    L146:
        if (r149 >= r148) goto L156;
        this.f458115v.put(Integer.valueOf(r147[r149]), (AbsBarrage) r134);
        r149 = r149 + 1;
    L156:
        r134.f458055c = r130;
        if (r136 == false) goto L167;
        e r150 = (e) r134;
        r150.e();
        if (r150.b().length != 0) goto L161;
        boolean r151 = true;
        boolean r152 = true;
    L163:
        if ((r152 ^ r151) == false) goto L167;
        r134.f458055c = r150.b()[0];
        goto L167
    L161:
        r151 = true;
        r152 = false;
    L167:
        this.f458117x.put((AbsBarrage) r134, r111);
        r110.add(r134);
    L173:
        boolean r153 = false;
    L174:
        if (r153 == true) goto L227;
        r127 = r211;
        r128 = r128 + 1;
        r103 = true;
        goto L69
    L227:
        return;
    L148:
        RectF r154 = r134.f458058f;
        float r155 = r100;
        r154.left = r155;
        r154.right = r155 + r135;
        float r156 = (r138 + r113) + ((r113 + r112) * r130);
        r154.top = r156;
        r154.bottom = r156 + r137;
        Unit r157 = Unit.INSTANCE;
        if (r112 != this.f458109p.f458123d) goto L151;
        float r158 = r112 * 0.5f;
        r154.top = r158 + ((r158 - r137) * 0.5f);
    L151:
        this.f458115v.put(Integer.valueOf(r130), (AbsBarrage) r134);
        goto L156
    L142:
        r142 = false;
        goto L144
    L152:
        RectF r159 = r134.f458058f;
        float r160 = r100 + r129;
        r159.left = r160;
        r159.right = r160 + r135;
        float r161 = (r138 + r113) + ((r113 + r112) * r130);
        r159.top = r161;
        r159.bottom = r161 + r137;
        Unit r162 = Unit.INSTANCE;
        if (r112 != this.f458109p.f458123d) goto L155;
        float r163 = r112 * 0.5f;
        r159.top = r163 + ((r163 - r137) * 0.5f);
    L155:
        this.f458115v.put(Integer.valueOf(r130), (AbsBarrage) r134);
        goto L156
    L136:
        float r164 = r100;
        r140 = Math.max(((((((r139.f458058f.right / r164) * r111.f458124e) / ((p) this.I).a(r139)) / r111.f458124e) * r164) * ((p) this.I).a(r134)) - r164, t());
        goto L137
    L132:
        r138 = (r112 - r137) / 2;
        goto L133
    L129:
        r137 = Math.min(r134.f458058f.height(), r112);
        goto L130
    L168:
        r128 = r128;
        if (this.f458110q.isEmpty() == false) goto L173;
        if (this.f458111r.isEmpty() == false) goto L173;
        r153 = true;
        goto L174
    L81:
        if ((this.f458111r.isEmpty() ^ r103) == false) goto L98;
        com.ss.ugc.live.barrage.barrage.d r165 = (com.ss.ugc.live.barrage.barrage.d) ((LinkedList) this.f458111r).getFirst();
        if ((r165 instanceof e) == false) goto L98;
        if (ArraysKt.contains(r165.b(), r130) == false) goto L98;
        if (r165.f458054b == false) goto L98;
        int[] r166 = r165.b();
        int r167 = r166.length;
        int r168 = 0;
        boolean r169 = true;
    L89:
        if (r168 >= r167) goto L94;
        int r212 = r127;
        if ((s(r166[r168]) + 0) <= this.H.getWidth()) goto L93;
        r169 = false;
    L93:
        r168 = r168 + 1;
        r127 = r212;
        goto L89
    L94:
        r211 = r127;
        if (r169 == false) goto L97;
        ((LinkedList) this.f458111r).removeFirst();
        r134 = r165;
        goto L125
    L97:
        r134 = 0;
    L98:
        r211 = r127;
        AbsBarrage r170 = g();
    L100:
        if ((r170 instanceof g) == false) goto L105;
        int r171 = this.f458109p.f458120a;
        if (ArraysKt.contains(((g) r170).d(), r130) == true) goto L105;
        ((LinkedList) this.f458110q).add(r170);
        r170 = g();
    L105:
        if ((r170 instanceof e) == false) goto L107;
        ((LinkedList) this.f458111r).add((com.ss.ugc.live.barrage.barrage.d) r170);
        r170 = g();
        goto L105
    L107:
        if (r170 == null) goto L109;
    L124:
        r134 = r170;
        goto L125
    L109:
        if ((!this.f458111r.isEmpty()) == false) goto L124;
        com.ss.ugc.live.barrage.barrage.d r172 = (com.ss.ugc.live.barrage.barrage.d) ((LinkedList) this.f458111r).getFirst();
        if ((r172 instanceof e) == false) goto L124;
        if (ArraysKt.contains(r172.b(), r130) == false) goto L124;
        if (r172.f458054b == false) goto L124;
        int[] r173 = r172.b();
        int r174 = r173.length;
        int r175 = 0;
        boolean r176 = true;
    L117:
        if (r175 >= r174) goto L122;
        if ((s(r173[r175]) + 0) <= this.H.getWidth()) goto L121;
        r176 = false;
    L121:
        r175 = r175 + 1;
        goto L117
    L122:
        if (r176 == false) goto L124;
        r170 = (AbsBarrage) ((LinkedList) this.f458111r).removeFirst();
        goto L124
    }

    public ScrollBarrageController(View r100, b r101, p r102) {
        super(r100);
        this.H = r100;
        this.I = r102;
        this.f458108o = LazyKt.lazy(LazyThreadSafetyMode.NONE, ScrollBarrageController$danmakuLinePaint$2.INSTANCE);
        this.f458109p = r101;
        this.f458110q = new LinkedList();
        this.f458111r = new LinkedList();
        this.f458112s = new com.ss.ugc.live.barrage.barrage.b();
        this.f458113t = new com.ss.ugc.live.barrage.controller.f();
        this.f458114u = new Random();
        this.f458115v = new HashMap();
        this.f458116w = new ArrayList();
        this.f458117x = new HashMap();
        this.f458118y = new com.ss.ugc.live.barrage.controller.e(this);
        this.f458119z = new RectF();
        this.B = new HashMap();
        this.C = new HashSet();
        this.D = new RectF();
        this.F = new RectF();
    }
}
