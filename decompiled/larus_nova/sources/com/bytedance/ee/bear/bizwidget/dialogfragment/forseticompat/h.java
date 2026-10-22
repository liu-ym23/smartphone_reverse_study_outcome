package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class h {

    public static final class a implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f216467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f216468b;

        public a(View r100, int r101) {
            this.f216467a = r100;
            this.f216468b = r101;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            Intrinsics.checkNotNullParameter(r101, "insets");
            Insets r102 = r101.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets r103 = r101.getInsets(WindowInsetsCompat.Type.ime());
            tt5.a.h("ForsetiInsetsHelper", "insets change, systemBarsCompat: " + r102 + ", imeCompat: " + r103 + ", view: " + r100);
            View r104 = this.f216467a;
            r104.setPadding(r104.getPaddingLeft(), Math.max(r103.top, r102.top), r104.getPaddingRight(), Math.max(r103.bottom, r102.bottom) + this.f216468b);
            return new WindowInsetsCompat.Builder(r101).setInsets(WindowInsetsCompat.Type.systemBars(), Insets.of(r102.left, 0, r102.right, 0)).setInsets(WindowInsetsCompat.Type.ime(), Insets.of(r103.left, 0, r103.right, 0)).build();
        }
    }

    public static final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.getPaddingBottom();
        tt5.a.h("ForsetiInsetsHelper", "handleInsetsForFloat, originPaddingBottom: " + r101 + ", view: " + r100);
        ViewCompat.setOnApplyWindowInsetsListener(r100, new a(r100, r101));
    }
}
