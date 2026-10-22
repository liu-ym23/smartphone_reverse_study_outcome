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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements ph5.d {
    public final /* synthetic */ Ref.ObjectRef<CopyOnWriteArrayList<PermissionResponse>> a;
    public final /* synthetic */ g b;
    public final /* synthetic */ PermissionRequest c;
    public final /* synthetic */ ph5.d d;

    @Override // ph5.d
    public final void a(PermissionResponse r13) {
        Intrinsics.checkNotNullParameter(r13, "permissionResponse");
        ((CopyOnWriteArrayList) this.a.element).add(r13);
        g r14 = this.b;
        PermissionRequest r0 = this.c;
        CopyOnWriteArrayList r1 = (CopyOnWriteArrayList) this.a.element;
        ph5.d r2 = this.d;
        r14.getClass();
        if (r1.size() >= r14.c.size()) goto L5;
        tt5.a.h("PermissionSDKImpl-PermissionSDK", "asyncCheckServiceInner " + r1.size());
        return;
    L5:
        Iterator<c> r15 = r14.c.iterator();
        PermissionResponse r4 = null;
    L6:
        boolean r7 = true;
        if (r15.hasNext() == false) goto L25;
        c r6 = r15.next();
        String r8 = ((ph5.f) r6).getIdentify();
        Iterator r9 = r1.iterator();
    L10:
        if (r9.hasNext() == false) goto L14;
        PermissionResponse r10 = (PermissionResponse) r9.next();
        if (Intrinsics.areEqual(r8, r10.getServiceIdentifyKey()) == false) goto L10;
    L16:
        if ((r6 instanceof j) == false) goto L18;
        r4 = r10;
    L18:
        if (r10 != null) goto L20;
    L22:
        r7 = false;
    L23:
        if (r7 == false) goto L6;
        tt5.a.h("PermissionSDKImpl-PermissionSDK", "asyncCheckServiceInner callback");
        r2.a(r10);
        int r16 = f.a;
        f.a.e(r0, r10);
        return;
    L20:
        if (r10.getAllow() == true) goto L22;
    L14:
        r10 = null;
        goto L16
    L25:
        if (r4 == null) goto L27;
        int r17 = f.a;
        f.a.e(r0, r4);
        r2.a(r4);
        return;
    L27:
        int r3 = f.a;
        PermissionResponse r18 = new PermissionResponse(new DenySource(DenyType.DEFAULT_NONE, UiType.DEFAULT), true, new h());
        f.a.e(r0, r18);
        r2.a(r18);
    }

    public i(Ref.ObjectRef<CopyOnWriteArrayList<PermissionResponse>> r1, g r2, PermissionRequest r3, ph5.d r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
