package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager;

import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.n;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lvb0/a;", "invoke", "(Lvb0/a;)Lvb0/a;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final class KtvComponentFirstLevelTabManager$updateOrderSongUnreadCount$1 extends Lambda implements Function1<vb0.a, vb0.a> {
    public static final KtvComponentFirstLevelTabManager$updateOrderSongUnreadCount$1 INSTANCE = null;

    static {
        INSTANCE = new KtvComponentFirstLevelTabManager$updateOrderSongUnreadCount$1();
    }

    public KtvComponentFirstLevelTabManager$updateOrderSongUnreadCount$1() {
        super(1);
    }

    public final vb0.a invoke(vb0.a r15) {
        Intrinsics.checkNotNullParameter(r15, "$receiver");
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L13;
        n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L13;
        KtvComponentUIContext r2 = (KtvComponentUIContext) r1.getValue();
        if (r2 == null) goto L13;
        NextLiveData<Integer> r3 = r2.getOrderSongUnReadNum();
        if (r3 == null) goto L13;
        Integer r4 = (Integer) r3.getValue();
        if (r4 == null) goto L13;
        long r5 = r4.intValue();
    L15:
        return vb0.a.a(r15, Long.valueOf(r5), null, null, null, null, null, null, null, null, false, 1022);
    L13:
        r5 = 0;
        goto L15
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((vb0.a) r1);
    }
}
