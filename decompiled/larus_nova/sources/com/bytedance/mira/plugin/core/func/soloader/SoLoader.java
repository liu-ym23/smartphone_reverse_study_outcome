package com.bytedance.mira.plugin.core.func.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl;
import com.bytedance.mira.plugin.core.func.soloader.impl.SoLoaderV1Impl;
import com.bytedance.mira.plugin.core.func.soloader.impl.SoLoaderV2Impl;
import com.bytedance.mira.plugin.core.func.soloader.impl.SoLoaderV3Impl;
import com.bytedance.mira.plugin.core.func.soloader.utils.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SoLoader {
    public static final String TAG = "SoLoader";
    private static volatile Config sConfig;
    private static volatile boolean sInit;
    private static ISoLoaderImpl soLoaderImpl;

    /* JADX INFO: renamed from: com.bytedance.mira.plugin.core.func.soloader.SoLoader$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes21.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Config {
        private IPluginGetClassloader classloaderGet;
        private boolean debug;
        private PluginActionDispatcher dispatcher;
        private boolean enableOptDeepCheck;
        private boolean enableOptNativeToJavaPluginCheck;
        private PluginExtraActionWrapper extraAction;
        private String hostPackageName;
        private ILog log;
        private Set<String> pkgAllList;
        private Map<String, List<String>> pkgToSoListMap;
        private Set<String> soAllList;
        private Map<String, List<Pair<String, List<String>>>> soLinkedMap;
        private Map<String, String> soToPkgMap;
        private StateManagerWrapper stateWrapper;

        private Config() {
            this.debug = false;
            this.classloaderGet = null;
            this.soToPkgMap = null;
            this.pkgToSoListMap = null;
            this.soAllList = null;
            this.pkgAllList = new HashSet();
            this.soLinkedMap = null;
            this.enableOptNativeToJavaPluginCheck = false;
            this.enableOptDeepCheck = false;
        }

        public PluginActionDispatcher getAction() {
            return this.dispatcher;
        }

        public PluginExtraActionWrapper getExtraAction() {
            return this.extraAction;
        }

        public String getHostPackageName() {
            return this.hostPackageName;
        }

        public ILog getLog() {
            return this.log;
        }

        public Set<String> getPkgAllList() {
            return this.pkgAllList;
        }

        public Map<String, List<String>> getPkgToSoListMap() {
            return this.pkgToSoListMap;
        }

        public Set<String> getSoAllList() {
            return this.soAllList;
        }

        public Map<String, List<Pair<String, List<String>>>> getSoLinkedMap() {
            return this.soLinkedMap;
        }

        public Map<String, String> getSoToPkgMap() {
            return this.soToPkgMap;
        }

        public StateManagerWrapper getStateWrapper() {
            return this.stateWrapper;
        }

        public boolean isDebug() {
            return this.debug;
        }

        public boolean isEnableOptDeepCheck() {
            return this.enableOptDeepCheck;
        }

        public boolean isEnableOptNativeToJavaPluginCheck() {
            return this.enableOptNativeToJavaPluginCheck;
        }

        public /* synthetic */ Config(AnonymousClass1 r100) {
            this();
        }

        public ClassLoader getClassLoader(String r100) {
            if (TextUtils.isEmpty(r100) == true) goto L9;
            IPluginGetClassloader r101 = this.classloaderGet;
            if (r101 != null) goto L8;
            return null;
        L8:
            return r101.getClassLoader(r100);
        L9:
            return null;
        }

        public String getPkgFromSoName(String r100) {
            Map<String, String> r101 = this.soToPkgMap;
            if (r101 != null) goto L5;
            return null;
        L5:
            return r101.get(r100);
        }

        public List<String> getSoListByPkg(String r100) {
            Map<String, List<String>> r101 = this.pkgToSoListMap;
            if (r101 != null) goto L5;
            return null;
        L5:
            return r101.get(r100);
        }

        public void setAction(PluginActionDispatcher r100) {
            this.dispatcher = r100;
        }

        public void setClassloaderGet(IPluginGetClassloader r100) {
            this.classloaderGet = r100;
        }

        public void setDebug(boolean r100) {
            this.debug = r100;
        }

        public void setEnableOptDeepCheck(boolean r100) {
            this.enableOptDeepCheck = r100;
        }

        public void setEnableOptNativeToJavaPluginCheck(boolean r100) {
            this.enableOptNativeToJavaPluginCheck = r100;
        }

        public void setExtraAction(PluginExtraActionWrapper r100) {
            this.extraAction = r100;
        }

        public void setHostPackageName(String r100) {
            this.hostPackageName = r100;
        }

        public void setLog(ILog r100) {
            this.log = r100;
        }

        public void setPkgAllList(Set<String> r100) {
            this.pkgAllList = r100;
        }

        public void setPkgToSoListMap(Map<String, List<String>> r100) {
            this.pkgToSoListMap = r100;
        }

        public void setSoAllList(Set<String> r100) {
            this.soAllList = r100;
        }

        public void setSoLinkedMap(Map<String, List<Pair<String, List<String>>>> r100) {
            this.soLinkedMap = r100;
        }

        public void setSoToPkgMap(Map<String, String> r100) {
            this.soToPkgMap = r100;
        }

        public void setStateManagerWrapper(StateManagerWrapper r100) {
            this.stateWrapper = r100;
        }
    }

    public static class ConfigBuilder {
        private IPluginAction action;
        private IPluginGetClassloader classloaderGet;
        private boolean debug;
        private boolean enableOptDeepCheck;
        private boolean enableOptNativeToJavaPluginCheck;
        private IPluginExtraAction extraAction;
        private String hostPackageName;
        private IStateListener listener;
        private ILog log;
        private Set<String> pkgAllList;
        private Map<String, List<String>> pkgToSoListMap;
        private Set<String> soAllList;
        private Map<String, List<Pair<String, List<String>>>> soLinkedMap;
        private Map<String, List<String>> soToNeedLoadPkgMap;
        private final Map<String, String> soToPkgMap;

        public Config build() {
            Config r100 = new Config(null);
            r100.setDebug(this.debug);
            r100.setHostPackageName(this.hostPackageName);
            r100.setClassloaderGet(this.classloaderGet);
            r100.setPkgToSoListMap(this.pkgToSoListMap);
            r100.setSoToPkgMap(this.soToPkgMap);
            r100.setSoLinkedMap(this.soLinkedMap);
            r100.setAction(new PluginActionDispatcher(new PluginActionWrapper(this.action, this.soToNeedLoadPkgMap), new PluginLinkWrapper(this.classloaderGet, this.soToPkgMap, this.soLinkedMap, this.soToNeedLoadPkgMap)));
            r100.setExtraAction(new PluginExtraActionWrapper(this.extraAction));
            r100.setSoAllList(this.soAllList);
            r100.setPkgAllList(this.pkgAllList);
            r100.setLog(this.log);
            r100.setEnableOptNativeToJavaPluginCheck(this.enableOptNativeToJavaPluginCheck);
            r100.setEnableOptDeepCheck(this.enableOptDeepCheck);
            r100.setStateManagerWrapper(new StateManagerWrapper(this.listener));
            return r100;
        }

        public ConfigBuilder() {
            this.debug = false;
            this.hostPackageName = null;
            this.classloaderGet = null;
            this.soToNeedLoadPkgMap = null;
            this.soToPkgMap = new HashMap();
            this.pkgToSoListMap = new HashMap();
            this.soAllList = new HashSet();
            this.pkgAllList = new HashSet();
            this.soLinkedMap = new HashMap();
            this.enableOptNativeToJavaPluginCheck = false;
            this.enableOptDeepCheck = false;
        }

        public ConfigBuilder setAction(IPluginAction r100) {
            this.action = r100;
            return this;
        }

        public ConfigBuilder setClassloaderGet(IPluginGetClassloader r100) {
            this.classloaderGet = r100;
            return this;
        }

        public ConfigBuilder setDebug(boolean r100) {
            this.debug = r100;
            return this;
        }

        public ConfigBuilder setEnableOptDeepCheck(boolean r100) {
            this.enableOptDeepCheck = r100;
            return this;
        }

        public ConfigBuilder setEnableOptNativeToJavaPluginCheck(boolean r100) {
            this.enableOptNativeToJavaPluginCheck = r100;
            return this;
        }

        public ConfigBuilder setExtraAction(IPluginExtraAction r100) {
            this.extraAction = r100;
            return this;
        }

        public ConfigBuilder setHostPackageName(String r100) {
            this.hostPackageName = r100;
            return this;
        }

        public ConfigBuilder setLogImpl(ILog r100) {
            this.log = r100;
            return this;
        }

        public ConfigBuilder setPkgToSoListMap(Map<String, List<String>> r100) {
            this.pkgToSoListMap = r100;
            if (r100 != null) goto L5;
        L19:
            return this;
        L5:
            if (r100.isEmpty() == true) goto L19;
            Iterator<Map.Entry<String, List<String>>> r101 = r100.entrySet().iterator();
        L8:
            if (r101.hasNext() == false) goto L18;
            Map.Entry<String, List<String>> r102 = r101.next();
            String r103 = r102.getKey();
            List<String> r104 = r102.getValue();
            if (TextUtils.isEmpty(r103) == true) goto L8;
            if (r104 == null) goto L8;
            if (r104.isEmpty() == true) goto L8;
            Iterator<String> r105 = r104.iterator();
        L16:
            if (r105.hasNext() == false) goto L8;
            String r106 = r105.next();
            this.soToPkgMap.put(r106, r103);
            this.soAllList.add(r106);
            goto L16
        L18:
            this.pkgAllList.addAll(r100.keySet());
            goto L19
        }

        public ConfigBuilder setSoLinkedMap(Map<String, List<Pair<String, List<String>>>> r100) {
            this.soLinkedMap = r100;
            return this;
        }

        public ConfigBuilder setSoToNeedLoadPkgMap(Map<String, List<String>> r100) {
            this.soToNeedLoadPkgMap = r100;
            return this;
        }

        public ConfigBuilder setStateListener(IStateListener r100) {
            this.listener = r100;
            return this;
        }
    }

    public interface ILog {
        void d(String r100, String r101);

        void e(String r100, String r101);
    }

    public interface IPluginAction {
        boolean checkPluginReady(String... r100);
    }

    /* JADX INFO: loaded from: classes21.dex */
    public interface IPluginExtraAction {
        boolean extraWithProcessAndThreadLock(String r100, String r101);
    }

    public interface IPluginGetClassloader {
        ClassLoader getClassLoader(String r100);
    }

    /* JADX INFO: loaded from: classes21.dex */
    public interface IStateListener {
        public static final int SO_LOAD_FAIL = 63001;
        public static final int SO_LOAD_FAIL_AGAIN = 63002;
        public static final int SO_LOAD_FAIL_PLUGIN_CLASSLOADER_NOT_MATCH = 63005;
        public static final int SO_LOAD_FAIL_PLUGIN_EXTRA_NOT_READY = 63007;
        public static final int SO_LOAD_FAIL_PLUGIN_NOT_READY = 63003;
        public static final int SO_LOAD_FAIL_PLUGIN_PKG_NOT_READY = 63004;
        public static final int SO_LOAD_FAIL_PLUGIN_REAL_PATH_NOT_READY = 63006;
        public static final int SO_LOAD_FAIL_PLUGIN_REAL_PATH_NOT_READY_AGAIN = 63008;
        public static final int SO_LOAD_START = 60000;
        public static final int SO_LOAD_SUCCESS = 61000;
        public static final int SO_LOAD_SUCCESS_AGAIN = 62000;

        void onStateChanged(String r100, String r101, int r102, Throwable r103);
    }

    public static class PluginActionDispatcher {
        private final PluginActionWrapper actionWrapper;
        private final PluginLinkWrapper linkWrapper;

        public boolean checkPluginLinked(String r100) {
            if (SoLoader.getAndroidVersion() < 26) goto L11;
            PluginLinkWrapper r101 = this.linkWrapper;
            if (r101 != null) goto L7;
        L9:
            return false;
        L7:
            if (r101.checkPluginLinkedByPkg(r100) == false) goto L9;
            return true;
        L11:
            return true;
        }

        public boolean checkPluginReady(String r100) {
            PluginActionWrapper r101 = this.actionWrapper;
            if (r101 != null) goto L5;
        L16:
            return false;
        L5:
            if (r101.checkPluginReady(r100) == false) goto L16;
            if (SoLoader.getAndroidVersion() < 26) goto L15;
            PluginLinkWrapper r102 = this.linkWrapper;
            if (r102 != null) goto L12;
            return false;
        L12:
            if (r102.checkPluginLinked(r100) == false) goto L18;
            return true;
        L18:
            return false;
        L15:
            return true;
        }

        public PluginActionDispatcher(PluginActionWrapper r100, PluginLinkWrapper r101) {
            this.actionWrapper = r100;
            this.linkWrapper = r101;
        }
    }

    public static class PluginActionWrapper {
        private final IPluginAction action;
        private final Map<String, List<String>> soToNeedLoadPkgMap;

        public boolean checkPluginReady(String r100) {
            Map<String, List<String>> r101 = this.soToNeedLoadPkgMap;
            if (r101 != null) goto L5;
        L7:
            List<String> r102 = null;
        L9:
            if (this.action == null) goto L15;
            if (r102 != null) goto L12;
            return true;
        L12:
            if (r102.isEmpty() == false) goto L14;
            return true;
        L14:
            return this.action.checkPluginReady((String[]) r102.toArray(new String[0]));
        L15:
            return true;
        L5:
            if (r101.isEmpty() == true) goto L7;
            r102 = this.soToNeedLoadPkgMap.get(r100);
            goto L9
        }

        public PluginActionWrapper(IPluginAction r100, Map<String, List<String>> r101) {
            this.action = r100;
            this.soToNeedLoadPkgMap = r101;
        }
    }

    public static class PluginExtraActionWrapper {
        private final IPluginExtraAction action;

        public PluginExtraActionWrapper(IPluginExtraAction r100) {
            this.action = r100;
        }

        public boolean extraWithProcessAndThreadLock(String r100, String r101) {
            IPluginExtraAction r102 = this.action;
            if (r102 != null) goto L5;
            return false;
        L5:
            return r102.extraWithProcessAndThreadLock(r100, r101);
        }
    }

    public static class PluginLinkWrapper {
        private static final List<String> DEFAULT_LIST = null;
        private final IPluginGetClassloader pluginClassLoaderGet;
        private final Map<String, List<Pair<String, List<String>>>> soLinkedMap;
        private final Map<String, List<String>> soLinkedResMap;
        private final Map<String, List<String>> soToNeedLoadPkgMap;
        private final Map<String, String> soToPkgMap;

        static {
            DEFAULT_LIST = new ArrayList();
        }

        public boolean checkPluginLinked(String r100) {
            Map<String, String> r101 = this.soToPkgMap;
            List<String> r102 = null;
            if (r101 != null) goto L5;
            String r103 = null;
        L7:
            if (TextUtils.isEmpty(r103) == false) goto L9;
            return true;
        L9:
            Map<String, List<String>> r104 = this.soToNeedLoadPkgMap;
            if (r104 == null) goto L13;
            r102 = r104.get(r100);
        L13:
            if (r102 != null) goto L15;
        L19:
            return true;
        L15:
            if (r102.isEmpty() == true) goto L19;
            return checkPluginLinkedByPkg(r103, new ArrayList(), r102);
        L5:
            r103 = r101.get(r100);
            goto L7
        }

        public boolean checkPluginLinkedByPkg(String r100) {
            return checkPluginLinkedByPkg(r100, new ArrayList(), DEFAULT_LIST);
        }

        private boolean checkPluginLinkedByPkg(String r110, List<String> r111, List<String> r112) {
            if (r111.contains(r110) == false) goto L5;
            return true;
        L5:
            r111.add(r110);
            List<Pair<String, List<String>>> r100 = this.soLinkedMap.get(r110);
            if (r100 != null) goto L8;
        L49:
            return true;
        L8:
            if (r100.isEmpty() == true) goto L49;
            Iterator<Pair<String, List<String>>> r101 = r100.iterator();
        L12:
            if (r101.hasNext() == false) goto L49;
            Pair<String, List<String>> r102 = r101.next();
            String r103 = (String) r102.first;
            if (DEFAULT_LIST == r112) goto L18;
            if (r112.contains(r103) == false) goto L12;
        L18:
            List r104 = (List) r102.second;
            if (r104 == null) goto L12;
            if (r104.isEmpty() == true) goto L12;
            IPluginGetClassloader r105 = this.pluginClassLoaderGet;
            ClassLoader r106 = null;
            if (r105 != null) goto L26;
            ClassLoader r107 = null;
        L27:
            IPluginGetClassloader r108 = this.pluginClassLoaderGet;
            if (r108 == null) goto L31;
            r106 = r108.getClassLoader(r103);
        L31:
            if (r107 == null) goto L12;
            if (r106 == null) goto L12;
            monitor-enter(PluginLinkWrapper.class);
            List<String> r109 = this.soLinkedResMap.get(r110);     // Catch: Throwable -> L46
            if (r109 != null) goto L40;
            r109 = new ArrayList();     // Catch: Throwable -> L46
        L40:
            if (r109.contains(r103) == true) goto L41;
            SoLoader.access$000(r107, r106, r104);     // Catch: Throwable -> L46
            r109.add(r103);     // Catch: Throwable -> L46
            this.soLinkedResMap.put(r110, r109);     // Catch: Throwable -> L46
            monitor-exit(PluginLinkWrapper.class);     // Catch: Throwable -> L46
            checkPluginLinkedByPkg(r103, r111, r112);
            goto L12
        L41:
            monitor-exit(PluginLinkWrapper.class);     // Catch: Throwable -> L46
        L46:
            th = move-exception;
            throw th;
        L26:
            r107 = r105.getClassLoader(r110);
            goto L27
        }

        public PluginLinkWrapper(IPluginGetClassloader r100, Map<String, String> r101, Map<String, List<Pair<String, List<String>>>> r102, Map<String, List<String>> r103) {
            this.soToPkgMap = r101;
            this.soLinkedMap = r102;
            this.soLinkedResMap = new HashMap();
            this.pluginClassLoaderGet = r100;
            this.soToNeedLoadPkgMap = r103;
        }
    }

    public static class StateManagerWrapper {
        private final IStateListener listener;

        public StateManagerWrapper(IStateListener r100) {
            this.listener = r100;
        }

        public void dispatchStateChange(String r100, String r101, int r102, Throwable r103) {
            IStateListener r104 = this.listener;
            if (r104 == null) goto L11;
            r104.onStateChanged(r100, r101, r102, r103);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            LogUtils.e(SoLoader.TAG, "invoke dispatchStateChange fail, so name=" + r100 + ", pkg=" + r101 + ", code=" + r102 + ", origin err=" + Log.getStackTraceString(r103) + ", invoke err=" + Log.getStackTraceString(th));
            return;
        }
    }

    public SoLoader() {
    }

    private static native boolean native_android_link_namespace(int r100, Object r101, Object r102, String r103);

    private static native boolean native_create_allocator_for_classloader(Object r100);

    private static native boolean native_create_classloader_namespace(int r100, int r101, Object r102, boolean r103, String r104);

    private static native boolean native_dlopen(String r100);

    private static native boolean native_hook();

    private static native boolean native_init(boolean r100, Object r101, String r102, String r103, boolean r104);

    private static native boolean native_register_classloader(Object r100, String r101, String r102, String r103);

    private static boolean ensureInit() {
        return init(sConfig);
    }

    public static int getAndroidVersion() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 23) goto L5;
        return r100;
    L5:
        if (Build.VERSION.PREVIEW_SDK_INT > 0) goto L7;
        return r100;
    L7:
        return r100 + 1;
    }

    private static void nativeHook() {
        native_hook();
    }

    private static String build(Set<String> r100) {
        if (r100 != null) goto L4;
    L12:
        return null;
    L4:
        if (r100.isEmpty() == true) goto L12;
        StringBuilder r101 = new StringBuilder();
        Iterator<String> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r101.append(r102.next());
        r101.append(":");
        goto L7
    L9:
        int r103 = r101.length();
        if (r103 <= 0) goto L12;
        r101.delete(r103 - 1, r103);
        return r101.toString();
    }

    public static boolean callOnSystemLoadOrLoadLibrary(String r100) throws Throwable {
        ensureInit();
        ISoLoaderImpl r101 = soLoaderImpl;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.callOnSystemLoadOrLoadLibrary(r100) == false) goto L7;
        return true;
    }

    public static boolean checkPluginLinkedByPkg(String r100) {
        ensureInit();
        ISoLoaderImpl r101 = soLoaderImpl;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.checkPluginLinkedByPkg(r100) == false) goto L7;
        return true;
    }

    private static boolean createAllocatorForClassLoader(ClassLoader r100) {
        return native_create_allocator_for_classloader(r100);
    }

    public static boolean dlOpen(String r100) {
        return native_dlopen(r100);
    }

    private static String getLdLibraryPath(Object r100) {
        ISoLoaderImpl r101 = soLoaderImpl;
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.getLdLibraryPath(r100);
    }

    private static int getTargetSdkVersion(Context r100) {
        ApplicationInfo r101 = null;
        if (r100 != null) goto L5;
        Context r102 = null;
    L6:
        if (r102 == null) goto L9;
        r101 = r102.getApplicationInfo();
    L9:
        if (r101 != null) goto L12;
        return 0;
    L12:
        return r101.targetSdkVersion;
    L5:
        r102 = r100.getApplicationContext();
        goto L6
    }

    public static boolean init(Config r100) {
        if (sInit == true) goto L15;
        monitor-enter(SoLoader.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInit == true) goto L9;
        sInit = safeInit(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SoLoader.class);     // Catch: Throwable -> L11
    L15:
        return sInit;
    }

    private static boolean safeInit(Config r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        sConfig = r100;
        LogUtils.setLogProxy(r100.getLog());
        int r101 = getAndroidVersion();
        if (r101 >= 24) goto L9;
        ISoLoaderImpl r102 = new SoLoaderV1Impl();
    L12:
        Set<String> r103 = null;
        r102.init(r100);     // Catch: Throwable -> L15
        soLoaderImpl = r102;     // Catch: Throwable -> L15
    L17:
        if (soLoaderImpl != null) goto L19;
        return false;
    L19:
        boolean r104 = r100.isEnableOptNativeToJavaPluginCheck();
        boolean r105 = r100.isDebug();
        PluginActionDispatcher r106 = r100.getAction();
        if (r104 == false) goto L22;
        Set<String> r107 = r100.getSoAllList();
    L23:
        if (r104 == false) goto L25;
        r103 = r100.getPkgAllList();
    L25:
        nativeInit(r105, r106, r107, r103, r100.isEnableOptDeepCheck());
        realRegisterClassLoader(SoLoader.class.getClassLoader(), r100.getHostPackageName(), false);
        nativeHook();
        return true;
    L22:
        r107 = null;
    L15:
        soLoaderImpl = null;
        goto L17
    L9:
        if (r101 >= 26) goto L11;
        r102 = new SoLoaderV2Impl();
        goto L12
    L11:
        r102 = new SoLoaderV3Impl();
        goto L12
    }

    public static boolean createClassLoaderNamespace(Context r100, Object r101) {
        if (ensureInit() == true) goto L6;
        return false;
    L6:
        return native_create_classloader_namespace(getAndroidVersion(), getTargetSdkVersion(r100), r101, false, getLdLibraryPath(r101));
    }

    public static boolean registerClassLoader(ClassLoader r100, String r101) {
        return realRegisterClassLoader(r100, r101, true);
    }

    public static /* synthetic */ boolean access$000(Object r100, Object r101, List r102) {
        return linkNameSpace(r100, r101, r102);
    }

    private static boolean linkNameSpace(Object r100, Object r101, List<String> r102) {
        if (r102 != null) goto L4;
    L18:
        LogUtils.e(TAG, "Fail:The LinkNameSpace method parameter verification failed!!!");
        return false;
    L4:
        if (r102.isEmpty() == true) goto L18;
        if (r100 == null) goto L18;
        if (r101 == null) goto L18;
        StringBuilder r103 = new StringBuilder();
        Iterator<String> r104 = r102.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        r103.append(r104.next());
        r103.append(":");
        goto L10
    L12:
        int r105 = r103.length();
        if (r105 <= 0) goto L15;
        r103.delete(r105 - 1, r105);
        String r106 = r103.toString();
    L17:
        return native_android_link_namespace(getAndroidVersion(), r100, r101, r106);
    L15:
        r106 = "";
        goto L17
    }

    private static boolean nativeLoad(String r100, ClassLoader r101, String r102) throws Throwable {
        ISoLoaderImpl r103 = soLoaderImpl;
        if (r103 != null) goto L5;
    L7:
        return false;
    L5:
        if (r103.nativeLoad(r100, r101, r102) == false) goto L7;
        return true;
    }

    private static boolean realRegisterClassLoader(ClassLoader r100, String r101, boolean r102) {
        if (r102 == true) goto L5;
    L7:
        createAllocatorForClassLoader(r100);
        ISoLoaderImpl r103 = soLoaderImpl;
        if (r103 != null) goto L10;
        return false;
    L10:
        if (r103.callOnRegisterClassLoader(r100) == true) goto L12;
        return false;
    L12:
        if (native_register_classloader(r100, r101, soLoaderImpl.getSoListStrByPkg(r101), getLdLibraryPath(r100)) == false) goto L17;
        return true;
    L17:
        return false;
    L5:
        if (ensureInit() == true) goto L7;
        return false;
    }

    private static void nativeInit(boolean r100, Object r101, Set<String> r102, Set<String> r103, boolean r104) {
        native_init(r100, r101, build(r102), build(r103), r104);
    }
}
