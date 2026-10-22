package com.bytedance.ee.lark.infra.file;

import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.lark.open_app_android.c;
import com.bytedance.lark.open_app_android.j;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.lark.android.encryption.exception.DecryptException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public class Stats {
    private static final String TAG = "Stats";
    private int lastAccessedTime;
    private int lastModifiedTime;
    private int mode;
    private long size;

    public Stats() {
    }

    public long getLastAccessedTime() {
        return this.lastAccessedTime;
    }

    public long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L4
        r100.put("mode", this.mode);     // Catch: Exception -> L4
        r100.put("size", this.size);     // Catch: Exception -> L4
        r100.put("lastAccessedTime", this.lastAccessedTime);     // Catch: Exception -> L4
        r100.put("lastModifiedTime", this.lastModifiedTime);     // Catch: Exception -> L4
        return r100;
    L4:
        e = move-exception;
        AppBrandLogger.stacktrace(6, TAG, e.getStackTrace());
        return null;
    }

    public int getMode() {
        return this.mode;
    }

    public long getSize() {
        return this.size;
    }

    public static Stats getEncryptFileStats(VFSPath r100) throws DecryptException {
        long r101 = com.suite.lark.component.storage.ext.b.e(r100);
        Stats r102 = getFileStats(r100.getAbsolutePath());
        r102.size = r101;
        return r102;
    }

    public static Stats getFileStats(String r100) {
        if (com.bytedance.ee.lark.infra.foundation.utils.a.a(r100).exists() == true) goto L10;
        return null;
    L10:
        c r101 = j.a(r100);     // Catch: Exception -> L7
        Stats r102 = new Stats();     // Catch: Exception -> L7
        r102.mode = r101.a().mode.intValue();     // Catch: Exception -> L7
        r102.size = r101.a().size.longValue();     // Catch: Exception -> L7
        r102.lastAccessedTime = r101.a().last_accessed_time.intValue();     // Catch: Exception -> L7
        r102.lastModifiedTime = r101.a().last_modified_time.intValue();     // Catch: Exception -> L7
        return r102;
    L7:
        e = move-exception;
        AppBrandLogger.e(TAG, new Object[]{"getFileStats error", e});
        return null;
    }
}
