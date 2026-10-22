package tk6;

import android.graphics.Canvas;
import android.graphics.Picture;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.artist.render.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c extends com.bytedance.live.zdanmaku.render.canvas.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Picture f546533d;

    @Override // com.bytedance.live.artist.render.e
    public final void d() {
    }

    @Override // of6.a, com.bytedance.live.artist.render.e
    public final void e() {
        float r100 = this.f546533d.getWidth();
        float r101 = this.f546533d.getHeight();
        RenderEntity r102 = this.f254850a;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("entity");
    L5:
        f r103 = r102.f254828c;
        r103.f254852a = r100;
        r103.f254853b = r101;
    }

    @Override // com.bytedance.live.artist.render.e
    public final void f() {
        Canvas r100 = this.f255886c;
        if (r100 == null) goto L12;
        r100.save();
        RenderEntity r101 = this.f254850a;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("entity");
    L7:
        float r102 = r101.f254829d.f254847a;
        RenderEntity r103 = this.f254850a;
        if (r103 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("entity");
    L10:
        r100.translate(r102, r103.f254829d.f254848b);
        this.f546533d.draw(r100);
        r100.restore();
        return;
    }

    public c(Picture r100) {
        this.f546533d = r100;
    }
}
