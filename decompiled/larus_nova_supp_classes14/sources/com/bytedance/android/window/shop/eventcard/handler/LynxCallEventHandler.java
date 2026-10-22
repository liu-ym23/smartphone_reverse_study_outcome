package com.bytedance.android.window.shop.eventcard.handler;

import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class LynxCallEventHandler implements com.bytedance.android.window.shop.eventcard.handler.a {
    public boolean a;
    public final List<Runnable> b;
    public final ECWindowViewModel c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final void release() {
        ((ArrayList) this.b).clear();
    }

    public LynxCallEventHandler(ECWindowViewModel r2) {
        Intrinsics.checkNotNullParameter(r2, "shopViewModel");
        this.c = r2;
        this.b = new ArrayList();
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final Map<String, Object> a(int r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        if (r2 != 1) goto L11;
        this.a = true;
        Iterator r4 = ((ArrayList) this.b).iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        ((Runnable) r4.next()).run();
        goto L6
    L8:
        ((ArrayList) this.b).clear();
        return MapsKt.emptyMap();
    L11:
        return MapsKt.emptyMap();
    }

    public final boolean b(final ECLynxCard r4, final cp3.a r5, Function1<? super String, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r4, "card");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "consumeBlocked");
        if (this.a == true) goto L6;
        List<Runnable> r0 = this.b;
        ArrayList r1 = (ArrayList) r0;
        r1.add(new c(this, r4, r5, r6));
        return false;
    L6:
        final Boolean r7 = (Boolean) r6.invoke(r5.b);
        this.c.runLowPriorityTask(new LynxCallEventHandler$doDirectCall$1(r4, r5, r7));
        if (r7 != null) goto L9;
        return false;
    L9:
        return r7.booleanValue();
    }
}
