package zkc;

import android.os.SystemClock;
import com.ss.ugc.android.cachalot.api.Trigger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f572740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f572741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f572742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f572743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f572744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Trigger f572745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f572746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f572747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f572748i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f572749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f572750k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Boolean f572751l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Long f572752m;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f572740a, r101.f572740a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f572741b, r101.f572741b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f572742c, r101.f572742c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f572743d, r101.f572743d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f572744e, r101.f572744e) == true) goto L24;
        return false;
    L24:
        if (this.f572745f == r101.f572745f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f572746g, r101.f572746g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f572747h, r101.f572747h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f572748i, r101.f572748i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f572749j, r101.f572749j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f572750k, r101.f572750k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f572751l, r101.f572751l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f572752m, r101.f572752m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f572740a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f572741b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f572742c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f572743d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f572744e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Trigger r116 = this.f572745f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f572746g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f572747h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f572748i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f572749j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.f572750k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.f572751l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Long r137 = this.f572752m;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TaskInfo(preloadTs=" + this.f572740a + ", cacheInitTs=" + this.f572741b + ", taskStartTs=" + this.f572742c + ", bindBeginTs=" + this.f572743d + ", bindDoneTs=" + this.f572744e + ", trigger=" + this.f572745f + ", mainThread=" + this.f572746g + ", reuseViewHolder=" + this.f572747h + ", errorMessage=" + this.f572748i + ", missMessage=" + this.f572749j + ", cacheCount=" + this.f572750k + ", enablePrefetch=" + this.f572751l + ", waitTime=" + this.f572752m + ')';
    }

    public b(int r100) {
        this.f572740a = Long.valueOf(SystemClock.uptimeMillis());
        this.f572741b = null;
        this.f572742c = null;
        this.f572743d = null;
        this.f572744e = null;
        this.f572745f = null;
        this.f572746g = null;
        this.f572747h = null;
        this.f572748i = null;
        this.f572749j = null;
        this.f572750k = null;
        this.f572751l = null;
        this.f572752m = null;
    }
}
