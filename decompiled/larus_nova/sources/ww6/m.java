package ww6;

import android.app.Activity;
import com.bytedance.locallife.cube.api.config.CubeConfig;
import com.bytedance.locallife.cube.api.i.IPoiLynxKitDelegate;
import com.bytedance.locallife.cube.api.model.CubeInternalSchemaModel;
import com.bytedance.locallife.pdp.container.api.PreloadScene;
import com.ss.android.ugc.aweme.poi.bean.DetailEnterPage;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes21.dex */
public interface m {
    boolean a(String r100);

    void b(PreloadScene r100, i r101);

    void c();

    void d(String r100, Map<String, ? extends Object> r101);

    com.bytedance.locallife.pdp.container.view.lynx.k e();

    void f(Activity r100);

    IPoiLynxKitDelegate g(i r100, CubeInternalSchemaModel r101, Function1<? super CubeConfig, Unit> r102);

    void h(Activity r100, DetailEnterPage r101);

    IPoiLynxKitDelegate i(i r100, CubeInternalSchemaModel r101, Function1<? super CubeConfig, Unit> r102);

    List<String> j();
}
