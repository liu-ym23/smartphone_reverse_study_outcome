package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f0<T> implements Observer {
    public final /* synthetic */ KtvMvMidiWidget a;

    public f0(KtvMvMidiWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Boolean r4 = (Boolean) r3;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer.a r0 = this.a.d;
        if (r0 == null) goto L6;
        r0.p0(Intrinsics.areEqual(r4, Boolean.TRUE));
        return;
    }
}
