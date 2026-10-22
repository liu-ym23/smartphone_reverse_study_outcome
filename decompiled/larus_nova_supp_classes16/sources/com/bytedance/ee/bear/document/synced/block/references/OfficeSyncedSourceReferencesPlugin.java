package com.bytedance.ee.bear.document.synced.block.references;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.f;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.document.orientation.p;
import com.bytedance.ee.bear.document.synced.block.references.entity.ReferencesParams;
import com.bytedance.ee.bear.document.synced.block.references.main.SyncedSourceReferencesMainFragment;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0002\u0016\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\nH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/document/synced/block/references/OfficeSyncedSourceReferencesPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "Lcom/bytedance/ee/bear/document/orientation/OrientationSupportPanel;", "<init>", "()V", "panelFragment", "Lcom/bytedance/ee/bear/document/synced/block/references/main/SyncedSourceReferencesMainFragment;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onDetachFromUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "dismissPickerIfNeed", "shouldDisableLandscape", "", "Companion", "ShowSyncedBlockReferencesHandler", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeSyncedSourceReferencesPlugin extends DocumentPluginV3 implements p {
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
        public final /* synthetic */ OfficeSyncedSourceReferencesPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeSyncedSourceReferencesPlugin r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r5v3, types: [com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.document.synced.block.references.OfficeSyncedSourceReferencesPlugin] */
        @Override // tb5.i, tb5.o
        public final void handle(Object r7, m r8) {
            ReferencesParams r9 = (ReferencesParams) r7;
            StringBuilder r0 = new StringBuilder("data=");
            if (r9 == null) goto L5;
            String r1 = r9.toString();
        L6:
            r0.append(du5.b.k(r1));
            tt5.a.h("SyncedSourceReferencesPlugin", r0.toString());
            if (OfficeSyncedSourceReferencesPlugin.access$isUIContainerDetached(this.a) == true) goto L40;
            if (r9 != null) goto L11;
        L34:
            OfficeSyncedSourceReferencesPlugin.access$dismissPickerIfNeed(this.a);
            return;
        L11:
            if (r9.getDocxSyncedBlockHostToken() != null) goto L36;
            if (r9.getDocxSyncedBlockHostType() != null) goto L36;
            if (r9.getLimit() != null) goto L36;
            if (r9.getResourceToken() != null) goto L36;
            if (r9.getResourceType() != null) goto L36;
            if (r9.getTotalCount() == null) goto L34;
        L36:
            OfficeSyncedSourceReferencesPlugin.access$dismissPickerIfNeed(this.a);     // Catch: Throwable -> L32
            String r2 = SyncedSourceReferencesMainFragment.class.getName();     // Catch: Throwable -> L32
            Bundle r3 = new Bundle();     // Catch: Throwable -> L32
            r3.putParcelable("key_references_param", r9);     // Catch: Throwable -> L32
            PassportcConvention.h(r3, this.a.getHost().getUserComponent().b());     // Catch: Throwable -> L32
            r3.putParcelable("bear_url", this.a.getDocumentMetadata().getBearUrl());     // Catch: Throwable -> L32
            Integer r10 = r9.getTotalCount();     // Catch: Throwable -> L32
            if (r10 == null) goto L27;
            int r11 = r10.intValue();     // Catch: Throwable -> L32
        L28:
            r3.putInt("key_references_count", r11);     // Catch: Throwable -> L32
            r3.putBoolean("key_is_sync_link", this.a.getDocumentMetadata().isSyncBlock());     // Catch: Throwable -> L32
            OfficeSyncedSourceReferencesPlugin r12 = this.a;     // Catch: Throwable -> L32
            SyncedSourceReferencesMainFragment r4 = Fragment.instantiate(OfficeSyncedSourceReferencesPlugin.access$getActivity(r12), r2, r3);     // Catch: Throwable -> L32
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.bytedance.ee.bear.document.synced.block.references.main.SyncedSourceReferencesMainFragment");     // Catch: Throwable -> L32
            OfficeSyncedSourceReferencesPlugin.access$setPanelFragment$p(r12, r4);     // Catch: Throwable -> L32
            SyncedSourceReferencesMainFragment r13 = OfficeSyncedSourceReferencesPlugin.access$getPanelFragment$p(this.a);     // Catch: Throwable -> L32
            if (r13 == null) goto L38;
            FragmentManager r5 = OfficeSyncedSourceReferencesPlugin.access$getFragmentManager(this.a);     // Catch: Throwable -> L32
            Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L32
            ?? r6 = this.a;     // Catch: Throwable -> L32
            r13.da0(r5, r2, new com.bytedance.ee.bear.document.synced.block.references.a(r6, r8), (WebPluginHost) r6.getHost());     // Catch: Throwable -> L32
            return;
        L38:
            return;
        L27:
            r11 = 0;
        L32:
            th = move-exception;
            tt5.a.f("SyncedSourceReferencesPlugin", th, false);
            return;
        L40:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    @Override // com.bytedance.ee.bear.document.orientation.p
    public boolean shouldDisableLandscape() {
        return true;
    }

    private final void dismissPickerIfNeed() {
        SyncedSourceReferencesMainFragment r0 = this.panelFragment;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_synced_block_references_OfficeSyncedSourceReferencesPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        tt5.a.f("SyncedSourceReferencesPlugin", th, false);
    }

    public OfficeSyncedSourceReferencesPlugin() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_synced_block_references_OfficeSyncedSourceReferencesPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(SyncedSourceReferencesMainFragment r1) {
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

    public static final /* synthetic */ void access$dismissPickerIfNeed(OfficeSyncedSourceReferencesPlugin r0) {
        r0.dismissPickerIfNeed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentActivity access$getActivity(OfficeSyncedSourceReferencesPlugin r0) {
        return r0.getActivity();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentManager access$getFragmentManager(OfficeSyncedSourceReferencesPlugin r0) {
        return r0.getFragmentManager();
    }

    public static final /* synthetic */ SyncedSourceReferencesMainFragment access$getPanelFragment$p(OfficeSyncedSourceReferencesPlugin r0) {
        return r0.panelFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ boolean access$isUIContainerDetached(OfficeSyncedSourceReferencesPlugin r0) {
        return r0.isUIContainerDetached();
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.util.showSyncedBlockReferences", new b(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ f access$findPlugin(OfficeSyncedSourceReferencesPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    public static final /* synthetic */ void access$setPanelFragment$p(OfficeSyncedSourceReferencesPlugin r0, SyncedSourceReferencesMainFragment r1) {
        r0.panelFragment = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
        dismissPickerIfNeed();
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
