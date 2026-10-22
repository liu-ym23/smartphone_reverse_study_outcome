package ve2;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements a {
    public j() {
    }

    @Override // ve2.a
    public final void cancelApply(h80.a<Boolean> r2) {
        k.n(IInteractService.class).getAudioTalkService().h(r2);
    }

    @Override // ve2.a
    public final void a(MusicPanel r8, com.bytedance.android.livesdk.ktvimpl.multichorus.d.a r9) {
        Intrinsics.checkNotNullParameter(r8, "music");
        Intrinsics.checkNotNullParameter(r9, "applyCallback");
        qd0.a r1 = k.n(IInteractService.class).getAudioTalkService();
        KtvMusic r2 = r8.a;
        LinkApplyType r4 = LinkApplyType.KTV_MULTI_CHORUS;
        int r10 = bh0.a.a;
        r1.ktvApply(r2, "推荐", r4, 102, r9);
    }

    @Override // ve2.a
    public final void b(Context r2, IRoom r3, com.bytedance.android.livesdk.ktvimpl.multichorus.d r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r4, "listener");
        k.n(IInteractService.class).getAudioTalkService().r0(r2, r3, r4);
    }

    @Override // ve2.a
    public final void i5(IBaseUser r2, h80.a<Boolean> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        k.n(IInteractService.class).permit(r2, r4);
    }
}
