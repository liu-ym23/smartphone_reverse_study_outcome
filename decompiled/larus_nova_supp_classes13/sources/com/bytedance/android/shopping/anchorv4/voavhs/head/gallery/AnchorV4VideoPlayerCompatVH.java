package com.bytedance.android.shopping.anchorv4.voavhs.head.gallery;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.o;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/gallery/AnchorV4VideoPlayerCompatVH;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/j0;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/vh/g;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4VideoPlayerCompatVH extends TransitionViewHolder implements j0, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g {
    public static final /* synthetic */ int q = 0;
    public final TextView a;
    public final TextView b;
    public final SeekBar c;
    public final ImageView d;
    public PlayerBlock e;
    public final View f;
    public final FrameLayout g;
    public ViewGroup h;
    public boolean i;
    public boolean j;
    public final Lazy k;
    public final f l;
    public final g m;
    public final boolean n;
    public final boolean o;
    public final Function1<Integer, ee3.c> p;

    public static final class a<T> implements Observer {
        public final /* synthetic */ AnchorV4VideoPlayerCompatVH a;

        public a(AnchorV4VideoPlayerCompatVH r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            AnchorV4VideoPlayerCompatVH r0 = this.a;
            int r5 = ((Integer) r4).intValue();
            View r1 = r0.f;
            if (r1 == null) goto L11;
            ViewGroup.LayoutParams r2 = r1.getLayoutParams();
            if ((r2 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
            r2 = null;
        L7:
            ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r2;
            if (r3 == null) goto L12;
            r3.bottomMargin = r5;
            r1.setLayoutParams(r3);
            return;
        L12:
            return;
        }
    }

    public static final class b implements TransitionListener {
        public final /* synthetic */ AnchorV4VideoPlayerCompatVH a;
        public final /* synthetic */ ee3.c b;

        public final void onTransitionBegin(int r2) {
            ee3.c r0 = this.b;
            if (r0 == null) goto L6;
            r0.onTransitionBegin(r2);
        L6:
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == true) goto L8;
            this.a.c.setVisibility(4);
            this.a.d.setVisibility(4);
            this.a.b.setVisibility(4);
            this.a.a.setVisibility(4);
        L8:
            PlayerBlock r3 = this.a.e;
            if (r3 == null) goto L12;
            r3.A = false;
            return;
        }

        public final void onTransitionEnd(int r2) {
            if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == true) goto L5;
            this.a.c.setVisibility(0);
            this.a.d.setVisibility(0);
            this.a.b.setVisibility(0);
            this.a.a.setVisibility(0);
        L5:
            PlayerBlock r3 = this.a.e;
            if (r3 == null) goto L9;
            r3.A = true;
            return;
        }

        public b(AnchorV4VideoPlayerCompatVH r1, ee3.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onTransitionChanged(int r2, float r3) {
            ee3.c r0 = this.b;
            if (r0 == null) goto L6;
            r0.onTransitionChanged(r2, r3);
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ AnchorV4VideoPlayerCompatVH a;
        public final /* synthetic */ ee3.c b;

        public c(AnchorV4VideoPlayerCompatVH r1, ee3.c r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AnchorV4VideoPlayerCompatVH r0 = this.a;     // Catch: Throwable -> L4
            ee3.c r1 = this.b;     // Catch: Throwable -> L4
            int r2 = AnchorV4VideoPlayerCompatVH.q;     // Catch: Throwable -> L4
            r0.T3(r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ AnchorV4VideoPlayerCompatVH a;

        public d(AnchorV4VideoPlayerCompatVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            PlayerBlock r4 = this.a.e;
            if (r4 == null) goto L6;
            PlayerBlock.o(r4, false, 3);
            return;
        }
    }

    public static final class e implements View.OnTouchListener {
        public final /* synthetic */ AnchorV4VideoPlayerCompatVH a;

        public e(AnchorV4VideoPlayerCompatVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            this.a.c.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    public static final class f implements SeekBar.OnSeekBarChangeListener {
        public final /* synthetic */ AnchorV4VideoPlayerCompatVH a;

        public f(AnchorV4VideoPlayerCompatVH r1) {
            this.a = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r2) {
            this.a.j = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r2) {
            PlayerBlock r0 = this.a.e;
            if (r0 == null) goto L8;
            if (r2 == null) goto L6;
            float r3 = r2.getProgress();
        L7:
            r0.J(r3);
            goto L8
        L6:
            r3 = 0.0f;
        L8:
            this.a.j = false;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
            if (r3 == false) goto L5;
            this.a.m.Q(r2);
            return;
        }
    }

    public static final class g implements o {
        public final /* synthetic */ AnchorV4VideoPlayerCompatVH a;

        public final void W(boolean r1) {
        }

        public g(AnchorV4VideoPlayerCompatVH r1) {
            this.a = r1;
        }

        public final void Q(float r5) {
            float r6 = (float) Math.floor(r5);
            AnchorV4VideoPlayerCompatVH r0 = this.a;
            if (r0.j == true) goto L5;
            r0.c.setProgress((int) r6);
        L5:
            float r7 = r6 / 100.0f;
            PlayerBlock r1 = this.a.e;
            if (r1 == null) goto L8;
            long r2 = r1.s();
        L9:
            this.a.a.setText(com.bytedance.android.shopping.utils.g.c((long) (r7 * (r2 / ((long) 1000)))));
            return;
        L8:
            r2 = 0;
            goto L9
        }

        public final void R(boolean r2) {
            ImageView r0 = this.a.d;
            if (r2 == false) goto L5;
            int r3 = 0;
        L6:
            r0.setVisibility(r3);
            return;
        L5:
            r3 = 4;
            goto L6
        }

        public final void V(boolean r2) {
            this.a.d.setSelected(!r2);
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void Y2() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void onPageSelected(int r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void onViewDetachedFromWindow() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void t0() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j0
    public final com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d S3() {
        return (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d) this.k.getValue();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void Z0() {
        if (this.i == false) goto L25;
        PlayerBlock r0 = this.e;
        if (r0 == null) goto L15;
        g r2 = this.m;
        Intrinsics.checkNotNullParameter(r2, "reporter");
        r0.p.remove(r2);
        r0.p(false);
        if (this.n == true) goto L15;
        View r1 = r0.findViewById(2131382459);
        PlayerBlock r3 = this.e;
        if (r3 != null) goto L11;
    L13:
        int r4 = 0;
    L14:
        r1.setVisibility(r4);
        goto L15
    L11:
        if (r3.isPlaying() != true) goto L13;
        r4 = 8;
    L15:
        this.g.removeView(this.e);
        if (this.n == true) goto L23;
        PlayerBlock r5 = this.e;
        if (r5 == null) goto L20;
        wg.a.a(r5);
    L20:
        ViewGroup r6 = this.h;
        if (r6 == null) goto L23;
        r6.addView(this.e, 0);
    L23:
        this.i = false;
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.j0
    public final void o0() {
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d r0 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d) this.k.getValue();
        if (r0 == null) goto L7;
        View r1 = r0.a;
        if (r1 == null) goto L7;
        r1.setAlpha(1.0f);
    L7:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d r2 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.d) this.k.getValue();
        if (r2 == null) goto L13;
        View r3 = r2.a;
        if (r3 == null) goto L14;
        r3.setVisibility(0);
        return;
    L14:
        return;
    }

    public final void T3(ee3.c r8) {
        ViewParent r0 = null;
        if (r8 == null) goto L5;
        PlayerBlock r9 = r8.getPlayer();
    L6:
        this.e = r9;
        boolean r2 = true;
        if (this.i == true) goto L19;
        if (r9 == null) goto L19;
        r9.i(this.m);
        ViewParent r1 = r9.getParent();
        if ((r1 instanceof ViewGroup) == false) goto L13;
        r0 = r1;
    L13:
        ViewGroup r3 = (ViewGroup) r0;
        this.h = r3;
        if (r3 == null) goto L16;
        r3.removeView(r9);
    L16:
        this.g.addView(r9);
        r9.p(true);
        this.i = true;
        TextView r4 = this.b;
        StringBuilder r5 = new StringBuilder(" / ");
        int r6 = com.bytedance.android.shopping.utils.g.a;
        r5.append(com.bytedance.android.shopping.utils.g.c(r9.s() / ((long) 1000)));
        r4.setText(r5.toString());
        this.a.setText("00:00");
        if (this.n == true) goto L19;
        r9.findViewById(2131382459).setVisibility(8);
    L19:
        this.d.setOnClickListener(new d(this));
        ImageView r10 = this.d;
        PlayerBlock r7 = this.e;
        if (r7 != null) goto L22;
    L25:
        r10.setSelected(r2);
        this.c.setOnSeekBarChangeListener(this.l);
        this.c.setOnTouchListener(new e(this));
        return;
    L22:
        if (r7.o != true) goto L25;
        r2 = false;
        goto L25
    L5:
        r9 = null;
        goto L6
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh.g
    public final void I3(int r7, com.bytedance.android.shopping.anchorv4.voavhs.head.gallery.b r8) {
        if (r8 != null) goto L5;
        ee3.c r9 = (ee3.c) this.p.invoke(Integer.valueOf(getAdapterPosition()));
    L5:
        getTransitionLayout().addTransitionListener(new b(this, r9));
        if (getAdapterPosition() > 0) goto L8;
    L10:
        T3(r9);
    L12:
        if (this.o == true) goto L14;
        return;
    L14:
        if (com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i.b() == true) goto L18;
        wg.a.e(this.b, 0, 0, com.bytedance.android.shopping.extensions.b.b(62), com.bytedance.android.shopping.extensions.b.b(62), true);
        return;
    L18:
        return;
    L8:
        if (com.bytedance.android.shopping.anchorv4.voavhs.head.j.a() == false) goto L10;
        getTransitionLayout().postDelayed(new c(this, r9), 50);
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4VideoPlayerCompatVH(View r2, boolean r3, boolean r4, l r5, Function1<? super Integer, ? extends ee3.c> r6) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r6, "videoProvider");
        super(r2);
        this.n = r3;
        this.o = r4;
        this.p = r6;
        this.a = (TextView) r2.findViewById(2131390929);
        this.b = (TextView) r2.findViewById(2131390928);
        this.c = (SeekBar) r2.findViewById(2131382056);
        this.d = (ImageView) r2.findViewById(2131376015);
        this.f = r2.findViewById(2131377673);
        this.g = (FrameLayout) r2.findViewById(2131392283);
        this.k = LazyKt.lazy(new AnchorV4VideoPlayerCompatVH$galleryLayerItem$2(this));
        this.l = new f(this);
        this.m = new g(this);
        if (r5 == null) goto L6;
        r5.f.getBottomBarHeight().observe(r5.e, new a(this));
        return;
    }
}
