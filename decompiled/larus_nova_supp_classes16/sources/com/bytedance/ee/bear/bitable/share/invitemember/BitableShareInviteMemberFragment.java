package com.bytedance.ee.bear.bitable.share.invitemember;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.n;
import com.bytedance.ee.bear.bitable.share.BitableSharePermSetInfo;
import com.bytedance.ee.bear.bitable.share.invitemember.manager.BitableShareInviteMemberManagerFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.BaseInviteMemberFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.InviteMemberViewModel;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.utils.CollectionUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.suite.lark.component.navroute.forseti.ForsetiNavOptions;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import mu4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/invitemember/BitableShareInviteMemberFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/BaseInviteMemberFragment;", "<init>", "()V", "mPermSetInfo", "Lcom/bytedance/ee/bear/bitable/share/BitableSharePermSetInfo;", "originUserInfoList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "ownerInfo", "inviteDepEnable", "", "isFromSharePanel", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "initData", "buildInviteParams", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/InviteMemberParams;", "fromSharePanel", "jumpNextPage", "jumpAskOwner", "jumpInviteMemberManage", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableShareInviteMemberFragment extends BaseInviteMemberFragment {
    public static final /* synthetic */ int p = 0;
    public BitableSharePermSetInfo k;
    public final ArrayList<UserInfo> l;
    public UserInfo m;
    public boolean n;
    public boolean o;

    public static final class a {
        @JvmStatic
        public static void a(FragmentActivity r7, Fragment r8, BitableSharePermSetInfo r9, ArrayList r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r7, "activity");
            Intrinsics.checkNotNullParameter(r9, "permSetInfo");
            Intrinsics.checkNotNullParameter(r10, "originUsers");
            Bundle r0 = new Bundle();
            r0.putParcelable("doc", r9);
            r0.putParcelableArrayList("users", r10);
            r0.putBoolean("from_share_panel", r11);
            Fragment r12 = Fragment.instantiate(r7, BitableShareInviteMemberFragment.class.getName(), r0);
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
            Fragment r13 = (DialogFragment) r12;
            if (c.j() == true) goto L5;
        L7:
            boolean r14 = false;
        L8:
            if (r14 == true) goto L10;
        L11:
            FragmentManager r16 = r7.getSupportFragmentManager();
            String r17 = BitableShareInviteMemberFragment.class.getName();
            if ((r13 instanceof Fragment) == false) goto L14;
            Fragment r18 = r13;
        L15:
            LandscapeRestrictionOperation r19 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r18, r17, r19);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r16, r18, r19) == true) goto L25;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
        L19:
            r13.show(r16, r17);
            return;
        L25:
            return;
        L14:
            r18 = null;
            goto L15
        L10:
            if (f.e(r13, r8, ForsetiNavOptions.DestinationStyle.FLOAT, false, 0, ForsetiHelper.m(), 28) == false) goto L11;
            return;
        L5:
            if (ForsetiHelper.s(r8) == false) goto L7;
            r14 = true;
            goto L8
        }
    }

    static {
    }

    public final void jD() {
    }

    public final void O50() {
        int r0 = BitableShareInviteMemberManagerFragment.i;
        Context r1 = requireContext();
        BitableSharePermSetInfo r2 = this.k;
        Parcelable r3 = this.m;
        boolean r4 = this.o;
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, "permSetInfo");
        Bundle r5 = new Bundle();
        r5.putParcelable("extra_perm_set_info", r2);
        r5.putBoolean("from_share_panel", r4);
        r5.putParcelable("extra_owner_info", r3);
        ha0(Fragment.instantiate(r1, BitableShareInviteMemberManagerFragment.class.getName(), r5));
    }

    public final InviteMemberParams ba0() {
        BitableSharePermSetInfo r1 = this.k;
        String r3 = r1.c;
        int r4 = r1.getType();
        UserInfo r2 = this.m;
        if (r2 == null) goto L6;
        String r5 = r2.getId();
        if (r5 == null) goto L6;
    L7:
        InviteMemberParams r6 = new InviteMemberParams(r3, r4, r5, null, null, this.n, false, false, false, false, false, false, "ccm_bitable_form_permission_select_contact_view", b.a(requireContext(), this.k.d.getShareType()), false, true, true, false, false, false, false, null, 8277976);
        if (this.k.d.getShareType() != EShareType.FORM) goto L10;
        r6.g = true;
        r6.u = Boolean.TRUE;
    L10:
        return r6;
    L6:
        r5 = "";
        goto L7
    }

    public BitableShareInviteMemberFragment() {
        this.k = new BitableSharePermSetInfo(0, null, 63);
        this.l = new ArrayList();
    }

    public final boolean ca0() {
        return this.o;
    }

    public final ArrayList<UserInfo> da0() {
        return this.l;
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        Bundle r8 = getArguments();
        boolean r0 = false;
        if (r8 == null) goto L23;
        BitableSharePermSetInfo r3 = (BitableSharePermSetInfo) r8.getParcelable("doc");
        if (r3 != null) goto L7;
        r3 = new BitableSharePermSetInfo(0, null, 63);
    L7:
        this.k = r3;
        ArrayList r4 = r8.getParcelableArrayList("users");
        if (CollectionUtils.isEmpty(r4) == true) goto L10;
        ArrayList<UserInfo> r5 = this.l;
        Intrinsics.checkNotNull(r4);
        r5.addAll(r4);
    L10:
        if (r4 == null) goto L21;
        Sequence r6 = CollectionsKt.asSequence(r4);
        if (r6 == null) goto L21;
        Iterator r9 = r6.iterator();
    L15:
        if (r9.hasNext() == false) goto L19;
        Object r10 = r9.next();
        if (((UserInfo) r10).isOwner() == false) goto L15;
    L20:
        UserInfo r11 = (UserInfo) r10;
    L22:
        this.m = r11;
        this.o = r8.getBoolean("from_share_panel", false);
    L24:
        ((BaseInviteMemberFragment) this).i = ViewModelProviders.of(requireActivity()).get(InviteMemberViewModel.class);
        AccountService$Account r12 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r12 != null) goto L27;
    L29:
        this.n = !r0;
        tt5.a.h("BitableShareInviteMemberFragment", "isConsumer:" + r0 + ", type=" + this.k.getType() + ", inviteDepEnable=" + this.n + ",isFromSharePanel=" + this.o);
        return;
    L27:
        if (r12.isConsumer() == false) goto L29;
        r0 = true;
        goto L29
    L19:
        r10 = null;
    L21:
        r11 = null;
        goto L22
    L23:
        tt5.a.d("BitableShareInviteMemberFragment", "initData()...args == null!");
        goto L24
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);     // Catch: Throwable -> L7
        int r3 = c.a;     // Catch: Throwable -> L7
        int r4 = n.a;     // Catch: Throwable -> L7
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.big_screen_share_invite_back_press_fix_enable") == false) goto L5;
        fa0();     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }
}
