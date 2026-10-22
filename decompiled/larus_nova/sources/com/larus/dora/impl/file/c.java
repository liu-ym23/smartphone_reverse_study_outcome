package com.larus.dora.impl.file;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.security.MessageDigest;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: classes27.dex */
public final class c {
    public static final String a(PolarisFileWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = okio.s.f524104c;
        Source r102 = Okio.source(r100);
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter("MD5", faceverify.q.KEY_ALGORITHM_CONFIG);
        okio.s r103 = new okio.s(r102, MessageDigest.getInstance("MD5"));
        BufferedSource r104 = Okio.buffer(r103);
        r104.readAll(Okio.blackhole());     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r104, null);
        MessageDigest r105 = r103.f524105a;
        if (r105 == null) goto L8;
        byte[] r106 = r105.digest();
        Intrinsics.checkNotNull(r106);
        return new ByteString(r106).hex();
    L8:
        Intrinsics.checkNotNull(null);
        throw null;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);
        throw th;
    }
}
