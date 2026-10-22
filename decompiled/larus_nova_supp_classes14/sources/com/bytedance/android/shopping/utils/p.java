package com.bytedance.android.shopping.utils;

import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    @JvmStatic
    public static final void a() {
        Intrinsics.checkNotNullParameter("ec", "scene");
        Intrinsics.checkNotNullParameter("enter_buy_now", "triggerAction");
    }

    public static String b() {
        return TTCJPayUtils.Companion.getInstance().getSDKVersion();
    }

    static {
    }
}
