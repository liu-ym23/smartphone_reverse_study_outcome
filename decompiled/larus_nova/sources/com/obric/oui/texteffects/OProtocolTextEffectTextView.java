package com.obric.oui.texteffects;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.obric.oui.texteffects.core.BlendSpec;
import com.obric.oui.texteffects.core.Direction;
import com.obric.oui.texteffects.core.TextSource;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import qma.g;
import qma.j;
import qma.k;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0001-B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR$\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0017\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\f8\u0014X\u0094D¢\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001d\u001a\u00020\u00028\u0014X\u0094D¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010 \u001a\u00020\u00028\u0014X\u0094D¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016R\u0014\u0010$\u001a\u00020!8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006."}, d2 = {"Lcom/obric/oui/texteffects/OProtocolTextEffectTextView;", "Landroid/widget/TextView;", "", "scale", "", "setDebugAnimationDurationScale", "Lsma/a;", "b", "Lkotlin/Lazy;", "getBlurFilterCache", "()Lsma/a;", "blurFilterCache", "", "<set-?>", "l", "Ljava/lang/String;", "getActiveEffectName", "()Ljava/lang/String;", "activeEffectName", "m", FaceService.girlLabel, "getDebugAnimationDurationScale", "()F", "debugAnimationDurationScale", OfficeSDKRequestTag.KEY_NEW_USER, "getLogTag", "logTag", "o", "getMaxBlurRadiusDp", "maxBlurRadiusDp", "p", "getBlurFilterCacheGranularityPx", "blurFilterCacheGranularityPx", "", "getCurrentEffectPlayTimeMs", "()J", "currentEffectPlayTimeMs", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0})
public abstract class OProtocolTextEffectTextView extends TextView {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f403276q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Float, Float> f403277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f403278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f403279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f403280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f403281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f403282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f403283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f403284h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public sma.c f403285i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public sma.c f403286j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public sma.c f403287k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f403288l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f403289m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f403290n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f403291o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final float f403292p;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f403293a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f403294b = null;

