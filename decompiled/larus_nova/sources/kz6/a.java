package kz6;

import com.bytedance.android.life.service.map.LifeCollectMap;
import com.bytedance.locallife.cube.impl.CubeFontService;
import com.bytedance.locallife.dito.common.action.TopModelActionHandler;
import com.bytedance.locallife.dito.common.view.DitoToolbarDataAgent;
import com.bytedance.locallife.dito.data.s;
import com.bytedance.locallife.dito.event.action.IDitoActionHandlerSpi;
import com.bytedance.locallife.dito.performance.g;
import com.bytedance.locallife.dito.performance.k;
import com.bytedance.locallife.host.ILifeBulletService;
import com.bytedance.locallife.host.ILifeGeckoInitService;
import com.bytedance.locallife.pdp.d;
import com.bytedance.locallife.poi.dito.container.ui.DitoContainerLynxAgent;
import com.bytedance.locallife.poi.dito.container.ui.DitoSketchViewAgent;
import gp6.e;
import hl6.b;
import java.util.Arrays;
import tn6.c;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LifeCollectMap f506758a = null;

    static {
        LifeCollectMap r100 = new LifeCollectMap();
        f506758a = r100;
        r100.put(b.class, new hl6.a());
        r100.put(e.class, new g());
        r100.put(com.bytedance.locallife.dito.provider.g.class, new k());
        r100.put(IDitoActionHandlerSpi.class, new TopModelActionHandler());
        r100.put(s.class, new DitoToolbarDataAgent());
        r100.put(d.class, new com.bytedance.locallife.pdp.e());
        r100.put(by6.a.class, new com.bytedance.locallife.poi.a());
        r100.put(s.class, Arrays.asList(new s[]{new DitoContainerLynxAgent(), new DitoSketchViewAgent()}));
        r100.put(ILifeBulletService.class, new com.bytedance.locallife.hybrid.bullet.e());
        r100.put(ILifeGeckoInitService.class, new pu6.a());
        r100.put(c.class, new tn6.a());
        r100.put(tn6.d.class, new tn6.b());
        r100.put(sx6.a.class, new tx6.a());
        r100.put(sx6.b.class, new tx6.b());
        r100.put(ep6.b.class, new CubeFontService());
        r100.put(com.bytedance.locallife.rate.a.class, new com.bytedance.locallife.rate.b());
    }
}
