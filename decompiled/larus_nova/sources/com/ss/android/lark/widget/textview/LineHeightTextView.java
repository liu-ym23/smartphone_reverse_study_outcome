package com.ss.android.lark.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\b\u0016\u0018\u0000 )2\u00020\u0001:\u0003'()B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u000bJ\b\u0010\"\u001a\u00020\u0007H\u0016J\u001a\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\rH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/ss/android/lark/widget/textview/LineHeightTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLineHeight", "", "mBuffer", "Landroid/widget/TextView$BufferType;", "builder", "Lcom/ss/android/lark/widget/textview/LineHeightTextView$LineHeightSpannableStringBuilder;", "getBuilder", "()Lcom/ss/android/lark/widget/textview/LineHeightTextView$LineHeightSpannableStringBuilder;", "builder$delegate", "Lkotlin/Lazy;", "isSingleLine", "", "isMaxLine", "()Z", "isEllipsized", "lastLineText", "", "getLastLineText", "()Ljava/lang/String;", "setUXLineHeight", "", "lineHeight", "setUXLineHeightInDp", "dpLineHeight", "getLineHeight", "setText", "text", "", "type", "LineHeightSpannableStringBuilder", "VCLineHeightSpan", "Companion", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LineHeightTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SparseIntArray f448911d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f448912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView.BufferType f448913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f448914c;

    public static final class a {
    }

    public static final class b extends SpannableStringBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f448915a;

        @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
        public final /* bridge */ int length() {
            return super.length();
        }

        public b() {
        }

        @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
        public final /* bridge */ char charAt(int r100) {
            return super.charAt(r100);
        }
    }

    public static final class c implements LineHeightSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f448916a;

        public c(float r100) {
            this.f448916a = (int) Math.ceil(r100);
        }

        @Override // android.text.style.LineHeightSpan
        public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
            Intrinsics.checkNotNullParameter(r100, "text");
            Intrinsics.checkNotNullParameter(r105, "fm");
            int r106 = r105.descent;
            int r107 = this.f448916a;
            if (r106 <= r107) goto L5;
            int r108 = (int) Math.min(r107, r106);
            r105.descent = r108;
            r105.bottom = r108;
            r105.ascent = 0;
            r105.top = 0;
            return;
        L5:
            int r109 = r105.ascent;
            if (((-r109) + r106) <= r107) goto L8;
            r105.bottom = r106;
            int r110 = (-r107) + r106;
            r105.ascent = r110;
            r105.top = r110;
            return;
        L8:
            int r111 = r105.bottom;
            if (((-r109) + r111) <= r107) goto L11;
            r105.top = r109;
            r105.bottom = r109 + r107;
            return;
        L11:
            int r112 = r105.top;
            if (((-r112) + r111) <= r107) goto L14;
            r105.top = r111 - r107;
            return;
        L14:
            double r113 = (r107 - ((-r112) + r111)) / 2.0f;
            r105.top = r112 - ((int) Math.ceil(r113));
            int r114 = r105.bottom + ((int) Math.floor(r113));
            r105.bottom = r114;
            r105.ascent = r105.top;
            r105.descent = r114;
        }
    }

    public LineHeightTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LineHeightTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    static {
        SparseIntArray r100 = new SparseIntArray();
        r100.put(26, 34);
        r100.put(25, 33);
        r100.put(24, 32);
        r100.put(23, 31);
        r100.put(22, 30);
        r100.put(21, 29);
        r100.put(20, 28);
        r100.put(19, 27);
        r100.put(18, 26);
        r100.put(17, 24);
        r100.put(16, 22);
        r100.put(15, 21);
        r100.put(14, 20);
        r100.put(13, 19);
        r100.put(12, 18);
        r100.put(11, 16);
        r100.put(10, 14);
        f448911d = r100;
    }

    private final b getBuilder() {
        return (b) this.f448914c.getValue();
    }

    @Override // android.widget.TextView
    public int getLineHeight() {
        return (int) this.f448912a;
    }

    public final String getLastLineText() {
        Layout r100 = getLayout();
        if (r100 != null) goto L7;
        return "";
    L7:
        return getText().toString().substring(r100.getLineStart(r100.getLineCount() - 1));
    }

    @Override // android.widget.TextView
    public final boolean isSingleLine() {
        Layout r100 = getLayout();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getLineCount() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public final void setUXLineHeight(float r100) {
        this.f448912a = r100;
        setText(getText(), this.f448913b);
    }

    public final void setUXLineHeightInDp(float r100) {
        Resources r101 = getContext().getResources();
        setUXLineHeight(WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.f448913b = r101;
        if (this.f448912a > 1.0f) goto L8;
        super.setText(r100, r101);
        return;
    L8:
        b r102 = getBuilder();
        float r103 = this.f448912a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "sequence");
        r102.clear();
        r102.clearSpans();
        c r104 = r102.f448915a;
        if (r104 == null) goto L11;
        r104.f448916a = (int) Math.ceil(r103);
    L12:
        r102.append(r100);
        r102.setSpan(r104, 0, r100.length(), 17);
        super.setText(r102, r101);
        return;
    L11:
        r104 = new c(r103);
        r102.f448915a = r104;
        goto L12
    }

    public LineHeightTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f448912a = -1.0f;
        this.f448913b = TextView.BufferType.NORMAL;
        this.f448914c = LazyKt.lazy(LazyThreadSafetyMode.NONE, LineHeightTextView$builder$2.INSTANCE);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ux_line_height});
        int r104 = r103.getDimensionPixelSize(0, -1);
        r103.recycle();
        if (r104 >= 0) goto L5;
        Resources r105 = getResources();
        float r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density;
        r104 = (int) (f448911d.get((int) (getTextSize() / r106), -1) * r106);
    L5:
        setUXLineHeight(r104);
    }

    public /* synthetic */ LineHeightTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
