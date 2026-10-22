package com.bytedance.locallife.poi.media.photo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.locallife.poi.media.PoiPlayer;
import com.bytedance.locallife.poi.media.api.PlayState;
import com.larus.nova.R;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class SlidesPhotosView implements hy6.e, hy6.c, View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f262705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<View, Unit> f262706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public hy6.b f262707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public hy6.c f262708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SlidesPhotosViewConfig f262709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f262710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PlayState f262711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f262712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewPager2 f262713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f262714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f262715k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SlidePhotosViewPagerAdapter f262716l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PoiSlidesPhotosProgressBar f262717m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f262718n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f262719o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f262720p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f262721q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f262722r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f262723s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicBoolean f262724t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final l f262725u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public j f262726v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CopyOnWriteArrayList<ViewPager2.OnPageChangeCallback> f262727w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CopyOnWriteArrayList<View.OnAttachStateChangeListener> f262728x;

    public final void a() {
        this.f262713i.setUserInputEnabled(this.f262709e.getDragEnabled());
        this.f262713i.setOrientation(this.f262709e.getOrientation());
        if (this.f262709e.getShowProgressBar() == true) goto L5;
    L7:
        l r100 = this.f262725u;
        r100.f262778c = this.f262709e.getPhotoPlayDuration();
        r100.c();
        l r101 = this.f262725u;
        r101.f262779d = this.f262709e.getProgressInterval();
        r101.c();
        return;
    L5:
        if (this.f262710f <= 1) goto L7;
        this.f262717m.setVisibility(0);
        goto L7
    }

    public static void f(SlidesPhotosView r100) {
        l r101 = r100.f262725u;
        r101.f262785j = false;
        r101.f262786k = false;
        r101.a();
        r100.f262713i.endFakeDrag();
        PlayState r102 = r100.f262711g;
        PlayState r103 = PlayState.PLAY_STATE_STOPPED;
        if (r102 == r103) goto L7;
        r100.f262711g = r103;
        hy6.b r104 = r100.f262707c;
        if (r104 == null) goto L7;
        r104.o(r103);
    L7:
        int r105 = r100.f262713i.getCurrentItem();
        if (r100.c(r105) != 0) goto L10;
    L13:
        r100.f262717m.c(0);
        return;
    L10:
        if (r100.f262709e.getEnableLoop() == false) goto L12;
        r100.g((r105 - r100.c(r105)) + 0, false, 0);
        goto L13
    L12:
        r100.g(0, false, 0);
        goto L13
    }

    public final int c(int r100) {
        if (this.f262716l.getItemCount() > 0) goto L5;
        return r100;
    L5:
        return r100 % this.f262716l.getItemCount();
    }

    @Override // hy6.c
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "urlStruct");
        hy6.c r101 = this.f262708d;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f262715k = false;
        Function1<View, Unit> r101 = this.f262706b;
        if (r101 == null) goto L6;
        r101.invoke(r100);
        return;
    }

    @Override // hy6.c
    public final void b(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "urlStruct");
        hy6.c r102 = this.f262708d;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    @Override // hy6.c
    public final void l(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "urlStruct");
        hy6.c r102 = this.f262708d;
        if (r102 == null) goto L6;
        r102.l(r100, r101);
    L6:
        if (this.f262724t.getAndSet(true) == true) goto L11;
        hy6.b r103 = this.f262707c;
        if (r103 == null) goto L12;
        r103.onRenderStart();
        return;
    L12:
        return;
    }

    @Override // hy6.e
    public final void n(int r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r101, "layoutParams");
        ViewGroup r102 = this.f262705a;
        if (r102.indexOfChild(this.f262712h) != (-1)) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L9;
        r102 = null;
    L9:
        if (r102 == null) goto L12;
        r102.addView(this.f262712h, r100, r101);
        return;
    L12:
        return;
    L5:
        r103 = false;
        goto L6
    }

    public SlidesPhotosView(PoiPlayer r100, SlidesPhotosViewConfig r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f262705a = r100;
        this.f262706b = r102;
        Context r103 = r100.getContext();
        this.f262709e = r101;
        this.f262711g = PlayState.PLAY_STATE_UNKNOWN;
        View r104 = LayoutInflater.from(r103).inflate(R.layout.life_poi_media_slides_photo_view, r100, false);
        this.f262712h = r104;
        ViewPager2 r105 = (ViewPager2) r104.findViewById(R.id.poi_slide_photo_pager);
        this.f262713i = r105;
        View r106 = r104.findViewById(R.id.poi_slides_photo_bottom_mask);
        r106.setBackground(ly6.b.b(SlidesPhotosView$mBottomMask$1$1.INSTANCE));
        this.f262714j = r106;
        o r107 = new o(this);
        ViewPager2.OnPageChangeCallback r108 = new SlidesPhotosView$mPageChangeCallback$1(this);
        SlidePhotosViewPagerAdapter r109 = new SlidePhotosViewPagerAdapter();
        r109.f262698b = this;
        r109.f262699c = this;
        this.f262716l = r109;
        PoiSlidesPhotosProgressBar r110 = (PoiSlidesPhotosProgressBar) r104.findViewById(R.id.poi_slide_photo_progress_bar);
        r110.setProgressBarConfig(new k());
        this.f262717m = r110;
        this.f262722r = true;
        this.f262724t = new AtomicBoolean(false);
        p r111 = new p(this);
        l r112 = new l();
        Intrinsics.checkNotNullParameter(r111, "callback");
        r112.f262777b = r111;
        this.f262725u = r112;
        this.f262727w = new CopyOnWriteArrayList();
        this.f262728x = new CopyOnWriteArrayList();
        r105.setOffscreenPageLimit(1);
        r105.addOnAttachStateChangeListener(r107);
        r105.registerOnPageChangeCallback(r108);
        r105.setAdapter(r109);
        View r113 = r105.getChildAt(0);
        if ((r113 instanceof RecyclerView) == false) goto L5;
        RecyclerView r114 = (RecyclerView) r113;
    L6:
        if (r114 == null) goto L9;
        r114.setNestedScrollingEnabled(false);
    L9:
        a();
        return;
    L5:
        r114 = null;
        goto L6
    }

    public final void g(final int r100, final boolean r110, long r111) {
        if (this.f262713i.isFakeDragging() == false) goto L6;
        this.f262713i.endFakeDrag();
    L6:
        if (r111 <= 0) goto L8;
        this.f262713i.postDelayed(new SlidesPhotosView$setCurrentPosition$1(r110, this, r100), r111);
        return;
    L8:
        if (r110 == false) goto L10;
        s.a(this.f262713i, r100, this.f262709e.getScrollAnimationDuration(), new SlidesPhotosView$setCurrentPosition$2(this), new SlidesPhotosView$setCurrentPosition$3(this));
        return;
    L10:
        this.f262713i.setCurrentItem(r100, r110);
    }

    public static void e(SlidesPhotosView r100, int r101, float r102, float r103, long r110, boolean r111, int r112) {
        if ((r112 & 8) == 0) goto L5;
        r110 = 300;
    L5:
        long r104 = r110;
        if ((r112 & 16) == 0) goto L8;
        r111 = false;
    L8:
        r100.getClass();
        if (r100.f262715k == false) goto L12;
        return;
    L12:
        if (r100.f262709e.getShowProgressBar() == true) goto L14;
    L20:
        j r105 = r100.f262726v;
        if (r105 == null) goto L24;
        r105.f();
        return;
    L24:
        return;
    L14:
        if (r100.f262710f <= 1) goto L20;
        if (r100.f262709e.getAutoPlayEnabled() == false) goto L19;
        if (r111 == true) goto L19;
        PoiSlidesPhotosProgressBar.d(r100.f262717m, r101, r103 / 100.0f, r104, 8);
    L19:
        r100.f262717m.e(r101, r103 / 100.0f);
        goto L20
    }
}
