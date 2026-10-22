package com.larus.bmhome.banner;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBindings;
import bb8.d;
import bb8.i;
import by7.e;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ixigua.lib.track.TrackParams;
import com.larus.business.banner.databinding.LarusItemBannerSingleBinding;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.t0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.zhpan.bannerview.BaseBannerAdapter;
import com.zhpan.bannerview.BaseViewHolder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u00012B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 2\u0006\u0010\u0005\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J0\u0010&\u001a\u00020\u00192\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020 2\b\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020%H\u0014J$\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010#H\u0002J\u0010\u00101\u001a\u00020%2\u0006\u0010$\u001a\u00020%H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016¨\u00063"}, d2 = {"Lcom/larus/bmhome/banner/BannerAdapter;", "Lcom/zhpan/bannerview/BaseBannerAdapter;", "Lcom/larus/bmhome/banner/BannerModel;", "Lcom/ixigua/lib/track/ITrackNode;", "Landroidx/lifecycle/LifecycleEventObserver;", "parent", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "<init>", "(Lcom/ixigua/lib/track/ITrackNode;Landroidx/lifecycle/Lifecycle;)V", "getParent", "()Lcom/ixigua/lib/track/ITrackNode;", "isNeedPlayGif", "", "enableBannerOpt", "getEnableBannerOpt", "()Z", "enableBannerOpt$delegate", "Lkotlin/Lazy;", "delayRefreshTask", "Ljava/lang/Runnable;", "getDelayRefreshTask", "()Ljava/lang/Runnable;", "delayRefreshTask$delegate", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "parentTrackNode", "createViewHolder", "Lcom/zhpan/bannerview/BaseViewHolder;", "Landroid/view/ViewGroup;", "itemView", "Landroid/view/View;", "viewType", "", "bindData", "holder", "data", "position", "pageSize", "handleBannerClickForOpenVideo", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bannerSchema", "", "animateView", "getLayoutId", "Companion", "banner_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BannerAdapter extends BaseBannerAdapter<i> implements e, LifecycleEventObserver {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f295873h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f295874i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f295875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lifecycle f295876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f295877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f295878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f295879g;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f295880a = null;

        static {
            int[] r100 = new int[Lifecycle.Event.values().length];
            r100[Lifecycle.Event.ON_RESUME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f295880a = r100;
        }
    }

    @Override // by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
    }

    @Override // com.zhpan.bannerview.BaseBannerAdapter
    public final int getLayoutId(int r100) {
        return R.layout.larus_item_banner_single;
    }

    static {
        int r100 = com.larus.utils.i.d(AppHost.f326268a.getApplication()) - i5.y0(c.b(R.attr.larus_dp_32, null, R.dimen.larus_dp_32));
        f295873h = r100;
        f295874i = (r100 * 2) / 5;
    }

    @Override // by7.e
    public final e referrerTrackNode() {
        return e.a.a(this);
    }

    @Override // by7.e
    public final e parentTrackNode() {
        return this.f295875c;
    }

    public BannerAdapter(e r100, Lifecycle r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f295875c = r100;
        this.f295876d = r101;
        Lazy r102 = LazyKt.lazy(new bb8.c());
        this.f295878f = r102;
        this.f295879g = LazyKt.lazy(new d(this));
        if (((Boolean) r102.getValue()).booleanValue() == false) goto L7;
        if (r101 == null) goto L8;
        r101.addObserver(this);
        return;
    L8:
        return;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = b.f295880a[r101.ordinal()];
        if (r102 != 1) goto L5;
        this.f295877e = true;
        t0.f375468a.removeCallbacks((Runnable) this.f295879g.getValue());
        ((Runnable) this.f295879g.getValue()).run();
        return;
    L5:
        if (r102 != 2) goto L7;
        this.f295877e = false;
        t0.f375468a.postDelayed((Runnable) this.f295879g.getValue(), 1000);
        return;
    L7:
        if (r102 != 3) goto L18;
        this.f295877e = false;
        t0.f375468a.removeCallbacks((Runnable) this.f295879g.getValue());
        Lifecycle r103 = this.f295876d;
        if (r103 == null) goto L15;
        r103.removeObserver(this);
        return;
    L15:
        return;
    }

    @Override // com.zhpan.bannerview.BaseBannerAdapter
    public final BaseViewHolder z2(ViewGroup r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        SimpleDraweeView r102 = (SimpleDraweeView) ViewBindings.findChildViewById(r101, R.id.banner_image);
        if (r102 == null) goto L7;
        return new BannerViewBindingViewHolder(new LarusItemBannerSingleBinding((RelativeLayout) r101, r102));
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(R.id.banner_image)));
    }

    @Override // com.zhpan.bannerview.BaseBannerAdapter
    public final void y2(BaseViewHolder r100, Object r101, final int r102) {
        final i r103 = (i) r101;
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof BannerViewBindingViewHolder) == false) goto L10;
        BannerViewBindingViewHolder r104 = (BannerViewBindingViewHolder) r100;
        final SimpleDraweeView r105 = r104.f295892a.f319938b;
        if (r103 == null) goto L7;
        String r106 = r103.b();
    L8:
        ImageLoaderKt.y(r105, r106, "notification.banner", new bb8.a(r105, this), 4);
        r104.f295892a.f319938b.setOnClickListener(new bb8.b(this, r105, r103, r102));
        return;
    L7:
        r106 = null;
        goto L8
    }
}
