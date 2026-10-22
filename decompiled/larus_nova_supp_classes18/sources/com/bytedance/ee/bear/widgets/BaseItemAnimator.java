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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class BaseItemAnimator extends SimpleItemAnimator {
    public static TimeInterpolator l;
    public final ArrayList<RecyclerView.ViewHolder> a;
    public final ArrayList<RecyclerView.ViewHolder> b;
    public final ArrayList<e> c;
    public final ArrayList<d> d;
    public final ArrayList<ArrayList<RecyclerView.ViewHolder>> e;
    public final ArrayList<ArrayList<e>> f;
    public final ArrayList<ArrayList<d>> g;
    public final ArrayList<RecyclerView.ViewHolder> h;
    public final ArrayList<RecyclerView.ViewHolder> i;
    public final ArrayList<RecyclerView.ViewHolder> j;
    public final ArrayList<RecyclerView.ViewHolder> k;

    public class a implements Runnable {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ BaseItemAnimator b;

        public final void a() {
            Iterator r0 = this.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L11;
            e r1 = (e) r0.next();
            BaseItemAnimator r3 = this.b;
            RecyclerView.ViewHolder r4 = r1.a;
            int r2 = r1.b;
            int r5 = r1.c;
            int r6 = r1.d;
            int r7 = r1.e;
            r3.getClass();
            View r8 = r4.itemView;
            int r9 = r6 - r2;
            int r10 = r7 - r5;
            if (r9 == 0) goto L8;
            r8.animate().translationX(0.0f);
        L8:
            if (r10 == 0) goto L10;
            r8.animate().translationY(0.0f);
        L10:
            ViewPropertyAnimator r11 = r8.animate();
            r3.i.add(r4);
            r11.setDuration(r3.getMoveDuration()).setListener(new com.bytedance.ee.bear.widgets.e(r3, r4, r9, r8, r10, r11)).start();
            goto L4
        L11:
            this.a.clear();
            this.b.f.remove(this.a);
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

        public a(BaseItemAnimator r1, ArrayList r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ BaseItemAnimator b;

        public final void a() {
            Iterator r0 = this.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L16;
            d r1 = (d) r0.next();
            BaseItemAnimator r2 = this.b;
            r2.getClass();
            RecyclerView.ViewHolder r3 = r1.a;
            View r4 = null;
            if (r3 != null) goto L8;
            View r5 = null;
        L9:
            RecyclerView.ViewHolder r6 = r1.b;
            if (r6 == null) goto L12;
            r4 = r6.itemView;
        L12:
            if (r5 == null) goto L14;
            ViewPropertyAnimator r7 = r5.animate().setDuration(r2.getChangeDuration());
            r2.k.add(r1.a);
            r7.translationX(r1.e - r1.c);
            r7.translationY(r1.f - r1.d);
            r7.setListener(new com.bytedance.ee.bear.widgets.f(r2, r1, r7, r5)).start();
        L14:
            if (r4 == null) goto L4;
            ViewPropertyAnimator r8 = r4.animate();
            r2.k.add(r1.b);
            r8.translationX(0.0f).translationY(0.0f).setDuration(r2.getChangeDuration()).setListener(new g(r2, r1, r8, r4)).start();
            goto L4
        L8:
            r5 = r3.itemView;
            goto L9
        L16:
            this.a.clear();
            this.b.g.remove(this.a);
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

        public b(BaseItemAnimator r1, ArrayList r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ ArrayList a;
        public final /* synthetic */ BaseItemAnimator b;

        public final void a() {
            Iterator r0 = this.a.iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            RecyclerView.ViewHolder r1 = (RecyclerView.ViewHolder) r0.next();
            BaseItemAnimator r2 = this.b;
            ViewPropertyAnimatorCompat r3 = r2.a(r1);
            r2.h.add(r1);
            r3.setDuration(r2.getAddDuration()).setListener(new com.bytedance.ee.bear.widgets.d(r2, r1, r3)).start();
            goto L4
        L6:
            this.a.clear();
            this.b.e.remove(this.a);
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

        public c(BaseItemAnimator r1, ArrayList r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static class d {
        public RecyclerView.ViewHolder a;
        public RecyclerView.ViewHolder b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public final String toString() {
            return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
        }

        public d(RecyclerView.ViewHolder r1, RecyclerView.ViewHolder r2, int r3, int r4, int r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static class e {
        public final RecyclerView.ViewHolder a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public e(RecyclerView.ViewHolder r1, int r2, int r3, int r4, int r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static class f implements ViewPropertyAnimatorListener {
        public void onAnimationCancel(View r1) {
        }

        public f() {
        }
    }

    public abstract ViewPropertyAnimatorCompat a(RecyclerView.ViewHolder r1);

    public abstract void b(RecyclerView.ViewHolder r1);

    public abstract void c(RecyclerView.ViewHolder r1);

    public abstract ViewPropertyAnimatorCompat e(RecyclerView.ViewHolder r1, int r2);

    public abstract void f(RecyclerView.ViewHolder r1);

    public final void endAnimations() {
        int r0 = this.c.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L6;
        e r2 = (e) ListProtector.get(this.c, r0);
        View r3 = r2.a.itemView;
        r3.setTranslationY(0.0f);
        r3.setTranslationX(0.0f);
        dispatchMoveFinished(r2.a);
        ListProtector.remove(this.c, r0);
        goto L3
    L6:
        int r1 = this.a.size();
    L7:
        r1 = r1 - 1;
        if (r1 < 0) goto L10;
        dispatchRemoveFinished((RecyclerView.ViewHolder) ListProtector.get(this.a, r1));
        ListProtector.remove(this.a, r1);
        goto L7
    L10:
        int r4 = this.b.size();
    L11:
        r4 = r4 - 1;
        if (r4 < 0) goto L14;
        RecyclerView.ViewHolder r5 = (RecyclerView.ViewHolder) ListProtector.get(this.b, r4);
        b(r5);
        dispatchAddFinished(r5);
        ListProtector.remove(this.b, r4);
        goto L11
    L14:
        int r6 = this.d.size();
    L15:
        r6 = r6 - 1;
        if (r6 < 0) goto L24;
        d r7 = (d) ListProtector.get(this.d, r6);
        RecyclerView.ViewHolder r8 = r7.a;
        if (r8 == null) goto L20;
        d(r7, r8);
    L20:
        RecyclerView.ViewHolder r9 = r7.b;
        if (r9 == null) goto L15;
        d(r7, r9);
        goto L15
    L24:
        this.d.clear();
        if (isRunning() == true) goto L27;
        return;
    L27:
        int r10 = this.f.size();
    L28:
        r10 = r10 - 1;
        if (r10 < 0) goto L38;
        ArrayList r11 = (ArrayList) ListProtector.get(this.f, r10);
        int r12 = r11.size();
    L31:
        r12 = r12 - 1;
        if (r12 < 0) goto L28;
        e r13 = (e) ListProtector.get(r11, r12);
        View r14 = r13.a.itemView;
        r14.setTranslationY(0.0f);
        r14.setTranslationX(0.0f);
        dispatchMoveFinished(r13.a);
        ListProtector.remove(r11, r12);
        if (r11.isEmpty() == false) goto L31;
        this.f.remove(r11);
        goto L31
    L38:
        int r15 = this.e.size();
    L39:
        r15 = r15 - 1;
        if (r15 < 0) goto L49;
        ArrayList r16 = (ArrayList) ListProtector.get(this.e, r15);
        int r17 = r16.size();
    L42:
        r17 = r17 - 1;
        if (r17 < 0) goto L39;
        RecyclerView.ViewHolder r18 = (RecyclerView.ViewHolder) ListProtector.get(r16, r17);
        View r19 = r18.itemView;
        b(r18);
        dispatchAddFinished(r18);
        ListProtector.remove(r16, r17);
        if (r16.isEmpty() == false) goto L42;
        this.e.remove(r16);
        goto L42
    L49:
        int r20 = this.g.size();
    L50:
        r20 = r20 - 1;
        if (r20 < 0) goto L66;
        ArrayList r21 = (ArrayList) ListProtector.get(this.g, r20);
        int r22 = r21.size();
    L53:
        r22 = r22 - 1;
        if (r22 < 0) goto L50;
        d r23 = (d) ListProtector.get(r21, r22);
        RecyclerView.ViewHolder r24 = r23.a;
        if (r24 == null) goto L58;
        d(r23, r24);
    L58:
        RecyclerView.ViewHolder r25 = r23.b;
        if (r25 == null) goto L62;
        d(r23, r25);
    L62:
        if (r21.isEmpty() == false) goto L53;
        this.g.remove(r21);
        goto L53
    L66:
        cancelAll(this.j);
        cancelAll(this.i);
        cancelAll(this.h);
        cancelAll(this.k);
        dispatchAnimationsFinished();
    }

    public final boolean isRunning() {
        if (this.b.isEmpty() == true) goto L5;
    L26:
        return true;
    L5:
        if (this.d.isEmpty() == false) goto L26;
        if (this.c.isEmpty() == false) goto L26;
        if (this.a.isEmpty() == false) goto L26;
        if (this.i.isEmpty() == false) goto L26;
        if (this.j.isEmpty() == false) goto L26;
        if (this.h.isEmpty() == false) goto L26;
        if (this.k.isEmpty() == false) goto L26;
        if (this.f.isEmpty() == false) goto L26;
        if (this.e.isEmpty() == false) goto L26;
        if (this.g.isEmpty() == false) goto L26;
        return false;
    }

    public final void runPendingAnimations() {
        boolean r0 = !this.a.isEmpty();
        boolean r1 = !this.c.isEmpty();
        boolean r2 = !this.d.isEmpty();
        boolean r3 = !this.b.isEmpty();
        if (r0 == true) goto L9;
        if (r1 == true) goto L9;
        if (r3 == true) goto L9;
        if (r2 == true) goto L9;
        return;
    L9:
        if (r1 == false) goto L11;
        ArrayList<e> r5 = this.c;
        e r6 = (e) ListProtector.get(r5, r5.size() - 1);
        int r7 = r6.e - r6.c;
    L12:
        Iterator<RecyclerView.ViewHolder> r8 = this.a.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        RecyclerView.ViewHolder r9 = r8.next();
        ViewPropertyAnimatorCompat r10 = e(r9, r7);
        this.j.add(r9);
        r10.setDuration(getRemoveDuration()).setListener(new com.bytedance.ee.bear.widgets.c(this, r9, r10)).start();
        goto L14
    L16:
        this.a.clear();
        if (r1 == false) goto L22;
        ArrayList<e> r11 = new ArrayList();
        r11.addAll(this.c);
        this.f.add(r11);
        this.c.clear();
        a r12 = new a(this, r11);
        if (r0 == false) goto L21;
        ViewCompat.postOnAnimationDelayed(((e) ListProtector.get(r11, 0)).a.itemView, r12, 0);
        goto L22
    L21:
        r12.run();
    L22:
        if (r2 == false) goto L27;
        ArrayList<d> r13 = new ArrayList();
        r13.addAll(this.d);
        this.g.add(r13);
        this.d.clear();
        b r14 = new b(this, r13);
        if (r0 == false) goto L26;
        ViewCompat.postOnAnimationDelayed(((d) ListProtector.get(r13, 0)).a.itemView, r14, 0);
        goto L27
    L26:
        r14.run();
    L27:
        if (r3 == false) goto L37;
        ArrayList<RecyclerView.ViewHolder> r4 = new ArrayList();
        r4.addAll(this.b);
        this.e.add(r4);
        this.b.clear();
        c r15 = new c(this, r4);
        if (r0 == true) goto L34;
        if (r1 == true) goto L34;
        if (r2 == true) goto L34;
        r15.run();
        return;
    L34:
        ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder) ListProtector.get(r4, 0)).itemView, r15, 0);
        return;
    L37:
        return;
    L11:
        r7 = 0;
        goto L12
    }

    public BaseItemAnimator() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
    }

    public final void dispatchFinishedWhenDone() {
        if (isRunning() == true) goto L6;
        dispatchAnimationsFinished();
        return;
    }

    public final boolean animateAdd(RecyclerView.ViewHolder r2) {
        resetAnimation(r2);
        c(r2);
        this.b.add(r2);
        return true;
    }

    public final boolean animateRemove(RecyclerView.ViewHolder r2) {
        resetAnimation(r2);
        this.a.add(r2);
        return true;
    }

    public final void cancelAll(List<RecyclerView.ViewHolder> r3) {
        int r0 = r3.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        ((RecyclerView.ViewHolder) ListProtector.get(r3, r0)).itemView.animate().cancel();
        r0 = r0 - 1;
        goto L3
    }

    public final void endAnimation(RecyclerView.ViewHolder r7) {
        View r0 = r7.itemView;
        r0.animate().cancel();
        int r1 = this.c.size();
    L3:
        r1 = r1 - 1;
        if (r1 < 0) goto L9;
        if (((e) ListProtector.get(this.c, r1)).a != r7) goto L3;
        r0.setTranslationY(0.0f);
        r0.setTranslationX(0.0f);
        dispatchMoveFinished(r7);
        ListProtector.remove(this.c, r1);
        goto L3
    L9:
        endChangeAnimation(this.d, r7);
        if (this.a.remove(r7) == false) goto L13;
        f(r7);
        dispatchRemoveFinished(r7);
    L13:
        if (this.b.remove(r7) == false) goto L15;
        b(r7);
        dispatchAddFinished(r7);
    L15:
        int r2 = this.g.size() - 1;
    L16:
        if (r2 < 0) goto L21;
        ArrayList r3 = (ArrayList) ListProtector.get(this.g, r2);
        endChangeAnimation(r3, r7);
        if (r3.isEmpty() == false) goto L20;
        ListProtector.remove(this.g, r2);
    L20:
        r2 = r2 - 1;
        goto L16
    L21:
        int r4 = this.f.size() - 1;
    L22:
        if (r4 < 0) goto L32;
        ArrayList r5 = (ArrayList) ListProtector.get(this.f, r4);
        int r6 = r5.size() - 1;
    L24:
        if (r6 < 0) goto L31;
        if (((e) ListProtector.get(r5, r6)).a == r7) goto L27;
        r6 = r6 - 1;
        goto L24
    L27:
        r0.setTranslationY(0.0f);
        r0.setTranslationX(0.0f);
        dispatchMoveFinished(r7);
        ListProtector.remove(r5, r6);
        if (r5.isEmpty() == false) goto L31;
        ListProtector.remove(this.f, r4);
    L31:
        r4 = r4 - 1;
        goto L22
    L32:
        int r8 = this.e.size() - 1;
    L33:
        if (r8 < 0) goto L40;
        ArrayList r9 = (ArrayList) ListProtector.get(this.e, r8);
        if (r9.remove(r7) == false) goto L39;
        b(r7);
        dispatchAddFinished(r7);
        if (r9.isEmpty() == false) goto L39;
        ListProtector.remove(this.e, r8);
    L39:
        r8 = r8 - 1;
        goto L33
    L40:
        this.j.remove(r7);
        this.h.remove(r7);
        this.k.remove(r7);
        this.i.remove(r7);
        dispatchFinishedWhenDone();
    }

    public final void resetAnimation(RecyclerView.ViewHolder r3) {
        if (l != null) goto L5;
        l = new ValueAnimator().getInterpolator();
    L5:
        r3.itemView.animate().setInterpolator(l);
        endAnimation(r3);
    }

    public final boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder r2, List<Object> r3) {
        if (r3.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (super/*androidx.recyclerview.widget.RecyclerView.ItemAnimator*/.canReuseUpdatedViewHolder(r2, r3) == true) goto L8;
        return false;
    }

    public final boolean d(d r5, RecyclerView.ViewHolder r6) {
        boolean r3 = false;
        if (r5.b != r6) goto L6;
        r5.b = null;
    L8:
        r6.itemView.setTranslationX(0.0f);
        r6.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(r6, r3);
        return true;
    L6:
        if (r5.a != r6) goto L10;
        r5.a = null;
        r3 = true;
        goto L8
    L10:
        return false;
    }

    public final void endChangeAnimation(List<d> r4, RecyclerView.ViewHolder r5) {
        int r0 = r4.size();
    L3:
        r0 = r0 - 1;
        if (r0 < 0) goto L12;
        d r1 = (d) ListProtector.get(r4, r0);
        if (d(r1, r5) == false) goto L3;
        if (r1.a != null) goto L3;
        if (r1.b != null) goto L3;
        r4.remove(r1);
        goto L3
    }

    public final boolean animateMove(RecyclerView.ViewHolder r9, int r10, int r11, int r12, int r13) {
        View r0 = r9.itemView;
        int r4 = r10 + ((int) r0.getTranslationX());
        int r5 = r11 + ((int) r9.itemView.getTranslationY());
        resetAnimation(r9);
        int r14 = r12 - r4;
        int r15 = r13 - r5;
        if (r14 != 0) goto L7;
        if (r15 != 0) goto L7;
        dispatchMoveFinished(r9);
        return false;
    L7:
        if (r14 == 0) goto L9;
        r0.setTranslationX(-r14);
    L9:
        if (r15 == 0) goto L11;
        r0.setTranslationY(-r15);
    L11:
        this.c.add(new e(r9, r4, r5, r12, r13));
        return true;
    }

    public final boolean animateChange(RecyclerView.ViewHolder r10, RecyclerView.ViewHolder r11, int r12, int r13, int r14, int r15) {
        if (r10 == r11) goto L4;
        float r0 = r10.itemView.getTranslationX();
        float r1 = r10.itemView.getTranslationY();
        resetAnimation(r10);
        int r2 = (int) ((r14 - r12) - r0);
        int r3 = (int) ((r15 - r13) - r1);
        r10.itemView.setTranslationX(r0);
        r10.itemView.setTranslationY(r1);
        if (r11 == null) goto L8;
        resetAnimation(r11);
        r11.itemView.setTranslationX(-r2);
        r11.itemView.setTranslationY(-r3);
    L8:
        this.d.add(new d(r10, r11, r12, r13, r14, r15));
        return true;
    L4:
        return animateMove(r10, r12, r13, r14, r15);
    }
}
