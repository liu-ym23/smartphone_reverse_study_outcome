package u25;

import com.bytedance.ee.bear.document.offline.sync.preloadexecutor.subblock.SubBlockModel;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f548467a;

    public d() {
        this.f548467a = new ConcurrentHashMap();
    }

    public final a a(String r100, boolean r101) {
        if (r100 == null) goto L36;
        ConcurrentHashMap<String, a> r102 = this.f548467a;
        if (r102 == null) goto L36;
        if (r102.containsKey(r100) == false) goto L36;
        a r103 = this.f548467a.get(r100);
        if (r101 == false) goto L15;
        Set<String> r104 = r103.f548461e;
        if (r104 == null) goto L19;
        r104.add(r100);
    L19:
        this.f548467a.remove(r100);
        List<SubBlockModel> r105 = r103.f548460d;
        boolean r106 = true;
        if (r105 != null) goto L22;
    L33:
        if (r106 == false) goto L36;
        tt5.a.h("ImgDownloadJobInFlightContainer", "job finished");
        return r103;
    L22:
        if (r105.isEmpty() == true) goto L33;
        Set<String> r107 = r103.f548461e;
        if (r107 != null) goto L27;
    L32:
        r106 = false;
        goto L33
    L27:
        if (r103.f548462f == null) goto L32;
        if ((r107.size() + r103.f548462f.size()) != r103.f548460d.size()) goto L32;
    L15:
        Set<String> r108 = r103.f548462f;
        if (r108 == null) goto L19;
        r108.add(r100);
    L36:
        return null;
    }
}
