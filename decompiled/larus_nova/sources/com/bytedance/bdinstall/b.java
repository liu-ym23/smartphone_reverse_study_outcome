package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f199613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f199614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f199615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f199616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f199617e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C2881b f199618f;

    public class a extends i84.r<SharedPreferences> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f199619c;

        public a(b r100) {
            this.f199619c = r100;
        }

        @Override // i84.r
        public final SharedPreferences a(Object[] r100) {
            String r101 = i84.a.b("ug_install_settings_pref", this.f199619c);
            if (TextUtils.equals(r101, "ug_install_settings_pref") == false) goto L6;
            Context r102 = (Context) r100[0];
            return i84.a.f488614a.b(new Object[]{r102});
        L6:
            return ((Context) r100[0]).getSharedPreferences(r101, 0);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdinstall.b$b, reason: collision with other inner class name */
    public class C2881b extends i84.i<SharedPreferences> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f199620b;

        public C2881b(b r100) {
            this.f199620b = r100;
        }

        public final Object a(String r100, Object[] r101) {
            b r102 = this.f199620b;
            i84.a.C6241a r103 = i84.a.f488614a;
            String r104 = i84.a.b("ug_install_settings_pref", r102) + "_" + r100;
            if (TextUtils.equals(r104, "ug_install_settings_pref_" + r100) == false) goto L6;
            return ((Context) r101[0]).getSharedPreferences("ug_install_settings_pref_" + r100, 0);
        L6:
            return ((Context) r101[0]).getSharedPreferences(r104, 0);
        }
    }

    public final String toString() {
        return "AbsEnv{isChildMode=" + this.f199613a + ", config=" + this.f199614b + ", isI18n=" + this.f199615c + ", isBoe=" + this.f199616d + '}';
    }

    public final Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final SharedPreferences a(o0 r100) {
        if (r100.O == true) goto L32;
        Context r101 = r100.getContext();
        String r102 = String.valueOf(r100.f199728a);
        C2881b r103 = this.f199618f;
        Object[] r104 = {r101};
        Object r105 = null;
        if (r103.f488621a != 0) goto L8;
        Object r106 = null;
    L9:
        if (r106 != null) goto L29;
        monitor-enter(r103);
    L25:
        th = move-exception;
        throw th;
    L12:
        if (r103.f488621a == 0) goto L15;
        r105 = r103.f488621a.get(r102);     // Catch: Throwable -> L25
    L15:
        if (r105 != null) goto L22;
        r106 = r103.a(r102, r104);     // Catch: Throwable -> L25
        if (r106 != null) goto L19;
    L23:
        monitor-exit(r103);     // Catch: Throwable -> L25
        goto L29
    L19:
        if (r103.f488621a != 0) goto L21;
        r103.f488621a = new ConcurrentHashMap(4);     // Catch: Throwable -> L25
    L21:
        r103.f488621a.put(r102, (T) r106);     // Catch: Throwable -> L25
        goto L23
    L22:
        r106 = r105;
    L29:
        return (SharedPreferences) r106;
    L8:
        r106 = r103.f488621a.get(r102);
        goto L9
    L32:
        return this.f199617e.b(new Object[]{r100.getContext()});
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (this.f199614b.equals(r101.f199614b) == true) goto L10;
    L16:
        return false;
    L10:
        if (this.f199616d != r101.f199616d) goto L16;
        if (this.f199615c != r101.f199615c) goto L16;
        if (this.f199613a != r101.f199613a) goto L16;
        return true;
    L18:
        return false;
    }

    public b(r0 r100, boolean r101, boolean r102, boolean r103) {
        this.f199617e = new a(this);
        this.f199618f = new C2881b(this);
        this.f199614b = r100;
        this.f199615c = r101;
        this.f199616d = r102;
        this.f199613a = r103;
    }
}
