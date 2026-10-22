package com.ss.android.ainote;

import com.ss.android.ainote.model.AINoteContentState;
import com.ss.android.ainote.model.AINoteCreateSource;
import com.ss.android.ainote.model.AINoteScene;
import com.ss.android.ainote.model.AINoteType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f407162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f407163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f407164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AINoteScene f407165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AINoteType f407166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AINoteCreateSource f407167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f407168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AINoteContentState f407169h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f407170i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f407171j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f407172k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f407173l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f407174m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f407175n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f407162a == r101.f407162a) goto L12;
        return false;
    L12:
        if (this.f407163b == r101.f407163b) goto L15;
        return false;
    L15:
        if (this.f407164c == r101.f407164c) goto L18;
        return false;
    L18:
        if (this.f407165d == r101.f407165d) goto L21;
        return false;
    L21:
        if (this.f407166e == r101.f407166e) goto L24;
        return false;
    L24:
        if (this.f407167f == r101.f407167f) goto L27;
        return false;
    L27:
        if (this.f407168g == r101.f407168g) goto L30;
        return false;
    L30:
        if (this.f407169h == r101.f407169h) goto L33;
        return false;
    L33:
        if (this.f407170i == r101.f407170i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f407171j, r101.f407171j) == true) goto L39;
        return false;
    L39:
        if (this.f407172k == r101.f407172k) goto L42;
        return false;
    L42:
        if (this.f407173l == r101.f407173l) goto L45;
        return false;
    L45:
        if (this.f407174m == r101.f407174m) goto L48;
        return false;
    L48:
        if (this.f407175n == r101.f407175n) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f407162a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f407163b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f407164c;
        int r105 = (((((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f407165d.hashCode()) * 31) + this.f407166e.hashCode()) * 31;
        AINoteCreateSource r106 = this.f407167f;
        int r107 = 0;
        if (r106 != null) goto L5;
        int r108 = 0;
    L6:
        long r109 = this.f407168g;
        int r110 = (((((r105 + r108) * 31) + ((int) (r109 ^ (r109 >>> 32)))) * 31) + this.f407169h.hashCode()) * 31;
        if (this.f407170i == false) goto L9;
        int r111 = 1231;
    L10:
        int r112 = (r110 + r111) * 31;
        String r113 = this.f407171j;
        if (r113 == null) goto L14;
        r107 = r113.hashCode();
    L14:
        int r114 = (r112 + r107) * 31;
        long r115 = this.f407172k;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        long r117 = this.f407173l;
        int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
        long r119 = this.f407174m;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        long r121 = this.f407175n;
        return r120 + ((int) (r121 ^ (r121 >>> 32)));
    L9:
        r111 = 1237;
        goto L10
    L5:
        r108 = r106.hashCode();
        goto L6
    }

    public final String toString() {
        return "AINoteHostNote(noteId=" + this.f407162a + ", cid=" + this.f407163b + ", sid=" + this.f407164c + ", scene=" + this.f407165d + ", noteType=" + this.f407166e + ", noteSource=" + this.f407167f + ", version=" + this.f407168g + ", contentState=" + this.f407169h + ", deleted=" + this.f407170i + ", markId=" + this.f407171j + ", audioLocationTime=" + this.f407172k + ", clientCreateTimeMs=" + this.f407173l + ", createRelMeetingTimeMs=" + this.f407174m + ", createRelAudioTimeMs=" + this.f407175n + ')';
    }

    public static p a(p r310, boolean r311, long r312, int r313) {
        long r100 = 0;
        if ((r313 & 1) == 0) goto L5;
        long r101 = r310.f407162a;
    L7:
        if ((r313 & 2) == 0) goto L9;
        long r110 = r310.f407163b;
    L11:
        if ((r313 & 4) == 0) goto L13;
        long r111 = r310.f407164c;
    L14:
        String r102 = null;
        if ((r313 & 8) == 0) goto L17;
        AINoteScene r112 = r310.f407165d;
    L19:
        if ((r313 & 16) == 0) goto L21;
        AINoteType r113 = r310.f407166e;
    L23:
        if ((r313 & 32) == 0) goto L25;
        AINoteCreateSource r114 = r310.f407167f;
    L27:
        if ((r313 & 64) == 0) goto L29;
        long r115 = r310.f407168g;
    L31:
        if ((r313 & 128) == 0) goto L33;
        AINoteContentState r103 = r310.f407169h;
    L35:
        if ((r313 & 256) == 0) goto L37;
        boolean r210 = r310.f407170i;
    L39:
        if ((r313 & 512) == 0) goto L41;
        r102 = r310.f407171j;
    L41:
        String r211 = r102;
        if ((r313 & 1024) == 0) goto L44;
        long r212 = r310.f407172k;
    L46:
        if ((r313 & 2048) == 0) goto L48;
        long r213 = r310.f407173l;
    L50:
        if ((r313 & 4096) == 0) goto L52;
        long r214 = r310.f407174m;
    L54:
        if ((r313 & 8192) == 0) goto L56;
        r100 = r310.f407175n;
    L56:
        Intrinsics.checkNotNullParameter(r112, "scene");
        Intrinsics.checkNotNullParameter(r113, "noteType");
        Intrinsics.checkNotNullParameter(r103, "contentState");
        return new p(r101, r110, r111, r112, r113, r114, r115, r103, r210, r211, r212, r213, r214, r100);
    L52:
        r214 = 0;
        goto L54
    L48:
        r213 = 0;
        goto L50
    L44:
        r212 = r312;
        goto L46
    L37:
        r210 = r311;
        goto L39
    L33:
        r103 = null;
        goto L35
    L29:
        r115 = 0;
        goto L31
    L25:
        r114 = null;
        goto L27
    L21:
        r113 = null;
        goto L23
    L17:
        r112 = null;
        goto L19
    L13:
        r111 = 0;
        goto L14
    L9:
        r110 = 0;
        goto L11
    L5:
        r101 = 0;
        goto L7
    }

    public p(long r100, long r101, long r110, AINoteScene r111, AINoteType r112, AINoteCreateSource r113, long r114, AINoteContentState r115, boolean r116, String r210, long r211, long r212, long r213, long r214) {
        Intrinsics.checkNotNullParameter(r111, "scene");
        Intrinsics.checkNotNullParameter(r112, "noteType");
        Intrinsics.checkNotNullParameter(r115, "contentState");
        this.f407162a = r100;
        this.f407163b = r101;
        this.f407164c = r110;
        this.f407165d = r111;
        this.f407166e = r112;
        this.f407167f = r113;
        this.f407168g = r114;
        this.f407169h = r115;
        this.f407170i = r116;
        this.f407171j = r210;
        this.f407172k = r211;
        this.f407173l = r212;
        this.f407174m = r213;
        this.f407175n = r214;
    }
}
