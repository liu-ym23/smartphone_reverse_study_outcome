package p85;

import com.bytedance.ee.plugin.common.ttpdfreader.IStreamingDownloader;
import com.bytedance.ee.plugin.common.ttpdfreader.Range;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements IStreamingDownloader.DownloadCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList<Range> f528189a;

    public b(ArrayList<Range> r100) {
        this.f528189a = r100;
    }

    @Override // com.bytedance.ee.plugin.common.ttpdfreader.IStreamingDownloader.DownloadCallback
    public final void onResult(String r100, int r101, List<Range> r102) {
        tt5.a.h("DriveStreamingPdfPreloader", "download, key=" + r100 + ", status=" + r101 + ", range=" + this.f528189a);
    }
}
