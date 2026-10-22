package com.obric.oui.privacy.recyclerview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R*\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011¨\u0006$"}, d2 = {"Lcom/obric/oui/privacy/recyclerview/PrivacyTopDownAlphaMaskRecyclerView;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "", "value", "H2", FaceService.girlLabel, "getFadeEdgeLength", "()F", "setFadeEdgeLength", "(F)V", "fadeEdgeLength", "", "I2", "Z", "getDynamicFade", "()Z", "setDynamicFade", "(Z)V", "dynamicFade", "J2", "getFadeTop", "setFadeTop", "fadeTop", "K2", "getFadeBottom", "setFadeBottom", "fadeBottom", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class PrivacyTopDownAlphaMaskRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: d3, reason: collision with root package name */
    public static final float[] f402500d3 = null;
    public float H2;
    public boolean I2;
    public boolean J2;
    public boolean K2;
    public float L2;
    public float M2;
    public final Paint N2;
    public final PorterDuffXfermode O2;
    public LinearGradient P2;
    public LinearGradient Q2;
    public final Matrix R2;
    public final Matrix S2;
    public int T2;
    public int U2;
    public float V2;
    public float W2;
    public float X2;
    public ValueAnimator Y2;
    public float Z2;

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    public float f402501a3;

    /* JADX INFO: renamed from: b3, reason: collision with root package name */
    public boolean f402502b3;

    /* JADX INFO: renamed from: c3, reason: collision with root package name */
    public boolean f402503c3;

    public static final class a extends RecyclerView.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PrivacyTopDownAlphaMaskRecyclerView f402504a;

        public a(PrivacyTopDownAlphaMaskRecyclerView r100) {
            this.f402504a = r100;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.o
        public final void a(RecyclerView r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            if (r101 != 1) goto L6;
            this.f402504a.f402502b3 = true;
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.o
        public final void b(RecyclerView r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "recyclerView");
            PrivacyTopDownAlphaMaskRecyclerView r103 = this.f402504a;
            if (r103.f402502b3 == true) goto L5;
            return;
        L5:
            r103.c0(true);
        }
    }

    public static final class b {
    }

    public PrivacyTopDownAlphaMaskRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PrivacyTopDownAlphaMaskRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void b0() {
        this.T2 = -1;
        this.U2 = -1;
        this.V2 = -1.0f;
        this.W2 = Float.NaN;
        this.X2 = Float.NaN;
        this.P2 = null;
        this.Q2 = null;
    }

    static {
        f402500d3 = new float[]{0.0f, 1.0f};
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.Y2;
        if (r100 == null) goto L6;
        r100.cancel();
    L6:
        removeCallbacks(null);
    }

    public final boolean getDynamicFade() {
        return this.I2;
    }

    public final boolean getFadeBottom() {
        return this.K2;
    }

    public final float getFadeEdgeLength() {
        return this.H2;
    }

    public final boolean getFadeTop() {
        return this.J2;
    }

    public final void c0(boolean r110) {
        boolean r100 = canScrollVertically(-1);
        boolean r101 = true;
        boolean r102 = canScrollVertically(1);
        if (this.J2 == false) goto L6;
        if (r100 == false) goto L6;
        final float r103 = 1.0f;
    L8:
        if (this.K2 == false) goto L11;
        if (r102 == false) goto L11;
        final float r111 = 1.0f;
    L12:
        if (r110 == true) goto L14;
        this.Z2 = r103;
        this.f402501a3 = r111;
        this.L2 = r103;
        this.M2 = r111;
        b0();
        invalidate();
        return;
    L14:
        if (this.Z2 != r103) goto L16;
        boolean r112 = true;
    L17:
        if (r112 == true) goto L19;
    L24:
        this.Z2 = r103;
        this.f402501a3 = r111;
        final float r104 = this.L2;
        final float r113 = this.M2;
        if (r104 != r103) goto L27;
        boolean r114 = true;
    L28:
        if (r114 == true) goto L30;
    L35:
        ValueAnimator r115 = this.Y2;
        if (r115 == null) goto L39;
        r115.cancel();
    L39:
        ValueAnimator r116 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r116.setDuration(100);
        r116.addUpdateListener(new ima.b(this, r104, r103, r113, r111));
        this.Y2 = r116;
        r116.start();
        return;
    L30:
        if (r113 == r111) goto L33;
        r101 = false;
    L33:
        if (r101 == false) goto L35;
        return;
    L27:
        r114 = false;
        goto L28
    L19:
        if (this.f402501a3 != r111) goto L21;
        boolean r117 = true;
    L22:
        if (r117 == false) goto L24;
        return;
    L21:
        r117 = false;
        goto L22
    L16:
        r112 = false;
    L11:
        r111 = 0.0f;
    L6:
        r103 = 0.0f;
        goto L8
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public final void draw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        if (getWidth() > 0) goto L5;
    L84:
        super.draw(r210);
        return;
    L5:
        if (getHeight() <= 0) goto L84;
        if (this.H2 <= 0.0f) goto L84;
        if (this.J2 == true) goto L14;
        if (this.K2 == true) goto L14;
    L17:
        super.draw(r210);
        return;
    L14:
        if (this.L2 > 0.0f) goto L20;
        if (this.M2 <= 0.0f) goto L17;
    L20:
        if (this.T2 == getWidth()) goto L22;
    L39:
        this.T2 = getWidth();
        this.U2 = getHeight();
        float r100 = this.H2;
        this.V2 = r100;
        this.W2 = this.L2;
        this.X2 = this.M2;
        float r101 = RangesKt.coerceAtMost(r100, getHeight());
        if (getWidth() > 0) goto L42;
    L59:
        this.P2 = null;
        this.Q2 = null;
    L60:
        int r102 = r210.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.draw(r210);
        this.N2.setXfermode(this.O2);
        if (this.J2 == false) goto L72;
        if (this.L2 <= 0.0f) goto L72;
        float r103 = RangesKt.coerceAtMost(this.H2, getHeight());
        if (r103 <= 0.0f) goto L72;
        LinearGradient r104 = this.P2;
        if (r104 == null) goto L72;
        this.R2.reset();
        r104.setLocalMatrix(this.R2);
        this.N2.setShader(r104);
        r210.drawRect(0.0f, 0.0f, getWidth(), r103, this.N2);
    L72:
        if (this.K2 == true) goto L74;
    L82:
        this.N2.setXfermode(null);
        this.N2.setShader(null);
        r210.restoreToCount(r102);
        return;
    L74:
        if (this.M2 <= 0.0f) goto L82;
        float r105 = RangesKt.coerceAtMost(this.H2, getHeight());
        if (r105 <= 0.0f) goto L82;
        float r106 = getHeight();
        float r107 = RangesKt.coerceAtLeast(r106 - r105, 0.0f);
        LinearGradient r108 = this.Q2;
        if (r108 == null) goto L82;
        this.S2.reset();
        this.S2.setTranslate(0.0f, r107);
        r108.setLocalMatrix(this.S2);
        this.N2.setShader(r108);
        r210.drawRect(0.0f, r107, getWidth(), r106, this.N2);
        goto L82
    L42:
        if (getHeight() <= 0) goto L59;
        if (r101 <= 0.0f) goto L59;
        float r109 = RangesKt.coerceIn(this.L2, 0.0f, 1.0f);
        float r110 = RangesKt.coerceIn(this.M2, 0.0f, 1.0f);
        int r111 = RangesKt.coerceIn((int) ((1.0f - r109) * 255.0f), 0, 255);
        int r112 = RangesKt.coerceIn((int) ((1.0f - r110) * 255.0f), 0, 255);
        float[] r113 = f402500d3;
        if (r109 > 0.0f) goto L49;
    L51:
        int r114 = 2;
        LinearGradient r115 = null;
    L52:
        this.P2 = r115;
        if (r110 > 0.0f) goto L55;
    L57:
        LinearGradient r116 = null;
    L58:
        this.Q2 = r116;
        goto L60
    L55:
        if (this.Q2 != null) goto L57;
        int[] r117 = new int[r114];
        r117[0] = Color.argb(r112, 0, 0, 0);
        r117[1] = Color.argb(255, 0, 0, 0);
        r116 = new LinearGradient(0.0f, r101, 0.0f, 0.0f, r117, r113, Shader.TileMode.CLAMP);
        goto L58
    L49:
        if (this.P2 != null) goto L51;
        r114 = 2;
        r115 = new LinearGradient(0.0f, 0.0f, 0.0f, r101, new int[]{Color.argb(r111, 0, 0, 0), Color.argb(255, 0, 0, 0)}, r113, Shader.TileMode.CLAMP);
        goto L52
    L22:
        if (this.U2 != getHeight()) goto L39;
        if (this.V2 != this.H2) goto L26;
        boolean r118 = true;
    L27:
        if (r118 == false) goto L39;
        if (this.W2 != this.L2) goto L31;
        boolean r119 = true;
    L32:
        if (r119 == false) goto L39;
        if (this.X2 != this.M2) goto L36;
        boolean r120 = true;
    L37:
        if (r120 == false) goto L39;
    L36:
        r120 = false;
        goto L37
    L31:
        r119 = false;
        goto L32
    L26:
        r118 = false;
        goto L27
    }

    public final void setDynamicFade(boolean r100) {
        this.I2 = r100;
    }

    public final void setFadeBottom(boolean r100) {
        if (this.K2 != r100) goto L5;
        return;
    L5:
        this.K2 = r100;
        invalidate();
    }

    public final void setFadeEdgeLength(float r100) {
        float r101 = RangesKt.coerceAtLeast(r100, 0.0f);
        if (this.H2 != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        this.H2 = r101;
        b0();
        invalidate();
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setFadeTop(boolean r100) {
        if (this.J2 != r100) goto L5;
        return;
    L5:
        this.J2 = r100;
        invalidate();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if ((getLayoutManager() instanceof LinearLayoutManager) == true) goto L5;
        return;
    L5:
        if (this.f402503c3 == false) goto L27;
        int r102 = computeVerticalScrollRange();
        if (r102 <= 0) goto L28;
        int r103 = 0;
        this.f402503c3 = false;
        if (r102 > ((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom())) goto L11;
        boolean r104 = true;
    L12:
        RecyclerView.k r105 = getLayoutManager();
        if (r105 == null) goto L25;
        if (((LinearLayoutManager) r105).f401565t == r104) goto L21;
        RecyclerView.k r106 = getLayoutManager();
        if (r106 == null) goto L20;
        ((LinearLayoutManager) r106).S0(r104);
        goto L21
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.LinearLayoutManager");
    L21:
        if (r104 == false) goto L23;
        r103 = 2;
    L23:
        setOverScrollMode(r103);
        return;
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.LinearLayoutManager");
    L11:
        r104 = false;
        goto L12
    L28:
        return;
    }

    public PrivacyTopDownAlphaMaskRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Resources r103 = getResources();
        this.H2 = TypedValue.applyDimension(1, 75.0f, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()));
        this.I2 = true;
        this.J2 = true;
        this.K2 = true;
        this.N2 = new Paint(1);
        this.O2 = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.R2 = new Matrix();
        this.S2 = new Matrix();
        this.T2 = -1;
        this.U2 = -1;
        this.V2 = -1.0f;
        this.W2 = Float.NaN;
        this.X2 = Float.NaN;
        this.f402503c3 = true;
        if (this.I2 == false) goto L6;
        j(new a(this));
        return;
    }

    public /* synthetic */ PrivacyTopDownAlphaMaskRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        b0();
        post(new ima.a(this));
    }
}
