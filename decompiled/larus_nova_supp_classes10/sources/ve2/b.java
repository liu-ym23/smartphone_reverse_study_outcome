package ve2;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements ve2.a {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // ve2.a
    public final void cancelApply(h80.a<Boolean> r1) {
        k.n(IPkAudienceLinkOutService.class).cancelApply();
    }

    @Override // ve2.a
    public final void a(MusicPanel r4, com.bytedance.android.livesdk.ktvimpl.multichorus.d.a r5) {
        Intrinsics.checkNotNullParameter(r4, "music");
        Intrinsics.checkNotNullParameter(r5, "applyCallback");
        k.n(IPkAudienceLinkOutService.class).apply(2, 114, "", LinkApplyType.KTV_MULTI_CHORUS.getValue());
    }

    @Override // ve2.a
    public final void b(Context r5, IRoom r6, com.bytedance.android.livesdk.ktvimpl.multichorus.d r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "room");
        Intrinsics.checkNotNullParameter(r7, "listener");
        OperateType r8 = OperateType.PRE_APPLY;
        ArrayList r0 = new ArrayList();
        r0.add(qh0.g.a(r8, 2));
        r0.add(new qh0.f.g(r5, r8, 2));
        r0.add(new qh0.f.c(r5, r8, 2));
        r0.add(new qh0.f.a(r5));
        r0.add(new qh0.f.d(r5, r8, 2, true));
        r0.add(new qh0.f.f(r5, r8, 2, true));
        r0.add(new qh0.f.e(r5, r8));
        qh0.f.a(r0).a(new c(r7));
    }

    @Override // ve2.a
    public final void i5(IBaseUser r2, h80.a<Boolean> r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        IPkAudienceLinkOutService r5 = k.n(IPkAudienceLinkOutService.class);
        LinkPlayerInfo r6 = new LinkPlayerInfo();
        r6.mUser = r2;
        Unit r7 = Unit.INSTANCE;
        r5.permit(r6);
    }
}
