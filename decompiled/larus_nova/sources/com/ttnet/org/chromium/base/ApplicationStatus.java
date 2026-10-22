package com.ttnet.org.chromium.base;

import android.app.Activity;
import android.app.Application;
import android.view.Window;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("base::android")
public class ApplicationStatus {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TOOLBAR_CALLBACK_WRAPPER_CLASS = "androidx.appcompat.app.ToolbarActionBar$ToolbarCallbackWrapper";
    private static Activity sActivity;
    private static final Map<Activity, ActivityInfo> sActivityInfo = null;
    private static ObserverList<ApplicationStateListener> sApplicationStateListeners;
    private static int sCurrentApplicationState;
    private static ObserverList<ActivityStateListener> sGeneralActivityStateListeners;
    private static ApplicationStateListener sNativeApplicationStateListener;
    private static ObserverList<WindowFocusChangedListener> sWindowFocusListeners;

    /* JADX INFO: loaded from: classes41.dex */
    public static class ActivityInfo {
        private ObserverList<ActivityStateListener> mListeners;
        private int mStatus;

        private ActivityInfo() {
            this.mStatus = 6;
            this.mListeners = new ObserverList();
        }

        public ObserverList<ActivityStateListener> getListeners() {
            return this.mListeners;
        }

        public int getStatus() {
            return this.mStatus;
        }

        public /* synthetic */ ActivityInfo(AnonymousClass1 r100) {
            this();
        }

