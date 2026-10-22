package vg5;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.setting.DocumentSettingViewModel;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public class a extends tg5.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dh5.b f554695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DocPermSetInfo f554696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f554697d;

    /* JADX INFO: renamed from: vg5.a$a, reason: collision with other inner class name */
    public static final class C8002a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ax4.e<InviteResult> f554698a;

        public b(ax4.e<InviteResult> r100) {
            this.f554698a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.h("DocInviteMemberManagerModel", "inviteUsers()...succeed");
            ax4.e<InviteResult> r101 = this.f554698a;
            r101.onSuccess((InviteResult) r100);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ax4.e<InviteResult> f554699a;

        public c(ax4.e<InviteResult> r100) {
            this.f554699a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.h("DocInviteMemberManagerModel", "inviteUsers()...error = " + r101.getMessage());
            this.f554699a.onFailed(r101);
        }
    }

    static {
    }

    @Override // tg5.a, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
        Iterator<T> r100 = this.f554695b.getSelected().iterator();
    L4:
        if (r100.hasNext() == false) goto L14;
        UserInfo r101 = (UserInfo) r100.next();
        int r102 = 1;
        if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == true) goto L8;
    L10:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L13;
        r102 = 4;
    L13:
        r101.setPermission(r102);
        goto L4
    L8:
        if (sbb.g.a(this.f554696c.getType()) == false) goto L10;
        r103 = true;
        goto L11
    }

    @Override // tg5.a, com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        super.destroy();
        Disposable r100 = this.f554697d;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L12;
        Disposable r102 = this.f554697d;
        if (r102 == null) goto L13;
        r102.dispose();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r100.isDisposed() == true) goto L7;
        r101 = true;
        goto L7
    }

    public static String p(ArrayList r100) {
        Intrinsics.checkNotNullParameter(r100, "selectedUsers");
        JSONArray r101 = new JSONArray();
        Iterator r102 = r100.iterator();     // Catch: JSONException -> L8
    L5:
        if (r102.hasNext() == false) goto L11;
        UserInfo r103 = (UserInfo) r102.next();     // Catch: JSONException -> L8
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L8
        r104.put("owner_id", r103.getId());     // Catch: JSONException -> L8
        r104.put("owner_type", r103.getOwnerType());     // Catch: JSONException -> L8
        r104.put("permission", r103.getPermission());     // Catch: JSONException -> L8
        r101.put(r104);     // Catch: JSONException -> L8
    L11:
        return r101.toString();
    L8:
        e = move-exception;
        tt5.a.f("DocInviteMemberManagerModel", e, false);
        goto L11
    }

    @Override // tg5.o
    public final void F1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "notificationId");
        tt5.a.h("DocInviteMemberManagerModel", "sendNotifyRequest()...");
        int r101 = li5.c.f509359a;
        Intrinsics.checkNotNullParameter(r100, "notificationId");
        tt5.a.h("DocPermissionManager", "sendNotifyRequest()...");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        tt5.a.h("DocPermissionManager", "notificationId is null or empty");
        return;
    L5:
        NetService r102 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.e r103 = new NetService.f("/space/api/suite/permission.v2/members/notify/");
        HashMap r104 = new HashMap();
        r104.put("notification_id", r100);
        r103.d(r104);
        r103.f216906c = 1;
        r102.Vc(new ax4.f()).a(r103).subscribe(li5.j.f509367a, li5.k.f509368a);
    }

    public final void h(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        String r101 = null;
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.android.sheet_share_url_extra_params_enabled") == false) goto L24;
        String r102 = this.f554696c.f234427a;
        Uri r103 = UriProtector.parse(r102);     // Catch: Exception -> L8
        tt5.a.h("DocInviteMemberManagerModel", "getLinkParamsJson, url: " + du5.b.l(r102));     // Catch: Exception -> L8
    L10:
        if (r103 == null) goto L24;
        Set<String> r104 = UriProtector.getQueryParameterNames(r103);
        if (r104 == null) goto L17;
        Set<String> r105 = r104;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L15:
        if (r107.hasNext() == false) goto L18;
        String r108 = (String) r107.next();
        r106.add(new Pair(r108, UriProtector.getQueryParameter(r103, r108)));
    L18:
        if (r106 == null) goto L24;
        JSONObject r109 = new JSONObject();
        Iterator r110 = r106.iterator();
    L21:
        if (r110.hasNext() == false) goto L23;
        Pair r111 = (Pair) r110.next();
        r109.putOpt((String) r111.first, r111.second);
        goto L21
    L23:
        r101 = r109.toString();
        goto L24
    L17:
        r106 = null;
    L8:
        e = move-exception;
        tt5.a.e("DocInviteMemberManagerModel", "getLinkParamsJson, failed to parse url: " + du5.b.l(r102) + ", ", e, false);
        r103 = null;
    L24:
        if (r101 == null) goto L31;
        ((HashMap) r100).put("link_params", r101);
        return;
    }

    public final boolean o(List<? extends UserInfo> r100) {
        if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
    L29:
        return false;
    L10:
        if (r100.isEmpty() == true) goto L26;
        Iterator<T> r102 = r100.iterator();
    L14:
        if (r102.hasNext() == false) goto L26;
        UserInfo r103 = (UserInfo) r102.next();
        DocUserPermission.a r104 = DocUserPermission.Companion;
        int r105 = r103.getPermission();
        r104.getClass();
        if ((r105 & 4) == 0) goto L18;
        boolean r106 = true;
    L19:
        if (r106 == false) goto L21;
    L23:
        boolean r107 = false;
    L24:
        if (r107 == false) goto L14;
        boolean r108 = true;
    L27:
        if (r108 == false) goto L29;
        return true;
    L21:
        if (DocUserPermission.a.a(r103.getPermission()) == true) goto L23;
        r107 = true;
        goto L24
    L18:
        r106 = false;
    L26:
        r108 = false;
        goto L27
    L5:
        if (sbb.g.a(this.f554696c.getType()) == false) goto L7;
        r101 = true;
        goto L8
    }

    public a(dh5.b r100, DocPermSetInfo r101) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r101, "permSetInfo");
        super(r100);
        this.f554695b = r100;
        this.f554696c = r101;
    }

    @Override // tg5.a, tg5.o
    public final void D1(boolean r100, String r101, EscapeRuleBean r102, d r110) {
        Intrinsics.checkNotNullParameter(r101, "notes");
        Intrinsics.checkNotNullParameter(r102, "escapeRuleBean");
        Intrinsics.checkNotNullParameter(r110, "callback");
        ArrayList<UserInfo> r103 = this.f554695b.getSelected();
        tt5.a.h("DocInviteMemberManagerModel", "inviteUsersByEscape()...size = " + r103.size() + ", notify = " + r100);
        if (hu5.a.d(r103) == false) goto L7;
        tt5.a.k("DocInviteMemberManagerModel", "inviteUsersByEscape()...users is empty");
        r110.onFailed(new Throwable("empty users"));
        return;
    L7:
        if (o(r103) == false) goto L10;
        tt5.a.k("DocInviteMemberManagerModel", "inviteUsersByEscape()...unsupported permission for Miaoda application");
        r110.onFailed(new IllegalArgumentException("unsupported Miaoda application permission"));
        return;
    L10:
        DocPermSetInfo r104 = this.f554696c;
        this.f554697d = oh5.d.a(r104.f234429c, r104.getType(), r102.getEscapeSetting(), "", r102.getPermReqType(), r102.getPermReqParam()).subscribe(new vg5.b(r110), new vg5.c(r110));
    }

    @Override // tg5.o
    public final void c7(boolean r100, boolean r101, String r102, ax4.e<InviteResult> r103) {
        Intrinsics.checkNotNullParameter(r102, "notes");
        Intrinsics.checkNotNullParameter(r103, "callback");
        ArrayList<UserInfo> r104 = this.f554695b.getSelected();
        tt5.a.h("DocInviteMemberManagerModel", "inviteUsers()...size = " + r104.size() + ", notify = " + r100);
        if (hu5.a.d(r104) == false) goto L7;
        tt5.a.k("DocInviteMemberManagerModel", "inviteUser()...users is empty");
        r103.onFailed(new Throwable("empty users"));
        return;
    L7:
        if (o(r104) == false) goto L10;
        tt5.a.k("DocInviteMemberManagerModel", "inviteUsers()...unsupported permission for Miaoda application");
        r103.onFailed(new IllegalArgumentException("unsupported Miaoda application permission"));
        return;
    L10:
        NetService r105 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r106 = new NetService.f("/space/api/suite/permission/members/create/");
        r106.d(k(r104, r100, r101, r102));
        r106.f216906c = 1;
        this.f554697d = r105.Vc(new com.bytedance.ee.bear.middleground.permission.collaborator.invite.h()).a(r106).subscribe(new b(r103), new c(r103));
    }

    public HashMap<String, String> k(ArrayList<UserInfo> r100, boolean r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "selectedUsers");
        Intrinsics.checkNotNullParameter(r103, "notes");
        HashMap<String, String> r104 = new HashMap();
        r104.put("token", this.f554696c.f234429c);
        r104.put("type", String.valueOf(this.f554696c.getType()));
        r104.put("owners", p(r100));
        r104.put("notify_lark_v3", String.valueOf(r101));
        r104.put("lark_im_text", r103);
        if (r102 == false) goto L5;
        String r105 = "1";
    L6:
        r104.put(DocumentSettingViewModel.KEY_ACCESS_PERM_TYPE, r105);
        h(r104);
        return r104;
    L5:
        r105 = "2";
        goto L6
    }
}
