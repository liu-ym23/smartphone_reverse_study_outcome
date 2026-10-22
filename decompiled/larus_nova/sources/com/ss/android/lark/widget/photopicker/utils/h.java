package com.ss.android.lark.widget.photopicker.utils;

import android.content.Context;
import com.bytedance.bdp.appbase.network.client.BdpOkClient;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.a0;
import java.io.IOException;
import java.util.regex.Pattern;
import kotlin.Unit;

/* JADX INFO: loaded from: classes38.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static znc.e f447659a;

    public static final class a {
        public static znc.e a(Context r100) {
            if (h.f447659a != null) goto L20;
            monitor-enter(j.class);
        L16:
            th = move-exception;
            throw th;
        L7:
            if (h.f447659a == null) goto L23;
        L13:
            Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L16
            monitor-exit(j.class);
            goto L20
        L23:
            PolarisFileWrapper r102 = new PolarisFileWrapper(a0.e(r100));     // Catch: IOException -> L11 Throwable -> L16
            Pattern r103 = znc.e.f573014p;     // Catch: IOException -> L11 Throwable -> L16
            h.f447659a = znc.e.g(r102, 1, 1, BdpOkClient.CACHE_MAX_SIZE, znc.b.a.f573013a);     // Catch: IOException -> L11 Throwable -> L16
        L11:
            e = move-exception;
            Log.e("MediaKVDiskCacheUtils2", "cannot get DiskLruCache", e);     // Catch: Throwable -> L16
        L20:
            return h.f447659a;
        }
    }

    static {
    }
}
