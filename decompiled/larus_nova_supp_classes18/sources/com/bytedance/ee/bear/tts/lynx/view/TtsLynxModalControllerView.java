package com.bytedance.ee.bear.tts.lynx.view;

import android.content.Context;
import android.content.res.Configuration;
import androidx.fragment.app.FragmentActivity;
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
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0016\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u000fH\u0014J\b\u0010$\u001a\u00020%H\u0014J\b\u0010&\u001a\u00020\u0015H\u0002J\b\u0010'\u001a\u00020\u0015H\u0002J\b\u0010(\u001a\u00020)H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/tts/lynx/view/TtsLynxModalControllerView;", "Lcom/bytedance/ee/bear/lynx/api/BaseLynxDialogFragment;", "albumVM", "Lcom/bytedance/ee/bear/tts/ITtsAlbumViewModel;", "<init>", "(Lcom/bytedance/ee/bear/tts/ITtsAlbumViewModel;)V", "resultHandler", "Lcom/bytedance/ee/bear/tts/lynx/view/TtsLynxModalControllerView$TtsLynxModalControllerViewResultHandler;", "getResultHandler", "()Lcom/bytedance/ee/bear/tts/lynx/view/TtsLynxModalControllerView$TtsLynxModalControllerViewResultHandler;", "resultHandler$delegate", "Lkotlin/Lazy;", "lynxVM", "Lcom/bytedance/ee/bear/tts/lynx/TtsLynxViewModel;", "getLynxViewType", "", "getLynxViewInitParams", "", "", "", "onLynxViewCreated", "", "onLynxViewAdded", "onLynxViewDestroyed", "onStart", "isEnableForseti", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "getCornerRadius", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseUDBottomSheetDialogFragment$CornerRadius;", "getMinHeightPx", "getMaxHeightRate", "", "initViewModel", "destroyViewModel", "calculateContainerParams", "Lcom/bytedance/ee/bear/tts/lynx/bean/TtsLynxContainerParams;", "Companion", "TtsLynxModalControllerViewResultHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsLynxModalControllerView extends BaseLynxDialogFragment {
    public static final int x = 0;
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
            tt5.a.h("TtsLynxModalControllerView", "TtsLynxModalControllerViewResultHandler-onResult, result: " + r3);
            com.bytedance.ee.bear.tts.a.a(r3);
        }
    }

    public final float ha0() {
        return 0.75f;
    }

    public final int ia0() {
        return 200;
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final int ua0() {
        return 9;
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final void wa0() {
    }

    static {
        x = LarkContext.getApplication().getResources().getDimensionPixelSize(2131169387);
    }

    public final BaseUDBottomSheetDialogFragment.a ga0() {
        int r0 = BaseUDBottomSheetDialogFragment.a.d;
        return BaseUDBottomSheetDialogFragment.a.a.a(x);
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
        TtsLynxPlayerStyle r6 = TtsLynxPlayerStyle.MODAL;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r5.h = r6;
        return r5.a();
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final void va0() {
        this.u.l((b) this.v.getValue());
        no5.c r0 = this.w;
        r0.f = new c(this);
        CCMLynxCardView r1 = this.t;
        if (r1 != null) goto L5;
        tt5.a.d("TtsLynxModalControllerView", "initViewModel, lynxView is null.");
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
    }

    public TtsLynxModalControllerView(mo5.a r4) {
        Intrinsics.checkNotNullParameter(r4, "albumVM");
        super("TtsLynxModalControllerView");
        this.u = r4;
        this.v = LazyKt.lazy(TtsLynxModalControllerView$resultHandler$2.INSTANCE);
        no5.c r1 = new no5.c("TtsLynxModalControllerView", getContext(), r4);
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
        FragmentActivity r3 = getActivity();
        boolean r0 = false;
        if (r3 != null) goto L6;
    L10:
        if (r0 == true) goto L21;
        tt5.a.h("TtsLynxModalControllerView", "onConfigurationChanged, dismiss self.");
        dismissAllowingStateLoss();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L22;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L22:
        return;
    L21:
        return;
    L6:
        if (ForsetiHelper.t(r3) == false) goto L10;
        if (DowngradeSettingUtil.a("downgradeForsetiTtsModal") == true) goto L10;
        r0 = true;
        goto L10
    }
}
