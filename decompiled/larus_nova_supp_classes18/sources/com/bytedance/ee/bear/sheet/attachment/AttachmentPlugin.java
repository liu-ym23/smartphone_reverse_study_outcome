package com.bytedance.ee.bear.sheet.attachment;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.observer.DiffObserver;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class AttachmentPlugin extends DocumentPlugin implements com.bytedance.ee.bear.document.orientation.p {
    private static final String BIZ_SHOW_ATTACHMENT_LIST = "biz.sheet.showAttachmentList";
    private static final String TAG = "AttachmentPlugin";
    private b showAttachmentHandler;
    private AttachmentViewModel viewModel;

    public class a extends DiffObserver<Boolean> {
        public final /* synthetic */ AttachmentPlugin b;

        public a(AttachmentPlugin r1) {
            this.b = r1;
        }

        public final void a(Object r3) {
            BaseUnspecifiedOrientationPlugin r0 = AttachmentPlugin.access$100(this.b, BaseUnspecifiedOrientationPlugin.class);
            Boolean r1 = Boolean.TRUE;
            if (r1.equals((Boolean) r3) == false) goto L7;
            tt5.a.h(AttachmentPlugin.TAG, "open attachment list");
            AttachmentPlugin.access$200(this.b, AttachmentFragment.class);
            if (r0 == null) goto L11;
            r0.onOrientationSupportPanelShowing(this.b);
            return;
        L11:
            return;
        L7:
            tt5.a.h(AttachmentPlugin.TAG, "close attachment list");
            AttachmentPlugin.access$300(this.b);
            if (r0 == null) goto L13;
            r0.onOrientationSupportPanelDismiss(this.b);
            return;
        }
    }

    public class b implements tb5.i<AttachmentModelList> {
        public tb5.m a;
        public final /* synthetic */ AttachmentPlugin b;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(AttachmentPlugin r1) {
            this.b = r1;
        }

        public final void handle(Object r2, tb5.m r3) {
            AttachmentModelList r4 = (AttachmentModelList) r2;
            this.a = r3;
            if (AttachmentPlugin.access$400(this.b) == null) goto L14;
            if (r4 != null) goto L7;
        L11:
            tt5.a.k(AttachmentPlugin.TAG, "AttachmentModelList is null");
            AttachmentPlugin.access$400(this.b).closeAttachmentPanel();
            return;
        L7:
            if (r4.getList() == null) goto L11;
            if (r4.getList().size() <= 0) goto L11;
            AttachmentPlugin.access$400(this.b).openAttachmentPanel();
            AttachmentPlugin.access$400(this.b).getAttachmentList().setValue(r4.getList());
            AttachmentPlugin.access$400(this.b).setCopyable(r4.isCopyable());
            return;
        }
    }

    public static /* synthetic */ void c(AttachmentPlugin r0, AttachmentModelList.AttachmentModel r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public boolean shouldDisableLandscape() {
        return false;
    }

    public AttachmentPlugin() {
    }

    public static /* synthetic */ void access$300(AttachmentPlugin r0) {
        r0.removeFragment();
    }

    public static /* synthetic */ AttachmentViewModel access$400(AttachmentPlugin r0) {
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

    public void onAttachToHost(DocumentPluginHost r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r4);
        AttachmentViewModel r0 = (AttachmentViewModel) viewModel(AttachmentViewModel.class);
        this.viewModel = r0;
        r0.setVCFollow(isVCFollow());
        this.viewModel.getActive().observe(getLifecycleOwner(), new a(this));
        this.viewModel.setDelegate(new i(this));
        r4.b().registerEditPanel(getLifecycleOwner(), this.viewModel);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$100(AttachmentPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static /* synthetic */ void access$200(AttachmentPlugin r0, Class r1) {
        r0.addOrReplaceFragment(r1);
    }
}
