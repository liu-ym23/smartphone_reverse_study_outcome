package fd2;

import android.content.Context;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f476468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f476469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f476470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f476471d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f476472e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f476473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f476474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ViewGroup f476475h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewGroup f476476i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L24;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f476468a, r101.f476468a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f476469b, r101.f476469b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f476470c, r101.f476470c) == true) goto L12;
        return false;
    L12:
        if (this.f476471d == r101.f476471d) goto L14;
        return false;
    L14:
        if (this.f476472e == r101.f476472e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f476473f, r101.f476473f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f476474g, r101.f476474g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f476475h, r101.f476475h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f476476i, r101.f476476i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        Context r100 = this.f476468a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f476469b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f476470c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f476471d;
        ?? r111 = 1;
        ?? r112 = r110;
        if (r110 == false) goto L17;
        r112 = 1;
    L17:
        int r113 = (r109 + r112) * 31;
        boolean r114 = this.f476472e;
        if (r114 == true) goto L21;
        r111 = r114;
    L21:
        int r115 = (r113 + r111) * 31;
        String r116 = this.f476473f;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        ViewGroup r119 = this.f476474g;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        ViewGroup r122 = this.f476475h;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        ViewGroup r125 = this.f476476i;
        if (r125 == null) goto L37;
        r101 = r125.hashCode();
    L37:
        return r124 + r101;
    L32:
        r123 = 0;
        goto L33
    L28:
        r120 = 0;
        goto L29
    L24:
        r117 = 0;
        goto L25
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
        return "ChorusStageLynxViewLoadParams(context=" + this.f476468a + ", roomId=" + this.f476469b + ", anchorId=" + this.f476470c + ", isFeed=" + this.f476471d + ", isVideoChorus=" + this.f476472e + ", enterFrom=" + this.f476473f + ", rootContainer=" + this.f476474g + ", lyricContainer=" + this.f476475h + ", lynxContainer=" + this.f476476i + ")";
    }

    public final Context getContext() {
        return this.f476468a;
    }

    public b(Context r100, String r101, String r102, boolean r103, boolean r104, String r105, ViewGroup r106, ViewGroup r107, ViewGroup r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        this.f476468a = r100;
        this.f476469b = r101;
        this.f476470c = r102;
        this.f476471d = r103;
        this.f476472e = r104;
        this.f476473f = r105;
        this.f476474g = r106;
        this.f476475h = r107;
        this.f476476i = r110;
    }
}
