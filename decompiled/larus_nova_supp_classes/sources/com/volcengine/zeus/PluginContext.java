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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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
        Context r0 = this.mOriginContext;
        if ((r0 instanceof PluginApplicationWrapper) == false) goto L6;
        return r0;
    L6:
        return ZeusTransformUtils.wrapperContext(r0.getApplicationContext(), this.mPlugin.mPkgName);
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
        Context r0 = super.getBaseContext();
        if ((r0 instanceof ContextWrapper) == true) goto L5;
        return r0;
    L5:
        return ((ContextWrapper) r0).getBaseContext();
    }

    public PluginContext() {
    }

    public Configuration getOverrideConfiguration() {
        return this.mOverrideConfiguration;
    }

    public static Context getContextWithoutTheme(Context r1) {
        if ((r1 instanceof ContextThemeWrapper) == false) goto L7;
        return getContextWithoutTheme(((ContextThemeWrapper) r1).getBaseContext());
    L7:
        if ((r1 instanceof androidx.appcompat.view.ContextThemeWrapper) == true) goto L9;
        return r1;
    L9:
        return getContextWithoutTheme(((androidx.appcompat.view.ContextThemeWrapper) r1).getBaseContext());
    }

    public static int getThemeResourceId(Context r1) {
        if ((r1 instanceof ContextThemeWrapper) == false) goto L9;
        return ((Integer) FieldUtils.readField(r1, "mThemeResource")).intValue();
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        if ((r1 instanceof androidx.appcompat.view.ContextThemeWrapper) == true) goto L11;
        return 0;
    L11:
        return ((androidx.appcompat.view.ContextThemeWrapper) r1).getThemeResId();
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration r2) {
        if (this.mPlugin.mResources != null) goto L11;
        if (this.mOverrideConfiguration != null) goto L9;
        this.mOverrideConfiguration = new Configuration(r2);
        return;
    L9:
        throw new IllegalStateException("Override configuration has already been set");
    L11:
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createConfigurationContext(Configuration r3) {
        Context r4 = super.createConfigurationContext(r3);
        FieldUtils.writeField(r4, "mResources", this.mPlugin.mResources);     // Catch: Throwable -> L5
    L9:
        return r4;
    L5:
        aqc.a.a(r4.getClass(), "mResources").set(r4, this.mPlugin.mResources);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String r2) {
        if ("layout_inflater".equals(r2) == true) goto L5;
        Context r0 = this.mOriginContext;
        if (r0 == null) goto L14;
        return r0.getSystemService(r2);
    L14:
        return getBaseContext().getSystemService(r2);
    L5:
        if (this.mInflater != null) goto L8;
        LayoutInflater r3 = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        this.mInflater = r3;
        jqc.b.a(r3);
    L8:
        return this.mInflater;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks r2) {
        if (this.mIsHostApplicationContext == false) goto L5;
        this.mOriginContext.registerComponentCallbacks(r2);
        return;
    L5:
        super.registerComponentCallbacks(r2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks r2) {
        if (this.mIsHostApplicationContext == false) goto L5;
        this.mOriginContext.unregisterComponentCallbacks(r2);
        return;
    L5:
        super.unregisterComponentCallbacks(r2);
    }

    public PluginContext(Context r3, Plugin r4, boolean r5) {
        super(getContextWithoutTheme(r3), getThemeResourceId(r3));
        this.mPlugin = r4;
        this.mOriginContext = r3;
        this.mIsHostApplicationContext = r5;
    }
}
