package oe4;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f522989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f522990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f522991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f522992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, String> f522993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f522994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f522995g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f522989a, r101.f522989a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522990b, r101.f522990b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f522991c, r101.f522991c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f522992d, r101.f522992d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f522993e, r101.f522993e) == true) goto L24;
        return false;
    L24:
        if (this.f522994f == r101.f522994f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f522995g, r101.f522995g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f522989a.hashCode() * 31) + this.f522990b.hashCode()) * 31) + this.f522991c.hashCode()) * 31) + this.f522992d.hashCode()) * 31;
        HashMap<String, String> r101 = this.f522993e;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        long r104 = this.f522994f;
        int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.f522995g;
        if (r106 == null) goto L11;
        r102 = r106.hashCode();
    L11:
        return r105 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "CJPaySmartInput(taskName=" + this.f522989a + ", sceneModel=" + this.f522990b + ", systemPrompt=" + this.f522991c + ", userPrompt=" + this.f522992d + ", inferenceParams=" + this.f522993e + ", timeoutMs=" + this.f522994f + ", activeLoraName=" + this.f522995g + ')';
    }

    public c(String r100, String r101, String r102, String r103, HashMap r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "taskName");
        Intrinsics.checkNotNullParameter(r101, "sceneModel");
        Intrinsics.checkNotNullParameter(r102, "systemPrompt");
        Intrinsics.checkNotNullParameter(r103, "userPrompt");
        this.f522989a = r100;
        this.f522990b = r101;
        this.f522991c = r102;
        this.f522992d = r103;
        this.f522993e = r104;
        this.f522994f = r105;
        this.f522995g = null;
    }
}
