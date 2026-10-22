package com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.list.u4;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.q;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f233374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f233375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f233376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a.InterfaceC3341a f233377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q f233378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InviteMemberSendLinkAdapter f233379f;

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        tt5.a.h("InviteMemberSendLinkView", "create()...");
        InviteMemberSendLinkAdapter r100 = null;
        Locale r101 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        AccountService$Account r102 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNull(r102);
        InviteMemberSendLinkAdapter r103 = new InviteMemberSendLinkAdapter(r101, r102);
        this.f233379f = r103;
        r103.f233164c = new h(this);
        ((RecyclerView) this.f233375b.findViewById(R.id.usersRv)).setLayoutManager(new LinearLayoutManagerWrapper(this.f233374a));
        RecyclerView r104 = (RecyclerView) this.f233375b.findViewById(R.id.usersRv);
        InviteMemberSendLinkAdapter r105 = this.f233379f;
        if (r105 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L6:
        r104.setAdapter(r100);
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L9;
        int r106 = R.string.LarkCCM_Docs_Doubao_ShareLeaveNote_Placeholder;
    L10:
        ((SpaceEditText) this.f233375b.findViewById(R.id.notesInput)).setHint(ContextCompat.getString(this.f233374a, com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(this.f233376c, R.string.LarkCCM_ChatShare_AddNote_Placeholder, r106)));
        this.f233375b.setOnTouchListener(yg5.c.f567500a);
        ((ImageView) this.f233375b.findViewById(R.id.titleBackIcon)).setOnClickListener(new e(this));
        ((TextView) this.f233375b.findViewById(R.id.sendLinkTv)).setOnClickListener(new f(this));
        ((TextView) this.f233375b.findViewById(R.id.askOwnerTv)).setOnClickListener(new g(this));
        return;
    L9:
        r106 = R.string.Doc_Permission_AddUserAddNotesHint;
        goto L10
    L5:
        r100 = r105;
        goto L6
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        tt5.a.h("InviteMemberSendLinkView", "destroy()...");
        this.f233378e.a();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a
    public final String getNotes() {
        Editable r100 = ((SpaceEditText) this.f233375b.findViewById(R.id.notesInput)).getText();
        if (r100 == null) goto L6;
        String r101 = r100.toString();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final void h() {
        InviteMemberSendLinkAdapter r100 = this.f233379f;
        Object r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r100 = null;
    L5:
        Iterator r102 = CollectionsKt.asSequence(r100.getData()).iterator();
    L6:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L14;
        Object r104 = r102.next();
        if (((UserInfo) r104).getOwnerType() != 18) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L6;
        r101 = r104;
        goto L14
    L11:
        r105 = false;
    L14:
        if (r101 == null) goto L16;
        r103 = true;
    L16:
        u4 r106 = u4.f229807a;
        Context r107 = this.f233374a;
        int r108 = this.f233376c;
        r106.getClass();
        String r109 = u4.a(r107, r108);
        HashMap r110 = new HashMap();
        r110.put("doc_type", r109);
        if (r103 == false) goto L19;
        r110.put("bot", this.f233374a.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.a(this.f233376c)));
        String r111 = xo5.a.d(this.f233374a, R.string.Doc_Permission_SendLinkWithDepTips_AddVariable, r110);
    L20:
        UDNotice r112 = (UDNotice) this.f233375b.findViewById(R.id.bannerTipsLayout);
        Intrinsics.checkNotNull(r111);
        r112.setText(r111);
        return;
    L19:
        r111 = xo5.a.d(this.f233374a, R.string.Doc_Permission_SendLinkTips_AddVariable, r110);
        goto L20
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a
    public final void F(ArrayList<UserInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "users");
        InviteMemberSendLinkAdapter r101 = this.f233379f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r101 = null;
    L5:
        r101.setNewData(r100);
        h();
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f233377d = (com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a.InterfaceC3341a) r100;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a
    public final void showLoading(boolean r100) {
        if (r100 == false) goto L4;
        this.f233378e.e();
        return;
    L4:
        this.f233378e.a();
    }

    public d(Context r100, View r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        this.f233374a = r100;
        this.f233375b = r101;
        this.f233376c = r102;
        this.f233378e = new q(r100);
    }
}
