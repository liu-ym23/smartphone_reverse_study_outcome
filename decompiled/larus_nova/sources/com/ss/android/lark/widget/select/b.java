package com.ss.android.lark.widget.select;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.View;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LKUILightTextView f448400a;

    @Override // com.ss.android.lark.widget.select.q
    public final void clearSelection() {
        CharSequence r100 = this.f448400a.getContentText();
        if ((r100 instanceof Spannable) == true) goto L5;
        return;
    L5:
        Selection.removeSelection((Spannable) r100);
        LKUILightTextView r101 = this.f448400a;
        r101.f448398a = SelectableView.State.NORMAL;
        r101.invalidate();
        this.f448400a.invalidate();
    }

    @Override // com.ss.android.lark.widget.select.q
    public final CharSequence getContent() {
        return this.f448400a.getContentText();
    }

    @Override // com.ss.android.lark.widget.select.q
    public final Layout getLayout() {
        return this.f448400a.getLayout();
    }

    @Override // com.ss.android.lark.widget.select.q
    public final View getView() {
        return this.f448400a;
    }

    public b(LKUILightTextView r100) {
        Intrinsics.checkNotNullParameter(r100, "lightView");
        this.f448400a = r100;
    }

    @Override // com.ss.android.lark.widget.select.q
    public final void setSelection(int r100, int r101) {
        CharSequence r102 = this.f448400a.getContentText();
        if ((r102 instanceof Spannable) == true) goto L5;
        return;
    L5:
        Spannable r103 = (Spannable) r102;
        int r104 = RangesKt.coerceIn(r100, 0, r103.length());
        int r105 = RangesKt.coerceIn(r101, 0, r103.length());
        Selection.setSelection(r103, RangesKt.coerceAtMost(r104, r105), RangesKt.coerceAtLeast(r104, r105));
        LKUILightTextView r106 = this.f448400a;
        r106.f448398a = SelectableView.State.SELECTED;
        r106.invalidate();
        this.f448400a.invalidate();
    }
}
