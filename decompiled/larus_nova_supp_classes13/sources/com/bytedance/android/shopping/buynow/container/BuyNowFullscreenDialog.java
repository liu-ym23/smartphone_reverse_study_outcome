package com.bytedance.android.shopping.buynow.container;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/buynow/container/BuyNowFullscreenDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowFullscreenDialog extends AppCompatDialog {
    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        Window r4 = getWindow();
        if (r4 == null) goto L9;
        int r0 = Build.VERSION.SDK_INT;
        r4.setStatusBarColor(0);
        r4.addFlags(Integer.MIN_VALUE);
        if (r0 >= 23) goto L7;
        r4.addFlags(67108864);
    L7:
        r4.setLayout(-1, -1);
        return;
    }

    public BuyNowFullscreenDialog(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
