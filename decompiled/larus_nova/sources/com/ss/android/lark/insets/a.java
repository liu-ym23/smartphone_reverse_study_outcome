package com.ss.android.lark.insets;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowInsetsCompat;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroupCompat;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnApplyWindowInsetsListener f427729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f427730b;

    public a(ForsetiNormalChainViewGroupCompat.a r100, ViewGroup r101) {
        this.f427729a = r100;
        this.f427730b = r101;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "insets");
        WindowInsetsCompat r102 = this.f427729a.onApplyWindowInsets(r100, r101);
        Iterator<View> r103 = ViewGroupKt.getChildren(this.f427730b).iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        r103.next().dispatchApplyWindowInsets(r102.toWindowInsets());
        goto L4
    L7:
        return WindowInsetsCompat.CONSUMED;
    }
}
