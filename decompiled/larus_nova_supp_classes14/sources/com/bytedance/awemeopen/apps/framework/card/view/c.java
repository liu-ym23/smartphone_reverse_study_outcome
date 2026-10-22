package com.bytedance.awemeopen.apps.framework.card.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.awemeopen.apps.framework.card.impression.AosImpressionRelativeLayout;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends AosImpressionRelativeLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;

    @Override // com.bytedance.awemeopen.apps.framework.card.impression.AosImpressionRelativeLayout
    public final void a(boolean r1) {
    }

    public final void setOnCardShowListener(com.bytedance.awemeopen.apps.framework.card.e r2) {
        Intrinsics.checkNotNullParameter(r2, "cardShowListener");
    }

    private final Drawable getLoadingRoundDrawable() {
        GradientDrawable r0 = new GradientDrawable();
        r0.setShape(0);
        Intrinsics.checkNotNullParameter("#0D161823", "<this>");
        r0.setColor(ColorProtector.parseColor("#0D161823"));
        Resources r2 = Resources.getSystem();
        r0.setCornerRadius(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics())));
        return r0;
    }

    private final TextView getVideoAuthorNameTv() {
        return (TextView) this.i.getValue();
    }

    private final View getVideoBottomInfoView() {
        return (View) this.h.getValue();
    }

    private final ImageView getVideoCloseIv() {
        return (ImageView) this.l.getValue();
    }

    private final TextView getVideoCommentOrPraiseCountTv() {
        return (TextView) this.j.getValue();
    }

    private final AoImageView getVideoCoverBorder() {
        return (AoImageView) this.d.getValue();
    }

    private final AoImageView getVideoCoverIv() {
        return (AoImageView) this.c.getValue();
    }

    private final RelativeLayout getVideoCoverRl() {
        return (RelativeLayout) this.b.getValue();
    }

    private final View getVideoDouyinTag() {
        return (View) this.e.getValue();
    }

    private final TextView getVideoDurationTv() {
        return (TextView) this.g.getValue();
    }

    private final View getVideoPlayIcon() {
        return (View) this.f.getValue();
    }

    private final TextView getVideoPublishTimeTv() {
        return (TextView) this.k.getValue();
    }

    private final TextView getVideoTitleTv() {
        return (TextView) this.a.getValue();
    }

    public c(Context r3) {
        Intrinsics.checkNotNullParameter(null, "cardConfig");
        new LinkedHashMap();
        super(r3);
        this.a = LazyKt.lazy(new AosMiddleVideoCardView$videoTitleTv$2(this));
        this.b = LazyKt.lazy(new AosMiddleVideoCardView$videoCoverRl$2(this));
        this.c = LazyKt.lazy(new AosMiddleVideoCardView$videoCoverIv$2(this));
        this.d = LazyKt.lazy(new AosMiddleVideoCardView$videoCoverBorder$2(this));
        this.e = LazyKt.lazy(new AosMiddleVideoCardView$videoDouyinTag$2(this));
        this.f = LazyKt.lazy(new AosMiddleVideoCardView$videoPlayIcon$2(this));
        this.g = LazyKt.lazy(new AosMiddleVideoCardView$videoDurationTv$2(this));
        this.h = LazyKt.lazy(new AosMiddleVideoCardView$videoBottomInfoView$2(this));
        this.i = LazyKt.lazy(new AosMiddleVideoCardView$videoAuthorNameTv$2(this));
        this.j = LazyKt.lazy(new AosMiddleVideoCardView$videoCommentOrPraiseCountTv$2(this));
        this.k = LazyKt.lazy(new AosMiddleVideoCardView$videoPublishTimeTv$2(this));
        this.l = LazyKt.lazy(new AosMiddleVideoCardView$videoCloseIv$2(this));
        if (r3 == null) goto L6;
        r3.getDrawable(2131231613);
        return;
    }

    public void setOnCardClickListener(u44.a r2) {
        Intrinsics.checkNotNullParameter(r2, "middleCardListener");
        setOnClickListener(new a(this));
        getVideoCloseIv().setOnClickListener(new b(this));
    }
}
