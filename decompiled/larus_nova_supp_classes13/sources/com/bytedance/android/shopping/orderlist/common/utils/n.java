package com.bytedance.android.shopping.orderlist.common.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    public static final class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public a(String r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.ec.sdk.helper.i r0 = com.bytedance.android.ec.sdk.helper.i.a;     // Catch: Throwable -> L7
            Context r1 = ECAppInfoService.e.getApplicationContext();     // Catch: Throwable -> L7
            String r2 = this.a;     // Catch: Throwable -> L7
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            r0.e(r1, r2, this.b, this.c);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public n() {
    }

    static {
    }

    public static void a(String r3, boolean r4, boolean r5) {
        if (r3 != null) goto L5;
        String r1 = "";
    L7:
        if ((!StringsKt.isBlank(r1)) == true) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L14;
        com.bytedance.android.ec.sdk.helper.i r2 = com.bytedance.android.ec.sdk.helper.i.a;
        Context r6 = ECAppInfoService.e.getApplicationContext();
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        r2.e(r6, r3, r4, r5);
        return;
    L14:
        new Handler(Looper.getMainLooper()).post(new a(r3, r4, r5));
        return;
    L5:
        r1 = r3;
        goto L7
    }
}
