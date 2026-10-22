package com.larus.audioplayer.impl.stream;

import android.graphics.Bitmap;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f290466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f290467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f290468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f290469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f290470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f290471f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z) == true) goto L8;
        return false;
    L8:
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f290466a, r101.f290466a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f290467b, r101.f290467b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f290468c, r101.f290468c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f290469d, r101.f290469d) == true) goto L21;
        return false;
    L21:
        if (this.f290470e == r101.f290470e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f290471f, r101.f290471f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f290466a.hashCode() * 31) + this.f290467b.hashCode()) * 31) + this.f290468c.hashCode()) * 31;
        String r101 = this.f290469d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        if (this.f290470e == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        Bitmap r107 = this.f290471f;
        if (r107 == null) goto L15;
        r102 = r107.hashCode();
    L15:
        return r106 + r102;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "StreamPlayerInfo(uuid=" + this.f290466a + ", title=" + this.f290467b + ", artist=" + this.f290468c + ", coverUrl=" + this.f290469d + ", isPlaying=" + this.f290470e + ", coverBitmap=" + this.f290471f + ')';
    }

    public z(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r102, "artist");
        this.f290466a = r100;
        this.f290467b = r101;
        this.f290468c = r102;
        this.f290469d = r103;
        this.f290470e = true;
        this.f290471f = null;
    }
}
