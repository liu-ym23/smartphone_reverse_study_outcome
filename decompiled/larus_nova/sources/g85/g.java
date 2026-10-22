package g85;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.bytedance.ee.drive.mime.DriveLocalMime;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<String> f480400a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseIntArray f480401b = null;

    static {
        SparseArray<String> r100 = new SparseArray(10);
        f480400a = r100;
        SparseIntArray r101 = new SparseIntArray(6);
        f480401b = r101;
        r100.put(9, "PDF");
        r100.put(0, "PDF");
        r100.put(1, "PNG");
        r100.put(7, "JPG");
        r100.put(2, "PAGES");
        r100.put(8, "HTML");
        r100.put(3, "MP4");
        r100.put(14, "TXT");
        r101.put(DriveLocalMime.NOT_SUPPORT.getValue(), R.string.Drive_Drive_DefaultFileType);
        r101.put(DriveLocalMime.DOCUMENT.getValue(), R.string.Drive_Drive_DocumentType);
        r101.put(DriveLocalMime.IMAGE.getValue(), R.string.Drive_Drive_ImageType);
        r101.put(DriveLocalMime.AUDIO.getValue(), R.string.Drive_Drive_AudioType);
        r101.put(DriveLocalMime.VIDEO.getValue(), R.string.Drive_Drive_VideoType);
        r101.put(DriveLocalMime.PDF.getValue(), R.string.Drive_Drive_PdfType);
        r101.put(DriveLocalMime.APK.getValue(), R.string.Drive_Drive_ApkType);
    }
}
