package vi5;

import android.view.View;
import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f555336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f555337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f555338c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f555339d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f555340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f555341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View.OnClickListener f555342g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f555336a, r101.f555336a) == true) goto L12;
        return false;
    L12:
        if (this.f555337b == r101.f555337b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f555338c, r101.f555338c) == true) goto L18;
        return false;
    L18:
        if (this.f555339d == r101.f555339d) goto L21;
        return false;
    L21:
        if (this.f555340e == r101.f555340e) goto L24;
        return false;
    L24:
        if (this.f555341f == r101.f555341f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f555342g, r101.f555342g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f555336a.hashCode() * 31) + this.f555337b) * 31) + this.f555338c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f555339d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f555340e == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.f555341f == true) goto L15;
        r101 = 1237;
    L15:
        return ((r105 + r101) * 31) + this.f555342g.hashCode();
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "EditPermItemModel(desc=" + this.f555336a + ", descColor=" + this.f555337b + ", tips=" + this.f555338c + ", isSelected=" + this.f555339d + ", clickable=" + this.f555340e + ", showDivider=" + this.f555341f + ", clickListener=" + this.f555342g + ')';
    }

    public c(String r100, int r101, String r102, boolean r103, boolean r104, boolean r105, View.OnClickListener r106) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_APP_DESC);
        Intrinsics.checkNotNullParameter(r102, "tips");
        Intrinsics.checkNotNullParameter(r106, "clickListener");
        this.f555336a = r100;
        this.f555337b = r101;
        this.f555338c = r102;
        this.f555339d = r103;
        this.f555340e = r104;
        this.f555341f = r105;
        this.f555342g = r106;
    }
}
