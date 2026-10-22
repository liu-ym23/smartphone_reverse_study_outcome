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
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LandscapeCommentPresenter {
    public static final float h = 0.0f;
    public final ViewGroup a;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b b;
    public final CommentPageParam c;
    public boolean d;
    public CommentListView e;
    public View f;
    public final long g;

    public static final class a {
    }

    public static final class b implements Animation.AnimationListener {
        public final /* synthetic */ LandscapeCommentPresenter a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public b(LandscapeCommentPresenter r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            ViewGroup r3 = this.a.a;
            r3.removeView(r3.findViewWithTag(LandscapeCommentPresenter.class));
            this.a.d = false;
        }
    }

    static {
        Resources r1 = Resources.getSystem();
        h = TypedValue.applyDimension(1, 390, WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()));
    }

    public final void a() {
        if (this.d == true) goto L5;
        return;
    L5:
        View r0 = this.f;
        if (r0 != null) goto L8;
        return;
    L8:
        TranslateAnimation r1 = new TranslateAnimation(0.0f, h, 0.0f, 0.0f);
        int r2 = 0;
        r1.setFillBefore(false);
        r1.setFillAfter(true);
        r1.setAnimationListener(new b(this));
        r0.startAnimation(r1);
        CommentListView r3 = this.e;
        if (r3 == null) goto L11;
        r2 = r3.getMaxConsumeMainCommentCount();
    L11:
        long r4 = SystemClock.elapsedRealtime();
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("enter_from", this.c.g);
        r5.put("author_openid", this.c.b);
        r5.put("group_id", this.c.a);
        r5.put("impr_id", this.c.h);
        r5.put("consume_count", Integer.valueOf(r2));
        r5.put("duration", Long.valueOf(r4 - this.g));
        CommentPageParam r6 = this.c;
        if (r6 == null) goto L19;
        Map<String, Object> r7 = r6.v;
        if (r7 == null) goto L19;
        Iterator<Map.Entry<String, Object>> r8 = r7.entrySet().iterator();
    L17:
        if (r8.hasNext() == false) goto L19;
        Map.Entry<String, Object> r9 = r8.next();
        r5.put(r9.getKey(), r9.getValue());
    L19:
        AosEventReporter.s(AosEventReporter.a, "close_comment", r5, null, null, null, 28);
    }

    public final void b() {
        View r0 = LayoutInflater.from(this.a.getContext()).inflate(2131558621, this.a, false);
        CommentListView r1 = (CommentListView) r0.findViewById(2131367388);
        this.e = r1;
        if (r1 == null) goto L5;
        r1.t(this.c, null);
    L5:
        CommentListView r2 = this.e;
        if (r2 == null) goto L8;
        r2.setPageOwner(this.b);
    L8:
        CommentListView r3 = this.e;
        if (r3 == null) goto L11;
        r3.setCloseCommentButton(new LandscapeCommentPresenter$init$1(this));
    L11:
        r0.setOnClickListener(new com.bytedance.awemeopen.apps.framework.landscape.b(this));
        r0.setTag(LandscapeCommentPresenter.class);
        this.f = r0;
    }

    public LandscapeCommentPresenter(ViewGroup r2, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r3, CommentPageParam r4) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "pageOwner");
        Intrinsics.checkNotNullParameter(r4, "commentPageParam");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.g = -1;
    }
}
