package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.content.Context;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.livesdk.ktvimpl.base.controlnode.AddMusicControlNode;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i1 implements com.bytedance.android.livesdk.ktvimpl.base.util.e {
    public i1() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final int ktvAddSongLimitNum() {
        return ((Number) vm2.h.k0.getValue(null, vm2.h.a[61])).intValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void cancelApply(h80.a<Boolean> r4) {
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r0 == null) goto L6;
        r0.cancelApply(r4, true, null);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void checkAudienceSingEnablePermission(Long r1, rj0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((BaseOrderSongViewModel.e) r2).onSuccess();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void checkPermision(Context r5, IRoom r6, rj0.b r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "room");
        Intrinsics.checkNotNullParameter(r7, "listener");
        OperateType r8 = OperateType.APPLY;
        ArrayList r0 = new ArrayList();
        r0.add(qh0.g.a(r8, 2));
        r0.add(new qh0.f.g(r5, r8, 2));
        r0.add(new qh0.f.c(r5, r8, 2));
        r0.add(new qh0.f.a(r5));
        r0.add(new qh0.f.d(r5, r8, 2, true));
        r0.add(new qh0.f.f(r5, r8, 2, true));
        r0.add(new qh0.f.e(r5, r8));
        qh0.f.a(r0).a(new h1((AddMusicControlNode.d) r7));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void ktvApply(KtvMusic r8, String r9, LinkApplyType r10, tf0.b r11) {
        Intrinsics.checkNotNullParameter(r10, "applyType");
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.Y0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c r1 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.c.a.a();
        if (r1 == null) goto L6;
        int r0 = bh0.a.a;
        r1.ktvApply(r8, r9, r10, 102, r11);
        return;
    }
}
