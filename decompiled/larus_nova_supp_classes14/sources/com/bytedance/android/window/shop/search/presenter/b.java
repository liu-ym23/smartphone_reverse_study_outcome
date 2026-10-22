package com.bytedance.android.window.shop.search.presenter;

import android.os.SystemClock;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.android.window.shop.search.viewmodel.WindowSearchViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ WindowSearchGroupPresenter a;
    public final /* synthetic */ LinearLayout b;
    public final /* synthetic */ RecyclerView c;

    public b(WindowSearchGroupPresenter r1, LinearLayout r2, RecyclerView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onChanged(Object r4) {
        if (com.bytedance.android.shopping.extensions.k.c((String) r4) == false) goto L5;
        ExtensionsKt.gone(this.b);
        return;
    L5:
        WindowSearchViewModel r5 = this.a.e;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        r5.setPageDuration(0);
        WindowSearchViewModel r6 = this.a.e;
        if (r6 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        r6.setMiddlePageStartTime(SystemClock.elapsedRealtime());
        ExtensionsKt.visible(this.b);
        ExtensionsKt.gone(this.c);
    }
}
