package yh5;

import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenySource;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.DenyType;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UiType;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements ph5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<CopyOnWriteArrayList<PermissionResponse>> f567587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f567588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PermissionRequest f567589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ph5.d f567590d;

    @Override // ph5.d
    public final void a(PermissionResponse r110) {
        Intrinsics.checkNotNullParameter(r110, "permissionResponse");
        this.f567587a.element.add(r110);
        g r111 = this.f567588b;
        PermissionRequest r100 = this.f567589c;
        CopyOnWriteArrayList<PermissionResponse> r101 = this.f567587a.element;
        ph5.d r102 = this.f567590d;
        r111.getClass();
        if (r101.size() >= r111.f567585c.size()) goto L5;
        tt5.a.h("PermissionSDKImpl-PermissionSDK", "asyncCheckServiceInner " + r101.size());
        return;
    L5:
        Iterator<c> r112 = r111.f567585c.iterator();
        PermissionResponse r103 = null;
    L6:
        boolean r104 = true;
        if (r112.hasNext() == false) goto L25;
        c r105 = r112.next();
        String r106 = ((ph5.f) r105).getIdentify();
        Iterator<PermissionResponse> r107 = r101.iterator();
    L10:
        if (r107.hasNext() == false) goto L14;
        PermissionResponse r113 = r107.next();
        if (Intrinsics.areEqual(r106, r113.getServiceIdentifyKey()) == false) goto L10;
    L16:
        if ((r105 instanceof j) == false) goto L18;
        r103 = r113;
    L18:
        if (r113 != null) goto L20;
    L22:
        r104 = false;
    L23:
        if (r104 == false) goto L6;
        tt5.a.h("PermissionSDKImpl-PermissionSDK", "asyncCheckServiceInner callback");
        r102.a(r113);
        int r114 = f.f567580a;
        f.a.e(r100, r113);
        return;
    L20:
        if (r113.getAllow() == true) goto L22;
    L14:
        r113 = null;
        goto L16
    L25:
        if (r103 == null) goto L27;
        int r115 = f.f567580a;
        f.a.e(r100, r103);
        r102.a(r103);
        return;
    L27:
        int r108 = f.f567580a;
        PermissionResponse r116 = new PermissionResponse(new DenySource(DenyType.DEFAULT_NONE, UiType.DEFAULT), true, new h());
        f.a.e(r100, r116);
        r102.a(r116);
    }

    public i(Ref.ObjectRef<CopyOnWriteArrayList<PermissionResponse>> r100, g r101, PermissionRequest r102, ph5.d r103) {
        this.f567587a = r100;
        this.f567588b = r101;
        this.f567589c = r102;
        this.f567590d = r103;
    }
}
