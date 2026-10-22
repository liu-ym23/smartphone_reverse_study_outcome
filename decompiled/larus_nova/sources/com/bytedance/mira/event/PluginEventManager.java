package com.bytedance.mira.event;

import com.bytedance.mira.log.MiraLogger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PluginEventManager {
    private static final String TAG = "PluginEventManager";
    private static volatile PluginEventManager sInstance;
    private final List<PluginEventListener> mPluginLogListeners;

    /* JADX INFO: loaded from: classes21.dex */
    public static final class InstallStatusCode {
        public static final int INSTALL_CHECK_HOST_COMPAT_FAILED = 22998;
        public static final int INSTALL_CHECK_ZIP_ENTRY_FAILED = 22997;
        public static final int INSTALL_COPY_APK_FAILED = 22003;
        public static final int INSTALL_COPY_SO_FAILED = 22004;
        public static final int INSTALL_DEX_OPT_FAILED = 22006;
        public static final int INSTALL_ERROR_END = 22999;
        public static final int INSTALL_HOST_ABI_NOT_MATCH = 22007;
        public static final int INSTALL_MULTIDEX_FAILED = 22005;
        public static final int INSTALL_PERMISSION_NOT_MATCH = 22002;
        public static final int INSTALL_SIGNATURES_NOT_MATCH = 22001;
        public static final int INSTALL_START = 20000;
        public static final int INSTALL_SUCCESS = 21000;
        public static final int INSTALL_UNKNOWN_ERROR = 22000;

        public InstallStatusCode() {
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public static final class LoadStatusCode {
        public static final int LOAD_ERROR_END = 32999;
        public static final int LOAD_RESOLVE_ERROR = 32001;
        public static final int LOAD_START = 30000;
        public static final int LOAD_SUCCESS = 31000;
        public static final int LOAD_UNKNOWN_ERROR = 32000;

        public LoadStatusCode() {
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public static final class OtherStatusCode {
        public static final int HOST_DOWNGRADE = 41005;
        public static final int OFFLINE_CLEAR = 42000;
        public static final int OFFLINE_RECEIVED = 40000;
        public static final int OFFLINE_SUCCESS = 41000;
        public static final int REVERT_RECEIVED = 40001;
        public static final int REVERT_SUCCESS = 41001;
        public static final int UPDATE_ROM = 41003;
        public static final int UPDATE_UNKNOWN = 41004;
        public static final int UPDATE_VERSION = 41002;

        public OtherStatusCode() {
        }
    }

    public static PluginEventManager getInstance() {
        if (sInstance != null) goto L13;
        monitor-enter(PluginEventManager.class);
        sInstance = new PluginEventManager();     // Catch: Throwable -> L9
        monitor-exit(PluginEventManager.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return sInstance;
    }

    private PluginEventManager() {
        this.mPluginLogListeners = new CopyOnWriteArrayList();
    }

    public void addPluginEventListener(PluginEventListener r100) {
        this.mPluginLogListeners.add(r100);
    }

    public void removePluginEventListener(PluginEventListener r100) {
        this.mPluginLogListeners.remove(r100);
    }

    public void notifyPluginEvent(int r110, String r111, int r112, long r113) {
        execEventListeners(r110, r111, r112, -1, null, r113);
    }

    public void notifyPluginErrorEvent(int r110, String r111, int r112, Throwable r113, long r114) {
        execEventListeners(r110, r111, r112, -1, r113, r114);
    }

    public void notifyPluginSuccessEvent(int r110, String r111, int r112, long r113, long r114) {
        execEventListeners(r110, r111, r112, r113, null, r114);
    }

    private void execEventListeners(int r110, String r210, int r211, long r212, Throwable r213, long r214) {
        String r100 = "PluginEventManager execEventListeners, size=" + this.mPluginLogListeners.size();
        String r101 = MiraLogger.TAG_LOAD;
        MiraLogger.i(MiraLogger.TAG_LOAD, r100);
        Iterator<PluginEventListener> r111 = this.mPluginLogListeners.iterator();
    L4:
        if (r111.hasNext() == false) goto L13;
        PluginEventListener r112 = r111.next();
        MiraLogger.i(r101, "PluginEventManager execEventListeners, status=" + r110 + ", packageName=" + r210 + ", versionCode=" + r211 + ", listener=" + r112.toString());     // Catch: Throwable -> L10
        String r102 = r101;
        r112.onPluginEvent(r110, r210, r211, r212, r213, r214);     // Catch: Throwable -> L14
    L12:
        r101 = r102;
    L11:
        MiraLogger.e(r102, "PluginEventManager execEventListeners has error, status=" + r110 + ", packageName=" + r210 + ", versionCode=" + r211 + ", listener=" + r112.toString(), r213);
    L10:
        r102 = r101;
        goto L11
    }
}
