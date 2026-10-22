package yh5;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.permsdkimpl.model.CacParamEntity;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements gj5.a {
    public final /* synthetic */ j a;
    public final /* synthetic */ ph5.d b;
    public final /* synthetic */ PermissionRequest c;
    public final /* synthetic */ Ref.ObjectRef<CacParamEntity> d;

    @Override // gj5.a
    public final void a(gj5.c r8) {
        Intrinsics.checkNotNullParameter(r8, "result");
        this.a.getClass();
        tt5.a.h("CacCheckService-PermissionSDK", "asyncExecute " + r8);
        ph5.d r0 = this.b;
        j r1 = this.a;
        PermissionRequest r2 = this.c;
        CacParamEntity r3 = (CacParamEntity) this.d.element;
        r1.getClass();
        if (r8.a == false) goto L5;
        PermissionResponse r4 = r1.d();
        r4.setSecSdkResult(r8.c);
        r4.setOperation(r3.getOperation());
        r4.setCacheReqRequest(r2);
    L6:
        r0.a(r4);
        return;
    L5:
        PermissionResponse r6 = new PermissionResponse(j.c(false, r8.b), false, r1.a);
        r6.setServiceIdentifyKey("CacCheckService");
        r6.setSdkCacheEntity(r3);
        r6.setSecSdkResult(r8.c);
        r6.setCacheReqRequest(r2);
        r6.setOperation(r3.getOperation());
        r4 = r6;
        goto L6
    }

    public k(j r1, i r2, PermissionRequest r3, Ref.ObjectRef r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
