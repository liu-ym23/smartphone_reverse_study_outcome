package com.bytedance.ee.bear.doc.minutes;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002:\u0001\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/doc/minutes/OfficePlaySpeedPanelPlugin;", "Lcom/bytedance/ee/bear/document/base/DocumentPluginV3;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "handle", "target", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficePlaySpeedPanelPlugin extends DocumentPluginV3 implements i<String> {
    public static final a Companion = null;
    public static final String JSB_NAME = "biz.util.showPlaySpeedPanel";
    public static final String TAG = "OfficePlaySpeedPanelPlugin";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // tb5.i, tb5.o
    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfficePlaySpeedPanelPlugin() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "handlersHolder");
        super.getBridgeHandlers(r2);
        r2.put(JSB_NAME, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handle(String r4, final m r5) {
        if (r4 != null) goto L6;
        tt5.a.k(TAG, "handle: target is null");     // Catch: Throwable -> L25
        return;
    L6:
        PlaySpeedRequest r6 = (PlaySpeedRequest) JSON.parseObject(r4, PlaySpeedRequest.class);     // Catch: Throwable -> L25
        if (r6 == null) goto L9;
        List<PlaySpeedItem> r2 = r6.getData();     // Catch: Throwable -> L25
    L10:
        List<PlaySpeedItem> r3 = r2;     // Catch: Throwable -> L25
        if (r3 != null) goto L13;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == false) goto L20;
        tt5.a.k(TAG, "handle: data is empty or null");     // Catch: Throwable -> L25
        return;
    L20:
        int r8 = PlaySpeedBottomSheet.m;     // Catch: Throwable -> L25
        List<PlaySpeedItem> r9 = r6.getData();     // Catch: Throwable -> L25
        if (r9 != null) goto L23;
        r9 = CollectionsKt.emptyList();     // Catch: Throwable -> L25
    L23:
        Function1<PlaySpeedItem, Unit> r10 = new OfficePlaySpeedPanelPlugin$handle$bottomSheet$1(r5);     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r9, "data");     // Catch: Throwable -> L25
        Intrinsics.checkNotNullParameter(r10, "callback");     // Catch: Throwable -> L25
        PlaySpeedBottomSheet r11 = new PlaySpeedBottomSheet();     // Catch: Throwable -> L25
        r11.k = r9;     // Catch: Throwable -> L25
        r11.l = r10;     // Catch: Throwable -> L25
        INVOKEVIRTUAL_com_bytedance_ee_bear_doc_minutes_OfficePlaySpeedPanelPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r11, getHost().getFragment().getChildFragmentManager(), "PlaySpeedBottomSheet");     // Catch: Throwable -> L25
        return;
    L13:
        if (r3.isEmpty() == true) goto L16;
        r7 = false;
        goto L17
    L9:
        r2 = null;
    L25:
        th = move-exception;
        tt5.a.e(TAG, "handle: error parsing or showing play speed panel", th, false);
    }

    @Override // tb5.i, tb5.o
    public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        handle((String) r1, r2);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_doc_minutes_OfficePlaySpeedPanelPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(PlaySpeedBottomSheet r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        PlaySpeedBottomSheet r0 = r2;
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
