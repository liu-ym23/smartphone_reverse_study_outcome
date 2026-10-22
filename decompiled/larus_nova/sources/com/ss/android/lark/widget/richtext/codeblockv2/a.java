package com.ss.android.lark.widget.richtext.codeblockv2;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.view.View;
import com.ss.android.lark.widget.select.SelectableView;
import com.ss.android.lark.widget.select.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CodeBlockV2DetailView f448290a;

    @Override // com.ss.android.lark.widget.select.q
    public final CharSequence getContent() {
        return this.f448290a.getContent();
    }

    @Override // com.ss.android.lark.widget.select.q
    public final Layout getLayout() {
        return this.f448290a.getLayout();
    }

    @Override // com.ss.android.lark.widget.select.q
    public final void clearSelection() {
        CharSequence r100 = getContent();
        if ((r100 instanceof Spannable) == true) goto L5;
        return;
    L5:
        Selection.removeSelection((Spannable) r100);
        CodeBlockV2DetailView r101 = this.f448290a;
        r101.f448398a = SelectableView.State.NORMAL;
        r101.invalidate();
        this.f448290a.invalidate();
    }

    @Override // com.ss.android.lark.widget.select.q
    public final View getView() {
        return this.f448290a;
    }

    public a(CodeBlockV2DetailView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f448290a = r100;
    }

    @Override // com.ss.android.lark.widget.select.q
    public final void setSelection(int r100, int r101) {
        CharSequence r102 = getContent();
        if ((r102 instanceof Spannable) == true) goto L5;
        return;
    L5:
        Selection.setSelection((Spannable) r102, r100, r101);
        CodeBlockV2DetailView r103 = this.f448290a;
        r103.f448398a = SelectableView.State.SELECTED;
        r103.invalidate();
        this.f448290a.invalidate();
    }
}
