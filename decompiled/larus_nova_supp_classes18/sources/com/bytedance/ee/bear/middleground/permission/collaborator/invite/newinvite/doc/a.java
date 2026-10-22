package com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.permission.escape.g;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeApprovalInfo;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tg5.o;
import tg5.p;
import vg5.d;
import vg5.e;
import vg5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BasePresenter<o, p, p.a> {
    public final FragmentActivity a;
    public final o b;
    public final p c;
    public final b d;
    public final DocPermSetInfo e;
    public final String f;
    public final UserInfo g;
    public final boolean h;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a$a, reason: collision with other inner class name */
    public static final class C0092a {
    }

    public interface b {
        void back();

        void finish();
    }

    public final class c implements p.a {
        public final /* synthetic */ a a;

        @Override // tg5.p.a
        public final void W2() {
            a r1 = this.a;
            ArrayList<UserInfo> r2 = r1.b.e();
            int r5 = 1;
            if (r1.c.getNotes().length() <= 0) goto L5;
            boolean r3 = true;
        L6:
            com.bytedance.ee.bear.middleground.permission.c.T(r2, r3, r1.c.b8(), r1.c.u6());
            EscapeRuleBean r4 = r1.e.k;
            Iterator<T> r6 = r1.b.e().iterator();
        L8:
            if (r6.hasNext() == false) goto L12;
            Object r7 = r6.next();
            if (((UserInfo) r7).isExternal() == false) goto L8;
        L13:
            if (r7 == null) goto L15;
            boolean r8 = true;
        L16:
            DocPermSetInfo r9 = r1.e;
            if (r9.d == true) goto L19;
            boolean r10 = r9.f.a.isFullAccess();
        L26:
            DocPermSetInfo r11 = r1.e;
            if (r11.d == false) goto L29;
        L32:
            boolean r12 = r1.e.f.b.externalAccess();
        L33:
            boolean r13 = r1.e.f.b.canExternalAccessOpenEscape();
            tt5.a.h("InviteMemberManagerPresenter", "invite member sure, escapeRuleBean: " + r4 + ", canFullAccess: " + r10 + ", externalAccess: " + r12 + ", canExternalAccessOpenEscape: " + r13);
            if (r4 == null) goto L51;
            if (r8 == false) goto L51;
            if (r10 == false) goto L51;
            if (r12 == true) goto L51;
            if (r13 == false) goto L51;
            r4.setPermReqType(2);
            Gson r14 = new Gson();
            Pair[] r15 = new Pair[6];
            r15[0] = TuplesKt.to(ResourceData.KEY_TOKEN, r1.e.c);
            r15[1] = TuplesKt.to(ResourceData.KEY_TYPE, Integer.valueOf(r1.e.getType()));
            Gson r16 = new Gson();
            ArrayList<UserInfo> r17 = r1.b.e();
            ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
            Iterator<T> r19 = r17.iterator();
        L41:
            if (r19.hasNext() == false) goto L43;
            UserInfo r110 = (UserInfo) r19.next();
            r18.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("owner_id", r110.getId()), TuplesKt.to("owner_type", Integer.valueOf(r110.getOwnerType())), TuplesKt.to("permission", Integer.valueOf(r110.getPermission()))}));
            goto L41
        L43:
            r15[2] = TuplesKt.to("owners", GsonProtectorUtils.toJson(r16, r18));
            r15[3] = TuplesKt.to("notify_lark_v3", Boolean.valueOf(r1.c.b8()));
            r15[4] = TuplesKt.to("lark_im_text", r1.c.getNotes());
            if (r1.c.u6() == true) goto L47;
            r5 = 2;
        L47:
            r15[5] = TuplesKt.to("perm_type", Integer.valueOf(r5));
            r4.setPermReqParam(GsonProtectorUtils.toJson(r14, MapsKt.mapOf(r15)));
            if (r4.getApprovalDef().getApprovalDetail().isNeedApprove() == true) goto L50;
            r1.c.showLoading();
            o r20 = r1.b;
            boolean r21 = r1.c.b8();
            r1.c.u6();
            r20.D1(r21, r1.c.getNotes(), r4, new d(r1));
            return;
        L50:
            ((g) org.koin.java.a.c(g.class, null, null, 6)).b(r1.a, r4, new EscapeApprovalInfo(null, 0, null, 7, null), new e(r1));
            return;
        L51:
            r1.c.showLoading();
            r1.b.c7(r1.c.b8(), r1.c.u6(), r1.c.getNotes(), new f(r1));
            return;
        L29:
            if (r11.a() == true) goto L32;
            r12 = true;
            goto L33
        L19:
            if (r9.f.a.isSinglePageFullAccess() == false) goto L21;
        L24:
            r10 = true;
            goto L26
        L21:
            if (r1.e.f.a.isFullAccess() == true) goto L24;
            r10 = false;
            goto L26
        L15:
            r8 = false;
            goto L16
        L12:
            r7 = null;
            goto L13
        L5:
            r3 = false;
            goto L6
        }

        @Override // tg5.p.a
        public final ArrayList<UserInfo> e() {
            return this.a.b.e();
        }

        @Override // tg5.p.a
        public final void onBack() {
            b r0 = this.a.d;
            if (r0 == null) goto L5;
            r0.back();
        L5:
            com.bytedance.ee.bear.middleground.permission.c.S();
        }

        @Override // tg5.p.a
        public final boolean r0() {
            return this.a.b.r0();
        }

        public c(a r1) {
            this.a = r1;
        }

        @Override // tg5.p.a
        public final void D0(String r2) {
            Intrinsics.checkNotNullParameter(r2, "notificationId");
            this.a.b.F1(r2);
        }

        @Override // tg5.p.a
        public final void N(boolean r2) {
            this.a.b.N(r2);
        }

        @Override // tg5.p.a
        public final void W(UserInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "userInfo");
            this.a.b.m7(r2);
            this.a.c.A8();
            if (this.a.b.e().size() != 0) goto L8;
            b r3 = this.a.d;
            if (r3 == null) goto L9;
            r3.back();
            return;
        L9:
            return;
        }
    }

    static {
    }

    public static void I8() {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().j(0);
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new c(this);
    }

    public final void create() {
        super.create();
        this.c.F(this.b.e());
        this.c.A8();
        com.bytedance.ee.bear.middleground.permission.c.U(this.b.e());
    }

    public final void H8(boolean r3) {
        if (this.h == true) goto L5;
        if (r3 == true) goto L5;
        return;
    L5:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).X9();
    }

    public a(FragmentActivity r2, vg5.a r3, vg5.g r4, b r5, DocPermSetInfo r6, String r7, UserInfo r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r6, "permSetInfo");
        Intrinsics.checkNotNullParameter(r7, "module");
        super(r3, r4);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
    }
}
