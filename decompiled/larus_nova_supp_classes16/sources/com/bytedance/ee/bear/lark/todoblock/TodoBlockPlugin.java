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
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.Map;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final /* synthetic */ TodoBlockPlugin a;

        public a(TodoBlockPlugin r1) {
            this.a = r1;
        }
    }

    public class b implements i<String> {
        public final /* synthetic */ TodoBlockPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(TodoBlockPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            TodoBlockPlugin.access$502(this.a, r3);
            TodoBlockPlugin r4 = this.a;
            TodoBlockPlugin.access$600(r4, (String) r2, 3);
        }
    }

    public class c implements i<Void> {
        public final /* synthetic */ TodoBlockPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(TodoBlockPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            Void r4 = (Void) r2;
            if (LarkAppContext.inst().buildConfig().isOfficeSDK() == false) goto L5;
            UDToast.show(this.a.getHost().getContext(), 2131889046);
            return;
        L5:
            TodoBlockPlugin.access$302(this.a, r3);
            TodoBlockPlugin.access$600(this.a, null, 1);
        }
    }

    public class d implements i<String> {
        public final /* synthetic */ TodoBlockPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public d(TodoBlockPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r2, m r3) {
            TodoBlockPlugin.access$502(this.a, r3);
            TodoBlockPlugin r4 = this.a;
            TodoBlockPlugin.access$600(r4, (String) r2, 2);
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private TodoBlockFragment findStartPreviewFragment() {
        Fragment r0 = getHost().getHostFragment();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (TodoBlockFragment) r0.getChildFragmentManager().findFragmentByTag(TAG_FRAGMENT);
    }

    private void removeTodoFragment() {
        TodoBlockFragment r0 = findStartPreviewFragment();     // Catch: Exception -> L9
        if (r0 == null) goto L14;
        Fragment r1 = getHost().getHostFragment();     // Catch: Exception -> L9
        if (r1 != null) goto L7;
        return;
    L7:
        r1.getChildFragmentManager().beginTransaction().remove(r0).commitAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        tt5.a.d(TAG, "removeTodoFragment error:" + e);
    }

    public TodoBlockPlugin() {
    }

    public static /* synthetic */ m access$300(TodoBlockPlugin r0) {
        return r0.mSearchCallBack;
    }

    public static /* synthetic */ void access$400(TodoBlockPlugin r0) {
        r0.removeTodoFragment();
    }

    public static /* synthetic */ m access$500(TodoBlockPlugin r0) {
        return r0.mTaskCallBack;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        r3.put(SHOW_SEARCH_ASSIGNEE, new c(this));
        r3.put(SHOW_TASK_ASSIGNEE, new d(this));
        r3.put(SHOW_CREATE_TASK, new b(this));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r3) {
        super.onAttachToHost(r3);
        TodoBlockViewModel r4 = (TodoBlockViewModel) q.c(r3, TodoBlockViewModel.class, null);
        this.mTodoViewModel = r4;
        r4.setDelegate(new a(this));
    }

    public static /* synthetic */ m access$302(TodoBlockPlugin r0, m r1) {
        r0.mSearchCallBack = r1;
        return r1;
    }

    public static /* synthetic */ m access$502(TodoBlockPlugin r0, m r1) {
        r0.mTaskCallBack = r1;
        return r1;
    }

    private void ensureTodoFragment(String r4, int r5) {
        Fragment r0 = getHost().getHostFragment();     // Catch: Exception -> L7
        if (r0 != null) goto L5;
        return;
    L5:
        FragmentManager r1 = r0.getChildFragmentManager();     // Catch: Exception -> L7
        Bundle r2 = new Bundle();     // Catch: Exception -> L7
        r2.putInt("request_code", r5);     // Catch: Exception -> L7
        r2.putString("request_data", r4);     // Catch: Exception -> L7
        INVOKEVIRTUAL_com_bytedance_ee_bear_lark_todoblock_TodoBlockPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r1.beginTransaction(), (TodoBlockFragment) instantiateFragment(TodoBlockFragment.class, r2), TAG_FRAGMENT).commitAllowingStateLoss();     // Catch: Exception -> L7
        r1.executePendingTransactions();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.d(TAG, "ensureTodoFragment error:" + e);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_bytedance_ee_bear_lark_todoblock_TodoBlockPlugin_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == false) goto L6;
        return r2;
    L6:
        return r2.add(r3, r4);
    }

    public static /* synthetic */ void access$600(TodoBlockPlugin r0, String r1, int r2) {
        r0.ensureTodoFragment(r1, r2);
    }
}
