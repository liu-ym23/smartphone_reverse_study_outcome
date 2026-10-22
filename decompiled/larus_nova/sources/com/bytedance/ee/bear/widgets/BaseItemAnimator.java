package com.bytedance.ee.bear.widgets;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public abstract class BaseItemAnimator extends SimpleItemAnimator {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static TimeInterpolator f239995l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<RecyclerView.ViewHolder> f239996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<RecyclerView.ViewHolder> f239997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<e> f239998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<d> f239999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<ArrayList<RecyclerView.ViewHolder>> f240000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<ArrayList<e>> f240001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<ArrayList<d>> f240002g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<RecyclerView.ViewHolder> f240003h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<RecyclerView.ViewHolder> f240004i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<RecyclerView.ViewHolder> f240005j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<RecyclerView.ViewHolder> f240006k;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f240007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseItemAnimator f240008b;

        public final void a() {
            Iterator r100 = this.f240007a.iterator();
        L4:
            if (r100.hasNext() == false) goto L11;
            e r101 = (e) r100.next();
            BaseItemAnimator r102 = this.f240008b;
            RecyclerView.ViewHolder r103 = r101.f240019a;
            int r104 = r101.f240020b;
            int r105 = r101.f240021c;
            int r106 = r101.f240022d;
            int r107 = r101.f240023e;
            r102.getClass();
            View r108 = r103.itemView;
            int r109 = r106 - r104;
            int r110 = r107 - r105;
            if (r109 == 0) goto L8;
            r108.animate().translationX(0.0f);
        L8:
            if (r110 == 0) goto L10;
            r108.animate().translationY(0.0f);
        L10:
            ViewPropertyAnimator r111 = r108.animate();
            r102.f240004i.add(r103);
            r111.setDuration(r102.getMoveDuration()).setListener(new com.bytedance.ee.bear.widgets.e(r102, r103, r109, r108, r110, r111)).start();
            goto L4
        L11:
            this.f240007a.clear();
            this.f240008b.f240001f.remove(this.f240007a);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(BaseItemAnimator r100, ArrayList r101) {
            this.f240008b = r100;
            this.f240007a = r101;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f240009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseItemAnimator f240010b;

        public final void a() {
            Iterator r100 = this.f240009a.iterator();
        L4:
            if (r100.hasNext() == false) goto L16;
            d r101 = (d) r100.next();
            BaseItemAnimator r102 = this.f240010b;
            r102.getClass();
            RecyclerView.ViewHolder r103 = r101.f240013a;
            View r104 = null;
            if (r103 != null) goto L8;
            View r105 = null;
        L9:
            RecyclerView.ViewHolder r106 = r101.f240014b;
            if (r106 == null) goto L12;
            r104 = r106.itemView;
        L12:
            if (r105 == null) goto L14;
            ViewPropertyAnimator r107 = r105.animate().setDuration(r102.getChangeDuration());
            r102.f240006k.add(r101.f240013a);
            r107.translationX(r101.f240017e - r101.f240015c);
            r107.translationY(r101.f240018f - r101.f240016d);
            r107.setListener(new com.bytedance.ee.bear.widgets.f(r102, r101, r107, r105)).start();
        L14:
            if (r104 == null) goto L4;
            ViewPropertyAnimator r108 = r104.animate();
            r102.f240006k.add(r101.f240014b);
            r108.translationX(0.0f).translationY(0.0f).setDuration(r102.getChangeDuration()).setListener(new g(r102, r101, r108, r104)).start();
            goto L4
        L8:
            r105 = r103.itemView;
            goto L9
        L16:
            this.f240009a.clear();
            this.f240010b.f240002g.remove(this.f240009a);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(BaseItemAnimator r100, ArrayList r101) {
            this.f240010b = r100;
            this.f240009a = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f240011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseItemAnimator f240012b;

        public final void a() {
            Iterator r100 = this.f240011a.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            RecyclerView.ViewHolder r101 = (RecyclerView.ViewHolder) r100.next();
            BaseItemAnimator r102 = this.f240012b;
            ViewPropertyAnimatorCompat r103 = r102.a(r101);
            r102.f240003h.add(r101);
            r103.setDuration(r102.getAddDuration()).setListener(new com.bytedance.ee.bear.widgets.d(r102, r101, r103)).start();
            goto L4
        L6:
            this.f240011a.clear();
            this.f240012b.f240000e.remove(this.f240011a);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(BaseItemAnimator r100, ArrayList r101) {
            this.f240012b = r100;
            this.f240011a = r101;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.ViewHolder f240013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.ViewHolder f240014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f240015c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f240016d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f240017e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f240018f;

        public final String toString() {
            return "ChangeInfo{oldHolder=" + this.f240013a + ", newHolder=" + this.f240014b + ", fromX=" + this.f240015c + ", fromY=" + this.f240016d + ", toX=" + this.f240017e + ", toY=" + this.f240018f + '}';
        }

        public d(RecyclerView.ViewHolder r100, RecyclerView.ViewHolder r101, int r102, int r103, int r104, int r105) {
            this.f240013a = r100;
            this.f240014b = r101;
            this.f240015c = r102;
            this.f240016d = r103;
            this.f240017e = r104;
            this.f240018f = r105;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView.ViewHolder f240019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f240020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f240021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f240022d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f240023e;

        public e(RecyclerView.ViewHolder r100, int r101, int r102, int r103, int r104) {
            this.f240019a = r100;
            this.f240020b = r101;
            this.f240021c = r102;
            this.f240022d = r103;
            this.f240023e = r104;
        }
    }

    public static class f implements ViewPropertyAnimatorListener {
        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View r100) {
        }

        public f() {
        }
    }

    public abstract ViewPropertyAnimatorCompat a(RecyclerView.ViewHolder r100);

    public abstract void b(RecyclerView.ViewHolder r100);

    public abstract void c(RecyclerView.ViewHolder r100);

    public abstract ViewPropertyAnimatorCompat e(RecyclerView.ViewHolder r100, int r101);

    public abstract void f(RecyclerView.ViewHolder r100);

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void endAnimations() {
        int r100 = this.f239998c.size();
    L3:
        r100 = r100 - 1;
        if (r100 < 0) goto L6;
        e r101 = (e) ListProtector.get(this.f239998c, r100);
        View r102 = r101.f240019a.itemView;
        r102.setTranslationY(0.0f);
        r102.setTranslationX(0.0f);
        dispatchMoveFinished(r101.f240019a);
        ListProtector.remove(this.f239998c, r100);
        goto L3
    L6:
        int r103 = this.f239996a.size();
    L7:
        r103 = r103 - 1;
        if (r103 < 0) goto L10;
        dispatchRemoveFinished((RecyclerView.ViewHolder) ListProtector.get(this.f239996a, r103));
        ListProtector.remove(this.f239996a, r103);
        goto L7
    L10:
        int r104 = this.f239997b.size();
    L11:
        r104 = r104 - 1;
        if (r104 < 0) goto L14;
        RecyclerView.ViewHolder r105 = (RecyclerView.ViewHolder) ListProtector.get(this.f239997b, r104);
        b(r105);
        dispatchAddFinished(r105);
        ListProtector.remove(this.f239997b, r104);
        goto L11
    L14:
        int r106 = this.f239999d.size();
    L15:
        r106 = r106 - 1;
        if (r106 < 0) goto L24;
        d r107 = (d) ListProtector.get(this.f239999d, r106);
        RecyclerView.ViewHolder r108 = r107.f240013a;
        if (r108 == null) goto L20;
        d(r107, r108);
    L20:
        RecyclerView.ViewHolder r109 = r107.f240014b;
        if (r109 == null) goto L15;
        d(r107, r109);
        goto L15
    L24:
        this.f239999d.clear();
        if (isRunning() == true) goto L27;
        return;
    L27:
        int r110 = this.f240001f.size();
    L28:
        r110 = r110 - 1;
        if (r110 < 0) goto L38;
        ArrayList r111 = (ArrayList) ListProtector.get(this.f240001f, r110);
        int r112 = r111.size();
    L31:
        r112 = r112 - 1;
        if (r112 < 0) goto L28;
        e r113 = (e) ListProtector.get(r111, r112);
        View r114 = r113.f240019a.itemView;
        r114.setTranslationY(0.0f);
        r114.setTranslationX(0.0f);
        dispatchMoveFinished(r113.f240019a);
        ListProtector.remove(r111, r112);
        if (r111.isEmpty() == false) goto L31;
        this.f240001f.remove(r111);
        goto L31
    L38:
        int r115 = this.f240000e.size();
    L39:
        r115 = r115 - 1;
        if (r115 < 0) goto L49;
        ArrayList r116 = (ArrayList) ListProtector.get(this.f240000e, r115);
        int r117 = r116.size();
    L42:
        r117 = r117 - 1;
        if (r117 < 0) goto L39;
        RecyclerView.ViewHolder r118 = (RecyclerView.ViewHolder) ListProtector.get(r116, r117);
        View r119 = r118.itemView;
        b(r118);
        dispatchAddFinished(r118);
        ListProtector.remove(r116, r117);
        if (r116.isEmpty() == false) goto L42;
        this.f240000e.remove(r116);
        goto L42
    L49:
        int r120 = this.f240002g.size();
    L50:
        r120 = r120 - 1;
        if (r120 < 0) goto L66;
        ArrayList r121 = (ArrayList) ListProtector.get(this.f240002g, r120);
        int r122 = r121.size();
    L53:
        r122 = r122 - 1;
        if (r122 < 0) goto L50;
        d r123 = (d) ListProtector.get(r121, r122);
        RecyclerView.ViewHolder r124 = r123.f240013a;
        if (r124 == null) goto L58;
        d(r123, r124);
    L58:
        RecyclerView.ViewHolder r125 = r123.f240014b;
        if (r125 == null) goto L62;
        d(r123, r125);
    L62:
        if (r121.isEmpty() == false) goto L53;
        this.f240002g.remove(r121);
        goto L53
    L66:
        cancelAll(this.f240005j);
        cancelAll(this.f240004i);
        cancelAll(this.f240003h);
        cancelAll(this.f240006k);
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean isRunning() {
        if (this.f239997b.isEmpty() == true) goto L5;
    L26:
        return true;
    L5:
        if (this.f239999d.isEmpty() == false) goto L26;
        if (this.f239998c.isEmpty() == false) goto L26;
        if (this.f239996a.isEmpty() == false) goto L26;
        if (this.f240004i.isEmpty() == false) goto L26;
        if (this.f240005j.isEmpty() == false) goto L26;
        if (this.f240003h.isEmpty() == false) goto L26;
        if (this.f240006k.isEmpty() == false) goto L26;
        if (this.f240001f.isEmpty() == false) goto L26;
        if (this.f240000e.isEmpty() == false) goto L26;
        if (this.f240002g.isEmpty() == false) goto L26;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void runPendingAnimations() {
        boolean r100 = !this.f239996a.isEmpty();
        boolean r101 = !this.f239998c.isEmpty();
        boolean r102 = !this.f239999d.isEmpty();
        boolean r103 = !this.f239997b.isEmpty();
        if (r100 == true) goto L9;
        if (r101 == true) goto L9;
        if (r103 == true) goto L9;
        if (r102 == true) goto L9;
        return;
    L9:
        if (r101 == false) goto L11;
        ArrayList<e> r104 = this.f239998c;
        e r105 = (e) ListProtector.get(r104, r104.size() - 1);
        int r106 = r105.f240023e - r105.f240021c;
    L12:
        Iterator<RecyclerView.ViewHolder> r107 = this.f239996a.iterator();
    L14:
        if (r107.hasNext() == false) goto L16;
        RecyclerView.ViewHolder r108 = r107.next();
        ViewPropertyAnimatorCompat r109 = e(r108, r106);
        this.f240005j.add(r108);
        r109.setDuration(getRemoveDuration()).setListener(new com.bytedance.ee.bear.widgets.c(this, r108, r109)).start();
        goto L14
    L16:
        this.f239996a.clear();
        if (r101 == false) goto L22;
        ArrayList<e> r110 = new ArrayList();
        r110.addAll(this.f239998c);
        this.f240001f.add(r110);
        this.f239998c.clear();
        a r111 = new a(this, r110);
        if (r100 == false) goto L21;
        ViewCompat.postOnAnimationDelayed(((e) ListProtector.get(r110, 0)).f240019a.itemView, r111, 0);
        goto L22
    L21:
        r111.run();
    L22:
        if (r102 == false) goto L27;
        ArrayList<d> r112 = new ArrayList();
        r112.addAll(this.f239999d);
        this.f240002g.add(r112);
        this.f239999d.clear();
        b r113 = new b(this, r112);
        if (r100 == false) goto L26;
        ViewCompat.postOnAnimationDelayed(((d) ListProtector.get(r112, 0)).f240013a.itemView, r113, 0);
        goto L27
    L26:
        r113.run();
    L27:
        if (r103 == false) goto L37;
        ArrayList<RecyclerView.ViewHolder> r114 = new ArrayList();
        r114.addAll(this.f239997b);
        this.f240000e.add(r114);
        this.f239997b.clear();
        c r115 = new c(this, r114);
        if (r100 == true) goto L34;
        if (r101 == true) goto L34;
        if (r102 == true) goto L34;
        r115.run();
        return;
    L34:
        ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder) ListProtector.get(r114, 0)).itemView, r115, 0);
        return;
    L37:
        return;
    L11:
        r106 = 0;
        goto L12
    }

    public BaseItemAnimator() {
        this.f239996a = new ArrayList();
        this.f239997b = new ArrayList();
        this.f239998c = new ArrayList();
        this.f239999d = new ArrayList();
        this.f240000e = new ArrayList();
        this.f240001f = new ArrayList();
        this.f240002g = new ArrayList();
        this.f240003h = new ArrayList();
        this.f240004i = new ArrayList();
        this.f240005j = new ArrayList();
        this.f240006k = new ArrayList();
    }

    public final void dispatchFinishedWhenDone() {
        if (isRunning() == true) goto L6;
        dispatchAnimationsFinished();
        return;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateAdd(RecyclerView.ViewHolder r100) {
        resetAnimation(r100);
        c(r100);
        this.f239997b.add(r100);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateRemove(RecyclerView.ViewHolder r100) {
        resetAnimation(r100);
        this.f239996a.add(r100);
        return true;
    }

    public final void cancelAll(List<RecyclerView.ViewHolder> r100) {
        int r101 = r100.size() - 1;
    L3:
        if (r101 < 0) goto L5;
        ((RecyclerView.ViewHolder) ListProtector.get(r100, r101)).itemView.animate().cancel();
        r101 = r101 - 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void endAnimation(RecyclerView.ViewHolder r100) {
        View r101 = r100.itemView;
        r101.animate().cancel();
        int r102 = this.f239998c.size();
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L9;
        if (((e) ListProtector.get(this.f239998c, r102)).f240019a != r100) goto L3;
        r101.setTranslationY(0.0f);
        r101.setTranslationX(0.0f);
        dispatchMoveFinished(r100);
        ListProtector.remove(this.f239998c, r102);
        goto L3
    L9:
        endChangeAnimation(this.f239999d, r100);
        if (this.f239996a.remove(r100) == false) goto L13;
        f(r100);
        dispatchRemoveFinished(r100);
    L13:
        if (this.f239997b.remove(r100) == false) goto L15;
        b(r100);
        dispatchAddFinished(r100);
    L15:
        int r103 = this.f240002g.size() - 1;
    L16:
        if (r103 < 0) goto L21;
        ArrayList r104 = (ArrayList) ListProtector.get(this.f240002g, r103);
        endChangeAnimation(r104, r100);
        if (r104.isEmpty() == false) goto L20;
        ListProtector.remove(this.f240002g, r103);
    L20:
        r103 = r103 - 1;
        goto L16
    L21:
        int r105 = this.f240001f.size() - 1;
    L22:
        if (r105 < 0) goto L32;
        ArrayList r106 = (ArrayList) ListProtector.get(this.f240001f, r105);
        int r107 = r106.size() - 1;
    L24:
        if (r107 < 0) goto L31;
        if (((e) ListProtector.get(r106, r107)).f240019a == r100) goto L27;
        r107 = r107 - 1;
        goto L24
    L27:
        r101.setTranslationY(0.0f);
        r101.setTranslationX(0.0f);
        dispatchMoveFinished(r100);
        ListProtector.remove(r106, r107);
        if (r106.isEmpty() == false) goto L31;
        ListProtector.remove(this.f240001f, r105);
    L31:
        r105 = r105 - 1;
        goto L22
    L32:
        int r108 = this.f240000e.size() - 1;
    L33:
        if (r108 < 0) goto L40;
        ArrayList r109 = (ArrayList) ListProtector.get(this.f240000e, r108);
        if (r109.remove(r100) == false) goto L39;
        b(r100);
        dispatchAddFinished(r100);
        if (r109.isEmpty() == false) goto L39;
        ListProtector.remove(this.f240000e, r108);
    L39:
        r108 = r108 - 1;
        goto L33
    L40:
        this.f240005j.remove(r100);
        this.f240003h.remove(r100);
        this.f240006k.remove(r100);
        this.f240004i.remove(r100);
        dispatchFinishedWhenDone();
    }

    public final void resetAnimation(RecyclerView.ViewHolder r100) {
        if (f239995l != null) goto L5;
        f239995l = new ValueAnimator().getInterpolator();
    L5:
        r100.itemView.animate().setInterpolator(f239995l);
        endAnimation(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder r100, List<Object> r101) {
        if (r101.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (super.canReuseUpdatedViewHolder(r100, r101) == true) goto L8;
        return false;
    }

    public final boolean d(d r100, RecyclerView.ViewHolder r101) {
        boolean r102 = false;
        if (r100.f240014b != r101) goto L6;
        r100.f240014b = null;
    L8:
        r101.itemView.setTranslationX(0.0f);
        r101.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(r101, r102);
        return true;
    L6:
        if (r100.f240013a != r101) goto L10;
        r100.f240013a = null;
        r102 = true;
        goto L8
    L10:
        return false;
    }

    public final void endChangeAnimation(List<d> r100, RecyclerView.ViewHolder r101) {
        int r102 = r100.size();
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L12;
        d r103 = (d) ListProtector.get(r100, r102);
        if (d(r103, r101) == false) goto L3;
        if (r103.f240013a != null) goto L3;
        if (r103.f240014b != null) goto L3;
        r100.remove(r103);
        goto L3
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateMove(RecyclerView.ViewHolder r100, int r110, int r111, int r112, int r113) {
        View r101 = r100.itemView;
        int r102 = r110 + ((int) r101.getTranslationX());
        int r103 = r111 + ((int) r100.itemView.getTranslationY());
        resetAnimation(r100);
        int r114 = r112 - r102;
        int r115 = r113 - r103;
        if (r114 != 0) goto L7;
        if (r115 != 0) goto L7;
        dispatchMoveFinished(r100);
        return false;
    L7:
        if (r114 == 0) goto L9;
        r101.setTranslationX(-r114);
    L9:
        if (r115 == 0) goto L11;
        r101.setTranslationY(-r115);
    L11:
        this.f239998c.add(new e(r100, r102, r103, r112, r113));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateChange(RecyclerView.ViewHolder r110, RecyclerView.ViewHolder r111, int r112, int r113, int r114, int r115) {
        if (r110 == r111) goto L4;
        float r100 = r110.itemView.getTranslationX();
        float r101 = r110.itemView.getTranslationY();
        resetAnimation(r110);
        int r102 = (int) ((r114 - r112) - r100);
        int r103 = (int) ((r115 - r113) - r101);
        r110.itemView.setTranslationX(r100);
        r110.itemView.setTranslationY(r101);
        if (r111 == null) goto L8;
        resetAnimation(r111);
        r111.itemView.setTranslationX(-r102);
        r111.itemView.setTranslationY(-r103);
    L8:
        this.f239999d.add(new d(r110, r111, r112, r113, r114, r115));
        return true;
    L4:
        return animateMove(r110, r112, r113, r114, r115);
    }
}
