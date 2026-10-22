package lu8;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f510835a = null;

    static {
        f510835a = new b();
    }

    public b() {
    }

    public static boolean a(File r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.exists() == true) goto L10;
        return true;
    L10:
        if (r100.isDirectory() == true) goto L12;
        return false;
    L12:
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L30;
        if (r101.length == 0) goto L30;
        Iterator r102 = ArrayIteratorKt.iterator(r101);
    L18:
        if (r102.hasNext() == false) goto L30;
        File r103 = (File) r102.next();
        if (r103.isFile() == true) goto L22;
        if (r103.isDirectory() == false) goto L18;
        if (a(r103) == true) goto L18;
        return false;
    L22:
        if (r103.delete() == true) goto L18;
        return false;
    L30:
        return r100.delete();
    }

    public final boolean delete(File r100) {
        boolean r101 = false;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.isDirectory() == false) goto L9;
        return a(r100);
    L9:
        if (r100.exists() == true) goto L11;
    L14:
        r101 = true;
    L16:
        return r101;
    L11:
        if (r100.isFile() == false) goto L16;
        if (r100.delete() == false) goto L16;
        goto L14
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [lu8.a] */
    @JvmStatic
    public static final List<File> b(String r100, boolean r101) {
        if (r100 == null) goto L10;
        int r102 = r100.length();
        boolean r103 = false;
        int r104 = 0;
    L5:
        if (r104 >= r102) goto L10;
        if (Character.isWhitespace(r100.charAt(r104)) == false) goto L11;
        r104 = r104 + 1;
    L11:
        if (r103 == false) goto L13;
        PolarisFileWrapper r105 = null;
    L15:
        return c(r105, new a(), r101);
    L13:
        r105 = new PolarisFileWrapper(r100);
    L10:
        r103 = true;
        goto L11
    }

    public static List c(File r100, a r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "filter");
        if (r100 != null) goto L5;
    L9:
        boolean r103 = false;
    L10:
        if (r103 == true) goto L13;
        return null;
    L13:
        ArrayList r104 = new ArrayList();
        Intrinsics.checkNotNull(r100);
        File[] r105 = r100.listFiles();
        if (r105 != null) goto L16;
    L25:
        return r104;
    L16:
        if (r105.length == 0) goto L25;
        Iterator r106 = ArrayIteratorKt.iterator(r105);
    L19:
        if (r106.hasNext() == false) goto L25;
        File r107 = (File) r106.next();
        Intrinsics.checkNotNull(r107);
        r104.add(r107);
        if (r102 == false) goto L19;
        if (r107.isDirectory() == false) goto L19;
        List r108 = c(r107, r101, true);
        Intrinsics.checkNotNull(r108);
        r104.addAll(r108);
        goto L19
    L5:
        if (r100.exists() == false) goto L9;
        if (r100.isDirectory() == false) goto L9;
        r103 = true;
        goto L10
    }
}
