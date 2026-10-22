package com.bytedance.push.proxy;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import com.bytedance.push.utils.b;
import com.bytedance.push.utils.f;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes21.dex */
public class InstrumentationProxy extends Instrumentation {
    public static final String METHOD_CALL_ACTIVITY_ON_PAUSE = "callActivityOnPause";
    public static final String METHOD_CALL_ACTIVITY_ON_RESUME = "callActivityOnResume";
    public static final String METHOD_CALL_ACTIVITY_ON_STOP = "callActivityOnStop";
    private final String TAG;
    private Method mCallActivityOnPause;
    private Method mCallActivityOnResume;
    private Method mCallActivityOnStop;
    private final InvocationHandler mInvocationHandler;
    private Instrumentation mOriginInstrumentation;

    public Method getCallActivityOnPause() {
        return this.mCallActivityOnPause;
    }

    public InstrumentationProxy(InvocationHandler r100) {
        this.TAG = "InstrumentationProxy";
        this.mInvocationHandler = r100;
        this.mCallActivityOnPause = b.f(Instrumentation.class, METHOD_CALL_ACTIVITY_ON_PAUSE, new Class[]{Activity.class});     // Catch: Throwable -> L5
        this.mCallActivityOnResume = b.f(Instrumentation.class, METHOD_CALL_ACTIVITY_ON_RESUME, new Class[]{Activity.class});     // Catch: Throwable -> L5
        this.mCallActivityOnStop = b.f(Instrumentation.class, METHOD_CALL_ACTIVITY_ON_STOP, new Class[]{Activity.class});     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        f.f("InstrumentationProxy", "error when init method ", th);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnDestroy(Activity r100) {
        Instrumentation r101 = this.mOriginInstrumentation;
        if (r101 == null) goto L5;
        r101.callActivityOnDestroy(r100);
        return;
    L5:
        super.callActivityOnDestroy(r100);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnPause(Activity r100) {
        this.mInvocationHandler.invoke(this, this.mCallActivityOnPause, new Object[]{r100});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        f.f("InstrumentationProxy", "[callActivityOnPause]exception", th);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnRestart(Activity r100) {
        Instrumentation r101 = this.mOriginInstrumentation;
        if (r101 == null) goto L5;
        r101.callActivityOnRestart(r100);
        return;
    L5:
        super.callActivityOnRestart(r100);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnResume(Activity r100) {
        this.mInvocationHandler.invoke(this, this.mCallActivityOnResume, new Object[]{r100});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        f.f("InstrumentationProxy", "[callActivityOnResume]exception", th);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnStart(Activity r100) {
        Instrumentation r101 = this.mOriginInstrumentation;
        if (r101 == null) goto L5;
        r101.callActivityOnStart(r100);
        return;
    L5:
        super.callActivityOnStart(r100);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnStop(Activity r100) {
        this.mInvocationHandler.invoke(this, this.mCallActivityOnStop, new Object[]{r100});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        f.f("InstrumentationProxy", "[callActivityOnStop]exception", th);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnUserLeaving(Activity r100) {
        Instrumentation r101 = this.mOriginInstrumentation;
        if (r101 == null) goto L5;
        r101.callActivityOnUserLeaving(r100);
        return;
    L5:
        super.callActivityOnUserLeaving(r100);
    }

    @Override // android.app.Instrumentation
    public void callApplicationOnCreate(Application r100) {
        Instrumentation r101 = this.mOriginInstrumentation;
        if (r101 == null) goto L5;
        r101.callApplicationOnCreate(r100);
        return;
    L5:
        super.callApplicationOnCreate(r100);
    }

    public InstrumentationProxy setOriginInstrumentation(Instrumentation r100) {
        this.mOriginInstrumentation = r100;
        return this;
    }

    @Override // android.app.Instrumentation
    public void callActivityOnCreate(Activity r100, Bundle r101) {
        Instrumentation r102 = this.mOriginInstrumentation;
        if (r102 == null) goto L5;
        r102.callActivityOnCreate(r100, r101);
        return;
    L5:
        super.callActivityOnCreate(r100, r101);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnNewIntent(Activity r100, Intent r101) {
        Instrumentation r102 = this.mOriginInstrumentation;
        if (r102 == null) goto L5;
        r102.callActivityOnNewIntent(r100, r101);
        return;
    L5:
        super.callActivityOnNewIntent(r100, r101);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnPostCreate(Activity r100, Bundle r101) {
        Instrumentation r102 = this.mOriginInstrumentation;
        if (r102 == null) goto L5;
        r102.callActivityOnPostCreate(r100, r101);
        return;
    L5:
        super.callActivityOnPostCreate(r100, r101);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnRestoreInstanceState(Activity r100, Bundle r101) {
        Instrumentation r102 = this.mOriginInstrumentation;
        if (r102 == null) goto L5;
        r102.callActivityOnRestoreInstanceState(r100, r101);
        return;
    L5:
        super.callActivityOnRestoreInstanceState(r100, r101);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnSaveInstanceState(Activity r100, Bundle r101) {
        Instrumentation r102 = this.mOriginInstrumentation;
        if (r102 == null) goto L5;
        r102.callActivityOnSaveInstanceState(r100, r101);
        return;
    L5:
        super.callActivityOnSaveInstanceState(r100, r101);
    }

    @Override // android.app.Instrumentation
    public boolean onException(Object r100, Throwable r101) {
        Instrumentation r102 = this.mOriginInstrumentation;
        if (r102 == null) goto L7;
        return r102.onException(r100, r101);
    L7:
        return super.onException(r100, r101);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnCreate(Activity r100, Bundle r101, PersistableBundle r102) {
        Instrumentation r103 = this.mOriginInstrumentation;
        if (r103 == null) goto L5;
        r103.callActivityOnCreate(r100, r101, r102);
        return;
    L5:
        super.callActivityOnCreate(r100, r101, r102);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnRestoreInstanceState(Activity r100, Bundle r101, PersistableBundle r102) {
        Instrumentation r103 = this.mOriginInstrumentation;
        if (r103 == null) goto L5;
        r103.callActivityOnRestoreInstanceState(r100, r101, r102);
        return;
    L5:
        super.callActivityOnRestoreInstanceState(r100, r101, r102);
    }

    @Override // android.app.Instrumentation
    public void callActivityOnSaveInstanceState(Activity r100, Bundle r101, PersistableBundle r102) {
        Instrumentation r103 = this.mOriginInstrumentation;
        if (r103 == null) goto L5;
        r103.callActivityOnSaveInstanceState(r100, r101, r102);
        return;
    L5:
        super.callActivityOnSaveInstanceState(r100, r101, r102);
    }

    @Override // android.app.Instrumentation
    public Activity newActivity(ClassLoader r100, String r101, Intent r102) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Instrumentation r103 = this.mOriginInstrumentation;
        if (r103 == null) goto L7;
        return r103.newActivity(r100, r101, r102);
    L7:
        return super.newActivity(r100, r101, r102);
    }

    @Override // android.app.Instrumentation
    public Application newApplication(ClassLoader r100, String r101, Context r102) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Instrumentation r103 = this.mOriginInstrumentation;
        if (r103 == null) goto L7;
        return r103.newApplication(r100, r101, r102);
    L7:
        return super.newApplication(r100, r101, r102);
    }

    public void execStartActivities(Context r100, IBinder r101, IBinder r102, Activity r103, Intent[] r104, Bundle r105) {
        if (this.mOriginInstrumentation != null) goto L10;
        return;
    L10:
        b.d(Instrumentation.class, "execStartActivities", new Class[]{Context.class, IBinder.class, IBinder.class, Activity.class, Intent[].class, Bundle.class}).invoke(this.mOriginInstrumentation, new Object[]{r100, r101, r102, r103, r104, r105});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        f.e("InstrumentationProxy", "[execStartActivities]exception:" + e.getLocalizedMessage());
    }

    public Instrumentation.ActivityResult execStartActivity(Context r100, IBinder r101, IBinder r102, Activity r103, Intent r104, int r105) {
        if (this.mOriginInstrumentation != null) goto L11;
        return null;
    L11:
        b.d(Instrumentation.class, "execStartActivity", new Class[]{Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE}).invoke(this.mOriginInstrumentation, new Object[]{r100, r101, r102, r103, r104, Integer.valueOf(r105)});     // Catch: Exception -> L7
        return null;
    L7:
        e = move-exception;
        f.e("InstrumentationProxy", "[execStartActivity1]exception:" + e.getLocalizedMessage());
        return null;
    }

    public Instrumentation.ActivityResult execStartActivity(Context r100, IBinder r101, IBinder r102, Fragment r103, Intent r104, int r105) {
        if (this.mOriginInstrumentation != null) goto L11;
        return null;
    L11:
        b.d(Instrumentation.class, "execStartActivity", new Class[]{Context.class, IBinder.class, IBinder.class, Fragment.class, Intent.class, Integer.TYPE}).invoke(this.mOriginInstrumentation, new Object[]{r100, r101, r102, r103, r104, Integer.valueOf(r105)});     // Catch: Exception -> L7
        return null;
    L7:
        e = move-exception;
        f.e("InstrumentationProxy", "[execStartActivity2]exception:" + e.getLocalizedMessage());
        return null;
    }

    public Instrumentation.ActivityResult execStartActivity(Context r100, IBinder r101, IBinder r102, Activity r103, Intent r104, int r105, Bundle r110) {
        if (this.mOriginInstrumentation != null) goto L11;
        return null;
    L11:
        b.d(Instrumentation.class, "execStartActivity", new Class[]{Context.class, IBinder.class, IBinder.class, Activity.class, Intent.class, Integer.TYPE, Bundle.class}).invoke(this.mOriginInstrumentation, new Object[]{r100, r101, r102, r103, r104, Integer.valueOf(r105), r110});     // Catch: Exception -> L7
        return null;
    L7:
        e = move-exception;
        f.e("InstrumentationProxy", "[execStartActivity3]exception:" + e.getLocalizedMessage());
        return null;
    }

    public Instrumentation.ActivityResult execStartActivity(Context r100, IBinder r101, IBinder r102, Fragment r103, Intent r104, int r105, Bundle r110) {
        if (this.mOriginInstrumentation != null) goto L11;
        return null;
    L11:
        b.d(Instrumentation.class, "execStartActivity", new Class[]{Context.class, IBinder.class, IBinder.class, Fragment.class, Intent.class, Integer.TYPE, Bundle.class}).invoke(this.mOriginInstrumentation, new Object[]{r100, r101, r102, r103, r104, Integer.valueOf(r105), r110});     // Catch: Exception -> L7
        return null;
    L7:
        e = move-exception;
        f.e("InstrumentationProxy", "[execStartActivity4]exception:" + e.getLocalizedMessage());
        return null;
    }

    public Instrumentation.ActivityResult execStartActivity(Context r100, IBinder r101, IBinder r102, String r103, Intent r104, int r105, Bundle r110) {
        if (this.mOriginInstrumentation != null) goto L11;
        return null;
    L11:
        b.d(Instrumentation.class, "execStartActivity", new Class[]{Context.class, IBinder.class, IBinder.class, String.class, Intent.class, Integer.TYPE, Bundle.class}).invoke(this.mOriginInstrumentation, new Object[]{r100, r101, r102, r103, r104, Integer.valueOf(r105), r110});     // Catch: Exception -> L7
        return null;
    L7:
        e = move-exception;
        f.e("InstrumentationProxy", "[execStartActivity5]exception:" + e.getLocalizedMessage());
        return null;
    }
}
