package com.larus.bmhome.chat.list.cell.text.user;

import android.text.TextPaint;
import android.view.View;
import com.larus.bmhome.chat.layout.widget.w0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c extends w0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<View, Unit> f306449c;

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super View, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onResourceClick");
        super(null, null);
        this.f306449c = r100;
    }

    @Override // com.larus.bmhome.chat.layout.widget.w0, android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f306449c.invoke(r100);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        r100.setUnderlineText(false);
    }
}
