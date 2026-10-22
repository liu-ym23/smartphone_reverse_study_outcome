package com.bytedance.ee.bear.bitable.share.invitemember.manager;

import com.bytedance.ee.bear.bitable.share.BitableSharePermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tg5.o;
import tg5.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends BasePresenter<o, p, p.a> {
    public final o a;
    public final p b;
    public final b c;
    public final BitableSharePermSetInfo d;
    public final boolean e;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.share.invitemember.manager.a$a, reason: collision with other inner class name */
    public static final class C0016a {
    }

    public interface b {
        void back();

        void finish();
    }

    public final class c implements p.a {
        public final /* synthetic */ a a;

        public final void D0(String r2) {
            Intrinsics.checkNotNullParameter(r2, "notificationId");
        }

        public final void W2() {
            a r0 = this.a;
            r0.getClass();
            int r1 = com.bytedance.ee.bear.middleground.permission.a.a;
            boolean r2 = r0.b.b8();
            ArrayList r3 = r0.a.e();
            Intrinsics.checkNotNullParameter(r3, "userInfoList");
            JSONObject r4 = new JSONObject();
            r4.put("click", "invite");
            if (r2 == false) goto L5;
            String r5 = "true";
        L6:
            r4.put("is_send_notice", r5);
            JSONArray r6 = new JSONArray();
            Iterator r7 = r3.iterator();
        L8:
            if (r7.hasNext() == false) goto L10;
            UserInfo r8 = (UserInfo) r7.next();
            JSONObject r9 = new JSONObject();
            r9.put("collaborate_type", r8.getOwnerType());
            r9.put("object_uid", du5.b.g(r8.getId()));
            r6.put(r9);
            goto L8
        L10:
            r4.put("user_list", r6.toString());
            r4.put("target", "none");
            com.bytedance.ee.bear.middleground.permission.a.a("ccm_bitable_form_permission_select_contact_click", r4);
            r0.b.showLoading();
            r0.a.c7(r0.b.b8(), r0.b.u6(), r0.b.getNotes(), new ou4.b(r0));
            return;
        L5:
            r5 = "false";
            goto L6
        }

        public final ArrayList<UserInfo> e() {
            return this.a.a.e();
        }

        public final void onBack() {
            b r0 = this.a.c;
            if (r0 == null) goto L5;
            r0.back();
        L5:
            int r1 = com.bytedance.ee.bear.middleground.permission.a.a;
            JSONObject r2 = new JSONObject();
            r2.put("click", "back");
            r2.put("target", "none");
            com.bytedance.ee.bear.middleground.permission.a.a("ccm_bitable_form_permission_select_contact_click", r2);
        }

        public final boolean r0() {
            return this.a.a.r0();
        }

        public c(a r1) {
            this.a = r1;
        }

        public final void N(boolean r2) {
            this.a.a.N(r2);
        }

        public final void W(UserInfo r2) {
            Intrinsics.checkNotNullParameter(r2, "userInfo");
            this.a.a.m7(r2);
            this.a.b.A8();
            if (this.a.a.e().size() != 0) goto L8;
            b r3 = this.a.c;
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
        this.b.F(this.a.e());
        this.b.A8();
        int r0 = com.bytedance.ee.bear.middleground.permission.a.a;
        com.bytedance.ee.bear.middleground.permission.a.a("ccm_bitable_form_permission_select_contact_view", new JSONObject());
    }

    public a(ou4.a r2, ou4.c r3, b r4, BitableSharePermSetInfo r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r5, "permSetInfo");
        super(r2, r3);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
