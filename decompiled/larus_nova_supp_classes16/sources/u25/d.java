package u25;

import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockModel;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public final ConcurrentHashMap<String, a> a;

    public d() {
        this.a = new ConcurrentHashMap();
    }

    public final a a(String r5, boolean r6) {
        if (r5 == null) goto L36;
        ConcurrentHashMap<String, a> r1 = this.a;
        if (r1 == null) goto L36;
        if (r1.containsKey(r5) == false) goto L36;
        a r2 = this.a.get(r5);
        if (r6 == false) goto L15;
        Set<String> r7 = r2.e;
        if (r7 == null) goto L19;
        r7.add(r5);
    L19:
        this.a.remove(r5);
        List<SubBlockModel> r8 = r2.d;
        boolean r9 = true;
        if (r8 != null) goto L22;
    L33:
        if (r9 == false) goto L36;
        tt5.a.h("ImgDownloadJobInFlightContainer", "job finished");
        return r2;
    L22:
        if (r8.isEmpty() == true) goto L33;
        Set<String> r10 = r2.e;
        if (r10 != null) goto L27;
    L32:
        r9 = false;
        goto L33
    L27:
        if (r2.f == null) goto L32;
        if ((r10.size() + r2.f.size()) != r2.d.size()) goto L32;
    L15:
        Set<String> r11 = r2.f;
        if (r11 == null) goto L19;
        r11.add(r5);
    L36:
        return null;
    }
}