        public void setStatus(int r100) {
            this.mStatus = r100;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public interface ActivityStateListener {
        void onActivityStateChange(Activity r100, int r101);
    }

    public interface ApplicationStateListener {
        void onApplicationStateChange(int r100);
    }

    /* JADX INFO: loaded from: classes41.dex */
    public interface Natives {
        void onApplicationStateChange(int r100);
    }

    /* JADX INFO: loaded from: classes41.dex */
    public static class WindowCallbackProxy implements InvocationHandler {
        private final Activity mActivity;
        private final Window.Callback mCallback;

        public void onWindowFocusChanged(boolean r100) {
            this.mCallback.onWindowFocusChanged(r100);
            if (ApplicationStatus.access$000() == null) goto L8;
            Iterator r101 = ApplicationStatus.access$000().iterator();
        L6:
            if (r101.hasNext() == false) goto L10;
            ((WindowFocusChangedListener) r101.next()).onWindowFocusChanged(this.mActivity, r100);
            goto L6
        L10:
            return;
        }

        public WindowCallbackProxy(Activity r100, Window.Callback r101) {
            this.mCallback = r101;
            this.mActivity = r100;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
            if (r101.getName().equals("onWindowFocusChanged") == true) goto L5;
        L18:
            return r101.invoke(this.mCallback, r102);
        L12:
            e = move-exception;
            if ((e.getCause() instanceof AbstractMethodError) == true) goto L16;
            throw e;
        L16:
            throw e.getCause();
        L5:
            if (r102.length != 1) goto L18;
            Object r103 = r102[0];
            if ((r103 instanceof Boolean) == false) goto L18;
            onWindowFocusChanged(((Boolean) r103).booleanValue());
            return null;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    public interface WindowFocusChangedListener {
        void onWindowFocusChanged(Activity r100, boolean r101);
    }

    private ApplicationStatus() {
    }

    static {
        sActivityInfo = Collections.synchronizedMap(new HashMap());
        sCurrentApplicationState = 0;
    }

    public static void destroyForJUnitTests() {
        Map<Activity, ActivityInfo> r100 = sActivityInfo;
        monitor-enter(r100);
        ObserverList<ApplicationStateListener> r101 = sApplicationStateListeners;     // Catch: Throwable -> L16
        if (r101 == null) goto L7;
        r101.clear();     // Catch: Throwable -> L16
    L7:
        ObserverList<ActivityStateListener> r102 = sGeneralActivityStateListeners;     // Catch: Throwable -> L16
        if (r102 == null) goto L10;
        r102.clear();     // Catch: Throwable -> L16
    L10:
        r100.clear();     // Catch: Throwable -> L16
        ObserverList<WindowFocusChangedListener> r103 = sWindowFocusListeners;     // Catch: Throwable -> L16
        if (r103 == null) goto L13;
        r103.clear();     // Catch: Throwable -> L16
    L13:
        sCurrentApplicationState = 0;     // Catch: Throwable -> L16
        sActivity = null;     // Catch: Throwable -> L16
        sNativeApplicationStateListener = null;     // Catch: Throwable -> L16
        monitor-exit(r100);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private static int determineApplicationStateLocked() {
        Iterator<ActivityInfo> r100 = sActivityInfo.values().iterator();
        boolean r101 = false;
        boolean r102 = false;
    L4:
        if (r100.hasNext() == false) goto L15;
        int r103 = r100.next().getStatus();
        if (r103 == 4) goto L11;
        if (r103 == 5) goto L11;
        if (r103 == 6) goto L11;
        return 1;
    L11:
        if (r103 == 4) goto L12;
        if (r103 != 5) goto L4;
        r102 = true;
        goto L4
    L12:
        r101 = true;
        goto L4
    L15:
        if (r101 == false) goto L18;
        return 2;
    L18:
        if (r102 == false) goto L21;
        return 3;
    L21:
        return 4;
    }

    public static List<Activity> getRunningActivities() {
        Map<Activity, ActivityInfo> r100 = sActivityInfo;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList(r100.keySet());     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static int getStateForApplication() {
        Map<Activity, ActivityInfo> r100 = sActivityInfo;
        monitor-enter(r100);
        int r101 = sCurrentApplicationState;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean isEveryActivityDestroyed() {
        return sActivityInfo.isEmpty();
    }

    public static boolean isInitialized() {
        Map<Activity, ActivityInfo> r100 = sActivityInfo;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sCurrentApplicationState == 0) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    private static void registerThreadSafeNativeApplicationStateListener() {
        ThreadUtils.runOnUiThread(new AnonymousClass3());
    }

    public static void resetActivitiesForInstrumentationTests() {
        Map<Activity, ActivityInfo> r100 = sActivityInfo;
        monitor-enter(r100);
        Iterator r101 = new HashSet(r100.keySet()).iterator();     // Catch: Throwable -> L10
    L6:
        if (r101.hasNext() == false) goto L8;
        onStateChangeForTesting((Activity) r101.next(), 6);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static boolean hasVisibleActivities() {
        int r100 = getStateForApplication();
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static /* synthetic */ ObserverList access$000() {
        return sWindowFocusListeners;
    }

    public static /* synthetic */ Activity access$100() {
        return sActivity;
    }

    public static /* synthetic */ ApplicationStateListener access$400() {
        return sNativeApplicationStateListener;
    }

    public static Activity getLastTrackedFocusedActivity() {
        return sActivity;
    }

    public static /* synthetic */ Activity access$102(Activity r100) {
        sActivity = r100;
        return r100;
    }

    public static /* synthetic */ ApplicationStateListener access$402(ApplicationStateListener r100) {
        sNativeApplicationStateListener = r100;
        return r100;
    }

    public static int getStateForActivity(Activity r100) {
        if (r100 != null) goto L5;
        return 6;
    L5:
        ActivityInfo r101 = sActivityInfo.get(r100);
        if (r101 != null) goto L8;
        return 6;
    L8:
        return r101.getStatus();
    }

    public static void initialize(Application r100) {
        Map<Activity, ActivityInfo> r101 = sActivityInfo;
        monitor-enter(r101);
        sCurrentApplicationState = 4;     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        registerWindowFocusChangedListener(new AnonymousClass1());
        r100.registerActivityLifecycleCallbacks(new AnonymousClass2());
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static boolean reachesWindowCallback(Window.Callback r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getClass().getName().equals(TOOLBAR_CALLBACK_WRAPPER_CLASS) == false) goto L9;
        return true;
    L9:
        if (Proxy.isProxyClass(r100.getClass()) == true) goto L11;
        Class<?> r101 = r100.getClass();
    L14:
        if (r101 == Object.class) goto L30;
        Field[] r102 = r101.getDeclaredFields();
        int r103 = r102.length;
        int r104 = 0;
    L16:
        if (r104 >= r103) goto L29;
        Field r105 = r102[r104];
        if (r105.getType().isAssignableFrom(Window.Callback.class) == false) goto L28;
        boolean r106 = r105.isAccessible();
        r105.setAccessible(true);
        Window.Callback r107 = (Window.Callback) r105.get(r100);     // Catch: Throwable -> L24 IllegalAccessException -> L27
        r105.setAccessible(r106);
        if (reachesWindowCallback(r107) == false) goto L28;
        return true;
    L27:
        r105.setAccessible(r106);
    L24:
        th = move-exception;
        r105.setAccessible(r106);
        throw th;
    L28:
        r104 = r104 + 1;
        goto L16
    L29:
        r101 = r101.getSuperclass();
        goto L14
    L30:
        return false;
    L11:
        return Proxy.getInvocationHandler(r100) instanceof WindowCallbackProxy;
    }

    public static void registerApplicationStateListener(ApplicationStateListener r100) {
        if (sApplicationStateListeners != null) goto L5;
        sApplicationStateListeners = new ObserverList();
    L5:
        sApplicationStateListeners.addObserver(r100);
    }

    public static void registerStateListenerForAllActivities(ActivityStateListener r100) {
        if (sGeneralActivityStateListeners != null) goto L5;
        sGeneralActivityStateListeners = new ObserverList();
    L5:
        sGeneralActivityStateListeners.addObserver(r100);
    }

    public static void registerWindowFocusChangedListener(WindowFocusChangedListener r100) {
        if (sWindowFocusListeners != null) goto L5;
        sWindowFocusListeners = new ObserverList();
    L5:
        sWindowFocusListeners.addObserver(r100);
    }

    public static void unregisterActivityStateListener(ActivityStateListener r100) {
        ObserverList<ActivityStateListener> r101 = sGeneralActivityStateListeners;
        if (r101 == null) goto L5;
        r101.removeObserver(r100);
    L5:
        Map<Activity, ActivityInfo> r102 = sActivityInfo;
        monitor-enter(r102);
        Iterator<ActivityInfo> r103 = r102.values().iterator();     // Catch: Throwable -> L13
    L9:
        if (r103.hasNext() == false) goto L11;
        r103.next().getListeners().removeObserver(r100);     // Catch: Throwable -> L13
        goto L9
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static void unregisterApplicationStateListener(ApplicationStateListener r100) {
        ObserverList<ApplicationStateListener> r101 = sApplicationStateListeners;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.removeObserver(r100);
    }

    public static void unregisterWindowFocusChangedListener(WindowFocusChangedListener r100) {
        ObserverList<WindowFocusChangedListener> r101 = sWindowFocusListeners;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.removeObserver(r100);
    }

    public static /* synthetic */ void access$200(Activity r100, int r101) {
        onStateChange(r100, r101);
    }

    public static Window.Callback createWindowCallbackProxy(Activity r100, Window.Callback r101) {
        return (Window.Callback) Proxy.newProxyInstance(Window.Callback.class.getClassLoader(), new Class[]{Window.Callback.class}, new WindowCallbackProxy(r100, r101));
    }

    private static void onStateChange(Activity r100, int r101) {
        if (r100 == null) goto L47;
        if (sActivity != null) goto L6;
    L11:
        sActivity = r100;
    L12:
        int r102 = getStateForApplication();
        Map<Activity, ActivityInfo> r103 = sActivityInfo;
        monitor-enter(r103);
        AnonymousClass1 r104 = null;
        if (r103.containsKey(r100) == true) goto L17;
        r103.put(r100, new ActivityInfo(r104));     // Catch: Throwable -> L43
    L17:
        ActivityInfo r105 = r103.get(r100);     // Catch: Throwable -> L43
        r105.setStatus(r101);     // Catch: Throwable -> L43
        if (r101 != 6) goto L22;
        r103.remove(r100);     // Catch: Throwable -> L43
        if (r100 != sActivity) goto L22;
        sActivity = null;     // Catch: Throwable -> L43
    L22:
        sCurrentApplicationState = determineApplicationStateLocked();     // Catch: Throwable -> L43
        monitor-exit(r103);     // Catch: Throwable -> L43
        Iterator<ActivityStateListener> r106 = r105.getListeners().iterator();
    L26:
        if (r106.hasNext() == false) goto L28;
        r106.next().onActivityStateChange(r100, r101);
        goto L26
    L28:
        ObserverList<ActivityStateListener> r107 = sGeneralActivityStateListeners;
        if (r107 == null) goto L34;
        Iterator<ActivityStateListener> r108 = r107.iterator();
    L32:
        if (r108.hasNext() == false) goto L34;
        r108.next().onActivityStateChange(r100, r101);
    L34:
        int r109 = getStateForApplication();
        if (r109 == r102) goto L42;
        ObserverList<ApplicationStateListener> r110 = sApplicationStateListeners;
        if (r110 == null) goto L53;
        Iterator<ApplicationStateListener> r111 = r110.iterator();
    L40:
        if (r111.hasNext() == false) goto L54;
        r111.next().onApplicationStateChange(r109);
        goto L40
    L54:
        return;
    L53:
        return;
    L42:
        return;
    L43:
        th = move-exception;
        throw th;
    L6:
        if (r101 == 1) goto L11;
        if (r101 == 3) goto L11;
        if (r101 != 2) goto L12;
    L47:
        throw new IllegalArgumentException("null activity is not supported");
    }

    public static void onStateChangeForTesting(Activity r100, int r101) {
        onStateChange(r100, r101);
    }

    public static void registerStateListenerForActivity(ActivityStateListener r100, Activity r101) {
        sActivityInfo.get(r101).getListeners().addObserver(r100);
    }
}
