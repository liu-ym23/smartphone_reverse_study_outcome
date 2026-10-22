package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel;

import android.content.Context;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.docshost.k;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.AskOwnerHelper;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import rg5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements f.a {
    public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a a;

        public a(com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            AskOwnerHelper.AskOwnerSendResult r5 = (AskOwnerHelper.AskOwnerSendResult) r4;
            int r0 = ui5.a.a;
            com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a r1 = this.a;
            int r2 = com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a.m;
            ((g) r1.getModel()).K7().size();
            Intrinsics.checkNotNull(r5);
            com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a r3 = this.a;
            if (ui5.a.c(r5, r3.a, new com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.b(r3)) == true) goto L6;
            Toast.showSuccessText(this.a.a, 2131888116);
            this.a.b.close();
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a a;

        public b(com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            Throwable r3 = (Throwable) r9;
            tt5.a.d("AskOwnerPresenter", "ask owner error: " + r3.getMessage());
            Locale r2 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c();
            com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a r10 = this.a;
            Context r0 = r10.a;
            String r11 = r10.c;
            Intrinsics.checkNotNull(r2);
            Intrinsics.checkNotNull(r3);
            com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a r1 = this.a;
            String r4 = r1.d;
            int r5 = r1.e;
            String r6 = r1.f;
            ArrayList<UserInfo> r7 = r1.h;
            int r8 = ui5.a.a;
            Intrinsics.checkNotNullParameter(r0, "context");
            Intrinsics.checkNotNullParameter(r11, "ownerName");
            Intrinsics.checkNotNullParameter(r2, "locale");
            Intrinsics.checkNotNullParameter(r3, "throwable");
            Intrinsics.checkNotNullParameter(r7, "selectedUser");
            UserInfo r12 = new UserInfo();
            r12.setName(r11);
            r12.setCnName(r11);
            r12.setEnName(r11);
            ui5.a.d(r0, r12, r2, r3, r4, r5, r6, r7);
        }
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.f.a
    public final void h1() {
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a r2 = this.a;
        if (r2.l == false) goto L5;
        String r0 = "IM_card";
    L6:
        String r4 = r2.f;
        String r5 = r2.d;
        int r6 = r2.e;
        String[] r7 = PermissionAnalytic.a;
        Intrinsics.checkNotNullParameter(r0, "source");
        Intrinsics.checkNotNullParameter("share", "action");
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        boolean r13 = false;
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L9
        r14.put("source", r0);     // Catch: Throwable -> L9
        r14.put("action", "share");     // Catch: Throwable -> L9
        r14.put("module", r4);     // Catch: Throwable -> L9
        r14.put("file_type", sbb.e.c(r6));     // Catch: Throwable -> L9
        r14.put("file_id", du5.b.g(r5));     // Catch: Throwable -> L9
        tt5.a.b("PermissionAnalytic", "reportSendAskOwner()..." + r14);     // Catch: Throwable -> L9
        PermissionAnalytic.b().a("send_ask_owner", r14);     // Catch: Throwable -> L9
    L11:
        String r15 = r2.d;
        int r1 = r2.e;
        String r8 = r2.i;
        boolean r9 = r2.j;
        String r10 = r2.f;
        int r11 = ((f) r2.getView()).q1();
        String r12 = ((f) r2.getView()).getNotes();
        boolean r16 = r2.l;
        ArrayList<UserInfo> r3 = r2.h;
        String r17 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r15, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r8, "subType");
        Intrinsics.checkNotNullParameter(r10, "module");
        Intrinsics.checkNotNullParameter(r12, "notes");
        Intrinsics.checkNotNullParameter(r3, "userInfoList");
        JSONObject r18 = new JSONObject();
        if (r16 == false) goto L15;
    L17:
        String r19 = "none";
    L18:
        if (r16 == false) goto L20;
        String r110 = "";
    L21:
        com.bytedance.ee.bear.middleground.permission.c.a(r18, r15, r1, r19, r8, r10, "", r110, com.bytedance.ee.bear.middleground.permission.c.b, r9);
        if (r11 != 1) goto L24;
    L27:
        String r20 = "read";
    L28:
        r18.put("list_type", r20);
        if (r12.length() != 0) goto L31;
        r13 = true;
    L31:
        r18.put("is_leave_message", true ^ r13);
        if (r16 == false) goto L34;
        String r21 = "im_card";
    L35:
        r18.put("from_scene", r21);
        r18.put("target", "none");
        JSONArray r22 = new JSONArray();
        Iterator<UserInfo> r23 = r3.iterator();
    L37:
        if (r23.hasNext() == false) goto L39;
        UserInfo r24 = r23.next();
        JSONObject r25 = new JSONObject();
        r25.put("collaborate_type", r24.getOwnerType());
        r25.put("object_uid", du5.b.g(r24.getId()));
        r25.put("list_type", com.bytedance.ee.bear.middleground.permission.c.d(r1, r24.getPermission()));
        r22.put(r25);
        goto L37
    L39:
        r18.put("user_list", r22.toString());
        r18.put("click", "send_request");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_ask_owner_click", r18);
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a r26 = this.a;
        Flowable<AskOwnerHelper.AskOwnerSendResult> r27 = ((g) r26.getModel()).U6(((f) this.a.getView()).q1(), ((f) this.a.getView()).getNotes());
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a r28 = this.a;
        r26.k = r27.subscribe(new a(r28), new b(r28));
        return;
    L34:
        r21 = "add_collaborator";
        goto L35
    L24:
        if (r11 != 4) goto L27;
        r20 = "edit";
        goto L28
    L20:
        r110 = com.bytedance.ee.bear.middleground.permission.c.a;
        goto L21
    L15:
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L17;
        r19 = ThumbGlideUrl.SOURCE_VC;
    L9:
        th = move-exception;
        tt5.a.f("PermissionAnalytic", th, false);
        goto L11
    L5:
        r0 = "add_cooperator";
        goto L6
    }

    public c(com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.f.a
    public final void W7(String r4) {
        Intrinsics.checkNotNullParameter(r4, "ownerId");
        ((k) org.koin.java.a.c(k.class, null, null, 6)).e(r4, "");
    }
}
