package com.bytedance.ee.bear.minutes;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.bizwidget.dialogfragment.BaseUDBottomSheetDialogFragment;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelItemData;
import com.bytedance.ee.bear.content.common.morepanel.CommonPanelAdapter;
import com.bytedance.ee.bear.doc.minutes.PlaySpeedItem;
import com.bytedance.ee.bear.doc.minutes.PlaySpeedRequest;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.tts.impl.view.TtsOptionsView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.n;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.LarkContext;
import hw4.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002:\u0001\u000eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\tH\u0016J\u001c\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/minutes/PlaySpeedPanelPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "handle", "target", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "Companion", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PlaySpeedPanelPlugin extends DocumentPlugin implements i<String> {
    public static final a Companion = null;
    public static final String JSB_NAME = "biz.util.showPlaySpeedPanel";
    public static final String TAG = "PlaySpeedPanelPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements d {
        public final /* synthetic */ List<PlaySpeedItem> a;
        public final /* synthetic */ m b;
        public final /* synthetic */ TtsOptionsView c;

        public final void a(int r3, CommonMorePanelItemData r4) {
            Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
            PlaySpeedItem r5 = (PlaySpeedItem) CollectionsKt.getOrNull(this.a, r3);
            if (r5 != null) goto L5;
            return;
        L5:
            tt5.a.h(PlaySpeedPanelPlugin.TAG, "handle: user selected speed id=" + r5.getId() + ", position=" + r3);
            m r6 = this.b;
            if (r6 == null) goto L8;
            r6.onCallBack(JSON.toJSONString(MapsKt.mapOf(TuplesKt.to(ResourceData.KEY_ID, Integer.valueOf(r5.getId())))));
        L8:
            tt5.a.h(PlaySpeedPanelPlugin.TAG, "handle: callback sent to frontend");
            this.c.dismissAllowingStateLoss();     // Catch: Exception -> L11
            return;
        L11:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r7 = DialogFragmentLancet.sLastShowStack;
            if (r7 == null) goto L18;
            com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public b(List<PlaySpeedItem> r1, m r2, TtsOptionsView r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
        Companion = new a();
    }

    @Nullable
    public /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return null;
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public PlaySpeedPanelPlugin() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "handlersHolder");
        super.getBridgeHandlers(r2);
        r2.put(JSB_NAME, this);
    }

    public void handle(String r10, m r11) {
        if (r10 != null) goto L6;
        tt5.a.k(TAG, "handle: target is null");     // Catch: Throwable -> L31
        return;
    L6:
        tt5.a.h(TAG, "handle: receive play speed panel request");     // Catch: Throwable -> L31
        PlaySpeedRequest r12 = (PlaySpeedRequest) JSON.parseObject(r10, PlaySpeedRequest.class);     // Catch: Throwable -> L31
        if (r12 == null) goto L9;
        List r13 = r12.getData();     // Catch: Throwable -> L31
    L10:
        List r3 = r13;     // Catch: Throwable -> L31
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L20;
        tt5.a.k(TAG, "handle: data is empty or null");     // Catch: Throwable -> L31
        return;
    L20:
        tt5.a.h(TAG, "handle: parsed " + r13.size() + " speed items");     // Catch: Throwable -> L31
        FragmentActivity r0 = getHost().getActivity();     // Catch: Throwable -> L31
        if (r0 != null) goto L24;
        tt5.a.k(TAG, "handle: host activity is null or invalid");     // Catch: Throwable -> L31
        return;
    L24:
        ArrayList r5 = new ArrayList(r13.size());     // Catch: Throwable -> L31
        Iterator r6 = r13.iterator();     // Catch: Throwable -> L31
    L26:
        if (r6.hasNext() == false) goto L33;
        PlaySpeedItem r7 = (PlaySpeedItem) r6.next();     // Catch: Throwable -> L31
        CommonMorePanelItemData r8 = new CommonMorePanelItemData();     // Catch: Throwable -> L31
        String r9 = String.valueOf(r7.getId());     // Catch: Throwable -> L31
        Intrinsics.checkNotNullParameter(r9, "<set-?>");     // Catch: Throwable -> L31
        r8.a = r9;     // Catch: Throwable -> L31
        r8.a(r7.getValue());     // Catch: Throwable -> L31
        if (r7.isSelect() == false) goto L30;
        r8.d = 2131255020;     // Catch: Throwable -> L31
        r8.g = n.c(16.0f);     // Catch: Throwable -> L31
        r8.h = 2131105543;     // Catch: Throwable -> L31
    L30:
        r5.add(r8);     // Catch: Throwable -> L31
        goto L26
    L33:
        TtsOptionsView r14 = new TtsOptionsView();     // Catch: Throwable -> L31
        ((BaseUDBottomSheetDialogFragment) r14).r = LarkContext.getApplication().getString(2131889244);     // Catch: Throwable -> L31
        r14.oa0();     // Catch: Throwable -> L31
        CommonPanelAdapter r15 = (CommonPanelAdapter) r14.t.getValue();     // Catch: Throwable -> L31
        r15.a = r5;     // Catch: Throwable -> L31
        r15.notifyDataSetChanged();     // Catch: Throwable -> L31
        r14.ra0(new b(r13, r11, r14));     // Catch: Throwable -> L31
        tt5.a.h(TAG, "handle: showing play speed panel");     // Catch: Throwable -> L31
        INVOKEVIRTUAL_com_bytedance_ee_bear_minutes_PlaySpeedPanelPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r14, r0.getSupportFragmentManager(), TtsOptionsView.class.getName() + "-PlaySpeed");     // Catch: Throwable -> L31
        return;
    L13:
        if (r3.isEmpty() == true) goto L16;
        r4 = false;
        goto L17
    L9:
        r13 = null;
    L31:
        th = move-exception;
        tt5.a.e(TAG, "handle: error parsing or showing play speed panel", th, false);
    }

    public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        handle((String) r1, r2);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_minutes_PlaySpeedPanelPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(TtsOptionsView r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        TtsOptionsView r0 = r2;
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
