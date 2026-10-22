package jz2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends fz2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<Map<String, Object>> f501099a;

    public a(Map<String, ? extends Object> r100) {
        this(new CopyOnWriteArrayList());
        if (r100 == null) goto L6;
        this.f501099a.add(r100);
        return;
    }

    @Override // fz2.a
    public final void fillInJsonObject(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = this.f501099a.iterator();
    L4:
        if (r102.hasNext() == false) goto L18;
        Iterator r103 = ((Map) r102.next()).entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        Map.Entry r104 = (Map.Entry) r103.next();
        if (Intrinsics.areEqual(r104.getKey(), "container_id") == true) goto L10;
        com.bytedance.android.monitorV2.util.l.p(r100, (String) r104.getKey(), r104.getValue());
        goto L7
    L10:
        Object r105 = r104.getValue();
        if ((r105 instanceof String) == false) goto L13;
        String r106 = (String) r105;
    L14:
        if (r106 == null) goto L7;
        r101.add(r106);
        goto L7
    L13:
        r106 = null;
        goto L14
    L18:
        if ((!r101.isEmpty()) == false) goto L30;
        com.bytedance.android.monitorV2.util.l.p(r100, "container_ids", new JSONArray(r101));
        return;
    }

    public a(CopyOnWriteArrayList<Map<String, Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerBaseMapList");
        this.f501099a = r100;
    }
}
