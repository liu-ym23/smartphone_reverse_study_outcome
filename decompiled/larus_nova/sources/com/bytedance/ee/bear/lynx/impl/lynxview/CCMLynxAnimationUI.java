package com.bytedance.ee.bear.lynx.impl.lynxview;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.widgets.lottie.CCMLottieRes;
import com.bytedance.ee.bear.widgets.lottie.CCMLottieView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0007J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0012H\u0007R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/lynxview/CCMLynxAnimationUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/bytedance/ee/bear/widgets/lottie/CCMLottieView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "lottieView", "createView", "Landroid/content/Context;", "setPlaying", "", "isPlaying", "", "setLoop", "loop", "setFrame", "frame", "", "setLottieType", "lottieType", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMLynxAnimationUI extends LynxUI<CCMLottieView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CCMLottieView f229872a;

    public static final class a {
    }

    static {
    }

    public CCMLynxAnimationUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        CCMLottieView r101 = new CCMLottieView(r100);
        r101.setRepeatCount(-1);
        this.f229872a = r101;
        return r101;
    }

    @LynxProp(name = "frame")
    public final void setFrame(int r100) {
        tt5.a.h("CCMLynxAnimationUI", "setFrame, frame: " + r100);
        CCMLottieView r101 = this.f229872a;
        if (r101 == null) goto L6;
        r101.setFrame(r100);
        return;
    }

    @LynxProp(name = "loop")
    public final void setLoop(boolean r100) {
        tt5.a.h("CCMLynxAnimationUI", "setLoop, loop: " + r100);
        CCMLottieView r101 = this.f229872a;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = -1;
    L7:
        r101.setRepeatCount(r102);
        return;
    L6:
        r102 = 0;
        goto L7
    }

    @LynxProp(name = "lottie-type")
    public final void setLottieType(int r100) {
        CCMLottieRes[] r101 = CCMLottieRes.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        CCMLottieRes r104 = r101[r103];
        if (r104.getType() != r100) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L13;
        r103 = r103 + 1;
    L13:
        if (r104 != null) goto L16;
        tt5.a.k("CCMLynxAnimationUI", "setLottieType, lottie res not found, type: " + r100);
        return;
    L16:
        tt5.a.h("CCMLynxAnimationUI", "setLottieType, found lottie res, type: " + r100);
        CCMLottieView r106 = this.f229872a;
        if (r106 == null) goto L24;
        boolean r107 = r106.isAnimating();
        r106.setAnimation(r104.getResId());
        if (r107 == false) goto L25;
        r106.playAnimation();
        return;
    L25:
        return;
    L24:
        return;
    L7:
        r105 = false;
        goto L8
    L11:
        r104 = null;
        goto L13
    }

    @LynxProp(name = "play")
    public final void setPlaying(boolean r100) {
        tt5.a.h("CCMLynxAnimationUI", "setPlaying, isPlaying: " + r100);
        CCMLottieView r101 = this.f229872a;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        r101.resumeAnimation();
        return;
    L6:
        r101.pauseAnimation();
        return;
    }
}
