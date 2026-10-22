package com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.setting.DocumentSettingViewModel;
import com.bytedance.ee.bear.middleground.permission.escape.g;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeApprovalInfo;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes18.dex */
public final class a extends BasePresenter<o, p, p.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f233332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f233333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f233334c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f233335d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DocPermSetInfo f233336e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f233337f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final UserInfo f233338g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f233339h;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.doc.a$a, reason: collision with other inner class name */
    public static final class C3339a {
    }

    public interface b {
        void back();

        void finish();
    }

    public final class c implements p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f233340a;

        @Override // tg5.p.a
        public final void W2() {
            a r100 = this.f233340a;
            ArrayList<UserInfo> r101 = r100.f233333b.e();
            int r102 = 1;
            if (r100.f233334c.getNotes().length() <= 0) goto L5;
            boolean r103 = true;
        L6:
            com.bytedance.ee.bear.middleground.permission.c.T(r101, r103, r100.f233334c.b8(), r100.f233334c.u6());
            EscapeRuleBean r104 = r100.f233336e.f234437k;
            Iterator<T> r105 = r100.f233333b.e().iterator();
        L8:
            if (r105.hasNext() == false) goto L12;
            Object r106 = r105.next();
            if (((UserInfo) r106).isExternal() == false) goto L8;
        L13:
            if (r106 == null) goto L15;
            boolean r107 = true;
        L16:
            DocPermSetInfo r108 = r100.f233336e;
            if (r108.f234430d == true) goto L19;
            boolean r109 = r108.f234432f.f234419a.isFullAccess();
        L26:
            DocPermSetInfo r110 = r100.f233336e;
            if (r110.f234430d == false) goto L29;
        L32:
            boolean r111 = r100.f233336e.f234432f.f234420b.externalAccess();
        L33:
            boolean r112 = r100.f233336e.f234432f.f234420b.canExternalAccessOpenEscape();
            tt5.a.h("InviteMemberManagerPresenter", "invite member sure, escapeRuleBean: " + r104 + ", canFullAccess: " + r109 + ", externalAccess: " + r111 + ", canExternalAccessOpenEscape: " + r112);
            if (r104 == null) goto L51;
            if (r107 == false) goto L51;
            if (r109 == false) goto L51;
            if (r111 == true) goto L51;
            if (r112 == false) goto L51;
            r104.setPermReqType(2);
            Gson r113 = new Gson();
            Pair[] r114 = new Pair[6];
            r114[0] = TuplesKt.to("token", r100.f233336e.f234429c);
            r114[1] = TuplesKt.to("type", Integer.valueOf(r100.f233336e.getType()));
            Gson r115 = new Gson();
            ArrayList<UserInfo> r116 = r100.f233333b.e();
            ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
            Iterator<T> r118 = r116.iterator();
        L41:
            if (r118.hasNext() == false) goto L43;
            UserInfo r119 = (UserInfo) r118.next();
            r117.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("owner_id", r119.getId()), TuplesKt.to("owner_type", Integer.valueOf(r119.getOwnerType())), TuplesKt.to("permission", Integer.valueOf(r119.getPermission()))}));
            goto L41
        L43:
            r114[2] = TuplesKt.to("owners", GsonProtectorUtils.toJson(r115, r117));
            r114[3] = TuplesKt.to("notify_lark_v3", Boolean.valueOf(r100.f233334c.b8()));
            r114[4] = TuplesKt.to("lark_im_text", r100.f233334c.getNotes());
            if (r100.f233334c.u6() == true) goto L47;
            r102 = 2;
        L47:
            r114[5] = TuplesKt.to(DocumentSettingViewModel.KEY_ACCESS_PERM_TYPE, Integer.valueOf(r102));
            r104.setPermReqParam(GsonProtectorUtils.toJson(r113, MapsKt.mapOf(r114)));
            if (r104.getApprovalDef().getApprovalDetail().isNeedApprove() == true) goto L50;
            r100.f233334c.showLoading();
            o r120 = r100.f233333b;
            boolean r121 = r100.f233334c.b8();
            r100.f233334c.u6();
            r120.D1(r121, r100.f233334c.getNotes(), r104, new d(r100));
            return;
        L50:
            ((g) org.koin.java.a.c(g.class, null, null, 6)).b(r100.f233332a, r104, new EscapeApprovalInfo(null, 0, null, 7, null), new e(r100));
            return;
        L51:
            r100.f233334c.showLoading();
            r100.f233333b.c7(r100.f233334c.b8(), r100.f233334c.u6(), r100.f233334c.getNotes(), new f(r100));
            return;
        L29:
            if (r110.a() == true) goto L32;
            r111 = true;
            goto L33
        L19:
            if (r108.f234432f.f234419a.isSinglePageFullAccess() == false) goto L21;
        L24:
            r109 = true;
            goto L26
        L21:
            if (r100.f233336e.f234432f.f234419a.isFullAccess() == true) goto L24;
            r109 = false;
            goto L26
        L15:
            r107 = false;
            goto L16
        L12:
            r106 = null;
            goto L13
        L5:
            r103 = false;
            goto L6
        }

        @Override // tg5.p.a
        public final ArrayList<UserInfo> e() {
            return this.f233340a.f233333b.e();
        }

        @Override // tg5.p.a
        public final void onBack() {
            b r100 = this.f233340a.f233335d;
            if (r100 == null) goto L5;
            r100.back();
        L5:
            com.bytedance.ee.bear.middleground.permission.c.S();
        }

        @Override // tg5.p.a
        public final boolean r0() {
            return this.f233340a.f233333b.r0();
        }

        public c(a r100) {
            this.f233340a = r100;
        }

        @Override // tg5.p.a
        public final void D0(String r100) {
            Intrinsics.checkNotNullParameter(r100, "notificationId");
            this.f233340a.f233333b.F1(r100);
        }

        @Override // tg5.p.a
        public final void N(boolean r100) {
            this.f233340a.f233333b.N(r100);
        }

        @Override // tg5.p.a
        public final void W(UserInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "userInfo");
            this.f233340a.f233333b.m7(r100);
            this.f233340a.f233334c.A8();
            if (this.f233340a.f233333b.e().size() != 0) goto L8;
            b r101 = this.f233340a.f233335d;
            if (r101 == null) goto L9;
            r101.back();
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

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new c(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        this.f233334c.F(this.f233333b.e());
        this.f233334c.A8();
        com.bytedance.ee.bear.middleground.permission.c.U(this.f233333b.e());
    }

    public final void H8(boolean r100) {
        if (this.f233339h == true) goto L5;
        if (r100 == true) goto L5;
        return;
    L5:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).X9();
    }

    public a(FragmentActivity r100, vg5.a r101, vg5.g r102, b r103, DocPermSetInfo r104, String r105, UserInfo r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r104, "permSetInfo");
        Intrinsics.checkNotNullParameter(r105, EventConstant.Key.MODULE);
        super(r101, r102);
        this.f233332a = r100;
        this.f233333b = r101;
        this.f233334c = r102;
        this.f233335d = r103;
        this.f233336e = r104;
        this.f233337f = r105;
        this.f233338g = r106;
        this.f233339h = r107;
    }
}
