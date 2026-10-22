package com.ss.android.lark.widget.light.span;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.larus.nova.R;
import com.ss.android.lark.widget.span.AbbreviationInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbbreviationInfo f446231a;

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
    }

    public final int hashCode() {
        return this.f446231a.hashCode();
    }

    public a(AbbreviationInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "mAbbreviationInfo");
        this.f446231a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f446231a, ((a) r100).f446231a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if ((r100 instanceof mcc.m) == true) goto L6;
        return;
    L6:
        if (r100.getTag(R.id.tag_long_press) == null) goto L8;
        r100.setTag(R.id.tag_long_press, null);
        return;
    L8:
        mcc.a.InterfaceC6801a r101 = (mcc.a.InterfaceC6801a) r100;
        ((mcc.a) r100).s(r100, this.f446231a, r101.getAcitonUpX(), r101.getActionUpY());
    }
}
