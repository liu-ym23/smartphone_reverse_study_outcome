package com.bytedance.locallife.host.share;

import android.app.Activity;
import android.view.View;
import com.bytedance.locallife.dito.event.DitoEventBus;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public interface q extends ns6.a {

    public static final class a {
        public static /* synthetic */ void a(q r100, Activity r101, w r110, Map r111, String r112, String r113, View r114) {
            r100.k(r101, r110, r111, r112, r113, null, null);
        }
    }

    Map<String, String> A(String r100);

    void Y();

    void a0();

    void b0();

    void c(Activity r100, String r101, PoiBundle r102);

    List<DitoEventBus> c0();

    void i();

    void j0(Activity r100, String r101, PoiBundle r102);

    void k(Activity r100, w r101, Map r102, String r103, String r104, JSONObject r105, Map r106);

    Map<String, String> w(String r100, Map<String, String> r101);
}
