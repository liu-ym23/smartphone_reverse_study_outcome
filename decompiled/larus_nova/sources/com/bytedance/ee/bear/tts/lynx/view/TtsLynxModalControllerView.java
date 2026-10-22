package com.bytedance.ee.bear.tts.lynx.view;

import android.content.Context;
import android.content.res.Configuration;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.lynx.bean.TtsLynxPlayerStyle;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 *2\u00020\u0001:\u0002*+B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\u0016\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010#\u001a\u00020\u000fH\u0014J\b\u0010$\u001a\u00020%H\u0014J\b\u0010&\u001a\u00020\u0015H\u0002J\b\u0010'\u001a\u00020\u0015H\u0002J\b\u0010(\u001a\u00020)H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/tts/lynx/view/TtsLynxModalControllerView;", "Lcom/bytedance/ee/bear/lynx/api/BaseLynxDialogFragment;", "albumVM", "Lcom/bytedance/ee/bear/tts/ITtsAlbumViewModel;", "<init>", "(Lcom/bytedance/ee/bear/tts/ITtsAlbumViewModel;)V", "resultHandler", "Lcom/bytedance/ee/bear/tts/lynx/view/TtsLynxModalControllerView$TtsLynxModalControllerViewResultHandler;", "getResultHandler", "()Lcom/bytedance/ee/bear/tts/lynx/view/TtsLynxModalControllerView$TtsLynxModalControllerViewResultHandler;", "resultHandler$delegate", "Lkotlin/Lazy;", "lynxVM", "Lcom/bytedance/ee/bear/tts/lynx/TtsLynxViewModel;", "getLynxViewType", "", "getLynxViewInitParams", "", "", "", "onLynxViewCreated", "", "onLynxViewAdded", "onLynxViewDestroyed", WidgetCostModule.TYPE_ON_START, "isEnableForseti", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", LiveCommonConstants.REASON_ON_DEDTROY, "getCornerRadius", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/BaseUDBottomSheetDialogFragment$CornerRadius;", "getMinHeightPx", "getMaxHeightRate", "", "initViewModel", "destroyViewModel", "calculateContainerParams", "Lcom/bytedance/ee/bear/tts/lynx/bean/TtsLynxContainerParams;", "Companion", "TtsLynxModalControllerViewResultHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsLynxModalControllerView extends BaseLynxDialogFragment {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f239640x = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final mo5.a f239641u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f239642v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final no5.c f239643w;

    public static final class a {
    }

    public static final class b implements mo5.c {
        public b() {
        }

        @Override // mo5.c
        public final void a(TtsResult r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            tt5.a.h("TtsLynxModalControllerView", "TtsLynxModalControllerViewResultHandler-onResult, result: " + r100);
            com.bytedance.ee.bear.tts.a.a(r100);
        }
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment
    public final float ha0() {
        return 0.75f;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment
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
        f239640x = LarkContext.getApplication().getResources().getDimensionPixelSize(R.dimen.ud_radius_xxl);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment
    public final BaseUDBottomSheetDialogFragment.a ga0() {
        int r100 = BaseUDBottomSheetDialogFragment.a.f216388d;
        return BaseUDBottomSheetDialogFragment.a.C3088a.a(f239640x);
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final Map<String, Object> sa0() {
        no5.a r100 = no5.a.f519907a;
        mo5.a r101 = this.f239641u;
        no5.c r102 = this.f239643w;
        oo5.a r103 = r102.f519916d;
        oo5.c r104 = r102.f519917e;
        r100.getClass();
        oo5.d r105 = no5.a.b(r101, r103, r104);
        TtsLynxPlayerStyle r106 = TtsLynxPlayerStyle.MODAL;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f524605h = r106;
        return r105.a();
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final void va0() {
        this.f239641u.l((b) this.f239642v.getValue());
        no5.c r100 = this.f239643w;
        r100.f519918f = new c(this);
        CCMLynxCardView r101 = this.f229858t;
        if (r101 != null) goto L5;
        tt5.a.d("TtsLynxModalControllerView", "initViewModel, lynxView is null.");
        return;
    L5:
        r100.e(r101);
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final void xa0() {
        this.f239641u.c((b) this.f239642v.getValue());
        no5.c r100 = this.f239643w;
        r100.f519918f = null;
        r100.d();
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f239641u.c((b) this.f239642v.getValue());
        no5.c r100 = this.f239643w;
        r100.f519918f = null;
        r100.d();
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Context r100 = getContext();
        if (r100 != null) goto L5;
        r100 = LarkContext.getApplication();
    L5:
        pa0(UIUtils.getColor(r100, R.color.bg_float));
        qa0();
    }

    public TtsLynxModalControllerView(mo5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "albumVM");
        super("TtsLynxModalControllerView");
        this.f239641u = r100;
        this.f239642v = LazyKt.lazy(TtsLynxModalControllerView$resultHandler$2.INSTANCE);
        no5.c r101 = new no5.c("TtsLynxModalControllerView", getContext(), r100);
        Context r102 = getContext();
        if (r102 != null) goto L5;
        r102 = LarkContext.getApplication();
    L5:
        float r103 = UIUtils.px2dp(r102, DeviceUtils.getScreenWidth(r102));
        float r104 = UIUtils.px2dp(r102, ea0());
        oo5.a r105 = new oo5.a();
        r105.f524584a = r103;
        r105.f524585b = r104;
        r101.f519916d = r105;
        this.f239643w = r101;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        FragmentActivity r101 = getActivity();
        boolean r102 = false;
        if (r101 != null) goto L6;
    L10:
        if (r102 == true) goto L21;
        tt5.a.h("TtsLynxModalControllerView", "onConfigurationChanged, dismiss self.");
        dismissAllowingStateLoss();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L22;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L22:
        return;
    L21:
        return;
    L6:
        if (ForsetiHelper.t(r101) == false) goto L10;
        if (DowngradeSettingUtil.a("downgradeForsetiTtsModal") == true) goto L10;
        r102 = true;
        goto L10
    }
}
