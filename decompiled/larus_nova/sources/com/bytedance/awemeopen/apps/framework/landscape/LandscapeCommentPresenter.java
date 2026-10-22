package com.bytedance.awemeopen.apps.framework.landscape;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.bytedance.awemeopen.apps.framework.comment.CommentListView;
import com.bytedance.awemeopen.apps.framework.comment.CommentPageParam;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class LandscapeCommentPresenter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final float f197076h = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f197077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b f197078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CommentPageParam f197079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f197080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CommentListView f197081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f197082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f197083g;

    public static final class a {
    }

    public static final class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LandscapeCommentPresenter f197084a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r100) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r100) {
        }

        public b(LandscapeCommentPresenter r100) {
            this.f197084a = r100;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r100) {
            ViewGroup r101 = this.f197084a.f197077a;
            r101.removeView(r101.findViewWithTag(LandscapeCommentPresenter.class));
            this.f197084a.f197080d = false;
        }
    }

    static {
        float r100 = MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS;
        Resources r101 = Resources.getSystem();
        f197076h = TypedValue.applyDimension(1, r100, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()));
    }

    public final void a() {
        if (this.f197080d == true) goto L5;
        return;
    L5:
        View r100 = this.f197082f;
        if (r100 != null) goto L8;
        return;
    L8:
        TranslateAnimation r101 = new TranslateAnimation(0.0f, f197076h, 0.0f, 0.0f);
        int r102 = 0;
        r101.setFillBefore(false);
        r101.setFillAfter(true);
        r101.setAnimationListener(new b(this));
        r100.startAnimation(r101);
        CommentListView r103 = this.f197081e;
        if (r103 == null) goto L11;
        r102 = r103.getMaxConsumeMainCommentCount();
    L11:
        long r104 = SystemClock.elapsedRealtime();
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("enter_from", this.f197079c.f194081g);
        r105.put("author_openid", this.f197079c.f194076b);
        r105.put("group_id", this.f197079c.f194075a);
        r105.put("impr_id", this.f197079c.f194082h);
        r105.put("consume_count", Integer.valueOf(r102));
        r105.put("duration", Long.valueOf(r104 - this.f197083g));
        CommentPageParam r106 = this.f197079c;
        if (r106 == null) goto L19;
        Map<String, Object> r107 = r106.f194096v;
        if (r107 == null) goto L19;
        Iterator<Map.Entry<String, Object>> r108 = r107.entrySet().iterator();
    L17:
        if (r108.hasNext() == false) goto L19;
        Map.Entry<String, Object> r109 = r108.next();
        r105.put(r109.getKey(), r109.getValue());
    L19:
        AosEventReporter.s(AosEventReporter.f194596a, "close_comment", r105, null, null, null, 28);
    }

    public final void b() {
        View r100 = LayoutInflater.from(this.f197077a.getContext()).inflate(R.layout.aos_dialog_landscape_comment, this.f197077a, false);
        CommentListView r101 = (CommentListView) r100.findViewById(R.id.comment_list_view);
        this.f197081e = r101;
        if (r101 == null) goto L5;
        r101.t(this.f197079c, null);
    L5:
        CommentListView r102 = this.f197081e;
        if (r102 == null) goto L8;
        r102.setPageOwner(this.f197078b);
    L8:
        CommentListView r103 = this.f197081e;
        if (r103 == null) goto L11;
        r103.setCloseCommentButton(new LandscapeCommentPresenter$init$1(this));
    L11:
        r100.setOnClickListener(new com.bytedance.awemeopen.apps.framework.landscape.b(this));
        r100.setTag(LandscapeCommentPresenter.class);
        this.f197082f = r100;
    }

    public LandscapeCommentPresenter(ViewGroup r100, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r101, CommentPageParam r102) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "pageOwner");
        Intrinsics.checkNotNullParameter(r102, "commentPageParam");
        this.f197077a = r100;
        this.f197078b = r101;
        this.f197079c = r102;
        this.f197083g = -1;
    }
}
