package com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class ViewGroupItemAnimator implements com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f251981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f251982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f251983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ba6.g f251984d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f251985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f251986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AnimatorSet f251987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f251988d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f251989e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f251985a, r101.f251985a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f251986b, r101.f251986b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f251985a.hashCode() * 31) + this.f251986b.hashCode();
        }

        public final String toString() {
            return "AddPendingInfo(nodeKey=" + this.f251985a + ')';
        }

        public a(String r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, "nodeKey");
            Intrinsics.checkNotNullParameter(r101, "view");
            this.f251985a = r100;
            this.f251986b = r101;
            this.f251989e = -2;
        }
    }

    public interface b {
        void a();

        void b();

        void onAnimationRepeat();

        void onAnimationStart();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f251990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f251991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Unit> f251992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AnimatorSet f251993d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f251990a, r101.f251990a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f251991b, r101.f251991b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f251992c, r101.f251992c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f251990a.hashCode() * 31) + this.f251991b.hashCode()) * 31) + this.f251992c.hashCode();
        }

        public final String toString() {
            return "RemovePendingInfo(nodeKey=" + this.f251990a + ')';
        }

        public c(String r100, View r101, Function0<Unit> r102) {
            Intrinsics.checkNotNullParameter(r100, "nodeKey");
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, "onEnd");
            this.f251990a = r100;
            this.f251991b = r101;
            this.f251992c = r102;
        }
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.a
    public final void c() {
        Iterator r100 = ((ArrayList) this.f251982b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        final a r101 = (a) r100.next();
        String r102 = YaTaLog.f251436a;
        YaTaLog.c("ViewGroupItemAnimator", new ViewGroupItemAnimator$startAddAnim$1(r101));
        View r103 = r101.f251986b;
        r103.setAlpha(0.0f);
        ValueAnimator r104 = f(r103, 0, r101.f251988d, new f(r103, r101));
        ValueAnimator r105 = e(r103, 0.0f, 1.0f, new e(r103));
        long r106 = this.f251981a;
        AnimatorSet r107 = new AnimatorSet();
        r107.setDuration(r106);
        r107.playTogether(ArraysKt.toList(new Animator[]{r104, r105}));
        r107.start();
        r101.f251987c = r107;
        goto L4
    L6:
        Iterator r108 = ((ArrayList) this.f251983c).iterator();
    L8:
        if (r108.hasNext() == false) goto L10;
        final c r109 = (c) r108.next();
        String r110 = YaTaLog.f251436a;
        YaTaLog.c("ViewGroupItemAnimator", new ViewGroupItemAnimator$startRemoveAnim$1(r109));
        View r111 = r109.f251991b;
        ValueAnimator r112 = f(r111, r111.getHeight(), 0, new h(r109));
        ValueAnimator r113 = e(r111, 1.0f, 0.0f, new g(r111));
        long r114 = this.f251981a;
        Animator[] r115 = {r112, r113};
        AnimatorSet r116 = new AnimatorSet();
        r116.setDuration(r114);
        r116.playTogether(ArraysKt.toList(r115));
        r116.start();
        r109.f251993d = r116;
        goto L8
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.a
    public final void reset() {
        String r100 = YaTaLog.f251436a;
        YaTaLog.c("ViewGroupItemAnimator", AnonymousClass1.INSTANCE);
        Iterator r101 = ((ArrayList) this.f251982b).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        AnimatorSet r102 = ((a) r101.next()).f251987c;
        if (r102 == null) goto L4;
        r102.cancel();
        goto L4
    L8:
        ((ArrayList) this.f251982b).clear();
        Iterator r103 = ((ArrayList) this.f251983c).iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        AnimatorSet r104 = ((c) r103.next()).f251993d;
        if (r104 == null) goto L10;
        r104.cancel();
        goto L10
    L14:
        ((ArrayList) this.f251983c).clear();
    }

    public ViewGroupItemAnimator(com.bytedance.kmp.ec.yata.view.c r100) {
        Intrinsics.checkNotNullParameter(r100, "viewWrapper");
        this.f251981a = 250;
        this.f251982b = new ArrayList();
        this.f251983c = new ArrayList();
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.a
    public final void b(ba6.g r100) {
        Intrinsics.checkNotNullParameter(r100, "storeData");
        this.f251984d = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.a
    public final boolean d(ba6.d r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "node");
        final String r102 = r100.d();
        ba6.g r103 = this.f251984d;
        String r104 = null;
        if (r103 == null) goto L5;
        aa6.a r105 = r103.getStrategy();
    L6:
        ba6.g r106 = this.f251984d;
        if (r106 == null) goto L10;
        r104 = r106.getTriggerType();
    L10:
        if (r100.k(r105, r104) == false) goto L13;
        r101.setAlpha(0.0f);
        final a r107 = new a(r102, r101);
        r101.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r107.f251988d = r101.getMeasuredHeight();
        r107.f251989e = r101.getLayoutParams().height;
        ((ArrayList) this.f251982b).add(r107);
        String r108 = YaTaLog.f251436a;
        YaTaLog.c("ViewGroupItemAnimator", new ViewGroupItemAnimator$animateAdd$1(r102, r107));
        return true;
    L13:
        String r109 = YaTaLog.f251436a;
        YaTaLog.c("ViewGroupItemAnimator", new ViewGroupItemAnimator$animateAdd$2(r102));
        return false;
    L5:
        r105 = null;
        goto L6
    }

    public static ValueAnimator e(final View r100, float r101, float r102, final b r103) {
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{r101, r102});
        r104.setInterpolator(new LinearInterpolator());
        r104.addUpdateListener(new com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.b(r100, r103));
        r104.addListener(new d(r103));
        return r104;
    }

    public static ValueAnimator f(final View r100, int r101, int r102, final b r103) {
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{r101, r102});
        r104.setInterpolator(new LinearInterpolator());
        r104.addUpdateListener(new com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.c(r100, r103));
        r104.addListener(new d(r103));
        return r104;
    }

    @Override // com.bytedance.kmp.ec.yata.view.render.controller.viewgroup.anim.a
    public final boolean a(final String r100, ba6.d r101, View r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r103, "onEnd");
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r101 != null) goto L7;
        return false;
    L7:
        ba6.g r104 = this.f251984d;
        String r105 = null;
        if (r104 == null) goto L10;
        aa6.a r106 = r104.getStrategy();
    L11:
        ba6.g r107 = this.f251984d;
        if (r107 == null) goto L15;
        r105 = r107.getTriggerType();
    L15:
        if (r101.l(r106, r105) == false) goto L18;
        final c r108 = new c(r100, r102, r103);
        ((ArrayList) this.f251983c).add(r108);
        String r109 = YaTaLog.f251436a;
        YaTaLog.c("ViewGroupItemAnimator", new ViewGroupItemAnimator$animateRemove$1(r100, r108));
        return true;
    L18:
        String r110 = YaTaLog.f251436a;
        YaTaLog.c("ViewGroupItemAnimator", new ViewGroupItemAnimator$animateRemove$2(r100));
        return false;
    L10:
        r106 = null;
        goto L11
    }
}
