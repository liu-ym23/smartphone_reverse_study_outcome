package py2;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class b extends ny2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Map<String, Object>> f530980a;

    public b(List<Map<String, Object>> r100) {
        this.f530980a = r100;
    }

    @Override // ny2.a
    public final void b(JSONObject r100) {
        Iterator<T> r101 = this.f530980a.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Iterator r102 = ((Map) r101.next()).entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L4;
        Map.Entry r103 = (Map.Entry) r102.next();
        bz2.e.h(r100, (String) r103.getKey(), r103.getValue());
        goto L7
    }
}
