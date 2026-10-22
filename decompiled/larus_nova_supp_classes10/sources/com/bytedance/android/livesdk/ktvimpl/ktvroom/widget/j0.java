package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j0<T> implements Observer {
    public final /* synthetic */ KtvMvMidiWidget a;

    public j0(KtvMvMidiWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        KtvMvMidiWidget r0 = this.a;
        r0.getClass();
        if (Intrinsics.areEqual((Boolean) r3, Boolean.TRUE) == false) goto L6;
        r0.wq();
        return;
    }
}
