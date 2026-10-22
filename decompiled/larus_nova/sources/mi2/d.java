package mi2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.ECLiveCommerceModel_ProvideAbServiceFactory;
import com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel.ECScrollProductCardViewModelProviderFactory;
import com.bytedance.android.livesdk.livecommerce.room.utils.ECLiveEventHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import el2.g;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements gl2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QUIManager f514052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f514053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ml.b f514054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ml.a f514055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f514056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f514057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f514058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final xk.a f514059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f514060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f514061j;

    @Override // gl2.a
    public final View getView() {
        this.f514052a.c(pi2.a.class, null);
        return this.f514052a.p();
    }

    @Override // gl2.a
    public final void release() {
        this.f514052a.r(pi2.a.class);
        g r100 = this.f514053b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (((Boolean) r100.getLiveSettingValue("ec_live_release_event_helper_jump_dispatcher", Boolean.TRUE)).booleanValue() != true) goto L9;
        com.bytedance.android.ec.common.api.jump.model.g r101 = ECLiveEventHelper.f151901a;
        ECLiveEventHelper.f151902b = null;
        return;
    }

    @Override // gl2.a
    public final void init(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        ECScrollProductCardViewModelProviderFactory r100 = new ECScrollProductCardViewModelProviderFactory(this.f514054c, this.f514055d, this.f514056e, this.f514057f, this.f514058g, this.f514059h, this.f514060i, this.f514061j);
        QUIManager r101 = this.f514052a;
        this.f514059h.getEnterFrom();
        r101.l(new pi2.a("live_fragment_replay", r100), r110, false);
    }

    public d(com.bytedance.android.livesdk.livecommerce.playback.multicards.a r100, com.bytedance.android.livesdk.livecommerce.playback.multicards.b r101, JSONObject r102, com.bytedance.android.livesdk.livecommerce.playback.multicards.c r103) {
        Intrinsics.checkNotNullParameter(r100, "roomInfo");
        Intrinsics.checkNotNullParameter(r101, "btmInfo");
        Intrinsics.checkNotNullParameter(r102, "entranceInfo");
        Intrinsics.checkNotNullParameter("1079", "ecomSceneId");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter("", "replayId");
        this.f514054c = r100;
        this.f514055d = r101;
        this.f514056e = r102;
        this.f514057f = 4;
        this.f514058g = "1079";
        this.f514059h = r103;
        this.f514060i = "";
        this.f514061j = 0;
        this.f514052a = new QUIManager();
        this.f514053b = ECLiveCommerceModel_ProvideAbServiceFactory.proxyProvideAbService(hh2.a.a().f485153f);
    }
}
