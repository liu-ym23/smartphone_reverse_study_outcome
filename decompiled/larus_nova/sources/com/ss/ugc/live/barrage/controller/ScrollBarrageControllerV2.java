package com.ss.ugc.live.barrage.controller;

import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ScrollBarrageControllerV2 extends ScrollBarrageController {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/ugc/live/barrage/controller/ScrollBarrageControllerV2$BarrageHeat;", "", "LOW", "MEDIUM", "HIGH", EffectConstants.NORMAL, "HIGH_MAX", "barrage_release"}, k = 1, mv = {1, 4, 0})
    public static final enum BarrageHeat extends Enum<BarrageHeat> {
        public static final BarrageHeat HIGH = null;
        public static final BarrageHeat HIGH_MAX = null;
        public static final BarrageHeat LOW = null;
        public static final BarrageHeat MEDIUM = null;
        public static final BarrageHeat NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BarrageHeat[] f458131a = null;

        static {
            BarrageHeat r100 = new BarrageHeat("LOW", 0);
            LOW = r100;
            BarrageHeat r101 = new BarrageHeat("MEDIUM", 1);
            MEDIUM = r101;
            BarrageHeat r102 = new BarrageHeat("HIGH", 2);
            HIGH = r102;
            BarrageHeat r103 = new BarrageHeat(EffectConstants.NORMAL, 3);
            NORMAL = r103;
            BarrageHeat r104 = new BarrageHeat("HIGH_MAX", 4);
            HIGH_MAX = r104;
            f458131a = new BarrageHeat[]{r100, r101, r102, r103, r104};
        }

        public static BarrageHeat valueOf(String r100) {
            return (BarrageHeat) r27.a.a(BarrageHeat.class, r100);
        }

        public static BarrageHeat[] values() {
            return (BarrageHeat[]) f458131a.clone();
        }

        public BarrageHeat(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController, com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void b() {
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

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController, com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void m() {
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

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController, com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void c(Canvas r100) {
        int r101 = this.f458094a.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L10;
        AbsBarrage r103 = (AbsBarrage) ListProtector.get(this.f458094a, r102);
        if ((!Intrinsics.areEqual(r103, null)) == false) goto L9;
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
    }

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController, com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final boolean k(MotionEvent r100) {
        Function1<AbsBarrage, Unit> r101 = new ScrollBarrageControllerV2$onTouchEvent$1(this);
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

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController, com.ss.ugc.live.barrage.controller.AbsBarrageController
    public final void j(com.ss.ugc.live.barrage.util.a r100, float r101) {
        if (this.E == false) goto L6;
        return;
    L6:
        throw null;
    }
}
