package com.bytedance.ee.bear.tts.lynx.view;

import android.content.Context;
import android.content.res.Configuration;
import android.view.ViewGroup;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.utils.LarkContext;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\u0015H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/tts/lynx/view/TtsLynxPlaylistView;", "Lcom/bytedance/ee/bear/lynx/api/BaseLynxDialogFragment;", "albumVM", "Lcom/bytedance/ee/bear/tts/ITtsAlbumViewModel;", "<init>", "(Lcom/bytedance/ee/bear/tts/ITtsAlbumViewModel;)V", "resultHandler", "Lcom/bytedance/ee/bear/tts/lynx/view/TtsLynxPlaylistView$TtsLynxPlaylistViewResultHandler;", "lynxVM", "Lcom/bytedance/ee/bear/tts/lynx/TtsLynxViewModel;", "isNeedFitSystemWindows", "", "getLynxViewType", "", "getLynxViewInitParams", "", "", "", "getLynxViewLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "onLynxViewCreated", "", "onLynxViewAdded", "onLynxViewDestroyed", WidgetCostModule.TYPE_ON_START, "isEnableForseti", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", LiveCommonConstants.REASON_ON_DEDTROY, "initViewModel", "destroyViewModel", "calculateContainerParams", "Lcom/bytedance/ee/bear/tts/lynx/bean/TtsLynxContainerParams;", "Companion", "TtsLynxPlaylistViewResultHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsLynxPlaylistView extends BaseLynxDialogFragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final mo5.a f239644u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f239645v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final no5.c f239646w;

    public static final class a {
    }

    public static final class b implements mo5.c {
        public b() {
        }

        @Override // mo5.c
        public final void a(TtsResult r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            tt5.a.h("TtsLynxPlaylistView", "TtsLynxPlaylistViewResultHandler-onResult, result: " + r100 + ", isDestroyed: false");
            com.bytedance.ee.bear.tts.a.a(r100);
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment
    public final boolean ja0() {
        return true;
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final int ua0() {
        return 10;
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final void wa0() {
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final Map<String, Object> sa0() {
        no5.a r100 = no5.a.f519907a;
        mo5.a r101 = this.f239644u;
        r100.getClass();
        return no5.a.c(r101).a();
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final ViewGroup.LayoutParams ta0() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final void va0() {
        this.f239644u.l(this.f239645v);
        no5.c r100 = this.f239646w;
        r100.f519918f = new d(this);
        CCMLynxCardView r101 = this.f229858t;
        if (r101 != null) goto L5;
        tt5.a.d("TtsLynxPlaylistView", "initViewModel, lynxView is null.");
        return;
    L5:
        r100.e(r101);
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment
    public final void xa0() {
        this.f239644u.c(this.f239645v);
        no5.c r100 = this.f239646w;
        r100.f519918f = null;
        r100.d();
    }

    @Override // com.bytedance.ee.bear.lynx.api.BaseLynxDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f239644u.c(this.f239645v);
        no5.c r100 = this.f239646w;
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

    public TtsLynxPlaylistView(mo5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "albumVM");
        super("TtsLynxPlaylistView");
        this.f239644u = r100;
        this.f239645v = new b();
        no5.c r101 = new no5.c("TtsLynxPlaylistView", getContext(), r100);
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
        this.f239646w = r101;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        if (ForsetiHelper.t(getActivity()) == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L19;
        tt5.a.h("TtsLynxPlaylistView", "onConfigurationChanged, dismiss self.");
        dismissAllowingStateLoss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L20;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (DowngradeSettingUtil.a("downgradeForsetiTtsModal") == true) goto L7;
        r101 = true;
        goto L8
    }
}
