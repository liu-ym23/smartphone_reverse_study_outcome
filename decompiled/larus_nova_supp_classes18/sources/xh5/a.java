package xh5;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground.permission.apply.i1;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.bytedance.ee.bear.middleground.permission.permission.folder.FolderPublicPermissionV3;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements si5.b {
    public static final a a = null;

    /* JADX INFO: renamed from: xh5.a$a, reason: collision with other inner class name */
    public static final class C0333a<T1, T2, R> implements BiFunction {
        public static final C0333a<T1, T2, R> a = null;

        static {
            a = new C0333a();
        }

        public C0333a() {
        }

        public final Object apply(Object r2, Object r3) {
            ShareFolderUserPermission r4 = (ShareFolderUserPermission) r2;
            IFolderPublicPermission r5 = (IFolderPublicPermission) r3;
            Intrinsics.checkNotNullParameter(r4, "t1");
            Intrinsics.checkNotNullParameter(r5, "t2");
            return new ShareFolderPermission(r4, r5);
        }
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2) {
            FolderPublicPermissionV3 r3 = (FolderPublicPermissionV3) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3;
        }
    }

    static {
        a = new a();
    }

    public a() {
    }

    @Override // si5.b
    public final Flowable a(String r4) {
        tt5.a.h("FolderPermissionManager", "getUserInfoV2()...lastLabel = ");
        NetService.f r0 = new NetService.f("/space/api/suite/permission/space/collaborators/");
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.b(ResourceData.KEY_TOKEN, r4);
        r0.b("last_label", "");
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new si5.a()).a(r0);
    }

    public final Flowable<IFolderPublicPermission> f(String r4) {
        NetService.f r0 = new NetService.f("/space/api/suite/permission/space/setting.v2/");
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.b(ResourceData.KEY_TOKEN, r4);
        r0.b(ResourceData.KEY_TYPE, String.valueOf(sbb.e.f.b));
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new j()).a(r0).map(b.a);
    }

    @Override // si5.b
    public final Flowable<Result<String>> b(String r5, int r6, String r7) {
        NetService.f r0 = new NetService.f("/space/api/suite/permission/space/apply_permission/");
        ((NetService.e) r0).c = 1;
        JSONObject r1 = new JSONObject();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r1.put(ResourceData.KEY_TOKEN, r5);
        r1.put("perm_role", Integer.valueOf(r6));
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r1.put("message", r7);
        ((NetService.e) r0).j = r1.toJSONString();
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new i1()).a(r0);
    }

    @Override // si5.b
    public final Flowable<ShareFolderUserPermission> c(String r4, FolderVersion r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "folderVersion");
        JSONArray r0 = new JSONArray();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        JSONObject r1 = new JSONObject();
        r1.put(ResourceData.KEY_TOKEN, r4);
        r1.put("actions", r0);
        NetService.f r7 = new NetService.f("/space/api/suite/permission/space/collaborator/perm/");
        ((NetService.e) r7).j = r1.toJSONString();
        ((NetService.e) r7).c = 1;
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new l(r5, r6)).a(r7);
    }

    @Override // si5.b
    public final Flowable<ShareFolderPermission> e(String r2, FolderVersion r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r3, "folderVersion");
        return Flowable.zip(c(r2, r3, r4), f(r2), C0333a.a);
    }

    @Override // si5.b
    public final Flowable<InviteResult> d(ArrayList<UserInfo> r6, boolean r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r6, "selectedUsers");
        Intrinsics.checkNotNullParameter(r8, "notes");
        Intrinsics.checkNotNullParameter(r9, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r10, "spaceId");
        NetService.f r11 = new NetService.f("/space/api/suite/permission/space/collaborators/create/");
        JSONObject r1 = new JSONObject();
        r1.put(ResourceData.KEY_TOKEN, r9);
        JSONArray r12 = new JSONArray();
        Iterator<UserInfo> r13 = r6.iterator();     // Catch: JSONException -> L8
    L5:
        if (r13.hasNext() == false) goto L10;
        UserInfo r0 = r13.next();     // Catch: JSONException -> L8
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L8
        r2.put("collaborator_id", r0.getId());     // Catch: JSONException -> L8
        r2.put("collaborator_type", Integer.valueOf(r0.getOwnerType()));     // Catch: JSONException -> L8
        r2.put("perm_role", Integer.valueOf(r0.getPermission()));     // Catch: JSONException -> L8
        r12.add(r2);     // Catch: JSONException -> L8
    L10:
        r1.put("collaborators", r12);
        r1.put("need_notify", Boolean.valueOf(r7));
        r1.put("notify_text", r8);
        ((NetService.e) r11).j = r1.toJSONString();
        ((NetService.e) r11).c = 1;
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new com.bytedance.ee.bear.middleground.permission.collaborator.invite.h()).a(r11);
    L8:
        e = move-exception;
        tt5.a.f("FolderPermissionManager", e, false);
        goto L10
    }
}
