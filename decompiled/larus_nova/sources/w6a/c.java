package w6a;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements LynxKeyframeAnimator.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.c f558444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f558445b;

    @Override // com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator.e
    public final void a(String r100) {
        this.f558445b.f558459l.remove(r100);
        View r101 = this.f558445b.f558448a.getView();
        if (r101 != null) goto L5;
        return;
    L5:
        ViewParent r102 = r101.getParent();
        if (r102 == null) goto L8;
        ((ViewGroup) r102).removeView(r101);
    L8:
        h.c r103 = this.f558444a;
        if (r103 == null) goto L11;
        r103.a();
    L11:
        this.f558445b.f558458k = false;
    }

    public c(e r100, h.c r101) {
        this.f558445b = r100;
        this.f558444a = r101;
    }
}
