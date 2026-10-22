package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a {
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

    public g(com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ktvUIStrategy");
        this.a = r2;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void cancelApply(h80.a<Boolean> r2) {
        k.n(IInteractService.class).getVideoTalkService().o(r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a
    public final void Fh(IBaseUser r2, h80.a<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        k.n(IInteractService.class).permit(r2, "live_song_accept_button");
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void checkAudienceSingEnablePermission(Long r1, rj0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a.C0016a.a((BaseOrderSongViewModel.e) r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void checkPermision(Context r2, IRoom r3, rj0.b r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r4, "listener");
        k.n(IInteractService.class).getVideoTalkService().J(r2, r3, r4);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void ktvApply(KtvMusic r2, String r3, LinkApplyType r4, tf0.b r5) {
        Intrinsics.checkNotNullParameter(r4, "applyType");
        k.n(IInteractService.class).getVideoTalkService().N(r3, 114, r4, r5);
    }
}
