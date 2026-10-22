package com.bytedance.awemeopen.apps.framework.profile.presenter;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.bytedance.awemeopen.apps.framework.base.view.AutoRTLImageView;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView;
import com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout;
import com.bytedance.crash.dumper.Scraps;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o0 extends f04.a<Unit> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.profile.m f197477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f197478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f197479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f197480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AutoRTLImageView f197481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DmtTextView f197482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DampScrollableLayout f197483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AnimatedVectorDrawableCompat f197484k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AnimatedVectorDrawableCompat f197485l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f197486m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final a f197487n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f197488o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final m0 f197489p;

    public static final class a implements DampScrollableLayout.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o0 f197490a;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final boolean c() {
            return false;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void d() {
        }

        public a(o0 r100) {
            this.f197490a = r100;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.scrollablelayout.DampScrollableLayout.d
        public final void e(int r100) {
            o0 r101 = this.f197490a;
            boolean r102 = false;
            if (r100 < r101.f197488o) goto L20;
            if (r101.f197479f.getAlpha() != 0.0f) goto L7;
            r102 = true;
        L7:
            if (r102 == false) goto L18;
            Drawable r103 = r101.f197481h.getDrawable();
            if (r103 == r101.f197484k) goto L18;
            if ((r103 instanceof AnimatedVectorDrawableCompat) == false) goto L15;
            AnimatedVectorDrawableCompat r104 = (AnimatedVectorDrawableCompat) r103;
            if (r104.isRunning() == false) goto L15;
            r104.stop();
        L15:
            r101.f197481h.setImageDrawable(r101.f197484k);
            AnimatedVectorDrawableCompat r105 = r101.f197484k;
            if (r105 == null) goto L18;
            r105.start();
        L18:
            r101.f197479f.setAlpha(1.0f);
            x54.b.d(r101.f197482i);
            return;
        L20:
            if (r101.f197479f.getAlpha() != 1.0f) goto L22;
            r102 = true;
        L22:
            if (r102 == false) goto L33;
            Drawable r106 = r101.f197481h.getDrawable();
            if (r106 == r101.f197485l) goto L33;
            if ((r106 instanceof AnimatedVectorDrawableCompat) == false) goto L30;
            AnimatedVectorDrawableCompat r107 = (AnimatedVectorDrawableCompat) r106;
            if (r107.isRunning() == false) goto L30;
            r107.stop();
        L30:
            r101.f197481h.setImageDrawable(r101.f197485l);
            AnimatedVectorDrawableCompat r108 = r101.f197485l;
            if (r108 == null) goto L33;
            r108.start();
        L33:
            r101.f197479f.setAlpha(0.0f);
            x54.b.b(r101.f197482i);
        }
    }

    @Override // f04.a
    public final void k() {
        this.f197483j.e(this.f197487n);
        this.f197477d.f197362b.getUserName().removeObserver(this.f197489p);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.awemeopen.apps.framework.profile.presenter.m0] */
    public o0(com.bytedance.awemeopen.apps.framework.profile.m r100) {
        Intrinsics.checkNotNullParameter(r100, "pgParameters");
        super(r100.f197361a);
        this.f197477d = r100;
        View r101 = i(R.id.profile_title_bar_layout);
        this.f197478e = r101;
        this.f197479f = i(R.id.title_color_ctrl);
        this.f197480g = i(R.id.title_bar_content_fl);
        this.f197481h = (AutoRTLImageView) i(R.id.back_btn);
        this.f197482i = (DmtTextView) i(R.id.title);
        this.f197483j = (DampScrollableLayout) i(R.id.scroll_layout);
        this.f197484k = AnimatedVectorDrawableCompat.create(getContext(), R.drawable.aos_profile_ic_back);
        this.f197485l = AnimatedVectorDrawableCompat.create(getContext(), R.drawable.aos_profile_ic_back_reverse);
        this.f197486m = z04.c.a(getContext());
        this.f197487n = new a(this);
        r101.post(new l0(this));
        this.f197489p = new m0(this);
    }

    @Override // f04.a
    public final void j(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, Scraps.INNER_UNIT);
        this.f197481h.setOnClickListener(new n0(this));
        this.f197483j.d(this.f197487n);
        this.f197477d.f197362b.getUserName().observe(this.f197477d.f197363c, this.f197489p);
    }
}
