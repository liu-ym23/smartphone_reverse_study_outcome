package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.d;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public final class GoogleServices {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private static final Object f274473zza = null;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private static GoogleServices f274474zzb;
    private final String zzc;
    private final Status zzd;
    private final boolean zze;
    private final boolean zzf;

    static {
        f274473zza = new Object();
    }

    public GoogleServices(String r100, boolean r101) {
        this.zzc = r100;
        this.zzd = Status.RESULT_SUCCESS;
        this.zze = r101;
        this.zzf = !r101;
    }

    public static void clearInstanceForTest() {
        Object r100 = f274473zza;
        monitor-enter(r100);
        f274474zzb = null;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static String getGoogleAppId() {
        return checkInitialized("getGoogleAppId").zzc;
    }

    public static boolean isMeasurementEnabled() {
        GoogleServices r100 = checkInitialized("isMeasurementEnabled");
        if (r100.zzd.isSuccess() == true) goto L5;
        return false;
    L5:
        if (r100.zze == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean isMeasurementExplicitlyDisabled() {
        return checkInitialized("isMeasurementExplicitlyDisabled").zzf;
    }

    public GoogleServices(Context r100) {
        Resources r101 = r100.getResources();
        int r102 = r101.getIdentifier("google_app_measurement_enable", "integer", r101.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        boolean r103 = true;
        if (r102 == 0) goto L12;
        int r104 = r101.getInteger(r102);
        if (r104 == 0) goto L7;
        boolean r105 = false;
    L8:
        if (r104 != 0) goto L11;
        r103 = false;
    L11:
        this.zzf = r105;
    L13:
        this.zze = r103;
        d.a(r100);
        String r106 = d.f274538c;
        if (r106 != null) goto L17;
        r106 = new StringResourceValueReader(r100).getString("google_app_id");
    L17:
        if (TextUtils.isEmpty(r106) == false) goto L20;
        this.zzd = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
        this.zzc = null;
        return;
    L20:
        this.zzc = r106;
        this.zzd = Status.RESULT_SUCCESS;
        return;
    L7:
        r105 = true;
        goto L8
    L12:
        this.zzf = false;
        goto L13
    }

    private static GoogleServices checkInitialized(String r100) {
        Object r101 = f274473zza;
        monitor-enter(r101);
        GoogleServices r102 = f274474zzb;     // Catch: Throwable -> L10
        if (r102 == null) goto L9;
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    L9:
        throw new IllegalStateException("Initialize must be called before " + r100 + ".");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static Status initialize(Context r100) {
        Preconditions.checkNotNull(r100, "Context must not be null.");
        Object r101 = f274473zza;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f274474zzb != null) goto L7;
        f274474zzb = new GoogleServices(r100);     // Catch: Throwable -> L10
    L7:
        Status r102 = f274474zzb.zzd;     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    }

    public Status checkGoogleAppId(String r100) {
        String r101 = this.zzc;
        if (r101 == null) goto L9;
        if (r101.equals(r100) == true) goto L9;
        return new Status(10, "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '" + this.zzc + "'.");
    L9:
        return Status.RESULT_SUCCESS;
    }

    @ResultIgnorabilityUnspecified
    public static Status initialize(Context r100, String r101, boolean r102) {
        Preconditions.checkNotNull(r100, "Context must not be null.");
        Preconditions.checkNotEmpty(r101, "App ID must be nonempty.");
        Object r103 = f274473zza;
        monitor-enter(r103);
        GoogleServices r104 = f274474zzb;     // Catch: Throwable -> L12
        if (r104 == null) goto L9;
        Status r105 = r104.checkGoogleAppId(r101);     // Catch: Throwable -> L12
        monitor-exit(r103);     // Catch: Throwable -> L12
        return r105;
    L9:
        GoogleServices r106 = new GoogleServices(r101, r102);     // Catch: Throwable -> L12
        f274474zzb = r106;     // Catch: Throwable -> L12
        Status r107 = r106.zzd;     // Catch: Throwable -> L12
        monitor-exit(r103);     // Catch: Throwable -> L12
        return r107;
    L12:
        th = move-exception;
        throw th;
    }
}
