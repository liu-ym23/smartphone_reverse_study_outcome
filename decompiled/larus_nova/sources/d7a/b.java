package d7a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.lynx.tasm.behavior.ui.image.InlineImageShadowNode;

/* JADX INFO: loaded from: classes32.dex */
public final class b extends com.lynx.tasm.behavior.ui.text.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public f f467299q;

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void e() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void f() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void g() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void h() {
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final Drawable c() {
        return this.f467299q.f467323j;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void d() {
        f r100 = this.f467299q;
        if (r100 != null) goto L5;
        return;
    L5:
        f.e r101 = r100.V1;
        if (r101 == null) goto L10;
        r101.b();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a
    public final void j(Drawable.Callback r100) {
        this.f383090o = r100;
        if (this.f383082g > 0) goto L5;
        return;
    L5:
        if (this.f383081f <= 0) goto L9;
        this.f467299q.z();
        return;
    }

    public b(int r100, int r101, int[] r102) {
        super(r100, r101, r102);
    }

    public b(int r100, int r101, int[] r110, InlineImageShadowNode.a r111) {
        super(r100, r101, r110);
        this.f467299q = r111;
        r111.l(this.f383082g, this.f383081f, 0, 0, 0, 0);
        this.f467299q.F = true;
    }

    @Override // com.lynx.tasm.behavior.ui.text.a, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r110) {
        if (this.f383090o != null) goto L5;
        return;
    L5:
        super.draw(r100, r101, r102, r103, r104, r105, r106, r107, r110);
    }
}
