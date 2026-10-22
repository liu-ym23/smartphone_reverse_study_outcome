package i8a;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.RemoteException;
import android.view.View;
import com.lynx.tasm.service.IServiceProvider;

/* JADX INFO: loaded from: classes32.dex */
public interface h extends IServiceProvider {
    void a(ClipData r100) throws RemoteException;

    void b();

    Bitmap c(View r100, Bitmap.Config r101);

    void d();

    String extractMetadata(MediaMetadataRetriever r100, int r101);

    String getLocale();

    void openCamera() throws RuntimeException;

    void releaseCamera();
}
