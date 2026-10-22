package ijc;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;

/* JADX INFO: loaded from: classes40.dex */
public final class d extends hjc.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f490160a;

    public d(a r100) {
        this.f490160a = r100;
    }

    @Override // hjc.f.b
    public final void a(hjc.f r100, View r101, int r102, int r103) {
        int r104 = r100.f485508a;
        boolean r105 = false;
        r100.f485513f = false;
        float r106 = a.a(this.f490160a, r101);
        int r107 = a.b(r100.f485508a, null);
        if ((r104 & 12) == 0) goto L5;
        r105 = true;
    L5:
        if (r105 == false) goto L7;
        r102 = r103;
    L7:
        int r108 = r104 & 5;
        int r109 = Math.abs(r102);
        if (r108 != 0) goto L11;
        r109 = -r109;
    L11:
        if (r105 == false) goto L13;
        DynamicAnimation.ViewProperty r110 = DynamicAnimation.TRANSLATION_Y;
    L14:
        FlingAnimation r111 = new FlingAnimation(r101, r110);
        float r112 = r107;
        FlingAnimation r113 = r111.setMinValue(Math.min(r106, r112)).setMaxValue(Math.max(r106, r112)).setFriction(0.1f);
        if (r109 <= 0) goto L17;
        int r114 = Math.max(r109, 7000);
    L18:
        r113.setStartVelocity(r114).addUpdateListener(new c(r100)).addEndListener(new b(r100)).start();
        return;
    L17:
        r114 = Math.min(r109, -7000);
        goto L18
    L13:
        r110 = DynamicAnimation.TRANSLATION_X;
        goto L14
    }
}
