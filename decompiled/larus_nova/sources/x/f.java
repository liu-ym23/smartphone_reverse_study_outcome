package x;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes28.dex */
public final class f implements MediaScannerConnection.MediaScannerConnectionClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaScannerConnection f561987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f561988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedBlockingQueue<Uri> f561989c;

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public final void onMediaScannerConnected() {
        this.f561987a.scanFile(this.f561988b.getAbsolutePath(), null);
    }

    public f(Context r100, File r101) {
        this.f561989c = new LinkedBlockingQueue(1);
        this.f561988b = r101;
        MediaScannerConnection r102 = new MediaScannerConnection(r100, this);
        this.f561987a = r102;
        r102.connect();
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public final void onScanCompleted(String r100, Uri r101) {
        this.f561987a.disconnect();
        if (r101 != null) goto L10;
        return;
    L10:
        this.f561989c.put(r101);     // Catch: InterruptedException -> L7
        return;
    L7:
        e = move-exception;
        e.getMessage();
    }
}
