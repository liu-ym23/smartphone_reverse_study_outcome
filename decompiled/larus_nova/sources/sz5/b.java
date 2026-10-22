package sz5;

import com.bytedance.helios.api.consumer.EventHandler;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import e06.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements EventHandler {
    public b() {
    }

    @Override // com.bytedance.helios.api.consumer.EventHandler
    public final int stage() {
        return 5;
    }

    @Override // com.bytedance.helios.api.consumer.EventHandler
    public final void a(PrivacyEvent r100) {
        List<qz5.a> r101 = f.f470648d;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        r102.add(Integer.valueOf(((qz5.a) r103.next()).f535345a));
        goto L4
    L7:
        if (r102.contains(Integer.valueOf(r100.f245366c)) == false) goto L9;
        ConcurrentHashMap<String, CopyOnWriteArrayList<Pair<Long, Integer>>> r104 = zz5.c.f574094a;
        zz5.c.f(r100);
    L9:
        int r105 = r100.f245366c;
        if (r105 != 102600) goto L12;
    L13:
        Set<Map<String, ?>> r106 = r100.L;
        if (r106 != null) goto L16;
    L19:
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
        e06.b.c();
    L29:
        com.bytedance.helios.sdk.engine.a.f245566d.a(r100, false);
        return;
    L22:
        Iterator<T> r108 = r100.L.iterator();
    L24:
        if (r108.hasNext() == false) goto L29;
        Map r109 = (Map) r108.next();
        Map<String, Integer> r110 = e06.b.f470641a;
        Object r111 = r109.get("extra_parameter_permissions");
        if ((r111 instanceof String) == true) goto L28;
        r111 = null;
    L28:
        e06.b.b((String) r111);
        goto L24
    L16:
        if (r106.isEmpty() == true) goto L19;
        r107 = false;
        goto L20
    L12:
        if (r105 != 102601) goto L29;
        goto L13
    }
}
