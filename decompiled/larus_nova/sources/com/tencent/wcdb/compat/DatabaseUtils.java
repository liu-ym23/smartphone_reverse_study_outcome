package com.tencent.wcdb.compat;

import android.os.CancellationSignal;
import com.tencent.wcdb.core.Handle;

/* JADX INFO: loaded from: classes40.dex */
public final class DatabaseUtils {
    private DatabaseUtils() {
    }

    public static void bindCancellationSignal(Handle r100, CancellationSignal r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        final Handle.CancellationSignal r102 = new Handle.CancellationSignal();
        r101.setOnCancelListener(new AnonymousClass1(r102));
        if (r101.isCanceled() == false) goto L7;
        r102.cancel();
    L7:
        r100.attachCancellationSignal(r102);
    }

    public static long longForQuery(SQLiteDatabase r100, String r101, Object[] r102) {
        SQLiteStatement r103 = r100.compileStatement(r101);
        r103.bindAllArgs(r102);     // Catch: Throwable -> L6
        long r104 = r103.simpleQueryForLong();     // Catch: Throwable -> L6
        r103.close();
        return r104;
    L6:
        th = move-exception;
        if (r103 != null) goto L13;
    L12:
        throw th;
    L13:
        r103.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.addSuppressed(th);
        goto L12
    }

    public static String stringForQuery(SQLiteDatabase r100, String r101, Object[] r102) {
        SQLiteStatement r103 = r100.compileStatement(r101);
        r103.bindAllArgs(r102);     // Catch: Throwable -> L6
        String r104 = r103.simpleQueryForString();     // Catch: Throwable -> L6
        r103.close();
        return r104;
    L6:
        th = move-exception;
        if (r103 != null) goto L13;
    L12:
        throw th;
    L13:
        r103.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.addSuppressed(th);
        goto L12
    }
}
