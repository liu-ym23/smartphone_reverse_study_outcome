package e65;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.drive.biz.preview.more.download.im.DriveImFileDownloadVM;
import com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveImFileSaveToSpaceVM;
import com.bytedance.ee.bear.drive.core.DriveViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final BaseOpenEntity a;
    public final DriveViewModel b;
    public final DriveImFileSaveToSpaceVM c;
    public final DriveImFileDownloadVM d;

    /* JADX INFO: renamed from: e65.a$a, reason: collision with other inner class name */
    public static final class C0217a {
        public final DriveViewModel a;
        public final DriveImFileSaveToSpaceVM b;
        public final DriveImFileDownloadVM c;

        public C0217a(DriveViewModel r2, DriveImFileSaveToSpaceVM r3, DriveImFileDownloadVM r4) {
            Intrinsics.checkNotNullParameter(r2, "driveVM");
            Intrinsics.checkNotNullParameter(r3, "save2SpaceVM");
            Intrinsics.checkNotNullParameter(r4, "fileDownloadVM");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public a(C0217a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.a = r2.a.getOpenEntity();
        this.b = r2.a;
        this.c = r2.b;
        this.d = r2.c;
    }
}
