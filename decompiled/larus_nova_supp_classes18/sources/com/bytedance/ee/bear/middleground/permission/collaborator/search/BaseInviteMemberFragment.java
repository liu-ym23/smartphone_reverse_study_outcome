package com.bytedance.ee.bear.middleground.permission.collaborator.search;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.FragmentBackPressedHelperKt;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteMemberParams;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.dep.SelectDepFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.newsearch.user.NewSearchUserFragment;
import com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup.SelectUserGroupFragment;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.util.ui.i;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.utils.UIUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rcb.c;
import sa5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001LB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010)\u001a\u00020\r2\u0006\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020+H\u0014J\u0018\u0010,\u001a\u00020\r2\u0006\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020+H\u0014J\b\u0010-\u001a\u00020\rH\u0002J\u0010\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u0016H\u0002J\b\u00100\u001a\u00020\u0016H\u0016J\u001a\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u00103\u001a\u00020\rH\u0016J\b\u00104\u001a\u00020\rH\u0004J\b\u00105\u001a\u00020\rH\u0002J\b\u00106\u001a\u00020\rH\u0002J\b\u00107\u001a\u000208H&J\u0018\u00109\u001a\u0012\u0012\u0004\u0012\u00020;0:j\b\u0012\u0004\u0012\u00020;`<H&J\u001c\u0010=\u001a\u0016\u0012\u0004\u0012\u00020;\u0018\u00010:j\n\u0012\u0004\u0012\u00020;\u0018\u0001`<H\u0016J\b\u0010>\u001a\u00020+H&J$\u0010?\u001a\u00020+2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\u00162\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010E\u001a\u00020+H\u0016J\b\u0010F\u001a\u00020\rH\u0016J\b\u0010G\u001a\u00020\rH\u0016J\b\u0010H\u001a\u00020\rH\u0016J\u0010\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020KH\u0004R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006M"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/BaseInviteMemberFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/newsearch/ISearchUserActDependency;", "Landroid/content/DialogInterface$OnKeyListener;", "<init>", "()V", "shareSearchContentFrameFromXml", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/WindowInsetsAdaptationFrameLayout;", "getShareSearchContentFrameFromXml", "()Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/WindowInsetsAdaptationFrameLayout;", "setShareSearchContentFrameFromXml", "(Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/WindowInsetsAdaptationFrameLayout;)V", "clearFromXmlViewCache", "", "onDestroyView", "viewModel", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/InviteMemberViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/InviteMemberViewModel;", "setViewModel", "(Lcom/bytedance/ee/bear/middleground/permission/collaborator/search/InviteMemberViewModel;)V", "DP_11", "", "getDP_11", "()I", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "adjustWindowParams", "attributes", "Landroid/view/WindowManager$LayoutParams;", "adjustWindowHeight", "isLandscape", "", "adjustWindowHeightInternal", "updateNavigationBarStyle", "setStatusBarColor", "color", "getAnimations", "onViewCreated", "view", "onResume", "showShareFragment", "hideShareFragment", "initFragment", "buildInviteParams", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/InviteMemberParams;", "originUserInfoList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "Lkotlin/collections/ArrayList;", "topStickUserInfoList", "fromSharePanel", "onKey", "dialog", "Landroid/content/DialogInterface;", "keyCode", "event", "Landroid/view/KeyEvent;", "back", "finish", "jumpSelectedDep", "jumpSelectedUserGroup", "transformFragment", "fragment", "Landroidx/fragment/app/Fragment;", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseInviteMemberFragment extends BaseAntiScreenshotsDialogFragment implements dh5.a, DialogInterface.OnKeyListener {
    public WindowInsetsAdaptationFrameLayout h;
    public InviteMemberViewModel i;
    public final int j;

    public static final class a {
    }

    public static final class b implements d {
        public final /* synthetic */ BaseInviteMemberFragment a;

        public b(BaseInviteMemberFragment r1) {
            this.a = r1;
        }

        public final boolean onBackPressed() {
            this.a.back();
            return true;
        }
    }

    static {
    }

    public void Z90(WindowManager.LayoutParams r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "attributes");
    }

    public abstract InviteMemberParams ba0();

    public abstract boolean ca0();

    public abstract ArrayList<UserInfo> da0();

    public ArrayList<UserInfo> ga0() {
        return null;
    }

    @Override // dh5.a
    public final void bE() {
        int r0 = SelectDepFragment.j;
        ArrayList<UserInfo> r1 = da0();
        InviteMemberParams r2 = ba0();
        Intrinsics.checkNotNullParameter(r1, "originUsers");
        Intrinsics.checkNotNullParameter(r2, "params");
        Bundle r3 = new Bundle();
        r3.putParcelableArrayList("extra_origin_user", r1);
        r3.putParcelable("extra_params", r2);
        SelectDepFragment r4 = new SelectDepFragment();
        r4.setArguments(r3);
        ha0(r4);
    }

    @Override // dh5.a
    public final void qE() {
        int r0 = SelectUserGroupFragment.j;
        ArrayList<UserInfo> r1 = da0();
        InviteMemberParams r2 = ba0();
        Intrinsics.checkNotNullParameter(r1, "originUsers");
        Intrinsics.checkNotNullParameter(r2, "params");
        Bundle r3 = new Bundle();
        r3.putParcelableArrayList("extra_origin_user", r1);
        r3.putParcelable("extra_params", r2);
        SelectUserGroupFragment r4 = new SelectUserGroupFragment();
        r4.setArguments(r3);
        ha0(r4);
    }

    public BaseInviteMemberFragment() {
        this.j = n.d(11);
    }

    @Override // dh5.a
    public final boolean back() {
        if (isAdded() == true) goto L7;
        tt5.a.d("InviteMemberFragment", "back()...but isAdd=false");
        return false;
    L7:
        if (getChildFragmentManager().getBackStackEntryCount() < 1) goto L9;
        FragmentManager r0 = getChildFragmentManager();
        i.a(r0);
        r0.popBackStack();
        return true;
    L9:
        finish();
        return false;
    }

    public final void fa0() {
        if (ca0() == false) goto L6;
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).ja();
        return;
    }

    @Override // dh5.a
    public final void finish() {
        View r0 = getView();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        c.d(getView());
    L9:
        fa0();
        dismissAllowingStateLoss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L19;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L19:
        return;
    L5:
        if (r0.requestFocus() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.h = null;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (ca0() == false) goto L6;
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).ba();
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L8;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        FragmentActivity r3 = getActivity();
        Intrinsics.checkNotNull(r3);
        aa0(r2, r3.getResources().getConfiguration());
        r2.softInputMode = 16;
        r1.setAttributes(r2);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
    L8:
        if (Build.VERSION.SDK_INT < 29) goto L22;
        Dialog r4 = getDialog();
        if (r4 == null) goto L23;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L24;
        r5.setNavigationBarContrastEnforced(false);
        View r6 = r5.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L18;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r7 = ThreadMethodProxy.currentThread();
        if (r7 == com.larus.home.impl.utils.c.a) goto L18;
        com.larus.home.impl.utils.c.a(r7, "getDecorView");
    L18:
        WindowInsetsControllerCompat r8 = WindowCompat.getInsetsController(r5, r6);
        if (r8 == null) goto L25;
        r8.setAppearanceLightNavigationBars(true);
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    }

    public final void ea0(int r8) {
        Dialog r0 = getDialog();
        if (r0 == null) goto L14;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L15;
        boolean r3 = false;
        if (Color.alpha(r8) == 255) goto L10;
        bp5.c.f(r1, r8, false);
        return;
    L10:
        if (ColorUtils.calculateContrast(-1, r8) > 3.0d) goto L12;
        r3 = true;
    L12:
        bp5.c.f(r1, r8, r3);
        return;
    L15:
        return;
    }

    public final void ha0(Fragment r6) {
        Intrinsics.checkNotNullParameter(r6, "fragment");
        FragmentTransaction r0 = getChildFragmentManager().beginTransaction().setCustomAnimations(2130772290, 2130772289, 2130772288, 2130772293);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r0, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131386129) == true) goto L6;
        r0 = r0.add(2131386129, r6);
    L6:
        r0.addToBackStack(null).commitAllowingStateLoss();
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        WindowManager.LayoutParams r3 = r1.getAttributes();
    L8:
        aa0(r3, r2);
        Dialog r4 = getDialog();
        if (r4 == null) goto L14;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L15;
        r5.setAttributes(r3);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(0, 2131952404);
        com.bytedance.ee.bear.middleground.permission.c.b0("ccm_permission_add_collaborator_view");
    }

    public final void aa0(WindowManager.LayoutParams r3, Configuration r4) {
        if (r3 == null) goto L9;
        int r5 = r4.orientation;
        if (2 != r5) goto L6;
        r3.width = (int) (n.q(getActivity()) * 0.7f);
        Z90(r3, true);
        ea0(UIUtils.getColor(getActivity(), 2131106784));
        return;
    L6:
        if (1 != r5) goto L11;
        r3.width = -1;
        Z90(r3, false);
        ea0(UIUtils.getColor(getActivity(), 2131100548));
        return;
    L11:
        return;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r6, r7);
        Dialog r8 = getDialog();
        if (r8 == null) goto L6;
        r8.setOnKeyListener(this);
    L6:
        if (getChildFragmentManager().findFragmentByTag(NewSearchUserFragment.class.getName()) != null) goto L15;
        InviteMemberViewModel r9 = this.i;
        if (r9 == null) goto L10;
        r9.clearDataAndListener();
    L10:
        int r10 = NewSearchUserFragment.j;
        ArrayList<UserInfo> r11 = da0();
        ArrayList<UserInfo> r1 = ga0();
        InviteMemberParams r2 = ba0();
        Intrinsics.checkNotNullParameter(r11, "originUsers");
        Intrinsics.checkNotNullParameter(r2, "inviteMemberParams");
        Bundle r3 = new Bundle();
        r3.putParcelableArrayList("extra_origin_user", r11);
        r3.putParcelableArrayList("top_stick_users", r1);
        r3.putParcelable("extra_params", r2);
        NewSearchUserFragment r12 = new NewSearchUserFragment();
        r12.setArguments(r3);
        FragmentTransaction r4 = getChildFragmentManager().beginTransaction();
        String r5 = NewSearchUserFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r4, r12, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r5, 2131386129) == true) goto L14;
        r4 = r4.add(2131386129, r12, r5);
    L14:
        r4.commitAllowingStateLoss();
    L15:
        zo5.b r13 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        View r14 = this.h;
        if (r14 != null) goto L22;
        View r15 = getView();
        if (r15 == null) goto L20;
        r14 = r15.findViewById(2131386129);
    L21:
        this.h = (WindowInsetsAdaptationFrameLayout) r14;
        goto L22
    L20:
        r14 = null;
    L22:
        r13.p((WindowInsetsAdaptationFrameLayout) r14);
        if (ForsetiHelper.s(this) == false) goto L26;
        r6.setOnClickListener(null);
        FragmentBackPressedHelperKt.a(this, new b(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561212, r3, false);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r4, int r5, KeyEvent r6) {
        if (r5 != 4) goto L12;
        if (r6 != null) goto L6;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L12;
        return back();
    L6:
        if (r6.getAction() != 0) goto L8;
        r2 = true;
    L12:
        if (r5 != 4) goto L20;
        if (r6 != null) goto L15;
    L17:
        boolean r7 = false;
    L18:
        if (r7 == false) goto L20;
        return true;
    L15:
        if (r6.getAction() != 1) goto L17;
        r7 = true;
    L20:
        return false;
    }
}
