package com.hihonor.cloudservice.support.feature.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractSignInAccountInfo implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f276513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f276514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<Scope> f276515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f276516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f276517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f276518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<Scope> f276519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f276520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f276521i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f276522j;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public int hashCode() {
        return new HashSet(this.f276519g).hashCode();
    }

    public String toString() {
        return "{displayName: photoUriString: " + this.f276514b + ",serviceCountryCode: countryCode: ";
    }

    public AbstractSignInAccountInfo() {
        this.f276519g = new HashSet();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof AbstractSignInAccountInfo) == true) goto L10;
        return false;
    L10:
        return this.f276515c.equals(((AbstractSignInAccountInfo) r100).f276515c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f276513a);
        r100.writeString(this.f276514b);
        r100.writeString(this.f276516d);
        r100.writeList(new ArrayList(this.f276515c));
        r100.writeString(this.f276517e);
        r100.writeString(this.f276518f);
        r100.writeString(this.f276520h);
        r100.writeLong(this.f276521i);
        r100.writeString(this.f276522j);
    }

    public AbstractSignInAccountInfo(String r100, String r101, String r102, String r103) {
        this.f276519g = new HashSet();
        this.f276513a = r100;
        this.f276514b = "";
        this.f276515c = null;
        this.f276516d = r101;
        this.f276517e = r102;
        this.f276520h = r103;
    }
}
