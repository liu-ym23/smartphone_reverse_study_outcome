package com.ss.android.lark.appsetting.api;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import dagger.hilt.EntryPoints;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import io.reactivex.Scheduler;

/* JADX INFO: loaded from: classes34.dex */
public class SettingManager {
    private static final String TAG = "SettingManager";
    private com.ss.android.lark.appsetting.api.a mDependency;
    private final awa.c mGlobalSetting;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SettingManager f408943a = null;

        static {
            f408943a = new SettingManager();
        }
    }

    public SettingManager() {
        awa.c r100 = (awa.c) ((DwarfSPIEntryPoint) EntryPoints.get(AppSettingApiModule.a().getContext(), DwarfSPIEntryPoint.class)).dwarfSPI().get(awa.c.class);     // Catch: Throwable -> L5
    L15:
        this.mDependency = AppSettingApiModule.a();     // Catch: Throwable -> L9
    L11:
        this.mGlobalSetting = r100;
        return;
    L9:
        th = move-exception;
        Log.e(TAG, "init mGlobalSetting failed, use mock impl," + th.getMessage());
    L5:
        th = move-exception;
        Log.e(TAG, "init mGlobalSetting failed, use mock impl, " + th.getMessage());
        r100 = new c();
        goto L15
    }

    private String getCurrentUid() {
        com.ss.android.lark.appsetting.api.a r100 = this.mDependency;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getUid();
    }

    public static SettingManager getInstance() {
        return a.f408943a;
    }

    public <T> T get(Class<T> r100) {
        Log.d(TAG, "get, from SettingManager, clazz: ".concat(r100.getName()));
        return (T) this.mGlobalSetting.y0(getCurrentUid(), r100);
    }

    public boolean getBoolean(Class<?> r100) {
        Log.d(TAG, "getBoolean, from SettingManager, clazz: ".concat(r100.getName()));
        return this.mGlobalSetting.s3(getCurrentUid(), r100);
    }

    public double getDouble(Class<?> r100) {
        Log.d(TAG, "getDouble, from SettingManager, clazz: ".concat(r100.getName()));
        return this.mGlobalSetting.m6(getCurrentUid(), r100);
    }

    public int getInt(Class<?> r100) {
        Log.d(TAG, "getInt, from SettingManager, clazz: ".concat(r100.getName()));
        return this.mGlobalSetting.T1(getCurrentUid(), r100);
    }

    public long getLong(Class<?> r100) {
        Log.d(TAG, "getDouble, from SettingManager, clazz: ".concat(r100.getName()));
        return this.mGlobalSetting.b4(getCurrentUid(), r100);
    }

    public String getString(Class<?> r100) {
        Log.d(TAG, "getString, from SettingManager, clazz: ".concat(r100.getName()));
        return this.mGlobalSetting.V5(getCurrentUid(), r100);
    }

    public <T> void get(Class<T> r100, IGetDataCallback<T> r101) {
        Log.d(TAG, "get, from SettingManager, clazz: ".concat(r100.getName()));
        this.mGlobalSetting.M5(getCurrentUid(), r100, r101);
    }

    public void getBoolean(Class r100, IGetDataCallback<Boolean> r101) {
        Log.d(TAG, "getBoolean, from SettingManager, clazz: ".concat(r100.getName()));
        this.mGlobalSetting.sc(getCurrentUid(), r100, r101);
    }

    public void getDouble(Class r100, IGetDataCallback<Double> r101) {
        Log.d(TAG, "getDouble, from SettingManager, clazz: ".concat(r100.getName()));
        this.mGlobalSetting.Bd(getCurrentUid(), r100, r101);
    }

    public void getInt(Class r100, IGetDataCallback<Integer> r101) {
        Log.d(TAG, "getInt, from SettingManager, clazz: ".concat(r100.getName()));
        this.mGlobalSetting.k9(getCurrentUid(), r100, r101);
    }

    public String getSettingConfig(String r100, boolean r101) {
        return this.mGlobalSetting.q0(getCurrentUid(), r100, r101);
    }

    public void getString(Class r100, IGetDataCallback<String> r101) {
        Log.d(TAG, "getString, from SettingManager, clazz: ".concat(r100.getName()));
        this.mGlobalSetting.C9(getCurrentUid(), r100, r101);
    }

    public <T> void get(Class<T> r100, Scheduler r110, Scheduler r111, IGetDataCallback<T> r112) {
        Log.d(TAG, "get, from SettingManager, clazz: ".concat(r100.getName()));
        this.mGlobalSetting.x3(getCurrentUid(), r100, r110, r111, r112);
    }

    public void getBoolean(Class r100, Scheduler r110, Scheduler r111, IGetDataCallback<Boolean> r112) {
        Log.d(TAG, "getBoolean, from SettingManager, clazz: ".concat(r100.getName()));
        this.mGlobalSetting.m2(getCurrentUid(), r100, r110, r111, r112);
    }

    public void getDouble(Class r100, Scheduler r110, Scheduler r111, IGetDataCallback<Double> r112) {
        Log.d(TAG, "getDouble, from SettingManager, clazz: ".concat(r100.getName()));
        this.mGlobalSetting.D7(getCurrentUid(), r100, r110, r111, r112);
    }

    public void getInt(Class r100, Scheduler r110, Scheduler r111, IGetDataCallback<Integer> r112) {
        Log.d(TAG, "getInt, from SettingManager, clazz: ".concat(r100.getName()));
        this.mGlobalSetting.f7(getCurrentUid(), r100, r110, r111, r112);
    }

    public void getString(Class r100, Scheduler r110, Scheduler r111, IGetDataCallback<String> r112) {
        Log.d(TAG, "getString, from SettingManager, clazz: ".concat(r100.getName()));
        this.mGlobalSetting.p5(getCurrentUid(), r100, r110, r111, r112);
    }
}
