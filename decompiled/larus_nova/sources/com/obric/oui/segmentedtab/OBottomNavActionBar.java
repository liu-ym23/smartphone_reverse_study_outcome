package com.obric.oui.segmentedtab;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.common.style.ShadowAnimator;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.q;
import com.obric.oui.common.style.r;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.p;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vma.i;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0003rstB'\b\u0007\u0012\u0006\u0010l\u001a\u00020k\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010m\u0012\b\b\u0002\u0010o\u001a\u00020\u0003¢\u0006\u0004\bp\u0010qJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0013\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0012R\u0016\u0010\u0014\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010#\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00038\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010'\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00038\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010\u0018R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010\u0018R\u0016\u00100\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010+R\u0016\u00101\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010+R\u0016\u00102\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R*\u0010:\u001a\u00020)2\u0006\u00104\u001a\u00020)8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010+\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010;\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u00103\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R(\u0010?\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b?\u00103\u0012\u0004\bA\u0010B\u001a\u0004\b?\u0010<\"\u0004\b@\u0010>R$\u0010C\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bD\u0010\"\"\u0004\bE\u0010FR$\u0010G\u001a\u00020)2\u0006\u0010G\u001a\u00020)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bH\u00107\"\u0004\bI\u00109R$\u0010K\u001a\u00020\t2\u0006\u0010J\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bK\u0010<\"\u0004\bL\u0010>R$\u0010M\u001a\u00020)2\u0006\u0010M\u001a\u00020)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u00107\"\u0004\bO\u00109R$\u0010P\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010\"\"\u0004\bR\u0010FR$\u0010U\u001a\u00020)2\u0006\u00104\u001a\u00020)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bS\u00107\"\u0004\bT\u00109R$\u0010V\u001a\u00020\u00032\u0006\u0010V\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010\"\"\u0004\bX\u0010FR$\u0010Y\u001a\u00020)2\u0006\u0010Y\u001a\u00020)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bZ\u00107\"\u0004\b[\u00109R$\u0010\\\u001a\u00020)2\u0006\u0010\\\u001a\u00020)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b]\u00107\"\u0004\b^\u00109R$\u0010_\u001a\u00020)2\u0006\u0010_\u001a\u00020)8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b`\u00107\"\u0004\ba\u00109R$\u0010b\u001a\u00020\u00032\u0006\u0010b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bc\u0010\"\"\u0004\bd\u0010FR$\u0010e\u001a\u00020\u00032\u0006\u0010e\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bf\u0010\"\"\u0004\bg\u0010FR$\u0010i\u001a\u00020\t2\u0006\u0010h\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bi\u0010<\"\u0004\bj\u0010>¨\u0006u"}, d2 = {"Lcom/obric/oui/segmentedtab/OBottomNavActionBar;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/g;", "", "index", "", "setFragments", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "", "enabled", "setEnabled", "Landroid/view/View;", "view", "setBackdropTarget", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$c;", "listener", "setOnTabSelectListener", "Lcom/obric/oui/segmentedtab/OBottomNavActionBar$b;", "setOnTabSelectAnimListener", "mContentRoot", "Lcom/obric/oui/layout/OUIFrameLayout;", "", OfficeSDKRequestTag.KEY_NEW_USER, "Ljava/util/List;", "getTabList", "()Ljava/util/List;", "setTabList", "(Ljava/util/List;)V", "tabList", "<set-?>", "o", "I", "getTabCount", "()I", "tabCount", "Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable;", "indicatorDrawable", "Lcom/obric/oui/segmentedtab/ONaviIndicatorDrawable;", "indicatorSpacing", "getIndicatorSpacing", "", "mBarStrokeWidth", FaceService.girlLabel, "", "Lcom/obric/oui/common/style/q;", "shadowsNormal", "shadowsPressed", "pressScale", "initScale", "mIsFirstDraw", "Z", "value", "N", "getIndicatorCornerRadius", "()F", "setIndicatorCornerRadius", "(F)V", "indicatorCornerRadius", "isIndicatorAnimEnable", "()Z", "setIndicatorAnimEnable", "(Z)V", "isIndicatorBounceEnable", "setIndicatorBounceEnable", "isIndicatorBounceEnable$annotations", "()V", "currentTab", "getCurrentTab", "setCurrentTab", "(I)V", "tabPadding", "getTabPadding", "setTabPadding", "tabSpaceEqual", "isTabSpaceEqual", "setTabSpaceEqual", "tabWidth", "getTabWidth", "setTabWidth", "indicatorColor", "getIndicatorColor", "setIndicatorColor", "getIndicatorHeight", "setIndicatorHeight", "indicatorHeight", "dividerColor", "getDividerColor", "setDividerColor", "dividerWidth", "getDividerWidth", "setDividerWidth", "dividerPadding", "getDividerPadding", "setDividerPadding", "textSize", "getTextSize", "setTextSize", "textSelectColor", "getTextSelectColor", "setTextSelectColor", "textUnselectColor", "getTextUnselectColor", "setTextUnselectColor", "textAllCaps", "isTextAllCaps", "setTextAllCaps", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OBottomNavActionBar extends OUIFrameLayout implements com.obric.oui.material.g {
    public static final /* synthetic */ int P = 0;
    public int A;
    public int B;
    public boolean C;
    public final Paint D;
    public final Paint E;
    public final RectF F;
    public final RectF G;
    public fja.d H;
    public fja.d I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f402634J;
    public boolean K;
    public int L;
    public int M;
    public float N;
    public c O;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f402635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String[] f402636i;
    private final ONaviIndicatorDrawable indicatorDrawable;
    private int indicatorSpacing;
    private float initScale;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable[] f402637j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinearLayout f402638k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f402639l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f402640m;
    private float mBarStrokeWidth;
    private OUIFrameLayout mContentRoot;
    private boolean mIsFirstDraw;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<View> f402641n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f402642o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint f402643p;
    private float pressScale;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f402644q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f402645r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f402646s;
    private List<q> shadowsNormal;
    private List<q> shadowsPressed;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f402647t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f402648u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f402649v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f402650w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f402651x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f402652y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f402653z;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
        void a(int r100);

        void onSelect(int r100);
    }

    static {
    }

    public OBottomNavActionBar(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OBottomNavActionBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final void setFragments(int r100) {
    }

    public final Fragment getCurrentFragment() {
        return null;
    }

    public final void setIndicatorAnimEnable(boolean r100) {
    }

    public final void setIndicatorBounceEnable(boolean r100) {
    }

    public final void d() {
        if (this.indicatorDrawable.b() == true) goto L6;
        View r100 = this.f402640m;
        Intrinsics.checkNotNull(r100);
        float r101 = r100.getLeft();
        View r102 = this.f402640m;
        Intrinsics.checkNotNull(r102);
        float r103 = r102.getRight();
        ONaviIndicatorDrawable r104 = this.indicatorDrawable;
        float r105 = this.indicatorSpacing + this.mBarStrokeWidth;
        float r106 = r103 - r101;
        float r107 = r104.f402697o;
        r104.f402685c = r101;
        r104.f402686d = r106;
        r104.f402687e = r107;
        r104.f402690h = r101;
        r104.f402691i = r105;
        r104.f402692j = r106;
        r104.f402693k = r107;
        r104.f402694l = r101;
        r104.f402695m = r105;
        r104.f402696n = r106;
        r104.f402697o = r107;
        return;
    }

    public final int getIndicatorColor() {
        return this.indicatorDrawable.f402688f;
    }

    public final float getIndicatorHeight() {
        return this.indicatorDrawable.f402697o;
    }

    public final void j() {
        int r100 = this.f402642o;
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L29;
        int r102 = r101 + 1;
        View r103 = this.f402638k.getChildAt(r101);
        float r104 = this.f402644q;
        r103.setPadding((int) r104, 0, (int) r104, 0);
        View r105 = r103.findViewById(R.id.tv_tab_title);
        if (r105 == null) goto L28;
        TextView r106 = (TextView) r105;
        if (r101 != this.f402639l) goto L9;
        boolean r107 = true;
    L11:
        if ((r103 instanceof OSegmentTabView) == false) goto L13;
        ((OSegmentTabView) r103).d(r107);
        r106.setTextSize(0, this.f402650w);
    L17:
        ImageView r108 = (ImageView) r103.findViewById(R.id.tv_tab_icon);
        if (r107 == false) goto L20;
        int r109 = this.f402651x;
    L21:
        r108.setImageTintList(ColorStateList.valueOf(r109));
        if (this.f402653z == false) goto L24;
        r106.setText(r106.getText().toString().toUpperCase(Locale.ROOT));
    L24:
        if (r107 == false) goto L26;
        this.f402640m = r103;
    L26:
        r101 = r102;
        goto L3
    L20:
        r109 = this.f402652y;
        goto L21
    L13:
        if (r107 == false) goto L15;
        int r110 = this.f402651x;
    L16:
        r106.setTextColor(r110);
        r106.setTextSize(0, this.f402650w);
        goto L17
    L15:
        r110 = this.f402652y;
        goto L16
    L9:
        r107 = false;
        goto L11
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle r100 = new Bundle();
        r100.putInt("mCurrentTab", this.f402639l);
        r100.putParcelable("instanceState", super.onSaveInstanceState());
        return r100;
    }

    public final int getCurrentTab() {
        return this.f402639l;
    }

    public final int getDividerColor() {
        return this.f402647t;
    }

    public final float getDividerPadding() {
        return this.f402649v;
    }

    public final float getDividerWidth() {
        return this.f402648u;
    }

    public final float getIndicatorCornerRadius() {
        return this.N;
    }

    public final int getIndicatorSpacing() {
        return this.indicatorSpacing;
    }

    public final int getTabCount() {
        return this.f402642o;
    }

    public final List<View> getTabList() {
        return this.f402641n;
    }

    public final float getTabPadding() {
        return this.f402644q;
    }

    public final float getTabWidth() {
        return this.f402646s;
    }

    public final int getTextSelectColor() {
        return this.f402651x;
    }

    public final float getTextSize() {
        return this.f402650w;
    }

    public final int getTextUnselectColor() {
        return this.f402652y;
    }

    @Override // com.obric.oui.material.g
    public final void a(int r100) {
        this.L = r100;
        p.g(this, r100);
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        if (r101 == 0) goto L9;
        if (r101 != 1) goto L6;
    L8:
        e(false);
    L11:
        return super.dispatchTouchEvent(r100);
    L6:
        if (r101 == 3) goto L8;
    L9:
        e(true);
        goto L11
    }

    public final void e(boolean r100) {
        fja.d r101 = this.H;
        if (r101 == null) goto L6;
        int r102 = fja.d.f477533d;
        r101.a(false);
    L6:
        fja.d r103 = this.I;
        if (r103 == null) goto L10;
        int r104 = fja.d.f477533d;
        r103.a(false);
    L10:
        if (r100 == false) goto L12;
        this.H = ShadowAnimator.a(this, this.initScale, this.pressScale, getCurrentShadows(), this.shadowsPressed);
        return;
    L12:
        this.I = ShadowAnimator.a(this, this.pressScale, this.initScale, getCurrentShadows(), this.shadowsNormal);
    }

    public final int f(float r100) {
        Resources r101 = this.f402635h.getResources();
        return (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density) + 0.5f);
    }

    public final void i(int r100) {
        int r101 = this.f402642o;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L23;
        int r103 = r102 + 1;
        View r104 = this.f402638k.getChildAt(r102);
        if (r102 != r100) goto L7;
        boolean r105 = true;
    L8:
        ImageView r106 = (ImageView) r104.findViewById(R.id.tv_tab_icon);
        if (r105 == false) goto L11;
        int r107 = this.f402651x;
    L12:
        r106.setImageTintList(ColorStateList.valueOf(r107));
        int r108 = vma.c.f556351a;
        if ((r104 instanceof OSegmentTabView) == false) goto L15;
        View r109 = r104;
    L16:
        OSegmentTabView r110 = (OSegmentTabView) r109;
        if (r110 == null) goto L20;
        r110.d(r105);
    L20:
        if (r105 == false) goto L22;
        this.f402640m = r104;
    L22:
        r102 = r103;
        goto L3
    L15:
        r109 = null;
        goto L16
    L11:
        r107 = this.f402652y;
        goto L12
    L7:
        r105 = false;
        goto L8
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        super.invalidateDrawable(r100);
        if (Intrinsics.areEqual(r100, this.indicatorDrawable) == false) goto L6;
        invalidate();
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (isInEditMode() == false) goto L5;
        return;
    L5:
        if (this.f402642o <= 0) goto L31;
        float r100 = this.indicatorDrawable.f402689g + (this.indicatorSpacing / 2);
        if (this.K == true) goto L12;
        this.D.setColor(this.A);
        this.F.set(0.0f, getPaddingTop(), getWidth(), getHeight() - getPaddingBottom());
        r.e(r110, this.F, r100, this.D);
    L12:
        if (this.mBarStrokeWidth <= 0.0f) goto L15;
        this.E.setColor(this.B);
        this.E.setStrokeWidth(this.mBarStrokeWidth);
        float r101 = 2;
        this.G.set(this.mBarStrokeWidth / r101, getPaddingTop() + (this.mBarStrokeWidth / r101), getWidth() - (this.mBarStrokeWidth / r101), (getHeight() - getPaddingBottom()) - (this.mBarStrokeWidth / r101));
        r.e(r110, this.G, r100, this.E);
    L15:
        if (this.indicatorDrawable.f402698p == true) goto L22;
        float r102 = this.f402648u;
        if (r102 <= 0.0f) goto L22;
        this.f402643p.setStrokeWidth(r102);
        this.f402643p.setColor(this.f402647t);
        int r103 = this.f402642o - 1;
        int r104 = 0;
    L19:
        if (r104 >= r103) goto L22;
        int r105 = r104 + 1;
        View r106 = this.f402638k.getChildAt(r104);
        r110.drawLine(getPaddingLeft() + r106.getRight(), this.f402649v, getPaddingLeft() + r106.getRight(), getHeight() - this.f402649v, this.f402643p);
        r104 = r105;
    L22:
        if (this.indicatorDrawable.f402698p == true) goto L24;
        d();
    L27:
        r110.translate(getPaddingLeft(), getPaddingTop());
        this.indicatorDrawable.draw(r110);
        r110.translate(-getPaddingLeft(), -getPaddingTop());
        return;
    L24:
        if (this.mIsFirstDraw == false) goto L27;
        this.mIsFirstDraw = false;
        d();
        goto L27
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if ((r100 instanceof Bundle) == false) goto L12;
        Bundle r101 = (Bundle) r100;
        this.f402639l = r101.getInt("mCurrentTab");
        r100 = r101.getParcelable("instanceState");
        if (this.f402639l == 0) goto L12;
        if (this.f402638k.getChildCount() == 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        i(this.f402639l);
        goto L12
    L9:
        r102 = false;
    L12:
        super.onRestoreInstanceState(r100);
    }

    @Override // com.obric.oui.material.g
    public void setBackdropTarget(View r100) {
        Intrinsics.checkNotNullParameter(this, "<this>");
        OMaterialHelper.t(this, r100);
    }

    public final void setCurrentTab(int r100) {
        int r101 = this.f402639l;
        if (r100 != r101) goto L10;
        c r102 = this.O;
        if (r102 == null) goto L20;
        if (r102 == null) goto L21;
        r102.a(r101);
        return;
    L21:
        return;
    L20:
        return;
    L10:
        this.mIsFirstDraw = true;
        this.f402639l = r100;
        i(r100);
        setFragments(r100);
        c r103 = this.O;
        if (r103 == null) goto L16;
        if (r103 == null) goto L16;
        r103.onSelect(this.f402639l);
    L16:
        if (this.indicatorDrawable.f402698p == false) goto L18;
        View r104 = this.f402640m;
        Intrinsics.checkNotNull(r104);
        float r105 = r104.getLeft();
        View r106 = this.f402640m;
        Intrinsics.checkNotNull(r106);
        float r107 = r106.getRight();
        ONaviIndicatorDrawable r108 = this.indicatorDrawable;
        r108.e(r105, this.indicatorSpacing, r107 - r105, r108.f402697o);
        return;
    L18:
        invalidate();
    }

    public final void setDividerColor(int r100) {
        this.f402647t = r100;
        invalidate();
    }

    public final void setDividerPadding(float r100) {
        this.f402649v = f(r100);
        invalidate();
    }

    public final void setDividerWidth(float r100) {
        this.f402648u = f(r100);
        invalidate();
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r100) {
        super.setEnabled(r100);
        Iterator<View> r101 = this.f402641n.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().setEnabled(r100);
        goto L4
    }

    public final void setIndicatorColor(int r100) {
        ONaviIndicatorDrawable r101 = this.indicatorDrawable;
        if (r101.f402688f == r100) goto L6;
        r101.f402688f = r100;
        r101.f402683a.setColor(r100);
        r101.invalidateSelf();
        return;
    }

    public final void setIndicatorCornerRadius(float r100) {
        this.indicatorDrawable.c(f(r100));
        this.N = this.indicatorDrawable.f402689g;
    }

    public final void setIndicatorHeight(float r100) {
        this.indicatorDrawable.d(f(r100));
    }

    public final void setOnTabSelectAnimListener(b r100) {
        this.indicatorDrawable.getClass();
    }

    public final void setOnTabSelectListener(c r100) {
        this.O = r100;
    }

    public final void setTabList(List<View> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f402641n = r100;
    }

    public final void setTabPadding(float r100) {
        this.f402644q = f(r100);
        j();
    }

    public final void setTabSpaceEqual(boolean r100) {
        this.f402645r = r100;
        j();
    }

    public final void setTabWidth(float r100) {
        this.f402646s = f(r100);
        j();
    }

    public final void setTextAllCaps(boolean r100) {
        this.f402653z = r100;
        j();
    }

    public final void setTextSelectColor(int r100) {
        this.f402651x = r100;
        j();
    }

    public final void setTextSize(float r100) {
        Resources r101 = this.f402635h.getResources();
        this.f402650w = (int) ((r100 * WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).scaledDensity) + 0.5f);
        j();
    }

    public final void setTextUnselectColor(int r100) {
        this.f402652y = r100;
        j();
    }

    public final void g(Context r100, AttributeSet r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.indicatorDrawable.setCallback(this);
        TypedArray r111 = r100.obtainStyledAttributes(r110, new int[]{R.attr.bar_color, R.attr.bar_stroke_color, R.attr.bar_stroke_width, R.attr.divider_color, R.attr.divider_padding, R.attr.divider_width, R.attr.enableDefaultMaskBackground, R.attr.indicator_anim_duration, R.attr.indicator_anim_enable, R.attr.indicator_background, R.attr.indicator_bounce_enable, R.attr.indicator_color, R.attr.indicator_corner_radius, R.attr.indicator_height, R.attr.indicator_marginBottom, R.attr.indicator_marginLeft, R.attr.indicator_marginRight, R.attr.indicator_marginTop, R.attr.indicator_spacing, R.attr.indicator_unselected_color, R.attr.maskBackground, R.attr.mask_blur_radius, R.attr.oui_alpha_disabled, R.attr.oui_bottomActionBarType, R.attr.oui_widgetBlurBlendModes, R.attr.oui_widgetBlurColors, R.attr.oui_widgetBlurRadius, R.attr.oui_widgetFitInsetBottom, R.attr.oui_widgetFitInsetLeft, R.attr.oui_widgetFitInsetRight, R.attr.oui_widgetFitInsetTop, R.attr.oui_widgetMaterial, R.attr.oui_widgetMaterialSrcType, R.attr.oui_widgetShadowNormal, R.attr.oui_widgetShadowPressed, R.attr.shadow_normal, R.attr.shadow_pressed, R.attr.tab_divider, R.attr.tab_edgeFadeEnabled, R.attr.tab_edgeFadeLength, R.attr.tab_enableMaterial, R.attr.tab_material, R.attr.tab_material_selected, R.attr.tab_padding, R.attr.tab_space_equal, R.attr.tab_textAllCaps, R.attr.tab_textBold, R.attr.tab_textPressedColor, R.attr.tab_textSelectColor, R.attr.tab_textSelectedStyle, R.attr.tab_textSize, R.attr.tab_textStyle, R.attr.tab_textUnselectColor, R.attr.tab_width, R.attr.vibrate_on_tab_selected});
        ONaviIndicatorDrawable r101 = this.indicatorDrawable;
        int r102 = r111.getColor(11, getResources().getColor(R.color.oui_fill_element_3));
        if (r101.f402688f == r102) goto L5;
        r101.f402688f = r102;
        r101.f402683a.setColor(r102);
        r101.invalidateSelf();
    L5:
        this.indicatorDrawable.d(r111.getDimension(13, -1.0f));
        this.indicatorDrawable.c(r111.getDimension(12, -1.0f));
        setIndicatorCornerRadius(this.indicatorDrawable.f402689g);
        this.indicatorSpacing = r111.getDimensionPixelSize(18, f(4.0f));
        this.indicatorDrawable.f402698p = r111.getBoolean(8, false);
        r111.getBoolean(10, true);
        this.f402638k.setPadding(getIndicatorSpacing(), 0, getIndicatorSpacing(), 0);
        this.mContentRoot.addView(this.f402638k);
        this.f402647t = r111.getColor(3, this.indicatorDrawable.f402688f);
        this.f402648u = r111.getDimension(5, 0.0f);
        this.f402649v = r111.getDimension(4, 0.0f);
        this.f402650w = r111.getDimension(50, f(10.0f));
        this.f402651x = r111.getColor(48, this.f402635h.getColor(R.color.oui_text_1));
        this.f402652y = r111.getColor(52, this.f402635h.getColor(R.color.oui_text_3b));
        this.f402653z = r111.getBoolean(45, false);
        this.f402645r = r111.getBoolean(44, true);
        float r103 = r111.getDimension(53, f(-1.0f));
        this.f402646s = r103;
        if (this.f402645r == false) goto L8;
    L11:
        int r104 = f(0.0f);
    L12:
        this.f402644q = r111.getDimension(43, r104);
        int r105 = r111.getColor(0, 0);
        this.A = r105;
        this.B = r111.getColor(1, r105);
        int r106 = 2;
        this.mBarStrokeWidth = r111.getDimension(2, f(0.0f));
        this.C = r111.getBoolean(54, false);
        List<q> r107 = l.b(r100, r111, 35);
        if (r107 != null) goto L15;
        r107 = l.b(r100, r111, 33);
    L15:
        if (r107 == null) goto L17;
        this.shadowsNormal = r107;
        Intrinsics.checkNotNull(r107);
        q r108 = (q) CollectionsKt.getOrNull(r107, 0);
        List<q> r109 = this.shadowsNormal;
        Intrinsics.checkNotNull(r109);
        c(r108, (q) CollectionsKt.getOrNull(r109, 1), false);
    L17:
        List<q> r112 = l.b(r100, r111, 36);
        if (r112 != null) goto L20;
        r112 = l.b(r100, r111, 34);
    L20:
        if (r112 == null) goto L22;
        this.shadowsPressed = r112;
    L22:
        setShadowCornerRadius(pla.d.n(this, 99));
        if (this.f402634J == false) goto L41;
        this.L = r111.getInt(32, -1);
        String r113 = r111.getString(31);
        if (r113 != null) goto L27;
        r113 = getResources().getString(R.string.oui_material_bg_floating);
    L27:
        com.obric.oui.material.c[] r114 = MaterialToken.parseSet(r113, !i.a(this));
        if (r114 == null) goto L30;
        boolean r115 = true;
    L31:
        this.f402634J = r115;
        this.K = r115;
        r111.recycle();
        if (this.K == false) goto L42;
        setEnableShadowWidthRadius(true);
        setRadius(pla.d.n(this, 99));
        if (r114 == null) goto L43;
        int r116 = this.L;
        if (r116 == (-1)) goto L39;
        r106 = r116;
    L39:
        p.d(this, r114, false, r106, 10);
        GradientDrawable r117 = new GradientDrawable();
        r117.setShape(0);
        r117.setCornerRadius(pla.d.q(this, 99));
        r117.setColor(0);
        setBackground(r117);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        return;
    L43:
        return;
    L42:
        return;
    L30:
        r115 = false;
        goto L31
    L41:
        return;
    L8:
        if (r103 > 0.0f) goto L11;
        r104 = f(10.0f);
        goto L12
    }

    public final void h(String[] r110, Drawable[] r111) {
        if (r110 != null) goto L5;
    L11:
        boolean r100 = true;
    L12:
        if (r100 == false) goto L25;
        if (r111 != null) goto L15;
    L21:
        boolean r101 = true;
    L22:
        if (r101 == false) goto L25;
        boolean r102 = false;
    L26:
        if (r102 == false) goto L78;
        this.f402636i = r110;
        this.f402637j = r111;
        this.mIsFirstDraw = true;
        this.f402638k.removeAllViews();
        String[] r112 = this.f402636i;
        if (r112 != null) goto L30;
        Integer r113 = null;
    L31:
        if (r113 != null) goto L36;
        Drawable[] r114 = this.f402637j;
        if (r114 != null) goto L35;
        int r115 = 0;
    L37:
        this.f402642o = r115;
        this.f402641n.clear();
        int r116 = this.f402642o;
        int r103 = 0;
    L38:
        if (r103 >= r116) goto L75;
        int r104 = r103 + 1;
        int r105 = OSegmentTabView.f402704l;
        OSegmentTabView r106 = OSegmentTabView.a.a(this.f402635h);
        int r107 = this.f402651x;
        int r108 = this.f402652y;
        r106.f402708f = r107;
        r106.f402709g = r108;
        r106.setOriginIconAlpha(255);
        r106.setTag(Integer.valueOf(r103));
        View r109 = r106.findViewById(R.id.tv_tab_title);
        if (r109 == null) goto L74;
        TextView r117 = (TextView) r109;
        ImageView r118 = (ImageView) r106.findViewById(R.id.tv_tab_icon);
        int r119 = pla.d.n(this, 2);
        String[] r120 = this.f402636i;
        if (r120 != null) goto L44;
        Unit r121 = null;
    L51:
        if (r121 != null) goto L53;
        r117.setVisibility(8);
    L53:
        Drawable[] r122 = this.f402637j;
        if (r122 != null) goto L56;
        Unit r123 = null;
    L57:
        if (r123 != null) goto L63;
        r118.setVisibility(8);
        ViewGroup.LayoutParams r124 = r117.getLayoutParams();
        if (r124 == null) goto L62;
        LinearLayout.LayoutParams r125 = (LinearLayout.LayoutParams) r124;
        r125.setMargins(0, r119, 0, 0);
        r117.setLayoutParams(r125);
        goto L63
    L62:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L63:
        r106.setOnTouchListener(new com.obric.oui.segmentedtab.a(this));
        r106.setOnClickListener(new com.obric.oui.segmentedtab.b(this));
        this.f402641n.add(r106);
        if (this.f402645r == false) goto L66;
        LinearLayout.LayoutParams r126 = new LinearLayout.LayoutParams(0, -1, 1.0f);
    L68:
        if (this.f402646s <= 0.0f) goto L70;
        r126 = new LinearLayout.LayoutParams((int) this.f402646s, -1);
    L70:
        this.f402638k.addView(r106, r103, r126);
        r103 = r104;
        goto L38
    L66:
        r126 = new LinearLayout.LayoutParams(-2, -1);
        goto L68
    L56:
        r118.setImageDrawable(r122[r103]);
        r123 = Unit.INSTANCE;
        goto L57
    L44:
        String r127 = r120[r103];
        if (r127 != null) goto L47;
        r127 = "";
    L47:
        r117.setText(r127);
        ViewGroup.LayoutParams r128 = r117.getLayoutParams();
        if (r128 == null) goto L72;
        LinearLayout.LayoutParams r129 = (LinearLayout.LayoutParams) r128;
        r129.setMargins(0, r119, 0, 0);
        r117.setLayoutParams(r129);
        r121 = Unit.INSTANCE;
        goto L51
    L72:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L74:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L75:
        j();
        return;
    L35:
        r115 = r114.length;
        goto L37
    L36:
        r115 = r113.intValue();
        goto L37
    L30:
        r113 = Integer.valueOf(r112.length);
        goto L31
    L78:
        throw new IllegalStateException("Titles and Drawables can not be NULL or EMPTY !".toString());
    L15:
        if (r111.length != 0) goto L17;
        boolean r130 = true;
    L18:
        if (r130 == true) goto L21;
        r101 = false;
        goto L22
    L17:
        r130 = false;
    L25:
        r102 = true;
        goto L26
    L5:
        if (r110.length != 0) goto L7;
        boolean r131 = true;
    L8:
        if (r131 == true) goto L11;
        r100 = false;
        goto L12
    L7:
        r131 = false;
        goto L8
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
    }

    public OBottomNavActionBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 8);
        this.f402641n = new ArrayList();
        this.f402643p = new Paint(1);
        this.indicatorDrawable = new ONaviIndicatorDrawable();
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.FILL);
        this.D = r103;
        Paint r104 = new Paint(1);
        r104.setStyle(Paint.Style.STROKE);
        this.E = r104;
        this.F = new RectF();
        this.G = new RectF();
        this.pressScale = 0.988f;
        this.initScale = 1.0f;
        this.L = -1;
        this.M = -1;
        if (p.b(this) == true) goto L5;
    L7:
        boolean r105 = false;
    L8:
        this.f402634J = r105;
        this.K = r105;
        this.mIsFirstDraw = true;
        new Paint(1);
        new SparseArray();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f402635h = r100;
        this.f402638k = new LinearLayout(r100);
        OUIFrameLayout r106 = new OUIFrameLayout(r100, null, 0, 14);
        this.mContentRoot = r106;
        r106.setRadius(pla.d.n(this, 99));
        this.mContentRoot.setChangeAlphaWhenPress(false);
        this.mContentRoot.setChangeAlphaWhenDisable(false);
        this.mContentRoot.setChangeAlphaWhenSelected(false);
        addView(this.mContentRoot);
        Intrinsics.checkNotNull(r101);
        String r107 = r101.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (Intrinsics.areEqual(r107, "-1") == false) goto L12;
        return;
    L12:
        if (Intrinsics.areEqual(r107, "-2") == true) goto L17;
        TypedArray r108 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.layout_height});
        r108.getDimensionPixelSize(0, -2);
        r108.recycle();
        return;
    L17:
        return;
    L5:
        if (OMaterialHelper.l() == false) goto L7;
        r105 = true;
        goto L8
    }

    public /* synthetic */ OBottomNavActionBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        ONaviIndicatorDrawable r105 = this.indicatorDrawable;
        int r106 = getHeight();
        int r107 = this.indicatorSpacing;
        if (r105.f402697o >= 0.0f) goto L5;
        r105.d(r106 - (r107 * 2.0f));
    L5:
        float r108 = r105.f402689g;
        if (r108 >= 0.0f) goto L8;
    L9:
        r105.c(r105.f402697o);
    L11:
        if (getWidth() == this.M) goto L14;
        this.M = getWidth();
        this.mIsFirstDraw = true;
        return;
    L14:
        return;
    L8:
        if (r108 <= (r105.f402697o / 2)) goto L11;
        goto L9
    }
}
