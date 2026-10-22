package com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.BasePlugin;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.model.toolbar.insertblock.InsertNewBlock;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.List;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class AbsInsertNewBlockPlugin<T extends PluginHost> extends BasePlugin<T> {
    private static final String TAG = "AbsInsertNewBlockPlugin";
    private InsertNewBlockFragment fragment;
    private AbsInsertNewBlockPlugin<T>.a jsHandler;
    private Observer<InsertNewBlock> observer;
    private InsertNewBlockViewModel viewModel;

    public class a implements tb5.i<InsertNewBlock> {
        public m a;
        public final /* synthetic */ AbsInsertNewBlockPlugin b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(AbsInsertNewBlockPlugin r1) {
            this.b = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, m r4) {
            InsertNewBlock r5 = (InsertNewBlock) r3;
            tt5.a.h(AbsInsertNewBlockPlugin.TAG, "InsertNewBlockHandler " + r5);
            this.a = r4;
            AbsInsertNewBlockPlugin.access$000(this.b).updateInsertNewBlock(r5);
        }
    }

    public static /* synthetic */ void a(AbsInsertNewBlockPlugin r0, t r1, InsertNewBlock r2) {
        r0.lambda$onAttachToUIContainer$0(r1, r2);
    }

    public static /* synthetic */ void c(AbsInsertNewBlockPlugin r0, String r1, String r2) {
        r0.processOnItemClick(r1, r2);
    }

    public abstract void bindBridgeHandler(String r1, tb5.i<InsertNewBlock> r2);

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public AbsInsertNewBlockPlugin() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_edit_toolbar_toolbar2_insertblock_AbsInsertNewBlockPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(InsertNewBlockFragment r1) {
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

    public static /* synthetic */ InsertNewBlockViewModel access$000(AbsInsertNewBlockPlugin r0) {
        return r0.viewModel;
    }

    private void showInsertNewBlockFragment(t r4) {
        Bundle r0 = new Bundle();
        r0.putBoolean("key_is_function_panel", true);
        InsertNewBlockFragment r1 = instantiateFragment(InsertNewBlockFragment.class, r0);
        this.fragment = r1;
        if (ForsetiHelper.s(getHost().getHostFragment()) == true) goto L5;
    L6:
        INVOKEVIRTUAL_com_bytedance_ee_bear_edit_toolbar_toolbar2_insertblock_AbsInsertNewBlockPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r1, r4.getFragmentManager(), InsertNewBlockFragment.class.getName());
        return;
    L5:
        if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.c(r1, getHost().getHostFragment()) == false) goto L6;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(T r3) {
        super.onAttachToHost(r3);
        this.viewModel = (InsertNewBlockViewModel) q.c(r3, InsertNewBlockViewModel.class, null);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        this.viewModel.clearInsertNewBlockData();
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$0(t r7, InsertNewBlock r8) {
        tt5.a.h(TAG, "getInsertNewBlockLiveData >" + r8);
        boolean r0 = true;
        boolean r1 = false;
        if (r8 != null) goto L5;
        boolean r2 = true;
    L7:
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L19;
        if (r2 == false) goto L14;
        InsertNewBlockFragment r9 = this.fragment;
        if (r9 != null) goto L12;
        return;
    L12:
        if (r9.isAdded() == false) goto L41;
        INVOKEVIRTUAL_com_bytedance_ee_bear_edit_toolbar_toolbar2_insertblock_AbsInsertNewBlockPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this.fragment);
        return;
    L41:
        return;
    L14:
        InsertNewBlockFragment r10 = this.fragment;
        if (r10 != null) goto L17;
    L18:
        showInsertNewBlockFragment(r7);
        return;
    L17:
        if (r10.isAdded() == false) goto L18;
        return;
    L19:
        List r3 = r7.getFragmentManager().getFragments();
        if (r3 == null) goto L45;
        Iterator r4 = r3.iterator();
    L23:
        if (r4.hasNext() == false) goto L29;
        InsertNewBlockFragment r5 = (Fragment) r4.next();
        if ((r5 instanceof InsertNewBlockFragment) == false) goto L23;
        if (r2 == true) goto L27;
        r1 = true;
        goto L23
    L27:
        INVOKEVIRTUAL_com_bytedance_ee_bear_edit_toolbar_toolbar2_insertblock_AbsInsertNewBlockPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r5);
    L30:
        if (r0 == true) goto L46;
        if (r8 == null) goto L47;
        showInsertNewBlockFragment(r7);
        return;
    L47:
        return;
    L46:
        return;
    L29:
        r0 = r1;
        goto L30
    L45:
        return;
    L5:
        r2 = false;
        goto L7
    }

    private void processOnItemClick(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        AbsInsertNewBlockPlugin<T>.a r0 = this.jsHandler;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.a == null) goto L10;
        JSONObject r1 = new JSONObject();
        r1.put("id", r4);
        r1.put("value", r5);
        r0.a.b(r1);
        return;
    L10:
        tt5.a.d(TAG, "insertImages(): failed cause selectImgCallback is null ");
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(T r3, final t r4) {
        super.onAttachToUIContainer(r3, r4);
        AbsInsertNewBlockPlugin<T>.a r0 = new a(this);
        this.jsHandler = r0;
        bindBridgeHandler("biz.navigation.setInsertNewBlockPanel", r0);
        this.viewModel.setDelegate(new com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.a(this));
        if (this.observer != null) goto L6;
        LiveData<InsertNewBlock> r1 = this.viewModel.getInsertNewBlockLiveData();
        LifecycleOwner r5 = r3.getLifecycleOwner();
        Observer<InsertNewBlock> r2 = new b(this, r4);
        this.observer = r2;
        r1.observe(r5, r2);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(T r2, t r3) {
        super.onDetachFromUIContainer(r2, r3);
        this.viewModel.setDelegate(null);
        this.viewModel.clearInsertNewBlockData();
        if (this.observer == null) goto L6;
        this.viewModel.getInsertNewBlockLiveData().removeObserver(this.observer);
        this.observer = null;
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_edit_toolbar_toolbar2_insertblock_AbsInsertNewBlockPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(InsertNewBlockFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        InsertNewBlockFragment r0 = r2;
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
