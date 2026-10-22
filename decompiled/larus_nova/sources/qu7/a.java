package qu7;

import com.alibaba.gaiax.template.GXTemplateKey;
import jla.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f534845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.oui.animation.easy.a f534846b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f534845a, r101.f534845a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f534846b, r101.f534846b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f534845a.hashCode() * 31) + this.f534846b.hashCode();
    }

    public final String toString() {
        return "SpringAnimationHolder(animation=" + this.f534845a + ", config=" + this.f534846b + ')';
    }

    public a(d r100, com.obric.oui.animation.easy.a r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f534845a = r100;
        this.f534846b = r101;
    }
}
