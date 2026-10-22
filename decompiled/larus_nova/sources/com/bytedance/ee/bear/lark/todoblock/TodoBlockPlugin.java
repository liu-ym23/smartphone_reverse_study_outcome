package com.bytedance.ee.bear.lark.todoblock;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public class TodoBlockPlugin extends DocumentPluginV2 {
    private static final String SHOW_CREATE_TASK = "biz.util.showCreateTask";
    private static final String SHOW_SEARCH_ASSIGNEE = "biz.util.searchAssignee";
    private static final String SHOW_TASK_ASSIGNEE = "biz.util.showTaskAssignee";
    private static final String TAG = "TodoBlockPlugin";
    private static final String TAG_FRAGMENT = "TodoBlockPlugin#Fragment";
    private m mSearchCallBack;
    private m mTaskCallBack;
    private TodoBlockViewModel mTodoViewModel;

    public class a implements TodoBlockViewModel.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoBlockPlugin f227584a;

        public a(TodoBlockPlugin r100) {
            this.f227584a = r100;
        }
    }

    public class b implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoBlockPlugin f227585a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(TodoBlockPlugin r100) {
            this.f227585a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            TodoBlockPlugin.access$502(this.f227585a, r101);
            TodoBlockPlugin r102 = this.f227585a;
            TodoBlockPlugin.access$600(r102, (String) r100, 3);
        }
    }

    public class c implements i<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoBlockPlugin f227586a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(TodoBlockPlugin r100) {
            this.f227586a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            Void r102 = (Void) r100;
            if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L5;
            UDToast.show(this.f227586a.getHost().getContext(), R.string.LarkCCM_Docs_Doubao_OperateInFeishu_Toast);
            return;
        L5:
            TodoBlockPlugin.access$302(this.f227586a, r101);
            TodoBlockPlugin.access$600(this.f227586a, null, 1);
        }
    }

    public class d implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TodoBlockPlugin f227587a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(TodoBlockPlugin r100) {
            this.f227587a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            TodoBlockPlugin.access$502(this.f227587a, r101);
            TodoBlockPlugin r102 = this.f227587a;
            TodoBlockPlugin.access$600(r102, (String) r100, 2);
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private TodoBlockFragment findStartPreviewFragment() {
        Fragment r100 = getHost().getHostFragment();
        if (r100 != null) goto L7;
        return null;
    L7:
        return (TodoBlockFragment) r100.getChildFragmentManager().findFragmentByTag(TAG_FRAGMENT);
    }

    private void removeTodoFragment() {
        TodoBlockFragment r100 = findStartPreviewFragment();     // Catch: Exception -> L9
        if (r100 == null) goto L14;
        Fragment r101 = getHost().getHostFragment();     // Catch: Exception -> L9
        if (r101 != null) goto L7;
        return;
    L7:
        r101.getChildFragmentManager().beginTransaction().remove(r100).commitAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        tt5.a.d(TAG, "removeTodoFragment error:" + e);
    }

    public TodoBlockPlugin() {
    }

    public static /* synthetic */ m access$300(TodoBlockPlugin r100) {
        return r100.mSearchCallBack;
    }

    public static /* synthetic */ void access$400(TodoBlockPlugin r100) {
        r100.removeTodoFragment();
    }

    public static /* synthetic */ m access$500(TodoBlockPlugin r100) {
        return r100.mTaskCallBack;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r100) {
        r100.put(SHOW_SEARCH_ASSIGNEE, new c(this));
        r100.put(SHOW_TASK_ASSIGNEE, new d(this));
        r100.put(SHOW_CREATE_TASK, new b(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r100) {
        super.onAttachToHost(r100);
        TodoBlockViewModel r101 = (TodoBlockViewModel) q.c(r100, TodoBlockViewModel.class, null);
        this.mTodoViewModel = r101;
        r101.setDelegate(new a(this));
    }

    public static /* synthetic */ m access$302(TodoBlockPlugin r100, m r101) {
        r100.mSearchCallBack = r101;
        return r101;
    }

    public static /* synthetic */ m access$502(TodoBlockPlugin r100, m r101) {
        r100.mTaskCallBack = r101;
        return r101;
    }

    private void ensureTodoFragment(String r100, int r101) {
        Fragment r102 = getHost().getHostFragment();     // Catch: Exception -> L7
        if (r102 != null) goto L5;
        return;
    L5:
        FragmentManager r103 = r102.getChildFragmentManager();     // Catch: Exception -> L7
        Bundle r104 = new Bundle();     // Catch: Exception -> L7
        r104.putInt("request_code", r101);     // Catch: Exception -> L7
        r104.putString("request_data", r100);     // Catch: Exception -> L7
        INVOKEVIRTUAL_com_bytedance_ee_bear_lark_todoblock_TodoBlockPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r103.beginTransaction(), (TodoBlockFragment) instantiateFragment(TodoBlockFragment.class, r104), TAG_FRAGMENT).commitAllowingStateLoss();     // Catch: Exception -> L7
        r103.executePendingTransactions();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.d(TAG, "ensureTodoFragment error:" + e);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_lark_todoblock_TodoBlockPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r100, Fragment r101, String r102) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r100, r101, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r102, 0) == false) goto L6;
        return r100;
    L6:
        return r100.add(r101, r102);
    }

    public static /* synthetic */ void access$600(TodoBlockPlugin r100, String r101, int r102) {
        r100.ensureTodoFragment(r101, r102);
    }
}
