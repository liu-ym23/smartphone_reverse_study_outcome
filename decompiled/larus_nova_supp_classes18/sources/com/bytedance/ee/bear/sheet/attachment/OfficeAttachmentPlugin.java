package com.bytedance.ee.bear.sheet.attachment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.observer.DiffObserver;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeAttachmentPlugin extends DocumentPluginV3 implements com.bytedance.ee.bear.document.orientation.p {
    private static final String BIZ_SHOW_ATTACHMENT_LIST = "biz.sheet.showAttachmentList";
    private static final String TAG = "OfficeAttachmentPlugin";
    private b showAttachmentHandler;
    private AttachmentViewModel viewModel;

    public class a extends DiffObserver<Boolean> {
        public final /* synthetic */ OfficeAttachmentPlugin b;

        public a(OfficeAttachmentPlugin r1) {
            this.b = r1;
        }

        public final void a(Object r3) {
            BaseUnspecifiedOrientationPlugin r0 = OfficeAttachmentPlugin.access$100(this.b, BaseUnspecifiedOrientationPlugin.class);
            Boolean r1 = Boolean.TRUE;
            if (r1.equals((Boolean) r3) == false) goto L7;
            tt5.a.h(OfficeAttachmentPlugin.TAG, "open attachment list");
            OfficeAttachmentPlugin.access$200(this.b);
            if (r0 == null) goto L11;
            r0.onOrientationSupportPanelShowing(this.b);
            return;
        L11:
            return;
        L7:
            tt5.a.h(OfficeAttachmentPlugin.TAG, "close attachment list");
            OfficeAttachmentPlugin.access$300(this.b);
            if (r0 == null) goto L13;
            r0.onOrientationSupportPanelDismiss(this.b);
            return;
        }
    }

    public class b implements tb5.i<AttachmentModelList> {
        public tb5.m a;
        public final /* synthetic */ OfficeAttachmentPlugin b;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(OfficeAttachmentPlugin r1) {
            this.b = r1;
        }

        public final void handle(Object r2, tb5.m r3) {
            AttachmentModelList r4 = (AttachmentModelList) r2;
            this.a = r3;
            if (OfficeAttachmentPlugin.access$400(this.b) == null) goto L14;
            if (r4 != null) goto L7;
        L11:
            tt5.a.k(OfficeAttachmentPlugin.TAG, "AttachmentModelList is null");
            OfficeAttachmentPlugin.access$400(this.b).closeAttachmentPanel();
            return;
        L7:
            if (r4.getList() == null) goto L11;
            if (r4.getList().size() <= 0) goto L11;
            OfficeAttachmentPlugin.access$400(this.b).openAttachmentPanel();
            OfficeAttachmentPlugin.access$400(this.b).getAttachmentList().setValue(r4.getList());
            OfficeAttachmentPlugin.access$400(this.b).setCopyable(r4.isCopyable());
            return;
        }
    }

    public static /* synthetic */ void a(OfficeAttachmentPlugin r0, AttachmentModelList.AttachmentModel r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public boolean shouldDisableLandscape() {
        return false;
    }

    private OfficeAttachmentFragment getAttachmentFragment() {
        OfficeAttachmentFragment r0 = getFragmentManager().findFragmentByTag("OfficeAttachmentFragment");
        if ((r0 instanceof OfficeAttachmentFragment) == true) goto L5;
        return null;
    L5:
        return r0;
    }

    private void hideAttachmentList() {
        OfficeAttachmentFragment r0 = getAttachmentFragment();
        if (r0 == null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_attachment_OfficeAttachmentPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);
        return;
    }

    private void showAttachmentList() {
        if (getAttachmentFragment() != null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_attachment_OfficeAttachmentPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(instantiateFragment(OfficeAttachmentFragment.class), getFragmentManager(), "OfficeAttachmentFragment");
        return;
    }

    public OfficeAttachmentPlugin() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_attachment_OfficeAttachmentPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(OfficeAttachmentFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static /* synthetic */ void access$200(OfficeAttachmentPlugin r0) {
        r0.showAttachmentList();
    }

    public static /* synthetic */ void access$300(OfficeAttachmentPlugin r0) {
        r0.hideAttachmentList();
    }

    public static /* synthetic */ AttachmentViewModel access$400(OfficeAttachmentPlugin r0) {
        return r0.viewModel;
    }

    private void lambda$onAttachToHost$0(AttachmentModelList.AttachmentModel r4) {
        b r0 = this.showAttachmentHandler;
        r0.getClass();
        tt5.a.h(TAG, "onSelectAttachment");
        tb5.m r1 = r0.a;
        if (r1 == null) goto L6;
        r1.a(r4);
        return;
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        b r0 = new b(this);
        this.showAttachmentHandler = r0;
        r3.put(BIZ_SHOW_ATTACHMENT_LIST, r0);
    }

    public void onAttachToHost(ChameleonPluginHost r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r4);
        AttachmentViewModel r0 = (AttachmentViewModel) viewModel(AttachmentViewModel.class);
        this.viewModel = r0;
        r0.setVCFollow(isVCFollow());
        this.viewModel.getActive().observe(getLifecycleOwner(), new a(this));
        this.viewModel.setDelegate(new r(this));
        h35.a.a(r4).registerEditPanel(r4.getLifecycleOwner(), this.viewModel);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$100(OfficeAttachmentPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_attachment_OfficeAttachmentPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(OfficeAttachmentFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        OfficeAttachmentFragment r0 = r2;
    L6:
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r0, r4, r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r0, r1) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, r4);
        return;
    L5:
        r0 = null;
        goto L6
    }
}
