package com.larus.search.impl.global;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.paging.PagingSource;
import com.larus.paging.w0;
import com.larus.platform.model.SearchMobParam;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.i3;

/* JADX INFO: loaded from: classes31.dex */
public final class GlobalSearchPagingSource extends PagingSource<Integer, ws9.c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f367699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f367700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakReference<by7.e> f367701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Integer f367702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<String> f367703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f367704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f367705h;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.paging.PagingSource
    public final Integer b(w0<Integer, ws9.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        return r100.f363933b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.paging.PagingSource
    public final Object c(PagingSource.a<Integer> r210, Continuation<? super PagingSource.b<Integer, ws9.c>> r211) {
        if ((r211 instanceof GlobalSearchPagingSource$load$1) == false) goto L7;
        GlobalSearchPagingSource$load$1 r100 = (GlobalSearchPagingSource$load$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        GlobalSearchPagingSource$load$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        boolean r111 = true;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r105 = r110.I$0;
        String r106 = (String) r110.L$0;
        ResultKt.throwOnFailure(r102);
    L22:
        com.larus.network.http.a r107 = (com.larus.network.http.a) r102;
        ws9.a r108 = (ws9.a) r107.f360135b;
        Object r109 = this.f367701d;
        if ((r109 instanceof com.larus.trace.tracknode.a) == false) goto L25;
        com.larus.trace.tracknode.a r112 = (com.larus.trace.tracknode.a) r109;
    L26:
        if (r112 == null) goto L28;
        String r113 = r112.k();
    L29:
        if (r108 == null) goto L33;
        Map<String, String> r114 = r108.e();
        if (r114 == null) goto L33;
        String r115 = r114.get("request_id");
    L34:
        this.f367705h = r115;
        if (r105 != 0) goto L37;
        this.f367704g = r115;
    L37:
        if (r108 == null) goto L55;
        List<ws9.b> r116 = r108.a();
        if (r116 == null) goto L55;
        Iterator<T> r117 = r116.iterator();
        int r118 = 0;
    L42:
        if (r117.hasNext() == false) goto L55;
        Object r119 = r117.next();
        int r120 = r118 + 1;
        if (r118 >= 0) goto L46;
        CollectionsKt.throwIndexOverflow();
    L46:
        ws9.b r121 = (ws9.b) r119;
        RecommendBot r122 = r121.a();
        if (r122 == null) goto L53;
        String r123 = this.f367704g;
        String r124 = this.f367705h;
        RecommendBot r125 = r121.a();
        if (r125 == null) goto L51;
        String r126 = r125.o();
    L52:
        r122.f297432b = new SearchMobParam(r123, r124, r126, String.valueOf(r118 + r105), r113, 3);
        goto L53
    L51:
        r126 = null;
    L53:
        r118 = r120;
    L55:
        if ((r107 instanceof y) == false) goto L68;
        y r127 = (y) r107;
        Long r128 = r127.f360205g;
        if (r128 != null) goto L60;
    L62:
        Long r129 = r127.f360205g;
        if (r129 == null) goto L65;
        String r130 = r129.toString();
    L66:
        d(r106, r130, (ws9.a) r127.f360135b, false);
    L70:
        ws9.a r131 = (ws9.a) r107.f360135b;
        if (r131 == null) goto L73;
        String r132 = this.f367699b;
        List<ws9.b> r133 = r131.a();
        ArrayList r134 = new ArrayList();
        if (r133 == null) goto L102;
        Iterator<T> r135 = r133.iterator();
        int r136 = 0;
    L87:
        if (r135.hasNext() == false) goto L103;
        ws9.b r137 = (ws9.b) r135.next();
        Set<String> r138 = this.f367703f;
        RecommendBot r139 = r137.a();
        if (r139 == null) goto L92;
        String r140 = r139.o();
        if (r140 == null) goto L92;
    L94:
        if (r138.contains(r140) == true) goto L95;
        RecommendBot r141 = r137.a();
        if (r141 == null) goto L101;
        String r142 = r141.o();
        if (r142 == null) goto L101;
        this.f367703f.add(r142);
    L101:
        r134.add(r137);
        goto L87
    L95:
        r136 = r136 + 1;
    L92:
        r140 = "";
    L103:
        if (r133 == null) goto L105;
        int r143 = r133.size();
    L106:
        if (r136 != r143) goto L109;
        r111 = false;
    L109:
        Boolean r144 = Boolean.valueOf(r111);
        ArrayList r145 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r134, 10));
        Iterator r146 = r134.iterator();
    L111:
        if (r146.hasNext() == false) goto L113;
        r145.add(new ws9.c(r132, (ws9.b) r146.next()));
        goto L111
    L113:
        Pair r147 = TuplesKt.to(r144, r145);
        boolean r148 = ((Boolean) r147.getFirst()).booleanValue();
        List r149 = (List) r147.getSecond();
        List<ws9.b> r150 = r131.a();
        if (r150 != null) goto L116;
        r150 = CollectionsKt.emptyList();
    L116:
        int r151 = r150.size() + r105;
        Integer r152 = r131.d();
        if (r152 == null) goto L119;
        int r153 = r152.intValue();
    L120:
        if (r151 < r153) goto L122;
        Integer r154 = null;
    L127:
        if (Intrinsics.areEqual(this.f367702e, r154) == true) goto L131;
        if (r148 == false) goto L131;
        this.f367702e = r154;
        return new PagingSource.b.c(r149, r154);
    L131:
        this.f367702e = null;
        return new PagingSource.b.c(r149, null);
    L122:
        List<ws9.b> r155 = r131.a();
        if (r155 != null) goto L125;
        r155 = CollectionsKt.emptyList();
    L125:
        r154 = Boxing.boxInt(r105 + r155.size());
        goto L127
    L119:
        r153 = 0;
        goto L120
    L105:
        r143 = 0;
        goto L106
    L102:
        r136 = 0;
        goto L103
    L73:
        if ((r107 instanceof com.larus.network.http.f) == false) goto L75;
        com.larus.network.http.f r156 = (com.larus.network.http.f) r107;
    L76:
        if (r156 == null) goto L80;
        Throwable r157 = r156.f360157d;
        if (r157 == null) goto L80;
    L82:
        return new PagingSource.b.a(r157);
    L80:
        r157 = new Error(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        goto L82
    L75:
        r156 = null;
        goto L76
    L65:
        r130 = null;
        goto L66
    L60:
        if (r128.longValue() != 0) goto L62;
        d(r106, null, (ws9.a) r127.f360135b, true);
        goto L70
    L68:
        if ((r107 instanceof com.larus.network.http.f) == false) goto L70;
        com.larus.network.http.f r158 = (com.larus.network.http.f) r107;
        d(r106, String.valueOf(r158.f360157d.getCode()), (ws9.a) r158.f360135b, false);
    L33:
        r115 = null;
        goto L34
    L28:
        r113 = null;
        goto L29
    L25:
        r112 = null;
        goto L26
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        Integer r159 = r210.a();
        if (r159 == null) goto L17;
        int r160 = r159.intValue();
    L18:
        String r161 = this.f367699b;
        JSONObject r162 = new JSONObject();
        r162.put("keyword", r161);
        r162.put("offset", r160);
        r162.put("index_type", 2);
        r162.put("size", r210.f363722a);
        Unit r163 = Unit.INSTANCE;
        r110.L$0 = r161;
        r110.I$0 = r160;
        r110.label = 1;
        Object r164 = HttpExtKt.k(ServiceType.BASIC_SERVICE, ws9.a.class, "/alice/comprehensive/search", r162, null, null, false, null, null, null, r110, 1008);
        if (r164 != r103) goto L21;
        return r103;
    L21:
        r105 = r160;
        r102 = r164;
        r106 = r161;
        goto L22
    L17:
        r160 = 0;
    L7:
        r100 = new GlobalSearchPagingSource$load$1(this, r211);
        goto L8
    }

    public GlobalSearchPagingSource(String r100, String r101, WeakReference<by7.e> r102) {
        Intrinsics.checkNotNullParameter(r100, "query");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "trackNode");
        this.f367699b = r100;
        this.f367700c = r101;
        this.f367701d = r102;
        this.f367702e = -1;
        this.f367703f = new LinkedHashSet();
    }

    public final void d(String r110, String r111, ws9.a r112, boolean r113) {
        String r100 = this.f367700c;
        if (r112 == null) goto L7;
        Integer r101 = r112.d();
        if (r101 == null) goto L7;
        Long r102 = Long.valueOf(r101.intValue());
    L8:
        Long r103 = r102;
        String r104 = iz8.c.d(r110);
        String r105 = this.f367705h;
        String r106 = this.f367704g;
        if (r113 == false) goto L11;
        String r107 = "1";
    L12:
        i3.c("bot_list_discover_search", r100, r111, r103, r110, r104, r106, r105, null, null, r107, this.f367701d.get(), 5696);
        return;
    L11:
        r107 = "0";
    L7:
        r102 = null;
        goto L8
    }
}
