package rm4;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f538544a = 0;

    static {
    }

    public static Drawable a(String r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        PackageManager r102 = r101.getPackageManager();
        PackageInfo r103 = r102.getPackageArchiveInfo(r100, 0);
        if (r103 != null) goto L5;
        return null;
    L5:
        ApplicationInfo r104 = r103.applicationInfo;
        if (r104 == null) goto L8;
        r104.sourceDir = r100;
    L8:
        if (r104 == null) goto L10;
        r104.publicSourceDir = r100;
    L10:
        if (r104 != null) goto L12;
        return null;
    L12:
        return r104.loadIcon(r102);
    }
}
