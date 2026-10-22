package com.obric.assistant.reporter;

import android.content.Context;
import by7.g;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f391351a = 0;

    static {
    }

    public static void a(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110.getFilesDir(), "obric_dialog_click_cache.txt");     // Catch: Exception -> L28
        if (r100.exists() == false) goto L30;
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: Exception -> L28
        FileChannel r102 = r101.getChannel();     // Catch: Throwable -> L23
        FileLock r103 = r102.lock(0, Long.MAX_VALUE, true);     // Catch: Throwable -> L18
        byte[] r104 = new byte[(int) r102.size()];     // Catch: Throwable -> L15
        r101.read(r104);     // Catch: Throwable -> L15
        String r105 = new String(r104, Charsets.UTF_8);     // Catch: Throwable -> L15
        r103.release();     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r102, null);     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r101, null);     // Catch: Exception -> L28
    L31:
        String r106 = r105;
        if (StringsKt.isBlank(r106) == false) goto L34;
        return;
    L34:
        Iterator r107 = StringsKt.split$default(r106, new String[]{"\n"}, false, 0, 6, null).iterator();
    L36:
        if (r107.hasNext() == false) goto L84;
        String r108 = StringsKt.trim((String) r107.next()).toString();
        if (r108.length() != 0) goto L40;
        boolean r109 = true;
    L41:
        if (r109 == true) goto L36;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L44
        JSONObject r112 = new JSONObject(r108);     // Catch: Throwable -> L44
        g.f21473d.onEvent("obric_dialog_click", r112);     // Catch: Throwable -> L44
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L36;
        r114.toString();
    L44:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L46
    L40:
        r109 = false;
        goto L41
    L84:
        PolarisFileWrapper r116 = new PolarisFileWrapper(r110.getFilesDir(), "obric_dialog_click_cache.txt");     // Catch: Exception -> L74
        if (r116.exists() == false) goto L102;
        RandomAccessFile r117 = new RandomAccessFile(r116, "rw");     // Catch: Exception -> L74
        FileChannel r118 = r117.getChannel();     // Catch: Throwable -> L69
        FileLock r119 = r118.lock();     // Catch: Throwable -> L64
        r118.truncate(0);     // Catch: Throwable -> L61
        r117.getFD().sync();     // Catch: Throwable -> L61
        r119.release();     // Catch: Throwable -> L64
        Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L64
        CloseableKt.closeFinally(r118, null);     // Catch: Throwable -> L69
        CloseableKt.closeFinally(r117, null);     // Catch: Exception -> L74
        return;
    L61:
        th = move-exception;
        r119.release();     // Catch: Throwable -> L64
        throw th;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        throw th;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        CloseableKt.closeFinally(r118, th);     // Catch: Throwable -> L69
        throw th;     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        throw th;     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        CloseableKt.closeFinally(r117, th);     // Catch: Exception -> L74
        throw th;     // Catch: Exception -> L74
    L102:
        return;
    L74:
        e = move-exception;
        e.toString();
        return;
    L15:
        th = move-exception;
        r103.release();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);     // Catch: Exception -> L28
        throw th;     // Catch: Exception -> L28
    L30:
        r105 = "";
    L28:
        e = move-exception;
        e.toString();
        goto L30
    }
}
