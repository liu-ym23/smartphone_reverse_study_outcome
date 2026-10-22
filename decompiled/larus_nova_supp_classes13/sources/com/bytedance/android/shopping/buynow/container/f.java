package com.bytedance.android.shopping.buynow.container;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.android.ecom.arch.slice.render.util.keyboard.SlcKeyboardMonitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements OnApplyWindowInsetsListener {
    public final /* synthetic */ OnApplyWindowInsetsListener a;

    public f(SlcKeyboardMonitor.SlcApplyWindowInsetsListener r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r2, WindowInsetsCompat r3) {
        this.a.onApplyWindowInsets(r2, r3);
        return ViewCompat.onApplyWindowInsets(r2, r3);
    }
}
