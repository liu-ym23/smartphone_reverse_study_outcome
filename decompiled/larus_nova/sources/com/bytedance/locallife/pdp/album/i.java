package com.bytedance.locallife.pdp.album;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.locallife.model.album.PoiAlbumParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements com.bytedance.locallife.biz.widget.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomAlbumActivity f260973a;

    @Override // com.bytedance.locallife.biz.widget.a
    public final Map<String, Object> a() {
        LinkedHashMap r100 = new LinkedHashMap();
        CustomAlbumActivity r101 = this.f260973a;
        PoiAlbumParams r102 = r101.f260934e;
        String r103 = "";
        if (r102 == null) goto L6;
        String r104 = r102.getPoiId();
        if (r104 == null) goto L6;
    L7:
        r100.put("poi_id", r104);
        PoiAlbumParams r105 = r101.f260934e;
        if (r105 == null) goto L11;
        String r106 = r105.getPoiName();
        if (r106 == null) goto L11;
    L12:
        r100.put("poi_name", r106);
        PoiAlbumParams r107 = r101.f260934e;
        if (r107 == null) goto L16;
        String r108 = r107.getProductId();
        if (r108 == null) goto L16;
    L17:
        r100.put("product_id", r108);
        PoiAlbumParams r109 = r101.f260934e;
        if (r109 == null) goto L23;
        String r110 = r109.getTraceSessionId();
        if (r110 == null) goto L23;
        r103 = r110;
    L23:
        r100.put(LiveLocalLifeRoomInfo.TRACE_SESSION_ID, r103);
        PoiAlbumParams r111 = r101.f260934e;
        if (r111 == null) goto L27;
        String r112 = r111.getExtraParams();
        if (r112 == null) goto L27;
    L28:
        r100.put("extra_params", r112);
        return r100;
    L27:
        r112 = SliceInitService.DEFAULT_SWITCH;
    L16:
        r108 = "";
    L11:
        r106 = "";
    L6:
        r104 = "";
        goto L7
    }

    @Override // com.bytedance.locallife.biz.widget.a
    public final Map<String, Object> getGlobalProps() {
        return MapsKt.emptyMap();
    }

    public i(CustomAlbumActivity r100) {
        this.f260973a = r100;
    }
}
