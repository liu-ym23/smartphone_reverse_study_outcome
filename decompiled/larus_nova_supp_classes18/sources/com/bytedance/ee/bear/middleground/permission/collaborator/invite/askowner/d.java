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
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends BasePresenter<com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.a, com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b, com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b.a> {
    public final com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b a;
    public final com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.a b;
    public final Context c;
    public final b d;
    public final String e;
    public final String f;
    public final DocPermSetInfo g;
    public final UserInfo h;
    public final CompositeDisposable i;

    public static final class a {
    }

    public interface b {
        void back();

        void finish();
    }

    public final class c implements com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b.a {
        public final /* synthetic */ d a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ d a;

            public a(d r1) {
                this.a = r1;
            }

            public final void accept(Object r5) {
                AskOwnerHelper.AskOwnerSendResult r6 = (AskOwnerHelper.AskOwnerSendResult) r5;
                this.a.a.showLoading(false);
                int r0 = ui5.a.a;
                this.a.b.getUsers().size();
                Intrinsics.checkNotNull(r6);
                d r1 = this.a;
                if (ui5.a.c(r6, r1.c, new e(r1)) == true) goto L8;
                Context r7 = this.a.c;
                Toast.showSuccessText(r7, r7.getString(2131888116), 0);
                b r8 = this.a.d;
                if (r8 == null) goto L9;
                r8.finish();
                return;
            L9:
                return;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ d a;

            public b(d r1) {
                this.a = r1;
            }

            public final void accept(Object r9) {
                Throwable r3 = (Throwable) r9;
                tt5.a.d("InviteMemberAskOwnerPresenter", "onAskOwnerClick()...error = " + r3.getMessage());
                this.a.a.showLoading(false);
                Locale r2 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
                d r10 = this.a;
                Context r0 = r10.c;
                UserInfo r1 = r10.h;
                Intrinsics.checkNotNull(r2);
                Intrinsics.checkNotNull(r3);
                DocPermSetInfo r11 = this.a.g;
                String r4 = r11.c;
                int r5 = r11.getType();
                d r12 = this.a;
                ui5.a.d(r0, r1, r2, r3, r4, r5, r12.e, r12.b.getUsers());
            }
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b.a
        public final void a0() {
            this.a.a.showLoading(true);
            d r0 = this.a;
            CompositeDisposable r2 = r0.i;
            Flowable<AskOwnerHelper.AskOwnerSendResult> r1 = r0.b.z0(r0.a.getNotes());
            d r4 = this.a;
            r2.add(r1.subscribe(new a(r4), new b(r4)));
            d r3 = this.a;
            PermissionAnalytic.i("send_ask_owner", r3.f, r3.e, r3.g.getType(), this.a.g.c);
            String r5 = this.a.a.getNotes();
            ArrayList<UserInfo> r6 = this.a.b.getUsers();
            String r7 = com.bytedance.ee.bear.middleground.permission.c.a;
            Intrinsics.checkNotNullParameter(r5, "notes");
            Intrinsics.checkNotNullParameter(r6, "userInfoList");
            JSONObject r8 = new JSONObject();
            String r9 = com.bytedance.ee.bear.middleground.permission.c.f;
            int r10 = com.bytedance.ee.bear.middleground.permission.c.g;
            if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L5;
            String r11 = ThumbGlideUrl.SOURCE_VC;
        L6:
            com.bytedance.ee.bear.middleground.permission.c.a(r8, r9, r10, r11, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
            r8.put("click", "send_request");
            if (r5.length() != 0) goto L9;
            boolean r12 = true;
        L10:
            r8.put("is_add_notes", !r12);
            JSONArray r13 = new JSONArray();
            Iterator<UserInfo> r14 = r6.iterator();
        L12:
            if (r14.hasNext() == false) goto L14;
            UserInfo r15 = r14.next();
            JSONObject r16 = new JSONObject();
            r16.put("collaborate_type", r15.getOwnerType());
            r16.put("object_uid", du5.b.g(r15.getId()));
            r16.put("list_type", com.bytedance.ee.bear.middleground.permission.c.d(com.bytedance.ee.bear.middleground.permission.c.g, r15.getPermission()));
            r13.put(r16);
            goto L12
        L14:
            r8.put("user_list", r13.toString());
            r8.put("target", "none");
            com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_ask_owner_click", r8);
            return;
        L9:
            r12 = false;
            goto L10
        L5:
            r11 = "none";
            goto L6
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b.a
        public final void onBack() {
            b r0 = this.a.d;
            if (r0 == null) goto L5;
            r0.back();
        L5:
            String r1 = com.bytedance.ee.bear.middleground.permission.c.a;
            JSONObject r2 = new JSONObject();
            String r3 = com.bytedance.ee.bear.middleground.permission.c.f;
            int r4 = com.bytedance.ee.bear.middleground.permission.c.g;
            if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L8;
            String r5 = ThumbGlideUrl.SOURCE_VC;
        L9:
            com.bytedance.ee.bear.middleground.permission.c.a(r2, r3, r4, r5, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
            r2.put("click", "back");
            r2.put("target", "none");
            com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_ask_owner_click", r2);
            return;
        L8:
            r5 = "none";
            goto L9
        }

        public c(d r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.b.a
        public final void Y(int r1, UserInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "userInfo");
            this.a.b.V(r2);
            if (this.a.b.getUsers().size() != 0) goto L8;
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

    public final IView.IViewDelegate createViewDelegate() {
        return new c(this);
    }

    public final void create() {
        super.create();
        this.a.F(this.b.getUsers());
        PermissionAnalytic.i("show_ask_owner", this.f, this.e, this.g.getType(), this.g.c);
        ArrayList<UserInfo> r0 = this.b.getUsers();
        String r1 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r0, "userInfoList");
        JSONObject r2 = new JSONObject();
        String r3 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r4 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L5;
        String r5 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r2, r3, r4, r5, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        JSONArray r6 = new JSONArray();
        Iterator<UserInfo> r7 = r0.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        UserInfo r8 = r7.next();
        JSONObject r9 = new JSONObject();
        r9.put("collaborate_type", r8.getOwnerType());
        r9.put("object_uid", du5.b.g(r8.getId()));
        r9.put("list_type", com.bytedance.ee.bear.middleground.permission.c.d(com.bytedance.ee.bear.middleground.permission.c.g, r8.getPermission()));
        r6.put(r9);
        goto L8
    L10:
        r2.put("user_list", r6.toString());
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_share_ask_owner_view", r2);
        return;
    L5:
        r5 = "none";
        goto L6
    }

    public final void destroy() {
        super.destroy();
        this.i.clear();
    }

    public d(InviteMemberAskOwnerView r2, com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.c r3, Context r4, b r5, String r6, String r7, DocPermSetInfo r8, UserInfo r9) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "module");
        Intrinsics.checkNotNullParameter(r7, "source");
        Intrinsics.checkNotNullParameter(r8, "permSetInfo");
        Intrinsics.checkNotNullParameter(r9, "ownerInfo");
        super(r3, r2);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = new CompositeDisposable();
    }
}
