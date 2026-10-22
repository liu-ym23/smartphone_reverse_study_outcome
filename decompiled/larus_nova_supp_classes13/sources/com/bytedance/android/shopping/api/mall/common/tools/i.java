package com.bytedance.android.shopping.api.mall.common.tools;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements yj.r {
    public static final i b = null;
    public final /* synthetic */ yj.r a;

    public final Typeface a(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "fontName");
        return this.a.a(r2, r3);
    }

    public final void showToast(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "content");
        this.a.showToast(r2, r3);
    }

    static {
        b = new i();
    }

    public i() {
        this.a = h.b.getIHybridHostUIService();
    }
}
