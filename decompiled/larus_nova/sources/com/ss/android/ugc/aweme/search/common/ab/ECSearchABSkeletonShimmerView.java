package com.ss.android.ugc.aweme.search.common.ab;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ab/ECSearchABSkeletonShimmerView;", "Landroid/view/View;", "Landroid/animation/Animator;", "getShimmerAnimation", "", RemoteMessageConst.Notification.VISIBILITY, "", "setVisibility", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchABSkeletonShimmerView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f451400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f451401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f451402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinearGradient f451403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f451404e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f451405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f451406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f451407h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ObjectAnimator f451408i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ECSearchABSkeletonShimmerView$startAnimation$1 f451409j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f451410k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ab/ECSearchABSkeletonShimmerView$Companion;", "", "()V", "DEFAULT_ANGLE", "", "DEFAULT_CENTER_COLOR_X_POSITION", "", "DEFAULT_DURATION", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public ECSearchABSkeletonShimmerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECSearchABSkeletonShimmerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        if (this.f451406g > 0) goto L6;
        this.f451406g = this.f451405f + ((int) (((float) Math.tan(Math.toRadians(this.f451401b))) * getHeight()));
    L6:
        if (this.f451407h > 0) goto L9;
        this.f451407h = getHeight();
        return;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.ss.android.ugc.aweme.search.common.ab.ECSearchABSkeletonShimmerView$startAnimation$1] */
    public final void b() {
        if (this.f451410k == false) goto L8;
        if (getVisibility() != 0) goto L8;
        return;
    L8:
        if (getWidth() != 0) goto L11;
        this.f451409j = new ECSearchABSkeletonShimmerView$startAnimation$1(this);
        getViewTreeObserver().addOnPreDrawListener(this.f451409j);
        return;
    L11:
        this.f451410k = true;
        getShimmerAnimation().start();
    }

    public final void c() {
        ECSearchABSkeletonShimmerView$startAnimation$1 r100 = this.f451409j;
        if (r100 == null) goto L5;
        getViewTreeObserver().removeOnPreDrawListener(r100);
    L5:
        ObjectAnimator r101 = this.f451408i;
        if (r101 == null) goto L8;
        r101.end();
    L8:
        this.f451410k = false;
    }

    private final Animator getShimmerAnimation() {
        a();
        ObjectAnimator r100 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{this.f451406g * (-1.0f), getWidth() * 1.0f});
        r100.setDuration(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
        r100.setRepeatCount(-1);
        this.f451408i = r100;
        return r100;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        a();
        if (this.f451403d != null) goto L5;
        float r100 = ((float) Math.cos(Math.toRadians(this.f451401b))) * this.f451405f;
        LinearGradient r101 = new LinearGradient(0.0f, getHeight(), ((float) Math.cos(Math.toRadians(this.f451401b))) * r100, (((float) Math.sin(Math.toRadians(this.f451401b))) * r100) + getHeight(), this.f451400a, this.f451402c, Shader.TileMode.CLAMP);
        this.f451403d = r101;
        this.f451404e.setShader(r101);
    L5:
        r110.drawRect(0.0f, 0.0f, this.f451406g, this.f451407h, this.f451404e);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(r100);
        if (r100 != 0) goto L5;
        b();
        return;
    L5:
        c();
    }

    public ECSearchABSkeletonShimmerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f451400a = new int[]{1447971, 85334051, 1447971};
        float[] r103 = {0.0f, 0.5f, 1.0f};
        this.f451402c = r103;
        this.f451404e = new Paint();
        this.f451401b = 20;
        r103[1] = 0.5f;
        this.f451405f = DimenExtensionsKt.b(210);
        addOnAttachStateChangeListener(new AnonymousClass1(this));
    }

    public /* synthetic */ ECSearchABSkeletonShimmerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
