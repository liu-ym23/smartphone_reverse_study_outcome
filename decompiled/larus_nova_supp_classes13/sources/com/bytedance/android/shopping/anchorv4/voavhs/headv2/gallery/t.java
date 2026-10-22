package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv4.widgets.EdgeGradientFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class t {
    public EdgeGradientFrameLayout a;
    public RecyclerView b;
    public boolean c;
    public final l d;
    public final FrameLayout e;
    public final Function1<Integer, Unit> f;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ t a;
        public final /* synthetic */ boolean b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.b == true) goto L8;
            RecyclerView r3 = this.a.b;
            if (r3 == null) goto L9;
            r3.setVisibility(4);
            return;
        L9:
            return;
        }

        public b(t r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public static final void a(t r5) {
        RecyclerView r0 = r5.b;
        if (r0 != null) goto L5;
    L7:
        int r1 = 0;
    L8:
        RecyclerView r4 = r5.b;
        if (r4 != null) goto L11;
    L13:
        int r2 = 0;
    L14:
        EdgeGradientFrameLayout r6 = r5.a;
        if (r6 == null) goto L18;
        r6.b(r1, 0, r2, 0);
        return;
    L18:
        return;
    L11:
        if (r4.canScrollHorizontally(1) != true) goto L13;
        r2 = com.bytedance.android.shopping.extensions.b.a(30);
        goto L14
    L5:
        if (r0.canScrollHorizontally(-1) != true) goto L7;
        r1 = com.bytedance.android.shopping.extensions.b.a(30);
        goto L8
    }

    public final float e(int r3) {
        List r0 = (List) this.d.f.getFullThumbList().getValue();
        if (r0 == null) goto L23;
        s r4 = (s) CollectionsKt.getOrNull(r0, r3);
        if (r4 == null) goto L23;
        if (this.d.b() == false) goto L11;
        boolean r5 = Intrinsics.areEqual((Boolean) this.d.f.isMoreVideoExpanded().getValue(), Boolean.TRUE);
    L17:
        if (r5 == true) goto L28;
        EdgeGradientFrameLayout r6 = this.a;
        if (r6 != null) goto L22;
        return 0.0f;
    L22:
        return r6.getHeight();
    L28:
        return 0.0f;
    L11:
        if (r4.d == true) goto L13;
    L16:
        r5 = true;
        goto L17
    L13:
        if (Intrinsics.areEqual((Boolean) this.d.f.isMoreVideoExpanded().getValue(), Boolean.TRUE) == true) goto L16;
        r5 = false;
    L23:
        EdgeGradientFrameLayout r7 = this.a;
        if (r7 != null) goto L26;
        return 0.0f;
    L26:
        return r7.getHeight();
    }

    public final List<s> f(List<s> r11) {
        List<s> r12 = r11;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L13;
        s r1 = (s) r13.next();
        Integer r2 = (Integer) this.d.f.getSelectedPosition().getValue();
        int r3 = r1.c;
        if (r2 != null) goto L9;
    L11:
        boolean r9 = false;
    L12:
        String r4 = r1.a;
        String r5 = r1.b;
        int r6 = r1.c;
        boolean r7 = r1.d;
        String r8 = r1.e;
        Intrinsics.checkNotNullParameter(r4, "label");
        Intrinsics.checkNotNullParameter(r8, "originLabel");
        r0.add(new s(r4, r5, r6, r7, r8, r9));
        goto L4
    L9:
        if (r2.intValue() != r3) goto L11;
        r9 = true;
        goto L12
    L13:
        return r0;
    }

    public final boolean g(int r2) {
        List r0 = (List) this.d.f.getFullThumbList().getValue();
        if (r0 == null) goto L5;
        s r3 = (s) CollectionsKt.getOrNull(r0, r2);
    L6:
        if (r3 == null) goto L8;
        return true;
    L8:
        return false;
    L5:
        r3 = null;
        goto L6
    }

    public final void h(boolean r3) {
        Integer r0 = (Integer) this.d.f.getSelectedPosition().getValue();
        if (r0 != null) goto L5;
        r0 = -1;
    L5:
        int r1 = r0.intValue();
        if (g(r1) == true) goto L8;
        return;
    L8:
        float r2 = e(r1);
        if (r2 != 0.0f) goto L11;
        boolean r4 = true;
    L12:
        d(r2, r3, r4);
        return;
    L11:
        r4 = false;
        goto L12
    }

    public static final void c(t r6, List r7) {
        final List<s> r8 = r6.f(r7);
        EdgeGradientFrameLayout r0 = r6.a;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        RecyclerView r2 = r6.b;
        Integer r3 = null;
        if (r2 == null) goto L11;
        RecyclerView.Adapter r4 = r2.getAdapter();
    L13:
        if ((r4 instanceof p0) == true) goto L15;
        r4 = null;
    L15:
        p0 r5 = (p0) r4;
        if (r5 == null) goto L18;
        Intrinsics.checkNotNullParameter(r8, "newItems");
        final List r9 = CollectionsKt.toList(r5.a);
        DiffUtil.DiffResult r10 = DiffUtil.calculateDiff(new MoreVideoAdapter$updateItems$diffResult$1(r9, r8));
        r5.a.clear();
        r5.a.addAll(r8);
        r10.dispatchUpdatesTo(r5);
    L18:
        Iterator r11 = ((ArrayList) r8).iterator();
        int r12 = 0;
    L20:
        if (r11.hasNext() == false) goto L25;
        if (((s) r11.next()).f == true) goto L26;
        r12 = r12 + 1;
    L26:
        Integer r13 = Integer.valueOf(r12);
        if (r13.intValue() < 0) goto L29;
        r1 = true;
    L29:
        if (r1 == false) goto L31;
        r3 = r13;
    L31:
        if (r3 == null) goto L36;
        int r14 = r3.intValue();
        RecyclerView r15 = r6.b;
        if (r15 == null) goto L36;
        r15.post(new b0(r14, r6));
    L36:
        if (r6.c == true) goto L41;
        r6.h(true);
        return;
    L41:
        return;
    L25:
        r12 = -1;
        goto L26
    L11:
        r4 = null;
        goto L13
    L5:
        if ((!((ArrayList) r8).isEmpty()) == false) goto L7;
        r0.setVisibility(0);
        goto L8
    L7:
        r0.setVisibility(8);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(l r2, FrameLayout r3, Function1<? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "galleryCtx");
        Intrinsics.checkNotNullParameter(r3, "galleryContainer");
        Intrinsics.checkNotNullParameter(r4, "trySelectPosition");
        this.d = r2;
        this.e = r3;
        this.f = r4;
    }

    public static final void b(t r1, int r2, RecyclerView r3) {
        r1.getClass();
        RecyclerView.ViewHolder r4 = r3.findViewHolderForLayoutPosition(r2);
        if (r4 == null) goto L8;
        View r5 = r4.itemView;
        if (r5 == null) goto L9;
        r3.smoothScrollBy(((int) r5.getX()) - ((r3.getWidth() / 2) - (r5.getWidth() / 2)), 0);
        return;
    L9:
        return;
    }

    public final void d(float r11, boolean r12, boolean r13) {
        float r2 = 0.0f;
        if (r11 != 0.0f) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        m r4 = this.d.g;
        r4.getClass();
        m.d(r4, "pdp_module_show", null, "more_video_show", "a1.b34986.c503191.d927636", 6);
    L8:
        EdgeGradientFrameLayout r5 = this.a;
        if (r5 != null) goto L11;
        return;
    L11:
        if (r5.isLaidOut() == true) goto L13;
        return;
    L13:
        if (r5.getHeight() <= 0) goto L44;
        float r6 = 1.0f;
        if (r12 == false) goto L23;
        if (r13 == false) goto L20;
        RecyclerView r14 = this.b;
        if (r14 == null) goto L20;
        r14.setVisibility(0);
    L20:
        if (r13 == false) goto L22;
        r2 = 1.0f;
    L22:
        r5.animate().translationY(r11).alpha(r2).setDuration(300).setListener(new b(this, r13)).start();
        return;
    L23:
        EdgeGradientFrameLayout r15 = this.a;
        if (r15 == null) goto L26;
        float r16 = r15.getHeight();
    L28:
        if (r16 <= 0) goto L33;
        float r17 = 1;
        EdgeGradientFrameLayout r0 = this.a;
        if (r0 == null) goto L32;
        r2 = r0.getHeight();
    L32:
        r6 = r17 - (r11 / r2);
    L33:
        r5.animate().setListener(null).cancel();
        r5.setTranslationY(r11);
        r5.setAlpha(r6);
        if (r13 == false) goto L38;
        RecyclerView r18 = this.b;
        if (r18 == null) goto L46;
        r18.setVisibility(0);
        return;
    L46:
        return;
    L38:
        RecyclerView r19 = this.b;
        if (r19 == null) goto L48;
        r19.setVisibility(4);
        return;
    L48:
        return;
    L26:
        r16 = 0.0f;
        goto L28
    L44:
        return;
    L5:
        r3 = false;
        goto L6
    }
}
