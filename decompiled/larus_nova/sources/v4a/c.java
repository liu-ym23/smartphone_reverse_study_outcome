package v4a;

import com.alipay.sdk.m.u.i;
import com.huawei.hms.framework.common.ContainerUtils;
import com.lynx.animax.base.bridge.JavaOnlyMap;
import com.lynx.animax.base.bridge.ReadableMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JavaOnlyMap f553152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JavaOnlyMap f553153b;

    public final String toString() {
        StringBuilder r100 = new StringBuilder("PerfMetrics{");
        Iterator<Map.Entry<String, Object>> r101 = this.f553152a.asHashMap().entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<String, Object> r102 = r101.next();
        if (r102.getValue() == null) goto L4;
        r100.append(r102.getKey());
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(r102.getValue());
        r100.append(",");
        goto L4
    L8:
        Iterator<Map.Entry<String, Object>> r103 = this.f553153b.asHashMap().entrySet().iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<String, Object> r104 = r103.next();
        if (r104.getValue() == null) goto L10;
        r100.append(r104.getKey());
        r100.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r100.append(r104.getValue());
        r100.append(",");
        goto L10
    L14:
        r100.append(i.f25855d);
        return r100.toString();
    }

    public c(ReadableMap r100, ReadableMap r101, Map<String, Object> r102, String r103) {
        if (r100 != null) goto L5;
        HashMap<String, Object> r104 = new HashMap();
    L6:
        if (r101 != null) goto L8;
        HashMap<String, Object> r105 = new HashMap();
    L9:
        Iterator<Map.Entry<String, Object>> r106 = r102.entrySet().iterator();
    L11:
        if (r106.hasNext() == false) goto L23;
        Map.Entry<String, Object> r107 = r106.next();
        String r108 = r107.getKey();
        Object r109 = r107.getValue();
        if (r109 == null) goto L11;
        if ((r109 instanceof Number) == true) goto L17;
        if ((r109 instanceof String) == true) goto L22;
        if ((r109 instanceof Boolean) == false) goto L11;
    L22:
        r105.put(r108, r109);
        goto L11
    L17:
        r104.put(r108, r109);
        goto L11
    L23:
        if (r103 == null) goto L25;
        r105.put("default", r103);
    L25:
        this.f553152a = JavaOnlyMap.from(r104);
        this.f553153b = JavaOnlyMap.from(r105);
        return;
    L8:
        r105 = r101.asHashMap();
        goto L9
    L5:
        r104 = r100.asHashMap();
        goto L6
    }
}
