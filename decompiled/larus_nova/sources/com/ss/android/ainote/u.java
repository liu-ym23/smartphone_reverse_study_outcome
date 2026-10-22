package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteScene;
import com.ss.android.ainote.model.AINoteType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f407208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f407209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AINoteScene f407210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AINoteType f407211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f407212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f407213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f407214g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (this.f407208a == r101.f407208a) goto L12;
        return false;
    L12:
        if (this.f407209b == r101.f407209b) goto L15;
        return false;
    L15:
        if (this.f407210c == r101.f407210c) goto L18;
        return false;
    L18:
        if (this.f407211d == r101.f407211d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f407212e, r101.f407212e) == true) goto L24;
        return false;
    L24:
        if (this.f407213f == r101.f407213f) goto L27;
        return false;
    L27:
        if (this.f407214g == r101.f407214g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f407208a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f407209b;
        int r103 = (((((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f407210c.hashCode()) * 31) + this.f407211d.hashCode()) * 31) + this.f407212e.hashCode()) * 31;
        long r104 = this.f407213f;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        if (this.f407214g == false) goto L5;
        int r106 = 1231;
    L7:
        return r105 + r106;
    L5:
        r106 = 1237;
        goto L7
    }

    public final String toString() {
        return "AINoteMarkBinding(noteId=" + this.f407208a + ", sid=" + this.f407209b + ", scene=" + this.f407210c + ", noteType=" + this.f407211d + ", markId=" + this.f407212e + ", audioLocationTime=" + this.f407213f + ", deleted=" + this.f407214g + ')';
    }

    public u(long r100, long r101, AINoteScene r102, AINoteType r103, String r104, long r105, boolean r110) {
        Intrinsics.checkNotNullParameter(r102, "scene");
        Intrinsics.checkNotNullParameter(r103, "noteType");
        Intrinsics.checkNotNullParameter(r104, "markId");
        this.f407208a = r100;
        this.f407209b = r101;
        this.f407210c = r102;
        this.f407211d = r103;
        this.f407212e = r104;
        this.f407213f = r105;
        this.f407214g = r110;
    }
}
