package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes41.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bundle f462277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f462279c;

    public final String a() {
        return this.f462278b;
    }

    public final Bundle b() {
        return this.f462277a;
    }

    public static d a(Intent r100) {
        String r101 = null;
        if (r100 != null) goto L6;
        com.vivo.push.util.t.a("BundleWapper", "create error : intent is null");
        return null;
    L6:
        Bundle r102 = r100.getExtras();
        if (r102 == null) goto L11;
        String r103 = r102.getString("client_pkgname");
        if (TextUtils.isEmpty(r103) == true) goto L11;
    L13:
        if (TextUtils.isEmpty(r103) == false) goto L15;
        com.vivo.push.util.t.b("BundleWapper", "create warning: pkgName is null");
    L15:
        String r104 = r100.getPackage();
        if (TextUtils.isEmpty(r104) == false) goto L26;
        if (r100.getComponent() == null) goto L22;
        r101 = r100.getComponent().getPackageName();
    L22:
        if (TextUtils.isEmpty(r101) == false) goto L24;
        com.vivo.push.util.t.b("BundleWapper", "create warning: targetPkgName is null");
    L24:
        r104 = r101;
    L26:
        return new d(r103, r104, r102);
    L11:
        r103 = null;
        goto L13
    }

    public final byte[] b(String r100) {
        Bundle r101 = this.f462277a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getByteArray(r100);
    }

    public final ArrayList<String> c(String r100) {
        Bundle r101 = this.f462277a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getStringArrayList(r100);
    }

    public final Serializable d(String r100) {
        Bundle r101 = this.f462277a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSerializable(r100);
    }

    public final boolean e(String r100) {
        Bundle r101 = this.f462277a;
        if (r101 != null) goto L6;
        return false;
    L6:
        return r101.getBoolean(r100, false);
    }

    public final String a(String r100) {
        Bundle r101 = this.f462277a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getString(r100);
    }

    public final void a(String r100, int r101) {
        if (this.f462277a != null) goto L5;
        this.f462277a = new Bundle();
    L5:
        this.f462277a.putInt(r100, r101);
    }

    public final int b(String r100, int r101) {
        Bundle r102 = this.f462277a;
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102.getInt(r100, r101);
    }

    public final void a(String r100, long r101) {
        if (this.f462277a != null) goto L5;
        this.f462277a = new Bundle();
    L5:
        this.f462277a.putLong(r100, r101);
    }

    public final long b(String r100, long r101) {
        Bundle r102 = this.f462277a;
        if (r102 != null) goto L6;
        return r101;
    L6:
        return r102.getLong(r100, r101);
    }

    public final void a(String r100, Serializable r101) {
        if (this.f462277a != null) goto L5;
        this.f462277a = new Bundle();
    L5:
        this.f462277a.putSerializable(r100, r101);
    }

    public final void a(String r100, String r101) {
        if (this.f462277a != null) goto L5;
        this.f462277a = new Bundle();
    L5:
        this.f462277a.putString(r100, r101);
    }

    public final void a(String r100, ArrayList<String> r101) {
        if (this.f462277a != null) goto L5;
        this.f462277a = new Bundle();
    L5:
        this.f462277a.putStringArrayList(r100, r101);
    }

    public final void a(String r100, boolean r101) {
        if (this.f462277a != null) goto L5;
        this.f462277a = new Bundle();
    L5:
        this.f462277a.putBoolean(r100, r101);
    }

    public final void a(String r100, byte[] r101) {
        if (this.f462277a != null) goto L5;
        this.f462277a = new Bundle();
    L5:
        this.f462277a.putByteArray(r100, r101);
    }

    public d(String r100, String r101, Bundle r102) {
        this.f462278b = r100;
        this.f462279c = r101;
        this.f462277a = r102;
    }
}
