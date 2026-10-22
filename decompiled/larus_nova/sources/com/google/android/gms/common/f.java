package com.google.android.gms.common;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.errorprone.annotations.CheckReturnValue;

/* JADX INFO: loaded from: classes23.dex */
@CheckReturnValue
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzh f274488a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zzi f274489b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile zzag f274490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f274491d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Context f274492e;

    static {
        new zzf(zzj.zze("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
        new zzg(zzj.zze("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
        f274488a = new zzh(zzj.zze("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
        f274489b = new zzi(zzj.zze("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
        f274491d = new Object();
    }

    public static void c() throws DynamiteModule.LoadingException {
        if (f274490c == null) goto L5;
        return;
    L5:
        Preconditions.checkNotNull(f274492e);
        Object r100 = f274491d;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (f274490c != null) goto L10;
        f274490c = zzaf.zzb(DynamiteModule.load(f274492e, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
    }

    public static synchronized void a(Context r100) {
        monitor-enter(f.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f274492e != null) goto L12;
        if (r100 == null) goto L10;
        f274492e = r100.getApplicationContext();     // Catch: Throwable -> L14
        monitor-exit(f.class);
        return;
    L10:
        monitor-exit(f.class);
        return;
    L12:
        monitor-exit(f.class);
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [com.google.android.gms.common.d] */
    public static k b(final String r100, final zzj r101, final boolean r102, boolean r103) {
        c();     // Catch: DynamiteModule.LoadingException -> L13
        Preconditions.checkNotNull(f274492e);
        zzs r104 = new zzs(r100, r101, r102, r103);
        if (f274490c.zzh(r104, ObjectWrapper.wrap(f274492e.getPackageManager())) == false) goto L9;
        return k.f274581c;
    L9:
        return new j(new d(r102, r100, r101));
    L10:
        e = move-exception;
        return k.c("module call", e);
    L13:
        e = move-exception;
        return k.c("module init: ".concat(String.valueOf(e.getMessage())), e);
    }
}
