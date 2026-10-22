package j22;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animatable f496957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.a f496958b;

    public b(c.a r100, Animatable r101) {
        this.f496958b = r100;
        this.f496957a = r101;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        super.onAnimationFrame(r100, r101);
        if (r101 != (r100.getFrameCount() - 1)) goto L18;
        c r102 = this.f496958b.f496967b;
        if (r102.f496963d == true) goto L7;
    L9:
        c r103 = this.f496958b.f496967b;
        if (r103.f496963d == true) goto L12;
    L14:
        c.a r104 = this.f496958b;
        if (r104.f496966a.equals(r104.f496967b.f496961b) == true) goto L19;
        c r105 = this.f496958b.f496967b;
        r105.b(r105.f496961b);
        return;
    L19:
        return;
    L12:
        if (r103.f496964e == false) goto L14;
        this.f496957a.stop();
        ((AnimatedDrawable2) this.f496957a).jumpToFrame(1);
        goto L14
    L7:
        if (r102.f496964e == true) goto L9;
        r102.f496960a.setController(null);
        this.f496958b.f496967b.f496960a.setVisibility(4);
        goto L9
    }
}
