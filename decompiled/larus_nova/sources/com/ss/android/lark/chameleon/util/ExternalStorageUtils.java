package com.ss.android.lark.chameleon.util;

import android.os.Environment;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.idependency.Log;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleon/util/ExternalStorageUtils;", "", "()V", "TAG", "", "getExternalStoragePath", "Ljava/io/File;", "dirName", "getFileNameFromPath", "filePath", "getUniqueFileNameWithNumber", "fileName", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ExternalStorageUtils {
    public static final ExternalStorageUtils INSTANCE = null;
    private static final String TAG = "ExternalStorageUtils";

    static {
        INSTANCE = new ExternalStorageUtils();
    }

    private ExternalStorageUtils() {
    }

    private final File getExternalStoragePath(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(Environment.getExternalStorageDirectory().toString() + File.separator + r100);
        if (r101.exists() == true) goto L5;
        r101.mkdirs();
    L5:
        return r101;
    }

    @JvmStatic
    public static final String getFileNameFromPath(String r100) {
        if (r100 == null) goto L27;
        String r101 = StringsKt.trim(r100).toString();     // Catch: Exception -> L24
        if (r101 == null) goto L28;
        boolean r102 = true;
        if (r101.length() != 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        return null;
    L13:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101);     // Catch: Exception -> L24
        if (StringsKt.isBlank(r104.getName()) == false) goto L16;
        return null;
    L16:
        String r105 = StringsKt.trim(r104.getName()).toString();     // Catch: Exception -> L24
        if (r105.length() == 0) goto L20;
        r102 = false;
    L20:
        if (r102 == false) goto L23;
        return null;
    L23:
        return r105;
    L10:
        r103 = false;
        goto L11
    L28:
        return null;
    L30:
        return null;
    L27:
        return null;
    }

    @JvmStatic
    public static final String getUniqueFileNameWithNumber(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "dirName");
        Intrinsics.checkNotNullParameter(r111, "fileName");
        String r112 = new Regex(PatternProtector.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]")).replace(r111, "_");
        File r113 = INSTANCE.getExternalStoragePath(r110);     // Catch: Exception -> L28
        if (r113.mkdirs() == false) goto L6;
    L9:
        PolarisFileWrapper r100 = new PolarisFileWrapper(r113, r112);     // Catch: Exception -> L28
        Integer r101 = Integer.valueOf(StringsKt.lastIndexOf$default(r112, '.', 0, false, 6, null));     // Catch: Exception -> L28
        int r102 = 0;
        if (r101.intValue() < 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == true) goto L16;
        r101 = null;
    L16:
        if (r101 == null) goto L18;
        int r104 = r101.intValue();     // Catch: Exception -> L28
    L19:
        String r105 = r112;
    L21:
        if (r100.exists() == false) goto L24;
        if (r102 >= 100) goto L24;
        r102 = r102 + 1;     // Catch: Exception -> L28
        StringBuilder r106 = new StringBuilder(r112);     // Catch: Exception -> L28
        StringBuilder r107 = new StringBuilder();     // Catch: Exception -> L28
        r107.append('(');     // Catch: Exception -> L28
        r107.append(r102);     // Catch: Exception -> L28
        r107.append(')');     // Catch: Exception -> L28
        r105 = r106.insert(r104, r107.toString()).toString();     // Catch: Exception -> L28
        r100 = new PolarisFileWrapper(r113, r105);     // Catch: Exception -> L28
    L24:
        if (r102 < 100) goto L26;
        Log.w(TAG, "failed maxRetryCount 100 ");     // Catch: Exception -> L28
        StringBuilder r114 = new StringBuilder(r112);     // Catch: Exception -> L28
        StringBuilder r108 = new StringBuilder();     // Catch: Exception -> L28
        r108.append('(');     // Catch: Exception -> L28
        r108.append(100);     // Catch: Exception -> L28
        r108.append(')');     // Catch: Exception -> L28
        r105 = r114.insert(r104, r108.toString()).toString();     // Catch: Exception -> L28
    L26:
        Log.i(TAG, "new file name ：" + r105 + "，count：" + r102);     // Catch: Exception -> L28
        return r105;
    L18:
        r104 = r112.length();     // Catch: Exception -> L28
        goto L19
    L12:
        r103 = false;
        goto L13
    L6:
        if (r113.exists() == true) goto L9;
        Log.i(TAG, " use default legal file name：" + r113.getAbsolutePath());     // Catch: Exception -> L28
        return r112;
    L28:
        e = move-exception;
        Log.e(TAG, "error:", e);
        return r112;
    }
}
