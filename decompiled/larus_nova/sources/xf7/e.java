package xf7;

import com.bytedance.sync.SyncSDK;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f563452a;

    @Override // xf7.j
    public final Map<String, String> getCommonParams() {
        j r100 = this.f563452a;
        if (r100 == null) goto L5;
        Map<String, String> r101 = r100.getCommonParams();
    L6:
        if (r101 != null) goto L8;
        r101 = new HashMap();
    L8:
        r101.put("bytesync_sdk_version", String.valueOf(10002));
        Collection<o> r102 = SyncSDK.getRegisteredBusinesses();
        if (r102 != null) goto L11;
    L20:
        return r101;
    L11:
        if (r102.isEmpty() == true) goto L20;
        Iterator<o> r103 = r102.iterator();
    L15:
        if (r103.hasNext() == false) goto L20;
        o r104 = r103.next();
        if (r104 == null) goto L15;
        r104.f563486a.getClass();
        goto L15
    L5:
        r101 = null;
        goto L6
    }

    public e(j r100) {
        this.f563452a = r100;
    }
}
