package com.ss.android.lark.utils;

import android.content.Context;
import android.text.TextUtils;
import com.larksuite.framework.utils.FileUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a0 {
    public static String d(Context r100) {
        int r101 = com.ss.android.lark.diskmanage.storage.d.f420488a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = com.ss.android.lark.diskmanage.storage.d.k(r100) + "log/";
        FileUtils.t(r102);
        return r102;
    }

    public static String e(Context r100) {
        int r101 = com.ss.android.lark.diskmanage.storage.d.f420488a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = com.larksuite.framework.utils.l.a(r100) + "/media_support_compress/";
        FileUtils.t(r102);
        return r102;
    }

    public static String f(Context r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(com.ss.android.lark.diskmanage.storage.d.j(r100));
        String r102 = File.separator;
        r101.append(r102);
        r101.append("rust_avatar");
        r101.append(r102);
        return r101.toString();
    }

    public static String g(Context r100) {
        int r101 = com.ss.android.lark.diskmanage.storage.d.f420488a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = com.larksuite.framework.utils.l.a(r100) + "/picture/rust/";
        FileUtils.t(r102);
        return r102;
    }

    public static String a(Context r100, String r101) {
        int r102 = com.ss.android.lark.diskmanage.storage.d.f420488a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "filename");
        String r103 = com.ss.android.lark.diskmanage.storage.d.a(r100) + r101;
        if (FileUtils.r(r103) == true) goto L7;
        return "";
    L7:
        return r103;
    }

    public static int b(String r100, String r101, int r102) {
        FileType r103 = FileType.TYPE_UNKNOWN;
        if (TextUtils.isEmpty(r100) == true) goto L5;
        FileType r104 = FileType.getFileTypeByMime(r100);
    L6:
        if (r104 != r103) goto L13;
        if (TextUtils.isEmpty(r101) == true) goto L13;
        String r105 = FileUtils.m(r101);
        if (TextUtils.isEmpty(r105) == true) goto L13;
        r104 = FileType.getFileTypeBySuffix(r105);
    L13:
        return r104.getResId(r102);
    L5:
        r104 = r103;
        goto L6
    }

    public static int c(String r100, String r101, boolean r102) {
        if (r102 == false) goto L7;
        return FileType.TYPE_FOLDER.getResId(1);
    L7:
        return b(r100, r101, 1);
    }
}
