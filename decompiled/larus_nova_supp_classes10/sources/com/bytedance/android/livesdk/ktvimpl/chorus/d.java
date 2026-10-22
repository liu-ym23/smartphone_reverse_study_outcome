package com.bytedance.android.livesdk.ktvimpl.chorus;

import com.bytedance.android.live.liveinteract.model.ChorusInfo;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.k1;
import com.bytedance.android.livesdk.chatroom.model.interact.p2;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ ChorusWidget a;

    public d(ChorusWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        k1 r4 = (k1) ((ExtraResponse) ((com.bytedance.android.live.network.response.e) r3)).data;
        if (r4 == null) goto L12;
        p2 r5 = r4.getLinkmicPlayModeInfo();
        if (r5 == null) goto L12;
        ChorusInfo r6 = r5.getChorusInfo();
        if (r6 == null) goto L12;
        ChorusViewModel r0 = this.a.b;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
    L11:
        ChorusInfo r7 = r6;
        r0.getChorusInfo().setValue(r7);
        c.a.b = r7;
    L12:
        c.d();
    }
}
