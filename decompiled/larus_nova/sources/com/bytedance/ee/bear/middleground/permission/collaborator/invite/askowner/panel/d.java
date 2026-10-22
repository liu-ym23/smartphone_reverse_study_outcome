package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LinearLayoutManagerWrapper;
import com.bytedance.ee.bear.list.u4;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import hi5.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f233273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f233274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Dialog f233275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f233276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f233277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<UserInfo> f233278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f233279g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f233280h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f233281i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f233282j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f233283k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f233284l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f.a f233285m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f233286n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f233287o;

    public static final class a implements y.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f233288a;

        public a(d r100) {
            this.f233288a = r100;
        }

        @Override // hi5.y.a
        public final /* synthetic */ void QF() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            d r101 = this.f233288a;
            f.a r102 = r101.f233285m;
            if (r102 == null) goto L6;
            r102.W7(r101.f233277e);
            return;
        }
    }

    public static final class b implements y.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f233289a;

        public b(d r100) {
            this.f233289a = r100;
        }

        @Override // hi5.y.a
        public final /* synthetic */ void QF() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            d r111 = this.f233289a;
            Dialog r100 = r111.f233275c;
            if (r100 == null) goto L5;
            r100.hide();
        L5:
            com.bytedance.ee.bear.widgets.a r101 = new com.bytedance.ee.bear.widgets.a(r111.f233273a);
            CharSequence r102 = r111.f233273a.getText(R.string.Doc_Facade_ReadPermission);
            rg5.c r103 = new rg5.c(r111);
            if (r111.f233286n != 1) goto L8;
            boolean r104 = true;
        L9:
            int r105 = r111.k(r104);
            cp5.b r106 = new cp5.b();
            r106.f464689a = r102;
            r106.f464692d = false;
            r106.f464693e = null;
            r106.f464694f = r103;
            r106.f464691c = false;
            r106.f464690b = r105;
            r106.f464695g = true;
            r106.f464696h = 1.0f;
            r106.f464697i = true;
            r101.f(r106);
            if (r111.f233281i == 125) goto L16;
            CharSequence r107 = r111.f233273a.getText(R.string.Doc_Facade_EditPermission);
            rg5.d r108 = new rg5.d(r111);
            if (r111.f233286n != 4) goto L14;
            boolean r109 = true;
        L15:
            int r112 = r111.k(r109);
            cp5.b r113 = new cp5.b();
            r113.f464689a = r107;
            r113.f464692d = false;
            r113.f464693e = null;
            r113.f464694f = r108;
            r113.f464691c = false;
            r113.f464690b = r112;
            r113.f464695g = true;
            r113.f464696h = 1.0f;
            r113.f464697i = true;
            r101.f(r113);
        L17:
            r101.b(new rg5.e(r111));
            r101.p(new rg5.f(r111));
            r101.q();
            String r114 = r111.f233280h;
            int r115 = r111.f233281i;
            String r116 = r111.f233283k;
            boolean r117 = r111.f233284l;
            String r118 = r111.f233282j;
            boolean r119 = r111.f233287o;
            String r120 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
            Intrinsics.checkNotNullParameter(r114, "token");
            Intrinsics.checkNotNullParameter(r116, "subType");
            Intrinsics.checkNotNullParameter(r118, EventConstant.Key.MODULE);
            JSONObject r121 = new JSONObject();
            if (r119 == false) goto L21;
        L23:
            String r122 = "none";
        L24:
            String r123 = r122;
            if (r119 == false) goto L27;
            String r124 = "";
        L28:
            com.bytedance.ee.bear.middleground.permission.c.a(r121, r114, r115, r123, r116, r118, "", r124, com.bytedance.ee.bear.middleground.permission.c.f233148b, r117);
            if (r119 == false) goto L31;
            String r125 = "im_card";
        L32:
            r121.put("from_scene", r125);
            com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_ask_owner_type_view", r121);
            return;
        L31:
            r125 = "add_collaborator";
            goto L32
        L27:
            r124 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
            goto L28
        L21:
            if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L23;
            r122 = ThumbGlideUrl.SOURCE_VC;
            goto L24
        L14:
            r109 = false;
            goto L15
        L16:
            tt5.a.h("AskOwnerView", "stage=role_options, obj_type=125, role_domain=bit, requested_role=1");
            goto L17
        L8:
            r104 = false;
            goto L9
        }
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        TextView r100 = (TextView) this.f233274b.findViewById(R.id.title);
        if (this.f233287o == false) goto L5;
        r100.setText(R.string.Doc_Permission_AskOwnerShare);
    L6:
        o();
        String r101 = xo5.a.c(this.f233273a, R.string.Doc_Permission_AskOwner_placeholder, "owner_name", this.f233276d);
        ((SpaceEditText) this.f233274b.findViewById(R.id.notesInput)).setHint(r101);
        Locale r102 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
        AccountService$Account r103 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        Intrinsics.checkNotNull(r102);
        UserAdapter r104 = new UserAdapter(r102, r103, this.f233279g);
        r104.setNewData(this.f233278f);
        ((RecyclerView) this.f233274b.findViewById(R.id.invitedUserList)).setAdapter(r104);
        ((RecyclerView) this.f233274b.findViewById(R.id.invitedUserList)).setLayoutManager(new LinearLayoutManagerWrapper(this.f233273a));
        ((Button) this.f233274b.findViewById(R.id.sendRequestBtn)).setOnClickListener(new e(this));
        return;
    L5:
        r100.setText(R.string.Doc_Permission_AskOwnerPartUserFailed);
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.f
    public final String getNotes() {
        Editable r100 = ((SpaceEditText) this.f233274b.findViewById(R.id.notesInput)).getText();
        if (r100 == null) goto L6;
        String r101 = r100.toString();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final void o() {
        String r100 = "@" + this.f233276d;
        if (this.f233286n != 1) goto L5;
        int r101 = R.string.Doc_Facade_ReadPermission;
    L6:
        String r102 = this.f233273a.getString(r101);
        if (this.f233287o == false) goto L9;
        HashMap r103 = new HashMap();
        r103.put("name", r100);
        r103.put("permission_type", r102 + ' ');
        String r104 = xo5.a.d(this.f233273a, com.bytedance.ee.bear.middleground.permission.collaborator.invite.b.b(this.f233281i, R.string.LarkCCM_ChatShare_AskChatOwnerForPermission_Desc, R.string.Doc_Permission_AskOwnerFromIMTips), r103);
    L10:
        String r105 = r104;
        Intrinsics.checkNotNull(r105);
        int r106 = StringsKt.indexOf$default(r105, r100, 0, false, 6, null);
        int r107 = StringsKt.indexOf$default(r105, r102, 0, false, 6, null);
        SpannableString r108 = new SpannableString(r105);
        r108.setSpan(new y(this.f233273a, new a(this)), r106, r100.length() + r106, 33);
        r108.setSpan(new y(this.f233273a, new b(this)), r107, r102.length() + r107, 33);
        int r109 = r107 + r102.length();
        r108.setSpan(new rg5.a(this.f233273a), r109, r109 + 1, 33);
        ((TextView) this.f233274b.findViewById(R.id.tips)).setText(r108);
        ((TextView) this.f233274b.findViewById(R.id.tips)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) this.f233274b.findViewById(R.id.tips)).setHighlightColor(0);
        return;
    L9:
        HashMap r110 = new HashMap();
        r110.put("name", r100);
        r110.put("permission_type", r102 + ' ');
        u4 r111 = u4.f229807a;
        Context r112 = this.f233273a;
        int r113 = this.f233281i;
        r111.getClass();
        r110.put("doc_type", u4.a(r112, r113));
        r104 = xo5.a.d(this.f233273a, R.string.CreatinoMobile_Minutes_share_external_dialog, r110);
        goto L10
    L5:
        r101 = R.string.Doc_Facade_EditPermission;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.f
    public final int q1() {
        return this.f233286n;
    }

    public final int k(boolean r100) {
        int r101 = this.f233273a.getResources().getColor(R.color.primary_fill_default);
        int r102 = this.f233273a.getResources().getColor(R.color.text_title);
        if (r100 == false) goto L6;
        return r101;
    L6:
        return r102;
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f233285m = (f.a) r100;
    }

    public static final void h(d r110, int r111) {
        String r100 = r110.f233280h;
        int r101 = r110.f233281i;
        String r102 = r110.f233283k;
        boolean r103 = r110.f233284l;
        String r104 = r110.f233282j;
        boolean r112 = r110.f233287o;
        String r105 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "subType");
        Intrinsics.checkNotNullParameter(r104, EventConstant.Key.MODULE);
        JSONObject r113 = new JSONObject();
        if (r112 == false) goto L6;
    L8:
        String r106 = "none";
    L9:
        if (r112 == false) goto L11;
        String r107 = "";
    L12:
        com.bytedance.ee.bear.middleground.permission.c.a(r113, r100, r101, r106, r102, r104, "", r107, com.bytedance.ee.bear.middleground.permission.c.f233148b, r103);
        if (r111 != 1) goto L15;
        String r114 = "read";
    L19:
        r113.put("click", r114);
        if (r112 == false) goto L22;
        String r115 = "im_card";
    L23:
        r113.put("from_scene", r115);
        r113.put(PickerReporterConstants.KEY.TARGET, "none");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_ask_owner_type_click", r113);
        return;
    L22:
        r115 = "add_collaborator";
        goto L23
    L15:
        if (r111 == 4) goto L17;
        r114 = "cancel";
        goto L19
    L17:
        r114 = "edit";
        goto L19
    L11:
        r107 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        goto L12
    L6:
        if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L8;
        r106 = ThumbGlideUrl.SOURCE_VC;
        goto L9
    }

    public d(Context r100, View r101, Dialog r102, String r103, String r104, ArrayList<UserInfo> r105, int r106, String r107, int r110, String r111, String r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "rootView");
        Intrinsics.checkNotNullParameter(r103, "ownerName");
        Intrinsics.checkNotNullParameter(r104, "ownerId");
        Intrinsics.checkNotNullParameter(r105, "invitedUsers");
        Intrinsics.checkNotNullParameter(r107, "token");
        Intrinsics.checkNotNullParameter(r111, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r112, "subType");
        this.f233273a = r100;
        this.f233274b = r101;
        this.f233275c = r102;
        this.f233276d = r103;
        this.f233277e = r104;
        this.f233278f = r105;
        this.f233279g = r106;
        this.f233280h = r107;
        this.f233281i = r110;
        this.f233282j = r111;
        this.f233283k = r112;
        this.f233284l = r113;
        boolean r108 = true;
        this.f233286n = 1;
        if (r106 == 2) goto L6;
        r108 = false;
    L6:
        this.f233287o = r108;
    }
}
