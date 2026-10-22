package com.bytedance.ee.bear.doc.vote;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.base.DocumentPluginV3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.reminder.ReminderFragment;
import com.bytedance.ee.bear.reminder.ReminderViewModel;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.observer.DiffObserver;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Calendar;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class OfficeVotePlugin extends DocumentPluginV3 {
    private static final int DEFAULT_HOUR_OF_DAY = 18;
    private static final int DEFAULT_TIME_PICKER_MINUTE_INTERNAL = 30;
    private static final String OPEN_VOTE_OPTION_MEMBERS = "biz.util.openVoteMembers";
    private static final String SHOW_SELECT_VOTE_EXPIRATION_DATEPANEL = "biz.docx.showVoteSelectExpirationDatePanel";
    private static final String TAG = "OfficeVotePlugin";
    private ReminderViewModel mReminderViewModel;
    private boolean mUseIndependentReminderViewModel;

    public static class SelectVoteExpirationDateResult implements NonProguard {
        private long expireTime;

        private SelectVoteExpirationDateResult() {
            this.expireTime = 0;
        }

        public long getExpireTime() {
            return this.expireTime;
        }

        public /* synthetic */ SelectVoteExpirationDateResult(a r1) {
            this();
        }

        public void setExpireTime(long r1) {
            this.expireTime = r1;
        }
    }

    public class a extends DiffObserver<Boolean> {
        public final /* synthetic */ OfficeVotePlugin b;

        public a(OfficeVotePlugin r1) {
            this.b = r1;
        }

        public final void a(Object r2) {
            Boolean r0 = Boolean.TRUE;
            if (r0.equals((Boolean) r2) == false) goto L5;
            tt5.a.h(OfficeVotePlugin.TAG, "show reminder fragment.");
            this.b.showReminderFragment();
            return;
        L5:
            tt5.a.h(OfficeVotePlugin.TAG, "remove reminder fragment.");
            this.b.hideReminderFragment();
        }
    }

    public class b implements tb5.i<VoteOptionJsData> {
        public final /* synthetic */ OfficeVotePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(OfficeVotePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r1, tb5.m r2) {
            VoteOptionJsData r3 = (VoteOptionJsData) r1;
            if (OfficeVotePlugin.access$200(this.a) == true) goto L10;
            if (r3 == null) goto L7;
            OfficeVotePlugin.access$300(this.a, r3);
            return;
        L7:
            tt5.a.k(OfficeVotePlugin.TAG, "js data is null");
            return;
        }
    }

    public class c implements tb5.i<SelectVoteExpirationDateResult> {
        public final /* synthetic */ OfficeVotePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(OfficeVotePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r8, tb5.m r9) {
            SelectVoteExpirationDateResult r10 = (SelectVoteExpirationDateResult) r8;
            tt5.a.h(OfficeVotePlugin.TAG, "show SelectVoteExpirationDatePanel, isUIContainerDetached : " + OfficeVotePlugin.access$400(this.a));
            if (OfficeVotePlugin.access$500(this.a) == false) goto L6;
            return;
        L6:
            if (r10 != null) goto L8;
        L10:
            Calendar r11 = Calendar.getInstance();
            r11.setTimeInMillis(System.currentTimeMillis());
            r11.add(5, 1);
            r11.set(11, OfficeVotePlugin.DEFAULT_HOUR_OF_DAY);
            r11.set(12, 0);
            long r2 = r11.getTimeInMillis();
        L11:
            com.bytedance.ee.bear.reminder.model.a r12 = new com.bytedance.ee.bear.reminder.model.a();
            r12.c = false;
            r12.m = 30;
            r12.b = r2;
            r12.f = true;
            r12.e = true;
            r12.d = false;
            r12.n = OfficeVotePlugin.access$600(this.a).getString(2131889358);
            OfficeVotePlugin.access$700(this.a).setOriginReminderSettings(r12);
            OfficeVotePlugin.access$700(this.a).setDelegate(new com.bytedance.ee.bear.doc.vote.b(this, r9));
            rcb.c.c(OfficeVotePlugin.access$900(this.a));
            OfficeVotePlugin.access$700(this.a).setActive(true);
            return;
        L8:
            if (r10.getExpireTime() == 0) goto L10;
            r2 = r10.getExpireTime();
            goto L11
        }
    }

    public static /* synthetic */ void a(OfficeVotePlugin r0) {
        r0.hideVoteOptionMembersFragment();
    }

    @Override // com.bytedance.ee.bear.document.base.DocumentPluginV3
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ReminderFragment instantiateReminderFragment() {
        if (this.mUseIndependentReminderViewModel == false) goto L7;
        return instantiateFragment(VoteReminderFragment.class);
    L7:
        return instantiateFragment(ReminderFragment.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ReminderFragment getReminderFragment() {
        return getActivity().getSupportFragmentManager().findFragmentByTag(OfficeVotePlugin.class.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void hideVoteOptionMembersFragment() {
        if (isUIContainerAttached() == false) goto L6;
        getUIContainer().d(this);
        return;
    }

    public void hideReminderFragment() {
        ReminderFragment r0 = getReminderFragment();
        if (r0 == null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_doc_vote_OfficeVotePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showReminderFragment() {
        if (getReminderFragment() != null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_doc_vote_OfficeVotePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(instantiateReminderFragment(), getActivity().getSupportFragmentManager(), OfficeVotePlugin.class.getName());
        return;
    }

    public OfficeVotePlugin() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_doc_vote_OfficeVotePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(ReminderFragment r1) {
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

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean access$200(OfficeVotePlugin r0) {
        return r0.isUIContainerDetached();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean access$400(OfficeVotePlugin r0) {
        return r0.isUIContainerDetached();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean access$500(OfficeVotePlugin r0) {
        return r0.isUIContainerDetached();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context access$600(OfficeVotePlugin r0) {
        return r0.getContext();
    }

    public static /* synthetic */ ReminderViewModel access$700(OfficeVotePlugin r0) {
        return r0.mReminderViewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context access$900(OfficeVotePlugin r0) {
        return r0.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showVoteOptionMembersFragment(VoteOptionJsData r5) {
        rcb.c.c(getContext());
        int r1 = VoteOptionMembersFragment.s;
        Bundle r2 = new Bundle();
        if (r5 == null) goto L6;
        r2.putString("page_id", r5.page_id);
        r2.putString("block_id", r5.block_id);
        r2.putString("option_id", r5.option_id);
        r2.putInt("vote_count", r5.vote_count);
        r2.putString("offset", r5.offset);
        r2.putBoolean("isVoteDesc", r5.isVoteDesc);
    L6:
        VoteOptionMembersFragment r6 = (VoteOptionMembersFragment) instantiateFragment(VoteOptionMembersFragment.class, r2);
        r6.r = new com.bytedance.ee.bear.doc.vote.a(this);
        getUIContainer().i(this, r6);
    }

    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put(OPEN_VOTE_OPTION_MEMBERS, new b(this));
        r3.put(SHOW_SELECT_VOTE_EXPIRATION_DATEPANEL, new c(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(ChameleonPluginHost r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r3);
        this.mUseIndependentReminderViewModel = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.fix_multi_reminder_fragment");
        tt5.a.h(TAG, "mUseIndependentReminderViewModel: " + this.mUseIndependentReminderViewModel);
        if (this.mUseIndependentReminderViewModel == false) goto L5;
        ReminderViewModel r4 = (ReminderViewModel) viewModel(VoteReminderViewModel.class);
    L6:
        this.mReminderViewModel = r4;
        r4.getActive().observe(getLifecycleOwner(), new a(this));
        return;
    L5:
        r4 = viewModel(ReminderViewModel.class);
        goto L6
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((ChameleonPluginHost) r1);
    }

    public static /* synthetic */ void access$300(OfficeVotePlugin r0, VoteOptionJsData r1) {
        r0.showVoteOptionMembersFragment(r1);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_doc_vote_OfficeVotePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(ReminderFragment r2, FragmentManager r3, String r4) {
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
