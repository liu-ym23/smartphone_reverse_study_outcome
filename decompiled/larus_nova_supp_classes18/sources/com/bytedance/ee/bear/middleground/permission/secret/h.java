package com.bytedance.ee.bear.middleground.permission.secret;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends ClickableSpan {
    public final /* synthetic */ Function0<Unit> a;
    public final /* synthetic */ FragmentActivity b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Function0<Unit> r3 = this.a;
        if (r3 == null) goto L6;
        r3.invoke();
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r3) {
        Intrinsics.checkNotNullParameter(r3, "ds");
        super.updateDrawState(r3);
        r3.setColor(ContextCompat.getColor(this.b, 2131108626));
        r3.setUnderlineText(false);
    }

    public h(Function0<Unit> r1, FragmentActivity r2) {
        this.a = r1;
        this.b = r2;
    }
}
