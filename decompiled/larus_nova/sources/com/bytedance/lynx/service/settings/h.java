package com.bytedance.lynx.service.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.lynx.service.trail.TrailServiceBridge;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Gson f264980e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile h f264981f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f264982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<String, Object> f264983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReadWriteLock f264984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f264985d;

    static {
        f264980e = new Gson();
    }

    public static h c() {
        if (f264981f != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f264981f != null) goto L9;
        f264981f = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f264981f;
    }

    public final String f() {
        SharedPreferences r100 = this.f264982a;
        if (r100 != null) goto L7;
        LLog.e("LynxSettingsManager", "please call initialize first");
        return null;
    L7:
        if (r100.contains("settings") == true) goto L15;
        LLog.i("LynxSettingsManager", "Lynx load local cached settings: no cached.");
        return null;
    L15:
        return this.f264982a.getString("settings", "");
    L12:
        e = move-exception;
        LLog.e("LynxSettingsManager", "Lynx load local cached settings exception " + e);
        return null;
    }

    public h() {
        this.f264982a = null;
        this.f264983b = null;
        this.f264984c = new ReentrantReadWriteLock();
        this.f264985d = null;
    }

    public static HashMap a(String r100) {
        if (r100 != null) goto L27;
        return null;
    L27:
        Gson r101 = f264980e;     // Catch: Throwable -> L15 IllegalStateException -> L19 JsonParseException -> L21
        JsonElement r102 = (JsonElement) r101.fromJson(r100, JsonElement.class);     // Catch: Throwable -> L15 IllegalStateException -> L19 JsonParseException -> L21
        if (r102 == null) goto L29;
        HashMap r103 = (HashMap) r101.fromJson(r102.getAsJsonObject(), HashMap.class);     // Catch: Throwable -> L15 IllegalStateException -> L19 JsonParseException -> L21
        LLog.i("LynxSettingsManager", "Lynx load local cached settings success");     // Catch: Throwable -> L9 IllegalStateException -> L11 JsonParseException -> L13
    L30:
        return r103;
    L13:
        Object e100 = e;
    L23:
        LLog.e("LynxSettingsManager", "Lynx settings initialize exception " + e100);
    L11:
        e100 = e;
    L9:
        Object th10 = th;
    L17:
        LLog.e("LynxSettingsManager", "Lynx settings unexpected exception " + th10);
        goto L30
    L29:
        return null;
    L21:
        e = e;
    L22:
        e100 = e;
        r103 = null;
    L19:
        e = e;
    L15:
        th = move-exception;
        th10 = th;
        r103 = null;
        goto L17
    }

    public final void b(Context r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f264982a != null) goto L20;
        TraceEvent.beginSection("LynxSettingsManager.initialize");
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (this.f264982a != null) goto L11;
        this.f264985d = r100;     // Catch: Throwable -> L17
        this.f264982a = r100.getSharedPreferences("lynx_settings_manager_sp", 0);     // Catch: Throwable -> L17
        String r101 = f();     // Catch: Throwable -> L17
    L12:
        monitor-exit(this);     // Catch: Throwable -> L17
        HashMap<String, Object> r102 = a(r101);
        if (r102 == null) goto L16;
        g(r102);
    L16:
        TraceEvent.endSection("LynxSettingsManager.initialize");
        return;
    L11:
        r101 = null;
        goto L12
    }

    public final void g(HashMap<String, Object> r100) {
        ((ReentrantReadWriteLock) this.f264984c).readLock().lock();
        HashMap<String, Object> r101 = this.f264983b;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        ((ReentrantReadWriteLock) this.f264984c).readLock().unlock();
        if (r102 == false) goto L14;
        ((ReentrantReadWriteLock) this.f264984c).writeLock().lock();
        this.f264983b = r100;
        ((ReentrantReadWriteLock) this.f264984c).writeLock().unlock();
        LynxEnv.inst().setSettings(this.f264983b);
        if (s07.a.f540023a.ensureInitialized() == false) goto L16;
        TrailServiceBridge.nativeCleanCache();
        return;
    L16:
        return;
    L14:
        LLog.i("LynxSettingsManager", "settings hash not changed");
        return;
    L5:
        if (r101.equals(r100) == false) goto L8;
        r102 = false;
        goto L9
    }

    public final void d(JsonObject r100, long r101) {
        String r102 = r100.toString();
        if (LynxLiteConfigs.enablePrimJSTrail() == false) goto L5;
        wp7.a.b().c(r102, Integer.valueOf((int) r101), this.f264985d);
    L5:
        monitor-enter(this);
        SharedPreferences r103 = this.f264982a;     // Catch: Throwable -> L12
        if (r103 == null) goto L9;
        r103.edit().putString("settings", r102).putLong("settings_time", r101).apply();     // Catch: Throwable -> L12
    L9:
        monitor-exit(this);     // Catch: Throwable -> L12
        g((HashMap) GsonProtectorUtils.fromJson(f264980e, r100, HashMap.class));
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void e(String r100, long r101) {
        LLog.i("LynxSettingsManager", "Lynx setSettings " + r100);
        JsonObject r102 = (JsonObject) f264980e.fromJson(r100, JsonObject.class);     // Catch: Throwable -> L9 JsonParseException -> L11
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.isJsonObject() == false) goto L17;
        d(r102, r101);     // Catch: Throwable -> L9 JsonParseException -> L11
    L19:
        return;
    L17:
        return;
    L11:
        e = move-exception;
        LLog.e("LynxSettingsManager", "Lynx set settings exception " + e);
        return;
    L9:
        th = move-exception;
        LLog.e("LynxSettingsManager", "Lynx settings unexpected exception " + th);
    }
}
