package com.bytedance.android.shopping.gallery2;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.shopping.utils.g;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.utils.Error;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/gallery2/ECVideoViewContainerVH;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/b;", "Lee3/d;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECVideoViewContainerVH extends TransitionViewHolder implements com.bytedance.android.shopping.widget.ecvideoplayer.b, ee3.d {
    public final ECVideoView a;
    public ECVideoView b;
    public ECVideoPlayer c;
    public final TextView d;
    public final TextView e;
    public final SeekBar f;
    public final ImageView g;
    public final ImageView h;
    public final View i;
    public final ECStatusView j;
    public boolean k;

    public static final class a implements TransitionListener {
        public final /* synthetic */ ECVideoViewContainerVH a;

        public final void onTransitionChanged(int r1, float r2) {
        }

        public a(ECVideoViewContainerVH r1) {
            this.a = r1;
        }

        public final void onTransitionBegin(int r2) {
            this.a.f.setVisibility(4);
            this.a.g.setVisibility(4);
            this.a.e.setVisibility(4);
            this.a.d.setVisibility(4);
        }

        public final void onTransitionEnd(int r2) {
            this.a.f.setVisibility(0);
            this.a.g.setVisibility(0);
            this.a.e.setVisibility(0);
            this.a.d.setVisibility(0);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ECVideoViewContainerVH a;

        public b(ECVideoViewContainerVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            ECVideoPlayer r4 = this.a.c;
            boolean r0 = true;
            if (r4 == null) goto L5;
            r4.o(!r4.j);
        L5:
            ECVideoViewContainerVH r5 = this.a;
            ImageView r1 = r5.g;
            ECVideoPlayer r6 = r5.c;
            if (r6 != null) goto L8;
        L10:
            r0 = false;
        L11:
            r1.setSelected(r0);
            return;
        L8:
            if (r6.j == true) goto L10;
            goto L10
        }
    }

    public static final class c implements View.OnTouchListener {
        public final /* synthetic */ ECVideoViewContainerVH a;

        public c(ECVideoViewContainerVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            this.a.f.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ECVideoViewContainerVH a;

        public d(ECVideoViewContainerVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            ECVideoPlayer r3 = this.a.c;
            if (r3 != null) goto L5;
        L9:
            ECVideoPlayer r4 = this.a.c;
            if (r4 == null) goto L15;
            r4.k();
            return;
        L15:
            return;
        L5:
            if (r3.e() != true) goto L9;
            ECVideoPlayer r5 = this.a.c;
            if (r5 == null) goto L13;
            r5.j();
            return;
        }
    }

    public static final class e implements SeekBar.OnSeekBarChangeListener {
        public final /* synthetic */ ECVideoViewContainerVH a;

        public e(ECVideoViewContainerVH r1) {
            this.a = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r2) {
            ECVideoViewContainerVH r3 = this.a;
            r3.k = true;
            ECVideoPlayer r4 = r3.c;
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.g.d != 0) goto L7;
            boolean r5 = true;
        L8:
            if (r5 != true) goto L14;
            ECVideoPlayer r6 = this.a.c;
            if (r6 == null) goto L15;
            r6.k();
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r5 = false;
            goto L8
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r7) {
            ECVideoPlayer r0 = this.a.c;
            if (r0 == null) goto L10;
            if (r7 == null) goto L6;
            int r2 = r7.getProgress();
        L7:
            r0.b();
            TTVideoEngine r3 = r0.a;
            if (r3 == null) goto L10;
            r0.b.c(new com.bytedance.android.shopping.widget.ecvideoplayer.d(r3, r0, r2));
            goto L10
        L6:
            r2 = 0;
        L10:
            TextView r1 = this.a.d;
            if (r7 == null) goto L13;
            String r8 = g.b(r7.getProgress() / 1000);
        L14:
            r1.setText(r8);
            this.a.k = false;
            return;
        L13:
            r8 = null;
            goto L14
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
            if (r3 == false) goto L5;
            this.a.f.setProgress(r2);
            TextView r4 = this.a.d;
            int r5 = g.a;
            r4.setText(g.b(r2 / 1000));
            return;
        }
    }

    public final void onError(Error r1) {
    }

    public final void onIdle() {
    }

    public final void onRelease() {
    }

    public final void onRenderStart() {
    }

    public final void onVideoSizeChanged(int r1, int r2) {
    }

    public final void E() {
        this.j.c();
    }

    @Override // ee3.d
    public final void J() {
        this.a.b();
        ECVideoPlayer r0 = this.c;
        if (r0 == null) goto L7;
        ECVideoView r1 = this.b;
        if (r1 == null) goto L7;
        r1.setPlayer(r0);
    L7:
        ECVideoPlayer r2 = this.c;
        if (r2 == null) goto L10;
        r2.m(this);
    L10:
        this.c = null;
    }

    public final void g() {
        this.h.setVisibility(0);
    }

    public final void onPaused() {
        this.h.setVisibility(0);
    }

    public final void onPlaying() {
        TextView r0 = this.e;
        StringBuilder r1 = new StringBuilder(" / ");
        int r2 = g.a;
        ECVideoPlayer r3 = this.c;
        int r4 = 0;
        if (r3 == null) goto L8;
        TTVideoEngine r5 = r3.a;
        if (r5 == null) goto L7;
        r4 = r5.getDuration();
    L7:
        r4 = r4 / 1000;
    L8:
        r1.append(g.b(r4));
        r0.setText(r1.toString());
        this.h.setVisibility(8);
        this.j.a();
    }

    @Override // ee3.d
    public final void onViewAttachedToWindow() {
        ECVideoPlayer r0 = this.c;
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    @Override // ee3.d
    public final void onViewDetachedFromWindow() {
        ECVideoPlayer r0 = this.c;
        if (r0 == null) goto L6;
        r0.j();
        return;
    }

    public final void w() {
        this.j.c();
    }

    public ECVideoViewContainerVH(View r7) {
        Intrinsics.checkNotNullParameter(r7, "itemView");
        super(r7);
        this.a = r7.findViewById(2131371244);
        this.d = (TextView) r7.findViewById(2131390929);
        this.e = (TextView) r7.findViewById(2131390928);
        SeekBar r0 = (SeekBar) r7.findViewById(2131382056);
        this.f = r0;
        ImageView r1 = (ImageView) r7.findViewById(2131376015);
        this.g = r1;
        this.h = (ImageView) r7.findViewById(2131370806);
        View r2 = r7.findViewById(2131384822);
        this.i = r2;
        ECStatusView r3 = r7.findViewById(2131379080);
        this.j = r3;
        e r4 = new e(this);
        r3.b(r7.getContext(), null, null);
        getTransitionLayout().addTransitionListener(new a(this));
        r1.setOnClickListener(new b(this));
        r0.setOnTouchListener(new c(this));
        r0.setOnSeekBarChangeListener(r4);
        r2.setOnClickListener(new d(this));
    }

    @Override // ee3.d
    public final void W(ee3.b r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryECVideoViewModel");
        J();
        ECVideoView r3 = r2.r;
        this.b = r3;
        if (r3 == null) goto L5;
        ECVideoPlayer r4 = r3.getPlayer();
    L6:
        this.c = r4;
        ECVideoView r5 = this.b;
        if (r5 == null) goto L9;
        r5.b();
    L9:
        ECVideoPlayer r6 = this.c;
        if (r6 == null) goto L12;
        this.a.setPlayer(r6);
    L12:
        ECVideoPlayer r7 = this.c;
        if (r7 == null) goto L15;
        r7.a(this);
    L15:
        ImageView r8 = this.g;
        ECVideoPlayer r0 = this.c;
        if (r0 != null) goto L18;
    L20:
        boolean r1 = false;
    L21:
        r8.setSelected(r1);
        return;
    L18:
        if (r0.j == true) goto L20;
        r1 = true;
        goto L21
    L5:
        r4 = null;
        goto L6
    }

    public final void h(int r2, int r3) {
        if (this.k == true) goto L6;
        this.f.setProgress(r2);
        this.f.setMax(r3);
        TextView r4 = this.d;
        int r0 = g.a;
        r4.setText(g.b(r2 / 1000));
        return;
    }
}
