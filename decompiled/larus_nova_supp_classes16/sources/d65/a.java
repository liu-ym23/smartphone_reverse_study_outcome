package d65;

import com.bytedance.ee.bear.drive.biz.external.f;
import com.bytedance.ee.bear.drive.biz.preview.more.download.spacefile.SpaceFileDownloadManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements f.c {
    public final /* synthetic */ SpaceFileDownloadManager a;

    public a(SpaceFileDownloadManager r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.drive.biz.external.f.c
    public final String getFileId() {
        return this.a.b.getFileId();
    }
}
