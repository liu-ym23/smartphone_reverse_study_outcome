package com.obric.sva.sdk.ui;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jn\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020!2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020$0#2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#J\u001a\u0010(\u001a\u00020)2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010*\u001a\u00020)2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002JV\u0010+\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020!2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020$0#2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#J6\u0010.\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020!J0\u0010/\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u001eH\u0002JV\u00104\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0001\u00105\u001a\u00020!2\b\b\u0001\u00106\u001a\u00020!2\b\b\u0001\u00107\u001a\u00020!2\b\b\u0001\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020!2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020!J8\u0010:\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020!2\u0006\u00109\u001a\u00020!H\u0002J(\u0010;\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0002Jh\u0010?\u001a\u00020\u0019*\u00020\u00192\u0006\u0010@\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020!2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020$0#2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/obric/sva/sdk/ui/IslandAnimatorHelper;", "", "<init>", "()V", "TAG", "", "ALPHA_MAX", "", "ALPHA_MIN", "ALPHA_ZERO", "SCALE_MAX", "SCALE_MIN", "DURATION", "", "HIDE_DURATION", "ANIM_TYPE_SCALE_AND_ALPHA", "ANIM_TYPE_PANEL_OR_CAPSULE", "ANIM_TYPE_SCALE", "ANIM_TYPE_ALPHA", "ANIM_TYPE_BACKGROUND", "ANIM_TYPE_TRANSLATION", "ANIM_TYPE_QUIT_HIDE", "ANIM_TYPE_TO_HIDE", "animMap", "", "Landroid/animation/ValueAnimator;", "doScaleAndAlphaAnim", "view", "Landroid/view/View;", "show", "", "duration", "startDelay", "", "onPrepare", "Lkotlin/Function0;", "", WidgetCostModule.TYPE_ON_START, "onEnd", "onCancel", "createScaleAnim", "Lcom/obric/sva/sdk/ui/ViewAnimData;", "createAlphaAnim", "doScaleAnim", "start", "end", "doAlphaAnim", "createWidthOrHeightAnimData", "isWidth", "startValue", "endValue", "clipBounds", "doBackgroundChangeAnim", "startColor1", "startColor2", "endColor1", "endColor2", "radius", "createBackgroundAnim", "createTranslationAnim", "isX", "startX", "endX", "dealMultipleAnim", "key", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IslandAnimatorHelper {
    private static final float ALPHA_MAX = 1.0f;
    private static final float ALPHA_MIN = 0.3f;
    private static final float ALPHA_ZERO = 0.0f;
    private static final String ANIM_TYPE_ALPHA = "anim_type_alpha";
    private static final String ANIM_TYPE_BACKGROUND = "anim_type_background";
    private static final String ANIM_TYPE_PANEL_OR_CAPSULE = "anim_type_panel_or_capsule";
    private static final String ANIM_TYPE_QUIT_HIDE = "anim_type_quit_hide";
    private static final String ANIM_TYPE_SCALE = "anim_type_scale";
    private static final String ANIM_TYPE_SCALE_AND_ALPHA = "anim_type_scale_and_alpha";
    private static final String ANIM_TYPE_TO_HIDE = "anim_type_to_hide";
    private static final String ANIM_TYPE_TRANSLATION = "anim_type_translation";
    private static final long DURATION = 500;
    private static final long HIDE_DURATION = 250;
    public static final IslandAnimatorHelper INSTANCE = null;
    private static final float SCALE_MAX = 1.0f;
    private static final float SCALE_MIN = 0.8f;
    private static final String TAG = "IslandAnimatorHelper";
    private static final Map<String, ValueAnimator> animMap = null;

    private IslandAnimatorHelper() {
    }

    public static /* synthetic */ Unit a() {
        return doScaleAndAlphaAnim$lambda$1();
    }

    public static /* synthetic */ Unit b() {
        return doScaleAndAlphaAnim$lambda$2();
    }

    public static /* synthetic */ Unit c() {
        return doScaleAndAlphaAnim$lambda$3();
    }

    public static /* synthetic */ Unit d(View r100, boolean r101, Function0 r102) {
        return doScaleAndAlphaAnim$lambda$7$lambda$6(r100, r101, r102);
    }

    public static /* synthetic */ Unit e() {
        return dealMultipleAnim$lambda$16();
    }

    public static /* synthetic */ Unit f() {
        return dealMultipleAnim$lambda$17();
    }

    public static /* synthetic */ Unit g() {
        return doScaleAnim$lambda$8();
    }

    public static /* synthetic */ Unit h() {
        return dealMultipleAnim$lambda$15();
    }

    public static /* synthetic */ Unit i(Function0 r100, View r101) {
        return doScaleAndAlphaAnim$lambda$7$lambda$5(r100, r101);
    }

    public static /* synthetic */ Unit j() {
        return doScaleAnim$lambda$9();
    }

    public static /* synthetic */ Unit k() {
        return doScaleAndAlphaAnim$lambda$0();
    }

    public static /* synthetic */ Unit l() {
        return dealMultipleAnim$lambda$14();
    }

    public static /* synthetic */ Unit m(Function0 r100) {
        return doScaleAndAlphaAnim$lambda$7$lambda$4(r100);
    }

    static {
        INSTANCE = new IslandAnimatorHelper();
        animMap = new LinkedHashMap();
    }

    private static final Unit dealMultipleAnim$lambda$14() {
        return Unit.INSTANCE;
    }

    private static final Unit dealMultipleAnim$lambda$15() {
        return Unit.INSTANCE;
    }

    private static final Unit dealMultipleAnim$lambda$16() {
        return Unit.INSTANCE;
    }

    private static final Unit dealMultipleAnim$lambda$17() {
        return Unit.INSTANCE;
    }

    private static final Unit doScaleAndAlphaAnim$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Unit doScaleAndAlphaAnim$lambda$1() {
        return Unit.INSTANCE;
    }

    private static final Unit doScaleAndAlphaAnim$lambda$2() {
        return Unit.INSTANCE;
    }

    private static final Unit doScaleAndAlphaAnim$lambda$3() {
        return Unit.INSTANCE;
    }

    private static final Unit doScaleAnim$lambda$8() {
        return Unit.INSTANCE;
    }

    private static final Unit doScaleAnim$lambda$9() {
        return Unit.INSTANCE;
    }

    private static final Unit doScaleAndAlphaAnim$lambda$7$lambda$4(Function0 r100) {
        r100.invoke();
        return Unit.INSTANCE;
    }

    private final ViewAnimData createAlphaAnim(View r110, boolean r111) {
        if (r111 == false) goto L5;
        float r100 = 0.3f;
    L6:
        if (r111 == false) goto L8;
        float r101 = 1.0f;
    L10:
        return new ViewAnimData(r110, "alpha", r100, r101, false, null, 32, null);
    L8:
        r101 = 0.3f;
        goto L10
    L5:
        r100 = 1.0f;
        goto L6
    }

    private final ViewAnimData createScaleAnim(View r110, boolean r111) {
        if (r111 == false) goto L5;
        float r100 = 0.8f;
    L6:
        if (r111 == false) goto L8;
        float r101 = 1.0f;
    L10:
        return new ViewAnimData(r110, "scale", r100, r101, false, null, 32, null);
    L8:
        r101 = 0.8f;
        goto L10
    L5:
        r100 = 1.0f;
        goto L6
    }

    private static final Unit doScaleAndAlphaAnim$lambda$7$lambda$5(Function0 r100, View r101) {
        r100.invoke();
        r101.setVisibility(0);
        return Unit.INSTANCE;
    }

    private static final Unit doScaleAndAlphaAnim$lambda$7$lambda$6(View r100, boolean r101, Function0 r102) {
        if (r101 == false) goto L4;
        int r103 = 0;
    L5:
        r100.setVisibility(r103);
        r102.invoke();
        return Unit.INSTANCE;
    L4:
        r103 = 8;
        goto L5
    }

    private final ViewAnimData createTranslationAnim(View r110, boolean r111, float r112, float r113) {
        if (r111 == false) goto L5;
        String r114 = LiveDegradeFpsAnimator.TRANSLATION_X;
    L7:
        return new ViewAnimData(r110, r114, r112, r113, false, null, 32, null);
    L5:
        r114 = LiveDegradeFpsAnimator.TRANSLATION_Y;
        goto L7
    }

    private final ViewAnimData createWidthOrHeightAnimData(View r110, boolean r111, float r112, float r113, boolean r114) {
        if (r111 == false) goto L5;
        String r115 = "width";
    L7:
        return new ViewAnimData(r110, r115, r112, r113, r114, null, 32, null);
    L5:
        r115 = "height";
        goto L7
    }

    public final ValueAnimator doAlphaAnim(View r210, float r211, float r212, long r213, int r214) {
        if (r210 == null) goto L4;
        ViewAnimData[] r100 = {new ViewAnimData(r210, "alpha", r211, r212, false, null, 32, null)};
        return dealMultipleAnim$default(INSTANCE, IslandAnimatorUtils.playTogether$default(IslandAnimatorUtils.INSTANCE, r100, 0, 2, null), ANIM_TYPE_ALPHA + r210.getId(), r213, r214, null, null, null, null, 120, null);
    L4:
        return null;
    }

    private final ViewAnimData createBackgroundAnim(View r310, int r311, int r312, int r313, int r314, int r315) {
        if ((r310.getBackground() instanceof GradientDrawable) == false) goto L11;
        Drawable r100 = r310.getBackground();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        int[] r101 = ((GradientDrawable) r100).getColors();
        if (r101 == null) goto L11;
        if (r101.length != 2) goto L11;
        return new ViewBgAnimData(r310, "background", r101[0], r101[1], new LinearInterpolator(), r313, r314, r315, false, 256, null);
    L11:
        return new ViewBgAnimData(r310, "background", r311, r312, new LinearInterpolator(), r313, r314, r315, false, 256, null);
    }

    public final ValueAnimator doScaleAnim(View r210, float r211, float r212, long r213, int r214, Function0<Unit> r215, Function0<Unit> r216) {
        Intrinsics.checkNotNullParameter(r215, "onEnd");
        Intrinsics.checkNotNullParameter(r216, "onCancel");
        if (r210 == null) goto L5;
        ViewAnimData[] r100 = {new ViewAnimData(r210, "scale", r211, r212, false, null, 32, null)};
        return dealMultipleAnim$default(INSTANCE, IslandAnimatorUtils.playTogether$default(IslandAnimatorUtils.INSTANCE, r100, 0, 2, null), ANIM_TYPE_SCALE + r210.getId(), r213, r214, null, null, r215, r216, 24, null);
    L5:
        return null;
    }

    private final ValueAnimator dealMultipleAnim(ValueAnimator r100, String r101, long r102, int r103, Function0<Unit> r104, final Function0<Unit> r105, final Function0<Unit> r110, final Function0<Unit> r111) {
        Map<String, ValueAnimator> r106 = animMap;
        final ValueAnimator r107 = r106.remove(r101);
        r106.put(r101, r100);
        r100.addListener(new AnonymousClass5(r107, r105, r110, r111));
        r104.invoke();
        r100.setDuration(r102);
        if (r103 <= 0) goto L5;
        r100.setStartDelay(r103);
    L5:
        r100.start();
        return r100;
    }

    public static /* synthetic */ ValueAnimator doAlphaAnim$default(IslandAnimatorHelper r100, View r101, float r102, float r110, long r111, int r112, int r113, Object r114) {
        if ((r113 & 8) == 0) goto L5;
        r111 = 500;
    L5:
        long r103 = r111;
        if ((r113 & 16) == 0) goto L8;
        int r104 = 0;
    L10:
        return r100.doAlphaAnim(r101, r102, r110, r103, r104);
    L8:
        r104 = r112;
        goto L10
    }

    public final ValueAnimator doBackgroundChangeAnim(View r210, int r211, int r212, int r213, int r214, int r215, long r216, int r217) {
        if (r210 == null) goto L4;
        IslandAnimatorHelper r100 = INSTANCE;
        return dealMultipleAnim$default(r100, IslandAnimatorUtils.playTogether$default(IslandAnimatorUtils.INSTANCE, new ViewAnimData[]{r100.createBackgroundAnim(r210, r211, r212, r213, r214, r215)}, 0, 2, null), ANIM_TYPE_BACKGROUND + r210.getId(), r216, r217, null, null, null, null, 120, null);
    L4:
        return null;
    }

    public final ValueAnimator doScaleAndAlphaAnim(final View r110, final boolean r111, long r112, int r210, final Function0<Unit> r211, final Function0<Unit> r212, final Function0<Unit> r213, Function0<Unit> r214) {
        Intrinsics.checkNotNullParameter(r211, "onPrepare");
        Intrinsics.checkNotNullParameter(r212, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r213, "onEnd");
        Intrinsics.checkNotNullParameter(r214, "onCancel");
        if (r111 == true) goto L11;
        if (r110 != null) goto L6;
    L8:
        boolean r100 = false;
    L9:
        if (r100 == false) goto L11;
        return null;
    L6:
        if (r110.getVisibility() != 8) goto L8;
        r100 = true;
    L11:
        if (r110 == null) goto L14;
        IslandAnimatorHelper r101 = INSTANCE;
        return r101.dealMultipleAnim(IslandAnimatorUtils.playTogether$default(IslandAnimatorUtils.INSTANCE, new ViewAnimData[]{r101.createAlphaAnim(r110, r111), r101.createScaleAnim(r110, r111)}, 0, 2, null), ANIM_TYPE_SCALE_AND_ALPHA + r110.getId(), r112, r210, new j(r211), new k(r212, r110), new l(r110, r111, r213), r214);
    L14:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ValueAnimator doScaleAnim$default(IslandAnimatorHelper r110, View r111, float r112, float r113, long r114, int r115, Function0 r116, Function0 r117, int r210, Object r211) {
        if ((r210 & 8) == 0) goto L5;
        long r100 = 500;
    L7:
        if ((r210 & 16) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r210 & 32) == 0) goto L13;
        Function0 r102 = new h();
    L15:
        if ((r210 & 64) == 0) goto L17;
        Function0 r118 = new i();
    L19:
        return r110.doScaleAnim(r111, r112, r113, r100, r101, r102, r118);
    L17:
        r118 = r117;
        goto L19
    L13:
        r102 = r116;
        goto L15
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ValueAnimator dealMultipleAnim$default(IslandAnimatorHelper r110, ValueAnimator r111, String r112, long r113, int r114, Function0 r115, Function0 r116, Function0 r210, Function0 r211, int r212, Object r213) {
        if ((r212 & 2) == 0) goto L5;
        long r100 = 500;
    L7:
        if ((r212 & 4) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r212 & 8) == 0) goto L13;
        Function0 r102 = new a();
    L15:
        if ((r212 & 16) == 0) goto L17;
        Function0 r103 = new e();
    L19:
        if ((r212 & 32) == 0) goto L21;
        Function0 r117 = new f();
    L23:
        if ((r212 & 64) == 0) goto L25;
        Function0 r118 = new g();
    L27:
        return r110.dealMultipleAnim(r111, r112, r100, r101, r102, r103, r117, r118);
    L25:
        r118 = r211;
        goto L27
    L21:
        r117 = r210;
        goto L23
    L17:
        r103 = r116;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }

    public static /* synthetic */ ValueAnimator doBackgroundChangeAnim$default(IslandAnimatorHelper r110, View r111, int r112, int r113, int r114, int r115, int r116, long r210, int r211, int r212, Object r213) {
        if ((r212 & 64) == 0) goto L5;
        long r117 = 500;
    L7:
        if ((r212 & 128) == 0) goto L9;
        int r118 = 0;
    L11:
        return r110.doBackgroundChangeAnim(r111, r112, r113, r114, r115, r116, r117, r118);
    L9:
        r118 = r211;
        goto L11
    L5:
        r117 = r210;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ValueAnimator doScaleAndAlphaAnim$default(IslandAnimatorHelper r110, View r111, boolean r112, long r113, int r114, Function0 r115, Function0 r210, Function0 r211, Function0 r212, int r213, Object r214) {
        if ((r213 & 4) == 0) goto L5;
        long r100 = 500;
    L7:
        if ((r213 & 8) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r213 & 16) == 0) goto L13;
        Function0 r102 = new m();
    L15:
        if ((r213 & 32) == 0) goto L17;
        Function0 r116 = new b();
    L19:
        if ((r213 & 64) == 0) goto L21;
        Function0 r117 = new c();
    L23:
        if ((r213 & 128) == 0) goto L25;
        Function0 r118 = new d();
    L27:
        return r110.doScaleAndAlphaAnim(r111, r112, r100, r101, r102, r116, r117, r118);
    L25:
        r118 = r212;
        goto L27
    L21:
        r117 = r211;
        goto L23
    L17:
        r116 = r210;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
