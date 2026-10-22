package mi2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.ECLiveCommerceModel_ProvideAbServiceFactory;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModelProviderFactory;
import com.bytedance.android.livesdk.livecommerce.room.utils.ECLiveEventHelper;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import el2.g;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements gl2.a {
    public final QUIManager a;
    public g b;
    public final ml.b c;
    public final ml.a d;
    public final JSONObject e;
    public final int f;
    public final String g;
    public final xk.a h;
    public final String i;
    public final long j;

    @Override // gl2.a
    public final View getView() {
        this.a.c(pi2.a.class, null);
        return this.a.p();
    }

    @Override // gl2.a
    public final void release() {
        this.a.r(pi2.a.class);
        g r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((Boolean) r0.getLiveSettingValue("ec_live_release_event_helper_jump_dispatcher", Boolean.TRUE)).booleanValue() != true) goto L9;
        com.bytedance.android.ec.common.api.jump.model.g r1 = ECLiveEventHelper.a;
        ECLiveEventHelper.b = null;
        return;
    }

    @Override // gl2.a
    public final void init(Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        ECScrollProductCardViewModelProviderFactory r0 = new ECScrollProductCardViewModelProviderFactory(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        QUIManager r1 = this.a;
        this.h.getEnterFrom();
        r1.l(new pi2.a("live_fragment_replay", r0), r12, false);
    }

    public d(com.bytedance.android.livesdk.livecommerce.playback.multicards.a r4, com.bytedance.android.livesdk.livecommerce.playback.multicards.b r5, JSONObject r6, com.bytedance.android.livesdk.livecommerce.playback.multicards.c r7) {
        Intrinsics.checkNotNullParameter(r4, "roomInfo");
        Intrinsics.checkNotNullParameter(r5, "btmInfo");
        Intrinsics.checkNotNullParameter(r6, "entranceInfo");
        Intrinsics.checkNotNullParameter("1079", "ecomSceneId");
        Intrinsics.checkNotNullParameter(r7, "params");
        Intrinsics.checkNotNullParameter("", "replayId");
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = 4;
        this.g = "1079";
        this.h = r7;
        this.i = "";
        this.j = 0;
        this.a = new QUIManager();
        this.b = ECLiveCommerceModel_ProvideAbServiceFactory.proxyProvideAbService(hh2.a.a().f);
    }
}
