package com.bytedance.pia.core.worker;

import android.content.Context;
import android.text.TextUtils;
import c47.c;
import com.bytedance.pia.core.utils.StreamUtils;
import com.bytedance.pia.core.utils.d;
import com.larus.nova.R;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public class Polyfill {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f266403a = null;

        static {
            f266403a = Polyfill.a();
        }
    }

    public Polyfill() {
    }

    public static String a() {
        Context r100 = c.a.f22405a;
        if (r100 != null) goto L5;
        return null;
    L5:
        long r101 = System.currentTimeMillis();
        InputStream r102 = r100.getResources().openRawResource(R.raw.pia_worker_polyfill);     // Catch: Throwable -> L8
        int r103 = StreamUtils.f266377a;     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r102, "<this>");     // Catch: Throwable -> L8
        String r104 = StreamUtils.b(r102, "");     // Catch: Throwable -> L8
    L10:
        d.i("[Worker] load worker polyfill success, cost: " + (System.currentTimeMillis() - r101));
        if (TextUtils.isEmpty(r104) == true) goto L13;
        return r104;
    L13:
        return null;
    L8:
        th = move-exception;
        d.d("[Worker] load worker polyfill error:", th);
        r104 = null;
        goto L10
    }

    public static String buildPolyfillForTesting() {
        return a();
    }
}
