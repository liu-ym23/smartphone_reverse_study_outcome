package com.bytedance.android.shopping.mall.homepage.card;

import android.view.View;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.shopping.mall.homepage.card.ECMallInstantCardExtensionsKt$generateClickDelegate$1] */
    public static final ECMallInstantCardExtensionsKt$generateClickDelegate$1 a(final View.OnClickListener r1, final Function0 r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$convertToAddressUpdateClickListener");
        Intrinsics.checkNotNullParameter(r2, "addressProvider");
        return new ECMallInstantCardExtensionsKt$generateClickDelegate$1(r2, r1);
    }
}
