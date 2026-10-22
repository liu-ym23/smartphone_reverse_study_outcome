package com.bytedance.common.jato.views.fps;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.bytedance.common.jato.views.DoubleReflector;
import com.bytedance.common.jato.views.UIUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public class WindowFPSManager {
    protected static int DEFAULT_MIN_FRAME_INTERVAL = 50;
    public static boolean IS_DEBUG = true;
    protected static boolean IS_STRICT_MODE;
    protected static List<DebugListener> sDebugListeners;
    private static WindowFPSManager sInstance;
    Class clz_ViewRootImpl;
    Field fld_ViewRootImpl_mUpcomingInTouchMode;
    Handler mHandler;
    private Map<Integer, SceneState> mScenes;
    Method mth_View_getViewRootImpl;

    static {
        sDebugListeners = new LinkedList();
    }

    public static synchronized WindowFPSManager getInstance() {
        monitor-enter(WindowFPSManager.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (sInstance == null) goto L7;
    L14:
        WindowFPSManager r100 = sInstance;     // Catch: Throwable -> L17
        monitor-exit(WindowFPSManager.class);
        return r100;
    L7:
        monitor-enter(WindowFPSManager.class);     // Catch: Throwable -> L17
        sInstance = new WindowFPSManager();     // Catch: Throwable -> L11
        monitor-exit(WindowFPSManager.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    }

    private WindowFPSManager() {
        this.mScenes = new HashMap();
        if (new PolarisFileWrapper("/data/local/tmp/fpsmanager/disable").exists() == false) goto L5;
        DEFAULT_MIN_FRAME_INTERVAL = -1;
    L5:
        this.mHandler = new Handler(Looper.getMainLooper());
        Method r100 = DoubleReflector.getMethod(View.class, "getViewRootImpl", new Class[0]);     // Catch: Exception -> L8
        this.mth_View_getViewRootImpl = r100;     // Catch: Exception -> L8
        r100.setAccessible(true);     // Catch: Exception -> L8
        Class<?> r101 = DoubleReflector.getClass("android.view.ViewRootImpl");     // Catch: Exception -> L8
        this.clz_ViewRootImpl = r101;     // Catch: Exception -> L8
        Field r102 = DoubleReflector.getField(r101, "mUpcomingWindowFocus");     // Catch: Exception -> L8
        this.fld_ViewRootImpl_mUpcomingInTouchMode = r102;     // Catch: Exception -> L8
        r102.setAccessible(true);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        reportError(1, e.getMessage());
        DEFAULT_MIN_FRAME_INTERVAL = -1;
    }

    private void exitScene(SceneState r100) {
        this.mScenes.remove(Integer.valueOf(r100.activityId));
        Iterator<WindowState> r101 = r100.mWindows.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().destroy();
        goto L4
    }

    public void detachWindow(Activity r100, WindowState r101) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L16;
        UIUtils.checkRunOnUIThread();
        int r102 = r100.hashCode();
        SceneState r103 = this.mScenes.get(Integer.valueOf(r102));
        if (r103 == null) goto L11;
        r103.removeWindow(r101);
        if (r103.mWindows.size() != 0) goto L11;
        exitScene(r103);
    L11:
        if (IS_DEBUG == false) goto L15;
        this.mScenes.size();
        return;
    L15:
        return;
    L16:
        return;
    }

    public void reportError(int r100, String r101) {
        List<DebugListener> r102 = sDebugListeners;
        if (r102 == null) goto L11;
        if (r102.size() <= 0) goto L11;
        Iterator<DebugListener> r103 = sDebugListeners.iterator();
    L8:
        if (r103.hasNext() == false) goto L11;
        r103.next().onError(r100, r101);
    L11:
        if (IS_STRICT_MODE == true) goto L14;
        return;
    L14:
        throw new FPSManagerError(r101 + " ErrorCode:" + r100);
    }

    public WindowState attachWindow(Activity r100, String r101, Window r102, WindowState.WindowConfig r103) {
        if (r100 == null) goto L10;
        if (r102 == null) goto L12;
        UIUtils.checkRunOnUIThread();
        int r104 = r100.hashCode();
        SceneState r105 = this.mScenes.get(Integer.valueOf(r104));
        if (r105 != null) goto L9;
        r105 = new SceneState(r100);
        this.mScenes.put(Integer.valueOf(r104), r105);
    L9:
        return r105.addWindow(r101, r102, r103);
    L12:
        return null;
    L10:
        return null;
    }
}
