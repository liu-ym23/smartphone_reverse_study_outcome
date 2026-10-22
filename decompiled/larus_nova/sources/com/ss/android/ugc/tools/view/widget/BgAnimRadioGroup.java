package com.ss.android.ugc.tools.view.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u0017\u0010!\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006)"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/BgAnimRadioGroup;", "Landroid/widget/FrameLayout;", "", "index", "", "setCurrentItem", "Lcom/ss/android/ugc/tools/view/widget/BgAnimRadioGroup$b;", "listener", "setOnItemChangeListener", "", "b", FaceService.girlLabel, "getItemTextSize", "()F", "setItemTextSize", "(F)V", "itemTextSize", "c", "I", "getItemTextNormalColor", "()I", "setItemTextNormalColor", "(I)V", "itemTextNormalColor", "d", "getItemTextSelectColor", "setItemTextSelectColor", "itemTextSelectColor", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", KtvSubElement.CONTAINER, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class BgAnimRadioGroup extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f454985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f454986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f454987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f454988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f454989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f454990f;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BgAnimRadioGroup f454991a;

        public a(BgAnimRadioGroup r100) {
            this.f454991a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L9;
            float r102 = ((Float) r101).floatValue();
            this.f454991a.f454989e.setX(0.0f + (0.0f * r102));
            if (r102 != 1.0f) goto L10;
            BgAnimRadioGroup r103 = this.f454991a;
            r103.a(r103.getContainer().getChildAt(this.f454991a.f454985a), this.f454991a.getItemTextSelectColor());
            return;
        L10:
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public interface b {
    }

    public BgAnimRadioGroup(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BgAnimRadioGroup(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setOnItemChangeListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    public final LinearLayout getContainer() {
        return this.f454990f;
    }

    public final int getItemTextNormalColor() {
        return this.f454987c;
    }

    public final int getItemTextSelectColor() {
        return this.f454988d;
    }

    public final float getItemTextSize() {
        return this.f454986b;
    }

    public final void setCurrentItem(int r100) {
        if (r100 < 0) goto L4;
        this.f454990f.getChildAt(r100).setSelected(true);
    L4:
        int r101 = this.f454985a;
        int r102 = 0;
        if (r101 < 0) goto L7;
        this.f454990f.getChildAt(r101).setSelected(false);
    L7:
        this.f454985a = r100;
        int r103 = this.f454990f.getChildCount();
    L8:
        if (r102 >= r103) goto L14;
        View r104 = this.f454990f.getChildAt(r102);
        if (r102 != r100) goto L12;
        int r105 = this.f454988d;
    L13:
        a(r104, r105);
        r102 = r102 + 1;
        goto L8
    L12:
        r105 = this.f454987c;
        goto L13
    }

    public final void setItemTextNormalColor(int r100) {
        this.f454987c = r100;
    }

    public final void setItemTextSelectColor(int r100) {
        this.f454988d = r100;
    }

    public final void setItemTextSize(float r100) {
        this.f454986b = r100;
    }

    public final void a(View r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof TextView) == true) goto L6;
        return;
    L6:
        if (this.f454988d == (-1)) goto L11;
        ((TextView) r100).setTextColor(r101);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = View.MeasureSpec.makeMeasureSpec(((View.MeasureSpec.getSize(r100) - getPaddingLeft()) - getPaddingRight()) / this.f454990f.getChildCount(), Integer.MIN_VALUE);
        measureChild(this.f454989e, r102, r101);
    }

    public BgAnimRadioGroup(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        this.f454985a = -1;
        View r102 = new View(r100);
        r102.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Unit r103 = Unit.INSTANCE;
        this.f454989e = r102;
        LinearLayout r104 = new LinearLayout(r100);
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f454990f = r104;
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r105.setDuration(250);
        r105.addUpdateListener(new a(this));
        TypedArray r106 = r100.obtainStyledAttributes(r101, new int[]{R.attr.item_background, R.attr.item_normal_textColor, R.attr.item_select_textColor, R.attr.item_textSize}, r110, 0);
        Drawable r107 = r106.getDrawable(0);
        this.f454986b = r106.getDimension(3, 0.0f);
        this.f454987c = r106.getColor(1, 0);
        this.f454988d = r106.getColor(2, -1);
        r106.recycle();
        r102.setBackground(r107);
        addView(r102);
        addView(r104);
    }

    public /* synthetic */ BgAnimRadioGroup(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        View r105 = this.f454990f.getChildAt(this.f454985a);
        if (r105 == null) goto L6;
        this.f454989e.setX(r105.getX());
        return;
    }
}
