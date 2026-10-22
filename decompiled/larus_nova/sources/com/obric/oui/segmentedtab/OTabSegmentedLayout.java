package com.obric.oui.segmentedtab;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.common.style.r;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0005pqrstB'\b\u0007\u0012\u0006\u0010j\u001a\u00020i\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010k\u0012\b\b\u0002\u0010m\u001a\u00020\u0004¢\u0006\u0004\bn\u0010oJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0010R$\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00188\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010(\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010-\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010\u0014R(\u00108\u001a\b\u0012\u0004\u0012\u000201008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u00109\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b:\u0010\u0016\"\u0004\b;\u0010<R$\u0010=\u001a\u00020\u00182\u0006\u0010=\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u0010\u001c\"\u0004\b?\u0010@R$\u0010B\u001a\u00020\n2\u0006\u0010A\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010)\"\u0004\bC\u0010+R$\u0010D\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u001c\"\u0004\bF\u0010@R$\u0010G\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bH\u0010\u0016\"\u0004\bI\u0010<R$\u0010J\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bK\u0010\u001c\"\u0004\bL\u0010@R$\u0010M\u001a\u00020\u00182\u0006\u0010M\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010\u001c\"\u0004\bO\u0010@R$\u0010P\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010\u0016\"\u0004\bR\u0010<R$\u0010S\u001a\u00020\u00182\u0006\u0010S\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010\u001c\"\u0004\bU\u0010@R$\u0010V\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010\u001c\"\u0004\bX\u0010@R$\u0010\\\u001a\u00020\u00182\u0006\u0010Y\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u0010\u001c\"\u0004\b[\u0010@R$\u0010]\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b^\u0010\u0016\"\u0004\b_\u0010<R$\u0010`\u001a\u00020\u00042\u0006\u0010`\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\ba\u0010\u0016\"\u0004\bb\u0010<R$\u0010c\u001a\u00020\u00042\u0006\u0010c\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bd\u0010\u0016\"\u0004\be\u0010<R$\u0010g\u001a\u00020\n2\u0006\u0010f\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bg\u0010)\"\u0004\bh\u0010+¨\u0006u"}, d2 = {"Lcom/obric/oui/segmentedtab/OTabSegmentedLayout;", "Landroid/widget/FrameLayout;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/Animator$AnimatorListener;", "", "index", "", "setFragments", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "", "enabled", "setEnabled", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$e;", "listener", "setOnTabSelectListener", "Lcom/obric/oui/segmentedtab/OTabSegmentedLayout$d;", "setOnTabSelectAnimListener", "<set-?>", "h", "I", "getTabCount", "()I", "tabCount", "", "s", FaceService.girlLabel, "getIndicatorSpacing", "()F", "indicatorSpacing", "", "t", "J", "getIndicatorAnimDuration", "()J", "setIndicatorAnimDuration", "(J)V", "indicatorAnimDuration", "u", "Z", "isIndicatorAnimEnable", "()Z", "setIndicatorAnimEnable", "(Z)V", BaseSwitches.V, "isIndicatorBounceEnable", "setIndicatorBounceEnable", "mBarColor", "", "Landroid/view/View;", "R", "Ljava/util/List;", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabList", "currentTab", "getCurrentTab", "setCurrentTab", "(I)V", "tabPadding", "getTabPadding", "setTabPadding", "(F)V", "tabSpaceEqual", "isTabSpaceEqual", "setTabSpaceEqual", "tabWidth", "getTabWidth", "setTabWidth", "indicatorColor", "getIndicatorColor", "setIndicatorColor", "indicatorHeight", "getIndicatorHeight", "setIndicatorHeight", "indicatorCornerRadius", "getIndicatorCornerRadius", "setIndicatorCornerRadius", "dividerColor", "getDividerColor", "setDividerColor", "dividerWidth", "getDividerWidth", "setDividerWidth", "dividerPadding", "getDividerPadding", "setDividerPadding", "textSize", "getTextsize", "setTextsize", "textsize", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "textBold", "getTextBold", "setTextBold", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OTabSegmentedLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    public static final /* synthetic */ int W = 0;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public int E;
    public float F;
    public boolean G;
    public float H;
    public float I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public float f402714J;
    public final ValueAnimator K;
    public final PathInterpolator L;
    public final float[] M;
    public final Paint N;
    public final Paint O;
    public final RectF P;
    public final RectF Q;
    public List<View> R;
    public boolean S;
    public e T;
    public final b U;
    public final b V;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f402715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f402716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable[] f402717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f402718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f402719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f402720f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f402721g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f402722h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Rect f402723i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f402724j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f402725k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f402726l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f402727m;
    private int mBarColor;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f402728n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f402729o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f402730p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f402731q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f402732r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f402733s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f402734t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f402735u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f402736v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f402737w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f402738x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f402739y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f402740z;

    public static final class a {
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f402741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f402742b;

        public final String toString() {
            return "(left = " + this.f402741a + ", right = " + this.f402742b + ')';
        }

        public b(OTabSegmentedLayout r100) {
            Intrinsics.checkNotNullParameter(r100, "this$0");
        }
    }

    public final class c implements TypeEvaluator<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OTabSegmentedLayout f402743a;

        public c(OTabSegmentedLayout r100) {
            Intrinsics.checkNotNullParameter(r100, "this$0");
            this.f402743a = r100;
        }

        @Override // android.animation.TypeEvaluator
        public final b evaluate(float r100, b r101, b r102) {
            b r103 = r101;
            b r104 = r102;
            Intrinsics.checkNotNullParameter(r103, "startValue");
            Intrinsics.checkNotNullParameter(r104, "endValue");
            float r105 = r103.f402741a;
            float r106 = r105 + ((r104.f402741a - r105) * r100);
            float r107 = r103.f402742b;
            float r108 = r107 + (r100 * (r104.f402742b - r107));
            b r109 = new b(this.f402743a);
            r109.f402741a = r106;
            r109.f402742b = r108;
            return r109;
        }
    }

    public interface d {
    }

    public interface e {
        void a();

        void onSelect(int r100);
    }

    static {
    }

    public OTabSegmentedLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OTabSegmentedLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final void setFragments(int r100) {
    }

    public final Fragment getCurrentFragment() {
        return null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    public final void setOnTabSelectAnimListener(d r100) {
    }

    public final void b() {
        View r100 = this.f402718d.getChildAt(this.f402719e);
        float r101 = r100.getLeft();
        float r102 = r100.getRight();
        Rect r103 = this.f402723i;
        r103.left = (int) r101;
        r103.right = (int) r102;
        if (this.f402735u == true) goto L11;
        int r104 = this.f402719e;
        if (r104 != 0) goto L8;
        float[] r105 = this.M;
        float r110 = this.f402732r;
        r105[0] = r110;
        r105[1] = r110;
        r105[2] = 0.0f;
        r105[3] = 0.0f;
        r105[4] = 0.0f;
        r105[5] = 0.0f;
        r105[6] = r110;
        r105[7] = r110;
        return;
    L8:
        if (r104 != (this.f402722h - 1)) goto L10;
        float[] r106 = this.M;
        r106[0] = 0.0f;
        r106[1] = 0.0f;
        float r107 = this.f402732r;
        r106[2] = r107;
        r106[3] = r107;
        r106[4] = r107;
        r106[5] = r107;
        r106[6] = 0.0f;
        r106[7] = 0.0f;
        return;
    L10:
        float[] r108 = this.M;
        r108[0] = 0.0f;
        r108[1] = 0.0f;
        r108[2] = 0.0f;
        r108[3] = 0.0f;
        r108[4] = 0.0f;
        r108[5] = 0.0f;
        r108[6] = 0.0f;
        r108[7] = 0.0f;
        return;
    L11:
        float[] r109 = this.M;
        float r111 = this.f402732r;
        r109[0] = r111;
        r109[1] = r111;
        r109[2] = r111;
        r109[3] = r111;
        r109[4] = r111;
        r109[5] = r111;
        r109[6] = r111;
        r109[7] = r111;
    }

    public final void g() {
        int r100 = this.f402722h;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L30;
        int r102 = r101 + 1;
        View r103 = this.f402718d.getChildAt(r101);
        int r104 = (int) this.f402727m;
        r103.setPadding(r104, 0, r104, 0);
        View r105 = r103.findViewById(R.id.tv_tab_title);
        if (r105 == null) goto L29;
        TextView r106 = (TextView) r105;
        int r107 = this.f402719e;
        if (r101 != r107) goto L9;
        boolean r108 = true;
    L10:
        if (r101 != r107) goto L12;
        int r109 = this.A;
    L13:
        r106.setTextColor(r109);
        r106.setTextSize(0, this.f402740z);
        ImageView r110 = (ImageView) r103.findViewById(R.id.tv_tab_icon);
        if (r101 != this.f402719e) goto L16;
        int r111 = this.A;
    L17:
        r110.setImageTintList(ColorStateList.valueOf(r111));
        if (this.D == false) goto L20;
        r106.setText(r106.getText().toString().toUpperCase(Locale.ROOT));
    L20:
        int r112 = this.C;
        if (r112 != 2) goto L23;
        a(r106.getPaint(), true);
    L27:
        r101 = r102;
        goto L3
    L23:
        if (r112 != 0) goto L25;
        a(r106.getPaint(), false);
        goto L27
    L25:
        if (r112 != 1) goto L27;
        a(r106.getPaint(), r108);
        goto L27
    L16:
        r111 = this.B;
        goto L17
    L12:
        r109 = this.B;
        goto L13
    L9:
        r108 = false;
        goto L10
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putParcelable("instanceState", super.onSaveInstanceState());
        r100.putInt("mCurrentTab", this.f402719e);
        return r100;
    }

    public final int getCurrentTab() {
        return this.f402719e;
    }

    public final int getDividerColor() {
        return this.f402737w;
    }

    public final float getDividerPadding() {
        return this.f402739y;
    }

    public final float getDividerWidth() {
        return this.f402738x;
    }

    public final long getIndicatorAnimDuration() {
        return this.f402734t;
    }

    public final int getIndicatorColor() {
        return this.f402730p;
    }

    public final float getIndicatorCornerRadius() {
        return this.f402732r;
    }

    public final float getIndicatorHeight() {
        return this.f402731q;
    }

    public final float getIndicatorSpacing() {
        return this.f402733s;
    }

    public final int getTabCount() {
        return this.f402722h;
    }

    public final List<View> getTabList() {
        return this.R;
    }

    public final float getTabPadding() {
        return this.f402727m;
    }

    public final float getTabWidth() {
        return this.f402729o;
    }

    public final int getTextBold() {
        return this.C;
    }

    public final int getTextSelectColor() {
        return this.A;
    }

    public final int getTextUnselectColor() {
        return this.B;
    }

    public final float getTextsize() {
        return this.f402740z;
    }

    public final int d(float r100) {
        Resources r101 = this.f402715a.getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final void f(int r110) {
        int r100 = this.f402722h;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L28;
        int r102 = r101 + 1;
        View r103 = this.f402718d.getChildAt(r101);
        if (r101 != r110) goto L7;
        boolean r104 = true;
    L8:
        View r105 = r103.findViewById(R.id.tv_tab_title);
        if (r105 == null) goto L27;
        TextView r106 = (TextView) r105;
        ImageView r107 = (ImageView) r103.findViewById(R.id.tv_tab_icon);
        if (r104 == false) goto L13;
        int r108 = this.A;
    L14:
        r107.setImageTintList(ColorStateList.valueOf(r108));
        if (this.C != 1) goto L17;
        a(r106.getPaint(), r104);
        r106.invalidate();
    L17:
        int r109 = vma.c.f556351a;
        if ((r103 instanceof OSegmentTabView) == true) goto L21;
        r103 = null;
    L21:
        OSegmentTabView r111 = (OSegmentTabView) r103;
        if (r111 == null) goto L25;
        r111.d(r104);
    L25:
        r101 = r102;
        goto L3
    L13:
        r108 = this.B;
        goto L14
    L27:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L7:
        r104 = false;
        goto L8
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        b r102 = (b) r101;
        Rect r103 = this.f402723i;
        r103.left = (int) r102.f402741a;
        r103.right = (int) r102.f402742b;
        invalidate();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.segmentedtab.OTabSegmentedLayout.IndicatorPoint");
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.H = pla.d.q(this, 10);
        this.I = pla.d.q(this, 0);
        this.f402714J = pla.d.q(this, 4);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.f402722h <= 0) goto L42;
        int r100 = getHeight();
        int r101 = getPaddingLeft();
        if (this.f402731q >= 0.0f) goto L10;
        this.f402731q = r100 - (this.f402733s * 2);
    L10:
        float r102 = this.f402732r;
        if (r102 >= 0.0f) goto L13;
    L14:
        this.f402732r = this.f402731q;
    L15:
        this.N.setColor(this.mBarColor);
        this.P.set(0.0f, getPaddingTop(), getWidth(), r100 - getPaddingBottom());
        float r103 = 2;
        float r104 = this.f402732r + (this.f402733s / r103);
        r.e(r110, this.P, r104, this.N);
        if (this.F <= 0.0f) goto L19;
        this.O.setColor(this.E);
        this.O.setStrokeWidth(this.F);
        this.Q.set(this.F / r103, getPaddingTop() + (this.F / r103), getWidth() - (this.F / r103), (r100 - getPaddingBottom()) - (this.F / r103));
        r.e(r110, this.Q, r104, this.O);
    L19:
        if (this.f402735u == true) goto L26;
        float r105 = this.f402738x;
        if (r105 <= 0.0f) goto L26;
        this.f402726l.setStrokeWidth(r105);
        this.f402726l.setColor(this.f402737w);
        int r106 = this.f402722h - 1;
        int r107 = 0;
    L23:
        if (r107 >= r106) goto L26;
        int r108 = r107 + 1;
        View r109 = this.f402718d.getChildAt(r107);
        r110.drawLine(r109.getRight() + r101, this.f402739y, r109.getRight() + r101, r100 - this.f402739y, this.f402726l);
        r107 = r108;
    L26:
        if (this.f402735u == true) goto L28;
        b();
    L31:
        int r111 = this.f402720f;
        if (r111 == (-1)) goto L34;
        View r112 = this.f402718d.getChildAt(r111);
    L35:
        if (r112 == null) goto L38;
        this.f402724j.left = r112.getLeft();
        this.f402724j.right = r112.getRight();
    L38:
        float r113 = (this.f402733s / r103) + this.F;
        Paint r114 = this.f402725k;
        r114.setColor(this.f402730p);
        r114.setShadowLayer(this.H, this.I, this.f402714J, ContextCompat.getColor(getContext(), R.color.TabSegmentedShadowColor));
        Rect r115 = this.f402723i;
        float r116 = (r101 + r113) + r115.left;
        float r117 = this.f402733s;
        float r118 = this.F;
        r.d(r110, r116, r117 + r118, (r101 + r115.right) - r113, (r117 + this.f402731q) - r118, this.f402732r, this.f402725k);
        return;
    L34:
        r112 = null;
        goto L35
    L28:
        if (this.S == false) goto L31;
        this.S = false;
        b();
        goto L31
    L13:
        if (r102 <= (this.f402731q / 2)) goto L15;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if ((r100 instanceof Bundle) == false) goto L9;
        Bundle r101 = (Bundle) r100;
        this.f402719e = r101.getInt("mCurrentTab");
        r100 = r101.getParcelable("instanceState");
        if (this.f402719e == 0) goto L9;
        if (this.f402718d.getChildCount() <= 0) goto L9;
        f(this.f402719e);
    L9:
        super.onRestoreInstanceState(r100);
    }

    public final void setCurrentTab(int r100) {
        int r101 = this.f402719e;
        if (r100 != r101) goto L5;
        return;
    L5:
        this.S = true;
        this.f402721g = r101;
        this.f402719e = r100;
        f(r100);
        setFragments(r100);
        if (this.f402735u == false) goto L22;
        View r102 = this.f402718d.getChildAt(this.f402719e);
        this.U.f402741a = r102.getLeft();
        this.U.f402742b = r102.getRight();
        View r103 = this.f402718d.getChildAt(this.f402721g);
        this.V.f402741a = r103.getLeft();
        this.V.f402742b = r103.getRight();
        b r104 = this.V;
        float r105 = r104.f402741a;
        b r106 = this.U;
        if (r105 != r106.f402741a) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == true) goto L13;
    L18:
        this.K.setObjectValues(new Object[]{r104, r106});
        if (this.f402736v == false) goto L21;
        this.K.setInterpolator(this.L);
    L21:
        this.K.setDuration(350);
        this.K.start();
        return;
    L13:
        if (r104.f402742b != r106.f402742b) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == false) goto L18;
        invalidate();
        return;
    L15:
        r108 = false;
        goto L16
    L10:
        r107 = false;
        goto L11
    L22:
        invalidate();
    }

    public final void setDividerColor(int r100) {
        this.f402737w = r100;
        invalidate();
    }

    public final void setDividerPadding(float r100) {
        this.f402739y = d(r100);
        invalidate();
    }

    public final void setDividerWidth(float r100) {
        this.f402738x = d(r100);
        invalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        Iterator<View> r101 = this.R.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().setEnabled(r100);
        goto L4
    }

    public final void setIndicatorAnimDuration(long r100) {
        this.f402734t = r100;
    }

    public final void setIndicatorAnimEnable(boolean r100) {
        this.f402735u = r100;
    }

    public final void setIndicatorBounceEnable(boolean r100) {
        this.f402736v = r100;
    }

    public final void setIndicatorColor(int r100) {
        this.f402730p = r100;
        invalidate();
    }

    public final void setIndicatorCornerRadius(float r100) {
        this.f402732r = d(r100);
        invalidate();
    }

    public final void setIndicatorHeight(float r100) {
        this.f402731q = d(r100);
        invalidate();
    }

    public final void setOnTabSelectListener(e r100) {
        this.T = r100;
    }

    public final void setTabList(List<View> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.R = r100;
    }

    public final void setTabPadding(float r100) {
        this.f402727m = d(r100);
        g();
    }

    public final void setTabSpaceEqual(boolean r100) {
        this.f402728n = r100;
        g();
    }

    public final void setTabWidth(float r100) {
        this.f402729o = d(r100);
        g();
    }

    public final void setTextAllCaps(boolean r100) {
        this.D = r100;
        g();
    }

    public final void setTextBold(int r100) {
        this.C = r100;
        g();
    }

    public final void setTextSelectColor(int r100) {
        this.A = r100;
        g();
    }

    public final void setTextUnselectColor(int r100) {
        this.B = r100;
        g();
    }

    public final void setTextsize(float r100) {
        Resources r101 = this.f402715a.getResources();
        this.f402740z = (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).scaledDensity) + 0.5f);
        g();
    }

    public static void a(TextPaint r100, boolean r101) {
        if (r101 == false) goto L4;
        int r102 = 700;
    L5:
        r100.setTypeface(Typeface.create(null, r102, false));
        return;
    L4:
        r102 = 400;
        goto L5
    }

    public final void e(String[] r100, Drawable[] r110) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L25;
        if (r110 != null) goto L15;
    L21:
        boolean r103 = true;
    L22:
        if (r103 == false) goto L25;
        r101 = false;
        goto L25
    L15:
        if (r110.length != 0) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == true) goto L21;
        r103 = false;
        goto L22
    L17:
        r104 = false;
    L25:
        if (r101 == false) goto L73;
        this.f402716b = r100;
        this.f402717c = r110;
        this.f402718d.removeAllViews();
        String[] r105 = this.f402716b;
        if (r105 != null) goto L29;
        Integer r106 = null;
    L30:
        if (r106 != null) goto L35;
        Drawable[] r107 = this.f402717c;
        if (r107 != null) goto L34;
        int r108 = 0;
    L36:
        this.f402722h = r108;
        this.R.clear();
        int r109 = this.f402722h;
        int r111 = 0;
    L37:
        if (r111 >= r109) goto L70;
        int r112 = r111 + 1;
        int r113 = OSegmentTabView.f402704l;
        OSegmentTabView r114 = OSegmentTabView.a.a(this.f402715a);
        int r115 = this.A;
        int r116 = this.B;
        r114.f402708f = r115;
        r114.f402709g = r116;
        r114.setOriginIconAlpha(255);
        r114.setTag(Integer.valueOf(r111));
        View r117 = r114.findViewById(R.id.tv_tab_title);
        if (r117 == null) goto L69;
        TextView r118 = (TextView) r117;
        ImageView r119 = (ImageView) r114.findViewById(R.id.tv_tab_icon);
        String[] r120 = this.f402716b;
        if (r120 != null) goto L43;
        Unit r121 = null;
    L48:
        if (r121 != null) goto L50;
        r118.setVisibility(8);
    L50:
        Drawable[] r122 = this.f402717c;
        if (r122 != null) goto L53;
        Unit r123 = null;
    L54:
        if (r123 != null) goto L60;
        r119.setVisibility(8);
        ViewGroup.LayoutParams r124 = r118.getLayoutParams();
        if (r124 == null) goto L59;
        LinearLayout.LayoutParams r125 = (LinearLayout.LayoutParams) r124;
        r125.setMargins(0, 0, 0, 0);
        r118.setLayoutParams(r125);
        goto L60
    L59:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L60:
        r114.setOnTouchListener(new com.obric.oui.segmentedtab.d(this));
        r114.setOnClickListener(new com.obric.oui.segmentedtab.e(this));
        this.R.add(r114);
        if (this.f402728n == false) goto L63;
        LinearLayout.LayoutParams r126 = new LinearLayout.LayoutParams(0, -1, 1.0f);
    L65:
        if (this.f402729o <= 0.0f) goto L67;
        r126 = new LinearLayout.LayoutParams((int) this.f402729o, -1);
    L67:
        this.f402718d.addView(r114, r111, r126);
        r111 = r112;
        goto L37
    L63:
        r126 = new LinearLayout.LayoutParams(-2, -1);
        goto L65
    L53:
        r119.setImageDrawable(r122[r111]);
        r123 = Unit.INSTANCE;
        goto L54
    L43:
        String r127 = r120[r111];
        if (r127 != null) goto L46;
        r127 = "";
    L46:
        r118.setText(r127);
        r121 = Unit.INSTANCE;
        goto L48
    L69:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L70:
        g();
        return;
    L34:
        r108 = r107.length;
        goto L36
    L35:
        r108 = r106.intValue();
        goto L36
    L29:
        r106 = Integer.valueOf(r105.length);
        goto L30
    L73:
        throw new IllegalStateException("Titles and Drawables can not be NULL or EMPTY !".toString());
    L5:
        if (r100.length != 0) goto L7;
        boolean r128 = true;
    L8:
        if (r128 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r128 = false;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public OTabSegmentedLayout(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f402720f = -1;
        this.f402723i = new Rect();
        this.f402724j = new Rect();
        this.f402725k = new Paint();
        this.f402726l = new Paint(1);
        this.f402734t = 350;
        this.f402735u = true;
        this.G = true;
        this.L = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.M = new float[8];
        Paint r100 = new Paint(1);
        r100.setStyle(Paint.Style.FILL);
        this.N = r100;
        Paint r101 = new Paint(1);
        r101.setStyle(Paint.Style.STROKE);
        this.O = r101;
        this.P = new RectF();
        this.Q = new RectF();
        this.R = new ArrayList();
        this.S = true;
        new Paint(1);
        new SparseArray();
        b r102 = new b(this);
        this.U = r102;
        b r103 = new b(this);
        this.V = r103;
        this.H = pla.d.q(this, 10);
        this.I = pla.d.q(this, 0);
        this.f402714J = pla.d.q(this, 4);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f402715a = r110;
        LinearLayout r113 = new LinearLayout(r110);
        this.f402718d = r113;
        addView(r113);
        TypedArray r114 = r110.obtainStyledAttributes(r111, new int[]{R.attr.bar_color, R.attr.bar_stroke_color, R.attr.bar_stroke_width, R.attr.divider_color, R.attr.divider_padding, R.attr.divider_width, R.attr.enableDefaultMaskBackground, R.attr.indicator_anim_duration, R.attr.indicator_anim_enable, R.attr.indicator_background, R.attr.indicator_bounce_enable, R.attr.indicator_color, R.attr.indicator_corner_radius, R.attr.indicator_height, R.attr.indicator_marginBottom, R.attr.indicator_marginLeft, R.attr.indicator_marginRight, R.attr.indicator_marginTop, R.attr.indicator_spacing, R.attr.indicator_unselected_color, R.attr.maskBackground, R.attr.mask_blur_radius, R.attr.oui_alpha_disabled, R.attr.oui_bottomActionBarType, R.attr.oui_widgetBlurBlendModes, R.attr.oui_widgetBlurColors, R.attr.oui_widgetBlurRadius, R.attr.oui_widgetFitInsetBottom, R.attr.oui_widgetFitInsetLeft, R.attr.oui_widgetFitInsetRight, R.attr.oui_widgetFitInsetTop, R.attr.oui_widgetMaterial, R.attr.oui_widgetMaterialSrcType, R.attr.oui_widgetShadowNormal, R.attr.oui_widgetShadowPressed, R.attr.shadow_normal, R.attr.shadow_pressed, R.attr.tab_divider, R.attr.tab_edgeFadeEnabled, R.attr.tab_edgeFadeLength, R.attr.tab_enableMaterial, R.attr.tab_material, R.attr.tab_material_selected, R.attr.tab_padding, R.attr.tab_space_equal, R.attr.tab_textAllCaps, R.attr.tab_textBold, R.attr.tab_textPressedColor, R.attr.tab_textSelectColor, R.attr.tab_textSelectedStyle, R.attr.tab_textSize, R.attr.tab_textStyle, R.attr.tab_textUnselectColor, R.attr.tab_width, R.attr.vibrate_on_tab_selected});
        this.f402730p = r114.getColor(11, getResources().getColor(R.color.oui_fill_seg_selected));
        this.f402731q = r114.getDimension(13, -1.0f);
        this.f402732r = r114.getDimension(12, -1.0f);
        this.f402733s = r114.getDimension(18, d(4.0f));
        int r115 = (int) (getIndicatorSpacing() / 2);
        r113.setPadding(r115, 0, r115, 0);
        this.f402735u = r114.getBoolean(8, false);
        this.f402736v = r114.getBoolean(10, true);
        this.f402737w = r114.getColor(3, this.f402730p);
        this.f402738x = r114.getDimension(5, d(1.0f));
        this.f402739y = r114.getDimension(4, 0.0f);
        Resources r104 = r110.getResources();
        this.f402740z = r114.getDimension(50, (int) ((13.0f * WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).scaledDensity) + 0.5f));
        this.A = r114.getColor(48, ColorProtector.parseColor("#ffffff"));
        this.B = r114.getColor(52, this.f402730p);
        this.C = r114.getInt(46, 0);
        this.D = r114.getBoolean(45, false);
        this.f402728n = r114.getBoolean(44, true);
        float r105 = r114.getDimension(53, d(-1.0f));
        this.f402729o = r105;
        if (this.f402728n == false) goto L5;
    L8:
        int r106 = d(0.0f);
    L9:
        this.f402727m = r114.getDimension(43, r106);
        int r107 = r114.getColor(0, 0);
        this.mBarColor = r107;
        this.E = r114.getColor(1, r107);
        this.F = r114.getDimension(2, d(0.0f));
        this.G = r114.getBoolean(54, true);
        r114.recycle();
        Intrinsics.checkNotNull(r111);
        String r108 = r111.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (Intrinsics.areEqual(r108, "-1") == false) goto L13;
    L16:
        ValueAnimator r109 = ValueAnimator.ofObject(new c(this), new Object[]{r103, r102});
        this.K = r109;
        r109.addUpdateListener(this);
        r109.addListener(this);
        return;
    L13:
        if (Intrinsics.areEqual(r108, "-2") == true) goto L16;
        TypedArray r116 = r110.obtainStyledAttributes(r111, new int[]{android.R.attr.layout_height});
        r116.getDimensionPixelSize(0, -2);
        r116.recycle();
        goto L16
    L5:
        if (r105 > 0.0f) goto L8;
        r106 = d(10.0f);
        goto L9
    }

    public /* synthetic */ OTabSegmentedLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
