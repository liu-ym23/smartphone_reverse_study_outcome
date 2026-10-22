package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.document.i5;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0017J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/sharepanel/BitableFormShareLinkSettingPanelFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "lynxView", "Lcom/bytedance/ee/bear/lynx/api/CCMLynxCardView;", "delegateImpl", "Lcom/bytedance/ee/bear/bitable/share/sharepanel/BitableFormShareLinkSettingPanelFragment$Delegate;", "setDelegate", "", "delegate", WidgetCostModule.TYPE_ON_START, WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "Delegate", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableFormShareLinkSettingPanelFragment extends BaseAntiScreenshotsDialogFragment {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f215334j = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CCMLynxCardView f215335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f215336i;

    public static final class a {
    }

    public interface b {
        void a();

        vv4.k b();
    }

    public static final class c extends p66.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitableFormShareLinkSettingPanelFragment f215337b;

        public c(BitableFormShareLinkSettingPanelFragment r100) {
            this.f215337b = r100;
        }

        @Override // p66.a
        public final void e(q66.a r100, p66.a.C7156a r101, XBridgePlatformType r102) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r101, "callback");
            Intrinsics.checkNotNullParameter(r102, "type");
            tt5.a.b("BitableFormShareLinkSettingPanelFragment", "close shareLinkSetting");
            this.f215337b.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r103 = DialogFragmentLancet.sLastShowStack;
            if (r103 == null) goto L12;
            com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements tb5.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vv4.k f215338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitableFormShareLinkSettingPanelFragment f215339b;

        @Override // tb5.m
        public final void a(NonProguard r100) {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // tb5.m
        public final void b(JSONObject r100) {
            tt5.a.b("BitableFormShareLinkSettingPanelFragment", "notifyFormShareLinkSettingChanged " + r100);
            this.f215338a.execJS("document.dispatchEvent(new CustomEvent('formSharePermissionChange'))");
            b r101 = this.f215339b.f215336i;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }

        @Override // tb5.m
        public final void onCallBack(String r100) {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        public d(vv4.k r100, BitableFormShareLinkSettingPanelFragment r101) {
            this.f215338a = r100;
            this.f215339b = r101;
        }
    }

    public static final class e implements CCMLynxCardView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableFormShareLinkSettingPanelFragment f215340a;

        @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView.b
        public final void a(Map<String, String> r100) {
        }

        @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView.b
        public final void onShow() {
        }

        @Override // com.bytedance.ee.bear.lynx.api.CCMLynxCardView.b
        public final void H() {
            this.f215340a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r100 = DialogFragmentLancet.sLastShowStack;
            if (r100 == null) goto L12;
            com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public e(BitableFormShareLinkSettingPanelFragment r100) {
            this.f215340a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        CCMLynxCardView r100 = this.f215335h;
        if (r100 == null) goto L6;
        r100.destroy();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r100 = getDialog();
        if (r100 == null) goto L7;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L7;
        WindowManager.LayoutParams r102 = r101.getAttributes();
        r102.gravity = 80;
        r102.y = com.bytedance.ee.util.ui.k.e(r101.getContext());
        r102.windowAnimations = R.style.ActionSheetDialogAnimation;
        r101.setAttributes(r102);
        r101.setLayout(-1, -1);
        r101.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(getDialog());
    }

    public BitableFormShareLinkSettingPanelFragment() {
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        CCMLynxCardView r101 = this.f215335h;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        CCMLynxCardView r101 = (CCMLynxCardView) org.koin.java.a.c(CCMLynxCardView.class, null, new AnonymousClass1(this), 2);
        b r102 = this.f215336i;
        if (r102 == null) goto L7;
        vv4.k r103 = r102.b();
        if (r103 == null) goto L7;
        i5 r104 = new i5(r103);
        r104.c("notifyFormShareLinkSettingChanged", new d(r103, this));
        r101.c(r104);
        r101.h("ccm.closePage", new c(this));
    L7:
        r101.f(new e(this));
        this.f215335h = r101;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.bitable_form_share_link_setting_panel_fragment, r101, false);
        Bundle r104 = getArguments();
        String r105 = null;
        if (r104 == null) goto L5;
        Serializable r106 = r104.getSerializable("template_data");
    L6:
        Bundle r107 = getArguments();
        if (r107 == null) goto L9;
        r105 = r107.getString("share_ctx_id");
    L9:
        String r108 = r105;
        CCMLynxCardView r109 = this.f215335h;
        if (r109 == null) goto L12;
        ViewGroup r110 = (ViewGroup) r103.findViewById(R.id.form_share_link_setting_container);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        r109.d(r110, 5, (Map) r106, new ViewGroup.LayoutParams(-1, -1), r108);
    L12:
        return r103;
    L5:
        r106 = null;
        goto L6
    }
}
