package com.bytedance.ee.bear.middleground.permission.secret.detail;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends ClickableSpan {
    public final /* synthetic */ f a;

    public g(f r1) {
        this.a = r1;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        c r3 = this.a.h;
        if (r3 == null) goto L6;
        r3.a();
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        super.updateDrawState(r2);
        r2.setColor(UIHelper.getColor(2131106620));
        r2.setUnderlineText(false);
    }
}
