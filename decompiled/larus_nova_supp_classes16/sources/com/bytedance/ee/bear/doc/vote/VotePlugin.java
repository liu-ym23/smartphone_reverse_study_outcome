package com.bytedance.ee.bear.doc.vote;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.reminder.ReminderFragment;
import com.bytedance.ee.bear.reminder.ReminderViewModel;
import com.bytedance.ee.bear.route.PostCard;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.observer.DiffObserver;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Calendar;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class VotePlugin extends DocumentPlugin {
    private static final int DEFAULT_HOUR_OF_DAY = 18;
    private static final int DEFAULT_TIME_PICKER_MINUTE_INTERNAL = 30;
    private static final String OPEN_VOTE_OPTION_MEMBERS = "biz.util.openVoteMembers";
    private static final String SHOW_SELECT_VOTE_EXPIRATION_DATEPANEL = "biz.docx.showVoteSelectExpirationDatePanel";
    private static final String TAG = "VotePlugin";
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
        public final /* synthetic */ VotePlugin b;

        public a(VotePlugin r1) {
            this.b = r1;
        }

        public final void a(Object r2) {
            Boolean r0 = Boolean.TRUE;
            if (r0.equals((Boolean) r2) == false) goto L5;
            tt5.a.h(VotePlugin.TAG, "show reminder fragment.");
            this.b.showReminderFragment();
            return;
        L5:
            tt5.a.h(VotePlugin.TAG, "remove reminder fragment.");
            this.b.hideReminderFragment();
        }
    }

    public class b implements tb5.i<VoteOptionJsData> {
        public final /* synthetic */ VotePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(VotePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r3, tb5.m r4) {
            VoteOptionJsData r5 = (VoteOptionJsData) r3;
            if (VotePlugin.access$200(this.a) == true) goto L10;
            if (r5 == null) goto L7;
            PostCard r6 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2("/doc/vote/activity");
            int r0 = VoteOptionMembersActivity.p;
            r6.i("page_id", r5.page_id).i("block_id", r5.block_id).i("option_id", r5.option_id).j("vote_count", r5.vote_count).i("offset", r5.offset).l("isVoteDesc", r5.isVoteDesc).e();
            return;
        L7:
            tt5.a.k(VotePlugin.TAG, "js data is null");
            return;
        }
    }

    public class c implements tb5.i<SelectVoteExpirationDateResult> {
        public final /* synthetic */ VotePlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(VotePlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r8, tb5.m r9) {
            SelectVoteExpirationDateResult r10 = (SelectVoteExpirationDateResult) r8;
            tt5.a.h(VotePlugin.TAG, "show SelectVoteExpirationDatePanel, isUIContainerDetached : " + VotePlugin.access$300(this.a));
            if (VotePlugin.access$400(this.a) == false) goto L6;
            return;
        L6:
            if (r10 != null) goto L8;
        L10:
            Calendar r11 = Calendar.getInstance();
            r11.setTimeInMillis(System.currentTimeMillis());
            r11.add(5, 1);
            r11.set(11, VotePlugin.DEFAULT_HOUR_OF_DAY);
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
            r12.n = VotePlugin.access$500(this.a).getString(2131889358);
            VotePlugin.access$600(this.a).setOriginReminderSettings(r12);
            VotePlugin.access$600(this.a).setDelegate(new w(this, r9));
            rcb.c.c(VotePlugin.access$800(this.a));
            VotePlugin.access$600(this.a).setActive(true);
            return;
        L8:
            if (r10.getExpireTime() == 0) goto L10;
            r2 = r10.getExpireTime();
            goto L11
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private ReminderFragment instantiateReminderFragment() {
        if (this.mUseIndependentReminderViewModel == false) goto L7;
        return instantiateFragment(VoteReminderFragment.class);
    L7:
        return instantiateFragment(ReminderFragment.class);
    }

    private ReminderFragment getReminderFragment() {
        return getActivity().getSupportFragmentManager().findFragmentByTag(VotePlugin.class.getName());
    }

    public void hideReminderFragment() {
        ReminderFragment r0 = getReminderFragment();
        if (r0 == null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_doc_vote_VotePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);
        return;
    }

    public void showReminderFragment() {
        if (getReminderFragment() != null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_doc_vote_VotePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(instantiateReminderFragment(), getActivity().getSupportFragmentManager(), VotePlugin.class.getName());
        return;
    }

    public VotePlugin() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_doc_vote_VotePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(ReminderFragment r1) {
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

    public static /* synthetic */ boolean access$200(VotePlugin r0) {
        return r0.isUIContainerDetached();
    }

    public static /* synthetic */ boolean access$300(VotePlugin r0) {
        return r0.isUIContainerDetached();
    }

    public static /* synthetic */ boolean access$400(VotePlugin r0) {
        return r0.isUIContainerDetached();
    }

    public static /* synthetic */ Context access$500(VotePlugin r0) {
        return r0.getContext();
    }

    public static /* synthetic */ ReminderViewModel access$600(VotePlugin r0) {
        return r0.mReminderViewModel;
    }

    public static /* synthetic */ Context access$800(VotePlugin r0) {
        return r0.getContext();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        r3.put(OPEN_VOTE_OPTION_MEMBERS, new b(this));
        r3.put(SHOW_SELECT_VOTE_EXPIRATION_DATEPANEL, new c(this));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.ee.bear.browser.plugin.PluginHost] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ee.bear.browser.plugin.PluginHost] */
    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        this.mUseIndependentReminderViewModel = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.fix_multi_reminder_fragment");
        tt5.a.h(TAG, "mUseIndependentReminderViewModel: " + this.mUseIndependentReminderViewModel);
        if (this.mUseIndependentReminderViewModel == false) goto L5;
        ReminderViewModel r4 = (ReminderViewModel) com.bytedance.ee.bear.browser.plugin.q.c(getHost(), VoteReminderViewModel.class, null);
    L6:
        this.mReminderViewModel = r4;
        r4.getActive().observe(getLifecycleOwner(), new a(this));
        return;
    L5:
        r4 = com.bytedance.ee.bear.browser.plugin.q.c(getHost(), ReminderViewModel.class, null);
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_doc_vote_VotePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(ReminderFragment r2, FragmentManager r3, String r4) {
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
