package rwc;

import com.alipay.sdk.m.u.i;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.nanohttpd.protocols.http.response.Response;

/* JADX INFO: loaded from: classes42.dex */
public final class c implements Iterable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f539740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f539741b;

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return this.f539740a.keySet().iterator();
    }

    public c(Map<String, String> r100) {
        this.f539740a = new HashMap();
        this.f539741b = new ArrayList();
        String r101 = r100.get(BaseHttpRequestInfo.KEY_COOKIE);
        if (r101 == null) goto L10;
        String[] r102 = r101.split(i.f25853b);
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L14;
        String[] r105 = r102[r104].trim().split(ContainerUtils.KEY_VALUE_DELIMITER);
        if (r105.length != 2) goto L9;
        this.f539740a.put(r105[0], r105[1]);
    L9:
        r104 = r104 + 1;
        goto L5
    L14:
        return;
    }

    public final void a(Response r100) {
        Iterator<b> r101 = this.f539741b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        b r102 = r101.next();
        ((ArrayList) r100.f526210j).add(String.format("%s=%s; expires=%s", new Object[]{r102.f539737a, r102.f539738b, r102.f539739c}));
        goto L4
    }

    public void delete(String r100) {
        ArrayList<b> r101 = this.f539741b;
        Calendar r102 = Calendar.getInstance();
        SimpleDateFormat r103 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        r103.setTimeZone(TimeZone.getTimeZone("GMT"));
        r102.add(5, -30);
        r101.add(new b(r100, r103.format(r102.getTime())));
    }
}
