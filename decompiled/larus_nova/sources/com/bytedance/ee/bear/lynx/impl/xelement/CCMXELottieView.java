package com.bytedance.ee.bear.lynx.impl.xelement;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH\u0007J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0007R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/xelement/CCMXELottieView;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/bytedance/ee/bear/lynx/impl/xelement/CCMLynxLottieView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "ccmLynxLottieView", "ASSETS_SCHEME", "", "createView", "Landroid/content/Context;", "setAutoplay", "", "autoplay", "", "setLoop", "loop", "setLocalSrc", "srcUrl", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMXELottieView extends LynxUI<CCMLynxLottieView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CCMLynxLottieView f229977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f229978b;

    public CCMXELottieView(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f229978b = "appAsset";
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        CCMLynxLottieView r101 = new CCMLynxLottieView(r100);
        this.f229977a = r101;
        return r101;
    }

    @LynxProp(name = "autoplay")
    public final void setAutoplay(boolean r100) {
        CCMLynxLottieView r101 = this.f229977a;
        if (r101 == null) goto L6;
        r101.setAutoplay$features_lynx_impl_productionChinaRelease(r100);
        return;
    }

    @LynxProp(name = "src-local")
    public final void setLocalSrc(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L12;
        Uri r101 = UriProtector.parse(r100);
        String r102 = r101.getScheme();
        String r103 = r101.getHost();
        if (Intrinsics.areEqual(this.f229978b, r102) == true) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r103) == true) goto L14;
        CCMLynxLottieView r104 = this.f229977a;
        if (r104 == null) goto L15;
        r104.setAnimationAsset$features_lynx_impl_productionChinaRelease(r103);
        return;
    L15:
        return;
    L14:
        return;
    }

    @LynxProp(name = "loop")
    public final void setLoop(boolean r100) {
        CCMLynxLottieView r101 = this.f229977a;
        if (r101 == null) goto L6;
        r101.setLoop$features_lynx_impl_productionChinaRelease(r100);
        return;
    }
}
