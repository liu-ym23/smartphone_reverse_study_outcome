package com.bytedance.android.livesdk.ktvimpl.base.util;

import android.content.Context;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.livesdk.ktvimpl.base.controlnode.AddMusicControlNode;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements e {
    public b() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final int ktvAddSongLimitNum() {
        return e.a.a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void cancelApply(h80.a<Boolean> r4) {
        Lazy r0 = KtvSettingHelper.a;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r1 == null) goto L6;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.b.a(r1, r4, true, 4);
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
        Lazy r8 = KtvSettingHelper.a;
        OperateType r9 = OperateType.APPLY;
        ArrayList r0 = new ArrayList();
        r0.add(qh0.g.a(r9, 2));
        r0.add(new qh0.f.g(r5, r9, 2));
        r0.add(new qh0.f.c(r5, r9, 2));
        r0.add(new qh0.f.a(r5));
        r0.add(new qh0.f.d(r5, r9, 2, true));
        r0.add(new qh0.f.f(r5, r9, 2, true));
        r0.add(new qh0.f.e(r5, r9));
        qh0.f.a(r0).a(new a((AddMusicControlNode.d) r7));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void ktvApply(KtvMusic r8, String r9, LinkApplyType r10, tf0.b r11) {
        Intrinsics.checkNotNullParameter(r10, "applyType");
        Lazy r0 = KtvSettingHelper.a;
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0 == null) goto L8;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a();
        if (r1 == null) goto L9;
        int r2 = bh0.a.a;
        r1.ktvApply(r8, r9, r10, 102, r11);
        return;
    L9:
        return;
    }
}
