package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteContentState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f407152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f407153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f407154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f407155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AINoteMutationRequestType f407156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AINoteContentState f407157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f407158g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (this.f407152a == r101.f407152a) goto L12;
        return false;
    L12:
        if (this.f407153b == r101.f407153b) goto L15;
        return false;
    L15:
        if (this.f407154c == r101.f407154c) goto L18;
        return false;
    L18:
        if (this.f407155d == r101.f407155d) goto L21;
        return false;
    L21:
        if (this.f407156e == r101.f407156e) goto L24;
        return false;
    L24:
        if (this.f407157f == r101.f407157f) goto L27;
        return false;
    L27:
        if (this.f407158g == r101.f407158g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f407152a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f407153b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f407154c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f407155d;
        int r107 = (((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f407156e.hashCode()) * 31;
        AINoteContentState r108 = this.f407157f;
        if (r108 != null) goto L5;
        int r109 = 0;
    L6:
        int r110 = (r107 + r109) * 31;
        if (this.f407158g == false) goto L9;
        int r111 = 1231;
    L11:
        return r110 + r111;
    L9:
        r111 = 1237;
        goto L11
    L5:
        r109 = r108.hashCode();
        goto L6
    }

    public final String toString() {
        return "AINoteTrackedMutation(noteId=" + this.f407152a + ", cid=" + this.f407153b + ", sid=" + this.f407154c + ", requestVersion=" + this.f407155d + ", requestType=" + this.f407156e + ", expectedState=" + this.f407157f + ", deleted=" + this.f407158g + ')';
    }

    public final boolean a(long r100, long r101, long r110) {
        if (r100 <= 0) goto L11;
        if (this.f407152a != r100) goto L7;
    L18:
        return true;
    L7:
        if (this.f407154c == r100) goto L18;
        if (this.f407153b == r100) goto L18;
    L11:
        if (r101 <= 0) goto L15;
        if (this.f407154c == r101) goto L18;
    L15:
        if (r110 > 0) goto L17;
    L19:
        return false;
    L17:
        if (this.f407153b != r110) goto L19;
        goto L18
    }

    public n0(long r100, long r101, long r102, long r103, AINoteMutationRequestType r110, AINoteContentState r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "requestType");
        this.f407152a = r100;
        this.f407153b = r101;
        this.f407154c = r102;
        this.f407155d = r103;
        this.f407156e = r110;
        this.f407157f = r111;
        this.f407158g = r112;
    }
}
