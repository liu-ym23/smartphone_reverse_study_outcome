package com.hihonor.cloudservice.support.feature.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.cloudservice.support.api.entity.auth.PermissionInfo;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import hxc.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractSignInOptions implements d.a, Parcelable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Scope f276504h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Scope f276505i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Scope> f276506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<PermissionInfo> f276507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f276508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f276509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f276510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f276511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f276512g;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        new PermissionInfo().f276502c = "com.hihonor.account.getUID";
        f276504h = new Scope("profile");
        f276505i = new Scope("openid");
    }

    public int hashCode() {
        ArrayList<Scope> r100 = this.f276506a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r102 + 31) * 31;
        ArrayList<PermissionInfo> r104 = this.f276507b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AbstractSignInOptions) == true) goto L8;
        return false;
    L8:
        AbstractSignInOptions r101 = (AbstractSignInOptions) r100;
        if (a(this.f276506a, r101.f276506a) == true) goto L11;
    L13:
        return false;
    L11:
        if (a(this.f276507b, r101.f276507b) == false) goto L13;
        return true;
    }

    public static boolean a(ArrayList r100, ArrayList r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100.size() == r101.size()) goto L10;
        return false;
    L10:
        return r100.containsAll(r101);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeList(this.f276506a);
        r100.writeList(this.f276507b);
    }

    public AbstractSignInOptions(ArrayList r100, ArrayList r101, String r102, String r103, String r104, boolean r105, boolean r106) {
        this.f276508c = "";
        this.f276509d = "";
        this.f276510e = "";
        this.f276506a = r100;
        this.f276507b = r101;
        this.f276508c = r102;
        this.f276509d = r103;
        this.f276510e = r104;
        this.f276511f = r105;
        this.f276512g = r106;
    }
}
