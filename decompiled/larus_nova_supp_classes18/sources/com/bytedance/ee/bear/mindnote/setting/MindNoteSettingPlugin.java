package com.bytedance.ee.bear.mindnote.setting;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MindNoteSettingPlugin extends DocumentPlugin {
    private static final String TAG = "MindNoteSettingPlugin";
    private b mShowThemeCard;
    private ml5.b mSp;
    private MindNoteSettingViewModel mViewModel;

    public class a implements i<ViewData> {
        public final /* synthetic */ MindNoteSettingPlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public a(MindNoteSettingPlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r2, m r3) {
            ViewData r4 = (ViewData) r2;
            if (r4 == null) goto L7;
            tt5.a.b(MindNoteSettingPlugin.TAG, "SetViewHandler..." + r4.toString());
            MindNoteSettingPlugin.access$100(this.a).b("mindnote_view_type", r4.getViewType());
            return;
        }
    }

    public class b implements i<MindNoteSettingData> {
        public m a;
        public final /* synthetic */ MindNoteSettingPlugin b;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(MindNoteSettingPlugin r1) {
            this.b = r1;
        }

        public final void handle(Object r3, m r4) {
            MindNoteSettingData r5 = (MindNoteSettingData) r3;
            if (r5 == null) goto L7;
            tt5.a.b(MindNoteSettingPlugin.TAG, "ShowThemeCard..." + r5.toString());
            this.a = r4;
            MindNoteSettingPlugin.access$000(this.b).setData(r5);
            return;
        }
    }

    public static /* synthetic */ void c(MindNoteSettingPlugin r0, String r1, String r2) {
        r0.lambda$onAttachToHost$0(r1, r2);
    }

    public static /* synthetic */ void d(MindNoteSettingPlugin r0, MindNoteSettingData r1) {
        r0.lambda$onAttachToHost$1(r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private void ensureSettingFragment() {
        tt5.a.b(TAG, "ensureSettingFragment");
        MindNoteSettingFragment r0 = instantiateFragment(MindNoteSettingFragment.class);
        if (getFragmentManager().findFragmentByTag("MindNoteSettingFragment") != null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_mindnote_setting_MindNoteSettingPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(getFragmentManager().beginTransaction(), r0, "MindNoteSettingFragment").commitAllowingStateLoss();
        return;
    }

    public MindNoteSettingPlugin() {
    }

    public static /* synthetic */ MindNoteSettingViewModel access$000(MindNoteSettingPlugin r0) {
        return r0.mViewModel;
    }

    public static /* synthetic */ ml5.b access$100(MindNoteSettingPlugin r0) {
        return r0.mSp;
    }

    private /* synthetic */ void lambda$onAttachToHost$1(MindNoteSettingData r1) {
        if (r1 == null) goto L5;
        ensureSettingFragment();
        return;
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        this.mShowThemeCard = new b(this);
        this.mViewModel = (MindNoteSettingViewModel) viewModel(MindNoteSettingViewModel.class);
        this.mSp = new ml5.b(DocumentType.MINDNOTE_NAME);
        this.mViewModel.setDelegate(new c(this));
        this.mViewModel.getData().observe(getLifecycleOwner(), new d(this));
        bindBridgeHandler("biz.mindnote.showThemeCard", this.mShowThemeCard);
        bindBridgeHandler("biz.mindnote.setView", new a(this));
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    private void lambda$onAttachToHost$0(String r4, String r5) {
        b r0 = this.mShowThemeCard;
        r0.getClass();
        JSONObject r1 = new JSONObject();
        r1.put("key", r4);
        r1.put(ResourceData.KEY_TYPE, r5);
        tt5.a.b(TAG, "onSelected..." + r1.toString());
        r0.a.b(r1);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_mindnote_setting_MindNoteSettingPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == false) goto L6;
        return r2;
    L6:
        return r2.add(r3, r4);
    }
}
