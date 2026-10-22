package com.bytedance.awemeopen.apps.framework.base.view;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f193235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f193236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<View, Unit> f193237c;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f193237c.invoke(r100);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setTextSize(this.f193235a);
        r100.setColor(this.f193236b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(float r100, int r101, Function1<? super View, Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "onClickListener");
        this.f193235a = r100;
        this.f193236b = r101;
        this.f193237c = r102;
    }
}
