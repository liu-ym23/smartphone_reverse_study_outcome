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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class AbsServerManager extends ContentProvider {
    static final String BUNDLE_BINDER = "binder";
    static final String METHOD_QUERY_BINDER = "query_binder";
    static final String PACKAGE_QUERY_BINDER = "package";
    static final String PLUGIN_PROCESS_QUERY_BINDER = "plugin_process";
    static final String SERVICE_QUERY_BINDER = "service";

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
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

    private long getRequestId(Bundle r4) {
        if (r4 != null) goto L6;
        return -1;
    L6:
        return r4.getLong("zeus_ipc_request_id", -1);
    }

    public IBinder onBind(String r3) {
        r3.getClass();
        byte r1 = -1;
        switch(r3.hashCode()) {
            case -807062458: goto L14;
            case 1042764131: goto L10;
            case 1984153269: goto L6;
            default: goto L17;
        };
    L17:
        switch(r1) {
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
        if (r3.equals(SERVICE_QUERY_BINDER) == false) goto L17;
        r1 = 2;
        goto L17
    L10:
        if (r3.equals(PLUGIN_PROCESS_QUERY_BINDER) == false) goto L17;
        r1 = 1;
        goto L17
    L14:
        if (r3.equals(PACKAGE_QUERY_BINDER) == false) goto L17;
        r1 = 0;
        goto L17
    }

    private String getString(Bundle r2, String r3) {
        if (r2 != null) goto L6;
        return XmlPullParser.NO_NAMESPACE;
    L6:
        return r2.getString(r3, XmlPullParser.NO_NAMESPACE);
    }

    private void logQueryBinderReceived(String r4, Bundle r5) {
        ZeusLogger.i(ZeusLogger.TAG_SERVER, "ServerManagerIPC event=query_binder_received requestId=" + getRequestId(r5) + " component=" + r4 + " fromProcess=" + getString(r5, "zeus_ipc_from_process") + " currentProcess=" + getCurrentProcessName() + " targetProcessKey=" + getString(r5, "zeus_ipc_target_process_key") + " targetProcess=" + getString(r5, "zeus_ipc_target_process"));
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r3, String r4, Bundle r5) {
        if (METHOD_QUERY_BINDER.equals(r3) == true) goto L5;
        return null;
    L5:
        if (ZeusLogger.isDebug() == false) goto L7;
        logQueryBinderReceived(r4, r5);
    L7:
        IBinder r6 = onBind(r4);
        if (r6 == null) goto L11;
        Bundle r7 = new Bundle();
        r7.putParcelable(BUNDLE_BINDER, new BinderParcel(r6));
        return r7;
    L11:
        ZeusLogger.w(ZeusLogger.TAG_SERVER, "ServerManagerIPC event=query_binder_no_binder requestId=" + getRequestId(r5) + " component=" + r4 + " fromProcess=" + getString(r5, "zeus_ipc_from_process") + " currentProcess=" + getCurrentProcessName() + " targetProcessKey=" + getString(r5, "zeus_ipc_target_process_key") + " targetProcess=" + getString(r5, "zeus_ipc_target_process"));
        return null;
    }
}
