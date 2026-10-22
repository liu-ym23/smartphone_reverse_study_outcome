package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h {

    public static final class a implements OnApplyWindowInsetsListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;

        public a(View r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final WindowInsetsCompat onApplyWindowInsets(View r7, WindowInsetsCompat r8) {
            Intrinsics.checkNotNullParameter(r7, "v");
            Intrinsics.checkNotNullParameter(r8, "insets");
            Insets r0 = r8.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets r1 = r8.getInsets(WindowInsetsCompat.Type.ime());
            tt5.a.h("ForsetiInsetsHelper", "insets change, systemBarsCompat: " + r0 + ", imeCompat: " + r1 + ", view: " + r7);
            View r9 = this.a;
            r9.setPadding(r9.getPaddingLeft(), Math.max(r1.top, r0.top), r9.getPaddingRight(), Math.max(r1.bottom, r0.bottom) + this.b);
            return new WindowInsetsCompat.Builder(r8).setInsets(WindowInsetsCompat.Type.systemBars(), Insets.of(r0.left, 0, r0.right, 0)).setInsets(WindowInsetsCompat.Type.ime(), Insets.of(r1.left, 0, r1.right, 0)).build();
        }
    }

    public static final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r0 = r3.getPaddingBottom();
        tt5.a.h("ForsetiInsetsHelper", "handleInsetsForFloat, originPaddingBottom: " + r0 + ", view: " + r3);
        ViewCompat.setOnApplyWindowInsetsListener(r3, new a(r3, r0));
    }
}
