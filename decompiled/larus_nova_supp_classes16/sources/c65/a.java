package c65;

import com.bytedance.ee.bear.drive.biz.preview.error.password.DriveFileEncryptedView;
import h95.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements b {
    public final /* synthetic */ DriveFileEncryptedView a;

    @Override // h95.b
    public final void a() {
        this.a.a.setImageSizeResource(2131165486);
        this.a.a.getImageView().requestLayout();
        this.a.a.setTitleTextAppearance(2131953915);
        DriveFileEncryptedView r0 = this.a;
        r0.a.showPrimaryAction(r0.b);
    }

    @Override // h95.b
    public final void b() {
        this.a.a.setImageSizeResource(2131165487);
        this.a.a.getImageView().requestLayout();
        this.a.a.setTitleTextAppearance(2131953909);
        this.a.a.showPrimaryAction(false);
    }

    public a(DriveFileEncryptedView r1) {
        this.a = r1;
    }
}
