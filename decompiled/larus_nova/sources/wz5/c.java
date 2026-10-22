package wz5;

import com.bytedance.helios.api.consumer.FrequencyExtra;
import com.bytedance.helios.api.consumer.FrequencyLog;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import hz5.k;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements b {
    public c() {
    }

    @Override // wz5.b
    public final boolean a(PrivacyEvent r100) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<Pair<Long, Integer>>> r101 = zz5.c.f574094a;
        boolean r102 = zz5.c.d(zz5.c.b(r100), r100);
        if (r102 == false) goto L17;
        r100.f245384u.add("frequency");
        FrequencyExtra r103 = r100.A;
        if (r103 == null) goto L7;
        Set<FrequencyLog> r104 = r103.getFrequencyLogs();
    L8:
        if (r104 == null) goto L16;
        Iterator<T> r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(((FrequencyLog) r105.next()).getName(), String.valueOf(r100.f245366c)) == true) goto L14;
        r100.f245384u.add("frequency_group");
        goto L11
    L14:
        r100.f245384u.add("frequency_api");
    L16:
        k.d("Helios-Control-Api", "FrequencyCondition id=" + r100.f245366c + " startedTime=" + r100.f245376m);
        goto L17
    L7:
        r104 = null;
    L17:
        return r102;
    }
}
