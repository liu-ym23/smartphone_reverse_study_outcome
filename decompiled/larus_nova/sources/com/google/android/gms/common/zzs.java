package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes23.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f274630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final zzj f274631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f274632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f274633d;

    static {
        CREATOR = new i();
    }

    public zzs(String r100, @Nullable zzj r101, boolean r102, boolean r103) {
        this.f274630a = r100;
        this.f274631b = r101;
        this.f274632c = r102;
        this.f274633d = r103;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        String r102 = this.f274630a;
        int r103 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeString(r100, 1, r102, false);
        zzj r104 = this.f274631b;
        if (r104 != null) goto L5;
        r104 = null;
    L5:
        SafeParcelWriter.writeIBinder(r100, 2, r104, false);
        SafeParcelWriter.writeBoolean(r100, 3, this.f274632c);
        SafeParcelWriter.writeBoolean(r100, 4, this.f274633d);
        SafeParcelWriter.finishObjectHeader(r100, r103);
    }

    public zzs(String r100, @Nullable IBinder r101, boolean r102, boolean r103) {
        this.f274630a = r100;
        zzk r104 = null;
        if (r101 != null) goto L14;
    L11:
        this.f274631b = r104;
        this.f274632c = r102;
        this.f274633d = r103;
        return;
    L14:
        IObjectWrapper r105 = zzz.zzg(r101).zzd();     // Catch: RemoteException -> L13
        if (r105 != null) goto L8;
        byte[] r106 = null;
    L9:
        if (r106 == null) goto L11;
        r104 = new zzk(r106);
        goto L11
    L8:
        r106 = (byte[]) ObjectWrapper.unwrap(r105);
        goto L9
    }
}
