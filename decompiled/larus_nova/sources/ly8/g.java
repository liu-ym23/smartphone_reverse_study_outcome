package ly8;

import com.larus.canvas.feature.component.base.ImageResId;
import com.larus.canvas.feature.component.base.TextRes;
import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f511325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageResId f511326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextRes f511327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f511328d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f511325a, r101.f511325a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f511326b, r101.f511326b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f511327c, r101.f511327c) == true) goto L18;
        return false;
    L18:
        if (this.f511328d == r101.f511328d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f511325a.hashCode() * 31) + this.f511326b.hashCode()) * 31) + this.f511327c.hashCode()) * 31) + this.f511328d;
    }

    public final String toString() {
        return "DropdownItemData(id=" + this.f511325a + ", icon=" + this.f511326b + ", desc=" + this.f511327c + ", color=" + this.f511328d + ')';
    }

    public g(String r100, ImageResId r101, TextRes.StringResId r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "icon");
        Intrinsics.checkNotNullParameter(r102, SocialConstants.PARAM_APP_DESC);
        this.f511325a = r100;
        this.f511326b = r101;
        this.f511327c = r102;
        this.f511328d = r103;
    }
}
