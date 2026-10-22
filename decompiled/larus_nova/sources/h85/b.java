package h85;

import android.content.Context;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity;
import com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.SpaceFileDownloadManager;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements com.bytedance.ee.bear.g {
    public b() {
    }

    @Override // com.bytedance.ee.bear.g
    public final void a(Context r100, BaseSpaceOpenEntity r101) {
        if (r100 == null) goto L5;
        int r102 = a95.a.f2276d;
        new SpaceFileDownloadManager(r100, r101, null, null, a95.a.b.a(null)).c();
        return;
    L5:
        tt5.a.d("DriveComponent", "downloadFile() param is null");
    }
}
