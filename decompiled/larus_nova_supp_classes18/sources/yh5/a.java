package yh5;

import android.app.Application;
import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenySource;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground.permission.permsdkimpl.model.AdminParamEntity;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements c, ph5.f {
    public final b a;

    /* JADX INFO: renamed from: yh5.a$a, reason: collision with other inner class name */
    public static final class C0338a {
    }

    public static final class b implements ph5.e {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // ph5.e
        public final void a(Context r3, PermissionResponse r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "response");
            int r0 = f.a;
            f.a.f(r4);
            this.a.getClass();
            tt5.a.h("AdminCheckService-PermissionSDK", "handleUIAction " + r4.getAllow());
            if (r4.getAllow() == false) goto L5;
            return;
        L5:
            Application r5 = eu5.b.a;
            Toast.showFailureText(r3, 2131887246);
        }
    }

    static {
    }

    @Override // yh5.c
    public final void a(PermissionRequest r2, i r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "callback");
    }

    @Override // ph5.f
    public final String getIdentify() {
        return "AdminCheckService";
    }

    public a() {
        this.a = new b(this);
    }

    @Override // yh5.c
    public final PermissionResponse b(PermissionRequest r7, UserPermissionEntity r8) {
        Intrinsics.checkNotNullParameter(r7, "request");
        tt5.a.h("AdminCheckService-PermissionSDK", "execute");
        HashMap<String, Integer> r0 = qh5.a.a;
        if (qh5.a.a(r7.getSceneKey(), r7.getOperation(), 4) == true) goto L5;
        tt5.a.h("AdminCheckService-PermissionSDK", "paramInit check pass " + r7.getSceneKey());
        AdminParamEntity r1 = new AdminParamEntity(false);
    L20:
        if (r1.getShouldCheck() == false) goto L22;
        tt5.a.h("AdminCheckService-PermissionSDK", "permissionType=" + r1.getPermissionType());
        if (r1.getPermissionType() != 13) goto L26;
        boolean r9 = ((com.bytedance.ee.bear.middleground_permission_export.model.b) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.b.class, null, null, 6)).a(r1.getType().b, r1.getToken());
    L27:
        if (r9 == false) goto L30;
        PermissionResponse r10 = new PermissionResponse(yh5.b.a(), true, this.a);
        r10.setCacheReqRequest(r7);
        return r10;
    L30:
        PermissionResponse r2 = new PermissionResponse(new DenySource(DenyType.ADMIN, UiType.DISABLED), false, this.a);
        r2.setCacheReqRequest(r7);
        return r2;
    L26:
        r9 = true;
        goto L27
    L22:
        return new PermissionResponse(yh5.b.a(), true, this.a);
    L5:
        sbb.e r3 = r7.getBaseEntity().getType();
        if (Intrinsics.areEqual(sbb.e.x, r3) == false) goto L8;
        r3 = sbb.e.l;
    L8:
        sbb.e r4 = sbb.e.e;
        if (r3 != null) goto L12;
        r3 = r4;
    L12:
        String r5 = r7.getBaseEntity().getToken();
        if (r5 != null) goto L16;
        r5 = "";
    L16:
        if (Intrinsics.areEqual("FILE_EXTERNAL_SHARE", r7.getOperation()) == false) goto L18;
        r1 = new AdminParamEntity(r5, r3, 13);
        goto L20
    L18:
        r1 = new AdminParamEntity(false);
        goto L20
    }
}
