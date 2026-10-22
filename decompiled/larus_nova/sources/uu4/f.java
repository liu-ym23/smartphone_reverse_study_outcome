package uu4;

import android.util.Pair;
import com.bytedance.ee.bear.bitable.card.model.enums.ETableType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f551747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f551748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f551749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f551750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ETableType f551751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Pair<Long, Long> f551752f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f551747a == r101.f551747a) goto L12;
        return false;
    L12:
        if (this.f551748b == r101.f551748b) goto L15;
        return false;
    L15:
        if (this.f551749c == r101.f551749c) goto L18;
        return false;
    L18:
        if (this.f551750d == r101.f551750d) goto L21;
        return false;
    L21:
        if (this.f551751e == r101.f551751e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f551752f, r101.f551752f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f551747a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f551748b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f551749c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f551750d == true) goto L18;
        r100 = 1237;
    L18:
        int r107 = (r106 + r100) * 31;
        ETableType r108 = this.f551751e;
        int r109 = 0;
        if (r108 != null) goto L21;
        int r110 = 0;
    L22:
        int r111 = (r107 + r110) * 31;
        Pair<Long, Long> r112 = this.f551752f;
        if (r112 == null) goto L27;
        r109 = r112.hashCode();
    L27:
        return r111 + r109;
    L21:
        r110 = r108.hashCode();
        goto L22
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "OpenRecordStartParam(isShowNormalCard=" + this.f551747a + ", isShowInRecord=" + this.f551748b + ", isBaseAdd=" + this.f551749c + ", isReady=" + this.f551750d + ", tableType=" + this.f551751e + ", mergeDataTimes=" + this.f551752f + ')';
    }

    public f(boolean r100, boolean r101, boolean r102, boolean r103, ETableType r104, Pair<Long, Long> r105) {
        this.f551747a = r100;
        this.f551748b = r101;
        this.f551749c = r102;
        this.f551750d = r103;
        this.f551751e = r104;
        this.f551752f = r105;
    }
}
