package com.obric.oui.tips;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import pla.j;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u0012\b\b\u0002\u00109\u001a\u00020'¢\u0006\u0004\b:\u0010;J\u0014\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R#\u0010\r\u001a\n \b*\u0004\u0018\u00010\u00070\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0015\u001a\n \b*\u0004\u0018\u00010\u00070\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR(\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00168B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u001f\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00168B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR(\u0010&\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010-\u001a\u00020'2\u0006\u0010(\u001a\u00020'8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00104\u001a\u00020.2\u0006\u0010/\u001a\u00020.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006<"}, d2 = {"Lcom/obric/oui/tips/OTips;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/Function0;", "", "clickAction", "setRightIconOnClickListener", "setLeftIconOnClickListener", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getLeftIcon", "()Landroid/widget/ImageView;", "leftIcon", "Landroid/widget/TextView;", "b", "getTipsTv", "()Landroid/widget/TextView;", "tipsTv", "c", "getRightIcon", "rightIcon", "Landroid/graphics/drawable/Drawable;", "ic", "getLeftIc", "()Landroid/graphics/drawable/Drawable;", "setLeftIc", "(Landroid/graphics/drawable/Drawable;)V", "leftIc", "getRightIc", "setRightIc", "rightIc", "", "txt", "getTipsText", "()Ljava/lang/String;", "setTipsText", "(Ljava/lang/String;)V", "tipsText", "", "num", "getTipsLine", "()I", "setTipsLine", "(I)V", "tipsLine", "", "value", "getTextRolling", "()Z", "setTextRolling", "(Z)V", "textRolling", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OTips extends ConstraintLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f403350d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f403351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f403352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f403353c;

    public OTips(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OTips(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final ImageView getLeftIcon() {
        return (ImageView) this.f403351a.getValue();
    }

    public final ImageView getRightIcon() {
        return (ImageView) this.f403353c.getValue();
    }

    public final TextView getTipsTv() {
        return (TextView) this.f403352b.getValue();
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
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.toString();
    }

    private final void setLeftIc(Drawable r100) {
        getLeftIcon().setImageDrawable(r100);
        j.f(getLeftIcon());
        invalidate();
    }

    private final void setRightIc(Drawable r100) {
        getRightIcon().setImageDrawable(r100);
        j.f(getRightIcon());
        invalidate();
    }

    public final void setLeftIconOnClickListener(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "clickAction");
        ImageView r101 = getLeftIcon();
        if (r101 == null) goto L7;
        r101.setOnClickListener(new a(r100));
        return;
    }

    public final void setRightIconOnClickListener(final Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "clickAction");
        ImageView r101 = getRightIcon();
        if (r101 == null) goto L7;
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

    public OTips(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f403351a = LazyKt.lazy(new OTips$leftIcon$2(this));
        this.f403352b = LazyKt.lazy(new OTips$tipsTv$2(this));
        this.f403353c = LazyKt.lazy(new OTips$rightIcon$2(this));
        LayoutInflater.from(r100).inflate(R.layout.o_tips, this);
        if (r101 == null) goto L47;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.oui_RightIcon, R.attr.oui_leftIcon, R.attr.oui_leftIcon_tint, R.attr.oui_rightIcon_tint, R.attr.oui_spanText, R.attr.oui_textRolling, R.attr.oui_tipsLine, R.attr.oui_tipsText, R.attr.oui_tipsTextColor});
        Drawable r104 = r103.getDrawable(1);
        if (r104 == null) goto L8;
        setLeftIc(r104);
    L8:
        Drawable r105 = r103.getDrawable(0);
        if (r105 == null) goto L12;
        setRightIc(r105);
    L12:
        ColorStateList r106 = r103.getColorStateList(2);
        if (r106 == null) goto L22;
        ImageView r107 = getLeftIcon();
        if (r107 == null) goto L22;
        Drawable r108 = r107.getDrawable();
        if (r108 == null) goto L22;
        r108.setTintList(r106);
    L22:
        ColorStateList r109 = r103.getColorStateList(3);
        if (r109 == null) goto L32;
        ImageView r110 = getRightIcon();
        if (r110 == null) goto L32;
        Drawable r111 = r110.getDrawable();
        if (r111 == null) goto L32;
        r111.setTintList(r109);
    L32:
        Integer r112 = Integer.valueOf(r103.getColor(8, -1));
        if (r112.intValue() == (-1)) goto L35;
        boolean r113 = true;
    L36:
        if (r113 == true) goto L39;
        r112 = null;
    L39:
        if (r112 == null) goto L45;
        int r114 = r112.intValue();
        TextView r115 = getTipsTv();
        if (r115 == null) goto L45;
        r115.setTextColor(r114);
    L45:
        setTipsText(r103.getString(7));
        setTipsLine(r103.getInteger(6, 1));
        setTextRolling(r103.getBoolean(5, false));
        r103.getString(4);
        r103.recycle();
        return;
    L35:
        r113 = false;
        goto L36
    }

    public /* synthetic */ OTips(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
