package com.bytedance.ee.bear.contract;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f217097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f217098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f217099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f217100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f217101e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f217097a, r101.f217097a) == true) goto L12;
        return false;
    L12:
        if (this.f217098b == r101.f217098b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f217099c, r101.f217099c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f217100d, r101.f217100d) == true) goto L21;
        return false;
    L21:
        if (this.f217101e == r101.f217101e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Context r100 = this.f217097a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f217098b) * 31;
        String r104 = this.f217099c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f217100d;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        if (this.f217101e == false) goto L17;
        int r109 = 1231;
    L19:
        return r108 + r109;
    L17:
        r109 = 1237;
        goto L19
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreateDocumentBean(context=" + this.f217097a + ", type=" + this.f217098b + ", path=" + this.f217099c + ", tab=" + this.f217100d + ", isSpaceV2=" + this.f217101e + ')';
    }

    public final Context getContext() {
        return this.f217097a;
    }

    public final int getType() {
        return this.f217098b;
    }

    public k(Context r100, int r101, String r102, boolean r103) {
        this.f217097a = r100;
        this.f217098b = r101;
        this.f217099c = "";
        this.f217100d = r102;
        this.f217101e = r103;
    }
}
