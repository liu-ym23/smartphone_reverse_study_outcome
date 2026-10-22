package com.bytedance.ee.bear.sheet.exportimage.exportshare;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rw4.n;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\f\u001a\u00020\r2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0018\u00010\tR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/sheet/exportimage/exportshare/ExportSharePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "<init>", "()V", "TAG", "", "BIZ_SHEET_EXPORT_SHARE", "handler", "Lcom/bytedance/ee/bear/sheet/exportimage/exportshare/ExportSharePlugin$ExportShareHandler;", "viewModel", "Lcom/bytedance/ee/bear/sheet/exportimage/exportshare/ExportShareViewModel;", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "hideFragment", "showFragment", "getFragment", "Lcom/bytedance/ee/bear/sheet/exportimage/exportshare/ExportShareDialogFragment;", "shouldDisableLandscape", "", "ExportShareHandler", "docs-sheet_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExportSharePlugin extends DocumentPlugin implements p {
    private final String BIZ_SHEET_EXPORT_SHARE;
    private final String TAG;
    private a handler;
    private ExportShareViewModel viewModel;

    public final class a implements i<ExportShareModel> {
        public m a;
        public final /* synthetic */ ExportSharePlugin b;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public a(ExportSharePlugin r1) {
            this.b = r1;
        }

        public final void handle(Object r2, m r3) {
            ExportShareModel r4 = (ExportShareModel) r2;
            this.a = r3;
            ExportShareViewModel r5 = ExportSharePlugin.access$getViewModel$p(this.b);
            if (r5 == null) goto L8;
            if (r4 == null) goto L6;
            boolean r0 = true;
        L7:
            r5.setActiveValue(r0);
            goto L8
        L6:
            r0 = false;
        L8:
            ExportShareViewModel r6 = ExportSharePlugin.access$getViewModel$p(this.b);
            if (r6 == null) goto L15;
            if (r4 == null) goto L12;
            String[] r7 = r4.getTypes();
        L13:
            r6.setShareItems(r7);
            return;
        L12:
            r7 = null;
            goto L13
        }
    }

    public static final class b implements tm5.b {
        public final /* synthetic */ ExportSharePlugin a;

        public final void g() {
        }

        public final String getToken() {
            return "";
        }

        public b(ExportSharePlugin r1) {
            this.a = r1;
        }

        public final void b(String r2) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TYPE);
        }

        public final void d(String r2) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TYPE);
        }

        @Override // tm5.b
        public final void i(String r5) {
            a r0 = ExportSharePlugin.access$getHandler$p(this.a);
            if (r0 == null) goto L8;
            tt5.a.h(ExportSharePlugin.access$getTAG$p(r0.b), "onCallback(id: " + r5 + ')');
            JSONObject r1 = new JSONObject();
            r1.put(ResourceData.KEY_ID, r5);
            m r6 = r0.a;
            if (r6 == null) goto L9;
            r6.b(r1);
            return;
        L9:
            return;
        }

        public final void j(String r2) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TYPE);
        }

        public final void k(n r2, rw4.a r3) {
            Intrinsics.checkNotNullParameter(r2, "format");
            Intrinsics.checkNotNullParameter(r3, "callback");
        }

        public final void a(n r1, String r2, rw4.a r3) {
            k(r1, r3);
        }
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public boolean shouldDisableLandscape() {
        return true;
    }

    public ExportSharePlugin() {
        this.TAG = "ExportSharePlugin";
        this.BIZ_SHEET_EXPORT_SHARE = "biz.sheet.exportShare";
    }

    private final ExportShareDialogFragment getFragment() {
        return getActivity().getSupportFragmentManager().findFragmentByTag(this.TAG);
    }

    private final void hideFragment() {
        ExportShareDialogFragment r0 = getFragment();
        if (r0 == null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_exportimage_exportshare_ExportSharePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);
        return;
    }

    private final void showFragment() {
        if (getFragment() != null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_exportimage_exportshare_ExportSharePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(instantiateFragment(ExportShareDialogFragment.class), getActivity().getSupportFragmentManager(), this.TAG);
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_exportimage_exportshare_ExportSharePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(ExportShareDialogFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final /* synthetic */ a access$getHandler$p(ExportSharePlugin r0) {
        return r0.handler;
    }

    public static final /* synthetic */ String access$getTAG$p(ExportSharePlugin r0) {
        return r0.TAG;
    }

    public static final /* synthetic */ ExportShareViewModel access$getViewModel$p(ExportSharePlugin r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$hideFragment(ExportSharePlugin r0) {
        r0.hideFragment();
    }

    public static final /* synthetic */ void access$showFragment(ExportSharePlugin r0) {
        r0.showFragment();
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        a r0 = new a(this);
        this.handler = r0;
        String r1 = this.BIZ_SHEET_EXPORT_SHARE;
        Intrinsics.checkNotNull(r0);
        r3.put(r1, r0);
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        ExportShareViewModel r4 = viewModel(ExportShareViewModel.class);
        this.viewModel = r4;
        if (r4 == null) goto L5;
        r4.setExportShareDelegate(new b(this));
    L5:
        ExportShareViewModel r5 = this.viewModel;
        if (r5 == null) goto L11;
        LiveData<Boolean> r6 = r5.getActive();
        if (r6 == null) goto L12;
        r6.observe(getLifecycleOwner(), new AnonymousClass2(this));
        return;
    L12:
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ f access$findPlugin(ExportSharePlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_sheet_exportimage_exportshare_ExportSharePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(ExportShareDialogFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        ExportShareDialogFragment r0 = r2;
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
