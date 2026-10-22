package xkc;

import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class d implements Callable<wkc.a> {
    public d() {
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public wkc.a call2() throws Exception {
        ArrayMap r100 = a.f564387o;
        if (r100 != null) goto L5;
        String r101 = null;
    L14:
        vkc.a r102 = vkc.d.b().f555575b;
        r102.getClass();
        return new wkc.a(new JSONObject(r102.f555560b.a(vkc.a.a(r102.f555559a + "/video/live/qos/v2/ipSettings", r102.f555561c), r101.toString().getBytes("UTF-8"))));
    L5:
        StringBuilder r103 = new StringBuilder("{ \"IpMap\":{");
        Iterator r104 = r100.values().iterator();
        int r105 = 0;
    L7:
        if (r104.hasNext() == false) goto L13;
        j r106 = ((i) r104.next()).f564421c;
        if (r106 == null) goto L7;
        if (r105 == 0) goto L12;
        r103.append(",");
    L12:
        r103.append(r106.toString());
        r105 = r105 + 1;
        goto L7
    L13:
        r103.append("}}");
        r101 = r103.toString();
        goto L14
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ wkc.a call() throws Exception {
        return call2();
    }
}
