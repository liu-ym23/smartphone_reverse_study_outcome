package g85;

import android.util.SparseArray;
import com.bytedance.ee.bear.drive.view.preview.archive.ArchivePreviewView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.AbsLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.ApkLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.AudioLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.DocumentLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.ImageLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.NotSupportLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.PdfLoadingView;
import com.bytedance.ee.bear.drive.view.preview.loadingview.VideoViewLoadingView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AbsPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ApkPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.AudioPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.DocumentPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.ImagePreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.NotSupportPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PdfPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.VideoPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.WpsPreviewView;
import com.bytedance.ee.drive.mime.DriveLocalMime;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static final SparseArray<Class<? extends AbsPreviewView>> a = null;
    public static final SparseArray<Class<? extends AbsLoadingView>> b = null;

    static {
        SparseArray<Class<? extends AbsPreviewView>> r0 = new SparseArray();
        a = r0;
        SparseArray<Class<? extends AbsLoadingView>> r1 = new SparseArray();
        b = r1;
        DriveLocalMime r2 = DriveLocalMime.NOT_SUPPORT;
        r0.put(r2.getValue(), NotSupportPreviewView.class);
        DriveLocalMime r3 = DriveLocalMime.DOCUMENT;
        r0.put(r3.getValue(), DocumentPreviewView.class);
        DriveLocalMime r4 = DriveLocalMime.IMAGE;
        r0.put(r4.getValue(), ImagePreviewView.class);
        DriveLocalMime r5 = DriveLocalMime.AUDIO;
        r0.put(r5.getValue(), AudioPreviewView.class);
        DriveLocalMime r6 = DriveLocalMime.VIDEO;
        r0.put(r6.getValue(), VideoPreviewView.class);
        DriveLocalMime r7 = DriveLocalMime.PDF;
        r0.put(r7.getValue(), PdfPreviewView.class);
        DriveLocalMime r8 = DriveLocalMime.APK;
        r0.put(r8.getValue(), ApkPreviewView.class);
        r0.put(DriveLocalMime.ARCHIVE.getValue(), ArchivePreviewView.class);
        r0.put(DriveLocalMime.WPS.getValue(), WpsPreviewView.class);
        r1.put(r2.getValue(), NotSupportLoadingView.class);
        r1.put(r3.getValue(), DocumentLoadingView.class);
        r1.put(r4.getValue(), ImageLoadingView.class);
        r1.put(r5.getValue(), AudioLoadingView.class);
        r1.put(r6.getValue(), VideoViewLoadingView.class);
        r1.put(r7.getValue(), PdfLoadingView.class);
        r1.put(r8.getValue(), ApkLoadingView.class);
    }
}
