package com.bytedance.android.shopping.buynow.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    public m() {
    }

    static {
    }

    public static void a(int r3) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        com.bytedance.android.ec.sdk.helper.i.a.e(ECAppInfoService.e.getApplicationContext(), com.bytedance.android.shopping.extensions.j.c(r3), false, false);
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new l(r3, false, false));
    }

    public static void b(String r3) {
        if ((!StringsKt.isBlank(r3)) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L7;
        com.bytedance.android.ec.sdk.helper.i.a.e(ECAppInfoService.e.getApplicationContext(), r3, false, false);
        return;
    L7:
        new Handler(Looper.getMainLooper()).post(new k(r3, false, false));
    }
}
