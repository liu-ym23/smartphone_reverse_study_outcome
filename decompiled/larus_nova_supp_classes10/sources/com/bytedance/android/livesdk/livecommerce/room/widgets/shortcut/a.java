package com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.model.JumpUrl;
import com.bytedance.android.livesdk.livecommerce.room.f;
import com.bytedance.android.livesdk.livecommerce.utils.k;
import com.bytedance.android.livesdk.livecommerce.utils.t;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends ClickableSpan {
    public final /* synthetic */ JumpUrl a;
    public final /* synthetic */ Context b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        String r4 = this.a.getUrl();
        if (com.bytedance.android.shopping.anchorv3.a.b(r4) == true) goto L6;
        r4 = null;
    L6:
        Context r0 = this.b;
        Handler r1 = k.a;
        f.b(r0, r4);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r5) {
        Intrinsics.checkNotNullParameter(r5, "ds");
        super.updateDrawState(r5);
        int r0 = t.a;
        Context r1 = this.b;
        Object r2 = null;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        Resources r4 = th.a.f(r1);     // Catch: Throwable -> L11
        if (r4 == null) goto L8;
        Integer r6 = Integer.valueOf(r4.getColor(2131101601));     // Catch: Throwable -> L11
    L9:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L11
    L14:
        if (Result.exceptionOrNull-impl(r7) == null) goto L17;
        dm.a.a("ECLiveResourceUtils").i("safeGetResourceColor error!!!");
    L17:
        if (Result.isFailure-impl(r7) == true) goto L20;
        r2 = r7;
    L20:
        Integer r8 = (Integer) r2;
        if (r8 == null) goto L23;
        r5.setColor(r8.intValue());
    L23:
        r5.setUnderlineText(false);
        return;
    L8:
        r6 = null;
    L11:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public a(JumpUrl r1, Context r2) {
        this.a = r1;
        this.b = r2;
    }
}
