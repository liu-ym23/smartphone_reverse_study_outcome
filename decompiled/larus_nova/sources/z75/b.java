package z75;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.drive.DriveLocalFilePath;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSPath;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    public static final String a(DriveFilePath r100, UserSession r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return b(r100, r101).getRealPath();
    }

    public static final VFSPath b(DriveFilePath r100, UserSession r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof DriveLocalFilePath) == false) goto L6;
        a.C8426a r102 = a.f570666a;
        String r103 = ((DriveLocalFilePath) r100).getLocalFilePath();
        Intrinsics.checkNotNullParameter(r103, "localFilePath");
        return ay4.d.a().z(r103);
    L6:
        VFSPath r104 = r100.getDecryptPath();
        if (r104 == null) goto L9;
        return r104;
    L9:
        a.C8426a r105 = a.f570666a;
        Biz r106 = r100.getBiz();
        String r107 = r100.getRelativePath();
        return a.f570666a.b(r106, r107, null, r101).subPath(r100.getFileName());
    }

    public static final void c(DriveFilePath r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == null) goto L6;
        r100.setRelativePath(r100.getRelativePath() + File.separator + r101);
        return;
    }

    public static final boolean d(DriveFilePath r100, UserSession r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        VFSFile r102 = b(r100, r101).toFile();
        if (r100.isEmpty() == false) goto L5;
    L9:
        return false;
    L5:
        if (r102.isFile() == false) goto L9;
        if (r102.exists() == false) goto L9;
        return true;
    }

    public static final VFSFile e(DriveFilePath r100, UserSession r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return b(r100, r101).toFile();
    }

    public static final VFSFile f(DriveFilePath r100, UserSession r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return h(r100, r101).toFile();
    }

    public static final String g(DriveFilePath r100, UserSession r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return h(r100, r101).getRealPath();
    }

    public static final VFSPath h(DriveFilePath r100, UserSession r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof DriveLocalFilePath) == false) goto L6;
        a.C8426a r102 = a.f570666a;
        String r103 = ((DriveLocalFilePath) r100).getLocalFilePath();
        Intrinsics.checkNotNullParameter(r103, "localFilePath");
        return ay4.d.a().z(r103);
    L6:
        VFSPath r104 = r100.getDecryptPath();
        if (r104 == null) goto L9;
        return r104;
    L9:
        a.C8426a r105 = a.f570666a;
        Biz r106 = r100.getBiz();
        String r107 = r100.getRelativePath();
        return a.f570666a.b(r106, r107, null, r101);
    }
}
