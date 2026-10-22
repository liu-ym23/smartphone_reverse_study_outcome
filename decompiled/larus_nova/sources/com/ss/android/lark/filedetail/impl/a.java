package com.ss.android.lark.filedetail.impl;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.MediaStoreUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f421547a = null;

    static {
        f421547a = new byte[]{5, 69, 69, 83, 0, 0, 0, 0};
    }

    @JvmStatic
    public static final String a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        StringBuilder r102 = new StringBuilder();
        Set<String> r103 = MediaStoreUtil.f285910a;
        MediaStoreUtil.DirType r104 = MediaStoreUtil.DirType.DOWNLOADS;
        Intrinsics.checkNotNullParameter(r104, "dirType");
        r102.append(new PolarisFileWrapper(Environment.getExternalStoragePublicDirectory(r104.getValue()), "Lark").getAbsolutePath());
        r102.append(File.separator);
        String r105 = r102.toString();
        ArrayList r106 = new ArrayList();
        if (TextUtils.isEmpty(r101) == true) goto L9;
        String[] r107 = new PolarisFileWrapper(r105).list(new com.larksuite.framework.utils.k(FileUtils.n(r101), FileUtils.m(r101)));
        if (r107 == null) goto L9;
        r106.addAll(Arrays.asList(r107));
    L9:
        if (r106.size() == 0) goto L27;
        Collections.sort(r106);
        String r108 = FileUtils.n(r101);
        String r109 = FileUtils.m(r101);
        String r110 = FileUtils.n((String) ListProtector.get(r106, r106.size() - 1)).substring(r108.length());
    L16:
        e = move-exception;
        e.printStackTrace();
    L18:
        int r111 = 0;
    L19:
        int r112 = r111 + 1;
        if (r112 != 0) goto L22;
        String r113 = "";
    L24:
        return r105 + r108 + r113 + r109;
    L22:
        r113 = "_" + r112;
        goto L24
    L13:
        if (TextUtils.isEmpty(r110) == true) goto L18;
        r111 = CastIntegerProtector.parseInt(r110.substring(1, r110.length()));     // Catch: Exception -> L16
        goto L19
    L27:
        return r105 + r101;
    }
}
