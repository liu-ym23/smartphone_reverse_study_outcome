package com.ss.lark.android.encryption.utils;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import ikc.f;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class b {
    public static final void a(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L5
        r101.put("tag", "stream_exception");     // Catch: Exception -> L5
        r101.put("scene", "open");     // Catch: Exception -> L5
        r101.put("msg", r100.getMessage());     // Catch: Exception -> L5
        f.f490295a.f490294c.sendEvent("disk_file_cipher_error");     // Catch: Exception -> L5
        return;
    }

    public static final void b(String r100, ErrorResult r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "path");
        if (r110 == null) goto L8;
        Log.e("ScsFileLock", "openFile: " + r100 + ", error: " + r110.getDebugMsg());
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L7
        r101.put("tag", "stream");     // Catch: Exception -> L7
        r101.put("scene", "open");     // Catch: Exception -> L7
        r101.put("msg", r100 + ' ' + r110);     // Catch: Exception -> L7
        f.f490295a.f490294c.sendEvent("disk_file_cipher_error");     // Catch: Exception -> L7
    L8:
        if (r111 == 0) goto L16;
        JSONObject r112 = new JSONObject();     // Catch: Exception -> L11
        r112.put("tag", "stream");     // Catch: Exception -> L11
        r112.put("scene", "open");     // Catch: Exception -> L11
        r112.put("msg", r100);     // Catch: Exception -> L11
        r112.put("error_code", r111);     // Catch: Exception -> L11
        f.f490295a.f490294c.sendEvent("disk_file_cipher_error");     // Catch: Exception -> L11
        return;
    L17:
        return;
    }
}
