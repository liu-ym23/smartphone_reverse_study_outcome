package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a {
    public final com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final int ktvAddSongLimitNum() {
        return com.bytedance.android.livesdk.ktvimpl.base.util.e.a.a();
    }

    public b(com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ktvUIStrategy");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void cancelApply(h80.a<Boolean> r3) {
        ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleAudienceStrategy: cancelApply");
        if (k.n(IInteractService.class).getInteractAudienceService() == null) goto L8;
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r0 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r0 == null) goto L9;
        r0.Q6(r3, false, false);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a
    public final void Fh(IBaseUser r2, h80.a<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleAudienceStrategy: permit");
        k.n(IInteractService.class).permit(r2, "live_song_accept_button");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void checkAudienceSingEnablePermission(Long r1, rj0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a.C0016a.a((BaseOrderSongViewModel.e) r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void checkPermision(Context r3, IRoom r4, rj0.b r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r5, "listener");
        ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleAudienceStrategy: checkPermision");
        if (k.n(IInteractService.class).getInteractAudienceService() == null) goto L8;
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r0 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r0 == null) goto L9;
        r0.r0(r3, r4, r5);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void ktvApply(KtvMusic r2, String r3, LinkApplyType r4, tf0.b r5) {
        Intrinsics.checkNotNullParameter(r4, "applyType");
        ALogger.w("KtvComponent_MergeMode", "KtvComponentSingleAudienceStrategy: ktvApply");
        if (k.n(IInteractService.class).getInteractAudienceService() == null) goto L8;
        LinkApplyType r6 = LinkApplyType.SONG;
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r7 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r7 == null) goto L9;
        r7.c2(2, 114, "ktv_apply", r6);
        return;
    L9:
        return;
    }
}
