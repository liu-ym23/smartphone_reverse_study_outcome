package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.SeekBar;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n0 extends g04.a<jz3.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d f195536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f195537f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ValueAnimator f195538g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ValueAnimator f195539h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f195540i;

    public static final class a implements com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n0 f195541a;

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void onProgressChanged(int r100) {
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void a() {
            this.f195541a.f195539h.end();
            this.f195541a.f195538g.end();
            this.f195541a.f195538g.start();
        }

        public a(n0 r100) {
            this.f195541a = r100;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void b(SeekBar r100, boolean r101) {
            this.f195541a.f195539h.end();
            this.f195541a.f195538g.end();
            this.f195541a.f195539h.start();
        }
    }

    @Override // g04.a
    public final void g() {
        com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d r100 = this.f195536e;
        if (r100 == null) goto L6;
        r100.addSeekBarChangeListener(this.f195540i);
        return;
    }

    @Override // g04.a
    public final void i() {
        com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d r100 = this.f195536e;
        if (r100 == null) goto L6;
        r100.removeSeekBarChangeListener(this.f195540i);
        return;
    }

    @Override // g04.a
    public final void f(jz3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public n0(View r100, com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f195536e = r101;
        this.f195537f = e(R.id.feed_page);
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r102.setDuration(250);
        r102.addUpdateListener(new l0(this));
        this.f195538g = r102;
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r103.setDuration(250);
        r103.addUpdateListener(new m0(this));
        this.f195539h = r103;
        this.f195540i = new a(this);
    }
}
