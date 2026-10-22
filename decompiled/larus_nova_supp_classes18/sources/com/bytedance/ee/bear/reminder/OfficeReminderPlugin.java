package com.bytedance.ee.bear.reminder;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.reminder.model.ReminderModel;
import com.bytedance.ee.util.ui.j;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ql5.d;
import ql5.e0;
import rcb.c;
import s45.p;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeReminderPlugin extends DocumentPluginV3 {
    private static final String TAG = "ReminderPlugin";
    private ReminderFragment mReminderFragment;
    private b mReminderJsBinder;
    private e0 mReminderReporter;
    private ReminderViewModel mReminderViewModel;

    public class a implements ReminderViewModel.a {
        public final /* synthetic */ OfficeReminderPlugin a;

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void h() {
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void a() {
            OfficeReminderPlugin.access$100(this.a).a("select_reminder_time");
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void b() {
            OfficeReminderPlugin.access$100(this.a).a("select_time");
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void c() {
            OfficeReminderPlugin.access$100(this.a).a("click_continue_edit");
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void d() {
            OfficeReminderPlugin.access$100(this.a).a("select_date");
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void e() {
            OfficeReminderPlugin.access$100(this.a).a("click_confirm_quit");
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void f() {
            OfficeReminderPlugin.access$100(this.a).a("select_month");
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void g() {
            OfficeReminderPlugin.access$100(this.a).a("click_no_reminder");
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void j() {
            OfficeReminderPlugin.access$100(this.a).a("client_all_day");
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void k() {
            OfficeReminderPlugin.access$100(this.a).a("client_cancel_all_day");
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void onClose() {
            tt5.a.h(OfficeReminderPlugin.TAG, "close reminder fragment.");
            OfficeReminderPlugin.access$100(this.a).a("click_quit");
            OfficeReminderPlugin.access$200(this.a).a();
            OfficeReminderPlugin.access$300(this.a).setActive(false);
            ((com.bytedance.ee.bear.document.toolbar2.b) org.koin.java.a.a(com.bytedance.ee.bear.document.toolbar2.b.class)).b(this.a.getHost());
        }

        public a(OfficeReminderPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.reminder.ReminderViewModel.a
        public final void i(com.bytedance.ee.bear.reminder.model.a r6) {
            tt5.a.h(OfficeReminderPlugin.TAG, "save reminder settings.");
            OfficeReminderPlugin.access$100(this.a).a("click_save");
            b r0 = OfficeReminderPlugin.access$200(this.a);
            ReminderModel r7 = ReminderModel.newInstance(r6);
            r0.getClass();
            r7.getData().setReminderBlockId(r0.a);
            tt5.a.b(OfficeReminderPlugin.TAG, String.format("initViewModel: window.lark.biz.reminder.setDate(%s)", new Object[]{r7.toString()}));
            r0.b.getHost().getWeb().getBridge().a("window.lark.biz.reminder.setDate", r7.toJSONObject(), null);
            OfficeReminderPlugin.access$300(this.a).setActive(false);
        }
    }

    public class b implements i<ReminderModel> {
        public String a;
        public final /* synthetic */ OfficeReminderPlugin b;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public final void a() {
            tt5.a.b(OfficeReminderPlugin.TAG, "notifyCancel ");
            this.b.getHost().getWeb().getBridge().a("window.lark.biz.reminder.cancel", new JSONObject(), null);
        }

        public b(OfficeReminderPlugin r1) {
            this.b = r1;
        }

        public final void handle(Object r2, m r3) {
            ReminderModel r4 = (ReminderModel) r2;
            tt5.a.b(OfficeReminderPlugin.TAG, "show reminder: data = " + r4);
            if (r4 != null) goto L5;
        L7:
            this.a = null;
            OfficeReminderPlugin.access$100(this.b).a("click_insert_reminder");
        L8:
            if (r4 != null) goto L10;
        L13:
            com.bytedance.ee.bear.reminder.model.a r5 = new com.bytedance.ee.bear.reminder.model.a();
        L14:
            if (r4 != null) goto L16;
            r5 = new com.bytedance.ee.bear.reminder.model.a();
        L17:
            r5.m = 5;
            if (r5.l != null) goto L20;
            r5.l = new ReminderModel.CreateTaskSwitchBean();
        L20:
            OfficeReminderPlugin.access$300(this.b).setOriginReminderSettings(r5);
            c.c(OfficeReminderPlugin.access$400(this.b));
            OfficeReminderPlugin.access$300(this.b).setActive(true);
            return;
        L16:
            r5.l = r4.getCreateTaskSwitch();
            goto L17
        L10:
            if (r4.getData() == null) goto L13;
            r5 = r4.toReminderSettings();
            goto L14
        L5:
            if (r4.getData() == null) goto L7;
            this.a = r4.getData().getReminderBlockId();
            OfficeReminderPlugin.access$100(this.b).a("click_reminder");
            goto L8
        }
    }

    public static /* synthetic */ Unit a(OfficeReminderPlugin r0, ReminderFragment r1) {
        return r0.lambda$showFragment$2(r1);
    }

    public static /* synthetic */ void c(OfficeReminderPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$1(r1);
    }

    public static /* synthetic */ void d(OfficeReminderPlugin r0, ReminderFragment r1) {
        r0.lambda$showFragment$3(r1);
    }

    public static /* synthetic */ void e(OfficeReminderPlugin r0, Boolean r1) {
        r0.lambda$onAttachToHost$0(r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private ReminderFragment getReminderFragment() {
        return getActivity().getSupportFragmentManager().findFragmentByTag(TAG);
    }

    private void hideFragment() {
        ReminderFragment r0 = getReminderFragment();
        if (r0 == null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_reminder_OfficeReminderPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);
        return;
    }

    private void showFragment() {
        if (getReminderFragment() != null) goto L12;
        final ReminderFragment r0 = instantiateFragment(ReminderFragment.class);
        if (ForsetiHelper.s(getHost().getHostFragment()) == false) goto L10;
        Fragment r2 = getHost().getHostFragment();
        ForsetiNavOptions.DestinationStyle r3 = ForsetiNavOptions.DestinationStyle.FLOAT;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r3, "style");
        if (f.e(r0, r2, r3, false, 0, false, 60) == false) goto L10;
        this.mReminderFragment = r0;
        j.c(new d(this, r0));
        return;
    L10:
        INVOKEVIRTUAL_com_bytedance_ee_bear_reminder_OfficeReminderPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(r0, getActivity().getSupportFragmentManager(), TAG);
        return;
    }

    public OfficeReminderPlugin() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_reminder_OfficeReminderPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(ReminderFragment r1) {
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

    public static /* synthetic */ e0 access$100(OfficeReminderPlugin r0) {
        return r0.mReminderReporter;
    }

    public static /* synthetic */ b access$200(OfficeReminderPlugin r0) {
        return r0.mReminderJsBinder;
    }

    public static /* synthetic */ ReminderViewModel access$300(OfficeReminderPlugin r0) {
        return r0.mReminderViewModel;
    }

    public static /* synthetic */ Context access$400(OfficeReminderPlugin r0) {
        return r0.getContext();
    }

    private /* synthetic */ void lambda$onAttachToHost$0(Boolean r2) {
        if (Boolean.TRUE.equals(r2) == false) goto L5;
        tt5.a.h(TAG, "show reminder fragment.");
        showFragment();
        return;
    L5:
        tt5.a.h(TAG, "remove reminder fragment.");
        hideFragment();
    }

    private /* synthetic */ void lambda$onAttachToHost$1(Boolean r3) {
        tt5.a.h(TAG, "edit mode changed: " + r3);
        if (Boolean.FALSE.equals(r3) == false) goto L10;
        ReminderFragment r4 = this.mReminderFragment;
        if (r4 != null) goto L7;
        return;
    L7:
        if (r4.isAdded() == false) goto L12;
        INVOKEVIRTUAL_com_bytedance_ee_bear_reminder_OfficeReminderPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this.mReminderFragment);
        return;
    L12:
        return;
    }

    private /* synthetic */ Unit lambda$showFragment$2(ReminderFragment r3) {
        tt5.a.h(TAG, "fragment is removed");
        this.mReminderFragment = null;
        ForsetiHelper.v(r3);
        b r4 = this.mReminderJsBinder;
        if (r4 == null) goto L5;
        r4.a();
    L5:
        return null;
    }

    private /* synthetic */ void lambda$showFragment$3(final ReminderFragment r2) {
        if (com.bytedance.ee.util.ui.b.a(getHost().getActivity()) == true) goto L5;
        return;
    L5:
        if (r2.isAdded() == false) goto L9;
        ForsetiHelper.a(r2, new ql5.a(this, r2));
        return;
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        b r0 = new b(this);
        this.mReminderJsBinder = r0;
        r3.put("biz.reminder.showSettingsPage", r0);
    }

    public void onAttachToHost(ChameleonPluginHost r4) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r4);
        this.mReminderReporter = new e0();
        ReminderViewModel r0 = (ReminderViewModel) q.c(getHost(), ReminderViewModel.class, null);
        this.mReminderViewModel = r0;
        r0.setDelegate(new a(this));
        if (getDocumentMetadata() == null) goto L5;
        BearUrl r1 = p.a().Z(getDocumentMetadata().getUrl());
        e0 r2 = this.mReminderReporter;
        r2.a = du5.b.g(r1.b);
        e0 r3 = this.mReminderReporter;
        r3.b = r1.a;
        this.mReminderViewModel.setBearUrl(r1);
    L5:
        this.mReminderViewModel.getActive().observe(getLifecycleOwner(), new ql5.b(this));
        oy4.a r5 = r4.getHostAbilityOrNull(oy4.a.class);
        if (r5 == null) goto L9;
        r5.getEditModeLiveData().observe(getLifecycleOwner(), new ql5.c(this));
        return;
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_reminder_OfficeReminderPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(ReminderFragment r2, FragmentManager r3, String r4) {
        if ((r2 instanceof Fragment) == false) goto L5;
        ReminderFragment r0 = r2;
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
