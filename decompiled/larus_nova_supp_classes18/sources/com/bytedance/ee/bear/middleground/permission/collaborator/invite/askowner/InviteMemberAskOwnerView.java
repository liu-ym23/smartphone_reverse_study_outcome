package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.list.u4;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.DocumentInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.q;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class InviteMemberAskOwnerView implements b {
    public final Context a;
    public final View b;
    public final DocPermSetInfo c;
    public final UserInfo d;
    public b.a e;
    public final q f;
    public BaseInviteCollaboratorManageAdapter g;
    public vi5.a h;
    public int i;
    public final Lazy j;

    public static final class a {
    }

    static {
    }

    public final void create() {
        tt5.a.h("InviteMemberAskOwnerView", "create()...");
        CharSequence r3 = null;
        AccountService.Account r1 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        DocumentInviteCollaboratorManageAdapter r2 = new DocumentInviteCollaboratorManageAdapter((Locale) this.j.getValue(), r1);
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.g = r2;
        BaseInviteCollaboratorManageAdapter r4 = h();
        r4.c = new n(this);
        this.b.findViewById(2131392083).setLayoutManager(new LinearLayoutManagerWrapper(this.a));
        this.b.findViewById(2131392083).setAdapter(h());
        String r5 = this.d.getDisplayName((Locale) this.j.getValue());
        boolean r6 = false;
        if (r5 != null) goto L5;
    L8:
        boolean r7 = true;
    L10:
        if (r7 == false) goto L12;
        tt5.a.h("InviteMemberAskOwnerView", "initView, ownerName is null or empty, notesHint using fallback");
        CharSequence r0 = this.a.getString(2131889184);
    L27:
        Intrinsics.checkNotNull(r0);
        ((SpaceEditText) this.b.findViewById(2131381012)).setHint(r0);
        this.b.setOnTouchListener(k.a);
        ((ImageView) this.b.findViewById(2131388774)).setOnClickListener(new l(this));
        ((TextView) this.b.findViewById(2131363251)).setOnClickListener(new m(this));
        return;
    L12:
        String r8 = xo5.a.c(this.a, 2131888076, "owner_name", r5);
        if (r8 != null) goto L15;
    L26:
        CharSequence r9 = this.a.getString(2131889184);
        tt5.a.h("InviteMemberAskOwnerView", "initView, ownerName is not empty, but mustacheFormat failed, notesHint using fallback");
        r0 = r9;
        goto L27
    L15:
        if (r8.length() <= 0) goto L17;
        boolean r10 = true;
    L18:
        if (r10 == true) goto L20;
    L22:
        if (r6 == false) goto L24;
        r3 = r8;
    L24:
        if (r3 == null) goto L26;
        r0 = r3;
        goto L27
    L20:
        if (Intrinsics.areEqual(r8, this.a.getString(2131888076)) == true) goto L22;
        r6 = true;
        goto L22
    L17:
        r10 = false;
        goto L18
    L5:
        if (r5.length() == 0) goto L8;
        r7 = false;
        goto L10
    }

    public final void destroy() {
        tt5.a.h("InviteMemberAskOwnerView", "destroy()...");
        this.f.a();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b
    public final String getNotes() {
        Editable r0 = ((SpaceEditText) this.b.findViewById(2131381012)).getText();
        if (r0 == null) goto L6;
        String r1 = r0.toString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final BaseInviteCollaboratorManageAdapter h() {
        BaseInviteCollaboratorManageAdapter r0 = this.g;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    public final void p() {
        String r0 = this.d.getDisplayName((Locale) this.j.getValue());
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (r0.length() != 0) goto L8;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        tt5.a.k("InviteMemberAskOwnerView", "owner name is empty, hide banner");
        this.b.findViewById(2131363916).setVisibility(8);
        return;
    L13:
        this.b.findViewById(2131363916).setVisibility(0);
        u4 r2 = u4.a;
        Context r5 = this.a;
        int r6 = this.c.getType();
        r2.getClass();
        String r3 = u4.a(r5, r6);
        HashMap r7 = new HashMap();
        r7.put("name", "@".concat(r0));
        r7.put("doc_type", r3);
        Iterator r4 = CollectionsKt.asSequence(h().getData()).iterator();
    L15:
        if (r4.hasNext() == false) goto L22;
        Object r8 = r4.next();
        if (((UserInfo) r8).getOwnerType() != 18) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == false) goto L15;
    L23:
        if (r8 == null) goto L25;
        this.b.findViewById(2131363916).setType(UDNotice.Type.WARNING);
        this.b.findViewById(2131363916).setIcon(2131256187);
        r7.put("bot", this.a.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.a(this.c.getType())));
        String r10 = xo5.a.d(this.a, 2131887099, r7);
    L26:
        String r11 = r10;
        UDNotice r12 = this.b.findViewById(2131363916);
        Intrinsics.checkNotNull(r11);
        r12.setText(r11);
        int r13 = StringsKt.indexOf$default(r11, "@", 0, false, 6, null);
        this.b.findViewById(2131363916).S5(r13, (r13 + 1) + r0.length(), new o(this));
        return;
    L25:
        this.b.findViewById(2131363916).setType(UDNotice.Type.INFO);
        this.b.findViewById(2131363916).setIcon(2131254920);
        r10 = xo5.a.d(this.a, 2131888075, r7);
        goto L26
    L19:
        r9 = false;
        goto L20
    L22:
        r8 = null;
        goto L23
    L8:
        r1 = false;
        goto L10
    }

    public final Context getContext() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b
    public final void F(ArrayList<UserInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "users");
        h().setNewData(r2);
        p();
    }

    public final void k(UserInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "userInfo");
        tt5.a.h("InviteMemberAskOwnerView", "onClickRemovePermission()...position = " + this.i);
        com.bytedance.ee.bear.middleground.permission.c.k(r3, 0);
        b.a r0 = this.e;
        if (r0 == null) goto L5;
        r0.Y(this.i, r3);
    L5:
        h().notifyItemRemoved(this.i);
        vi5.a r4 = this.h;
        if (r4 == null) goto L8;
        r4.b();
    L8:
        p();
    }

    public final void o(UserInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "userInfo");
        tt5.a.h("InviteMemberAskOwnerView", "onClickSetCanRead()...position = " + this.i);
        com.bytedance.ee.bear.middleground.permission.c.k(r3, 1);
        r3.setPermission(1);
        h().notifyItemChanged(this.i);
        vi5.a r4 = this.h;
        if (r4 == null) goto L6;
        r4.b();
        return;
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.e = (b.a) r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b
    public final void showLoading(boolean r1) {
        if (r1 == false) goto L4;
        this.f.e();
        return;
    L4:
        this.f.a();
    }

    public InviteMemberAskOwnerView(Context r2, View r3, DocPermSetInfo r4, UserInfo r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r4, "permSetInfo");
        Intrinsics.checkNotNullParameter(r5, "ownerInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.f = new q(r2);
        this.j = LazyKt.lazy(InviteMemberAskOwnerView$locale$2.INSTANCE);
    }
}
