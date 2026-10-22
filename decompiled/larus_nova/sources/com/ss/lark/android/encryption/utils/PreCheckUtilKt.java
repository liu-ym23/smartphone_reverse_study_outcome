package com.ss.lark.android.encryption.utils;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class PreCheckUtilKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f456819a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f456820b = null;

    static {
        f456819a = LazyKt.lazy(PreCheckUtilKt$MAGIC_1$2.INSTANCE);
        f456820b = LazyKt.lazy(PreCheckUtilKt$MAGIC_2$2.INSTANCE);
    }

    public static final Map<String, byte[]> b(byte[] r100) {
        HashMap r101 = new HashMap(16);
        Section[] r102 = Section.values();
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r103) goto L5;
        Section r106 = r102[r104];
        int r107 = r106.getLength() + r105;
        r101.put(r106.name(), ArraysKt.copyOfRange(r100, r105, r107));
        r105 = r105 + r106.getLength();
        r104 = r104 + 1;
        goto L3
    L5:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [long] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static final Map<String, byte[]> c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        ?? r102 = r101.length();
        Map<String, byte[]> r103 = null;
        if (r102 >= 96) goto L27;
        return null;
    L27:
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r101);     // Catch: Throwable -> L11 Exception -> L13
    L25:
        byte[] r105 = new byte[96];     // Catch: Exception -> L9 Throwable -> L19
        r104.read(r105);     // Catch: Exception -> L9 Throwable -> L19
        r103 = b(r105);     // Catch: Exception -> L9 Throwable -> L19
        r102 = r104;
    L8:
        r102.close();
    L18:
        return r103;
    L9:
        e = e;
    L15:
        Log.e("ScsFileLock", String.valueOf(e.getMessage()));     // Catch: Throwable -> L19
        r102 = r104;
        if (r104 == null) goto L18;
    L13:
        e = e;
        r104 = null;
    L11:
        th = move-exception;
        r102 = 0;
        th = th;
    L20:
        if (r102 == 0) goto L22;
        r102.close();
    L22:
        throw th;
    L19:
        th = th;
        goto L20
    }

    public static final boolean a(String r100, Map<String, byte[]> r101) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        if (r101 != null) goto L6;
        r101 = c(r100);
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L15;
        return false;
    L15:
        if (Arrays.equals(r101.get("MAGIC_1"), (byte[]) f456819a.getValue()) == true) goto L17;
    L19:
        return false;
    L17:
        if (Arrays.equals(r101.get("MAGIC_2"), (byte[]) f456820b.getValue()) == false) goto L19;
        return true;
    L8:
        if (r101.isEmpty() == true) goto L11;
        r102 = false;
        goto L12
    }
}
