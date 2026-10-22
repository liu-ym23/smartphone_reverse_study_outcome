package com.larksuite.component.card.component.text;

import android.content.Context;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.util.AttributeSet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0015"}, d2 = {"Lcom/larksuite/component/card/component/text/UniversalCardLightTextView;", "Lcom/ss/android/lark/widget/light/LKUILightTextView;", "Lcom/ss/android/lark/widget/card/ICardSpanListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onDetachedFromWindow", "", "onDrawableInvalidated", "setLayout", "layout", "Landroid/text/Layout;", "cancelAnimations", "setListeners", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UniversalCardLightTextView extends LKUILightTextView implements ybc.b {
    public final void B() {
        CharSequence r100 = getContentText();
        if ((r100 instanceof Spanned) == true) goto L5;
        return;
    L5:
        Spanned r101 = (Spanned) r100;
        int r102 = 0;
        ybc.a[] r103 = (ybc.a[]) r101.getSpans(0, r101.length(), ybc.a.class);
        Intrinsics.checkNotNull(r103);
        int r104 = r103.length;
    L6:
        if (r102 >= r104) goto L8;
        r103[r102].cancelAnimation();
        r102 = r102 + 1;
        goto L6
    }

    @Override // com.ss.android.lark.widget.light.LKUILightTextView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    @Override // ybc.b
    public final void h() {
        invalidate();
    }

    public UniversalCardLightTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    private final void setListeners(Layout r100) {
        CharSequence r101 = r100.getText();
        if ((r101 instanceof Spannable) == true) goto L5;
        return;
    L5:
        int r102 = 0;
        ybc.a[] r103 = (ybc.a[]) ((Spannable) r101).getSpans(0, r101.length(), ybc.a.class);
        Intrinsics.checkNotNull(r103);
        int r104 = r103.length;
    L6:
        if (r102 >= r104) goto L8;
        r103[r102].a(this);
        r102 = r102 + 1;
        goto L6
    }

    public final void setLayout(Layout r100) {
        Intrinsics.checkNotNullParameter(r100, "layout");
        if (Intrinsics.areEqual(r100, getLayout()) == false) goto L5;
        return;
    L5:
        B();
        setListeners(r100);
        setContentLayout(r100);
    }

    public UniversalCardLightTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
    }

    public UniversalCardLightTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
    }
}
