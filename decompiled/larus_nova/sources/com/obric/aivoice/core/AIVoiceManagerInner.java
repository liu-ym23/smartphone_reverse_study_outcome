package com.obric.aivoice.core;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.keva.ext.fast.KevaMultiProcessFastConstant;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.obric.aivoice.AIVoiceBinder;
import com.obric.aivoice.AIVoiceListener;
import com.obric.aivoice.core.conn.ClientServiceConn;
import com.obric.aivoice.core.data.BundleExtKt;
import com.obric.aivoice.core.data.IdlKeys;
import com.obric.aivoice.core.log.AIVoiceLog;
import com.obric.aivoice.sdk.AIVoiceConfig;
import com.obric.aivoice.sdk.FileAsrTaskListener;
import com.obric.aivoice.sdk.IConnectListener;
import com.obric.aivoice.sdk.IOfflineServerListener;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012J\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012J\"\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\b\u0010$\u001a\u0004\u0018\u00010\u0010J\u0006\u0010%\u001a\u00020\u001aJ\u0006\u0010&\u001a\u00020\u001aJ\u0016\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u0012J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004J\b\u0010,\u001a\u00020\u001aH\u0002J\u000e\u0010-\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020.J\u000e\u0010/\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0004J\u000e\u00100\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0004J\u000e\u00101\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020.J\u0016\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0004J\u000e\u00106\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0004J\u0016\u00107\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/aivoice/core/AIVoiceManagerInner;", "", "()V", "TAG", "", "aiVoiceConfig", "Lcom/obric/aivoice/sdk/AIVoiceConfig;", "getAiVoiceConfig", "()Lcom/obric/aivoice/sdk/AIVoiceConfig;", "setAiVoiceConfig", "(Lcom/obric/aivoice/sdk/AIVoiceConfig;)V", "conn", "Lcom/obric/aivoice/core/conn/ClientServiceConn;", "connectListener", "Lcom/obric/aivoice/sdk/IConnectListener;", "offlineServerListener", "Lcom/obric/aivoice/sdk/IOfflineServerListener;", "createAsrTask", "", "asrConfig", "createFileAsrTask", "listener", "Lcom/obric/aivoice/sdk/FileAsrTaskListener;", "createTtsTask", "ttsConfig", MapMonitorConst.EVENT_DESTROY, "", "enableOfflineServer", "enable", "", "type", KevaMultiProcessFastConstant.CALL_METHOD, "Lcom/obric/aivoice/AIVoiceBinder;", "getOfflineServerStatus", "init", "config", "statusListener", "onConnected", "onDisconnected", "onOfflineStatusChanged", "status", "mode", "queryFileAsrTask", DBDefinition.TASK_ID, "reConn", "registerOfflineServerListener", "Lcom/obric/aivoice/AIVoiceListener;", "removeAsrTask", "removeTtsTask", "unregisterOfflineServerListener", "writeAsrData", "data", "", "asrData", "writeTtsEnd", "writeTtsText", "text", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AIVoiceManagerInner {
    public static final AIVoiceManagerInner INSTANCE = null;
    private static final String TAG = null;
    private static AIVoiceConfig aiVoiceConfig;
    private static ClientServiceConn conn;
    private static IConnectListener connectListener;
    private static IOfflineServerListener offlineServerListener;

    private AIVoiceManagerInner() {
    }

    private final synchronized void reConn() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (conn != null) goto L6;
        conn = ClientServiceConn.Companion.getInstance(new ComponentName("com.obric.aivoice", "com.obric.aivoice.service.AIVoiceService"));     // Catch: Throwable -> L15
    L6:
        AIVoiceConfig r100 = aiVoiceConfig;     // Catch: Throwable -> L15
        Unit r101 = null;
        if (r100 == null) goto L11;
        ClientServiceConn r102 = conn;     // Catch: Throwable -> L15
        if (r102 == null) goto L11;
        r102.conn(r100.getContextGetter());     // Catch: Throwable -> L15
        r101 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L11:
        if (r101 != null) goto L13;
        AIVoiceLog.INSTANCE.e(TAG, "config is null");     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
    }

    public final synchronized AIVoiceBinder getBinder() {
        monitor-enter(this);
        reConn();     // Catch: Throwable -> L10
        ClientServiceConn r100 = conn;     // Catch: Throwable -> L10
        if (r100 == null) goto L7;
        AIVoiceBinder r101 = r100.getBinder();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return r101;
    L7:
        r101 = null;
    L10:
        th = move-exception;
        throw th;
    }

    static {
        INSTANCE = new AIVoiceManagerInner();
        TAG = "AIVoiceManagerInner";
    }

    public final void destroy() {
        AIVoiceConfig r100 = aiVoiceConfig;
        if (r100 == null) goto L8;
        ClientServiceConn r101 = conn;
        if (r101 == null) goto L9;
        r101.disconnect(r100.getContextGetter());
        return;
    L9:
        return;
    }

    public final void onConnected() {
        IConnectListener r100 = connectListener;
        if (r100 == null) goto L6;
        r100.onServerConnected();
        return;
    }

    public final void onDisconnected() {
        IConnectListener r100 = connectListener;
        if (r100 == null) goto L6;
        r100.onServerDisconnected();
        return;
    }

    public final AIVoiceConfig getAiVoiceConfig() {
        return aiVoiceConfig;
    }

    public final int createAsrTask(String r100) {
        Intrinsics.checkNotNullParameter(r100, "asrConfig");
        Bundle r101 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_CreateAsrTask);
        r101.putString(IdlKeys.Args_AsrConfig, r100);
        AIVoiceBinder r102 = getBinder();     // Catch: RemoteException -> L15
        Integer r103 = null;
        if (r102 == null) goto L8;
        Bundle r104 = r102.callVoiceSync(r101);     // Catch: RemoteException -> L15
        if (r104 == null) goto L8;
        Object r105 = r104.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r105 instanceof Integer) == false) goto L12;
        r103 = (Integer) r105;     // Catch: RemoteException -> L15
    L12:
        if (r103 == null) goto L25;
        return r103.intValue();
    L25:
        return -1;
    L8:
        r105 = null;
    L15:
        e = move-exception;
        AIVoiceLog r106 = AIVoiceLog.INSTANCE;
        String r107 = TAG;
        String r108 = e.getMessage();
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        r106.e(r107, r108, e);
        ClientServiceConn r109 = conn;
        if (r109 == null) goto L26;
        r109.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final int createTtsTask(String r100) {
        Intrinsics.checkNotNullParameter(r100, "ttsConfig");
        Bundle r101 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_CreateTtsTask);
        r101.putString(IdlKeys.Args_TtsConfig, r100);
        AIVoiceBinder r102 = getBinder();     // Catch: RemoteException -> L15
        Integer r103 = null;
        if (r102 == null) goto L8;
        Bundle r104 = r102.callVoiceSync(r101);     // Catch: RemoteException -> L15
        if (r104 == null) goto L8;
        Object r105 = r104.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r105 instanceof Integer) == false) goto L12;
        r103 = (Integer) r105;     // Catch: RemoteException -> L15
    L12:
        if (r103 == null) goto L25;
        return r103.intValue();
    L25:
        return -1;
    L8:
        r105 = null;
    L15:
        e = move-exception;
        AIVoiceLog r106 = AIVoiceLog.INSTANCE;
        String r107 = TAG;
        String r108 = e.getMessage();
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        r106.e(r107, r108, e);
        ClientServiceConn r109 = conn;
        if (r109 == null) goto L26;
        r109.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final int getOfflineServerStatus(int r100) {
        Bundle r101 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_GetOfflineServerStatus);
        r101.putInt(IdlKeys.Args_OfflineType, r100);
        AIVoiceBinder r102 = getBinder();     // Catch: RemoteException -> L15
        Integer r103 = null;
        if (r102 == null) goto L8;
        Bundle r104 = r102.callVoiceSync(r101);     // Catch: RemoteException -> L15
        if (r104 == null) goto L8;
        Object r105 = r104.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r105 instanceof Integer) == false) goto L12;
        r103 = (Integer) r105;     // Catch: RemoteException -> L15
    L12:
        if (r103 == null) goto L25;
        return r103.intValue();
    L25:
        return -1;
    L8:
        r105 = null;
    L15:
        e = move-exception;
        AIVoiceLog r106 = AIVoiceLog.INSTANCE;
        String r107 = TAG;
        String r108 = e.getMessage();
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        r106.e(r107, r108, e);
        ClientServiceConn r109 = conn;
        if (r109 == null) goto L26;
        r109.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final String queryFileAsrTask(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Bundle r101 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_QueryFileAsrTask);
        r101.putString(IdlKeys.Args_AsrTaskId, r100);
        AIVoiceBinder r102 = getBinder();     // Catch: RemoteException -> L15
        String r103 = null;
        if (r102 == null) goto L8;
        Bundle r104 = r102.callVoiceSync(r101);     // Catch: RemoteException -> L15
        if (r104 == null) goto L8;
        Object r105 = r104.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r105 instanceof String) == false) goto L12;
        r103 = (String) r105;     // Catch: RemoteException -> L15
    L12:
        if (r103 != null) goto L25;
        return "";
    L25:
        return r103;
    L8:
        r105 = null;
    L15:
        e = move-exception;
        AIVoiceLog r106 = AIVoiceLog.INSTANCE;
        String r107 = TAG;
        String r108 = e.getMessage();
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        r106.e(r107, r108, e);
        ClientServiceConn r109 = conn;
        if (r109 == null) goto L26;
        r109.onBinderException();
        return "";
    L26:
        return "";
    }

    public final void registerOfflineServerListener(AIVoiceListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Bundle r101 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_RegisterOfflineServerListener);
        AIVoiceBinder r102 = getBinder();     // Catch: RemoteException -> L7
        if (r102 == null) goto L17;
        r102.callVoice(r101, r100);     // Catch: RemoteException -> L7
        return;
    L17:
        return;
    L7:
        e = move-exception;
        AIVoiceLog r103 = AIVoiceLog.INSTANCE;
        String r104 = TAG;
        String r105 = e.getMessage();
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        r103.e(r104, r105, e);
        ClientServiceConn r106 = conn;
        if (r106 == null) goto L18;
        r106.onBinderException();
        return;
    }

    public final int removeAsrTask(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Bundle r101 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_RemoveAsrTask);
        r101.putString(IdlKeys.Args_AsrTaskId, r100);
        AIVoiceBinder r102 = getBinder();     // Catch: RemoteException -> L15
        Integer r103 = null;
        if (r102 == null) goto L8;
        Bundle r104 = r102.callVoiceSync(r101);     // Catch: RemoteException -> L15
        if (r104 == null) goto L8;
        Object r105 = r104.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r105 instanceof Integer) == false) goto L12;
        r103 = (Integer) r105;     // Catch: RemoteException -> L15
    L12:
        if (r103 == null) goto L25;
        return r103.intValue();
    L25:
        return -1;
    L8:
        r105 = null;
    L15:
        e = move-exception;
        AIVoiceLog r106 = AIVoiceLog.INSTANCE;
        String r107 = TAG;
        String r108 = e.getMessage();
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        r106.e(r107, r108, e);
        ClientServiceConn r109 = conn;
        if (r109 == null) goto L26;
        r109.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final int removeTtsTask(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Bundle r101 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_RemoveTtsTask);
        r101.putString(IdlKeys.Args_TtsTaskId, r100);
        AIVoiceBinder r102 = getBinder();     // Catch: RemoteException -> L15
        Integer r103 = null;
        if (r102 == null) goto L8;
        Bundle r104 = r102.callVoiceSync(r101);     // Catch: RemoteException -> L15
        if (r104 == null) goto L8;
        Object r105 = r104.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r105 instanceof Integer) == false) goto L12;
        r103 = (Integer) r105;     // Catch: RemoteException -> L15
    L12:
        if (r103 == null) goto L25;
        return r103.intValue();
    L25:
        return -1;
    L8:
        r105 = null;
    L15:
        e = move-exception;
        AIVoiceLog r106 = AIVoiceLog.INSTANCE;
        String r107 = TAG;
        String r108 = e.getMessage();
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        r106.e(r107, r108, e);
        ClientServiceConn r109 = conn;
        if (r109 == null) goto L26;
        r109.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final void setAiVoiceConfig(AIVoiceConfig r100) {
        aiVoiceConfig = r100;
    }

    public final void unregisterOfflineServerListener(AIVoiceListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Bundle r101 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_UnRegisterOfflineServerListener);
        AIVoiceBinder r102 = getBinder();     // Catch: RemoteException -> L7
        if (r102 == null) goto L17;
        r102.callVoice(r101, r100);     // Catch: RemoteException -> L7
        return;
    L17:
        return;
    L7:
        e = move-exception;
        AIVoiceLog r103 = AIVoiceLog.INSTANCE;
        String r104 = TAG;
        String r105 = e.getMessage();
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        r103.e(r104, r105, e);
        ClientServiceConn r106 = conn;
        if (r106 == null) goto L18;
        r106.onBinderException();
        return;
    }

    public final int writeTtsEnd(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Bundle r101 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_WriteTtsEnd);
        r101.putString(IdlKeys.Args_TtsTaskId, r100);
        AIVoiceBinder r102 = getBinder();     // Catch: RemoteException -> L15
        Integer r103 = null;
        if (r102 == null) goto L8;
        Bundle r104 = r102.callVoiceSync(r101);     // Catch: RemoteException -> L15
        if (r104 == null) goto L8;
        Object r105 = r104.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r105 instanceof Integer) == false) goto L12;
        r103 = (Integer) r105;     // Catch: RemoteException -> L15
    L12:
        if (r103 == null) goto L25;
        return r103.intValue();
    L25:
        return -1;
    L8:
        r105 = null;
    L15:
        e = move-exception;
        AIVoiceLog r106 = AIVoiceLog.INSTANCE;
        String r107 = TAG;
        String r108 = e.getMessage();
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        r106.e(r107, r108, e);
        ClientServiceConn r109 = conn;
        if (r109 == null) goto L26;
        r109.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final String createFileAsrTask(String r100, FileAsrTaskListener r101) {
        Intrinsics.checkNotNullParameter(r100, "asrConfig");
        Bundle r102 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_CreateFileAsrTask);
        r102.putString(IdlKeys.Args_AsrConfig, r100);
        if (r101 == null) goto L25;
        r102.putBinder(IdlKeys.Args_TaskListener, r101.asBinder());
    L25:
        AIVoiceBinder r103 = getBinder();     // Catch: RemoteException -> L17
        String r104 = null;
        if (r103 == null) goto L10;
        Bundle r105 = r103.callVoiceSync(r102);     // Catch: RemoteException -> L17
        if (r105 == null) goto L10;
        Object r106 = r105.get(IdlKeys.Result);     // Catch: RemoteException -> L17
    L12:
        if ((r106 instanceof String) == false) goto L14;
        r104 = (String) r106;     // Catch: RemoteException -> L17
    L14:
        if (r104 != null) goto L27;
        return "";
    L27:
        return r104;
    L10:
        r106 = null;
    L17:
        e = move-exception;
        AIVoiceLog r107 = AIVoiceLog.INSTANCE;
        String r108 = TAG;
        String r109 = e.getMessage();
        if (r109 != null) goto L21;
        r109 = "";
    L21:
        r107.e(r108, r109, e);
        ClientServiceConn r110 = conn;
        if (r110 == null) goto L28;
        r110.onBinderException();
        return "";
    L28:
        return "";
    }

    public final int enableOfflineServer(boolean r100, int r101) {
        Bundle r102 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_EnableOfflineServer);
        r102.putBoolean(IdlKeys.Args_EnableOffline, r100);
        r102.putInt(IdlKeys.Args_OfflineType, r101);
        AIVoiceConfig r103 = aiVoiceConfig;
        Integer r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.getPackageName();
    L6:
        r102.putString(IdlKeys.Args_PackageName, r105);
        AIVoiceBinder r106 = getBinder();     // Catch: RemoteException -> L20
        if (r106 == null) goto L12;
        Bundle r107 = r106.callVoiceSync(r102);     // Catch: RemoteException -> L20
        if (r107 == null) goto L12;
        Object r108 = r107.get(IdlKeys.Result);     // Catch: RemoteException -> L20
    L14:
        if ((r108 instanceof Integer) == false) goto L16;
        r104 = (Integer) r108;     // Catch: RemoteException -> L20
    L16:
        if (r104 == null) goto L19;
        return r104.intValue();
    L19:
        return -1;
    L12:
        r108 = null;
    L20:
        e = move-exception;
        AIVoiceLog r109 = AIVoiceLog.INSTANCE;
        String r110 = TAG;
        String r111 = e.getMessage();
        if (r111 != null) goto L24;
        r111 = "";
    L24:
        r109.e(r110, r111, e);
        ClientServiceConn r112 = conn;
        if (r112 == null) goto L27;
        r112.onBinderException();
    L27:
        return 0;
    L5:
        r105 = null;
        goto L6
    }

    public final void onOfflineStatusChanged(boolean r100, int r101) {
        AIVoiceLog.INSTANCE.d(TAG, "onOfflineStatusChanged status:" + r100 + " mode:" + r101);
        IOfflineServerListener r102 = offlineServerListener;
        if (r102 == null) goto L6;
        r102.onOfflineServerStatusChanged(r100, r101);
        return;
    }

    public final int writeAsrData(byte[] r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "asrData");
        Bundle r102 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_WriteAsrData);
        r102.putByteArray(IdlKeys.Args_AudioBin, r100);
        r102.putString(IdlKeys.Args_AsrData, r101);
        AIVoiceBinder r103 = getBinder();     // Catch: RemoteException -> L15
        Integer r104 = null;
        if (r103 == null) goto L8;
        Bundle r105 = r103.callVoiceSync(r102);     // Catch: RemoteException -> L15
        if (r105 == null) goto L8;
        Object r106 = r105.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r106 instanceof Integer) == false) goto L12;
        r104 = (Integer) r106;     // Catch: RemoteException -> L15
    L12:
        if (r104 == null) goto L25;
        return r104.intValue();
    L25:
        return -1;
    L8:
        r106 = null;
    L15:
        e = move-exception;
        AIVoiceLog r107 = AIVoiceLog.INSTANCE;
        String r108 = TAG;
        String r109 = e.getMessage();
        if (r109 != null) goto L19;
        r109 = "";
    L19:
        r107.e(r108, r109, e);
        ClientServiceConn r110 = conn;
        if (r110 == null) goto L26;
        r110.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final int writeTtsText(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        Bundle r102 = BundleExtKt.setGlobalCall(new Bundle(), IdlKeys.Method_WriteTtsText);
        r102.putString(IdlKeys.Args_TtsTaskId, r100);
        r102.putString(IdlKeys.Args_TtsText, r101);
        AIVoiceBinder r103 = getBinder();     // Catch: RemoteException -> L15
        Integer r104 = null;
        if (r103 == null) goto L8;
        Bundle r105 = r103.callVoiceSync(r102);     // Catch: RemoteException -> L15
        if (r105 == null) goto L8;
        Object r106 = r105.get(IdlKeys.Result);     // Catch: RemoteException -> L15
    L10:
        if ((r106 instanceof Integer) == false) goto L12;
        r104 = (Integer) r106;     // Catch: RemoteException -> L15
    L12:
        if (r104 == null) goto L25;
        return r104.intValue();
    L25:
        return -1;
    L8:
        r106 = null;
    L15:
        e = move-exception;
        AIVoiceLog r107 = AIVoiceLog.INSTANCE;
        String r108 = TAG;
        String r109 = e.getMessage();
        if (r109 != null) goto L19;
        r109 = "";
    L19:
        r107.e(r108, r109, e);
        ClientServiceConn r110 = conn;
        if (r110 == null) goto L26;
        r110.onBinderException();
        return -1;
    L26:
        return -1;
    }

    public final synchronized void init(AIVoiceConfig r100, IConnectListener r101, IOfflineServerListener r102) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "config");     // Catch: Throwable -> L6
        aiVoiceConfig = r100;     // Catch: Throwable -> L6
        connectListener = r101;     // Catch: Throwable -> L6
        offlineServerListener = r102;     // Catch: Throwable -> L6
        reConn();     // Catch: Throwable -> L6
        AIVoiceLog.INSTANCE.v(TAG, "initialize success.");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
