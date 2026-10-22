package com.obric.memorydata.plugin_api.login;

import android.content.Intent;
import android.os.Parcel;
import com.volcengine.zeus.util.kv.IKVStore;
import com.volcengine.zeus.util.kv.KVStorage;
import mka.a;
import mka.b;

/* JADX INFO: loaded from: classes33.dex */
public final class LoginRestartRelayProtocol {

    public static final class RestoreRequest {
        private final Intent intent;
        private final int sourcePid;

        public Intent getIntent() {
            return this.intent;
        }

        public int getSourcePid() {
            return this.sourcePid;
        }

        public RestoreRequest(int r100, Intent r101) {
            this.sourcePid = r100;
            this.intent = r101;
        }
    }

    public static RestoreRequest consume() {
        IKVStore r100 = KVStorage.INSTANCE.staticKV();
        byte[] r101 = r100.getBytes("memorydata_login_restart_pending_page", b.f514351a);     // Catch: Throwable -> L39
        r100.erase("memorydata_login_restart_pending_page");
        Intent r102 = null;
        if (r101 != null) goto L7;
    L27:
        a r103 = null;
    L28:
        if (r103 != null) goto L30;
        return null;
    L30:
        int r104 = r103.f514349a;
        Parcel r105 = Parcel.obtain();
        byte[] r106 = r103.f514350b;     // Catch: Throwable -> L33 RuntimeException -> L36
        r105.unmarshall(r106, 0, r106.length);     // Catch: Throwable -> L33 RuntimeException -> L36
        r105.setDataPosition(0);     // Catch: Throwable -> L33 RuntimeException -> L36
        Intent r107 = (Intent) Intent.CREATOR.createFromParcel(r105);     // Catch: Throwable -> L33 RuntimeException -> L36
        r105.recycle();
        r102 = r107;
    L38:
        return new RestoreRequest(r104, r102);
    L36:
        r105.recycle();
    L33:
        th = move-exception;
        r105.recycle();
        throw th;
    L7:
        if (r101.length == 0) goto L27;
        Parcel r108 = Parcel.obtain();
        r108.unmarshall(r101, 0, r101.length);     // Catch: Throwable -> L23 RuntimeException -> L42
        r108.setDataPosition(0);     // Catch: Throwable -> L23 RuntimeException -> L42
        if (r108.readInt() != 1296847442) goto L26;
        if (r108.readInt() != 1) goto L26;
        long r109 = r108.readLong();     // Catch: Throwable -> L23 RuntimeException -> L42
        int r110 = r108.readInt();     // Catch: Throwable -> L23 RuntimeException -> L42
        String r111 = r108.readString();     // Catch: Throwable -> L23 RuntimeException -> L42
        byte[] r112 = r108.createByteArray();     // Catch: Throwable -> L23 RuntimeException -> L42
        if (r112 == null) goto L26;
        if (r111 != null) goto L21;
        r111 = "";
    L21:
        r103 = new a(r109, r110, r111, r112);     // Catch: Throwable -> L23 RuntimeException -> L42
        r108.recycle();
        goto L28
    L23:
        th = move-exception;
        r108.recycle();
        throw th;
    L26:
        r108.recycle();
    L39:
        th = move-exception;
        r100.erase("memorydata_login_restart_pending_page");
        throw th;
    }

    private LoginRestartRelayProtocol() {
    }
}
