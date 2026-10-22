package fl0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.livepullstream.PullStreamService;
import com.ss.videoarch.liveplayer.i;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PullStreamService f477678a;

    @Override // com.ss.videoarch.liveplayer.i.a
    public final void loadLibraryFromPath(String r100) throws Exception {
    }

    @Override // com.ss.videoarch.liveplayer.i.a
    public final boolean loadPluginLibrary(String r100, String r101) throws Exception {
        return false;
    }

    public a(PullStreamService r100) {
        this.f477678a = r100;
    }

    @Override // com.ss.videoarch.liveplayer.i.a
    public final void loadLibrary(String r100) throws Exception {
        this.f477678a.loadLibrary(r100);
    }

    @Override // com.ss.videoarch.liveplayer.i.a
    public final boolean loadPlayerLibrary(String r100) {
        if (this.f477678a.loadLibrary(r100) != 0) goto L11;
        return true;
    L11:
        return false;
    L7:
        ALogger.d("pull-stream-plugin-load", "load " + r100 + " so failed!");
        return false;
    }
}
