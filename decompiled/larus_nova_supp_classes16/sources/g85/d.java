package g85;

import android.util.SparseArray;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.AbsProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.ArchiveTreeProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.ImageThumbDownloadProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.NoDownloadProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.NotSupportProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.OggFileProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.PdfStreamingProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.ProgressiveImageProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.SimilarFileProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.TransDownloadProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.TransHtmlProcessor;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.VideoStreamingProcessor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static final SparseArray<Class<? extends AbsProcessor>> a = null;

    static {
        SparseArray<Class<? extends AbsProcessor>> r0 = new SparseArray();
        a = r0;
        r0.put(9, PdfStreamingProcessor.class);
        r0.put(3, VideoStreamingProcessor.class);
        r0.put(0, TransDownloadProcessor.class);
        r0.put(1, TransDownloadProcessor.class);
        r0.put(7, TransDownloadProcessor.class);
        r0.put(2, TransDownloadProcessor.class);
        r0.put(8, TransHtmlProcessor.class);
        r0.put(-3, NoDownloadProcessor.class);
        r0.put(-4, ImageThumbDownloadProcessor.class);
        r0.put(-2, SimilarFileProcessor.class);
        r0.put(-1, NotSupportProcessor.class);
        r0.put(11, ProgressiveImageProcessor.class);
        r0.put(13, ArchiveTreeProcessor.class);
        r0.put(14, TransDownloadProcessor.class);
        r0.put(20, OggFileProcessor.class);
    }
}
