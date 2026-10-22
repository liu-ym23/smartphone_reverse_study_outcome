package com.bytedance.ee.bear.document.synced.block;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.document.synced.block.references.entity.ReferencesParams;
import com.bytedance.ee.bear.document.synced.block.references.main.SyncedSourceReferencesMainFragment;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/SyncedSourceReferencesPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "<init>", "()V", "panelFragment", "Lcom/bytedance/ee/bear/document/synced/block/references/main/SyncedSourceReferencesMainFragment;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onDetachFromUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "dismissPickerIfNeed", "shouldDisableLandscape", "", "Companion", "ShowSyncedBlockReferencesHandler", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncedSourceReferencesPlugin extends DocumentPluginV2 implements p {
    public static final a Companion = null;
    public static final String JSB_MORE = "lark.biz.util.onSubMoreMenuClick";
    public static final String KEY_COUNT = "key_references_count";
    public static final String KEY_IS_SYNC_LINK = "key_is_sync_link";
    public static final String KEY_PARAM = "key_references_param";
    public static final String TAG = "SyncedSourceReferencesPlugin";
    private SyncedSourceReferencesMainFragment panelFragment;

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<ReferencesParams> {
        public final /* synthetic */ SyncedSourceReferencesPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(SyncedSourceReferencesPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r8, m r9) {
            ReferencesParams r10 = (ReferencesParams) r8;
            StringBuilder r0 = new StringBuilder("data=");
            BearUrl r1 = null;
            if (r10 == null) goto L5;
            String r2 = r10.toString();
        L6:
            r0.append(du5.b.k(r2));
            tt5.a.h("SyncedSourceReferencesPlugin", r0.toString());
            if (SyncedSourceReferencesPlugin.access$isUIContainerDetached(this.a) == true) goto L47;
            if (r10 != null) goto L11;
        L41:
            SyncedSourceReferencesPlugin.access$dismissPickerIfNeed(this.a);
            return;
        L11:
            if (r10.getDocxSyncedBlockHostToken() != null) goto L43;
            if (r10.getDocxSyncedBlockHostType() != null) goto L43;
            if (r10.getLimit() != null) goto L43;
            if (r10.getResourceToken() != null) goto L43;
            if (r10.getResourceType() != null) goto L43;
            if (r10.getTotalCount() == null) goto L41;
        L43:
            SyncedSourceReferencesPlugin.access$dismissPickerIfNeed(this.a);     // Catch: Throwable -> L39
            String r3 = SyncedSourceReferencesMainFragment.class.getName();     // Catch: Throwable -> L39
            Bundle r4 = new Bundle();     // Catch: Throwable -> L39
            r4.putParcelable("key_references_param", r10);     // Catch: Throwable -> L39
            PassportcConvention.h(r4, this.a.getHost().getUserComponent().b());     // Catch: Throwable -> L39
            DocViewModel r6 = SyncedSourceReferencesPlugin.access$getDocViewModel(this.a);     // Catch: Throwable -> L39
            if (r6 == null) goto L27;
            r1 = r6.getBearUrl();     // Catch: Throwable -> L39
        L27:
            r4.putParcelable("bear_url", r1);     // Catch: Throwable -> L39
            Integer r11 = r10.getTotalCount();     // Catch: Throwable -> L39
            if (r11 == null) goto L30;
            int r12 = r11.intValue();     // Catch: Throwable -> L39
        L31:
            r4.putInt("key_references_count", r12);     // Catch: Throwable -> L39
            DocViewModel r5 = SyncedSourceReferencesPlugin.access$getDocViewModel(this.a);     // Catch: Throwable -> L39
            if (r5 == null) goto L34;
            boolean r7 = r5.isSyncBlock();     // Catch: Throwable -> L39
        L35:
            r4.putBoolean("key_is_sync_link", r7);     // Catch: Throwable -> L39
            SyncedSourceReferencesPlugin r13 = this.a;     // Catch: Throwable -> L39
            SyncedSourceReferencesMainFragment r14 = Fragment.instantiate(SyncedSourceReferencesPlugin.access$getActivity(r13), r3, r4);     // Catch: Throwable -> L39
            Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type com.bytedance.ee.bear.document.synced.block.references.main.SyncedSourceReferencesMainFragment");     // Catch: Throwable -> L39
            SyncedSourceReferencesPlugin.access$setPanelFragment$p(r13, r14);     // Catch: Throwable -> L39
            SyncedSourceReferencesMainFragment r16 = SyncedSourceReferencesPlugin.access$getPanelFragment$p(this.a);     // Catch: Throwable -> L39
            if (r16 == null) goto L45;
            FragmentManager r17 = SyncedSourceReferencesPlugin.access$getFragmentManager(this.a);     // Catch: Throwable -> L39
            Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L39
            SyncedSourceReferencesPlugin r18 = this.a;     // Catch: Throwable -> L39
            com.bytedance.ee.bear.document.synced.block.a r19 = new com.bytedance.ee.bear.document.synced.block.a(r18, r9);     // Catch: Throwable -> L39
            PluginHost r20 = r18.getHost();     // Catch: Throwable -> L39
            Intrinsics.checkNotNull(r20, "null cannot be cast to non-null type com.bytedance.ee.bear.document.DocumentPluginHost");     // Catch: Throwable -> L39
            r16.da0(r17, r3, r19, (DocumentPluginHost) r20);     // Catch: Throwable -> L39
            return;
        L45:
            return;
        L34:
            r7 = false;
            goto L35
        L30:
            r12 = 0;
        L39:
            th = move-exception;
            tt5.a.f("SyncedSourceReferencesPlugin", th, false);
            return;
        L47:
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return true;
    }

    private final void dismissPickerIfNeed() {
        SyncedSourceReferencesMainFragment r0 = this.panelFragment;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_synced_block_SyncedSourceReferencesPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        tt5.a.f("SyncedSourceReferencesPlugin", th, false);
    }

    public SyncedSourceReferencesPlugin() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_synced_block_SyncedSourceReferencesPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(SyncedSourceReferencesMainFragment r1) {
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

    public static final /* synthetic */ void access$dismissPickerIfNeed(SyncedSourceReferencesPlugin r0) {
        r0.dismissPickerIfNeed();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(SyncedSourceReferencesPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ DocViewModel access$getDocViewModel(SyncedSourceReferencesPlugin r0) {
        return r0.getDocViewModel();
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManager(SyncedSourceReferencesPlugin r0) {
        return r0.getFragmentManager();
    }

    public static final /* synthetic */ SyncedSourceReferencesMainFragment access$getPanelFragment$p(SyncedSourceReferencesPlugin r0) {
        return r0.panelFragment;
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(SyncedSourceReferencesPlugin r0) {
        return r0.isUIContainerDetached();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.util.showSyncedBlockReferences", new b(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
    }

    public static final /* synthetic */ f access$findPlugin(SyncedSourceReferencesPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ void access$setPanelFragment$p(SyncedSourceReferencesPlugin r0, SyncedSourceReferencesMainFragment r1) {
        r0.panelFragment = r1;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(PluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        dismissPickerIfNeed();
    }
}
