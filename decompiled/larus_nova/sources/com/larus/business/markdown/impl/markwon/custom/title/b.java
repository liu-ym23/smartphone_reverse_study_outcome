package com.larus.business.markdown.impl.markwon.custom.title;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f320666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gw8.a f320667b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f320667b.a(r100, this.f320666a);
        if ((r100 instanceof TextView) == false) goto L5;
        TextView r101 = (TextView) r100;
    L6:
        if (r101 == null) goto L10;
        r101.setHighlightColor(0);
        return;
    L10:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setUnderlineText(false);
    }

    public b(c r100, gw8.a r101) {
        Intrinsics.checkNotNullParameter(r100, "fullScreenDetailInfoSpan");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f320666a = r100;
        this.f320667b = r101;
    }
}
