package com.bytedance.ee.bear.doc.vote;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Calendar;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
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

        public /* synthetic */ SelectVoteExpirationDateResult(a r100) {
            this();
        }

        public void setExpireTime(long r100) {
            this.expireTime = r100;
        }
    }

    public class a extends DiffObserver<Boolean> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VotePlugin f218429b;

        public a(VotePlugin r100) {
            this.f218429b = r100;
        }

        @Override // com.bytedance.ee.util.observer.DiffObserver
        public final void a(Boolean r100) {
            Boolean r101 = Boolean.TRUE;
            if (r101.equals(r100) == false) goto L5;
            tt5.a.h(VotePlugin.TAG, "show reminder fragment.");
            this.f218429b.showReminderFragment();
            return;
        L5:
            tt5.a.h(VotePlugin.TAG, "remove reminder fragment.");
            this.f218429b.hideReminderFragment();
        }
    }

    public class b implements tb5.i<VoteOptionJsData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VotePlugin f218430a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(VotePlugin r100) {
            this.f218430a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            VoteOptionJsData r102 = (VoteOptionJsData) r100;
            if (VotePlugin.access$200(this.f218430a) == true) goto L10;
            if (r102 == null) goto L7;
            PostCard r103 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).w2("/doc/vote/activity");
            int r104 = VoteOptionMembersActivity.f218393p;
            r103.i(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, r102.page_id).i(BitableResourceData.KEY_BLOCK_ID, r102.block_id).i("option_id", r102.option_id).j("vote_count", r102.vote_count).i("offset", r102.offset).l("isVoteDesc", r102.isVoteDesc).e();
            return;
        L7:
            tt5.a.k(VotePlugin.TAG, "js data is null");
            return;
        }
    }

    public class c implements tb5.i<SelectVoteExpirationDateResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VotePlugin f218431a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public c(VotePlugin r100) {
            this.f218431a = r100;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, tb5.m r101) {
            SelectVoteExpirationDateResult r102 = (SelectVoteExpirationDateResult) r100;
            tt5.a.h(VotePlugin.TAG, "show SelectVoteExpirationDatePanel, isUIContainerDetached : " + VotePlugin.access$300(this.f218431a));
            if (VotePlugin.access$400(this.f218431a) == false) goto L6;
            return;
        L6:
            if (r102 != null) goto L8;
        L10:
            Calendar r103 = Calendar.getInstance();
            r103.setTimeInMillis(System.currentTimeMillis());
            r103.add(5, 1);
            r103.set(11, 18);
            r103.set(12, 0);
            long r104 = r103.getTimeInMillis();
        L11:
            com.bytedance.ee.bear.reminder.model.a r105 = new com.bytedance.ee.bear.reminder.model.a();
            r105.f236477c = false;
            r105.f236487m = 30;
            r105.f236476b = r104;
            r105.f236480f = true;
            r105.f236479e = true;
            r105.f236478d = false;
            r105.f236488n = VotePlugin.access$500(this.f218431a).getString(R.string.LarkCCM_Docx_Poll_Deadline_Title);
            VotePlugin.access$600(this.f218431a).setOriginReminderSettings(r105);
            VotePlugin.access$600(this.f218431a).setDelegate(new w(this, r101));
            rcb.c.c(VotePlugin.access$800(this.f218431a));
            VotePlugin.access$600(this.f218431a).setActive(true);
            return;
        L8:
            if (r102.getExpireTime() == 0) goto L10;
            r104 = r102.getExpireTime();
            goto L11
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private ReminderFragment instantiateReminderFragment() {
        if (this.mUseIndependentReminderViewModel == false) goto L7;
        return (ReminderFragment) instantiateFragment(VoteReminderFragment.class);
    L7:
        return (ReminderFragment) instantiateFragment(ReminderFragment.class);
    }

    private ReminderFragment getReminderFragment() {
        return (ReminderFragment) getActivity().getSupportFragmentManager().findFragmentByTag(VotePlugin.class.getName());
    }

    public void hideReminderFragment() {
        ReminderFragment r100 = getReminderFragment();
        if (r100 == null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_doc_vote_VotePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r100);
        return;
    }

    public void showReminderFragment() {
        if (getReminderFragment() != null) goto L6;
        INVOKEVIRTUAL_com_bytedance_ee_bear_doc_vote_VotePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(instantiateReminderFragment(), getActivity().getSupportFragmentManager(), VotePlugin.class.getName());
        return;
    }

    public VotePlugin() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_doc_vote_VotePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(ReminderFragment r100) {
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

    public static /* synthetic */ boolean access$200(VotePlugin r100) {
        return r100.isUIContainerDetached();
    }

    public static /* synthetic */ boolean access$300(VotePlugin r100) {
        return r100.isUIContainerDetached();
    }

    public static /* synthetic */ boolean access$400(VotePlugin r100) {
        return r100.isUIContainerDetached();
    }

    public static /* synthetic */ Context access$500(VotePlugin r100) {
        return r100.getContext();
    }

    public static /* synthetic */ ReminderViewModel access$600(VotePlugin r100) {
        return r100.mReminderViewModel;
    }

    public static /* synthetic */ Context access$800(VotePlugin r100) {
        return r100.getContext();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, tb5.i<?>> r100) {
        r100.put(OPEN_VOTE_OPTION_MEMBERS, new b(this));
        r100.put(SHOW_SELECT_VOTE_EXPIRATION_DATEPANEL, new c(this));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.ee.bear.browser.plugin.PluginHost] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ee.bear.browser.plugin.PluginHost] */
    public void onAttachToHost(DocumentPluginHost r100) {
        super.onAttachToHost(r100);
        this.mUseIndependentReminderViewModel = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.fix_multi_reminder_fragment");
        tt5.a.h(TAG, "mUseIndependentReminderViewModel: " + this.mUseIndependentReminderViewModel);
        if (this.mUseIndependentReminderViewModel == false) goto L5;
        ReminderViewModel r101 = (ReminderViewModel) com.bytedance.ee.bear.browser.plugin.q.c(getHost(), VoteReminderViewModel.class, null);
    L6:
        this.mReminderViewModel = r101;
        r101.getActive().observe(getLifecycleOwner(), new a(this));
        return;
    L5:
        r101 = (ReminderViewModel) com.bytedance.ee.bear.browser.plugin.q.c(getHost(), ReminderViewModel.class, null);
        goto L6
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DocumentPluginHost) r100);
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_doc_vote_VotePlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_show(ReminderFragment r100, FragmentManager r101, String r102) {
        if ((r100 instanceof Fragment) == false) goto L5;
        ReminderFragment r103 = r100;
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
