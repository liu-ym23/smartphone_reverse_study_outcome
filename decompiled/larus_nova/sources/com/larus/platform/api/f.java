package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f365101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f365103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f365104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AuthScene f365105e;

    public f() {
        this(null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f365101a, r101.f365101a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365102b, r101.f365102b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f365103c, r101.f365103c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365104d, r101.f365104d) == true) goto L21;
        return false;
    L21:
        if (this.f365105e == r101.f365105e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f365101a.hashCode() * 31) + this.f365102b.hashCode()) * 31) + this.f365103c.hashCode()) * 31) + this.f365104d.hashCode()) * 31) + this.f365105e.hashCode();
    }

    public final String toString() {
        return "AuthDialogRenderInfo(lifeTraceInfo=" + this.f365101a + ", title=" + this.f365102b + ", cancelText=" + this.f365103c + ", confirmText=" + this.f365104d + ", authScene=" + this.f365105e + ')';
    }

    public f(String r100, AuthScene r101, int r102) {
        String r103 = null;
        if ((r102 & 1) == 0) goto L5;
        JSONObject r104 = new JSONObject();
    L7:
        if ((r102 & 2) == 0) goto L10;
        r100 = "";
    L10:
        if ((r102 & 4) == 0) goto L12;
        String r105 = "";
    L14:
        if ((r102 & 8) == 0) goto L17;
        r103 = "";
    L17:
        if ((r102 & 16) == 0) goto L19;
        r101 = AuthScene.LocalLife;
    L19:
        Intrinsics.checkNotNullParameter(r104, "lifeTraceInfo");
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r105, "cancelText");
        Intrinsics.checkNotNullParameter(r103, "confirmText");
        Intrinsics.checkNotNullParameter(r101, "authScene");
        this.f365101a = r104;
        this.f365102b = r100;
        this.f365103c = r105;
        this.f365104d = r103;
        this.f365105e = r101;
        return;
    L12:
        r105 = null;
        goto L14
    L5:
        r104 = null;
        goto L7
    }
}
