package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel;

import android.content.Context;
import com.bytedance.ee.bear.middleground.permission.PermissionAnalytic;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larksuite.framework.mvp.BasePresenter;
import com.larksuite.framework.mvp.IView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import rg5.g;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends BasePresenter<g, f, f.a> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f233256m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f233257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f233258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f233259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f233260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f233261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f233262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f233263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<UserInfo> f233264h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f233265i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f233266j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Disposable f233267k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f233268l;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.panel.a$a, reason: collision with other inner class name */
    public static final class C3337a {
    }

    public interface b {
        void close();
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        if (this.f233263g != 2) goto L5;
        String r100 = "IM_card";
    L6:
        String r101 = this.f233262f;
        String r102 = this.f233260d;
        int r103 = this.f233261e;
        String[] r104 = PermissionAnalytic.f232823a;
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter("share", "action");
        Intrinsics.checkNotNullParameter(r102, "token");
        JSONObject r110 = new JSONObject();     // Catch: Throwable -> L9
        r110.put("source", r100);     // Catch: Throwable -> L9
        r110.put("action", "share");     // Catch: Throwable -> L9
        r110.put(EventConstant.Key.MODULE, r101);     // Catch: Throwable -> L9
        r110.put("file_type", sbb.e.c(r103));     // Catch: Throwable -> L9
        r110.put("file_id", du5.b.g(r102));     // Catch: Throwable -> L9
        tt5.a.b("PermissionAnalytic", "reportShowAskOwner()..." + r110);     // Catch: Throwable -> L9
        PermissionAnalytic.b().a("show_ask_owner", r110);     // Catch: Throwable -> L9
    L11:
        String r111 = this.f233260d;
        int r105 = this.f233261e;
        String r106 = this.f233265i;
        boolean r107 = this.f233266j;
        String r108 = this.f233262f;
        boolean r109 = this.f233268l;
        ArrayList<UserInfo> r112 = this.f233264h;
        String r113 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        Intrinsics.checkNotNullParameter(r111, "token");
        Intrinsics.checkNotNullParameter(r106, "subType");
        Intrinsics.checkNotNullParameter(r108, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r112, "userInfoList");
        JSONObject r114 = new JSONObject();
        if (r109 == false) goto L15;
    L17:
        String r115 = "none";
    L18:
        String r116 = r115;
        if (r109 == false) goto L21;
        String r117 = "";
    L22:
        com.bytedance.ee.bear.middleground.permission.c.a(r114, r111, r105, r116, r106, r108, "", r117, com.bytedance.ee.bear.middleground.permission.c.f233148b, r107);
        if (r109 == false) goto L25;
        String r118 = "im_card";
    L26:
        r114.put("from_scene", r118);
        JSONArray r119 = new JSONArray();
        Iterator<UserInfo> r120 = r112.iterator();
    L28:
        if (r120.hasNext() == false) goto L30;
        UserInfo r121 = r120.next();
        JSONObject r122 = new JSONObject();
        r122.put("collaborate_type", r121.getOwnerType());
        r122.put("object_uid", du5.b.g(r121.getId()));
        r122.put("list_type", com.bytedance.ee.bear.middleground.permission.c.d(r105, r121.getPermission()));
        r119.put(r122);
        goto L28
    L30:
        r114.put("user_list", r119.toString());
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_ask_owner_view", r114);
        return;
    L25:
        r118 = "add_collaborator";
        goto L26
    L21:
        r117 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        goto L22
    L15:
        if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L17;
        r115 = ThumbGlideUrl.SOURCE_VC;
    L9:
        th = move-exception;
        tt5.a.f("PermissionAnalytic", th, false);
        goto L11
    L5:
        r100 = "add_cooperator";
        goto L6
    }

    @Override // com.larksuite.framework.mvp.BasePresenter
    public final IView.IViewDelegate createViewDelegate() {
        return new c(this);
    }

    @Override // com.larksuite.framework.mvp.BasePresenter, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        Disposable r100 = this.f233267k;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == true) goto L12;
        Disposable r102 = this.f233267k;
        if (r102 == null) goto L13;
        r102.dispose();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r100.isDisposed() != true) goto L7;
        r101 = true;
        goto L7
    }

    public a(Context r100, rg5.b r101, d r102, b r103, String r104, String r105, int r106, String r107, int r110, ArrayList r111, String r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r103, "dependency");
        Intrinsics.checkNotNullParameter(r104, "ownerName");
        Intrinsics.checkNotNullParameter(r105, "token");
        Intrinsics.checkNotNullParameter(r107, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r111, "invitedUserList");
        Intrinsics.checkNotNullParameter(r112, "subType");
        super(r101, r102);
        this.f233257a = r100;
        this.f233258b = r103;
        this.f233259c = r104;
        this.f233260d = r105;
        this.f233261e = r106;
        this.f233262f = r107;
        this.f233263g = r110;
        this.f233264h = r111;
        this.f233265i = r112;
        this.f233266j = r113;
        if (r110 != 2) goto L5;
        boolean r108 = true;
    L6:
        this.f233268l = r108;
        return;
    L5:
        r108 = false;
        goto L6
    }
}
