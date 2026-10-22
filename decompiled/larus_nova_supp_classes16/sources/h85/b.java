package h85;

import android.content.Context;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity;
import com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.SpaceFileDownloadManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements com.bytedance.ee.bear.g {
    public b() {
    }

    public final void a(Context r8, BaseSpaceOpenEntity r9) {
        if (r8 == null) goto L5;
        int r0 = a95.a.d;
        new SpaceFileDownloadManager(r8, r9, null, null, a95.a.b.a(null)).c();
        return;
    L5:
        tt5.a.d("DriveComponent", "downloadFile() param is null");
    }
}
