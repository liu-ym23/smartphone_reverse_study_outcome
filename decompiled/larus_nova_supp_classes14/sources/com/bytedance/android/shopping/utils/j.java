package com.bytedance.android.shopping.utils;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r1, Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        if ((r1 instanceof FragmentActivity) == true) goto L5;
        r1 = null;
    L5:
        FragmentActivity r3 = (FragmentActivity) r1;
        if (r3 == null) goto L11;
        Lifecycle r4 = r3.getLifecycle();
        if (r4 == null) goto L12;
        r4.addObserver(new OrderPageCloseListener(r2));
        return;
    L12:
        return;
    }
}
