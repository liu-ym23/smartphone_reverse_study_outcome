package com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro;

import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tg5.o;
import tg5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BasePresenter<o, p, p.a> {
    public final o a;
    public final p b;
    public final b c;
    public final String d;
    public final cj5.c.a e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.a$a, reason: collision with other inner class name */
    public static final class C0091a {
    }

    public interface b {
        void back();

        void finish();
    }

    public final class c implements p.a {
        public final /* synthetic */ a a;

        @Override // tg5.p.a
        public final void D0(String r2) {
            Intrinsics.checkNotNullParameter(r2, "notificationId");
        }

        @Override // tg5.p.a
        public final void W2() {
            a r0 = this.a;
            r0.b.showLoading();
            if (r0.e == null) goto L5;
            r0.a.c7(r0.b.b8(), r0.b.u6(), r0.b.getNotes(), new com.bytedance.ee.bear.middleground.permission.collaborator.invite.newinvite.bitablepro.b(r0));
        L6:
            int r1 = com.bytedance.ee.bear.middleground.permission.a.a;
            ArrayList<UserInfo> r2 = e();
            Intrinsics.checkNotNullParameter(r2, "userInfoList");
            JSONObject r3 = new JSONObject();
            r3.put("click", "invite");
            r3.put("target", "none");
            JSONArray r4 = new JSONArray();
            Iterator<UserInfo> r5 = r2.iterator();
        L8:
            if (r5.hasNext() == false) goto L10;
            UserInfo r6 = r5.next();
            JSONObject r7 = new JSONObject();
            r7.put("collaborate_type", r6.getOwnerType());
            r7.put("object_uid", du5.b.g(r6.getId()));
            r4.put(r7);
            goto L8
        L10:
            r3.put("user_list", r4.toString());
            com.bytedance.ee.bear.middleground.permission.a.a("ccm_bitable_premium_permission_invite_collaborator_click", r3);
            return;
        L5:
            r0.a.c7(r0.b.b8(), r0.b.u6(), r0.b.getNotes(), new ug5.b(r0));
            goto L6
        }

        @Override // tg5.p.a
        public final ArrayList<UserInfo> e() {
            return this.a.a.e();
        }

        @Override // tg5.p.a
        public final void onBack() {
            b r0 = this.a.c;
            if (r0 == null) goto L5;
            r0.back();
        L5:
            int r1 = com.bytedance.ee.bear.middleground.permission.a.a;
            JSONObject r2 = new JSONObject();
            r2.put("click", "back");
            r2.put("target", "none");
            com.bytedance.ee.bear.middleground.permission.a.a("ccm_bitable_premium_permission_invite_collaborator_click", r2);
        }

        @Override // tg5.p.a
        public final boolean r0() {
            return this.a.a.r0();
        }

        public c(a r1) {
            this.a = r1;
        }

        @Override // tg5.p.a
        public final void N(boolean r2) {
            this.a.a.N(r2);
        }

        @Override // tg5.p.a
        public final void W(UserInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "userInfo");
            this.a.a.m7(r3);
            if (this.a.a.e().size() != 0) goto L7;
            b r4 = this.a.c;
            if (r4 == null) goto L7;
            r4.back();
        L7:
            int r5 = com.bytedance.ee.bear.middleground.permission.a.a;
            JSONObject r6 = new JSONObject();
            r6.put("click", "remove");
            r6.put("target", "none");
            com.bytedance.ee.bear.middleground.permission.a.a("ccm_bitable_premium_permission_invite_collaborator_click", r6);
        }
    }

    static {
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new c(this);
    }

    public final void create() {
        super.create();
        this.b.F(this.a.e());
        this.b.A8();
        int r0 = com.bytedance.ee.bear.middleground.permission.a.a;
        com.bytedance.ee.bear.middleground.permission.a.a("ccm_bitable_premium_permission_invite_collaborator_view", new JSONObject());
    }

    public a(ug5.a r2, ug5.c r3, b r4, String r5, cj5.c.a r6) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        super(r2, r3);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
