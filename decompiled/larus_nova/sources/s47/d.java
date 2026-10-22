package s47;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements i47.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Uri f540619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f540620b;

    @Override // i47.d
    public final /* synthetic */ Map getOptions() {
        return null;
    }

    @Override // i47.d
    public final boolean isForMainFrame() {
        return true;
    }

    @Override // i47.d
    public final Map<String, String> getRequestHeaders() {
        return this.f540620b;
    }

    @Override // i47.d
    public final Uri getUrl() {
        return this.f540619a;
    }

    public d(Uri r100, Map r101) {
        this.f540619a = r100;
        this.f540620b = r101;
    }
}
