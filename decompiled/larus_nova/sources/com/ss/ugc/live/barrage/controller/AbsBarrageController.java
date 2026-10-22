package com.ss.ugc.live.barrage.controller;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.ReplayDanmakuWidget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import com.ss.ugc.live.barrage.util.UtilsKt;
import com.ss.ugc.live.barrage.view.SurfaceBarrageLayout;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes36.dex */
public abstract class AbsBarrageController {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f458092l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f458093m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.ugc.live.barrage.util.a f458094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deque<AbsBarrage> f458095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Deque<AbsBarrage> f458096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AbsBarrage f458097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f458098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f458099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f458100g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f458101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f458102i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f458103j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View f458104k;

    public interface a {
    }

    public static final class b {
    }

    public static final class c implements com.ss.ugc.live.barrage.util.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbsBarrageController f458105a;

        @Override // com.ss.ugc.live.barrage.util.a.b
        public final void b() {
            a r100 = this.f458105a.f458103j;
        }

        public c(AbsBarrageController r100) {
            this.f458105a = r100;
        }

        @Override // com.ss.ugc.live.barrage.util.a.b
        public final void a(AbsBarrage r100) {
            a r101 = this.f458105a.f458103j;
            if (r101 == null) goto L9;
            ReplayDanmakuWidget.e r102 = (ReplayDanmakuWidget.e) r101;
            if ((r100 instanceof com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.viewholder.a) == false) goto L7;
            ((HashSet) r102.f108948a.f108927g).remove(r100);
        L7:
            r102.f108948a.f108940t.c();
            r102.f108948a.f108939s.c();
            return;
        }
    }

    static {
        f458092l = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AbsBarrageController.class), "valueAnimator", "getValueAnimator()Landroid/animation/ValueAnimator;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AbsBarrageController.class), "frameAnimator", "getFrameAnimator()Lcom/ss/ugc/live/barrage/util/FrameAnimator;"))};
    }

    public void d(Canvas r100) {
    }

    public final com.ss.ugc.live.barrage.util.d e() {
        Lazy r100 = this.f458102i;
        KProperty r101 = f458092l[1];
        return (com.ss.ugc.live.barrage.util.d) r100.getValue();
    }

    public final ValueAnimator f() {
        Lazy r100 = this.f458099f;
        KProperty r101 = f458092l[0];
        return (ValueAnimator) r100.getValue();
    }

    public abstract void j(com.ss.ugc.live.barrage.util.a r100, float r101);

    public final AbsBarrage g() {
        Iterator<AbsBarrage> r100 = this.f458096c.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        AbsBarrage r101 = r100.next();
        if (r101.f458054b == false) goto L4;
        r100.remove();
        h();
        return r101;
    L9:
        return null;
    }

    public final void h() {
    L3:
        if (((LinkedList) this.f458096c).size() > 8) goto L10;
        if (((LinkedList) this.f458095b).size() == 0) goto L18;
        AbsBarrage r100 = (AbsBarrage) ((LinkedList) this.f458095b).removeFirst();
        r100.p(AbsBarrage.State.PREPARING);
        if (r100.f458057e == true) goto L8;
        ((LinkedList) this.f458096c).add(r100);
        goto L3
    L8:
        ((LinkedList) this.f458096c).addFirst(r100);
        goto L3
    L18:
        return;
    }

    public final boolean q() {
        if (this.f458101h == false) goto L5;
    L10:
        return true;
    L5:
        if (this.f458100g == true) goto L7;
    L9:
        return false;
    L7:
        if (f458093m == false) goto L9;
        goto L9
    }

    public void b() {
        UtilsKt.a();
        a r100 = this.f458103j;
        if (r100 == null) goto L5;
        ((ReplayDanmakuWidget.e) r100).a("clearLists");
    L5:
        ((LinkedList) this.f458095b).clear();
        ((LinkedList) this.f458096c).clear();
    }

    public final void l() {
        UtilsKt.a();
        a r100 = this.f458103j;
        if (r100 == null) goto L6;
        ((ReplayDanmakuWidget.e) r100).a("pause");
    L6:
        if (q() == false) goto L16;
        if (e().f458150a == null) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == false) goto L21;
        com.ss.ugc.live.barrage.util.d r102 = e();
        r102.getClass();
        r102.f458153d = System.currentTimeMillis() - r102.f458152c;
        r102.f458154e = true;
        com.ss.ugc.live.barrage.util.d.a r103 = r102.f458150a;
        if (r103 == null) goto L22;
        Choreographer.getInstance().removeFrameCallback(r103);
        r102.f458150a = null;
        return;
    L22:
        return;
    L21:
        return;
    L10:
        r101 = false;
        goto L11
    L16:
        if (f().isPaused() == false) goto L18;
        return;
    L18:
        if (f().isRunning() == false) goto L25;
        f().pause();
        return;
    }

    public void m() {
        UtilsKt.a();
        a r100 = this.f458103j;
        if (r100 == null) goto L5;
        ((ReplayDanmakuWidget.e) r100).a("release");
    L5:
        Canvas r101 = null;
        if (q() == false) goto L10;
        com.ss.ugc.live.barrage.util.d r102 = e();
        r102.getClass();
        r102.f458153d = System.currentTimeMillis() - r102.f458152c;
        r102.f458154e = true;
        com.ss.ugc.live.barrage.util.d.a r103 = r102.f458150a;
        if (r103 == null) goto L10;
        Choreographer.getInstance().removeFrameCallback(r103);
        r102.f458150a = null;
    L10:
        f().cancel();
        ((LinkedList) this.f458095b).clear();
        ((LinkedList) this.f458096c).clear();
        this.f458094a.clear();
        this.f458104k.invalidate();
        View r104 = this.f458104k;
        if ((r104 instanceof SurfaceBarrageLayout) == false) goto L20;
        SurfaceBarrageLayout r105 = (SurfaceBarrageLayout) r104;
        SurfaceHolder r106 = r105.f458176d;
        if (r106 == null) goto L15;
        r101 = r106.lockCanvas();
    L15:
        if (r101 == null) goto L21;
        r101.drawColor(0, PorterDuff.Mode.CLEAR);
        SurfaceHolder r107 = r105.f458176d;
        if (r107 == null) goto L22;
        r107.unlockCanvasAndPost(r101);
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void n() {
        UtilsKt.a();
        a r100 = this.f458103j;
        if (r100 == null) goto L6;
        ((ReplayDanmakuWidget.e) r100).a("resume");
    L6:
        if (q() == false) goto L14;
        if (e().f458150a == null) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == true) goto L17;
        e().c();
        return;
    L17:
        return;
    L10:
        r101 = false;
        goto L11
    L14:
        if (f().isPaused() == false) goto L19;
        f().resume();
        return;
    }

    public final void o() {
        UtilsKt.a();
        if (q() == false) goto L11;
        if (e().f458150a == null) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == true) goto L13;
        e().c();
    L13:
        h();
        return;
    L7:
        r100 = false;
        goto L8
    L11:
        if (f().isRunning() == true) goto L13;
        f().start();
        goto L13
    }

    public final void p() {
        UtilsKt.a();
        a r100 = this.f458103j;
        if (r100 == null) goto L5;
        ((ReplayDanmakuWidget.e) r100).a("stop");
    L5:
        Canvas r101 = null;
        if (q() == false) goto L16;
        if (e().f458150a == null) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L18;
        com.ss.ugc.live.barrage.util.d r103 = e();
        r103.getClass();
        r103.f458153d = System.currentTimeMillis() - r103.f458152c;
        r103.f458154e = true;
        com.ss.ugc.live.barrage.util.d.a r104 = r103.f458150a;
        if (r104 == null) goto L18;
        Choreographer.getInstance().removeFrameCallback(r104);
        r103.f458150a = null;
    L18:
        this.f458104k.invalidate();
        View r105 = this.f458104k;
        if ((r105 instanceof SurfaceBarrageLayout) == false) goto L28;
        SurfaceBarrageLayout r106 = (SurfaceBarrageLayout) r105;
        SurfaceHolder r107 = r106.f458176d;
        if (r107 == null) goto L23;
        r101 = r107.lockCanvas();
    L23:
        if (r101 == null) goto L29;
        r101.drawColor(0, PorterDuff.Mode.CLEAR);
        SurfaceHolder r108 = r106.f458176d;
        if (r108 == null) goto L30;
        r108.unlockCanvasAndPost(r101);
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L10:
        r102 = false;
        goto L11
    L16:
        if (f().isRunning() == false) goto L18;
        f().cancel();
        goto L18
    }

    public AbsBarrageController(View r100) {
        this.f458104k = r100;
        this.f458094a = new com.ss.ugc.live.barrage.util.a(new c(this), new ArrayList());
        this.f458095b = new LinkedList();
        this.f458096c = new LinkedList();
        this.f458099f = LazyKt.lazy(LazyThreadSafetyMode.NONE, new AbsBarrageController$valueAnimator$2(this));
        this.f458100g = true;
        this.f458102i = LazyKt.lazy(new AbsBarrageController$frameAnimator$2(this));
    }

    public void c(Canvas r100) {
        int r101 = this.f458094a.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((AbsBarrage) ListProtector.get(this.f458094a, r102)).g(r100);
        r102 = r102 + 1;
        goto L3
    }

    public void i(AbsBarrage r100) {
        r100.p(AbsBarrage.State.ADDED);
        o();
    }

    public boolean k(MotionEvent r100) {
        int r101 = r100.getAction();
        if (r101 == 0) goto L30;
        if (r101 != 1) goto L6;
        AbsBarrage r102 = this.f458097d;
        if (r102 == null) goto L39;
        RectF r103 = r102.f458058f;
        if (r103 == null) goto L39;
        if (r103.contains(r100.getX(), r100.getY()) != true) goto L39;
        AbsBarrage r104 = this.f458097d;
        if (r104 != null) goto L29;
        return false;
    L29:
        return r104.l(r100, this.f458104k);
    L39:
        return false;
    L6:
        if (r101 != 2) goto L8;
    L10:
        AbsBarrage r105 = this.f458097d;
        if (r105 == null) goto L39;
        RectF r106 = r105.f458058f;
        if (r106 == null) goto L39;
        if (r106.contains(r100.getX(), r100.getY()) != true) goto L39;
        AbsBarrage r107 = this.f458097d;
        if (r107 != null) goto L19;
        return false;
    L19:
        return r107.l(r100, this.f458104k);
    L8:
        if (r101 == 3) goto L10;
    L30:
        Iterator<AbsBarrage> r108 = this.f458094a.iterator();
    L31:
        com.ss.ugc.live.barrage.util.a.C5473a r109 = (com.ss.ugc.live.barrage.util.a.C5473a) r108;
        if (r109.hasNext() == false) goto L39;
        AbsBarrage r110 = (AbsBarrage) r109.next();
        if (r110.f458058f.contains(r100.getX(), r100.getY()) == false) goto L31;
        if (r110.l(r100, this.f458104k) == false) goto L31;
        this.f458097d = r110;
        return true;
    }

    public final void a(AbsBarrage r100, boolean r101) {
        UtilsKt.a();
        if (r101 == false) goto L5;
        ((LinkedList) this.f458095b).addFirst(r100);
    L6:
        i(r100);
        return;
    L5:
        ((LinkedList) this.f458095b).add(r100);
        goto L6
    }
}
