package ya4;

import com.bytedance.bdp.bdpbase.core.preload.BdpAppPreloadEntity;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.schema.SchemaInfo;
import com.bytedance.bdp.serviceapi.defaults.platform.BdpPlatformService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class d implements a {
    public d() {
    }

    @Override // ya4.a
    public final void a(List<String> r100, e r101) {
        int r102 = c.f567021a;
        List<String> r103 = r100;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L20;
        SchemaInfo.a r106 = new SchemaInfo.a((String) r105.next());
        String r107 = r101.f567022d;
        LinkedHashMap<String, String> r108 = r106.f201307a;
        SchemaInfo.G.getClass();
        r108.put("scene", SchemaInfo.c.d(r107));
        String r109 = r101.f567023e;
        JSONObject r110 = r106.f201310d;
        if (r110 != null) goto L8;
        r110 = new JSONObject();
    L8:
        r110.put("launch_from", r109);
        r106.f201310d = r110;
        Unit r111 = null;
        SchemaInfo r112 = r106.a();     // Catch: Exception -> L11
    L13:
        if (r112 == null) goto L15;
        String r113 = r112.s();
    L16:
        new BdpAppPreloadEntity(r113, 0);
        BdpPlatformService r114 = (BdpPlatformService) BdpManager.getInst().getService(BdpPlatformService.class);
        if (r114 == null) goto L19;
        MapsKt.mapOf(TuplesKt.to("plugin_name", "com.ss.android.ugc.aweme.miniapp"));
        r114.y2();
        r111 = Unit.INSTANCE;
    L19:
        r104.add(r111);
        goto L4
    L15:
        r113 = null;
    L11:
        r112 = null;
        goto L13
    }
}
