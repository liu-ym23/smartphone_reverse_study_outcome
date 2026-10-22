package com.bytedance.awemeopen.apps.framework.base.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends ClickableSpan {
    public final float a;
    public final int b;
    public final Function1<View, Unit> c;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        this.c.invoke(r2);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        r2.setTextSize(this.a);
        r2.setColor(this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(float r2, int r3, Function1<? super View, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onClickListener");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
