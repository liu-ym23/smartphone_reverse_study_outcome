package com.bytedance.android.shopping.verify;

import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class c extends ClickableSpan {
    public final String a;
    public final int b;

    @Override // android.text.style.ClickableSpan
    public void onClick(View r5) {
        Intrinsics.checkNotNullParameter(r5, "widget");
        Activity r6 = ECAppInfoService.e.getCurrentActivity();
        if (r6 == null) goto L6;
        jj.a.a.b(p.a, this.a, r6, null, 28);
        return;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r2) {
        Intrinsics.checkNotNullParameter(r2, "ds");
        r2.setColor(this.b);
        r2.setUnderlineText(false);
    }

    public c(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "mUrl");
        this.a = r2;
        this.b = r3;
    }
}
