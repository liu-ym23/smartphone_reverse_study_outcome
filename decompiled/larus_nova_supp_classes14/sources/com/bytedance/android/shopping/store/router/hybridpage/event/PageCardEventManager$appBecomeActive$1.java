package com.bytedance.android.shopping.store.router.hybridpage.event;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/router/hybridpage/event/a;", "it", "", "invoke", "(Lcom/bytedance/android/shopping/store/router/hybridpage/event/a;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class PageCardEventManager$appBecomeActive$1 extends Lambda implements Function1<a, Unit> {
    public static final PageCardEventManager$appBecomeActive$1 INSTANCE = null;

    static {
        INSTANCE = new PageCardEventManager$appBecomeActive$1();
    }

    public PageCardEventManager$appBecomeActive$1() {
        super(1);
    }

    public final void invoke(a r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        r2.j();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((a) r1);
        return Unit.INSTANCE;
    }
}
