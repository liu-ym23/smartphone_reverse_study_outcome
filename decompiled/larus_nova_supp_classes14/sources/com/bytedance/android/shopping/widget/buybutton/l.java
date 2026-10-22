package com.bytedance.android.shopping.widget.buybutton;

import com.bytedance.android.ec.model.ButtonTime;
import com.bytedance.android.ec.model.ButtonType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l {
    public final String a;
    public final String b;
    public final String c;
    public final Boolean d;
    public final ButtonTime e;
    public final ButtonType f;
    public final Integer g;

    public l() {
        this(null, null, null, null, null, ButtonType.NORMAL, null);
    }

    public l(String r2, String r3, String r4, Boolean r5, ButtonTime r6, ButtonType r7, Integer r8) {
        Intrinsics.checkNotNullParameter(r7, "buttonType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
