package com.ss.android.vesdk.runtime.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final class VESP {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f455916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences f455917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences.Editor f455918c;

    public static final enum VESPSingleton extends Enum<VESPSingleton> {
        public static final VESPSingleton INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VESPSingleton[] f455919a = null;
        private VESP mInstance;

        static {
            VESPSingleton r100 = new VESPSingleton();
            INSTANCE = r100;
            f455919a = new VESPSingleton[]{r100};
        }

        public VESPSingleton() {
            super("INSTANCE", 0);
            this.mInstance = new VESP();
        }

        public static VESPSingleton[] values() {
            return (VESPSingleton[]) f455919a.clone();
        }

        public VESP getInstance() {
            return this.mInstance;
        }

        public static VESPSingleton valueOf(String r100) {
            return (VESPSingleton) a.a(VESPSingleton.class, r100);
        }
    }

    public static VESP b() {
        return VESPSingleton.INSTANCE.getInstance();
    }

    public VESP() {
        this.f455916a = false;
    }

    public final void c(Context r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f455916a == true) goto L6;
        this.f455917b = r100.getSharedPreferences(r100.getPackageName(), 0);     // Catch: Throwable -> L8
        this.f455916a = true;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T a(String r100, T r101) {
        if ((r101 instanceof String) == false) goto L7;
        return (T) this.f455917b.getString(r100, (String) r101);
    L7:
        if ((r101 instanceof Integer) == false) goto L11;
        return (T) Integer.valueOf(this.f455917b.getInt(r100, ((Integer) r101).intValue()));
    L11:
        if ((r101 instanceof Boolean) == false) goto L15;
        return (T) Boolean.valueOf(this.f455917b.getBoolean(r100, ((Boolean) r101).booleanValue()));
    L15:
        if ((r101 instanceof Float) == false) goto L19;
        return (T) Float.valueOf(this.f455917b.getFloat(r100, ((Float) r101).floatValue()));
    L19:
        if ((r101 instanceof Long) == false) goto L23;
        return (T) Long.valueOf(this.f455917b.getLong(r100, ((Long) r101).longValue()));
    L23:
        return (T) this.f455917b.getString(r100, null);
    }

    public final void d(String r100, Object r101, boolean r102) {
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L4:
        if (this.f455918c != null) goto L6;
        this.f455918c = this.f455917b.edit();     // Catch: Throwable -> L29
    L6:
        monitor-exit(this);
        if ((r101 instanceof String) == false) goto L11;
        this.f455918c.putString(r100, (String) r101);
    L25:
        if (r102 == false) goto L27;
        this.f455918c.apply();
        return;
    L27:
        this.f455918c.commit();
        return;
    L11:
        if ((r101 instanceof Integer) == false) goto L14;
        this.f455918c.putInt(r100, ((Integer) r101).intValue());
        goto L25
    L14:
        if ((r101 instanceof Boolean) == false) goto L17;
        this.f455918c.putBoolean(r100, ((Boolean) r101).booleanValue());
        goto L25
    L17:
        if ((r101 instanceof Float) == false) goto L20;
        this.f455918c.putFloat(r100, ((Float) r101).floatValue());
        goto L25
    L20:
        if ((r101 instanceof Long) == false) goto L22;
        this.f455918c.putLong(r100, ((Long) r101).longValue());
        goto L25
    L22:
        if (r101 != null) goto L24;
        return;
    L24:
        this.f455918c.putString(r100, r101.toString());
        goto L25
    }
}
