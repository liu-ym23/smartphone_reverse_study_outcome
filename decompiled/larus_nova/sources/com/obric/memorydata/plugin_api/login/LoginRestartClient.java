package com.obric.memorydata.plugin_api.login;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Process;
import com.obric.memorydata.plugin_api.stub.activity.LoginRestartRelayActivity;
import com.volcengine.zeus.util.kv.KVStorage;

/* JADX INFO: loaded from: classes6.dex */
public final class LoginRestartClient {
    private static final String TAG = "LoginRestartClient";

    private static void clearPendingRecordQuietly() {
        KVStorage.INSTANCE.staticKV().erase("memorydata_login_restart_pending_page");     // Catch: RuntimeException -> L4
        return;
    }

    private LoginRestartClient() {
    }

    public static boolean restartAfterLogin(Context r100, String r101) {
        byte[] r102 = LoginRestartPageRecorder.consumeIntentBytes();
        if (r102 != null) goto L5;
    L20:
        clearPendingRecordQuietly();
        return false;
    L5:
        if (r102.length == 0) goto L20;
        long r103 = System.currentTimeMillis();
        int r104 = Process.myPid();
        if (r101 != null) goto L22;
        r101 = "";
    L22:
        Parcel r105 = Parcel.obtain();     // Catch: RuntimeException -> L18
        r105.writeInt(1296847442);     // Catch: Throwable -> L15
        r105.writeInt(1);     // Catch: Throwable -> L15
        r105.writeLong(r103);     // Catch: Throwable -> L15
        r105.writeInt(r104);     // Catch: Throwable -> L15
        r105.writeString(r101);     // Catch: Throwable -> L15
        r105.writeByteArray(r102);     // Catch: Throwable -> L15
        byte[] r106 = r105.marshall();     // Catch: Throwable -> L15
        r105.recycle();     // Catch: RuntimeException -> L18
        KVStorage.INSTANCE.staticKV().storeBytes("memorydata_login_restart_pending_page", r106);     // Catch: RuntimeException -> L18
        Intent r107 = new Intent(r100, LoginRestartRelayActivity.class);     // Catch: RuntimeException -> L18
        r107.addFlags(268435456);     // Catch: RuntimeException -> L18
        r100.startActivity(r107);     // Catch: RuntimeException -> L18
        return true;
    L15:
        th = move-exception;
        r105.recycle();     // Catch: RuntimeException -> L18
        throw th;     // Catch: RuntimeException -> L18
    L18:
        clearPendingRecordQuietly();
        return false;
    }
}
