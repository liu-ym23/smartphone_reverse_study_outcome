package w85;

import com.bytedance.ee.bear.middleground.drive.export.DownloadRequestInfo;
import io.reactivex.Flowable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface c {
    void a(List<a> r1, a.b r2);

    void b(String r1);

    b c(String r1, DownloadRequestInfo.DownloadType r2);

    Flowable<Boolean> clearCache();

    b d(a r1);

    Flowable<Long> getCacheSize();
}
