package com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.list.u4;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.q;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larksuite.framework.mvp.IView;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a {
    public final Context a;
    public final View b;
    public final int c;
    public com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a.InterfaceC0094a d;
    public final q e;
    public InviteMemberSendLinkAdapter f;

    public static final class a {
    }

    static {
    }

    public final void create() {
        tt5.a.h("InviteMemberSendLinkView", "create()...");
        RecyclerView.Adapter r1 = null;
        Locale r0 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        AccountService.Account r2 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        Intrinsics.checkNotNull(r0);
        Intrinsics.checkNotNull(r2);
        InviteMemberSendLinkAdapter r3 = new InviteMemberSendLinkAdapter(r0, r2);
        this.f = r3;
        r3.c = new h(this);
        this.b.findViewById(2131392083).setLayoutManager(new LinearLayoutManagerWrapper(this.a));
        RecyclerView r4 = this.b.findViewById(2131392083);
        RecyclerView.Adapter r5 = this.f;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L6:
        r4.setAdapter(r1);
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L9;
        int r6 = 2131889048;
    L10:
        ((SpaceEditText) this.b.findViewById(2131381012)).setHint(ContextCompat.getString(this.a, com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(this.c, 2131888859, r6)));
        this.b.setOnTouchListener(yg5.c.a);
        ((ImageView) this.b.findViewById(2131388774)).setOnClickListener(new e(this));
        ((TextView) this.b.findViewById(2131385894)).setOnClickListener(new f(this));
        ((TextView) this.b.findViewById(2131363251)).setOnClickListener(new g(this));
        return;
    L9:
        r6 = 2131888040;
        goto L10
    L5:
        r1 = r5;
        goto L6
    }

    public final void destroy() {
        tt5.a.h("InviteMemberSendLinkView", "destroy()...");
        this.e.a();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a
    public final String getNotes() {
        Editable r0 = ((SpaceEditText) this.b.findViewById(2131381012)).getText();
        if (r0 == null) goto L6;
        String r1 = r0.toString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final void h() {
        InviteMemberSendLinkAdapter r0 = this.f;
        Object r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L5:
        Iterator r2 = CollectionsKt.asSequence(r0.getData()).iterator();
    L6:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L14;
        Object r4 = r2.next();
        if (((UserInfo) r4).getOwnerType() != 18) goto L11;
        boolean r5 = true;
    L12:
        if (r5 == false) goto L6;
        r1 = r4;
        goto L14
    L11:
        r5 = false;
    L14:
        if (r1 == null) goto L16;
        r3 = true;
    L16:
        u4 r6 = u4.a;
        Context r7 = this.a;
        int r8 = this.c;
        r6.getClass();
        String r9 = u4.a(r7, r8);
        HashMap r10 = new HashMap();
        r10.put("doc_type", r9);
        if (r3 == false) goto L19;
        r10.put("bot", this.a.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.a(this.c)));
        String r11 = xo5.a.d(this.a, 2131888122, r10);
    L20:
        UDNotice r12 = this.b.findViewById(2131363916);
        Intrinsics.checkNotNull(r11);
        r12.setText(r11);
        return;
    L19:
        r11 = xo5.a.d(this.a, 2131888121, r10);
        goto L20
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a
    public final void F(ArrayList<UserInfo> r2) {
        Intrinsics.checkNotNullParameter(r2, "users");
        InviteMemberSendLinkAdapter r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r0 = null;
    L5:
        r0.setNewData(r2);
        h();
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.d = (com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a.InterfaceC0094a) r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a
    public final void showLoading(boolean r1) {
        if (r1 == false) goto L4;
        this.e.e();
        return;
    L4:
        this.e.a();
    }

    public d(Context r2, View r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = new q(r2);
    }
}
