package com.volcengine.zeus.wrapper;

import android.app.Application;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import com.volcengine.zeus.PluginContext;
import com.volcengine.zeus.util.FieldUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
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
    public void onConfigurationChanged(Configuration r100) {
        this.mOriginApplication.onConfigurationChanged(r100);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int r100) {
        this.mOriginApplication.onTrimMemory(r100);
    }

    @Override // android.app.Application
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks r100) {
        this.mOriginApplication.registerActivityLifecycleCallbacks(r100);
    }

    @Override // android.app.Application
    public void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener r100) {
        this.mOriginApplication.registerOnProvideAssistDataListener(r100);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int r100) {
        this.mOriginApplication.setTheme(r100);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r100) {
        this.mOriginApplication.startActivities(r100);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r100) {
        this.mOriginApplication.startActivity(r100);
    }

    @Override // android.app.Application
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks r100) {
        this.mOriginApplication.unregisterActivityLifecycleCallbacks(r100);
    }

    @Override // android.app.Application
    public void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener r100) {
        this.mOriginApplication.unregisterOnProvideAssistDataListener(r100);
    }

    public PluginApplicationWrapper(Application r100, PluginContext r101) {
        this.mOriginApplication = r100;
        this.mPluginContext = r101;
        FieldUtils.writeField(this, "mBase", r101);     // Catch: IllegalAccessException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] r100, Bundle r101) {
        this.mOriginApplication.startActivities(r100, r101);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r100, Bundle r101) {
        this.mOriginApplication.startActivity(r100, r101);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender r100, Intent r101, int r102, int r110, int r111) throws IntentSender.SendIntentException {
        this.mOriginApplication.startIntentSender(r100, r101, r102, r110, r111);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender r100, Intent r101, int r110, int r111, int r112, Bundle r113) throws IntentSender.SendIntentException {
        this.mOriginApplication.startIntentSender(r100, r101, r110, r111, r112, r113);
    }
}
