package com.larksuite.component.card.component.lottie;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00122\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0012B\u0013\b\u0014\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0014\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tJ\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000bH\u0014J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¨\u0006\u0013"}, d2 = {"Lcom/larksuite/component/card/component/lottie/LottieUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/airbnb/lottie/LottieAnimationView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "param", "", "(Lcom/lynx/tasm/behavior/LynxContext;Ljava/lang/Object;)V", "createView", "Landroid/content/Context;", "setSrc", "", "src", "", "getRes", "", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class LottieUI extends LynxUI<LottieAnimationView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f283416a = 0;

    public static final class a {
    }

    static {
    }

    public LottieUI(LynxContext r100) {
        super(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LottieAnimationView r101 = new LottieAnimationView(r100);
        r101.setRepeatCount(-1);
        return r101;
    }

    @LynxProp(name = "src")
    public final void setSrc(String r100) {
        Uri r101 = UriProtector.parse(r100);
        if (Intrinsics.areEqual(TemplateNodeType.RAW, r101.getScheme()) == false) goto L9;
        String r102 = r101.getHost();
        if (r102 == null) goto L9;
        if (Intrinsics.areEqual(r102, "loading_anim") == false) goto L9;
        int r103 = R.raw.loading_anim;
    L10:
        if ((-1) == r103) goto L18;
        LottieAnimationView r104 = (LottieAnimationView) this.mView;
        if (r104 == null) goto L14;
        r104.setAnimation(r103);
    L14:
        LottieAnimationView r105 = (LottieAnimationView) this.mView;
        if (r105 == null) goto L19;
        r105.playAnimation();
        return;
    L19:
        return;
    L18:
        return;
    L9:
        r103 = -1;
        goto L10
    }
}
