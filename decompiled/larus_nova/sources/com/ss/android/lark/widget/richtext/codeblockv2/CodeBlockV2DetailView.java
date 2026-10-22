package com.ss.android.lark.widget.richtext.codeblockv2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.select.SelectableView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\nH\u0014J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0014J\n\u0010\"\u001a\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u000fJ\n\u0010%\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010'H\u0016J\b\u0010*\u001a\u00020\u001cH\u0016J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\nH\u0016J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\nH\u0016R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Lcom/ss/android/lark/widget/richtext/codeblockv2/CodeBlockV2DetailView;", "Lcom/ss/android/lark/widget/select/SelectableView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "selectedColorInt", "highLightColorInt", "contentLayout", "Landroid/text/Layout;", "highLightPath", "Landroid/graphics/Path;", "getHighLightPath", "()Landroid/graphics/Path;", "highLightPath$delegate", "Lkotlin/Lazy;", "highLightPaint", "Landroid/graphics/Paint;", "getHighLightPaint", "()Landroid/graphics/Paint;", "highLightPaint$delegate", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "getUpdatedHighlightPath", "setContentLayout", "layout", "getLayout", "getContent", "", "setContentText", "content", "updateSelection", "setSelectedColor", "color", "setHighlightedColor", "richtext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CodeBlockV2DetailView extends SelectableView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f448285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f448286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Layout f448287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f448288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f448289f;

    @Override // com.ss.android.lark.widget.select.SelectableView
    public void setContentText(CharSequence r100) {
    }

    private final Paint getHighLightPaint() {
        return (Paint) this.f448289f.getValue();
    }

    private final Path getHighLightPath() {
        return (Path) this.f448288e.getValue();
    }

    private final Path getUpdatedHighlightPath() {
        if (this.f448398a != SelectableView.State.NORMAL) goto L5;
        return null;
    L5:
        Layout r100 = this.f448287d;
        if (r100 == null) goto L8;
        CharSequence r101 = r100.getText();
    L10:
        if ((r101 instanceof Spannable) == true) goto L12;
        return null;
    L12:
        int r102 = Selection.getSelectionStart(r101);
        int r103 = Selection.getSelectionEnd(r101);
        if (r102 >= 0) goto L15;
        return null;
    L15:
        getHighLightPath().reset();
        Layout r104 = this.f448287d;
        if (r104 == null) goto L18;
        r104.getSelectionPath(r102, r103, getHighLightPath());
    L18:
        Paint r105 = getHighLightPaint();
        if (this.f448398a != SelectableView.State.SELECTED) goto L21;
        int r106 = this.f448285b;
    L22:
        r105.setColor(r106);
        return getHighLightPath();
    L21:
        r106 = this.f448286c;
        goto L22
    L8:
        r101 = null;
        goto L10
    }

    @Override // com.ss.android.lark.widget.select.SelectableView
    public CharSequence getContent() {
        Layout r100 = this.f448287d;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getText();
    }

    @Override // com.ss.android.lark.widget.select.SelectableView
    public Layout getLayout() {
        return this.f448287d;
    }

    public CodeBlockV2DetailView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        int r101 = UIUtils.getColor(getContext(), R.color.primary_pri_500_20);
        this.f448285b = r101;
        this.f448286c = r101;
        this.f448288e = LazyKt.lazy(CodeBlockV2DetailView$highLightPath$2.INSTANCE);
        this.f448289f = LazyKt.lazy(CodeBlockV2DetailView$highLightPaint$2.INSTANCE);
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.save();
        if (this.f448287d == null) goto L7;
        r100.translate(getPaddingLeft(), getPaddingTop());
        Path r101 = getUpdatedHighlightPath();
        Layout r102 = this.f448287d;
        if (r102 == null) goto L7;
        int r103 = com.ss.android.lark.widget.light.b.f445973a;
        com.ss.android.lark.widget.light.b.a(r100, r102, r101, getHighLightPaint(), this.f448398a);
    L7:
        r100.restore();
    }

    public final void setContentLayout(Layout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        if (Intrinsics.areEqual(r100, this.f448287d) == false) goto L5;
        return;
    L5:
        this.f448287d = r100;
        requestLayout();
    }

    @Override // com.ss.android.lark.widget.select.SelectableView
    public void setHighlightedColor(int r100) {
        this.f448286c = r100;
        invalidate();
    }

    @Override // com.ss.android.lark.widget.select.SelectableView
    public void setSelectedColor(int r100) {
        this.f448285b = r100;
        invalidate();
    }

    public CodeBlockV2DetailView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        int r102 = UIUtils.getColor(getContext(), R.color.primary_pri_500_20);
        this.f448285b = r102;
        this.f448286c = r102;
        this.f448288e = LazyKt.lazy(CodeBlockV2DetailView$highLightPath$2.INSTANCE);
        this.f448289f = LazyKt.lazy(CodeBlockV2DetailView$highLightPaint$2.INSTANCE);
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f448287d != null) goto L5;
        return;
    L5:
        int r102 = View.MeasureSpec.getSize(r100);
        int r103 = View.MeasureSpec.getSize(r101);
        if (View.MeasureSpec.getMode(r100) == 1073741824) goto L11;
        Layout r104 = this.f448287d;
        if (r104 == null) goto L11;
        Intrinsics.checkNotNull(r104);
        int r105 = r104.getWidth() + getPaddingLeft();
        r102 = getPaddingRight() + r105;
    L11:
        if (View.MeasureSpec.getMode(r101) == 1073741824) goto L15;
        Layout r106 = this.f448287d;
        if (r106 == null) goto L15;
        r103 = (com.ss.android.lark.widget.light.layout.e.a(r106) + getPaddingTop()) + getPaddingBottom();
    L15:
        setMeasuredDimension(r102, r103);
    }

    public CodeBlockV2DetailView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        int r103 = UIUtils.getColor(getContext(), R.color.primary_pri_500_20);
        this.f448285b = r103;
        this.f448286c = r103;
        this.f448288e = LazyKt.lazy(CodeBlockV2DetailView$highLightPath$2.INSTANCE);
        this.f448289f = LazyKt.lazy(CodeBlockV2DetailView$highLightPaint$2.INSTANCE);
        setWillNotDraw(false);
    }
}
