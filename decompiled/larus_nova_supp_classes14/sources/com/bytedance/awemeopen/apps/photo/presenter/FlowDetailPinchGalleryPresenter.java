package com.bytedance.awemeopen.apps.photo.presenter;

import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.GalleryLayout;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.StoryListProgressBar;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.vm.PhotoFeedPagerViewModel;
import com.bytedance.awemeopen.apps.photo.pinch.PinchStableView;
import com.bytedance.awemeopen.apps.photo.viewmodel.FlowPagePinchVM;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class FlowDetailPinchGalleryPresenter extends f04.a<Unit> implements StoryListProgressBar.b, com.bytedance.awemeopen.apps.framework.utils.r0.a, GalleryLayout.b {
    public final a14.a d;
    public final PhotoFeedPagerViewModel e;
    public final Lazy f;
    public final Lazy g;
    public long h;
    public final StoryListProgressBar i;
    public final View j;
    public GalleryLayout k;
    public int l;
    public GalleryLayout.c m;
    public r14.c n;
    public final com.bytedance.awemeopen.apps.framework.utils.r0 o;
    public final a p;

    public static final class a implements Runnable {
        public final /* synthetic */ FlowDetailPinchGalleryPresenter a;

        @Override // java.lang.Runnable
        public final void run() {
            FlowDetailPinchGalleryPresenter r0 = this.a;     // Catch: Throwable -> L7
            r0.getClass();     // Catch: Throwable -> L7
            long r1 = System.currentTimeMillis() - r0.h;     // Catch: Throwable -> L7
            if (r1 <= 1500) goto L5;
            this.a.m();     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            this.a.o.postDelayed(this, ((long) ECDraweeView.ROUND) - r1);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public a(FlowDetailPinchGalleryPresenter r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.StoryListProgressBar.b
    public final void M0() {
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r1) {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.StoryListProgressBar.b
    public final void onDown(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
    }

    public final void m() {
        d14.a r0 = b14.a.a;
        if (b14.a.a(x24.a.class).v3(this.n) == true) goto L5;
        return;
    L5:
        n();
        GalleryLayout.c r1 = this.m;
        if (r1 == null) goto L13;
        boolean r2 = true;
        if (r1.b == true) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
    L14:
        if (r2 == true) goto L18;
        int r4 = this.l;
        if (r4 < 0) goto L18;
        this.e.updatePreviewPhotoPosition(r4);
    L18:
        this.l = -1;
        this.m = null;
        this.o.removeCallbacks(this.p);
        this.e.setInPhotoPreView(false);
        return;
    L10:
        r3 = false;
    L13:
        r2 = false;
        goto L14
    }

    public final void n() {
        GalleryLayout r0 = this.k;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        GalleryLayout r1 = this.k;
        if (r1 == null) goto L8;
        x54.b.a(r1);
    L8:
        GalleryLayout r2 = this.k;
        if (r2 == null) goto L16;
        ViewParent r3 = r2.getParent();
        if ((r3 instanceof ViewGroup) == false) goto L13;
        ViewGroup r4 = (ViewGroup) r3;
    L14:
        if (r4 == null) goto L16;
        r4.removeView(this.k);
        goto L16
    L13:
        r4 = null;
    L16:
        this.i.requestDisallowInterceptTouchEvent(false);
        this.i.setIsTouchable(true);
        x54.b.d(this.i);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.GalleryLayout.b
    public final void a() {
        this.h = System.currentTimeMillis();
    }

    @Override // f04.a
    public final void k() {
        n();
        this.i.setProgressBarGestureListener(null);
        GalleryLayout r0 = this.k;
        if (r0 == null) goto L6;
        r0.setGalleryLayoutListener(null);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.StoryListProgressBar.b
    public final void N0(MotionEvent r5) {
        this.o.removeCallbacks(this.p);
        GalleryLayout r0 = this.k;
        if (r0 != null) goto L5;
    L9:
        GalleryLayout r1 = this.k;
        if (r1 == null) goto L17;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.getVisibility() != 8) goto L14;
        boolean r2 = true;
    L15:
        if (r2 != true) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == false) goto L36;
        this.e.cancelLoop(true);
        GalleryLayout r4 = this.k;
        if (r4 == null) goto L22;
        x54.b.d(r4);
    L22:
        r14.c r6 = this.n;
        if (r6 == null) goto L32;
        List<r14.y> r7 = r6.v();
        if (r7 == null) goto L32;
        GalleryLayout r8 = this.k;
        if (r8 == null) goto L29;
        r8.setData(r7);
    L29:
        GalleryLayout r9 = this.k;
        if (r9 == null) goto L32;
        r9.d.setVisibility(0);
        r9.g.setVisibility(0);
        r9.g.getLayoutParams().height = 0;
    L32:
        GalleryLayout r10 = this.k;
        if (r10 == null) goto L35;
        r10.c(this.i.getCurrentPosition());
    L35:
        this.i.requestDisallowInterceptTouchEvent(true);
        this.e.setInPhotoPreView(true);
    L36:
        if (r5 == null) goto L41;
        GalleryLayout r11 = this.k;
        if (r11 == null) goto L42;
        r11.d(r5.getRawX(), r5.getRawY(), new FlowDetailPinchGalleryPresenter$onMove$2$1(this));
        return;
    L42:
        return;
    L41:
        return;
    L14:
        r2 = false;
    L17:
        r3 = false;
        goto L18
    L5:
        if (r0.getParent() != null) goto L9;
        PinchStableView r12 = (PinchStableView) this.g.getValue();
        if (r12 == null) goto L9;
        r12.addView(this.k);
        goto L9
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress.StoryListProgressBar.b
    public final void O0(boolean r1) {
        m();
    }

    @Override // f04.a
    public final void j(Unit r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        this.n = this.d.a;
        this.i.setMaskView(this.j);
        GalleryLayout r6 = new GalleryLayout(this.a.getContext(), null, 6, 0);
        this.k = r6;
        x54.b.a(r6);
        GalleryLayout r7 = this.k;
        if (r7 == null) goto L5;
        r7.d.setVisibility(8);
        r7.g.setVisibility(8);
    L5:
        FlowPagePinchVM r8 = (FlowPagePinchVM) this.f.getValue();
        if (r8 == null) goto L11;
        MutableLiveData<Boolean> r9 = r8.getInStableView();
        if (r9 == null) goto L12;
        LifecycleOwner r0 = this.d.d;
        final Function1<Boolean, Unit> r1 = new FlowDetailPinchGalleryPresenter$onBind$1(this);
        r9.observe(r0, new u(r1));
        return;
    L12:
        return;
    }

    public FlowDetailPinchGalleryPresenter(a14.a r2, PhotoFeedPagerViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "pgParameters");
        Intrinsics.checkNotNullParameter(r3, "photoVM");
        super(r2.b);
        this.d = r2;
        this.e = r3;
        this.f = LazyKt.lazy(new FlowDetailPinchGalleryPresenter$pagePinchVM$2(this));
        this.g = LazyKt.lazy(new FlowDetailPinchGalleryPresenter$mGalleryLayoutContainer$2(this));
        this.i = (StoryListProgressBar) i(2131383297);
        this.j = i(2131383298);
        this.l = -1;
        this.o = new com.bytedance.awemeopen.apps.framework.utils.r0(this);
        this.p = new a(this);
    }
}
