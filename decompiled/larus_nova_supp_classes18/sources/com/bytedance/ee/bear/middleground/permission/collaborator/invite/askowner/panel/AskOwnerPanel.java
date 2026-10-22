package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0002J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001fH\u0002J\b\u0010(\u001a\u00020\u001aH\u0016J\b\u0010)\u001a\u00020\u001aH\u0016J\b\u0010*\u001a\u00020\u001aH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/askowner/panel/AskOwnerPanel;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/askowner/panel/AskOwnerPresenter$Dependency;", "<init>", "()V", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "", "ownerId", "ownerName", "invitedUserList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/share/export/UserInfo;", "Lkotlin/collections/ArrayList;", "from", "module", "subType", "fromVC", "", "isWiki", "userPerm", "publicPerm", "presenter", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/askowner/panel/AskOwnerPresenter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initData", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initMVP", "rootView", "onStart", "onDestroyView", "close", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AskOwnerPanel extends BaseAntiScreenshotsDialogFragment implements com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a.b {
    public static final /* synthetic */ int r = 0;
    public String h;
    public int i;
    public String j;
    public String k;
    public ArrayList<UserInfo> l;
    public int m;
    public String n;
    public String o;
    public boolean p;
    public com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a q;

    public static final class a {
        @JvmStatic
        public static void a(FragmentActivity r2, String r3, int r4, String r5, String r6, ArrayList r7, int r8, String r9, String r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r5, "ownerId");
            Intrinsics.checkNotNullParameter(r6, "ownerName");
            Intrinsics.checkNotNullParameter(r7, "invitedUserList");
            Intrinsics.checkNotNullParameter(r9, "module");
            Intrinsics.checkNotNullParameter(r10, "subType");
            Bundle r0 = new Bundle();
            r0.putString("extra_token", r3);
            r0.putInt("extra_type", r4);
            r0.putString("extra_owner_id", r5);
            r0.putString("extra_owner_name", r6);
            r0.putSerializable("extra_invited_user_list", r7);
            r0.putInt("extra_from", r8);
            r0.putString("extra_module", r9);
            r0.putString("extra_sub_type", r10);
            r0.putBoolean("extra_is_wiki", r11);
            Fragment r12 = Fragment.instantiate(r2, AskOwnerPanel.class.getName(), r0);
            Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
            Fragment r13 = (DialogFragment) r12;
            FragmentManager r14 = r2.getSupportFragmentManager();
            String r15 = AskOwnerPanel.class.getName();
            if ((r13 instanceof Fragment) == false) goto L5;
            Fragment r16 = r13;
        L6:
            LandscapeRestrictionOperation r17 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r16, r15, r17);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r14, r16, r17) == true) goto L15;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L10:
            r13.show(r14, r15);
            return;
        L15:
            return;
        L5:
            r16 = null;
            goto L6
        }
    }

    static {
    }

    public AskOwnerPanel() {
        this.i = sbb.e.g.b;
        this.m = 1;
        this.o = "";
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a.b
    public final void close() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = DialogFragmentLancet.sLastShowStack;
        if (r0 == null) goto L11;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a r0 = this.q;
        if (r0 == null) goto L6;
        r0.destroy();
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L9;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.height = -2;
        r2.softInputMode = 16;
        r2.gravity = 80;
        r1.setAttributes(r2);
        r1.setDimAmount(0.2f);
        r1.setWindowAnimations(2131951620);
        r1.setBackgroundDrawableResource(R.color.transparent);
        TypedValue r3 = new TypedValue();
        getResources().getValue(2131168390, r3, true);
        r1.setDimAmount(r3.getFloat());
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        Bundle r5 = getArguments();
        String r0 = "";
        if (r5 == null) goto L6;
        String r6 = r5.getString("extra_token", "");
        if (r6 == null) goto L6;
    L7:
        this.h = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L10;
        int r8 = r7.getInt("extra_type", this.i);
    L11:
        this.i = r8;
        Bundle r9 = getArguments();
        if (r9 == null) goto L15;
        String r10 = r9.getString("extra_owner_id", "");
        if (r10 == null) goto L15;
    L16:
        this.j = r10;
        Bundle r11 = getArguments();
        if (r11 == null) goto L20;
        String r12 = r11.getString("extra_owner_name", "");
        if (r12 == null) goto L20;
    L21:
        this.k = r12;
        Bundle r13 = getArguments();
        if (r13 == null) goto L24;
        Serializable r14 = r13.getSerializable("extra_invited_user_list");
    L25:
        if (r14 != null) goto L27;
        ArrayList<UserInfo> r15 = new ArrayList();
    L28:
        this.l = r15;
        Bundle r16 = getArguments();
        if (r16 == null) goto L31;
        int r17 = r16.getInt("extra_from", this.m);
    L32:
        this.m = r17;
        Bundle r18 = getArguments();
        if (r18 == null) goto L36;
        String r19 = r18.getString("extra_module", "");
        if (r19 == null) goto L36;
    L37:
        this.n = r19;
        Bundle r20 = getArguments();
        if (r20 == null) goto L43;
        String r21 = r20.getString("extra_sub_type", "");
        if (r21 == null) goto L43;
        r0 = r21;
    L43:
        this.o = r0;
        Bundle r22 = getArguments();
        boolean r1 = false;
        if (r22 == null) goto L46;
        r1 = r22.getBoolean("extra_is_wiki", false);
    L46:
        this.p = r1;
        return;
    L36:
        r19 = "";
        goto L37
    L31:
        r17 = this.m;
        goto L32
    L27:
        r15 = (ArrayList) r14;
        goto L28
    L24:
        r14 = null;
    L20:
        r12 = "";
    L15:
        r10 = "";
        goto L16
    L10:
        r8 = this.i;
    L6:
        r6 = "";
        goto L7
    }

    public final void onViewCreated(View r23, Bundle r24) {
        Intrinsics.checkNotNullParameter(r23, "view");
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r23, r24);
        String r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(ResourceData.KEY_TOKEN);
        r0 = null;
    L5:
        int r1 = this.i;
        ArrayList<UserInfo> r2 = this.l;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("invitedUserList");
        r2 = null;
    L8:
        rg5.b r15 = new rg5.b(r0, r1, r2);
        Context r3 = getContext();
        Intrinsics.checkNotNull(r3);
        Dialog r4 = getDialog();
        String r5 = this.k;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ownerName");
        String r6 = null;
    L12:
        String r7 = this.j;
        if (r7 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("ownerId");
        String r8 = null;
    L16:
        ArrayList<UserInfo> r9 = this.l;
        if (r9 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("invitedUserList");
        ArrayList<UserInfo> r10 = null;
    L20:
        int r11 = this.m;
        String r12 = this.h;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException(ResourceData.KEY_TOKEN);
        String r13 = null;
    L24:
        int r14 = this.i;
        String r16 = this.n;
        if (r16 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("module");
        String r17 = null;
    L28:
        d r18 = new d(r3, r23, r4, r6, r8, r10, r11, r13, r14, r17, this.o, this.p);
        Context r19 = getContext();
        Intrinsics.checkNotNull(r19);
        String r20 = this.k;
        if (r20 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("ownerName");
        String r21 = null;
    L32:
        String r22 = this.h;
        if (r22 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException(ResourceData.KEY_TOKEN);
        String r25 = null;
    L36:
        int r26 = this.i;
        String r27 = this.n;
        if (r27 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("module");
        String r28 = null;
    L40:
        int r29 = this.m;
        ArrayList<UserInfo> r30 = this.l;
        if (r30 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("invitedUserList");
        ArrayList<UserInfo> r110 = null;
    L44:
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a r111 = new com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a(r19, r15, r18, this, r21, r25, r26, r28, r29, r110, this.o, this.p);
        this.q = r111;
        r111.create();
        zo5.b r31 = (zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6);
        String r112 = this.h;
        if (r112 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException(ResourceData.KEY_TOKEN);
        r112 = null;
    L47:
        r31.h(r112, this.i);
        r31.p((FrameLayout) r23.findViewById(2131367794));
        return;
    L43:
        r110 = r30;
        goto L44
    L39:
        r28 = r27;
        goto L40
    L35:
        r25 = r22;
        goto L36
    L31:
        r21 = r20;
        goto L32
    L27:
        r17 = r16;
        goto L28
    L23:
        r13 = r12;
        goto L24
    L19:
        r10 = r9;
        goto L20
    L15:
        r8 = r7;
        goto L16
    L11:
        r6 = r5;
        goto L12
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131564178, r3, false);
    }
}
