package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.list.u4;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.mvp.IView;
import hi5.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements f {
    public final Context a;
    public final View b;
    public final Dialog c;
    public final String d;
    public final String e;
    public final ArrayList<UserInfo> f;
    public final int g;
    public final String h;
    public final int i;
    public final String j;
    public final String k;
    public final boolean l;
    public f.a m;
    public int n;
    public final boolean o;

    public static final class a implements y.a {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        @Override // hi5.y.a
        public final /* synthetic */ void QF() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            d r3 = this.a;
            f.a r0 = r3.m;
            if (r0 == null) goto L6;
            r0.W7(r3.e);
            return;
        }
    }

    public static final class b implements y.a {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        @Override // hi5.y.a
        public final /* synthetic */ void QF() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r13) {
            d r14 = this.a;
            Dialog r0 = r14.c;
            if (r0 == null) goto L5;
            r0.hide();
        L5:
            com.bytedance.ee.bear.widgets.a r1 = new com.bytedance.ee.bear.widgets.a(r14.a);
            CharSequence r2 = r14.a.getText(2131887806);
            rg5.c r3 = new rg5.c(r14);
            if (r14.n != 1) goto L8;
            boolean r4 = true;
        L9:
            int r5 = r14.k(r4);
            cp5.b r6 = new cp5.b();
            r6.a = r2;
            r6.d = false;
            r6.e = null;
            r6.f = r3;
            r6.c = false;
            r6.b = r5;
            r6.g = true;
            r6.h = 1.0f;
            r6.i = true;
            r1.f(r6);
            if (r14.i == 125) goto L16;
            CharSequence r7 = r14.a.getText(2131887750);
            rg5.d r8 = new rg5.d(r14);
            if (r14.n != 4) goto L14;
            boolean r9 = true;
        L15:
            int r10 = r14.k(r9);
            cp5.b r11 = new cp5.b();
            r11.a = r7;
            r11.d = false;
            r11.e = null;
            r11.f = r8;
            r11.c = false;
            r11.b = r10;
            r11.g = true;
            r11.h = 1.0f;
            r11.i = true;
            r1.f(r11);
        L17:
            r1.b(new rg5.e(r14));
            r1.p(new rg5.f(r14));
            r1.q();
            String r12 = r14.h;
            int r15 = r14.i;
            String r16 = r14.k;
            boolean r17 = r14.l;
            String r18 = r14.j;
            boolean r19 = r14.o;
            String r20 = com.bytedance.ee.bear.middleground.permission.c.a;
            Intrinsics.checkNotNullParameter(r12, ResourceData.KEY_TOKEN);
            Intrinsics.checkNotNullParameter(r16, "subType");
            Intrinsics.checkNotNullParameter(r18, "module");
            JSONObject r21 = new JSONObject();
            if (r19 == false) goto L21;
        L23:
            String r22 = "none";
        L24:
            String r23 = r22;
            if (r19 == false) goto L27;
            String r24 = "";
        L28:
            com.bytedance.ee.bear.middleground.permission.c.a(r21, r12, r15, r23, r16, r18, "", r24, com.bytedance.ee.bear.middleground.permission.c.b, r17);
            if (r19 == false) goto L31;
            String r110 = "im_card";
        L32:
            r21.put("from_scene", r110);
            com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_ask_owner_type_view", r21);
            return;
        L31:
            r110 = "add_collaborator";
            goto L32
        L27:
            r24 = com.bytedance.ee.bear.middleground.permission.c.a;
            goto L28
        L21:
            if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L23;
            r22 = ThumbGlideUrl.SOURCE_VC;
            goto L24
        L14:
            r9 = false;
            goto L15
        L16:
            tt5.a.h("AskOwnerView", "stage=role_options, obj_type=125, role_domain=bit, requested_role=1");
            goto L17
        L8:
            r4 = false;
            goto L9
        }
    }

    public final void destroy() {
    }

    public final void create() {
        TextView r0 = (TextView) this.b.findViewById(2131388772);
        if (this.o == false) goto L5;
        r0.setText(2131888074);
    L6:
        o();
        CharSequence r1 = xo5.a.c(this.a, 2131888076, "owner_name", this.d);
        ((SpaceEditText) this.b.findViewById(2131381012)).setHint(r1);
        Locale r2 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        AccountService.Account r3 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        Intrinsics.checkNotNull(r2);
        UserAdapter r4 = new UserAdapter(r2, r3, this.g);
        r4.setNewData(this.f);
        this.b.findViewById(2131375620).setAdapter(r4);
        this.b.findViewById(2131375620).setLayoutManager(new LinearLayoutManagerWrapper(this.a));
        ((Button) this.b.findViewById(2131385898)).setOnClickListener(new e(this));
        return;
    L5:
        r0.setText(2131888068);
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.f
    public final String getNotes() {
        Editable r0 = ((SpaceEditText) this.b.findViewById(2131381012)).getText();
        if (r0 == null) goto L6;
        String r1 = r0.toString();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public final void o() {
        String r0 = "@" + this.d;
        if (this.n != 1) goto L5;
        int r1 = 2131887806;
    L6:
        String r2 = this.a.getString(r1);
        if (this.o == false) goto L9;
        HashMap r3 = new HashMap();
        r3.put("name", r0);
        r3.put("permission_type", r2 + ' ');
        String r4 = xo5.a.d(this.a, com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(this.i, 2131888862, 2131888067), r3);
    L10:
        String r9 = r4;
        Intrinsics.checkNotNull(r9);
        int r5 = StringsKt.indexOf$default(r9, r0, 0, false, 6, null);
        int r6 = StringsKt.indexOf$default(r9, r2, 0, false, 6, null);
        SpannableString r7 = new SpannableString(r9);
        r7.setSpan(new y(this.a, new a(this)), r5, r0.length() + r5, 33);
        r7.setSpan(new y(this.a, new b(this)), r6, r2.length() + r6, 33);
        int r8 = r6 + r2.length();
        r7.setSpan(new rg5.a(this.a), r8, r8 + 1, 33);
        ((TextView) this.b.findViewById(2131388741)).setText(r7);
        ((TextView) this.b.findViewById(2131388741)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) this.b.findViewById(2131388741)).setHighlightColor(0);
        return;
    L9:
        HashMap r10 = new HashMap();
        r10.put("name", r0);
        r10.put("permission_type", r2 + ' ');
        u4 r11 = u4.a;
        Context r12 = this.a;
        int r13 = this.i;
        r11.getClass();
        r10.put("doc_type", u4.a(r12, r13));
        r4 = xo5.a.d(this.a, 2131887100, r10);
        goto L10
    L5:
        r1 = 2131887750;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.f
    public final int q1() {
        return this.n;
    }

    public final int k(boolean r4) {
        int r0 = this.a.getResources().getColor(2131105548);
        int r1 = this.a.getResources().getColor(2131106622);
        if (r4 == false) goto L6;
        return r0;
    L6:
        return r1;
    }

    public final void setViewDelegate(IView.IViewDelegate r1) {
        this.m = (f.a) r1;
    }

    public static final void h(d r12, int r13) {
        String r1 = r12.h;
        int r2 = r12.i;
        String r4 = r12.k;
        boolean r9 = r12.l;
        String r5 = r12.j;
        boolean r14 = r12.o;
        String r0 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "subType");
        Intrinsics.checkNotNullParameter(r5, "module");
        JSONObject r10 = new JSONObject();
        if (r14 == false) goto L6;
    L8:
        String r3 = "none";
    L9:
        if (r14 == false) goto L11;
        String r6 = "";
    L12:
        com.bytedance.ee.bear.middleground.permission.c.a(r10, r1, r2, r3, r4, r5, "", r6, com.bytedance.ee.bear.middleground.permission.c.b, r9);
        if (r13 != 1) goto L15;
        String r15 = "read";
    L19:
        r10.put("click", r15);
        if (r14 == false) goto L22;
        String r16 = "im_card";
    L23:
        r10.put("from_scene", r16);
        r10.put("target", "none");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_ask_owner_type_click", r10);
        return;
    L22:
        r16 = "add_collaborator";
        goto L23
    L15:
        if (r13 == 4) goto L17;
        r15 = DocFeed$Value$Result.CANCEL;
        goto L19
    L17:
        r15 = "edit";
        goto L19
    L11:
        r6 = com.bytedance.ee.bear.middleground.permission.c.a;
        goto L12
    L6:
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L8;
        r3 = ThumbGlideUrl.SOURCE_VC;
        goto L9
    }

    public d(Context r2, View r3, Dialog r4, String r5, String r6, ArrayList<UserInfo> r7, int r8, String r9, int r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r5, "ownerName");
        Intrinsics.checkNotNullParameter(r6, "ownerId");
        Intrinsics.checkNotNullParameter(r7, "invitedUsers");
        Intrinsics.checkNotNullParameter(r9, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r11, "module");
        Intrinsics.checkNotNullParameter(r12, "subType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        boolean r14 = true;
        this.n = 1;
        if (r8 == 2) goto L6;
        r14 = false;
    L6:
        this.o = r14;
    }
}
