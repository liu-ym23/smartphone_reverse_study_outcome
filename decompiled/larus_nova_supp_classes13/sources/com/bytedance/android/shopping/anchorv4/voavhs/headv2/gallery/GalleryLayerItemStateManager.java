package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.gallery2.PhotoVH;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionPhotoDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class GalleryLayerItemStateManager {
    public boolean a;
    public boolean b;
    public boolean c;
    public GalleryViewModel d;
    public ValueAnimator e;
    public ValueAnimator f;
    public ValueAnimator g;
    public ValueAnimator h;
    public final List<b> i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public final a q;
    public final Function0<RecyclerView> r;

    public static final class a implements TransitionListener {
        public final /* synthetic */ GalleryLayerItemStateManager a;

        public a(GalleryLayerItemStateManager r1) {
            this.a = r1;
        }

        public final void onTransitionBegin(int r2) {
            if (r2 != 2) goto L6;
            GalleryLayerItemStateManager.a(this.a, true);
            return;
        }

        public final void onTransitionEnd(int r2) {
            if (r2 != 0) goto L8;
            GalleryViewModel r3 = this.a.d;
            if (r3 == null) goto L6;
            r3.setEnterAnimStatus(3);
        L6:
            GalleryLayerItemStateManager r4 = this.a;
            r4.p = true;
            r4.f(r4.i);
            return;
        }

        public final void onTransitionChanged(int r6, float r7) {
            boolean r0 = true;
            if (r6 == 3) goto L5;
            if (r6 == 1) goto L5;
            return;
        L5:
            GalleryLayerItemStateManager r2 = this.a;
            if (r6 != 3) goto L8;
        L11:
            GalleryLayerItemStateManager.a(r2, r0);
            return;
        L8:
            if (r7 < 0.99d) goto L11;
            r0 = false;
            goto L11
        }
    }

    public final void c(b r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        m0 r0 = r4.b;
        if (r0.a == false) goto L6;
        this.j++;
    L6:
        if (r0.b == false) goto L9;
        this.k++;
    L9:
        if (r0.d == (-1)) goto L12;
        this.m++;
    L12:
        if (r0.e == false) goto L15;
        this.n++;
    L15:
        if (r0.c == false) goto L17;
        this.l++;
    L17:
        ((ArrayList) this.i).add(r4);
        if (r4.b.f == false) goto L21;
        r4.a.setVisibility(8);
    L21:
        if (this.p == false) goto L24;
        f(CollectionsKt.listOf(r4));
        return;
    }

    public final void e(boolean r10) {
        if (this.c != r10) goto L5;
        return;
    L5:
        this.c = r10;
        Iterator r0 = ((ArrayList) this.i).iterator();
    L7:
        if (r0.hasNext() == false) goto L10;
        ((b) r0.next()).c(r10);
        goto L7
    L10:
        if (this.l != 0) goto L12;
        return;
    L12:
        boolean r11 = this.c;
        if (r11 == false) goto L15;
        float r4 = 1.0f;
    L16:
        if (r11 == false) goto L18;
        final float r5 = 0.0f;
    L19:
        if (r11 == true) goto L21;
        j(this.i);
    L21:
        this.h = i(this, this.h, r4, r5, false, new GalleryLayerItemStateManager$handleSwitchAnimation$2(this, r5), 8);
        return;
    L18:
        r5 = 1.0f;
        goto L19
    L15:
        r4 = 0.0f;
        goto L16
    }

    public final void f(final List<? extends b> r9) {
        d((RecyclerView) this.r.invoke(), r9);
        j(r9);
        i(this, null, 0.0f, 0.0f, false, new GalleryLayerItemStateManager$initItemsVisibilityState$1(this, r9), 14);
    }

    public final void g(float r10) {
        if (this.j != 0) goto L5;
        return;
    L5:
        if (this.b == true) goto L27;
        double r0 = r10;
        if (r0 <= 1.02d) goto L10;
    L13:
        boolean r11 = true;
    L15:
        if (r11 != this.a) goto L17;
        return;
    L17:
        this.a = r11;
        if (r11 == false) goto L20;
        float r4 = 1.0f;
    L21:
        if (r11 == false) goto L23;
        final float r5 = 0.0f;
    L24:
        this.f = i(this, this.f, r4, r5, false, new GalleryLayerItemStateManager$onZoom$1(this, r5), 8);
        return;
    L23:
        r5 = 1.0f;
        goto L24
    L20:
        r4 = 0.0f;
        goto L21
    L10:
        if (r0 < 0.98d) goto L13;
        r11 = false;
        goto L15
    }

    public final void h(b r4) {
        Intrinsics.checkNotNullParameter(r4, "item");
        m0 r0 = r4.b;
        if (r0.a == false) goto L6;
        this.j--;
    L6:
        if (r0.b == false) goto L9;
        this.k--;
    L9:
        if (r0.d == (-1)) goto L12;
        this.m--;
    L12:
        if (r0.e == false) goto L15;
        this.n--;
    L15:
        if (r0.c == false) goto L17;
        this.l--;
    L17:
        ((ArrayList) this.i).remove(r4);
    }

    public final void j(List<? extends b> r4) {
        RecyclerView.ViewHolder r0 = ((RecyclerView) this.r.invoke()).findViewHolderForAdapterPosition(this.o);
        RectF r2 = null;
        if ((r0 instanceof PhotoVH) == true) goto L5;
        r0 = null;
    L5:
        PhotoVH r1 = (PhotoVH) r0;
        if (r1 == null) goto L10;
        TransitionPhotoDraweeView r3 = r1.a;
        if (r3 == null) goto L10;
        r2 = r3.getAvailableImageBounds();
    L10:
        Iterator<T> r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        ((b) r5.next()).b(r2);
        goto L12
    }

    public GalleryLayerItemStateManager(boolean r2, Function0<? extends RecyclerView> r3) {
        Intrinsics.checkNotNullParameter(r3, "getPager");
        this.r = r3;
        this.i = new ArrayList();
        this.o = -1;
        this.p = !r2;
        this.q = new a(this);
    }

    public static final void a(final GalleryLayerItemStateManager r9, boolean r10) {
        if (r9.k != 0) goto L6;
        return;
    L6:
        if (r10 == r9.b) goto L18;
        r9.b = r10;
        if (r10 == false) goto L11;
        float r4 = 1.0f;
    L12:
        if (r10 == false) goto L14;
        final float r5 = 0.0f;
    L15:
        r9.e = i(r9, r9.e, r4, r5, false, new GalleryLayerItemStateManager$onDrag$1(r9, r5), 8);
        return;
    L14:
        r5 = 1.0f;
        goto L15
    L11:
        r4 = 0.0f;
        goto L12
    }

    public final void d(RecyclerView r12, List<? extends b> r13) {
        Intrinsics.checkNotNullParameter(r12, "recyclerView");
        Intrinsics.checkNotNullParameter(r13, "list");
        if (this.p == true) goto L5;
        return;
    L5:
        int r0 = r12.getWidth();
        int r1 = r12.getChildCount();
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L48;
        View r7 = r12.getChildAt(r3);
        if (r7.getX() >= 0) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        RecyclerView.ViewHolder r2 = r12.findContainingViewHolder(r7);
        if (r2 == null) goto L48;
        Integer r4 = Integer.valueOf(r2.getAdapterPosition());
        if (r7.getX() == 0.0f) goto L39;
        if (r4.intValue() == 0) goto L39;
        if ((r2 instanceof PhotoVH) == true) goto L21;
        r2 = null;
    L21:
        PhotoVH r5 = (PhotoVH) r2;
        if (r5 == null) goto L26;
        TransitionPhotoDraweeView r6 = r5.a;
        if (r6 == null) goto L26;
        RectF r8 = r6.getAvailableImageBounds();
    L27:
        Integer r9 = Integer.valueOf(r4.intValue() - 1);
        View r10 = qc3.a.c(r12, r3 - 1);
        if (r10 == null) goto L37;
        RecyclerView.ViewHolder r14 = r12.findContainingViewHolder(r10);
        if ((r14 instanceof PhotoVH) == true) goto L32;
        r14 = null;
    L32:
        PhotoVH r15 = (PhotoVH) r14;
        if (r15 == null) goto L37;
        TransitionPhotoDraweeView r16 = r15.a;
        if (r16 == null) goto L37;
        r16.getAvailableImageBounds();
    L37:
        float r17 = r0;
        float r11 = (r17 - r7.getX()) / r17;
        Integer r18 = r4;
        r4 = r9;
    L50:
        if (r4 == null) goto L96;
        int r19 = r4.intValue();
        if (r18 == null) goto L59;
        if (r19 < r18.intValue()) goto L59;
        throw new IllegalArgumentException("curPos must be smaller than nextPos, cur=" + r19 + " next=" + r18);
    L59:
        if (this.m <= 0) goto L78;
        Iterator<T> r20 = r13.iterator();
    L62:
        if (r20.hasNext() == false) goto L78;
        b r21 = (b) r20.next();
        if (r21.b.d != 0) goto L62;
        boolean r22 = r21.a(r19);
        if (r18 == null) goto L67;
        if (r22 == r21.a(r18.intValue())) goto L62;
        if (r22 == true) goto L75;
        r21.a.setTranslationX((1 - r11) * r0);
        goto L62
    L75:
        r21.a.setTranslationX(-(r0 * r11));
        goto L62
    L67:
        View r23 = r21.a;
        if (r22 == false) goto L70;
        float r24 = 0.0f;
    L71:
        r23.setTranslationX(r24);
        goto L62
    L70:
        r24 = r0;
    L78:
        if (this.n <= 0) goto L122;
        Iterator<T> r110 = r13.iterator();
    L81:
        if (r110.hasNext() == false) goto L123;
        b r25 = (b) r110.next();
        if (r25.b.e == false) goto L81;
        if (r8 == null) goto L86;
        r8.height();
    L86:
        boolean r26 = r25.a(r19);
        if (r18 == null) goto L89;
        Boolean r27 = Boolean.valueOf(r25.a(r18.intValue()));
    L90:
        if (r26 == true) goto L94;
        if (Intrinsics.areEqual(r27, Boolean.TRUE) == true) goto L81;
    L94:
        if (r26 == false) goto L81;
        Intrinsics.areEqual(r27, Boolean.TRUE);
        goto L81
    L89:
        r27 = null;
        goto L90
    L123:
        return;
    L122:
        return;
    L96:
        return;
    L26:
        r8 = null;
    L39:
        if ((r2 instanceof PhotoVH) == true) goto L41;
        r2 = null;
    L41:
        PhotoVH r28 = (PhotoVH) r2;
        if (r28 == null) goto L46;
        TransitionPhotoDraweeView r111 = r28.a;
        if (r111 == null) goto L46;
        r111.getAvailableImageBounds();
    L46:
        r18 = null;
        r8 = null;
    L49:
        r11 = 0.0f;
    L48:
        r18 = null;
        r8 = null;
        r4 = null;
        goto L49
    }

    public static final void b(GalleryLayerItemStateManager r4, View r5, float r6, float r7, b r8) {
        r4.getClass();
        boolean r9 = true;
        if (r7 != 1.0f) goto L11;
        if (r5.getVisibility() != 8) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L20;
        r5.setVisibility(0);
    L20:
        if (r5.getAlpha() == r7) goto L23;
        r5.setAlpha(r6);
    L23:
        if (r7 != r6) goto L29;
        if (r7 == 1.0f) goto L27;
        r9 = false;
    L27:
        r8.d(r9);
        return;
    L29:
        return;
    L7:
        r2 = false;
        goto L8
    L11:
        if (r5.getVisibility() != 8) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L17;
        return;
    L17:
        if (r7 != r6) goto L20;
        r5.setVisibility(8);
        goto L20
    L13:
        r3 = false;
        goto L14
    }

    public static ValueAnimator i(GalleryLayerItemStateManager r2, Animator r3, float r4, float r5, boolean r6, Function1 r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = 0.0f;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = 1.0f;
    L12:
        if ((r8 & 8) == 0) goto L14;
        r6 = false;
    L14:
        r2.getClass();
        if (r3 == null) goto L17;
        r3.cancel();
    L17:
        if (r6 == false) goto L19;
        r7.invoke(Float.valueOf(r5));
        return null;
    L19:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{r4, r5});
        r1.setDuration(100);
        r1.addUpdateListener(new r(r7));
        r1.start();
        return r1;
    }
}
