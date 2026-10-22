package okio;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public class w extends l {
    public String toString() {
        return "JvmSystemFileSystem";
    }

    public w() {
    }

    @Override // okio.l
    public final List<b0> b(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        List<b0> r101 = f(r100, true);
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    @Override // okio.l
    public final List<b0> c(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_DIR);
        return f(r100, false);
    }

    @Override // okio.l
    public k d(b0 r110) {
        Intrinsics.checkNotNullParameter(r110, "path");
        r110.getClass();
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110.toString());
        boolean r101 = r100.isFile();
        boolean r102 = r100.isDirectory();
        long r103 = r100.lastModified();
        long r104 = r100.length();
        if (r101 == true) goto L14;
        if (r102 == true) goto L14;
        if (r103 != 0) goto L14;
        if (r104 != 0) goto L14;
        if (r100.exists() == true) goto L14;
        return null;
    L14:
        return new k(r101, r102, null, Long.valueOf(r104), null, Long.valueOf(r103), null);
    }

    @Override // okio.l
    public final j e(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        r100.getClass();
        return new v(new RandomAccessFile(new PolarisFileWrapper(r100.toString()), "r"));
    }

    @Override // okio.l
    public void delete(b0 r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        if (Thread.interrupted() == true) goto L16;
        r100.getClass();
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.toString());
        if (r102.delete() == false) goto L7;
        return;
    L7:
        if (r102.exists() == true) goto L13;
        if (r101 == true) goto L11;
        return;
    L11:
        throw new FileNotFoundException("no such file: " + r100);
    L13:
        throw new IOException("failed to delete " + r100);
    L16:
        throw new InterruptedIOException("interrupted");
    }

    public final List<b0> f(b0 r100, boolean r101) {
        r100.getClass();
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.toString());
        String[] r103 = r102.list();
        if (r103 != null) goto L13;
        if (r101 == true) goto L6;
        return null;
    L6:
        if (r102.exists() == true) goto L10;
        throw new FileNotFoundException("no such file: " + r100);
    L10:
        throw new IOException("failed to list " + r100);
    L13:
        ArrayList r104 = new ArrayList();
        int r105 = r103.length;
        int r106 = 0;
    L14:
        if (r106 >= r105) goto L16;
        String r107 = r103[r106];
        Intrinsics.checkNotNull(r107);
        r104.add(r100.c(r107));
        r106 = r106 + 1;
        goto L14
    L16:
        CollectionsKt.sort(r104);
        return r104;
    }
}
