package x4a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.view.View;
import android.widget.FrameLayout;
import com.lynx.animax.UIAnimaX;
import com.lynx.animax.a0;
import com.lynx.animax.setter.UIAnimaXPropsPrioritySetter;
import com.lynx.animax.ui.AnimaXImageView;
import com.lynx.animax.ui.AnimaXView;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC8195a f562451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimaXView f562452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnimaXImageView f562453c;

    /* JADX INFO: renamed from: x4a.a$a, reason: collision with other inner class name */
    public interface InterfaceC8195a {
    }

    public AnimaXImageView getAnimaXImageView() {
        return this.f562453c;
    }

    public AnimaXView getAnimaXView() {
        return this.f562452b;
    }

    public a(Context r100) {
        super(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        InterfaceC8195a r101 = this.f562451a;
        if (r101 == null) goto L18;
        UIAnimaX r102 = ((a0) r101).f380236a;
        UIAnimaXPropsPrioritySetter.ExecutionPriority r103 = UIAnimaX.f380217p;
        if (r102.getLynxBackground() == null) goto L7;
        BackgroundDrawable r104 = (BackgroundDrawable) r102.getLynxBackground().f383142b;
    L8:
        if (r104 == null) goto L18;
        Path r105 = r104.l();
        if (r105 == null) goto L14;
        r100.clipPath(r105);
        goto L18
    L14:
        if (r102.getSkewX() == 0.0f) goto L16;
    L17:
        r100.clipRect(r102.getClipBounds());
        goto L18
    L16:
        if (r102.getSkewY() == 0.0f) goto L18;
    L7:
        r104 = null;
    L18:
        super.dispatchDraw(r100);
        if (r100.isHardwareAccelerated() == true) goto L25;
        InterfaceC8195a r106 = this.f562451a;
        if (r106 == null) goto L25;
        if (((a0) r106).f380236a.f380231m == false) goto L25;
        boolean r107 = true;
    L26:
        if (r107 == false) goto L37;
        AnimaXView r108 = this.f562452b;
        if (r108 == null) goto L30;
        Bitmap r109 = r108.getBitmap();
    L34:
        if (r109 == null) goto L38;
        r100.drawBitmap(r109, getPaddingLeft(), getPaddingTop(), null);
        return;
    L38:
        return;
    L30:
        AnimaXImageView r110 = this.f562453c;
        if (r110 == null) goto L33;
        r109 = r110.getCurrentBitmap();
        goto L34
    L33:
        r109 = null;
        goto L34
    L37:
        return;
    L25:
        r107 = false;
        goto L26
    }

    public final void a(View r100, a0 r101) {
        if ((r100 instanceof AnimaXView) == false) goto L6;
        this.f562452b = (AnimaXView) r100;
    L8:
        r100.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(r100);
        this.f562451a = r101;
        return;
    L6:
        if ((r100 instanceof AnimaXImageView) == false) goto L10;
        this.f562453c = (AnimaXImageView) r100;
        goto L8
    }
}
