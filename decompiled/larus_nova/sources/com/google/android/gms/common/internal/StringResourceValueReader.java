package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes23.dex */
public class StringResourceValueReader {

    /* JADX INFO: renamed from: zza, reason: collision with root package name */
    private final Resources f274526zza;

    /* JADX INFO: renamed from: zzb, reason: collision with root package name */
    private final String f274527zzb;

    public StringResourceValueReader(Context r100) {
        Preconditions.checkNotNull(r100);
        Resources r101 = r100.getResources();
        this.f274526zza = r101;
        this.f274527zzb = r101.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    public String getString(String r100) {
        String r101 = this.f274527zzb;
        int r102 = this.f274526zza.getIdentifier(r100, "string", r101);
        if (r102 != 0) goto L7;
        return null;
    L7:
        return this.f274526zza.getString(r102);
    }
}
