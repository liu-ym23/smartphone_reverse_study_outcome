package vg5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.DocumentInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tg5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class g extends tg5.b {
    public final Context k;
    public final View l;
    public final DocPermSetInfo m;
    public int n;
    public vi5.a o;

    public static final class a {
    }

    public static final class b implements BaseInviteCollaboratorManageAdapter.a {
        public final /* synthetic */ g a;

        public b(g r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter.a
        public final void a(UserInfo r21, int r22) {
            g r2 = this.a;
            r2.n = r22;
            if (r2.o != null) goto L5;
            r2.o = new vi5.a(r2.k);
        L5:
            vi5.a r3 = this.a.o;
            if (r3 == null) goto L74;
            Intrinsics.checkNotNull(r21);
            DocPermSetInfo r5 = this.a.m;
            String r6 = r5.c;
            int r7 = r5.getType();
            g r8 = this.a;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r21, "userInfo");
            if (r8.m.getType() != 44) goto L10;
            boolean r9 = true;
        L12:
            if (r8.u6() == false) goto L15;
            if (r9 == true) goto L15;
            boolean r10 = true;
        L16:
            if (r10 == false) goto L18;
            boolean r11 = r8.m.f.a.canInviteFullAccess();
        L19:
            boolean r12 = r11;
            if (r10 == false) goto L22;
            boolean r13 = r8.m.f.a.canInviteEdit();
        L23:
            if (r10 == false) goto L25;
            boolean r14 = r8.m.f.a.canInviteView();
        L27:
            if (r8.m.getType() != 125) goto L33;
            tt5.a.h("DocInviteMemberManagerView", "stage=role_options, obj_type=125, role_domain=bit, requested_role=1");
            vi5.d r15 = new vi5.d(r8.k);
            if (r21.getPermission() != 1) goto L31;
            boolean r16 = true;
        L32:
            vi5.d.d(r15, r16, r14, new h(r8, r21));
            r15.a(new i(r8, r21));
            ArrayList<vi5.c> r17 = r15.b;
            vi5.a r0 = r3;
            int r4 = r7;
            String r18 = r6;
        L73:
            r0.c(r21, r18, r4, r17);
            goto L74
        L31:
            r16 = false;
            goto L32
        L33:
            DocUserPermission.a r19 = DocUserPermission.Companion;
            int r110 = r21.getPermission();
            r19.getClass();
            boolean r111 = DocUserPermission.a.a(r110);
            if ((r21.getPermission() & 4) == 0) goto L36;
            boolean r112 = true;
        L38:
            if ((r21.getPermission() & 1) == 0) goto L40;
            boolean r113 = true;
        L42:
            if (r21.getOwnerType() == 29) goto L44;
            boolean r114 = true;
        L46:
            if (r21.getOwnerType() == 29) goto L48;
            boolean r20 = true;
        L49:
            DocPermSetInfo r23 = r8.m;
            boolean r1 = r23.d;
            boolean r24 = r23.a();
            tt5.a.h("DocInviteMemberManagerView", "canUserFa: " + r12 + ", canUserEdit: " + r13 + ", canMemberEdit:" + r112 + ", canMemberFa:" + r111 + ", canMemberRead:" + r113 + ", canShowEdit:" + r20 + ", canShowFa:" + r114 + ", wiki2enable:" + r1 + ", isDocV2: " + r24);
            vi5.d r25 = new vi5.d(r8.k);
            if (r114 == false) goto L63;
            if (r1 == true) goto L62;
            if (r24 == true) goto L62;
            if (r8.m.getType() == 28) goto L62;
            if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == true) goto L58;
        L60:
            boolean r26 = false;
        L61:
            if (r26 == false) goto L63;
        L58:
            if (sbb.g.a(r8.m.getType()) == false) goto L60;
            r26 = true;
        L62:
            boolean r27 = true;
        L64:
            boolean r28 = r113;
            r25.c(r27, r12, r111, r8.m.d, new j(r8, r21));
            r25.b(r112, r13, new k(r8, r21), r20);
            if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == true) goto L67;
        L69:
            boolean r29 = false;
        L70:
            if (r29 == true) goto L72;
            vi5.d.d(r25, r28, r14, new l(r8, r21));
        L72:
            r25.a(new m(r8, r21));
            r17 = r25.b;
            r0 = r3;
            r4 = r7;
            r18 = r6;
            goto L73
        L67:
            if (sbb.g.a(r8.m.getType()) == false) goto L69;
            r29 = true;
        L63:
            r27 = false;
            goto L64
        L48:
            r20 = false;
            goto L49
        L44:
            r114 = false;
            goto L46
        L40:
            r113 = false;
            goto L42
        L36:
            r112 = false;
            goto L38
        L25:
            r14 = r8.m.f.a.canInviteSinglePageView();
            goto L27
        L22:
            r13 = r8.m.f.a.canInviteSinglePageEdit();
            goto L23
        L18:
            r11 = r8.m.f.a.canInviteSinglePageFullAccess();
        L15:
            r10 = false;
            goto L16
        L10:
            r9 = false;
        L74:
            DocPermSetInfo r30 = this.a.m;
            String[] r31 = PermissionAnalytic.a;
            Intrinsics.checkNotNullParameter(r30, "permSetInfo");
            HashMap r32 = new HashMap();
            if (r21 != null) goto L77;
        L79:
            boolean r115 = false;
        L80:
            if (r115 == true) goto L82;
            String r33 = "user";
        L83:
            r32.put("invite_collaborate_type", r33);
            PermissionAnalytic.l(r30, "click_edit_collaborate_perm", r32);
            return;
        L82:
            r33 = ThumbGlideUrl.SOURCE_CHAT;
            goto L83
        L77:
            if (r21.getOwnerType() != 2) goto L79;
            r115 = true;
            goto L80
        }
    }

    public static final class c extends t {
        public final /* synthetic */ g c;

        public c(g r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            Context r3 = this.c.k;
            Toast.showText(r3, r3.getString(2131889805));
        }
    }

    static {
    }

    public final void e1() {
        this.l.findViewById(2131367734).setVisibility(8);
        this.l.findViewById(2131367734).setOnClickListener(null);
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L5;
        int r0 = 2131889048;
    L6:
        ((SpaceEditText) this.l.findViewById(2131381012)).setHint(this.k.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(this.m.getType(), 2131888859, r0)));
        return;
    L5:
        r0 = 2131888038;
        goto L6
    }

    @Override // tg5.b
    public final boolean j0() {
        return this.m.d;
    }

    @Override // tg5.b
    public BaseInviteCollaboratorManageAdapter p() {
        DocumentInviteCollaboratorManageAdapter r2 = new DocumentInviteCollaboratorManageAdapter(((i0) org.koin.java.a.c(i0.class, null, null, 6)).c(), ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2());
        r2.c = new b(this);
        return r2;
    }

    @Override // tg5.b, tg5.p
    public final boolean u6() {
        DocPermSetInfo r0 = this.m;
        if (r0.d == true) goto L5;
    L10:
        return true;
    L5:
        if (r0.f.a.canManageContainerCollaborator() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.l.findViewById(2131367732).isChecked() == false) goto L9;
        goto L9
    }

    @Override // tg5.b
    public final void create() {
        super.create();
        h1(true);
    }

    @Override // tg5.b
    public final void h0() {
        super.h0();
        O0(e());
    }

    public final void S0(UserInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "userInfo");
        tt5.a.h("DocInviteMemberManagerView", "onClickRemovePermission()...pos = " + this.n);
        p.a r0 = this.d;
        if (r0 == null) goto L5;
        r0.W(r3);
    L5:
        L().notifyItemRemoved(this.n);
        if (hu5.a.f(L().getData()) == false) goto L8;
        List r4 = L().getData();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.ee.bear.share.export.UserInfo>");
        O0((ArrayList) r4);
        h1(false);
    L8:
        vi5.a r5 = this.o;
        if (r5 == null) goto L12;
        r5.b();
        return;
    }

    public final void V0(UserInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "userInfo");
        tt5.a.h("DocInviteMemberManagerView", "onClickSetCanRead()...pos = " + this.n);
        r3.setPermission(1);
        L().notifyItemChanged(this.n);
        vi5.a r4 = this.o;
        if (r4 == null) goto L6;
        r4.b();
        return;
    }

    public final void h1(boolean r8) {
        boolean r4 = false;
        if (this.m.d == true) goto L5;
    L7:
        DocPermSetInfo r0 = this.m;
        if (r0.d == true) goto L10;
    L28:
        DocPermSetInfo r9 = this.m;
        if (r9.d == true) goto L31;
    L33:
        this.l.findViewById(2131367735).setVisibility(8);
        this.l.findViewById(2131363918).setVisibility(8);
        e1();
        if (o() == false) goto L40;
        ((SpaceEditText) this.l.findViewById(2131381012)).setHint(this.k.getString(2131889101));
        return;
    L40:
        return;
    L31:
        if (r9.f.a.canManageSinglePageCollaborator() == false) goto L33;
        this.l.findViewById(2131367735).setVisibility(8);
        this.l.findViewById(2131363918).setVisibility(0);
        e1();
        return;
    L10:
        if (r0.f.a.canManageContainerCollaborator() == false) goto L28;
        this.l.findViewById(2131367735).setVisibility(0);
        if (r8 == true) goto L14;
        UDCheckBox r10 = this.l.findViewById(2131367732);
        if (this.l.findViewById(2131367732).isChecked() == true) goto L24;
    L26:
        r10.setChecked(r4);
    L27:
        this.l.findViewById(2131367732).setEnabled(true);
        D0(this.l.findViewById(2131367732).isChecked());
        e1();
        return;
    L24:
        if (k() == true) goto L26;
        r4 = true;
        goto L26
    L14:
        if (k() == false) goto L16;
        this.l.findViewById(2131367732).setChecked(false);
        goto L27
    L16:
        UDCheckBox r11 = this.l.findViewById(2131367732);
        p.a r1 = this.d;
        if (r1 == null) goto L19;
        boolean r2 = r1.r0();
    L20:
        r11.setChecked(r2);
        goto L27
    L19:
        r2 = true;
        goto L20
    L5:
        if (o() == false) goto L7;
        this.l.findViewById(2131367735).setVisibility(0);
        this.l.findViewById(2131367732).setChecked(false);
        this.l.findViewById(2131367732).setEnabled(false);
        this.l.findViewById(2131367734).setVisibility(0);
        this.l.findViewById(2131367734).setOnClickListener(new c(this));
        ((SpaceEditText) this.l.findViewById(2131381012)).setHint(this.k.getString(2131889101));
        D0(this.l.findViewById(2131367732).isChecked());
    }

    public g(Context r3, View r4, DocPermSetInfo r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "permSetInfo");
        super(r3, r4, r5.getType(), r5.e.getCreatorTenantId());
        this.k = r3;
        this.l = r4;
        this.m = r5;
    }
}
