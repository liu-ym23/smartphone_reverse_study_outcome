package com.volcengine.zeus.servermanager;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.pm.PackageManager;
import com.volcengine.zeus.service.server.PluginProcessManager;
import com.volcengine.zeus.service.server.ServiceManager;
import dqc.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsServerManager extends ContentProvider {
    static final String BUNDLE_BINDER = "binder";
    static final String METHOD_QUERY_BINDER = "query_binder";
    static final String PACKAGE_QUERY_BINDER = "package";
    static final String PLUGIN_PROCESS_QUERY_BINDER = "plugin_process";
    static final String SERVICE_QUERY_BINDER = "service";

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    private String getCurrentProcessName() {
        Zeus.getAppApplication();     // Catch: Throwable -> L4
        return d.c();
    L4:
        return "unknown";
    }

    public AbsServerManager() {
    }

    private long getRequestId(Bundle r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        return r100.getLong("zeus_ipc_request_id", -1);
    }

    public IBinder onBind(String r100) {
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -807062458: goto L14;
            case 1042764131: goto L10;
            case 1984153269: goto L6;
            default: goto L17;
        };
    L17:
        switch(r101) {
            case 0: goto L25;
            case 1: goto L23;
            case 2: goto L21;
            default: goto L18;
        };
    L18:
        return null;
    L21:
        return ServiceManager.getInstance();
    L23:
        return PluginProcessManager.INSTANCE;
    L25:
        return PackageManager.getInstance();
    L6:
        if (r100.equals("service") == false) goto L17;
        r101 = 2;
        goto L17
    L10:
        if (r100.equals(PLUGIN_PROCESS_QUERY_BINDER) == false) goto L17;
        r101 = 1;
        goto L17
    L14:
        if (r100.equals("package") == false) goto L17;
        r101 = 0;
        goto L17
    }

    private String getString(Bundle r100, String r101) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.getString(r101, "");
    }

    private void logQueryBinderReceived(String r100, Bundle r101) {
        ZeusLogger.i(ZeusLogger.TAG_SERVER, "ServerManagerIPC event=query_binder_received requestId=" + getRequestId(r101) + " component=" + r100 + " fromProcess=" + getString(r101, "zeus_ipc_from_process") + " currentProcess=" + getCurrentProcessName() + " targetProcessKey=" + getString(r101, "zeus_ipc_target_process_key") + " targetProcess=" + getString(r101, "zeus_ipc_target_process"));
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        if (METHOD_QUERY_BINDER.equals(r100) == true) goto L5;
        return null;
    L5:
        if (ZeusLogger.isDebug() == false) goto L7;
        logQueryBinderReceived(r101, r102);
    L7:
        IBinder r103 = onBind(r101);
        if (r103 == null) goto L11;
        Bundle r104 = new Bundle();
        r104.putParcelable(BUNDLE_BINDER, new BinderParcel(r103));
        return r104;
    L11:
        ZeusLogger.w(ZeusLogger.TAG_SERVER, "ServerManagerIPC event=query_binder_no_binder requestId=" + getRequestId(r102) + " component=" + r101 + " fromProcess=" + getString(r102, "zeus_ipc_from_process") + " currentProcess=" + getCurrentProcessName() + " targetProcessKey=" + getString(r102, "zeus_ipc_target_process_key") + " targetProcess=" + getString(r102, "zeus_ipc_target_process"));
        return null;
    }
}
