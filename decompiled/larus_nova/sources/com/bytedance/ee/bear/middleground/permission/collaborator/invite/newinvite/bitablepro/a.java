package com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tg5.o;
import tg5.p;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends BasePresenter<o, p, p.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f233318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f233319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f233320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f233321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cj5.c.a f233322e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.a$a, reason: collision with other inner class name */
    public static final class C3338a {
    }

    public interface b {
        void back();

        void finish();
    }

    public final class c implements p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f233323a;

        @Override // tg5.p.a
        public final void D0(String r100) {
            Intrinsics.checkNotNullParameter(r100, "notificationId");
        }

        @Override // tg5.p.a
        public final void W2() {
            a r100 = this.f233323a;
            r100.f233319b.showLoading();
            if (r100.f233322e == null) goto L5;
            r100.f233318a.c7(r100.f233319b.b8(), r100.f233319b.u6(), r100.f233319b.getNotes(), new com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.b(r100));
        L6:
            int r101 = com.bytedance.ee.bear.middleground.permission.a.f232845a;
            ArrayList<UserInfo> r102 = e();
            Intrinsics.checkNotNullParameter(r102, "userInfoList");
            JSONObject r103 = new JSONObject();
            r103.put("click", "invite");
            r103.put(PickerReporterConstants.KEY.TARGET, "none");
            JSONArray r104 = new JSONArray();
            Iterator<UserInfo> r105 = r102.iterator();
        L8:
            if (r105.hasNext() == false) goto L10;
            UserInfo r106 = r105.next();
            JSONObject r107 = new JSONObject();
            r107.put("collaborate_type", r106.getOwnerType());
            r107.put("object_uid", du5.b.g(r106.getId()));
            r104.put(r107);
            goto L8
        L10:
            r103.put("user_list", r104.toString());
            com.bytedance.ee.bear.middleground.permission.a.a("ccm_bitable_premium_permission_invite_collaborator_click", r103);
            return;
        L5:
            r100.f233318a.c7(r100.f233319b.b8(), r100.f233319b.u6(), r100.f233319b.getNotes(), new ug5.b(r100));
            goto L6
        }

        @Override // tg5.p.a
        public final ArrayList<UserInfo> e() {
            return this.f233323a.f233318a.e();
        }

        @Override // tg5.p.a
        public final void onBack() {
            b r100 = this.f233323a.f233320c;
            if (r100 == null) goto L5;
            r100.back();
        L5:
            int r101 = com.bytedance.ee.bear.middleground.permission.a.f232845a;
            JSONObject r102 = new JSONObject();
            r102.put("click", "back");
            r102.put(PickerReporterConstants.KEY.TARGET, "none");
            com.bytedance.ee.bear.middleground.permission.a.a("ccm_bitable_premium_permission_invite_collaborator_click", r102);
        }

        @Override // tg5.p.a
        public final boolean r0() {
            return this.f233323a.f233318a.r0();
        }

        public c(a r100) {
            this.f233323a = r100;
        }

        @Override // tg5.p.a
        public final void N(boolean r100) {
            this.f233323a.f233318a.N(r100);
        }

        @Override // tg5.p.a
        public final void W(UserInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "userInfo");
            this.f233323a.f233318a.m7(r100);
            if (this.f233323a.f233318a.e().size() != 0) goto L7;
            b r101 = this.f233323a.f233320c;
            if (r101 == null) goto L7;
            r101.back();
        L7:
            int r102 = com.bytedance.ee.bear.middleground.permission.a.f232845a;
            JSONObject r103 = new JSONObject();
            r103.put("click", "remove");
            r103.put(PickerReporterConstants.KEY.TARGET, "none");
            com.bytedance.ee.bear.middleground.permission.a.a("ccm_bitable_premium_permission_invite_collaborator_click", r103);
        }
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new c(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        this.f233319b.F(this.f233318a.e());
        this.f233319b.A8();
        int r100 = com.bytedance.ee.bear.middleground.permission.a.f232845a;
        com.bytedance.ee.bear.middleground.permission.a.a("ccm_bitable_premium_permission_invite_collaborator_view", new JSONObject());
    }

    public a(ug5.a r100, ug5.c r101, b r102, String r103, cj5.c.a r104) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r103, "token");
        super(r100, r101);
        this.f233318a = r100;
        this.f233319b = r101;
        this.f233320c = r102;
        this.f233321d = r103;
        this.f233322e = r104;
    }
}
