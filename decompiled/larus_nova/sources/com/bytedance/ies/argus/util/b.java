package com.bytedance.ies.argus.util;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f246251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f246252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f246253c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f246251a == r101.f246251a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f246252b, r101.f246252b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f246253c, r101.f246253c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.f246251a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f246252b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        JSONObject r106 = this.f246253c;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "success=" + this.f246251a + ", msg=" + this.f246252b;
    }

    public b(boolean r100, String r101, JSONObject r102) {
        this.f246251a = r100;
        this.f246252b = r101;
        this.f246253c = r102;
    }
}
