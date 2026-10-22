package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes23.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f274620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f274621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f274622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f274623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f274624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f274625f;

    static {
        CREATOR = new g();
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [android.os.IBinder, com.google.android.gms.dynamic.IObjectWrapper] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        String r102 = this.f274620a;
        int r103 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeString(r100, 1, r102, false);
        SafeParcelWriter.writeBoolean(r100, 2, this.f274621b);
        SafeParcelWriter.writeBoolean(r100, 3, this.f274622c);
        SafeParcelWriter.writeIBinder(r100, 4, ObjectWrapper.wrap(this.f274623d), false);
        SafeParcelWriter.writeBoolean(r100, 5, this.f274624e);
        SafeParcelWriter.writeBoolean(r100, 6, this.f274625f);
        SafeParcelWriter.finishObjectHeader(r100, r103);
    }

    public zzo(String r100, boolean r101, boolean r102, IBinder r103, boolean r104, boolean r105) {
        this.f274620a = r100;
        this.f274621b = r101;
        this.f274622c = r102;
        this.f274623d = (Context) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(r103));
        this.f274624e = r104;
        this.f274625f = r105;
    }
}
