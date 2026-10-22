package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import android.content.Context;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends BasePresenter<com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.a, com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b, com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b f233210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.a f233211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f233212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f233213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f233214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f233215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DocPermSetInfo f233216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final UserInfo f233217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeDisposable f233218i;

    public static final class a {
    }

    public interface b {
        void back();

        void finish();
    }

    public final class c implements com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f233219a;

        public static final class a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f233220a;

            public a(d r100) {
                this.f233220a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                AskOwnerHelper.AskOwnerSendResult r101 = (AskOwnerHelper.AskOwnerSendResult) r100;
                this.f233220a.f233210a.showLoading(false);
                int r102 = ui5.a.f550206a;
                this.f233220a.f233211b.getUsers().size();
                Intrinsics.checkNotNull(r101);
                d r103 = this.f233220a;
                if (ui5.a.c(r101, r103.f233212c, new e(r103)) == true) goto L8;
                Context r104 = this.f233220a.f233212c;
                Toast.showSuccessText(r104, r104.getString(R.string.Doc_Permission_SendApplySuccess), 0);
                b r105 = this.f233220a.f233213d;
                if (r105 == null) goto L9;
                r105.finish();
                return;
            L9:
                return;
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f233221a;

            public b(d r100) {
                this.f233221a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                tt5.a.d("InviteMemberAskOwnerPresenter", "onAskOwnerClick()...error = " + r101.getMessage());
                this.f233221a.f233210a.showLoading(false);
                Locale r102 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
                d r103 = this.f233221a;
                Context r104 = r103.f233212c;
                UserInfo r105 = r103.f233217h;
                Intrinsics.checkNotNull(r102);
                Intrinsics.checkNotNull(r101);
                DocPermSetInfo r106 = this.f233221a.f233216g;
                String r107 = r106.f234429c;
                int r108 = r106.getType();
                d r109 = this.f233221a;
                ui5.a.d(r104, r105, r102, r101, r107, r108, r109.f233214e, r109.f233211b.getUsers());
            }
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b.a
        public final void a0() {
            this.f233219a.f233210a.showLoading(true);
            d r100 = this.f233219a;
            CompositeDisposable r101 = r100.f233218i;
            Flowable<AskOwnerHelper.AskOwnerSendResult> r102 = r100.f233211b.z0(r100.f233210a.getNotes());
            d r103 = this.f233219a;
            r101.add(r102.subscribe(new a(r103), new b(r103)));
            d r104 = this.f233219a;
            PermissionAnalytic.i("send_ask_owner", r104.f233215f, r104.f233214e, r104.f233216g.getType(), this.f233219a.f233216g.f234429c);
            String r105 = this.f233219a.f233210a.getNotes();
            ArrayList<UserInfo> r106 = this.f233219a.f233211b.getUsers();
            String r107 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
            Intrinsics.checkNotNullParameter(r105, "notes");
            Intrinsics.checkNotNullParameter(r106, "userInfoList");
            JSONObject r108 = new JSONObject();
            String r109 = com.bytedance.ee.bear.middleground.permission.c.f233152f;
            int r110 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
            if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L5;
            String r111 = ThumbGlideUrl.SOURCE_VC;
        L6:
            com.bytedance.ee.bear.middleground.permission.c.a(r108, r109, r110, r111, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
            r108.put("click", "send_request");
            if (r105.length() != 0) goto L9;
            boolean r112 = true;
        L10:
            r108.put("is_add_notes", !r112);
            JSONArray r113 = new JSONArray();
            Iterator<UserInfo> r114 = r106.iterator();
        L12:
            if (r114.hasNext() == false) goto L14;
            UserInfo r115 = r114.next();
            JSONObject r116 = new JSONObject();
            r116.put("collaborate_type", r115.getOwnerType());
            r116.put("object_uid", du5.b.g(r115.getId()));
            r116.put("list_type", com.bytedance.ee.bear.middleground.permission.c.d(com.bytedance.ee.bear.middleground.permission.c.f233153g, r115.getPermission()));
            r113.put(r116);
            goto L12
        L14:
            r108.put("user_list", r113.toString());
            r108.put(PickerReporterConstants.KEY.TARGET, "none");
            com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_ask_owner_click", r108);
            return;
        L9:
            r112 = false;
            goto L10
        L5:
            r111 = "none";
            goto L6
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b.a
        public final void onBack() {
            b r100 = this.f233219a.f233213d;
            if (r100 == null) goto L5;
            r100.back();
        L5:
            String r101 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
            JSONObject r102 = new JSONObject();
            String r103 = com.bytedance.ee.bear.middleground.permission.c.f233152f;
            int r104 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
            if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L8;
            String r105 = ThumbGlideUrl.SOURCE_VC;
        L9:
            com.bytedance.ee.bear.middleground.permission.c.a(r102, r103, r104, r105, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
            r102.put("click", "back");
            r102.put(PickerReporterConstants.KEY.TARGET, "none");
            com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_ask_owner_click", r102);
            return;
        L8:
            r105 = "none";
            goto L9
        }

        public c(d r100) {
            this.f233219a = r100;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b.a
        public final void Y(int r100, UserInfo r101) {
            Intrinsics.checkNotNullParameter(r101, "userInfo");
            this.f233219a.f233211b.V(r101);
            if (this.f233219a.f233211b.getUsers().size() != 0) goto L8;
            b r102 = this.f233219a.f233213d;
            if (r102 == null) goto L9;
            r102.back();
            return;
        L9:
            return;
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
        this.f233210a.F(this.f233211b.getUsers());
        PermissionAnalytic.i("show_ask_owner", this.f233215f, this.f233214e, this.f233216g.getType(), this.f233216g.f234429c);
        ArrayList<UserInfo> r100 = this.f233211b.getUsers();
        String r101 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        Intrinsics.checkNotNullParameter(r100, "userInfoList");
        JSONObject r102 = new JSONObject();
        String r103 = com.bytedance.ee.bear.middleground.permission.c.f233152f;
        int r104 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
        if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L5;
        String r105 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r102, r103, r104, r105, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
        JSONArray r106 = new JSONArray();
        Iterator<UserInfo> r107 = r100.iterator();
    L8:
        if (r107.hasNext() == false) goto L10;
        UserInfo r108 = r107.next();
        JSONObject r109 = new JSONObject();
        r109.put("collaborate_type", r108.getOwnerType());
        r109.put("object_uid", du5.b.g(r108.getId()));
        r109.put("list_type", com.bytedance.ee.bear.middleground.permission.c.d(com.bytedance.ee.bear.middleground.permission.c.f233153g, r108.getPermission()));
        r106.put(r109);
        goto L8
    L10:
        r102.put("user_list", r106.toString());
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_ask_owner_view", r102);
        return;
    L5:
        r105 = "none";
        goto L6
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        this.f233218i.clear();
    }

    public d(InviteMemberAskOwnerView r100, com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.c r101, Context r102, b r103, String r104, String r105, DocPermSetInfo r106, UserInfo r107) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r105, "source");
        Intrinsics.checkNotNullParameter(r106, "permSetInfo");
        Intrinsics.checkNotNullParameter(r107, "ownerInfo");
        super(r101, r100);
        this.f233210a = r100;
        this.f233211b = r101;
        this.f233212c = r102;
        this.f233213d = r103;
        this.f233214e = r104;
        this.f233215f = r105;
        this.f233216g = r106;
        this.f233217h = r107;
        this.f233218i = new CompositeDisposable();
    }
}
