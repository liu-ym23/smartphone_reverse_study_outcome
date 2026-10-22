package com.bytedance.android.shopping.gallery2;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.ECStatusView;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.h;
import com.bytedance.android.shopping.api.video.i;
import com.bytedance.android.shopping.utils.g;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionViewHolder;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/gallery2/ECVideoViewContainerVHNew;", "Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionViewHolder;", "Lee3/d;", "Lcom/bytedance/android/shopping/api/video/h;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECVideoViewContainerVHNew extends TransitionViewHolder implements ee3.d, h {
    public static final /* synthetic */ int h = 0;
    public final String a;
    public i b;
    public final TextView c;
    public final TextView d;
    public final SeekBar e;
    public final ImageView f;
    public final View g;

    public static final class a implements TransitionListener {
        public final /* synthetic */ ECVideoViewContainerVHNew a;

        public final void onTransitionChanged(int r1, float r2) {
        }

        public a(ECVideoViewContainerVHNew r1) {
            this.a = r1;
        }

        public final void onTransitionBegin(int r2) {
            this.a.e.setVisibility(4);
            this.a.f.setVisibility(4);
            this.a.d.setVisibility(4);
            this.a.c.setVisibility(4);
        }

        public final void onTransitionEnd(int r2) {
            this.a.e.setVisibility(0);
            this.a.f.setVisibility(0);
            this.a.d.setVisibility(0);
            this.a.c.setVisibility(0);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ECVideoViewContainerVHNew a;

        public b(ECVideoViewContainerVHNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            i r4 = this.a.b;
            boolean r0 = true;
            if (r4 == null) goto L5;
            ECVideoPlayerView r5 = (ECVideoPlayerView) r4;
            r5.k(!r5.f());
        L5:
            ECVideoViewContainerVHNew r6 = this.a;
            ImageView r1 = r6.f;
            i r7 = r6.b;
            if (r7 != null) goto L8;
        L10:
            r0 = false;
        L11:
            r1.setSelected(r0);
            return;
        L8:
            if (((ECVideoPlayerView) r7).f() == true) goto L10;
            goto L10
        }
    }

    public static final class c implements View.OnTouchListener {
        public final /* synthetic */ ECVideoViewContainerVHNew a;

        public c(ECVideoViewContainerVHNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r1, MotionEvent r2) {
            this.a.e.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ECVideoViewContainerVHNew a;

        public d(ECVideoViewContainerVHNew r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            i r3 = this.a.b;
            if (r3 != null) goto L5;
        L9:
            i r4 = this.a.b;
            if (r4 == null) goto L15;
            ((ECVideoPlayerView) r4).n();
            return;
        L15:
            return;
        L5:
            if (((ECVideoPlayerView) r3).h() != true) goto L9;
            i r5 = this.a.b;
            if (r5 == null) goto L13;
            ((ECVideoPlayerView) r5).m();
            return;
        }
    }

    public static final class e implements SeekBar.OnSeekBarChangeListener {
        public final /* synthetic */ ECVideoViewContainerVHNew a;

        public e(ECVideoViewContainerVHNew r1) {
            this.a = r1;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r2) {
            ECVideoViewContainerVHNew r3 = this.a;
            int r0 = ECVideoViewContainerVHNew.h;
            r3.getClass();
            i r4 = this.a.b;
            if (r4 != null) goto L5;
            return;
        L5:
            if (((ECVideoPlayerView) r4).d() != true) goto L11;
            i r5 = this.a.b;
            if (r5 == null) goto L12;
            ((ECVideoPlayerView) r5).n();
            return;
        L12:
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r4) {
            if (r4 != null) goto L12;
            return;
        L12:
            i r0 = this.a.b;     // Catch: Exception -> L8
            if (r0 == null) goto L10;
            ((ECVideoPlayerView) r0).v((r4.getProgress() * 100) / r4.getMax());     // Catch: Exception -> L8
        L10:
            this.a.c.setText(g.b(r4.getProgress() / 1000));
            this.a.getClass();
            return;
        L8:
            e = move-exception;
            EnsureManager.ensureNotReachHere(e);
            goto L10
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r1, int r2, boolean r3) {
            if (r3 == false) goto L5;
            this.a.e.setProgress(r2);
            TextView r4 = this.a.c;
            int r5 = g.a;
            r4.setText(g.b(r2 / 1000));
            return;
        }
    }

    @Override // ee3.d
    public final void J() {
        dm.a.b r0 = dm.a.a;
        dm.a.a(this.a).a("detachOldPlayer");
        i r1 = this.b;
        if (r1 == null) goto L5;
        ((ECVideoPlayerView) r1).t(this);
    L5:
        this.b = null;
    }

    @Override // ee3.d
    public final void onViewAttachedToWindow() {
        i r0 = this.b;
        if (r0 == null) goto L6;
        ((ECVideoPlayerView) r0).n();
        return;
    }

    @Override // ee3.d
    public final void onViewDetachedFromWindow() {
        i r0 = this.b;
        if (r0 == null) goto L6;
        ((ECVideoPlayerView) r0).m();
        return;
    }

    public ECVideoViewContainerVHNew(View r7) {
        Intrinsics.checkNotNullParameter(r7, "itemView");
        super(r7);
        this.a = "ECVideoViewContainerVHNew" + hashCode();
        ECVideoPlayerView r0 = (ECVideoPlayerView) r7.findViewById(2131371244);
        this.c = (TextView) r7.findViewById(2131390929);
        this.d = (TextView) r7.findViewById(2131390928);
        SeekBar r1 = (SeekBar) r7.findViewById(2131382056);
        this.e = r1;
        ImageView r2 = (ImageView) r7.findViewById(2131376015);
        this.f = r2;
        ImageView r3 = (ImageView) r7.findViewById(2131370806);
        View r4 = r7.findViewById(2131384822);
        this.g = r4;
        ECStatusView r5 = r7.findViewById(2131379080);
        e r6 = new e(this);
        r5.b(r7.getContext(), null, null);
        getTransitionLayout().addTransitionListener(new a(this));
        r2.setOnClickListener(new b(this));
        r1.setOnTouchListener(new c(this));
        r1.setOnSeekBarChangeListener(r6);
        r4.setOnClickListener(new d(this));
    }

    @Override // ee3.d
    public final void W(ee3.b r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryECVideoViewModel");
        J();
        dm.a.b r3 = dm.a.a;
        dm.a.a(this.a).a("attachPlayer");
        this.b = null;
        ImageView r4 = this.f;
        i r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        r4.setSelected(r1);
        return;
    L5:
        if (((ECVideoPlayerView) r0).f() == true) goto L7;
        r1 = true;
        goto L8
    }
}
