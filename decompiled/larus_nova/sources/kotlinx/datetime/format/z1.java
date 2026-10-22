package kotlinx.datetime.format;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.SignedIntFieldFormatDirective;

/* JADX INFO: loaded from: classes42.dex */
public final class z1 extends SignedIntFieldFormatDirective<e> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Padding f505254f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f505255g;

    public final int hashCode() {
        int r100 = this.f505254f.hashCode() * 31;
        if (this.f505255g == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public z1(Padding r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.FLEXBOX_PADDING);
        kotlinx.datetime.internal.format.p<e, Integer> r101 = DateFields.f505169a;
        if (r100 != Padding.ZERO) goto L5;
        int r102 = 4;
    L6:
        Integer r103 = Integer.valueOf(r102);
        if (r100 != Padding.SPACE) goto L9;
        Integer r104 = 4;
    L10:
        super(r101, r103, r104, 4);
        this.f505254f = r100;
        this.f505255g = false;
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = 1;
        goto L6
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof z1) == false) goto L9;
        z1 r101 = (z1) r100;
        if (this.f505254f != r101.f505254f) goto L9;
        if (this.f505255g != r101.f505255g) goto L9;
        return true;
    L9:
        return false;
    }
}
