package g21;

import com.alibaba.gaiax.template.GXTemplateKey;
import fr2.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f479677d;

    public final String toString() {
        return "LayerRenderView(render=" + this.f479676b + ')';
    }

    public b(l r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_LAYER);
        super(r100, r101);
        this.f479677d = r100;
    }
}
