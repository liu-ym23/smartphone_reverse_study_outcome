package com.ss.android.lark.diskmanage.storage;

import android.content.Context;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.FileUtils;
import com.larksuite.framework.utils.l;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@Deprecated(message = "direct native path is not allowed, plz use LarkFileStorage instead", replaceWith = @ReplaceWith(expression = "LarkFileStorage", imports = {}))
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f420488a = 0;

    static {
    }

    public static String a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = l.b(r100) + "/avatar/";
        FileUtils.t(r101);
        return r101;
    }

    public static String b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = l.a(r100) + "/download/";
        FileUtils.t(r101);
        return r101;
    }

    public static String c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = r100.getFilesDir().getPath();
        Intrinsics.checkNotNull(r101);
        return r101.substring(0, StringsKt.lastIndexOf$default(r101, HTTP.URL_DEFAULT, 0, false, 6, null)) + "/databases/";
    }

    public static String d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = l.b(r100) + "/drive/";
        FileUtils.t(r101);
        return r101;
    }

    public static String e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = l.b(r100) + "/picture/";
        FileUtils.t(r101);
        return r101;
    }

    public static String f(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = l.a(r100) + "/glide_cache/";
        FileUtils.t(r101);
        return r101;
    }

    public static String g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = l.a(r100) + "/image_cache/";
        FileUtils.t(r101);
        return r101;
    }

    public static String h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = l.a(r100) + "/image_compressed/";
        FileUtils.t(r101);
        return r101;
    }

    public static String i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        File r101 = r100.getCacheDir();
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.getPath();
    }

    public static String j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        File r101 = r100.getFilesDir();
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.getPath();
    }

    public static String k(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (DevEnvUtil.isDevelopPackage(r100) == false) goto L6;
        return o(r100);
    L6:
        return n(r100);
    }

    public static String l(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = l.d(r100) + "/Lark/";
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101);
        if (r102.exists() == true) goto L5;
        r102.mkdir();
    L5:
        return r101;
    }

    public static String m(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        File r101 = r100.getExternalCacheDir();
        if (r101 != null) goto L7;
        return "";
    L7:
        return r101.getPath();
    }

    public static String n(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return l.c(r100) + "/Journal/";
    }

    public static String o(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return l.b(r100) + "/Journal/";
    }

    public static String p(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = c(r100) + "sdk_storage/";
        FileUtils.t(r101);
        return r101;
    }

    public static String q(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = l.a(r100) + "/share_temp/";
        FileUtils.t(r101);
        return r101;
    }

    public static String r(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = l.a(r100) + "/update/";
        FileUtils.t(r101);
        return r101;
    }

    public static String s(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = l.a(r100) + "/video_cache/";
        FileUtils.t(r101);
        return r101;
    }
}
