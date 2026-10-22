package s47;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class i implements i47.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f540630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f540631b;

    @Override // i47.d
    public final /* synthetic */ Map getRequestHeaders() {
        return null;
    }

    @Override // i47.d
    public final /* synthetic */ boolean isForMainFrame() {
        return false;
    }

    @Override // i47.d
    public final Map<String, String> getOptions() {
        HashMap r100 = new HashMap();
        r100.put("useForest", "1");
        Map r101 = this.f540631b;
        if (r101 == null) goto L5;
        r100.putAll(r101);
    L5:
        return r100;
    }

    @Override // i47.d
    public final Uri getUrl() {
        return this.f540630a;
    }

    public i(Uri r100, Map r101) {
        this.f540630a = r100;
        this.f540631b = r101;
    }
}
