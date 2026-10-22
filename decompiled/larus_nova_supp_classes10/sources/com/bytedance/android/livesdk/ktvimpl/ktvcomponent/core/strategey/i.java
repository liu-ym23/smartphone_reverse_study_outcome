package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.ArrayList;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a {

    public static final class a {
    }

    public static final class b implements qh0.d<rh0.a> {
        public final /* synthetic */ rj0.b a;

        public b(rj0.b r1) {
            this.a = r1;
        }

        public final void b(BaseCheckException r2) {
            Intrinsics.checkNotNullParameter(r2, "exception");
            this.a.onFailed(r2);
        }

        public final void onResult(Object r1) {
            rh0.a r2 = (rh0.a) r1;
            this.a.onSuccess();
        }
    }

    static {
    }

    public i() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final int ktvAddSongLimitNum() {
        return com.bytedance.android.livesdk.ktvimpl.base.util.e.a.a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void cancelApply(h80.a<Boolean> r1) {
        k.n(IPkAudienceLinkOutService.class).cancelApply();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a
    public final void Fh(IBaseUser r2, h80.a<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "user");
        Intrinsics.checkNotNullParameter(r3, "consumer");
        IPkAudienceLinkOutService r4 = k.n(IPkAudienceLinkOutService.class);
        LinkPlayerInfo r0 = new LinkPlayerInfo();
        r0.mUser = r2;
        Unit r5 = Unit.INSTANCE;
        r4.permit(r0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void checkAudienceSingEnablePermission(Long r1, rj0.b r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a.C0016a.a((BaseOrderSongViewModel.e) r2);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void checkPermision(Context r5, IRoom r6, rj0.b r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "room");
        Intrinsics.checkNotNullParameter(r7, "listener");
        OperateType r8 = OperateType.APPLY;
        b r0 = new b(r7);
        ArrayList r9 = new ArrayList();
        r9.add(qh0.g.a(r8, 2));
        r9.add(new qh0.f.g(r5, r8, 2));
        r9.add(new qh0.f.c(r5, r8, 2));
        r9.add(new qh0.f.a(r5));
        r9.add(new qh0.f.d(r5, r8, 2, true));
        r9.add(new qh0.f.f(r5, r8, 2, true));
        r9.add(new qh0.f.e(r5, r8));
        qh0.f.a(r9).a(r0);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.util.e
    public final void ktvApply(KtvMusic r2, String r3, LinkApplyType r4, tf0.b r5) {
        Intrinsics.checkNotNullParameter(r4, "applyType");
        IPkAudienceLinkOutService r6 = k.n(IPkAudienceLinkOutService.class);
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r6.apply(2, 114, r3, LinkApplyType.SONG.getValue());
    }
}
