package com.bytedance.android.window.shop.home.tab;

import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.window.base.utils.window.WindowAutoCleanResourceCache;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c extends ObservableProperty<ECLynxCard> {
    public final /* synthetic */ WindowLynxTabPresenter a;

    public c(WindowLynxTabPresenter r1) {
        this.a = r1;
        super(null);
    }

    public final void afterChange(KProperty<?> r2, ECLynxCard r3, ECLynxCard r4) {
        Intrinsics.checkNotNullParameter(r2, "property");
        ECLynxCard r5 = r4;
        ECLynxCard r6 = r3;
        if (r6 == null) goto L5;
        WindowAutoCleanResourceCache r7 = (WindowAutoCleanResourceCache) this.a.g.getValue();
        r7.a.remove(r6);
        r7.b.invoke(r6);
    L5:
        if (r5 == null) goto L8;
        ((WindowAutoCleanResourceCache) this.a.g.getValue()).a.add(r5);
        return;
    }
}
