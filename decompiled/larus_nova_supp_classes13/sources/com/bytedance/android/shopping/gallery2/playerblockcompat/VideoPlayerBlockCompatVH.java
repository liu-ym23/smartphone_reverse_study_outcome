package com.bytedance.android.shopping.gallery2.playerblockcompat;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.o;
import com.bytedance.android.shopping.utils.g;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/gallery2/playerblockcompat/VideoPlayerBlockCompatVH;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoPlayerBlockCompatVH extends TransitionViewHolder {
    public final TextView a;
    public final TextView b;
    public final SeekBar c;
    public final ImageView d;
    public final PlayerBlock e;
    public final FrameLayout f;
    public ViewGroup g;
    public boolean h;
    public boolean i;
    public final e j;

    public static final class a implements TransitionListener {
        public final /* synthetic */ VideoPlayerBlockCompatVH a;
        public final /* synthetic */ ee3.c b;

        public final void onTransitionBegin(int r2) {
            this.b.onTransitionBegin(r2);
            this.a.c.setVisibility(4);
            this.a.d.setVisibility(4);
            this.a.b.setVisibility(4);
            this.a.a.setVisibility(4);
        }

        public final void onTransitionEnd(int r2) {
            this.a.c.setVisibility(0);
            this.a.d.setVisibility(0);
            this.a.b.setVisibility(0);
            this.a.a.setVisibility(0);
        }

        public a(VideoPlayerBlockCompatVH r1, ee3.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onTransitionChanged(int r2, float r3) {
            this.b.onTransitionChanged(r2, r3);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ VideoPlayerBlockCompatVH a;

        public b(VideoPlayerBlockCompatVH r1) {
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

    public static final class c implements View.OnTouchListener {
        public final /* synthetic */ VideoPlayerBlockCompatVH a;

        public c(VideoPlayerBlockCompatVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            this.a.c.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    public static final class d implements SeekBar.OnSeekBarChangeListener {
        public final /* synthetic */ VideoPlayerBlockCompatVH a;

        public d(VideoPlayerBlockCompatVH r1) {
            this.a = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r2) {
            this.a.i = true;
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
            this.a.i = false;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
            if (r3 == false) goto L5;
            this.a.j.Q(r2);
            return;
        }
    }

    public static final class e implements o {
        public final /* synthetic */ VideoPlayerBlockCompatVH a;

        public final void W(boolean r1) {
        }

        public e(VideoPlayerBlockCompatVH r1) {
            this.a = r1;
        }

        public final void Q(float r5) {
            float r6 = (float) Math.floor(r5);
            VideoPlayerBlockCompatVH r0 = this.a;
            if (r0.i == true) goto L5;
            r0.c.setProgress((int) r6);
        L5:
            float r7 = r6 / 100.0f;
            PlayerBlock r1 = this.a.e;
            if (r1 == null) goto L8;
            long r2 = r1.s();
        L9:
            this.a.a.setText(g.c((long) (r7 * (r2 / ((long) 1000)))));
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

    public VideoPlayerBlockCompatVH(View r12, ee3.c r13) {
        Intrinsics.checkNotNullParameter(r12, "itemView");
        Intrinsics.checkNotNullParameter(r13, "videoProvider");
        super(r12);
        TextView r0 = (TextView) r12.findViewById(2131390929);
        this.a = r0;
        TextView r1 = (TextView) r12.findViewById(2131390928);
        this.b = r1;
        SeekBar r2 = (SeekBar) r12.findViewById(2131382056);
        this.c = r2;
        ImageView r3 = (ImageView) r12.findViewById(2131376015);
        this.d = r3;
        FrameLayout r14 = (FrameLayout) r12.findViewById(2131392283);
        this.f = r14;
        d r4 = new d(this);
        e r5 = new e(this);
        this.j = r5;
        getTransitionLayout().addTransitionListener(new a(this, r13));
        PlayerBlock r6 = r13.getPlayer();
        this.e = r6;
        boolean r8 = true;
        if (this.h == true) goto L12;
        if (r6 == null) goto L12;
        r6.i(r5);
        ViewParent r7 = r6.getParent();
        if ((r7 instanceof ViewGroup) == true) goto L8;
        r7 = null;
    L8:
        ViewGroup r9 = (ViewGroup) r7;
        this.g = r9;
        if (r9 == null) goto L11;
        r9.removeView(r6);
    L11:
        r14.addView(r6);
        r6.p(true);
        this.h = true;
        StringBuilder r15 = new StringBuilder(" / ");
        int r10 = g.a;
        r15.append(g.c(r6.s() / ((long) 1000)));
        r1.setText(r15.toString());
        r0.setText("00:00");
    L12:
        r3.setOnClickListener(new b(this));
        PlayerBlock r16 = r13.getPlayer();
        if (r16 != null) goto L15;
    L17:
        r8 = false;
    L18:
        r3.setSelected(r8);
        r2.setOnSeekBarChangeListener(r4);
        r2.setOnTouchListener(new c(this));
        return;
    L15:
        if (r16.o == true) goto L17;
        goto L17
    }
}
