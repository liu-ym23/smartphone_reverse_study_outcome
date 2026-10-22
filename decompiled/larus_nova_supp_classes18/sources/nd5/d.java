package nd5;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import li5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements nd5.a {

    public static final class a {
    }

    public static final class b implements nc5.b {
        public final /* synthetic */ Disposable a;

        @Override // nc5.b
        public final void cancel() {
            tt5.a.h("PermissionExecutor", "updatePermission folder cancel");
            Disposable r0 = this.a;
            if (r0 == null) goto L6;
            r0.dispose();
            return;
        }

        public b(Disposable r1) {
            this.a = r1;
        }
    }

    public static final class c implements nc5.b {
        public c() {
        }

        @Override // nc5.b
        public final void cancel() {
            tt5.a.h("PermissionExecutor", "updatePermission doc cancel");
        }
    }

    /* JADX INFO: renamed from: nd5.d$d, reason: collision with other inner class name */
    public static final class C0272d<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.j a;
        public final /* synthetic */ int b;

        public C0272d(com.bytedance.ee.bear.middleground_permission_export.model.j r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            SimpleRequestResult r3 = (SimpleRequestResult) r2;
            tt5.a.h("PermissionExecutor", "updatePermission folder success");
            this.a.c(this.b);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.middleground_permission_export.model.j a;

        public e(com.bytedance.ee.bear.middleground_permission_export.model.j r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.d("PermissionExecutor", "updateLinkShare folder error: " + r4.getMessage());
            this.a.b(r4);
        }
    }

    static {
    }

    public d() {
    }

    @Override // nd5.a
    public final nd5.e a(String r3, int r4, nd5.b r5) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r5, "callback");
        tt5.a.h("PermissionExecutor", "queryPermission, token: " + du5.b.k(r3) + ", type: " + r4);
        if (r4 != 0) goto L5;
        Flowable r6 = xh5.a.a.f(r3).map(i.a);
        Intrinsics.checkNotNull(r6);
    L7:
        return new nd5.e(r6.subscribe(new f(r5), new g(r5)));
    L5:
        r6 = wh5.b.a(r3, r4).map(k.a);
        Intrinsics.checkNotNull(r6);
        goto L7
    }

    @Override // nd5.a
    public final nc5.b b(String r4, int r5, int r6, com.bytedance.ee.bear.middleground_permission_export.model.j r7) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "callback");
        tt5.a.h("PermissionExecutor", "updatePermission, token: " + du5.b.k(r4) + ", type: " + r5 + ", linkShareEntity: " + r6);
        r7.a();
        JSONObject r1 = new JSONObject();
        r1.put(ResourceData.KEY_TOKEN, r4);
        r1.put(ResourceData.KEY_TYPE, Integer.valueOf(r5));
        r1.put("link_share_entity", Integer.valueOf(r6));
        if (r5 != 0) goto L9;
        int r8 = xh5.f.a;
        Flowable<SimpleRequestResult> r9 = xh5.h.a.b(r1);
        if (r9 == null) goto L7;
        Disposable r10 = r9.subscribe(new C0272d(r7, r6), new e(r7));
    L11:
        return new b(r10);
    L7:
        r10 = null;
        goto L11
    L9:
        tt5.a.h("PermissionExecutor", "updatePermission doc");
        int r11 = m.a;
        m.b(r1.toString(), r6, r7);
        return new c();
    }
}
