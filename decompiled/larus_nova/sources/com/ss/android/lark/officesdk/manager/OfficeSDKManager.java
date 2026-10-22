package com.ss.android.lark.officesdk.manager;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.api.IOfficeSDKHostSessionProvider;
import com.ss.android.lark.officesdk.api.api.OfficeSDKUserApi;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.officesdk.api.init.IDeviceInfoProvider;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKBizConfigProvider;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKHostAppHeaderProvider;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKLifeCycle;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKTokenProvider;
import com.ss.android.lark.officesdk.api.init.IOfficeSDKUserServiceInjector;
import com.ss.android.lark.officesdk.api.init.IOfficeSdkLanguageProvider;
import com.ss.android.lark.officesdk.api.init.OfficeSDKInitConfig;
import com.ss.android.lark.officesdk.api.service.capacity.IHostLifecycle;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKGlobalEntryPoint;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKUserEntryPoint;
import com.ss.android.lark.officesdk.interfaces.IOfficeSDKLifecycleListener;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.hilt.EntryPoints;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000»\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0013H\u0007J\b\u0010\u001a\u001a\u00020\u0014H\u0007J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0007J\u0015\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\fH\u0001¢\u0006\u0002\b\u001eJ\n\u0010\u001f\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000fH\u0007J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0005H\u0007J\u0018\u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000fH\u0007J\n\u0010#\u001a\u0004\u0018\u00010\u000fH\u0007J\u001d\u0010$\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000fH\u0001¢\u0006\u0002\b%J\r\u0010&\u001a\u00020\u0017H\u0001¢\u0006\u0002\b'J \u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u000fH\u0002J\u0017\u0010+\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\b,J\u0015\u0010-\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0005H\u0001¢\u0006\u0002\b.J\n\u0010/\u001a\u0004\u0018\u00010\u0005H\u0007J/\u00104\u001a\u00020\u0017\"\b\b\u0000\u00105*\u0002022\f\u00106\u001a\b\u0012\u0004\u0012\u0002H5012\u0006\u00107\u001a\u0002H5H\u0001¢\u0006\u0004\b8\u00109J7\u0010:\u001a\u00020\u0017\"\b\b\u0000\u00105*\u0002022\u0006\u0010!\u001a\u00020\u00052\f\u00106\u001a\b\u0012\u0004\u0012\u0002H5012\u0006\u00107\u001a\u0002H5H\u0001¢\u0006\u0004\b;\u0010<J'\u0010=\u001a\u0004\u0018\u0001H5\"\b\b\u0000\u00105*\u0002022\f\u00106\u001a\b\u0012\u0004\u0012\u0002H501H\u0007¢\u0006\u0002\u0010>J/\u0010?\u001a\u0004\u0018\u0001H5\"\b\b\u0000\u00105*\u0002022\u0006\u0010!\u001a\u00020\u00052\f\u00106\u001a\b\u0012\u0004\u0012\u0002H501H\u0007¢\u0006\u0002\u0010@J\u0015\u0010A\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0005H\u0001¢\u0006\u0002\bBJ\r\u0010C\u001a\u00020\u0017H\u0001¢\u0006\u0002\bDJ\u0015\u0010E\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\bFJ\n\u0010G\u001a\u0004\u0018\u00010HH\u0007J\n\u0010I\u001a\u0004\u0018\u00010\u0005H\u0007J\u000f\u0010J\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010KJ\n\u0010L\u001a\u0004\u0018\u00010\u0005H\u0007J\n\u0010M\u001a\u0004\u0018\u00010\u0005H\u0007J\u000f\u0010N\u001a\u0004\u0018\u00010OH\u0007¢\u0006\u0002\u0010PJ\n\u0010Q\u001a\u0004\u0018\u00010\u0005H\u0007J\u000e\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00050SH\u0007J\n\u0010T\u001a\u0004\u0018\u00010UH\u0007J\n\u0010V\u001a\u0004\u0018\u00010WH\u0007J\n\u0010X\u001a\u0004\u0018\u00010YH\u0007J\n\u0010Z\u001a\u0004\u0018\u00010[H\u0007J\n\u0010\\\u001a\u0004\u0018\u00010]H\u0007J\n\u0010^\u001a\u0004\u0018\u00010\u0005H\u0007J\u000f\u0010_\u001a\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010KJ\n\u0010`\u001a\u0004\u0018\u00010aH\u0007J\n\u0010b\u001a\u0004\u0018\u00010cH\u0007J\n\u0010d\u001a\u0004\u0018\u00010eH\u0007J\n\u0010f\u001a\u0004\u0018\u00010gH\u0007J\b\u0010h\u001a\u00020\u0014H\u0007J\b\u0010i\u001a\u00020\u0014H\u0007J\b\u0010p\u001a\u00020qH\u0007J\u0010\u0010r\u001a\u00020\u00172\u0006\u0010s\u001a\u00020lH\u0007J\u0010\u0010t\u001a\u00020\u00172\u0006\u0010s\u001a\u00020lH\u0007J\r\u0010u\u001a\u00020\u0017H\u0001¢\u0006\u0002\bvJ\u0015\u0010w\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0005H\u0000¢\u0006\u0002\bxJ\r\u0010y\u001a\u00020\u0017H\u0000¢\u0006\u0002\bzR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u00100\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020201\u0012\u0004\u0012\u0002020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R.\u00103\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020201\u0012\u0004\u0012\u0002020\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010j\u001a\b\u0012\u0004\u0012\u00020l0kX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u00020nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010o¨\u0006{"}, d2 = {"Lcom/ss/android/lark/officesdk/manager/OfficeSDKManager;", "", "<init>", "()V", "TAG", "", "initConfig", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig;", "isFunctionAvailable", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "officeSDKGlobalComponent", "Lcom/ss/android/lark/officesdk/container/OfficeSDKGlobalComponent;", "officeSDKUserComponents", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/ss/android/lark/officesdk/container/OfficeSDKUserComponent;", "pendingUserComponentReady", "currentUid", "embeddedLarkHostEnabledProvider", "Lkotlin/Function0;", "", "embeddedLarkCurrentUserIdProvider", "configureEmbeddedLarkHost", "", "enabledProvider", "currentUserIdProvider", "isEmbeddedLarkHost", "getEmbeddedLarkCurrentUserId", "setGlobalComponent", "component", "setGlobalComponent$officesdk_core_release", "getOfficeSDKGlobalComponent", "registerOfficeSDKUserComponent", "uid", "unregisterOfficeSDKUserComponent", "getOfficeSDKUserComponent", "notifyOfficeSDKUserComponentReady", "notifyOfficeSDKUserComponentReady$officesdk_core_release", "dispatchPendingUserComponentReady", "dispatchPendingUserComponentReady$officesdk_core_release", "dispatchUserComponentReady", "globalComponent", "userComponent", "setCurrentUid", "setCurrentUid$officesdk_core_release", "clearCurrentUid", "clearCurrentUid$officesdk_core_release", "getCurrentUid", "globalServiceRegistry", "Ljava/lang/Class;", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "userServiceRegistry", "injectGlobalService", ExifInterface.GPS_DIRECTION_TRUE, "serviceClass", "service", "injectGlobalService$officesdk_core_release", "(Ljava/lang/Class;Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;)V", "injectUserService", "injectUserService$officesdk_core_release", "(Ljava/lang/String;Ljava/lang/Class;Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;)V", "getHostGlobalService", "(Ljava/lang/Class;)Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "getHostUserService", "(Ljava/lang/String;Ljava/lang/Class;)Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "clearUserServices", "clearUserServices$officesdk_core_release", "clearAllServices", "clearAllServices$officesdk_core_release", "setInitConfig", "setInitConfig$officesdk_core_release", "getContext", "Landroid/content/Context;", "getAppName", "isDebug", "()Ljava/lang/Boolean;", "getAppId", "getHostAppVersion", "getEnv", "", "()Ljava/lang/Integer;", "getTTEnv", "getJournalPaths", "", "getTokenProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKTokenProvider;", "getLifeCycle", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKLifeCycle;", "getDeviceInfoProvider", "Lcom/ss/android/lark/officesdk/api/init/IDeviceInfoProvider;", "getLanguageProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSdkLanguageProvider;", "getHostAppHeaderProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKHostAppHeaderProvider;", "getRequestTagBase", "isEnableNewTtnetLogReporter", "getHostSessionProvider", "Lcom/ss/android/lark/officesdk/api/IOfficeSDKHostSessionProvider;", "getUserServiceInjector", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKUserServiceInjector;", "getBizConfigProvider", "Lcom/ss/android/lark/officesdk/api/init/IOfficeSDKBizConfigProvider;", "getAppBuildConfig", "Lcom/ss/android/lark/officesdk/api/init/OfficeSDKInitConfig$AppBuildConfig;", "isInitialized", "isAvailable", "lifecycleListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/ss/android/lark/officesdk/interfaces/IOfficeSDKLifecycleListener;", "hostLifecycle", "com/ss/android/lark/officesdk/manager/OfficeSDKManager$hostLifecycle$1", "Lcom/ss/android/lark/officesdk/manager/OfficeSDKManager$hostLifecycle$1;", "getHostLifecycle", "Lcom/ss/android/lark/officesdk/api/service/capacity/IHostLifecycle;", "registerLifecycleListener", "listener", "unregisterLifecycleListener", "clearAllLifecycleListeners", "clearAllLifecycleListeners$officesdk_core_release", "hasPendingUserComponentReadyForTest", "hasPendingUserComponentReadyForTest$officesdk_core_release", "clearPendingUserComponentReadyForTest", "clearPendingUserComponentReadyForTest$officesdk_core_release", "officesdk-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSDKManager {
    public static final OfficeSDKManager INSTANCE = null;
    private static final String TAG = "OfficeSDKManager";
    private static volatile String currentUid;
    private static volatile Function0<String> embeddedLarkCurrentUserIdProvider;
    private static volatile Function0<Boolean> embeddedLarkHostEnabledProvider;
    private static final ConcurrentHashMap<Class<? extends IOfficeSDKProtocol>, IOfficeSDKProtocol> globalServiceRegistry = null;
    private static final a hostLifecycle = null;
    private static OfficeSDKInitConfig initConfig;
    private static final AtomicBoolean isFunctionAvailable = null;
    private static final CopyOnWriteArrayList<IOfficeSDKLifecycleListener> lifecycleListeners = null;
    private static OfficeSDKGlobalComponent officeSDKGlobalComponent;
    private static final ConcurrentHashMap<String, OfficeSDKUserComponent> officeSDKUserComponents = null;
    private static final ConcurrentHashMap<String, OfficeSDKUserComponent> pendingUserComponentReady = null;
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Class<? extends IOfficeSDKProtocol>, IOfficeSDKProtocol>> userServiceRegistry = null;

    public static final class a implements IHostLifecycle {
        public a() {
        }

        @Override // com.ss.android.lark.officesdk.api.service.capacity.IHostLifecycle
        public final void onPause(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Log.i(OfficeSDKManager.TAG, "hostLifecycle onPause, listeners count: " + OfficeSDKManager.access$getLifecycleListeners$p().size());
            Iterator r101 = OfficeSDKManager.access$getLifecycleListeners$p().iterator();
        L4:
            if (r101.hasNext() == false) goto L10;
            ((IOfficeSDKLifecycleListener) r101.next()).onPause(r100);     // Catch: Exception -> L8
        L8:
            e = move-exception;
            Log.e(OfficeSDKManager.TAG, "error in lifecycleListeners onPause", e);
            goto L4
        }

        @Override // com.ss.android.lark.officesdk.api.service.capacity.IHostLifecycle
        public final void onResume(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Log.i(OfficeSDKManager.TAG, "hostLifecycle onResume, listeners count: " + OfficeSDKManager.access$getLifecycleListeners$p().size());
            Iterator r101 = OfficeSDKManager.access$getLifecycleListeners$p().iterator();
        L4:
            if (r101.hasNext() == false) goto L10;
            ((IOfficeSDKLifecycleListener) r101.next()).onResume(r100);     // Catch: Exception -> L8
        L8:
            e = move-exception;
            Log.e(OfficeSDKManager.TAG, "error in lifecycleListeners onResume", e);
            goto L4
        }

        @Override // com.ss.android.lark.officesdk.api.service.capacity.IHostLifecycle
        public final void onStart(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Log.i(OfficeSDKManager.TAG, "hostLifecycle onStart, listeners count: " + OfficeSDKManager.access$getLifecycleListeners$p().size());
            Iterator r101 = OfficeSDKManager.access$getLifecycleListeners$p().iterator();
        L4:
            if (r101.hasNext() == false) goto L10;
            ((IOfficeSDKLifecycleListener) r101.next()).onStart(r100);     // Catch: Exception -> L8
        L8:
            e = move-exception;
            Log.e(OfficeSDKManager.TAG, "error in lifecycleListeners onStart", e);
            goto L4
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T, R> f433473a = null;

        static {
            f433473a = new b();
        }

        public b() {
        }

        @Override // java.util.function.Function
        public final Object apply(Object r100) {
            Intrinsics.checkNotNullParameter((String) r100, "it");
            return new ConcurrentHashMap();
        }
    }

    private OfficeSDKManager() {
    }

    static {
        INSTANCE = new OfficeSDKManager();
        isFunctionAvailable = new AtomicBoolean(false);
        officeSDKUserComponents = new ConcurrentHashMap();
        pendingUserComponentReady = new ConcurrentHashMap();
        embeddedLarkHostEnabledProvider = OfficeSDKManager$embeddedLarkHostEnabledProvider$1.INSTANCE;
        embeddedLarkCurrentUserIdProvider = OfficeSDKManager$embeddedLarkCurrentUserIdProvider$1.INSTANCE;
        globalServiceRegistry = new ConcurrentHashMap();
        userServiceRegistry = new ConcurrentHashMap();
        lifecycleListeners = new CopyOnWriteArrayList();
        hostLifecycle = new a();
    }

    @JvmStatic
    public static final void clearAllLifecycleListeners$officesdk_core_release() {
        lifecycleListeners.clear();
        Log.i(TAG, "clearAllLifecycleListeners");
    }

    @JvmStatic
    public static final void clearAllServices$officesdk_core_release() {
        globalServiceRegistry.clear();
        userServiceRegistry.clear();
        Log.i(TAG, "clearAllServices");
    }

    @JvmStatic
    public static final void dispatchPendingUserComponentReady$officesdk_core_release() {
        Iterator r100 = CollectionsKt.toList(pendingUserComponentReady.entrySet()).iterator();
    L4:
        if (r100.hasNext() == false) goto L11;
        Map.Entry r101 = (Map.Entry) r100.next();
        Intrinsics.checkNotNull(r101);
        String r102 = (String) r101.getKey();
        OfficeSDKUserComponent r103 = (OfficeSDKUserComponent) r101.getValue();
        if (officeSDKUserComponents.get(r102) != r103) goto L7;
        if (notifyOfficeSDKUserComponentReady$officesdk_core_release(r102, r103) == false) goto L4;
        pendingUserComponentReady.remove(r102, r103);
        goto L4
    L7:
        pendingUserComponentReady.remove(r102, r103);
        Log.w(TAG, "dispatchPendingUserComponentReady skipped stale component, uid: " + r102);
        goto L4
    }

    @JvmStatic
    public static final OfficeSDKInitConfig.AppBuildConfig getAppBuildConfig() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        OfficeSDKInitConfig.AppBuildConfig r101 = r100.getAppBuildConfig();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.i(TAG, "getAppBuildConfig: not set by host (optional)");
        return null;
    }

    @JvmStatic
    public static final String getAppId() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        String r101 = r100.getAppId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.w(TAG, "getAppId, OfficeSDK not init");
        return null;
    }

    @JvmStatic
    public static final String getAppName() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        String r101 = r100.getAppName();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.w(TAG, "getAppName, OfficeSDK not init");
        return null;
    }

    @JvmStatic
    public static final IOfficeSDKBizConfigProvider getBizConfigProvider() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        IOfficeSDKBizConfigProvider r101 = r100.getBizConfigProvider();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.i(TAG, "getBizConfigProvider: not set by host (optional)");
        return null;
    }

    @JvmStatic
    public static final Context getContext() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        Context r101 = r100.getContext();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.w(TAG, "getContext, OfficeSDK not init");
        return null;
    }

    @JvmStatic
    public static final IDeviceInfoProvider getDeviceInfoProvider() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        IDeviceInfoProvider r101 = r100.getDeviceInfoProvider();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.w(TAG, "getDeviceInfoProvider: OfficeSDK not initialized");
        return null;
    }

    @JvmStatic
    public static final String getEmbeddedLarkCurrentUserId() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(embeddedLarkCurrentUserIdProvider.invoke());     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L12;
        return null;
    L12:
        if ((!StringsKt.isBlank(r102)) == true) goto L14;
        return null;
    L14:
        return r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final Integer getEnv() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        Integer r101 = r100.getEnv();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.w(TAG, "getEnv, OfficeSDK not init");
        return null;
    }

    @JvmStatic
    public static final IOfficeSDKHostAppHeaderProvider getHostAppHeaderProvider() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        IOfficeSDKHostAppHeaderProvider r101 = r100.getHostAppHeaderProvider();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.i(TAG, "getHostAppHeaderProvider: not set by host (optional)");
        return null;
    }

    @JvmStatic
    public static final String getHostAppVersion() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        String r101 = r100.getHostAppVersion();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.w(TAG, "getHostAppVersion, OfficeSDK not init");
        return null;
    }

    @JvmStatic
    public static final IOfficeSDKHostSessionProvider getHostSessionProvider() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getHostSessionProvider();
    }

    @JvmStatic
    public static final List<String> getJournalPaths() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        List<String> r101 = r100.getJournalPaths();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.w(TAG, "getJournalPaths, OfficeSDK not init");
        return CollectionsKt.emptyList();
    }

    @JvmStatic
    public static final IOfficeSdkLanguageProvider getLanguageProvider() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        IOfficeSdkLanguageProvider r101 = r100.getLanguageProvider();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.w(TAG, "getLanguageProvider: OfficeSDK not initialized");
        return null;
    }

    @JvmStatic
    public static final IOfficeSDKLifeCycle getLifeCycle() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        IOfficeSDKLifeCycle r101 = r100.getOfficeSDKLifeCycle();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.w(TAG, "getLifeCycle, OfficeSDK not init");
        return null;
    }

    @JvmStatic
    public static final OfficeSDKUserComponent getOfficeSDKUserComponent() {
        String r100 = currentUid;
        if (r100 != null) goto L7;
        return null;
    L7:
        return officeSDKUserComponents.get(r100);
    }

    @JvmStatic
    public static final String getRequestTagBase() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        String r101 = r100.getRequestTagBase();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.i(TAG, "getRequestTagBase: not set by host (optional)");
        return null;
    }

    @JvmStatic
    public static final String getTTEnv() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        String r101 = r100.getTtEnv();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.w(TAG, "getTTEnv, OfficeSDK not init");
        return null;
    }

    @JvmStatic
    public static final IOfficeSDKTokenProvider getTokenProvider() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        IOfficeSDKTokenProvider r101 = r100.getTokenProvider();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.w(TAG, "getTokenProvider, OfficeSDK not init");
        return null;
    }

    @JvmStatic
    public static final IOfficeSDKUserServiceInjector getUserServiceInjector() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getUserServiceInjector();
    }

    @JvmStatic
    public static final boolean isAvailable() {
        return isFunctionAvailable.get();
    }

    @JvmStatic
    public static final Boolean isDebug() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 != null) goto L7;
        Log.w(TAG, "isDebug, OfficeSDK not init");
        return null;
    L7:
        return Boolean.valueOf(r100.isDebug());
    }

    @JvmStatic
    public static final boolean isEmbeddedLarkHost() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(embeddedLarkHostEnabledProvider.invoke().booleanValue()));     // Catch: Throwable -> L4
    L6:
        Boolean r102 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = r102;
    L10:
        return ((Boolean) r101).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @JvmStatic
    public static final Boolean isEnableNewTtnetLogReporter() {
        OfficeSDKInitConfig r100 = initConfig;
        if (r100 == null) goto L6;
        Boolean r101 = r100.getEnableNewTtnetLogReporter();
        if (r101 == null) goto L6;
        return r101;
    L6:
        Log.i(TAG, "isEnableNewTtnetLogReporter: not set by host (optional)");
        return null;
    }

    @JvmStatic
    public static final boolean isInitialized() {
        if (initConfig == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void clearPendingUserComponentReadyForTest$officesdk_core_release() {
        pendingUserComponentReady.clear();
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getLifecycleListeners$p() {
        return lifecycleListeners;
    }

    @JvmStatic
    public static final String getCurrentUid() {
        return currentUid;
    }

    @JvmStatic
    public static final IHostLifecycle getHostLifecycle() {
        return hostLifecycle;
    }

    @JvmStatic
    public static final OfficeSDKGlobalComponent getOfficeSDKGlobalComponent() {
        return officeSDKGlobalComponent;
    }

    public final AtomicBoolean isFunctionAvailable() {
        return isFunctionAvailable;
    }

    @JvmStatic
    public static final void clearCurrentUid$officesdk_core_release(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        if (Intrinsics.areEqual(currentUid, r100) == false) goto L5;
        currentUid = null;
        Log.i(TAG, "clearCurrentUid: cleared for " + r100);
        return;
    L5:
        Log.w(TAG, "clearCurrentUid: skipped. current: " + currentUid + ", target: " + r100);
    }

    @JvmStatic
    public static final void clearUserServices$officesdk_core_release(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        userServiceRegistry.remove(r100);
        Log.i(TAG, "clearUserServices, uid: " + r100);
    }

    @JvmStatic
    public static final <T extends IOfficeSDKProtocol> T getHostGlobalService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "serviceClass");
        IOfficeSDKProtocol r101 = globalServiceRegistry.get(r100);
        if ((r101 instanceof IOfficeSDKProtocol) == false) goto L5;
        T r102 = (T) r101;
    L6:
        if (r102 != null) goto L8;
        Log.w(TAG, "global service not found: ".concat(r100.getSimpleName()));
    L8:
        return r102;
    L5:
        r102 = null;
        goto L6
    }

    @JvmStatic
    public static final void registerLifecycleListener(IOfficeSDKLifecycleListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        CopyOnWriteArrayList<IOfficeSDKLifecycleListener> r101 = lifecycleListeners;
        if (r101.contains(r100) == true) goto L6;
        r101.add(r100);
        Log.i(TAG, "registerLifecycleListener, listener: ".concat(r100.getClass().getSimpleName()));
        return;
    }

    @JvmStatic
    public static final void setCurrentUid$officesdk_core_release(String r100) {
        currentUid = r100;
        if (r100 != null) goto L5;
        r100 = "cleared";
    L5:
        Log.i(TAG, "setCurrentUid: ".concat(r100));
    }

    @JvmStatic
    public static final void setGlobalComponent$officesdk_core_release(OfficeSDKGlobalComponent r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        officeSDKGlobalComponent = r100;
        Log.i(TAG, "setGlobalComponent");
    }

    @JvmStatic
    public static final void setInitConfig$officesdk_core_release(OfficeSDKInitConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "initConfig");
        initConfig = r100;
        Log.i(TAG, "initConfig, appName: " + r100.getAppName());
    }

    @JvmStatic
    public static final void unregisterLifecycleListener(IOfficeSDKLifecycleListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (lifecycleListeners.remove(r100) == false) goto L6;
        Log.i(TAG, "unregisterLifecycleListener, listener: ".concat(r100.getClass().getSimpleName()));
        return;
    }

    @JvmStatic
    public static final void unregisterOfficeSDKUserComponent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        officeSDKUserComponents.remove(r100);
        pendingUserComponentReady.remove(r100);
        Log.i(TAG, "unregisterOfficeSDKUserComponent: " + r100);
    }

    public final boolean hasPendingUserComponentReadyForTest$officesdk_core_release(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return pendingUserComponentReady.containsKey(r100);
    }

    @JvmStatic
    public static final void configureEmbeddedLarkHost(Function0<Boolean> r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "enabledProvider");
        Intrinsics.checkNotNullParameter(r101, "currentUserIdProvider");
        embeddedLarkHostEnabledProvider = r100;
        embeddedLarkCurrentUserIdProvider = r101;
        Log.i(TAG, "configureEmbeddedFeishuHost");
    }

    @JvmStatic
    public static final <T extends IOfficeSDKProtocol> T getHostUserService(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "serviceClass");
        ConcurrentHashMap<Class<? extends IOfficeSDKProtocol>, IOfficeSDKProtocol> r102 = userServiceRegistry.get(r100);
        T r103 = null;
        if (r102 == null) goto L5;
        IOfficeSDKProtocol r104 = r102.get(r101);
    L7:
        if ((r104 instanceof IOfficeSDKProtocol) == false) goto L9;
        r103 = (T) r104;
    L9:
        if (r103 != null) goto L11;
        Log.w(TAG, "user service not found: " + r101.getSimpleName() + ", uid: " + r100);
    L11:
        return r103;
    L5:
        r104 = null;
        goto L7
    }

    @JvmStatic
    public static final <T extends IOfficeSDKProtocol> void injectGlobalService$officesdk_core_release(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "serviceClass");
        Intrinsics.checkNotNullParameter(r101, "service");
        globalServiceRegistry.put(r100, r101);
        Log.i(TAG, "injectGlobalService: ".concat(r100.getSimpleName()));
    }

    @JvmStatic
    public static final boolean notifyOfficeSDKUserComponentReady$officesdk_core_release(String r100, OfficeSDKUserComponent r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "component");
        OfficeSDKGlobalComponent r102 = officeSDKGlobalComponent;
        if (r102 != null) goto L7;
        pendingUserComponentReady.put(r100, r101);
        Log.w(TAG, "notifyOfficeSDKUserComponentReady pending, globalComponent is null, uid: " + r100);
        return false;
    L7:
        return INSTANCE.dispatchUserComponentReady(r102, r100, r101);
    }

    @JvmStatic
    public static final void registerOfficeSDKUserComponent(String r100, OfficeSDKUserComponent r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "component");
        officeSDKUserComponents.put(r100, r101);
        Log.i(TAG, "registerOfficeSDKUserComponent: " + r100);
    }

    @JvmStatic
    public static final void unregisterOfficeSDKUserComponent(String r100, OfficeSDKUserComponent r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "component");
        boolean r102 = officeSDKUserComponents.remove(r100, r101);
        pendingUserComponentReady.remove(r100, r101);
        if (r102 == false) goto L5;
        Log.i(TAG, "unregisterOfficeSDKUserComponent: " + r100);
        return;
    L5:
        Log.w(TAG, "unregisterOfficeSDKUserComponent skipped stale component, uid: " + r100);
    }

    private final boolean dispatchUserComponentReady(OfficeSDKGlobalComponent r100, String r101, OfficeSDKUserComponent r102) {
        IOfficeSDKLifeCycle r103 = ((OfficeSDKGlobalEntryPoint) EntryPoints.get(r100, OfficeSDKGlobalEntryPoint.class)).getOfficeSDKLifeCycle();     // Catch: Exception -> L11
        OfficeSDKUserApi r104 = ((OfficeSDKUserEntryPoint) EntryPoints.get(r102, OfficeSDKUserEntryPoint.class)).getOfficeSDKUserApi();     // Catch: Exception -> L11
        r103.onUserComponentReady(r104);     // Catch: Exception -> L11
        if (isEmbeddedLarkHost() == true) goto L6;
    L8:
        Log.i(TAG, "dispatchUserComponentReady: callback invoked, uid: " + r101);     // Catch: Exception -> L11
        return true;
    L6:
        if (Intrinsics.areEqual(getCurrentUid(), r101) == false) goto L8;
        r103.onLoginSuccess(r104);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Log.e(TAG, "dispatchUserComponentReady: failed, uid: " + r101, e);
        return false;
    }

    @JvmStatic
    public static final <T extends IOfficeSDKProtocol> void injectUserService$officesdk_core_release(String r100, Class<T> r101, T r102) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "serviceClass");
        Intrinsics.checkNotNullParameter(r102, "service");
        userServiceRegistry.computeIfAbsent(r100, b.f433473a).put(r101, r102);
        Log.i(TAG, "injectUserService: " + r101.getSimpleName() + ", uid: " + r100);
    }
}
