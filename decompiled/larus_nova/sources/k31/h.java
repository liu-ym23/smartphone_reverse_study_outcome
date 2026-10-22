package k31;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.revlink.impl.multianchor.constants.GravityDef;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f501650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f501651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f501652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f501653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final GravityDef f501654e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L16;
        h r101 = (h) r100;
        if (this.f501650a == r101.f501650a) goto L8;
        return false;
    L8:
        if (this.f501651b == r101.f501651b) goto L10;
        return false;
    L10:
        if (this.f501652c == r101.f501652c) goto L12;
        return false;
    L12:
        if (this.f501653d == r101.f501653d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f501654e, r101.f501654e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((this.f501650a * 31) + this.f501651b) * 31) + this.f501652c) * 31) + this.f501653d) * 31;
        GravityDef r101 = this.f501654e;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "PlayerLayoutData(width=" + this.f501650a + ", height=" + this.f501651b + ", topMargin=" + this.f501652c + ", leftMargin=" + this.f501653d + ", gravity=" + this.f501654e + ")";
    }

    public h(int r100, int r101, int r102, int r103, GravityDef r104) {
        Intrinsics.checkNotNullParameter(r104, GXTemplateKey.GAIAX_LAYER_GRAVITY);
        this.f501650a = r100;
        this.f501651b = r101;
        this.f501652c = r102;
        this.f501653d = r103;
        this.f501654e = r104;
    }
}
