package com.google.android.gms.common;

/* JADX INFO: loaded from: classes23.dex */
public class GooglePlayServicesManifestException extends IllegalStateException {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private final int f274458zza;

    public int getActualVersion() {
        return this.f274458zza;
    }

    public int getExpectedVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    public GooglePlayServicesManifestException(int r100, String r101) {
        super(r101);
        this.f274458zza = r100;
    }
}
