package com.ss.videoarch.live.ttquic;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Process;
import android.preference.PreferenceManager;

/* JADX INFO: loaded from: classes38.dex */
public class ContextUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "ContextUtils";
    private static Context sApplicationContext;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static SharedPreferences f458589a;

        static {
            f458589a = ContextUtils.access$000();
        }
    }

    public ContextUtils() {
    }

    private static SharedPreferences fetchAppSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(sApplicationContext);
    }

    public static /* synthetic */ SharedPreferences access$000() {
        return fetchAppSharedPreferences();
    }

    public static AssetManager getApplicationAssets() {
        Context r100 = getApplicationContext();
    L4:
        if ((r100 instanceof ContextWrapper) == false) goto L7;
        r100 = ((ContextWrapper) r100).getBaseContext();
        goto L4
    L7:
        return r100.getAssets();
    }

    public static boolean isIsolatedProcess() {
        return Process.isIsolated();
    }

    static {
    }

    public static SharedPreferences getAppSharedPreferences() {
        return a.f458589a;
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static void initApplicationContext(Context r100) {
        initJavaSideApplicationContext(r100);
    }

    public static void initApplicationContextForTests(Context r100) {
        initJavaSideApplicationContext(r100);
        a.f458589a = fetchAppSharedPreferences();
    }

    private static void initJavaSideApplicationContext(Context r100) {
        if ((r100 instanceof Application) == false) goto L5;
        r100 = new ContextWrapper(r100);
    L5:
        sApplicationContext = r100;
    }
}
