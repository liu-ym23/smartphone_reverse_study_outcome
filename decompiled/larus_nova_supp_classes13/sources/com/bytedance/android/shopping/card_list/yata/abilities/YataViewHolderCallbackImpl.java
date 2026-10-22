package com.bytedance.android.shopping.card_list.yata.abilities;

import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.monitor.CardListYataMonitorManager;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class YataViewHolderCallbackImpl {
    public final String a;
    public final AtomicBoolean b;
    public final Lazy c;
    public final CardListObjectContainer d;

    public final CardListYataMonitorManager a() {
        return (CardListYataMonitorManager) this.c.getValue();
    }

    public YataViewHolderCallbackImpl(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.d = r2;
        CardPassThroughData r3 = r2.e.a;
        if (r3 == null) goto L5;
        String r4 = r3.getMonitorId();
    L6:
        this.a = r4;
        this.b = new AtomicBoolean(false);
        this.c = LazyKt.lazy(new YataViewHolderCallbackImpl$monitorManager$2(this));
        return;
    L5:
        r4 = null;
        goto L6
    }
}
