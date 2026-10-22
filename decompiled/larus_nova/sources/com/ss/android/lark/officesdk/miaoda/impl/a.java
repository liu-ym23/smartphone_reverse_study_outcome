package com.ss.android.lark.officesdk.miaoda.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SendHttpRequest;
import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.t;
import com.heytap.mcssdk.constant.b;
import com.larus.office.base.service.OfficeSdkServiceV2;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passport.dpop.DPOPServiceSdk;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@OfficeSDKUserScope
public final class a implements dub.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f433474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, Long> f433475b;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.miaoda.impl.a$a, reason: collision with other inner class name */
    public static final class C5155a {
    }

    static {
    }

    @Inject
    public a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f433474a = r100;
        this.f433475b = new ConcurrentHashMap();
    }

    @Override // dub.a
    public final void kc(final String r110, final OfficeSdkServiceV2.e r111) {
        Intrinsics.checkNotNullParameter(r110, b.f276371u);
        final long r100 = System.currentTimeMillis();
        CollectionsKt.removeAll(this.f433475b.entrySet(), new MiaodaPrewarmCapacityImpl$prewarm$1(r100));
        Long r101 = this.f433475b.get(r110);
        if (r101 != null) goto L5;
    L8:
        this.f433475b.put(r110, Long.valueOf(r100));
        boolean r102 = true;
        String r103 = jcb.b.c().a("miaoda");     // Catch: Exception -> L39
        if (r103 == null) goto L15;
        if (r103.length() == 0) goto L15;
        boolean r104 = false;
    L16:
        if (r104 == true) goto L17;
    L18:
        String r105 = "https://" + r103 + "/af/api/v1/studio/app/" + URLEncoder.encode(r110, "UTF-8") + "/instance/get_or_bind?branch=sprint%2Fdefault";
        Map<String, String> r106 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("Content-Type", "application/json"), TuplesKt.to("Accept", "application/json")});
        IOfficeSDKTokenProvider r107 = OfficeSDKManager.getTokenProvider();
        if (r107 != null) goto L22;
        this.f433475b.remove(r110);
        r111.onFailure(new IllegalStateException("Missing token provider"));
        return;
    L22:
        String r108 = r107.getAccessToken();
        if (r108.length() != 0) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == false) goto L29;
        this.f433475b.remove(r110);
        r111.onFailure(new IllegalStateException("Missing access token"));
        return;
    L29:
        String r109 = r107.getAuthSchema() + ' ' + r108;
        r106.put("Authorization", r109);
        if (StringsKt.startsWith$default(r109, "DPoP ", false, 2, null) == false) goto L37;
        String r113 = new String(DPOPServiceSdk.getDPOPToken(r105, "GET"), Charsets.UTF_8);
        if (r113.length() > 0) goto L35;
        r102 = false;
    L35:
        if (r102 == false) goto L37;
        r106.put("DPoP", r113);
    L37:
        SendHttpRequest.Builder r114 = new SendHttpRequest.Builder().url(r105).method(SendHttpRequest.Method.GET).headers(r106);
        l r115 = this.f433474a;
        Command r116 = Command.SEND_HTTP;
        Intrinsics.checkNotNull(r114);
        t.a(r115.h(new d(r114, SendHttpResponse.ADAPTER, r116, null, null, null, null, 248)).a(), new MiaodaPrewarmCapacityImpl$prewarm$2(r110, r111, this), new MiaodaPrewarmCapacityImpl$prewarm$3(r110, this, r111), new MiaodaPrewarmCapacityImpl$prewarm$4(r110, this, r111));
        return;
    L25:
        r112 = false;
    L15:
        r104 = true;
    L17:
        r103 = "miaoda.feishu.cn";
        goto L18
    L5:
        if ((r100 - r101.longValue()) >= 1200000) goto L8;
        r111.onSuccess();
    }
}
