package com.lynx.debugrouter;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.view.View;
import com.bytedance.librarian.a;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.lynx.debugrouter.app.MessageHandler;
import com.lynx.debugrouter.base.report.DebugRouterMetaInfo;
import com.lynx.debugrouter.base.report.DebugRouterReportServiceUtil;
import com.lynx.debugrouter.base.usb.USBTransTemplateUtil;
import com.lynx.debugrouter.log.LLog;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class DebugRouter {
    private static final String TAG = "DebugRouter";
    private static boolean mIsNativeLibraryLoaded;
    private static volatile DebugRouter sInstance;
    private static final WeakHashMap<View, Integer> viewMap = null;
    private final Map<DebugRouterGlobalHandler, Integer> mGlobalHandlers;
    private final Map<DebugRouterSessionHandler, Integer> mSessionHandlers;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static /* synthetic */ Class access$001(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    private native int nativeAddNativeGlobalHandler(GlobalHandlerDelegate r100);

    private native void nativeAddNativeMessageHandler(MessageHandlerDelegate r100);

    private native int nativeAddNativeSessionHandler(SessionHandlerDelegate r100);

    private native void nativeAddStateListener(NativeStateListenerDelegate r100);

    private native void nativeConnect(String r100, String r101);

    private native void nativeConnectAsync(String r100, String r101);

    private native void nativeCreateDebugRouter();

    private native void nativeDisableDebugChannel();

    private native void nativeDisconnect();

    private native void nativeDisconnectAsync();

    private native void nativeEnableAllSessions();

    private native void nativeEnableDebugChannel();

    private native void nativeEnableSingleSession(int r100);

    private native String nativeGetAppInfoByKey(String r100);

    private native String nativeGetConfig(String r100, String r101);

    private native int nativeGetConnectionState();

    private native String nativeGetRoomId();

    private native String nativeGetServerUrl();

    private native int nativeGetUSBPort();

    private native boolean nativeHandleSchema(String r100);

    private native boolean nativeIsDebugChannelEnabled();

    private native boolean nativeIsValidSchema(String r100);

    private native int nativePlug(NativeSlotDelegate r100);

    private native void nativePull(int r100);

    private native boolean nativeRemoveNativeGlobalHandler(int r100);

    private native boolean nativeRemoveNativeMessageHandler(String r100);

    private native boolean nativeRemoveNativeSessionHandler(int r100);

    private native void nativeSend(String r100);

    private native void nativeSendAsync(String r100);

    private native void nativeSendData(String r100, int r101, String r102, int r103, boolean r104);

    private native void nativeSendDataAsync(String r100, int r101, String r102, int r103, boolean r104);

    private native void nativeSetAppInfo(String r100, String r101);

    private native void nativeSetConfig(String r100, String r101);

    private native void nativeSetReportDelegate(NativeReportDelegate r100);

    public String getVersion() {
        return BuildConfig.DEBUGROUTER_VERSION;
    }

    static {
        viewMap = new WeakHashMap();
    }

    private String getCurrentProcessName() {
        Method r100 = INVOKESTATIC_com_lynx_debugrouter_DebugRouter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L7
        r100.setAccessible(true);     // Catch: Throwable -> L7
        Object r101 = r100.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if ((r101 instanceof String) == false) goto L12;
        return (String) r101;
    L12:
        return "android";
    L7:
        th = move-exception;
        th.printStackTrace();
        return "android";
    }

    public static DebugRouter getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(DebugRouter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new DebugRouter();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DebugRouter.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void initAppInfo() {
        String r100 = Build.MANUFACTURER;
        String r101 = Build.MODEL;
        if (r101.startsWith(r100) == false) goto L5;
        String r102 = r101;
    L6:
        String r103 = getCurrentProcessName();
        nativeSetAppInfo("App", r103);
        nativeSetAppInfo("AppVersion", "1.0");
        nativeSetAppInfo("AppProcessName", r103);
        nativeSetAppInfo("manufacturer", r100);
        nativeSetAppInfo(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r101);
        nativeSetAppInfo("deviceModel", r102);
        nativeSetAppInfo("osVersion", Build.VERSION.RELEASE);
        nativeSetAppInfo("debugRouterVersion", getVersion());
        nativeSetAppInfo("debugRouterId", UUID.randomUUID().toString());
        nativeSetReportDelegate(new NativeReportDelegate());
        return;
    L5:
        r102 = r100 + " " + r101;
        goto L6
    }

    public static void loadNativeLibrary() {
        if (mIsNativeLibraryLoaded == true) goto L11;
        INVOKESTATIC_com_lynx_debugrouter_DebugRouter_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lynxdebugrouter");     // Catch: Throwable -> L6
        mIsNativeLibraryLoaded = true;     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.toString();
        return;
    }

    public void disconnect() {
        LLog.i(TAG, "disconnect");
        nativeDisconnect();
    }

    private DebugRouter() {
        this.mSessionHandlers = new ConcurrentHashMap();
        this.mGlobalHandlers = new ConcurrentHashMap();
        loadNativeLibrary();
        LLog.addDebugLoggingDelegate();
        DebugRouterReportServiceUtil.init(new DebugRouterMetaInfo(getVersion(), getCurrentProcessName()));
        DebugRouterReportServiceUtil.report("DebugRouterInit", null, null, null);
        nativeCreateDebugRouter();
        initAppInfo();
        addMessageHandler(new CallStaticVoidMethodHandler());
        addMessageHandler(new OpenUsbTransTemplateSwitchHandler());
        addMessageHandler(new ReceiveTemplateByUsbHandler());
        addStateListener(new DebugRouterStateListener());
        USBTransTemplateUtil.INSTANCE.addInterceptor();
    }

    public static int getUSBPort() {
        return getInstance().nativeGetUSBPort();
    }

    public ConnectionState getConnectionState() {
        int r100 = nativeGetConnectionState();
        if (r100 == (-1)) goto L11;
        if (r100 == 1) goto L9;
        return ConnectionState.DISCONNECTED;
    L9:
        return ConnectionState.CONNECTED;
    L11:
        return ConnectionState.DISCONNECTED;
    }

    public String getRoomId() {
        return nativeGetRoomId();
    }

    public String getServerUrl() {
        return nativeGetServerUrl();
    }

    public boolean isDebugChannelEnabled() {
        return nativeIsDebugChannelEnabled();
    }

    public static boolean isNativeLibraryLoaded() {
        return mIsNativeLibraryLoaded;
    }

    public void disableDebugChannel() {
        nativeDisableDebugChannel();
    }

    public void disconnectAsync() {
        nativeDisconnectAsync();
    }

    public void enableAllSessions() {
        nativeEnableAllSessions();
    }

    public void enableDebugChannel() {
        nativeEnableDebugChannel();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lynx_debugrouter_DebugRouter_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    private String checkNetworkStatus(Context r100) {
        if (r100 != null) goto L14;
        return "";
    L14:
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Throwable -> L13
        if (r101 != null) goto L8;
        return "";
    L8:
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Throwable -> L13
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102.getTypeName();
    L13:
        return "";
    }

    public void addGlobalHandler(DebugRouterGlobalHandler r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = nativeAddNativeGlobalHandler(new GlobalHandlerDelegate(r100));
        this.mGlobalHandlers.put(r100, Integer.valueOf(r101));
    }

    public void addMessageHandler(MessageHandler r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        nativeAddNativeMessageHandler(new MessageHandlerDelegate(r100));
    }

    public void addSessionHandler(DebugRouterSessionHandler r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = nativeAddNativeSessionHandler(new SessionHandlerDelegate(r100));
        this.mSessionHandlers.put(r100, Integer.valueOf(r101));
    }

    public void addStateListener(StateListener r100) {
        if (r100 == null) goto L5;
        nativeAddStateListener(new NativeStateListenerDelegate(r100));
        return;
    }

    public void enableSingleSession(int r100) {
        nativeEnableSingleSession(r100);
    }

    public String getAppInfoByKey(String r100) {
        return nativeGetAppInfoByKey(r100);
    }

    public int getSessionIdByView(View r100) {
        WeakHashMap<View, Integer> r101 = viewMap;
        monitor-enter(r101);
        Integer r102 = r101.get(r100);     // Catch: Throwable -> L10
        if (r102 != null) goto L7;
        int r103 = 0;
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r103;
    L7:
        r103 = r102.intValue();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public View getViewBySessionId(int r100) {
        WeakHashMap<View, Integer> r101 = viewMap;
        monitor-enter(r101);
        Iterator<Map.Entry<View, Integer>> r102 = r101.entrySet().iterator();     // Catch: Throwable -> L15
    L6:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<View, Integer> r103 = r102.next();     // Catch: Throwable -> L15
        if (r103.getValue().intValue() != r100) goto L6;
        View r104 = r103.getKey();     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        return r104;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L15
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public boolean handleSchema(String r100) {
        DebugRouterReport.reportHandleSchema(r100);
        return nativeHandleSchema(r100);
    }

    public boolean isValidSchema(String r100) {
        return nativeIsValidSchema(r100);
    }

    public int plug(DebugRouterSlot r100) {
        LLog.i(TAG, "plug session " + r100.getTemplateUrl());
        int r101 = nativePlug(new NativeSlotDelegate(r100));
        View r102 = r100.getTemplateView();
        if (r102 == null) goto L12;
        WeakHashMap<View, Integer> r103 = viewMap;
        monitor-enter(r103);
        r103.put(r102, Integer.valueOf(r101));     // Catch: Throwable -> L9
        monitor-exit(r103);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        return r101;
    }

    public void pull(int r100) {
        LLog.i(TAG, "pull session " + r100);
        nativePull(r100);
    }

    public boolean removeGlobalHandler(DebugRouterGlobalHandler r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Integer r101 = this.mGlobalHandlers.remove(r100);
        if (r101 != null) goto L8;
        return false;
    L8:
        return nativeRemoveNativeGlobalHandler(r101.intValue());
    }

    public boolean removeMessageHandler(MessageHandler r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return nativeRemoveNativeMessageHandler(r100.getName());
    }

    public boolean removeSessionHandler(DebugRouterSessionHandler r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Integer r101 = this.mSessionHandlers.remove(r100);
        if (r101 != null) goto L8;
        return false;
    L8:
        return nativeRemoveNativeSessionHandler(r101.intValue());
    }

    public void send(String r100) {
        if (r100 != null) goto L5;
        LLog.i(TAG, "send: message == null");
        return;
    L5:
        nativeSend(r100);
    }

    public void sendAsync(String r100) {
        nativeSendAsync(r100);
    }

    public synchronized void setAppInfo(Map<String, String> r100) {
        monitor-enter(this);
        setAppInfo(null, r100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void connect(String r100, String r101) {
        LLog.i(TAG, "connect url:" + r100 + ", room:" + r101);
        nativeConnect(r100, r101);
    }

    public void connectAsync(String r100, String r101) {
        LLog.i(TAG, "connectAsync url:" + r100 + ", room:" + r101);
        nativeConnectAsync(r100, r101);
    }

    public Boolean getConfig(String r100, Boolean r101) {
        String r102 = nativeGetConfig(r100, r101.toString());
        if ("true".equals(r102) == false) goto L7;
        return Boolean.TRUE;
    L7:
        if ("false".equals(r102) == true) goto L9;
        LLog.w(TAG, "getConfig: value is illegal");
        return Boolean.FALSE;
    L9:
        return Boolean.FALSE;
    }

    public synchronized void setAppInfo(Context r100, Map<String, String> r101) {
        monitor-enter(this);
        Iterator<String> r102 = r101.keySet().iterator();     // Catch: Throwable -> L10
    L5:
        if (r102.hasNext() == false) goto L7;
        String r103 = r102.next();     // Catch: Throwable -> L10
        nativeSetAppInfo(r103, r101.get(r103));     // Catch: Throwable -> L10
        goto L5
    L7:
        nativeSetAppInfo("network", checkNetworkStatus(r100));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void setConfig(String r100, Boolean r101) {
        nativeSetConfig(r100, r101.toString());
    }

    public void setSessionIdOfView(View r100, int r101) {
        WeakHashMap<View, Integer> r102 = viewMap;
        monitor-enter(r102);
        r102.put(r100, Integer.valueOf(r101));     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_debugrouter_DebugRouter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$001(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$001(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public void sendData(String r100, int r101, String r102) {
        sendData(r100, r101, r102, -1);
    }

    public void sendDataAsync(String r100, int r101, String r102) {
        sendDataAsync(r100, r101, r102, -1);
    }

    public void sendData(String r100, int r101, JSONObject r102) {
        sendData(r100, r101, r102, -1);
    }

    public void sendDataAsync(String r100, int r101, JSONObject r102) {
        sendDataAsync(r100, r101, r102, -1);
    }

    public void sendData(String r100, int r101, JSONObject r102, int r110) {
        sendData(r100, r101, r102.toString(), r110, true);
    }

    public void sendDataAsync(String r100, int r101, JSONObject r102, int r110) {
        nativeSendDataAsync(r100, r101, r102.toString(), r110, true);
    }

    public void sendData(String r100, int r101, String r102, int r110) {
        sendData(r100, r101, r102, r110, false);
    }

    public void sendDataAsync(String r100, int r101, String r102, int r110) {
        nativeSendDataAsync(r100, r101, r102, r110, false);
    }

    private void sendData(String r100, int r101, String r102, int r103, boolean r104) {
        if (r102 != null) goto L5;
        LLog.i(TAG, "sendData: message == null");
        return;
    L5:
        nativeSendData(r100, r101, r102, r103, r104);
    }
}
