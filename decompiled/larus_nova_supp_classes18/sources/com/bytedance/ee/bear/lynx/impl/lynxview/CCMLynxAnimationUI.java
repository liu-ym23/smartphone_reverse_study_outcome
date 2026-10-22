package com.bytedance.ee.bear.lynx.impl.lynxview;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.widgets.lottie.CCMLottieRes;
import com.bytedance.ee.bear.widgets.lottie.CCMLottieView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0007J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0012H\u0007R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/lynxview/CCMLynxAnimationUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/bytedance/ee/bear/widgets/lottie/CCMLottieView;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "lottieView", "createView", "Landroid/content/Context;", "setPlaying", "", "isPlaying", "", "setLoop", "loop", "setFrame", "frame", "", "setLottieType", "lottieType", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMLynxAnimationUI extends LynxUI<CCMLottieView> {
    public CCMLottieView a;

    public static final class a {
    }

    static {
    }

    public CCMLynxAnimationUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.View, com.airbnb.lottie.LottieAnimationView, com.bytedance.ee.bear.widgets.lottie.CCMLottieView] */
    public final View createView(Context r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        ?? r0 = new CCMLottieView(r2);
        r0.setRepeatCount(-1);
        this.a = r0;
        return r0;
    }

    @LynxProp(name = "frame")
    public final void setFrame(int r3) {
        tt5.a.h("CCMLynxAnimationUI", "setFrame, frame: " + r3);
        CCMLottieView r0 = this.a;
        if (r0 == null) goto L6;
        r0.setFrame(r3);
        return;
    }

    @LynxProp(name = "loop")
    public final void setLoop(boolean r3) {
        tt5.a.h("CCMLynxAnimationUI", "setLoop, loop: " + r3);
        CCMLottieView r0 = this.a;
        if (r0 == null) goto L9;
        if (r3 == false) goto L6;
        int r4 = -1;
    L7:
        r0.setRepeatCount(r4);
        return;
    L6:
        r4 = 0;
        goto L7
    }

    @LynxProp(name = "lottie-type")
    public final void setLottieType(int r7) {
        CCMLottieRes[] r0 = CCMLottieRes.values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        CCMLottieRes r4 = r0[r3];
        if (r4.getType() != r7) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == true) goto L13;
        r3 = r3 + 1;
    L13:
        if (r4 != null) goto L16;
        tt5.a.k("CCMLynxAnimationUI", "setLottieType, lottie res not found, type: " + r7);
        return;
    L16:
        tt5.a.h("CCMLynxAnimationUI", "setLottieType, found lottie res, type: " + r7);
        CCMLottieView r8 = this.a;
        if (r8 == null) goto L24;
        boolean r2 = r8.isAnimating();
        r8.setAnimation(r4.getResId());
        if (r2 == false) goto L25;
        r8.playAnimation();
        return;
    L25:
        return;
    L24:
        return;
    L7:
        r5 = false;
        goto L8
    L11:
        r4 = null;
        goto L13
    }

    @LynxProp(name = "play")
    public final void setPlaying(boolean r3) {
        tt5.a.h("CCMLynxAnimationUI", "setPlaying, isPlaying: " + r3);
        CCMLottieView r0 = this.a;
        if (r0 == null) goto L8;
        if (r3 == false) goto L6;
        r0.resumeAnimation();
        return;
    L6:
        r0.pauseAnimation();
        return;
    }
}
