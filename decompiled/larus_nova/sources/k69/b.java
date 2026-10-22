package k69;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import g49.d;
import java.io.File;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ArrayIteratorKt;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f501976a = 0;

    static {
    }

    public static boolean a(String r100, String[] r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L5;
    L25:
        return false;
    L5:
        if (r102.isDirectory() == false) goto L25;
        File[] r103 = r102.listFiles();
        if (r103 == null) goto L23;
        Iterator r104 = ArrayIteratorKt.iterator(r103);
    L11:
        if (r104.hasNext() == false) goto L37;
        File r105 = (File) r104.next();
        if (r105.isDirectory() == true) goto L15;
        if (ArraysKt.contains(r101, r105.getName()) == true) goto L19;
        boolean r106 = r105.delete();
        d.d("DoraOTAUtils", "deleteAllFilesInDirectory: " + r105.getAbsolutePath() + ' ' + r106);
        if (r106 == true) goto L11;
        return false;
    L19:
        d.d("DoraOTAUtils", "deleteAllFilesInDirectory: " + r105.getAbsolutePath() + " exclude");
        goto L11
    L15:
        if (a(r105.getAbsolutePath(), r101) == true) goto L11;
        return false;
    L37:
        return true;
    L23:
        return true;
    }
}
