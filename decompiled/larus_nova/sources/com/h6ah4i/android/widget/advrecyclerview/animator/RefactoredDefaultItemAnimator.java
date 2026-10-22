package com.h6ah4i.android.widget.advrecyclerview.animator;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import xv7.e;
import xv7.f;
import xv7.g;
import xv7.h;
import xv7.i;

/* JADX INFO: loaded from: classes23.dex */
public class RefactoredDefaultItemAnimator extends GeneralItemAnimator {

    public static class a extends xv7.c {
        public a(BaseItemAnimator r100) {
            super(r100);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final void n(xv7.d r100) {
            xv7.a r101 = (xv7.a) r100;
            ViewPropertyAnimatorCompat r102 = ViewCompat.animate(r101.f565175a.itemView);
            r102.alpha(1.0f);
            r102.setDuration(this.f276023a.getAddDuration());
            q(r101, r101.f565175a, r102);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final void k(xv7.d r100, RecyclerView.ViewHolder r101) {
            xv7.a r102 = (xv7.a) r100;
            r101.itemView.setAlpha(1.0f);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final void l(xv7.d r100, RecyclerView.ViewHolder r101) {
            xv7.a r102 = (xv7.a) r100;
            r101.itemView.setAlpha(1.0f);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final /* bridge */ /* synthetic */ void m(xv7.d r100, RecyclerView.ViewHolder r101) {
            xv7.a r102 = (xv7.a) r100;
        }
    }

    public static class b extends e {
        public b(BaseItemAnimator r100) {
            super(r100);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final /* bridge */ /* synthetic */ void k(xv7.d r100, RecyclerView.ViewHolder r101) {
            xv7.b r102 = (xv7.b) r100;
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final void l(xv7.d r100, RecyclerView.ViewHolder r101) {
            xv7.b r102 = (xv7.b) r100;
            View r103 = r101.itemView;
            r103.setAlpha(1.0f);
            r103.setTranslationX(0.0f);
            r103.setTranslationY(0.0f);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final void m(xv7.d r100, RecyclerView.ViewHolder r101) {
            xv7.b r102 = (xv7.b) r100;
            View r103 = r101.itemView;
            r103.setAlpha(1.0f);
            r103.setTranslationX(0.0f);
            r103.setTranslationY(0.0f);
        }
    }

    public static class c extends f {
        public c(BaseItemAnimator r100) {
            super(r100);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final void n(xv7.d r100) {
            h r101 = (h) r100;
            View r102 = r101.f565186e.itemView;
            int r103 = r101.f565184c - r101.f565182a;
            int r104 = r101.f565185d - r101.f565183b;
            if (r103 == 0) goto L5;
            ViewCompat.animate(r102).translationX(0.0f);
        L5:
            if (r104 == 0) goto L7;
            ViewCompat.animate(r102).translationY(0.0f);
        L7:
            ViewPropertyAnimatorCompat r105 = ViewCompat.animate(r102);
            r105.setDuration(this.f276023a.getMoveDuration());
            q(r101, r101.f565186e, r105);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final void k(xv7.d r100, RecyclerView.ViewHolder r101) {
            h r102 = (h) r100;
            View r103 = r101.itemView;
            int r104 = r102.f565184c - r102.f565182a;
            int r105 = r102.f565185d - r102.f565183b;
            if (r104 == 0) goto L5;
            ViewCompat.animate(r103).translationX(0.0f);
        L5:
            if (r105 == 0) goto L7;
            ViewCompat.animate(r103).translationY(0.0f);
        L7:
            if (r104 == 0) goto L9;
            r103.setTranslationX(0.0f);
        L9:
            if (r105 == 0) goto L12;
            r103.setTranslationY(0.0f);
            return;
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final void l(xv7.d r100, RecyclerView.ViewHolder r101) {
            h r102 = (h) r100;
            View r103 = r101.itemView;
            r103.setTranslationY(0.0f);
            r103.setTranslationX(0.0f);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final /* bridge */ /* synthetic */ void m(xv7.d r100, RecyclerView.ViewHolder r101) {
            h r102 = (h) r100;
        }

        @Override // xv7.f
        public final boolean r(RecyclerView.ViewHolder r100, int r110, int r111, int r112, int r113) {
            View r101 = r100.itemView;
            int r102 = (int) (r110 + r101.getTranslationX());
            int r103 = (int) (r111 + r100.itemView.getTranslationY());
            o(r100);
            int r114 = r112 - r102;
            int r115 = r113 - r103;
            h r104 = new h(r100, r102, r103, r112, r113);
            if (r114 != 0) goto L7;
            if (r115 != 0) goto L7;
            s(r104.f565186e);
            r104.a(r104.f565186e);
            return false;
        L7:
            if (r114 == 0) goto L9;
            r101.setTranslationX(-r114);
        L9:
            if (r115 == 0) goto L11;
            r101.setTranslationY(-r115);
        L11:
            h(r104);
            return true;
        }
    }

    public static class d extends g {
        public d(BaseItemAnimator r100) {
            super(r100);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final void n(xv7.d r100) {
            i r101 = (i) r100;
            ViewPropertyAnimatorCompat r102 = ViewCompat.animate(r101.f565187a.itemView);
            r102.setDuration(this.f276023a.getRemoveDuration());
            r102.alpha(0.0f);
            q(r101, r101.f565187a, r102);
        }

        @Override // xv7.g
        public final boolean r(RecyclerView.ViewHolder r100) {
            o(r100);
            h(new i(r100));
            return true;
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final /* bridge */ /* synthetic */ void k(xv7.d r100, RecyclerView.ViewHolder r101) {
            i r102 = (i) r100;
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final void l(xv7.d r100, RecyclerView.ViewHolder r101) {
            i r102 = (i) r100;
            r101.itemView.setAlpha(1.0f);
        }

        @Override // com.h6ah4i.android.widget.advrecyclerview.animator.impl.BaseItemAnimationManager
        public final void m(xv7.d r100, RecyclerView.ViewHolder r101) {
            i r102 = (i) r100;
            r101.itemView.setAlpha(1.0f);
        }
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator
    public void d() {
        this.f276017b = new a(this);
        this.f276016a = new d(this);
        this.f276018c = new b(this);
        this.f276019d = new c(this);
    }

    public RefactoredDefaultItemAnimator() {
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator
    public final void c() {
        e();
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
}
