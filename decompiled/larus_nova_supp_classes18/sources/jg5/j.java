package jg5;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.retention.RetentionSettingVisible;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j {
    public static final List<com.bytedance.ee.bear.middleground_permission_export.model.i> b = null;
    public static final jg5.a c = null;
    public static final Map<String, ArrayList<fj5.b>> d = null;
    public static final Map<String, rh5.a> e = null;
    public static final Map<String, com.bytedance.ee.bear.middleground.permission.collaborator.invite.i> f = null;
    public static final Map<String, Boolean> g = null;
    public static final Map<String, ArrayList<vh5.a>> h = null;
    public static final ArrayList<hj5.b> i = null;

    @Nullable
    public static WeakReference<th5.a> j;

    @Nullable
    public th5.c a;

    public static class a {
        public static final j a = null;

        static {
            a = new j();
        }
    }

    static {
        b = new ArrayList();
        c = new jg5.a();
        d = new HashMap();
        e = new HashMap();
        f = new HashMap();
        g = new HashMap();
        h = new HashMap();
        i = new ArrayList();
    }

    public j() {
    }

    public final boolean h(String r2) {
        int r0 = yg5.b.a;
        return !hu5.a.d(yg5.b.a.a(r2, null).getBlockedUsers());
    }

    public final void i(String r2) {
        ArrayList r3 = (ArrayList) ((HashMap) h).get(r2);
        if (hu5.a.d(r3) == false) goto L5;
        return;
    L5:
        Iterator r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        ((vh5.a) r4.next()).permissionChange();
        goto L7
    }

    public final void j(int r2) {
        Iterator r3 = ((ArrayList) b).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground_permission_export.model.i) r3.next()).sB();
        goto L4
    }

    public final void k(int r3) {
        ArrayList<hj5.b> r0 = i;
        if (hu5.a.f(r0) == false) goto L8;
        Iterator<hj5.b> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        r1.next().a(r3);
        goto L6
    L10:
        return;
    }

    public final void m(com.bytedance.ee.bear.middleground_permission_export.model.i r3) {
        List<com.bytedance.ee.bear.middleground_permission_export.model.i> r0 = b;
        if (((ArrayList) r0).contains(r3) == true) goto L6;
        ((ArrayList) r0).add(r3);
        return;
    }

    public final Flowable<DocPermission> a(String r2, int r3) {
        wh5.d r0 = new wh5.d();
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r0.b(r2, r3);
    }

    public final Flowable<IDocPublicPermission> b(String r3, int r4) {
        wh5.d r0 = new wh5.d();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        return Flowable.create(new wh5.e(r3, r4, r0), BackpressureStrategy.BUFFER);
    }

    public final Flowable<IDocUserPermission> c(String r2, int r3) {
        wh5.d r0 = new wh5.d();
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r0.c(r2, r3);
    }

    public final Flowable<RetentionSettingVisible> d(int r5, String r6) {
        NetService.d r0 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new bi5.b());
        NetService.f r1 = new NetService.f("/lark/scs/compliance/entity/ccm/label/setting_visible");
        String r2 = bi5.a.b();
        if (TextUtils.isEmpty(r2) == true) goto L10;
        ((NetService.e) r1).a = r2;
        ((NetService.e) r1).i = false;
        r1.b(ResourceData.KEY_TOKEN, r6);
        if (TextUtils.isEmpty(bi5.a.a(r5)) == true) goto L9;
        r1.b("entityType", bi5.a.a(r5));
        return r0.a(r1);
    L9:
        return Flowable.error(new Throwable("type is illegal!!!"));
    L10:
        return Flowable.error(new Throwable("get retention host failed!!!"));
    }

    public final void n(String r3, com.bytedance.ee.bear.middleground_permission_export.model.g r4) {
        jg5.a r0 = c;
        r0.getClass();
        if (r4 == null) goto L13;
        if (r3 != null) goto L7;
    L10:
        ((ConcurrentHashMap) r0.a).remove(r4);
        return;
    L7:
        if (r3.isEmpty() == true) goto L10;
        ((ConcurrentHashMap) r0.a).put(r4, r3);
        return;
    }

    public final void o(String r3, fj5.b r4) {
        Map<String, ArrayList<fj5.b>> r0 = d;
        ArrayList r1 = (ArrayList) ((HashMap) r0).get(r3);
        if (r1 != null) goto L7;
        ArrayList r2 = new ArrayList();
        r2.add(r4);
        ((HashMap) r0).put(r3, r2);
        return;
    L7:
        if (r1.contains(r4) == true) goto L10;
        r1.add(r4);
        return;
    }

    public final void p(String r4, vh5.a r5) {
        Map<String, ArrayList<vh5.a>> r0 = h;
        ArrayList r1 = (ArrayList) ((HashMap) r0).get(r4);
        if (hu5.a.d(r1) == false) goto L5;
        return;
    L5:
        r1.remove(r5);
        if (hu5.a.d(r1) == false) goto L9;
        ((HashMap) r0).remove(r4);
        return;
    }

    public final void q(String r3, fj5.b r4) {
        Map<String, ArrayList<fj5.b>> r0 = d;
        ArrayList r5 = (ArrayList) ((HashMap) r0).get(r3);
        if (r5 != null) goto L15;
        if (r4 != null) goto L6;
        return;
    L6:
        String r6 = r4.getRetryToken();
        if (TextUtils.isEmpty(r6) == true) goto L17;
        ArrayList r7 = (ArrayList) ((HashMap) r0).get(r6);
        if (r7 != null) goto L11;
        return;
    L11:
        if (r7.size() <= 0) goto L19;
        r7.remove(r4);
        return;
    L19:
        return;
    L17:
        return;
    L15:
        r5.remove(r4);
    }

    public final Flowable<ShareFolderPermission> e(String r3, FolderVersion r4, boolean r5) {
        boolean r0 = r4.isShareFolderV2();
        int r1 = xh5.c.a;
        if (r0 == false) goto L5;
        si5.b r2 = xh5.a.a;
    L7:
        return r2.e(r3, r4, r5);
    L5:
        r2 = xh5.d.a;
        goto L7
    }

    public final Flowable<ShareFolderUserPermission> f(String r3, FolderVersion r4, boolean r5) {
        boolean r0 = r4.isShareFolderV2();
        int r1 = xh5.c.a;
        if (r0 == false) goto L5;
        si5.b r2 = xh5.a.a;
    L7:
        return r2.c(r3, r4, r5);
    L5:
        r2 = xh5.d.a;
        goto L7
    }

    public final void g(com.bytedance.ee.bear.middleground.permission.collaborator.invite.g r12, List<UserInfo> r13, final com.bytedance.ee.bear.middleground_permission_export.model.e r14) {
        int r0 = li5.c.a;
        Intrinsics.checkNotNullParameter(r12, "requestParams");
        Intrinsics.checkNotNullParameter(r13, "users");
        NetService.f r1 = new NetService.f("/space/api/suite/permission/members/create/");
        HashMap r2 = new HashMap();
        String r3 = r12.d;
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r2.put(ResourceData.KEY_TOKEN, r3);
        r2.put(ResourceData.KEY_TYPE, String.valueOf(r12.getType()));
        int r4 = r12.e;
        JSONArray r5 = new JSONArray();
        Iterator<T> r15 = r13.iterator();     // Catch: JSONException -> L11
    L8:
        if (r15.hasNext() == false) goto L13;
        UserInfo r7 = (UserInfo) r15.next();     // Catch: JSONException -> L11
        JSONObject r8 = new JSONObject();     // Catch: JSONException -> L11
        r8.put("owner_id", r7.getId());     // Catch: JSONException -> L11
        r8.put("owner_type", r7.getOwnerType());     // Catch: JSONException -> L11
        r8.put("permission", r4);     // Catch: JSONException -> L11
        r5.put(r8);     // Catch: JSONException -> L11
    L13:
        r2.put("owners", r5.toString());
        if (r12.f == false) goto L16;
        String r16 = "1";
    L17:
        r2.put("notify_lark", r16);
        r2.put("send_lark_im", "false");
        r2.put("lark_im_text", "");
        r2.put("perm_type", String.valueOf(r12.a));
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.android.sheet_share_url_extra_params_enabled") == true) goto L42;
    L40:
        r1.d(r2);
        ((NetService.e) r1).c = 1;
        ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new com.bytedance.ee.bear.middleground.permission.collaborator.invite.h()).a(r1).subscribe(new f(r14), new g(r14));
        return;
    L42:
        Uri r17 = UriProtector.parse(r12.b);     // Catch: Exception -> L21
        tt5.a.h("DocPermissionManager", "inviteNoPermissionUser, url: " + du5.b.l(r12.b));     // Catch: Exception -> L21
    L23:
        if (r17 == null) goto L37;
        Set r18 = UriProtector.getQueryParameterNames(r17);
        if (r18 == null) goto L30;
        Set r19 = r18;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r110 = r19.iterator();
    L28:
        if (r110.hasNext() == false) goto L31;
        String r9 = (String) r110.next();
        r6.add(new Pair(r9, UriProtector.getQueryParameter(r17, r9)));
    L31:
        if (r6 == null) goto L37;
        JSONObject r111 = new JSONObject();
        Iterator r112 = r6.iterator();
    L34:
        if (r112.hasNext() == false) goto L36;
        Pair r10 = (Pair) r112.next();
        r111.putOpt((String) r10.first, r10.second);
        goto L34
    L36:
        String r113 = r111.toString();
    L38:
        if (r113 == null) goto L40;
        r2.put("link_params", r113);
        goto L40
    L30:
        r6 = null;
    L37:
        r113 = null;
    L21:
        e = move-exception;
        tt5.a.e("DocPermissionManager", "inviteNoPermissionUser, failed to parse url: " + du5.b.l(r12.b) + ", ", e, false);
        r17 = null;
        goto L23
    L16:
        r16 = "0";
    L11:
        e = move-exception;
        tt5.a.f("DocPermissionManager", e, false);
        goto L13
    }

    public final void l(String r2, String r3, int r4) {
        ArrayList r5 = (ArrayList) ((HashMap) d).get(r2);
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L9;
        ((fj5.b) r6.next()).onSecretLevelChange(r3, r4);
        goto L7
    }
}
