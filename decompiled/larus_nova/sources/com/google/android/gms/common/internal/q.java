package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes23.dex */
public final class q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Uri f274549e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f274550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f274551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ComponentName f274552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f274553d;

    static {
        f274549e = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    }

    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.f274550a, this.f274551b, this.f274552c, 4225, Boolean.valueOf(this.f274553d)});
    }

    public final String toString() {
        String r100 = this.f274550a;
        if (r100 != null) goto L6;
        Preconditions.checkNotNull(this.f274552c);
        return this.f274552c.flattenToString();
    L6:
        return r100;
    }

    public q(ComponentName r100) {
        this.f274550a = null;
        this.f274551b = null;
        Preconditions.checkNotNull(r100);
        this.f274552c = r100;
        this.f274553d = false;
    }

    public final Intent a(Context r100) {
        if (this.f274550a == null) goto L20;
        Intent r101 = null;
        if (this.f274553d == false) goto L16;
        Bundle r102 = new Bundle();
        r102.putString("serviceActionBundleKey", this.f274550a);
        Bundle r103 = r100.getContentResolver().call(f274549e, "serviceIntentCall", null, r102);     // Catch: IllegalArgumentException -> L9
    L11:
        if (r103 == null) goto L14;
        r101 = (Intent) r103.getParcelable("serviceResponseIntentKey");
    L14:
        if (r101 != null) goto L16;
        "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f274550a));
    L9:
        e = move-exception;
        "Dynamic intent resolution failed: ".concat(e.toString());
        r103 = null;
    L16:
        if (r101 == null) goto L18;
        return r101;
    L18:
        return new Intent(this.f274550a).setPackage(this.f274551b);
    L20:
        return new Intent().setComponent(this.f274552c);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Objects.equal(this.f274550a, r101.f274550a) == true) goto L11;
    L17:
        return false;
    L11:
        if (Objects.equal(this.f274551b, r101.f274551b) == false) goto L17;
        if (Objects.equal(this.f274552c, r101.f274552c) == false) goto L17;
        if (this.f274553d != r101.f274553d) goto L17;
        return true;
    }

    public q(String r100) {
        this(r100, "com.google.android.gms", false);
    }

    public q(String r100, String r101, boolean r102) {
        Preconditions.checkNotEmpty(r100);
        this.f274550a = r100;
        Preconditions.checkNotEmpty(r101);
        this.f274551b = r101;
        this.f274552c = null;
        this.f274553d = r102;
    }
}
