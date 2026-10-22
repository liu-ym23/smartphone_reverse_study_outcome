package com.bytedance.ee.bear.tts.lynx.view;

import android.content.Context;
import android.content.res.Configuration;
import android.view.ViewGroup;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.lynx.bean.TtsLynxPlayerStyle;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0016\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000fH\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001c\u001a\u00020\u001aH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020\u001aH\u0002J\b\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020&H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/tts/lynx/view/TtsLynxFullscreenPlayerView;", "Lcom/bytedance/ee/bear/lynx/api/BaseLynxDialogFragment;", "albumVM", "Lcom/bytedance/ee/bear/tts/ITtsAlbumViewModel;", "<init>", "(Lcom/bytedance/ee/bear/tts/ITtsAlbumViewModel;)V", "resultHandler", "Lcom/bytedance/ee/bear/tts/lynx/view/TtsLynxFullscreenPlayerView$TtsLynxFullscreenPlayerViewResultHandler;", "getResultHandler", "()Lcom/bytedance/ee/bear/tts/lynx/view/TtsLynxFullscreenPlayerView$TtsLynxFullscreenPlayerViewResultHandler;", "resultHandler$delegate", "Lkotlin/Lazy;", "lynxVM", "Lcom/bytedance/ee/bear/tts/lynx/TtsLynxViewModel;", "isNeedFitSystemWindows", "", "getLynxViewType", "", "getLynxViewInitParams", "", "", "", "getLynxViewLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "getIsImmersiveStatusBar", "onLynxViewCreated", "", "onLynxViewAdded", "onLynxViewDestroyed", "onStart", "isEnableForseti", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "initViewModel", "destroyViewModel", "calculateContainerParams", "Lcom/bytedance/ee/bear/tts/lynx/bean/TtsLynxContainerParams;", "Companion", "TtsLynxFullscreenPlayerViewResultHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsLynxFullscreenPlayerView extends BaseLynxDialogFragment {
    public final mo5.a u;
    public final Lazy v;
    public final no5.c w;

    public static final class a {
    }

    public static final class b implements mo5.c {
        public b() {
        }

        @Override // mo5.c
        public final void a(TtsResult r3) {
            Intrinsics.checkNotNullParameter(r3, "result");
            tt5.a.h("TtsLynxFullscreenPlayerView", "TtsLynxFullscreenPlayerViewResultHandler-onResult, ignored result: " + r3);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final int ua0() {
        return 9;
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final void wa0() {
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final Map<String, Object> sa0() {
        no5.a r0 = no5.a.a;
        mo5.a r1 = this.u;
        no5.c r2 = this.w;
        oo5.a r3 = r2.d;
        oo5.c r4 = r2.e;
        r0.getClass();
        oo5.d r5 = no5.a.b(r1, r3, r4);
        TtsLynxPlayerStyle r6 = TtsLynxPlayerStyle.FULLSCREEN;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.h = r6;
        return r5.a();
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final ViewGroup.LayoutParams ta0() {
        ViewGroup.MarginLayoutParams r0 = new ViewGroup.MarginLayoutParams(-1, -1);
        Context r1 = getContext();
        if (r1 != null) goto L5;
        r1 = LarkContext.getApplication();
    L5:
        r0.topMargin = UIUtils.dp2px(r1, 12.0f);
        Context r2 = getContext();
        if (r2 != null) goto L8;
        r2 = LarkContext.getApplication();
    L8:
        r0.bottomMargin = UIUtils.dp2px(r2, 24.0f);
        return r0;
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final void va0() {
        this.u.l((b) this.v.getValue());
        no5.c r0 = this.w;
        r0.f = new com.bytedance.ee.bear.tts.lynx.view.b(this);
        CCMLynxCardView r1 = this.t;
        if (r1 != null) goto L5;
        tt5.a.d("TtsLynxFullscreenPlayerView", "initViewModel, lynxView is null.");
        return;
    L5:
        r0.e(r1);
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final void xa0() {
        this.u.c((b) this.v.getValue());
        no5.c r0 = this.w;
        r0.f = null;
        r0.d();
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        this.u.c((b) this.v.getValue());
        no5.c r0 = this.w;
        r0.f = null;
        r0.d();
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Context r0 = getContext();
        if (r0 != null) goto L5;
        r0 = LarkContext.getApplication();
    L5:
        pa0(UIUtils.getColor(r0, 2131100557));
        qa0();
        ((BaseUDBottomSheetDialogFragment) this).p = false;
        ma0();
    }

    public TtsLynxFullscreenPlayerView(mo5.a r4) {
        Intrinsics.checkNotNullParameter(r4, "albumVM");
        super("TtsLynxFullscreenPlayerView");
        this.u = r4;
        this.v = LazyKt.lazy(TtsLynxFullscreenPlayerView$resultHandler$2.INSTANCE);
        no5.c r1 = new no5.c("TtsLynxFullscreenPlayerView", getContext(), r4);
        Context r5 = getContext();
        if (r5 != null) goto L5;
        r5 = LarkContext.getApplication();
    L5:
        float r0 = UIUtils.px2dp(r5, DeviceUtils.getScreenWidth(r5));
        float r6 = UIUtils.px2dp(r5, ea0());
        oo5.a r2 = new oo5.a();
        r2.a = r0;
        r2.b = r6;
        r1.d = r2;
        this.w = r1;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment*/.onConfigurationChanged(r2);
        if (ForsetiHelper.t(getActivity()) == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L19;
        tt5.a.h("TtsLynxFullscreenPlayerView", "onConfigurationChanged, dismiss self.");
        dismissAllowingStateLoss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L20;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (DowngradeSettingUtil.a("downgradeForsetiTtsModal") == true) goto L7;
        r3 = true;
        goto L8
    }
}
