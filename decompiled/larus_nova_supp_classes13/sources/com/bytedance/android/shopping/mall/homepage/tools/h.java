package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.keva.Keva;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h<V> implements Callable {
    public final /* synthetic */ ECMallFavoriteSectionHelper a;
    public final /* synthetic */ String[] b;
    public final /* synthetic */ int c;

    public h(ECMallFavoriteSectionHelper r1, String[] r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        if (this.b.length != 0) goto L5;
        boolean r0 = true;
    L7:
        if ((!r0) == false) goto L12;
        Keva r1 = com.bytedance.android.shopping.api.mall.common.tools.s.a;
        ECMallFavoriteSectionHelper r2 = this.a;
        int r3 = this.c;
        Lazy r4 = ECMallFavoriteSectionHelper.I;
        String r5 = r2.n(r3);
        String[] r6 = this.b;
        Intrinsics.checkNotNullParameter(r5, "key");
        Keva r7 = com.bytedance.android.shopping.api.mall.common.tools.s.a;
        if (r7 == null) goto L13;
        r7.storeStringArray(r5, r6);
        Unit r8 = Unit.INSTANCE;
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
