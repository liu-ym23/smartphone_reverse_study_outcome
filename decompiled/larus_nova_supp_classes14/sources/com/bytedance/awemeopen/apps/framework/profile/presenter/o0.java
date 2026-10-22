package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.bytedance.awemeopen.apps.framework.base.view.AutoRTLImageView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o0 extends f04.a<Unit> {
    public final com.bytedance.awemeopen.apps.framework.profile.m d;
    public final View e;
    public final View f;
    public final View g;
    public final AutoRTLImageView h;
    public final DmtTextView i;
    public final DampScrollableLayout j;
    public final AnimatedVectorDrawableCompat k;
    public final AnimatedVectorDrawableCompat l;
    public final int m;
    public final a n;
    public int o;
    public final m0 p;

    public static final class a implements DampScrollableLayout.d {
        public final /* synthetic */ o0 a;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final boolean c() {
            return false;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void d() {
        }

        public a(o0 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void e(int r7) {
            o0 r0 = this.a;
            boolean r2 = false;
            if (r7 < r0.o) goto L20;
            if (r0.f.getAlpha() != 0.0f) goto L7;
            r2 = true;
        L7:
            if (r2 == false) goto L18;
            Drawable r8 = r0.h.getDrawable();
            if (r8 == r0.k) goto L18;
            if ((r8 instanceof AnimatedVectorDrawableCompat) == false) goto L15;
            AnimatedVectorDrawableCompat r9 = (AnimatedVectorDrawableCompat) r8;
            if (r9.isRunning() == false) goto L15;
            r9.stop();
        L15:
            r0.h.setImageDrawable(r0.k);
            AnimatedVectorDrawableCompat r10 = r0.k;
            if (r10 == null) goto L18;
            r10.start();
        L18:
            r0.f.setAlpha(1.0f);
            x54.b.d(r0.i);
            return;
        L20:
            if (r0.f.getAlpha() != 1.0f) goto L22;
            r2 = true;
        L22:
            if (r2 == false) goto L33;
            Drawable r11 = r0.h.getDrawable();
            if (r11 == r0.l) goto L33;
            if ((r11 instanceof AnimatedVectorDrawableCompat) == false) goto L30;
            AnimatedVectorDrawableCompat r12 = (AnimatedVectorDrawableCompat) r11;
            if (r12.isRunning() == false) goto L30;
            r12.stop();
        L30:
            r0.h.setImageDrawable(r0.l);
            AnimatedVectorDrawableCompat r13 = r0.l;
            if (r13 == null) goto L33;
            r13.start();
        L33:
            r0.f.setAlpha(0.0f);
            x54.b.b(r0.i);
        }
    }

    @Override // f04.a
    public final void k() {
        this.j.e(this.n);
        this.d.b.getUserName().removeObserver(this.p);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.m0] */
    public o0(com.bytedance.awemeopen.apps.framework.profile.m r3) {
        Intrinsics.checkNotNullParameter(r3, "pgParameters");
        super(r3.a);
        this.d = r3;
        View r4 = i(2131383273);
        this.e = r4;
        this.f = i(2131388841);
        this.g = i(2131388813);
        this.h = (AutoRTLImageView) i(2131363770);
        this.i = (DmtTextView) i(2131388772);
        this.j = (DampScrollableLayout) i(2131385230);
        this.k = AnimatedVectorDrawableCompat.create(getContext(), 2131231592);
        this.l = AnimatedVectorDrawableCompat.create(getContext(), 2131231594);
        this.m = z04.c.a(getContext());
        this.n = new a(this);
        r4.post(new l0(this));
        this.p = new m0(this);
    }

    @Override // f04.a
    public final void j(Unit r3) {
        Intrinsics.checkNotNullParameter(r3, "unit");
        this.h.setOnClickListener(new n0(this));
        this.j.d(this.n);
        this.d.b.getUserName().observe(this.d.c, this.p);
    }
}
