package com.bytedance.ee.bear.document.render.init;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f221293a = null;

    static {
        f221293a = new d();
    }

    public d() {
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, "<unused var>");
        Intrinsics.checkNotNullParameter(r101, "insets");
        return new WindowInsetsCompat.Builder(r101).setInsets(WindowInsetsCompat.Type.ime(), Insets.NONE).build();
    }
}
