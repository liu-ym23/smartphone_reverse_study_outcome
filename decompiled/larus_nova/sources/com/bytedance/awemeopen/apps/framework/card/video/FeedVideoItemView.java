package com.bytedance.awemeopen.apps.framework.card.video;

import android.app.Activity;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtStatusView;
import com.bytedance.awemeopen.apps.framework.comment.write.WriteCommentEntranceView;
import com.bytedance.awemeopen.apps.framework.event.AutoPlayAction;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p;
import com.bytedance.awemeopen.apps.framework.feed.pages.recommend.holder.VideoFeedViewHolder;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.SingleVideoSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;
import com.bytedance.awemeopen.apps.framework.framework.extension.ViewModelProviderFactory;
import com.bytedance.awemeopen.apps.framework.framework.viewpager.AosDefaultNetErrorView;
import com.bytedance.awemeopen.apps.framework.utils.reporter.HostCommonParamProvider;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes14.dex */
public final class FeedVideoItemView implements p44.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f193835u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f193836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f193837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l54.a f193838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.card.video.a f193839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.card.video.a f193840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f193841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f193842g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SingleVideoSeekBarHelper f193843h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DmtStatusView f193844i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f193845j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FrameLayout f193846k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.c f193847l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final VideoCardPreRender f193848m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final VideoFeedViewHolder f193849n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f193850o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f193851p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HostCommonParamProvider f193852q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final e f193853r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f193854s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public r14.c f193855t;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f193856a = null;

        static {
            int[] r100 = new int[AutoPlayAction.values().length];
            r100[AutoPlayAction.STOP_AUTOPLAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[AutoPlayAction.REOPEN_AUTOPLAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f193856a = r100;
        }
    }

    static {
    }

    public static final boolean a(FeedVideoItemView r100) {
        if (r100.f193837b.getMeasuredWidth() > 0) goto L5;
    L7:
        return false;
    L5:
        if (r100.f193837b.getMeasuredHeight() <= 0) goto L7;
        return true;
    }

    public static void d(boolean r100) {
        AoLogger.b("FeedViewItemView", new Object[]{"set hasDialogInterruptAutoPlay " + r100});
    }

    public final void c(final r14.c r100, int r101) {
        AoLogger.b("FeedViewItemView", new Object[]{this.f193841f + " doBind"});
        this.f193855t = r100;
        this.f193839d.b();
        if (this.f193845j.getParent() != null) goto L6;
        this.f193846k.addView(this.f193845j, 0);
    L6:
        if (AosExtConfig.f193138b.getCommentConfig().f1843c == false) goto L9;
        this.f193838c.getClass();
        View r102 = LayoutInflater.from(this.f193836a).inflate(R.layout.aos_bottom_write_comment_view, null);
        x54.b.d(r102);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-1, this.f193847l.f195165e.f195176h);
        r103.gravity = 80;
        this.f193846k.addView(r102, r103);
        final WriteCommentEntranceView r104 = new WriteCommentEntranceView(this.f193846k, new i(this));
        r104.d();
        r104.f(this.f193847l.f195165e, true);
        ViewGroup.LayoutParams r105 = this.f193845j.getLayoutParams();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        r106.bottomMargin = r103.height;
        this.f193845j.setLayoutParams(r106);
        this.f193846k.post(new f(this, r100, r104));
    L9:
        this.f193843h.i(r100);
        this.f193843h.e();
        this.f193842g.f193877c = this.f193843h;
        this.f193838c.getClass();
        this.f193838c.getClass();
        jz3.a r107 = new jz3.a(r100, null, null);
        r107.f501176d = r101;
        this.f193849n.c(r107, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v20, types: [com.bytedance.awemeopen.apps.framework.card.video.c] */
    /* JADX WARN: Type inference failed for: r2v21, types: [com.bytedance.awemeopen.apps.framework.card.video.d] */
    /* JADX WARN: Type inference failed for: r2v23, types: [com.bytedance.awemeopen.apps.framework.card.video.e] */
    public FeedVideoItemView(Activity r210, ViewGroup r211, l54.a r212) {
        Intrinsics.checkNotNullParameter(r210, "activity");
        Intrinsics.checkNotNullParameter(r211, "parentView");
        Intrinsics.checkNotNullParameter(r212, "videoCardConfig");
        this.f193836a = r210;
        this.f193837b = r211;
        this.f193838c = r212;
        this.f193839d = new com.bytedance.awemeopen.apps.framework.card.video.a();
        this.f193840e = new com.bytedance.awemeopen.apps.framework.card.video.a();
        this.f193841f = "";
        if (r212.f507509i == false) goto L5;
        Intrinsics.checkNotNull(r210, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
        ViewModelProviderFactory r100 = ViewModelProviderFactory.f196951a;
        r100.getClass();
        VideoCardPlayerViewModel r101 = (VideoCardPlayerViewModel) new ViewModelProvider((ViewModelStoreOwner) r210, r100).get(VideoCardPlayerViewModel.class);
    L6:
        VideoCardPlayerViewModel r110 = r101;
        j r111 = new j(r212, r110);
        this.f193842g = r111;
        Intrinsics.checkNotNullParameter(r111.getPlayer(), "player");
        SingleVideoSeekBarHelper r112 = new SingleVideoSeekBarHelper(new WeakReference(this.f193836a), r111.a(), false, 4);
        this.f193843h = r112;
        final DmtStatusView r113 = new DmtStatusView(r210);
        DmtStatusView.a r102 = DmtStatusView.a.a(r210);
        AosDefaultNetErrorView r103 = new AosDefaultNetErrorView(r210);
        r103.b();
        r103.findViewById(R.id.retry_btn).setOnClickListener(new com.bytedance.awemeopen.apps.framework.card.video.b(r113, this));
        Unit r104 = Unit.INSTANCE;
        r102.d(r103);
        r113.setBuilder(r102);
        this.f193844i = r113;
        LayoutInflater r105 = LayoutInflater.from(r210);
        int r106 = VideoFeedViewHolder.f195118p;
        View r107 = r105.inflate(R.layout.aos_item_feeditem_video_page, null);
        this.f193845j = r107;
        FrameLayout r108 = new FrameLayout(r210);
        this.f193846k = r108;
        Intrinsics.checkNotNull(r210, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        LifecycleOwner r109 = (LifecycleOwner) r210;
        Intrinsics.checkNotNull(r210, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
        ViewModelStoreOwner r114 = (ViewModelStoreOwner) r210;
        Map r115 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_card_mode", "1")});
        AosExtConfig r116 = AosExtConfig.f193138b;
        if (r116.getCommentConfig().f1843c == false) goto L9;
        Resources r117 = Resources.getSystem();
        int r213 = MathKt.roundToInt(TypedValue.applyDimension(1, 56, WindowDisplayMetricsOverride.apply(r117, r117.getDisplayMetrics())));
    L10:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.c r118 = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.c(r107, r211, r111, r210, new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b(r210, r211, r211, r109, r114, r115, r213, 32), r116.p2(), new FeedVideoItemView$parameters$1(this));
        this.f193847l = r118;
        VideoCardPreRender r119 = new VideoCardPreRender(r110.getFeedPlayerHelper().e());
        this.f193848m = r119;
        this.f193849n = new VideoFeedViewHolder(r118, r112, new p(), r119);
        this.f193850o = new c(this);
        this.f193851p = new d(this);
        this.f193852q = new HostCommonParamProvider(r111.f193875a.f507507g.getHostCommonParams());
        this.f193853r = new e(this);
        this.f193854s = LazyKt.lazy(FeedVideoItemView$enableHostExpand$2.INSTANCE);
        r108.addView(r113);
        r108.setBackgroundColor(-16777216);
        r112.h(r108, r118.f195165e.f195176h);
        return;
    L9:
        r213 = 0;
        goto L10
    L5:
        r101 = new VideoCardPlayerViewModel(null, 1, null);
        goto L6
    }

    public static final void b(FeedVideoItemView r100, r14.c r101, int r102) {
        r100.getClass();
        AoLogger.b("FeedViewItemView", new Object[]{r100.f193841f + " resumePendingState " + r100.f193840e});
        com.bytedance.awemeopen.apps.framework.card.video.a r103 = r100.f193840e;
        if (r103.f193860a != 2) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L15;
        r100.c(r101, r102);
        d14.a r105 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).H1(r100.f193852q);
        ((t24.a) b14.a.a(t24.a.class)).H1(r100.f193853r);
        d(false);
        if (r100.f193839d.a() == false) goto L11;
        r100.f193839d.b();
        r100.f193849n.i();
        r100.f193842g.observeCommentShowState(r100.f193847l.f195165e.f195172d, r100.f193851p);
        LiveDataBus r106 = LiveDataBus.f196946c;
        LiveDataBus.a.a(gz3.a.class).observe(r100.f193847l.f195165e.f195172d, r100.f193850o);
    L13:
        r100.f193848m.f193859c = true;
    L17:
        r100.f193840e.f193860a = 0;
        return;
    L11:
        if (r100.f193840e.a() == false) goto L13;
        r100.f193840e.b();
        goto L13
    L15:
        if (r103.a() == false) goto L17;
        r100.c(r101, r102);
        goto L17
    L5:
        r104 = false;
        goto L6
    }
}
