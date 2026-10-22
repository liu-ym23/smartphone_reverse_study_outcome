package com.h6ah4i.android.widget.advrecyclerview.animator;

import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import xv7.a;
import xv7.b;
import xv7.c;
import xv7.e;
import xv7.f;
import xv7.g;

/* JADX INFO: loaded from: classes23.dex */
public abstract class GeneralItemAnimator extends BaseItemAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f276016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f276017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f276018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f276019d;

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator
    public final void a() {
    }

    public abstract void d();

    public final void e() {
        boolean r100 = this.f276016a.i();
        boolean r101 = this.f276019d.i();
        boolean r102 = this.f276018c.i();
        boolean r103 = this.f276017b.i();
        long r104 = 0;
        if (r100 == false) goto L5;
        long r105 = getRemoveDuration();
    L6:
        if (r101 == false) goto L8;
        long r106 = getMoveDuration();
    L9:
        if (r102 == false) goto L11;
        long r110 = getChangeDuration();
    L12:
        boolean r111 = false;
        if (r100 == false) goto L15;
        this.f276016a.p(false, 0);
    L15:
        if (r101 == false) goto L17;
        this.f276019d.p(r100, r105);
    L17:
        if (r102 == false) goto L19;
        this.f276018c.p(r100, r105);
    L19:
        if (r103 == false) goto L29;
        if (r100 == true) goto L23;
        if (r101 == true) goto L23;
        if (r102 == true) goto L23;
    L24:
        long r107 = r105 + Math.max(r106, r110);
        if (r111 == false) goto L27;
        r104 = r107;
    L27:
        this.f276017b.p(r111, r104);
        return;
    L23:
        r111 = true;
        goto L24
    L29:
        return;
    L11:
        r110 = 0;
        goto L12
    L8:
        r106 = 0;
        goto L9
    L5:
        r105 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void endAnimations() {
        this.f276019d.g(null);
        this.f276016a.g(null);
        this.f276017b.g(null);
        this.f276018c.g(null);
        if (isRunning() == true) goto L5;
        return;
    L5:
        this.f276019d.e(null);
        this.f276017b.e(null);
        this.f276018c.e(null);
        this.f276016a.a();
        this.f276019d.a();
        this.f276017b.a();
        this.f276018c.a();
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final boolean isRunning() {
        if (this.f276016a.j() == false) goto L5;
    L12:
        return true;
    L5:
        if (this.f276017b.j() == true) goto L12;
        if (this.f276018c.j() == true) goto L12;
        if (this.f276019d.j() == true) goto L12;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void runPendingAnimations() {
        if (this.f276016a.i() == false) goto L5;
    L12:
        boolean r100 = true;
    L13:
        if (r100 == true) goto L15;
        return;
    L15:
        c();
        return;
    L5:
        if (this.f276019d.i() == true) goto L12;
        if (this.f276018c.i() == true) goto L12;
        if (this.f276017b.i() == true) goto L12;
        r100 = false;
        goto L13
    }

    public GeneralItemAnimator() {
        d();
        if (this.f276016a == null) goto L12;
        if (this.f276017b == null) goto L12;
        if (this.f276018c == null) goto L12;
        if (this.f276019d == null) goto L12;
        return;
    L12:
        throw new IllegalStateException("setup incomplete");
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.BaseItemAnimator
    public final boolean b() {
        return super.b();
    }

    public void c() {
        e();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateAdd(RecyclerView.ViewHolder r100) {
        RefactoredDefaultItemAnimator.a r101 = (RefactoredDefaultItemAnimator.a) this.f276017b;
        r101.o(r100);
        r100.itemView.setAlpha(0.0f);
        r101.h(new a(r100));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateRemove(RecyclerView.ViewHolder r100) {
        return this.f276016a.r(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public final void endAnimation(RecyclerView.ViewHolder r100) {
        ViewCompat.animate(r100.itemView).cancel();
        this.f276019d.g(r100);
        this.f276018c.g(r100);
        this.f276016a.g(r100);
        this.f276017b.g(r100);
        this.f276019d.e(r100);
        this.f276018c.e(r100);
        this.f276016a.e(r100);
        this.f276017b.e(r100);
        ((ArrayList) this.f276016a.f276026d).remove(r100);
        ((ArrayList) this.f276017b.f276026d).remove(r100);
        ((ArrayList) this.f276018c.f276026d).remove(r100);
        ((ArrayList) this.f276019d.f276026d).remove(r100);
        super.b();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public final boolean animateMove(RecyclerView.ViewHolder r100, int r101, int r102, int r110, int r111) {
        return this.f276019d.r(r100, r101, r102, r110, r111);
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder r110, RecyclerView.ViewHolder r111, int r112, int r113, int r114, int r115) {
        if (r110 == r111) goto L5;
        RefactoredDefaultItemAnimator.b r100 = (RefactoredDefaultItemAnimator.b) this.f276018c;
        r100.getClass();
        float r101 = r110.itemView.getTranslationX();
        float r102 = r110.itemView.getTranslationY();
        float r103 = r110.itemView.getAlpha();
        r100.o(r110);
        int r104 = (int) ((r114 - r112) - r101);
        int r105 = (int) ((r115 - r113) - r102);
        r110.itemView.setTranslationX(r101);
        r110.itemView.setTranslationY(r102);
        r110.itemView.setAlpha(r103);
        if (r111 == null) goto L9;
        r100.o(r111);
        r111.itemView.setTranslationX(-r104);
        r111.itemView.setTranslationY(-r105);
        r111.itemView.setAlpha(0.0f);
    L9:
        r100.h(new b(r110, r111, r112, r113, r114, r115));
        return true;
    L5:
        return this.f276019d.r(r110, r112, r113, r114, r115);
    }
}
