package com.volcengine.zeus;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.volcengine.zeus.plugin.Plugin;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.volcengine.zeus.util.FieldUtils;
import com.volcengine.zeus.wrapper.PluginApplicationWrapper;

/* JADX INFO: loaded from: classes.dex */
public class PluginContext extends e {
    private LayoutInflater mInflater;
    public boolean mIsHostApplicationContext;
    public Context mOriginContext;
    private Configuration mOverrideConfiguration;
    public Plugin mPlugin;

    private Resources getResourcesInternal() {
        return this.mPlugin.mResources;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        Context r100 = this.mOriginContext;
        if ((r100 instanceof PluginApplicationWrapper) == false) goto L6;
        return r100;
    L6:
        return ZeusTransformUtils.wrapperContext(r100.getApplicationContext(), this.mPlugin.mPkgName);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        return this.mPlugin.mHostApplicationInfoHookSomeField;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.mPlugin.mResources.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return this.mPlugin.mClassLoader.getInnerClassLoader();
    }

    public String getPluginPackageName() {
        return this.mPlugin.mPkgName;
    }

    @Override // com.volcengine.zeus.e
    public String getPluginPkg() {
        return this.mPlugin.mPkgName;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.mPlugin.mResources;
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        Context r100 = super.getBaseContext();
        if ((r100 instanceof ContextWrapper) == true) goto L5;
        return r100;
    L5:
        return ((ContextWrapper) r100).getBaseContext();
    }

    public PluginContext() {
    }

    public Configuration getOverrideConfiguration() {
        return this.mOverrideConfiguration;
    }

    public static Context getContextWithoutTheme(Context r100) {
        if ((r100 instanceof ContextThemeWrapper) == false) goto L7;
        return getContextWithoutTheme(((ContextThemeWrapper) r100).getBaseContext());
    L7:
        if ((r100 instanceof androidx.appcompat.view.ContextThemeWrapper) == true) goto L9;
        return r100;
    L9:
        return getContextWithoutTheme(((androidx.appcompat.view.ContextThemeWrapper) r100).getBaseContext());
    }

    public static int getThemeResourceId(Context r100) {
        if ((r100 instanceof ContextThemeWrapper) == false) goto L9;
        return ((Integer) FieldUtils.readField(r100, "mThemeResource")).intValue();
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        if ((r100 instanceof androidx.appcompat.view.ContextThemeWrapper) == true) goto L11;
        return 0;
    L11:
        return ((androidx.appcompat.view.ContextThemeWrapper) r100).getThemeResId();
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration r100) {
        if (this.mPlugin.mResources != null) goto L11;
        if (this.mOverrideConfiguration != null) goto L9;
        this.mOverrideConfiguration = new Configuration(r100);
        return;
    L9:
        throw new IllegalStateException("Override configuration has already been set");
    L11:
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createConfigurationContext(Configuration r100) {
        Context r101 = super.createConfigurationContext(r100);
        FieldUtils.writeField(r101, "mResources", this.mPlugin.mResources);     // Catch: Throwable -> L5
    L9:
        return r101;
    L5:
        aqc.a.a(r101.getClass(), "mResources").set(r101, this.mPlugin.mResources);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r100) {
        if ("layout_inflater".equals(r100) == true) goto L5;
        Context r101 = this.mOriginContext;
        if (r101 == null) goto L14;
        return r101.getSystemService(r100);
    L14:
        return getBaseContext().getSystemService(r100);
    L5:
        if (this.mInflater != null) goto L8;
        LayoutInflater r102 = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        this.mInflater = r102;
        jqc.b.a(r102);
    L8:
        return this.mInflater;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks r100) {
        if (this.mIsHostApplicationContext == false) goto L5;
        this.mOriginContext.registerComponentCallbacks(r100);
        return;
    L5:
        super.registerComponentCallbacks(r100);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks r100) {
        if (this.mIsHostApplicationContext == false) goto L5;
        this.mOriginContext.unregisterComponentCallbacks(r100);
        return;
    L5:
        super.unregisterComponentCallbacks(r100);
    }

    public PluginContext(Context r100, Plugin r101, boolean r102) {
        super(getContextWithoutTheme(r100), getThemeResourceId(r100));
        this.mPlugin = r101;
        this.mOriginContext = r100;
        this.mIsHostApplicationContext = r102;
    }
}
