package vg5;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.bytedance.ee.bear.middleground.permission.escape.model.EscapeRuleBean;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.UriProtector;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class a extends tg5.a {
    public final dh5.b b;
    public final DocPermSetInfo c;
    public Disposable d;

    /* JADX INFO: renamed from: vg5.a$a, reason: collision with other inner class name */
    public static final class C0322a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ax4.e<InviteResult> a;

        public b(ax4.e<InviteResult> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.h("DocInviteMemberManagerModel", "inviteUsers()...succeed");
            ax4.e<InviteResult> r0 = this.a;
            r0.onSuccess((InviteResult) r3);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ ax4.e<InviteResult> a;

        public c(ax4.e<InviteResult> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.h("DocInviteMemberManagerModel", "inviteUsers()...error = " + r4.getMessage());
            this.a.onFailed(r4);
        }
    }

    static {
    }

    @Override // tg5.a
    public final void create() {
        super.create();
        Iterator<T> r0 = this.b.getSelected().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        UserInfo r1 = (UserInfo) r0.next();
        int r3 = 1;
        if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == true) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == false) goto L13;
        r3 = 4;
    L13:
        r1.setPermission(r3);
        goto L4
    L8:
        if (sbb.g.a(this.c.getType()) == false) goto L10;
        r2 = true;
        goto L11
    }

    @Override // tg5.a
    public final void destroy() {
        super.destroy();
        Disposable r0 = this.d;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L12;
        Disposable r2 = this.d;
        if (r2 == null) goto L13;
        r2.dispose();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r1 = true;
        goto L7
    }

    public static String p(ArrayList r5) {
        Intrinsics.checkNotNullParameter(r5, "selectedUsers");
        JSONArray r0 = new JSONArray();
        Iterator r6 = r5.iterator();     // Catch: JSONException -> L8
    L5:
        if (r6.hasNext() == false) goto L11;
        UserInfo r1 = (UserInfo) r6.next();     // Catch: JSONException -> L8
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L8
        r2.put("owner_id", r1.getId());     // Catch: JSONException -> L8
        r2.put("owner_type", r1.getOwnerType());     // Catch: JSONException -> L8
        r2.put("permission", r1.getPermission());     // Catch: JSONException -> L8
        r0.put(r2);     // Catch: JSONException -> L8
    L11:
        return r0.toString();
    L8:
        e = move-exception;
        tt5.a.f("DocInviteMemberManagerModel", e, false);
        goto L11
    }

    @Override // tg5.o
    public final void F1(String r5) {
        Intrinsics.checkNotNullParameter(r5, "notificationId");
        tt5.a.h("DocInviteMemberManagerModel", "sendNotifyRequest()...");
        int r1 = li5.c.a;
        Intrinsics.checkNotNullParameter(r5, "notificationId");
        tt5.a.h("DocPermissionManager", "sendNotifyRequest()...");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        tt5.a.h("DocPermissionManager", "notificationId is null or empty");
        return;
    L5:
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r2 = new NetService.f("/space/api/suite/permission.v2/members/notify/");
        HashMap r3 = new HashMap();
        r3.put("notification_id", r5);
        r2.d(r3);
        ((NetService.e) r2).c = 1;
        r0.Vc(new ax4.f()).a(r2).subscribe(li5.j.a, li5.k.a);
    }

    public final void h(Map<String, String> r8) {
        Intrinsics.checkNotNullParameter(r8, "paramsMap");
        String r3 = null;
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.android.sheet_share_url_extra_params_enabled") == false) goto L24;
        String r2 = this.c.a;
        Uri r4 = UriProtector.parse(r2);     // Catch: Exception -> L8
        tt5.a.h("DocInviteMemberManagerModel", "getLinkParamsJson, url: " + du5.b.l(r2));     // Catch: Exception -> L8
    L10:
        if (r4 == null) goto L24;
        Set r0 = UriProtector.getQueryParameterNames(r4);
        if (r0 == null) goto L17;
        Set r1 = r0;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r6 = r1.iterator();
    L15:
        if (r6.hasNext() == false) goto L18;
        String r7 = (String) r6.next();
        r5.add(new Pair(r7, UriProtector.getQueryParameter(r4, r7)));
    L18:
        if (r5 == null) goto L24;
        JSONObject r9 = new JSONObject();
        Iterator r10 = r5.iterator();
    L21:
        if (r10.hasNext() == false) goto L23;
        Pair r11 = (Pair) r10.next();
        r9.putOpt((String) r11.first, r11.second);
        goto L21
    L23:
        r3 = r9.toString();
        goto L24
    L17:
        r5 = null;
    L8:
        e = move-exception;
        tt5.a.e("DocInviteMemberManagerModel", "getLinkParamsJson, failed to parse url: " + du5.b.l(r2) + ", ", e, false);
        r4 = null;
    L24:
        if (r3 == null) goto L31;
        ((HashMap) r8).put("link_params", r3);
        return;
    }

    public final boolean o(List<? extends UserInfo> r6) {
        if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == true) goto L10;
    L29:
        return false;
    L10:
        if (r6.isEmpty() == true) goto L26;
        Iterator<T> r7 = r6.iterator();
    L14:
        if (r7.hasNext() == false) goto L26;
        UserInfo r1 = (UserInfo) r7.next();
        DocUserPermission.a r3 = DocUserPermission.Companion;
        int r4 = r1.getPermission();
        r3.getClass();
        if ((r4 & 4) == 0) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
    L23:
        boolean r2 = false;
    L24:
        if (r2 == false) goto L14;
        boolean r8 = true;
    L27:
        if (r8 == false) goto L29;
        return true;
    L21:
        if (DocUserPermission.a.a(r1.getPermission()) == true) goto L23;
        r2 = true;
        goto L24
    L18:
        r5 = false;
    L26:
        r8 = false;
        goto L27
    L5:
        if (sbb.g.a(this.c.getType()) == false) goto L7;
        r0 = true;
        goto L8
    }

    public a(dh5.b r2, DocPermSetInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, "permSetInfo");
        super(r2);
        this.b = r2;
        this.c = r3;
    }

    @Override // tg5.a, tg5.o
    public final void D1(boolean r7, String r8, EscapeRuleBean r9, d r10) {
        Intrinsics.checkNotNullParameter(r8, "notes");
        Intrinsics.checkNotNullParameter(r9, "escapeRuleBean");
        Intrinsics.checkNotNullParameter(r10, "callback");
        ArrayList<UserInfo> r11 = this.b.getSelected();
        tt5.a.h("DocInviteMemberManagerModel", "inviteUsersByEscape()...size = " + r11.size() + ", notify = " + r7);
        if (hu5.a.d(r11) == false) goto L7;
        tt5.a.k("DocInviteMemberManagerModel", "inviteUsersByEscape()...users is empty");
        r10.onFailed(new Throwable("empty users"));
        return;
    L7:
        if (o(r11) == false) goto L10;
        tt5.a.k("DocInviteMemberManagerModel", "inviteUsersByEscape()...unsupported permission for Miaoda application");
        r10.onFailed(new IllegalArgumentException("unsupported Miaoda application permission"));
        return;
    L10:
        DocPermSetInfo r12 = this.c;
        this.d = oh5.d.a(r12.c, r12.getType(), r9.getEscapeSetting(), "", r9.getPermReqType(), r9.getPermReqParam()).subscribe(new vg5.b(r10), new vg5.c(r10));
    }

    @Override // tg5.o
    public final void c7(boolean r5, boolean r6, String r7, ax4.e<InviteResult> r8) {
        Intrinsics.checkNotNullParameter(r7, "notes");
        Intrinsics.checkNotNullParameter(r8, "callback");
        ArrayList<UserInfo> r0 = this.b.getSelected();
        tt5.a.h("DocInviteMemberManagerModel", "inviteUsers()...size = " + r0.size() + ", notify = " + r5);
        if (hu5.a.d(r0) == false) goto L7;
        tt5.a.k("DocInviteMemberManagerModel", "inviteUser()...users is empty");
        r8.onFailed(new Throwable("empty users"));
        return;
    L7:
        if (o(r0) == false) goto L10;
        tt5.a.k("DocInviteMemberManagerModel", "inviteUsers()...unsupported permission for Miaoda application");
        r8.onFailed(new IllegalArgumentException("unsupported Miaoda application permission"));
        return;
    L10:
        NetService r1 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r2 = new NetService.f("/space/api/suite/permission/members/create/");
        r2.d(k(r0, r5, r6, r7));
        ((NetService.e) r2).c = 1;
        this.d = r1.Vc(new com.bytedance.ee.bear.middleground.permission.collaborator.invite.h()).a(r2).subscribe(new b(r8), new c(r8));
    }

    public HashMap<String, String> k(ArrayList<UserInfo> r4, boolean r5, boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "selectedUsers");
        Intrinsics.checkNotNullParameter(r7, "notes");
        HashMap<String, String> r0 = new HashMap();
        r0.put(ResourceData.KEY_TOKEN, this.c.c);
        r0.put(ResourceData.KEY_TYPE, String.valueOf(this.c.getType()));
        r0.put("owners", p(r4));
        r0.put("notify_lark_v3", String.valueOf(r5));
        r0.put("lark_im_text", r7);
        if (r6 == false) goto L5;
        String r8 = "1";
    L6:
        r0.put("perm_type", r8);
        h(r0);
        return r0;
    L5:
        r8 = "2";
        goto L6
    }
}
