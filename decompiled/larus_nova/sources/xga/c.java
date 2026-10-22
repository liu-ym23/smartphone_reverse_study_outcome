package xga;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f563835a = null;

    static {
        f563835a = new c();
    }

    public c() {
    }

    public final void update(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L34
        PolarisFileWrapper r103 = new PolarisFileWrapper(new PolarisFileWrapper(r100.getFilesDir(), "obric_early_settings"), "zeus_plugin_process_short_circuit_v1");     // Catch: Throwable -> L34
        if (r101 == false) goto L26;
        File r104 = r103.getParentFile();     // Catch: Throwable -> L34
        boolean r105 = false;
        if (r104 != null) goto L8;
    L12:
        boolean r106 = false;
    L13:
        if (r106 == false) goto L24;
        if (r103.exists() == false) goto L17;
    L18:
        r105 = true;
    L19:
        if (r105 == false) goto L22;
    L32:
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L37:
        if (Result.m9456isSuccessimpl(r107) == false) goto L40;
        Unit r108 = (Unit) r107;
    L40:
        if (Result.m9452exceptionOrNullimpl(r107) != null) goto L42;
        return;
    L42:
        return;
    L22:
        throw new IllegalStateException("create Settings snapshot failed".toString());     // Catch: Throwable -> L34
    L17:
        if (r103.createNewFile() == false) goto L19;
    L24:
        throw new IllegalStateException("create Settings snapshot directory failed".toString());     // Catch: Throwable -> L34
    L8:
        if (r104.exists() == false) goto L10;
    L11:
        r106 = true;
        goto L13
    L10:
        if (r104.mkdirs() == false) goto L12;
    L26:
        if (r103.exists() == false) goto L32;
        if (r103.delete() == true) goto L32;
        throw new IllegalStateException("delete Settings snapshot failed".toString());     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L37
    }
}
