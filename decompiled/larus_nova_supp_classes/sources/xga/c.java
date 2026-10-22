package xga;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final void update(Context r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L34
        PolarisFileWrapper r1 = new PolarisFileWrapper(new PolarisFileWrapper(r4.getFilesDir(), "obric_early_settings"), "zeus_plugin_process_short_circuit_v1");     // Catch: Throwable -> L34
        if (r5 == false) goto L26;
        File r6 = r1.getParentFile();     // Catch: Throwable -> L34
        boolean r7 = false;
        if (r6 != null) goto L8;
    L12:
        boolean r8 = false;
    L13:
        if (r8 == false) goto L24;
        if (r1.exists() == false) goto L17;
    L18:
        r7 = true;
    L19:
        if (r7 == false) goto L22;
    L32:
        Object r9 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L37:
        if (Result.m56isSuccessimpl(r9) == false) goto L40;
        Unit r10 = (Unit) r9;
    L40:
        if (Result.m52exceptionOrNullimpl(r9) != null) goto L42;
        return;
    L42:
        return;
    L22:
        throw new IllegalStateException("create Settings snapshot failed".toString());     // Catch: Throwable -> L34
    L17:
        if (r1.createNewFile() == false) goto L19;
    L24:
        throw new IllegalStateException("create Settings snapshot directory failed".toString());     // Catch: Throwable -> L34
    L8:
        if (r6.exists() == false) goto L10;
    L11:
        r8 = true;
        goto L13
    L10:
        if (r6.mkdirs() == false) goto L12;
    L26:
        if (r1.exists() == false) goto L32;
        if (r1.delete() == true) goto L32;
        throw new IllegalStateException("delete Settings snapshot failed".toString());     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L37
    }
}
