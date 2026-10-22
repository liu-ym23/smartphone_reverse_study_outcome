package pf9;

import com.larus.im.service.audio.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h0 implements z0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f528918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f528919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f528920d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f528917a, r101.f528917a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528918b, r101.f528918b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f528919c, r101.f528919c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f528920d, r101.f528920d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f528917a.hashCode() * 31) + this.f528918b.hashCode()) * 31) + this.f528919c.hashCode()) * 31) + this.f528920d.hashCode();
    }

    public final String toString() {
        return "FlowLLMSISecurityCheckEvent(astSedId=" + this.f528917a + ", asrReplaceContent=" + this.f528918b + ", chatReplaceContent=" + this.f528919c + ", srcChannel=" + this.f528920d + ')';
    }

    public h0() {
        this("", "", "", "");
    }

    public h0(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "astSedId");
        Intrinsics.checkNotNullParameter(r101, "asrReplaceContent");
        Intrinsics.checkNotNullParameter(r102, "chatReplaceContent");
        Intrinsics.checkNotNullParameter(r103, "srcChannel");
        this.f528917a = r100;
        this.f528918b = r101;
        this.f528919c = r102;
        this.f528920d = r103;
    }
}
