package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g0<T> implements Consumer {
    public final /* synthetic */ RealTimeChorusMainViewWidget a;

    public g0(RealTimeChorusMainViewWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Long r3 = (Long) r2;
        KtvModeOrderedSongDataContext.a r4 = KtvModeOrderedSongDataContext.Companion;
        if (r4.getContext() != null) goto L5;
    L6:
        OrderedSongDataContext r5 = (OrderedSongDataContext) this.a.b1.getFirst();
        if (r5 == null) goto L9;
        com.bytedance.live.datacontext.b.a(r5, KtvModeOrderedSongDataContext.class);
    L9:
        w.a("RealTimeChorusMainViewWidget", "share KtvModeOrderedSongDataContext");
        return;
    L5:
        if ((!Intrinsics.areEqual((OrderedSongDataContext) this.a.b1.getFirst(), r4.getContext())) == true) goto L6;
    }
}
