package com.ss.android.lark.widget.previewanimation.animation;

import android.view.KeyEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f448000a;

    public b(a r100) {
        this.f448000a = r100;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r100, int r101, KeyEvent r102) {
        boolean r103 = false;
        if (r101 == 4) goto L5;
        return false;
    L5:
        a r104 = this.f448000a;
        Intrinsics.checkNotNull(r102);
        r104.getClass();
        if (r102.getAction() != 0) goto L9;
        r104.f447999g++;
        return true;
    L9:
        if (r102.getAction() != 1) goto L22;
        int r105 = r104.f447999g - 1;
        r104.f447999g = r105;
        if (r105 < 0) goto L23;
        d r106 = r104.f447995c;
        int r107 = r106.f448005c;
        if (r107 == (-1)) goto L17;
        if (r107 != 1) goto L19;
        float r108 = r106.f448004b;
        r106.f448003a.setDestroyAfterAnimationEnd$photo_picker_release(false);
        r106.cancel();
        r106.f448003a.setDestroyAfterAnimationEnd$photo_picker_release(true);
        long r109 = MathKt.roundToLong(r106.f448003a.getDuration() * r108);
        r106.f448005c = -1;
        r106.setDuration(r109);
        r106.f448006d = r108;
        r106.f448007e = r108;
        r106.start();
    L18:
        r103 = true;
    L19:
        r104.f447996d |= r103;
        return r103;
    L17:
        r106.cancel();
        goto L18
    L23:
        return false;
    L22:
        return false;
    }
}
