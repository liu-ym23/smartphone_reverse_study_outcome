package com.h6ah4i.android.widget.advrecyclerview.animator.impl;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xv7.d;

/* JADX INFO: loaded from: classes23.dex */
public abstract class BaseItemAnimationManager<T extends d> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static TimeInterpolator f276022e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseItemAnimator f276023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<T> f276024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<List<T>> f276025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<RecyclerView.ViewHolder> f276026d;

    public static class BaseAnimatorListener implements ViewPropertyAnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BaseItemAnimationManager f276027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d f276028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public RecyclerView.ViewHolder f276029c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ViewPropertyAnimatorCompat f276030d;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationCancel(View r100) {
            this.f276027a.k(this.f276028b, this.f276029c);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd(View r100) {
            BaseItemAnimationManager r101 = this.f276027a;
            d r102 = this.f276028b;
            RecyclerView.ViewHolder r103 = this.f276029c;
            this.f276030d.setListener(null);
            this.f276027a = null;
            this.f276028b = null;
            this.f276029c = null;
            this.f276030d = null;
            r101.m(r102, r103);
            r101.c(r102, r103);
            r102.a(r103);
            ((ArrayList) r101.f276026d).remove(r103);
            r101.f276023a.b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationStart(View r100) {
            this.f276027a.d(this.f276028b, this.f276029c);
        }

        public BaseAnimatorListener(BaseItemAnimationManager r100, d r101, RecyclerView.ViewHolder r102, ViewPropertyAnimatorCompat r103) {
            this.f276027a = r100;
            this.f276028b = r101;
            this.f276029c = r102;
            this.f276030d = r103;
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f276031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseItemAnimationManager f276032b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            Iterator r100 = this.f276031a.iterator();     // Catch: Throwable -> L8
        L4:
            if (r100.hasNext() == false) goto L6;
            d r101 = (d) r100.next();     // Catch: Throwable -> L8
            this.f276032b.n(r101);     // Catch: Throwable -> L8
            goto L4
        L6:
            this.f276031a.clear();     // Catch: Throwable -> L8
            List<List<T>> r102 = this.f276032b.f276025c;     // Catch: Throwable -> L8
            ArrayList r103 = (ArrayList) r102;     // Catch: Throwable -> L8
            r103.remove(this.f276031a);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }

        public a(BaseItemAnimationManager r100, List r101) {
            this.f276032b = r100;
            this.f276031a = r101;
        }
    }

    public abstract void c(T r100, RecyclerView.ViewHolder r101);

    public abstract void d(T r100, RecyclerView.ViewHolder r101);

    public abstract boolean f(T r100, RecyclerView.ViewHolder r101);

    public abstract void k(T r100, RecyclerView.ViewHolder r101);

    public abstract void l(T r100, RecyclerView.ViewHolder r101);

    public abstract void m(T r100, RecyclerView.ViewHolder r101);

    public abstract void n(T r100);

    public final void a() {
        ArrayList r100 = (ArrayList) this.f276026d;
        int r101 = r100.size() - 1;
    L3:
        if (r101 < 0) goto L5;
        ViewCompat.animate(((RecyclerView.ViewHolder) ListProtector.get(r100, r101)).itemView).cancel();
        r101 = r101 - 1;
        goto L3
    }

    public final boolean b() {
        this.f276023a.a();
        return false;
    }

    public final boolean i() {
        return !((ArrayList) this.f276024b).isEmpty();
    }

    public final boolean j() {
        if (((ArrayList) this.f276024b).isEmpty() == true) goto L5;
    L10:
        return true;
    L5:
        if (((ArrayList) this.f276026d).isEmpty() == false) goto L10;
        if (((ArrayList) this.f276025c).isEmpty() == false) goto L10;
        return false;
    }

    public BaseItemAnimationManager(BaseItemAnimator r100) {
        this.f276023a = r100;
        this.f276024b = new ArrayList();
        this.f276026d = new ArrayList();
        this.f276025c = new ArrayList();
    }

    public final void e(RecyclerView.ViewHolder r100) {
        int r101 = ((ArrayList) this.f276025c).size() - 1;
    L3:
        if (r101 < 0) goto L17;
        List r102 = (List) ListProtector.get(this.f276025c, r101);
        int r103 = r102.size() - 1;
    L5:
        if (r103 < 0) goto L11;
        if (f((d) ListProtector.get(r102, r103), r100) == false) goto L10;
        if (r100 == null) goto L10;
        ListProtector.remove(r102, r103);
    L10:
        r103 = r103 - 1;
        goto L5
    L11:
        if (r100 != null) goto L14;
        r102.clear();
    L14:
        if (r102.isEmpty() == false) goto L16;
        ((ArrayList) this.f276025c).remove(r102);
    L16:
        r101 = r101 - 1;
        goto L3
    }

    public final void g(RecyclerView.ViewHolder r100) {
        ArrayList r101 = (ArrayList) this.f276024b;
        int r102 = r101.size() - 1;
    L3:
        if (r102 < 0) goto L9;
        if (f((d) ListProtector.get(r101, r102), r100) == false) goto L8;
        if (r100 == null) goto L8;
        ListProtector.remove(r101, r102);
    L8:
        r102 = r102 - 1;
        goto L3
    L9:
        if (r100 != null) goto L16;
        r101.clear();
        return;
    }

    public final void h(T r100) {
        ((ArrayList) this.f276024b).add(r100);
    }

    public final void o(RecyclerView.ViewHolder r100) {
        if (f276022e != null) goto L5;
        f276022e = new ValueAnimator().getInterpolator();
    L5:
        r100.itemView.animate().setInterpolator(f276022e);
        this.f276023a.endAnimation(r100);
    }

    public final void p(boolean r100, long r101) {
        ArrayList r102 = new ArrayList();
        r102.addAll(this.f276024b);
        ((ArrayList) this.f276024b).clear();
        if (r100 == false) goto L5;
        ((ArrayList) this.f276025c).add(r102);
        a r103 = new a(this, r102);
        ViewCompat.postOnAnimationDelayed(((d) ListProtector.get(r102, 0)).b().itemView, r103, r101);
        return;
    L5:
        Iterator r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        n((d) r104.next());
        goto L7
    L9:
        r102.clear();
    }

    public final void q(T r100, RecyclerView.ViewHolder r101, ViewPropertyAnimatorCompat r102) {
        r102.setListener(new BaseAnimatorListener(this, r100, r101, r102));
        if (r101 == null) goto L7;
        ((ArrayList) this.f276026d).add(r101);
        r102.start();
        return;
    L7:
        throw new IllegalStateException("item is null");
    }
}
