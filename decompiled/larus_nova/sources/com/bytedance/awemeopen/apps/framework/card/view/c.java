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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c extends AosImpressionRelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f193896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f193897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f193898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f193899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f193900e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f193901f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f193902g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f193903h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f193904i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f193905j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f193906k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f193907l;

    @Override // com.bytedance.awemeopen.apps.framework.card.impression.AosImpressionRelativeLayout
    public final void a(boolean r100) {
    }

    public final void setOnCardShowListener(com.bytedance.awemeopen.apps.framework.card.e r100) {
        Intrinsics.checkNotNullParameter(r100, "cardShowListener");
    }

    private final Drawable getLoadingRoundDrawable() {
        GradientDrawable r100 = new GradientDrawable();
        r100.setShape(0);
        Intrinsics.checkNotNullParameter("#0D161823", "<this>");
        r100.setColor(ColorProtector.parseColor("#0D161823"));
        Resources r101 = Resources.getSystem();
        r100.setCornerRadius(TypedValue.applyDimension(1, 4, WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics())));
        return r100;
    }

    private final TextView getVideoAuthorNameTv() {
        return (TextView) this.f193904i.getValue();
    }

    private final View getVideoBottomInfoView() {
        return (View) this.f193903h.getValue();
    }

    private final ImageView getVideoCloseIv() {
        return (ImageView) this.f193907l.getValue();
    }

    private final TextView getVideoCommentOrPraiseCountTv() {
        return (TextView) this.f193905j.getValue();
    }

    private final AoImageView getVideoCoverBorder() {
        return (AoImageView) this.f193899d.getValue();
    }

    private final AoImageView getVideoCoverIv() {
        return (AoImageView) this.f193898c.getValue();
    }

    private final RelativeLayout getVideoCoverRl() {
        return (RelativeLayout) this.f193897b.getValue();
    }

    private final View getVideoDouyinTag() {
        return (View) this.f193900e.getValue();
    }

    private final TextView getVideoDurationTv() {
        return (TextView) this.f193902g.getValue();
    }

    private final View getVideoPlayIcon() {
        return (View) this.f193901f.getValue();
    }

    private final TextView getVideoPublishTimeTv() {
        return (TextView) this.f193906k.getValue();
    }

    private final TextView getVideoTitleTv() {
        return (TextView) this.f193896a.getValue();
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(null, "cardConfig");
        new LinkedHashMap();
        super(r100);
        this.f193896a = LazyKt.lazy(new AosMiddleVideoCardView$videoTitleTv$2(this));
        this.f193897b = LazyKt.lazy(new AosMiddleVideoCardView$videoCoverRl$2(this));
        this.f193898c = LazyKt.lazy(new AosMiddleVideoCardView$videoCoverIv$2(this));
        this.f193899d = LazyKt.lazy(new AosMiddleVideoCardView$videoCoverBorder$2(this));
        this.f193900e = LazyKt.lazy(new AosMiddleVideoCardView$videoDouyinTag$2(this));
        this.f193901f = LazyKt.lazy(new AosMiddleVideoCardView$videoPlayIcon$2(this));
        this.f193902g = LazyKt.lazy(new AosMiddleVideoCardView$videoDurationTv$2(this));
        this.f193903h = LazyKt.lazy(new AosMiddleVideoCardView$videoBottomInfoView$2(this));
        this.f193904i = LazyKt.lazy(new AosMiddleVideoCardView$videoAuthorNameTv$2(this));
        this.f193905j = LazyKt.lazy(new AosMiddleVideoCardView$videoCommentOrPraiseCountTv$2(this));
        this.f193906k = LazyKt.lazy(new AosMiddleVideoCardView$videoPublishTimeTv$2(this));
        this.f193907l = LazyKt.lazy(new AosMiddleVideoCardView$videoCloseIv$2(this));
        if (r100 == null) goto L6;
        r100.getDrawable(R.drawable.aos_std_card_cover_bg);
        return;
    }

    public void setOnCardClickListener(u44.a r100) {
        Intrinsics.checkNotNullParameter(r100, "middleCardListener");
        setOnClickListener(new a(this));
        getVideoCloseIv().setOnClickListener(new b(this));
    }
}
