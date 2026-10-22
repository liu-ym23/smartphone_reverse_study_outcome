package com.bytedance.navigation.kmp.handler.projection;

import androidx.camera.video.AudioStats;
import com.bytedance.bdnavigationsdk.navigation.j;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f265856f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f265857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f265858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f265859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f265860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f265861e;

    public static final class a {
        public static b a(com.bytedance.bdnavigationsdk.navigation.g r110) {
            Intrinsics.checkNotNullParameter(r110, "navigationInformation");
            j r100 = r110.f200070d;
            com.bytedance.bdnavigationsdk.pojo.b r101 = r100.f200084a;
            if (r101 != null) goto L5;
            return null;
        L5:
            com.bytedance.bdnavigationsdk.pojo.a r102 = r100.f200085b;
            if (r102 != null) goto L9;
            return null;
        L9:
            if (StringsKt.isBlank(r110.f200067a) == false) goto L12;
            return null;
        L12:
            if (r101.f200339f > 0) goto L14;
            return null;
        L14:
            double r103 = r102.f200330a;
            boolean r104 = false;
            if (Double.isInfinite(r103) == false) goto L17;
        L19:
            boolean r105 = false;
        L20:
            if (r105 == false) goto L41;
            double r106 = r102.f200331b;
            if (Double.isInfinite(r106) == false) goto L24;
        L26:
            boolean r107 = false;
        L27:
            if (r107 == true) goto L30;
            return null;
        L30:
            if (r102.f200330a != AudioStats.AUDIO_AMPLITUDE_NONE) goto L32;
            boolean r108 = true;
        L33:
            if (r108 == false) goto L40;
            if (r102.f200331b != AudioStats.AUDIO_AMPLITUDE_NONE) goto L37;
            r104 = true;
        L37:
            if (r104 == false) goto L40;
            return null;
        L40:
            return new b(r110.f200067a, r102.f200330a, r102.f200331b, r101.f200339f, r110.f200069c);
        L32:
            r108 = false;
            goto L33
        L24:
            if (Double.isNaN(r106) == true) goto L26;
            r107 = true;
            goto L27
        L41:
            return null;
        L17:
            if (Double.isNaN(r103) == true) goto L19;
            r105 = true;
            goto L20
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f265857a, r101.f265857a) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.f265858b, r101.f265858b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f265859c, r101.f265859c) == 0) goto L18;
        return false;
    L18:
        if (this.f265860d == r101.f265860d) goto L21;
        return false;
    L21:
        if (this.f265861e == r101.f265861e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f265857a.hashCode() * 31;
        long r101 = Double.doubleToLongBits(this.f265858b);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = Double.doubleToLongBits(this.f265859c);
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f265860d;
        return ((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.f265861e;
    }

    public final String toString() {
        return "ProjectionFrame(navId=" + this.f265857a + ", projLatitude=" + this.f265858b + ", projLongitude=" + this.f265859c + ", locationTimestamp=" + this.f265860d + ", navYawStatus=" + this.f265861e + ")";
    }

    public b(String r100, double r101, double r102, long r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "navId");
        this.f265857a = r100;
        this.f265858b = r101;
        this.f265859c = r102;
        this.f265860d = r103;
        this.f265861e = r104;
    }
}
