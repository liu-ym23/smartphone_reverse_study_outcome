package xh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground.permission.apply.i1;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements si5.b {
    public static final d a = null;

    public static final class a<T1, T2, R> implements BiFunction {
        public static final a<T1, T2, R> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2, Object r3) {
            ShareFolderUserPermission r4 = (ShareFolderUserPermission) r2;
            IFolderPublicPermission r5 = (IFolderPublicPermission) r3;
            Intrinsics.checkNotNullParameter(r4, "t1");
            Intrinsics.checkNotNullParameter(r5, "t2");
            return new ShareFolderPermission(r4, r5);
        }
    }

    static {
        a = new d();
    }

    public d() {
    }

    @Override // si5.b
    public final Flowable a(String r5) {
        NetService.f r0 = new NetService.f("/space/api/suite/permission/share_space/members/");
        if (r5 != null) goto L5;
        String r1 = "";
    L6:
        r0.b("space_id", r1);
        ((NetService.e) r0).c = 2;
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new si5.c(r5)).a(r0);
    L5:
        r1 = r5;
        goto L6
    }

    @Override // si5.b
    public final Flowable<Result<String>> b(String r3, int r4, String r5) {
        HashMap r6 = new HashMap();
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r6.put(ResourceData.KEY_TOKEN, r3);
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        r6.put("message", r5);
        NetService.f r7 = new NetService.f("/api/explorer/space/apply_permission/");
        ((NetService.e) r7).c = 1;
        r7.d(r6);
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new i1()).a(r7);
    }

    @Override // si5.b
    public final Flowable<ShareFolderUserPermission> c(String r4, FolderVersion r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "folderVersion");
        NetService.f r0 = new NetService.f("/api/suite/permission/share_space/member/perm/");
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.b("space_id", r4);
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new l(r5, r6)).a(r0);
    }

    @Override // si5.b
    public final Flowable<ShareFolderPermission> e(String r3, FolderVersion r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "spaceId");
        Intrinsics.checkNotNullParameter(r4, "folderVersion");
        Flowable<ShareFolderUserPermission> r6 = c(r3, r4, r5);
        NetService.f r7 = new NetService.f("/api/suite/permission/share_space/setting/get/");
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r7.b("space_id", r3);
        return Flowable.zip(r6, ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new i()).a(r7).map(e.a), a.a);
    }

    @Override // si5.b
    public final Flowable<InviteResult> d(ArrayList<UserInfo> r8, boolean r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "selectedUsers");
        Intrinsics.checkNotNullParameter(r10, "notes");
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r12, "spaceId");
        HashMap r1 = new HashMap();
        r1.put(ResourceData.KEY_TOKEN, r11);
        if (r12.length() <= 0) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L8;
        r1.put("space_id", r12);
    L8:
        JSONArray r14 = new JSONArray();
        Iterator<UserInfo> r15 = r8.iterator();     // Catch: JSONException -> L23
    L11:
        if (r15.hasNext() == false) goto L25;
        UserInfo r16 = r15.next();     // Catch: JSONException -> L23
        JSONObject r3 = new JSONObject();     // Catch: JSONException -> L23
        r3.put(ResourceData.KEY_ID, r16.getId());     // Catch: JSONException -> L23
        int r5 = r16.getOwnerType();     // Catch: JSONException -> L23
        if (r5 == 0) goto L20;
        if (r5 == 1) goto L20;
        int r6 = 17;
        if (r5 == 17) goto L21;
        r6 = 18;
        if (r5 == 18) goto L21;
        r6 = 1;
    L21:
        r3.put(ResourceData.KEY_TYPE, r6);     // Catch: JSONException -> L23
        r3.put("perm", r16.getPermission());     // Catch: JSONException -> L23
        r14.put(r3);     // Catch: JSONException -> L23
    L20:
        r6 = 0;
    L25:
        r1.put("owners", r14.toString());
        r1.put("need_notify", "0");
        r1.put("send_lark_im", String.valueOf(r9));
        r1.put("lark_im_text", r10);
        NetService.f r17 = new NetService.f("/api/explorer/space/add/");
        ((NetService.e) r17).c = 1;
        r17.d(r1);
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new com.bytedance.ee.bear.middleground.permission.collaborator.invite.h()).a(r17);
    L23:
        e = move-exception;
        tt5.a.f("FolderPermissionManagerOV", e, false);
        goto L25
    L5:
        r13 = false;
        goto L6
    }
}
