package com.larus.community.impl.repository;

import com.bytedance.ttnet.http.RequestContext;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.community.impl.api.CreationRecommendApi;
import com.larus.community.impl.api.j;
import com.larus.community.impl.api.m;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.platform.service.z2;
import com.larus.utils.o0;
import java.util.Map;
import juc.d;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import zp9.c;
import zp9.n;

/* JADX INFO: loaded from: classes27.dex */
public final class CommunityCreationRecommendRepository implements n {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f329752i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f329753j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f329754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TabItemInfo f329755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f329756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CreationFeedCacheEntity f329757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f329758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile String f329759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile String f329760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larus.community.impl.repository.a f329761h;

    public static final class a {
    }

    static {
        f329752i = true;
        f329753j = z2.f365865a.getCommunityRecommendRequestConfig().a();
    }

    @Override // zp9.n
    public final CreationFeedCacheEntity b() {
        return this.f329757d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v8 */
    @Override // zp9.n
    public final Object a(int r310, String r311, Long r312, String r313, Continuation<? super Pair<c, ? extends dm9.a<?>>> r314) {
        if ((r314 instanceof CommunityCreationRecommendRepository$fetchBatch$1) == false) goto L7;
        CommunityCreationRecommendRepository$fetchBatch$1 r100 = (CommunityCreationRecommendRepository$fetchBatch$1) r314;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r110 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
        Map<String, String> r104 = null;
    L73:
        com.larus.network.http.a r105 = (com.larus.network.http.a) r102;
        if ((r105 instanceof y) == false) goto L93;
        y r106 = (y) r105;
        Long r107 = r106.f360205g;
        if (r107 == null) goto L95;
        if (r107.longValue() != 0) goto L95;
        m29.a.c("CommunityCreationRecommendRepository", "success in fetch template list ");
        m r108 = (m) r106.f360135b;
        if (r108 == null) goto L83;
        boolean r109 = r108.f328824a;
    L84:
        if (r108 == null) goto L86;
        Map<String, String> r111 = r108.f328825b;
    L87:
        if (r108 == null) goto L89;
        ?? r112 = r108.f328826c;
    L94:
        return TuplesKt.to(new c(r109, r111, r112, null, null, 24), r104);
    L89:
        r112 = r104;
        goto L94
    L86:
        r111 = r104;
        goto L87
    L83:
        r109 = false;
    L95:
        return TuplesKt.to(r104, r104);
    L93:
        return TuplesKt.to(r104, r104);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        String r113 = this.f329759f;
        String r114 = this.f329760g;
        if (this.f329759f == null) goto L17;
    L18:
        if (r310 != 1) goto L20;
        this.f329759f = null;
        this.f329760g = null;
        m29.a.c("CommunityCreationRecommendRepository", " clear relatedRecommendationForFirstPage and relatedCreationId");
    L20:
        int r115 = this.f329754a;
        long r116 = f329753j;
        long r117 = r310;
        if (f329752i == false) goto L23;
        f329752i = false;
        boolean r210 = true;
    L24:
        TabItemInfo r118 = this.f329755b;
        if (r118 == null) goto L39;
        String r119 = r118.getId();
        if (r119 == null) goto L39;
        if (r119.length() <= 0) goto L31;
        boolean r120 = true;
    L32:
        if (r120 == true) goto L34;
    L36:
        boolean r121 = false;
    L37:
        if (r121 == false) goto L39;
        String r211 = r119;
    L40:
        String r122 = this.f329756c;
        if (r310 == 1) goto L43;
        r114 = this.f329758e;
    L47:
        String r315 = r114;
        if (r310 != 1) goto L50;
        String r316 = r113;
    L51:
        e29.c r123 = this.f329761h.f329765a;
        if (r123 == null) goto L61;
        String r124 = r123.a();
        if (r124 == null) goto L61;
        if (r124.length() <= 0) goto L58;
        boolean r125 = true;
    L59:
        if (r125 == false) goto L61;
        String r317 = r124;
    L62:
        j r126 = new j(r115, r117, r116, r210, r312, r211, r122, r315, r316, r317);
        CreationRecommendApi.a r127 = CreationRecommendApi.f328807a;
        Long r128 = Boxing.boxLong(((long) z2.f365865a.Y1()) * 1000);
        r100.label = 1;
        r127.getClass();
        FlowDowngradeServiceDelegate r129 = FlowDowngradeServiceDelegate.INSTANCE;
        d<j> r130 = j.Companion.serializer();
        d<m> r131 = m.Companion.serializer();
        if (r313 == null) goto L65;
        Map<String, String> r132 = MapsKt.mapOf(TuplesKt.to("source", r313));
    L66:
        if (r128 == null) goto L68;
        long r133 = r128.longValue();
        RequestContext r134 = new RequestContext();
        r134.timeout_connect = r133;
        r134.timeout_read = r133;
        r134.timeout_write = r133;
        RequestContext r135 = r134;
    L69:
        r104 = null;
        Object r136 = r129.requestPost(ServiceType.UGC, m.class, "/creativity/community/creation/recommend", r126, r130, r131, "application/json", MapsKt.emptyMap(), true, null, r135, null, r132, r100);
        if (r136 != r110) goto L72;
        return r110;
    L72:
        r102 = r136;
        goto L73
    L68:
        r135 = null;
        goto L69
    L65:
        r132 = null;
        goto L66
    L58:
        r125 = false;
    L61:
        r317 = null;
        goto L62
    L50:
        r316 = null;
        goto L51
    L43:
        if (o0.d(r114) == true) goto L47;
        r114 = this.f329758e;
        goto L47
    L34:
        if (Intrinsics.areEqual(r119, "0") == true) goto L36;
        r121 = true;
        goto L37
    L31:
        r120 = false;
    L39:
        r211 = null;
        goto L40
    L23:
        r210 = false;
        goto L24
    L17:
        if (this.f329760g == null) goto L20;
    L7:
        r100 = new CommunityCreationRecommendRepository$fetchBatch$1(this, r314);
        goto L8
    }

    public CommunityCreationRecommendRepository(int r100, TabItemInfo r101, String r102, CreationFeedCacheEntity r103, String r104, String r105, String r106, e29.c r110, int r111) {
        if ((r111 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r111 & 16) == 0) goto L9;
        r104 = null;
    L9:
        if ((r111 & 32) == 0) goto L12;
        r105 = null;
    L12:
        if ((r111 & 64) == 0) goto L15;
        r106 = null;
    L15:
        if ((r111 & 128) == 0) goto L17;
        r110 = null;
    L17:
        this.f329754a = r100;
        this.f329755b = r101;
        this.f329756c = r102;
        this.f329757d = r103;
        this.f329758e = r104;
        this.f329759f = r105;
        this.f329760g = r106;
        this.f329761h = new com.larus.community.impl.repository.a(r110);
    }
}
