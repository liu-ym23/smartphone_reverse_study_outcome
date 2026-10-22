package com.bytedance.android.livesdk.ktvimpl.feed;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.base.sei.k;
import com.bytedance.android.livesdk.ktvimpl.base.sei.q;
import com.bytedance.android.livesdk.ktvimpl.base.sei.v;
import com.bytedance.android.livesdk.ktvimpl.base.util.o;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a {
    public final StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> a;

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void c(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "valid");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void h(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "valid");
    }

    public b(StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "stateMachine");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void f(k r3) {
        Intrinsics.checkNotNullParameter(r3, "seiModel");
        int r0 = r3.C();
        if (r0 == 0) goto L19;
        boolean r1 = true;
        if (r0 != 1) goto L23;
        q r2 = r3.w();
        if (r2 == null) goto L11;
        String r4 = r2.h();
        if (r4 == null) goto L11;
    L13:
        if (r4.length() == 0) goto L16;
        r1 = false;
    L16:
        if (r1 == true) goto L18;
        j(new KtvRoomLyricsStateMachineConfig.a.c(o.d(r3)));
        return;
    L18:
        j(KtvRoomLyricsStateMachineConfig.a.h.c);
        return;
    L11:
        r4 = "";
        goto L13
    L23:
        return;
    L19:
        j(KtvRoomLyricsStateMachineConfig.a.h.c);
    }

    public final void j(KtvRoomLyricsStateMachineConfig.a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r0 = this.a;
        StateMachine.a r1 = StateMachine.c;
        r0.d(r3, null);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.a
    public final void g(k r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "seiModel");
        Intrinsics.checkNotNullParameter(r6, "sourceSei");
        int r7 = r5.d();
        boolean r0 = false;
        List<v> r2 = null;
        if (r7 != 0) goto L5;
        List<v> r8 = r5.l();
        if (r8 != null) goto L20;
        return;
    L20:
        if (r8.size() <= 0) goto L22;
        r0 = true;
    L22:
        if (r0 == false) goto L24;
        r2 = r8;
    L24:
        if (r2 == null) goto L32;
        j(new KtvRoomLyricsStateMachineConfig.a.e(o.d(r5), r5, (long) ((r5.y() + r5.m()) * 1000)));
        return;
    L32:
        return;
    L5:
        if (r7 != 3) goto L7;
        j(new KtvRoomLyricsStateMachineConfig.a.e(o.d(r5), r5, (long) ((r5.y() + r5.m()) * 1000)));
        return;
    L7:
        if (r7 != 4) goto L9;
        j(new KtvRoomLyricsStateMachineConfig.a.b(0));
        return;
    L9:
        if (r7 != 5) goto L11;
        j(new KtvRoomLyricsStateMachineConfig.a.d(null));
        return;
    L11:
        if (r7 != 6) goto L33;
        j(KtvRoomLyricsStateMachineConfig.a.h.c);
        return;
    }
}
