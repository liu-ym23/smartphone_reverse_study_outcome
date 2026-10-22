package wh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPublicPermission;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermissionV2;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a<T, R> implements Function {
        public static final a<T, R> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object apply(Object r2) {
            DocPublicPermission r3 = (DocPublicPermission) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3;
        }
    }

    /* JADX INFO: renamed from: wh5.b$b, reason: collision with other inner class name */
    public static final class C0324b<T, R> implements Function {
        public static final C0324b<T, R> a = null;

        static {
            a = new C0324b();
        }

        public C0324b() {
        }

        public final Object apply(Object r2) {
            DocUserPermissionV2 r3 = (DocUserPermissionV2) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return r3;
        }
    }

    static {
    }

    public static Flowable a(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new h()).a(new NetService.f(String.format(Locale.US, "/api/suite/permission/public.v4/?token=%s&type=%d", Arrays.copyOf(new Object[]{r4, Integer.valueOf(r5)}, 2)))).map(a.a);
    }

    public static Flowable b(String r44, int r45, String r46, int r47) {
        Intrinsics.checkNotNullParameter(r44, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r46, "parentToken");
        JSONObject r3 = new JSONObject();
        r3.put(ResourceData.KEY_TOKEN, r44);
        r3.put(ResourceData.KEY_TYPE, r45);
        if (r46.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L17;
    L11:
        ArrayList r1 = CollectionsKt.arrayListOf(new String[]{"view", "edit", "comment", "manage_collaborator", "manage_meta", "create_sub_node", "copy", "manage_history_record", "collect", "operate_from_dusbin", "operate_entity", "be_moved", "move_to", "move_from", OperationName.OPERATION_DOWNLOAD, "print", "export", "manage_single_page_collaborator", "manage_single_page_meta", "invite_full_access", "invite_can_edit", "invite_can_view", "invite_single_page_full_access", "invite_single_page_can_edit", "invite_single_page_can_view", "visit_secret_level", "modify_secret_level", "apply_embed", "is_full_access", "is_single_page_full_access", "show_collaborator_info", "modify_secret_level", "view", "preview", "perceive", "apply_embed", "is_full_access", "is_single_page_full_access", "manage_version", "duplicate"});
        r1.add("share_external");
        r1.add("share_partner_tenant");
        JSONArray r2 = new JSONArray();
        Iterator r4 = r1.iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        r2.put((String) r4.next());
        goto L13
    L15:
        r3.put("actions", r2);
        NetService.f r5 = new NetService.f("/api/suite/permission/document/actions/state/");
        ((NetService.e) r5).j = r3.toString();
        ((NetService.e) r5).c = 1;
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new j()).a(r5).map(C0324b.a);
    L17:
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L9
        r6.put("entity_token", r46);     // Catch: Exception -> L9
        r6.put("entity_type", String.valueOf(r47));     // Catch: Exception -> L9
        r6.put("relation_type", 1);     // Catch: Exception -> L9
        r3.put("relation", r6);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        tt5.a.d("DocPermissionExecutor", "requestDocUserPermission : " + e.getMessage());
        goto L11
    L5:
        r0 = false;
        goto L6
    }
}
