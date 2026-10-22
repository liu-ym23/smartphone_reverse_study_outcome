package s10;

import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class i<T> implements h80.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f540142a = null;

    static {
        f540142a = new i();
    }

    public i() {
    }

    @Override // h80.d
    public final Object get() {
        IHostWebView r100 = (IHostWebView) k.f(IHostWebView.class);
        if (r100 == null) goto L30;
        Map<String, String> r101 = r100.getHeaderMap("https://" + ((IHostNetwork) k.n(IHostNetwork.class)).getHostDomain());
        if (r101 == null) goto L30;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r103 = r101.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L36;
        Map.Entry<String, String> r104 = r103.next();
        String r105 = r104.getKey();
        boolean r106 = true;
        if (r105 != null) goto L12;
    L15:
        boolean r107 = true;
    L16:
        if (r107 == true) goto L26;
        String r108 = r104.getValue();
        if (r108 != null) goto L20;
    L23:
        boolean r109 = true;
    L24:
        if (r109 == true) goto L26;
    L27:
        if (r106 == false) goto L8;
        r102.put(r104.getKey(), r104.getValue());
        goto L8
    L20:
        if (r108.length() == 0) goto L23;
        r109 = false;
    L26:
        r106 = false;
        goto L27
    L12:
        if (r105.length() == 0) goto L15;
        r107 = false;
        goto L16
    L36:
        return r102;
    L30:
        return new HashMap();
    }
}
