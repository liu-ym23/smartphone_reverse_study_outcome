package kotlinx.datetime.format;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.UnsignedIntFieldFormatDirective;

/* JADX INFO: loaded from: classes42.dex */
public final class a1 extends UnsignedIntFieldFormatDirective<e> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Padding f505199e;

    public final int hashCode() {
        return this.f505199e.hashCode();
    }

    public a1(Padding r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.FLEXBOX_PADDING);
        kotlinx.datetime.internal.format.p<e, Integer> r101 = DateFields.f505169a;
        kotlinx.datetime.internal.format.w<e> r102 = DateFields.f505170b;
        if (r100 != Padding.ZERO) goto L5;
        int r103 = 2;
    L7:
        if (r100 != Padding.SPACE) goto L9;
        Integer r104 = 2;
    L10:
        super(r102, r103, r104);
        this.f505199e = r100;
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = 1;
        goto L7
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a1) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f505199e != ((a1) r100).f505199e) goto L7;
        return true;
    }
}
