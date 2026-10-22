package com.bytedance.android.shopping.card_list.yata.abilities;

import android.content.Context;
import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;
import v96.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class YataToastImpl implements g {
    public final Context a;

    public static final class a {
    }

    static {
    }

    public YataToastImpl(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void a(final String r2) {
        Intrinsics.checkNotNullParameter(r2, "content");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r0 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new YataToastImpl$toast$1(this, r2));
    }
}