        static {
            int[] r100 = new int[TextSource.values().length];
            r100[TextSource.Current.ordinal()] = 1;
            r100[TextSource.Old.ordinal()] = 2;
            r100[TextSource.New.ordinal()] = 3;
            f403293a = r100;
            int[] r101 = new int[BlendSpec.values().length];
            r101[BlendSpec.CLEAR.ordinal()] = 1;
            r101[BlendSpec.SRC.ordinal()] = 2;
            r101[BlendSpec.DST.ordinal()] = 3;
            r101[BlendSpec.SRC_OVER.ordinal()] = 4;
            r101[BlendSpec.DST_OVER.ordinal()] = 5;
            r101[BlendSpec.SRC_IN.ordinal()] = 6;
            r101[BlendSpec.DST_IN.ordinal()] = 7;
            r101[BlendSpec.SRC_OUT.ordinal()] = 8;
            r101[BlendSpec.DST_OUT.ordinal()] = 9;
            r101[BlendSpec.SRC_ATOP.ordinal()] = 10;
            r101[BlendSpec.DST_ATOP.ordinal()] = 11;
            r101[BlendSpec.XOR.ordinal()] = 12;
            r101[BlendSpec.PLUS.ordinal()] = 13;
            r101[BlendSpec.MODULATE.ordinal()] = 14;
            r101[BlendSpec.SCREEN.ordinal()] = 15;
            r101[BlendSpec.OVERLAY.ordinal()] = 16;
            r101[BlendSpec.DARKEN.ordinal()] = 17;
            r101[BlendSpec.LIGHTEN.ordinal()] = 18;
            r101[BlendSpec.COLOR_DODGE.ordinal()] = 19;
            r101[BlendSpec.COLOR_BURN.ordinal()] = 20;
            r101[BlendSpec.HARD_LIGHT.ordinal()] = 21;
            r101[BlendSpec.SOFT_LIGHT.ordinal()] = 22;
            r101[BlendSpec.DIFFERENCE.ordinal()] = 23;
            r101[BlendSpec.EXCLUSION.ordinal()] = 24;
            r101[BlendSpec.MULTIPLY.ordinal()] = 25;
            r101[BlendSpec.HUE.ordinal()] = 26;
            r101[BlendSpec.SATURATION.ordinal()] = 27;
            r101[BlendSpec.COLOR.ordinal()] = 28;
            r101[BlendSpec.LUMINOSITY.ordinal()] = 29;
            f403294b = r101;
        }
    }

    static {
    }

    public OProtocolTextEffectTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OProtocolTextEffectTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public void p(String r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "effectName");
        Intrinsics.checkNotNullParameter(r101, "spec");
    }

    public void q() {
    }

    public void r(String r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "effectName");
        Intrinsics.checkNotNullParameter(r101, "spec");
    }

    public void s() {
    }

    private final sma.a getBlurFilterCache() {
        return (sma.a) this.f403278b.getValue();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        int r100 = f.f403310a;
        getLogTag();
        u();
        getBlurFilterCache().f542591c.clear();
        super.onDetachedFromWindow();
    }

    public void u() {
        int r100 = f.f403310a;
        getLogTag();
        if (this.f403280d == null) goto L5;
        getLogTag();
    L5:
        ValueAnimator r101 = this.f403280d;
        if (r101 == null) goto L9;
        r101.cancel();
    L9:
        this.f403280d = null;
        this.f403279c = null;
        this.f403288l = "none";
        this.f403281e = 0;
        this.f403282f = null;
        this.f403283g = null;
        this.f403284h = null;
        this.f403286j = null;
        this.f403287k = null;
        s();
        invalidate();
    }

    public final float e() {
        return RangesKt.coerceAtLeast((getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight(), 0.0f);
    }

    public final String getActiveEffectName() {
        return this.f403288l;
    }

    public float getBlurFilterCacheGranularityPx() {
        return this.f403292p;
    }

    public final long getCurrentEffectPlayTimeMs() {
        return this.f403281e;
    }

    public final float getDebugAnimationDurationScale() {
        return this.f403289m;
    }

    public String getLogTag() {
        return this.f403290n;
    }

    public float getMaxBlurRadiusDp() {
        return this.f403291o;
    }

    public static int k(Drawable r100) {
        Integer r101 = Integer.valueOf(r100.getBounds().height());
        if (r101.intValue() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = null;
    L9:
        if (r101 != null) goto L12;
        return RangesKt.coerceAtLeast(r100.getIntrinsicHeight(), 0);
    L12:
        return r101.intValue();
    L5:
        r102 = false;
        goto L6
    }

    public static int l(Drawable r100) {
        Integer r101 = Integer.valueOf(r100.getBounds().width());
        if (r101.intValue() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r101 = null;
    L9:
        if (r101 != null) goto L12;
        return RangesKt.coerceAtLeast(r100.getIntrinsicWidth(), 0);
    L12:
        return r101.intValue();
    L5:
        r102 = false;
        goto L6
    }

    public sma.c d(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        int r101 = sma.d.f542607a;
        return sma.d.a(r100, getPaint(), e(), getEllipsize(), new OProtocolTextEffectTextView$buildTextCache$1(this), OProtocolTextEffectTextView$buildTextCache$2.INSTANCE);
    }

    public final float f(float r100) {
        float r101 = e();
        int r102 = getGravity() & 7;
        float r103 = getCompoundPaddingLeft();
        if (r102 != 1) goto L5;
        float r104 = (r101 - r100) / 2.0f;
    L12:
        return r103 + r104;
    L5:
        if (r102 != 5) goto L7;
    L9:
        r104 = r101 - r100;
        goto L12
    L7:
        if (r102 == 8388613) goto L9;
        return r103;
    }

    public final BlurMaskFilter n(float r100) {
        sma.a r101 = getBlurFilterCache();
        r101.getClass();
        if (Float.isNaN(r100) == false) goto L5;
        return null;
    L5:
        if (Float.isInfinite(r100) == false) goto L7;
        return null;
    L7:
        if (r100 <= 0.01f) goto L25;
        int r102 = RangesKt.coerceAtLeast(MathKt.roundToInt(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r100, r101.f542589a), r101.f542590b) / r101.f542590b), 1);
        BlurMaskFilter r103 = r101.f542591c.get(r102);
        if (r103 == null) goto L20;
        return r103;
    L20:
        BlurMaskFilter r104 = new BlurMaskFilter(r102 * r101.f542590b, BlurMaskFilter.Blur.NORMAL);     // Catch: RuntimeException -> L15
    L16:
        if (r104 == null) goto L26;
        r101.f542591c.put(r102, r104);
        return r104;
    L26:
        return null;
    L15:
        r104 = null;
        goto L16
    L25:
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        k r100 = this.f403279c;
        if (r100 != null) goto L6;
        super.onDraw(r110);
        return;
    L6:
        LruCache<qma.a.b, PathInterpolator> r101 = com.obric.oui.texteffects.runtime.f.f403340a;
        com.obric.oui.texteffects.runtime.e r102 = com.obric.oui.texteffects.runtime.f.e(r100, this.f403281e);
        int r103 = f.f403310a;
        getLogTag();
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Drawable[] r104 = getCompoundDrawables();
        int r105 = getCompoundPaddingLeft();
        int r106 = getCompoundPaddingTop();
        int r107 = getWidth() - getCompoundPaddingRight();
        int r108 = getHeight() - getCompoundPaddingBottom();
        int r109 = RangesKt.coerceAtLeast(r107 - r105, 0);
        int r111 = RangesKt.coerceAtLeast(r108 - r106, 0);
        Drawable r112 = r104[0];
        if (r112 == null) goto L10;
        h(r112, r110, getPaddingLeft(), ((r111 - k(r112)) / 2) + r106);
    L10:
        Drawable r113 = r104[1];
        if (r113 == null) goto L14;
        h(r113, r110, ((r109 - l(r113)) / 2) + r105, getPaddingTop());
    L14:
        Drawable r114 = r104[2];
        if (r114 == null) goto L18;
        h(r114, r110, (getWidth() - getPaddingRight()) - l(r114), r106 + ((r111 - k(r114)) / 2));
    L18:
        Drawable r115 = r104[3];
        if (r115 == null) goto L22;
        h(r115, r110, r105 + ((r109 - l(r115)) / 2), (getHeight() - getPaddingBottom()) - k(r115));
    L22:
        int r116 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        Iterator<T> r117 = r102.f403339c.iterator();     // Catch: Throwable -> L33
    L25:
        if (r117.hasNext() == false) goto L31;
        com.obric.oui.texteffects.runtime.d r118 = (com.obric.oui.texteffects.runtime.d) r117.next();     // Catch: Throwable -> L33
        qma.b.C7362b r119 = m(r100, r118);     // Catch: Throwable -> L33
        if (r119 == null) goto L25;
        j(r110, r119, r118);     // Catch: Throwable -> L33
        goto L25
    L31:
        r110.restoreToCount(r116);
        return;
    L33:
        th = move-exception;
        r110.restoreToCount(r116);
        throw th;
    }

    public void setDebugAnimationDurationScale(float r100) {
        if (Float.isNaN(r100) == false) goto L5;
    L8:
        float r101 = 1.0f;
    L10:
        if (this.f403289m != r101) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L15;
        return;
    L15:
        this.f403289m = r101;
        int r103 = f.f403310a;
        getLogTag();
        return;
    L12:
        r102 = false;
        goto L13
    L5:
        if (Float.isInfinite(r100) == true) goto L8;
        r101 = RangesKt.coerceIn(r100, 0.1f, 10.0f);
        goto L10
    }

    public static void a(Paint r100, BlendSpec r101) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, "blend");
        PorterDuffXfermode r102 = null;
        if (r101 != BlendSpec.SRC_OVER) goto L10;
        if (Build.VERSION.SDK_INT < 29) goto L7;
        r100.setBlendMode(null);
        return;
    L7:
        r100.setXfermode(null);
        return;
    L10:
        if (Build.VERSION.SDK_INT < 29) goto L46;
        switch(b.f403294b[r101.ordinal()]) {
            case 1: goto L43;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L40;
            case 5: goto L39;
            case 6: goto L38;
            case 7: goto L37;
            case 8: goto L36;
            case 9: goto L35;
            case 10: goto L34;
            case 11: goto L33;
            case 12: goto L32;
            case 13: goto L31;
            case 14: goto L30;
            case 15: goto L29;
            case 16: goto L28;
            case 17: goto L27;
            case 18: goto L26;
            case 19: goto L25;
            case 20: goto L24;
            case 21: goto L23;
            case 22: goto L22;
            case 23: goto L21;
            case 24: goto L20;
            case 25: goto L19;
            case 26: goto L18;
            case 27: goto L17;
            case 28: goto L16;
            case 29: goto L15;
            default: goto L14;
        };
    L15:
        BlendMode r103 = BlendMode.LUMINOSITY;
    L44:
        r100.setBlendMode(r103);
        return;
    L16:
        r103 = BlendMode.COLOR;
        goto L44
    L17:
        r103 = BlendMode.SATURATION;
        goto L44
    L18:
        r103 = BlendMode.HUE;
        goto L44
    L19:
        r103 = BlendMode.MULTIPLY;
        goto L44
    L20:
        r103 = BlendMode.EXCLUSION;
        goto L44
    L21:
        r103 = BlendMode.DIFFERENCE;
        goto L44
    L22:
        r103 = BlendMode.SOFT_LIGHT;
        goto L44
    L23:
        r103 = BlendMode.HARD_LIGHT;
        goto L44
    L24:
        r103 = BlendMode.COLOR_BURN;
        goto L44
    L25:
        r103 = BlendMode.COLOR_DODGE;
        goto L44
    L26:
        r103 = BlendMode.LIGHTEN;
        goto L44
    L27:
        r103 = BlendMode.DARKEN;
        goto L44
    L28:
        r103 = BlendMode.OVERLAY;
        goto L44
    L29:
        r103 = BlendMode.SCREEN;
        goto L44
    L30:
        r103 = BlendMode.MODULATE;
        goto L44
    L31:
        r103 = BlendMode.PLUS;
        goto L44
    L32:
        r103 = BlendMode.XOR;
        goto L44
    L33:
        r103 = BlendMode.DST_ATOP;
        goto L44
    L34:
        r103 = BlendMode.SRC_ATOP;
        goto L44
    L35:
        r103 = BlendMode.DST_OUT;
        goto L44
    L36:
        r103 = BlendMode.SRC_OUT;
        goto L44
    L37:
        r103 = BlendMode.DST_IN;
        goto L44
    L38:
        r103 = BlendMode.SRC_IN;
        goto L44
    L39:
        r103 = BlendMode.DST_OVER;
        goto L44
    L40:
        r103 = BlendMode.SRC_OVER;
        goto L44
    L41:
        r103 = BlendMode.DST;
        goto L44
    L42:
        r103 = BlendMode.SRC;
        goto L44
    L43:
        r103 = BlendMode.CLEAR;
        goto L44
    L14:
        throw new NoWhenBranchMatchedException();
    L46:
        switch(b.f403294b[r101.ordinal()]) {
            case 1: goto L67;
            case 2: goto L66;
            case 3: goto L65;
            case 4: goto L64;
            case 5: goto L63;
            case 6: goto L62;
            case 7: goto L61;
            case 8: goto L60;
            case 9: goto L59;
            case 10: goto L58;
            case 11: goto L57;
            case 12: goto L56;
            case 13: goto L55;
            case 14: goto L54;
            case 15: goto L53;
            case 16: goto L52;
            case 17: goto L51;
            case 18: goto L50;
            case 19: goto L64;
            case 20: goto L64;
            case 21: goto L64;
            case 22: goto L64;
            case 23: goto L64;
            case 24: goto L64;
            case 25: goto L49;
            case 26: goto L64;
            case 27: goto L64;
            case 28: goto L64;
            case 29: goto L64;
            default: goto L48;
        };
    L49:
        PorterDuff.Mode r104 = PorterDuff.Mode.MULTIPLY;
    L68:
        if (r104 == null) goto L71;
        r102 = new PorterDuffXfermode(r104);
    L71:
        r100.setXfermode(r102);
        return;
    L50:
        r104 = PorterDuff.Mode.LIGHTEN;
        goto L68
    L51:
        r104 = PorterDuff.Mode.DARKEN;
        goto L68
    L52:
        r104 = PorterDuff.Mode.OVERLAY;
        goto L68
    L53:
        r104 = PorterDuff.Mode.SCREEN;
        goto L68
    L54:
        r104 = PorterDuff.Mode.MULTIPLY;
        goto L68
    L55:
        r104 = PorterDuff.Mode.ADD;
        goto L68
    L56:
        r104 = PorterDuff.Mode.XOR;
        goto L68
    L57:
        r104 = PorterDuff.Mode.DST_ATOP;
        goto L68
    L58:
        r104 = PorterDuff.Mode.SRC_ATOP;
        goto L68
    L59:
        r104 = PorterDuff.Mode.DST_OUT;
        goto L68
    L60:
        r104 = PorterDuff.Mode.SRC_OUT;
        goto L68
    L61:
        r104 = PorterDuff.Mode.DST_IN;
        goto L68
    L62:
        r104 = PorterDuff.Mode.SRC_IN;
        goto L68
    L63:
        r104 = PorterDuff.Mode.DST_OVER;
        goto L68
    L64:
        r104 = null;
        goto L68
    L65:
        r104 = PorterDuff.Mode.DST;
        goto L68
    L66:
        r104 = PorterDuff.Mode.SRC;
        goto L68
    L67:
        r104 = PorterDuff.Mode.CLEAR;
        goto L68
    L48:
        throw new NoWhenBranchMatchedException();
    }

    public static qma.b.C7362b m(k r100, com.obric.oui.texteffects.runtime.d r101) {
        Intrinsics.checkNotNullParameter(r100, "spec");
        Intrinsics.checkNotNullParameter(r101, "frame");
        Iterator<T> r102 = r100.f533975e.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((qma.c) r103).f533942a, r101.f403323a) == false) goto L4;
    L9:
        qma.c r104 = (qma.c) r103;
        if (r104 != null) goto L12;
        return null;
    L12:
        Iterator<T> r105 = r104.f533945d.iterator();
    L14:
        if (r105.hasNext() == false) goto L18;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((qma.b) r106).a(), r101.f403324b) == false) goto L14;
    L20:
        if ((r106 instanceof qma.b.C7362b) == true) goto L22;
        return null;
    L22:
        return (qma.b.C7362b) r106;
    L18:
        r106 = null;
        goto L20
    L8:
        r103 = null;
        goto L9
    }

    public LinearGradient c(sma.c r100, qma.e.a r110) {
        Intrinsics.checkNotNullParameter(r100, "cache");
        Intrinsics.checkNotNullParameter(r110, LynxVideoManagerLite.FILL);
        float r101 = r100.f542604h;
        if (r101 > 0.01f) goto L6;
        return null;
    L6:
        float r102 = r100.f542605i;
        return new LinearGradient(r102, 0.0f, r102 + r101, 0.0f, r110.f533954a, r110.f533955b, Shader.TileMode.CLAMP);
    }

    public final float g(com.obric.oui.texteffects.runtime.d r100, qma.d r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r101 instanceof qma.d.a) == false) goto L6;
        return this.f403277a.invoke(Float.valueOf(((qma.d.a) r101).f533946a)).floatValue();
    L6:
        if ((r101 instanceof qma.d.b) == false) goto L9;
        return ((qma.d.b) r101).f533947a;
    L9:
        return this.f403277a.invoke(Float.valueOf(0.0f)).floatValue();
    }

    public final boolean o(sma.c r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "cache");
        Intrinsics.checkNotNullParameter(r101, "text");
        if (Intrinsics.areEqual(r100.f542597a, r101) == true) goto L5;
        return false;
    L5:
        if (r100.f542601e != e()) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L10;
        return false;
    L10:
        if (r100.f542602f == getEllipsize()) goto L12;
        return false;
    L12:
        if (r100.f542603g != getPaint().getTextSize()) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L21;
        return true;
    L21:
        return false;
    L14:
        r103 = false;
        goto L15
    L7:
        r102 = false;
        goto L8
    }

    public OProtocolTextEffectTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f403277a = new OProtocolTextEffectTextView$dp$1(this);
        this.f403278b = LazyKt.lazy(new OProtocolTextEffectTextView$blurFilterCache$2(this));
        this.f403288l = "none";
        this.f403289m = 1.0f;
        this.f403290n = "ProtocolTextEffectView";
        this.f403291o = 16.0f;
        this.f403292p = 0.5f;
    }

    public final void b(Paint r100, qma.e r101, sma.c r102) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.FILL);
        Intrinsics.checkNotNullParameter(r102, "cache");
        if (Intrinsics.areEqual(r101, qma.e.b.f533956a) == false) goto L6;
        r100.setShader(null);
        r100.setColor(getCurrentTextColor());
        return;
    L6:
        if ((r101 instanceof qma.e.a) == false) goto L10;
        r100.setShader(c(r102, (qma.e.a) r101));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12, types: [android.graphics.Shader] */
    /* JADX WARN: Type inference failed for: r10v13, types: [android.graphics.Shader] */
    /* JADX WARN: Type inference failed for: r11v10, types: [int] */
    /* JADX WARN: Type inference failed for: r11v11, types: [int] */
    /* JADX WARN: Type inference failed for: r12v12, types: [qma.j$b] */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v15, types: [int] */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v3, types: [int] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v11, types: [int] */
    /* JADX WARN: Type inference failed for: r14v0, types: [android.graphics.Paint, android.text.TextPaint] */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13, types: [android.graphics.Xfermode] */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16, types: [android.text.TextPaint] */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v3, types: [android.graphics.Xfermode] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r15v0, types: [sma.c] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27, types: [android.graphics.Shader] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.graphics.Shader] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r26v0 */
    /* JADX WARN: Type inference failed for: r26v1 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r26v5 */
    /* JADX WARN: Type inference failed for: r36v0, types: [android.widget.TextView, com.obric.oui.texteffects.OProtocolTextEffectTextView, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r38v0, types: [java.lang.Object, qma.b$b] */
    /* JADX WARN: Type inference failed for: r38v1 */
    /* JADX WARN: Type inference failed for: r38v3 */
    /* JADX WARN: Type inference failed for: r38v5 */
    /* JADX WARN: Type inference failed for: r38v6 */
    /* JADX WARN: Type inference failed for: r39v0, types: [com.obric.oui.texteffects.runtime.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r39v1 */
    /* JADX WARN: Type inference failed for: r39v3 */
    /* JADX WARN: Type inference failed for: r39v4 */
    /* JADX WARN: Type inference failed for: r39v5 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15, types: [int] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v5, types: [int] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r5v10, types: [android.graphics.Paint] */
    /* JADX WARN: Type inference failed for: r5v11, types: [android.text.TextPaint] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.text.TextPaint] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13, types: [sma.c] */
    /* JADX WARN: Type inference failed for: r6v14, types: [sma.c] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v7, types: [sma.c] */
    /* JADX WARN: Type inference failed for: r6v8 */
    public final void j(Canvas r310, qma.b.C7362b r311, com.obric.oui.texteffects.runtime.d r312) {
        Intrinsics.checkNotNullParameter(r310, "canvas");
        Intrinsics.checkNotNullParameter(r311, GXTemplateKey.GAIAX_LAYER);
        Intrinsics.checkNotNullParameter(r312, "frame");
        TextSource r100 = r311.f533938b;
        Intrinsics.checkNotNullParameter(r100, "source");
        int r101 = b.f403293a[r100.ordinal()];
        CharSequence r102 = "";
        if (r101 != 1) goto L5;
        CharSequence r103 = getText();
        if (r103 == null) goto L44;
        r102 = r103;
    L44:
        sma.c r104 = this.f403285i;
        if (r104 != null) goto L48;
    L50:
        r104 = null;
    L51:
        if (r104 != null) goto L53;
        r104 = d(r102);
        this.f403285i = r104;
        int r105 = f.f403310a;
        getLogTag();
    L53:
        ?? r110 = r104;
        if (r110.f542599c.length != 0) goto L56;
        boolean r106 = true;
    L57:
        if (r106 == false) goto L59;
        return;
    L59:
        if (r110.f542604h <= 0.01f) goto L153;
        ?? r111 = getPaint();
        int r112 = r111.getColor();
        int r113 = r111.getAlpha();
        Shader r114 = r111.getShader();
        MaskFilter r107 = r111.getMaskFilter();
        Xfermode r108 = r111.getXfermode();
        int r109 = Build.VERSION.SDK_INT;
        if (r109 < 29) goto L64;
        BlendMode r210 = r111.getBlendMode();
    L65:
        float r115 = r111.getLetterSpacing();
        boolean r116 = r111.isSubpixelText();
        float r117 = r110.f542604h;
        float r118 = r110.f542605i;
        LinearGradient r119 = r110.f542606j;
        if (Float.isNaN(r312.f403327e) == false) goto L68;
        float r120 = 1.0f;
    L70:
        if (Float.isNaN(r312.f403328f) == false) goto L72;
        float r121 = 1.0f;
    L73:
        float r122 = r121 * r120;
        if (r122 > 0.001f) goto L141;
        return;
    L141:
        r111.setSubpixelText(true);     // Catch: Throwable -> L129
        r111.setAlpha(255);     // Catch: Throwable -> L129
        if (Float.isNaN(r312.f403330h) == false) goto L80;
        float r123 = r115;
    L81:
        r111.setLetterSpacing(r123);     // Catch: Throwable -> L129
        char[] r124 = r110.f542599c;     // Catch: Throwable -> L129
        float r125 = r111.measureText(r124, 0, r124.length);     // Catch: Throwable -> L129
        r110.f542604h = r125;     // Catch: Throwable -> L129
        r110.f542605i = f(r125);     // Catch: Throwable -> L129
        r110.f542606j = null;     // Catch: Throwable -> L129
        float r126 = g(r312, r312.f403334l);     // Catch: Throwable -> L129
        float r127 = g(r312, r312.f403333k);     // Catch: Throwable -> L129
        int r128 = f.f403310a;     // Catch: Throwable -> L129
        getLogTag();     // Catch: Throwable -> L129
        float r129 = r110.f542605i + r126;     // Catch: Throwable -> L129
        float r130 = r110.f542604h + r129;
        float r131 = Math.max(this.f403277a.invoke(Float.valueOf(getMaxBlurRadiusDp())).floatValue(), r127) + Math.abs(r126);     // Catch: Throwable -> L127
        float r132 = RangesKt.coerceAtLeast(r129 - r131, 0.0f);     // Catch: Throwable -> L127
        float r211 = RangesKt.coerceAtMost(r130 + r131, getWidth());     // Catch: Throwable -> L127
        if (r211 > r132) goto L149;
        r111.setColor(r112);
        r111.setAlpha(r113);
        r111.setShader(r114);
        r111.setMaskFilter(r107);
        r111.setSubpixelText(r116);
        r111.setLetterSpacing(r115);
        r110.f542604h = r117;
        r110.f542605i = r118;
        r110.f542606j = r119;
        if (r109 < 29) goto L89;
        r111.setBlendMode(r210);
    L89:
        r111.setXfermode(r108);
        return;
    L149:
        ?? r212 = r112;
        b(r111, r311.f533939c, r110);     // Catch: Throwable -> L122
        r111.setAlpha(RangesKt.coerceIn(MathKt.roundToInt(r111.getAlpha() * RangesKt.coerceIn(r122, 0.0f, 1.0f)), 0, 255));     // Catch: Throwable -> L119
        a(r111, r311.f533940d);     // Catch: Throwable -> L119
        ?? r133 = r312.f403331i;     // Catch: Throwable -> L119
        if (Float.isNaN(r312.f403329g) == false) goto L99;
        Float r134 = null;
    L143:
        if (r133 == 0) goto L107;
        if (r134 == null) goto L107;
        LinearGradient r213 = r119;
        float r313 = r115;
        boolean r314 = r116;
        float r315 = r118;
        float r316 = r117;
        int r317 = r109;
        Xfermode r318 = r108;
        MaskFilter r319 = r107;
        r312 = r114;
        r133 = r113;
        i(r310, r111, r110, r132, r211, r129, r134.floatValue(), r133, r210, r318);     // Catch: Throwable -> L117
        ?? r135 = r111;
        ?? r136 = r110;
        ?? r137 = r212;
        r111 = r111;
        r110 = r110;
        r212 = r212;
        r311 = r318;
    L110:
        r135.setColor(r137);
        r135.setAlpha(r133);
        r135.setShader(r312);
        r135.setMaskFilter(r319);
        r135.setSubpixelText(r314);
        r135.setLetterSpacing(r313);
        r136.f542604h = r316;
        r136.f542605i = r315;
        r136.f542606j = r213;
        if (r317 < 29) goto L113;
        r135.setBlendMode(r210);
    L113:
        r135.setXfermode(r311);
        return;
    L105:
        th = th;
    L121:
        ?? r138 = r110;
        LinearGradient r139 = r119;
        r116 = r116;
        ?? r140 = r212;
        r115 = r115;
        int r141 = 29;
        r118 = r118;
        ?? r142 = r111;
        ?? r143 = r108;
        ?? r144 = r114;
        ?? r145 = r113;
    L131:
        r142.setColor(r140);
        r142.setAlpha(r145);
        r142.setShader(r144);
        r142.setMaskFilter(r107);
        r142.setSubpixelText(r116);
        int r146 = Build.VERSION.SDK_INT;
        r142.setLetterSpacing(r115);
        r138.f542604h = r117;
        r138.f542605i = r118;
        r138.f542606j = r139;
        if (r146 < r141) goto L134;
        r142.setBlendMode(r210);
    L134:
        r142.setXfermode(r143);
        throw th;
    L107:
        r315 = r118;
        r316 = r117;
        r319 = r107;
        Shader r320 = r114;
        int r147 = r113;
        Xfermode r321 = r108;
        r213 = r119;
        r314 = r116;
        r317 = r109;
        r313 = r115;
        Paint r148 = sma.b.a(r111);     // Catch: Throwable -> L117
        ?? r149 = r212;
        ?? r150 = r111;
        float r151 = r132;
        ?? r152 = r110;
        float r153 = r211;
        BlendMode r214 = r210;
        sma.b.b(r310, r151, r153, r148, r150, r152, r129, getBaseline(), r132, r211, getHeight(), r127, new OProtocolTextEffectTextView$drawTextLayer$2(this), r214, r321);     // Catch: Throwable -> L115
        r137 = r149;
        r135 = r150;
        r136 = r152;
        r133 = r147;
        r111 = r151;
        r110 = r153;
        r212 = r214;
        r311 = r321;
        r312 = r320;
    L115:
        th = th;
        r143 = r321;
        r144 = r320;
        r139 = r213;
        r115 = r313;
        r116 = r314;
        r118 = r315;
        r117 = r316;
        r107 = r319;
        r141 = 29;
        r140 = r149;
        r142 = r150;
        r138 = r152;
        r145 = r147;
    L117:
        th = th;
        r144 = r312;
        r142 = r111;
        r138 = r110;
        r140 = r212;
        r139 = r213;
        r115 = r313;
        r116 = r314;
        r118 = r315;
        r117 = r316;
        r107 = r319;
        r141 = 29;
        r143 = r311;
        r145 = r133;
        goto L131
    L99:
        r134 = Float.valueOf(r312.f403329g);     // Catch: Throwable -> L119
    L119:
        th = th;
    L122:
        th = th;
        r115 = r115;
        r117 = r117;
        r107 = r107;
        r144 = r114;
        r145 = r113;
        r138 = r110;
        r141 = 29;
        r139 = r119;
        r116 = r116;
        r118 = r118;
        r142 = r111;
        r143 = r108;
        r140 = r212;
    L124:
        th = th;
        r141 = 29;
        r139 = r119;
        Xfermode r154 = r108;
    L126:
        r144 = r114;
        r140 = r112;
        r142 = r111;
        r138 = r110;
        r145 = r113;
        r143 = r154;
    L127:
        th = th;
        r115 = r115;
        r116 = r116;
        r117 = r117;
        r107 = r107;
        r144 = r114;
        r145 = r113;
        r140 = r112;
        r138 = r110;
        r139 = r119;
        r141 = 29;
        r118 = r118;
        r142 = r111;
        r143 = r108;
        goto L131
    L80:
        r123 = r312.f403330h;     // Catch: Throwable -> L129
    L129:
        th = th;
        r141 = 29;
        r139 = r119;
        r154 = r108;
        goto L126
    L72:
        r121 = r312.f403328f;
        goto L73
    L68:
        r120 = r312.f403327e;
        goto L70
    L64:
        r210 = null;
        goto L65
    L153:
        return;
    L56:
        r106 = false;
        goto L57
    L48:
        if (o(r104, r102) == false) goto L50;
    L5:
        if (r101 != 2) goto L7;
        CharSequence r155 = this.f403283g;
        if (r155 != null) goto L28;
        r155 = getText();
    L28:
        if (r155 == null) goto L31;
        r102 = r155;
    L31:
        r104 = this.f403286j;
        if (r104 != null) goto L35;
    L37:
        r104 = null;
    L38:
        if (r104 != null) goto L53;
        r104 = d(r102);
        this.f403286j = r104;
        int r156 = f.f403310a;
        getLogTag();
        goto L53
    L35:
        if (o(r104, r102) == false) goto L37;
    L7:
        if (r101 != 3) goto L24;
        CharSequence r157 = this.f403284h;
        if (r157 != null) goto L11;
        r157 = getText();
    L11:
        if (r157 == null) goto L14;
        r102 = r157;
    L14:
        r104 = this.f403287k;
        if (r104 != null) goto L18;
    L20:
        r104 = null;
    L21:
        if (r104 != null) goto L53;
        r104 = d(r102);
        this.f403287k = r104;
        int r158 = f.f403310a;
        getLogTag();
        goto L53
    L18:
        if (o(r104, r102) == false) goto L20;
    L24:
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ OProtocolTextEffectTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void h(Drawable r100, Canvas r101, int r102, int r103) {
        int r104 = r101.save();
        r101.translate(r102, r103);     // Catch: Throwable -> L6
        r100.draw(r101);     // Catch: Throwable -> L6
        r101.restoreToCount(r104);
        return;
    L6:
        th = move-exception;
        r101.restoreToCount(r104);
        throw th;
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        int r104 = f.f403310a;
        getLogTag();
        this.f403285i = null;
        this.f403286j = null;
        this.f403287k = null;
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        super.onTextChanged(r100, r101, r102, r103);
        this.f403285i = null;
    }

    public static void t(final OProtocolTextEffectTextView r100, final k r101, String r102, boolean r103, CharSequence r104, CharSequence r110, CharSequence r111, int r112) {
        int r105 = 0;
        if ((r112 & 4) == 0) goto L6;
        r103 = false;
    L6:
        if ((r112 & 8) == 0) goto L9;
        r104 = null;
    L9:
        if ((r112 & 16) == 0) goto L12;
        r110 = null;
    L12:
        if ((r112 & 32) == 0) goto L14;
        r111 = null;
    L14:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "spec");
        Intrinsics.checkNotNullParameter(r102, "effectName");
        int r113 = f.f403310a;
        r100.getLogTag();
        if (r103 == true) goto L25;
        if (r100.f403280d == null) goto L19;
        r100.getLogTag();
    L19:
        ValueAnimator r106 = r100.f403280d;
        if (r106 == null) goto L23;
        r106.cancel();
    L23:
        r100.f403280d = null;
        r100.f403281e = 0;
    L32:
        r100.f403279c = r101;
        r100.f403288l = r102;
        r100.f403281e = 0;
        r100.f403282f = r104;
        r100.f403283g = r110;
        r100.f403284h = r111;
        r100.f403286j = null;
        r100.f403287k = null;
        r100.r(r102, r101);
        Ref.BooleanRef r107 = new Ref.BooleanRef();
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r108.setDuration(RangesKt.coerceAtLeast(MathKt.roundToInt(r101.f533973c * r100.f403289m), 1));
        r108.setInterpolator(new LinearInterpolator());
        if (Intrinsics.areEqual(r101.f533974d, g.b.f533959a) == false) goto L35;
        r105 = -1;
    L35:
        r108.setRepeatCount(r105);
        r108.setRepeatMode(1);
        r108.addUpdateListener(new d(r100, r101));
        r108.addListener(new e(r107, r100, r101));
        r108.start();
        r100.f403280d = r108;
        r100.invalidate();
        return;
    L25:
        if (r100.f403280d == null) goto L27;
        r100.getLogTag();
    L27:
        ValueAnimator r109 = r100.f403280d;
        if (r109 == null) goto L31;
        r109.cancel();
    L31:
        r100.f403280d = null;
        goto L32
    }

    public final void i(Canvas r210, Paint r211, sma.c r212, float r213, float r214, float r215, float r216, j.b r217, BlendMode r218, Xfermode r219) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        Intrinsics.checkNotNullParameter(r211, "paint");
        Intrinsics.checkNotNullParameter(r212, "cache");
        Intrinsics.checkNotNullParameter(r217, "selector");
        float r100 = r212.f542604h;
        float r110 = r215 + (r100 * r216);
        float r101 = RangesKt.coerceAtLeast(r100 * r217.f533969c, this.f403277a.invoke(Float.valueOf(r217.f533970d)).floatValue());
        int r102 = f.f403310a;
        getLogTag();
        Paint r103 = sma.b.a(r211);
        float r104 = getBaseline();
        float r111 = r110 + r101;
        float r112 = getHeight();
        if (r217.f533968b == Direction.RightToLeft) goto L5;
        boolean r113 = true;
    L6:
        Intrinsics.checkNotNullParameter(r210, "canvas");
        Intrinsics.checkNotNullParameter(r211, "paint");
        Intrinsics.checkNotNullParameter(r212, "cache");
        int r105 = r210.saveLayer(r213, 0.0f, r214, r112, r103);
        int r106 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L25
        if (r106 < 29) goto L10;
        r211.setBlendMode(null);     // Catch: Throwable -> L25
    L10:
        r211.setXfermode(null);     // Catch: Throwable -> L25
        r211.setMaskFilter(null);     // Catch: Throwable -> L25
        char[] r107 = r212.f542599c;     // Catch: Throwable -> L25
        r210.drawText(r107, 0, r107.length, r215, r104, r211);     // Catch: Throwable -> L22
        if (r113 == false) goto L15;
        LinearGradient r108 = sma.b.f542595d;     // Catch: Throwable -> L22
    L16:
        Matrix r109 = sma.b.f542594c;     // Catch: Throwable -> L22
        r109.reset();     // Catch: Throwable -> L22
        r109.setScale(RangesKt.coerceAtLeast(r111 - r110, 0.001f), 1.0f);     // Catch: Throwable -> L22
        r109.postTranslate(r110, 0.0f);     // Catch: Throwable -> L22
        r108.setLocalMatrix(r109);     // Catch: Throwable -> L22
        Paint r114 = sma.b.f542593b;     // Catch: Throwable -> L22
        r114.setShader(r108);     // Catch: Throwable -> L22
        r210.drawRect(r213, 0.0f, r214, r112, r114);     // Catch: Throwable -> L22
        r114.setShader(null);
        r210.restoreToCount(r105);
        if (r106 < 29) goto L20;
        r211.setBlendMode(r218);
    L20:
        r211.setXfermode(r219);
        return;
    L15:
        r108 = sma.b.f542596e;     // Catch: Throwable -> L22
    L22:
        th = th;
        int r115 = r105;
        Shader r116 = null;
    L27:
        sma.b.f542593b.setShader(r116);
        r210.restoreToCount(r115);
        if (Build.VERSION.SDK_INT < 29) goto L30;
        r211.setBlendMode(r218);
    L30:
        r211.setXfermode(r219);
        throw th;
    L25:
        th = th;
        r116 = null;
        r115 = r105;
        goto L27
    L5:
        r113 = false;
        goto L6
    }
}
