package com.obric.sva.sdk.ui;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rH\u0002J#\u0010\u0012\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\u0016J%\u0010\u0017\u001a\u00020\u00112\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u00142\u0006\u0010\u0018\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/sva/sdk/ui/IslandAnimatorUtils;", "", "<init>", "()V", "ANIMATOR_DURATION", "", "FROM", "", "TO", "createAnim", "Landroid/animation/ValueAnimator;", "duration", "onUpdate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "progress", "", "playTogether", "valueAnimData", "", "Lcom/obric/sva/sdk/ui/ViewAnimData;", "([Lcom/obric/sva/sdk/ui/ViewAnimData;J)Landroid/animation/ValueAnimator;", "dealAnimDataWithProgress", "fraction", "([Lcom/obric/sva/sdk/ui/ViewAnimData;F)V", "createBackground", "Landroid/graphics/drawable/Drawable;", "data", "Lcom/obric/sva/sdk/ui/ViewBgAnimData;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IslandAnimatorUtils {
    private static final long ANIMATOR_DURATION = 1000;
    private static final float FROM = 0.0f;
    public static final IslandAnimatorUtils INSTANCE = null;
    private static final float TO = 1.0f;

    static {
        INSTANCE = new IslandAnimatorUtils();
    }

    private IslandAnimatorUtils() {
    }

    public static /* synthetic */ Unit a(ViewAnimData[] r100, float r101) {
        return playTogether$lambda$2(r100, r101);
    }

    public static /* synthetic */ void b(Function1 r100, ValueAnimator r101) {
        createAnim$lambda$1$lambda$0(r100, r101);
    }

    private final ValueAnimator createAnim(long r100, final Function1<? super Float, Unit> r101) {
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r102.addUpdateListener(new n(r101));
        r102.setInterpolator(new LinearInterpolator());
        r102.setDuration(r100);
        Intrinsics.checkNotNull(r102);
        return r102;
    }

    private static final void createAnim$lambda$1$lambda$0(Function1 r100, ValueAnimator r101) {
        Intrinsics.checkNotNullParameter(r101, "valueAnimator");
        Object r102 = r101.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Float");
        r100.invoke((Float) r102);
    }

    private final Drawable createBackground(ViewBgAnimData r100, float r101) {
        ArgbEvaluator r102 = new ArgbEvaluator();
        Object r103 = r102.evaluate(r101, Integer.valueOf((int) r100.getStartValue()), Integer.valueOf((int) r100.getStartValue1()));
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Int");
        int r104 = ((Integer) r103).intValue();
        Object r105 = r102.evaluate(r101, Integer.valueOf((int) r100.getEndValue()), Integer.valueOf((int) r100.getEndValue1()));
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Int");
        GradientDrawable r106 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{r104, ((Integer) r105).intValue()});
        r106.setShape(0);
        r106.setCornerRadius(r100.getRadius());
        r106.setGradientType(0);
        return r106;
    }

    private final void dealAnimDataWithProgress(ViewAnimData[] r110, float r111) {
        ArrayList r100 = new ArrayList();
        int r101 = r110.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        ViewAnimData r103 = r110[r102];
        if (r103.getView() == null) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        r100.add(r103);
    L10:
        r102 = r102 + 1;
        goto L3
    L7:
        r104 = false;
        goto L8
    L11:
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r105 = r100.iterator();
    L13:
        if (r105.hasNext() == false) goto L83;
        ViewAnimData r106 = (ViewAnimData) r105.next();
        float r107 = r106.getInterpolator().getInterpolation(r111);
        float r108 = ((r106.getEndValue() - r106.getStartValue()) * r107) + r106.getStartValue();
        View r109 = r106.getView();
        Rect r113 = null;
        if (r109 == null) goto L17;
        ViewGroup.LayoutParams r114 = r109.getLayoutParams();
    L18:
        String r115 = r106.getPropertyName();
        switch(r115.hashCode()) {
            case -1332194002: goto L75;
            case -1225497657: goto L69;
            case -1225497656: goto L63;
            case -1221029593: goto L45;
            case 92909918: goto L39;
            case 109250890: goto L30;
            case 113126854: goto L22;
            default: goto L82;
        };
    L22:
        if (r115.equals("width") == false) goto L82;
        if (r114 == null) goto L26;
        r114.width = (int) r108;
    L26:
        View r116 = r106.getView();
        if (r116 == null) goto L82;
        r116.setLayoutParams(r114);
        goto L82
    L30:
        if (r115.equals("scale") == false) goto L82;
        View r117 = r106.getView();
        if (r117 == null) goto L35;
        r117.setScaleX(r108);
    L35:
        View r118 = r106.getView();
        if (r118 == null) goto L82;
        r118.setScaleY(r108);
        goto L82
    L39:
        if (r115.equals("alpha") == false) goto L82;
        View r119 = r106.getView();
        if (r119 == null) goto L82;
        r119.setAlpha(r108);
        goto L82
    L45:
        if (r115.equals("height") == false) goto L82;
        if (r114 == null) goto L49;
        r114.height = (int) r108;
    L49:
        View r120 = r106.getView();
        if (r120 == null) goto L53;
        r120.setLayoutParams(r114);
    L53:
        if (r106.getClipBounds() == false) goto L82;
        View r121 = r106.getView();
        if (r121 == null) goto L82;
        View r122 = r106.getView();
        if (r122 == null) goto L59;
        r113 = r122.getClipBounds();
    L59:
        if (r113 != null) goto L61;
        r113 = new Rect();
    L61:
        r113.left = 0;
        r113.top = 0;
        r113.right = r121.getWidth();
        r113.bottom = (int) r108;
        r121.setClipBounds(r113);
        goto L82
    L63:
        if (r115.equals(LiveDegradeFpsAnimator.TRANSLATION_Y) == false) goto L82;
        View r123 = r106.getView();
        if (r123 == null) goto L82;
        r123.setTranslationY(r108);
        goto L82
    L69:
        if (r115.equals(LiveDegradeFpsAnimator.TRANSLATION_X) == false) goto L82;
        View r124 = r106.getView();
        if (r124 == null) goto L82;
        r124.setTranslationX(r108);
        goto L82
    L75:
        if (r115.equals("background") == false) goto L82;
        if ((r106 instanceof ViewBgAnimData) == false) goto L82;
        ViewBgAnimData r125 = (ViewBgAnimData) r106;
        View r126 = r125.getView();
        if (r126 == null) goto L82;
        r126.setBackground(INSTANCE.createBackground(r125, r107));
    L82:
        r112.add(Unit.INSTANCE);
        goto L13
    L17:
        r114 = null;
        goto L18
    }

    private static final Unit playTogether$lambda$2(ViewAnimData[] r100, float r101) {
        INSTANCE.dealAnimDataWithProgress(r100, r101);
        return Unit.INSTANCE;
    }

    public final ValueAnimator playTogether(final ViewAnimData[] r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "valueAnimData");
        return createAnim(r101, new o(r100));
    }

    public static /* synthetic */ ValueAnimator createAnim$default(IslandAnimatorUtils r100, long r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = 1000;
    L6:
        return r100.createAnim(r101, r102);
    }

    public static /* synthetic */ ValueAnimator playTogether$default(IslandAnimatorUtils r100, ViewAnimData[] r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 1000;
    L6:
        return r100.playTogether(r101, r102);
    }
}
