package kf0;

import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.liveinteract.interact.audience.contract.InteractAudienceInviteContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.api.LinkAnchorApi;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends hf0.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f503143d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IRoom f503144c;

    static {
    }

    public f(InteractAudienceInviteContract$View r100, IRoom r101) {
        super(r100);
        this.f503144c = r101;
    }

    @Override // hf0.b
    public final void d(int r110, String r111) {
        if (this.f503144c != null) goto L5;
        return;
    L5:
        if (vm2.d.k() == false) goto L7;
        long r100 = System.currentTimeMillis();
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getInviteList(this.f503144c.getId(), 1).as(c())).subscribe(new c(this, r100), new d(this, r100));
        return;
    L7:
        ((SingleSubscribeProxy) ((LinkAnchorApi) com.bytedance.android.live.network.c.b().e(LinkAnchorApi.class)).getPageList(this.f503144c.getId(), d5.c(this.f503144c.getOwnerUserIdString()), this.f503144c.getOwnerUserIdString(), 1, r110, 0, false, "", 0, "", r111).as(c())).subscribe(new b(this), new e(this));
    }
}
