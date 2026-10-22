package k65;

import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import com.bytedance.ee.bear.drive.biz.preview.more.menu.importfile.ImportFileItemV2;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import e45.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements b {
    public final DriveMGPermissionVM a;
    public final DriveViewModel b;
    public final String c;

    @Override // e45.b
    public final void b() {
    }

    @Override // e45.b
    public final boolean c() {
        return false;
    }

    @Override // e45.b
    public final boolean a() {
        DriveMGPermissionVM r0 = this.a;
        if (r0 != null) goto L5;
    L22:
        tt5.a.k(this.c, "driveState = null");
        return false;
    L5:
        if (r0.livePerm().getValue() == null) goto L22;
        if (this.b.getFileModel() == null) goto L22;
        u55.b r1 = (u55.b) this.a.livePerm().getValue();
        if (r1 != null) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == true) goto L17;
        return false;
    L17:
        if (n55.a.a((f85.a) this.b.getFileModel()) == true) goto L19;
        return false;
    L19:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).l(ImportFileItemV2.ID_IMPORT_FILE) == false) goto L26;
        return true;
    L26:
        return false;
    L12:
        if (r1.d() != true) goto L14;
        r2 = true;
        goto L15
    }

    @Override // e45.b
    public final String getId() {
        return ImportFileItemV2.ID_IMPORT_FILE;
    }

    public a(DriveMGPermissionVM r2, DriveViewModel r3) {
        Intrinsics.checkNotNullParameter(r3, "driveVM");
        this.a = r2;
        this.b = r3;
        this.c = "ImportFileMoreBadgeStrategy";
    }
}
