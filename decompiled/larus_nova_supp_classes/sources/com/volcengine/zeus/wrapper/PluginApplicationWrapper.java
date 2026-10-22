package com.volcengine.zeus.wrapper;

import android.app.Application;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import com.volcengine.zeus.PluginContext;
import com.volcengine.zeus.util.FieldUtils;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class PluginApplicationWrapper extends Application {
    public Application mOriginApplication;
    public PluginContext mPluginContext;

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        return this.mPluginContext.getDataDir();
    }

    @Override // android.app.Application
    public void onCreate() {
        this.mOriginApplication.onCreate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mOriginApplication.onLowMemory();
    }

    @Override // android.app.Application
    public void onTerminate() {
        this.mOriginApplication.onTerminate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r2) {
        this.mOriginApplication.onConfigurationChanged(r2);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int r2) {
        this.mOriginApplication.onTrimMemory(r2);
    }

    @Override // android.app.Application
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks r2) {
        this.mOriginApplication.registerActivityLifecycleCallbacks(r2);
    }

    @Override // android.app.Application
    public void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener r2) {
        this.mOriginApplication.registerOnProvideAssistDataListener(r2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r2) {
        this.mOriginApplication.setTheme(r2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r2) {
        this.mOriginApplication.startActivities(r2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r2) {
        this.mOriginApplication.startActivity(r2);
    }

    @Override // android.app.Application
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks r2) {
        this.mOriginApplication.unregisterActivityLifecycleCallbacks(r2);
    }

    @Override // android.app.Application
    public void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener r2) {
        this.mOriginApplication.unregisterOnProvideAssistDataListener(r2);
    }

    public PluginApplicationWrapper(Application r1, PluginContext r2) {
        this.mOriginApplication = r1;
        this.mPluginContext = r2;
        FieldUtils.writeField(this, "mBase", r2);     // Catch: IllegalAccessException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r2, Bundle r3) {
        this.mOriginApplication.startActivities(r2, r3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r2, Bundle r3) {
        this.mOriginApplication.startActivity(r2, r3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender r7, Intent r8, int r9, int r10, int r11) throws IntentSender.SendIntentException {
        this.mOriginApplication.startIntentSender(r7, r8, r9, r10, r11);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender r8, Intent r9, int r10, int r11, int r12, Bundle r13) throws IntentSender.SendIntentException {
        this.mOriginApplication.startIntentSender(r8, r9, r10, r11, r12, r13);
    }
}
