package fl0;

import com.bytedance.android.live.livepullstream.PullStreamService;
import com.ss.videoarch.liveplayer.i;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PullStreamService f477679a;

    @Override // com.ss.videoarch.liveplayer.i.a
    public final void loadLibrary(String r100) throws Exception {
    }

    @Override // com.ss.videoarch.liveplayer.i.a
    public final void loadLibraryFromPath(String r100) throws Exception {
    }

    @Override // com.ss.videoarch.liveplayer.i.a
    public final boolean loadPlayerLibrary(String r100) {
        return false;
    }

    public b(PullStreamService r100) {
        this.f477679a = r100;
    }

    @Override // com.ss.videoarch.liveplayer.i.a
    public final boolean loadPluginLibrary(String r100, String r101) throws Exception {
        return this.f477679a.loadPluginLibrary(r100, r101);
    }
}
