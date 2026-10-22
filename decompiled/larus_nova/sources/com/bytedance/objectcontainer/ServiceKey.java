package com.bytedance.objectcontainer;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes21.dex */
class ServiceKey {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f266130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f266131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f266132c;

    public final String a() {
        if (TextUtils.isEmpty(this.f266131b) == true) goto L7;
        return this.f266130a.toString() + "(" + this.f266131b + ")";
    L7:
        return this.f266130a.toString();
    }

    public final int hashCode() {
        if (this.f266132c != Integer.MIN_VALUE) goto L10;
        int r100 = this.f266130a.hashCode();
        String r101 = this.f266131b;
        if (r101 != null) goto L7;
        int r102 = 0;
    L8:
        this.f266132c = r100 ^ r102;
        goto L10
    L7:
        r102 = r101.hashCode();
    L10:
        return this.f266132c;
    }

    public final String toString() {
        return "ServiceKey{" + String.valueOf(this.f266130a) + " " + this.f266131b + i.f25855d;
    }

    public ServiceKey(Type r100) {
        this.f266132c = Integer.MIN_VALUE;
        this.f266130a = r100;
        this.f266131b = null;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof ServiceKey) == true) goto L5;
        return false;
    L5:
        ServiceKey r101 = (ServiceKey) r100;
        Type r102 = r101.f266130a;
        Type r103 = this.f266130a;
        int r104 = Utlity.f266134a;
        if (r102 == r103) goto L12;
        if (r102 != null) goto L9;
    L11:
        boolean r105 = false;
    L13:
        if (r105 == false) goto L25;
        String r106 = r101.f266131b;
        String r107 = this.f266131b;
        if (r106 == r107) goto L21;
        if (r106 != null) goto L18;
    L20:
        boolean r108 = false;
    L22:
        if (r108 == false) goto L26;
        return true;
    L26:
        return false;
    L18:
        if (r106.equals(r107) == false) goto L20;
    L21:
        r108 = true;
        goto L22
    L25:
        return false;
    L9:
        if (r102.equals(r103) == false) goto L11;
    L12:
        r105 = true;
        goto L13
    }
}
