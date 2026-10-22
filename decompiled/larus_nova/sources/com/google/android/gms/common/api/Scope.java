package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: loaded from: classes23.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f274466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f274467b;

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return this.f274467b;
    }

    public final int hashCode() {
        return this.f274467b.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Scope) == true) goto L10;
        return false;
    L10:
        return this.f274467b.equals(((Scope) r100).f274467b);
    }

    public Scope(int r100, String r101) {
        Preconditions.checkNotEmpty(r101, "scopeUri must not be null or empty");
        this.f274466a = r100;
        this.f274467b = r101;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        int r102 = this.f274466a;
        int r103 = SafeParcelWriter.beginObjectHeader(r100);
        SafeParcelWriter.writeInt(r100, 1, r102);
        SafeParcelWriter.writeString(r100, 2, this.f274467b, false);
        SafeParcelWriter.finishObjectHeader(r100, r103);
    }
}
