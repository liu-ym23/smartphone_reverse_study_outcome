package com.oplus.ocs.base.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.oplus.ocs.base.utils.c;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class CapabilityInfo implements Parcelable {
    public static final Parcelable.Creator<CapabilityInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Feature> f404144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f404145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AuthResult f404146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IBinder f404147d;
    public String mClassName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public AuthResult getAuthResult() {
        return this.f404146c;
    }

    public IBinder getBinder() {
        return this.f404147d;
    }

    public String getClassName() {
        return this.mClassName;
    }

    public List<Feature> getFeatures() {
        return this.f404144a;
    }

    public int getVersion() {
        return this.f404145b;
    }

    public CapabilityInfo(Parcel r100) {
        this.f404144a = r100.readArrayList(Feature.class.getClassLoader());
        this.f404145b = r100.readInt();
        ClassLoader r101 = AuthResult.class.getClassLoader();
        if (TextUtils.isEmpty(this.mClassName) == false) goto L5;
        String r102 = AuthResult.class.getName();
    L6:
        this.f404146c = (AuthResult) c.a(r100, r101, r102);
        this.f404147d = r100.readStrongBinder();
        return;
    L5:
        r102 = this.mClassName;
        goto L6
    }

    public void setBinder(IBinder r100) {
        this.f404147d = r100;
    }

    public void setClassName(String r100) {
        this.mClassName = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeList(this.f404144a);
        r100.writeInt(this.f404145b);
        AuthResult r102 = this.f404146c;
        if (TextUtils.isEmpty(this.mClassName) == false) goto L5;
        String r103 = AuthResult.class.getName();
    L6:
        c.a(r100, r102, r103);
        r100.writeStrongBinder(this.f404147d);
        return;
    L5:
        r103 = this.mClassName;
        goto L6
    }

    public CapabilityInfo(List<Feature> r100, int r101, AuthResult r102) {
        this(r100, r101, r102, null);
    }

    public CapabilityInfo(List<Feature> r100, int r101, AuthResult r102, IBinder r103) {
        this.f404144a = r100;
        this.f404145b = r101;
        this.f404146c = r102;
        this.f404147d = r103;
    }
}
