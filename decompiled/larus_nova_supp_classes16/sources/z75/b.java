package z75;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.drive.DriveLocalFilePath;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final String a(DriveFilePath r1, UserSession r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return b(r1, r2).getRealPath();
    }

    public static final VFSPath b(DriveFilePath r4, UserSession r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if ((r4 instanceof DriveLocalFilePath) == false) goto L6;
        a.C0333a r6 = a.a;
        String r7 = ((DriveLocalFilePath) r4).getLocalFilePath();
        Intrinsics.checkNotNullParameter(r7, "localFilePath");
        return ay4.d.a().z(r7);
    L6:
        VFSPath r0 = r4.getDecryptPath();
        if (r0 == null) goto L9;
        return r0;
    L9:
        a.C0333a r1 = a.a;
        Biz r2 = r4.getBiz();
        String r3 = r4.getRelativePath();
        return a.a.b(r2, r3, null, r5).subPath(r4.getFileName());
    }

    public static final void c(DriveFilePath r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 == null) goto L6;
        r2.setRelativePath(r2.getRelativePath() + File.separator + r3);
        return;
    }

    public static final boolean d(DriveFilePath r1, UserSession r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        VFSFile r3 = b(r1, r2).toFile();
        if (r1.isEmpty() == false) goto L5;
    L9:
        return false;
    L5:
        if (r3.isFile() == false) goto L9;
        if (r3.exists() == false) goto L9;
        return true;
    }

    public static final VFSFile e(DriveFilePath r1, UserSession r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return b(r1, r2).toFile();
    }

    public static final VFSFile f(DriveFilePath r1, UserSession r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return h(r1, r2).toFile();
    }

    public static final String g(DriveFilePath r1, UserSession r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return h(r1, r2).getRealPath();
    }

    public static final VFSPath h(DriveFilePath r3, UserSession r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if ((r3 instanceof DriveLocalFilePath) == false) goto L6;
        a.C0333a r5 = a.a;
        String r6 = ((DriveLocalFilePath) r3).getLocalFilePath();
        Intrinsics.checkNotNullParameter(r6, "localFilePath");
        return ay4.d.a().z(r6);
    L6:
        VFSPath r0 = r3.getDecryptPath();
        if (r0 == null) goto L9;
        return r0;
    L9:
        a.C0333a r1 = a.a;
        Biz r2 = r3.getBiz();
        String r7 = r3.getRelativePath();
        return a.a.b(r2, r7, null, r4);
    }
}
