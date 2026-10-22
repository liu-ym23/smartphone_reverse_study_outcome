package com.bytedance.android.shopping.sku.inner.container;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/container/SkuYataFixedDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuYataFixedDialog extends AppCompatDialog {
    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        Window r3 = getWindow();
        if (r3 == null) goto L5;
        r3.setLayout(-1, -1);
    L5:
        Window r4 = getWindow();
        if (r4 == null) goto L9;
        r4.setSoftInputMode(48);
        return;
    }

    public SkuYataFixedDialog(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
