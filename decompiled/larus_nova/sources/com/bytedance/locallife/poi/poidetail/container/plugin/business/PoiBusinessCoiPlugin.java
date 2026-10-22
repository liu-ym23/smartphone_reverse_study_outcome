package com.bytedance.locallife.poi.poidetail.container.plugin.business;

import com.bytedance.ies.xbridge.ReadableMapImpl;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.locallife.dito.data.DitoPage;
import com.bytedance.locallife.dito.data.l;
import com.bytedance.locallife.dito.utils.j;
import com.bytedance.locallife.poi.poidetail.container.plugin.PoiDetailBizContainerPlugin;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/container/plugin/business/PoiBusinessCoiPlugin;", "Lcom/bytedance/locallife/poi/poidetail/container/plugin/PoiDetailBizContainerPlugin;", "<init>", "()V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiBusinessCoiPlugin extends PoiDetailBizContainerPlugin {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f263916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f263917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f263918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f263919g;

    public PoiBusinessCoiPlugin() {
        this.f263916d = new AtomicBoolean(false);
        this.f263917e = -1;
        this.f263918f = -1;
        this.f263919g = -1;
    }

    @Override // com.bytedance.locallife.poi.poidetail.container.plugin.PoiDetailBizContainerPlugin
    public final void A(l r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r100, "data");
        DitoPage r101 = r100.f258215b;
        List<String> r102 = null;
        if (r101 == null) goto L7;
        Map<String, List<String>> r103 = r101.getLayout();
        if (r103 == null) goto L7;
        List<String> r104 = r103.get("poi_detail_coi_double_loop");
    L8:
        DitoPage r105 = r100.f258215b;
        if (r105 == null) goto L13;
        Map<String, List<String>> r106 = r105.getLayout();
        if (r106 == null) goto L13;
        r102 = r106.get("poi_detail_coi_single_loop");
    L13:
        List<String> r107 = r104;
        boolean r108 = true;
        if (r107 != null) goto L16;
    L19:
        boolean r109 = true;
    L20:
        if (r109 == false) goto L28;
        List<String> r110 = r102;
        if (r110 != null) goto L24;
    L27:
        if (r108 == false) goto L28;
        return;
    L24:
        if (r110.isEmpty() == true) goto L27;
        r108 = false;
    L28:
        j.o(g(), new PoiBusinessCoiPlugin$onRequestDataUpdate$1(this));
        return;
    L16:
        if (r107.isEmpty() == true) goto L19;
        r109 = false;
    L7:
        r104 = null;
        goto L8
    }

    public static final void B(PoiBusinessCoiPlugin r100, int r101) {
        if (r100.f263919g == r101) goto L15;
        Object r102 = r100.g().A.get("poi_bundle");
        String r103 = null;
        if ((r102 instanceof PoiBundle) == false) goto L7;
        PoiBundle r104 = (PoiBundle) r102;
    L8:
        long r105 = System.currentTimeMillis();
        JSONObject r106 = new JSONObject();
        if (r104 == null) goto L11;
        r103 = r104.sessionId;
    L11:
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        r106.put("session_id", r103);
        r106.put("status", r101);
        Unit r107 = Unit.INSTANCE;
        EventCenter.enqueueEvent(new Event("poi_coi_cover_status_event", r105, new ReadableMapImpl(r106)));
        r100.f263919g = r101;
        return;
    L7:
        r104 = null;
        goto L8
    }

    public static final void C(PoiBusinessCoiPlugin r100, int r101) {
        if (r100.f263918f == r101) goto L15;
        Object r102 = r100.g().A.get("poi_bundle");
        String r103 = null;
        if ((r102 instanceof PoiBundle) == false) goto L7;
        PoiBundle r104 = (PoiBundle) r102;
    L8:
        long r105 = System.currentTimeMillis();
        JSONObject r106 = new JSONObject();
        if (r104 == null) goto L11;
        r103 = r104.sessionId;
    L11:
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        r106.put("session_id", r103);
        r106.put("status", r101);
        Unit r107 = Unit.INSTANCE;
        EventCenter.enqueueEvent(new Event("poi_coi_status_event", r105, new ReadableMapImpl(r106)));
        r100.f263918f = r101;
        return;
    L7:
        r104 = null;
        goto L8
    }
}
