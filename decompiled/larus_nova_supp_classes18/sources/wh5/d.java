package wh5;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.permission.doc.AuthReason;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocPermissionAction;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermissionV2;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.share.export.OwnerInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static final class b<T1, T2, R> implements BiFunction {
        public static final b<T1, T2, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r2, Object r3) {
            IDocUserPermission r4 = (IDocUserPermission) r2;
            IDocPublicPermission r5 = (IDocPublicPermission) r3;
            Intrinsics.checkNotNullParameter(r4, "userPermission");
            Intrinsics.checkNotNullParameter(r5, "publicPermission");
            return new DocPermission(r4, r5);
        }
    }

    public static final class c<T> implements FlowableOnSubscribe {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ d c;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ FlowableEmitter<IDocUserPermission> a;

            public a(FlowableEmitter<IDocUserPermission> r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                IDocUserPermission r3 = (IDocUserPermission) r2;
                if (this.a.isCancelled() == true) goto L6;
                this.a.onNext(r3);
                return;
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ FlowableEmitter<IDocUserPermission> a;
            public final /* synthetic */ d b;

            public b(FlowableEmitter<IDocUserPermission> r1, d r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r3) {
                Throwable r4 = (Throwable) r3;
                if (this.a.isCancelled() == true) goto L9;
                d r0 = this.b;
                Intrinsics.checkNotNull(r4);
                int r1 = d.a;
                r0.getClass();
                if (ax4.d.b(r4, 4) == false) goto L7;
                this.a.onNext(d.a(this.b, r4));
                return;
            L7:
                this.a.onError(r4);
                return;
            }
        }

        public c(String r1, int r2, d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void subscribe(FlowableEmitter<IDocUserPermission> r5) {
            Intrinsics.checkNotNullParameter(r5, "emitter");
            int r0 = wh5.b.a;
            String r1 = this.a;
            int r2 = this.b;
            Intrinsics.checkNotNullParameter(r1, ResourceData.KEY_TOKEN);
            wh5.b.b(r1, r2, "", -1).subscribe(new a(r5), new b(r5, this.c));
        }
    }

    static {
    }

    public d() {
    }

    public static final DocUserPermissionV2 a(d r49, Throwable r50) {
        r49.getClass();
        Intrinsics.checkNotNull(r50, "null cannot be cast to non-null type com.bytedance.ee.bear.contract.NetService.ServerErrorException");     // Catch: Exception -> L11
        JSONObject r1 = new JSONObject(((NetService.ServerErrorException) r50).getJson());     // Catch: Exception -> L11
        JSONObject r0 = r1.optJSONObject(WikiFolderPushPlugin.DATA);     // Catch: Exception -> L11
        int r5 = r0.optInt("permission_status_code");     // Catch: Exception -> L11
        OwnerInfo r7 = (OwnerInfo) JSON.parseObject(r1.optJSONObject("meta").optString("owner"), OwnerInfo.class);     // Catch: Exception -> L11
        JSONObject r2 = r0.optJSONObject("actions");     // Catch: Exception -> L11
        DocPermissionAction r6 = new DocPermissionAction(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 31, null);     // Catch: Exception -> L11
        if (r2 == null) goto L6;
        int r3 = r2.optInt("view");     // Catch: Exception -> L11
        int r4 = r2.optInt("perceive");     // Catch: Exception -> L11
        r6.setView(r3);     // Catch: Exception -> L11
        r6.setPerceive(r4);     // Catch: Exception -> L11
    L6:
        JSONObject r8 = r0.optJSONObject("auth_reasons");     // Catch: Exception -> L11
        AuthReason r9 = new AuthReason(0, 0, 3, null);     // Catch: Exception -> L11
        if (r8 == null) goto L9;
        r9.setCopy(r8.optInt("copy"));     // Catch: Exception -> L11
    L9:
        return new DocUserPermissionV2(false, r5, r6, r7, r9, null, 4, com.bytedance.ee.bear.middleground.permission.b.l(), 33, null);
    L11:
        e = move-exception;
        tt5.a.d("DocPermissionFetcher", "parse: " + e);
        return new DocUserPermissionV2(false, 0, null, null, null, null, 0, com.bytedance.ee.bear.middleground.permission.b.l(), 127, null);
    }

    public final Flowable<DocPermission> b(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Flowable<IDocUserPermission> r1 = c(r3, r4);
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        return Flowable.zip(r1, Flowable.create(new e(r3, r4, this), BackpressureStrategy.BUFFER), b.a);
    }

    public final Flowable<IDocUserPermission> c(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_TOKEN);
        return Flowable.create(new c(r2, r3, this), BackpressureStrategy.BUFFER);
    }
}
