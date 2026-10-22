package kotlinx.datetime.format;

import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.UnsignedIntFieldFormatDirective;

/* JADX INFO: loaded from: classes42.dex */
public final class c1 extends UnsignedIntFieldFormatDirective<d1> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Padding f505206e;

    public final int hashCode() {
        return this.f505206e.hashCode();
    }

    public c1(Padding r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.FLEXBOX_PADDING);
        kotlinx.datetime.internal.format.w<d1> r101 = TimeFields.f505189a;
        kotlinx.datetime.internal.format.w<d1> r102 = TimeFields.f505191c;
        if (r100 != Padding.ZERO) goto L5;
        int r103 = 2;
    L7:
        if (r100 != Padding.SPACE) goto L9;
        Integer r104 = 2;
    L10:
        super(r102, r103, r104);
        this.f505206e = r100;
        return;
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = 1;
        goto L7
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof c1) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f505206e != ((c1) r100).f505206e) goto L7;
        return true;
    }
}
