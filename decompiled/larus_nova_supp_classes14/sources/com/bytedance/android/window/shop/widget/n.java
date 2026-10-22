package com.bytedance.android.window.shop.widget;

import android.content.SharedPreferences;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n<T> implements ObservableOnSubscribe {
    public final /* synthetic */ ToolBarView a;
    public final /* synthetic */ com.bytedance.android.window.shop.repository.tab.entity.d b;

    public n(ToolBarView r1, com.bytedance.android.window.shop.repository.tab.entity.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        ToolBarView r0 = this.a;
        com.bytedance.android.window.shop.repository.tab.entity.d r1 = this.b;
        int r2 = ToolBarView.l;
        r0.getClass();
        String r3 = "filter_type_" + r1.a;
        SharedPreferences r4 = this.a.getContext().getSharedPreferences("ec_window", 0);
        boolean r6 = r4.getBoolean(r3, false);
        if (r6 == true) goto L6;
        r4.edit().putBoolean(r3, true).apply();
        r5.onNext(Boolean.valueOf(r6));
        return;
    L6:
        r5.onNext(Boolean.valueOf(r6));
    }
}
