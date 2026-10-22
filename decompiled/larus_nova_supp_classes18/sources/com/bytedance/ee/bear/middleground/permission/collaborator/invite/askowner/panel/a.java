package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel;

import android.content.Context;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import rg5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BasePresenter<g, f, f.a> {
    public static final /* synthetic */ int m = 0;
    public final Context a;
    public final b b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;
    public final int g;
    public final ArrayList<UserInfo> h;
    public final String i;
    public final boolean j;
    public Disposable k;
    public final boolean l;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a$a, reason: collision with other inner class name */
    public static final class C0090a {
    }

    public interface b {
        void close();
    }

    static {
    }

    public final void create() {
        super.create();
        if (this.g != 2) goto L5;
        String r0 = "IM_card";
    L6:
        String r3 = this.f;
        String r4 = this.d;
        int r5 = this.e;
        String[] r6 = PermissionAnalytic.a;
        Intrinsics.checkNotNullParameter(r0, "source");
        Intrinsics.checkNotNullParameter("share", "action");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L9
        r12.put("source", r0);     // Catch: Throwable -> L9
        r12.put("action", "share");     // Catch: Throwable -> L9
        r12.put("module", r3);     // Catch: Throwable -> L9
        r12.put("file_type", sbb.e.c(r5));     // Catch: Throwable -> L9
        r12.put("file_id", du5.b.g(r4));     // Catch: Throwable -> L9
        tt5.a.b("PermissionAnalytic", "reportShowAskOwner()..." + r12);     // Catch: Throwable -> L9
        PermissionAnalytic.b().a("show_ask_owner", r12);     // Catch: Throwable -> L9
    L11:
        String r13 = this.d;
        int r1 = this.e;
        String r7 = this.i;
        boolean r8 = this.j;
        String r9 = this.f;
        boolean r10 = this.l;
        ArrayList<UserInfo> r11 = this.h;
        String r14 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r13, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "subType");
        Intrinsics.checkNotNullParameter(r9, "module");
        Intrinsics.checkNotNullParameter(r11, "userInfoList");
        JSONObject r2 = new JSONObject();
        if (r10 == false) goto L15;
    L17:
        String r15 = "none";
    L18:
        String r16 = r15;
        if (r10 == false) goto L21;
        String r17 = "";
    L22:
        com.bytedance.ee.bear.middleground.permission.c.a(r2, r13, r1, r16, r7, r9, "", r17, com.bytedance.ee.bear.middleground.permission.c.b, r8);
        if (r10 == false) goto L25;
        String r18 = "im_card";
    L26:
        r2.put("from_scene", r18);
        JSONArray r19 = new JSONArray();
        Iterator<UserInfo> r20 = r11.iterator();
    L28:
        if (r20.hasNext() == false) goto L30;
        UserInfo r21 = r20.next();
        JSONObject r22 = new JSONObject();
        r22.put("collaborate_type", r21.getOwnerType());
        r22.put("object_uid", du5.b.g(r21.getId()));
        r22.put("list_type", com.bytedance.ee.bear.middleground.permission.c.d(r1, r21.getPermission()));
        r19.put(r22);
        goto L28
    L30:
        r2.put("user_list", r19.toString());
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_ask_owner_view", r2);
        return;
    L25:
        r18 = "add_collaborator";
        goto L26
    L21:
        r17 = com.bytedance.ee.bear.middleground.permission.c.a;
        goto L22
    L15:
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L17;
        r15 = ThumbGlideUrl.SOURCE_VC;
    L9:
        th = move-exception;
        tt5.a.f("PermissionAnalytic", th, false);
        goto L11
    L5:
        r0 = "add_cooperator";
        goto L6
    }

    public final IView.IViewDelegate createViewDelegate() {
        return new c(this);
    }

    public final void destroy() {
        super.destroy();
        Disposable r0 = this.k;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == true) goto L12;
        Disposable r2 = this.k;
        if (r2 == null) goto L13;
        r2.dispose();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r0.isDisposed() != true) goto L7;
        r1 = true;
        goto L7
    }

    public a(Context r2, rg5.b r3, d r4, b r5, String r6, String r7, int r8, String r9, int r10, ArrayList r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "model");
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "dependency");
        Intrinsics.checkNotNullParameter(r6, "ownerName");
        Intrinsics.checkNotNullParameter(r7, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r9, "module");
        Intrinsics.checkNotNullParameter(r11, "invitedUserList");
        Intrinsics.checkNotNullParameter(r12, "subType");
        super(r3, r4);
        this.a = r2;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        if (r10 != 2) goto L5;
        boolean r14 = true;
    L6:
        this.l = r14;
        return;
    L5:
        r14 = false;
        goto L6
    }
}
