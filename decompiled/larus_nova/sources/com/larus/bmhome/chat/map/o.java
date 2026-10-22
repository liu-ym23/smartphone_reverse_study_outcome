package com.larus.bmhome.chat.map;

import android.content.Context;
import android.content.res.Resources;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.ttnet.INetworkApi;
import com.google.gson.Gson;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.network.FlowHttpConnection;
import com.larus.nova.R;
import com.larus.platform.service.t1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f306904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f306905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PoiItem f306906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public wq9.f f306907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public wq9.f f306908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public wq9.g f306909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public wq9.g f306910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Resources f306911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final wq9.e f306912i;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.f306904a;
    }

    public final void a(final wq9.a r100) {
        PoiItem r101 = this.f306906c;
        if (r101 == null) goto L8;
        String r102 = r101.getIcon();
        if (r102 == null) goto L9;
        final String r103 = this.f306905b;
        ImageLoaderKt.l(r102, "poi_map_wrapper", new m(r103, this, r100), new n(this), 20);
        return;
    L9:
        return;
    }

    public final void b(List<wq9.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "latLngs");
        wq9.g r101 = this.f306909f;
        if (r101 == null) goto L5;
        r101.remove();
    L5:
        wq9.g r102 = this.f306910g;
        if (r102 == null) goto L8;
        r102.remove();
    L8:
        wq9.e r103 = this.f306912i;
        kk9.c r104 = null;
        if (r103 == null) goto L11;
        kk9.c r105 = r103.g(new wq9.c(r100, -1, (int) this.f306904a.getResources().getDimension(v19.c.b(R.attr.larus_bottom_layer_route_width, this.f306904a, R.dimen.larus_bottom_layer_route_width))));
    L12:
        this.f306909f = r105;
        wq9.e r106 = this.f306912i;
        if (r106 == null) goto L15;
        r104 = r106.g(new wq9.c(r100, this.f306904a.getResources().getColor(v19.c.b(R.attr.larus_primary_50, this.f306904a, R.color.larus_primary_50)), (int) this.f306904a.getResources().getDimension(v19.c.b(R.attr.larus_upper_layer_route_width, this.f306904a, R.dimen.larus_upper_layer_route_width))));
    L15:
        this.f306910g = r104;
        return;
    L11:
        r105 = null;
        goto L12
    }

    public final void d(List<wq9.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "latLngs");
        wq9.e r101 = this.f306912i;
        if (r101 == null) goto L6;
        r101.c(r100, (int) this.f306911h.getDimension(v19.c.b(R.attr.larus_map_common_margin, null, R.dimen.larus_map_common_margin)), (int) this.f306911h.getDimension(v19.c.b(R.attr.larus_map_common_margin, null, R.dimen.larus_map_common_margin)), (int) this.f306911h.getDimension(v19.c.b(R.attr.larus_map_common_margin, null, R.dimen.larus_map_common_margin)), (int) this.f306911h.getDimension(v19.c.b(R.attr.larus_map_margin_bottom, null, R.dimen.larus_map_margin_bottom)));
        return;
    }

    public o(Context r100, ConstraintLayout r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        this.f306904a = r100;
        this.f306911h = r100.getResources();
        wq9.e r102 = t1.f365807a.a(r100);
        this.f306912i = r102;
        if (r102 == null) goto L5;
        r102.a();
    L5:
        if (r102 == null) goto L7;
        r102.e();
    L7:
        if (r102 == null) goto L9;
        r102.f();
    L9:
        if (r102 == null) goto L11;
        r102.i();
    L11:
        if (r102 == null) goto L14;
        r102.b(r101);
        return;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.bmhome.chat.map.l, java.lang.Object] */
    public final void c(wq9.a r110, wq9.a r111) {
        Intrinsics.checkNotNullParameter(r110, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r111, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        final String r100 = this.f306905b;
        Gson r101 = e.f306883a;
        ?? r102 = new l(r100, this);
        Intrinsics.checkNotNullParameter(r110, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r111, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        Intrinsics.checkNotNullParameter(r102, "callback");
        FLogger.f375446a.d("MapNetworkClient", "queryPolyline");
        INetworkApi r103 = (INetworkApi) FlowHttpConnection.b("https://mapproxy.bytedance.com", null, null).create(INetworkApi.class);
        StringBuilder r104 = new StringBuilder();
        r104.append(r110.f560760b);
        r104.append(',');
        r104.append(r110.f560759a);
        StringBuilder r112 = new StringBuilder();
        r112.append(r111.f560760b);
        r112.append(',');
        r112.append(r111.f560759a);
        r103.doGet(true, -1, "/amap/v3/direction/driving", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("key", t1.f365807a.c()), TuplesKt.to(PlayerResolution.SDKKEY.ORIGIN, r104.toString()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_DESTINATION, r112.toString())}), CollectionsKt.mutableListOf(new Header[]{new Header("Content-Type", "application/json")}), null).enqueue(new d(r102));
    }
}
