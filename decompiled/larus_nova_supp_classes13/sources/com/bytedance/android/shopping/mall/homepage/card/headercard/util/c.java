package com.bytedance.android.shopping.mall.homepage.card.headercard.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final void a(View r7, Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        if (r7 != null) goto L5;
        return;
    L5:
        BackgroundDrawable r0 = new BackgroundDrawable(r8, r9, false, 4, null);
        r0.setBgColor(ContextCompat.getColor(r8, 2131106130));
        int r10 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r0.setCornerRadius(com.bytedance.android.ec.hybrid.list.util.c.c(12, r8, true));
        r0.invalidate();
        Unit r11 = Unit.INSTANCE;
        r7.setBackground(r0);
    }
}
