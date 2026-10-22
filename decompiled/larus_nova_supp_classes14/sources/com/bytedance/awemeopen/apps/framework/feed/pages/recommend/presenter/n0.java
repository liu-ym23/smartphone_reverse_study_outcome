package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.SeekBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n0 extends g04.a<jz3.a> {
    public final com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d e;
    public final View f;
    public final ValueAnimator g;
    public final ValueAnimator h;
    public final a i;

    public static final class a implements com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a {
        public final /* synthetic */ n0 a;

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void onProgressChanged(int r1) {
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void a() {
            this.a.h.end();
            this.a.g.end();
            this.a.g.start();
        }

        public a(n0 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void b(SeekBar r1, boolean r2) {
            this.a.h.end();
            this.a.g.end();
            this.a.h.start();
        }
    }

    @Override // g04.a
    public final void g() {
        com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d r0 = this.e;
        if (r0 == null) goto L6;
        r0.addSeekBarChangeListener(this.i);
        return;
    }

    @Override // g04.a
    public final void i() {
        com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d r0 = this.e;
        if (r0 == null) goto L6;
        r0.removeSeekBarChangeListener(this.i);
        return;
    }

    @Override // g04.a
    public final void f(jz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    public n0(View r4, com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        this.e = r5;
        this.f = e(2131372243);
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r6.setDuration(250);
        r6.addUpdateListener(new l0(this));
        this.g = r6;
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r7.setDuration(250);
        r7.addUpdateListener(new m0(this));
        this.h = r7;
        this.i = new a(this);
    }
}
