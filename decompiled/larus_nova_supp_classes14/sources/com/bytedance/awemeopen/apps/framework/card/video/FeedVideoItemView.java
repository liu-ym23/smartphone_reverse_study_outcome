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
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class FeedVideoItemView implements p44.b {
    public static final /* synthetic */ int u = 0;
    public final Activity a;
    public final ViewGroup b;
    public final l54.a c;
    public final com.bytedance.awemeopen.apps.framework.card.video.a d;
    public final com.bytedance.awemeopen.apps.framework.card.video.a e;
    public final String f;
    public final j g;
    public final SingleVideoSeekBarHelper h;
    public final DmtStatusView i;
    public final View j;
    public final FrameLayout k;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.c l;
    public final VideoCardPreRender m;
    public final VideoFeedViewHolder n;
    public final c o;
    public final d p;
    public final HostCommonParamProvider q;
    public final e r;
    public final Lazy s;
    public r14.c t;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AutoPlayAction.values().length];
            r0[AutoPlayAction.STOP_AUTOPLAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AutoPlayAction.REOPEN_AUTOPLAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static final boolean a(FeedVideoItemView r1) {
        if (r1.b.getMeasuredWidth() > 0) goto L5;
    L7:
        return false;
    L5:
        if (r1.b.getMeasuredHeight() <= 0) goto L7;
        return true;
    }

    public static void d(boolean r3) {
        AoLogger.b("FeedViewItemView", new Object[]{"set hasDialogInterruptAutoPlay " + r3});
    }

    public final void c(final r14.c r7, int r8) {
        AoLogger.b("FeedViewItemView", new Object[]{this.f + " doBind"});
        this.t = r7;
        this.d.b();
        if (this.j.getParent() != null) goto L6;
        this.k.addView(this.j, 0);
    L6:
        if (AosExtConfig.b.getCommentConfig().c == false) goto L9;
        this.c.getClass();
        View r1 = LayoutInflater.from(this.a).inflate(2131558591, null);
        x54.b.d(r1);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-1, this.l.e.h);
        r3.gravity = 80;
        this.k.addView(r1, r3);
        final WriteCommentEntranceView r2 = new WriteCommentEntranceView(this.k, new i(this));
        r2.d();
        r2.f(this.l.e, true);
        ViewGroup.LayoutParams r0 = this.j.getLayoutParams();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r0;
        r4.bottomMargin = r3.height;
        this.j.setLayoutParams(r4);
        this.k.post(new f(this, r7, r2));
    L9:
        this.h.i(r7);
        this.h.e();
        this.g.c = this.h;
        this.c.getClass();
        this.c.getClass();
        jz3.a r5 = new jz3.a(r7, null, null);
        r5.d = r8;
        this.n.c(r5, r8);
    }

    /* JADX WARN: Type inference failed for: r2v20, types: [com.bytedance.awemeopen.apps.framework.card.video.c] */
    /* JADX WARN: Type inference failed for: r2v21, types: [com.bytedance.awemeopen.apps.framework.card.video.d] */
    /* JADX WARN: Type inference failed for: r2v23, types: [com.bytedance.awemeopen.apps.framework.card.video.e] */
    public FeedVideoItemView(Activity r23, ViewGroup r24, l54.a r25) {
        Intrinsics.checkNotNullParameter(r23, "activity");
        Intrinsics.checkNotNullParameter(r24, "parentView");
        Intrinsics.checkNotNullParameter(r25, "videoCardConfig");
        this.a = r23;
        this.b = r24;
        this.c = r25;
        this.d = new com.bytedance.awemeopen.apps.framework.card.video.a();
        this.e = new com.bytedance.awemeopen.apps.framework.card.video.a();
        this.f = "";
        if (r25.i == false) goto L5;
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
        ViewModelProviderFactory r7 = ViewModelProviderFactory.a;
        r7.getClass();
        VideoCardPlayerViewModel r2 = (VideoCardPlayerViewModel) new ViewModelProvider((ViewModelStoreOwner) r23, r7).get(VideoCardPlayerViewModel.class);
    L6:
        VideoCardPlayerViewModel r12 = r2;
        j r13 = new j(r25, r12);
        this.g = r13;
        Intrinsics.checkNotNullParameter(r13.getPlayer(), "player");
        SingleVideoSeekBarHelper r14 = new SingleVideoSeekBarHelper(new WeakReference(this.a), r13.a(), false, 4);
        this.h = r14;
        final DmtStatusView r15 = new DmtStatusView(r23);
        DmtStatusView.a r1 = DmtStatusView.a.a(r23);
        AosDefaultNetErrorView r3 = new AosDefaultNetErrorView(r23);
        r3.b();
        r3.findViewById(2131384465).setOnClickListener(new com.bytedance.awemeopen.apps.framework.card.video.b(r15, this));
        Unit r6 = Unit.INSTANCE;
        r1.d(r3);
        r15.setBuilder(r1);
        this.i = r15;
        LayoutInflater r4 = LayoutInflater.from(r23);
        int r5 = VideoFeedViewHolder.p;
        View r9 = r4.inflate(2131558665, null);
        this.j = r9;
        FrameLayout r8 = new FrameLayout(r23);
        this.k = r8;
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        LifecycleOwner r10 = (LifecycleOwner) r23;
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
        ViewModelStoreOwner r17 = (ViewModelStoreOwner) r23;
        Map r18 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_card_mode", CommentScene.COMMENTSCENE_NO_AWEME)});
        AosExtConfig r19 = AosExtConfig.b;
        if (r19.getCommentConfig().c == false) goto L9;
        Resources r11 = Resources.getSystem();
        int r20 = MathKt.roundToInt(TypedValue.applyDimension(1, 56, WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics())));
    L10:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.c r16 = new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.c(r9, r24, r13, r23, new com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b(r23, r24, r24, r10, r17, r18, r20, 32), r19.p2(), new FeedVideoItemView$parameters$1(this));
        this.l = r16;
        VideoCardPreRender r21 = new VideoCardPreRender(r12.getFeedPlayerHelper().e());
        this.m = r21;
        this.n = new VideoFeedViewHolder(r16, r14, new p(), r21);
        this.o = new c(this);
        this.p = new d(this);
        this.q = new HostCommonParamProvider(r13.a.g.getHostCommonParams());
        this.r = new e(this);
        this.s = LazyKt.lazy(FeedVideoItemView$enableHostExpand$2.INSTANCE);
        r8.addView(r15);
        r8.setBackgroundColor(-16777216);
        r14.h(r8, r16.e.h);
        return;
    L9:
        r20 = 0;
        goto L10
    L5:
        r2 = new VideoCardPlayerViewModel(null, 1, null);
        goto L6
    }

    public static final void b(FeedVideoItemView r5, r14.c r6, int r7) {
        r5.getClass();
        AoLogger.b("FeedViewItemView", new Object[]{r5.f + " resumePendingState " + r5.e});
        com.bytedance.awemeopen.apps.framework.card.video.a r1 = r5.e;
        if (r1.a != 2) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L15;
        r5.c(r6, r7);
        d14.a r8 = b14.a.a;
        b14.a.a(t24.a.class).H1(r5.q);
        b14.a.a(t24.a.class).H1(r5.r);
        d(false);
        if (r5.d.a() == false) goto L11;
        r5.d.b();
        r5.n.i();
        r5.g.observeCommentShowState(r5.l.e.d, r5.p);
        LiveDataBus r9 = LiveDataBus.c;
        LiveDataBus.a.a(gz3.a.class).observe(r5.l.e.d, r5.o);
    L13:
        r5.m.c = true;
    L17:
        r5.e.a = 0;
        return;
    L11:
        if (r5.e.a() == false) goto L13;
        r5.e.b();
        goto L13
    L15:
        if (r1.a() == false) goto L17;
        r5.c(r6, r7);
        goto L17
    L5:
        r2 = false;
        goto L6
    }
}
