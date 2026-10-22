package wh5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.permission.doc.EditionUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IEditionUserPermission;
import com.bytedance.ee.bear.share.export.OwnerInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.google.gson.Gson;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements FlowableOnSubscribe {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ d c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ FlowableEmitter<IEditionUserPermission> a;

        public a(FlowableEmitter<IEditionUserPermission> r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IEditionUserPermission r3 = (IEditionUserPermission) r2;
            if (this.a.isCancelled() == true) goto L6;
            this.a.onNext(r3);
            return;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ FlowableEmitter<IEditionUserPermission> a;
        public final /* synthetic */ d b;

        public b(FlowableEmitter<IEditionUserPermission> r1, d r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r12) {
            NetService.ServerErrorException r13 = (Throwable) r12;
            if (this.a.isCancelled() == true) goto L16;
            d r0 = this.b;
            Intrinsics.checkNotNull(r13);
            int r1 = d.a;
            r0.getClass();
            if (ax4.d.b(r13, 4) == false) goto L12;
            FlowableEmitter<IEditionUserPermission> r2 = this.a;
            this.b.getClass();
            Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.NetService.ServerErrorException");     // Catch: Exception -> L9
            JSONObject r3 = new JSONObject(r13.getJson());     // Catch: Exception -> L9
            EditionUserPermission r14 = new EditionUserPermission(false, r3.optJSONObject(WikiFolderPushPlugin.DATA).optInt("permission_status_code"), null, (OwnerInfo) new Gson().fromJson(r3.optJSONObject("meta").optString("owner"), OwnerInfo.class), null, 21, null);     // Catch: Exception -> L9
        L11:
            r2.onNext(r14);
            return;
        L9:
            e = move-exception;
            tt5.a.d("DocPermissionFetcher", "parse: " + e);
            r14 = new EditionUserPermission(false, 0, null, null, null, 31, null);
            goto L11
        L12:
            this.a.onError(r13);
            return;
        }
    }

    public g(String r1, int r2, d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void subscribe(FlowableEmitter<IEditionUserPermission> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        int r0 = wh5.b.a;
        String r1 = this.a;
        int r2 = this.b;
        Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_TOKEN);
        JSONObject r3 = new JSONObject();
        r3.put(ResourceData.KEY_TOKEN, r1);
        r3.put(ResourceData.KEY_TYPE, r2);
        ArrayList r4 = CollectionsKt.arrayListOf(new String[]{"operate_entity", "manage_version"});
        JSONArray r6 = new JSONArray();
        Iterator r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        r6.put((String) r7.next());
        goto L4
    L6:
        r3.put("actions", r6);
        NetService.f r8 = new NetService.f("/api/suite/permission/document/actions/state/");
        ((NetService.e) r8).j = r3.toString();
        ((NetService.e) r8).c = 1;
        ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new k()).a(r8).map(c.a).subscribe(new a(r5), new b(r5, this.c));
    }
}
