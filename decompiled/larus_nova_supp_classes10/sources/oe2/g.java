package oe2;

import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements sb0.c {
    public List<LinkPlayerInfo> a;
    public final IRoom b;

    public final List<LinkPlayerInfo> getOnlineUserList() {
        Lazy r0 = KtvSettingHelper.a;
        List r1 = null;
        if (KtvUtilsKt.g() == true) goto L5;
        IInteractService r2 = jc1.k.f(IInteractService.class);
        if (r2 == null) goto L17;
        com.bytedance.android.live.liveinteract.plantform.base.i r3 = r2.getLinkUserInfoCenter();
        if (r3 == null) goto L17;
        r1 = r3.getOnlineUserList();
    L17:
        List<LinkPlayerInfo> r4 = KotlinTypeUtilsKt.castMutableElementType(r1);
    L18:
        this.a = r4;
        return r4;
    L5:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L11;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r5 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r5 == null) goto L11;
        List<ILinkPlayerInfoBridge> r6 = r5.getOnlineUserList();
        if (r6 == null) goto L11;
        r1 = CollectionsKt.toMutableList(r6);
    L11:
        r4 = KotlinTypeUtilsKt.castMutableElementType(r1);
        goto L18
    }

    public final boolean isAudienceLinkEngineOn() {
        Lazy r0 = KtvSettingHelper.a;
        if (KtvUtilsKt.g() == true) goto L5;
        IInteractService r1 = jc1.k.f(IInteractService.class);
        if (r1 != null) goto L16;
    L14:
        return false;
    L16:
        return r1.isAudienceLinkEngineOn();
    L5:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L14;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r2 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r2 == null) goto L14;
        if (r2.isEngineOn() != true) goto L14;
        return true;
    }

    public g(IRoom r1) {
        this.b = r1;
    }
}
