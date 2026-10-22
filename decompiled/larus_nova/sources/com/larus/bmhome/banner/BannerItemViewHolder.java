package com.larus.bmhome.banner;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import bb8.g;
import bb8.i;
import bb8.j;
import by7.e;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.ixigua.lib.track.TrackParams;
import com.larus.business.banner.databinding.LarusItemBannerBinding;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.zhpan.bannerview.indicator.DrawableIndicator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\u0015H\u0007J\b\u0010\u0017\u001a\u00020\u0015H\u0007J\u0016\u0010\u0018\u001a\u00020\u00152\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aJ \u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/banner/BannerItemViewHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/ixigua/lib/track/ITrackNode;", "viewBinding", "Lcom/larus/business/banner/databinding/LarusItemBannerBinding;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "parent", "<init>", "(Lcom/larus/business/banner/databinding/LarusItemBannerBinding;Landroidx/lifecycle/Lifecycle;Lcom/ixigua/lib/track/ITrackNode;)V", "pendingEventBannerShow", "Ljava/lang/Runnable;", "enableBannerOpt", "", "getEnableBannerOpt", "()Z", "enableBannerOpt$delegate", "Lkotlin/Lazy;", "parentTrackNode", "onPause", "", "onResume", LiveCommonConstants.REASON_ON_DEDTROY, "bindViewHolder", "data", "", "Lcom/larus/bmhome/banner/BannerModel;", "getValidBanner", "banner_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BannerItemViewHolder extends ViewBindingHolder implements LifecycleObserver, e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f295883f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemBannerBinding f295884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lifecycle f295885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f295886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f295887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f295888e;

    @Override // by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.f295884a.f319935b.g();
        if (((Boolean) this.f295888e.getValue()).booleanValue() == false) goto L8;
        this.f295884a.f319935b.setBannerAutoPlay(false);
        Lifecycle r100 = this.f295885b;
        if (r100 == null) goto L9;
        r100.removeObserver(this);
        return;
    L9:
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        if (((Boolean) this.f295888e.getValue()).booleanValue() == false) goto L5;
        this.f295884a.f319935b.setBannerAutoPlay(false);
    L5:
        this.f295884a.f319935b.g();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        BannerViewPager r100 = this.f295884a.f319935b;
        r100.setBannerAutoPlay(true);
        r100.f();
        Runnable r101 = this.f295887d;
        if (r101 == null) goto L5;
        r101.run();
    L5:
        this.f295887d = null;
    }

    @Override // by7.e
    public final e referrerTrackNode() {
        return e.a.a(this);
    }

    @Override // by7.e
    public final e parentTrackNode() {
        return this.f295886c;
    }

    public final void T3(List<i> r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        final BannerViewPager r100 = this.f295884a.f319935b;
        final ArrayList r101 = new ArrayList();
        Iterator<T> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L9;
        i r102 = (i) r111.next();
        if (j.a(r102) == true) goto L4;
        r101.add(r102);
        goto L4
    L9:
        if (r100.getAdapter() != null) goto L11;
    L13:
        r100.f464544i = new BannerAdapter(this, this.f295885b);
        r100.f464545j = new BannerItemViewHolder$bindViewHolder$1$1(this, r101, r100);
        DrawableIndicator r112 = this.f295884a.f319936c;
        r112.d(R.drawable.larus_banner_indicator_unchoice, R.drawable.larus_banner_indicator_choice);
        Lifecycle.State r103 = null;
        int r104 = i5.y0(c.b(R.attr.larus_dp_3, null, R.dimen.larus_dp_3));
        if (r104 < 0) goto L16;
        r112.f464556g = r104;
        r112.postInvalidate();
    L16:
        r112.f464561l = new DrawableIndicator.a(i5.y0(c.b(R.attr.larus_dp_5, null, R.dimen.larus_dp_5)), i5.y0(c.b(R.attr.larus_dp_4, null, R.dimen.larus_dp_4)), i5.y0(c.b(R.attr.larus_dp_5, null, R.dimen.larus_dp_5)), i5.y0(c.b(R.attr.larus_dp_4, null, R.dimen.larus_dp_4)));
        r112.c();
        r112.postInvalidate();
        Lifecycle r113 = this.f295885b;
        if (r113 == null) goto L20;
        r103 = r113.getCurrentState();
    L20:
        if (r103 != Lifecycle.State.RESUMED) goto L22;
        r100.setBannerAutoPlay(true);
    L23:
        r100.f464542g.a().f568893a = z2.f365865a.m1();
        DrawableIndicator r114 = this.f295884a.f319936c;
        if ((r114 instanceof View) == false) goto L26;
        r100.f464537b = true;
        r100.f464539d = r114;
    L26:
        Lifecycle r115 = this.f295885b;
        if (r115 == null) goto L29;
        r115.addObserver(this);
    L29:
        r100.b();
        r100.d(r101);
        return;
    L22:
        r100.setBannerAutoPlay(false);
        goto L23
    L11:
        if (Intrinsics.areEqual(r101, r100.getData()) == false) goto L13;
    }

    public BannerItemViewHolder(LarusItemBannerBinding r100, Lifecycle r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "viewBinding");
        Intrinsics.checkNotNullParameter(r102, "parent");
        super(r100);
        this.f295884a = r100;
        this.f295885b = r101;
        this.f295886c = r102;
        this.f295888e = LazyKt.lazy(new g());
    }
}
