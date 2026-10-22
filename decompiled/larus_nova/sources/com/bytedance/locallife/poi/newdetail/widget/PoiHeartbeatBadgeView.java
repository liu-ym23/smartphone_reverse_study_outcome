package com.bytedance.locallife.poi.newdetail.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.lighten.core.ScaleType;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.dito.utils.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import df6.q;
import df6.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/PoiHeartbeatBadgeView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiHeartbeatBadgeView extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f263309f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f263310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f263311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SmartImageView f263312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SmartImageView f263313d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SmartImageView f263314e;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiHeartbeatBadgeView f263315a;

        public a(PoiHeartbeatBadgeView r100) {
            this.f263315a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            SmartImageView r101 = this.f263315a.f263312c;
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
            r101.setScaleX(((Float) r102).floatValue());
            Object r103 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Float");
            r101.setScaleY(((Float) r103).floatValue());
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiHeartbeatBadgeView f263316a;

        public b(PoiHeartbeatBadgeView r100) {
            this.f263316a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            PoiHeartbeatBadgeView r101 = this.f263316a;
            int r102 = PoiHeartbeatBadgeView.f263309f;
            r101.getClass();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            PoiHeartbeatBadgeView r101 = this.f263316a;
            int r102 = PoiHeartbeatBadgeView.f263309f;
            r101.getClass();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            PoiHeartbeatBadgeView r101 = this.f263316a;
            int r102 = PoiHeartbeatBadgeView.f263309f;
            r101.getClass();
        }
    }

    public PoiHeartbeatBadgeView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiHeartbeatBadgeView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void b(int r100) {
        if (r100 == 9) goto L7;
        this.f263311b = true;
        return;
    L7:
        if (this.f263310a == false) goto L9;
    L10:
        this.f263310a = false;
        this.f263311b = false;
        ValueAnimator r101 = ValueAnimator.ofFloat(new float[]{1.0f, 1.05f, 1.0f});
        r101.setDuration(666);
        r101.addUpdateListener(new a(this));
        r101.addListener(new b(this));
        r101.start();
        return;
    L9:
        if (this.f263311b == true) goto L10;
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "badgeUrl");
        Intrinsics.checkNotNullParameter(r101, "backgroundUrl");
        u r102 = q.e(r100);
        r102.f468288n = ScaleType.FIT_XY;
        r102.f468294t = this.f263312c;
        r102.c();
        u r103 = q.e(r101);
        r103.f468294t = this.f263314e;
        r103.c();
    }

    public PoiHeartbeatBadgeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f263310a = true;
        this.f263311b = true;
        SmartImageView r103 = new SmartImageView(r100);
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams((int) xo6.b.a(76), (int) xo6.b.a(76));
        r104.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        r104.bottomMargin = (int) xo6.b.a(14);
        r104.setMarginEnd((int) xo6.b.a(18));
        r103.setLayoutParams(r104);
        addView(r103);
        this.f263312c = r103;
        SmartImageView r105 = new SmartImageView(r100);
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams((int) xo6.b.a(66), (int) xo6.b.a(66));
        r106.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        r106.bottomMargin = (int) xo6.b.a(19);
        r106.setMarginEnd((int) xo6.b.a(23));
        r105.setLayoutParams(r106);
        r105.setBackground(o.a(PoiHeartbeatBadgeView$blurImage$1$2.INSTANCE));
        addView(r105);
        bringChildToFront(r103);
        this.f263313d = r105;
        SmartImageView r107 = new SmartImageView(r100);
        FrameLayout.LayoutParams r108 = new FrameLayout.LayoutParams((int) xo6.b.a(110), (int) xo6.b.a(122));
        r108.gravity = GravityCompat.END;
        r107.setLayoutParams(r108);
        addView(r107, 0);
        this.f263314e = r107;
    }

    public /* synthetic */ PoiHeartbeatBadgeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
