package com.bytedance.locallife.live.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.locallife.live.util.j0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import com.ttnet.org.chromium.base.BaseSwitches;
import df6.q;
import df6.u;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0001JB'\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u0012\b\b\u0002\u0010F\u001a\u00020\n¢\u0006\u0004\bG\u0010HJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018J \u0010\u001e\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00142\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001cJ\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u0012\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00108R\u0016\u0010:\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00100R\u0016\u0010;\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u00100R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006K"}, d2 = {"Lcom/bytedance/locallife/live/view/LiveLifeAtmosphereAnimView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnAttachStateChangeListener;", "Ldf6/o;", "imageInfo", "", "changeImageSize", "startAnim", "changeBack", "startTvAnim", "", "currentNum", "setTextWithAnimator", "checkWidthScale", "checkAndSetNumText", "", "view", "changeClip", "animType", "changeAnimType", "", "textBig", "setText", "num", "", "needResetNumber", "setNum", "uri", "", "urlList", "setIcon", "Landroid/view/View;", BaseSwitches.V, "onViewAttachedToWindow", "onViewDetachedFromWindow", "Landroid/view/ViewGroup;", "content", "Landroid/view/ViewGroup;", "Lcom/bytedance/lighten/loader/SmartImageView;", "ivAnim", "Lcom/bytedance/lighten/loader/SmartImageView;", "Landroid/widget/TextView;", "tvSmall", "Landroid/widget/TextView;", "tvBig", "Landroid/widget/LinearLayout;", "layoutTv", "Landroid/widget/LinearLayout;", "I", "Ljava/lang/Runnable;", "smallBellRunnable", "Ljava/lang/Runnable;", "Lcom/bytedance/locallife/live/view/m;", "numCalculator", "Lcom/bytedance/locallife/live/view/m;", "isAnimating", "Z", "isAnimatorLoadFinish", "animWidth", "animHeight", "Landroid/animation/AnimatorSet;", "animatorSet", "Landroid/animation/AnimatorSet;", "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;", "animatedDrawable2", "Lcom/facebook/fresco/animation/drawable/AnimatedDrawable2;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public class LiveLifeAtmosphereAnimView extends FrameLayout implements View.OnAttachStateChangeListener {
    public static final String BG_FLAMES = "#CCFFB11A";
    public static final String BG_FLAMES_CENTER = "#99FFB11A";
    public static final String BG_MEDAL = "#CCF18827";
    public static final String BG_MEDAL_CENTER = "#99F18827";
    public static final float BG_RADIUS = 12.0f;
    public static final String BG_SMALL_BELL = "#CCFF45B5";
    public static final String BG_SMALL_BELL_CENTER = "#B2FF45B5";
    public static final a Companion = null;
    public static final int MAX_NUM_FLAMES = 999;
    public static final String SMALL_TEXT = "x";
    public static final int TEXT_SIZE_TV_BIG = 18;
    public static final int TEXT_SIZE_TV_SMALL = 10;
    public static final String TV_MAX_NUM_FLAMES = "999+";
    public static final int VIEW_HEIGHT = 24;
    public static final int VIEW_WIDTH = 112;
    private int animHeight;
    private int animType;
    private int animWidth;
    private AnimatedDrawable2 animatedDrawable2;
    private AnimatorSet animatorSet;
    private final ViewGroup content;
    private boolean isAnimating;
    private boolean isAnimatorLoadFinish;
    private final SmartImageView ivAnim;
    private final LinearLayout layoutTv;
    private m numCalculator;
    private Runnable smallBellRunnable;
    private final TextView tvBig;
    private final TextView tvSmall;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends hf6.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLifeAtmosphereAnimView f260774a;

        @Override // hf6.f
        public final void onFailed(Uri r100, View r101, Throwable r102) {
        }

        public b(LiveLifeAtmosphereAnimView r100) {
            this.f260774a = r100;
        }

        @Override // hf6.f
        public final void onComplete(Uri r100, View r101, df6.o r102, Animatable r103) {
            if (r101 != null) goto L4;
            return;
        L4:
            this.f260774a.setAlpha(1.0f);
            LiveLifeAtmosphereAnimView.access$setAnimatorLoadFinish$p(this.f260774a, true);
            LiveLifeAtmosphereAnimView.access$changeImageSize(this.f260774a, r102);
            LiveLifeAtmosphereAnimView.access$startAnim(this.f260774a);
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLifeAtmosphereAnimView f260775a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public c(LiveLifeAtmosphereAnimView r100) {
            this.f260775a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            LiveLifeAtmosphereAnimView.access$setAnimatorSet$p(this.f260775a, null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            LiveLifeAtmosphereAnimView.access$checkAndSetNumText(this.f260775a);
            LiveLifeAtmosphereAnimView.access$setAnimating$p(this.f260775a, false);
            LiveLifeAtmosphereAnimView.access$setAnimatorSet$p(this.f260775a, null);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            LiveLifeAtmosphereAnimView.access$setAnimating$p(this.f260775a, true);
        }
    }

    static {
        Companion = new a();
    }

    public LiveLifeAtmosphereAnimView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public LiveLifeAtmosphereAnimView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final void changeBack() {
        int r100 = this.animType;
        if (r100 == 1) goto L7;
        if (r100 == 2) goto L6;
        String r101 = BG_MEDAL;
    L8:
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L11;
        String r102 = BG_MEDAL_CENTER;
    L13:
        float r103 = j0.b(12.0f);
        float[] r104 = {r103, r103, 0.0f, 0.0f, 0.0f, 0.0f, r103, r103};
        int r105 = ColorProtector.parseColor(r101);
        int r106 = ColorProtector.parseColor(r102);
        GradientDrawable r107 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{r105, r105, r105, r106, 0});
        r107.setCornerRadii(r104);
        setBackground(r107);
        return;
    L11:
        r102 = BG_FLAMES_CENTER;
        goto L13
    L12:
        r102 = BG_SMALL_BELL_CENTER;
        goto L13
    L6:
        r101 = BG_FLAMES;
        goto L8
    L7:
        r101 = BG_SMALL_BELL;
        goto L8
    }

    private final void checkAndSetNumText() {
        m r100 = this.numCalculator;
        if (r100 != null) goto L5;
        return;
    L5:
        setTextWithAnimator(r100.a());
    }

    private final void checkWidthScale() {
        float r100 = j0.b(112);
        float r101 = j0.b(24);
        float r102 = 10;
        this.tvSmall.setTextSize(0, j0.b(r102));
        float r103 = 18;
        this.tvBig.setTextSize(0, j0.b(r103));
        float r104 = this.tvBig.getPaint().measureText(this.tvBig.getText().toString());
        if (this.animType != 3) goto L5;
        float r105 = 0.0f;
    L6:
        float r106 = (this.animWidth * r101) / this.animHeight;
        float r107 = ((r106 + r104) + r105) + j0.b(4.0f);
        if (r107 <= r100) goto L9;
        float r108 = r100 / r107;
    L10:
        ViewGroup.LayoutParams r109 = this.ivAnim.getLayoutParams();
        r109.width = (int) (r106 * r108);
        r109.height = (int) (r101 * r108);
        this.ivAnim.setLayoutParams(r109);
        this.tvSmall.setTextSize(0, j0.b(r102) * r108);
        this.tvBig.setTextSize(0, j0.b(r103) * r108);
        ViewGroup.LayoutParams r110 = this.tvSmall.getLayoutParams();
        r110.width = (int) ((r105 * r108) + j0.b(1.0f));
        this.tvSmall.setLayoutParams(r110);
        ViewGroup.LayoutParams r111 = this.tvBig.getLayoutParams();
        r111.width = (int) ((r104 * r108) + j0.b(2.0f));
        this.tvBig.setLayoutParams(r111);
        return;
    L9:
        r108 = 1.0f;
        goto L10
    L5:
        r105 = this.tvSmall.getPaint().measureText(this.tvSmall.getText().toString());
        goto L6
    }

    private final void startAnim() {
        DraweeController r100 = this.ivAnim.getController();
        final AnimatedDrawable2 r101 = null;
        if (r100 == null) goto L5;
        Animatable r102 = r100.getAnimatable();
    L7:
        if ((r102 instanceof AnimatedDrawable2) == false) goto L9;
        r101 = (AnimatedDrawable2) r102;
    L9:
        this.animatedDrawable2 = r101;
        if (r101 == null) goto L15;
        r101.setLoopCount(1);
        if (r101.isRunning() == true) goto L16;
        r101.getLoopCount();
        r101.start();
        r101.setAnimationListener(new com.bytedance.locallife.live.view.a(r101.getFrameCount(), new LiveLifeAtmosphereAnimView$startAnim$1$1(this, r101)));
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L7
    }

    private final void startTvAnim() {
        ObjectAnimator r100 = ObjectAnimator.ofFloat(this.layoutTv, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 1.1f, 1.0f});
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.layoutTv, LiveDegradeFpsAnimator.SCALE_Y, new float[]{1.0f, 1.1f, 1.0f});
        AnimatorSet r102 = new AnimatorSet();
        r102.addListener(new c(this));
        r102.playTogether(new Animator[]{r100, r101});
        r102.setDuration(300);
        this.animatorSet = r102;
        r102.start();
    }

    public static final /* synthetic */ void access$checkAndSetNumText(LiveLifeAtmosphereAnimView r100) {
        r100.checkAndSetNumText();
    }

    public static final /* synthetic */ int access$getAnimType$p(LiveLifeAtmosphereAnimView r100) {
        return r100.animType;
    }

    public static final /* synthetic */ Runnable access$getSmallBellRunnable$p(LiveLifeAtmosphereAnimView r100) {
        return r100.smallBellRunnable;
    }

    public static final /* synthetic */ void access$startAnim(LiveLifeAtmosphereAnimView r100) {
        r100.startAnim();
    }

    private final void changeClip(Object r100) {
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r101 = (ViewGroup) r100;
    L6:
        if (r101 == null) goto L9;
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    private final void changeImageSize(df6.o r100) {
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.f468224b;
    L6:
        if (r100 == null) goto L8;
        r101 = r100.f468223a;
    L8:
        this.animWidth = r101;
        this.animHeight = r102;
        checkWidthScale();
        return;
    L5:
        r102 = 0;
        goto L6
    }

    private final void setTextWithAnimator(int r100) {
        int r101 = this.animType;
        if (r101 != 1) goto L8;
        if (r100 != 0) goto L8;
        setVisibility(8);
        return;
    L8:
        if (r101 == 2) goto L10;
    L12:
        String r102 = String.valueOf(r100);
    L14:
        if (Intrinsics.areEqual(r102, this.tvBig.getText()) == true) goto L17;
        this.tvBig.setText(r102);
        checkWidthScale();
        startTvAnim();
        return;
    L17:
        return;
    L10:
        if (r100 <= 999) goto L12;
        r102 = TV_MAX_NUM_FLAMES;
        goto L14
    }

    public final void changeAnimType(int r100) {
        if (this.animType == r100) goto L9;
        this.animType = r100;
        int r101 = 0;
        this.isAnimatorLoadFinish = false;
        changeBack();
        TextView r102 = this.tvSmall;
        if (r100 != 3) goto L7;
        r101 = 8;
    L7:
        r102.setVisibility(r101);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        changeClip(this.layoutTv);
        changeClip(findViewById(R.id.content));
        changeClip(this);
        changeClip(getParent());
        ViewParent r101 = getParent();
        if (r101 == null) goto L5;
        ViewParent r102 = r101.getParent();
    L6:
        changeClip(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        AnimatorSet r101 = this.animatorSet;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        this.animatorSet = null;
        AnimatedDrawable2 r102 = this.animatedDrawable2;
        if (r102 == null) goto L8;
        r102.stop();
    L8:
        this.animatedDrawable2 = null;
        Runnable r103 = this.smallBellRunnable;
        if (r103 == null) goto L12;
        com.bytedance.locallife.common.utils.k.a(r103);
        return;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "textBig");
        if (this.animType != 3) goto L6;
        this.tvBig.setText(r100);
        checkWidthScale();
        return;
    }

    public static final /* synthetic */ void access$changeImageSize(LiveLifeAtmosphereAnimView r100, df6.o r101) {
        r100.changeImageSize(r101);
    }

    public static final /* synthetic */ void access$setAnimating$p(LiveLifeAtmosphereAnimView r100, boolean r101) {
        r100.isAnimating = r101;
    }

    public static final /* synthetic */ void access$setAnimatorLoadFinish$p(LiveLifeAtmosphereAnimView r100, boolean r101) {
        r100.isAnimatorLoadFinish = r101;
    }

    public static final /* synthetic */ void access$setAnimatorSet$p(LiveLifeAtmosphereAnimView r100, AnimatorSet r101) {
        r100.animatorSet = r101;
    }

    public static final /* synthetic */ void access$setSmallBellRunnable$p(LiveLifeAtmosphereAnimView r100, Runnable r101) {
        r100.smallBellRunnable = r101;
    }

    public static final /* synthetic */ void access$setTextWithAnimator(LiveLifeAtmosphereAnimView r100, int r101) {
        r100.setTextWithAnimator(r101);
    }

    public final void setIcon(String r110, List<String> r111) {
        if (this.isAnimatorLoadFinish == false) goto L5;
        return;
    L5:
        setAlpha(0.0f);
        u r112 = q.d(new PoiImageUrlModel(null, r110, r111, 0, 0, 25, null));
        r112.b("LiveLifeAtmosphereAnimView");
        r112.f468294t = this.ivAnim;
        r112.f468287m = Bitmap.Config.ARGB_8888;
        r112.d(new b(this));
    }

    public final void setNum(int r100, boolean r101) {
        int r102 = this.animType;
        if (r102 != 3) goto L6;
        return;
    L6:
        if (this.numCalculator == null) goto L9;
        if (r101 == true) goto L9;
    L22:
        m r103 = this.numCalculator;
        if (r103 == null) goto L26;
        r103.b(r100);
    L26:
        if (this.isAnimating == true) goto L29;
        checkAndSetNumText();
        return;
    L29:
        return;
    L9:
        if (r102 != 1) goto L11;
        m r104 = new o();
    L15:
        this.numCalculator = r104;
        if (r101 == false) goto L18;
        this.tvBig.setText("");
    L18:
        m r105 = this.numCalculator;
        if (r105 == null) goto L22;
        r105.f260833d = new AnonymousClass1(this);
        goto L22
    L11:
        if (r102 == 2) goto L13;
        r104 = null;
        goto L15
    L13:
        r104 = new com.bytedance.locallife.live.view.b();
        goto L15
    }

    public LiveLifeAtmosphereAnimView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.saas_live_life_view_atmosphere_anim, this);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup");
        this.content = (ViewGroup) r103;
        this.ivAnim = (SmartImageView) findViewById(R.id.iv_anim);
        TextView r104 = (TextView) findViewById(R.id.tv_small);
        this.tvSmall = r104;
        this.tvBig = (TextView) findViewById(R.id.tv_big);
        this.layoutTv = (LinearLayout) findViewById(R.id.layout_tv);
        r104.setText("x");
        addOnAttachStateChangeListener(this);
        setAlpha(0.0f);
    }

    public /* synthetic */ LiveLifeAtmosphereAnimView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
