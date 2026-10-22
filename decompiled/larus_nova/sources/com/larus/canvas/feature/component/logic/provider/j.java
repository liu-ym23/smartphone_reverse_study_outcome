package com.larus.canvas.feature.component.logic.provider;

import androidx.fragment.app.Fragment;
import com.larus.canvas.feature.component.logic.j2;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f323442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f323443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f323444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0 f323445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Integer> f323446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f323447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f323448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Fragment f323449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f323450i;

    public j() {
        this(null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f323442a == r101.f323442a) goto L12;
        return false;
    L12:
        if (this.f323443b == r101.f323443b) goto L15;
        return false;
    L15:
        if (this.f323444c == r101.f323444c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f323445d, r101.f323445d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f323446e, r101.f323446e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f323447f, r101.f323447f) == true) goto L27;
        return false;
    L27:
        if (this.f323448g == r101.f323448g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f323449h, r101.f323449h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f323450i, r101.f323450i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f323442a * 31) + this.f323443b) * 31;
        long r101 = this.f323444c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        c0 r103 = this.f323445d;
        int r104 = 0;
        if (r103 != null) goto L5;
        int r105 = 0;
    L6:
        int r106 = (((((r102 + r105) * 31) + this.f323446e.hashCode()) * 31) + this.f323447f.hashCode()) * 31;
        if (this.f323448g == false) goto L9;
        int r107 = 1231;
    L10:
        int r108 = (r106 + r107) * 31;
        Fragment r109 = this.f323449h;
        if (r109 == null) goto L15;
        r104 = r109.hashCode();
    L15:
        return ((r108 + r104) * 31) + this.f323450i.hashCode();
    L9:
        r107 = 1237;
        goto L10
    L5:
        r105 = r103.hashCode();
        goto L6
    }

    public final String toString() {
        return "CanvasGalleryContext(initializedIndex=" + this.f323442a + ", gallerySize=" + this.f323443b + ", animationDuration=" + this.f323444c + ", sidebarCallback=" + this.f323445d + ", creationStateRecord=" + this.f323446e + ", creationIdRecord=" + this.f323447f + ", useNewStyle=" + this.f323448g + ", fragment=" + this.f323449h + ", traceParams=" + this.f323450i + ')';
    }

    public j(j2 r100, Fragment r101, int r102) {
        if ((r102 & 4) == 0) goto L5;
        long r103 = 200;
    L6:
        LinkedHashMap r104 = null;
        if ((r102 & 8) == 0) goto L10;
        r100 = null;
    L10:
        if ((r102 & 16) == 0) goto L12;
        LinkedHashMap r105 = new LinkedHashMap();
    L14:
        if ((r102 & 32) == 0) goto L16;
        LinkedHashMap r106 = new LinkedHashMap();
    L18:
        if ((r102 & 128) == 0) goto L21;
        r101 = null;
    L21:
        if ((r102 & 256) == 0) goto L23;
        r104 = new LinkedHashMap();
    L23:
        Intrinsics.checkNotNullParameter(r105, "creationStateRecord");
        Intrinsics.checkNotNullParameter(r106, "creationIdRecord");
        Intrinsics.checkNotNullParameter(r104, "traceParams");
        this.f323442a = 0;
        this.f323443b = 0;
        this.f323444c = r103;
        this.f323445d = r100;
        this.f323446e = r105;
        this.f323447f = r106;
        this.f323448g = false;
        this.f323449h = r101;
        this.f323450i = r104;
        return;
    L16:
        r106 = null;
        goto L18
    L12:
        r105 = null;
        goto L14
    L5:
        r103 = 0;
        goto L6
    }
}
