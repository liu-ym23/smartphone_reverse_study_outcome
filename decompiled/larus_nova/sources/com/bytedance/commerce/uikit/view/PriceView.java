package com.bytedance.commerce.uikit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.ttcjpaysdk.base.ui.widget.CJBadgeTextView;
import com.bytedance.commerce.base.richtext.a;
import com.bytedance.commerce.base.richtext.b;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/commerce/uikit/view/PriceView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "uikit_release"}, k = 1, mv = {1, 4, 0})
public final class PriceView extends AppCompatTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f202958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f202959b;

    public PriceView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PriceView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        if (this.f202958a.f202917j == false) goto L6;
        float r101 = 3;
        r100.drawLine(getPaddingLeft(), getPaddingTop() + ((((getHeight() - getPaddingTop()) - getPaddingBottom()) / 5.0f) * r101), getWidth() - getPaddingRight(), ((((getHeight() - getPaddingTop()) - getPaddingBottom()) / 5.0f) * r101) + getPaddingTop(), this.f202959b);
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r100);
        int r103 = View.MeasureSpec.getSize(r100);
        int r104 = View.MeasureSpec.getMode(r101);
        int r105 = View.MeasureSpec.getSize(r101);
        if (r102 == Integer.MIN_VALUE) goto L7;
        if (r104 == Integer.MIN_VALUE) goto L7;
        super.onMeasure(r100, r101);
        return;
    L7:
        int r106 = Integer.MAX_VALUE;
        int r107 = Integer.MAX_VALUE;
    L8:
        if (r106 > r105) goto L12;
        if (r107 > r103) goto L12;
        return;
    L12:
        setTextSize(0, getTextSize() - 1);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), r101);
        r107 = getMeasuredWidth();
        r106 = getMeasuredHeight();
        goto L8
    }

    public PriceView(Context r210, AttributeSet r211, int r212) {
        super(r210, r211, r212);
        a r100 = new a(this);
        this.f202958a = r100;
        Paint r101 = new Paint();
        this.f202959b = r101;
        TypedArray r102 = getContext().obtainStyledAttributes(r211, new int[]{R.attr.pv_hideYuanSymbol, R.attr.pv_prefixMarginRight, R.attr.pv_prefixText, R.attr.pv_prefixTextColor, R.attr.pv_prefixTextSizeRatio, R.attr.pv_priceBold, R.attr.pv_priceDecimalTextSizeRatio, R.attr.pv_priceInFen, R.attr.pv_priceTextColor, R.attr.pv_showStrikeThrough, R.attr.pv_strikeThroughColor, R.attr.pv_strikeThroughThickness, R.attr.pv_suffixText, R.attr.pv_suffixTextColor, R.attr.pv_suffixTextMarginLeft, R.attr.pv_suffixTextSizeRatio, R.attr.pv_yuanSymbolBold, R.attr.pv_yuanSymbolMarginRight, R.attr.pv_yuanSymbolRatioOfPriceTextSize});
        r100.f202909b = r102.getInteger(7, 0);
        r100.f202910c = r102.getColor(8, CJBadgeTextView.BADGE_COLOR);
        r100.f202911d = r102.getFloat(6, 0.6666667f);
        r100.f202912e = r102.getBoolean(5, false);
        r100.f202913f = r102.getBoolean(0, false);
        r100.f202914g = r102.getFloat(18, 0.6666667f);
        r100.f202915h = r102.getBoolean(16, false);
        r100.f202916i = r102.getDimensionPixelSize(17, vf4.a.a(getContext(), 2.0f));
        r100.f202917j = r102.getBoolean(9, false);
        r100.f202918k = r102.getColor(10, r100.f202910c);
        r100.f202919l = r102.getDimensionPixelSize(11, vf4.a.a(getContext(), 1.0f));
        String r110 = r102.getString(2);
        String r111 = "";
        if (r110 != null) goto L6;
        r110 = "";
    L6:
        r100.f202920m = r110;
        r100.f202921n = r102.getFloat(4, 1.0f);
        r100.f202922o = r102.getColor(3, r100.f202910c);
        r100.f202923p = r102.getDimensionPixelSize(1, vf4.a.a(getContext(), 4.0f));
        String r112 = r102.getString(12);
        if (r112 != null) goto L10;
        r112 = "";
    L10:
        r100.f202924q = r112;
        r100.f202925r = r102.getFloat(15, 1.0f);
        r100.f202927t = r102.getColor(13, r100.f202910c);
        r100.f202926s = r102.getDimensionPixelSize(14, vf4.a.a(getContext(), 2.0f));
        r102.recycle();
        r101.setStrokeWidth(r100.f202919l);
        r101.setColor(r100.f202918k);
        setMaxLines(1);
        a r103 = new AnonymousClass1(this).invoke(r100);
        r103.getClass();
        int r104 = b.f202928a;
        SpannableStringBuilder r105 = new SpannableStringBuilder();
        if (r103.f202920m.length() <= 0) goto L13;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L18;
        SpannableString r107 = new SpannableString(r103.f202920m);
        r107.setSpan(new ForegroundColorSpan(r103.f202922o), 0, r107.length(), 17);
        r107.setSpan(new RelativeSizeSpan(r103.f202921n), 0, r107.length(), 17);
        r105.append(r107);
        SpannableString r108 = new SpannableString(" ");
        r108.setSpan(new b.a(r103.f202923p), 0, r108.length(), 17);
        r105.append(r108);
    L18:
        if (r103.f202913f == true) goto L23;
        SpannableString r109 = new SpannableString("¥");
        r109.setSpan(new ForegroundColorSpan(r103.f202910c), 0, r109.length(), 17);
        r109.setSpan(new RelativeSizeSpan(r103.f202914g), 0, r109.length(), 17);
        if (r103.f202915h == false) goto L22;
        r109.setSpan(new StyleSpan(1), 0, r109.length(), 17);
    L22:
        r105.append(r109);
        SpannableString r113 = new SpannableString(" ");
        r113.setSpan(new b.a(r103.f202916i), 0, r113.length(), 17);
        r105.append(r113);
    L23:
        long r114 = r103.f202909b;
        long r115 = 100;
        if ((r114 % r115) != 0) goto L27;
        String r116 = String.valueOf(r114 / r115);
    L31:
        if (StringsKt.contains$default(r116, ".", false, 2, null) == false) goto L37;
        String r117 = "null cannot be cast to non-null type java.lang.String";
        int r118 = StringsKt.indexOf$default(r116, ".", 0, false, 6, null);
        if (r116 == null) goto L36;
        String r119 = r116.substring(0, r118);
    L39:
        if (StringsKt.contains$default(r116, ".", false, 2, null) == false) goto L45;
        int r120 = StringsKt.indexOf$default(r116, ".", 0, false, 6, null);
        if (r116 == null) goto L44;
        r111 = r116.substring(r120);
        goto L45
    L44:
        throw new TypeCastException(r117);
    L45:
        SpannableString r121 = new SpannableString(r119);
        r121.setSpan(new ForegroundColorSpan(r103.f202910c), 0, r121.length(), 17);
        r121.setSpan(new RelativeSizeSpan(1.0f), 0, r121.length(), 17);
        if (r103.f202912e == false) goto L48;
        r121.setSpan(new StyleSpan(1), 0, r121.length(), 17);
    L48:
        r105.append(r121);
        if (r111.length() <= 0) goto L51;
        boolean r122 = true;
    L52:
        if (r122 == false) goto L60;
        SpannableString r123 = new SpannableString(r111);
        r123.setSpan(new ForegroundColorSpan(r103.f202910c), 0, r123.length(), 17);
        r123.setSpan(new RelativeSizeSpan(r103.f202911d), 0, r123.length(), 17);
        if (r103.f202912e == false) goto L57;
        r123.setSpan(new StyleSpan(1), 0, r123.length(), 17);
    L57:
        r105.append(r123);
    L60:
        if (r103.f202924q.length() <= 0) goto L62;
        boolean r124 = true;
    L63:
        if (r124 == false) goto L65;
        SpannableString r125 = new SpannableString(" ");
        r125.setSpan(new b.a(r103.f202926s), 0, r125.length(), 17);
        r105.append(r125);
        SpannableString r126 = new SpannableString(r103.f202924q);
        r126.setSpan(new ForegroundColorSpan(r103.f202927t), 0, r126.length(), 17);
        r126.setSpan(new RelativeSizeSpan(r103.f202925r), 0, r126.length(), 17);
        r105.append(r126);
    L65:
        TextView r127 = r103.f202908a;
        if (r127 == null) goto L68;
        r127.setText(r105);
    L68:
        setText(r105);
        return;
    L62:
        r124 = false;
        goto L63
    L51:
        r122 = false;
        goto L52
    L36:
        throw new TypeCastException(r117);
    L37:
        r117 = "null cannot be cast to non-null type java.lang.String";
        r119 = r116;
        goto L39
    L27:
        if ((r114 % ((long) 10)) != 0) goto L29;
        StringCompanionObject r128 = StringCompanionObject.INSTANCE;
        r116 = String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r114 / 100.0d)}, 1));
        goto L31
    L29:
        StringCompanionObject r129 = StringCompanionObject.INSTANCE;
        r116 = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r114 / 100.0d)}, 1));
        goto L31
    L13:
        r106 = false;
        goto L15
    }

    public /* synthetic */ PriceView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
