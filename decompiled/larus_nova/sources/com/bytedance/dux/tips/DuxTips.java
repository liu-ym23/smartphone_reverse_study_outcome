package com.bytedance.dux.tips;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.n;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R#\u0010\r\u001a\n \b*\u0004\u0018\u00010\u00070\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0015\u001a\n \b*\u0004\u0018\u00010\u00070\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR(\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00168B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001f\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00168B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR(\u0010&\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010-\u001a\u00020'2\u0006\u0010(\u001a\u00020'8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00104\u001a\u00020.2\u0006\u0010/\u001a\u00020.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/bytedance/dux/tips/DuxTips;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/Function0;", "", "clickAction", "setRightIconOnClickListener", "setLeftIconOnClickListener", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "b", "Lkotlin/Lazy;", "getLeftIcon", "()Landroid/widget/ImageView;", "leftIcon", "Landroid/widget/TextView;", "c", "getTipsTv", "()Landroid/widget/TextView;", "tipsTv", "d", "getRightIcon", "rightIcon", "Landroid/graphics/drawable/Drawable;", "ic", "getLeftIc", "()Landroid/graphics/drawable/Drawable;", "setLeftIc", "(Landroid/graphics/drawable/Drawable;)V", "leftIc", "getRightIc", "setRightIc", "rightIc", "", "txt", "getTipsText", "()Ljava/lang/String;", "setTipsText", "(Ljava/lang/String;)V", "tipsText", "", "num", "getTipsLine", "()I", "setTipsLine", "(I)V", "tipsLine", "", "value", "getTextRolling", "()Z", "setTextRolling", "(Z)V", "textRolling", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxTips extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f205769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f205770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f205771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f205772d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f205773a;

        public a(Function0<Unit> r100) {
            this.f205773a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f205773a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f205774a;

        public b(Function0<Unit> r100) {
            this.f205774a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f205774a.invoke();
        }
    }

    public DuxTips(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 14);
    }

    public DuxTips(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 12);
    }

    public DuxTips(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, r102, 8);
    }

    public final ImageView getLeftIcon() {
        return (ImageView) this.f205770b.getValue();
    }

    public final ImageView getRightIcon() {
        return (ImageView) this.f205772d.getValue();
    }

    public final TextView getTipsTv() {
        return (TextView) this.f205771c.getValue();
    }

    private final Drawable getLeftIc() {
        return getLeftIcon().getDrawable();
    }

    private final Drawable getRightIc() {
        return getRightIcon().getDrawable();
    }

    public final boolean getTextRolling() {
        if (getTipsTv().isSelected() == true) goto L5;
    L7:
        return false;
    L5:
        if (getTipsLine() != 1) goto L7;
        return true;
    }

    public final int getTipsLine() {
        return getTipsTv().getMaxLines();
    }

    public final String getTipsText() {
        CharSequence r100 = getTipsTv().getText();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    private final void setLeftIc(Drawable r100) {
        getLeftIcon().setImageDrawable(r100);
        n.f(getLeftIcon());
        invalidate();
    }

    private final void setRightIc(Drawable r100) {
        getRightIcon().setImageDrawable(r100);
        n.f(getRightIcon());
        invalidate();
    }

    public final void setLeftIconOnClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "clickAction");
        ImageView r101 = getLeftIcon();
        if (r101 == null) goto L6;
        r101.setOnClickListener(new a(r100));
        return;
    }

    public final void setRightIconOnClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "clickAction");
        ImageView r101 = getRightIcon();
        if (r101 == null) goto L6;
        Resources r102 = Resources.getSystem();
        n.a(r101, MathKt.roundToInt(TypedValue.applyDimension(1, 28, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()))));
        r101.setOnClickListener(new b(r100));
        return;
    }

    public final void setTextRolling(boolean r100) {
        getTipsTv().setSelected(r100);
        if (r100 == false) goto L5;
        getTipsTv().setMovementMethod(null);
        String r101 = getTipsText();
        getTipsTv().setText(null);
        getTipsTv().setText(r101);
        setTipsLine(1);
        getTipsTv().setMarqueeRepeatLimit(-1);
        getTipsTv().setEllipsize(TextUtils.TruncateAt.MARQUEE);
    L6:
        invalidate();
        return;
    L5:
        getTipsTv().setEllipsize(TextUtils.TruncateAt.END);
        goto L6
    }

    public final void setTipsLine(int r100) {
        getTipsTv().setMaxLines(r100);
        TextView r101 = getTipsTv();
        boolean r102 = true;
        if (r100 == 1) goto L6;
        r102 = false;
    L6:
        r101.setSingleLine(r102);
        invalidate();
    }

    public final void setTipsText(String r100) {
        getTipsTv().setText(r100);
        invalidate();
    }

    public DuxTips(Context r100, AttributeSet r101, int r102, int r103) {
        Integer r104 = null;
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f205769a = false;
        this.f205770b = LazyKt.lazy(new DuxTips$leftIcon$2(this));
        this.f205771c = LazyKt.lazy(new DuxTips$tipsTv$2(this));
        this.f205772d = LazyKt.lazy(new DuxTips$rightIcon$2(this));
        LayoutInflater.from(r100).inflate(R.layout.dux_tips, this);
        if (r101 == null) goto L45;
        TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.duxRightIcon, R.attr.leftIcon, R.attr.leftIcon_tint, R.attr.limitLargeFontScale, R.attr.rightIcon_tint, R.attr.spanText, R.attr.textRolling, R.attr.tipsLine, R.attr.tipsText, R.attr.tipsTextColor});
        Drawable r106 = r105.getDrawable(1);
        if (r106 == null) goto L13;
        setLeftIc(r106);
    L13:
        Drawable r107 = r105.getDrawable(0);
        if (r107 == null) goto L16;
        setRightIc(r107);
    L16:
        ColorStateList r108 = r105.getColorStateList(2);
        if (r108 == null) goto L23;
        ImageView r109 = getLeftIcon();
        if (r109 == null) goto L23;
        Drawable r110 = r109.getDrawable();
        if (r110 == null) goto L23;
        r110.setTintList(r108);
    L23:
        ColorStateList r111 = r105.getColorStateList(4);
        if (r111 == null) goto L30;
        ImageView r112 = getRightIcon();
        if (r112 == null) goto L30;
        Drawable r113 = r112.getDrawable();
        if (r113 == null) goto L30;
        r113.setTintList(r111);
    L30:
        Integer r114 = Integer.valueOf(r105.getColor(9, -1));
        if (r114.intValue() == (-1)) goto L33;
        boolean r115 = true;
    L34:
        if (r115 == false) goto L36;
        r104 = r114;
    L36:
        if (r104 == null) goto L40;
        int r116 = r104.intValue();
        TextView r117 = getTipsTv();
        if (r117 == null) goto L40;
        r117.setTextColor(r116);
    L40:
        setTipsText(r105.getString(8));
        setTipsLine(r105.getInteger(7, 1));
        setTextRolling(r105.getBoolean(6, false));
        r105.getString(5);
        if (r105.hasValue(3) == false) goto L43;
        this.f205769a = r105.getBoolean(3, false);
    L43:
        r105.recycle();
        goto L45
    L33:
        r115 = false;
    L45:
        if (this.f205769a == false) goto L58;
        ImageView r118 = getLeftIcon();
        if (r118 == null) goto L50;
        com.bytedance.dux.largefont.a.a(r118, 16, 16);
    L50:
        ImageView r119 = getRightIcon();
        if (r119 == null) goto L53;
        com.bytedance.dux.largefont.a.a(r119, 12, 12);
    L53:
        TextView r120 = getTipsTv();
        if (r120 == null) goto L57;
        com.bytedance.dux.largefont.a.c(r120, 13.0f);
        return;
    L57:
        return;
    }
}
