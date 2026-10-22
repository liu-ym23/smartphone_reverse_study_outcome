package yh5;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.permsdkimpl.model.CacParamEntity;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements gj5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f567596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ph5.d f567597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PermissionRequest f567598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<CacParamEntity> f567599d;

    @Override // gj5.a
    public final void a(gj5.c r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f567596a.getClass();
        tt5.a.h("CacCheckService-PermissionSDK", "asyncExecute " + r100);
        ph5.d r101 = this.f567597b;
        j r102 = this.f567596a;
        PermissionRequest r103 = this.f567598c;
        CacParamEntity r104 = this.f567599d.element;
        r102.getClass();
        if (r100.f481503a == false) goto L5;
        PermissionResponse r105 = r102.d();
        r105.setSecSdkResult(r100.f481505c);
        r105.setOperation(r104.getOperation());
        r105.setCacheReqRequest(r103);
    L6:
        r101.a(r105);
        return;
    L5:
        PermissionResponse r106 = new PermissionResponse(j.c(false, r100.f481504b), false, r102.f567591a);
        r106.setServiceIdentifyKey("CacCheckService");
        r106.setSdkCacheEntity(r104);
        r106.setSecSdkResult(r100.f481505c);
        r106.setCacheReqRequest(r103);
        r106.setOperation(r104.getOperation());
        r105 = r106;
        goto L6
    }

    public k(j r100, i r101, PermissionRequest r102, Ref.ObjectRef r103) {
        this.f567596a = r100;
        this.f567597b = r101;
        this.f567598c = r102;
        this.f567599d = r103;
    }
}
