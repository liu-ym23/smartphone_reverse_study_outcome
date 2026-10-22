package com.ss.android.lark.lynxkit.templateloader.loaderimpl;

import com.bytedance.ee.bear.bitable.anniex.env.BitableLynxEnv;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Regex f431541g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f431542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f431543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f431544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f431545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f431546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.ss.android.lark.lynxkit.templateloader.loaderimpl.a f431547f;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f431542a, r101.f431542a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f431543b, r101.f431543b) == true) goto L15;
        return false;
    L15:
        if (this.f431544c == r101.f431544c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f431545d, r101.f431545d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f431546e, r101.f431546e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f431547f, r101.f431547f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f431542a.hashCode() * 31) + this.f431543b.hashCode()) * 31;
        if (this.f431544c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.f431545d;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f431546e;
        if (r107 == null) goto L15;
        r104 = r107.hashCode();
    L15:
        return ((r106 + r104) * 31) + this.f431547f.hashCode();
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "BuiltInZstdTemplateLoaderConfig(accessKey=" + this.f431542a + ", channel=" + this.f431543b + ", enabled=" + this.f431544c + ", bundlePath=" + this.f431545d + ", bundleDir=" + this.f431546e + ", resolver=" + this.f431547f + ')';
    }

    static {
        f431541g = new Regex("^[a-zA-Z][a-zA-Z0-9+.-]*:");
    }

    public d(String r100, BitableLynxEnv.b r101) {
        Intrinsics.checkNotNullParameter(r100, "accessKey");
        Intrinsics.checkNotNullParameter("bitable_lynx_channel", "channel");
        Intrinsics.checkNotNullParameter(r101, "resolver");
        this.f431542a = r100;
        this.f431543b = "bitable_lynx_channel";
        this.f431544c = true;
        this.f431545d = null;
        this.f431546e = null;
        this.f431547f = r101;
    }
}
