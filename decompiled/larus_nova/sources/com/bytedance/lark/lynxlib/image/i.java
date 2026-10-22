package com.bytedance.lark.lynxlib.image;

import android.os.Build;
import android.text.TextUtils;
import com.bumptech.glide.load.model.GlideUrl;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f253278a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f253279b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f253280c = null;

    static {
        f253278a = new AtomicInteger(0);
        f253279b = new AtomicInteger(0);
        f253280c = new AtomicInteger(0);
    }

    public static Object a(String r100) {
        boolean r101 = true;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L9:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L20;
        if (f253280c.getAndIncrement() < 3) goto L16;
        r101 = false;
    L16:
        if (r101 == false) goto L18;
        Log.i("LynxImageUaUtils", "skip inject ua (non-http), src=" + b(r100));
    L18:
        return r100;
    L20:
        if (idb.f.a().isEnable("lark.workplace.image_lark_ua_force_enable") == true) goto L29;
        if (f253279b.getAndIncrement() < 3) goto L25;
        r101 = false;
    L25:
        if (r101 == false) goto L27;
        Log.i("LynxImageUaUtils", "skip inject ua (fg disabled), src=" + b(r100));
    L27:
        return r100;
    L29:
        if (f253278a.getAndIncrement() < 3) goto L32;
        r101 = false;
    L32:
        if (r101 == false) goto L34;
        Log.i("LynxImageUaUtils", "inject lark ua for image request, src=" + b(r100));
    L34:
        final HashMap r103 = new HashMap();
        r103.put("User-Agent", "Mozilla/5.0 (Android; Lark) " + Build.BRAND + ' ' + Build.MODEL);
        return new GlideUrl(r100, new h(r103));
    L5:
        if (r100.startsWith("http://") == false) goto L7;
    L8:
        r102 = true;
        goto L11
    L7:
        if (r100.startsWith("https://") == false) goto L9;
        goto L8
    }

    public static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        int r101 = Math.min(r100.length(), 80);
        String r102 = r100.substring(0, r101);
        if (r100.length() > r101) goto L9;
        return r102;
    L9:
        return r102 + "...";
    }
}
