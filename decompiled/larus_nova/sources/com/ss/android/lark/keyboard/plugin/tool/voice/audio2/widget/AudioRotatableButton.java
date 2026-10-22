package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u00015B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u001a\u0010(\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010%\u001a\u00020&J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020-H\u0014J\u0010\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u000200H\u0002J\u0019\u00101\u001a\u00020$2\n\b\u0003\u00102\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/widget/AudioRotatableButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "getMImageView", "()Landroidx/appcompat/widget/AppCompatImageView;", "mImageView$delegate", "Lkotlin/Lazy;", "mTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "getMTextView", "()Landroidx/appcompat/widget/AppCompatTextView;", "mTextView$delegate", "defaultIconRes", "", "defaultIconColorRes", "defaultTextColorRes", "defaultTextRes", "disableIconColor", "disableTextColor", "iconZhRes", "iconOtherRes", "iconColorRes", "textRes", "textColorRes", "circleBkgNormalColor", "circleBkgDisableColor", "paint", "Landroid/graphics/Paint;", "setEnable", "", "enable", "", "stopRotation", "startRotation", "milliseconds", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "parseTypedArray", "arr", "Landroid/content/res/TypedArray;", "setImageDrawable", "resId", "(Ljava/lang/Integer;)V", "updateSubView", "Companion", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioRotatableButton extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f430025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f430026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f430027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f430028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f430029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f430030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f430031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f430032h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f430033i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f430034j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f430035k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f430036l;

    public static final class a {
    }

    static {
    }

    private final AppCompatImageView getMImageView() {
        return (AppCompatImageView) this.f430025a.getValue();
    }

    private final AppCompatTextView getMTextView() {
        return (AppCompatTextView) this.f430026b.getValue();
    }

    private final void setImageDrawable(Integer r100) {
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L8:
        AppCompatImageView r102 = getMImageView();
        r102.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int r103 = c.f430003a;
        Drawable r104 = c.d(this, r101);
        if (isEnabled() == false) goto L11;
        PorterDuffColorFilter r105 = new PorterDuffColorFilter(c.c(this, this.f430031g), PorterDuff.Mode.SRC_IN);
    L12:
        r104.setColorFilter(r105);
        r102.setImageDrawable(r104);
        return;
    L11:
        r105 = new PorterDuffColorFilter(c.c(this, this.f430027c), PorterDuff.Mode.SRC_IN);
        goto L12
    L5:
        if (KeyboardVoiceModule.a().isZh() == false) goto L7;
        r101 = this.f430029e;
        goto L8
    L7:
        r101 = this.f430030f;
        goto L8
    }

    public final void R5(boolean r100) {
        if (getMImageView().getAnimation() == null) goto L6;
        getMImageView().clearAnimation();
        setImageDrawable(null);
        setEnable(r100);
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f430035k != (-1)) goto L5;
    L11:
        super.onDraw(r100);
        return;
    L5:
        if (this.f430034j == (-1)) goto L11;
        Paint r101 = this.f430036l;
        if (isEnabled() == false) goto L9;
        int r102 = this.f430034j;
    L10:
        r101.setColor(r102);
        r100.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, getWidth() / 2.0f, this.f430036l);
        goto L11
    L9:
        r102 = this.f430035k;
        goto L10
    }

    public final void setEnable(boolean r100) {
        if (r100 == true) goto L4;
    L6:
        boolean r101 = false;
    L7:
        setEnabled(r101);
        int r102 = c.f430003a;
        if (r101 == false) goto L10;
        int r103 = this.f430031g;
    L11:
        int r104 = c.c(this, r103);
        if (r101 == false) goto L14;
        int r105 = this.f430033i;
    L15:
        int r106 = c.c(this, r105);
        getMImageView().setColorFilter(r104);
        getMTextView().setTextColor(r106);
        return;
    L14:
        r105 = this.f430028d;
        goto L15
    L10:
        r103 = this.f430027c;
        goto L11
    L4:
        if (getMImageView().getAnimation() != null) goto L6;
        r101 = true;
        goto L7
    }

    public AudioRotatableButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f430025a = LazyKt.lazy(new AudioRotatableButton$mImageView$2(this));
        this.f430026b = LazyKt.lazy(new AudioRotatableButton$mTextView$2(this));
        this.f430027c = R.color.icon_disable;
        this.f430028d = R.color.text_disable;
        this.f430029e = R.drawable.ud_icon_undo_outlined;
        this.f430030f = R.drawable.ud_icon_undo_outlined;
        this.f430031g = R.color.icon_n1;
        this.f430032h = -1;
        this.f430033i = R.color.text_caption;
        this.f430034j = -1;
        this.f430035k = -1;
        Paint r102 = new Paint(5);
        r102.setStyle(Paint.Style.FILL);
        this.f430036l = r102;
        LayoutInflater.from(r100).inflate(R.layout.layout_rotatable_button, this);
        setWillNotDraw(false);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.btn_iconColor, R.attr.btn_iconOther, R.attr.btn_iconZh, R.attr.btn_text, R.attr.btn_textColor, R.attr.circle_bkg_disable_color, R.attr.circle_bkg_normal_color});
        int r104 = r103.getResourceId(2, R.drawable.ud_icon_undo_outlined);
        this.f430029e = r104;
        this.f430030f = r103.getResourceId(1, r104);
        this.f430031g = r103.getResourceId(0, R.color.icon_n1);
        this.f430032h = r103.getResourceId(3, -1);
        this.f430033i = r103.getResourceId(4, R.color.text_caption);
        this.f430034j = r103.getColor(6, -1);
        this.f430035k = r103.getColor(5, -1);
        r103.recycle();
        setImageDrawable(null);
        StringBuilder r105 = new StringBuilder("[debug info]: mTextView.textSize: ");
        r105.append(getMTextView().getTextSize());
        r105.append(", context.resources.displayMetrics.density：");
        Resources r106 = r100.getResources();
        r105.append(WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()).density);
        r105.append(", context.resources.configuration.fontScale: ");
        r105.append(r100.getResources().getConfiguration().fontScale);
        Log.i("AudioRotatableButton", r105.toString());
        if (this.f430032h == (-1)) goto L5;
        AppCompatTextView r107 = getMTextView();
        int r108 = c.f430003a;
        r107.setText(c.f(this, this.f430032h));
    L6:
        setEnable(true);
        return;
    L5:
        getMTextView().setVisibility(8);
        goto L6
    }
}
