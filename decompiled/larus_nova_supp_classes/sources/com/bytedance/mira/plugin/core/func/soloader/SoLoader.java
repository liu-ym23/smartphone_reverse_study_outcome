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
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class SoLoader {
    public static final String TAG = "SoLoader";
    private static volatile Config sConfig;
    private static volatile boolean sInit;
    private static ISoLoaderImpl soLoaderImpl;

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

        public /* synthetic */ Config(1 r1) {
            this();
        }

        public ClassLoader getClassLoader(String r2) {
            if (TextUtils.isEmpty(r2) == true) goto L9;
            IPluginGetClassloader r0 = this.classloaderGet;
            if (r0 != null) goto L8;
            return null;
        L8:
            return r0.getClassLoader(r2);
        L9:
            return null;
        }

        public String getPkgFromSoName(String r2) {
            Map<String, String> r0 = this.soToPkgMap;
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.get(r2);
        }

        public List<String> getSoListByPkg(String r2) {
            Map<String, List<String>> r0 = this.pkgToSoListMap;
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.get(r2);
        }

        public void setAction(PluginActionDispatcher r1) {
            this.dispatcher = r1;
        }

        public void setClassloaderGet(IPluginGetClassloader r1) {
            this.classloaderGet = r1;
        }

        public void setDebug(boolean r1) {
            this.debug = r1;
        }

        public void setEnableOptDeepCheck(boolean r1) {
            this.enableOptDeepCheck = r1;
        }

        public void setEnableOptNativeToJavaPluginCheck(boolean r1) {
            this.enableOptNativeToJavaPluginCheck = r1;
        }

        public void setExtraAction(PluginExtraActionWrapper r1) {
            this.extraAction = r1;
        }

        public void setHostPackageName(String r1) {
            this.hostPackageName = r1;
        }

        public void setLog(ILog r1) {
            this.log = r1;
        }

        public void setPkgAllList(Set<String> r1) {
            this.pkgAllList = r1;
        }

        public void setPkgToSoListMap(Map<String, List<String>> r1) {
            this.pkgToSoListMap = r1;
        }

        public void setSoAllList(Set<String> r1) {
            this.soAllList = r1;
        }

        public void setSoLinkedMap(Map<String, List<Pair<String, List<String>>>> r1) {
            this.soLinkedMap = r1;
        }

        public void setSoToPkgMap(Map<String, String> r1) {
            this.soToPkgMap = r1;
        }

        public void setStateManagerWrapper(StateManagerWrapper r1) {
            this.stateWrapper = r1;
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
            Config r0 = new Config(null);
            r0.setDebug(this.debug);
            r0.setHostPackageName(this.hostPackageName);
            r0.setClassloaderGet(this.classloaderGet);
            r0.setPkgToSoListMap(this.pkgToSoListMap);
            r0.setSoToPkgMap(this.soToPkgMap);
            r0.setSoLinkedMap(this.soLinkedMap);
            r0.setAction(new PluginActionDispatcher(new PluginActionWrapper(this.action, this.soToNeedLoadPkgMap), new PluginLinkWrapper(this.classloaderGet, this.soToPkgMap, this.soLinkedMap, this.soToNeedLoadPkgMap)));
            r0.setExtraAction(new PluginExtraActionWrapper(this.extraAction));
            r0.setSoAllList(this.soAllList);
            r0.setPkgAllList(this.pkgAllList);
            r0.setLog(this.log);
            r0.setEnableOptNativeToJavaPluginCheck(this.enableOptNativeToJavaPluginCheck);
            r0.setEnableOptDeepCheck(this.enableOptDeepCheck);
            r0.setStateManagerWrapper(new StateManagerWrapper(this.listener));
            return r0;
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

        public ConfigBuilder setAction(IPluginAction r1) {
            this.action = r1;
            return this;
        }

        public ConfigBuilder setClassloaderGet(IPluginGetClassloader r1) {
            this.classloaderGet = r1;
            return this;
        }

        public ConfigBuilder setDebug(boolean r1) {
            this.debug = r1;
            return this;
        }

        public ConfigBuilder setEnableOptDeepCheck(boolean r1) {
            this.enableOptDeepCheck = r1;
            return this;
        }

        public ConfigBuilder setEnableOptNativeToJavaPluginCheck(boolean r1) {
            this.enableOptNativeToJavaPluginCheck = r1;
            return this;
        }

        public ConfigBuilder setExtraAction(IPluginExtraAction r1) {
            this.extraAction = r1;
            return this;
        }

        public ConfigBuilder setHostPackageName(String r1) {
            this.hostPackageName = r1;
            return this;
        }

        public ConfigBuilder setLogImpl(ILog r1) {
            this.log = r1;
            return this;
        }

        public ConfigBuilder setPkgToSoListMap(Map<String, List<String>> r6) {
            this.pkgToSoListMap = r6;
            if (r6 != null) goto L5;
        L19:
            return this;
        L5:
            if (r6.isEmpty() == true) goto L19;
            Iterator<Map.Entry<String, List<String>>> r0 = r6.entrySet().iterator();
        L8:
            if (r0.hasNext() == false) goto L18;
            Map.Entry<String, List<String>> r1 = r0.next();
            String r2 = r1.getKey();
            List<String> r3 = r1.getValue();
            if (TextUtils.isEmpty(r2) == true) goto L8;
            if (r3 == null) goto L8;
            if (r3.isEmpty() == true) goto L8;
            Iterator<String> r4 = r3.iterator();
        L16:
            if (r4.hasNext() == false) goto L8;
            String r5 = r4.next();
            this.soToPkgMap.put(r5, r2);
            this.soAllList.add(r5);
            goto L16
        L18:
            this.pkgAllList.addAll(r6.keySet());
            goto L19
        }

        public ConfigBuilder setSoLinkedMap(Map<String, List<Pair<String, List<String>>>> r1) {
            this.soLinkedMap = r1;
            return this;
        }

        public ConfigBuilder setSoToNeedLoadPkgMap(Map<String, List<String>> r1) {
            this.soToNeedLoadPkgMap = r1;
            return this;
        }

        public ConfigBuilder setStateListener(IStateListener r1) {
            this.listener = r1;
            return this;
        }
    }

    public interface ILog {
        void d(String r1, String r2);

        void e(String r1, String r2);
    }

    public interface IPluginAction {
        boolean checkPluginReady(String... r1);
    }

    public interface IPluginGetClassloader {
        ClassLoader getClassLoader(String r1);
    }

    public static class PluginActionDispatcher {
        private final PluginActionWrapper actionWrapper;
        private final PluginLinkWrapper linkWrapper;

        public boolean checkPluginLinked(String r4) {
            if (SoLoader.getAndroidVersion() < 26) goto L11;
            PluginLinkWrapper r0 = this.linkWrapper;
            if (r0 != null) goto L7;
        L9:
            return false;
        L7:
            if (r0.checkPluginLinkedByPkg(r4) == false) goto L9;
            return true;
        L11:
            return true;
        }

        public boolean checkPluginReady(String r5) {
            PluginActionWrapper r0 = this.actionWrapper;
            if (r0 != null) goto L5;
        L16:
            return false;
        L5:
            if (r0.checkPluginReady(r5) == false) goto L16;
            if (SoLoader.getAndroidVersion() < 26) goto L15;
            PluginLinkWrapper r1 = this.linkWrapper;
            if (r1 != null) goto L12;
            return false;
        L12:
            if (r1.checkPluginLinked(r5) == false) goto L18;
            return true;
        L18:
            return false;
        L15:
            return true;
        }

        public PluginActionDispatcher(PluginActionWrapper r1, PluginLinkWrapper r2) {
            this.actionWrapper = r1;
            this.linkWrapper = r2;
        }
    }

    public static class PluginActionWrapper {
        private final IPluginAction action;
        private final Map<String, List<String>> soToNeedLoadPkgMap;

        public boolean checkPluginReady(String r3) {
            Map<String, List<String>> r0 = this.soToNeedLoadPkgMap;
            if (r0 != null) goto L5;
        L7:
            List<String> r4 = null;
        L9:
            if (this.action == null) goto L15;
            if (r4 != null) goto L12;
            return true;
        L12:
            if (r4.isEmpty() == false) goto L14;
            return true;
        L14:
            return this.action.checkPluginReady((String[]) r4.toArray(new String[0]));
        L15:
            return true;
        L5:
            if (r0.isEmpty() == true) goto L7;
            r4 = this.soToNeedLoadPkgMap.get(r3);
            goto L9
        }

        public PluginActionWrapper(IPluginAction r1, Map<String, List<String>> r2) {
            this.action = r1;
            this.soToNeedLoadPkgMap = r2;
        }
    }

    public static class PluginExtraActionWrapper {
        private final IPluginExtraAction action;

        public PluginExtraActionWrapper(IPluginExtraAction r1) {
            this.action = r1;
        }

        public boolean extraWithProcessAndThreadLock(String r2, String r3) {
            IPluginExtraAction r0 = this.action;
            if (r0 != null) goto L5;
            return false;
        L5:
            return r0.extraWithProcessAndThreadLock(r2, r3);
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

        public boolean checkPluginLinked(String r5) {
            Map<String, String> r0 = this.soToPkgMap;
            List<String> r1 = null;
            if (r0 != null) goto L5;
            String r2 = null;
        L7:
            if (TextUtils.isEmpty(r2) == false) goto L9;
            return true;
        L9:
            Map<String, List<String>> r3 = this.soToNeedLoadPkgMap;
            if (r3 == null) goto L13;
            r1 = r3.get(r5);
        L13:
            if (r1 != null) goto L15;
        L19:
            return true;
        L15:
            if (r1.isEmpty() == true) goto L19;
            return checkPluginLinkedByPkg(r2, new ArrayList(), r1);
        L5:
            r2 = r0.get(r5);
            goto L7
        }

        public boolean checkPluginLinkedByPkg(String r3) {
            return checkPluginLinkedByPkg(r3, new ArrayList(), DEFAULT_LIST);
        }

        private boolean checkPluginLinkedByPkg(String r10, List<String> r11, List<String> r12) {
            if (r11.contains(r10) == false) goto L5;
            return true;
        L5:
            r11.add(r10);
            List<Pair<String, List<String>>> r0 = this.soLinkedMap.get(r10);
            if (r0 != null) goto L8;
        L49:
            return true;
        L8:
            if (r0.isEmpty() == true) goto L49;
            Iterator<Pair<String, List<String>>> r1 = r0.iterator();
        L12:
            if (r1.hasNext() == false) goto L49;
            Pair<String, List<String>> r2 = r1.next();
            String r3 = (String) r2.first;
            if (DEFAULT_LIST == r12) goto L18;
            if (r12.contains(r3) == false) goto L12;
        L18:
            List r4 = (List) r2.second;
            if (r4 == null) goto L12;
            if (r4.isEmpty() == true) goto L12;
            IPluginGetClassloader r5 = this.pluginClassLoaderGet;
            ClassLoader r6 = null;
            if (r5 != null) goto L26;
            ClassLoader r7 = null;
        L27:
            IPluginGetClassloader r8 = this.pluginClassLoaderGet;
            if (r8 == null) goto L31;
            r6 = r8.getClassLoader(r3);
        L31:
            if (r7 == null) goto L12;
            if (r6 == null) goto L12;
            monitor-enter(PluginLinkWrapper.class);
            List<String> r9 = this.soLinkedResMap.get(r10);     // Catch: Throwable -> L46
            if (r9 != null) goto L40;
            r9 = new ArrayList();     // Catch: Throwable -> L46
        L40:
            if (r9.contains(r3) == true) goto L41;
            SoLoader.access$000(r7, r6, r4);     // Catch: Throwable -> L46
            r9.add(r3);     // Catch: Throwable -> L46
            this.soLinkedResMap.put(r10, r9);     // Catch: Throwable -> L46
            monitor-exit(PluginLinkWrapper.class);     // Catch: Throwable -> L46
            checkPluginLinkedByPkg(r3, r11, r12);
            goto L12
        L41:
            monitor-exit(PluginLinkWrapper.class);     // Catch: Throwable -> L46
        L46:
            th = move-exception;
            throw th;
        L26:
            r7 = r5.getClassLoader(r10);
            goto L27
        }

        public PluginLinkWrapper(IPluginGetClassloader r1, Map<String, String> r2, Map<String, List<Pair<String, List<String>>>> r3, Map<String, List<String>> r4) {
            this.soToPkgMap = r2;
            this.soLinkedMap = r3;
            this.soLinkedResMap = new HashMap();
            this.pluginClassLoaderGet = r1;
            this.soToNeedLoadPkgMap = r4;
        }
    }

    public static class StateManagerWrapper {
        private final IStateListener listener;

        public StateManagerWrapper(IStateListener r1) {
            this.listener = r1;
        }

        public void dispatchStateChange(String r4, String r5, int r6, Throwable r7) {
            IStateListener r0 = this.listener;
            if (r0 == null) goto L11;
            r0.onStateChanged(r4, r5, r6, r7);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            LogUtils.e(SoLoader.TAG, "invoke dispatchStateChange fail, so name=" + r4 + ", pkg=" + r5 + ", code=" + r6 + ", origin err=" + Log.getStackTraceString(r7) + ", invoke err=" + Log.getStackTraceString(th));
            return;
        }
    }

    public SoLoader() {
    }

    private static native boolean native_android_link_namespace(int r0, Object r1, Object r2, String r3);

    private static native boolean native_create_allocator_for_classloader(Object r0);

    private static native boolean native_create_classloader_namespace(int r0, int r1, Object r2, boolean r3, String r4);

    private static native boolean native_dlopen(String r0);

    private static native boolean native_hook();

    private static native boolean native_init(boolean r0, Object r1, String r2, String r3, boolean r4);

    private static native boolean native_register_classloader(Object r0, String r1, String r2, String r3);

    private static boolean ensureInit() {
        return init(sConfig);
    }

    public static int getAndroidVersion() {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 >= 23) goto L5;
        return r0;
    L5:
        if (Build.VERSION.PREVIEW_SDK_INT > 0) goto L7;
        return r0;
    L7:
        return r0 + 1;
    }

    private static void nativeHook() {
        native_hook();
    }

    private static String build(Set<String> r2) {
        if (r2 != null) goto L4;
    L12:
        return null;
    L4:
        if (r2.isEmpty() == true) goto L12;
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.append(r3.next());
        r0.append(":");
        goto L7
    L9:
        int r4 = r0.length();
        if (r4 <= 0) goto L12;
        r0.delete(r4 - 1, r4);
        return r0.toString();
    }

    public static boolean callOnSystemLoadOrLoadLibrary(String r1) throws Throwable {
        ensureInit();
        ISoLoaderImpl r0 = soLoaderImpl;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.callOnSystemLoadOrLoadLibrary(r1) == false) goto L7;
        return true;
    }

    public static boolean checkPluginLinkedByPkg(String r1) {
        ensureInit();
        ISoLoaderImpl r0 = soLoaderImpl;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.checkPluginLinkedByPkg(r1) == false) goto L7;
        return true;
    }

    private static boolean createAllocatorForClassLoader(ClassLoader r0) {
        return native_create_allocator_for_classloader(r0);
    }

    public static boolean dlOpen(String r0) {
        return native_dlopen(r0);
    }

    private static String getLdLibraryPath(Object r1) {
        ISoLoaderImpl r0 = soLoaderImpl;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getLdLibraryPath(r1);
    }

    private static int getTargetSdkVersion(Context r1) {
        ApplicationInfo r0 = null;
        if (r1 != null) goto L5;
        Context r2 = null;
    L6:
        if (r2 == null) goto L9;
        r0 = r2.getApplicationInfo();
    L9:
        if (r0 != null) goto L12;
        return 0;
    L12:
        return r0.targetSdkVersion;
    L5:
        r2 = r1.getApplicationContext();
        goto L6
    }

    public static boolean init(Config r2) {
        if (sInit == true) goto L15;
        monitor-enter(SoLoader.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInit == true) goto L9;
        sInit = safeInit(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SoLoader.class);     // Catch: Throwable -> L11
    L15:
        return sInit;
    }

    private static boolean safeInit(Config r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        sConfig = r6;
        LogUtils.setLogProxy(r6.getLog());
        int r1 = getAndroidVersion();
        if (r1 >= 24) goto L9;
        SoLoaderV1Impl r2 = new SoLoaderV1Impl();
    L12:
        Set<String> r3 = null;
        r2.init(r6);     // Catch: Throwable -> L15
        soLoaderImpl = r2;     // Catch: Throwable -> L15
    L17:
        if (soLoaderImpl != null) goto L19;
        return false;
    L19:
        boolean r4 = r6.isEnableOptNativeToJavaPluginCheck();
        boolean r5 = r6.isDebug();
        PluginActionDispatcher r7 = r6.getAction();
        if (r4 == false) goto L22;
        Set<String> r8 = r6.getSoAllList();
    L23:
        if (r4 == false) goto L25;
        r3 = r6.getPkgAllList();
    L25:
        nativeInit(r5, r7, r8, r3, r6.isEnableOptDeepCheck());
        realRegisterClassLoader(SoLoader.class.getClassLoader(), r6.getHostPackageName(), false);
        nativeHook();
        return true;
    L22:
        r8 = null;
    L15:
        soLoaderImpl = null;
        goto L17
    L9:
        if (r1 >= 26) goto L11;
        r2 = new SoLoaderV2Impl();
        goto L12
    L11:
        r2 = new SoLoaderV3Impl();
        goto L12
    }

    public static boolean createClassLoaderNamespace(Context r3, Object r4) {
        if (ensureInit() == true) goto L6;
        return false;
    L6:
        return native_create_classloader_namespace(getAndroidVersion(), getTargetSdkVersion(r3), r4, false, getLdLibraryPath(r4));
    }

    public static boolean registerClassLoader(ClassLoader r1, String r2) {
        return realRegisterClassLoader(r1, r2, true);
    }

    public static /* synthetic */ boolean access$000(Object r0, Object r1, List r2) {
        return linkNameSpace(r0, r1, r2);
    }

    private static boolean linkNameSpace(Object r2, Object r3, List<String> r4) {
        if (r4 != null) goto L4;
    L18:
        LogUtils.e(TAG, "Fail:The LinkNameSpace method parameter verification failed!!!");
        return false;
    L4:
        if (r4.isEmpty() == true) goto L18;
        if (r2 == null) goto L18;
        if (r3 == null) goto L18;
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r5 = r4.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        r0.append(r5.next());
        r0.append(":");
        goto L10
    L12:
        int r6 = r0.length();
        if (r6 <= 0) goto L15;
        r0.delete(r6 - 1, r6);
        String r7 = r0.toString();
    L17:
        return native_android_link_namespace(getAndroidVersion(), r2, r3, r7);
    L15:
        r7 = XmlPullParser.NO_NAMESPACE;
        goto L17
    }

    private static boolean nativeLoad(String r1, ClassLoader r2, String r3) throws Throwable {
        ISoLoaderImpl r0 = soLoaderImpl;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.nativeLoad(r1, r2, r3) == false) goto L7;
        return true;
    }

    private static boolean realRegisterClassLoader(ClassLoader r2, String r3, boolean r4) {
        if (r4 == true) goto L5;
    L7:
        createAllocatorForClassLoader(r2);
        ISoLoaderImpl r5 = soLoaderImpl;
        if (r5 != null) goto L10;
        return false;
    L10:
        if (r5.callOnRegisterClassLoader(r2) == true) goto L12;
        return false;
    L12:
        if (native_register_classloader(r2, r3, soLoaderImpl.getSoListStrByPkg(r3), getLdLibraryPath(r2)) == false) goto L17;
        return true;
    L17:
        return false;
    L5:
        if (ensureInit() == true) goto L7;
        return false;
    }

    private static void nativeInit(boolean r0, Object r1, Set<String> r2, Set<String> r3, boolean r4) {
        native_init(r0, r1, build(r2), build(r3), r4);
    }
}
