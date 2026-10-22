package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService$Account;
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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class InviteMemberAskOwnerView implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f233198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f233199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DocPermSetInfo f233200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UserInfo f233201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b.a f233202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q f233203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BaseInviteCollaboratorManageAdapter f233204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public vi5.a f233205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f233206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f233207j;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        tt5.a.h("InviteMemberAskOwnerView", "create()...");
        String r100 = null;
        AccountService$Account r101 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        DocumentInviteCollaboratorManageAdapter r102 = new DocumentInviteCollaboratorManageAdapter((Locale) this.f233207j.getValue(), r101);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f233204g = r102;
        BaseInviteCollaboratorManageAdapter r103 = h();
        r103.f233164c = new n(this);
        ((RecyclerView) this.f233199b.findViewById(R.id.usersRv)).setLayoutManager(new LinearLayoutManagerWrapper(this.f233198a));
        ((RecyclerView) this.f233199b.findViewById(R.id.usersRv)).setAdapter(h());
        String r104 = this.f233201d.getDisplayName((Locale) this.f233207j.getValue());
        boolean r105 = false;
        if (r104 != null) goto L5;
    L8:
        boolean r106 = true;
    L10:
        if (r106 == false) goto L12;
        tt5.a.h("InviteMemberAskOwnerView", "initView, ownerName is null or empty, notesHint using fallback");
        String r107 = this.f233198a.getString(R.string.LarkCCM_Docs_NoteForOwner_NoName_Placeholder);
    L27:
        Intrinsics.checkNotNull(r107);
        ((SpaceEditText) this.f233199b.findViewById(R.id.notesInput)).setHint(r107);
        this.f233199b.setOnTouchListener(k.f233233a);
        ((ImageView) this.f233199b.findViewById(R.id.titleBackIcon)).setOnClickListener(new l(this));
        ((TextView) this.f233199b.findViewById(R.id.askOwnerTv)).setOnClickListener(new m(this));
        return;
    L12:
        String r108 = xo5.a.c(this.f233198a, R.string.Doc_Permission_AskOwner_placeholder, "owner_name", r104);
        if (r108 != null) goto L15;
    L26:
        String r109 = this.f233198a.getString(R.string.LarkCCM_Docs_NoteForOwner_NoName_Placeholder);
        tt5.a.h("InviteMemberAskOwnerView", "initView, ownerName is not empty, but mustacheFormat failed, notesHint using fallback");
        r107 = r109;
        goto L27
    L15:
        if (r108.length() <= 0) goto L17;
        boolean r110 = true;
    L18:
        if (r110 == true) goto L20;
    L22:
        if (r105 == false) goto L24;
        r100 = r108;
    L24:
        if (r100 == null) goto L26;
        r107 = r100;
        goto L27
    L20:
        if (Intrinsics.areEqual(r108, this.f233198a.getString(R.string.Doc_Permission_AskOwner_placeholder)) == true) goto L22;
        r105 = true;
        goto L22
    L17:
        r110 = false;
        goto L18
    L5:
        if (r104.length() == 0) goto L8;
        r106 = false;
        goto L10
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        tt5.a.h("InviteMemberAskOwnerView", "destroy()...");
        this.f233203f.a();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b
    public final String getNotes() {
        Editable r100 = ((SpaceEditText) this.f233199b.findViewById(R.id.notesInput)).getText();
        if (r100 == null) goto L6;
        String r101 = r100.toString();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final BaseInviteCollaboratorManageAdapter h() {
        BaseInviteCollaboratorManageAdapter r100 = this.f233204g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    public final void p() {
        String r100 = this.f233201d.getDisplayName((Locale) this.f233207j.getValue());
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        if (r100.length() != 0) goto L8;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        tt5.a.k("InviteMemberAskOwnerView", "owner name is empty, hide banner");
        ((UDNotice) this.f233199b.findViewById(R.id.bannerTipsLayout)).setVisibility(8);
        return;
    L13:
        ((UDNotice) this.f233199b.findViewById(R.id.bannerTipsLayout)).setVisibility(0);
        u4 r102 = u4.f229807a;
        Context r103 = this.f233198a;
        int r104 = this.f233200c.getType();
        r102.getClass();
        String r105 = u4.a(r103, r104);
        HashMap r106 = new HashMap();
        r106.put("name", "@".concat(r100));
        r106.put("doc_type", r105);
        Iterator r107 = CollectionsKt.asSequence(h().getData()).iterator();
    L15:
        if (r107.hasNext() == false) goto L22;
        Object r108 = r107.next();
        if (((UserInfo) r108).getOwnerType() != 18) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L15;
    L23:
        if (r108 == null) goto L25;
        ((UDNotice) this.f233199b.findViewById(R.id.bannerTipsLayout)).setType(UDNotice.Type.WARNING);
        ((UDNotice) this.f233199b.findViewById(R.id.bannerTipsLayout)).setIcon(R.drawable.ud_icon_warning_hollow_filled);
        r106.put("bot", this.f233198a.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.a(this.f233200c.getType())));
        String r110 = xo5.a.d(this.f233198a, R.string.CreatinoMobile_Minutes_share_depart_dialog, r106);
    L26:
        String r111 = r110;
        UDNotice r112 = (UDNotice) this.f233199b.findViewById(R.id.bannerTipsLayout);
        Intrinsics.checkNotNull(r111);
        r112.setText(r111);
        int r113 = StringsKt.indexOf$default(r111, "@", 0, false, 6, null);
        ((UDNotice) this.f233199b.findViewById(R.id.bannerTipsLayout)).S5(r113, (r113 + 1) + r100.length(), new o(this));
        return;
    L25:
        ((UDNotice) this.f233199b.findViewById(R.id.bannerTipsLayout)).setType(UDNotice.Type.INFO);
        ((UDNotice) this.f233199b.findViewById(R.id.bannerTipsLayout)).setIcon(R.drawable.ud_icon_info_hollow_filled);
        r110 = xo5.a.d(this.f233198a, R.string.Doc_Permission_AskOwnerToShare_AddVariable, r106);
        goto L26
    L19:
        r109 = false;
        goto L20
    L22:
        r108 = null;
        goto L23
    L8:
        r101 = false;
        goto L10
    }

    public final Context getContext() {
        return this.f233198a;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b
    public final void F(ArrayList<UserInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "users");
        h().setNewData(r100);
        p();
    }

    public final void k(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        tt5.a.h("InviteMemberAskOwnerView", "onClickRemovePermission()...position = " + this.f233206i);
        com.bytedance.ee.bear.middleground.permission.c.k(r100, 0);
        b.a r101 = this.f233202e;
        if (r101 == null) goto L5;
        r101.Y(this.f233206i, r100);
    L5:
        h().notifyItemRemoved(this.f233206i);
        vi5.a r102 = this.f233205h;
        if (r102 == null) goto L8;
        r102.b();
    L8:
        p();
    }

    public final void o(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        tt5.a.h("InviteMemberAskOwnerView", "onClickSetCanRead()...position = " + this.f233206i);
        com.bytedance.ee.bear.middleground.permission.c.k(r100, 1);
        r100.setPermission(1);
        h().notifyItemChanged(this.f233206i);
        vi5.a r101 = this.f233205h;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f233202e = (b.a) r100;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b
    public final void showLoading(boolean r100) {
        if (r100 == false) goto L4;
        this.f233203f.e();
        return;
    L4:
        this.f233203f.a();
    }

    public InviteMemberAskOwnerView(Context r100, View r101, DocPermSetInfo r102, UserInfo r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r102, "permSetInfo");
        Intrinsics.checkNotNullParameter(r103, "ownerInfo");
        this.f233198a = r100;
        this.f233199b = r101;
        this.f233200c = r102;
        this.f233201d = r103;
        this.f233203f = new q(r100);
        this.f233207j = LazyKt.lazy(InviteMemberAskOwnerView$locale$2.INSTANCE);
    }
}
