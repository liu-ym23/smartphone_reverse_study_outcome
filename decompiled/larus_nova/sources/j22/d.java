package j22;

import android.text.TextUtils;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: classes9.dex */
public final class d extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.b f496970a;

    public d(c.b r100) {
        this.f496970a = r100;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        super.onAnimationFrame(r100, r101);
        if (r101 != (r100.getFrameCount() - 1)) goto L11;
        c r102 = this.f496970a.f496969b;
        if (r102.f496963d == false) goto L7;
        r102.f496960a.setController(null);
        this.f496970a.f496969b.f496960a.setVisibility(4);
    L7:
        c.b r103 = this.f496970a;
        if (TextUtils.equals(r103.f496968a, r103.f496969b.f496962c) == true) goto L12;
        c r104 = this.f496970a.f496969b;
        r104.a(r104.f496962c);
        return;
    L12:
        return;
    }
}
