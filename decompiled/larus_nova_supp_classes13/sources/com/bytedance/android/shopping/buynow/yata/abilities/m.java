package com.bytedance.android.shopping.buynow.yata.abilities;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonToast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements v96.g {
    public final Context a;

    public static final class a {
    }

    static {
    }

    public m(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        int r0 = SkuCommonToast.a;
        SkuCommonToast.b(this.a, r2);
    }
}
