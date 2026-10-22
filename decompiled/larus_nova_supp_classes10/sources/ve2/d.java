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
public final class d implements ve2.a {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // ve2.a
    public final void cancelApply(h80.a<Boolean> r3) {
        if (k.n(IInteractService.class).getInteractAudienceService() == null) goto L8;
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r4 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r4 == null) goto L9;
        r4.Q6(null, false, false);
        return;
    L9:
        return;
    }

    @Override // ve2.a
    public final void a(MusicPanel r4, com.bytedance.android.livesdk.ktvimpl.multichorus.d.a r5) {
        Intrinsics.checkNotNullParameter(r4, "music");
        Intrinsics.checkNotNullParameter(r5, "applyCallback");
        if (k.n(IInteractService.class).getInteractAudienceService() == null) goto L8;
        LinkApplyType r6 = LinkApplyType.KTV_MULTI_CHORUS;
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r7 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r7 == null) goto L9;
        r7.c2(2, 114, "ktv_apply", r6);
        return;
    L9:
        return;
    }

    @Override // ve2.a
    public final void b(Context r2, IRoom r3, com.bytedance.android.livesdk.ktvimpl.multichorus.d r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "room");
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (k.n(IInteractService.class).getInteractAudienceService() == null) goto L8;
        com.bytedance.android.live.liveinteract.plantform.base.e.l0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.e r0 = com.bytedance.android.live.liveinteract.plantform.base.e.a.a();
        if (r0 == null) goto L9;
        r0.r0(r2, r3, r4);
        return;
    L9:
        return;
    }

    @Override // ve2.a
    public final void i5(IBaseUser r2, h80.a<Boolean> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        k.n(IInteractService.class).permit(r2, r4);
    }
}
