package jz2;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class b extends fz2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<Map<String, Object>> f501100a;

    public final Map<String, Object> a() {
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        Iterator<T> r101 = this.f501100a.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Iterator r102 = ((Map) r101.next()).entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L4;
        Map.Entry r103 = (Map.Entry) r102.next();
        r100.put(r103.getKey(), r103.getValue());
        goto L7
    L9:
        return r100;
    }

    public b(Map<String, ? extends Object> r100) {
        this(new CopyOnWriteArrayList());
        if (r100 == null) goto L6;
        this.f501100a.add(r100);
        return;
    }

    @Override // fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Iterator<T> r101 = this.f501100a.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Iterator r102 = ((Map) r101.next()).entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L4;
        Map.Entry r103 = (Map.Entry) r102.next();
        com.bytedance.android.monitorV2.util.l.p(r100, (String) r103.getKey(), r103.getValue());
        goto L7
    }

    public b(CopyOnWriteArrayList<Map<String, Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerInfoMapList");
        this.f501100a = r100;
    }
}
