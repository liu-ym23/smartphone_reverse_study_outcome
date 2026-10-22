package com.bytedance.android.shopping.sku.inner.container;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class n implements SlcKeyboardMonitor.b {
    public final /* synthetic */ View a;

    public n(View r1) {
        this.a = r1;
    }

    public final void a(SlcKeyboardMonitor.SlcApplyWindowInsetsListener r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ViewCompat.setOnApplyWindowInsetsListener(this.a, new m(r3));
    }

    public final void b(SlcKeyboardMonitor.SlcApplyWindowInsetsListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ViewCompat.setOnApplyWindowInsetsListener(this.a, null);
    }
}
