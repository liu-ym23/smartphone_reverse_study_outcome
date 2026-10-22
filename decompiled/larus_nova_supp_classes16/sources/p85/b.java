package p85;

import com.bytedance.ee.plugin.common.ttpdfreader.IStreamingDownloader;
import com.bytedance.ee.plugin.common.ttpdfreader.Range;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements IStreamingDownloader.DownloadCallback {
    public final /* synthetic */ ArrayList<Range> a;

    public b(ArrayList<Range> r1) {
        this.a = r1;
    }

    public final void onResult(String r2, int r3, List<Range> r4) {
        tt5.a.h("DriveStreamingPdfPreloader", "download, key=" + r2 + ", status=" + r3 + ", range=" + this.a);
    }
}
