package com.dtf.face.utils;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.log.RecordService;
import hs7.a;

/* JADX INFO: loaded from: classes22.dex */
public class ClientConfigUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f273682a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f273683b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f273684c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f273685d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f273686e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f273687f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f273688g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f273689h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f273690i = -1;

    public static int b() {
        int r100 = f273682a;
        if (r100 <= (-1)) goto L5;
        return r100;
    L5:
        f273682a = 15;
        AndroidClientConfig r101 = a.h().c();
        if (r101 == null) goto L16;
        JSONObject r102 = r101.clientExtParams;
        if (r102 == null) goto L16;
        String r103 = r102.getString("ATTR_COLLECT_SIZE");
        if (TextUtils.isEmpty(r103) == true) goto L14;
        f273682a = Integer.parseInt(r103);     // Catch: Throwable -> L17
    L14:
        return f273682a;
    L16:
        return f273682a;
    }

    public static int d() {
        int r100 = f273685d;
        if (r100 == (-1)) goto L5;
        return r100;
    L5:
        AndroidClientConfig r101 = a.h().c();
        if (r101 == null) goto L15;
        JSONObject r102 = r101.clientExtParams;
        if (r102 == null) goto L15;
        f273685d = 2;
        if (r102.containsKey("LOG_UPLOAD_LEVEL") == false) goto L14;
        f273685d = Integer.parseInt(r102.getString("LOG_UPLOAD_LEVEL"));     // Catch: Throwable -> L16
    L14:
        return f273685d;
    L15:
        return 2;
    }

    public static boolean f() {
        String r100 = c("VIDEO_EX_DEVICES");
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains("$" + Build.MODEL + "$") == false) goto L7;
        return true;
    }

    public static boolean g() {
        int r100 = f273687f;
        boolean r101 = false;
        if (r100 == 0) goto L5;
        if (r100 != 1) goto L16;
        return true;
    L16:
        return false;
    L5:
        if (a.h().m() == true) goto L8;
        r101 = !"0".equals(c("NEED_MEMORY_LOG"));
    L8:
        if (r101 == false) goto L10;
        f273687f = 1;
        return r101;
    L10:
        f273687f = -1;
        return r101;
    }

    public static boolean isCfgVideoExDevice() {
        int r100 = f273683b;
        if (r100 != 0) goto L9;
        boolean r101 = f();
        if (r101 == false) goto L7;
        RecordService.getInstance().recordEvent(2, "isVideoExDevice", new String[0]);
        f273683b = 1;
    L12:
        return r101;
    L7:
        f273683b = -1;
        goto L12
    L9:
        if (r100 != 1) goto L13;
        return true;
    L13:
        return false;
    }

    public static boolean needVideoExDegrade() {
        int r100 = f273684c;
        if (r100 != 0) goto L9;
        boolean r101 = e("VIDEO_EX_DEGRADE");
        if (r101 == false) goto L7;
        f273684c = 1;
    L13:
        return r101;
    L7:
        f273684c = -1;
        goto L13
    L9:
        if (r100 == 1) goto L14;
        return false;
    L14:
        return true;
    }

    public static boolean a() {
        AndroidClientConfig r100 = a.h().c();
        if (r100 == null) goto L11;
        JSONObject r101 = r100.clientExtParams;
        if (r101 == null) goto L11;
        if (r101.containsKey("MULTI_PICTURE_COLLECT") == false) goto L11;
        return "true".equals(r101.getString("MULTI_PICTURE_COLLECT"));
    L11:
        return true;
    }

    public ClientConfigUtil() {
    }

    public static String c(String r100) {
        AndroidClientConfig r101 = a.h().c();
        if (r101 == null) goto L11;
        JSONObject r102 = r101.clientExtParams;
        if (r102 != null) goto L8;
        return "";
    L8:
        if (r102.containsKey(r100) == true) goto L10;
        return "";
    L10:
        return r102.getString(r100);
    L11:
        return "";
    }

    public static boolean e(String r100) {
        return "1".equals(c(r100));
    }
}
