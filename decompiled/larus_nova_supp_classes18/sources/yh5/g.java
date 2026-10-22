package yh5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenySource;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements ph5.b {
    public com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.a a;
    public final LinkedList<yh5.c> b;
    public final LinkedList<yh5.c> c;
    public final d d;

    public static final class a {
    }

    public static final class b implements ph5.a {
        public b() {
        }

        @Override // ph5.a
        public final void a(Context r2, ErrorResponse r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "response");
        }
    }

    public static final class c implements ph5.e {
        public c() {
        }

        @Override // ph5.e
        public final void a(Context r2, PermissionResponse r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "response");
        }
    }

    static {
    }

    public g() {
        LinkedList<yh5.c> r0 = new LinkedList();
        this.b = r0;
        LinkedList<yh5.c> r1 = new LinkedList();
        this.c = r1;
        this.d = new d();
        r0.add(new j());
        r0.add(new yh5.a());
        r0.add(new l());
        r1.add(new j());
    }

    @Override // ph5.b
    public final Flowable<String> c(String r4) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        if (this.a != null) goto L5;
        this.a = new com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.a();
    L5:
        int r1 = f.a;
        com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.a r2 = this.a;
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        if (r2 != null) goto L20;
    L15:
        return Flowable.just("");
    L17:
        th = move-exception;
        tt5.a.d("PermSdkUtils", th.getMessage());
        return Flowable.just("");
    L20:
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);     // Catch: Throwable -> L17
        if (r2.b.get() == false) goto L13;
        String r5 = r2.a.get(r4);     // Catch: Throwable -> L17
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        Flowable<String> r6 = Flowable.just(r5);     // Catch: Throwable -> L17
    L14:
        if (r6 == null) goto L15;
        return r6;
    L13:
        r6 = r2.b(r4);     // Catch: Throwable -> L17
        goto L14
    }

    @Override // ph5.b
    public final void a(String r5, String r6) {
        qqb.a.h("invalidateOfflinePerm start " + r6);     // Catch: Throwable -> L22
        if (this.a != null) goto L6;
        this.a = new com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.a();     // Catch: Throwable -> L22
    L6:
        int r0 = f.a;     // Catch: Throwable -> L22
        com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.a r1 = this.a;     // Catch: Throwable -> L22
        boolean r3 = false;
        if (TextUtils.isEmpty(r5) == false) goto L9;
    L16:
        StringBuilder r7 = new StringBuilder("saveOfflinePermission empty ");     // Catch: Throwable -> L22
        if (r5 != null) goto L19;
        r3 = true;
    L19:
        r7.append(r3);     // Catch: Throwable -> L22
        tt5.a.d("PermSdkUtils", r7.toString());     // Catch: Throwable -> L22
    L20:
        qqb.a.a();
        return;
    L9:
        if (TextUtils.isEmpty(r6) == true) goto L16;
        if (r1 == null) goto L20;
        r1.a(r5, r6);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        tt5.a.f("PermSdkUtils", th, false);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        qqb.a.a();
        throw th;
    }

    @Override // ph5.b
    public final PermissionRequest d(BaseEntity r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "entity");
        Intrinsics.checkNotNullParameter("user_perm", "sceneKey");
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.OPT);
        PermissionRequest r0 = new PermissionRequest(r3, r4);
        r0.setSceneKey("user_perm");
        return r0;
    }

    @Override // ph5.b
    public final PermissionResponse f(PermissionRequest r3, UserPermissionEntity r4) {
        Intrinsics.checkNotNullParameter(r3, "request");
        StringBuilder r0 = new StringBuilder("PermissionSDKImpl validate ");
        r0.append(r3.getOperation());
        r0.append(", ");
        sbb.e r1 = r3.getBaseEntity().getType();
        if (r1 == null) goto L5;
        Integer r2 = Integer.valueOf(r1.b);
    L6:
        r0.append(r2);
        qqb.a.h(r0.toString());     // Catch: Throwable -> L10
        PermissionResponse r5 = g(r3, r4);     // Catch: Throwable -> L10
        qqb.a.a();
        return r5;
    L10:
        th = move-exception;
        qqb.a.a();
        throw th;
    L5:
        r2 = null;
        goto L6
    }

    public final PermissionResponse g(PermissionRequest r5, UserPermissionEntity r6) {
        PermissionResponse r0 = null;
        Iterator<yh5.c> r1 = this.b.iterator();     // Catch: Throwable -> L13
    L5:
        if (r1.hasNext() == false) goto L15;
        yh5.c r2 = r1.next();     // Catch: Throwable -> L13
        PermissionResponse r3 = r2.b(r5, r6);     // Catch: Throwable -> L13
        if ((r2 instanceof j) == false) goto L10;
        r0 = r3;
    L10:
        if (r3.getAllow() == true) goto L5;
        int r7 = f.a;     // Catch: Throwable -> L13
        f.a.e(r5, r3);     // Catch: Throwable -> L13
        return r3;
    L15:
        if (r0 == null) goto L18;
        int r8 = f.a;
        f.a.e(r5, r0);
        return r0;
    L18:
        tt5.a.h("PermissionSDKImpl", "return here");
        int r4 = f.a;
        PermissionResponse r9 = new PermissionResponse(new DenySource(DenyType.DEFAULT_NONE, UiType.DEFAULT), true, new c());
        f.a.e(r5, r9);
        return r9;
    L13:
        th = move-exception;
        tt5.a.f("PermissionSDKImpl-PermissionSDK validate exception", th, false);
        goto L15
    }

    @Override // ph5.b
    public final void b(PermissionRequest r4, UserPermissionEntity r5, ph5.d r6) {
        Intrinsics.checkNotNullParameter(r4, "request");
        Intrinsics.checkNotNullParameter(r6, "callback");
        if (this.a != null) goto L5;
        this.a = new com.bytedance.ee.bear.middleground.permission.permsdkimpl.offline.a();
    L5:
        StringBuilder r7 = new StringBuilder("PermissionSDKImpl asyncValidate ");
        r7.append(r4.getOperation());
        r7.append(", ");
        sbb.e r0 = r4.getBaseEntity().getType();
        if (r0 == null) goto L8;
        Integer r1 = Integer.valueOf(r0.b);
    L9:
        r7.append(r1);
        qqb.a.h(r7.toString());     // Catch: Throwable -> L17
        Ref.ObjectRef r8 = new Ref.ObjectRef();     // Catch: Throwable -> L17
        r8.element = new CopyOnWriteArrayList();     // Catch: Throwable -> L17
        Iterator<yh5.c> r2 = this.c.iterator();     // Catch: Throwable -> L17
    L12:
        if (r2.hasNext() == false) goto L15;
        r2.next().a(r4, new i(r8, this, r4, r6));     // Catch: Throwable -> L17
        goto L12
    L15:
        qqb.a.a();
        return;
    L17:
        th = move-exception;
        qqb.a.a();
        throw th;
    L8:
        r1 = null;
        goto L9
    }

    @Override // ph5.b
    public final ErrorResponse e(String r3, Integer r4, String r5, Throwable r6) {
        Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.OPT);
        Intrinsics.checkNotNullParameter(r6, "throwable");
    L10:
        th = move-exception;
        tt5.a.f("PermissionSDKImpl-PermissionSDK handlePermError exception", th, false);
        return new ErrorResponse(false, new b());
    L14:
        qqb.a.h("PermissionSDKImpl handlePermError " + r5 + ", " + r4);     // Catch: Throwable -> L7
        ErrorResponse r7 = this.d.a(r3, r5, r6);     // Catch: Throwable -> L7
        qqb.a.a();     // Catch: Throwable -> L10
        return r7;
    L7:
        th = move-exception;
        qqb.a.a();     // Catch: Throwable -> L10
        throw th;     // Catch: Throwable -> L10
    }
}
