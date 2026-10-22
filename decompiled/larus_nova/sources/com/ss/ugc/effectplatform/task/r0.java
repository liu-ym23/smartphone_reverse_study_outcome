package com.ss.ugc.effectplatform.task;

import bytekn.foundation.io.file.FileManager;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.bridge.network.NetRequest;
import com.ss.ugc.effectplatform.listener.IDownloadProviderEffectListListener;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import com.ss.ugc.effectplatform.model.GifProviderEffectModel;
import com.ss.ugc.effectplatform.model.ProviderEffect;
import com.ss.ugc.effectplatform.model.ProviderEffectModel;
import com.ss.ugc.effectplatform.model.net.GifProviderEffectListResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class r0 extends BaseNetworkTask<GifProviderEffectModel, GifProviderEffectListResponse> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final EffectConfig f457922n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f457923o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f457924p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f457925q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<String, String> f457926r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f457927s;

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final NetRequest f() {
        int r100 = com.ss.ugc.effectplatform.util.g.f458036a;
        HashMap r101 = com.ss.ugc.effectplatform.util.g.b(this.f457922n, 6);
        r101.put("gif_id", this.f457924p);
        String r102 = this.f457925q;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        r101.put("giphy_type", this.f457925q);
    L11:
        Map<String, String> r104 = this.f457926r;
        if (r104 == null) goto L14;
        r101.putAll(r104);
    L14:
        int r105 = com.ss.ugc.effectplatform.util.m.f458043a;
        StringBuilder r106 = new StringBuilder();
        r106.append(this.f457922n.E);
        this.f457922n.getClass();
        r106.append("/effect/api/stickers/list");
        return new NetRequest(com.ss.ugc.effectplatform.util.m.a(r101, r106.toString()), null, null, null, null, null, false, null, 254, null);
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r103 = false;
        goto L9
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final com.ss.ugc.effectplatform.model.e p(dlc.a r100, String r101) {
        return (GifProviderEffectListResponse) r100.f469201a.convertJsonToObj(r101, GifProviderEffectListResponse.class);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final void k(String r100, String r101, ExceptionResult r102) {
        r102.setTrackParams(null, null, null);
        super.k(r100, r101, r102);
    }

    @Override // com.ss.ugc.effectplatform.task.BaseNetworkTask
    public final void l(long r100, long r110, long r111, com.ss.ugc.effectplatform.model.e r112) {
        final GifProviderEffectListResponse r101 = (GifProviderEffectListResponse) r112;
        GifProviderEffectModel r113 = r101.getData();
        if (r113 == null) goto L7;
        ProviderEffectModel r114 = r113.getGifs();
        if (r114 == null) goto L7;
        List<ProviderEffect> r115 = r114.getSticker_list();
    L8:
        List<ProviderEffect> r102 = r115;
        boolean r103 = false;
        if (r102 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == true) goto L21;
        Iterator<ProviderEffect> r105 = r115.iterator();
    L18:
        if (r105.hasNext() == false) goto L21;
        ProviderEffect r106 = r105.next();
        r106.setPath(this.f457922n.f457163i + FileManager.f21782a + r106.getId() + EffectConstants.GIF_FILE_SUFFIX);
    L21:
        if (this.f457927s == false) goto L37;
        if (r102 != null) goto L24;
    L25:
        r103 = true;
    L26:
        if (r103 == true) goto L37;
        final IEffectPlatformBaseListener r107 = this.f457922n.N.a(this.f457923o);
        if ((r107 instanceof IDownloadProviderEffectListListener) == false) goto L31;
        e(new FetchProviderEffectByGiphyIdsTask$onSuccess$1(r107, r101));
    L31:
        q0 r108 = new q0(this, r101, r115);
        Iterator<ProviderEffect> r116 = r115.iterator();
    L33:
        if (r116.hasNext() == false) goto L45;
        ProviderEffect r117 = r116.next();
        String r118 = com.ss.ugc.effectplatform.util.q.a();
        this.f457922n.N.b(r118, r108);
        EffectConfig r119 = this.f457922n;
        q1 r120 = r119.D;
        if (r120 == null) goto L33;
        r120.a(new DownloadProviderEffectTask(r119, r117, r118));
        goto L33
    L45:
        return;
    L24:
        if (r102.isEmpty() == false) goto L26;
    L37:
        super.l(r100, r110, r111, r101);
        return;
    L11:
        if (r102.isEmpty() == true) goto L14;
        r104 = false;
    L7:
        r115 = null;
        goto L8
    }

    public r0(EffectConfig r100, String r101, String r110, String r111, Map<String, String> r112, boolean r113) {
        super(r100.f457175u.f1239a, r100.f457174t, r100.N, r101, r100.P);
        this.f457922n = r100;
        this.f457923o = r101;
        this.f457924p = r110;
        this.f457925q = r111;
        this.f457926r = r112;
        this.f457927s = r113;
    }
}
