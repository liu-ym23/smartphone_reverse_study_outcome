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
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.document.i5;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0017J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/sharepanel/BitableFormShareLinkSettingPanelFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "lynxView", "Lcom/bytedance/ee/bear/lynx/api/CCMLynxCardView;", "delegateImpl", "Lcom/bytedance/ee/bear/bitable/share/sharepanel/BitableFormShareLinkSettingPanelFragment$Delegate;", "setDelegate", "", "delegate", "onStart", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "Companion", "Delegate", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableFormShareLinkSettingPanelFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int j = 0;
    public CCMLynxCardView h;
    public b i;

    public static final class a {
    }

    public interface b {
        void a();

        vv4.k b();
    }

    public static final class c extends p66.a {
        public final /* synthetic */ BitableFormShareLinkSettingPanelFragment b;

        public c(BitableFormShareLinkSettingPanelFragment r1) {
            this.b = r1;
        }

        public final void e(q66.a r2, p66.a.a r3, XBridgePlatformType r4) {
            Intrinsics.checkNotNullParameter(r2, "params");
            Intrinsics.checkNotNullParameter(r3, "callback");
            Intrinsics.checkNotNullParameter(r4, "type");
            tt5.a.b("BitableFormShareLinkSettingPanelFragment", "close shareLinkSetting");
            this.b.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L12;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements tb5.m {
        public final /* synthetic */ vv4.k a;
        public final /* synthetic */ BitableFormShareLinkSettingPanelFragment b;

        @Override // tb5.m
        public final void a(NonProguard r2) {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        @Override // tb5.m
        public final void b(JSONObject r3) {
            tt5.a.b("BitableFormShareLinkSettingPanelFragment", "notifyFormShareLinkSettingChanged " + r3);
            this.a.execJS("document.dispatchEvent(new CustomEvent('formSharePermissionChange'))");
            b r4 = this.b.i;
            if (r4 == null) goto L6;
            r4.a();
            return;
        }

        @Override // tb5.m
        public final void onCallBack(String r2) {
            throw new NotImplementedError("An operation is not implemented: Not yet implemented");
        }

        public d(vv4.k r1, BitableFormShareLinkSettingPanelFragment r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class e implements CCMLynxCardView.b {
        public final /* synthetic */ BitableFormShareLinkSettingPanelFragment a;

        public final void a(Map<String, String> r1) {
        }

        public final void onShow() {
        }

        public final void H() {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r0 = DialogFragmentLancet.sLastShowStack;
            if (r0 == null) goto L12;
            com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public e(BitableFormShareLinkSettingPanelFragment r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onDestroy() {
        super.onDestroy();
        CCMLynxCardView r0 = this.h;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.gravity = 80;
        r2.y = com.bytedance.ee.util.ui.k.e(r1.getContext());
        r2.windowAnimations = 2131951621;
        r1.setAttributes(r2);
        r1.setLayout(-1, -1);
        r1.setBackgroundDrawable(new ColorDrawable(0));
    L7:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(getDialog());
    }

    public BitableFormShareLinkSettingPanelFragment() {
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        CCMLynxCardView r3 = this.h;
        if (r3 == null) goto L6;
        r3.b();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        CCMLynxCardView r5 = (CCMLynxCardView) org.koin.java.a.c(CCMLynxCardView.class, null, new AnonymousClass1(this), 2);
        b r0 = this.i;
        if (r0 == null) goto L7;
        vv4.k r1 = r0.b();
        if (r1 == null) goto L7;
        i5 r2 = new i5(r1);
        r2.c("notifyFormShareLinkSettingChanged", new d(r1, this));
        r5.c(r2);
        r5.h("ccm.closePage", new c(this));
    L7:
        r5.f(new e(this));
        this.h = r5;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        View r10 = r7.inflate(2131558998, r8, false);
        Bundle r11 = getArguments();
        String r12 = null;
        if (r11 == null) goto L5;
        Serializable r13 = r11.getSerializable("template_data");
    L6:
        Bundle r0 = getArguments();
        if (r0 == null) goto L9;
        r12 = r0.getString("share_ctx_id");
    L9:
        String r5 = r12;
        CCMLynxCardView r1 = this.h;
        if (r1 == null) goto L12;
        ViewGroup r2 = (ViewGroup) r10.findViewById(2131373184);
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        r1.d(r2, 5, (Map) r13, new ViewGroup.LayoutParams(-1, -1), r5);
    L12:
        return r10;
    L5:
        r13 = null;
        goto L6
    }
}
