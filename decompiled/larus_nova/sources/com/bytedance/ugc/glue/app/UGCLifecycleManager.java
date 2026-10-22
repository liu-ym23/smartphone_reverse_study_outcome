package com.bytedance.ugc.glue.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.View;
import com.bytedance.ugc.glue.UGCViewUtils;
import com.bytedance.ugc.ugcwidget.UGCSafeList;
import com.bytedance.ugc.ugcwidget.UGCServiceManager;
import java.util.HashMap;

/* JADX INFO: loaded from: classes22.dex */
public class UGCLifecycleManager {
    private final HashMap<Activity, UGCSafeList<UGCLifecycle>> map;

    public static abstract class CallbacksStub implements Application.ActivityLifecycleCallbacks {
        public CallbacksStub() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity r100, Bundle r101) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity r100) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity r100) {
        }
    }

    public static abstract class UGCForegroundListener {
        public UGCForegroundListener() {
        }

        public abstract void onChanged(boolean r100);
    }

    public static abstract class UGCLifecycle extends CallbacksStub {
        private static final UGCLifecycleManager singleton = null;

        static {
            singleton = new UGCLifecycleManager(null);
        }

        public UGCLifecycle() {
        }

        public static /* synthetic */ UGCLifecycleManager access$100() {
            return singleton;
        }

        @Override // com.bytedance.ugc.glue.app.UGCLifecycleManager.CallbacksStub, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity r100) {
            UGCLifecycleManager.removeLifecycle(r100, this);
        }
    }

    public static abstract class UGCLifecycle4ViewHolder extends UGCLifecycle implements View.OnAttachStateChangeListener {
        private Activity activity;
        private boolean hasRegister;
        private View view;

        public Activity getActivity() {
            if (this.activity != null) goto L6;
            this.activity = UGCViewUtils.getActivity(this.view);
        L6:
            return this.activity;
        }

        public void register() {
            if (this.hasRegister == false) goto L5;
            return;
        L5:
            this.hasRegister = true;
            UGCLifecycleManager.addLifecycle(getActivity(), this);
        }

        public UGCLifecycle4ViewHolder(View r100) {
            this.hasRegister = false;
            this.view = r100;
            r100.addOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r100) {
            register();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r100) {
            UGCLifecycleManager.removeLifecycle(this.activity, this);
            this.hasRegister = false;
        }
    }

    public static /* synthetic */ class a {
    }

    public static class b {
        public b() {
        }
    }

    public static boolean isBackground() {
        ((b) UGCServiceManager.getService(b.class)).getClass();
        return false;
    }

    private UGCLifecycleManager() {
        this.map = new HashMap();
        int r100 = ep7.a.f473437a;
        throw null;
    }

    public /* synthetic */ UGCLifecycleManager(a r100) {
        this();
    }

    public static /* synthetic */ HashMap access$200(UGCLifecycleManager r100) {
        return r100.map;
    }

    public static void addForegroundListener(UGCForegroundListener r100) {
        ((b) UGCServiceManager.getService(b.class)).getClass();
    }

    public static void removeForegroundListener(UGCForegroundListener r100) {
        ((b) UGCServiceManager.getService(b.class)).getClass();
    }

    public static void addLifecycle(Activity r100, UGCLifecycle r101) {
        if (r100 == null) goto L12;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == false) goto L7;
        return;
    L7:
        UGCSafeList<UGCLifecycle> r102 = UGCLifecycle.access$100().map.get(r100);
        if (r102 != null) goto L10;
        r102 = new UGCSafeList();
        UGCLifecycle.access$100().map.put(r100, r102);
    L10:
        r102.add(r101);
        return;
    }

    public static void removeLifecycle(Activity r100, UGCLifecycle r101) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L11;
        UGCSafeList<UGCLifecycle> r102 = UGCLifecycle.access$100().map.get(r100);
        if (r102 == null) goto L12;
        r102.remove(r101);
        if (r102.size() != 0) goto L13;
        UGCLifecycle.access$100().map.remove(r100);
        return;
    L13:
        return;
    L12:
        return;
    L11:
        return;
    }
}
