package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes23.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Scope[] f274503o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Feature[] f274504p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f274505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f274506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f274507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f274508d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IBinder f274509e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Scope[] f274510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bundle f274511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Account f274512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Feature[] f274513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Feature[] f274514j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f274515k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f274516l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f274517m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f274518n;

    static {
        CREATOR = new p();
        f274503o = new Scope[0];
        f274504p = new Feature[0];
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        p.a(this, r100, r101);
    }

    public GetServiceRequest(int r100, int r101, int r102, String r103, IBinder r104, Scope[] r105, Bundle r106, Account r107, Feature[] r110, Feature[] r111, boolean r112, int r113, boolean r114, String r115) {
        if (r105 != null) goto L5;
        r105 = f274503o;
    L5:
        if (r106 != null) goto L7;
        r106 = new Bundle();
    L7:
        Feature[] r108 = f274504p;
        if (r110 != null) goto L10;
        r110 = r108;
    L10:
        if (r111 != null) goto L12;
        r111 = r108;
    L12:
        this.f274505a = r100;
        this.f274506b = r101;
        this.f274507c = r102;
        if ("com.google.android.gms".equals(r103) == false) goto L15;
        this.f274508d = "com.google.android.gms";
    L17:
        if (r100 >= 2) goto L22;
        if (r104 == null) goto L20;
        Account r109 = AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(r104));
    L21:
        this.f274512h = r109;
    L23:
        this.f274510f = r105;
        this.f274511g = r106;
        this.f274513i = r110;
        this.f274514j = r111;
        this.f274515k = r112;
        this.f274516l = r113;
        this.f274517m = r114;
        this.f274518n = r115;
        return;
    L20:
        r109 = null;
        goto L21
    L22:
        this.f274509e = r104;
        this.f274512h = r107;
        goto L23
    L15:
        this.f274508d = r103;
        goto L17
    }
}
