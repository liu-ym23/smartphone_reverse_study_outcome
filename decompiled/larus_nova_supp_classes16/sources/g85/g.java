package g85;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.bytedance.ee.drive.mime.DriveLocalMime;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g {
    public static final SparseArray<String> a = null;
    public static final SparseIntArray b = null;

    static {
        SparseArray<String> r0 = new SparseArray(10);
        a = r0;
        SparseIntArray r1 = new SparseIntArray(6);
        b = r1;
        r0.put(9, "PDF");
        r0.put(0, "PDF");
        r0.put(1, "PNG");
        r0.put(7, "JPG");
        r0.put(2, "PAGES");
        r0.put(8, "HTML");
        r0.put(3, "MP4");
        r0.put(14, "TXT");
        r1.put(DriveLocalMime.NOT_SUPPORT.getValue(), 2131888376);
        r1.put(DriveLocalMime.DOCUMENT.getValue(), 2131888382);
        r1.put(DriveLocalMime.IMAGE.getValue(), 2131888407);
        r1.put(DriveLocalMime.AUDIO.getValue(), 2131888369);
        r1.put(DriveLocalMime.VIDEO.getValue(), 2131888464);
        r1.put(DriveLocalMime.PDF.getValue(), 2131888431);
        r1.put(DriveLocalMime.APK.getValue(), 2131888366);
    }
}
