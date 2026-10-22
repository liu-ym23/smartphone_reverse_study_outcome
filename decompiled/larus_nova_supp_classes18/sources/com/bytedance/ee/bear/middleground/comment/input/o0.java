package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o0 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ InputComment a;

    public o0(InputComment r1) {
        this.a = r1;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r4, WindowInsetsCompat r5) {
        Intrinsics.checkNotNullParameter(r4, "v");
        Intrinsics.checkNotNullParameter(r5, "insets");
        Insets r6 = r5.getInsets(WindowInsetsCompat.Type.navigationBars());
        this.a.n.setPadding(r6.left, r6.top, r6.right, r6.bottom);
        return WindowInsetsCompat.CONSUMED;
    }
}
