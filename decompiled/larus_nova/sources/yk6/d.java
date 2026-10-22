package yk6;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class d implements com.bytedance.livesdk.ktvcommon.download.api.d {
    public d() {
    }

    public static boolean a(File r100) {
        if (r100.isDirectory() == true) goto L5;
        return false;
    L5:
        File[] r101 = r100.listFiles();
        if (r101 != null) goto L8;
        return false;
    L8:
        int r102 = r101.length;
        int r103 = 0;
        boolean r104 = true;
    L9:
        if (r103 >= r102) goto L22;
        File r105 = r101[r103];
        if (r105.isDirectory() == true) goto L13;
        boolean r106 = r105.delete();
    L19:
        if (r106 == true) goto L21;
        r104 = false;
    L21:
        r103 = r103 + 1;
        goto L9
    L13:
        if (a(r105) == true) goto L15;
    L17:
        r106 = false;
        goto L19
    L15:
        if (r105.delete() == false) goto L17;
        r106 = true;
        goto L19
    L22:
        return r104;
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.d
    public final List<com.bytedance.livesdk.ktvcommon.download.model.g> c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "directoryPath");
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        ArrayList r102 = null;
        if (r101.exists() == true) goto L5;
    L12:
        return r102;
    L5:
        if (r101.isDirectory() == false) goto L12;
        File[] r103 = r101.listFiles();
        if (r103 == null) goto L12;
        r102 = new ArrayList(r103.length);
        int r104 = r103.length;
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L12;
        File r106 = r103[r105];
        r102.add(new com.bytedance.livesdk.ktvcommon.download.model.g(r106.getAbsolutePath(), r106.lastModified()));
        r105 = r105 + 1;
        goto L10
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.d
    public final boolean g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L7;
        return false;
    L7:
        if (r101.isFile() == false) goto L10;
        return r101.delete();
    L10:
        return a(r101);
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.d
    public final boolean h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "directoryPath");
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L6;
        return r101.isDirectory();
    L6:
        return r101.mkdirs();
    }

    @Override // com.bytedance.livesdk.ktvcommon.download.api.d
    public final boolean i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "directoryPath");
        return new PolarisFileWrapper(r100).exists();
    }
}
