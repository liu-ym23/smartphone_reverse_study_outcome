package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.photo;

import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.GalleryLayout;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.StoryListProgressBar;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vm.PhotoFeedPagerViewModel;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r14.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class PhotoFeedProgressPresenter extends g04.a<jz3.a> implements StoryListProgressBar.b, r0.a, GalleryLayout.b {
    public static final /* synthetic */ int C = 0;
    public final FrameLayout A;
    public final Function0<? extends ViewGroup> B;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public final PhotoFeedPagerViewModel f;
    public long g;
    public boolean h;
    public final Lazy i;
    public final StoryListProgressBar j;
    public final View k;
    public GalleryLayout l;
    public int m;
    public GalleryLayout.c n;
    public r14.c o;
    public final r0 p;
    public final b q;
    public sz3.c r;
    public PhotoFeedProgressPresenter$observePinchEvent$1 s;
    public o t;
    public boolean u;
    public View v;
    public int w;
    public ViewGroup x;
    public ViewGroup y;
    public ViewGroup.LayoutParams z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PhotoFeedProgressPresenter a;

        @Override // java.lang.Runnable
        public final void run() {
            PhotoFeedProgressPresenter r0 = this.a;     // Catch: Throwable -> L7
            r0.getClass();     // Catch: Throwable -> L7
            long r1 = System.currentTimeMillis() - r0.g;     // Catch: Throwable -> L7
            if (r1 <= 1500) goto L5;
            this.a.m();     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            this.a.p.postDelayed(this, ((long) ECDraweeView.ROUND) - r1);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public b(PhotoFeedProgressPresenter r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.StoryListProgressBar.b
    public final void M0() {
    }

    @Override // g04.a
    public final void g() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r1) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.StoryListProgressBar.b
    public final void onDown(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
    }

    @Override // g04.a
    public final void h() {
        this.j.setProgressBarGestureListener(null);
        GalleryLayout r0 = this.l;
        if (r0 == null) goto L5;
        r0.setGalleryLayoutListener(null);
    L5:
        PhotoFeedProgressPresenter$observePinchEvent$1 r1 = this.s;
        if (r1 == null) goto L12;
        sz3.c r2 = this.r;
        if (r2 == null) goto L12;
        qz3.b r3 = r2.i;
        if (r3 == null) goto L12;
        r3.q(r1);
    L12:
        o r4 = this.t;
        if (r4 == null) goto L20;
        sz3.c r5 = this.r;
        if (r5 == null) goto L21;
        qz3.b r6 = r5.i;
        if (r6 == null) goto L22;
        r6.h(r4);
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void m() {
        d14.a r0 = b14.a.a;
        if (b14.a.a(x24.a.class).v3(this.o) == true) goto L5;
        return;
    L5:
        o();
        GalleryLayout.c r1 = this.n;
        if (r1 == null) goto L13;
        boolean r2 = true;
        if (r1.b == true) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
    L14:
        if (r2 == true) goto L18;
        int r4 = this.m;
        if (r4 < 0) goto L18;
        this.f.updatePreviewPhotoPosition(r4);
    L18:
        this.m = -1;
        this.n = null;
        this.p.removeCallbacks(this.q);
        this.f.setInPhotoPreView(false);
        return;
    L10:
        r3 = false;
    L13:
        r2 = false;
        goto L14
    }

    public final void n() {
        ViewGroup r0 = this.x;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.w == (-1)) goto L16;
        ViewGroup r1 = this.y;
        if (r1 == null) goto L9;
        r1.removeView(this.v);
    L9:
        r0.addView(this.v, this.w);
        View r2 = this.v;
        if (r2 == null) goto L13;
        r2.setLayoutParams(this.z);
    L13:
        this.w = -1;
        this.v = null;
        this.x = null;
        this.y = null;
        this.z = null;
        return;
    }

    public final void o() {
        GalleryLayout r0 = this.l;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        GalleryLayout r1 = this.l;
        if (r1 == null) goto L8;
        x54.b.a(r1);
    L8:
        GalleryLayout r2 = this.l;
        if (r2 == null) goto L16;
        ViewParent r3 = r2.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L13;
        ViewGroup r4 = (ViewGroup) r3;
    L14:
        if (r4 == null) goto L16;
        r4.removeView(this.l);
        goto L16
    L13:
        r4 = null;
    L16:
        this.j.requestDisallowInterceptTouchEvent(false);
        this.j.setIsTouchable(true);
        x54.b.d(this.j);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.GalleryLayout.b
    public final void a() {
        this.g = System.currentTimeMillis();
    }

    @Override // g04.a
    public final void i() {
        o();
        if (((Boolean) this.i.getValue()).booleanValue() == true) goto L5;
    L7:
        n();
        return;
    L5:
        if (this.h == false) goto L7;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.a();
        goto L7
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.StoryListProgressBar.b
    public final void N0(MotionEvent r5) {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.b();
        this.p.removeCallbacks(this.q);
        GalleryLayout r0 = this.l;
        if (r0 != null) goto L5;
    L11:
        GalleryLayout r1 = this.l;
        if (r1 == null) goto L19;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getVisibility() != 8) goto L16;
        boolean r2 = true;
    L17:
        if (r2 != true) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L38;
        this.h = true;
        this.f.cancelLoop(true);
        GalleryLayout r4 = this.l;
        if (r4 == null) goto L24;
        x54.b.d(r4);
    L24:
        r14.c r6 = this.o;
        if (r6 == null) goto L34;
        List<y> r7 = r6.v();
        if (r7 == null) goto L34;
        GalleryLayout r8 = this.l;
        if (r8 == null) goto L31;
        r8.setData(r7);
    L31:
        GalleryLayout r9 = this.l;
        if (r9 == null) goto L34;
        r9.d.setVisibility(0);
        r9.g.setVisibility(0);
        r9.g.getLayoutParams().height = 0;
    L34:
        GalleryLayout r10 = this.l;
        if (r10 == null) goto L37;
        r10.c(this.j.getCurrentPosition());
    L37:
        this.j.requestDisallowInterceptTouchEvent(true);
        this.f.setInPhotoPreView(true);
    L38:
        if (r5 == null) goto L43;
        GalleryLayout r11 = this.l;
        if (r11 == null) goto L44;
        r11.d(r5.getRawX(), r5.getRawY(), new PhotoFeedProgressPresenter$onMove$2$1(this));
        return;
    L44:
        return;
    L43:
        return;
    L16:
        r2 = false;
    L19:
        r3 = false;
        goto L20
    L5:
        if (r0.getParent() != null) goto L11;
        View r12 = iz3.a.b(this.e);
        if (r12 == null) goto L11;
        FrameLayout r13 = (FrameLayout) r12.findViewById(2131387740);
        if (r13 == null) goto L11;
        r13.addView(this.l);
        goto L11
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.StoryListProgressBar.b
    public final void O0(boolean r1) {
        m();
    }

    @Override // g04.a
    public final void f(jz3.a r5) {
        jz3.a r6 = r5;
        Intrinsics.checkNotNullParameter(r6, "data");
        this.o = r6.a;
        this.j.setMaskView(this.k);
        this.j.setProgressBarGestureListener(this);
        GalleryLayout r7 = new GalleryLayout(this.a.getContext(), null, 6, 0);
        this.l = r7;
        x54.b.a(r7);
        GalleryLayout r8 = this.l;
        if (r8 == null) goto L5;
        r8.d.setVisibility(8);
        r8.g.setVisibility(8);
    L5:
        GalleryLayout r9 = this.l;
        if (r9 == null) goto L9;
        r9.setGalleryLayoutListener(this);
        return;
    }

    public PhotoFeedProgressPresenter(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r2, PhotoFeedPagerViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r3, "photoVM");
        super(r2.a);
        this.e = r2;
        this.f = r3;
        this.i = LazyKt.lazy(PhotoFeedProgressPresenter$isNewAutoPlayStrategy$2.INSTANCE);
        this.j = (StoryListProgressBar) e(2131383297);
        this.k = e(2131383298);
        this.m = -1;
        this.p = new r0(this);
        this.q = new b(this);
        View r4 = this.a;
        if (r4 == null) goto L5;
        FrameLayout r5 = (FrameLayout) r4.findViewById(2131382324);
    L6:
        this.A = r5;
        this.B = new PhotoFeedProgressPresenter$mPinchProgressContainer$1(this);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
