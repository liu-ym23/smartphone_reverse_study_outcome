package jg5;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.document.setting.DocumentSettingViewModel;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.retention.RetentionSettingVisible;
import com.bytedance.ee.bear.share.export.UserInfo;
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

/* JADX INFO: loaded from: classes18.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<com.bytedance.ee.bear.middleground_permission_export.model.i> f499008b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final jg5.a f499009c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, ArrayList<fj5.b>> f499010d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, rh5.a> f499011e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, com.bytedance.ee.bear.middleground.permission.collaborator.invite.i> f499012f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<String, Boolean> f499013g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, ArrayList<vh5.a>> f499014h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ArrayList<hj5.b> f499015i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public static WeakReference<th5.a> f499016j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public th5.c f499017a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f499018a = null;

        static {
            f499018a = new j();
        }
    }

    static {
        f499008b = new ArrayList();
        f499009c = new jg5.a();
        f499010d = new HashMap();
        f499011e = new HashMap();
        f499012f = new HashMap();
        f499013g = new HashMap();
        f499014h = new HashMap();
        f499015i = new ArrayList();
    }

    public j() {
    }

    public final boolean h(String r100) {
        int r101 = yg5.b.f567499a;
        return !hu5.a.d(yg5.b.a.a(r100, null).getBlockedUsers());
    }

    public final void i(String r100) {
        ArrayList r101 = (ArrayList) ((HashMap) f499014h).get(r100);
        if (hu5.a.d(r101) == false) goto L5;
        return;
    L5:
        Iterator r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((vh5.a) r102.next()).permissionChange();
        goto L7
    }

    public final void j(int r100) {
        Iterator r101 = ((ArrayList) f499008b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.middleground_permission_export.model.i) r101.next()).sB();
        goto L4
    }

    public final void k(int r100) {
        ArrayList<hj5.b> r101 = f499015i;
        if (hu5.a.f(r101) == false) goto L8;
        Iterator<hj5.b> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        r102.next().a(r100);
        goto L6
    L10:
        return;
    }

    public final void m(com.bytedance.ee.bear.middleground_permission_export.model.i r100) {
        List<com.bytedance.ee.bear.middleground_permission_export.model.i> r101 = f499008b;
        if (((ArrayList) r101).contains(r100) == true) goto L6;
        ((ArrayList) r101).add(r100);
        return;
    }

    public final Flowable<DocPermission> a(String r100, int r101) {
        wh5.d r102 = new wh5.d();
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return r102.b(r100, r101);
    }

    public final Flowable<IDocPublicPermission> b(String r100, int r101) {
        wh5.d r102 = new wh5.d();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Intrinsics.checkNotNullParameter(r100, "token");
        return Flowable.create(new wh5.e(r100, r101, r102), BackpressureStrategy.BUFFER);
    }

    public final Flowable<IDocUserPermission> c(String r100, int r101) {
        wh5.d r102 = new wh5.d();
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return r102.c(r100, r101);
    }

    public final Flowable<RetentionSettingVisible> d(int r100, String r101) {
        NetService.d r102 = ((NetService) org.koin.java.a.a(NetService.class)).Vc(new bi5.b());
        NetService.f r103 = new NetService.f("/lark/scs/compliance/entity/ccm/label/setting_visible");
        String r104 = bi5.a.b();
        if (TextUtils.isEmpty(r104) == true) goto L10;
        r103.f216904a = r104;
        r103.f216912i = false;
        r103.b("token", r101);
        if (TextUtils.isEmpty(bi5.a.a(r100)) == true) goto L9;
        r103.b("entityType", bi5.a.a(r100));
        return r102.a(r103);
    L9:
        return Flowable.error(new Throwable("type is illegal!!!"));
    L10:
        return Flowable.error(new Throwable("get retention host failed!!!"));
    }

    public final void n(String r100, com.bytedance.ee.bear.middleground_permission_export.model.g r101) {
        jg5.a r102 = f499009c;
        r102.getClass();
        if (r101 == null) goto L13;
        if (r100 != null) goto L7;
    L10:
        ((ConcurrentHashMap) r102.f498998a).remove(r101);
        return;
    L7:
        if (r100.isEmpty() == true) goto L10;
        ((ConcurrentHashMap) r102.f498998a).put(r101, r100);
        return;
    }

    public final void o(String r100, fj5.b r101) {
        Map<String, ArrayList<fj5.b>> r102 = f499010d;
        ArrayList r103 = (ArrayList) ((HashMap) r102).get(r100);
        if (r103 != null) goto L7;
        ArrayList r104 = new ArrayList();
        r104.add(r101);
        ((HashMap) r102).put(r100, r104);
        return;
    L7:
        if (r103.contains(r101) == true) goto L10;
        r103.add(r101);
        return;
    }

    public final void p(String r100, vh5.a r101) {
        Map<String, ArrayList<vh5.a>> r102 = f499014h;
        ArrayList r103 = (ArrayList) ((HashMap) r102).get(r100);
        if (hu5.a.d(r103) == false) goto L5;
        return;
    L5:
        r103.remove(r101);
        if (hu5.a.d(r103) == false) goto L9;
        ((HashMap) r102).remove(r100);
        return;
    }

    public final void q(String r100, fj5.b r101) {
        Map<String, ArrayList<fj5.b>> r102 = f499010d;
        ArrayList r103 = (ArrayList) ((HashMap) r102).get(r100);
        if (r103 != null) goto L15;
        if (r101 != null) goto L6;
        return;
    L6:
        String r104 = r101.getRetryToken();
        if (TextUtils.isEmpty(r104) == true) goto L17;
        ArrayList r105 = (ArrayList) ((HashMap) r102).get(r104);
        if (r105 != null) goto L11;
        return;
    L11:
        if (r105.size() <= 0) goto L19;
        r105.remove(r101);
        return;
    L19:
        return;
    L17:
        return;
    L15:
        r103.remove(r101);
    }

    public final Flowable<ShareFolderPermission> e(String r100, FolderVersion r101, boolean r102) {
        boolean r103 = r101.isShareFolderV2();
        int r104 = xh5.c.f563877a;
        if (r103 == false) goto L5;
        si5.b r105 = xh5.a.f563873a;
    L7:
        return r105.e(r100, r101, r102);
    L5:
        r105 = xh5.d.f563878a;
        goto L7
    }

    public final Flowable<ShareFolderUserPermission> f(String r100, FolderVersion r101, boolean r102) {
        boolean r103 = r101.isShareFolderV2();
        int r104 = xh5.c.f563877a;
        if (r103 == false) goto L5;
        si5.b r105 = xh5.a.f563873a;
    L7:
        return r105.c(r100, r101, r102);
    L5:
        r105 = xh5.d.f563878a;
        goto L7
    }

    public final void g(com.bytedance.ee.bear.middleground.permission.collaborator.invite.g r110, List<UserInfo> r111, final com.bytedance.ee.bear.middleground_permission_export.model.e r112) {
        int r100 = li5.c.f509359a;
        Intrinsics.checkNotNullParameter(r110, "requestParams");
        Intrinsics.checkNotNullParameter(r111, "users");
        NetService.e r101 = new NetService.f("/space/api/suite/permission/members/create/");
        HashMap r102 = new HashMap();
        String r103 = r110.f233303d;
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.put("token", r103);
        r102.put("type", String.valueOf(r110.getType()));
        int r104 = r110.f233304e;
        JSONArray r105 = new JSONArray();
        Iterator<T> r113 = r111.iterator();     // Catch: JSONException -> L11
    L8:
        if (r113.hasNext() == false) goto L13;
        UserInfo r106 = (UserInfo) r113.next();     // Catch: JSONException -> L11
        JSONObject r107 = new JSONObject();     // Catch: JSONException -> L11
        r107.put("owner_id", r106.getId());     // Catch: JSONException -> L11
        r107.put("owner_type", r106.getOwnerType());     // Catch: JSONException -> L11
        r107.put("permission", r104);     // Catch: JSONException -> L11
        r105.put(r107);     // Catch: JSONException -> L11
    L13:
        r102.put("owners", r105.toString());
        if (r110.f233305f == false) goto L16;
        String r114 = "1";
    L17:
        r102.put("notify_lark", r114);
        r102.put("send_lark_im", "false");
        r102.put("lark_im_text", "");
        r102.put(DocumentSettingViewModel.KEY_ACCESS_PERM_TYPE, String.valueOf(r110.f233300a));
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.android.sheet_share_url_extra_params_enabled") == true) goto L42;
    L40:
        r101.d(r102);
        r101.f216906c = 1;
        ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new com.bytedance.ee.bear.middleground.permission.collaborator.invite.h()).a(r101).subscribe(new f(r112), new g(r112));
        return;
    L42:
        Uri r115 = UriProtector.parse(r110.f233301b);     // Catch: Exception -> L21
        tt5.a.h("DocPermissionManager", "inviteNoPermissionUser, url: " + du5.b.l(r110.f233301b));     // Catch: Exception -> L21
    L23:
        if (r115 == null) goto L37;
        Set<String> r116 = UriProtector.getQueryParameterNames(r115);
        if (r116 == null) goto L30;
        Set<String> r117 = r116;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r117, 10));
        Iterator<T> r118 = r117.iterator();
    L28:
        if (r118.hasNext() == false) goto L31;
        String r109 = (String) r118.next();
        r108.add(new Pair(r109, UriProtector.getQueryParameter(r115, r109)));
    L31:
        if (r108 == null) goto L37;
        JSONObject r119 = new JSONObject();
        Iterator r120 = r108.iterator();
    L34:
        if (r120.hasNext() == false) goto L36;
        Pair r121 = (Pair) r120.next();
        r119.putOpt((String) r121.first, r121.second);
        goto L34
    L36:
        String r122 = r119.toString();
    L38:
        if (r122 == null) goto L40;
        r102.put("link_params", r122);
        goto L40
    L30:
        r108 = null;
    L37:
        r122 = null;
    L21:
        e = move-exception;
        tt5.a.e("DocPermissionManager", "inviteNoPermissionUser, failed to parse url: " + du5.b.l(r110.f233301b) + ", ", e, false);
        r115 = null;
        goto L23
    L16:
        r114 = "0";
    L11:
        e = move-exception;
        tt5.a.f("DocPermissionManager", e, false);
        goto L13
    }

    public final void l(String r100, String r101, int r102) {
        ArrayList r103 = (ArrayList) ((HashMap) f499010d).get(r100);
        if (r103 != null) goto L5;
        return;
    L5:
        Iterator r104 = r103.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((fj5.b) r104.next()).onSecretLevelChange(r101, r102);
        goto L7
    }
}
