package com.bytedance.android.window.shop.home.tabcard;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.ability.m0;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.window.base.widget.ECWindowRoundedLinearLayout;
import kotlin.jvm.internal.Intrinsics;
import zq3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends m0 {
    public final /* synthetic */ WindowHybridTabCardGroup a;

    public a(WindowHybridTabCardGroup r1) {
        this.a = r1;
    }

    public final ECLynxCardHolder a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        ECWindowRoundedLinearLayout r0 = new ECWindowRoundedLinearLayout(r6, null, 6, 0);
        r0.setOrientation(1);
        r0.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        r0.setMinimumHeight(1);
        WindowHybridTabCardGroup.WindowLynxHolder r7 = new WindowHybridTabCardGroup.WindowLynxHolder(r0, (String) this.a.a.getValue());
        int r1 = d.a;
        ((ECLynxCardHolder) r7).q = d.b(this.a.i, null, null);
        return r7;
    }
}
