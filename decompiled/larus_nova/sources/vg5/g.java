package vg5;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.Group;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.DocumentInviteCollaboratorManageAdapter;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.nova.R;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tg5.p;

/* JADX INFO: loaded from: classes18.dex */
public class g extends tg5.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f554705k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f554706l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DocPermSetInfo f554707m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f554708n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public vi5.a f554709o;

    public static final class a {
    }

    public static final class b implements BaseInviteCollaboratorManageAdapter.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f554710a;

        public b(g r100) {
            this.f554710a = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.BaseInviteCollaboratorManageAdapter.a
        public final void a(UserInfo r210, int r211) {
            g r100 = this.f554710a;
            r100.f554708n = r211;
            if (r100.f554709o != null) goto L5;
            r100.f554709o = new vi5.a(r100.f554705k);
        L5:
            vi5.a r101 = this.f554710a.f554709o;
            if (r101 == null) goto L74;
            Intrinsics.checkNotNull(r210);
            DocPermSetInfo r102 = this.f554710a.f554707m;
            String r103 = r102.f234429c;
            int r104 = r102.getType();
            g r105 = this.f554710a;
            r105.getClass();
            Intrinsics.checkNotNullParameter(r210, "userInfo");
            if (r105.f554707m.getType() != 44) goto L10;
            boolean r106 = true;
        L12:
            if (r105.u6() == false) goto L15;
            if (r106 == true) goto L15;
            boolean r107 = true;
        L16:
            if (r107 == false) goto L18;
            boolean r108 = r105.f554707m.f234432f.f234419a.canInviteFullAccess();
        L19:
            boolean r110 = r108;
            if (r107 == false) goto L22;
            boolean r109 = r105.f554707m.f234432f.f234419a.canInviteEdit();
        L23:
            if (r107 == false) goto L25;
            boolean r111 = r105.f554707m.f234432f.f234419a.canInviteView();
        L27:
            if (r105.f554707m.getType() != 125) goto L33;
            tt5.a.h("DocInviteMemberManagerView", "stage=role_options, obj_type=125, role_domain=bit, requested_role=1");
            vi5.d r112 = new vi5.d(r105.f554705k);
            if (r210.getPermission() != 1) goto L31;
            boolean r113 = true;
        L32:
            vi5.d.d(r112, r113, r111, new h(r105, r210));
            r112.a(new i(r105, r210));
            ArrayList<vi5.c> r114 = r112.f555344b;
            vi5.a r115 = r101;
            int r116 = r104;
            String r117 = r103;
        L73:
            r115.c(r210, r117, r116, r114);
            goto L74
        L31:
            r113 = false;
            goto L32
        L33:
            DocUserPermission.a r118 = DocUserPermission.Companion;
            int r119 = r210.getPermission();
            r118.getClass();
            boolean r120 = DocUserPermission.a.a(r119);
            if ((r210.getPermission() & 4) == 0) goto L36;
            boolean r121 = true;
        L38:
            if ((r210.getPermission() & 1) == 0) goto L40;
            boolean r122 = true;
        L42:
            if (r210.getOwnerType() == 29) goto L44;
            boolean r123 = true;
        L46:
            if (r210.getOwnerType() == 29) goto L48;
            boolean r124 = true;
        L49:
            DocPermSetInfo r125 = r105.f554707m;
            boolean r126 = r125.f234430d;
            boolean r127 = r125.a();
            tt5.a.h("DocInviteMemberManagerView", "canUserFa: " + r110 + ", canUserEdit: " + r109 + ", canMemberEdit:" + r121 + ", canMemberFa:" + r120 + ", canMemberRead:" + r122 + ", canShowEdit:" + r124 + ", canShowFa:" + r123 + ", wiki2enable:" + r126 + ", isDocV2: " + r127);
            vi5.d r128 = new vi5.d(r105.f554705k);
            if (r123 == false) goto L63;
            if (r126 == true) goto L62;
            if (r127 == true) goto L62;
            if (r105.f554707m.getType() == 28) goto L62;
            if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == true) goto L58;
        L60:
            boolean r129 = false;
        L61:
            if (r129 == false) goto L63;
        L58:
            if (sbb.g.a(r105.f554707m.getType()) == false) goto L60;
            r129 = true;
        L62:
            boolean r130 = true;
        L64:
            boolean r131 = r122;
            r128.c(r130, r110, r120, r105.f554707m.f234430d, new j(r105, r210));
            r128.b(r121, r109, new k(r105, r210), r124);
            if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == true) goto L67;
        L69:
            boolean r132 = false;
        L70:
            if (r132 == true) goto L72;
            vi5.d.d(r128, r131, r111, new l(r105, r210));
        L72:
            r128.a(new m(r105, r210));
            r114 = r128.f555344b;
            r115 = r101;
            r116 = r104;
            r117 = r103;
            goto L73
        L67:
            if (sbb.g.a(r105.f554707m.getType()) == false) goto L69;
            r132 = true;
        L63:
            r130 = false;
            goto L64
        L48:
            r124 = false;
            goto L49
        L44:
            r123 = false;
            goto L46
        L40:
            r122 = false;
            goto L42
        L36:
            r121 = false;
            goto L38
        L25:
            r111 = r105.f554707m.f234432f.f234419a.canInviteSinglePageView();
            goto L27
        L22:
            r109 = r105.f554707m.f234432f.f234419a.canInviteSinglePageEdit();
            goto L23
        L18:
            r108 = r105.f554707m.f234432f.f234419a.canInviteSinglePageFullAccess();
        L15:
            r107 = false;
            goto L16
        L10:
            r106 = false;
        L74:
            DocPermSetInfo r133 = this.f554710a.f554707m;
            String[] r134 = PermissionAnalytic.f232823a;
            Intrinsics.checkNotNullParameter(r133, "permSetInfo");
            HashMap r135 = new HashMap();
            if (r210 != null) goto L77;
        L79:
            boolean r136 = false;
        L80:
            if (r136 == true) goto L82;
            String r137 = "user";
        L83:
            r135.put("invite_collaborate_type", r137);
            PermissionAnalytic.l(r133, "click_edit_collaborate_perm", r135);
            return;
        L82:
            r137 = "chat";
            goto L83
        L77:
            if (r210.getOwnerType() != 2) goto L79;
            r136 = true;
            goto L80
        }
    }

    public static final class c extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f554711c;

        public c(g r100) {
            this.f554711c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Context r101 = this.f554711c.f554705k;
            Toast.showText(r101, r101.getString(R.string.LarkCCM_Wiki_InviteEmail_CurrentPageOnly_Descrip));
        }
    }

    static {
    }

    public final void e1() {
        this.f554706l.findViewById(R.id.containerPermCheckboxWrapper).setVisibility(8);
        this.f554706l.findViewById(R.id.containerPermCheckboxWrapper).setOnClickListener(null);
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L5;
        int r100 = R.string.LarkCCM_Docs_Doubao_ShareLeaveNote_Placeholder;
    L6:
        ((SpaceEditText) this.f554706l.findViewById(R.id.notesInput)).setHint(this.f554705k.getString(com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(this.f554707m.getType(), R.string.LarkCCM_ChatShare_AddNote_Placeholder, r100)));
        return;
    L5:
        r100 = R.string.Doc_Permission_AddNotesDesc;
        goto L6
    }

    @Override // tg5.b
    public final boolean j0() {
        return this.f554707m.f234430d;
    }

    @Override // tg5.b
    public BaseInviteCollaboratorManageAdapter p() {
        DocumentInviteCollaboratorManageAdapter r100 = new DocumentInviteCollaboratorManageAdapter(((i0) org.koin.java.a.c(i0.class, null, null, 6)).c(), ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2());
        r100.f233164c = new b(this);
        return r100;
    }

    @Override // tg5.b, tg5.p
    public final boolean u6() {
        DocPermSetInfo r100 = this.f554707m;
        if (r100.f234430d == true) goto L5;
    L10:
        return true;
    L5:
        if (r100.f234432f.f234419a.canManageContainerCollaborator() == true) goto L7;
    L9:
        return false;
    L7:
        if (((UDCheckBox) this.f554706l.findViewById(R.id.containerPermCheckBox)).isChecked() == false) goto L9;
        goto L9
    }

    @Override // tg5.b, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        h1(true);
    }

    @Override // tg5.b
    public final void h0() {
        super.h0();
        O0(e());
    }

    public final void S0(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        tt5.a.h("DocInviteMemberManagerView", "onClickRemovePermission()...pos = " + this.f554708n);
        p.a r101 = this.f545854d;
        if (r101 == null) goto L5;
        r101.W(r100);
    L5:
        L().notifyItemRemoved(this.f554708n);
        if (hu5.a.f(L().getData()) == false) goto L8;
        List<UserInfo> r102 = L().getData();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.util.ArrayList<com.bytedance.ee.bear.share.export.UserInfo>");
        O0((ArrayList) r102);
        h1(false);
    L8:
        vi5.a r103 = this.f554709o;
        if (r103 == null) goto L12;
        r103.b();
        return;
    }

    public final void V0(UserInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfo");
        tt5.a.h("DocInviteMemberManagerView", "onClickSetCanRead()...pos = " + this.f554708n);
        r100.setPermission(1);
        L().notifyItemChanged(this.f554708n);
        vi5.a r101 = this.f554709o;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }

    public final void h1(boolean r100) {
        boolean r101 = false;
        if (this.f554707m.f234430d == true) goto L5;
    L7:
        DocPermSetInfo r102 = this.f554707m;
        if (r102.f234430d == true) goto L10;
    L28:
        DocPermSetInfo r103 = this.f554707m;
        if (r103.f234430d == true) goto L31;
    L33:
        ((Group) this.f554706l.findViewById(R.id.containerPermGroup)).setVisibility(8);
        ((UDNotice) this.f554706l.findViewById(R.id.bannerTipsLayout3)).setVisibility(8);
        e1();
        if (o() == false) goto L40;
        ((SpaceEditText) this.f554706l.findViewById(R.id.notesInput)).setHint(this.f554705k.getString(R.string.LarkCCM_Docs_InviteEmail_SendNote_Placeholder));
        return;
    L40:
        return;
    L31:
        if (r103.f234432f.f234419a.canManageSinglePageCollaborator() == false) goto L33;
        ((Group) this.f554706l.findViewById(R.id.containerPermGroup)).setVisibility(8);
        ((UDNotice) this.f554706l.findViewById(R.id.bannerTipsLayout3)).setVisibility(0);
        e1();
        return;
    L10:
        if (r102.f234432f.f234419a.canManageContainerCollaborator() == false) goto L28;
        ((Group) this.f554706l.findViewById(R.id.containerPermGroup)).setVisibility(0);
        if (r100 == true) goto L14;
        UDCheckBox r104 = (UDCheckBox) this.f554706l.findViewById(R.id.containerPermCheckBox);
        if (((UDCheckBox) this.f554706l.findViewById(R.id.containerPermCheckBox)).isChecked() == true) goto L24;
    L26:
        r104.setChecked(r101);
    L27:
        ((UDCheckBox) this.f554706l.findViewById(R.id.containerPermCheckBox)).setEnabled(true);
        D0(((UDCheckBox) this.f554706l.findViewById(R.id.containerPermCheckBox)).isChecked());
        e1();
        return;
    L24:
        if (k() == true) goto L26;
        r101 = true;
        goto L26
    L14:
        if (k() == false) goto L16;
        ((UDCheckBox) this.f554706l.findViewById(R.id.containerPermCheckBox)).setChecked(false);
        goto L27
    L16:
        UDCheckBox r105 = (UDCheckBox) this.f554706l.findViewById(R.id.containerPermCheckBox);
        p.a r106 = this.f545854d;
        if (r106 == null) goto L19;
        boolean r107 = r106.r0();
    L20:
        r105.setChecked(r107);
        goto L27
    L19:
        r107 = true;
        goto L20
    L5:
        if (o() == false) goto L7;
        ((Group) this.f554706l.findViewById(R.id.containerPermGroup)).setVisibility(0);
        ((UDCheckBox) this.f554706l.findViewById(R.id.containerPermCheckBox)).setChecked(false);
        ((UDCheckBox) this.f554706l.findViewById(R.id.containerPermCheckBox)).setEnabled(false);
        this.f554706l.findViewById(R.id.containerPermCheckboxWrapper).setVisibility(0);
        this.f554706l.findViewById(R.id.containerPermCheckboxWrapper).setOnClickListener(new c(this));
        ((SpaceEditText) this.f554706l.findViewById(R.id.notesInput)).setHint(this.f554705k.getString(R.string.LarkCCM_Docs_InviteEmail_SendNote_Placeholder));
        D0(((UDCheckBox) this.f554706l.findViewById(R.id.containerPermCheckBox)).isChecked());
    }

    public g(Context r100, View r101, DocPermSetInfo r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "permSetInfo");
        super(r100, r101, r102.getType(), r102.f234431e.getCreatorTenantId());
        this.f554705k = r100;
        this.f554706l = r101;
        this.f554707m = r102;
    }
}
