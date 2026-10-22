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
import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.List;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public abstract class AbsInsertNewBlockPlugin<T extends PluginHost> extends BasePlugin<T> {
    private static final String TAG = "AbsInsertNewBlockPlugin";
    private InsertNewBlockFragment fragment;
    private AbsInsertNewBlockPlugin<T>.a jsHandler;
    private Observer<InsertNewBlock> observer;
    private InsertNewBlockViewModel viewModel;

    public class a implements tb5.i<InsertNewBlock> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f226287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbsInsertNewBlockPlugin f226288b;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(AbsInsertNewBlockPlugin r100) {
            this.f226288b = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            InsertNewBlock r102 = (InsertNewBlock) r100;
            tt5.a.h(AbsInsertNewBlockPlugin.TAG, "InsertNewBlockHandler " + r102);
            this.f226287a = r101;
            AbsInsertNewBlockPlugin.access$000(this.f226288b).updateInsertNewBlock(r102);
        }
    }

    public static /* synthetic */ void a(AbsInsertNewBlockPlugin r100, t r101, InsertNewBlock r102) {
        r100.lambda$onAttachToUIContainer$0(r101, r102);
    }

    public static /* synthetic */ void c(AbsInsertNewBlockPlugin r100, String r101, String r102) {
        r100.processOnItemClick(r101, r102);
    }

    public abstract void bindBridgeHandler(String r100, tb5.i<InsertNewBlock> r101);

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public AbsInsertNewBlockPlugin() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_edit_toolbar_toolbar2_insertblock_AbsInsertNewBlockPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(InsertNewBlockFragment r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static /* synthetic */ InsertNewBlockViewModel access$000(AbsInsertNewBlockPlugin r100) {
        return r100.viewModel;
    }

    private void showInsertNewBlockFragment(t r100) {
        Bundle r101 = new Bundle();
        r101.putBoolean("key_is_function_panel", true);
        InsertNewBlockFragment r102 = (InsertNewBlockFragment) instantiateFragment(InsertNewBlockFragment.class, r101);
        this.fragment = r102;
        if (ForsetiHelper.s(getHost().getHostFragment()) == true) goto L5;
    L6:
        INVOKEVIRTUAL_com_bytedance_ee_bear_edit_toolbar_toolbar2_insertblock_AbsInsertNewBlockPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r102, r100.getFragmentManager(), InsertNewBlockFragment.class.getName());
        return;
    L5:
        if (com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.c(r102, getHost().getHostFragment()) == false) goto L6;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(T r100) {
        super.onAttachToHost(r100);
        this.viewModel = (InsertNewBlockViewModel) q.c(r100, InsertNewBlockViewModel.class, null);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        this.viewModel.clearInsertNewBlockData();
    }

    private /* synthetic */ void lambda$onAttachToUIContainer$0(t r100, InsertNewBlock r101) {
        tt5.a.h(TAG, "getInsertNewBlockLiveData >" + r101);
        boolean r102 = true;
        boolean r103 = false;
        if (r101 != null) goto L5;
        boolean r104 = true;
    L7:
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L19;
        if (r104 == false) goto L14;
        InsertNewBlockFragment r105 = this.fragment;
        if (r105 != null) goto L12;
        return;
    L12:
        if (r105.isAdded() == false) goto L41;
        INVOKEVIRTUAL_com_bytedance_ee_bear_edit_toolbar_toolbar2_insertblock_AbsInsertNewBlockPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this.fragment);
        return;
    L41:
        return;
    L14:
        InsertNewBlockFragment r106 = this.fragment;
        if (r106 != null) goto L17;
    L18:
        showInsertNewBlockFragment(r100);
        return;
    L17:
        if (r106.isAdded() == false) goto L18;
        return;
    L19:
        List<Fragment> r107 = r100.getFragmentManager().getFragments();
        if (r107 == null) goto L45;
        Iterator<Fragment> r108 = r107.iterator();
    L23:
        if (r108.hasNext() == false) goto L29;
        Fragment r109 = r108.next();
        if ((r109 instanceof InsertNewBlockFragment) == false) goto L23;
        if (r104 == true) goto L27;
        r103 = true;
        goto L23
    L27:
        INVOKEVIRTUAL_com_bytedance_ee_bear_edit_toolbar_toolbar2_insertblock_AbsInsertNewBlockPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss((InsertNewBlockFragment) r109);
    L30:
        if (r102 == true) goto L46;
        if (r101 == null) goto L47;
        showInsertNewBlockFragment(r100);
        return;
    L47:
        return;
    L46:
        return;
    L29:
        r102 = r103;
        goto L30
    L45:
        return;
    L5:
        r104 = false;
        goto L7
    }

    private void processOnItemClick(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        AbsInsertNewBlockPlugin<T>.a r102 = this.jsHandler;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.f226287a == null) goto L10;
        JSONObject r103 = new JSONObject();
        r103.put2("id", r100);
        r103.put2("value", r101);
        r102.f226287a.b(r103);
        return;
    L10:
        tt5.a.d(TAG, "insertImages(): failed cause selectImgCallback is null ");
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToUIContainer(T r100, final t r101) {
        super.onAttachToUIContainer(r100, r101);
        AbsInsertNewBlockPlugin<T>.a r102 = new a(this);
        this.jsHandler = r102;
        bindBridgeHandler(JsBridgeConstants.BIZ_SET_INSERT_NEW_BLOCK_PANEL, r102);
        this.viewModel.setDelegate(new com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock.a(this));
        if (this.observer != null) goto L6;
        LiveData<InsertNewBlock> r103 = this.viewModel.getInsertNewBlockLiveData();
        LifecycleOwner r104 = r100.getLifecycleOwner();
        Observer<InsertNewBlock> r105 = new b(this, r101);
        this.observer = r105;
        r103.observe(r104, r105);
        return;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromUIContainer(T r100, t r101) {
        super.onDetachFromUIContainer(r100, r101);
        this.viewModel.setDelegate(null);
        this.viewModel.clearInsertNewBlockData();
        if (this.observer == null) goto L6;
        this.viewModel.getInsertNewBlockLiveData().removeObserver(this.observer);
        this.observer = null;
        return;
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_edit_toolbar_toolbar2_insertblock_AbsInsertNewBlockPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(InsertNewBlockFragment r100, FragmentManager r101, String r102) {
        if ((r100 instanceof Fragment) == false) goto L5;
        InsertNewBlockFragment r103 = r100;
    L6:
        LandscapeRestrictionOperation r104 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r103, r102, r104);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r103, r104) == false) goto L13;
        return;
    L13:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r100.show(r101, r102);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
