package ve2;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements a {
    public i() {
    }

    @Override // ve2.a
    public final void cancelApply(h80.a<Boolean> r2) {
        k.n(IInteractService.class).getVideoTalkService().o(r2);
    }

    @Override // ve2.a
    public final void a(MusicPanel r4, com.bytedance.android.livesdk.ktvimpl.multichorus.d.a r5) {
        Intrinsics.checkNotNullParameter(r4, "music");
        Intrinsics.checkNotNullParameter(r5, "applyCallback");
        k.n(IInteractService.class).getVideoTalkService().N("推荐", 114, LinkApplyType.KTV_MULTI_CHORUS, r5);
    }

    @Override // ve2.a
    public final void b(Context r2, IRoom r3, com.bytedance.android.livesdk.ktvimpl.multichorus.d r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r4, "listener");
        k.n(IInteractService.class).getVideoTalkService().J(r2, r3, r4);
    }

    @Override // ve2.a
    public final void i5(IBaseUser r2, h80.a<Boolean> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        k.n(IInteractService.class).permit(r2, r4);
    }
}
