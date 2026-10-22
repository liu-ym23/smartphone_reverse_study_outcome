package sia;

import android.graphics.BlurMaskFilter;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f542254a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.isDirectory() == true) goto L6;
        FLogger.f375446a.i("EnrollFileUtils", "createDirIfNotExists with " + r100);
        r101.mkdirs();
        return;
    }

    @JvmStatic
    public static final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);     // Catch: Exception -> L18
        if (r101.isDirectory() == false) goto L15;
        File[] r102 = r101.listFiles();     // Catch: Exception -> L18
        if (r102 == null) goto L12;
        Iterator r103 = ArrayIteratorKt.iterator(r102);     // Catch: Exception -> L18
    L9:
        if (r103.hasNext() == false) goto L12;
        b(((File) r103.next()).getPath());     // Catch: Exception -> L18
    L12:
        if (r101.delete() == true) goto L23;
        FLogger.f375446a.e("EnrollFileUtils", "Fails to delete directory = " + r101.getPath());     // Catch: Exception -> L18
        return;
    L23:
        return;
    L15:
        if (r101.delete() == true) goto L25;
        FLogger.f375446a.e("EnrollFileUtils", "Fails to delete file = " + r101.getPath());     // Catch: Exception -> L18
        return;
    L25:
        return;
    L18:
        e = move-exception;
        FLogger.f375446a.e("EnrollFileUtils", "deleteFile error: " + e.getMessage());
    }

    @JvmStatic
    public static final void c(TextView r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        FLogger.f375446a.i("EnrollFileUtils", "setBlur radius: " + r101);
        r100.getPaint().setMaskFilter(new BlurMaskFilter(r101, BlurMaskFilter.Blur.NORMAL));
        r100.postInvalidate();
    }
}
