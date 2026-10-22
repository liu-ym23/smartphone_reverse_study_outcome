package com.larus.avlink.e.mock;

import android.util.Base64;
import com.bytedance.android.ec.slice.SliceInitService;
import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f291816a = null;

    static {
        f291816a = new Gson();
    }

    public static b49.g a(CameraDataFrameJson r110) {
        if (r110 != null) goto L48;
        return null;
    L48:
        Integer r100 = r110.getStage();     // Catch: Exception -> L45
        if (r100 == null) goto L8;
        int r101 = r100.intValue();     // Catch: Exception -> L45
    L9:
        Integer r102 = r110.getScene();     // Catch: Exception -> L45
        if (r102 == null) goto L12;
        int r103 = r102.intValue();     // Catch: Exception -> L45
    L13:
        Integer r104 = r110.getId();     // Catch: Exception -> L45
        if (r104 == null) goto L16;
        int r105 = r104.intValue();     // Catch: Exception -> L45
    L17:
        Integer r106 = r110.getType();     // Catch: Exception -> L45
        if (r106 == null) goto L20;
        int r107 = r106.intValue();     // Catch: Exception -> L45
    L21:
        Integer r108 = r110.getSeq();     // Catch: Exception -> L45
        if (r108 == null) goto L24;
        int r109 = r108.intValue();     // Catch: Exception -> L45
    L25:
        Integer r111 = r110.getCount();     // Catch: Exception -> L45
        if (r111 == null) goto L28;
        int r112 = r111.intValue();     // Catch: Exception -> L45
    L29:
        String r113 = r110.getDataBase64();     // Catch: Exception -> L45
        if (r113 == null) goto L33;
        byte[] r114 = Base64.decode(r113, 0);     // Catch: Exception -> L45
        if (r114 == null) goto L33;
    L34:
        byte[] r115 = r114;
        Integer r116 = r110.getAssId();     // Catch: Exception -> L45
        if (r116 == null) goto L37;
        int r117 = r116.intValue();     // Catch: Exception -> L45
    L38:
        String r118 = r110.getAssDataBase64();     // Catch: Exception -> L45
        if (r118 == null) goto L42;
        byte[] r119 = Base64.decode(r118, 0);     // Catch: Exception -> L45
        if (r119 == null) goto L42;
    L43:
        return new b49.g(r101, r103, r105, r107, r109, r112, r115, r117, r119);
    L42:
        r119 = new byte[0];     // Catch: Exception -> L45
        goto L43
    L37:
        r117 = 0;
    L33:
        r114 = new byte[0];     // Catch: Exception -> L45
        goto L34
    L28:
        r112 = 0;
        goto L29
    L24:
        r109 = 0;
        goto L25
    L20:
        r107 = 0;
        goto L21
    L16:
        r105 = 0;
        goto L17
    L12:
        r103 = 1;
        goto L13
    L8:
        r101 = 0;
    L45:
        e = move-exception;
        FLogger.f375446a.e("CameraMockSerializer", "deserializeDataFrame failed", e);
        return null;
    }

    public static b49.h b(CameraImageInfoJson r110) {
        if (r110 != null) goto L22;
        return null;
    L22:
        Integer r100 = r110.getImageUUID();     // Catch: Exception -> L19
        if (r100 == null) goto L8;
        int r101 = r100.intValue();     // Catch: Exception -> L19
    L9:
        Integer r102 = r110.getSide();     // Catch: Exception -> L19
        if (r102 == null) goto L12;
        int r103 = r102.intValue();     // Catch: Exception -> L19
    L13:
        String r104 = r110.getDataBase64();     // Catch: Exception -> L19
        if (r104 == null) goto L16;
        byte[] r105 = Base64.decode(r104, 0);     // Catch: Exception -> L19
    L17:
        return new b49.h(r101, r105, r110.getWidth(), r110.getHeight(), r110.getFormat(), r103, r110.getLinkType(), 0, 0);
    L16:
        r105 = null;
        goto L17
    L12:
        r103 = 1;
        goto L13
    L8:
        r101 = 0;
    L19:
        e = move-exception;
        FLogger.f375446a.e("CameraMockSerializer", "deserializeImageInfo failed", e);
        return null;
    }

    public static String d(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        String r101 = f291816a.toJson(r100);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L5
        return r101;
    L5:
        e = move-exception;
        FLogger.f375446a.e("CameraMockSerializer", "mapToJsonString failed", e);
        return SliceInitService.DEFAULT_SWITCH;
    }

    public static String e(Object r100) {
        String r101 = f291816a.toJson(r100);     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L4
        return r101;
    L4:
        e = move-exception;
        FLogger.f375446a.e("CameraMockSerializer", "toJson failed", e);
        return "";
    }

    public static Object c(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        return f291816a.fromJson(r100, r101);
    L5:
        e = move-exception;
        FLogger.f375446a.e("CameraMockSerializer", "fromJson failed", e);
        return null;
    }
}
