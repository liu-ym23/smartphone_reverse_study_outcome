package g21;

import android.view.TextureView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextureView f479678d;

    public final String toString() {
        return "TextureRenderView(render=" + this.f479676b + ')';
    }

    public d(TextureView r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "textureView");
        super(r100, r101);
        this.f479678d = r100;
    }
}
