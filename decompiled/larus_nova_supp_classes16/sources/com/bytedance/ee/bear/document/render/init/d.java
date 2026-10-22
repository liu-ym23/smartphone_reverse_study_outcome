package com.bytedance.ee.bear.document.render.init;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements OnApplyWindowInsetsListener {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r2, WindowInsetsCompat r3) {
        Intrinsics.checkNotNullParameter(r2, "<unused var>");
        Intrinsics.checkNotNullParameter(r3, "insets");
        return new WindowInsetsCompat.Builder(r3).setInsets(WindowInsetsCompat.Type.ime(), Insets.NONE).build();
    }
}
