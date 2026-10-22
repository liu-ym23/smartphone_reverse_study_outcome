package u65;

import bb5.k;
import com.bytedance.ee.bear.drive.biz.upload.file.FileUploadFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends k {
    public final /* synthetic */ FileUploadFragment a;

    @Override // bb5.f
    public final void onPermissionDenied() {
        FileUploadFragment.Z90(this.a, null, false);
    }

    public a(FileUploadFragment r1) {
        this.a = r1;
    }
}
