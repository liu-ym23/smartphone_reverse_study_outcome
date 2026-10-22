package com.bytedance.ee.bear.middleground.permission.apply;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class l0 extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p0 f233043a;

    public l0(p0 r100) {
        this.f233043a = r100;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        n r101 = this.f233043a.f233065i;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setUnderlineText(false);
    }
}
