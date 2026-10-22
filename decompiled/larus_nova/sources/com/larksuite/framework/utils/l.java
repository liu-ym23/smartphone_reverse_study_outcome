package com.larksuite.framework.utils;

import android.content.Context;
import android.os.Environment;
import com.larksuite.framework.utils.file.direct.DirectFileAccess;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class l {
    public static String a(Context r110) {
        int r100 = DirectFileAccess.a.f285968i;
        DirectFileAccess.a.C3931a r101 = new DirectFileAccess.a.C3931a();
        r101.f285980d = r110;
        r101.f285978b = DirectFileAccess.StorageLocation.EXTERNAL;
        r101.f285979c = DirectFileAccess.PathType.CACHE;
        DirectFileAccess.c r102 = DirectFileAccess.f285961a;
        Intrinsics.checkNotNullParameter(r101, "paramsBuilder");
        File r103 = DirectFileAccess.a(new DirectFileAccess.a(r101.f285977a, r101.f285978b, r101.f285979c, null, r101.f285980d, r101.f285981e, r101.f285982f, null));
        if (r103 != null) goto L5;
        r103 = r110.getCacheDir();
    L5:
        if (r103 != null) goto L9;
        return "";
    L9:
        return r103.getPath();
    }

    public static String b(Context r110) {
        int r100 = DirectFileAccess.a.f285968i;
        DirectFileAccess.a.C3931a r101 = new DirectFileAccess.a.C3931a();
        r101.f285980d = r110;
        r101.f285978b = DirectFileAccess.StorageLocation.EXTERNAL;
        r101.f285979c = DirectFileAccess.PathType.FILES;
        DirectFileAccess.c r102 = DirectFileAccess.f285961a;
        Intrinsics.checkNotNullParameter(r101, "paramsBuilder");
        File r103 = DirectFileAccess.a(new DirectFileAccess.a(r101.f285977a, r101.f285978b, r101.f285979c, null, r101.f285980d, r101.f285981e, r101.f285982f, null));
        if (r103 != null) goto L5;
        r103 = r110.getFilesDir();
    L5:
        if (r103 != null) goto L9;
        return "";
    L9:
        return r103.getPath();
    }

    public static String c(Context r100) {
        File r101 = r100.getFilesDir();
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.getPath();
    }

    public static String d(Context r100) {
        if (Environment.getExternalStorageState().equals("mounted") == false) goto L5;
        File r101 = Environment.getExternalStorageDirectory();
    L6:
        if (r101 != null) goto L8;
        r101 = r100.getFilesDir();
    L8:
        if (r101 != null) goto L12;
        return "";
    L12:
        return r101.getPath();
    L5:
        r101 = null;
        goto L6
    }
}
