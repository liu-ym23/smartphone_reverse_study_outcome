package com.ss.android.downloadlib.addownload.config;

import com.ss.android.download.api.config.DownLoadBottomLibraryConfig;
import com.ss.android.download.api.config.DownloadBpeaCertFactory;
import com.ss.android.download.api.config.DownloadClearSpaceListener;
import com.ss.android.download.api.config.DownloadEventLogger;
import com.ss.android.download.api.config.DownloadNetworkFactory;
import com.ss.android.download.api.config.DownloadPermissionChecker;
import com.ss.android.download.api.config.DownloadProgressHandleFactory;
import com.ss.android.download.api.config.DownloadPushFactory;
import com.ss.android.download.api.config.DownloadSettings;
import com.ss.android.download.api.config.DownloadTLogger;
import com.ss.android.download.api.config.DownloadTaskQueueHandleFactory;
import com.ss.android.download.api.config.DownloadUIFactory;
import com.ss.android.download.api.config.DownloadUserEventLogger;
import com.ss.android.download.api.config.IApkUpdateHandler;
import com.ss.android.download.api.config.ICleanManager;
import com.ss.android.download.api.config.IDownloaderMonitor;
import com.ss.android.download.api.config.IEncryptor;
import com.ss.android.download.api.model.AppInfo;
import com.ss.android.download.api.runtime.IAdDownloadActionProvider;
import com.ss.android.download.api.runtime.IAdDownloadCheckerProvider;
import com.ss.android.downloadlib.utils.TTSlardarMonitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 V2\u00020\u0001:\u0002UVB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u00101\u001a\u0004\u0018\u000102¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u00105\u001a\u0004\u0018\u000106¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u00109\u001a\u0004\u0018\u00010:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010=\u001a\u0004\u0018\u00010>¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010A\u001a\u0004\u0018\u00010B¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010E\u001a\u0004\u0018\u00010F¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010I\u001a\u0004\u0018\u00010J¢\u0006\b\n\u0000\u001a\u0004\bK\u0010LR\u0013\u0010M\u001a\u0004\u0018\u00010N¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0013\u0010Q\u001a\u0004\u0018\u00010R¢\u0006\b\n\u0000\u001a\u0004\bS\u0010T¨\u0006W"}, d2 = {"Lcom/ss/android/downloadlib/addownload/config/TTDownloaderConfigure;", "", "builder", "Lcom/ss/android/downloadlib/addownload/config/TTDownloaderConfigure$Builder;", "(Lcom/ss/android/downloadlib/addownload/config/TTDownloaderConfigure$Builder;)V", "apkUpdateManager", "Lcom/ss/android/download/api/config/IApkUpdateHandler;", "getApkUpdateManager", "()Lcom/ss/android/download/api/config/IApkUpdateHandler;", "appUserInfo", "Lcom/ss/android/download/api/model/AppInfo;", "getAppUserInfo", "()Lcom/ss/android/download/api/model/AppInfo;", "bottomLibraryConfig", "Lcom/ss/android/download/api/config/DownLoadBottomLibraryConfig;", "getBottomLibraryConfig", "()Lcom/ss/android/download/api/config/DownLoadBottomLibraryConfig;", "cleanManger", "Lcom/ss/android/download/api/config/ICleanManager;", "getCleanManger", "()Lcom/ss/android/download/api/config/ICleanManager;", "downloadActionFactory", "Lcom/ss/android/download/api/runtime/IAdDownloadActionProvider;", "getDownloadActionFactory", "()Lcom/ss/android/download/api/runtime/IAdDownloadActionProvider;", "downloadBpeaCertFactory", "Lcom/ss/android/download/api/config/DownloadBpeaCertFactory;", "getDownloadBpeaCertFactory", "()Lcom/ss/android/download/api/config/DownloadBpeaCertFactory;", "downloadCheckerFactory", "Lcom/ss/android/download/api/runtime/IAdDownloadCheckerProvider;", "getDownloadCheckerFactory", "()Lcom/ss/android/download/api/runtime/IAdDownloadCheckerProvider;", "downloadClearSpaceListener", "Lcom/ss/android/download/api/config/DownloadClearSpaceListener;", "getDownloadClearSpaceListener", "()Lcom/ss/android/download/api/config/DownloadClearSpaceListener;", "downloadProgressHandleFactory", "Lcom/ss/android/download/api/config/DownloadProgressHandleFactory;", "getDownloadProgressHandleFactory", "()Lcom/ss/android/download/api/config/DownloadProgressHandleFactory;", "downloadPushFactory", "Lcom/ss/android/download/api/config/DownloadPushFactory;", "getDownloadPushFactory", "()Lcom/ss/android/download/api/config/DownloadPushFactory;", "downloadTaskQueueHandleFactory", "Lcom/ss/android/download/api/config/DownloadTaskQueueHandleFactory;", "getDownloadTaskQueueHandleFactory", "()Lcom/ss/android/download/api/config/DownloadTaskQueueHandleFactory;", "downloadUserEventLogger", "Lcom/ss/android/download/api/config/DownloadUserEventLogger;", "getDownloadUserEventLogger", "()Lcom/ss/android/download/api/config/DownloadUserEventLogger;", "encryptor", "Lcom/ss/android/download/api/config/IEncryptor;", "getEncryptor", "()Lcom/ss/android/download/api/config/IEncryptor;", "eventListener", "Lcom/ss/android/download/api/config/DownloadEventLogger;", "getEventListener", "()Lcom/ss/android/download/api/config/DownloadEventLogger;", "monitor", "Lcom/ss/android/download/api/config/IDownloaderMonitor;", "getMonitor", "()Lcom/ss/android/download/api/config/IDownloaderMonitor;", "networkFactory", "Lcom/ss/android/download/api/config/DownloadNetworkFactory;", "getNetworkFactory", "()Lcom/ss/android/download/api/config/DownloadNetworkFactory;", "permissionChecker", "Lcom/ss/android/download/api/config/DownloadPermissionChecker;", "getPermissionChecker", "()Lcom/ss/android/download/api/config/DownloadPermissionChecker;", "settings", "Lcom/ss/android/download/api/config/DownloadSettings;", "getSettings", "()Lcom/ss/android/download/api/config/DownloadSettings;", "tLogger", "Lcom/ss/android/download/api/config/DownloadTLogger;", "getTLogger", "()Lcom/ss/android/download/api/config/DownloadTLogger;", "uiFactory", "Lcom/ss/android/download/api/config/DownloadUIFactory;", "getUiFactory", "()Lcom/ss/android/download/api/config/DownloadUIFactory;", "Builder", "Companion", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public final class TTDownloaderConfigure {
    public static final Companion Companion = null;
    private final IApkUpdateHandler apkUpdateManager;
    private final AppInfo appUserInfo;
    private final DownLoadBottomLibraryConfig bottomLibraryConfig;
    private final ICleanManager cleanManger;
    private final IAdDownloadActionProvider downloadActionFactory;
    private final DownloadBpeaCertFactory downloadBpeaCertFactory;
    private final IAdDownloadCheckerProvider downloadCheckerFactory;
    private final DownloadClearSpaceListener downloadClearSpaceListener;
    private final DownloadProgressHandleFactory downloadProgressHandleFactory;
    private final DownloadPushFactory downloadPushFactory;
    private final DownloadTaskQueueHandleFactory downloadTaskQueueHandleFactory;
    private final DownloadUserEventLogger downloadUserEventLogger;
    private final IEncryptor encryptor;
    private final DownloadEventLogger eventListener;
    private final IDownloaderMonitor monitor;
    private final DownloadNetworkFactory networkFactory;
    private final DownloadPermissionChecker permissionChecker;
    private final DownloadSettings settings;
    private final DownloadTLogger tLogger;
    private final DownloadUIFactory uiFactory;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010{\u001a\u00020|R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010W\u001a\u0004\u0018\u00010XX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001c\u0010]\u001a\u0004\u0018\u00010^X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010c\u001a\u0004\u0018\u00010dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010i\u001a\u0004\u0018\u00010jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001c\u0010o\u001a\u0004\u0018\u00010pX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001c\u0010u\u001a\u0004\u0018\u00010vX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010z¨\u0006}"}, d2 = {"Lcom/ss/android/downloadlib/addownload/config/TTDownloaderConfigure$Builder;", "", "()V", "apkUpdateManager", "Lcom/ss/android/download/api/config/IApkUpdateHandler;", "getApkUpdateManager", "()Lcom/ss/android/download/api/config/IApkUpdateHandler;", "setApkUpdateManager", "(Lcom/ss/android/download/api/config/IApkUpdateHandler;)V", "appInfo", "Lcom/ss/android/download/api/model/AppInfo;", "getAppInfo", "()Lcom/ss/android/download/api/model/AppInfo;", "setAppInfo", "(Lcom/ss/android/download/api/model/AppInfo;)V", "bottomLibraryConfig", "Lcom/ss/android/download/api/config/DownLoadBottomLibraryConfig;", "getBottomLibraryConfig", "()Lcom/ss/android/download/api/config/DownLoadBottomLibraryConfig;", "setBottomLibraryConfig", "(Lcom/ss/android/download/api/config/DownLoadBottomLibraryConfig;)V", "cleanManger", "Lcom/ss/android/download/api/config/ICleanManager;", "getCleanManger", "()Lcom/ss/android/download/api/config/ICleanManager;", "setCleanManger", "(Lcom/ss/android/download/api/config/ICleanManager;)V", "downloadActionFactory", "Lcom/ss/android/download/api/runtime/IAdDownloadActionProvider;", "getDownloadActionFactory", "()Lcom/ss/android/download/api/runtime/IAdDownloadActionProvider;", "setDownloadActionFactory", "(Lcom/ss/android/download/api/runtime/IAdDownloadActionProvider;)V", "downloadBpeaCertFactory", "Lcom/ss/android/download/api/config/DownloadBpeaCertFactory;", "getDownloadBpeaCertFactory", "()Lcom/ss/android/download/api/config/DownloadBpeaCertFactory;", "setDownloadBpeaCertFactory", "(Lcom/ss/android/download/api/config/DownloadBpeaCertFactory;)V", "downloadCheckerFactory", "Lcom/ss/android/download/api/runtime/IAdDownloadCheckerProvider;", "getDownloadCheckerFactory", "()Lcom/ss/android/download/api/runtime/IAdDownloadCheckerProvider;", "setDownloadCheckerFactory", "(Lcom/ss/android/download/api/runtime/IAdDownloadCheckerProvider;)V", "downloadClearSpaceListener", "Lcom/ss/android/download/api/config/DownloadClearSpaceListener;", "getDownloadClearSpaceListener", "()Lcom/ss/android/download/api/config/DownloadClearSpaceListener;", "setDownloadClearSpaceListener", "(Lcom/ss/android/download/api/config/DownloadClearSpaceListener;)V", "downloadProgressHandleFactory", "Lcom/ss/android/download/api/config/DownloadProgressHandleFactory;", "getDownloadProgressHandleFactory", "()Lcom/ss/android/download/api/config/DownloadProgressHandleFactory;", "setDownloadProgressHandleFactory", "(Lcom/ss/android/download/api/config/DownloadProgressHandleFactory;)V", "downloadPushFactory", "Lcom/ss/android/download/api/config/DownloadPushFactory;", "getDownloadPushFactory", "()Lcom/ss/android/download/api/config/DownloadPushFactory;", "setDownloadPushFactory", "(Lcom/ss/android/download/api/config/DownloadPushFactory;)V", "downloadTaskQueueHandleFactory", "Lcom/ss/android/download/api/config/DownloadTaskQueueHandleFactory;", "getDownloadTaskQueueHandleFactory", "()Lcom/ss/android/download/api/config/DownloadTaskQueueHandleFactory;", "setDownloadTaskQueueHandleFactory", "(Lcom/ss/android/download/api/config/DownloadTaskQueueHandleFactory;)V", "downloadUserEventLogger", "Lcom/ss/android/download/api/config/DownloadUserEventLogger;", "getDownloadUserEventLogger", "()Lcom/ss/android/download/api/config/DownloadUserEventLogger;", "setDownloadUserEventLogger", "(Lcom/ss/android/download/api/config/DownloadUserEventLogger;)V", "encryptor", "Lcom/ss/android/download/api/config/IEncryptor;", "getEncryptor", "()Lcom/ss/android/download/api/config/IEncryptor;", "setEncryptor", "(Lcom/ss/android/download/api/config/IEncryptor;)V", "eventListener", "Lcom/ss/android/download/api/config/DownloadEventLogger;", "getEventListener", "()Lcom/ss/android/download/api/config/DownloadEventLogger;", "setEventListener", "(Lcom/ss/android/download/api/config/DownloadEventLogger;)V", "monitor", "Lcom/ss/android/download/api/config/IDownloaderMonitor;", "getMonitor", "()Lcom/ss/android/download/api/config/IDownloaderMonitor;", "setMonitor", "(Lcom/ss/android/download/api/config/IDownloaderMonitor;)V", "networkFactory", "Lcom/ss/android/download/api/config/DownloadNetworkFactory;", "getNetworkFactory", "()Lcom/ss/android/download/api/config/DownloadNetworkFactory;", "setNetworkFactory", "(Lcom/ss/android/download/api/config/DownloadNetworkFactory;)V", "permissionChecker", "Lcom/ss/android/download/api/config/DownloadPermissionChecker;", "getPermissionChecker", "()Lcom/ss/android/download/api/config/DownloadPermissionChecker;", "setPermissionChecker", "(Lcom/ss/android/download/api/config/DownloadPermissionChecker;)V", "settings", "Lcom/ss/android/download/api/config/DownloadSettings;", "getSettings", "()Lcom/ss/android/download/api/config/DownloadSettings;", "setSettings", "(Lcom/ss/android/download/api/config/DownloadSettings;)V", "tLogger", "Lcom/ss/android/download/api/config/DownloadTLogger;", "getTLogger", "()Lcom/ss/android/download/api/config/DownloadTLogger;", "setTLogger", "(Lcom/ss/android/download/api/config/DownloadTLogger;)V", "uiFactory", "Lcom/ss/android/download/api/config/DownloadUIFactory;", "getUiFactory", "()Lcom/ss/android/download/api/config/DownloadUIFactory;", "setUiFactory", "(Lcom/ss/android/download/api/config/DownloadUIFactory;)V", "build", "Lcom/ss/android/downloadlib/addownload/config/TTDownloaderConfigure;", "download-impl_release"}, k = 1, mv = {1, 1, 16})
    public static final class Builder {
        private IApkUpdateHandler apkUpdateManager;
        private AppInfo appInfo;
        private DownLoadBottomLibraryConfig bottomLibraryConfig;
        private ICleanManager cleanManger;
        private IAdDownloadActionProvider downloadActionFactory;
        private DownloadBpeaCertFactory downloadBpeaCertFactory;
        private IAdDownloadCheckerProvider downloadCheckerFactory;
        private DownloadClearSpaceListener downloadClearSpaceListener;
        private DownloadProgressHandleFactory downloadProgressHandleFactory;
        private DownloadPushFactory downloadPushFactory;
        private DownloadTaskQueueHandleFactory downloadTaskQueueHandleFactory;
        private DownloadUserEventLogger downloadUserEventLogger;
        private IEncryptor encryptor;
        private DownloadEventLogger eventListener;
        private IDownloaderMonitor monitor;
        private DownloadNetworkFactory networkFactory;
        private DownloadPermissionChecker permissionChecker;
        private DownloadSettings settings;
        private DownloadTLogger tLogger;
        private DownloadUIFactory uiFactory;

        public final TTDownloaderConfigure build() {
            return new TTDownloaderConfigure(this, null);
        }

        public Builder() {
            this.monitor = TTSlardarMonitor.getInstance();
        }

        public final IApkUpdateHandler getApkUpdateManager() {
            return this.apkUpdateManager;
        }

        public final AppInfo getAppInfo() {
            return this.appInfo;
        }

        public final DownLoadBottomLibraryConfig getBottomLibraryConfig() {
            return this.bottomLibraryConfig;
        }

        public final ICleanManager getCleanManger() {
            return this.cleanManger;
        }

        public final IAdDownloadActionProvider getDownloadActionFactory() {
            return this.downloadActionFactory;
        }

        public final DownloadBpeaCertFactory getDownloadBpeaCertFactory() {
            return this.downloadBpeaCertFactory;
        }

        public final IAdDownloadCheckerProvider getDownloadCheckerFactory() {
            return this.downloadCheckerFactory;
        }

        public final DownloadClearSpaceListener getDownloadClearSpaceListener() {
            return this.downloadClearSpaceListener;
        }

        public final DownloadProgressHandleFactory getDownloadProgressHandleFactory() {
            return this.downloadProgressHandleFactory;
        }

        public final DownloadPushFactory getDownloadPushFactory() {
            return this.downloadPushFactory;
        }

        public final DownloadTaskQueueHandleFactory getDownloadTaskQueueHandleFactory() {
            return this.downloadTaskQueueHandleFactory;
        }

        public final DownloadUserEventLogger getDownloadUserEventLogger() {
            return this.downloadUserEventLogger;
        }

        public final IEncryptor getEncryptor() {
            return this.encryptor;
        }

        public final DownloadEventLogger getEventListener() {
            return this.eventListener;
        }

        public final IDownloaderMonitor getMonitor() {
            return this.monitor;
        }

        public final DownloadNetworkFactory getNetworkFactory() {
            return this.networkFactory;
        }

        public final DownloadPermissionChecker getPermissionChecker() {
            return this.permissionChecker;
        }

        public final DownloadSettings getSettings() {
            return this.settings;
        }

        public final DownloadTLogger getTLogger() {
            return this.tLogger;
        }

        public final DownloadUIFactory getUiFactory() {
            return this.uiFactory;
        }

        public final void setApkUpdateManager(IApkUpdateHandler r100) {
            this.apkUpdateManager = r100;
        }

        public final void setAppInfo(AppInfo r100) {
            this.appInfo = r100;
        }

        public final void setBottomLibraryConfig(DownLoadBottomLibraryConfig r100) {
            this.bottomLibraryConfig = r100;
        }

        public final void setCleanManger(ICleanManager r100) {
            this.cleanManger = r100;
        }

        public final void setDownloadActionFactory(IAdDownloadActionProvider r100) {
            this.downloadActionFactory = r100;
        }

        public final void setDownloadBpeaCertFactory(DownloadBpeaCertFactory r100) {
            this.downloadBpeaCertFactory = r100;
        }

        public final void setDownloadCheckerFactory(IAdDownloadCheckerProvider r100) {
            this.downloadCheckerFactory = r100;
        }

        public final void setDownloadClearSpaceListener(DownloadClearSpaceListener r100) {
            this.downloadClearSpaceListener = r100;
        }

        public final void setDownloadProgressHandleFactory(DownloadProgressHandleFactory r100) {
            this.downloadProgressHandleFactory = r100;
        }

        public final void setDownloadPushFactory(DownloadPushFactory r100) {
            this.downloadPushFactory = r100;
        }

        public final void setDownloadTaskQueueHandleFactory(DownloadTaskQueueHandleFactory r100) {
            this.downloadTaskQueueHandleFactory = r100;
        }

        public final void setDownloadUserEventLogger(DownloadUserEventLogger r100) {
            this.downloadUserEventLogger = r100;
        }

        public final void setEncryptor(IEncryptor r100) {
            this.encryptor = r100;
        }

        public final void setEventListener(DownloadEventLogger r100) {
            this.eventListener = r100;
        }

        public final void setMonitor(IDownloaderMonitor r100) {
            this.monitor = r100;
        }

        public final void setNetworkFactory(DownloadNetworkFactory r100) {
            this.networkFactory = r100;
        }

        public final void setPermissionChecker(DownloadPermissionChecker r100) {
            this.permissionChecker = r100;
        }

        public final void setSettings(DownloadSettings r100) {
            this.settings = r100;
        }

        public final void setTLogger(DownloadTLogger r100) {
            this.tLogger = r100;
        }

        public final void setUiFactory(DownloadUIFactory r100) {
            this.uiFactory = r100;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\b¨\u0006\n"}, d2 = {"Lcom/ss/android/downloadlib/addownload/config/TTDownloaderConfigure$Companion;", "", "()V", "build", "Lcom/ss/android/downloadlib/addownload/config/TTDownloaderConfigure;", "block", "Lkotlin/Function1;", "Lcom/ss/android/downloadlib/addownload/config/TTDownloaderConfigure$Builder;", "", "Lkotlin/ExtensionFunctionType;", "download-impl_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final TTDownloaderConfigure build(Function1<? super Builder, Unit> r100) {
            Builder r101 = new Builder();
            r100.invoke(r101);
            return r101.build();
        }

        public static /* synthetic */ TTDownloaderConfigure build$default(Companion r100, Function1 r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L5;
            r101 = TTDownloaderConfigure$Companion$build$1.INSTANCE;
        L5:
            Builder r104 = new Builder();
            r101.invoke(r104);
            return r104.build();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final TTDownloaderConfigure build(Function1<? super Builder, Unit> r100) {
        return Companion.build(r100);
    }

    public final IApkUpdateHandler getApkUpdateManager() {
        return this.apkUpdateManager;
    }

    public final AppInfo getAppUserInfo() {
        return this.appUserInfo;
    }

    public final DownLoadBottomLibraryConfig getBottomLibraryConfig() {
        return this.bottomLibraryConfig;
    }

    public final ICleanManager getCleanManger() {
        return this.cleanManger;
    }

    public final IAdDownloadActionProvider getDownloadActionFactory() {
        return this.downloadActionFactory;
    }

    public final DownloadBpeaCertFactory getDownloadBpeaCertFactory() {
        return this.downloadBpeaCertFactory;
    }

    public final IAdDownloadCheckerProvider getDownloadCheckerFactory() {
        return this.downloadCheckerFactory;
    }

    public final DownloadClearSpaceListener getDownloadClearSpaceListener() {
        return this.downloadClearSpaceListener;
    }

    public final DownloadProgressHandleFactory getDownloadProgressHandleFactory() {
        return this.downloadProgressHandleFactory;
    }

    public final DownloadPushFactory getDownloadPushFactory() {
        return this.downloadPushFactory;
    }

    public final DownloadTaskQueueHandleFactory getDownloadTaskQueueHandleFactory() {
        return this.downloadTaskQueueHandleFactory;
    }

    public final DownloadUserEventLogger getDownloadUserEventLogger() {
        return this.downloadUserEventLogger;
    }

    public final IEncryptor getEncryptor() {
        return this.encryptor;
    }

    public final DownloadEventLogger getEventListener() {
        return this.eventListener;
    }

    public final IDownloaderMonitor getMonitor() {
        return this.monitor;
    }

    public final DownloadNetworkFactory getNetworkFactory() {
        return this.networkFactory;
    }

    public final DownloadPermissionChecker getPermissionChecker() {
        return this.permissionChecker;
    }

    public final DownloadSettings getSettings() {
        return this.settings;
    }

    public final DownloadTLogger getTLogger() {
        return this.tLogger;
    }

    public final DownloadUIFactory getUiFactory() {
        return this.uiFactory;
    }

    private TTDownloaderConfigure(Builder r100) {
        this.apkUpdateManager = r100.getApkUpdateManager();
        this.permissionChecker = r100.getPermissionChecker();
        this.eventListener = r100.getEventListener();
        this.uiFactory = r100.getUiFactory();
        this.networkFactory = r100.getNetworkFactory();
        this.settings = r100.getSettings();
        this.tLogger = r100.getTLogger();
        this.monitor = r100.getMonitor();
        this.appUserInfo = r100.getAppInfo();
        this.encryptor = r100.getEncryptor();
        this.downloadActionFactory = r100.getDownloadActionFactory();
        this.bottomLibraryConfig = r100.getBottomLibraryConfig();
        this.downloadCheckerFactory = r100.getDownloadCheckerFactory();
        this.downloadPushFactory = r100.getDownloadPushFactory();
        this.cleanManger = r100.getCleanManger();
        this.downloadClearSpaceListener = r100.getDownloadClearSpaceListener();
        this.downloadBpeaCertFactory = r100.getDownloadBpeaCertFactory();
        this.downloadProgressHandleFactory = r100.getDownloadProgressHandleFactory();
        this.downloadTaskQueueHandleFactory = r100.getDownloadTaskQueueHandleFactory();
        this.downloadUserEventLogger = r100.getDownloadUserEventLogger();
    }

    public /* synthetic */ TTDownloaderConfigure(Builder r100, DefaultConstructorMarker r101) {
        this(r100);
    }
}
