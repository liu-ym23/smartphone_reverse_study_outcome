package com.obric.assistant.view;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.window.materials.BlurSceneType;
import com.obric.assistant.window.materials.services.IWindowMaterialService;
import com.obric.oui.material.OMaterialHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes33.dex */
public final class n extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlurSceneType f394330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f394331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f394332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Integer, Unit> f394333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f394334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f394335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f394336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f394337h;

    public static final class a {
    }

    static {
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        ViewCompat.setWindowInsetsAnimationCallback(this, null);
        ViewCompat.setOnApplyWindowInsetsListener(this, null);
        super.onDetachedFromWindow();
        FLogger r100 = FLogger.f375446a;
        r100.i("ObricChatBottomBlurView", "onDetachedFromWindow");
        if (this.f394337h.compareAndSet(true, false) == false) goto L9;
        r100.i("ObricChatBottomBlurView", "clearBlur");
        com.obric.oui.blur.a r101 = getMaskMaterialConfig().f401458g;
        if (r101 == null) goto L7;
        r101.f398868c = 1.0f;
    L7:
        OMaterialHelper.q(this, 0);
        OMaterialHelper.t(this, null);
        return;
    }

    private final int getBlurSrcType() {
        return ((Number) this.f394335f.getValue()).intValue();
    }

    private final com.obric.oui.material.c getMaskMaterialConfig() {
        return (com.obric.oui.material.c) this.f394336g.getValue();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        FLogger r100 = FLogger.f375446a;
        r100.i("ObricChatBottomBlurView", "onAttachedToWindow");
        ViewCompat.setOnApplyWindowInsetsListener(this, new k(this));
        if (this.f394330a != BlurSceneType.WINDOW) goto L5;
        ViewCompat.setWindowInsetsAnimationCallback(this, new ObricChatBottomBlurView$setShowBelowNavigationBar$2(this));
    L5:
        ViewCompat.requestApplyInsets(this);
        IWindowMaterialService r101 = (IWindowMaterialService) ServiceManager.get().getService(IWindowMaterialService.class);
        if (r101 != null) goto L8;
    L10:
        boolean r102 = false;
    L11:
        if (r102 == true) goto L14;
        r100.i("ObricChatBottomBlurView", "setBlur: blur is not enabled");
        return;
    L14:
        if (this.f394337h.compareAndSet(false, true) == false) goto L18;
        r100.i("ObricChatBottomBlurView", "setBlur");
        OMaterialHelper.p(this, getMaskMaterialConfig(), getBlurSrcType());
        OMaterialHelper.t(this, this);
        return;
    L18:
        return;
    L8:
        if (r101.b(getContext()) != true) goto L10;
        r102 = true;
        goto L11
    }

    public final int getBlurHeight() {
        return this.f394334e;
    }

    public final void a(View r100) {
        float r101 = this.f394331b - this.f394332c;
        if (r100.getTranslationY() != r101) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r100.setTranslationY(r101);
        FLogger.f375446a.i("ObricChatBottomBlurView", "updateTranslationY: navigationBarHeight=" + this.f394331b + ", imeBottom=" + this.f394332c + ", translationY=" + r101);
        return;
    L9:
        return;
    L5:
        r102 = false;
        goto L6
    }

    public final void setBlurAlpha(float r100) {
        com.obric.oui.blur.a r101 = getMaskMaterialConfig().f401458g;
        if (r101 == null) goto L6;
        r101.f398868c = r100;
    L6:
        if (this.f394337h.get() == false) goto L9;
        OMaterialHelper.p(this, getMaskMaterialConfig(), getBlurSrcType());
        return;
    }

    public final void setOnImeBottomChangedListener(Function1<? super Integer, Unit> r100) {
        this.f394333d = r100;
        if (this.f394330a != BlurSceneType.WINDOW) goto L7;
        if (r100 == null) goto L8;
        r100.invoke(Integer.valueOf(this.f394332c));
        return;
    L8:
        return;
    }

    public n(final Context r100, BlurSceneType r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "blurSceneType");
        super(r100);
        this.f394330a = r101;
        this.f394334e = i5.w();
        this.f394335f = LazyKt.lazy(new l(this));
        this.f394336g = LazyKt.lazy(new m(r100));
        this.f394337h = new AtomicBoolean(false);
    }
}
