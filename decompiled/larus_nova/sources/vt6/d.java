package vt6;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.locallife.biz.common.ui.LocalLifeLoadingLayout;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.locallife.dito.data.o;
import com.bytedance.locallife.live.lynx.LiveLocalLifeLynxView;
import com.ss.android.ugc.aweme.poi.ui.PoiLoadingMode;
import com.ss.android.ugc.aweme.poi.ui.PoiLoadingShowStyle;
import com.ss.android.ugc.aweme.poi.ui.PoiSkinMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes21.dex */
public interface d {
    PoiLoadingShowStyle a();

    String appendCacheUniqueKey(CubeInternalSchemaModel r100, Uri r101);

    void b(String r100);

    void c();

    void d(HashMap r100, Activity r101, LiveLocalLifeLynxView r102);

    void e(mq6.c r100);

    void f(Number r100, String r101, String r102);

    void g(View r100);

    void h(HashMap<String, Object> r100, Activity r101);

    Map<String, o> i();

    Uri interceptSchema(Uri r100);

    void j();

    boolean k(String r100, String r101, Number r102);

    void l(String r100);

    String m();

    LocalLifeLoadingLayout n(Context r100, PoiLoadingMode r101, PoiSkinMode r102);

    List o();

    void p();

    void q(String r100, Function2 r101);

    void r();

    void s(String r100);

    void t(View r100);

    void u();
}
