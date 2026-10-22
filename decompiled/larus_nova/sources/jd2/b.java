package jd2;

import android.content.Context;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f498220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f498221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f498222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f498223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f498224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f498225f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f498220a, r101.f498220a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f498221b, r101.f498221b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f498222c, r101.f498222c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f498223d, r101.f498223d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f498224e, r101.f498224e) == true) goto L16;
        return false;
    L16:
        if (this.f498225f == r101.f498225f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        Context r100 = this.f498220a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ViewGroup r104 = this.f498221b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f498222c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f498223d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f498224e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (r112 + r101) * 31;
        boolean r115 = this.f498225f;
        ?? r116 = r115;
        if (r115 == false) goto L25;
        r116 = 1;
    L25:
        return r114 + r116;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ConcertStageLynxLoadParams(context=" + this.f498220a + ", lynxContainer=" + this.f498221b + ", roomId=" + this.f498222c + ", anchorId=" + this.f498223d + ", userId=" + this.f498224e + ", isFeed=" + this.f498225f + ")";
    }

    public final Context getContext() {
        return this.f498220a;
    }

    public b(Context r100, ViewGroup r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "lynxContainer");
        Intrinsics.checkNotNullParameter(r102, "roomId");
        Intrinsics.checkNotNullParameter(r103, "anchorId");
        Intrinsics.checkNotNullParameter(r104, "userId");
        this.f498220a = r100;
        this.f498221b = r101;
        this.f498222c = r102;
        this.f498223d = r103;
        this.f498224e = r104;
        this.f498225f = false;
    }
}
