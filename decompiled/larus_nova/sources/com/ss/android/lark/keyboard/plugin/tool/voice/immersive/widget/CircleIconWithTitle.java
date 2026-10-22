package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u001dH\u0002J\b\u0010\"\u001a\u00020\u001dH\u0002J\u0010\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020'J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020'J\b\u0010+\u001a\u00020'H\u0016J\u0019\u0010,\u001a\u00020\u001d2\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0002\u0010.R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/widget/CircleIconWithTitle;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "iconDrawableResId", "", "textTitleResId", "iconTintColor", "iconDisableTintColor", "iconSize", "iconBackground", "backgroundTintColor", "backgroundDisableTintColor", "icon", "Landroidx/appcompat/widget/AppCompatImageView;", "getIcon", "()Landroidx/appcompat/widget/AppCompatImageView;", "icon$delegate", "Lkotlin/Lazy;", "title", "Landroidx/appcompat/widget/AppCompatTextView;", "getTitle", "()Landroidx/appcompat/widget/AppCompatTextView;", "title$delegate", "initStyleAttributes", "", "setText", "text", "", "initData", "adjustLayoutIfNeed", "startRotation", "milliseconds", "", "isRotating", "", "stopRotation", "enable", "setIsEnabled", "performClick", "setImageDrawable", "drawableRes", "(Ljava/lang/Integer;)V", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CircleIconWithTitle extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f430616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f430617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f430618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f430619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f430620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f430621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f430622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f430623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f430624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f430625j;

    private final AppCompatImageView getIcon() {
        return (AppCompatImageView) this.f430624i.getValue();
    }

    private final AppCompatTextView getTitle() {
        return (AppCompatTextView) this.f430625j.getValue();
    }

    public final boolean R5() {
        if (getIcon().getAnimation() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        return super.performClick();
    }

    public static void S5(CircleIconWithTitle r100) {
        if (r100.getIcon().getAnimation() != null) goto L7;
        r100.setEnabled(false);
        r100.setImageDrawable(Integer.valueOf(R.drawable.ud_icon_loading_outlined));
        Animation r101 = AnimationUtils.loadAnimation(r100.getContext(), R.anim.waiting_anim);
        r100.getIcon().startAnimation(r101);
        return;
    }

    private final void setImageDrawable(Integer r100) {
        if (r100 == null) goto L4;
        int r101 = r100.intValue();
    L5:
        boolean r102 = isEnabled();
        AppCompatImageView r103 = getIcon();
        r103.setScaleType(ImageView.ScaleType.CENTER);
        Drawable r104 = UIUtils.getDrawable(r103.getContext(), r101);
        r103.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (r100 != null) goto L10;
        if (r102 == false) goto L9;
        int r105 = this.f430618c;
    L11:
        r104.setColorFilter(new PorterDuffColorFilter(r105, PorterDuff.Mode.SRC_IN));
        r103.setImageDrawable(r104);
        if (r100 != null) goto L16;
        if (r102 == false) goto L15;
        int r106 = this.f430622g;
    L17:
        Drawable r107 = getBackground();
        if (r107 == null) goto L21;
        r107.setColorFilter(new PorterDuffColorFilter(r106, PorterDuff.Mode.SRC_IN));
        return;
    L21:
        return;
    L15:
        r106 = this.f430623h;
        goto L17
    L16:
        r106 = this.f430622g;
        goto L17
    L9:
        r105 = this.f430619d;
        goto L11
    L10:
        r105 = this.f430618c;
        goto L11
    L4:
        r101 = this.f430616a;
        goto L5
    }

    public final void T5(boolean r100) {
        if (getIcon().getAnimation() == null) goto L5;
        getIcon().clearAnimation();
    L5:
        setEnabled(r100);
        setImageDrawable(null);
    }

    public final void setIsEnabled(boolean r100) {
        if (r100 == isEnabled()) goto L9;
        setEnabled(r100);
        if (getIcon().getAnimation() == null) goto L7;
        setImageDrawable(Integer.valueOf(R.drawable.ud_icon_loading_outlined));
        return;
    L7:
        setImageDrawable(null);
        return;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        getTitle().setText(r100);
    }

    public CircleIconWithTitle(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f430616a = -1;
        this.f430617b = -1;
        this.f430618c = UIUtils.getColor(r100, R.color.static_white_80);
        this.f430619d = UIUtils.getColor(r100, R.color.static_white_20);
        this.f430620e = -1;
        this.f430621f = -1;
        this.f430622g = UIUtils.getColor(r100, R.color.static_white_10);
        this.f430623h = UIUtils.getColor(r100, R.color.static_white_10);
        this.f430624i = LazyKt.lazy(new CircleIconWithTitle$icon$2(this));
        this.f430625j = LazyKt.lazy(new CircleIconWithTitle$title$2(this));
        boolean r102 = true;
        LayoutInflater.from(r100).inflate(R.layout.voice_widget_circle_icon_with_title, this, true);
        if (r101 == null) goto L6;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.backgroundDisableTintColor, R.attr.backgroundTintColor, R.attr.iconBackground, R.attr.iconDisableTintColor, R.attr.iconDrawableRes, R.attr.iconTintColor, R.attr.innerIconSize, R.attr.textResId});
        this.f430616a = r103.getResourceId(4, -1);
        this.f430621f = r103.getResourceId(2, -1);
        this.f430617b = r103.getResourceId(7, -1);
        this.f430618c = r103.getColor(5, this.f430618c);
        this.f430619d = r103.getColor(3, this.f430619d);
        this.f430622g = r103.getColor(1, this.f430622g);
        this.f430623h = r103.getColor(0, this.f430623h);
        this.f430620e = r103.getDimensionPixelSize(6, -1);
        r103.recycle();
    L6:
        if (this.f430617b == (-1)) goto L8;
        getTitle().setText(getContext().getString(this.f430617b));
    L9:
        ConstraintSet r104 = new ConstraintSet();
        r104.clone(this);
        if (getTitle().getVisibility() == 0) goto L14;
        r102 = false;
    L14:
        if (r102 == false) goto L16;
        r104.connect(R.id.icon, 4, R.id.title, 3);
    L17:
        r104.applyTo(this);
        if (this.f430616a == (-1)) goto L21;
        setImageDrawable(null);
    L21:
        if (this.f430621f == (-1)) goto L24;
        getIcon().setBackgroundResource(this.f430621f);
    L24:
        if (this.f430620e == (-1)) goto L27;
        ViewGroup.LayoutParams r105 = getIcon().getLayoutParams();
        int r106 = this.f430620e;
        r105.width = r106;
        r105.height = r106;
        return;
    L27:
        return;
    L16:
        r104.connect(R.id.icon, 4, 0, 4);
        goto L17
    L8:
        getTitle().setVisibility(8);
        goto L9
    }
}
