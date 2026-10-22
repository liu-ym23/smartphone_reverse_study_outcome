package km7;

import android.app.Application;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.v;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import ok7.i;
import rk7.m;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "luckydogWidgetIsInstalled")
public final class c extends ok7.a {
    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return "luckydogWidgetIsInstalled";
    }

    public c() {
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        v r102 = r100.getArray("installNameList");
        if (r102 != null) goto L5;
    L19:
        r101.invoke(ok7.c.a(new LinkedHashMap(), "installedList is empty"));
        return;
    L5:
        if (r102.size() == 0) goto L19;
        LinkedHashMap r103 = new LinkedHashMap();
        List<Object> r104 = r102.toList();
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L9:
        if (r106.hasNext() == false) goto L13;
        Object r107 = r106.next();
        if ((r107 instanceof String) == false) goto L9;
        r105.add(r107);
        goto L9
    L13:
        Iterator r108 = r105.iterator();
    L15:
        if (r108.hasNext() == false) goto L17;
        String r109 = (String) r108.next();
        Application r110 = m.f538347a;
        r103.put(r109, 0);
        goto L15
    L17:
        LinkedHashMap r111 = new LinkedHashMap();
        r111.put("installResult", r103);
        r101.invoke(ok7.c.a(r111, "success"));
    }
}
