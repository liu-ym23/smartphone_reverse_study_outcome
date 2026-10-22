package u65;

import bb5.k;
import com.bytedance.ee.bear.drive.biz.upload.file.FileUploadFragment;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FileUploadFragment f548925a;

    @Override // bb5.f
    public final void onPermissionDenied() {
        FileUploadFragment.Z90(this.f548925a, null, false);
    }

    public a(FileUploadFragment r100) {
        this.f548925a = r100;
    }
}
