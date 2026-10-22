package com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink;

import android.content.Context;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends BasePresenter<yg5.a, com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a, com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a.InterfaceC0094a> implements dh5.c {
    public final com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a a;
    public final yg5.a b;
    public final Context c;
    public final b d;
    public final DocPermSetInfo e;
    public final String f;
    public final CompositeDisposable g;

    public static final class a {
    }

    public interface b {
        void Hr();

        void back();

        void finish();
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.c$c, reason: collision with other inner class name */
    public final class C0095c implements com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a.InterfaceC0094a {
        public final /* synthetic */ c a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.c$c$a */
        public static final class a<T> implements Consumer {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            public final void accept(Object r3) {
                SimpleRequestResult r4 = (SimpleRequestResult) r3;
                this.a.a.showLoading(false);
                Context r5 = this.a.c;
                Toast.showSuccessText(r5, r5.getString(2131888126), 0);
                b r6 = this.a.d;
                if (r6 == null) goto L6;
                r6.finish();
                return;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.c$c$b */
        public static final class b<T> implements Consumer {
            public final /* synthetic */ c a;

            public b(c r1) {
                this.a = r1;
            }

            public final void accept(Object r12) {
                NetService.ServerErrorException r13 = (Throwable) r12;
                tt5.a.d("InviteMemberSendLinkPresenter", "onSendLinkClick()...error = " + r13.getMessage());
                boolean r1 = false;
                this.a.a.showLoading(false);
                Context r0 = this.a.c;
                Intrinsics.checkNotNull(r13);
                c r2 = this.a;
                String r3 = r2.e.c;
                String r4 = r2.f;
                ArrayList<UserInfo> r5 = r2.b.getUsers();
                int r6 = ui5.a.a;
                Intrinsics.checkNotNullParameter(r0, "context");
                Intrinsics.checkNotNullParameter(r13, "throwable");
                Intrinsics.checkNotNullParameter(r5, "selectedUser");
                String r7 = "others";
                if ((r13 instanceof NetService.ServerErrorException) == false) goto L58;
                int r8 = yg5.b.a;
                InviteMemberSendLinkData r9 = yg5.b.a.a(r13.getData(), r5);
                List<NotNotifyUserEntity> r10 = r9.getBlockUsers();
                if (r10 != null) goto L7;
            L9:
                boolean r11 = false;
            L11:
                if (r11 == false) goto L13;
                String r14 = xo5.a.c(r0, 2131888071, "name", ui5.a.a(r9.getBlockUsers()));
                Intrinsics.checkNotNull(r14);
                r7 = "block";
            L59:
                Toast.showFailureText(r0, r14);
                PermissionAnalytic.j(r7, r3, r4, "send_link");
                return;
            L13:
                List<NotNotifyUserEntity> r15 = r9.getBlockedUsers();
                if (r15 != null) goto L16;
            L18:
                boolean r16 = false;
            L20:
                if (r16 == false) goto L23;
                r14 = r0.getString(2131888739);
                Intrinsics.checkNotNull(r14);
            L25:
                r7 = "blocked";
                goto L59
            L23:
                if (ax4.d.b(r13, 10022) == false) goto L26;
                r14 = r0.getString(2131888739);
                Intrinsics.checkNotNull(r14);
                goto L25
            L26:
                List<NotNotifyUserEntity> r17 = r9.getPrivacyUsers();
                if (r17 != null) goto L29;
            L31:
                boolean r18 = false;
            L32:
                if (r18 == false) goto L34;
                r14 = xo5.a.c(r0, 2131888127, "userName", ui5.a.a(r9.getPrivacyUsers()));
                Intrinsics.checkNotNull(r14);
                r7 = "privacy_setting";
                goto L59
            L34:
                List<NotNotifyUserEntity> r19 = r9.getLimitUsers();
                if (r19 != null) goto L37;
            L39:
                boolean r110 = false;
            L40:
                if (r110 == false) goto L42;
                HashMap r111 = new HashMap();
                r111.put("name", ui5.a.a(r9.getLimitUsers()));
                r111.put("count", String.valueOf(r9.getSendLinkLimitNum()));
                r14 = xo5.a.d(r0, 2131888073, r111);
                Intrinsics.checkNotNull(r14);
                r7 = "more_then_limited";
                goto L59
            L42:
                List<NotNotifyUserEntity> r112 = r9.getNotNotifyUsers();
                if (r112 != null) goto L45;
            L47:
                boolean r113 = false;
            L48:
                if (r113 == false) goto L50;
                r14 = xo5.a.c(r0, 2131888070, "name", ui5.a.a(r9.getNotNotifyUsers()));
                Intrinsics.checkNotNull(r14);
                r7 = "admin_setting";
                goto L59
            L50:
                List<NotNotifyUserEntity> r114 = r9.getInviteFailedUsers();
                if (r114 != null) goto L53;
            L55:
                if (r1 == false) goto L57;
                r14 = r0.getString(2131888123);
                Intrinsics.checkNotNull(r14);
                goto L59
            L57:
                r14 = r0.getString(2131888117);
                Intrinsics.checkNotNull(r14);
                goto L59
            L53:
                if ((!r114.isEmpty()) != true) goto L55;
                r1 = true;
                goto L55
            L45:
                if ((!r112.isEmpty()) != true) goto L47;
                r113 = true;
                goto L48
            L37:
                if ((!r19.isEmpty()) != true) goto L39;
                r110 = true;
                goto L40
            L29:
                if ((!r17.isEmpty()) != true) goto L31;
                r18 = true;
                goto L32
            L16:
                if ((!r15.isEmpty()) != true) goto L18;
                r16 = true;
                goto L20
            L7:
                if ((!r10.isEmpty()) != true) goto L9;
                r11 = true;
                goto L11
            L58:
                r14 = r0.getString(2131888117);
                Intrinsics.checkNotNull(r14);
                goto L59
            }
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a.InterfaceC0094a
        public final void a0() {
            b r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.Hr();
            return;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a.InterfaceC0094a
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
            com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_send_link_click", r2);
            return;
        L8:
            r5 = "none";
            goto L9
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a.InterfaceC0094a
        public final void q2() {
            this.a.a.showLoading(true);
            c r0 = this.a;
            CompositeDisposable r2 = r0.g;
            Flowable<SimpleRequestResult> r1 = r0.b.P4(r0.a.getNotes());
            c r4 = this.a;
            r2.add(r1.subscribe(new a(r4), new b(r4)));
            c r3 = this.a;
            PermissionAnalytic.p("send_link_no_perm", r3.f, r3.e.getType(), this.a.e.c);
            ArrayList<UserInfo> r5 = this.a.b.getUsers();
            String r6 = this.a.a.getNotes();
            String r7 = com.bytedance.ee.bear.middleground.permission.c.a;
            Intrinsics.checkNotNullParameter(r5, "userInfoList");
            Intrinsics.checkNotNullParameter(r6, "notes");
            JSONObject r8 = new JSONObject();
            String r9 = com.bytedance.ee.bear.middleground.permission.c.f;
            int r10 = com.bytedance.ee.bear.middleground.permission.c.g;
            if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L5;
            String r11 = ThumbGlideUrl.SOURCE_VC;
        L6:
            com.bytedance.ee.bear.middleground.permission.c.a(r8, r9, r10, r11, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
            r8.put("click", "send_link");
            if (r6.length() != 0) goto L9;
            boolean r12 = true;
        L10:
            r8.put("is_add_notes", true ^ r12);
            JSONArray r13 = new JSONArray();
            Iterator<UserInfo> r14 = r5.iterator();
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
            com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_send_link_click", r8);
            return;
        L9:
            r12 = false;
            goto L10
        L5:
            r11 = "none";
            goto L6
        }

        public C0095c(c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.a.InterfaceC0094a
        public final void Y(int r12, UserInfo r13) {
            Intrinsics.checkNotNullParameter(r13, "userInfo");
            this.a.b.V(r13);
            if (this.a.b.getUsers().size() != 0) goto L7;
            b r14 = this.a.d;
            if (r14 == null) goto L7;
            r14.back();
        L7:
            String r15 = com.bytedance.ee.bear.middleground.permission.c.a;
            JSONObject r16 = new JSONObject();
            String r1 = com.bytedance.ee.bear.middleground.permission.c.f;
            int r2 = com.bytedance.ee.bear.middleground.permission.c.g;
            if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L10;
            String r3 = ThumbGlideUrl.SOURCE_VC;
        L11:
            com.bytedance.ee.bear.middleground.permission.c.a(r16, r1, r2, r3, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
            r16.put("click", "delete");
            r16.put("target", "none");
            com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_send_link_click", r16);
            return;
        L10:
            r3 = "none";
            goto L11
        }
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new C0095c(this);
    }

    public final void create() {
        super.create();
        this.b.r5(this);
        this.a.F(this.b.getUsers());
        PermissionAnalytic.p("show_send_link", this.f, this.e.getType(), this.e.c);
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
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_send_link_view", r2);
        return;
    L5:
        r5 = "none";
        goto L6
    }

    public final void destroy() {
        super.destroy();
        this.b.H6(this);
        this.g.clear();
    }

    @Override // dh5.c
    public final void W1(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        if (hu5.a.d(this.b.getUsers()) == false) goto L8;
        b r3 = this.d;
        if (r3 == null) goto L10;
        r3.back();
        return;
    L10:
        return;
    L8:
        this.a.F(this.b.getUsers());
    }

    @Override // dh5.c
    public final void g8(UserInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfo");
        this.a.F(this.b.getUsers());
    }

    public c(d r2, com.bytedance.ee.bear.middleground.permission.collaborator.invite.sendlink.b r3, Context r4, b r5, DocPermSetInfo r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "permSetInfo");
        Intrinsics.checkNotNullParameter(r7, "module");
        super(r3, r2);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = new CompositeDisposable();
    }
}
