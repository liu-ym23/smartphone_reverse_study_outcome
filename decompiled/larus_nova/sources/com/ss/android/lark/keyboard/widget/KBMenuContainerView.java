package com.ss.android.lark.keyboard.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.byted.cast.common.CastMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 <2\u00020\u0001:\u0001<B3\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0007H\u0014J0\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0014J\b\u00102\u001a\u00020\"H\u0002J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0002J\b\u00106\u001a\u00020)H\u0004J\b\u00107\u001a\u00020\u0007H\u0002J\u0016\u00108\u001a\u00020)2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J\u0012\u00109\u001a\u00020)2\b\u0010:\u001a\u0004\u0018\u00010;H\u0014R\u001a\u0010\u000b\u001a\u00020\fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0007X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0007X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0007X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0007X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/ss/android/lark/keyboard/widget/KBMenuContainerView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "menuLayoutManager", "Lcom/ss/android/lark/keyboard/keyboard2/IMenuLayoutManager;", "getMenuLayoutManager", "()Lcom/ss/android/lark/keyboard/keyboard2/IMenuLayoutManager;", "setMenuLayoutManager", "(Lcom/ss/android/lark/keyboard/keyboard2/IMenuLayoutManager;)V", "verticalPadding", "getVerticalPadding", "()I", "setVerticalPadding", "(I)V", "horizontalPadding", "getHorizontalPadding", "setHorizontalPadding", "iconWidth", "getIconWidth", "setIconWidth", "sendWrapperWidth", "getSendWrapperWidth", "setSendWrapperWidth", "density", "", "isFolderSuitEnable", "", "lastLayoutChildrenHash", "lastMeasuredWidth", "resetChildrenMargin", "forceUpdate", "containerWidthMeasured", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "l", "t", "r", "b", "resetChildrenMarginAndPaddingIfNeed", "getVisibleChildren", "", "Landroid/view/View;", "setupChildrenMargin", "computeCurrentLayoutChildrenHash", "updatePluginPadding", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "Companion", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class KBMenuContainerView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.lark.keyboard.keyboard2.f f430991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f430992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f430993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f430994d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f430995e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f430996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f430997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f430998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f430999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f431000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f431001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f431002l;

    public static final class a {
    }

    static {
    }

    public KBMenuContainerView(Context r100) {
        this(r100, null, 0, 14);
    }

    public KBMenuContainerView(Context r100, AttributeSet r101) {
        this(r100, r101, 0, 12);
    }

    public KBMenuContainerView(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 8);
    }

    private final List<View> getVisibleChildren() {
        ArrayList r100 = new ArrayList();
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        View r103 = getChildAt(r102);
        if (r103.getVisibility() == 8) goto L7;
        Intrinsics.checkNotNull(r103);
        r100.add(r103);
    L7:
        r102 = r102 + 1;
        goto L3
    L8:
        return r100;
    }

    public final int a() {
        Iterator<T> r100 = getVisibleChildren().iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        View r102 = (View) r100.next();
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r103;
        r101 = (((((r101 * 31) + r102.hashCode()) * 31) + r104.leftMargin) * 31) + r104.rightMargin;
        goto L4
    L6:
        return r101;
    }

    public int getHorizontalPadding() {
        return this.f430993c;
    }

    public int getIconWidth() {
        return this.f430994d;
    }

    public com.ss.android.lark.keyboard.keyboard2.f getMenuLayoutManager() {
        return this.f430991a;
    }

    public int getSendWrapperWidth() {
        return this.f430995e;
    }

    public int getVerticalPadding() {
        return this.f430992b;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.f431001k = true;
    }

    public void setHorizontalPadding(int r100) {
        this.f430993c = r100;
    }

    public void setIconWidth(int r100) {
        this.f430994d = r100;
    }

    public void setMenuLayoutManager(com.ss.android.lark.keyboard.keyboard2.f r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f430991a = r100;
    }

    public void setSendWrapperWidth(int r100) {
        this.f430995e = r100;
    }

    public void setVerticalPadding(int r100) {
        this.f430992b = r100;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = View.MeasureSpec.getSize(r110);
        this.f431002l = r100;
        boolean r101 = this.f431000j;
        boolean r102 = false;
        if (a() == this.f430998h) goto L5;
    L9:
        this.f431001k = false;
        List<View> r103 = getVisibleChildren();
        if (r103.isEmpty() == true) goto L40;
        int r104 = r100 - (r103.size() * getIconWidth());
        int r105 = MathKt.roundToInt(getVerticalPadding() / this.f430996f);
        int r106 = MathKt.roundToInt(getHorizontalPadding() / this.f430996f);
        if (r103.size() <= 1) goto L15;
        int r107 = ((r105 + r106) * (r103.size() - 1)) + r106;
    L16:
        float r108 = r104 / r107;
        float r109 = r105 * r108;
        float r112 = r106 * r108;
        int r113 = getIconWidth() + getHorizontalPadding();
        int r114 = (r103.size() - 1) * ((getVerticalPadding() + getIconWidth()) + getHorizontalPadding());
        if (r103.size() <= 1) goto L19;
        r113 = r113 + r114;
    L19:
        if (r113 <= r100) goto L21;
        boolean r115 = true;
    L23:
        if (this.f430997g == true) goto L25;
        int r116 = getVerticalPadding();
        int r117 = getHorizontalPadding();
    L28:
        int r118 = r103.size();
        int r119 = 0;
    L29:
        if (r119 >= r118) goto L39;
        View r120 = (View) ListProtector.get(r103, r119);
        if (r119 != 0) goto L33;
        r120.setPadding(0, getVerticalPadding(), r117, getVerticalPadding());
    L34:
        Intrinsics.checkNotNullParameter(r120, "<this>");
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        if ((r121 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        ViewGroup.MarginLayoutParams r122 = (ViewGroup.MarginLayoutParams) r121;
        r122.rightMargin = 0;
        r122.leftMargin = 0;
        r120.requestLayout();
    L38:
        r119 = r119 + 1;
        goto L29
    L33:
        r120.setPadding(r116, getVerticalPadding(), r117, getVerticalPadding());
        goto L34
    L39:
        r102 = true;
        goto L40
    L25:
        if (r115 == false) goto L27;
        r116 = (int) r109;
        r117 = (int) r112;
        goto L28
    L27:
        r116 = getVerticalPadding();
        r117 = getHorizontalPadding();
        goto L28
    L21:
        r115 = false;
        goto L23
    L15:
        r107 = r106;
    L40:
        this.f431000j = r101 | r102;
        super.onMeasure(r110, r111);
        return;
    L5:
        if (this.f431001k == true) goto L9;
        if (this.f431002l != this.f430999i) goto L9;
        goto L9
    }

    public KBMenuContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        super(r100, r101, r102, 0);
        this.f430991a = com.ss.android.lark.keyboard.keyboard2.f.f429545a;
        this.f430992b = UIUtils.getDimens(r100, R.dimen.keyboard_icon_vertical_padding);
        this.f430993c = UIUtils.getDimens(r100, R.dimen.keyboard_icon_horizontal_padding);
        this.f430994d = UIHelper.dp2px(24.0f);
        this.f430995e = UIHelper.dp2px(33.0f);
        if (r100 == null) goto L15;
        Resources r104 = r100.getResources();
        if (r104 == null) goto L15;
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());
        if (r105 == null) goto L15;
        float r106 = r105.density;
    L16:
        this.f430996f = r106;
        int r107 = com.ss.android.lark.keyboard.edittext2.utils.d.f429254a;
        Intrinsics.checkNotNullParameter("im.messenger.fold.support", "key");
        this.f430997g = KeyboardBaseModule.a().isFeatureGatingCurrentEnable("im.messenger.fold.support");
        setOrientation(0);
        setGravity(16);
        return;
    L15:
        r106 = 1.0f;
        goto L16
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (this.f431000j == false) goto L8;
        this.f431000j = false;
        List<View> r105 = getVisibleChildren();
        if (r105.isEmpty() == true) goto L8;
        this.f430998h = a();
        getMenuLayoutManager().a(this, r105);
    L8:
        this.f430999i = getMeasuredWidth();
        super.onLayout(r100, r101, r102, r103, r104);
    }
}
