package com.bytedance.android.shopping.yata.biz.popup.component;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a {
    public com.bytedance.android.shopping.yata.biz.popup.a a;
    public hl3.c b;
    public final Context c;
    public final il3.a d;

    public final Context getContext() {
        return this.c;
    }

    public a(Context r2, il3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.c = r2;
        this.d = r3;
    }

    public final <O> O c(String r2, O r3) {
        return (O) this.d.a(r2, r3);
    }
}
