package com.bytedance.kmp.ec.yata.common.platform;

import android.net.Uri;
import android.util.Base64;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(message = "SDK内部工具类")
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f251540a = 0;

    static {
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        Writer r102 = new OutputStreamWriter(new GZIPOutputStream(r101, 32768), StandardCharsets.UTF_8);
        if ((r102 instanceof BufferedWriter) == false) goto L5;
        BufferedWriter r103 = (BufferedWriter) r102;
    L14:
        r103.write(r100);     // Catch: Throwable -> L9
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r103, null);
        return Base64.encodeToString(r101.toByteArray(), 0);
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L5:
        r103 = new BufferedWriter(r102, 32768);
        goto L14
    }

    public static String a(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        if (r101 == null) goto L9;
        Iterator r103 = r101.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.appendQueryParameter((String) r104.getKey(), (String) r104.getValue());
    L9:
        return r102.build().toString();
    }
}
